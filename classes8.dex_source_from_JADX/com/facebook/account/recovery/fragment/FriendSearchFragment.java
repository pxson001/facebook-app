package com.facebook.account.recovery.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.facebook.account.recovery.logging.AccountRecoveryAnalyticsLogger;
import com.facebook.account.recovery.logging.AccountRecoveryAnalyticsLogger$EventType;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.keyboard.SmoothKeyboardFragmentBehavior;
import com.facebook.ui.search.SearchEditText;
import com.facebook.ui.search.SearchEditText.OnSubmitListener;
import com.facebook.widget.text.watcher.BaseTextWatcher;
import com.facebook.widget.titlebar.HasTitleBar;
import javax.inject.Inject;

/* compiled from: local_module_rank */
public class FriendSearchFragment extends FbFragment {
    @Inject
    public AccountRecoveryAnalyticsLogger f10267a;
    public SearchEditText f10268b;
    public Button f10269c;
    public View f10270d;
    public FriendSearchListener f10271e;
    public String f10272f;

    /* compiled from: local_module_rank */
    public class C10791 implements OnSubmitListener {
        final /* synthetic */ FriendSearchFragment f10264a;

        public C10791(FriendSearchFragment friendSearchFragment) {
            this.f10264a = friendSearchFragment;
        }

        public final void m12046a() {
            Object obj = this.f10264a.f10268b.getText().toString();
            if (!StringUtil.a(obj)) {
                this.f10264a.f10271e.a(this.f10264a.f10272f, obj);
            }
        }
    }

    /* compiled from: local_module_rank */
    public class C10802 implements OnClickListener {
        final /* synthetic */ FriendSearchFragment f10265a;

        public C10802(FriendSearchFragment friendSearchFragment) {
            this.f10265a = friendSearchFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 944844536);
            this.f10265a.f10268b.onEditorAction(this.f10265a.f10268b, 3, null);
            this.f10265a.f10269c.setVisibility(8);
            this.f10265a.f10270d.setVisibility(0);
            this.f10265a.f10268b.setEnabled(false);
            Logger.a(2, EntryType.UI_INPUT_END, 377147582, a);
        }
    }

    /* compiled from: local_module_rank */
    public class C10813 extends BaseTextWatcher {
        final /* synthetic */ FriendSearchFragment f10266a;

        public C10813(FriendSearchFragment friendSearchFragment) {
            this.f10266a = friendSearchFragment;
        }

        public void afterTextChanged(Editable editable) {
            if (this.f10266a.f10268b.getText().length() > 0) {
                this.f10266a.f10269c.setVisibility(0);
            } else {
                this.f10266a.f10269c.setVisibility(8);
            }
        }
    }

    public static void m12047a(Object obj, Context context) {
        ((FriendSearchFragment) obj).f10267a = AccountRecoveryAnalyticsLogger.a(FbInjector.get(context));
    }

    public final void m12051a(Activity activity) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 860329869);
        super.a(activity);
        try {
            this.f10271e = (FriendSearchListener) activity;
            LogUtils.f(662402921, a);
        } catch (ClassCastException e) {
            ClassCastException classCastException = new ClassCastException(activity.toString() + "must implement FriendSearchListener");
            LogUtils.f(1486428585, a);
            throw classCastException;
        }
    }

    public final void m12053c(Bundle bundle) {
        super.c(bundle);
        Class cls = FriendSearchFragment.class;
        m12047a((Object) this, getContext());
        a(new SmoothKeyboardFragmentBehavior());
    }

    public final View m12050a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1858151677);
        View inflate = layoutInflater.inflate(2130904491, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1529753325, a);
        return inflate;
    }

    public final void m12052a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f10268b = (SearchEditText) e(2131559176);
        this.f10269c = (Button) e(2131559181);
        this.f10270d = e(2131559183);
        if (this.s != null) {
            this.f10272f = this.s.getString("query");
        }
        AccountRecoveryAnalyticsLogger accountRecoveryAnalyticsLogger = this.f10267a;
        String str = this.f10272f;
        AnalyticsLogger analyticsLogger = accountRecoveryAnalyticsLogger.a;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(AccountRecoveryAnalyticsLogger$EventType.FRIEND_SEARCH_VIEWED.getEventName());
        honeyClientEvent.c = "account_recovery";
        analyticsLogger.b(honeyClientEvent.b("account_name", str), 1);
        this.f10268b.addTextChangedListener(new C10813(this));
        this.f10268b.f = new C10791(this);
        this.f10269c.setOnClickListener(new C10802(this));
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1302701841);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(2131239682);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1515359634, a);
    }

    public final void m12048G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -211379539);
        super.G();
        this.f10268b.b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1771916292, a);
    }

    public final void m12049H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1654588263);
        this.f10268b.c();
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 362685375, a);
    }
}
