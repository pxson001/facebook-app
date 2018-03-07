package com.facebook.payments.checkout.recyclerview;

import android.content.res.Resources;
import com.facebook.common.util.StringUtil;
import com.facebook.payments.checkout.SimpleCheckoutManager;
import com.facebook.payments.checkout.model.CheckoutData;
import com.facebook.payments.checkout.model.CheckoutItemPrice;
import com.facebook.payments.checkout.recyclerview.PayButtonCheckoutRow.State;
import com.facebook.payments.checkout.recyclerview.PriceTableRowView.RowData;
import com.facebook.payments.checkout.recyclerview.decorator.AddPayButtonDecorator;
import com.facebook.payments.checkout.recyclerview.decorator.LoadingPurchaseInfoDecorator;
import com.facebook.payments.checkout.recyclerview.decorator.SimpleCheckoutRows;
import com.facebook.payments.checkout.recyclerview.decorator.SplitWithDividersDecorator;
import com.facebook.payments.checkout.recyclerview.decorator.SuffixWithActionsDecorator;
import com.facebook.payments.checkout.statemachine.CheckoutStateMachineState;
import com.facebook.payments.decorator.PaymentsDecoratorAnimation;
import com.facebook.payments.decorator.PaymentsDecoratorParams;
import com.facebook.payments.model.PaymentItemType;
import com.facebook.payments.model.PaymentsFlowType;
import com.facebook.payments.model.PriceFormatter;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.facebook.payments.paymentmethods.picker.PickerScreenAnalyticsParams;
import com.facebook.payments.paymentmethods.picker.PickerScreenAnalyticsParamsBuilder;
import com.facebook.payments.paymentmethods.picker.PickerScreenCommonParams;
import com.facebook.payments.paymentmethods.picker.PickerScreenCommonParamsBuilder;
import com.facebook.payments.paymentmethods.picker.PickerScreenStyle;
import com.facebook.payments.paymentmethods.picker.PickerScreenStyleParams;
import com.facebook.payments.paymentmethods.picker.PickerScreenStyleParamsBuilder;
import com.facebook.payments.paymentmethods.picker.model.PaymentMethodsPickerScreenFetcherParams;
import com.facebook.payments.shipping.addresspicker.ShippingPickerScreenParams;
import com.facebook.payments.shipping.addresspicker.ShippingPickerScreenParamsBuilder;
import com.facebook.payments.shipping.model.MailingAddress;
import com.facebook.payments.shipping.model.ShippingCommonParams;
import com.facebook.payments.shipping.model.ShippingCommonParamsBuilder;
import com.facebook.payments.shipping.model.ShippingOption;
import com.facebook.payments.shipping.model.ShippingParams;
import com.facebook.payments.shipping.model.ShippingSource;
import com.facebook.payments.shipping.optionpicker.ShippingOptionPickerScreenParams;
import com.facebook.payments.shipping.optionpicker.ShippingOptionPickerScreenParamsBuilder;
import com.facebook.payments.ui.FloatingLabelMultiOptionsView.Mode;
import com.facebook.payments.ui.FloatingLabelMultiOptionsViewParams;
import com.facebook.payments.ui.FloatingLabelMultiOptionsViewParamsBuilder;
import com.facebook.payments.util.PaymentMethodUtil;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSortedMap;
import java.util.Iterator;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: err */
public class SimpleCheckoutRowsGenerator {
    public final Resources f15707a;
    public final SimpleCheckoutManager f15708b;

    @Inject
    public SimpleCheckoutRowsGenerator(Resources resources, SimpleCheckoutManager simpleCheckoutManager) {
        this.f15707a = resources;
        this.f15708b = simpleCheckoutManager;
    }

    public final ImmutableList<CheckoutRow> m15887a(CheckoutData checkoutData) {
        Builder builder = new Builder();
        Iterator it = mo630b(checkoutData).values().iterator();
        while (it.hasNext()) {
            CheckoutRow a = mo629a((CheckoutRowType) it.next(), checkoutData);
            if (a != null) {
                builder.c(a);
            }
        }
        return new AddPayButtonDecorator(new SplitWithDividersDecorator(new LoadingPurchaseInfoDecorator(new SuffixWithActionsDecorator(new SimpleCheckoutRows(builder.b())), this.f15708b.m18491a(checkoutData.mo717a().mo627a().f18459a).mo639a()), (DividerCheckoutRow) m15880a()), (PayButtonCheckoutRow) m15884i(checkoutData)).mo731a();
    }

    protected ImmutableSortedMap<Integer, CheckoutRowType> mo630b(CheckoutData checkoutData) {
        ImmutableSortedMap.Builder b = ImmutableSortedMap.b();
        b.a(Integer.valueOf(1), CheckoutRowType.PRICE_TABLE);
        b.a(Integer.valueOf(2), CheckoutRowType.ADD_MAILING_ADDRESS);
        b.a(Integer.valueOf(3), CheckoutRowType.MAILING_ADDRESS);
        b.a(Integer.valueOf(4), CheckoutRowType.SHIPPING_OPTION);
        b.a(Integer.valueOf(5), CheckoutRowType.ADD_PAYMENT_METHOD);
        b.a(Integer.valueOf(6), CheckoutRowType.PAYMENT_METHOD);
        b.a(Integer.valueOf(7), CheckoutRowType.TERMS_AND_POLICIES);
        return b.a();
    }

    @Nullable
    protected CheckoutRow mo629a(CheckoutRowType checkoutRowType, CheckoutData checkoutData) {
        Optional f;
        switch (checkoutRowType) {
            case ADD_MAILING_ADDRESS:
                AddMailingAddressCheckoutRow addMailingAddressCheckoutRow;
                f = checkoutData.mo722f();
                if (f == null || f.isPresent()) {
                    addMailingAddressCheckoutRow = null;
                } else {
                    SimpleCheckoutSubScreenParamsGenerator d = this.f15708b.m18493d(checkoutData.mo717a().mo627a().f18459a);
                    PaymentsDecoratorParams.Builder a = PaymentsDecoratorParams.newBuilder().a(checkoutData.mo717a().mo627a().f18462d);
                    a.a = PaymentsDecoratorAnimation.MODAL_BOTTOM;
                    PaymentsDecoratorParams c = a.c();
                    ShippingCommonParamsBuilder newBuilder = ShippingCommonParams.newBuilder();
                    newBuilder.f18994a = d.mo644a();
                    newBuilder = newBuilder;
                    newBuilder.f18998e = ShippingSource.CHECKOUT;
                    newBuilder = newBuilder;
                    newBuilder.f18999f = c;
                    addMailingAddressCheckoutRow = new AddMailingAddressCheckoutRow(2131240116, newBuilder.m18972h());
                }
                return addMailingAddressCheckoutRow;
            case ADD_PAYMENT_METHOD:
                AddPaymentMethodCheckoutRow addPaymentMethodCheckoutRow;
                f = checkoutData.mo728l();
                if (f == null || f.isPresent()) {
                    addPaymentMethodCheckoutRow = null;
                } else {
                    addPaymentMethodCheckoutRow = new AddPaymentMethodCheckoutRow(2131233856, this.f15708b.m18493d(checkoutData.mo717a().mo627a().f18459a).m15905d(checkoutData));
                }
                return addPaymentMethodCheckoutRow;
            case DIVIDER:
                return m15880a();
            case MAILING_ADDRESS:
                return m15881f(checkoutData);
            case PAY_BUTTON:
                return m15884i(checkoutData);
            case PAYMENT_METHOD:
                return m15885k(checkoutData);
            case PRICE_TABLE:
                return mo643d(checkoutData);
            case SHIPPING_OPTION:
                return m15882g(checkoutData);
            case TERMS_AND_POLICIES:
                return m15883h(checkoutData);
            default:
                throw new IllegalArgumentException("Unknown CheckoutRowType seen " + checkoutRowType);
        }
    }

    private static CheckoutRow m15880a() {
        return new DividerCheckoutRow();
    }

    @Nullable
    private CheckoutRow m15881f(CheckoutData checkoutData) {
        Optional f = checkoutData.mo722f();
        FloatingLabelMultiOptionsViewParamsBuilder newBuilder = FloatingLabelMultiOptionsViewParams.newBuilder();
        newBuilder.a = Mode.FLOATING_LABEL_TEXT;
        newBuilder = newBuilder;
        newBuilder.b = this.f15707a.getString(2131240248);
        newBuilder = newBuilder;
        if (f == null) {
            return new MailingAddressCheckoutRow(newBuilder.e(), null);
        }
        if (!f.isPresent()) {
            return null;
        }
        newBuilder.c = ((MailingAddress) f.get()).mo761a("%s (%s, %s, %s, %s)");
        SimpleCheckoutSubScreenParamsGenerator d = this.f15708b.m18493d(checkoutData.mo717a().mo627a().f18459a);
        PaymentItemType paymentItemType = checkoutData.mo717a().mo627a().f18460b;
        PickerScreenAnalyticsParamsBuilder newBuilder2 = PickerScreenAnalyticsParams.newBuilder();
        newBuilder2.f18780a = paymentItemType.getValue();
        newBuilder2 = newBuilder2;
        newBuilder2.f18782c = PaymentsFlowType.CHECKOUT_FLOW;
        PickerScreenAnalyticsParams e = newBuilder2.m18789e();
        PaymentsDecoratorParams.Builder a = PaymentsDecoratorParams.newBuilder().a(checkoutData.mo717a().mo627a().f18462d);
        a.a = PaymentsDecoratorAnimation.SLIDE_RIGHT;
        PaymentsDecoratorParams c = a.c();
        PickerScreenStyleParamsBuilder newBuilder3 = PickerScreenStyleParams.newBuilder();
        newBuilder3.f18814a = c;
        PickerScreenStyleParams c2 = newBuilder3.m18827c();
        PickerScreenCommonParamsBuilder newBuilder4 = PickerScreenCommonParams.newBuilder();
        newBuilder4.f18794b = c2;
        PickerScreenCommonParamsBuilder pickerScreenCommonParamsBuilder = newBuilder4;
        pickerScreenCommonParamsBuilder.f18793a = e;
        PickerScreenCommonParamsBuilder pickerScreenCommonParamsBuilder2 = pickerScreenCommonParamsBuilder;
        pickerScreenCommonParamsBuilder2.f18795c = PickerScreenStyle.SIMPLE_SHIPPING_ADDRESS;
        pickerScreenCommonParamsBuilder2 = pickerScreenCommonParamsBuilder2;
        pickerScreenCommonParamsBuilder2.f18796d = paymentItemType;
        PickerScreenCommonParamsBuilder pickerScreenCommonParamsBuilder3 = pickerScreenCommonParamsBuilder2;
        pickerScreenCommonParamsBuilder3.f18799g = d.f15734a.getString(2131240117);
        pickerScreenCommonParamsBuilder3 = pickerScreenCommonParamsBuilder3;
        pickerScreenCommonParamsBuilder3.f18800h = PaymentMethodsPickerScreenFetcherParams.newBuilder().m18855d();
        PickerScreenCommonParams j = pickerScreenCommonParamsBuilder3.m18799j();
        PaymentsDecoratorParams.Builder a2 = PaymentsDecoratorParams.newBuilder().a(checkoutData.mo717a().mo627a().f18462d);
        a2.a = PaymentsDecoratorAnimation.MODAL_BOTTOM;
        PaymentsDecoratorParams c3 = a2.c();
        ShippingCommonParamsBuilder newBuilder5 = ShippingCommonParams.newBuilder();
        newBuilder5.f18994a = d.mo644a();
        newBuilder5 = newBuilder5;
        newBuilder5.f18998e = ShippingSource.CHECKOUT;
        newBuilder5 = newBuilder5;
        newBuilder5.f18999f = c3;
        ShippingCommonParamsBuilder shippingCommonParamsBuilder = newBuilder5;
        shippingCommonParamsBuilder.f19000g = checkoutData.mo723g().size();
        ShippingParams h = shippingCommonParamsBuilder.m18972h();
        ShippingPickerScreenParamsBuilder newBuilder6 = ShippingPickerScreenParams.newBuilder();
        newBuilder6.f18902a = j;
        ShippingPickerScreenParamsBuilder shippingPickerScreenParamsBuilder = newBuilder6;
        shippingPickerScreenParamsBuilder.f18903b = h;
        shippingPickerScreenParamsBuilder = shippingPickerScreenParamsBuilder;
        shippingPickerScreenParamsBuilder.f18904c = checkoutData.mo723g();
        ShippingPickerScreenParamsBuilder shippingPickerScreenParamsBuilder2 = shippingPickerScreenParamsBuilder;
        shippingPickerScreenParamsBuilder2.f18905d = ((MailingAddress) checkoutData.mo722f().get()).mo760a();
        return new MailingAddressCheckoutRow(newBuilder.e(), shippingPickerScreenParamsBuilder2.m18909e());
    }

    @Nullable
    private CheckoutRow m15882g(CheckoutData checkoutData) {
        Optional h = checkoutData.mo724h();
        FloatingLabelMultiOptionsViewParamsBuilder newBuilder = FloatingLabelMultiOptionsViewParams.newBuilder();
        newBuilder.a = Mode.FLOATING_LABEL_TEXT;
        newBuilder = newBuilder;
        newBuilder.b = this.f15707a.getString(2131240249);
        newBuilder = newBuilder;
        if (h == null) {
            return new ShippingOptionCheckoutRow(newBuilder.e(), null);
        }
        if (!h.isPresent()) {
            return null;
        }
        newBuilder.c = ((ShippingOption) h.get()).mo647b();
        SimpleCheckoutSubScreenParamsGenerator d = this.f15708b.m18493d(checkoutData.mo717a().mo627a().f18459a);
        PaymentItemType paymentItemType = checkoutData.mo717a().mo627a().f18460b;
        PickerScreenAnalyticsParamsBuilder newBuilder2 = PickerScreenAnalyticsParams.newBuilder();
        newBuilder2.f18780a = paymentItemType.getValue();
        newBuilder2 = newBuilder2;
        newBuilder2.f18782c = PaymentsFlowType.CHECKOUT_FLOW;
        PickerScreenAnalyticsParams e = newBuilder2.m18789e();
        PaymentsDecoratorParams.Builder a = PaymentsDecoratorParams.newBuilder().a(checkoutData.mo717a().mo627a().f18462d);
        a.a = PaymentsDecoratorAnimation.SLIDE_RIGHT;
        PaymentsDecoratorParams c = a.c();
        PickerScreenStyleParamsBuilder newBuilder3 = PickerScreenStyleParams.newBuilder();
        newBuilder3.f18814a = c;
        PickerScreenStyleParams c2 = newBuilder3.m18827c();
        PickerScreenCommonParamsBuilder newBuilder4 = PickerScreenCommonParams.newBuilder();
        newBuilder4.f18794b = c2;
        PickerScreenCommonParamsBuilder pickerScreenCommonParamsBuilder = newBuilder4;
        pickerScreenCommonParamsBuilder.f18793a = e;
        PickerScreenCommonParamsBuilder pickerScreenCommonParamsBuilder2 = pickerScreenCommonParamsBuilder;
        pickerScreenCommonParamsBuilder2.f18795c = d.mo645c();
        pickerScreenCommonParamsBuilder2 = pickerScreenCommonParamsBuilder2;
        pickerScreenCommonParamsBuilder2.f18796d = paymentItemType;
        PickerScreenCommonParamsBuilder pickerScreenCommonParamsBuilder3 = pickerScreenCommonParamsBuilder2;
        pickerScreenCommonParamsBuilder3.f18799g = d.f15734a.getString(2131240119);
        pickerScreenCommonParamsBuilder3 = pickerScreenCommonParamsBuilder3;
        pickerScreenCommonParamsBuilder3.f18800h = PaymentMethodsPickerScreenFetcherParams.newBuilder().m18855d();
        PickerScreenCommonParams j = pickerScreenCommonParamsBuilder3.m18799j();
        ShippingOptionPickerScreenParamsBuilder newBuilder5 = ShippingOptionPickerScreenParams.newBuilder();
        newBuilder5.f19030a = j;
        newBuilder5 = newBuilder5;
        newBuilder5.f19032c = ((ShippingOption) checkoutData.mo724h().get()).mo646a();
        ShippingOptionPickerScreenParamsBuilder shippingOptionPickerScreenParamsBuilder = newBuilder5;
        shippingOptionPickerScreenParamsBuilder.f19031b = checkoutData.mo725i();
        return new ShippingOptionCheckoutRow(newBuilder.e(), shippingOptionPickerScreenParamsBuilder.m18994d());
    }

    @Nullable
    private CheckoutRow m15883h(CheckoutData checkoutData) {
        if (!mo642c(checkoutData)) {
            return null;
        }
        Object string;
        TermsAndPoliciesParams termsAndPoliciesParams = checkoutData.mo717a().mo627a().f18463e;
        switch (termsAndPoliciesParams.f18570b) {
            case THIRD_PARTY_MERCHANT:
                string = this.f15707a.getString(2131240255, new Object[]{termsAndPoliciesParams.f18573e});
                break;
            case THIRD_PARTY_PROCESSOR:
                string = this.f15707a.getString(2131240256, new Object[]{termsAndPoliciesParams.f18572d});
                break;
            case THIRD_PARTY_PROCESSOR_AND_MERCHANT:
                string = this.f15707a.getString(2131240257, new Object[]{termsAndPoliciesParams.f18572d, termsAndPoliciesParams.f18573e});
                break;
            case FACEBOOK:
                string = this.f15707a.getString(2131240254, new Object[]{termsAndPoliciesParams.f18573e});
                break;
            default:
                string = null;
                break;
        }
        if (StringUtil.a(string)) {
            return null;
        }
        return new TermsAndPoliciesCheckoutRow(string, termsAndPoliciesParams.f18571c);
    }

    private CheckoutRow m15884i(CheckoutData checkoutData) {
        Object obj = 1;
        boolean c = mo642c(checkoutData);
        Object obj2 = checkoutData.mo727k() == CheckoutStateMachineState.PROCESSING_SEND_PAYMENT ? 1 : null;
        if (checkoutData.mo727k() != CheckoutStateMachineState.FINISH) {
            obj = null;
        }
        State state = c ? State.READY_FOR_PAYMENT : obj2 != null ? State.PROCESSING_PAYMENT : obj != null ? State.PAYMENT_COMPLETED : State.INIT;
        return new PayButtonCheckoutRow(state, 2131240252);
    }

    protected boolean mo642c(CheckoutData checkoutData) {
        boolean z = checkoutData.mo728l() != null && checkoutData.mo728l().isPresent();
        boolean z2;
        if (checkoutData.mo727k() == CheckoutStateMachineState.PREPARE_CHECKOUT) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && r3) {
            return true;
        }
        return false;
    }

    @Nullable
    private CheckoutRow m15885k(CheckoutData checkoutData) {
        Optional l = checkoutData.mo728l();
        FloatingLabelMultiOptionsViewParamsBuilder newBuilder = FloatingLabelMultiOptionsViewParams.newBuilder();
        newBuilder.a = Mode.FLOATING_LABEL_TEXT;
        newBuilder = newBuilder;
        newBuilder.b = this.f15707a.getString(2131240250);
        newBuilder = newBuilder;
        if (l == null) {
            return new PaymentMethodCheckoutRow(newBuilder.e(), null);
        }
        if (!l.isPresent()) {
            return null;
        }
        newBuilder.c = PaymentMethodUtil.b((PaymentMethod) l.get(), this.f15707a);
        return new PaymentMethodCheckoutRow(newBuilder.e(), this.f15708b.m18493d(checkoutData.mo717a().mo627a().f18459a).m15905d(checkoutData));
    }

    @Nullable
    protected CheckoutRow mo643d(CheckoutData checkoutData) {
        CheckoutItemPrice c = checkoutData.mo719c();
        if (c == null) {
            return null;
        }
        Preconditions.checkNotNull(c.mo730a());
        return new PriceTableCheckoutRow(ImmutableList.of(new RowData(this.f15707a.getString(2131240251), PriceFormatter.a(c.mo730a()), true)));
    }
}
