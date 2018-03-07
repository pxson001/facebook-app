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
import android.widget.TextView;
import com.facebook.account.recovery.logging.AccountRecoveryAnalyticsLogger;
import com.facebook.account.recovery.logging.AccountRecoveryAnalyticsLogger$EventType;
import com.facebook.account.recovery.protocol.AccountRecoveryValidateCodeMethod.Params;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.search.SearchEditText;
import com.facebook.ui.search.SearchEditText.OnSubmitListener;
import com.facebook.widget.text.watcher.BaseTextWatcher;
import com.facebook.widget.titlebar.HasTitleBar;
import javax.inject.Inject;
import org.json.JSONObject;

/* compiled from: local_content_secondary_upload_message */
public class ResetPasswordFragment extends FbFragment {
    @Inject
    public DefaultBlueServiceOperationFactory f10287a;
    public boolean al;
    public OnPasswordResetListener am;
    @Inject
    public TasksManager f10288b;
    @Inject
    public AccountRecoveryAnalyticsLogger f10289c;
    public SearchEditText f10290d;
    public TextView f10291e;
    public Button f10292f;
    public View f10293g;
    public String f10294h;
    public String f10295i;

    /* compiled from: local_content_secondary_upload_message */
    public class C10851 implements OnSubmitListener {
        final /* synthetic */ ResetPasswordFragment f10282a;

        public C10851(ResetPasswordFragment resetPasswordFragment) {
            this.f10282a = resetPasswordFragment;
        }

        public final void m12059a() {
            String obj = this.f10282a.f10290d.getText().toString();
            if (!StringUtil.a(obj)) {
                if (obj.length() < 6) {
                    this.f10282a.m12065b(this.f10282a.b(2131239736));
                    return;
                }
                ResetPasswordFragment resetPasswordFragment = this.f10282a;
                AccountRecoveryAnalyticsLogger accountRecoveryAnalyticsLogger = resetPasswordFragment.f10289c;
                String str = resetPasswordFragment.f10294h;
                AnalyticsLogger analyticsLogger = accountRecoveryAnalyticsLogger.a;
                HoneyClientEvent honeyClientEvent = new HoneyClientEvent(AccountRecoveryAnalyticsLogger$EventType.CHANGE_PASSWORD_SUBMITTED.getEventName());
                honeyClientEvent.c = "account_recovery";
                analyticsLogger.b(honeyClientEvent.b("crypted_id", str), 1);
                Bundle bundle = new Bundle();
                bundle.putParcelable("accountRecoveryValidateCodeParamsKey", new Params(resetPasswordFragment.f10294h, resetPasswordFragment.f10295i, obj, resetPasswordFragment.al));
                resetPasswordFragment.f10288b.a(null, BlueServiceOperationFactoryDetour.a(resetPasswordFragment.f10287a, "account_recovery_validate_code", bundle, ErrorPropagation.BY_ERROR_CODE, CallerContext.a(ResetPasswordFragment.class), -1210070206).a(), new C10884(resetPasswordFragment, obj));
                this.f10282a.f10291e.setVisibility(8);
                this.f10282a.f10292f.setVisibility(8);
                this.f10282a.f10293g.setVisibility(0);
            }
        }
    }

    /* compiled from: local_content_secondary_upload_message */
    public class C10862 implements OnClickListener {
        final /* synthetic */ ResetPasswordFragment f10283a;

        public C10862(ResetPasswordFragment resetPasswordFragment) {
            this.f10283a = resetPasswordFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1359946977);
            this.f10283a.f10290d.onEditorAction(this.f10283a.f10290d, 3, null);
            Logger.a(2, EntryType.UI_INPUT_END, -225207938, a);
        }
    }

    /* compiled from: local_content_secondary_upload_message */
    public class C10873 extends BaseTextWatcher {
        final /* synthetic */ ResetPasswordFragment f10284a;

        public C10873(ResetPasswordFragment resetPasswordFragment) {
            this.f10284a = resetPasswordFragment;
        }

        public void afterTextChanged(Editable editable) {
            if (this.f10284a.f10290d.getText().length() > 0) {
                this.f10284a.f10292f.setVisibility(0);
                this.f10284a.f10291e.setVisibility(8);
                return;
            }
            this.f10284a.f10292f.setVisibility(8);
            this.f10284a.f10293g.setVisibility(8);
            this.f10284a.f10291e.setText(this.f10284a.b(2131239735));
            this.f10284a.f10291e.setTextColor(this.f10284a.jW_().getColor(2131361936));
            this.f10284a.f10291e.setVisibility(0);
        }
    }

    /* compiled from: local_content_secondary_upload_message */
    public class C10884 extends OperationResultFutureCallback {
        final /* synthetic */ String f10285a;
        final /* synthetic */ ResetPasswordFragment f10286b;

        public C10884(ResetPasswordFragment resetPasswordFragment, String str) {
            this.f10286b = resetPasswordFragment;
            this.f10285a = str;
        }

        protected final void m12061a(Object obj) {
            String str;
            OperationResult operationResult = (OperationResult) obj;
            AccountRecoveryAnalyticsLogger accountRecoveryAnalyticsLogger = this.f10286b.f10289c;
            String str2 = this.f10286b.f10294h;
            AnalyticsLogger analyticsLogger = accountRecoveryAnalyticsLogger.a;
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent(AccountRecoveryAnalyticsLogger$EventType.RECOVERY_SUCCESS.getEventName());
            honeyClientEvent.c = "account_recovery";
            analyticsLogger.b(honeyClientEvent.b("crypted_id", str2), 1);
            if (operationResult == null) {
                str = null;
            } else {
                str = operationResult.c;
            }
            this.f10286b.am.c(str, this.f10285a);
        }

        protected final void m12060a(ServiceException serviceException) {
            ResetPasswordFragment.m12062a(this.f10286b, serviceException);
        }
    }

    public static void m12064a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ResetPasswordFragment resetPasswordFragment = (ResetPasswordFragment) obj;
        DefaultBlueServiceOperationFactory b = DefaultBlueServiceOperationFactory.b(fbInjector);
        TasksManager b2 = TasksManager.b(fbInjector);
        AccountRecoveryAnalyticsLogger a = AccountRecoveryAnalyticsLogger.a(fbInjector);
        resetPasswordFragment.f10287a = b;
        resetPasswordFragment.f10288b = b2;
        resetPasswordFragment.f10289c = a;
    }

    public final void m12070c(Bundle bundle) {
        super.c(bundle);
        Class cls = ResetPasswordFragment.class;
        m12064a((Object) this, getContext());
    }

    public final View m12067a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 239971724);
        View inflate = layoutInflater.inflate(2130906834, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2103494169, a);
        return inflate;
    }

    public final void m12069a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f10290d = (SearchEditText) e(2131566980);
        this.f10291e = (TextView) e(2131566981);
        this.f10292f = (Button) e(2131566982);
        this.f10293g = e(2131566983);
        if (this.s != null) {
            this.f10294h = this.s.getString("account_secret_id");
            this.f10295i = this.s.getString("account_confirmation_code");
            this.al = this.s.getBoolean("account_logout");
        }
        this.f10290d.addTextChangedListener(new C10873(this));
        this.f10290d.f = new C10851(this);
        this.f10292f.setOnClickListener(new C10862(this));
        AccountRecoveryAnalyticsLogger accountRecoveryAnalyticsLogger = this.f10289c;
        String str = this.f10294h;
        AnalyticsLogger analyticsLogger = accountRecoveryAnalyticsLogger.a;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(AccountRecoveryAnalyticsLogger$EventType.CHANGE_PASSWORD_VIEWED.getEventName());
        honeyClientEvent.c = "account_recovery";
        analyticsLogger.b(honeyClientEvent.b("crypted_id", str), 1);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 183172075);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(2131239731);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -78788748, a);
    }

    public final void m12066H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -981366223);
        this.f10290d.c();
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1236223844, a);
    }

    public final void m12068a(Activity activity) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -720901833);
        super.a(activity);
        try {
            this.am = (OnPasswordResetListener) activity;
            LogUtils.f(-1474519957, a);
        } catch (ClassCastException e) {
            ClassCastException classCastException = new ClassCastException(activity.toString() + " must implement OnPasswordResetListener");
            LogUtils.f(-1996757355, a);
            throw classCastException;
        }
    }

    public static void m12062a(ResetPasswordFragment resetPasswordFragment, ServiceException serviceException) {
        String localizedMessage = serviceException.b().e().getLocalizedMessage();
        try {
            resetPasswordFragment.m12065b(new JSONObject(localizedMessage.substring(localizedMessage.indexOf("\n") + 1)).getJSONObject("error").getString("error_user_title"));
        } catch (Throwable e) {
            BLog.b("ResetPasswordFragment", "inconceivable JSON exception", e);
        }
    }

    private void m12065b(String str) {
        this.f10291e.setText(str);
        this.f10291e.setTextColor(jW_().getColor(2131361918));
        this.f10291e.setVisibility(0);
        this.f10292f.setVisibility(8);
        this.f10293g.setVisibility(8);
    }
}
