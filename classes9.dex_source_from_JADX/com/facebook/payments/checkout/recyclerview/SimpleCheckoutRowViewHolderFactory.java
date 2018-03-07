package com.facebook.payments.checkout.recyclerview;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.facebook.payments.ui.FloatingLabelMultiOptionsView;
import com.facebook.payments.ui.PaymentsComponentViewHolder;
import com.facebook.payments.ui.PaymentsDividerView;
import com.facebook.payments.ui.PaymentsDividerViewHolder;

/* compiled from: err_str */
public class SimpleCheckoutRowViewHolderFactory {
    public PaymentsComponentViewHolder mo628a(ViewGroup viewGroup, CheckoutRowType checkoutRowType) {
        switch (checkoutRowType) {
            case ADD_MAILING_ADDRESS:
                return new AddMailingAddressCheckoutViewHolder(m15876j(viewGroup));
            case ADD_PAYMENT_METHOD:
                return new AddPaymentMethodCheckoutViewHolder(m15876j(viewGroup));
            case DIVIDER:
                return new PaymentsDividerViewHolder(new PaymentsDividerView(viewGroup.getContext()));
            case MAILING_ADDRESS:
                return new MailingAddressCheckoutViewHolder(m15877k(viewGroup));
            case PAY_BUTTON:
                return new PayButtonCheckoutViewHolder((PayButtonCheckoutView) LayoutInflater.from(viewGroup.getContext()).inflate(2130907791, viewGroup, false));
            case PAYMENT_METHOD:
                return new PaymentMethodViewHolder(m15877k(viewGroup));
            case PRICE_TABLE:
                return new PriceTableCheckoutViewHolder((PriceTableView) LayoutInflater.from(viewGroup.getContext()).inflate(2130907799, viewGroup, false));
            case SHIPPING_OPTION:
                return new ShippingOptionCheckoutViewHolder(m15877k(viewGroup));
            case TERMS_AND_POLICIES:
                return new TermsAndPoliciesCheckoutViewHolder((TermsAndPoliciesCheckoutView) LayoutInflater.from(viewGroup.getContext()).inflate(2130907793, viewGroup, false));
            default:
                throw new UnsupportedOperationException("Unhandled checkoutRowType: " + checkoutRowType);
        }
    }

    public static CheckoutActionTextRowView m15876j(ViewGroup viewGroup) {
        return (CheckoutActionTextRowView) LayoutInflater.from(viewGroup.getContext()).inflate(2130907788, viewGroup, false);
    }

    public static FloatingLabelMultiOptionsView m15877k(ViewGroup viewGroup) {
        return (FloatingLabelMultiOptionsView) LayoutInflater.from(viewGroup.getContext()).inflate(2130907789, viewGroup, false);
    }
}
