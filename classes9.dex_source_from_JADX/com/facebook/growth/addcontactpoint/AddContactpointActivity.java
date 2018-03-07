package com.facebook.growth.addcontactpoint;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android_src.telephony.PhoneNumberFormattingTextWatcher;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.api.growth.UserSetContactInfoMethod.Params;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.confirmation.task.BackgroundConfirmationHelper;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.growth.logging.GrowthAnalyticsLogger;
import com.facebook.growth.logging.GrowthLoggingEventType;
import com.facebook.growth.model.Contactpoint;
import com.facebook.growth.util.DeviceContactpointUtil;
import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.errordialog.ErrorMessageGenerator;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.user.util.UserPhoneNumberUtil;
import com.facebook.widget.countryspinner.CountrySpinner;
import com.facebook.widget.text.watcher.BaseTextWatcher;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.Futures;
import javax.inject.Inject;

/* compiled from: payment_account_enabled_status */
public class AddContactpointActivity extends FbFragmentActivity {
    private String f7062A = null;
    @Inject
    DefaultBlueServiceOperationFactory f7063p;
    @Inject
    DeviceContactpointUtil f7064q;
    @Inject
    ErrorMessageGenerator f7065r;
    @Inject
    GrowthAnalyticsLogger f7066s;
    @Inject
    Lazy<BackgroundConfirmationHelper> f7067t;
    @Inject
    Toaster f7068u;
    @Inject
    UserPhoneNumberUtil f7069v;
    public EditText f7070w;
    public CountrySpinner f7071x;
    public Button f7072y;
    public String f7073z;

    /* compiled from: payment_account_enabled_status */
    class C07431 implements OnItemSelectedListener {
        PhoneNumberFormattingTextWatcher f7056a;
        final /* synthetic */ AddContactpointActivity f7057b;

        C07431(AddContactpointActivity addContactpointActivity) {
            this.f7057b = addContactpointActivity;
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            String selectedCountryIsoCode = this.f7057b.f7071x.getSelectedCountryIsoCode();
            this.f7057b.f7070w.removeTextChangedListener(this.f7056a);
            this.f7056a = new PhoneNumberFormattingTextWatcher(selectedCountryIsoCode, this.f7057b);
            this.f7057b.f7070w.addTextChangedListener(this.f7056a);
            AddContactpointActivity.m7346c(this.f7057b, selectedCountryIsoCode);
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* compiled from: payment_account_enabled_status */
    class C07442 extends BaseTextWatcher {
        final /* synthetic */ AddContactpointActivity f7058a;

        C07442(AddContactpointActivity addContactpointActivity) {
            this.f7058a = addContactpointActivity;
        }

        public void afterTextChanged(Editable editable) {
            Boolean valueOf = Boolean.valueOf(this.f7058a.f7070w.getText().length() > 0);
            this.f7058a.f7072y.setEnabled(valueOf.booleanValue());
            this.f7058a.f7072y.setAlpha(valueOf.booleanValue() ? 1.0f : 0.5f);
        }
    }

    /* compiled from: payment_account_enabled_status */
    class C07463 implements OnClickListener {
        final /* synthetic */ AddContactpointActivity f7061a;

        C07463(AddContactpointActivity addContactpointActivity) {
            this.f7061a = addContactpointActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1290104102);
            if (this.f7061a.f7070w == null || this.f7061a.f7070w.getText() == null || Strings.isNullOrEmpty(this.f7061a.f7070w.getText().toString())) {
                Logger.a(2, EntryType.UI_INPUT_END, -1666051298, a);
                return;
            }
            String obj = this.f7061a.f7070w.getText().toString();
            boolean z = this.f7061a.f7073z != null && this.f7061a.f7073z.equals(obj);
            this.f7061a.m7342a(this.f7061a.f7070w.getText().toString(), z);
            KeyboardUtils.a(this.f7061a);
            String c = this.f7061a.f7069v.c(this.f7061a.f7071x.getSelectedCountryDialingCode() + obj);
            final Contactpoint a2 = Contactpoint.a(c, this.f7061a.f7071x.getSelectedCountryIsoCode());
            Parcelable params = new Params(c, false);
            Bundle bundle = new Bundle();
            bundle.putParcelable("growthUserSetContactInfoParamsKey", params);
            Futures.a(BlueServiceOperationFactoryDetour.a(this.f7061a.f7063p, "growth_user_set_contact_info", bundle, 1574733006).a(new DialogBasedProgressIndicator(this.f7061a, 2131230757)).a(), new OperationResultFutureCallback(this) {
                final /* synthetic */ C07463 f7060b;

                protected final void m7332a(ServiceException serviceException) {
                    this.f7060b.f7061a.m7336a(serviceException);
                    this.f7060b.f7061a.f7068u.b(new ToastBuilder(this.f7060b.f7061a.f7065r.a(serviceException, true, true)));
                }

                protected final void m7333a(Object obj) {
                    AddContactpointActivity.m7357q(this.f7060b.f7061a);
                    ((BackgroundConfirmationHelper) this.f7060b.f7061a.f7067t.get()).a(a2);
                    this.f7060b.f7061a.finish();
                }
            });
            LogUtils.a(-1204710581, a);
        }
    }

    private static <T extends Context> void m7340a(Class<T> cls, T t) {
        m7341a((Object) t, (Context) t);
    }

    public static void m7341a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((AddContactpointActivity) obj).m7335a(DefaultBlueServiceOperationFactory.b(fbInjector), DeviceContactpointUtil.b(fbInjector), ErrorMessageGenerator.b(fbInjector), GrowthAnalyticsLogger.b(fbInjector), IdBasedLazy.a(fbInjector, 882), Toaster.b(fbInjector), UserPhoneNumberUtil.a(fbInjector));
    }

    private void m7335a(BlueServiceOperationFactory blueServiceOperationFactory, DeviceContactpointUtil deviceContactpointUtil, ErrorMessageGenerator errorMessageGenerator, GrowthAnalyticsLogger growthAnalyticsLogger, Lazy<BackgroundConfirmationHelper> lazy, Toaster toaster, UserPhoneNumberUtil userPhoneNumberUtil) {
        this.f7063p = blueServiceOperationFactory;
        this.f7064q = deviceContactpointUtil;
        this.f7065r = errorMessageGenerator;
        this.f7066s = growthAnalyticsLogger;
        this.f7067t = lazy;
        this.f7068u = toaster;
        this.f7069v = userPhoneNumberUtil;
    }

    public final void m7358b(Bundle bundle) {
        super.b(bundle);
        Class cls = AddContactpointActivity.class;
        m7341a((Object) this, (Context) this);
        setContentView(2130903159);
        if (getIntent().getExtras() != null) {
            this.f7062A = getIntent().getExtras().getString("launch_point");
        }
        if (this.f7062A == null) {
            this.f7062A = "quick_promotion_phone_acquisition";
        }
        FbTitleBarUtil.b(this);
        ((FbTitleBar) a(2131558563)).setTitle(2131236430);
        CharSequence l = m7352l();
        TextView textView = (TextView) a(2131559358);
        textView.setText(l);
        textView.setContentDescription(l);
        l = m7353m();
        this.f7070w = (EditText) a(2131559359);
        this.f7070w.setHint(l);
        this.f7070w.setContentDescription(l);
        this.f7070w.setInputType(3);
        this.f7070w.addTextChangedListener(m7355o());
        this.f7071x = (CountrySpinner) a(2131559360);
        this.f7071x.setOnItemSelectedListener(m7350j());
        this.f7072y = (Button) a(2131559361);
        this.f7072y.setOnClickListener(m7356p());
        this.f7072y.setEnabled(false);
        this.f7072y.setAlpha(0.5f);
        m7354n();
        m7344b(this.f7062A);
        getWindow().setSoftInputMode(4);
    }

    private static int m7349i() {
        return 3;
    }

    private OnItemSelectedListener m7350j() {
        return new C07431(this);
    }

    private static int m7351k() {
        return 2131236430;
    }

    private String m7352l() {
        return getResources().getString(2131236431);
    }

    private String m7353m() {
        return getResources().getString(2131236432);
    }

    private void m7354n() {
        this.f7073z = this.f7064q.a();
        if (!Strings.isNullOrEmpty(this.f7073z)) {
            this.f7070w.setText(this.f7069v.d(this.f7073z));
        }
    }

    private BaseTextWatcher m7355o() {
        return new C07442(this);
    }

    private OnClickListener m7356p() {
        return new C07463(this);
    }

    private void m7344b(String str) {
        HoneyClientEventFast a = this.f7066s.a.a(GrowthLoggingEventType.ADD_CONTACTPOINT_FLOW_ENTER.getAnalyticsName(), true);
        if (a.a()) {
            a.a("growth");
            a.a("launch_point", str);
            a.b();
        }
    }

    public static void m7346c(AddContactpointActivity addContactpointActivity, String str) {
        HoneyClientEventFast a = addContactpointActivity.f7066s.a.a(GrowthLoggingEventType.ADD_CONTACTPOINT_COUNTRY_SELECTED.getAnalyticsName(), true);
        if (a.a()) {
            a.a("growth");
            a.a("country_selected", str);
            a.b();
        }
    }

    private void m7342a(String str, boolean z) {
        HoneyClientEventFast a = this.f7066s.a.a(GrowthLoggingEventType.ADD_CONTACTPOINT_ATTEMPT.getAnalyticsName(), true);
        if (a.a()) {
            a.a("growth");
            a.a("phone_number_added", str);
            a.a("phone_number_changed", z);
            a.b();
        }
    }

    private void m7336a(ServiceException serviceException) {
        HoneyClientEventFast a = this.f7066s.a.a(GrowthLoggingEventType.ADD_CONTACTPOINT_FAILURE.getAnalyticsName(), true);
        if (a.a()) {
            int i;
            a.a("growth");
            String str = "error_code";
            if (serviceException == null) {
                i = -1;
            } else {
                OperationResult operationResult = serviceException.result;
                if (operationResult == null) {
                    i = -1;
                } else {
                    ApiErrorResult apiErrorResult = (ApiErrorResult) operationResult.c("result");
                    i = apiErrorResult == null ? -1 : apiErrorResult.a();
                }
            }
            a.a(str, i);
            a.b();
        }
    }

    public static void m7357q(AddContactpointActivity addContactpointActivity) {
        HoneyClientEventFast a = addContactpointActivity.f7066s.a.a(GrowthLoggingEventType.ADD_CONTACTPOINT_SUCCESS.getAnalyticsName(), true);
        if (a.a()) {
            a.a("growth");
            a.b();
        }
    }
}
