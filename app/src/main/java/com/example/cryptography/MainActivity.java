package com.example.cryptography;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Base64;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
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






    @RequiresApi(api = Build.VERSION_CODES.O)
    public String encrypt(String value, Context c){
        String crypted="";
        try {
            byte[] cleartext = value.getBytes(StandardCharsets.UTF_8);
            SecretKeySpec key = new SecretKeySpec(keytext.getText().toString().getBytes(),"DES");
            Cipher cipher = Cipher.getInstance("DES/ECB/ZeroBytePadding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            crypted = Base64.encodeToString(cipher.doFinal(cleartext), Base64.DEFAULT);
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            App.DialogMaker(c, "Encrypt Error", "Error"+"\n"+e.getMessage());
            return "Encrypt Error";
        }
        catch (NoSuchPaddingException e) {
           e.printStackTrace();
           App.DialogMaker(c, "Encrypt Error", "Error"+"\n"+e.getMessage());
           return "Encrypt Error";
        }
        catch (IllegalBlockSizeException e) {
            e.printStackTrace();
            App.DialogMaker(c, "Encrypt Error", "Error"+"\n"+e.getMessage());
            return "Encrypt Error";
        }
        catch (BadPaddingException e) {
            e.printStackTrace();
            App.DialogMaker(c, "Encrypt Error", "Error"+"\n"+e.getMessage());
            return "Encrypt Error";
        }
        catch (InvalidKeyException e) {
            e.printStackTrace();
            App.DialogMaker(c, "Encrypt Error", "Error"+"\n"+e.getMessage());
            return "Encrypt Error";
        } catch (Exception e) {
            e.printStackTrace();
            App.DialogMaker(c, "Encrypt Error", "Error"+"\n"+e.getMessage());
            return "Encrypt Error";
        }
        return crypted;



    }
}