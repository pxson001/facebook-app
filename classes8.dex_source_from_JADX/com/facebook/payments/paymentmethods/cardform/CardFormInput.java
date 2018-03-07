package com.facebook.payments.paymentmethods.cardform;

import com.facebook.common.locale.Country;
import com.facebook.common.util.StringUtil;
import com.facebook.payments.paymentmethods.model.BillingAddress;
import com.facebook.payments.paymentmethods.model.CreditCard;
import com.facebook.payments.paymentmethods.model.FbPaymentCardType;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: tap_friends_jewel */
public class CardFormInput {
    @Nullable
    public final String f1799a;
    @Nullable
    public final FbPaymentCardType f1800b;
    public final int f1801c;
    public final int f1802d;
    @Nullable
    public final String f1803e;
    @Nullable
    public final String f1804f;

    @Nullable
    public final String m2002a() {
        if (this.f1800b == null) {
            return null;
        }
        return this.f1800b.getHumanReadableName();
    }

    public final CreditCard m2001a(String str, boolean z, Country country) {
        String b = PaymentMethodInputFormattingUtils.m2051b(this.f1799a);
        return new CreditCard(str, this.f1801c, this.f1802d, StringUtil.b(b, 4), b.substring(0, 6), this.f1800b, true, z, new BillingAddress(this.f1804f, country));
    }

    public CardFormInput(CardFormInputBuilder cardFormInputBuilder) {
        FbPaymentCardType fbPaymentCardType;
        this.f1799a = cardFormInputBuilder.f1805a;
        if (cardFormInputBuilder.f1806b != null || StringUtil.a(this.f1799a)) {
            fbPaymentCardType = cardFormInputBuilder.f1806b;
        } else {
            fbPaymentCardType = PaymentMethodInputFormattingUtils.m2044a(this.f1799a);
        }
        this.f1800b = fbPaymentCardType;
        if (StringUtil.a(cardFormInputBuilder.f1807c)) {
            this.f1801c = cardFormInputBuilder.f1808d;
            this.f1802d = cardFormInputBuilder.f1809e;
        } else {
            String[] split = cardFormInputBuilder.f1807c.split("/");
            this.f1801c = Integer.parseInt(split[0]);
            this.f1802d = Integer.parseInt(split[1]);
        }
        this.f1803e = cardFormInputBuilder.f1810f;
        this.f1804f = cardFormInputBuilder.f1811g;
    }
}
