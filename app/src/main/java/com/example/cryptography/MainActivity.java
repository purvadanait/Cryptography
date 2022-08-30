package com.example.cryptography;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.nio.charset.StandardCharsets;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class MainActivity extends AppCompatActivity {
    EditText keytext;
    EditText normaltext;
    EditText ciphertext;
    Button copy_normal;
    Button copy_cipher;
    Button encrypt;
    Button decrypt;
    Button delete_normal;
    Button delete_cipher;
    TextView char_count;
    TextView char_count2;
    Context c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public String encrypt(String value, Context c){
        String crypted="";
        try {
            byte[] cleartext = value.getBytes(StandardCharsets.UTF_8);
            SecretKeySpec key = new SecretKeySpec(keytext.getText().toString().getBytes(),"DES");
            Cipher cipher = Cipher.getInstance("DES/ECB/ZeroBytePadding");




        }



    }
}