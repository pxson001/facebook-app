package com.facebook.account.recovery.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.account.recovery.logging.AccountRecoveryAnalyticsLogger;
import com.facebook.account.recovery.logging.AccountRecoveryAnalyticsLogger$EventType;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.fragment.FbFragment;
import com.facebook.fbui.widget.contentview.CheckedContentView;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.titlebar.HasTitleBar;
import javax.inject.Inject;

/* compiled from: local_content_upload_message */
public class LogoutFragment extends FbFragment {
    @Inject
    public AccountRecoveryAnalyticsLogger f10276a;
    public LogoutListener f10277b;
    public CheckedContentView f10278c;
    public CheckedContentView f10279d;
    public TextView f10280e;
    public String f10281f;

    /* compiled from: local_content_upload_message */
    public class C10821 implements OnClickListener {
        final /* synthetic */ LogoutFragment f10273a;

        public C10821(LogoutFragment logoutFragment) {
            this.f10273a = logoutFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 848458854);
            if (!this.f10273a.f10278c.isChecked()) {
                this.f10273a.f10278c.setChecked(true);
                this.f10273a.f10278c.setCheckMarkDrawable(2130840069);
                this.f10273a.f10279d.setChecked(false);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -850930871, a);
        }
    }

    /* compiled from: local_content_upload_message */
    public class C10832 implements OnClickListener {
        final /* synthetic */ LogoutFragment f10274a;

        public C10832(LogoutFragment logoutFragment) {
            this.f10274a = logoutFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 78541582);
            if (!this.f10274a.f10279d.isChecked()) {
                this.f10274a.f10279d.setChecked(true);
                this.f10274a.f10279d.setCheckMarkDrawable(2130840069);
                this.f10274a.f10278c.setChecked(false);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1560054460, a);
        }
    }

    /* compiled from: local_content_upload_message */
    public class C10843 implements OnClickListener {
        final /* synthetic */ LogoutFragment f10275a;

        public C10843(LogoutFragment logoutFragment) {
            this.f10275a = logoutFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2032179277);
            boolean isChecked = this.f10275a.f10278c.isChecked();
            AccountRecoveryAnalyticsLogger accountRecoveryAnalyticsLogger = this.f10275a.f10276a;
            String str = this.f10275a.f10281f;
            AnalyticsLogger analyticsLogger = accountRecoveryAnalyticsLogger.a;
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent(AccountRecoveryAnalyticsLogger$EventType.LOGOUT_OPTION_SELECTED.getEventName());
            honeyClientEvent.c = "account_recovery";
            analyticsLogger.b(honeyClientEvent.b("crypted_id", str).a("logout", isChecked), 1);
            this.f10275a.f10277b.b(isChecked);
            Logger.a(2, EntryType.UI_INPUT_END, 55256965, a);
        }
    }

    public static void m12054a(Object obj, Context context) {
        ((LogoutFragment) obj).f10276a = AccountRecoveryAnalyticsLogger.a(FbInjector.get(context));
    }

    public final void m12058c(Bundle bundle) {
        super.c(bundle);
        Class cls = LogoutFragment.class;
        m12054a((Object) this, getContext());
    }

    public final View m12055a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 237043981);
        View inflate = layoutInflater.inflate(2130905145, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1284768338, a);
        return inflate;
    }

    public final void m12057a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f10278c = (CheckedContentView) e(2131563646);
        this.f10279d = (CheckedContentView) e(2131563645);
        this.f10280e = (TextView) e(2131559172);
        this.f10278c.setShowThumbnail(false);
        this.f10279d.setShowThumbnail(false);
        if (this.s != null) {
            this.f10281f = this.s.getString("account_secret_id");
        }
        this.f10278c.setOnClickListener(new C10821(this));
        this.f10279d.setOnClickListener(new C10832(this));
        this.f10280e.setOnClickListener(new C10843(this));
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1738605568);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(2131239724);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 48617295, a);
    }

    public final void m12056a(Activity activity) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1671366422);
        super.a(activity);
        try {
            this.f10277b = (LogoutListener) activity;
            LogUtils.f(1543544715, a);
        } catch (ClassCastException e) {
            ClassCastException classCastException = new ClassCastException(activity.toString() + " must implement LogoutListener");
            LogUtils.f(950131076, a);
            throw classCastException;
        }
    }
}
