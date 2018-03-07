package com.facebook.payments.confirmation;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.facebook.payments.ui.PaymentsComponentViewHolder;
import com.facebook.payments.ui.PaymentsDividerView;
import com.facebook.payments.ui.PaymentsDividerViewHolder;

/* compiled from: call */
public class SimpleConfirmationRowViewHolderFactory {
    public final PaymentsComponentViewHolder m18653a(ViewGroup viewGroup, ConfirmationRowType confirmationRowType) {
        switch (confirmationRowType) {
            case CHECK_MARK:
                return new ConfirmationCheckMarkViewHolder((ConfirmationCheckMarkRowView) LayoutInflater.from(viewGroup.getContext()).inflate(2130907794, viewGroup, false));
            case PRODUCT_PURCHASE_SECTION:
                return new SimpleProductPurchaseRowViewHolder((SimpleProductPurchaseRowView) LayoutInflater.from(viewGroup.getContext()).inflate(2130907800, viewGroup, false));
            case DIVIDER:
                return new PaymentsDividerViewHolder(new PaymentsDividerView(viewGroup.getContext()));
            case POST_PURCHASE_ACTION:
                return new PostPurchaseActionRowViewHolder((PostPurchaseActionRowView) LayoutInflater.from(viewGroup.getContext()).inflate(2130907797, viewGroup, false));
            default:
                throw new UnsupportedOperationException("Unhandled row : " + confirmationRowType);
        }
    }
}
