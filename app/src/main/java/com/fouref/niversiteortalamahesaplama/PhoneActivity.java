package com.fouref.niversiteortalamahesaplama;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.huawei.agconnect.auth.AGConnectAuth;
import com.huawei.agconnect.auth.AGConnectAuthCredential;
import com.huawei.agconnect.auth.PhoneAuthProvider;
import com.huawei.agconnect.auth.PhoneUser;
import com.huawei.agconnect.auth.SignInResult;
import com.huawei.agconnect.auth.VerifyCodeResult;
import com.huawei.agconnect.auth.VerifyCodeSettings;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskExecutors;
import java.util.Locale;

public class PhoneActivity extends AppCompatActivity {

    private EditText countryCodeStr, phoneNumberStr, verifyCode, phonePassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        countryCodeStr = findViewById(R.id.editTextGeo);
        phoneNumberStr = findViewById(R.id.editTextPhoneNumber);
        verifyCode = findViewById(R.id.editTextVerifyCode);
        phonePassword = findViewById(R.id.editTextTextPassword);

        findViewById(R.id.getCodeButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyCode();
            }
        });
        findViewById(R.id.registerPhoneButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerWithPhone();
            }
        });
        findViewById(R.id.loginPhoneButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singInProccess();
            }
        });

    }

    private void registerWithPhone()
    {
        PhoneUser phoneUser = new PhoneUser.Builder()
                .setCountryCode(countryCodeStr.getText().toString())
                .setPhoneNumber(phoneNumberStr.getText().toString())
                .setVerifyCode(verifyCode.getText().toString())
                .setPassword(phonePassword.getText().toString())
                .build();

        AGConnectAuth.getInstance().createUser(phoneUser)
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


    private void verifyCode()
    {
        VerifyCodeSettings settings = new VerifyCodeSettings.Builder()
                .action(VerifyCodeSettings.ACTION_REGISTER_LOGIN)
                .sendInterval(30)
                .locale(Locale.ENGLISH)
                .build();

        Task<VerifyCodeResult> task = PhoneAuthProvider.requestVerifyCode(countryCodeStr.getText().toString(), phoneNumberStr.getText().toString(), settings);
        task.addOnSuccessListener(TaskExecutors.uiThread(), new OnSuccessListener<VerifyCodeResult>() {
            @Override
            public void onSuccess(VerifyCodeResult verifyCodeResult) {
                Toast.makeText(getApplicationContext(), "Telefonunuza Onay Kodu Gönderildi.", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(TaskExecutors.uiThread(), new OnFailureListener() {
            @Override
            public void onFailure(Exception e) {
                Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void singInProccess()
    {
        AGConnectAuthCredential credential = PhoneAuthProvider
                .credentialWithVerifyCode(countryCodeStr.getText().toString(), phoneNumberStr.getText().toString(),phonePassword.getText().toString(), verifyCode.getText().toString());

        AGConnectAuth.getInstance().signIn(credential)
                .addOnSuccessListener(new OnSuccessListener<SignInResult>() {
                    @Override
                    public void onSuccess(SignInResult signInResult) {
                        Toast.makeText(getApplicationContext(), "Başarıyla giriş yapıldı.", Toast.LENGTH_SHORT).show();
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