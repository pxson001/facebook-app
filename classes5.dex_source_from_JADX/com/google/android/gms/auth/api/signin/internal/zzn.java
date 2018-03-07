package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public class zzn {
    private static final Lock f6415a = new ReentrantLock();
    private static zzn f6416b;
    private final Lock f6417c = new ReentrantLock();
    private final SharedPreferences f6418d;

    private zzn(Context context) {
        this.f6418d = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    private SignInAccount m12106a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String c = m12113c(m12110b("signInAccount", str));
        if (TextUtils.isEmpty(c)) {
            return null;
        }
        try {
            SignInAccount a = SignInAccount.m12089a(c);
            if (a.m12093e() != null) {
                GoogleSignInAccount b = m12109b(a.m12093e().m12077h());
                if (b != null) {
                    a.m12091a(b);
                }
            }
            return a;
        } catch (JSONException e) {
            return null;
        }
    }

    public static zzn m12107a(Context context) {
        zzx.a(context);
        f6415a.lock();
        try {
            if (f6416b == null) {
                f6416b = new zzn(context.getApplicationContext());
            }
            zzn com_google_android_gms_auth_api_signin_internal_zzn = f6416b;
            return com_google_android_gms_auth_api_signin_internal_zzn;
        } finally {
            f6415a.unlock();
        }
    }

    private void m12108a(String str, String str2) {
        this.f6417c.lock();
        try {
            this.f6418d.edit().putString(str, str2).apply();
        } finally {
            this.f6417c.unlock();
        }
    }

    private GoogleSignInAccount m12109b(String str) {
        GoogleSignInAccount googleSignInAccount = null;
        if (!TextUtils.isEmpty(str)) {
            String c = m12113c(m12110b("googleSignInAccount", str));
            if (c != null) {
                try {
                    googleSignInAccount = GoogleSignInAccount.m12068a(c);
                } catch (JSONException e) {
                }
            }
        }
        return googleSignInAccount;
    }

    private static String m12110b(String str, String str2) {
        return str + ":" + str2;
    }

    private void m12111b(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        zzx.a(googleSignInAccount);
        zzx.a(googleSignInOptions);
        String str = googleSignInAccount.f6379k;
        m12108a(m12110b("googleSignInAccount", str), googleSignInAccount.m12079j());
        m12108a(m12110b("googleSignInOptions", str), googleSignInOptions.m12087g());
    }

    private void m12112b(SignInAccount signInAccount, SignInConfiguration signInConfiguration) {
        zzx.a(signInAccount);
        zzx.a(signInConfiguration);
        String str = signInAccount.f6404h;
        SignInAccount a = m12106a(str);
        if (!(a == null || a.f6403g == null)) {
            m12116e(a.f6403g.f6379k);
        }
        m12108a(m12110b("signInConfiguration", str), signInConfiguration.m12103g());
        m12108a(m12110b("signInAccount", str), signInAccount.m12095h());
        if (signInAccount.f6403g != null) {
            m12111b(signInAccount.f6403g, signInConfiguration.f6410e);
        }
    }

    private String m12113c(String str) {
        this.f6417c.lock();
        try {
            String string = this.f6418d.getString(str, null);
            return string;
        } finally {
            this.f6417c.unlock();
        }
    }

    private void m12114c() {
        String c = m12113c("defaultGoogleSignInAccount");
        m12117f("defaultGoogleSignInAccount");
        m12116e(c);
    }

    private void m12115d(String str) {
        if (!TextUtils.isEmpty(str)) {
            SignInAccount a = m12106a(str);
            m12117f(m12110b("signInAccount", str));
            m12117f(m12110b("signInConfiguration", str));
            if (a != null && a.f6403g != null) {
                m12116e(a.f6403g.f6379k);
            }
        }
    }

    private void m12116e(String str) {
        if (!TextUtils.isEmpty(str)) {
            m12117f(m12110b("googleSignInAccount", str));
            m12117f(m12110b("googleSignInOptions", str));
        }
    }

    private void m12117f(String str) {
        this.f6417c.lock();
        try {
            this.f6418d.edit().remove(str).apply();
        } finally {
            this.f6417c.unlock();
        }
    }

    public final GoogleSignInAccount m12118a() {
        return m12109b(m12113c("defaultGoogleSignInAccount"));
    }

    public final void m12119a(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        zzx.a(googleSignInAccount);
        zzx.a(googleSignInOptions);
        m12108a("defaultGoogleSignInAccount", googleSignInAccount.f6379k);
        m12111b(googleSignInAccount, googleSignInOptions);
    }

    public final void m12120a(SignInAccount signInAccount, SignInConfiguration signInConfiguration) {
        zzx.a(signInAccount);
        zzx.a(signInConfiguration);
        m12121b();
        m12108a("defaultSignInAccount", signInAccount.f6404h);
        if (signInAccount.f6403g != null) {
            m12108a("defaultGoogleSignInAccount", signInAccount.f6403g.f6379k);
        }
        m12112b(signInAccount, signInConfiguration);
    }

    public final void m12121b() {
        String c = m12113c("defaultSignInAccount");
        m12117f("defaultSignInAccount");
        m12114c();
        m12115d(c);
    }
}
