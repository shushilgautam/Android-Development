package com.example.cloudoperations;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {
    Button loginPage,signup;
    TextView email,password;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        loginPage=findViewById(R.id.LoginPage);
        email=findViewById(R.id.reg_email);
        password=findViewById(R.id.reg_password);
        signup=findViewById(R.id.register);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(valid()){
                    FirebaseAuth auth=FirebaseAuth.getInstance();
                    auth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            Toast.makeText(SignupActivity.this,"Congratulation",Toast.LENGTH_LONG).show();
                            Intent i=new Intent(SignupActivity.this,FirstActivity.class);
                            startActivity(i);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(SignupActivity.this,"Unsuccessful people ",Toast.LENGTH_LONG).show();
                        }
                    });
             }
            }
        });

        loginPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SignupActivity.this,FirstActivity.class);
                startActivity(i);
            }
        });

    }

    private boolean valid() {
        boolean validity=true;
        if(TextUtils.isEmpty(email.getText().toString())){
            email.setError("You cannot leave email empty..!");
            validity=false;
        }
        if (!email.getText().toString().contains("@")){
            email.setError("no @ in email");
            validity=false;
        }
        if (TextUtils.isEmpty(password.getText().toString())){
            password.setError("Password cannot be empty");
            validity=false;
        }
        return validity;

    }
}
