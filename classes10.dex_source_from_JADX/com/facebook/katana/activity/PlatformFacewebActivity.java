package com.facebook.katana.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.fragmentfactory.FragmentFactoryMap;
import com.facebook.common.fragmentfactory.FragmentFactoryMapImpl;
import com.facebook.common.util.StringUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.FbInjector;
import com.facebook.katana.activity.faceweb.FacewebFragment;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.payments.paymentmethods.model.CreditCard;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.facebook.payments.paymentmethods.model.PaymentMethodType;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.webview.eventbus.FacewebEventBus;
import com.facebook.webview.eventbus.FacewebEvents.BootstrapExecutionEventSubscriber;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: SCRUBBER */
public class PlatformFacewebActivity extends FbFragmentActivity {
    private static final String f24293t = PlatformFacewebActivity.class.getSimpleName();
    @Inject
    public AbstractFbErrorReporter f24294p;
    @Inject
    public FragmentFactoryMap f24295q;
    @Inject
    public QuickPerformanceLogger f24296r;
    @Inject
    public FacewebEventBus f24297s;
    private FragmentManager f24298u;
    private FacewebFragment f24299v;
    private final BootstrapExecutionEventSubscriber f24300w = new C34881(this);

    /* compiled from: SCRUBBER */
    class C34881 extends BootstrapExecutionEventSubscriber {
        final /* synthetic */ PlatformFacewebActivity f24292a;

        C34881(PlatformFacewebActivity platformFacewebActivity) {
            this.f24292a = platformFacewebActivity;
        }

        public final void m25593b(FbEvent fbEvent) {
            this.f24292a.f24296r.b(10092545, (short) 2);
        }
    }

    private static <T extends Context> void m25594a(Class<T> cls, T t) {
        m25595a((Object) t, (Context) t);
    }

    public static void m25595a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PlatformFacewebActivity platformFacewebActivity = (PlatformFacewebActivity) obj;
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        FragmentFactoryMap fragmentFactoryMap = (FragmentFactoryMap) FragmentFactoryMapImpl.a(fbInjector);
        QuickPerformanceLogger a = QuickPerformanceLoggerMethodAutoProvider.a(fbInjector);
        FacewebEventBus a2 = FacewebEventBus.m13014a(fbInjector);
        platformFacewebActivity.f24294p = abstractFbErrorReporter;
        platformFacewebActivity.f24295q = fragmentFactoryMap;
        platformFacewebActivity.f24296r = a;
        platformFacewebActivity.f24297s = a2;
    }

    protected final void m25596b(@Nullable Bundle bundle) {
        super.b(bundle);
        Class cls = PlatformFacewebActivity.class;
        m25595a((Object) this, (Context) this);
        this.f24298u = kO_();
        setContentView(2130906327);
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("target_fragment", -1);
        if (intExtra != -1) {
            Fragment a = this.f24295q.a(intExtra).a(intent);
            if (a == null || !(a instanceof FacewebFragment)) {
                this.f24294p.b(f24293t, "Failed to create a fragment");
                return;
            }
            this.f24299v = (FacewebFragment) a;
            overridePendingTransition(2130968739, 2130968614);
            this.f24298u.a().b(2131558429, this.f24299v).b();
            this.f24298u.b();
            this.f24297s.a(this.f24300w);
            this.f24296r.a(10092545, (short) 80);
        }
    }

    public void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1984938420);
        super.onResume();
        this.f24296r.a(10092545, (short) 143);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1600563903, a);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.f24299v.a(i, i2, intent);
        switch (i) {
            case 42:
                if (i2 == -1 && intent != null) {
                    PaymentMethod paymentMethod = (PaymentMethod) intent.getParcelableExtra("selected_payment_method");
                    if (paymentMethod != null && paymentMethod.b() == PaymentMethodType.CREDIT_CARD && (paymentMethod instanceof CreditCard)) {
                        Object obj;
                        CreditCard creditCard = (CreditCard) paymentMethod;
                        if (StringUtil.a(creditCard.g()) || StringUtil.a(creditCard.a()) || StringUtil.a(creditCard.c()) || StringUtil.a(creditCard.d()) || StringUtil.a(creditCard.e())) {
                            obj = null;
                        } else {
                            obj = 1;
                        }
                        if (obj == null) {
                            this.f24294p.b(f24293t, "Partial fields for credit card");
                            return;
                        }
                        FacewebFragment facewebFragment = this.f24299v;
                        String str = "require('MPagesPlatformPaymentNativeBridge').updatePaymentMethod('{" + PlatformPaymentUtil.m25599a("card_association", creditCard.g()) + "," + PlatformPaymentUtil.m25599a("credential_id", creditCard.a()) + "," + PlatformPaymentUtil.m25599a("expiration_month", creditCard.c()) + "," + PlatformPaymentUtil.m25599a("expiration_year", creditCard.d()) + "," + PlatformPaymentUtil.m25599a("last_four_digits", creditCard.e()) + "}');";
                        if (facewebFragment.an != null) {
                            facewebFragment.an.a(str, null);
                        }
                        return;
                    }
                    this.f24294p.b(f24293t, "Payment method must be credit card");
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 543374892);
        super.onPause();
        this.f24296r.b(10092545, (short) 22);
        this.f24297s.b(this.f24300w);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 386930603, a);
    }
}
