package com.facebook.intent.thirdparty;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.inject.FbInjector;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;

/* compiled from: mCityName */
public class ThirdPartyUriActivity extends FbFragmentActivity {
    private SecureContextHelper f11238p;

    /* compiled from: mCityName */
    class C06991 implements OnCancelListener {
        final /* synthetic */ ThirdPartyUriActivity f11229a;

        C06991(ThirdPartyUriActivity thirdPartyUriActivity) {
            this.f11229a = thirdPartyUriActivity;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f11229a.finish();
        }
    }

    /* compiled from: mCityName */
    class C07013 implements OnClickListener {
        final /* synthetic */ ThirdPartyUriActivity f11232a;

        C07013(ThirdPartyUriActivity thirdPartyUriActivity) {
            this.f11232a = thirdPartyUriActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f11232a.finish();
        }
    }

    /* compiled from: mCityName */
    class C07024 implements OnCancelListener {
        final /* synthetic */ ThirdPartyUriActivity f11233a;

        C07024(ThirdPartyUriActivity thirdPartyUriActivity) {
            this.f11233a = thirdPartyUriActivity;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f11233a.finish();
        }
    }

    protected final void m18120b(Bundle bundle) {
        NativeThirdPartyUriHelper$NativeThirdPartyIntents nativeThirdPartyUriHelper$NativeThirdPartyIntents;
        this.f11238p = (SecureContextHelper) DefaultSecureContextHelper.a(FbInjector.get(this));
        Uri data = getIntent().getData();
        if (NativeThirdPartyUriHelper.a(data)) {
            NativeThirdPartyUriHelper$AppSites e = NativeThirdPartyUriHelper.e(data);
            nativeThirdPartyUriHelper$NativeThirdPartyIntents = new NativeThirdPartyUriHelper$NativeThirdPartyIntents(NativeThirdPartyUriHelper.c(this, data, e), NativeThirdPartyUriHelper.a(this, data, e), NativeThirdPartyUriHelper.b(this, data, e));
        } else {
            nativeThirdPartyUriHelper$NativeThirdPartyIntents = null;
        }
        NativeThirdPartyUriHelper$NativeThirdPartyIntents nativeThirdPartyUriHelper$NativeThirdPartyIntents2 = nativeThirdPartyUriHelper$NativeThirdPartyIntents;
        List a = Lists.a();
        List a2 = Lists.a();
        if (nativeThirdPartyUriHelper$NativeThirdPartyIntents2.f11228c != null) {
            a.add(getString(2131236008));
            a2.add(nativeThirdPartyUriHelper$NativeThirdPartyIntents2.f11228c);
            if (nativeThirdPartyUriHelper$NativeThirdPartyIntents2.f11226a != null) {
                a.add(m18113a(nativeThirdPartyUriHelper$NativeThirdPartyIntents2.f11226a, getString(2131236009), getString(2131236010)));
                a2.add(nativeThirdPartyUriHelper$NativeThirdPartyIntents2.f11226a);
            } else if (nativeThirdPartyUriHelper$NativeThirdPartyIntents2.f11227b != null) {
                a.add(m18113a(nativeThirdPartyUriHelper$NativeThirdPartyIntents2.f11227b, getString(2131236011), getString(2131236012)));
                a2.add(nativeThirdPartyUriHelper$NativeThirdPartyIntents2.f11227b);
            }
            if (a.isEmpty()) {
                finish();
                return;
            } else if (a2.size() == 1) {
                m18118b(this, (Intent) a2.get(0));
                return;
            } else {
                m18117a(a, a2);
                return;
            }
        }
        m18114a(nativeThirdPartyUriHelper$NativeThirdPartyIntents2);
    }

    private static String m18113a(Intent intent, String str, String str2) {
        if (TextUtils.isEmpty(intent.getStringExtra("extra_app_name"))) {
            return str2;
        }
        return String.format(str, new Object[]{intent.getStringExtra("extra_app_name")});
    }

    private void m18117a(List<String> list, final List<Intent> list2) {
        new Builder(this).a(2131236007).a((CharSequence[]) list.toArray(new String[0]), new OnClickListener(this) {
            final /* synthetic */ ThirdPartyUriActivity f11231b;

            public void onClick(DialogInterface dialogInterface, int i) {
                ThirdPartyUriActivity.m18118b(this.f11231b, (Intent) list2.get(i));
                this.f11231b.finish();
            }
        }).a(new C06991(this)).a().show();
    }

    private void m18114a(final NativeThirdPartyUriHelper$NativeThirdPartyIntents nativeThirdPartyUriHelper$NativeThirdPartyIntents) {
        Builder b = new Builder(this).a(new C07024(this)).b(2131236013, new C07013(this));
        if (nativeThirdPartyUriHelper$NativeThirdPartyIntents.f11226a != null) {
            b.a(2131236014).b(m18113a(nativeThirdPartyUriHelper$NativeThirdPartyIntents.f11226a, getString(2131236016), getString(2131236017))).a(2131236015, new OnClickListener(this) {
                final /* synthetic */ ThirdPartyUriActivity f11235b;

                public void onClick(DialogInterface dialogInterface, int i) {
                    ThirdPartyUriActivity.m18118b(this.f11235b, nativeThirdPartyUriHelper$NativeThirdPartyIntents.f11226a);
                }
            });
        } else if (nativeThirdPartyUriHelper$NativeThirdPartyIntents.f11227b != null) {
            b.a(2131236018).b(m18113a(nativeThirdPartyUriHelper$NativeThirdPartyIntents.f11227b, getString(2131236020), getString(2131236021))).a(2131236019, new OnClickListener(this) {
                final /* synthetic */ ThirdPartyUriActivity f11237b;

                public void onClick(DialogInterface dialogInterface, int i) {
                    ThirdPartyUriActivity.m18118b(this.f11237b, nativeThirdPartyUriHelper$NativeThirdPartyIntents.f11227b);
                }
            });
        } else {
            finish();
            return;
        }
        b.a().show();
    }

    public static void m18118b(ThirdPartyUriActivity thirdPartyUriActivity, Intent intent) {
        Map a;
        intent.removeExtra("extra_app_name");
        NativeThirdPartyUriHelper$LoggingParams nativeThirdPartyUriHelper$LoggingParams = (NativeThirdPartyUriHelper$LoggingParams) thirdPartyUriActivity.getIntent().getParcelableExtra("extra_logging_params");
        if (nativeThirdPartyUriHelper$LoggingParams != null) {
            a = nativeThirdPartyUriHelper$LoggingParams.m18112a();
        } else {
            a = null;
        }
        NativeThirdPartyUriHelper.a(thirdPartyUriActivity, intent, a);
        thirdPartyUriActivity.f11238p.b(intent, thirdPartyUriActivity);
        thirdPartyUriActivity.finish();
    }

    public static void m18119i(ThirdPartyUriActivity thirdPartyUriActivity) {
        thirdPartyUriActivity.finish();
    }
}
