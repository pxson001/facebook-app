package com.facebook.messaging.payment.value.input;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.payment.currency.CurrencyFormatType;
import com.facebook.messaging.payment.currency.PaymentCurrencyUtil;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentPlatformItemModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentPlatformItemModel.MerchantLogoModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentPlatformItemModel.PlatformImagesModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentShippingOptionModel;
import com.facebook.messaging.payment.service.model.cards.ManualTransferMethod;
import com.facebook.messaging.payment.service.model.cards.NetBankingMethod;
import com.facebook.messaging.payment.ui.PaymentMethodWithImageView;
import com.facebook.messaging.payment.ui.PlatformCommerceAmountView;
import com.facebook.messaging.payment.ui.model.PlatformCommerceAmountViewParams;
import com.facebook.messaging.payment.ui.model.PlatformCommerceAmountViewParamsBuilder;
import com.facebook.messaging.payment.value.input.EnterPaymentValueFragment.C17747;
import com.facebook.payments.checkout.recyclerview.TermsAndPoliciesCheckoutView;
import com.facebook.payments.model.PaymentItemType;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.facebook.payments.paymentmethods.model.PaymentMethodType;
import com.facebook.payments.shipping.model.MailingAddress;
import com.facebook.payments.shipping.model.SimpleMailingAddressFormatter;
import com.facebook.payments.ui.FloatingLabelMultiOptionsView;
import com.facebook.payments.ui.FloatingLabelMultiOptionsView.Listener;
import com.facebook.payments.ui.FloatingLabelMultiOptionsView.Mode;
import com.facebook.payments.ui.FloatingLabelMultiOptionsViewParams;
import com.facebook.payments.ui.FloatingLabelMultiOptionsViewParamsBuilder;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;
import com.facebook.payments.ui.SingleItemInfoView;
import com.facebook.payments.ui.SingleItemInfoViewParams;
import com.facebook.payments.ui.SingleItemInfoViewParamsBuilder;
import com.facebook.payments.util.PaymentMethodUtil;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.text.BetterButton;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: external_attachment_sha256_hash */
public class MCMessengerPayView extends CustomRelativeLayout implements MessengerPayView {
    @Inject
    public Context f15359a;
    @Inject
    public PaymentCurrencyUtil f15360b;
    @Inject
    public SecureContextHelper f15361c;
    public FbDraweeView f15362d;
    public SingleItemInfoView f15363e;
    public PlatformCommerceAmountView f15364f;
    public FloatingLabelMultiOptionsView f15365g;
    public FloatingLabelMultiOptionsView f15366h;
    public FloatingLabelMultiOptionsView f15367i;
    public PaymentMethodWithImageView f15368j;
    public TermsAndPoliciesCheckoutView f15369k;
    public BetterButton f15370l;
    public MCMessengerPayViewParams f15371m;
    public C17747 f15372n;

    /* compiled from: external_attachment_sha256_hash */
    public class C17891 implements OnClickListener {
        final /* synthetic */ MCMessengerPayView f15353a;

        public C17891(MCMessengerPayView mCMessengerPayView) {
            this.f15353a = mCMessengerPayView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 224893043);
            this.f15353a.f15372n.m15635h();
            Logger.a(2, EntryType.UI_INPUT_END, -395083129, a);
        }
    }

    /* compiled from: external_attachment_sha256_hash */
    public class C17902 implements Listener {
        final /* synthetic */ MCMessengerPayView f15354a;

        public C17902(MCMessengerPayView mCMessengerPayView) {
            this.f15354a = mCMessengerPayView;
        }

        public final void m15697b() {
            EnterPaymentValueFragment.aN(this.f15354a.f15372n.f15276a);
        }

        public final void m15696a() {
            EnterPaymentValueFragment.aR(this.f15354a.f15372n.f15276a);
        }
    }

    /* compiled from: external_attachment_sha256_hash */
    public class C17913 implements Listener {
        final /* synthetic */ MCMessengerPayView f15355a;

        public C17913(MCMessengerPayView mCMessengerPayView) {
            this.f15355a = mCMessengerPayView;
        }

        public final void m15699b() {
            this.f15355a.f15372n.m15633f();
        }

        public final void m15698a() {
            this.f15355a.f15372n.m15633f();
        }
    }

    /* compiled from: external_attachment_sha256_hash */
    public class C17924 implements Listener {
        final /* synthetic */ MCMessengerPayView f15356a;

        public C17924(MCMessengerPayView mCMessengerPayView) {
            this.f15356a = mCMessengerPayView;
        }

        public final void m15701b() {
            this.f15356a.f15372n.m15630b();
        }

        public final void m15700a() {
            this.f15356a.f15372n.m15632c();
        }
    }

    /* compiled from: external_attachment_sha256_hash */
    public class C17935 extends SimplePaymentsComponentCallback {
        final /* synthetic */ MCMessengerPayView f15357a;

        public C17935(MCMessengerPayView mCMessengerPayView) {
            this.f15357a = mCMessengerPayView;
        }

        public final void m15702b(Intent intent) {
            this.f15357a.f15361c.b(intent, this.f15357a.f15359a);
        }
    }

    /* compiled from: external_attachment_sha256_hash */
    public class C17946 implements OnClickListener {
        final /* synthetic */ MCMessengerPayView f15358a;

        public C17946(MCMessengerPayView mCMessengerPayView) {
            this.f15358a = mCMessengerPayView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -488515044);
            if (this.f15358a.f15372n != null) {
                this.f15358a.f15372n.m15630b();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1275195514, a);
        }
    }

    public static void m15705a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        MCMessengerPayView mCMessengerPayView = (MCMessengerPayView) obj;
        Context context2 = (Context) injectorLike.getInstance(Context.class);
        PaymentCurrencyUtil a = PaymentCurrencyUtil.m13192a(injectorLike);
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike);
        mCMessengerPayView.f15359a = context2;
        mCMessengerPayView.f15360b = a;
        mCMessengerPayView.f15361c = secureContextHelper;
    }

    public MCMessengerPayView(Context context) {
        this(context, null);
    }

    private MCMessengerPayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private MCMessengerPayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = MCMessengerPayView.class;
        m15705a(this, getContext());
        setContentView(2130905163);
        this.f15362d = (FbDraweeView) a(2131563669);
        this.f15363e = (SingleItemInfoView) a(2131563670);
        this.f15364f = (PlatformCommerceAmountView) a(2131563671);
        this.f15365g = (FloatingLabelMultiOptionsView) a(2131563672);
        this.f15366h = (FloatingLabelMultiOptionsView) a(2131563673);
        this.f15367i = (FloatingLabelMultiOptionsView) a(2131563674);
        this.f15368j = (PaymentMethodWithImageView) a(2131563675);
        this.f15369k = (TermsAndPoliciesCheckoutView) a(2131563676);
        this.f15370l = (BetterButton) a(2131563677);
        this.f15365g.a();
        this.f15366h.a();
        this.f15367i.a();
    }

    @Nullable
    public View getImmediateFocusView() {
        return null;
    }

    public void setListener(C17747 c17747) {
        this.f15372n = c17747;
        this.f15370l.setOnClickListener(new C17891(this));
        this.f15365g.c = new C17902(this);
        this.f15366h.c = new C17913(this);
        this.f15367i.c = new C17924(this);
        this.f15369k.setPaymentsComponentCallback(new C17935(this));
        this.f15368j.setOnClickListener(new C17946(this));
    }

    public void setMessengerPayViewParams(MessengerPayViewParams messengerPayViewParams) {
        this.f15371m = (MCMessengerPayViewParams) messengerPayViewParams;
        m15706b();
    }

    public final void mo620a() {
    }

    private void m15706b() {
        String str;
        MerchantLogoModel lv_ = this.f15371m.f15379g.lv_();
        if (lv_ == null || StringUtil.a(lv_.m13769a())) {
            this.f15362d.setVisibility(8);
        } else {
            this.f15362d.a(Uri.parse(lv_.m13769a()), CallerContext.a(MCMessengerPayView.class));
            this.f15362d.setVisibility(0);
        }
        PaymentPlatformItemModel paymentPlatformItemModel = this.f15371m.f15379g;
        PlatformImagesModel platformImagesModel = (PlatformImagesModel) Iterables.a(paymentPlatformItemModel.lt_(), null);
        ImmutableList d = paymentPlatformItemModel.m13781d();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < d.size(); i++) {
            stringBuilder.append((String) d.get(i));
            if (i < d.size() - 1) {
                stringBuilder.append(" · ");
            }
        }
        SingleItemInfoViewParamsBuilder newBuilder = SingleItemInfoViewParams.newBuilder();
        if (platformImagesModel == null) {
            str = null;
        } else {
            str = platformImagesModel.m13774a();
        }
        newBuilder.a = str;
        SingleItemInfoViewParamsBuilder singleItemInfoViewParamsBuilder = newBuilder;
        singleItemInfoViewParamsBuilder.b = getResources().getDimension(2131429257);
        singleItemInfoViewParamsBuilder = singleItemInfoViewParamsBuilder;
        singleItemInfoViewParamsBuilder.c = paymentPlatformItemModel.m13782g();
        singleItemInfoViewParamsBuilder = singleItemInfoViewParamsBuilder;
        singleItemInfoViewParamsBuilder.d = stringBuilder.toString();
        this.f15363e.setViewParams(singleItemInfoViewParamsBuilder.f());
        this.f15363e.setVisibility(0);
        Optional optional = this.f15371m.f15376d;
        PaymentPlatformItemModel paymentPlatformItemModel2 = this.f15371m.f15379g;
        if (optional == null) {
            this.f15364f.m15509a();
        } else if (optional.isPresent()) {
            PlatformCommerceAmountViewParamsBuilder newBuilder2 = PlatformCommerceAmountViewParams.newBuilder();
            newBuilder2.f15158a = this.f15360b.m13199a(CurrencyFormatType.CURRENCY_SYMBOL_AND_EMPTY_DECIMALS, ((PaymentShippingOptionModel) optional.get()).m13827d(), ((PaymentShippingOptionModel) optional.get()).m13823a());
            newBuilder2 = newBuilder2;
            if (((PaymentShippingOptionModel) optional.get()).lA_() <= 0) {
                str = null;
            } else {
                str = this.f15360b.m13199a(CurrencyFormatType.CURRENCY_SYMBOL_AND_EMPTY_DECIMALS, ((PaymentShippingOptionModel) optional.get()).lA_(), ((PaymentShippingOptionModel) optional.get()).m13823a());
            }
            newBuilder2.f15159b = str;
            newBuilder2 = newBuilder2;
            newBuilder2.f15160c = this.f15360b.m13199a(CurrencyFormatType.CURRENCY_SYMBOL_AND_EMPTY_DECIMALS, ((PaymentShippingOptionModel) optional.get()).m13826c(), ((PaymentShippingOptionModel) optional.get()).m13823a());
            newBuilder2 = newBuilder2;
            newBuilder2.f15161d = this.f15360b.m13199a(CurrencyFormatType.CURRENCY_SYMBOL_AND_EMPTY_DECIMALS, ((PaymentShippingOptionModel) optional.get()).m13828g(), ((PaymentShippingOptionModel) optional.get()).m13823a());
            r0 = newBuilder2.m15511e();
            this.f15364f.m15510b();
            this.f15364f.setViewParams(r0);
        } else {
            PlatformCommerceAmountViewParamsBuilder newBuilder3 = PlatformCommerceAmountViewParams.newBuilder();
            newBuilder3.f15158a = this.f15360b.m13199a(CurrencyFormatType.CURRENCY_SYMBOL_AND_EMPTY_DECIMALS, paymentPlatformItemModel2.lu_().m13691a(), paymentPlatformItemModel2.lu_().m13695b());
            newBuilder3 = newBuilder3;
            newBuilder3.f15160c = "";
            newBuilder3 = newBuilder3;
            newBuilder3.f15161d = this.f15360b.m13199a(CurrencyFormatType.CURRENCY_SYMBOL_AND_EMPTY_DECIMALS, paymentPlatformItemModel2.lu_().m13691a(), paymentPlatformItemModel2.lu_().m13695b());
            r0 = newBuilder3.m15511e();
            this.f15364f.m15510b();
            this.f15364f.setViewParams(r0);
        }
        FloatingLabelMultiOptionsViewParamsBuilder newBuilder4 = FloatingLabelMultiOptionsViewParams.newBuilder();
        if (this.f15371m.f15378f == null || this.f15371m.f15377e == null) {
            newBuilder4.a = Mode.FLOATING_LABEL_TEXT;
            newBuilder4.b = getResources().getString(2131240248);
        } else if (this.f15371m.f15378f.isPresent()) {
            MailingAddress mailingAddress = (MailingAddress) this.f15371m.f15378f.get();
            newBuilder4.a = Mode.FLOATING_LABEL_TEXT;
            FloatingLabelMultiOptionsViewParamsBuilder floatingLabelMultiOptionsViewParamsBuilder = newBuilder4;
            floatingLabelMultiOptionsViewParamsBuilder.b = getResources().getString(2131240248);
            floatingLabelMultiOptionsViewParamsBuilder.c = SimpleMailingAddressFormatter.m18984a(mailingAddress, "%s, %s, %s, %s");
        } else {
            newBuilder4.a = Mode.ACTION_TEXT;
            newBuilder4.d = getResources().getString(2131240116);
        }
        this.f15365g.setViewParams(newBuilder4.e());
        newBuilder4 = FloatingLabelMultiOptionsViewParams.newBuilder();
        if (this.f15371m.f15376d == null || this.f15371m.f15375c == null) {
            newBuilder4.a = Mode.FLOATING_LABEL_TEXT;
            newBuilder4.b = getResources().getString(2131240249);
        } else if (this.f15371m.f15376d.isPresent()) {
            newBuilder4.a = Mode.FLOATING_LABEL_TEXT;
            FloatingLabelMultiOptionsViewParamsBuilder floatingLabelMultiOptionsViewParamsBuilder2 = newBuilder4;
            floatingLabelMultiOptionsViewParamsBuilder2.b = getResources().getString(2131240249);
            floatingLabelMultiOptionsViewParamsBuilder = floatingLabelMultiOptionsViewParamsBuilder2;
            floatingLabelMultiOptionsViewParamsBuilder.c = ((PaymentShippingOptionModel) this.f15371m.f15376d.get()).lz_();
            floatingLabelMultiOptionsViewParamsBuilder.e();
        } else {
            newBuilder4.a = Mode.ACTION_TEXT;
            newBuilder4.d = getResources().getString(2131240552);
        }
        this.f15366h.setViewParams(newBuilder4.e());
        m15707i();
        if (this.f15371m.f15374b == null || !this.f15371m.f15374b.isPresent() || ((PaymentMethod) this.f15371m.f15374b.get()).b().equals(PaymentMethodType.MANUAL_TRANSFER)) {
            this.f15369k.m18591a(getResources().getString(2131240254), Uri.parse("https://m.facebook.com/payments_terms"));
            return;
        }
        this.f15369k.m18591a(getResources().getString(2131240256, new Object[]{"2C2P"}), Uri.parse(StringFormatUtil.formatStrLocaleSafe("https://facebook.com/pay/payments/terms_and_policies?payment_type=%s", PaymentItemType.NMOR_PAGES_COMMERCE.getValue())));
    }

    private void m15707i() {
        this.f15368j.setVisibility(8);
        this.f15367i.setVisibility(0);
        FloatingLabelMultiOptionsViewParamsBuilder newBuilder = FloatingLabelMultiOptionsViewParams.newBuilder();
        CharSequence string = getResources().getString(2131240250);
        if (this.f15371m.f15374b == null) {
            newBuilder.a = Mode.FLOATING_LABEL_TEXT;
            newBuilder.b = string;
        } else if (this.f15371m.f15374b.isPresent()) {
            String string2;
            PaymentMethod paymentMethod = (PaymentMethod) this.f15371m.f15374b.get();
            if (paymentMethod.b().equals(PaymentMethodType.NET_BANKING)) {
                NetBankingMethod netBankingMethod = (NetBankingMethod) paymentMethod;
                string2 = getResources().getString(2131238341, new Object[]{netBankingMethod.f14645d});
            } else if (paymentMethod.b().equals(PaymentMethodType.MANUAL_TRANSFER)) {
                ManualTransferMethod manualTransferMethod = (ManualTransferMethod) paymentMethod;
                String str = manualTransferMethod.f14640d;
                if (manualTransferMethod.f14639c != null) {
                    Uri uri = manualTransferMethod.f14639c;
                    this.f15367i.setVisibility(8);
                    this.f15368j.setVisibility(0);
                    this.f15368j.setText(str);
                    this.f15368j.setHint(string);
                    this.f15368j.setImageUri(uri);
                    return;
                }
                string2 = str;
            } else {
                string2 = PaymentMethodUtil.b((PaymentMethod) this.f15371m.f15374b.get(), getResources());
            }
            newBuilder.a = Mode.FLOATING_LABEL_TEXT;
            FloatingLabelMultiOptionsViewParamsBuilder floatingLabelMultiOptionsViewParamsBuilder = newBuilder;
            floatingLabelMultiOptionsViewParamsBuilder.b = string;
            floatingLabelMultiOptionsViewParamsBuilder = floatingLabelMultiOptionsViewParamsBuilder;
            floatingLabelMultiOptionsViewParamsBuilder.c = string2;
            floatingLabelMultiOptionsViewParamsBuilder.e();
        } else {
            newBuilder.a = Mode.ACTION_TEXT;
            newBuilder.d = getResources().getString(2131240555);
        }
        this.f15367i.setViewParams(newBuilder.e());
    }

    public final void mo621a(@Nullable MenuItem menuItem) {
        Object obj;
        if (this.f15371m.f15374b == null || !this.f15371m.f15374b.isPresent()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            if (this.f15371m.f15378f == null || !this.f15371m.f15378f.isPresent()) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                if (this.f15371m.f15376d == null || !this.f15371m.f15376d.isPresent()) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null && this.f15371m.f15373a == MessengerPayState.PREPARE_PAYMENT) {
                    this.f15370l.setEnabled(true);
                    return;
                }
            }
        }
        this.f15370l.setEnabled(false);
    }
}
