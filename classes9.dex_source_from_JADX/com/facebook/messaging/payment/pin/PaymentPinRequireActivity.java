package com.facebook.messaging.payment.pin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import com.facebook.actionbar.ActionBarOwner;
import com.facebook.actionbar.AppCompatActivityOverrider;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.auth.annotations.ViewerContextUser;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.TriState;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.material.MessengerMaterialThemeUtil;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent;
import com.facebook.messaging.payment.connectivity.PaymentConnectivityDialogFactory;
import com.facebook.messaging.payment.pin.model.PaymentPin;
import com.facebook.messaging.payment.pin.params.PaymentPinProtectionsParams;
import com.facebook.messaging.payment.pin.protocol.PaymentPinProtocolUtil;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.user.model.User;
import com.facebook.widget.CustomViewPager;
import com.facebook.widget.titlebar.ActionBarBasedFbTitleBar;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: hasUnavailableAttachment */
public class PaymentPinRequireActivity extends FbFragmentActivity implements ActionBarOwner {
    public static final String f13614x = PaymentPinCreationActivity.class.getSimpleName();
    public LaunchMode f13615A;
    public long f13616B;
    public String f13617C;
    public PaymentPinProtectionsParams f13618D;
    public ListenableFuture<PaymentPin> f13619E;
    public ListenableFuture<PaymentPin> f13620F;
    public ListenableFuture<OperationResult> f13621G;
    public ListenableFuture<PaymentPin> f13622H;
    @Inject
    AppCompatActivityOverrider f13623p;
    @Inject
    @ForUiThread
    public Executor f13624q;
    @Inject
    SecureContextHelper f13625r;
    @Inject
    AnalyticsLogger f13626s;
    @Inject
    @ViewerContextUser
    public Provider<User> f13627t;
    @Inject
    public PaymentPinProtocolUtil f13628u;
    @Inject
    AbstractFbErrorReporter f13629v;
    @Inject
    public Toaster f13630w;
    public ProgressBar f13631y;
    public CustomViewPager f13632z;

    /* compiled from: hasUnavailableAttachment */
    public class C15222 implements PinInputListener {
        final /* synthetic */ PaymentPinRequireActivity f13598a;

        public C15222(PaymentPinRequireActivity paymentPinRequireActivity) {
            this.f13598a = paymentPinRequireActivity;
        }

        public final void mo530a(String str) {
            this.f13598a.f13617C = str;
            this.f13598a.f13632z.a(this.f13598a.f13632z.k + 1, true);
        }

        public final void mo529a() {
        }
    }

    /* compiled from: hasUnavailableAttachment */
    public class C15266 extends ResultFutureCallback<PaymentPin> {
        final /* synthetic */ PaymentPinRequireActivity f13605a;

        public C15266(PaymentPinRequireActivity paymentPinRequireActivity) {
            this.f13605a = paymentPinRequireActivity;
        }

        protected final void m14195a(Object obj) {
            PaymentPin paymentPin = (PaymentPin) obj;
            PaymentPinRequireActivity.m14213r(this.f13605a);
            if (paymentPin.m14261a().isPresent()) {
                PaymentPinRequireActivity.m14211n(this.f13605a);
                this.f13605a.f13616B = ((Long) paymentPin.m14261a().get()).longValue();
            } else {
                this.f13605a.f13615A = LaunchMode.CREATE_PIN;
            }
            PaymentPinRequireActivity.m14209j(this.f13605a);
        }

        protected final void m14194a(ServiceException serviceException) {
            PaymentPinRequireActivity.m14213r(this.f13605a);
            this.f13605a.f13629v.a("P2P_PAYMENT_PIN_FETCH_FAILED", "Payment PIN failed to fetch");
            PaymentConnectivityDialogFactory.a(this.f13605a, serviceException);
            this.f13605a.finish();
        }
    }

    /* compiled from: hasUnavailableAttachment */
    public class C15277 extends ResultFutureCallback<PaymentPin> {
        final /* synthetic */ PaymentPinFragment f13606a;
        final /* synthetic */ PaymentPinRequireActivity f13607b;

        public C15277(PaymentPinRequireActivity paymentPinRequireActivity, PaymentPinFragment paymentPinFragment) {
            this.f13607b = paymentPinRequireActivity;
            this.f13606a = paymentPinFragment;
        }

        protected final void m14197a(Object obj) {
            this.f13607b.f13630w.b(new ToastBuilder(2131241025));
            PaymentPinRequireActivity.m14204a(this.f13607b, this.f13606a, this.f13607b.f13617C, "p2p_pin_set");
        }

        protected final void m14196a(ServiceException serviceException) {
            this.f13606a.as();
            this.f13607b.f13626s.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_pin_set_fail"));
            BLog.b(PaymentPinRequireActivity.f13614x, "Fail to set payment PIN");
            this.f13606a.aq();
            PaymentConnectivityDialogFactory.a(this.f13607b, serviceException);
        }
    }

    /* compiled from: hasUnavailableAttachment */
    public class C15288 extends ResultFutureCallback<PaymentPin> {
        final /* synthetic */ PaymentPinFragment f13608a;
        final /* synthetic */ String f13609b;
        final /* synthetic */ PaymentPinRequireActivity f13610c;

        public C15288(PaymentPinRequireActivity paymentPinRequireActivity, PaymentPinFragment paymentPinFragment, String str) {
            this.f13610c = paymentPinRequireActivity;
            this.f13608a = paymentPinFragment;
            this.f13609b = str;
        }

        protected final void m14198a(ServiceException serviceException) {
            this.f13608a.as();
            this.f13610c.f13626s.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_pin_enter_fail"));
            this.f13608a.aq();
            if (PaymentPinFragment.m14176a(serviceException)) {
                PaymentPinRequireActivity.m14212o(this.f13610c);
            } else {
                this.f13608a.m14181b(serviceException);
            }
        }

        protected final void m14199a(Object obj) {
            PaymentPinRequireActivity.m14204a(this.f13610c, this.f13608a, this.f13609b, "p2p_pin_entered");
        }
    }

    /* compiled from: hasUnavailableAttachment */
    public class C15299 extends ResultFutureCallback<OperationResult> {
        final /* synthetic */ PaymentPinFragment f13611a;
        final /* synthetic */ String f13612b;
        final /* synthetic */ PaymentPinRequireActivity f13613c;

        public C15299(PaymentPinRequireActivity paymentPinRequireActivity, PaymentPinFragment paymentPinFragment, String str) {
            this.f13613c = paymentPinRequireActivity;
            this.f13611a = paymentPinFragment;
            this.f13612b = str;
        }

        protected final void m14200a(ServiceException serviceException) {
            this.f13611a.as();
            this.f13613c.f13626s.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_pin_status_update_fail"));
            this.f13611a.aq();
            if (PaymentPinFragment.m14176a(serviceException)) {
                PaymentPinRequireActivity.m14212o(this.f13613c);
            } else {
                this.f13611a.m14181b(serviceException);
            }
        }

        protected final void m14201a(Object obj) {
            PaymentPinRequireActivity.m14204a(this.f13613c, this.f13611a, this.f13612b, "p2p_pin_status_updated");
        }
    }

    /* compiled from: hasUnavailableAttachment */
    public enum LaunchMode {
        CREATE_PIN(2, false, false),
        VERIFY(1, true, false),
        UPDATE_PIN_STATUS(1, true, false),
        CREATE_OR_VERIFY(-1, true, true),
        CREATE_OR_UPDATE_PIN_STATUS(-1, true, true);
        
        public final boolean isConditionalFlow;
        public final boolean needFetchPin;
        public final int screenCount;

        private LaunchMode(int i, boolean z, boolean z2) {
            this.screenCount = i;
            this.needFetchPin = z;
            this.isConditionalFlow = z2;
        }
    }

    public static void m14205a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PaymentPinRequireActivity) obj).m14202a(AppCompatActivityOverrider.b(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 3596), PaymentPinProtocolUtil.m14279a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), Toaster.b(injectorLike));
    }

    private void m14202a(AppCompatActivityOverrider appCompatActivityOverrider, Executor executor, SecureContextHelper secureContextHelper, AnalyticsLogger analyticsLogger, Provider<User> provider, PaymentPinProtocolUtil paymentPinProtocolUtil, FbErrorReporter fbErrorReporter, Toaster toaster) {
        this.f13623p = appCompatActivityOverrider;
        this.f13624q = executor;
        this.f13625r = secureContextHelper;
        this.f13626s = analyticsLogger;
        this.f13627t = provider;
        this.f13628u = paymentPinProtocolUtil;
        this.f13629v = fbErrorReporter;
        this.f13630w = toaster;
    }

    protected final void m14215a(Bundle bundle) {
        MessengerMaterialThemeUtil.a(this, 2131625175);
        Class cls = PaymentPinRequireActivity.class;
        m14205a(this, this);
        a(this.f13623p);
    }

    protected final void m14217b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130906152);
        this.f13631y = (ProgressBar) findViewById(2131559418);
        this.f13626s.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_initiate_require_pin"));
        this.f13616B = -1;
        this.f13618D = (PaymentPinProtectionsParams) getIntent().getParcelableExtra("payment_pin_protections_params_extra");
        this.f13615A = (LaunchMode) getIntent().getSerializableExtra("launch_mode_extra");
        if (!this.f13615A.needFetchPin) {
            m14209j(this);
        } else if (m14206a(this.f13619E)) {
            this.f13631y.setVisibility(0);
            this.f13619E = this.f13628u.m14283a();
            Futures.a(this.f13619E, new C15266(this), this.f13624q);
        }
    }

    public final void m14216a(Fragment fragment) {
        super.a(fragment);
        if (fragment instanceof PaymentPinFragment) {
            m14203a((PaymentPinFragment) fragment);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("state_save_pin", this.f13617C);
        super.onSaveInstanceState(bundle);
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.f13617C = bundle.getString("state_save_pin");
    }

    public static void m14209j(PaymentPinRequireActivity paymentPinRequireActivity) {
        paymentPinRequireActivity.m14210k();
        paymentPinRequireActivity.f13632z = (CustomViewPager) paymentPinRequireActivity.a(2131565815);
        paymentPinRequireActivity.f13632z.a = false;
        paymentPinRequireActivity.f13632z.setAdapter(new FragmentPagerAdapter(paymentPinRequireActivity, paymentPinRequireActivity.kO_()) {
            final /* synthetic */ PaymentPinRequireActivity f13597a;

            public final int m14185b() {
                return this.f13597a.f13615A.screenCount;
            }

            public final Fragment m14184a(int i) {
                return PaymentPinRequireActivity.m14207b(this.f13597a, i);
            }
        });
    }

    private void m14210k() {
        int i;
        switch (this.f13615A) {
            case CREATE_PIN:
                i = 2131241022;
                break;
            case VERIFY:
            case UPDATE_PIN_STATUS:
                i = 2131241026;
                break;
            default:
                throw new IllegalArgumentException(StringFormatUtil.formatStrLocaleSafe("Unsupported flow type"));
        }
        new ActionBarBasedFbTitleBar(this, m14214a()).setTitle(i);
    }

    public static Fragment m14207b(PaymentPinRequireActivity paymentPinRequireActivity, int i) {
        switch (paymentPinRequireActivity.f13615A) {
            case CREATE_PIN:
                if (i == 0) {
                    paymentPinRequireActivity.f13626s.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_set_pin"));
                    return PaymentPinFragment.m14173a(paymentPinRequireActivity.getString(2131241023), 0, false);
                } else if (i == 1) {
                    return PaymentPinFragment.m14173a(paymentPinRequireActivity.getString(2131241024), 1, false);
                } else {
                    throw new IllegalArgumentException(StringFormatUtil.formatStrLocaleSafe("Position %d: Beyond payment pin adapter", Integer.valueOf(i)));
                }
            case VERIFY:
                paymentPinRequireActivity.f13626s.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_enter_pin"));
                return PaymentPinFragment.m14173a(paymentPinRequireActivity.getString(2131241028), 0, true);
            case UPDATE_PIN_STATUS:
                paymentPinRequireActivity.f13626s.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_pin_status_update"));
                return PaymentPinFragment.m14173a(paymentPinRequireActivity.getString(2131241028), 0, true);
            default:
                throw new IllegalArgumentException(StringFormatUtil.formatStrLocaleSafe("Unsupported launch mode for PaymentPinRequireActivity"));
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        menu.clear();
        return onCreateOptionsMenu;
    }

    public final ActionBar m14214a() {
        return this.f13623p.g();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    public void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -159074114);
        super.onDestroy();
        if (this.f13622H != null) {
            this.f13622H.cancel(true);
            this.f13622H = null;
        }
        if (this.f13620F != null) {
            this.f13620F.cancel(true);
            this.f13620F = null;
        }
        if (this.f13619E != null) {
            this.f13619E.cancel(true);
            this.f13619E = null;
        }
        if (this.f13621G != null) {
            this.f13621G.cancel(true);
            this.f13621G = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 138800686, a);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 0:
                if (i2 != -1 || intent == null) {
                    finish();
                    return;
                } else {
                    m14208b(intent.getStringExtra("user_entered_pin"));
                    return;
                }
            default:
                super.onActivityResult(i, i2, intent);
                return;
        }
    }

    private void m14203a(final PaymentPinFragment paymentPinFragment) {
        int e = paymentPinFragment.m14182e();
        switch (this.f13615A) {
            case CREATE_PIN:
                if (e == 0) {
                    paymentPinFragment.al = new C15222(this);
                    return;
                } else if (e == 1) {
                    paymentPinFragment.al = new PinInputListener(this) {
                        final /* synthetic */ PaymentPinRequireActivity f13600b;

                        public final void mo530a(String str) {
                            if (str.equals(this.f13600b.f13617C)) {
                                PaymentPinRequireActivity paymentPinRequireActivity = this.f13600b;
                                PaymentPinFragment paymentPinFragment = paymentPinFragment;
                                if (PaymentPinRequireActivity.m14206a(paymentPinRequireActivity.f13622H)) {
                                    TriState triState;
                                    Map map;
                                    long parseLong = Long.parseLong(((User) paymentPinRequireActivity.f13627t.get()).a);
                                    paymentPinFragment.ar();
                                    PaymentPinProtocolUtil paymentPinProtocolUtil = paymentPinRequireActivity.f13628u;
                                    String str2 = paymentPinRequireActivity.f13617C;
                                    if (paymentPinRequireActivity.f13618D == null) {
                                        triState = TriState.UNSET;
                                    } else {
                                        triState = paymentPinRequireActivity.f13618D.f13729b;
                                    }
                                    if (paymentPinRequireActivity.f13618D == null) {
                                        map = null;
                                    } else {
                                        map = paymentPinRequireActivity.f13618D.m14266b();
                                    }
                                    paymentPinRequireActivity.f13622H = paymentPinProtocolUtil.m14289a(str2, parseLong, triState, map);
                                    Futures.a(paymentPinRequireActivity.f13622H, new C15277(paymentPinRequireActivity, paymentPinFragment), paymentPinRequireActivity.f13624q);
                                }
                                return;
                            }
                            paymentPinFragment.aq();
                        }

                        public final void mo529a() {
                        }
                    };
                    return;
                } else {
                    return;
                }
            case VERIFY:
                paymentPinFragment.al = new PinInputListener(this) {
                    final /* synthetic */ PaymentPinRequireActivity f13602b;

                    public final void mo530a(String str) {
                        PaymentPinRequireActivity paymentPinRequireActivity = this.f13602b;
                        PaymentPinFragment paymentPinFragment = paymentPinFragment;
                        long j = this.f13602b.f13616B;
                        if (PaymentPinRequireActivity.m14206a(paymentPinRequireActivity.f13620F)) {
                            paymentPinFragment.ar();
                            paymentPinRequireActivity.f13620F = paymentPinRequireActivity.f13628u.m14284a(j, str);
                            Futures.a(paymentPinRequireActivity.f13620F, new C15288(paymentPinRequireActivity, paymentPinFragment, str), paymentPinRequireActivity.f13624q);
                        }
                    }

                    public final void mo529a() {
                        PaymentPinRequireActivity.m14212o(this.f13602b);
                    }
                };
                return;
            case UPDATE_PIN_STATUS:
                paymentPinFragment.al = new PinInputListener(this) {
                    final /* synthetic */ PaymentPinRequireActivity f13604b;

                    public final void mo530a(String str) {
                        PaymentPinRequireActivity paymentPinRequireActivity = this.f13604b;
                        PaymentPinFragment paymentPinFragment = paymentPinFragment;
                        long j = this.f13604b.f13616B;
                        if (PaymentPinRequireActivity.m14206a(paymentPinRequireActivity.f13621G)) {
                            paymentPinRequireActivity.f13621G = paymentPinRequireActivity.f13628u.m14285a(j, str, paymentPinRequireActivity.f13618D.f13729b, paymentPinRequireActivity.f13618D.m14266b());
                            Futures.a(paymentPinRequireActivity.f13621G, new C15299(paymentPinRequireActivity, paymentPinFragment, str), paymentPinRequireActivity.f13624q);
                        }
                    }

                    public final void mo529a() {
                        PaymentPinRequireActivity.m14212o(this.f13604b);
                    }
                };
                return;
            default:
                throw new IllegalArgumentException(StringFormatUtil.formatStrLocaleSafe("Unsupported launch mode for PaymentPinRequireActivity"));
        }
    }

    public static void m14211n(PaymentPinRequireActivity paymentPinRequireActivity) {
        if (paymentPinRequireActivity.f13615A.isConditionalFlow) {
            switch (paymentPinRequireActivity.f13615A) {
                case CREATE_OR_VERIFY:
                    paymentPinRequireActivity.f13615A = LaunchMode.VERIFY;
                    return;
                case CREATE_OR_UPDATE_PIN_STATUS:
                    paymentPinRequireActivity.f13615A = LaunchMode.UPDATE_PIN_STATUS;
                    return;
                default:
                    throw new IllegalArgumentException(StringFormatUtil.formatStrLocaleSafe("Unsupported launch mode for PaymentPinRequireActivity"));
            }
        }
    }

    public static void m14212o(PaymentPinRequireActivity paymentPinRequireActivity) {
        paymentPinRequireActivity.f13625r.a(PaymentPinResetActivity.m14230a(paymentPinRequireActivity, f13614x, null), 0, paymentPinRequireActivity);
    }

    public static void m14204a(PaymentPinRequireActivity paymentPinRequireActivity, PaymentPinFragment paymentPinFragment, String str, String str2) {
        paymentPinFragment.as();
        paymentPinRequireActivity.f13626s.a(P2pPaymentsLogEvent.c("p2p_settings", str2));
        paymentPinRequireActivity.m14208b(str);
    }

    private void m14208b(String str) {
        Intent intent = new Intent();
        intent.putExtra("user_entered_pin", str);
        setResult(-1, intent);
        finish();
    }

    public static void m14213r(PaymentPinRequireActivity paymentPinRequireActivity) {
        paymentPinRequireActivity.f13631y.setVisibility(8);
    }

    public static boolean m14206a(ListenableFuture listenableFuture) {
        return listenableFuture == null || listenableFuture.isDone();
    }
}
