package com.facebook.messaging.payment.pin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import com.facebook.actionbar.ActionBarOwner;
import com.facebook.actionbar.AppCompatActivityOverrider;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.material.MessengerMaterialThemeUtil;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent;
import com.facebook.messaging.payment.connectivity.PaymentConnectivityDialogFactory;
import com.facebook.messaging.payment.pin.model.PaymentPin;
import com.facebook.messaging.payment.pin.protocol.PaymentPinProtocolUtil;
import com.facebook.widget.titlebar.ActionBarBasedFbTitleBar;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: has_location */
public class PaymentPinConfirmActivity extends FbFragmentActivity implements ActionBarOwner {
    private static final Class<?> f13534p = PaymentPinConfirmActivity.class;
    private AppCompatActivityOverrider f13535q;
    public Executor f13536r;
    private SecureContextHelper f13537s;
    public AnalyticsLogger f13538t;
    public PaymentPinProtocolUtil f13539u;
    public AbstractFbErrorReporter f13540v;
    public ListenableFuture<PaymentPin> f13541w;
    public ListenableFuture<PaymentPin> f13542x;

    /* compiled from: has_location */
    public class C15022 extends ResultFutureCallback<PaymentPin> {
        final /* synthetic */ PaymentPinFragment f13528a;
        final /* synthetic */ String f13529b;
        final /* synthetic */ PaymentPinConfirmActivity f13530c;

        public C15022(PaymentPinConfirmActivity paymentPinConfirmActivity, PaymentPinFragment paymentPinFragment, String str) {
            this.f13530c = paymentPinConfirmActivity;
            this.f13528a = paymentPinFragment;
            this.f13529b = str;
        }

        protected final void m14129a(Object obj) {
            Object obj2;
            PaymentPin paymentPin = (PaymentPin) obj;
            this.f13528a.as();
            long longValue = paymentPin.m14261a().isPresent() ? ((Long) paymentPin.m14261a().get()).longValue() : -1;
            PaymentPinConfirmActivity paymentPinConfirmActivity = this.f13530c;
            String str = this.f13529b;
            PaymentPinFragment paymentPinFragment = this.f13528a;
            if (paymentPinConfirmActivity.f13542x == null || paymentPinConfirmActivity.f13542x.isDone()) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 != null) {
                paymentPinFragment.ar();
                paymentPinConfirmActivity.f13542x = paymentPinConfirmActivity.f13539u.m14284a(longValue, str);
                Futures.a(paymentPinConfirmActivity.f13542x, new C15033(paymentPinConfirmActivity, paymentPinFragment, str), paymentPinConfirmActivity.f13536r);
            }
        }

        protected final void m14128a(ServiceException serviceException) {
            this.f13528a.as();
            this.f13530c.f13540v.a("P2P_PAYMENT_PIN_FETCH_FAILED", "Payment PIN failed to fetch");
            this.f13528a.aq();
            PaymentConnectivityDialogFactory.a(this.f13530c, serviceException);
        }
    }

    /* compiled from: has_location */
    public class C15033 extends ResultFutureCallback<PaymentPin> {
        final /* synthetic */ PaymentPinFragment f13531a;
        final /* synthetic */ String f13532b;
        final /* synthetic */ PaymentPinConfirmActivity f13533c;

        public C15033(PaymentPinConfirmActivity paymentPinConfirmActivity, PaymentPinFragment paymentPinFragment, String str) {
            this.f13533c = paymentPinConfirmActivity;
            this.f13531a = paymentPinFragment;
            this.f13532b = str;
        }

        protected final void m14130a(ServiceException serviceException) {
            this.f13531a.as();
            this.f13533c.f13538t.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_pin_enter_fail"));
            this.f13531a.aq();
            if (PaymentPinFragment.m14176a(serviceException)) {
                PaymentPinConfirmActivity.m14136i(this.f13533c);
            } else {
                this.f13531a.m14181b(serviceException);
            }
        }

        protected final void m14131a(Object obj) {
            this.f13531a.as();
            this.f13533c.f13538t.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_pin_entered"));
            PaymentPinConfirmActivity.m14135b(this.f13533c, this.f13532b);
        }
    }

    public static void m14134a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PaymentPinConfirmActivity) obj).m14133a(AppCompatActivityOverrider.b(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), PaymentPinProtocolUtil.m14279a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    private void m14133a(AppCompatActivityOverrider appCompatActivityOverrider, Executor executor, SecureContextHelper secureContextHelper, AnalyticsLogger analyticsLogger, PaymentPinProtocolUtil paymentPinProtocolUtil, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f13535q = appCompatActivityOverrider;
        this.f13536r = executor;
        this.f13537s = secureContextHelper;
        this.f13538t = analyticsLogger;
        this.f13539u = paymentPinProtocolUtil;
        this.f13540v = abstractFbErrorReporter;
    }

    public static Intent m14132a(Context context) {
        Preconditions.checkNotNull(context);
        return new Intent(context, PaymentPinConfirmActivity.class);
    }

    public final void m14139a(Fragment fragment) {
        super.a(fragment);
        if (fragment instanceof PaymentPinFragment) {
            final PaymentPinFragment paymentPinFragment = (PaymentPinFragment) fragment;
            paymentPinFragment.al = new PinInputListener(this) {
                final /* synthetic */ PaymentPinConfirmActivity f13527b;

                public final void mo530a(String str) {
                    Object obj;
                    PaymentPinConfirmActivity paymentPinConfirmActivity = this.f13527b;
                    PaymentPinFragment paymentPinFragment = paymentPinFragment;
                    if (paymentPinConfirmActivity.f13541w == null || paymentPinConfirmActivity.f13541w.isDone()) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        paymentPinFragment.ar();
                        paymentPinConfirmActivity.f13541w = paymentPinConfirmActivity.f13539u.m14283a();
                        Futures.a(paymentPinConfirmActivity.f13541w, new C15022(paymentPinConfirmActivity, paymentPinFragment, str), paymentPinConfirmActivity.f13536r);
                    }
                }

                public final void mo529a() {
                    PaymentPinConfirmActivity.m14136i(this.f13527b);
                }
            };
        }
    }

    protected final void m14138a(Bundle bundle) {
        MessengerMaterialThemeUtil.a(this, 2131625175);
        Class cls = PaymentPinConfirmActivity.class;
        m14134a(this, this);
        a(this.f13535q);
    }

    protected final void m14140b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130904413);
        this.f13538t.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_initiate_verify_pin"));
        new ActionBarBasedFbTitleBar(this, m14137a()).setTitle(2131241026);
        FragmentManager kO_ = kO_();
        PaymentPinFragment a = PaymentPinFragment.m14173a(getString(2131241028), 0, true);
        this.f13538t.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_enter_pin"));
        kO_.a().a(2131560203, a).b();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        menu.clear();
        return onCreateOptionsMenu;
    }

    public final ActionBar m14137a() {
        return this.f13535q.g();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    public void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 719269418);
        super.onDestroy();
        if (this.f13542x != null) {
            this.f13542x.cancel(true);
            this.f13542x = null;
        }
        if (this.f13541w != null) {
            this.f13541w.cancel(true);
            this.f13541w = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 775766847, a);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 0:
                if (i2 != -1 || intent == null) {
                    finish();
                    return;
                } else {
                    m14135b(this, intent.getStringExtra("user_entered_pin"));
                    return;
                }
            default:
                super.onActivityResult(i, i2, intent);
                return;
        }
    }

    public static void m14135b(PaymentPinConfirmActivity paymentPinConfirmActivity, String str) {
        Intent intent = new Intent();
        intent.putExtra("user_entered_pin", str);
        paymentPinConfirmActivity.setResult(-1, intent);
        paymentPinConfirmActivity.finish();
    }

    public static void m14136i(PaymentPinConfirmActivity paymentPinConfirmActivity) {
        paymentPinConfirmActivity.f13537s.a(PaymentPinResetActivity.m14230a(paymentPinConfirmActivity, f13534p.getSimpleName(), null), 0, paymentPinConfirmActivity);
    }
}
