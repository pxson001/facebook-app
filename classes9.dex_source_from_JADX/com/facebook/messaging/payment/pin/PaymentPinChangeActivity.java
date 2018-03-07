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
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
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
import com.facebook.messaging.payment.value.util.PaymentsSoftInputUtil;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.CustomViewPager;
import com.facebook.widget.titlebar.ActionBarBasedFbTitleBar;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: has_pinned_threads */
public class PaymentPinChangeActivity extends FbFragmentActivity implements ActionBarOwner {
    private static final Class<?> f13510p = PaymentPinChangeActivity.class;
    private LinearLayout f13511A;
    public String[] f13512B;
    private ListenableFuture<PaymentPin> f13513C;
    public ListenableFuture<OperationResult> f13514D;
    public ListenableFuture<PaymentPin> f13515E;
    private AppCompatActivityOverrider f13516q;
    public Executor f13517r;
    public PaymentsSoftInputUtil f13518s;
    public PaymentPinProtocolUtil f13519t;
    public AbstractFbErrorReporter f13520u;
    public SecureContextHelper f13521v;
    public AnalyticsLogger f13522w;
    public Toaster f13523x;
    public ActionBarBasedFbTitleBar f13524y;
    public CustomViewPager f13525z;

    /* compiled from: has_pinned_threads */
    public class AnonymousClass10 extends ResultFutureCallback<PaymentPin> {
        final /* synthetic */ PaymentPinFragment f13491a;
        final /* synthetic */ String f13492b;
        final /* synthetic */ PaymentPinChangeActivity f13493c;

        public AnonymousClass10(PaymentPinChangeActivity paymentPinChangeActivity, PaymentPinFragment paymentPinFragment, String str) {
            this.f13493c = paymentPinChangeActivity;
            this.f13491a = paymentPinFragment;
            this.f13492b = str;
        }

        protected final void m14094a(ServiceException serviceException) {
            this.f13491a.as();
            this.f13491a.aq();
            if (PaymentPinFragment.m14176a(serviceException)) {
                PaymentPinChangeActivity.m14120k(this.f13493c);
            } else {
                this.f13491a.m14181b(serviceException);
            }
        }

        protected final void m14095a(Object obj) {
            this.f13491a.as();
            int i = this.f13493c.f13525z.k;
            this.f13493c.f13512B[i] = this.f13492b;
            this.f13493c.f13525z.a(i + 1, true);
        }
    }

    /* compiled from: has_pinned_threads */
    public class C14921 extends SimpleOnPageChangeListener {
        final /* synthetic */ PaymentPinChangeActivity f13494a;

        public C14921(PaymentPinChangeActivity paymentPinChangeActivity) {
            this.f13494a = paymentPinChangeActivity;
        }

        public final void e_(int i) {
            switch (i) {
                case 0:
                    this.f13494a.f13524y.setTitle(2131241026);
                    this.f13494a.f13522w.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_confirm_pin"));
                    break;
                case 1:
                    this.f13494a.f13524y.setTitle(2131241027);
                    this.f13494a.f13522w.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_confirm_pin"));
                    break;
                case 2:
                    this.f13494a.f13524y.setTitle(2131241027);
                    this.f13494a.f13522w.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_set_pin"));
                    break;
                default:
                    throw new IllegalArgumentException(StringFormatUtil.formatStrLocaleSafe("Position %d: Beyond payment pin adapter", Integer.valueOf(i)));
            }
            this.f13494a.f13518s.m16056a(this.f13494a, null);
        }
    }

    /* compiled from: has_pinned_threads */
    public class C14954 implements PinInputListener {
        final /* synthetic */ PaymentPinChangeActivity f13498a;

        public C14954(PaymentPinChangeActivity paymentPinChangeActivity) {
            this.f13498a = paymentPinChangeActivity;
        }

        public final void mo530a(String str) {
            int i = this.f13498a.f13525z.k;
            this.f13498a.f13512B[i] = str;
            this.f13498a.f13525z.a(i + 1, true);
        }

        public final void mo529a() {
        }
    }

    /* compiled from: has_pinned_threads */
    public class C14976 implements Callback {
        final /* synthetic */ PaymentPinChangeActivity f13501a;

        public C14976(PaymentPinChangeActivity paymentPinChangeActivity) {
            this.f13501a = paymentPinChangeActivity;
        }

        public final void mo531a() {
            this.f13501a.setResult(-1);
            this.f13501a.finish();
        }
    }

    /* compiled from: has_pinned_threads */
    public class C14998 extends OperationResultFutureCallback {
        final /* synthetic */ PaymentPinFragment f13505a;
        final /* synthetic */ PaymentPinChangeActivity f13506b;

        public C14998(PaymentPinChangeActivity paymentPinChangeActivity, PaymentPinFragment paymentPinFragment) {
            this.f13506b = paymentPinChangeActivity;
            this.f13505a = paymentPinFragment;
        }

        protected final void m14110a(ServiceException serviceException) {
            this.f13505a.as();
            this.f13506b.f13522w.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_pin_change_fail"));
            this.f13505a.aq();
            this.f13505a.m14181b(serviceException);
        }

        protected final void m14111a(Object obj) {
            this.f13505a.as();
            this.f13506b.f13522w.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_pin_changed"));
            this.f13506b.f13523x.b(new ToastBuilder(2131241031));
            PaymentPinChangeActivity paymentPinChangeActivity = this.f13506b;
            Intent intent = (Intent) paymentPinChangeActivity.getIntent().getParcelableExtra("on_activity_finish_launch_intent");
            if (intent == null) {
                paymentPinChangeActivity.finish();
                return;
            }
            intent.setFlags(67108864);
            paymentPinChangeActivity.f13521v.a(intent, paymentPinChangeActivity);
        }
    }

    public static void m14116a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PaymentPinChangeActivity) obj).m14114a(AppCompatActivityOverrider.b(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), PaymentsSoftInputUtil.m16054b(injectorLike), PaymentPinProtocolUtil.m14279a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), Toaster.b(injectorLike));
    }

    public final void m14124a(Fragment fragment) {
        if (fragment instanceof PaymentPinFragment) {
            int e = ((PaymentPinFragment) fragment).m14182e();
            final PaymentPinFragment paymentPinFragment;
            if (e == 0) {
                paymentPinFragment = (PaymentPinFragment) fragment;
                paymentPinFragment.al = new PinInputListener(this) {
                    final /* synthetic */ PaymentPinChangeActivity f13497b;

                    public final void mo530a(String str) {
                        this.f13497b.m14119b(str, paymentPinFragment);
                    }

                    public final void mo529a() {
                        PaymentPinChangeActivity.m14120k(this.f13497b);
                    }
                };
            } else if (e == 1) {
                ((PaymentPinFragment) fragment).al = new C14954(this);
            } else if (e == 2) {
                paymentPinFragment = (PaymentPinFragment) fragment;
                paymentPinFragment.al = new PinInputListener(this) {
                    final /* synthetic */ PaymentPinChangeActivity f13500b;

                    public final void mo530a(String str) {
                        if (str.equals(this.f13500b.f13512B[1])) {
                            this.f13500b.m14117a(str, paymentPinFragment);
                        } else {
                            paymentPinFragment.aq();
                        }
                    }

                    public final void mo529a() {
                    }
                };
            }
        }
    }

    @Inject
    private void m14114a(AppCompatActivityOverrider appCompatActivityOverrider, Executor executor, PaymentsSoftInputUtil paymentsSoftInputUtil, PaymentPinProtocolUtil paymentPinProtocolUtil, AbstractFbErrorReporter abstractFbErrorReporter, SecureContextHelper secureContextHelper, AnalyticsLogger analyticsLogger, Toaster toaster) {
        this.f13516q = appCompatActivityOverrider;
        this.f13517r = executor;
        this.f13518s = paymentsSoftInputUtil;
        this.f13519t = paymentPinProtocolUtil;
        this.f13520u = abstractFbErrorReporter;
        this.f13521v = secureContextHelper;
        this.f13522w = analyticsLogger;
        this.f13523x = toaster;
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putStringArray("savedPins", this.f13512B);
        super.onSaveInstanceState(bundle);
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.f13512B = bundle.getStringArray("savedPins");
    }

    protected final void m14123a(Bundle bundle) {
        super.a(bundle);
        MessengerMaterialThemeUtil.a(this, 2131625175);
        Class cls = PaymentPinChangeActivity.class;
        m14116a((Object) this, (Context) this);
        a(this.f13516q);
    }

    protected final void m14125b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130906150);
        this.f13511A = (LinearLayout) a(2131565813);
        this.f13522w.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_initiate_change_pin"));
        this.f13524y = new ActionBarBasedFbTitleBar(this, this.f13516q.g());
        this.f13524y.setTitle(2131241026);
        this.f13525z = (CustomViewPager) a(2131565814);
        this.f13525z.setOffscreenPageLimit(2);
        this.f13525z.a = false;
        this.f13525z.setOnPageChangeListener(new C14921(this));
        this.f13525z.setAdapter(new FragmentPagerAdapter(this, kO_()) {
            final /* synthetic */ PaymentPinChangeActivity f13495a;

            public final int m14097b() {
                return 3;
            }

            public final Fragment m14096a(int i) {
                if (i == 0) {
                    this.f13495a.f13522w.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_confirm_pin"));
                    return PaymentPinFragment.m14173a(this.f13495a.getString(2131241028), 0, true);
                } else if (i == 1) {
                    return PaymentPinFragment.m14173a(this.f13495a.getString(2131241029), 1, false);
                } else {
                    if (i == 2) {
                        return PaymentPinFragment.m14173a(this.f13495a.getString(2131241030), 2, false);
                    }
                    throw new IllegalArgumentException(StringFormatUtil.formatStrLocaleSafe("Position %d: Beyond payment pin adapter", Integer.valueOf(i)));
                }
            }
        });
        PaymentPinSyncControllerFragment paymentPinSyncControllerFragment = (PaymentPinSyncControllerFragment) kO_().a("payment_pin_listening_controller_fragment_tag");
        if (paymentPinSyncControllerFragment == null) {
            paymentPinSyncControllerFragment = new PaymentPinSyncControllerFragment();
            kO_().a().a(paymentPinSyncControllerFragment, "payment_pin_listening_controller_fragment_tag").b();
        }
        paymentPinSyncControllerFragment.f13677g = new C14976(this);
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -2043575943);
        super.onResume();
        if (this.f13512B == null) {
            this.f13512B = new String[2];
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1054939266, a);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        menu.clear();
        return onCreateOptionsMenu;
    }

    public final ActionBar m14122a() {
        return this.f13516q.g();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    public void onBackPressed() {
        int i = this.f13525z.k;
        if (i == 0) {
            finish();
        } else {
            this.f13525z.setCurrentItem(i - 1);
        }
    }

    public void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1159299063);
        super.onDestroy();
        if (this.f13515E != null) {
            this.f13515E.cancel(true);
            this.f13515E = null;
        }
        if (this.f13513C != null) {
            this.f13513C.cancel(true);
            this.f13513C = null;
        }
        if (this.f13514D != null) {
            this.f13514D.cancel(true);
            this.f13514D = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1585591610, a);
    }

    private void m14117a(final String str, final PaymentPinFragment paymentPinFragment) {
        if (m14121n()) {
            paymentPinFragment.ar();
            this.f13513C = this.f13519t.m14283a();
            Futures.a(this.f13513C, new ResultFutureCallback<PaymentPin>(this) {
                final /* synthetic */ PaymentPinChangeActivity f13504c;

                protected final void m14109a(Object obj) {
                    Object obj2;
                    PaymentPin paymentPin = (PaymentPin) obj;
                    paymentPinFragment.as();
                    long longValue = paymentPin.m14261a().isPresent() ? ((Long) paymentPin.m14261a().get()).longValue() : -1;
                    PaymentPinChangeActivity paymentPinChangeActivity = this.f13504c;
                    String str = str;
                    PaymentPinFragment paymentPinFragment = paymentPinFragment;
                    if (paymentPinChangeActivity.f13514D == null || paymentPinChangeActivity.f13514D.isDone()) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if (obj2 != null) {
                        paymentPinFragment.ar();
                        paymentPinChangeActivity.f13514D = paymentPinChangeActivity.f13519t.m14286a(longValue, paymentPinChangeActivity.f13512B[0], str);
                        Futures.a(paymentPinChangeActivity.f13514D, new C14998(paymentPinChangeActivity, paymentPinFragment), paymentPinChangeActivity.f13517r);
                    }
                }

                protected final void m14108a(ServiceException serviceException) {
                    paymentPinFragment.as();
                    this.f13504c.f13520u.a("P2P_PAYMENT_PIN_FETCH_FAILED", "Payment PIN failed to fetch");
                    paymentPinFragment.aq();
                    PaymentConnectivityDialogFactory.a(this.f13504c, serviceException);
                }
            }, this.f13517r);
        }
    }

    private void m14119b(final String str, final PaymentPinFragment paymentPinFragment) {
        if (m14121n()) {
            paymentPinFragment.ar();
            this.f13513C = this.f13519t.m14283a();
            Futures.a(this.f13513C, new ResultFutureCallback<PaymentPin>(this) {
                final /* synthetic */ PaymentPinChangeActivity f13509c;

                protected final void m14113a(Object obj) {
                    Object obj2;
                    PaymentPin paymentPin = (PaymentPin) obj;
                    paymentPinFragment.as();
                    long longValue = paymentPin.m14261a().isPresent() ? ((Long) paymentPin.m14261a().get()).longValue() : -1;
                    PaymentPinChangeActivity paymentPinChangeActivity = this.f13509c;
                    String str = str;
                    PaymentPinFragment paymentPinFragment = paymentPinFragment;
                    if (paymentPinChangeActivity.f13515E == null || paymentPinChangeActivity.f13515E.isDone()) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if (obj2 != null) {
                        paymentPinFragment.ar();
                        paymentPinChangeActivity.f13515E = paymentPinChangeActivity.f13519t.m14284a(longValue, str);
                        Futures.a(paymentPinChangeActivity.f13515E, new AnonymousClass10(paymentPinChangeActivity, paymentPinFragment, str), paymentPinChangeActivity.f13517r);
                    }
                }

                protected final void m14112a(ServiceException serviceException) {
                    paymentPinFragment.as();
                    this.f13509c.f13520u.a("P2P_PAYMENT_PIN_FETCH_FAILED", "Payment PIN failed to fetch");
                    paymentPinFragment.aq();
                    PaymentConnectivityDialogFactory.a(this.f13509c, serviceException);
                }
            }, this.f13517r);
        }
    }

    public static void m14120k(PaymentPinChangeActivity paymentPinChangeActivity) {
        paymentPinChangeActivity.f13521v.a(PaymentPinResetActivity.m14230a(paymentPinChangeActivity, f13510p.getSimpleName(), (Intent) paymentPinChangeActivity.getIntent().getParcelableExtra("on_activity_finish_launch_intent")), paymentPinChangeActivity);
        paymentPinChangeActivity.finish();
    }

    private boolean m14121n() {
        return this.f13513C == null || this.f13513C.isDone();
    }
}
