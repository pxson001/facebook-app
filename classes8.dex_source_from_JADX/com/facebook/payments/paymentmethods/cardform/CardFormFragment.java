package com.facebook.payments.paymentmethods.cardform;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.util.ContextUtils;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.payments.decorator.PaymentsDecoratorParams;
import com.facebook.payments.model.FormFieldProperty;
import com.facebook.payments.paymentmethods.cardform.CardFormMutatorFragment.C02031;
import com.facebook.payments.ui.PaymentsComponentAction;
import com.facebook.payments.ui.PaymentsComponentView;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;
import com.facebook.payments.ui.titlebar.PaymentsTitleBarViewStub;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnBackPressedListener;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: tap_photo_footer_comment */
public class CardFormFragment extends FbFragment implements CanHandleBackPressed {
    @Inject
    public AnalyticsLogger f1790a;
    public PaymentFormEditTextView al;
    private ProgressBar am;
    public FbTitleBar an;
    public CardFormParams ao;
    public CardFormInputControllerFragment ap;
    public CardFormMutatorFragment aq;
    public ListenableFuture ar;
    public final Builder as;
    public final C01871 at;
    public final SimplePaymentsComponentCallback au;
    private final C01893 av;
    @Inject
    public SecureContextHelper f1791b;
    @Inject
    public SimpleCardFormManager f1792c;
    @Inject
    @ForUiThread
    public Executor f1793d;
    private Context f1794e;
    public LinearLayout f1795f;
    public PaymentFormEditTextView f1796g;
    public PaymentFormEditTextView f1797h;
    public PaymentFormEditTextView f1798i;

    /* compiled from: tap_photo_footer_comment */
    public class C01871 {
        final /* synthetic */ CardFormFragment f1782a;

        C01871(CardFormFragment cardFormFragment) {
            this.f1782a = cardFormFragment;
        }

        public final void m1977a() {
            CardFormFragment.aw(this.f1782a);
        }

        public final void m1978b() {
            CardFormFragment.ax(this.f1782a);
        }
    }

    /* compiled from: tap_photo_footer_comment */
    class C01882 extends SimplePaymentsComponentCallback {
        final /* synthetic */ CardFormFragment f1783a;

        C01882(CardFormFragment cardFormFragment) {
            this.f1783a = cardFormFragment;
        }

        public final void mo80a(FbDialogFragment fbDialogFragment) {
            fbDialogFragment.a(this.f1783a.kO_(), "payments_component_dialog_fragment");
        }

        public final void mo82b(Intent intent) {
            this.f1783a.f1791b.b(intent, this.f1783a.getContext());
        }

        public final void mo79a(PaymentsComponentAction paymentsComponentAction) {
            CardFormFragment cardFormFragment = this.f1783a;
            switch (paymentsComponentAction.f1974a) {
                case FINISH_ACTIVITY:
                    Activity ao = cardFormFragment.ao();
                    if (ao != null) {
                        Intent intent = (Intent) paymentsComponentAction.m2210a("extra_activity_result_data");
                        if (intent != null) {
                            ao.setResult(-1, intent);
                        } else {
                            ao.setResult(-1);
                        }
                        ao.finish();
                        return;
                    }
                    return;
                case MUTATION:
                    CardFormMutatorFragment cardFormMutatorFragment = cardFormFragment.aq;
                    if (!CardFormMutatorFragment.m2028a(cardFormMutatorFragment.am)) {
                        cardFormMutatorFragment.am = cardFormMutatorFragment.f1841h.m2082a(cardFormMutatorFragment.f1839f, paymentsComponentAction);
                        cardFormMutatorFragment.f1840g.m1977a();
                        Futures.a(cardFormMutatorFragment.am, new C02031(cardFormMutatorFragment), cardFormMutatorFragment.f1836b);
                    }
                    return;
                case RESET:
                    if (cardFormFragment.ap != null) {
                        cardFormFragment.ap.ar();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        public final void mo81a(ListenableFuture listenableFuture) {
            CardFormFragment cardFormFragment = this.f1783a;
            if (cardFormFragment.ar != null) {
                cardFormFragment.ar.cancel(true);
            }
            CardFormFragment.aw(cardFormFragment);
            cardFormFragment.ar = listenableFuture;
            Futures.a(cardFormFragment.ar, new C01926(cardFormFragment), cardFormFragment.f1793d);
        }
    }

    /* compiled from: tap_photo_footer_comment */
    public class C01893 {
        public final /* synthetic */ CardFormFragment f1784a;

        C01893(CardFormFragment cardFormFragment) {
            this.f1784a = cardFormFragment;
        }

        public final void m1990a() {
            CardFormFragment.av(this.f1784a);
        }

        public final void m1991a(boolean z) {
            this.f1784a.as.d = z;
            this.f1784a.an.setButtonSpecs(ImmutableList.of(this.f1784a.as.a()));
        }
    }

    /* compiled from: tap_photo_footer_comment */
    class C01915 extends OnToolbarButtonListener {
        final /* synthetic */ CardFormFragment f1787a;

        C01915(CardFormFragment cardFormFragment) {
            this.f1787a = cardFormFragment;
        }

        public final void m1993a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            if (!CardFormMutatorFragment.m2028a(this.f1787a.aq.al)) {
                this.f1787a.f1790a.a(CardFormAnalyticsEvent.m1970c(this.f1787a.ao.mo78a().f1773b.f1769b, this.f1787a.f1792c.m2074b(this.f1787a.ao.mo78a().f1772a).m2057e(this.f1787a.ao)));
                this.f1787a.ap.m2016b();
            }
        }
    }

    /* compiled from: tap_photo_footer_comment */
    public class C01926 extends ResultFutureCallback<Object> {
        final /* synthetic */ CardFormFragment f1788a;

        public C01926(CardFormFragment cardFormFragment) {
            this.f1788a = cardFormFragment;
        }

        protected final void m1995a(Object obj) {
            CardFormFragment.ax(this.f1788a);
        }

        protected final void m1994a(ServiceException serviceException) {
            CardFormFragment.ax(this.f1788a);
        }
    }

    public static void m1996a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        CardFormFragment cardFormFragment = (CardFormFragment) obj;
        AnalyticsLogger a = AnalyticsLoggerMethodAutoProvider.a(injectorLike);
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike);
        SimpleCardFormManager a2 = SimpleCardFormManager.m2071a(injectorLike);
        Executor executor = (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike);
        cardFormFragment.f1790a = a;
        cardFormFragment.f1791b = secureContextHelper;
        cardFormFragment.f1792c = a2;
        cardFormFragment.f1793d = executor;
    }

    public CardFormFragment() {
        Builder a = TitleBarButtonSpec.a();
        a.d = false;
        this.as = a;
        this.at = new C01871(this);
        this.au = new C01882(this);
        this.av = new C01893(this);
    }

    public final void m2000c(Bundle bundle) {
        super.c(bundle);
        this.f1794e = ContextUtils.a(getContext(), 2130772893, 2131624691);
        Class cls = CardFormFragment.class;
        m1996a((Object) this, this.f1794e);
        d(true);
    }

    public final View m1998a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1304659848);
        View inflate = layoutInflater.cloneInContext(this.f1794e).inflate(2130903501, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1284908869, a);
        return inflate;
    }

    public final void m1999a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f1795f = (LinearLayout) e(2131560204);
        this.f1796g = (PaymentFormEditTextView) e(2131558763);
        this.f1797h = (PaymentFormEditTextView) e(2131560205);
        this.f1798i = (PaymentFormEditTextView) e(2131558764);
        this.al = (PaymentFormEditTextView) e(2131560206);
        this.am = (ProgressBar) e(2131559418);
        this.ao = (CardFormParams) this.s.getParcelable("card_form_params");
        if (this.ao.mo78a().f1774c.f1856d == FormFieldProperty.HIDDEN) {
            this.al.setVisibility(8);
        } else {
            this.al.setVisibility(0);
        }
        this.aq = (CardFormMutatorFragment) s().a("card_form_mutator_fragment");
        if (this.aq == null) {
            Parcelable parcelable = this.ao;
            CardFormMutatorFragment cardFormMutatorFragment = new CardFormMutatorFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("card_form_params", parcelable);
            cardFormMutatorFragment.g(bundle2);
            this.aq = cardFormMutatorFragment;
            s().a().a(this.aq, "card_form_mutator_fragment").b();
        }
        this.aq.f1840g = this.at;
        this.aq.f1842i = this.au;
        PaymentsComponentView a = this.f1792c.m2073a(this.ao.mo78a().f1772a).m2088a(this.f1795f, this.ao);
        if (a != null) {
            a.setPaymentsComponentCallback(this.au);
            this.f1795f.addView((View) a, 0);
        }
        a = this.f1792c.m2073a(this.ao.mo78a().f1772a).m2089b(this.f1795f, this.ao);
        if (a != null) {
            a.setPaymentsComponentCallback(this.au);
            this.f1795f.addView((View) a);
        }
        as();
        at();
        FbDialogFragment fbDialogFragment = (FbDialogFragment) kO_().a("payments_component_dialog_fragment");
        if (fbDialogFragment != null && (fbDialogFragment instanceof CardFormComponent)) {
            ((CardFormComponent) fbDialogFragment).mo85a(this.au);
        }
    }

    public final void m1997I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1413640089);
        super.I();
        if (this.ar != null) {
            this.ar.cancel(true);
            this.ar = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1417487836, a);
    }

    public final boolean O_() {
        CardFormInputControllerFragment cardFormInputControllerFragment = this.ap;
        SimpleCardFormAnalyticsEventSelector b = cardFormInputControllerFragment.f1830i.m2074b(cardFormInputControllerFragment.am.mo78a().f1772a);
        AnalyticsLogger analyticsLogger = cardFormInputControllerFragment.al;
        CardFormAnalyticsEvent.Builder d = CardFormAnalyticsEvent.m1971d(cardFormInputControllerFragment.am.mo78a().f1773b.f1769b, b.m2053a(cardFormInputControllerFragment.am));
        d.f1767a.a("card_number_digits", cardFormInputControllerFragment.av.mo86b());
        d = d;
        d.f1767a.a("expiration_date_digits", cardFormInputControllerFragment.ax.mo86b());
        d = d;
        d.f1767a.a("csc_digits", cardFormInputControllerFragment.aw.mo86b());
        d = d;
        d.f1767a.a("billing_zip_digits", cardFormInputControllerFragment.ay.mo86b());
        d = d;
        d.f1767a.a("is_card_number_valid", cardFormInputControllerFragment.av.as());
        d = d;
        d.f1767a.a("is_expiration_date_valid", cardFormInputControllerFragment.ax.as());
        d = d;
        d.f1767a.a("is_csc_valid", cardFormInputControllerFragment.aw.as());
        d = d;
        d.f1767a.a("is_billing_zip_valid", cardFormInputControllerFragment.ay.as());
        analyticsLogger.a(d.f1767a);
        return true;
    }

    private void as() {
        this.ap = (CardFormInputControllerFragment) kO_().a("card_form_input_controller_fragment");
        if (this.ap == null) {
            Parcelable parcelable = this.ao;
            Bundle bundle = new Bundle();
            bundle.putParcelable("card_form_params", parcelable);
            CardFormInputControllerFragment cardFormInputControllerFragment = new CardFormInputControllerFragment();
            cardFormInputControllerFragment.g(bundle);
            this.ap = cardFormInputControllerFragment;
            kO_().a().a(this.ap, "card_form_input_controller_fragment").b();
        }
        this.ap.aq = this.au;
        this.ap.ap = this.av;
        CardFormInputControllerFragment cardFormInputControllerFragment2 = this.ap;
        PaymentFormEditTextView paymentFormEditTextView = this.f1796g;
        PaymentFormEditTextView paymentFormEditTextView2 = this.f1797h;
        PaymentFormEditTextView paymentFormEditTextView3 = this.f1798i;
        PaymentFormEditTextView paymentFormEditTextView4 = this.al;
        cardFormInputControllerFragment2.ar = paymentFormEditTextView;
        cardFormInputControllerFragment2.ar.setInputType(4);
        cardFormInputControllerFragment2.as = paymentFormEditTextView2;
        cardFormInputControllerFragment2.as.setInputType(4);
        cardFormInputControllerFragment2.at = paymentFormEditTextView3;
        cardFormInputControllerFragment2.at.setInputType(4);
        cardFormInputControllerFragment2.au = paymentFormEditTextView4;
        cardFormInputControllerFragment2.au.setInputType(4);
    }

    private void at() {
        final Activity activity = (Activity) ContextUtils.a(getContext(), Activity.class);
        PaymentsTitleBarViewStub paymentsTitleBarViewStub = (PaymentsTitleBarViewStub) e(2131558562);
        PaymentsDecoratorParams paymentsDecoratorParams = this.ao.mo78a().f1774c.f1855c;
        paymentsTitleBarViewStub.m2241a((ViewGroup) this.T, new OnBackPressedListener(this) {
            final /* synthetic */ CardFormFragment f1786b;

            public final void m1992a() {
                activity.onBackPressed();
            }
        }, paymentsDecoratorParams.f1759b.getTitleBarStyle(), paymentsDecoratorParams.f1758a.getTitleBarNavIconStyle());
        this.an = paymentsTitleBarViewStub.f2007c;
        this.an.setOnToolbarButtonListener(new C01915(this));
        av(this);
    }

    public static void av(CardFormFragment cardFormFragment) {
        String str;
        String str2 = (String) MoreObjects.firstNonNull(cardFormFragment.ao.mo78a().f1774c.f1854b, cardFormFragment.b(2131238329));
        if (cardFormFragment.ao.mo78a().f1775d == null) {
            str = (String) MoreObjects.firstNonNull(cardFormFragment.ao.mo78a().f1774c.f1853a, cardFormFragment.jW_().getString(2131238330));
        } else {
            str = (String) MoreObjects.firstNonNull(cardFormFragment.ao.mo78a().f1774c.f1853a, cardFormFragment.jW_().getString(2131238331));
        }
        cardFormFragment.an.setTitle(str);
        cardFormFragment.as.g = str2;
        cardFormFragment.an.setButtonSpecs(ImmutableList.of(cardFormFragment.as.a()));
    }

    public static void aw(CardFormFragment cardFormFragment) {
        cardFormFragment.am.setVisibility(0);
        cardFormFragment.f1795f.setAlpha(0.2f);
        cardFormFragment.ap.m2015a(false);
        Activity ao = cardFormFragment.ao();
        if (ao != null) {
            ao.setRequestedOrientation(14);
        }
    }

    public static void ax(CardFormFragment cardFormFragment) {
        cardFormFragment.am.setVisibility(8);
        cardFormFragment.f1795f.setAlpha(1.0f);
        cardFormFragment.ap.m2015a(true);
        Activity ao = cardFormFragment.ao();
        if (ao != null) {
            ao.setRequestedOrientation(2);
        }
    }
}
