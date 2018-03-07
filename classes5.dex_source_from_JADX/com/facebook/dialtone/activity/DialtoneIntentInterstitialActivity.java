package com.facebook.dialtone.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.iorg.common.upsell.ui.FbZeroDialogController;
import com.facebook.iorg.common.zero.ui.ZeroDialogController;
import com.facebook.iorg.common.zero.ui.ZeroDialogController.Listener;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import javax.inject.Inject;

/* compiled from: \\b */
public class DialtoneIntentInterstitialActivity extends FbFragmentActivity {
    private static final Class<?> f11815r = DialtoneIntentInterstitialActivity.class;
    @Inject
    ZeroDialogController f11816p;
    @Inject
    SecureContextHelper f11817q;
    private Intent f11818s;
    private boolean f11819t;
    private int f11820u;

    /* compiled from: \\b */
    class C11021 implements Listener {
        final /* synthetic */ DialtoneIntentInterstitialActivity f11814a;

        C11021(DialtoneIntentInterstitialActivity dialtoneIntentInterstitialActivity) {
            this.f11814a = dialtoneIntentInterstitialActivity;
        }

        public final void m19833a(Object obj) {
            this.f11814a.f11817q.a(new Intent(this.f11814a, DialtoneModeTransitionInterstitialActivity.class), 79, this.f11814a);
        }

        public final void m19832a() {
            this.f11814a.finish();
        }
    }

    private static <T extends Context> void m19835a(Class<T> cls, T t) {
        m19836a((Object) t, (Context) t);
    }

    public static void m19836a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((DialtoneIntentInterstitialActivity) obj).m19834a((ZeroDialogController) FbZeroDialogController.b(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector));
    }

    protected final void m19838b(Bundle bundle) {
        super.b(bundle);
        Class cls = DialtoneIntentInterstitialActivity.class;
        m19836a((Object) this, (Context) this);
        Intent intent = getIntent();
        this.f11818s = (Intent) intent.getParcelableExtra("destination_intent");
        this.f11818s.setExtrasClassLoader(getClass().getClassLoader());
        this.f11819t = intent.getBooleanExtra("start_for_result", false);
        this.f11820u = intent.getIntExtra("request_code", 0);
        m19837i();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (this.f11819t) {
            try {
                this.f11817q.a(this.f11818s, this.f11820u, this);
                return;
            } catch (Throwable e) {
                BLog.b(f11815r, e, "Activity not found for intent: [%s]", new Object[]{this.f11818s});
                return;
            }
        }
        try {
            this.f11817q.a(this.f11818s, this);
        } catch (Throwable e2) {
            BLog.b(f11815r, e2, "Activity not found for intent: [%s]", new Object[]{this.f11818s});
        }
        finish();
    }

    private void m19837i() {
        this.f11816p.a(ZeroFeatureKey.DIALTONE_FACEWEB, getString(2131232553), getString(2131232554), new C11021(this));
        this.f11816p.a(ZeroFeatureKey.DIALTONE_FACEWEB, kO_(), null);
    }

    private void m19834a(ZeroDialogController zeroDialogController, SecureContextHelper secureContextHelper) {
        this.f11816p = zeroDialogController;
        this.f11817q = secureContextHelper;
    }
}
