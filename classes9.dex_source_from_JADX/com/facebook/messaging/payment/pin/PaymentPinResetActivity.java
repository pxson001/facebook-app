package com.facebook.messaging.payment.pin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import com.facebook.actionbar.ActionBarOwner;
import com.facebook.actionbar.AppCompatActivityOverrider;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.TriState;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.material.MessengerMaterialThemeUtil;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent;
import com.facebook.messaging.payment.connectivity.PaymentConnectivityDialogFactory;
import com.facebook.messaging.payment.pin.model.PaymentPin;
import com.facebook.messaging.payment.pin.protocol.PaymentPinProtocolUtil;
import com.facebook.messaging.payment.value.util.PaymentsSoftInputUtil;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.CustomViewPager;
import com.facebook.widget.titlebar.ActionBarBasedFbTitleBar;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: hasOptimisticAttachments */
public class PaymentPinResetActivity extends FbFragmentActivity implements ActionBarOwner {
    public static final Class<?> f13647p = PaymentPinResetActivity.class;
    public static final String f13648q = PaymentPinDeletionActivity.class.getSimpleName();
    public static final String f13649r = PaymentPinChangeActivity.class.getSimpleName();
    public static final String f13650s = PaymentPinConfirmActivity.class.getSimpleName();
    public Provider<String> f13651A;
    public Toaster f13652B;
    public CustomViewPager f13653C;
    public String f13654D;
    public String f13655E;
    public boolean f13656F;
    public boolean f13657G;
    public LinearLayout f13658H;
    public ListenableFuture<PaymentPin> f13659I;
    public ListenableFuture<OperationResult> f13660J;
    public ListenableFuture<PaymentPin> f13661K;
    private AppCompatActivityOverrider f13662t;
    public AbstractFbErrorReporter f13663u;
    public PaymentsSoftInputUtil f13664v;
    public PaymentPinProtocolUtil f13665w;
    public AnalyticsLogger f13666x;
    public Executor f13667y;
    private SecureContextHelper f13668z;

    /* compiled from: hasOptimisticAttachments */
    public class C15312 extends SimpleOnPageChangeListener {
        final /* synthetic */ PaymentPinResetActivity f13634a;

        public C15312(PaymentPinResetActivity paymentPinResetActivity) {
            this.f13634a = paymentPinResetActivity;
        }

        public final void e_(int i) {
            this.f13634a.f13664v.m16056a(this.f13634a, null);
            switch (i) {
                case 0:
                    this.f13634a.f13666x.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_reset_pin"));
                    return;
                case 1:
                    this.f13634a.f13666x.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_set_pin"));
                    return;
                case 2:
                    this.f13634a.f13666x.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_confirm_pin"));
                    return;
                default:
                    throw new IllegalArgumentException(StringFormatUtil.formatStrLocaleSafe("Position %d: Beyond payment pin adapter", Integer.valueOf(i)));
            }
        }
    }

    /* compiled from: hasOptimisticAttachments */
    public class C15334 extends ResultFutureCallback<PaymentPin> {
        final /* synthetic */ ResetPinFragment f13637a;
        final /* synthetic */ String f13638b;
        final /* synthetic */ PaymentPinResetActivity f13639c;

        public C15334(PaymentPinResetActivity paymentPinResetActivity, ResetPinFragment resetPinFragment, String str) {
            this.f13639c = paymentPinResetActivity;
            this.f13637a = resetPinFragment;
            this.f13638b = str;
        }

        public final void m14221a(Object obj) {
            Object obj2;
            PaymentPin paymentPin = (PaymentPin) obj;
            this.f13637a.ar();
            long longValue = paymentPin.m14261a().isPresent() ? ((Long) paymentPin.m14261a().get()).longValue() : -1;
            PaymentPinResetActivity paymentPinResetActivity = this.f13639c;
            String str = this.f13638b;
            ResetPinFragment resetPinFragment = this.f13637a;
            if (paymentPinResetActivity.f13660J == null || paymentPinResetActivity.f13660J.isDone()) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 != null) {
                resetPinFragment.aq();
                paymentPinResetActivity.f13660J = paymentPinResetActivity.f13665w.m14287a(longValue, str, false);
                Futures.a(paymentPinResetActivity.f13660J, new C15345(paymentPinResetActivity, resetPinFragment), paymentPinResetActivity.f13667y);
            }
        }

        public final void m14220a(ServiceException serviceException) {
            this.f13637a.ar();
            this.f13639c.f13663u.a("P2P_PAYMENT_PIN_FETCH_FAILED", "Payment PIN failed to fetch");
            this.f13637a.m14244b();
            PaymentConnectivityDialogFactory.a(this.f13639c, serviceException);
        }
    }

    /* compiled from: hasOptimisticAttachments */
    public class C15345 extends OperationResultFutureCallback {
        final /* synthetic */ ResetPinFragment f13640a;
        final /* synthetic */ PaymentPinResetActivity f13641b;

        public C15345(PaymentPinResetActivity paymentPinResetActivity, ResetPinFragment resetPinFragment) {
            this.f13641b = paymentPinResetActivity;
            this.f13640a = resetPinFragment;
        }

        protected final void m14223a(Object obj) {
            this.f13640a.ar();
            this.f13641b.f13666x.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_pin_deleted"));
            this.f13641b.f13656F = true;
            if (this.f13641b.f13655E.equals(PaymentPinResetActivity.f13648q)) {
                this.f13641b.f13652B.b(new ToastBuilder(2131241042));
                PaymentPinResetActivity.m14233q(this.f13641b);
            } else if (this.f13641b.f13655E.equals(PaymentPinResetActivity.f13649r) || this.f13641b.f13655E.equals(PaymentPinResetActivity.f13650s)) {
                this.f13641b.f13653C.a(this.f13641b.f13653C.k + 1, true);
            }
        }

        protected final void m14222a(ServiceException serviceException) {
            Object obj;
            this.f13640a.ar();
            this.f13641b.f13666x.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_pin_delete_fail"));
            this.f13640a.m14244b();
            ResetPinFragment resetPinFragment = this.f13640a;
            LinearLayout linearLayout = this.f13641b.f13658H;
            if (serviceException.errorCode != ErrorCode.API_ERROR) {
                PaymentConnectivityDialogFactory.a(resetPinFragment.getContext(), serviceException);
                obj = 1;
            } else {
                ApiErrorResult apiErrorResult = (ApiErrorResult) serviceException.result.h();
                if (apiErrorResult.a() != 100) {
                    PaymentPinFragment.m14178c(resetPinFragment.getContext(), ApiErrorResult.a(apiErrorResult.c())).show();
                    int i = 1;
                } else {
                    obj = null;
                }
            }
            if (obj == null) {
                this.f13641b.f13652B.b(new ToastBuilder(2131241038));
            }
        }
    }

    /* compiled from: hasOptimisticAttachments */
    public class C15356 implements PinInputListener {
        final /* synthetic */ PaymentPinResetActivity f13642a;

        public C15356(PaymentPinResetActivity paymentPinResetActivity) {
            this.f13642a = paymentPinResetActivity;
        }

        public final void mo530a(String str) {
            int i = this.f13642a.f13653C.k;
            this.f13642a.f13654D = str;
            this.f13642a.f13653C.a(i + 1, true);
        }

        public final void mo529a() {
        }
    }

    /* compiled from: hasOptimisticAttachments */
    public class C15378 extends ResultFutureCallback<PaymentPin> {
        final /* synthetic */ PaymentPinFragment f13645a;
        final /* synthetic */ PaymentPinResetActivity f13646b;

        public C15378(PaymentPinResetActivity paymentPinResetActivity, PaymentPinFragment paymentPinFragment) {
            this.f13646b = paymentPinResetActivity;
            this.f13645a = paymentPinFragment;
        }

        protected final void m14229a(Object obj) {
            this.f13645a.as();
            this.f13646b.f13666x.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_pin_set"));
            this.f13646b.f13657G = true;
            this.f13646b.f13652B.b(new ToastBuilder(2131241031));
            PaymentPinResetActivity.m14233q(this.f13646b);
        }

        protected final void m14228a(ServiceException serviceException) {
            this.f13645a.as();
            this.f13646b.f13666x.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_pin_set_fail"));
            BLog.b(PaymentPinResetActivity.f13647p, "Fail to set payment PIN");
            this.f13645a.aq();
            PaymentPinFragment paymentPinFragment = this.f13645a;
            LinearLayout linearLayout = this.f13646b.f13658H;
            paymentPinFragment.m14181b(serviceException);
        }
    }

    public static void m14232a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PaymentPinResetActivity) obj).m14231a(AppCompatActivityOverrider.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), PaymentsSoftInputUtil.m16054b(injectorLike), PaymentPinProtocolUtil.m14279a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), IdBasedProvider.a(injectorLike, 4442), Toaster.b(injectorLike));
    }

    public static Intent m14230a(Context context, String str, @Nullable Intent intent) {
        Preconditions.checkNotNull(context);
        Intent intent2 = new Intent(context, PaymentPinResetActivity.class);
        intent2.putExtra("calling_class_name", str);
        intent2.putExtra("on_activity_finish_launch_intent", intent);
        return intent2;
    }

    public final void m14236a(Fragment fragment) {
        if (fragment instanceof PaymentPinFragment) {
            final PaymentPinFragment paymentPinFragment = (PaymentPinFragment) fragment;
            int e = paymentPinFragment.m14182e();
            if (e == 1) {
                paymentPinFragment.al = new C15356(this);
            } else if (e == 2) {
                paymentPinFragment.al = new PinInputListener(this) {
                    final /* synthetic */ PaymentPinResetActivity f13644b;

                    public final void mo530a(String str) {
                        if (str.equals(this.f13644b.f13654D)) {
                            Object obj;
                            PaymentPinResetActivity paymentPinResetActivity = this.f13644b;
                            PaymentPinFragment paymentPinFragment = paymentPinFragment;
                            if (paymentPinResetActivity.f13661K == null || paymentPinResetActivity.f13661K.isDone()) {
                                obj = 1;
                            } else {
                                obj = null;
                            }
                            if (obj != null) {
                                long parseLong = Long.parseLong((String) paymentPinResetActivity.f13651A.get());
                                paymentPinFragment.ar();
                                paymentPinResetActivity.f13661K = paymentPinResetActivity.f13665w.m14289a(paymentPinResetActivity.f13654D, parseLong, TriState.YES, null);
                                Futures.a(paymentPinResetActivity.f13661K, new C15378(paymentPinResetActivity, paymentPinFragment), paymentPinResetActivity.f13667y);
                            }
                            return;
                        }
                        paymentPinFragment.aq();
                    }

                    public final void mo529a() {
                    }
                };
            }
        } else if (fragment instanceof ResetPinFragment) {
            final ResetPinFragment resetPinFragment = (ResetPinFragment) fragment;
            if (resetPinFragment.s.getInt("savedTag") == 0) {
                resetPinFragment.f13684f = new Object(this) {
                    public final /* synthetic */ PaymentPinResetActivity f13636b;
                };
            }
        }
    }

    @Inject
    private void m14231a(AppCompatActivityOverrider appCompatActivityOverrider, FbErrorReporter fbErrorReporter, PaymentsSoftInputUtil paymentsSoftInputUtil, PaymentPinProtocolUtil paymentPinProtocolUtil, AnalyticsLogger analyticsLogger, Executor executor, SecureContextHelper secureContextHelper, Provider<String> provider, Toaster toaster) {
        this.f13662t = appCompatActivityOverrider;
        this.f13663u = fbErrorReporter;
        this.f13664v = paymentsSoftInputUtil;
        this.f13665w = paymentPinProtocolUtil;
        this.f13666x = analyticsLogger;
        this.f13667y = executor;
        this.f13668z = secureContextHelper;
        this.f13651A = provider;
        this.f13652B = toaster;
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("savedPins", this.f13654D);
        super.onSaveInstanceState(bundle);
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.f13654D = bundle.getString("savedPins");
    }

    protected final void m14235a(Bundle bundle) {
        MessengerMaterialThemeUtil.a(this, 2131625175);
        Class cls = PaymentPinResetActivity.class;
        m14232a(this, this);
        a(this.f13662t);
    }

    protected final void m14237b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130906150);
        this.f13666x.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_initiate_reset_pin"));
        this.f13658H = (LinearLayout) a(2131565813);
        this.f13655E = getIntent().getStringExtra("calling_class_name");
        new ActionBarBasedFbTitleBar(this, m14234a()).setTitle(2131241033);
        this.f13653C = (CustomViewPager) a(2131565814);
        this.f13653C.a = false;
        this.f13653C.setAdapter(new FragmentPagerAdapter(this, kO_()) {
            final /* synthetic */ PaymentPinResetActivity f13633a;

            public final int m14219b() {
                return 3;
            }

            public final Fragment m14218a(int i) {
                if (i == 0) {
                    this.f13633a.f13666x.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_reset_pin"));
                    String string = this.f13633a.getString(2131241034);
                    Preconditions.checkNotNull(string);
                    Bundle bundle = new Bundle();
                    bundle.putString("savedHeaderText", string);
                    bundle.putInt("savedTag", 0);
                    ResetPinFragment resetPinFragment = new ResetPinFragment();
                    resetPinFragment.g(bundle);
                    return resetPinFragment;
                } else if (i == 1) {
                    return PaymentPinFragment.m14173a(this.f13633a.getString(2131241029), 1, false);
                } else {
                    if (i == 2) {
                        return PaymentPinFragment.m14173a(this.f13633a.getString(2131241030), 2, false);
                    }
                    throw new IllegalArgumentException(StringFormatUtil.formatStrLocaleSafe("Position %d: Beyond payment pin adapter", Integer.valueOf(i)));
                }
            }
        });
        this.f13653C.setOnPageChangeListener(new C15312(this));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        menu.clear();
        return onCreateOptionsMenu;
    }

    public final ActionBar m14234a() {
        return this.f13662t.g();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        m14233q(this);
        return true;
    }

    public void onBackPressed() {
        int i = this.f13653C.k;
        if (i == 0) {
            m14233q(this);
        } else {
            this.f13653C.setCurrentItem(i - 1);
        }
    }

    public void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1122456556);
        super.onDestroy();
        if (this.f13660J != null) {
            this.f13660J.cancel(true);
            this.f13660J = null;
        }
        if (this.f13659I != null) {
            this.f13659I.cancel(true);
            this.f13659I = null;
        }
        if (this.f13661K != null) {
            this.f13661K.cancel(true);
            this.f13661K = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1469777920, a);
    }

    public static void m14233q(PaymentPinResetActivity paymentPinResetActivity) {
        if (!paymentPinResetActivity.f13656F) {
            paymentPinResetActivity.finish();
        } else if (!paymentPinResetActivity.f13655E.equals(f13650s)) {
            r0 = (Intent) paymentPinResetActivity.getIntent().getParcelableExtra("on_activity_finish_launch_intent");
            if (r0 == null) {
                paymentPinResetActivity.finish();
                return;
            }
            r0.setFlags(67108864);
            paymentPinResetActivity.f13668z.a(r0, paymentPinResetActivity);
        } else if (paymentPinResetActivity.f13657G) {
            r0 = new Intent();
            r0.putExtra("user_entered_pin", paymentPinResetActivity.f13654D);
            paymentPinResetActivity.setResult(-1, r0);
            paymentPinResetActivity.finish();
        } else {
            paymentPinResetActivity.finish();
        }
    }
}
