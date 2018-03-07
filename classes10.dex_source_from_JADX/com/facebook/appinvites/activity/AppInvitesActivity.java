package com.facebook.appinvites.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.actionbar.ActionBarOwner;
import com.facebook.actionbar.AppCompatActivityOverrider;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.appinvites.fragment.AppInvitesFragment;
import com.facebook.appinvites.fragment.AppInvitesSettingsFragment;
import com.facebook.appinvites.logging.AppInvitesLoggingHelper;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.titlebar.ActionBarBasedFbTitleBar;
import com.facebook.widget.titlebar.FbActionBarUtil;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: email_for_alerts */
public class AppInvitesActivity extends FbFragmentActivity implements ActionBarOwner {
    private boolean f14533p;
    private AppCompatActivityOverrider f14534q;
    private Provider<AppCompatActivityOverrider> f14535r;
    private Provider<Boolean> f14536s;
    public AppInvitesLoggingHelper f14537t;
    private FbTitleBar f14538u;

    /* compiled from: email_for_alerts */
    class C20261 implements OnClickListener {
        final /* synthetic */ AppInvitesActivity f14531a;

        C20261(AppInvitesActivity appInvitesActivity) {
            this.f14531a = appInvitesActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -456111591);
            this.f14531a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, 238090625, a);
        }
    }

    /* compiled from: email_for_alerts */
    class C20272 extends OnToolbarButtonListener {
        final /* synthetic */ AppInvitesActivity f14532a;

        C20272(AppInvitesActivity appInvitesActivity) {
            this.f14532a = appInvitesActivity;
        }

        public final void m14703a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            this.f14532a.f14537t.f14610a.a(AppInvitesLoggingHelper.m14766b("app_invite_setting_button_did_tapped"));
            this.f14532a.m14710i();
        }
    }

    private static <T extends Context> void m14706a(Class<T> cls, T t) {
        m14707a((Object) t, (Context) t);
    }

    public static void m14707a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((AppInvitesActivity) obj).m14708a(IdBasedProvider.a(injectorLike, 3896), FbActionBarUtil.a(injectorLike), IdBasedProvider.a(injectorLike, 4577), AppInvitesLoggingHelper.m14767b(injectorLike));
    }

    @Inject
    private void m14708a(Provider<Boolean> provider, FbActionBarUtil fbActionBarUtil, Provider<AppCompatActivityOverrider> provider2, AppInvitesLoggingHelper appInvitesLoggingHelper) {
        this.f14536s = provider;
        this.f14533p = fbActionBarUtil.a();
        this.f14535r = provider2;
        this.f14537t = appInvitesLoggingHelper;
    }

    protected final void m14712a(Bundle bundle) {
        super.a(bundle);
        Class cls = AppInvitesActivity.class;
        m14707a((Object) this, (Context) this);
        if (this.f14533p) {
            this.f14534q = (AppCompatActivityOverrider) this.f14535r.get();
            a(this.f14534q);
        }
    }

    protected final void m14713b(Bundle bundle) {
        super.b(bundle);
        if (((Boolean) this.f14536s.get()).booleanValue()) {
            setContentView(2130903285);
            if (this.f14533p) {
                this.f14538u = new ActionBarBasedFbTitleBar(this, this.f14534q.g());
            } else {
                FbTitleBarUtil.b(this);
                this.f14538u = (FbTitleBar) a(2131558563);
            }
            this.f14538u.setHasFbLogo(true);
            this.f14538u.a(new C20261(this));
            kO_().a().a(2131559684, new AppInvitesFragment()).b();
            m14709b(false);
            String str = "unknown";
            Intent intent = getIntent();
            String str2 = "extra_launch_uri";
            if (intent.getExtras() != null && intent.getExtras().containsKey(str2)) {
                Uri parse = Uri.parse(intent.getExtras().getString(str2));
                if (parse.getQueryParameter("source") != null) {
                    str = parse.getQueryParameter("source");
                }
            }
            AppInvitesLoggingHelper appInvitesLoggingHelper = this.f14537t;
            HoneyClientEvent b = AppInvitesLoggingHelper.m14766b("app_invite_view_did_show");
            b.b("openingSource", str);
            appInvitesLoggingHelper.f14610a.a(b);
            return;
        }
        finish();
    }

    public void onBackPressed() {
        m14709b(false);
        super.onBackPressed();
    }

    public final ActionBar m14711a() {
        if (this.f14533p) {
            return this.f14534q.g();
        }
        return null;
    }

    private void m14710i() {
        m14709b(true);
        kO_().a().a(2130968649, 2130968694, 2130968648, 2130968695).a(2131559684, new AppInvitesSettingsFragment()).a(null).b();
    }

    private void m14709b(boolean z) {
        if (this.f14538u != null) {
            if (z) {
                this.f14538u.setTitle(2131241816);
                this.f14538u.setButtonSpecs(RegularImmutableList.a);
                return;
            }
            this.f14538u.setTitle(2131241792);
            FbTitleBar fbTitleBar = this.f14538u;
            Builder a = TitleBarButtonSpec.a();
            a.i = 2130840543;
            fbTitleBar.setButtonSpecs(ImmutableList.of(a.a()));
            this.f14538u.setOnToolbarButtonListener(new C20272(this));
        }
    }
}
