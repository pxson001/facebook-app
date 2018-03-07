package com.facebook.payments.shipping.form;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.locale.Country;
import com.facebook.common.locale.Locales;
import com.facebook.common.util.ContextUtils;
import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.payments.decorator.PaymentsDecoratorParams;
import com.facebook.payments.model.FormFieldProperty;
import com.facebook.payments.paymentmethods.cardform.PaymentFormEditTextView;
import com.facebook.payments.paymentmethods.cardform.formatting.BillingZipFormattingTextWatcher;
import com.facebook.payments.shipping.model.MailingAddress;
import com.facebook.payments.shipping.model.ShippingAddressFormInput;
import com.facebook.payments.shipping.model.ShippingAddressFormInputBuilder;
import com.facebook.payments.shipping.model.ShippingParams;
import com.facebook.payments.shipping.model.ShippingStyle;
import com.facebook.payments.shipping.validation.SimpleShippingStateInputValidator;
import com.facebook.payments.shipping.validation.SimpleShippingZipInputValidator;
import com.facebook.payments.ui.FloatingLabelTextView;
import com.facebook.payments.ui.PaymentsComponentAction;
import com.facebook.payments.ui.PaymentsComponentAction.Action;
import com.facebook.payments.ui.PaymentsComponentView;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;
import com.facebook.payments.ui.titlebar.PaymentsTitleBarViewStub;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.user.model.User;
import com.facebook.widget.SwitchCompat;
import com.facebook.widget.countryselector.CountrySelector;
import com.facebook.widget.countryselector.CountrySelector.OnCountrySelectListener;
import com.facebook.widget.countryselector.CountrySelectorProvider;
import com.facebook.widget.countryspinner.CountryCode;
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
import javax.inject.Provider;

/* compiled from: backstage_stack_open */
public class ShippingAddressFragment extends FbFragment {
    @Inject
    ShippingAddressFormControllerProvider f18949a;
    public SimpleShippingZipInputValidator aA;
    public Country aB;
    public final Builder aC;
    public final SimplePaymentsComponentCallback aD;
    public PaymentFormEditTextView al;
    public PaymentFormEditTextView am;
    public PaymentFormEditTextView an;
    public PaymentFormEditTextView ao;
    public PaymentFormEditTextView ap;
    public FloatingLabelTextView aq;
    public CountrySelector ar;
    private ProgressBar as;
    public FbTitleBar at;
    public LinearLayout au;
    public PaymentsComponentView av;
    public ShippingParams aw;
    public ShippingAddressFormController ax;
    public ListenableFuture ay;
    public SimpleShippingStateInputValidator az;
    @Inject
    @ForUiThread
    public Executor f18950b;
    @Inject
    public SimpleShippingManager f18951c;
    @Inject
    @LoggedInUser
    Provider<User> f18952d;
    @Inject
    Locales f18953e;
    @Inject
    CountrySelectorProvider f18954f;
    private Context f18955g;
    private PaymentFormEditTextView f18956h;
    public Spinner f18957i;

    /* compiled from: backstage_stack_open */
    class C22251 extends SimplePaymentsComponentCallback {
        final /* synthetic */ ShippingAddressFragment f18940a;

        C22251(ShippingAddressFragment shippingAddressFragment) {
            this.f18940a = shippingAddressFragment;
        }

        public final void m18935a(FbDialogFragment fbDialogFragment) {
            fbDialogFragment.a(this.f18940a.kO_(), "shipping_dialog_fragment_tag");
        }

        public final void m18934a(PaymentsComponentAction paymentsComponentAction) {
            ShippingAddressFragment shippingAddressFragment = this.f18940a;
            switch (C22328.f18948a[paymentsComponentAction.a.ordinal()]) {
                case 1:
                    Activity ao = shippingAddressFragment.ao();
                    if (ao != null) {
                        Intent intent = (Intent) paymentsComponentAction.a("extra_activity_result_data");
                        if (intent != null) {
                            ao.setResult(-1, intent);
                        } else {
                            ao.setResult(-1);
                        }
                        ao.finish();
                        return;
                    }
                    return;
                case 2:
                    shippingAddressFragment.f18951c.m18957a(shippingAddressFragment.aw.mo759a().f18987a).mo512a(shippingAddressFragment.aD);
                    shippingAddressFragment.f18951c.m18957a(shippingAddressFragment.aw.mo759a().f18987a).mo511a(paymentsComponentAction, ShippingAddressFragment.ay(shippingAddressFragment));
                    return;
                default:
                    return;
            }
        }

        public final void m18936a(ListenableFuture listenableFuture) {
            ShippingAddressFragment shippingAddressFragment = this.f18940a;
            if (shippingAddressFragment.ay != null) {
                shippingAddressFragment.ay.cancel(true);
            }
            ShippingAddressFragment.aw(shippingAddressFragment);
            shippingAddressFragment.ay = listenableFuture;
            Futures.a(shippingAddressFragment.ay, new C22317(shippingAddressFragment), shippingAddressFragment.f18950b);
        }
    }

    /* compiled from: backstage_stack_open */
    class C22262 implements OnCountrySelectListener {
        final /* synthetic */ ShippingAddressFragment f18941a;

        C22262(ShippingAddressFragment shippingAddressFragment) {
            this.f18941a = shippingAddressFragment;
        }

        public final void m18937a(CountryCode countryCode) {
            this.f18941a.aq.setText(countryCode.f3549c);
            this.f18941a.aB = Country.a(countryCode.f3547a);
            ShippingAddressFragment.au(this.f18941a);
        }
    }

    /* compiled from: backstage_stack_open */
    class C22273 implements OnClickListener {
        final /* synthetic */ ShippingAddressFragment f18942a;

        C22273(ShippingAddressFragment shippingAddressFragment) {
            this.f18942a = shippingAddressFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 293889445);
            this.f18942a.ar.a(view);
            Logger.a(2, EntryType.UI_INPUT_END, 982354286, a);
        }
    }

    /* compiled from: backstage_stack_open */
    public class C22295 extends OnToolbarButtonListener {
        final /* synthetic */ ShippingAddressFragment f18945a;

        public C22295(ShippingAddressFragment shippingAddressFragment) {
            this.f18945a = shippingAddressFragment;
        }

        public final void m18939a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            this.f18945a.ax.m18932a();
        }
    }

    /* compiled from: backstage_stack_open */
    public class C22306 {
        public final /* synthetic */ ShippingAddressFragment f18946a;

        C22306(ShippingAddressFragment shippingAddressFragment) {
            this.f18946a = shippingAddressFragment;
        }

        public final void m18940a(boolean z) {
            this.f18946a.aC.d = z;
            this.f18946a.at.setButtonSpecs(ImmutableList.of(this.f18946a.aC.a()));
        }
    }

    /* compiled from: backstage_stack_open */
    public class C22317 extends ResultFutureCallback<Object> {
        final /* synthetic */ ShippingAddressFragment f18947a;

        public C22317(ShippingAddressFragment shippingAddressFragment) {
            this.f18947a = shippingAddressFragment;
        }

        protected final void m18942a(Object obj) {
            ShippingAddressFragment.ax(this.f18947a);
        }

        protected final void m18941a(ServiceException serviceException) {
            ShippingAddressFragment.ax(this.f18947a);
        }
    }

    /* compiled from: backstage_stack_open */
    public /* synthetic */ class C22328 {
        public static final /* synthetic */ int[] f18948a = new int[Action.values().length];

        static {
            try {
                f18948a[Action.FINISH_ACTIVITY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18948a[Action.MUTATION.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public static void m18945a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ShippingAddressFragment) obj).m18944a((ShippingAddressFormControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ShippingAddressFormControllerProvider.class), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), SimpleShippingManager.m18955a(injectorLike), IdBasedProvider.a(injectorLike, 3595), Locales.a(injectorLike), (CountrySelectorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CountrySelectorProvider.class));
    }

    public ShippingAddressFragment() {
        Builder a = TitleBarButtonSpec.a();
        a.d = false;
        this.aC = a;
        this.aD = new C22251(this);
    }

    public static ShippingAddressFormInput ay(ShippingAddressFragment shippingAddressFragment) {
        boolean isChecked;
        ShippingAddressFormInputBuilder shippingAddressFormInputBuilder = new ShippingAddressFormInputBuilder();
        shippingAddressFormInputBuilder.f18972a = shippingAddressFragment.f18956h.getInputText();
        ShippingAddressFormInputBuilder shippingAddressFormInputBuilder2 = shippingAddressFormInputBuilder;
        shippingAddressFormInputBuilder2.f18973b = (String) shippingAddressFragment.f18957i.getSelectedItem();
        shippingAddressFormInputBuilder = shippingAddressFormInputBuilder2;
        shippingAddressFormInputBuilder.f18974c = shippingAddressFragment.al.getInputText();
        shippingAddressFormInputBuilder = shippingAddressFormInputBuilder;
        shippingAddressFormInputBuilder.f18975d = shippingAddressFragment.am.getInputText();
        shippingAddressFormInputBuilder = shippingAddressFormInputBuilder;
        shippingAddressFormInputBuilder.f18976e = shippingAddressFragment.an.getInputText();
        shippingAddressFormInputBuilder = shippingAddressFormInputBuilder;
        shippingAddressFormInputBuilder.f18977f = shippingAddressFragment.ao.getInputText();
        shippingAddressFormInputBuilder = shippingAddressFormInputBuilder;
        shippingAddressFormInputBuilder.f18978g = shippingAddressFragment.ap.getInputText();
        shippingAddressFormInputBuilder = shippingAddressFormInputBuilder;
        shippingAddressFormInputBuilder.f18979h = shippingAddressFragment.aB;
        shippingAddressFormInputBuilder = shippingAddressFormInputBuilder;
        if (shippingAddressFragment.av != null) {
            isChecked = ((SwitchCompat) shippingAddressFragment.e(2131565822)).isChecked();
        } else {
            isChecked = false;
        }
        shippingAddressFormInputBuilder.f18980i = isChecked;
        return new ShippingAddressFormInput(shippingAddressFormInputBuilder);
    }

    public final void m18950c(Bundle bundle) {
        SimpleShippingStateInputValidator simpleShippingStateInputValidator;
        SimpleShippingZipInputValidator simpleShippingZipInputValidator;
        super.c(bundle);
        this.f18955g = ContextUtils.a(getContext(), 2130772893, 2131624691);
        Class cls = ShippingAddressFragment.class;
        m18945a((Object) this, this.f18955g);
        this.aw = (ShippingParams) this.s.getParcelable("extra_shipping_address_params");
        this.aB = (Country) MoreObjects.firstNonNull(this.aw.mo759a().f18988b, Country.a(this.f18953e.a()));
        e(true);
        SimpleShippingManager simpleShippingManager = this.f18951c;
        ShippingStyle shippingStyle = this.aw.mo759a().f18987a;
        if (simpleShippingManager.f18960a.containsKey(shippingStyle)) {
            simpleShippingStateInputValidator = (SimpleShippingStateInputValidator) ((ShippingStyleAssociation) simpleShippingManager.f18960a.get(shippingStyle)).f13102d.get();
        } else {
            simpleShippingStateInputValidator = (SimpleShippingStateInputValidator) ((ShippingStyleAssociation) simpleShippingManager.f18960a.get(ShippingStyle.SIMPLE)).f13102d.get();
        }
        this.az = simpleShippingStateInputValidator;
        this.az.mo514a(this.aB);
        simpleShippingManager = this.f18951c;
        shippingStyle = this.aw.mo759a().f18987a;
        if (simpleShippingManager.f18960a.containsKey(shippingStyle)) {
            simpleShippingZipInputValidator = (SimpleShippingZipInputValidator) ((ShippingStyleAssociation) simpleShippingManager.f18960a.get(shippingStyle)).f13103e.get();
        } else {
            simpleShippingZipInputValidator = (SimpleShippingZipInputValidator) ((ShippingStyleAssociation) simpleShippingManager.f18960a.get(ShippingStyle.SIMPLE)).f13103e.get();
        }
        this.aA = simpleShippingZipInputValidator;
        this.aA.mo518a(this.aB);
    }

    public final View m18948a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2113547520);
        View inflate = layoutInflater.cloneInContext(this.f18955g).inflate(2130907082, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1781844232, a);
        return inflate;
    }

    public final void m18949a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f18956h = (PaymentFormEditTextView) e(2131559551);
        this.f18957i = (Spinner) e(2131567425);
        this.al = (PaymentFormEditTextView) e(2131567426);
        this.am = (PaymentFormEditTextView) e(2131567427);
        this.an = (PaymentFormEditTextView) e(2131567428);
        this.ao = (PaymentFormEditTextView) e(2131567429);
        this.ap = (PaymentFormEditTextView) e(2131560206);
        this.aq = (FloatingLabelTextView) e(2131567430);
        this.au = (LinearLayout) e(2131567424);
        this.as = (ProgressBar) e(2131567431);
        this.f18956h.setInputText(((User) this.f18952d.get()).k());
        this.ao.setMaxLength(this.az.mo513a());
        this.ap.setMaxLength(this.aA.mo517a());
        this.ar = this.f18954f.m3342a(getContext(), false);
        this.ar.f3545u = new C22262(this);
        this.aq.setText(this.aB.a());
        this.aq.setOnClickListener(new C22273(this));
        if (bundle == null) {
            MailingAddress mailingAddress = this.aw.mo759a().f18990d;
            if (mailingAddress != null) {
                this.f18957i.setSelection(((ArrayAdapter) this.f18957i.getAdapter()).getPosition(mailingAddress.mo766f()));
                this.al.setInputText(mailingAddress.mo762b());
                this.am.setInputText(mailingAddress.mo763c());
                this.an.setInputText(mailingAddress.mo767g());
                this.ao.setInputText(mailingAddress.mo768h());
                this.ap.setInputText(mailingAddress.mo764d());
            }
        }
        SimpleShippingStyleRenderer b = this.f18951c.m18958b(this.aw.mo759a().f18987a);
        b.f13106c = this.aD;
        this.av = b.m13419a(this.au, this.aw);
        this.au.addView((View) this.av);
        final Activity activity = (Activity) ContextUtils.a(getContext(), Activity.class);
        PaymentsTitleBarViewStub paymentsTitleBarViewStub = (PaymentsTitleBarViewStub) e(2131558562);
        PaymentsDecoratorParams paymentsDecoratorParams = this.aw.mo759a().f18992f;
        paymentsTitleBarViewStub.a((ViewGroup) this.T, new OnBackPressedListener(this) {
            final /* synthetic */ ShippingAddressFragment f18944b;

            public final void m18938a() {
                activity.onBackPressed();
            }
        }, paymentsDecoratorParams.b.getTitleBarStyle(), paymentsDecoratorParams.a.getTitleBarNavIconStyle());
        this.at = paymentsTitleBarViewStub.c;
        this.at.setTitle(b(2131240087));
        this.aC.g = b(2131240088);
        this.at.setButtonSpecs(ImmutableList.of(this.aC.a()));
        this.at.setOnToolbarButtonListener(new C22295(this));
        this.ax = new ShippingAddressFormController(kO_(), BillingZipFormattingTextWatcher.a(this.f18949a));
        at();
        m18943a(this.aB);
        m18946b(this.aB);
    }

    public final void m18947I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 830599594);
        super.I();
        if (this.ay != null) {
            this.ay.cancel(true);
            this.ay = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 964491038, a);
    }

    private void at() {
        this.ax.f18936n = this.az;
        this.ax.f18937o = this.aA;
        this.ax.m18930a(this.f18956h, this.al, this.am, this.an, this.ao, this.ap);
        this.ax.f18923a = new C22306(this);
    }

    public static void au(ShippingAddressFragment shippingAddressFragment) {
        shippingAddressFragment.m18943a(shippingAddressFragment.aB);
        shippingAddressFragment.az.mo514a(shippingAddressFragment.aB);
        shippingAddressFragment.ao.setMaxLength(shippingAddressFragment.az.mo513a());
        shippingAddressFragment.aA.mo518a(shippingAddressFragment.aB);
        shippingAddressFragment.ap.setMaxLength(shippingAddressFragment.aA.mo517a());
        shippingAddressFragment.at();
        shippingAddressFragment.m18946b(shippingAddressFragment.aB);
    }

    private void m18943a(Country country) {
        this.ax.f18939q = Country.a.equals(country) ? FormFieldProperty.REQUIRED : FormFieldProperty.OPTIONAL;
    }

    private void m18946b(Country country) {
        if (Country.a.equals(country)) {
            this.am.setHint(b(2131240091));
            this.an.setHint(b(2131240092));
            this.ao.setHint(b(2131240093));
            this.ap.setHint(b(2131240094));
            return;
        }
        this.am.setHint(b(2131240095));
        this.an.setHint(b(2131240096));
        this.ao.setHint(b(2131240097));
        this.ap.setHint(b(2131240098));
    }

    private void m18944a(ShippingAddressFormControllerProvider shippingAddressFormControllerProvider, Executor executor, ShippingManager shippingManager, Provider<User> provider, Locales locales, CountrySelectorProvider countrySelectorProvider) {
        this.f18949a = shippingAddressFormControllerProvider;
        this.f18950b = executor;
        this.f18951c = shippingManager;
        this.f18952d = provider;
        this.f18953e = locales;
        this.f18954f = countrySelectorProvider;
    }

    public static void aw(ShippingAddressFragment shippingAddressFragment) {
        shippingAddressFragment.as.setVisibility(0);
        shippingAddressFragment.au.setAlpha(0.2f);
        shippingAddressFragment.ax.m18931a(false);
    }

    public static void ax(ShippingAddressFragment shippingAddressFragment) {
        shippingAddressFragment.as.setVisibility(8);
        shippingAddressFragment.au.setAlpha(1.0f);
        shippingAddressFragment.ax.m18931a(true);
    }
}
