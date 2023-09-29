package com.example.csitmentor;

import android.content.Intent;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.card.MaterialCardView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

import java.util.regex.Pattern;

public class RegistrationActivity extends AppCompatActivity {
    EditText name,email,password;
    Button register,intentLogin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_layout);
        name=findViewById(R.id.fullName);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        register=findViewById(R.id.register);
        intentLogin=findViewById(R.id.intentLogin);
        intentLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(RegistrationActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (valid()){
                    FirebaseAuth auth=FirebaseAuth.getInstance();
                    auth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            UserProfileChangeRequest request=new UserProfileChangeRequest.Builder()
                                    .setDisplayName(name.getText().toString()).build();
                            FirebaseUser user=authResult.getUser();
                            user.updateProfile(request);
                            Toast.makeText(RegistrationActivity.this, "Registration Completed", Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(RegistrationActivity.this,LoginActivity.class);
                            startActivity(i);
                        }

                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(RegistrationActivity.this, "Error on Registration", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
    private boolean valid() {
        boolean validity=true;
        if (!name.getText().toString().contains(" ")){
            name.setError("Full Name Required");
            validity=false;

        }
        if(TextUtils.isEmpty(name.getText().toString())){
            name.setError("You cannot leave name empty..!");
            validity=false;
        }
        if (!email.getText().toString().contains("@")){
            email.setError("no @ in email");
            validity=false;
        }
        if(TextUtils.isEmpty(email.getText().toString())){
            email.setError("You cannot leave email empty..!");
            validity=false;
        }
        if (password.length()<8){
            password.setError("Password must contain 8 character");
            validity=false;
        }
        if (!Pattern.compile("[A-Z]").matcher(password.getText().toString()).find()){
            password.setError("Must contain Uppercase Character");
            validity=false;
        }
        if (!Pattern.compile("[a-z]").matcher(password.getText().toString()).find()){
            password.setError("Must contain Lowercase Character");
            validity=false;
        }
        if (!Pattern.compile("[0-9]").matcher(password.getText().toString()).find()){
            password.setError("Must contain a number");
            validity=false;
        }
        if (TextUtils.isEmpty(password.getText().toString())){
            password.setError("Password cannot be empty");
            validity=false;
        }
        return validity;

    }
}
