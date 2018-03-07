package com.facebook.appdiscovery.lite.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.appdiscovery.lite.common.error.AppDiscoveryError;
import com.facebook.appdiscovery.lite.common.error.AppDiscoveryException;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.util.injectable.DisplayUtil;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.dialogs.FbDialogFragment;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: sellerInfo */
public class AppDiscoveryLiteActivity extends FbFragmentActivity {
    private static final String f4134r = AppDiscoveryLiteActivity.class.getName();
    @Inject
    public AbstractFbErrorReporter f4135p;
    @Inject
    public DisplayUtil f4136q;
    @Nullable
    private String f4137s;
    @Nullable
    private String f4138t;
    @Nullable
    private String f4139u;

    private static <T extends Context> void m4187a(Class<T> cls, T t) {
        m4188a((Object) t, (Context) t);
    }

    public static void m4188a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        AppDiscoveryLiteActivity appDiscoveryLiteActivity = (AppDiscoveryLiteActivity) obj;
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        DisplayUtil a = DisplayUtil.a(fbInjector);
        appDiscoveryLiteActivity.f4135p = abstractFbErrorReporter;
        appDiscoveryLiteActivity.f4136q = a;
    }

    protected final void m4191b(@Nullable Bundle bundle) {
        super.b(bundle);
        Class cls = AppDiscoveryLiteActivity.class;
        m4188a((Object) this, (Context) this);
        setContentView(2130905059);
        Intent intent = getIntent();
        this.f4138t = intent.getStringExtra("package_name");
        this.f4139u = intent.getStringExtra("app_invite_id");
        this.f4137s = intent.getStringExtra("referrer");
        if (this.f4139u != null) {
            this.f4137s = "app_invites_notification";
        }
        if ((this.f4138t == null && this.f4139u == null) || this.f4137s == null) {
            this.f4135p.b(f4134r, new AppDiscoveryException("No package name or app invite id specified. Also need to set referrer", AppDiscoveryError.ILLEGAL_ARGUMENT));
        }
        m4189i();
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1810070626);
        super.onResume();
        getWindow().setLayout(m4190j(), -2);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1217646939, a);
    }

    private void m4189i() {
        FbDialogFragment fbDialogFragment;
        String str;
        String str2;
        AppDiscoveryLiteFragment appDiscoveryLiteFragment;
        Bundle bundle;
        if (this.f4139u != null) {
            str = this.f4139u;
            str2 = this.f4137s;
            appDiscoveryLiteFragment = new AppDiscoveryLiteFragment();
            bundle = new Bundle();
            bundle.putString("app_invite_id", str);
            bundle.putString("referrer", str2);
            appDiscoveryLiteFragment.g(bundle);
            fbDialogFragment = appDiscoveryLiteFragment;
        } else {
            str = this.f4138t;
            str2 = this.f4137s;
            appDiscoveryLiteFragment = new AppDiscoveryLiteFragment();
            bundle = new Bundle();
            bundle.putString("package_name", str);
            bundle.putString("referrer", str2);
            appDiscoveryLiteFragment.g(bundle);
            fbDialogFragment = appDiscoveryLiteFragment;
        }
        m4186a(fbDialogFragment);
    }

    private void m4186a(FbDialogFragment fbDialogFragment) {
        kO_().a().b(2131558429, fbDialogFragment).b();
    }

    private int m4190j() {
        return Math.round(((float) this.f4136q.a().x) * 0.9f);
    }
}
