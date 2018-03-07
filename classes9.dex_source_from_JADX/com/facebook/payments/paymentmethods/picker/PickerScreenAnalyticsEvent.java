package com.facebook.payments.paymentmethods.picker;

import com.facebook.analytics.logger.HoneyClientEvent;

/* compiled from: bookmark_new_favorites */
public class PickerScreenAnalyticsEvent extends HoneyClientEvent {

    /* compiled from: bookmark_new_favorites */
    public class Builder {
        public final PickerScreenAnalyticsEvent f18775a;

        public Builder(String str, String str2) {
            this.f18775a = new PickerScreenAnalyticsEvent(str);
            this.f18775a.c = str2;
        }

        public final Builder m18786a(PickerScreenCommonParams pickerScreenCommonParams) {
            this.f18775a.a("flow_context_id", pickerScreenCommonParams.f18785b.f18779d);
            this.f18775a.b("payment_account_id", pickerScreenCommonParams.f18789f);
            this.f18775a.a("flow_type", pickerScreenCommonParams.f18785b.f18778c);
            this.f18775a.b("external_reference_id", pickerScreenCommonParams.f18785b.f18777b);
            this.f18775a.b("item_type", pickerScreenCommonParams.f18787d.getValue());
            return this;
        }

        public final Builder m18787a(String str) {
            this.f18775a.b("credential_id", str);
            return this;
        }
    }

    public static Builder m18788c(String str, String str2) {
        return new Builder(str, str2);
    }

    public PickerScreenAnalyticsEvent(String str) {
        super(str);
    }
}
