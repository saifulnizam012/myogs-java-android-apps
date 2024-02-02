package com.example.myogs;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

public class EditProfile_Activity extends AppCompatActivity {

    TextView tvEmailEdit;
    EditText etNameEdit, etPhoneEdit, etPasswordEdit;
    Button btnUpdateProfile;
    ImageView ImgProfile;

    String euserID;
    StorageReference sR;
    FirebaseFirestore eStore;
    FirebaseAuth eAuth;
    FirebaseUser euser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        getSupportActionBar().setTitle("Edit Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvEmailEdit = findViewById(R.id.tv_emailEdit);

        etNameEdit = findViewById(R.id.et_nameEdit);
        etPhoneEdit = findViewById(R.id.et_phoneEdit);
        //etPasswordEdit = findViewById(R.id.et_PasswordEdit);

        btnUpdateProfile = findViewById(R.id.btn_updateProfileEdit);

        ImgProfile = findViewById(R.id.pic_profileEdit);

        eAuth = FirebaseAuth.getInstance();
        eStore = FirebaseFirestore.getInstance();
        sR = FirebaseStorage.getInstance().getReference();
        euser = eAuth.getCurrentUser();

        // no need to upload image everytime logout.
        StorageReference profileRef = sR.child("users/" + eAuth.getCurrentUser().getUid() + "profile.jpg");
        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {

                Picasso.get().load(uri).into(ImgProfile);

            }
        });

        euserID = eAuth.getCurrentUser().getUid();

        DocumentReference dR = eStore.collection("Users").document(euserID);

        //  get name from firebase
        dR.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {

                tvEmailEdit.setText(value.getString("Email"));
                etNameEdit.setText(value.getString("Full Name"));
                etPhoneEdit.setText(value.getString("Phone Number"));
                //etPasswordEdit.setText(value.getString("Password"));
                //etConfirmPasswordEdit.setText(value.getString("Password"));

            }
        });


        ImgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent openGalleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(openGalleryIntent, 1000);

            }
        });


        //  edit profile

        btnUpdateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (etNameEdit.getText().toString().isEmpty() || etPhoneEdit.getText().toString().isEmpty()){

                    etNameEdit.setError("Name are compulsory.");
                    etPhoneEdit.setError("Phone Number are compulsory.");
                    //etPasswordEdit.setError("Password are compulsory.");
                    return;
                }

                String email = tvEmailEdit.getText().toString();
                euser.updateEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                        DocumentReference documentReference = eStore.collection("Users").document(euser.getUid());
                        Map<String,Object> edited = new HashMap<>();

                        edited.put("Full Name", etNameEdit.getText().toString());
                        edited.put("Phone Number", etPhoneEdit.getText().toString());
                        //edited.put("Password", etPasswordEdit.getText().toString());

                        documentReference.update(edited).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {

                                Toast.makeText(EditProfile_Activity.this, "Profile Updated.", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(EditProfile_Activity.this, Profile_Page_Activity.class));

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                                Toast.makeText(EditProfile_Activity.this, "There is an error while updating the profile.", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                });


            }
        });


    }   // onCreate

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1000) {

            if (resultCode == Activity.RESULT_OK) {

                Uri imageUri = data.getData();
                uploadImageToFirebase(imageUri);


            }

        }

    }

    public  void uploadImageToFirebase(Uri imageUri) {

        //  upload image to firebase storage.
        StorageReference fileRef = sR.child("users/" + eAuth.getCurrentUser().getUid() + "profile.jpg");
        fileRef.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {

                        Picasso.get().load(uri).into(ImgProfile);

                    }
                });

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(EditProfile_Activity.this, "Failed to upload image.", Toast.LENGTH_SHORT).show();

            }
        });


    }


}
