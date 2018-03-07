package com.facebook.adspayments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.View;
import com.facebook.actionbar.ActionBarOwner;
import com.facebook.actionbar.AppCompatActivityOverrider;
import com.facebook.adspayments.PaymentUiUtil.C28311;
import com.facebook.adspayments.analytics.AdsPaymentsFlowContext;
import com.facebook.adspayments.analytics.PaymentsFlowContext;
import com.facebook.adspayments.analytics.PaymentsLogEvent;
import com.facebook.adspayments.analytics.PaymentsLogger;
import com.facebook.adspayments.analytics.StoredBalanceStatus;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.activitylistener.ActivityListener;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.locale.Country;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.payment.dialog.PaymentDialogsBuilder;
import com.facebook.payments.model.CurrencyAmount;
import com.facebook.payments.model.PaymentsFlowType;
import com.facebook.payments.paymentsflow.uicomponents.LoadingDialog;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.widget.titlebar.ActionBarBasedFbTitleBar;
import com.facebook.widget.titlebar.FbActionBarUtil;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.math.BigDecimal;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;

/* compiled from: Unexpected attachment type */
public abstract class AdsPaymentsActivity extends FbFragmentActivity implements ActionBarOwner {
    protected PaymentsFlowContext f23429A;
    public boolean f23430B;
    @Nullable
    public TitleBarButtonSpec[] f23431C;
    @Nullable
    public FbTitleBar f23432p;
    private final Object f23433q = new Object();
    @GuardedBy("loadingIndicatorLock")
    @Nullable
    private LoadingDialog f23434r;
    @Inject
    FbActionBarUtil f23435u;
    @Inject
    Lazy<AppCompatActivityOverrider> f23436v;
    @Inject
    protected AbstractFbErrorReporter f23437w;
    @Inject
    protected PaymentsLogger f23438x;
    @Inject
    @ForUiThread
    protected ExecutorService f23439y;
    @Inject
    protected SecureContextHelper f23440z;

    /* compiled from: Unexpected attachment type */
    public abstract class ServerResponseFutureCallback<T> extends AbstractDisposableFutureCallback<T> {
        final /* synthetic */ AdsPaymentsActivity f23423d;

        protected ServerResponseFutureCallback(AdsPaymentsActivity adsPaymentsActivity) {
            this.f23423d = adsPaymentsActivity;
        }

        protected void mo1060a(Throwable th) {
            this.f23423d.m25371s();
            AdsPaymentsActivity adsPaymentsActivity = this.f23423d;
            PaymentDialogsBuilder.m13303a(adsPaymentsActivity, th, adsPaymentsActivity.getString(2131230725), adsPaymentsActivity.getString(2131230762));
            this.f23423d.m25358b(th);
        }

        protected final void m25341a(CancellationException cancellationException) {
            super.a(cancellationException);
            this.f23423d.m25371s();
        }
    }

    public static void m25345a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((AdsPaymentsActivity) obj).m25344a(FbActionBarUtil.a(injectorLike), IdBasedLazy.a(injectorLike, 4577), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), PaymentsLogger.m3873a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    public abstract String mo1073i();

    protected abstract int mo1075k();

    private void m25344a(FbActionBarUtil fbActionBarUtil, Lazy<AppCompatActivityOverrider> lazy, FbErrorReporter fbErrorReporter, PaymentsLogger paymentsLogger, ExecutorService executorService, SecureContextHelper secureContextHelper) {
        this.f23435u = fbActionBarUtil;
        this.f23436v = lazy;
        this.f23437w = fbErrorReporter;
        this.f23438x = paymentsLogger;
        this.f23439y = executorService;
        this.f23440z = secureContextHelper;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Object obj;
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
            obj = 1;
        } else {
            obj = null;
        }
        return obj != null || super.onOptionsItemSelected(menuItem);
    }

    protected void mo1061a(Bundle bundle) {
        super.a(bundle);
        Class cls = AdsPaymentsActivity.class;
        m25345a((Object) this, (Context) this);
        this.f23430B = this.f23435u.a();
        if (this.f23430B) {
            a((ActivityListener) this.f23436v.get());
        }
    }

    public void setContentView(int i) {
        super.setContentView(i);
        mo1063l();
        boolean z = this.f23430B;
        AppCompatActivityOverrider appCompatActivityOverrider = (AppCompatActivityOverrider) this.f23436v.get();
        String string = getResources().getString(mo1075k());
        if (z) {
            ActionBarBasedFbTitleBar actionBarBasedFbTitleBar = new ActionBarBasedFbTitleBar(this, appCompatActivityOverrider.g());
            actionBarBasedFbTitleBar.setTitle(string);
            actionBarBasedFbTitleBar.setHasBackButton(true);
        } else if (FbTitleBarUtil.b(this)) {
            FbTitleBar fbTitleBar = (FbTitleBar) findViewById(2131558563);
            fbTitleBar.setTitle(string);
            fbTitleBar.a(new C28311(this));
        }
        if (!this.f23430B) {
            this.f23432p = (FbTitleBar) a(2131558563);
        }
    }

    protected final void m25356a(@Nullable Runnable runnable) {
        m25357a(getString(2131230745), runnable);
    }

    protected final void m25357a(String str, @Nullable final Runnable runnable) {
        final Runnable c28071 = runnable == null ? null : new Runnable(this) {
            final /* synthetic */ AdsPaymentsActivity f23513b;

            public void run() {
                AdsPaymentsActivity adsPaymentsActivity = this.f23513b;
                adsPaymentsActivity.m25362d(adsPaymentsActivity.mo1073i());
                runnable.run();
            }
        };
        boolean z = true;
        C28082 c28082 = new OnToolbarButtonListener(this) {
            final /* synthetic */ AdsPaymentsActivity f23515b;

            public final void m25464a(View view, TitleBarButtonSpec titleBarButtonSpec) {
                ((Runnable) Preconditions.checkNotNull(c28071)).run();
            }
        };
        TitleBarButtonSpec[] titleBarButtonSpecArr = new TitleBarButtonSpec[1];
        Builder a = TitleBarButtonSpec.a();
        a.a = 0;
        a = a;
        a.q = true;
        a = a;
        a.g = str;
        a = a;
        if (c28071 == null) {
            z = false;
        }
        a.d = z;
        titleBarButtonSpecArr[0] = a.a();
        if (!this.f23430B) {
            Preconditions.checkNotNull(this.f23432p);
            this.f23431C = titleBarButtonSpecArr;
            this.f23432p.setButtonSpecs(ImmutableList.copyOf(titleBarButtonSpecArr));
            this.f23432p.setOnToolbarButtonListener(c28082);
        }
    }

    protected final void m25353a(int i, boolean z) {
        if (!this.f23430B) {
            Preconditions.checkNotNull(this.f23431C);
            Preconditions.checkElementIndex(i, this.f23431C.length);
            Preconditions.checkNotNull(this.f23432p);
            this.f23431C[i].t = z;
            this.f23432p.setButtonSpecs(ImmutableList.copyOf(this.f23431C));
        }
    }

    private void mo1063l() {
        if (getIntent().hasExtra("payments_flow_context_key")) {
            this.f23429A = (PaymentsFlowContext) getIntent().getParcelableExtra("payments_flow_context_key");
        } else if (getIntent().hasExtra("ad_account_id") && getIntent().hasExtra("flow_name")) {
            this.f23429A = new AdsPaymentsFlowContext(getIntent().getStringExtra("flow_name"), getIntent().getStringExtra("ad_account_id"), PaymentsFlowType.PICKER_SCREEN, new CurrencyAmount("USD", BigDecimal.ONE), false, StoredBalanceStatus.NEW_USER);
        } else {
            throw new IllegalArgumentException(StringFormatUtil.formatStrLocaleSafe("Need either '%s' or ('%s' and '%s')", "payments_flow_context_key", "ad_account_id", "flow_name"));
        }
    }

    protected final void m25355a(final Country country, @Nullable final String str) {
        ExecutorDetour.a(this.f23439y, new Runnable(this) {
            final /* synthetic */ AdsPaymentsActivity f23518c;

            public void run() {
                Intent intent = new Intent();
                intent.putExtra("billing_country", country);
                intent.putExtra("brazilian_tax_id", str);
                intent.putExtra("payments_flow_context_key", this.f23518c.f23429A);
                this.f23518c.setResult(-1, intent);
                this.f23518c.finish();
            }
        }, 1594580330);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 10:
            case 301:
                if (i2 == -1) {
                    setResult(-1, intent);
                    finish();
                    return;
                }
                break;
        }
        super.onActivityResult(i, i2, intent);
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 19742042);
        super.onResume();
        mo1064m();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -388831918, a);
    }

    protected void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1250066524);
        mo1065n();
        super.onPause();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1696463643, a);
    }

    protected void mo1069p() {
        m25360c(mo1073i());
    }

    @VisibleForTesting
    private void mo1064m() {
        m25363e(null);
    }

    private void mo1065n() {
        mo1062b(mo1073i());
    }

    protected final void m25360c(String str) {
        m25346a("payments_action_back", str);
    }

    public final void m25362d(String str) {
        m25346a("payments_action_continue", str);
    }

    protected final void m25363e(@Nullable String str) {
        m25346a("payments_state_appear", (String) MoreObjects.firstNonNull(str, mo1073i()));
        this.f23438x.m3881b((String) MoreObjects.firstNonNull(str, mo1074j()), this.f23429A);
    }

    private void mo1062b(String str) {
        m25346a("payments_state_disappear", str);
    }

    protected final void m25358b(Throwable th) {
        this.f23438x.m3877a(th, this.f23429A);
        this.f23438x.m3879a((PaymentsLogEvent) mo1085g("payments_state_error").m3866a(th));
        this.f23437w.a(getClass().getSimpleName(), th);
    }

    private void m25346a(String str, String str2) {
        this.f23438x.m3879a(m25347b(str, str2));
    }

    protected final void m25364f(String str) {
        m25346a(str, mo1073i());
    }

    private PaymentsLogEvent m25347b(String str, String str2) {
        PaymentsLogEvent paymentsLogEvent = new PaymentsLogEvent(str, this.f23429A);
        paymentsLogEvent.b("ui_state", str2);
        if (this.f23429A instanceof AdsPaymentsFlowContext) {
            StoredBalanceStatus storedBalanceStatus = ((AdsPaymentsFlowContext) this.f23429A).f3974c;
            paymentsLogEvent.a("is_nux", storedBalanceStatus.isNUX());
            paymentsLogEvent.a("is_pux", storedBalanceStatus.isPUX());
            paymentsLogEvent.a("is_prepay_account", storedBalanceStatus.isLockedIntoPrepay());
        }
        return paymentsLogEvent;
    }

    protected PaymentsLogEvent mo1085g(String str) {
        return m25347b(str, mo1073i());
    }

    public void onBackPressed() {
        mo1069p();
        super.onBackPressed();
    }

    protected String mo1074j() {
        return mo1073i();
    }

    @Nullable
    public final ActionBar m25352a() {
        if (this.f23430B) {
            return ((AppCompatActivityOverrider) this.f23436v.get()).g();
        }
        return null;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        m25371s();
        super.onSaveInstanceState(bundle);
    }

    protected final void m25370r() {
        synchronized (this.f23433q) {
            this.f23434r = LoadingDialog.aq();
            this.f23434r.a(kO_(), null);
        }
    }

    protected final void m25371s() {
        synchronized (this.f23433q) {
            if (this.f23434r != null) {
                this.f23434r.a();
                this.f23434r = null;
            }
        }
    }

    protected final void m25359c(Intent intent) {
        setResult(-1, intent);
        finish();
    }

    protected final void m25361d(Intent intent) {
        this.f23440z.a(intent, 10, this);
    }
}
