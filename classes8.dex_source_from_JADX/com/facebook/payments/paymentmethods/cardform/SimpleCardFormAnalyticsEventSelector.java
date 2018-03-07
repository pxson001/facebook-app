package com.facebook.payments.paymentmethods.cardform;

import com.facebook.common.util.StringUtil;

/* compiled from: tagged_users */
public class SimpleCardFormAnalyticsEventSelector {
    public String m2053a(CardFormParams cardFormParams) {
        return m2052a("card_form_cancel", cardFormParams);
    }

    public String m2054b(CardFormParams cardFormParams) {
        return m2052a("card_form_submitted", cardFormParams);
    }

    public String m2055c(CardFormParams cardFormParams) {
        return m2052a("card_form_success", cardFormParams);
    }

    public String m2056d(CardFormParams cardFormParams) {
        return m2052a("card_form_fail", cardFormParams);
    }

    public String m2057e(CardFormParams cardFormParams) {
        return m2052a("card_form_save_click", cardFormParams);
    }

    public String m2058f(CardFormParams cardFormParams) {
        return m2052a("card_form_done_click", cardFormParams);
    }

    private static String m2052a(String str, CardFormParams cardFormParams) {
        Object obj = cardFormParams.mo78a().f1773b.f1768a;
        return StringUtil.c(obj) ? str : obj + "_" + str;
    }
}
