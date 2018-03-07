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
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.material.MessengerMaterialThemeUtil;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent;
import com.facebook.messaging.payment.connectivity.PaymentConnectivityDialogFactory;
import com.facebook.messaging.payment.pin.PaymentPinSyncControllerFragment.Callback;
import com.facebook.messaging.payment.pin.model.PaymentPin;
import com.facebook.messaging.payment.pin.protocol.PaymentPinProtocolUtil;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.titlebar.ActionBarBasedFbTitleBar;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: has_drawing */
public class PaymentPinDeletionActivity extends FbFragmentActivity implements ActionBarOwner {
    private static final Class<?> f13568p = PaymentPinDeletionActivity.class;
    private AppCompatActivityOverrider f13569q;
    public AbstractFbErrorReporter f13570r;
    public Executor f13571s;
    public PaymentPinProtocolUtil f13572t;
    public SecureContextHelper f13573u;
    public AnalyticsLogger f13574v;
    public Toaster f13575w;
    public ListenableFuture<PaymentPin> f13576x;
    public ListenableFuture<OperationResult> f13577y;

    /* compiled from: has_drawing */
    public class C15091 implements Callback {
        final /* synthetic */ PaymentPinDeletionActivity f13560a;

        public C15091(PaymentPinDeletionActivity paymentPinDeletionActivity) {
            this.f13560a = paymentPinDeletionActivity;
        }

        public final void mo531a() {
            this.f13560a.setResult(-1);
            this.f13560a.finish();
        }
    }

    /* compiled from: has_drawing */
    public class C15113 extends ResultFutureCallback<PaymentPin> {
        final /* synthetic */ String f13563a;
        final /* synthetic */ PaymentPinFragment f13564b;
        final /* synthetic */ PaymentPinDeletionActivity f13565c;

        public C15113(PaymentPinDeletionActivity paymentPinDeletionActivity, String str, PaymentPinFragment paymentPinFragment) {
            this.f13565c = paymentPinDeletionActivity;
            this.f13563a = str;
            this.f13564b = paymentPinFragment;
        }

        protected final void m14160a(Object obj) {
            Object obj2;
            PaymentPin paymentPin = (PaymentPin) obj;
            long longValue = paymentPin.m14261a().isPresent() ? ((Long) paymentPin.m14261a().get()).longValue() : -1;
            PaymentPinDeletionActivity paymentPinDeletionActivity = this.f13565c;
            String str = this.f13563a;
            PaymentPinFragment paymentPinFragment = this.f13564b;
            if (paymentPinDeletionActivity.f13577y == null || paymentPinDeletionActivity.f13577y.isDone()) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 != null) {
                paymentPinDeletionActivity.f13577y = paymentPinDeletionActivity.f13572t.m14287a(longValue, str, true);
                Futures.a(paymentPinDeletionActivity.f13577y, new C15124(paymentPinDeletionActivity, paymentPinFragment), paymentPinDeletionActivity.f13571s);
            }
        }

        protected final void m14159a(ServiceException serviceException) {
            this.f13565c.f13570r.a("P2P_PAYMENT_PIN_FETCH_FAILED", "Payment PIN failed to fetch");
            this.f13564b.as();
            this.f13564b.aq();
            PaymentConnectivityDialogFactory.a(this.f13565c, serviceException);
        }
    }

    /* compiled from: has_drawing */
    public class C15124 extends OperationResultFutureCallback {
        final /* synthetic */ PaymentPinFragment f13566a;
        final /* synthetic */ PaymentPinDeletionActivity f13567b;

        public C15124(PaymentPinDeletionActivity paymentPinDeletionActivity, PaymentPinFragment paymentPinFragment) {
            this.f13567b = paymentPinDeletionActivity;
            this.f13566a = paymentPinFragment;
        }

        protected final void m14162a(Object obj) {
            this.f13567b.f13574v.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_pin_deleted"));
            this.f13567b.f13575w.b(new ToastBuilder(2131241042));
            PaymentPinDeletionActivity paymentPinDeletionActivity = this.f13567b;
            Intent intent = (Intent) paymentPinDeletionActivity.getIntent().getParcelableExtra("on_activity_finish_launch_intent");
            if (intent == null) {
                paymentPinDeletionActivity.finish();
                return;
            }
            intent.setFlags(67108864);
            paymentPinDeletionActivity.f13573u.a(intent, paymentPinDeletionActivity);
        }

        protected final void m14161a(ServiceException serviceException) {
            this.f13566a.as();
            this.f13567b.f13574v.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_pin_delete_fail"));
            this.f13566a.aq();
            if (PaymentPinFragment.m14176a(serviceException)) {
                PaymentPinDeletionActivity.m14165j(this.f13567b);
            } else {
                this.f13566a.m14181b(serviceException);
            }
        }
    }

    public static void m14164a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PaymentPinDeletionActivity) obj).m14163a(AppCompatActivityOverrider.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), PaymentPinProtocolUtil.m14279a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), Toaster.b(injectorLike));
    }

    @Inject
    private void m14163a(AppCompatActivityOverrider appCompatActivityOverrider, AbstractFbErrorReporter abstractFbErrorReporter, Executor executor, PaymentPinProtocolUtil paymentPinProtocolUtil, SecureContextHelper secureContextHelper, AnalyticsLogger analyticsLogger, Toaster toaster) {
        this.f13569q = appCompatActivityOverrider;
        this.f13570r = abstractFbErrorReporter;
        this.f13571s = executor;
        this.f13572t = paymentPinProtocolUtil;
        this.f13573u = secureContextHelper;
        this.f13574v = analyticsLogger;
        this.f13575w = toaster;
    }

    public final void m14168a(Fragment fragment) {
        super.a(fragment);
        if (fragment instanceof PaymentPinFragment) {
            final PaymentPinFragment paymentPinFragment = (PaymentPinFragment) fragment;
            paymentPinFragment.al = new PinInputListener(this) {
                final /* synthetic */ PaymentPinDeletionActivity f13562b;

                public final void mo530a(String str) {
                    Object obj;
                    PaymentPinDeletionActivity paymentPinDeletionActivity = this.f13562b;
                    PaymentPinFragment paymentPinFragment = paymentPinFragment;
                    if (paymentPinDeletionActivity.f13576x == null || paymentPinDeletionActivity.f13576x.isDone()) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        paymentPinFragment.ar();
                        paymentPinDeletionActivity.f13576x = paymentPinDeletionActivity.f13572t.m14283a();
                        Futures.a(paymentPinDeletionActivity.f13576x, new C15113(paymentPinDeletionActivity, str, paymentPinFragment), paymentPinDeletionActivity.f13571s);
                    }
                }

                public final void mo529a() {
                    PaymentPinDeletionActivity.m14165j(this.f13562b);
                }
            };
        }
    }

    protected final void m14167a(Bundle bundle) {
        super.a(bundle);
        MessengerMaterialThemeUtil.a(this, 2131625175);
        Class cls = PaymentPinDeletionActivity.class;
        m14164a(this, this);
        a(this.f13569q);
    }

    protected final void m14169b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130904413);
        this.f13574v.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_initiate_delete_pin"));
        new ActionBarBasedFbTitleBar(this, m14166a()).setTitle(2131241043);
        FragmentManager kO_ = kO_();
        PaymentPinFragment a = PaymentPinFragment.m14173a(getString(2131241028), 0, true);
        this.f13574v.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_confirm_pin"));
        kO_.a().a(2131560203, a).b();
        PaymentPinSyncControllerFragment paymentPinSyncControllerFragment = (PaymentPinSyncControllerFragment) kO_().a("payment_pin_listening_controller_fragment_tag");
        if (paymentPinSyncControllerFragment == null) {
            paymentPinSyncControllerFragment = new PaymentPinSyncControllerFragment();
            kO_().a().a(paymentPinSyncControllerFragment, "payment_pin_listening_controller_fragment_tag").b();
        }
        paymentPinSyncControllerFragment.f13677g = new C15091(this);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        menu.clear();
        return onCreateOptionsMenu;
    }

    public final ActionBar m14166a() {
        return this.f13569q.g();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    public void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1660504552);
        super.onDestroy();
        if (this.f13577y != null) {
            this.f13577y.cancel(true);
            this.f13577y = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -438965808, a);
    }

    public static void m14165j(PaymentPinDeletionActivity paymentPinDeletionActivity) {
        paymentPinDeletionActivity.f13573u.a(PaymentPinResetActivity.m14230a(paymentPinDeletionActivity, f13568p.getSimpleName(), (Intent) paymentPinDeletionActivity.getIntent().getParcelableExtra("on_activity_finish_launch_intent")), paymentPinDeletionActivity);
        paymentPinDeletionActivity.finish();
    }
}
