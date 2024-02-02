package com.example.myogs;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;


public class Profile_Page_Activity extends AppCompatActivity {

    TextView pFullName, pEmail, pPhone;
    FirebaseAuth pAuth;
    FirebaseFirestore pStore;
    String puserID;
    ImageView pImageprofile;
    Button pbtnChangeProfile, pbtnResetPassword, pbtnLogout;
    StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        getSupportActionBar().setTitle("Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        pFullName = findViewById(R.id.tv_fullNameProfile);
        pEmail = findViewById(R.id.tv_emailProfile);
        pPhone = findViewById(R.id.tv_phoneNumProfile);
        pImageprofile = findViewById(R.id.pic_profile);

        pbtnChangeProfile = findViewById(R.id.btn_Changeprofile);

        pAuth = FirebaseAuth.getInstance();
        pStore = FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();


        // no need to upload image everytime logout.
        StorageReference profileRef = storageReference.child("users/" + pAuth.getCurrentUser().getUid() + "profile.jpg");
        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {

                Picasso.get().load(uri).into(pImageprofile);

            }
        });

        puserID = pAuth.getCurrentUser().getUid();

        DocumentReference pdocumentReference = pStore.collection("Users").document(puserID);

        pdocumentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {

                pFullName.setText(value.getString("Full Name"));
                //phone_name = value.getString("Full Name");

                pEmail.setText(value.getString("Email"));
                pPhone.setText(value.getString("Phone Number"));

            }
        });

        //   if user press change profile button
        pbtnChangeProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Profile_Page_Activity.this, EditProfile_Activity.class));
            }
        });
        pImageprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  let user go to gallery
                Intent openGalleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(openGalleryIntent, 1000);
            }
        });
    }   // onCreate
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000){
            if (resultCode == Activity.RESULT_OK){
                Uri imageUri = data.getData();
                uploadImageToFirebase(imageUri);
            }
        }
    }
    public  void uploadImageToFirebase(Uri imageUri) {
        //  upload image to firebase storage.
        StorageReference fileRef = storageReference.child("users/" + pAuth.getCurrentUser().getUid() + "profile.jpg");
        fileRef.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {

                        Picasso.get().load(uri).into(pImageprofile);

                    }
                });

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Profile_Page_Activity.this, "Failed to upload image.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}   //  class
