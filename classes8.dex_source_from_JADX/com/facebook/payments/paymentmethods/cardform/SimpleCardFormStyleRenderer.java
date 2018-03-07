package com.facebook.payments.paymentmethods.cardform;

import android.content.res.Resources;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.facebook.payments.ui.PaymentsComponentView;
import com.facebook.payments.ui.PaymentsSecurityInfoView;
import javax.annotation.Nullable;

/* compiled from: tag_place_after_tag_people */
public class SimpleCardFormStyleRenderer {
    @Nullable
    public PaymentsComponentView m2088a(ViewGroup viewGroup, CardFormParams cardFormParams) {
        return null;
    }

    @Nullable
    public PaymentsComponentView m2089b(ViewGroup viewGroup, CardFormParams cardFormParams) {
        PaymentsSecurityInfoView paymentsSecurityInfoView = (PaymentsSecurityInfoView) LayoutInflater.from(viewGroup.getContext()).inflate(2130907796, viewGroup, false);
        paymentsSecurityInfoView.setText(2131238333);
        paymentsSecurityInfoView.setLearnMoreUri(Uri.parse("https://m.facebook.com/payer_protection"));
        Resources resources = viewGroup.getResources();
        paymentsSecurityInfoView.setPadding(resources.getDimensionPixelSize(2131429262), resources.getDimensionPixelSize(2131429261), resources.getDimensionPixelSize(2131429263), 0);
        return paymentsSecurityInfoView;
    }
}
