package com.example.firebase2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.example.firebase2.Utilities.*;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtEmail = findViewById(R.id.editEmail);
        EditText edtPassword = findViewById(R.id.editPassword);
        EditText edtConfirmPassword = findViewById(R.id.editConfirmPassword);
        EditText edtPhoneNumber = findViewById(R.id.editPhoneNumber);

        Button btnReg = findViewById(R.id.btnReg);

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database = FirebaseDatabase
                        .getInstance("https://fir-2-9a42d-default-rtdb.firebaseio.com/")
                        .getReference().child("Users");
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();
                String confirmPassword = edtConfirmPassword.getText().toString();
                String phoneNumber = edtPhoneNumber.getText().toString();



                //Проверки
                if(!checkEmailForValidity(email))
                    Toast.makeText(getApplicationContext(),"Некорректный ввод эл.почты!",
                            Toast.LENGTH_SHORT).show();

                else if(!checkPasswordForValidity(password))
                    Toast.makeText(getApplicationContext(),
                            "Пароль должен быть более 8 символов и иметь заглавные, прописные символы, цифры и спецсимволы",
                            Toast.LENGTH_LONG).show();

                else if(!checkPasswordForEquals(password, confirmPassword))
                    Toast.makeText(getApplicationContext(),"Пароли не совпадают!",
                            Toast.LENGTH_SHORT).show();

                else if(!checkPhoneNumberForValidity(phoneNumber))
                    Toast.makeText(getApplicationContext(),
                            "Неккоректный номер телефона!",
                            Toast.LENGTH_SHORT).show();
                else{
                    User user = new User(email,
                            password,
                            confirmPassword,
                            phoneNumber);
                    database.child(phoneNumber).setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            edtEmail.getText().clear();
                            edtPassword.getText().clear();
                            edtConfirmPassword.getText().clear();
                            edtPhoneNumber.getText().clear();

                            Toast.makeText(getApplicationContext(),"Запись добавлена",Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(),"Произошла ошибка",
                                    Toast.LENGTH_SHORT).show();

                            Log.e("--!--Error", "onFailure: " + e);
                        }
                    });
                }
            }
        });
    }
}