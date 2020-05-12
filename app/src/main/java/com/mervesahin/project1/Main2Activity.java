package com.mervesahin.project1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Main2Activity extends AppCompatActivity {
    Bitmap selectedImage;
    ImageView imageView;
    private FirebaseAuth firebaseAuth;
    EditText commentText, commentText2;

    /*public Uri imageData;
    private FirebaseStorage firebaseStorage;
    private StorageReference storageReference;
    private FirebaseFirestore firebaseFirestore;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        firebaseAuth=FirebaseAuth.getInstance();
        imageView=findViewById(R.id.imageView);
        commentText=findViewById(R.id.emailText);
        commentText2=findViewById(R.id.passwordText);

       /* firebaseStorage=FirebaseStorage.getInstance();
        storageReference=firebaseStorage.getReference();
        firebaseFirestore=FirebaseFirestore.getInstance();*/

        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        if(firebaseUser!=null){
            Intent intent=new Intent(Main2Activity.this,Main3Activity.class);
            startActivity(intent);
            finish();
        }

    }

    public void resimSec(View view){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);
        }else{
            Intent intentToGallery=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intentToGallery,2);

        }


    }

    //galeriye erişim izni verilirse ne olacak

    public void onRequestPermissionResult(int requestCode,String[]permission, int[]grantResults){
        if(requestCode==1){
            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Intent intentToGallery = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intentToGallery,2);

            }
        }
        super.onRequestPermissionsResult(requestCode,permission,grantResults);
    }
    //galeriden görsel seçtiktan sonra ne olacak
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 2 && resultCode == RESULT_OK && data != null) {
            Uri imageData = data.getData();
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    ImageDecoder.Source source= ImageDecoder.createSource(this.getContentResolver(), imageData);
                    selectedImage = ImageDecoder.decodeBitmap(source);
                    imageView.setImageBitmap(selectedImage);
                } else {
                    selectedImage = MediaStore.Images.Media.getBitmap(this. getContentResolver(), imageData);
                    imageView.setImageBitmap(selectedImage);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }super.onActivityResult(requestCode, resultCode, data);
    }

    public void KayıtOl(View view) {
        String email = commentText.getText().toString();
        String password = commentText2.getText().toString();

        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener(
                new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(Main2Activity.this, "kullanıcı olusturuldu", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                        startActivity(intent);

                    }
                }
        ).addOnFailureListener(new OnFailureListener() {
                                   @Override
                                   public void onFailure(@NonNull Exception e) {
                                       Toast.makeText(Main2Activity.this, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();

                                   }
                               }
        );
    }

    public void GirisYap(View view){
        String email=commentText.getText().toString();
        String password=commentText2.getText().toString();

        firebaseAuth.signInWithEmailAndPassword(email,password).addOnSuccessListener(
                new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Intent intent=new Intent(Main2Activity.this,Main3Activity.class);
                        startActivity(intent);

                    }
                }
        ).addOnFailureListener(new OnFailureListener() {
                                   @Override
                                   public void onFailure(@NonNull Exception e) {
                                       Toast.makeText(Main2Activity.this,e.getLocalizedMessage(),Toast.LENGTH_LONG).show();

                                   }
                               }
        );

    }
}

