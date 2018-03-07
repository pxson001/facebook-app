package com.facebook.feed.quickcam;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.inject.FbInjector;

/* compiled from: drawerLockMode */
public class QuickCamActivity extends FbFragmentActivity {
    private QuickCamFragment f7516p;

    private static <T extends Context> void m8735a(Class<T> cls, T t) {
        FbInjector.get(t);
    }

    private static void m8736a(Object obj, Context context) {
        FbInjector.get(context);
    }

    @SuppressLint({"BadMethodUse-android.support.v4.app.FragmentActivity.getSupportFragmentManager"})
    public final void m8737b(Bundle bundle) {
        super.b(bundle);
        Class cls = QuickCamActivity.class;
        FbInjector.get(this);
        setContentView(2130904327);
        this.f7516p = (QuickCamFragment) kO_().a(2131558429);
        if (this.f7516p == null) {
            Intent intent = getIntent();
            intent.putExtra("STATE_KEY_OVERRIDDEN_ON_BACK_PRESS", true);
            Bundle bundle2 = new Bundle();
            if (!(intent == null || intent.getExtras() == null)) {
                bundle2.putAll(intent.getExtras());
            }
            QuickCamFragment quickCamFragment = new QuickCamFragment();
            quickCamFragment.g(bundle2);
            this.f7516p = quickCamFragment;
            kO_().a().b(2131558429, this.f7516p).b();
        }
    }

    public void onBackPressed() {
        this.f7516p.m8763b();
        super.onBackPressed();
    }
}
