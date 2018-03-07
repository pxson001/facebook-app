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
import com.facebook.actionbar.ActionBarOwner;
import com.facebook.actionbar.AppCompatActivityOverrider;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.TriState;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.ResultFutureCallback;
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
import com.facebook.messaging.payment.pin.protocol.PaymentPinProtocolUtil;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.CustomViewPager;
import com.facebook.widget.titlebar.ActionBarBasedFbTitleBar;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: has_like */
public class PaymentPinCreationActivity extends FbFragmentActivity implements ActionBarOwner {
    public static final Class<?> f13550p = PaymentPinCreationActivity.class;
    private AppCompatActivityOverrider f13551q;
    public Executor f13552r;
    public PaymentPinProtocolUtil f13553s;
    public Provider<String> f13554t;
    public AnalyticsLogger f13555u;
    public Toaster f13556v;
    public CustomViewPager f13557w;
    public ListenableFuture<PaymentPin> f13558x;
    public String f13559y;

    /* compiled from: has_like */
    class C15052 extends SimpleOnPageChangeListener {
        final /* synthetic */ PaymentPinCreationActivity f13544a;

        C15052(PaymentPinCreationActivity paymentPinCreationActivity) {
            this.f13544a = paymentPinCreationActivity;
        }

        public final void e_(int i) {
            switch (i) {
                case 0:
                    this.f13544a.f13555u.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_set_pin"));
                    return;
                case 1:
                    this.f13544a.f13555u.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_confirm_pin"));
                    return;
                default:
                    throw new IllegalArgumentException(StringFormatUtil.formatStrLocaleSafe("Position %d: Beyond payment pin adapter", Integer.valueOf(i)));
            }
        }
    }

    /* compiled from: has_like */
    public class C15063 implements PinInputListener {
        final /* synthetic */ PaymentPinCreationActivity f13545a;

        public C15063(PaymentPinCreationActivity paymentPinCreationActivity) {
            this.f13545a = paymentPinCreationActivity;
        }

        public final void mo530a(String str) {
            this.f13545a.f13559y = str;
            this.f13545a.f13557w.a(this.f13545a.f13557w.k + 1, true);
        }

        public final void mo529a() {
        }
    }

    /* compiled from: has_like */
    public class C15085 extends ResultFutureCallback<PaymentPin> {
        final /* synthetic */ PaymentPinFragment f13548a;
        final /* synthetic */ PaymentPinCreationActivity f13549b;

        public C15085(PaymentPinCreationActivity paymentPinCreationActivity, PaymentPinFragment paymentPinFragment) {
            this.f13549b = paymentPinCreationActivity;
            this.f13548a = paymentPinFragment;
        }

        protected final void m14148a(Object obj) {
            this.f13548a.as();
            this.f13549b.f13555u.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_pin_set"));
            this.f13549b.setResult(-1);
            this.f13549b.f13556v.b(new ToastBuilder(2131241025));
            this.f13549b.finish();
        }

        protected final void m14147a(ServiceException serviceException) {
            this.f13548a.as();
            this.f13549b.f13555u.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_pin_set_fail"));
            BLog.b(PaymentPinCreationActivity.f13550p, "Fail to set payment PIN");
            this.f13548a.aq();
            PaymentConnectivityDialogFactory.a(this.f13549b, serviceException);
        }
    }

    public static void m14151a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PaymentPinCreationActivity) obj).m14150a(AppCompatActivityOverrider.b(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), PaymentPinProtocolUtil.m14279a(injectorLike), IdBasedProvider.a(injectorLike, 4442), AnalyticsLoggerMethodAutoProvider.a(injectorLike), Toaster.b(injectorLike));
    }

    public static Intent m14149a(Context context) {
        Preconditions.checkNotNull(context);
        return new Intent(context, PaymentPinCreationActivity.class);
    }

    @Inject
    private void m14150a(AppCompatActivityOverrider appCompatActivityOverrider, Executor executor, PaymentPinProtocolUtil paymentPinProtocolUtil, Provider<String> provider, AnalyticsLogger analyticsLogger, Toaster toaster) {
        this.f13551q = appCompatActivityOverrider;
        this.f13552r = executor;
        this.f13553s = paymentPinProtocolUtil;
        this.f13554t = provider;
        this.f13555u = analyticsLogger;
        this.f13556v = toaster;
    }

    public final void m14154a(Fragment fragment) {
        if (fragment instanceof PaymentPinFragment) {
            final PaymentPinFragment paymentPinFragment = (PaymentPinFragment) fragment;
            int e = paymentPinFragment.m14182e();
            if (e == 0) {
                paymentPinFragment.al = new C15063(this);
            } else if (e == 1) {
                paymentPinFragment.al = new PinInputListener(this) {
                    final /* synthetic */ PaymentPinCreationActivity f13547b;

                    public final void mo530a(String str) {
                        if (str.equals(this.f13547b.f13559y)) {
                            Object obj;
                            PaymentPinCreationActivity paymentPinCreationActivity = this.f13547b;
                            PaymentPinFragment paymentPinFragment = paymentPinFragment;
                            if (paymentPinCreationActivity.f13558x == null || paymentPinCreationActivity.f13558x.isDone()) {
                                obj = 1;
                            } else {
                                obj = null;
                            }
                            if (obj != null) {
                                long parseLong = Long.parseLong((String) paymentPinCreationActivity.f13554t.get());
                                paymentPinFragment.ar();
                                paymentPinCreationActivity.f13558x = paymentPinCreationActivity.f13553s.m14289a(paymentPinCreationActivity.f13559y, parseLong, TriState.YES, null);
                                Futures.a(paymentPinCreationActivity.f13558x, new C15085(paymentPinCreationActivity, paymentPinFragment), paymentPinCreationActivity.f13552r);
                            }
                            return;
                        }
                        paymentPinFragment.aq();
                    }

                    public final void mo529a() {
                    }
                };
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("savedPin", this.f13559y);
        super.onSaveInstanceState(bundle);
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.f13559y = bundle.getString("savedPin");
    }

    protected final void m14153a(Bundle bundle) {
        MessengerMaterialThemeUtil.a(this, 2131625175);
        Class cls = PaymentPinCreationActivity.class;
        m14151a(this, this);
        a(this.f13551q);
    }

    protected final void m14155b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130906150);
        this.f13555u.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_initiate_set_pin"));
        new ActionBarBasedFbTitleBar(this, m14152a()).setTitle(2131241022);
        this.f13557w = (CustomViewPager) a(2131565814);
        this.f13557w.a = false;
        this.f13557w.setAdapter(new FragmentPagerAdapter(this, kO_()) {
            final /* synthetic */ PaymentPinCreationActivity f13543a;

            public final int m14142b() {
                return 2;
            }

            public final Fragment m14141a(int i) {
                if (i == 0) {
                    this.f13543a.f13555u.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_set_pin"));
                    return PaymentPinFragment.m14173a(this.f13543a.getString(2131241023), 0, false);
                } else if (i == 1) {
                    return PaymentPinFragment.m14173a(this.f13543a.getString(2131241024), 1, false);
                } else {
                    throw new IllegalArgumentException(StringFormatUtil.formatStrLocaleSafe("Position %d: Beyond payment pin adapter", Integer.valueOf(i)));
                }
            }
        });
        this.f13557w.setOnPageChangeListener(new C15052(this));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        menu.clear();
        return onCreateOptionsMenu;
    }

    public final ActionBar m14152a() {
        return this.f13551q.g();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    public void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1255146232);
        super.onDestroy();
        if (this.f13558x != null) {
            this.f13558x.cancel(true);
            this.f13558x = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1157340859, a);
    }
}
