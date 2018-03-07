package com.facebook.directinstall.feed;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.analytics.ManualAnalyticsNavigationActivity;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.directinstall.intent.DirectInstallAppData;
import com.facebook.directinstall.intent.DirectInstallIntentUtils;
import com.facebook.inject.FbInjector;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: omnistore.txt */
public class InstallDialogActivity extends FbFragmentActivity implements ManualAnalyticsNavigationActivity {
    @Inject
    public DirectInstallHandler f8760p;

    private static <T extends Context> void m12529a(Class<T> cls, T t) {
        m12530a((Object) t, (Context) t);
    }

    public static void m12530a(Object obj, Context context) {
        ((InstallDialogActivity) obj).f8760p = DirectInstallHandler.m12523a(FbInjector.get(context));
    }

    protected final void m12531b(@Nullable Bundle bundle) {
        super.b(bundle);
        Class cls = InstallDialogActivity.class;
        m12530a((Object) this, (Context) this);
        setContentView(2130903095);
        Intent intent = getIntent();
        DirectInstallHandler directInstallHandler = this.f8760p;
        DirectInstallAppData a = DirectInstallIntentUtils.m12552a(intent.getExtras());
        Builder builder = ImmutableMap.builder();
        Bundle bundleExtra = intent.getBundleExtra("analytics");
        if (bundleExtra != null) {
            for (String str : bundleExtra.keySet()) {
                builder.b(str, bundleExtra.get(str));
            }
        }
        Map b = builder.b();
        DirectInstallIntentUtils.m12557c(intent.getExtras());
        directInstallHandler.mo961a(this, a, b);
    }

    private void m12528a(DirectInstallHandler directInstallHandler) {
        this.f8760p = directInstallHandler;
    }
}
