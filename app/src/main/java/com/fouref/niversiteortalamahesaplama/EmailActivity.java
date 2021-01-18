package com.fouref.niversiteortalamahesaplama;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.huawei.agconnect.auth.AGConnectAuth;
import com.huawei.agconnect.auth.AGConnectAuthCredential;
import com.huawei.agconnect.auth.EmailAuthProvider;
import com.huawei.agconnect.auth.EmailUser;
import com.huawei.agconnect.auth.SignInResult;
import com.huawei.agconnect.auth.VerifyCodeResult;
import com.huawei.agconnect.auth.VerifyCodeSettings;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskExecutors;
import java.util.Locale;


public class EmailActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = EmailActivity.class.getSimpleName();
    private EditText emailEditText, passwordEditText, verifyCodeEditText;
    private Button verifyEmailButton, registerButton, loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        verifyCodeEditText = findViewById(R.id.verifyCodeEditText);
        verifyEmailButton = findViewById(R.id.verifyEmailButton);
        registerButton = findViewById(R.id.registerButton);
        loginButton = findViewById(R.id.loginButton);

        verifyEmailButton.setOnClickListener(this);
        registerButton.setOnClickListener(this);
        loginButton.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.verifyEmailButton:
                verifyEmail();
                break;
            case R.id.registerButton:
                registerWithEmail();
                break;
            case R.id.loginButton:
                loginProcess();
                break;
        }
    }

    private void verifyEmail() {
        VerifyCodeSettings settings = new VerifyCodeSettings.Builder()
                .action(VerifyCodeSettings.ACTION_REGISTER_LOGIN)
                .sendInterval(30)
                .locale(Locale.ENGLISH)
                .build();
        Task<VerifyCodeResult> task= EmailAuthProvider.requestVerifyCode(emailEditText.getText().toString(), settings);
        task.addOnSuccessListener(TaskExecutors.uiThread(), new OnSuccessListener<VerifyCodeResult>() {
            @Override
            public void onSuccess(VerifyCodeResult verifyCodeResult) {
                Toast.makeText(getApplicationContext(), "E-Postanızı Kontrol Edin.", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(TaskExecutors.uiThread(), new OnFailureListener() {
            @Override
            public void onFailure(Exception e) {
                Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void registerWithEmail() {

        EmailUser emailUser = new EmailUser.Builder()
                .setEmail(emailEditText.getText().toString())
                .setPassword(passwordEditText.getText().toString())
                .setVerifyCode(verifyCodeEditText.getText().toString())
                .build();

        AGConnectAuth.getInstance().createUser(emailUser)
                .addOnSuccessListener(new OnSuccessListener<SignInResult>() {
                    @Override
                    public void onSuccess(SignInResult signInResult) {
                        Toast.makeText(getApplicationContext(), "Kullanıcı Başarıyla Oluşturuldu", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void loginProcess() {

        AGConnectAuthCredential credential = EmailAuthProvider
                .credentialWithPassword(emailEditText.getText().toString(), passwordEditText.getText().toString());

        AGConnectAuth.getInstance().signIn(credential)
                .addOnSuccessListener(new OnSuccessListener<SignInResult>() {
                    @Override
                    public void onSuccess(SignInResult signInResult) {
                        Toast.makeText(getApplicationContext(), "Başarıyla Giriş Yapıldı.", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

}