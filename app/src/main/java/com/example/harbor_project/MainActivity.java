package com.example.harbor_project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(FirebaseAuth.getInstance().getCurrentUser()==null){
            startSignUpActivity();
        }
        findViewById(R.id.logoutButton).setOnClickListener(onClickListener);
        findViewById(R.id.cameraButton).setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.logoutButton:
                    FirebaseAuth.getInstance().signOut();
                    startSignUpActivity();
                    break;
                case R.id.cameraButton:
                    Log.e("클릭","클릭");
                    startCameraActivity();
                    break;
            }
        }
    };

    private void startSignUpActivity(){
        Intent intent=new Intent(this,SignUpActivity.class);
        startActivity(intent);
    }

    private void startCameraActivity(){
        Intent intent=new Intent(this,CameraActivity.class);
        startActivity(intent);
    }
}