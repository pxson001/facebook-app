package com.facebook.payments.paymentmethods.cardform;

import com.facebook.analytics.logger.HoneyClientEvent;

/* compiled from: target_actor_id */
public class CardFormAnalyticsEvent extends HoneyClientEvent {

    /* compiled from: target_actor_id */
    public class Builder {
        public final CardFormAnalyticsEvent f1767a;

        public Builder(String str, String str2) {
            this.f1767a = new CardFormAnalyticsEvent(str2);
            this.f1767a.c = str;
        }

        public final Builder m1968a(String str) {
            this.f1767a.b("card_issuer", str);
            return this;
        }

        public final Builder m1969b(String str) {
            this.f1767a.b("message", str);
            return this;
        }
    }

    public static CardFormAnalyticsEvent m1970c(String str, String str2) {
        return m1971d(str, str2).f1767a;
    }

    public static Builder m1971d(String str, String str2) {
        return new Builder(str, str2);
    }

    public CardFormAnalyticsEvent(String str) {
        super(str);
    }
}
