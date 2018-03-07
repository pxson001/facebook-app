package com.facebook.registration.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.activitylistener.annotations.IAuthNotRequired;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.registration.controller.RegistrationFragmentController;
import com.facebook.registration.logging.SimpleRegLogger;
import com.facebook.registration.util.RegistrationUtil;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import javax.inject.Inject;

/* compiled from: traceSectionName */
public class AccountRegistrationActivity extends FbFragmentActivity implements IAuthNotRequired, HasTitleBar {
    @Inject
    public SimpleRegLogger f838p;
    @Inject
    public FunnelLoggerImpl f839q;
    @Inject
    public RegistrationUtil f840r;
    private FbTitleBar f841s;
    private RegistrationFragmentController f842t;
    private View f843u;

    private static <T extends Context> void m1184a(Class<T> cls, T t) {
        m1185a((Object) t, (Context) t);
    }

    public static void m1185a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        AccountRegistrationActivity accountRegistrationActivity = (AccountRegistrationActivity) obj;
        SimpleRegLogger b = SimpleRegLogger.m13147b(injectorLike);
        FunnelLoggerImpl a = FunnelLoggerImpl.a(injectorLike);
        RegistrationUtil b2 = RegistrationUtil.m13191b(injectorLike);
        accountRegistrationActivity.f838p = b;
        accountRegistrationActivity.f839q = a;
        accountRegistrationActivity.f840r = b2;
    }

    protected final void m1189b(Bundle bundle) {
        super.b(bundle);
        Class cls = AccountRegistrationActivity.class;
        m1185a((Object) this, (Context) this);
        setContentView(2130906795);
        FbTitleBarUtil.b(this);
        this.f841s = (FbTitleBar) findViewById(2131558563);
        this.f841s.a(new 1(this));
        this.f842t = (RegistrationFragmentController) kO_().a(2131566899);
        if (getIntent().hasExtra("extra_ref")) {
            this.f838p.m13152a(getIntent().getStringExtra("extra_ref"));
        } else {
            this.f838p.m13152a("no_ref");
        }
    }

    public void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1955638804);
        if (this.f839q != null) {
            this.f839q.b(FunnelRegistry.d);
        }
        super.onDestroy();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -468741716, a);
    }

    public void onBackPressed() {
        if (this.f842t.b()) {
            m1186b(this, "back_button");
        } else {
            this.f842t.e();
        }
    }

    public final void a_(String str) {
        this.f841s.setTitle(str);
    }

    public final void y_(int i) {
        this.f841s.setTitle(i);
    }

    public void setCustomTitle(View view) {
        this.f841s.setCustomTitleView(view);
        this.f843u = view;
    }

    public final View lh_() {
        return this.f843u;
    }

    public final void m1188a(TitleBarButtonSpec titleBarButtonSpec) {
    }

    public final void m1190b(TitleBarButtonSpec titleBarButtonSpec) {
    }

    public final void m1187a(OnToolbarButtonListener onToolbarButtonListener) {
    }

    public final void kg_() {
    }

    public final void m1191c(boolean z) {
    }

    public static Intent m1182a(Context context, String str) {
        Intent intent = new Intent(context, AccountRegistrationActivity.class);
        intent.putExtra("extra_ref", str);
        return intent;
    }

    public static void m1186b(AccountRegistrationActivity accountRegistrationActivity, String str) {
        boolean z = accountRegistrationActivity.f842t.ar() || accountRegistrationActivity.f840r.m13198a();
        accountRegistrationActivity.f840r.m13196a((Activity) accountRegistrationActivity, str, z);
    }
}
