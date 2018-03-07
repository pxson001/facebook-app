package com.facebook.events.tickets.modal;

import android.content.res.Resources;
import com.facebook.payments.model.PriceFormatter;
import java.math.BigDecimal;

/* compiled from: args_mode */
public class EventBuyTicketStringFormattingUtil {
    private final Resources f19205a;

    public EventBuyTicketStringFormattingUtil(Resources resources) {
        this.f19205a = resources;
    }

    public static CharSequence m19390a(int i, String str, String str2, int i2) {
        return PriceFormatter.a(str2, new BigDecimal(str).multiply(new BigDecimal(i2)).divide(new BigDecimal(i)));
    }

    public final CharSequence m19391b(int i, String str, String str2, int i2) {
        return this.f19205a.getString(2131241920, new Object[]{m19390a(i, str, str2, i2)});
    }
}
