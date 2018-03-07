package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.app.LoaderManagerImpl;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.auth.api.signin.zze;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzld;
import com.google.android.gms.internal.zzlf;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SignInHubActivity extends FragmentActivity {
    private zzn f3668p;
    private zzj f3669q;
    private SignInConfiguration f3670r;
    private boolean f3671s;
    private String f3672t;
    private boolean f3673u;
    public int f3674v;
    public Intent f3675w;

    class C03311 implements com.google.android.gms.internal.zzld.zza {
        final /* synthetic */ SignInHubActivity f3666a;

        C03311(SignInHubActivity signInHubActivity) {
            this.f3666a = signInHubActivity;
        }

        public final void mo98a() {
            this.f3666a.setResult(0);
            this.f3666a.finish();
        }

        public final void mo99a(Intent intent) {
            if (intent != null) {
                this.f3666a.m3395a(intent);
                return;
            }
            Log.w("AuthSignInClient", "Idp signin failed!");
            this.f3666a.m3392a(4);
        }

        public final void mo100a(Exception exception) {
            String str = (exception == null || exception.getMessage() == null) ? "" : " " + exception.getMessage();
            Log.w("AuthSignInClient", "Idp signin failed!" + str);
            this.f3666a.m3392a(4);
        }
    }

    class zza implements LoaderCallbacks<Void> {
        final /* synthetic */ SignInHubActivity f3667a;

        public zza(SignInHubActivity signInHubActivity) {
            this.f3667a = signInHubActivity;
        }

        public final void m3390a(Loader loader, Object obj) {
            this.f3667a.setResult(this.f3667a.f3674v, this.f3667a.f3675w);
            this.f3667a.finish();
        }

        public final void gA_() {
        }

        public final Loader<Void> n_(int i) {
            return new zzb(this.f3667a, GoogleApiClient.a);
        }
    }

    private void m3392a(int i) {
        Intent intent = new Intent();
        intent.putExtra("errorCode", i);
        setResult(0, intent);
        finish();
    }

    private void m3393a(int i, int i2, Intent intent) {
        for (zzld a : this.f3669q.f3678a.values()) {
            if (a.mo105a(i, i2, intent, m3403g())) {
                break;
            }
        }
        if (i2 == 0) {
            finish();
        }
    }

    private void m3394a(int i, Intent intent) {
        if (intent != null) {
            SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra("signInAccount");
            if (signInAccount != null && signInAccount.g != null) {
                GoogleSignInAccount googleSignInAccount = signInAccount.g;
                this.f3668p.a(googleSignInAccount, this.f3670r.e);
                intent.removeExtra("signInAccount");
                intent.putExtra("googleSignInAccount", googleSignInAccount);
                this.f3673u = true;
                this.f3674v = i;
                this.f3675w = intent;
                m3402f();
                return;
            } else if (intent.hasExtra("errorCode")) {
                m3399b(intent.getIntExtra("errorCode", 8));
                return;
            }
        }
        m3399b(8);
    }

    private void m3395a(Intent intent) {
        intent.setPackage("com.google.android.gms");
        intent.putExtra("config", this.f3670r);
        try {
            startActivityForResult(intent, this.f3671s ? 40962 : 40961);
        } catch (ActivityNotFoundException e) {
            Log.w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
            if (this.f3671s) {
                m3399b(8);
            } else {
                m3392a(2);
            }
        }
    }

    private void m3399b(int i) {
        Status status = new Status(i);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
    }

    private void m3400b(int i, Intent intent) {
        if (i == -1) {
            SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra("signInAccount");
            if (signInAccount != null) {
                this.f3668p.a(signInAccount, this.f3670r);
                setResult(-1, intent);
                finish();
                return;
            }
            Log.w("AuthSignInClient", "[SignInHubActivity] SignInAccount is null.");
            m3392a(2);
        } else if (intent == null) {
            finish();
        } else {
            Object stringExtra = intent.getStringExtra("email");
            zze zzbI = zze.zzbI(intent.getStringExtra("idProvider"));
            if (zzbI == null) {
                setResult(i, intent);
                finish();
                return;
            }
            this.f3672t = intent.getStringExtra("pendingToken");
            Intent intent2 = this.f3670r.f.b;
            if (!zze.zzVK.equals(zzbI) || this.f3670r.f == null || intent2 == null) {
                zzld a = this.f3669q.m3407a(zzbI);
                if (a == null) {
                    Log.w("AuthSignInClient", zzbI.zzad(this) + " is not supported. Please check your configuration");
                    m3392a(1);
                    return;
                }
                int intExtra = intent.getIntExtra("userProfile", -1);
                if (intExtra == 0) {
                    if (TextUtils.isEmpty(stringExtra)) {
                        a.mo102a(m3403g());
                        return;
                    } else {
                        a.mo103a(stringExtra, m3403g());
                        return;
                    }
                } else if (intExtra != 1 || TextUtils.isEmpty(this.f3672t) || TextUtils.isEmpty(stringExtra)) {
                    Log.w("AuthSignInClient", "Internal error!");
                    m3392a(2);
                    return;
                } else {
                    a.mo104a(stringExtra, this.f3672t, m3403g());
                    return;
                }
            }
            startActivityForResult(intent2, 45057);
        }
    }

    private void m3401c(int i, Intent intent) {
        if (i == 0) {
            setResult(0, intent);
            finish();
            return;
        }
        Intent intent2 = new Intent("com.google.android.gms.auth.VERIFY_ASSERTION");
        intent2.putExtra("idpTokenType", IdpTokenType.f3662a);
        intent2.putExtra("idpToken", intent.getStringExtra("idpToken"));
        intent2.putExtra("pendingToken", this.f3672t);
        intent2.putExtra("idProvider", zze.zzVK.zzmC());
        m3395a(intent2);
    }

    private void m3402f() {
        LoaderManagerImpl loaderManagerImpl;
        if (this.n != null) {
            loaderManagerImpl = this.n;
        } else {
            this.k = true;
            this.n = a("(root)", this.l, true);
            loaderManagerImpl = this.n;
        }
        loaderManagerImpl.a(0, null, new zza(this));
    }

    private com.google.android.gms.internal.zzld.zza m3403g() {
        return new C03311(this);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        setResult(0);
        switch (i) {
            case 40961:
                m3400b(i2, intent);
                return;
            case 40962:
                m3394a(i2, intent);
                return;
            case 45057:
                m3401c(i2, intent);
                return;
            default:
                m3393a(i, i2, intent);
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1639906415);
        super.onCreate(bundle);
        this.f3668p = zzn.a(this);
        this.f3670r = (SignInConfiguration) getIntent().getParcelableExtra("config");
        this.f3671s = "com.google.android.gms.auth.GOOGLE_SIGN_IN".equals(getIntent().getAction());
        if (this.f3670r == null) {
            Log.e("AuthSignInClient", "Activity started with invalid configuration.");
            setResult(0);
            finish();
            Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1030414423, a);
            return;
        }
        int i;
        zzlf com_google_android_gms_internal_zzlf;
        List linkedList = new LinkedList();
        Map hashMap = new HashMap();
        zzh.m3406a(this.f3670r, linkedList, hashMap);
        this.f3669q = new zzj(this, linkedList, hashMap);
        if (this.f3670r.e() != null) {
            zzlf com_google_android_gms_internal_zzlf2 = (zzlf) this.f3669q.m3407a(zze.zzVK);
            com_google_android_gms_internal_zzlf2.m3420a((Context) this);
            if (this.f3670r.c() == null && this.f3670r.d() == null) {
                i = 1;
                com_google_android_gms_internal_zzlf = com_google_android_gms_internal_zzlf2;
            } else {
                i = 0;
                com_google_android_gms_internal_zzlf = com_google_android_gms_internal_zzlf2;
            }
        } else {
            i = 0;
            com_google_android_gms_internal_zzlf = null;
        }
        if (bundle == null) {
            Intent intent;
            if (this.f3671s) {
                intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
            } else {
                intent = new Intent("com.google.android.gms.auth.LOGIN_PICKER");
                if ("com.google.android.gms.auth.RESOLVE_CREDENTIAL".equals(getIntent().getAction())) {
                    intent.fillIn(getIntent(), 3);
                } else {
                    this.f3668p.b();
                    if (com_google_android_gms_internal_zzlf != null) {
                        try {
                            zzlf.m3416b(this);
                        } catch (IllegalStateException e) {
                        }
                    }
                }
            }
            if (i != 0) {
                com_google_android_gms_internal_zzlf.mo102a(m3403g());
                LogUtils.c(-677715940, a);
                return;
            }
            m3395a(intent);
        } else {
            this.f3672t = bundle.getString("pendingToken");
            this.f3673u = bundle.getBoolean("signingInGoogleApiClients");
            if (this.f3673u) {
                this.f3674v = bundle.getInt("signInResultCode");
                this.f3675w = (Intent) bundle.getParcelable("signInResultData");
                m3402f();
            }
        }
        LogUtils.c(-1680183990, a);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("pendingToken", this.f3672t);
        bundle.putBoolean("signingInGoogleApiClients", this.f3673u);
        if (this.f3673u) {
            bundle.putInt("signInResultCode", this.f3674v);
            bundle.putParcelable("signInResultData", this.f3675w);
        }
    }
}
