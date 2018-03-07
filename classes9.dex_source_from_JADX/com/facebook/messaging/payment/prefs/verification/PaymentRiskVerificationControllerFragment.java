package com.facebook.messaging.payment.prefs.verification;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.auth.annotations.ViewerContextUser;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.payment.abtest.ExperimentsForPaymentAbTestModule;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent;
import com.facebook.messaging.payment.config.AreP2pPaymentsRiskNativeEnabled;
import com.facebook.messaging.payment.connectivity.PaymentConnectivityDialogFactory;
import com.facebook.messaging.payment.dialog.PaymentDialogsBuilder;
import com.facebook.messaging.payment.model.verification.RiskScreen;
import com.facebook.messaging.payment.model.verification.ScreenData;
import com.facebook.messaging.payment.model.verification.UserInput;
import com.facebook.messaging.payment.protocol.PaymentProtocolUtil;
import com.facebook.messaging.payment.service.model.verification.VerifyPaymentResult;
import com.facebook.messaging.payment.util.PaymentTransactionUtil;
import com.facebook.messaging.payment.util.PaymentUrlHelper;
import com.facebook.payments.dialog.PaymentsConfirmDialogFragment;
import com.facebook.payments.dialog.PaymentsConfirmDialogFragment.Listener;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.dialogs.ProgressDialogFragment;
import com.facebook.user.model.User;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: friend_suggestion_pymk */
public class PaymentRiskVerificationControllerFragment extends FbFragment {
    @Inject
    PaymentProtocolUtil f14436a;
    @Inject
    public QeAccessor al;
    public String am;
    private String an;
    public ProgressDialogFragment ao;
    private ListenableFuture<VerifyPaymentResult> ap;
    public RiskScreen aq;
    public ScreenData ar;
    public String as;
    private final Listener at = new C16421(this);
    @Inject
    @ViewerContextUser
    Provider<User> f14437b;
    @Inject
    @ForUiThread
    Executor f14438c;
    @Inject
    Lazy<PaymentDialogsBuilder> f14439d;
    @Inject
    PaymentTransactionUtil f14440e;
    @Inject
    AnalyticsLogger f14441f;
    @Inject
    PaymentUrlHelper f14442g;
    @Inject
    SecureContextHelper f14443h;
    @Inject
    @AreP2pPaymentsRiskNativeEnabled
    Provider<Boolean> f14444i;

    /* compiled from: friend_suggestion_pymk */
    class C16421 implements Listener {
        final /* synthetic */ PaymentRiskVerificationControllerFragment f14431a;

        C16421(PaymentRiskVerificationControllerFragment paymentRiskVerificationControllerFragment) {
            this.f14431a = paymentRiskVerificationControllerFragment;
        }

        public final void m14826a() {
            Uri build;
            if (this.f14431a.as == null) {
                PaymentUrlHelper paymentUrlHelper = this.f14431a.f14442g;
                String str = this.f14431a.am;
                String str2 = "https://m.facebook.com/p2p/verify/?id=%s&source=orca_android&ts=%d&seed=%s";
                Long valueOf = Long.valueOf(paymentUrlHelper.f15171a.a() / 1000);
                StringBuilder stringBuilder = new StringBuilder(10);
                for (int i = 0; i < 10; i++) {
                    stringBuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(paymentUrlHelper.f15172b.nextInt(62)));
                }
                build = Uri.parse(StringFormatUtil.formatStrLocaleSafe(str2, str, valueOf, stringBuilder.toString())).buildUpon().build();
            } else {
                build = Uri.parse(this.f14431a.as).buildUpon().build();
            }
            this.f14431a.f14443h.b(new Intent("android.intent.action.VIEW").setData(build), this.f14431a.getContext());
            this.f14431a.o().finish();
        }

        public final void m14827b() {
            m14828c();
        }

        public final void m14828c() {
            this.f14431a.f14441f.a(P2pPaymentsLogEvent.c(PaymentRiskVerificationControllerFragment.au(this.f14431a), "p2p_mobile_browser_risk_cancel"));
            this.f14431a.o().finish();
        }
    }

    /* compiled from: friend_suggestion_pymk */
    class C16442 extends ResultFutureCallback<VerifyPaymentResult> {
        final /* synthetic */ PaymentRiskVerificationControllerFragment f14433a;

        /* compiled from: friend_suggestion_pymk */
        class C16431 implements OnClickListener {
            final /* synthetic */ C16442 f14432a;

            C16431(C16442 c16442) {
                this.f14432a = c16442;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }

        C16442(PaymentRiskVerificationControllerFragment paymentRiskVerificationControllerFragment) {
            this.f14433a = paymentRiskVerificationControllerFragment;
        }

        public final void m14830a(Object obj) {
            VerifyPaymentResult verifyPaymentResult = (VerifyPaymentResult) obj;
            this.f14433a.ao.a();
            if (verifyPaymentResult.m15212a()) {
                this.f14433a.as = verifyPaymentResult.m15213b();
                PaymentRiskVerificationControllerFragment.as(this.f14433a);
                return;
            }
            this.f14433a.aq = RiskScreen.fromString(verifyPaymentResult.m15214c());
            this.f14433a.ar = verifyPaymentResult.m15215d();
            PaymentRiskVerificationControllerFragment.m14833e(this.f14433a);
        }

        public final void m14829a(ServiceException serviceException) {
            this.f14433a.ao.a();
            if (serviceException.errorCode == ErrorCode.CONNECTION_FAILURE) {
                PaymentConnectivityDialogFactory.a(this.f14433a.getContext());
            } else if (serviceException.errorCode != ErrorCode.API_ERROR) {
                PaymentConnectivityDialogFactory.a(this.f14433a.getContext(), 2131240468);
            } else {
                ApiErrorResult apiErrorResult = (ApiErrorResult) serviceException.result.h();
                this.f14433a.f14439d.get();
                PaymentDialogsBuilder.m13299a(this.f14433a.getContext(), this.f14433a.b(2131240468), ApiErrorResult.a(apiErrorResult.c()), this.f14433a.b(2131230726), new C16431(this)).show();
            }
        }
    }

    /* compiled from: friend_suggestion_pymk */
    class C16453 implements OnClickListener {
        final /* synthetic */ PaymentRiskVerificationControllerFragment f14434a;

        C16453(PaymentRiskVerificationControllerFragment paymentRiskVerificationControllerFragment) {
            this.f14434a = paymentRiskVerificationControllerFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            this.f14434a.o().finish();
        }
    }

    public static void m14832a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PaymentRiskVerificationControllerFragment) obj).m14831a(PaymentProtocolUtil.m14937a(injectorLike), IdBasedProvider.a(injectorLike, 3596), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 8039), PaymentTransactionUtil.m15519a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), new PaymentUrlHelper((Clock) SystemClockMethodAutoProvider.a(injectorLike)), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), IdBasedProvider.a(injectorLike, 4176), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    private void m14831a(PaymentProtocolUtil paymentProtocolUtil, Provider<User> provider, Executor executor, Lazy<PaymentDialogsBuilder> lazy, PaymentTransactionUtil paymentTransactionUtil, AnalyticsLogger analyticsLogger, PaymentUrlHelper paymentUrlHelper, SecureContextHelper secureContextHelper, Provider<Boolean> provider2, QeAccessor qeAccessor) {
        this.f14436a = paymentProtocolUtil;
        this.f14437b = provider;
        this.f14438c = executor;
        this.f14439d = lazy;
        this.f14440e = paymentTransactionUtil;
        this.f14441f = analyticsLogger;
        this.f14442g = paymentUrlHelper;
        this.f14443h = secureContextHelper;
        this.f14444i = provider2;
        this.al = qeAccessor;
    }

    public final void m14836d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1280168942);
        super.d(bundle);
        Class cls = PaymentRiskVerificationControllerFragment.class;
        m14832a((Object) this, getContext());
        this.f14441f.a(P2pPaymentsLogEvent.c(au(this), "p2p_initiate_risk"));
        this.ao = (ProgressDialogFragment) ProgressDialogFragment.a(2131240467, true, false);
        this.am = this.s.getString("transaction_id");
        this.an = this.s.getString("recipient_id");
        if (!((Boolean) this.f14444i.get()).booleanValue() || "msite".equals(this.al.a(Liveness.Live, ExperimentsForPaymentAbTestModule.f12778b, "msite"))) {
            as(this);
            Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 825150089, a);
            return;
        }
        if (bundle != null) {
            this.aq = (RiskScreen) bundle.getSerializable("risk_screen");
            this.ar = (ScreenData) bundle.getParcelable("screen_data");
            this.as = bundle.getString("fallback_uri");
            if (!(this.aq == null || this.ar == null)) {
                m14833e(this);
                LogUtils.f(-793529575, a);
                return;
            }
        }
        m14835a(null, null);
        LogUtils.f(-1603099591, a);
    }

    public final View m14834a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1602930198);
        View inflate = layoutInflater.inflate(2130906156, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1841215566, a);
        return inflate;
    }

    public final void m14835a(@Nullable UserInput userInput, @Nullable String str) {
        if (this.ap != null && !this.ap.isDone()) {
            return;
        }
        if (this.as != null) {
            as(this);
            return;
        }
        String str2;
        this.ao.a(s(), "show_risk_controller_fragment_tag");
        PaymentProtocolUtil paymentProtocolUtil = this.f14436a;
        String str3 = this.am;
        if (this.aq == null) {
            str2 = null;
        } else {
            str2 = this.aq.name();
        }
        this.ap = paymentProtocolUtil.m14960a(str3, str2, userInput, str, ((User) this.f14437b.get()).a);
        Futures.a(this.ap, new C16442(this), this.f14438c);
    }

    public final void m14837e(Bundle bundle) {
        bundle.putSerializable("risk_screen", this.aq);
        bundle.putParcelable("screen_data", this.ar);
        bundle.putString("fallback_uri", this.as);
        super.e(bundle);
    }

    public static void m14833e(PaymentRiskVerificationControllerFragment paymentRiskVerificationControllerFragment) {
        String str;
        Fragment fragment;
        Parcelable parcelable;
        Bundle bundle;
        switch (paymentRiskVerificationControllerFragment.aq) {
            case INTRODUCTION:
                str = "risk_introduction_fragment_tag";
                parcelable = paymentRiskVerificationControllerFragment.ar;
                RiskIntroductionFragment riskIntroductionFragment = new RiskIntroductionFragment();
                bundle = new Bundle();
                bundle.putParcelable("screen_data", parcelable);
                riskIntroductionFragment.g(bundle);
                fragment = riskIntroductionFragment;
                break;
            case REQUEST_CC_CVV:
                str = "risk_security_code_fragment_tag";
                parcelable = paymentRiskVerificationControllerFragment.ar;
                RiskSecurityCodeFragment riskSecurityCodeFragment = new RiskSecurityCodeFragment();
                bundle = new Bundle();
                bundle.putParcelable("screen_data", parcelable);
                riskSecurityCodeFragment.g(bundle);
                fragment = riskSecurityCodeFragment;
                break;
            case REQUEST_CC_FIRST_SIX:
                str = "risk_card_first_six_fragment_tag";
                parcelable = paymentRiskVerificationControllerFragment.ar;
                RiskCardFirstSixFragment riskCardFirstSixFragment = new RiskCardFirstSixFragment();
                bundle = new Bundle();
                bundle.putParcelable("screen_data", parcelable);
                riskCardFirstSixFragment.g(bundle);
                fragment = riskCardFirstSixFragment;
                break;
            case FAILURE:
                FragmentManager s = paymentRiskVerificationControllerFragment.s();
                if (s.a("risk_failure_fragment_tag") == null) {
                    FragmentTransaction a = s.a();
                    Parcelable parcelable2 = paymentRiskVerificationControllerFragment.ar;
                    RiskFailureFragment riskFailureFragment = new RiskFailureFragment();
                    Bundle bundle2 = new Bundle();
                    bundle2.putParcelable("screen_data", parcelable2);
                    riskFailureFragment.g(bundle2);
                    a.a(riskFailureFragment, "risk_failure_fragment_tag").b();
                }
                return;
            case SUCCESS:
                paymentRiskVerificationControllerFragment.ar();
                return;
            case REQUEST_LEGAL_NAME:
                str = "risk_legal_name_birthday_fragment_tag";
                parcelable = paymentRiskVerificationControllerFragment.ar;
                RiskLegalNameBirthdayFragment riskLegalNameBirthdayFragment = new RiskLegalNameBirthdayFragment();
                bundle = new Bundle();
                bundle.putParcelable("screen_data", parcelable);
                riskLegalNameBirthdayFragment.g(bundle);
                fragment = riskLegalNameBirthdayFragment;
                break;
            case REQUEST_SSN_LAST_FOUR:
                str = "risk_last_4_ssn_fragment_tag";
                fragment = new RiskLast4SSNFragment();
                break;
            default:
                as(paymentRiskVerificationControllerFragment);
                return;
        }
        FragmentManager s2 = paymentRiskVerificationControllerFragment.s();
        if (s2.a(str) == null || paymentRiskVerificationControllerFragment.ar == null || paymentRiskVerificationControllerFragment.ar.m14082k()) {
            s2.a().b(2131565817, fragment, str).b();
        }
    }

    private void ar() {
        String a;
        Preconditions.checkNotNull(this.ar.m14075d());
        Preconditions.checkNotNull(this.ar.m14076e());
        Preconditions.checkNotNull(this.ar.m14077f());
        this.f14439d.get();
        Context context = getContext();
        String b = b(2131240469);
        if (this.f14440e.m15525a(this.an)) {
            a = a(2131240470, new Object[]{this.ar.m14075d(), this.ar.m14076e(), this.ar.m14077f()});
        } else {
            a = b(2131240471);
        }
        PaymentDialogsBuilder.m13299a(context, b, a, b(2131230726), new C16453(this)).show();
    }

    public static void as(PaymentRiskVerificationControllerFragment paymentRiskVerificationControllerFragment) {
        PaymentsConfirmDialogFragment paymentsConfirmDialogFragment = (PaymentsConfirmDialogFragment) paymentRiskVerificationControllerFragment.s().a("msite_dialog_fragment_tag");
        if (paymentsConfirmDialogFragment == null) {
            paymentsConfirmDialogFragment = PaymentsConfirmDialogFragment.a(paymentRiskVerificationControllerFragment.b(2131240443), paymentRiskVerificationControllerFragment.b(paymentRiskVerificationControllerFragment.f14440e.m15525a(paymentRiskVerificationControllerFragment.an) ? 2131240442 : 2131240441), paymentRiskVerificationControllerFragment.b(2131230730), paymentRiskVerificationControllerFragment.b(2131230727), true);
            paymentsConfirmDialogFragment.a(paymentRiskVerificationControllerFragment.s(), "msite_dialog_fragment_tag");
            paymentRiskVerificationControllerFragment.f14441f.a(P2pPaymentsLogEvent.c(au(paymentRiskVerificationControllerFragment), "p2p_mobile_browser_risk_confirm"));
        }
        paymentsConfirmDialogFragment.am = paymentRiskVerificationControllerFragment.at;
    }

    public static String au(PaymentRiskVerificationControllerFragment paymentRiskVerificationControllerFragment) {
        return paymentRiskVerificationControllerFragment.f14440e.m15525a(paymentRiskVerificationControllerFragment.an) ? "p2p_receive" : "p2p_send";
    }
}
