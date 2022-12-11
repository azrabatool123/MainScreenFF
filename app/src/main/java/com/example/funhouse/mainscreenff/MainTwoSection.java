package com.example.funhouse.mainscreenff;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.funhouse.mainscreenff.Model.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rengwuxian.materialedittext.MaterialEditText;

public class MainTwoSection extends AppCompatActivity {

    ConstraintLayout rootLayout;


    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;


    public static final String Users = "Users";
    ImageView letsLEarn, letsPlay, feedback, setting;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_two_section);

        letsLEarn = (ImageView) findViewById(R.id.letslearn);
        letsPlay = (ImageView) findViewById(R.id.letsplay);
        feedback = (ImageView) findViewById(R.id.feedback);
        setting = (ImageView) findViewById(R.id.iv_setting);


        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        users = db.getReference(Users);

        rootLayout = (ConstraintLayout) findViewById(R.id.rootLayout);

        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showButtonDialog();
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainTwoSection.this, "In Progress", Toast.LENGTH_SHORT).show();
            }
        });
        letsLEarn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainTwoSection.this, LetsLearn.class);
                startActivity(intent);
                cleanup();
                mp = MediaPlayer.create(MainTwoSection.this, R.raw.buttonclicksound);
                mp.start();
            }
        });
        letsPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainTwoSection.this, MainActivity.class);
                startActivity(intent);
                cleanup();
                mp = MediaPlayer.create(MainTwoSection.this, R.raw.buttonclicksound);
                mp.start();
            }
        });
    }

    //    @Override
//    protected void onStop() {
//        super.onStop();
//
//        if (mp != null) {
//            mp.stop();
//        }
//    }
    public void cleanup() {
        if (mp != null && mp.isPlaying()) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }


    private void showButtonDialog() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = LayoutInflater.from(this);
        View layout_buttons = inflater.inflate(R.layout.layout_buttons, null);
        dialog.setView(layout_buttons);


        final MaterialEditText editEmail = layout_buttons.findViewById(R.id.editEmail);
        final MaterialEditText editPassword = layout_buttons.findViewById(R.id.editPassword);
        final MaterialEditText editName = layout_buttons.findViewById(R.id.editName);
        final MaterialEditText editMessage = layout_buttons.findViewById(R.id.editMessage);

        dialog.setPositiveButton("SEND", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();

                if (TextUtils.isEmpty(editEmail.getText().toString())) {
                    Snackbar.make(rootLayout, "please enter Email", Snackbar.LENGTH_SHORT)
                            .show();
                    return;
                }

                if (TextUtils.isEmpty(editMessage.getText().toString())) {
                    Snackbar.make(rootLayout, "please enter Phone Number", Snackbar.LENGTH_SHORT)
                            .show();
                    return;
                }

                if (TextUtils.isEmpty(editName.getText().toString())) {
                    Snackbar.make(rootLayout, "please enter Name", Snackbar.LENGTH_SHORT)
                            .show();
                    return;
                }

                if (TextUtils.isEmpty(editPassword.getText().toString())) {
                    Snackbar.make(rootLayout, "please enter Password", Snackbar.LENGTH_SHORT)
                            .show();
                    return;
                }

                if (editPassword.getText().toString().length() < 6) {
                    Snackbar.make(rootLayout, "Password to Short...!!!", Snackbar.LENGTH_SHORT)
                            .show();
                    return;
                }


                auth.createUserWithEmailAndPassword(editEmail.getText().toString(), editPassword.getText().toString())
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {

                                //Save to firebase database
                                User user = new User();
                                user.setEmail(editEmail.getText().toString());
                                user.setName(editName.getText().toString());
                                user.setPassword(editPassword.getText().toString());
                                user.setMessgae(editMessage.getText().toString());

                                //Update Info

                                users.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(user)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                Snackbar.make(rootLayout, "Thanks for Providing Feedback!!!", Snackbar.LENGTH_SHORT)
                                                        .show();

                                            }
                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Snackbar.make(rootLayout, "failed...!!!" + e.getMessage(), Snackbar.LENGTH_SHORT)
                                                        .show();
                                            }
                                        });

                            }
                        })

                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Snackbar.make(rootLayout, "failed...!!!" + e.getMessage(), Snackbar.LENGTH_SHORT)
                                        .show();
                            }
                        });

            }
        });


        dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });


        dialog.show();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainTwoSection.this);
        builder.setTitle(R.string.app_name);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("Do you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();


    }

    public void ExitCode(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainTwoSection.this);
        builder.setTitle(R.string.app_name);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("Do you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }
}
