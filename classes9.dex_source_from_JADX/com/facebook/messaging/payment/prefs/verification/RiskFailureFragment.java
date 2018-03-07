package com.facebook.messaging.payment.prefs.verification;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.payment.model.verification.ScreenData;
import com.facebook.payments.dialog.PaymentsConfirmDialogFragment;
import com.facebook.payments.dialog.PaymentsConfirmDialogFragment.Listener;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.inject.Inject;

/* compiled from: friend_status */
public class RiskFailureFragment extends FbFragment {
    @Inject
    public AbstractFbErrorReporter f14451a;
    @Inject
    public SecureContextHelper f14452b;
    public final Listener f14453c = new C16471(this);
    public final Listener f14454d = new C16482(this);
    public final Listener f14455e = new C16493(this);

    /* compiled from: friend_status */
    class C16471 implements Listener {
        final /* synthetic */ RiskFailureFragment f14448a;

        C16471(RiskFailureFragment riskFailureFragment) {
            this.f14448a = riskFailureFragment;
        }

        public final void m14843a() {
            this.f14448a.o().finish();
        }

        public final void m14844b() {
        }

        public final void m14845c() {
            this.f14448a.o().finish();
        }
    }

    /* compiled from: friend_status */
    class C16482 implements Listener {
        final /* synthetic */ RiskFailureFragment f14449a;

        C16482(RiskFailureFragment riskFailureFragment) {
            this.f14449a = riskFailureFragment;
        }

        public final void m14846a() {
            this.f14449a.o().finish();
        }

        public final void m14847b() {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("https://m.facebook.com/help/contact/370238886476028"));
            this.f14449a.f14452b.b(intent, this.f14449a.getContext());
            this.f14449a.o().finish();
        }

        public final void m14848c() {
            this.f14449a.o().finish();
        }
    }

    /* compiled from: friend_status */
    class C16493 implements Listener {
        final /* synthetic */ RiskFailureFragment f14450a;

        C16493(RiskFailureFragment riskFailureFragment) {
            this.f14450a = riskFailureFragment;
        }

        public final void m14849a() {
            this.f14450a.o().finish();
        }

        public final void m14850b() {
        }

        public final void m14851c() {
            this.f14450a.o().finish();
        }
    }

    public static void m14852a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        RiskFailureFragment riskFailureFragment = (RiskFailureFragment) obj;
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector);
        riskFailureFragment.f14451a = abstractFbErrorReporter;
        riskFailureFragment.f14452b = secureContextHelper;
    }

    public final void m14855c(Bundle bundle) {
        super.c(bundle);
        Class cls = RiskFailureFragment.class;
        m14852a(this, getContext());
    }

    public final void m14856d(@Nullable Bundle bundle) {
        PaymentsConfirmDialogFragment a;
        int a2 = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1574620658);
        super.d(bundle);
        ScreenData screenData = (ScreenData) this.s.get("screen_data");
        if (bundle == null) {
            if (screenData.m14084m() || !screenData.m14083l()) {
                if (!screenData.m14084m() && !screenData.m14083l()) {
                    m14853b();
                } else if (screenData.m14084m() && screenData.m14083l()) {
                    m14854c(screenData);
                } else {
                    this.f14451a.b("RiskFailureFragment", "Invalid ScreenData received for FAILURE screen: " + screenData);
                }
            } else if (((PaymentsConfirmDialogFragment) s().a("unexpected_exception")) == null) {
                a = PaymentsConfirmDialogFragment.a(b(2131240472), screenData.m14078g(), b(2131230726), null, true);
                a.am = this.f14453c;
                a.a(s(), "unexpected_exception");
            }
        }
        a = (PaymentsConfirmDialogFragment) s().a("unexpected_exception");
        if (a != null) {
            a.am = this.f14453c;
        }
        a = (PaymentsConfirmDialogFragment) s().a("verification_failure");
        if (a != null) {
            a.am = this.f14454d;
        }
        a = (PaymentsConfirmDialogFragment) s().a("payment_error");
        if (a != null) {
            a.am = this.f14455e;
        }
        LogUtils.f(1702054564, a2);
    }

    private void m14853b() {
        if (((PaymentsConfirmDialogFragment) s().a("verification_failure")) == null) {
            PaymentsConfirmDialogFragment a = PaymentsConfirmDialogFragment.a(b(2131240472), b(2131240473), b(2131230726), b(2131240474), true);
            a.am = this.f14454d;
            a.a(s(), "verification_failure");
        }
    }

    private void m14854c(ScreenData screenData) {
        if (((PaymentsConfirmDialogFragment) s().a("payment_error")) == null) {
            PaymentsConfirmDialogFragment a = PaymentsConfirmDialogFragment.a(b(2131240475), a(2131240476, new Object[]{screenData.m14078g()}), b(2131230726), null, true);
            a.am = this.f14455e;
            a.a(s(), "payment_error");
        }
    }
}
