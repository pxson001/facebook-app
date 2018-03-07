package com.facebook.quickpromotion.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.quickpromotion.controller.QuickPromotionControllerDelegate;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.ui.QuickPromotionFragment.QuickPromotionFragmentHost;
import javax.inject.Inject;

/* compiled from: queue_state */
public class QuickPromotionInterstitialActivity extends FbFragmentActivity implements QuickPromotionFragmentHost {
    @Inject
    public QuickPromotionFragmentFactory f4815p;
    private boolean f4816q;

    private static <T extends Context> void m4683a(Class<T> cls, T t) {
        m4684a((Object) t, (Context) t);
    }

    public static void m4684a(Object obj, Context context) {
        ((QuickPromotionInterstitialActivity) obj).f4815p = QuickPromotionFragmentFactory.m4679a(FbInjector.get(context));
    }

    protected final void m4690b(Bundle bundle) {
        super.b(bundle);
        Class cls = QuickPromotionInterstitialActivity.class;
        m4684a((Object) this, (Context) this);
        if (bundle == null) {
            m4686i();
        }
    }

    protected final void m4689a(Intent intent) {
        super.a(intent);
        setIntent(intent);
        m4686i();
    }

    private void m4686i() {
        QuickPromotionFragment a = this.f4815p.m4681a(getIntent());
        if (a == null) {
            finish();
            return;
        }
        a.d(true);
        kO_().a().b(16908290, a).b();
        this.f4816q = m4685c(getIntent().getExtras());
    }

    private void m4682a(QuickPromotionFragmentFactory quickPromotionFragmentFactory) {
        this.f4815p = quickPromotionFragmentFactory;
    }

    public final void c_(boolean z) {
        if (m4687j()) {
            m4688k();
        } else if (z) {
            finish();
        }
    }

    public void onBackPressed() {
        if (m4687j()) {
            m4688k();
        } else {
            super.onBackPressed();
        }
    }

    private boolean m4687j() {
        return this.f4816q && VERSION.SDK_INT < 11;
    }

    private static boolean m4685c(Bundle bundle) {
        if (bundle != null) {
            QuickPromotionDefinition quickPromotionDefinition = (QuickPromotionDefinition) bundle.get("qp_definition");
            if (quickPromotionDefinition != null) {
                return QuickPromotionControllerDelegate.a(quickPromotionDefinition);
            }
        }
        return false;
    }

    private void m4688k() {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        intent.setFlags(268435456);
        ((SecureContextHelper) DefaultSecureContextHelper.a(hz_())).b(intent, getApplicationContext());
    }
}
