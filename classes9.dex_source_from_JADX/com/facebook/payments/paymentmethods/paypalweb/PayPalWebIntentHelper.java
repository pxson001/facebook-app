package com.facebook.payments.paymentmethods.paypalweb;

import android.content.Intent;
import android.net.Uri.Builder;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.payments.model.PaymentItemType;

/* compiled from: boosted_post_key */
public class PayPalWebIntentHelper {

    /* compiled from: boosted_post_key */
    /* synthetic */ class C21821 {
        static final /* synthetic */ int[] f18713a = new int[PaymentItemType.values().length];

        static {
            try {
                f18713a[PaymentItemType.EVENT_TICKETING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18713a[PaymentItemType.INVOICE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public static Intent m18718a(PaymentItemType paymentItemType, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        Builder builder = new Builder();
        builder.scheme("https").authority("m.facebook.com").appendPath("payments").appendPath("paypal").appendQueryParameter("adact", str).appendQueryParameter("rdruri", FBLinks.a("close/"));
        intent.setData(new Builder().scheme("https").authority("secure.facebook.com").appendPath("payments").appendPath("paypal_init.php").appendQueryParameter("redirect_url", builder.build().toString()).appendQueryParameter("amount_in_cents", "0").appendQueryParameter("user_currency", "USD").appendQueryParameter("is_dg_flow", "0").appendQueryParameter("use_payment_engine", "1").appendQueryParameter("account_id", str).appendQueryParameter("paypal_merchant_group", m18719a(paymentItemType)).build());
        intent.putExtra("force_in_app_browser", true);
        return intent;
    }

    public static String m18719a(PaymentItemType paymentItemType) {
        switch (C21821.f18713a[paymentItemType.ordinal()]) {
            case 1:
                return "86";
            case 2:
                return "65";
            default:
                throw new UnsupportedOperationException("PayPal merchant group not defined for " + paymentItemType);
        }
    }
}
