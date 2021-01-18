package com.fouref.niversiteortalamahesaplama;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.huawei.agconnect.auth.AGConnectAuth;
import com.huawei.agconnect.auth.AGConnectAuthCredential;
import com.huawei.agconnect.auth.AGConnectUser;
import com.huawei.agconnect.auth.HwIdAuthProvider;
import com.huawei.agconnect.auth.SignInResult;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.support.hwid.HuaweiIdAuthManager;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParams;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import com.huawei.hms.support.hwid.service.HuaweiIdAuthService;

public class LoginActivity extends AppCompatActivity {
    private AGConnectAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        auth = AGConnectAuth.getInstance();

        findViewById(R.id.huawei_Button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInWithHuaweiAccount();
            }
        });

        findViewById(R.id.Email_Button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(LoginActivity.this, EmailActivity.class);
                startActivity(mainIntent);
            }
        });
        findViewById(R.id.phone_Button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(LoginActivity.this, PhoneActivity.class);
                startActivity(mainIntent);
            }
        });

        findViewById(R.id.anonimButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInWithAnonymousAccount();
            }
        });


    }

    private void signInWithAnonymousAccount() {

        AGConnectAuth.getInstance().signInAnonymously().addOnSuccessListener(new OnSuccessListener<SignInResult>() {
            @Override
            public void onSuccess(SignInResult signInResult) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(Exception e) {
                Log.d("TAG", "Error " + e);
                Toast.makeText(LoginActivity.this, "Anonim olarak giriş başarısız", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void SendUserToMainActivity() {
        Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
        mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(mainIntent);
        finish();
    }

    private void signInWithHuaweiAccount() {
        HuaweiIdAuthParams mHuaweiIdAuthParams = new HuaweiIdAuthParamsHelper(HuaweiIdAuthParams.DEFAULT_AUTH_REQUEST_PARAM).setAccessToken().createParams();
        HuaweiIdAuthService mHuaweiIdAuthService = HuaweiIdAuthManager.getService(LoginActivity.this, mHuaweiIdAuthParams);
        startActivityForResult(mHuaweiIdAuthService.getSignInIntent(), 1001);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1001) {
            com.huawei.hmf.tasks.Task<AuthHuaweiId> authHuaweiIdTask = HuaweiIdAuthManager.parseAuthResultFromIntent(data);
            if (authHuaweiIdTask.isSuccessful()) {
                AuthHuaweiId huaweiAccount = authHuaweiIdTask.getResult();
                Log.i("TAG", "signIn success Access Token = " + huaweiAccount.getAccessToken());
                Log.i("TAG", "signIn success User Name = " + huaweiAccount.getDisplayName());
                transmitTokenIntoAppGalleryConnect(huaweiAccount.getAccessToken());
            } else {
                Log.i("TAG", "signIn failed: " + ((ApiException) authHuaweiIdTask.getException()).getStatusCode());
            }
        }
    }

    private void transmitTokenIntoAppGalleryConnect(String accessToken) {
        AGConnectAuthCredential credential = HwIdAuthProvider.credentialWithToken(accessToken);
        AGConnectAuth.getInstance().signIn(credential).addOnSuccessListener(new OnSuccessListener<SignInResult>() {
            @Override
            public void onSuccess(SignInResult signInResult) {
                SendUserToMainActivity();
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(Exception e) {
                Log.d("TAG", "Error " + e);
            }
        });
    }

@Override
protected void onStart() {
    super.onStart();
    if (AGConnectAuth.getInstance().getCurrentUser() != null) {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();

    }
}

}