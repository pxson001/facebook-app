package com.facebook.payments.paymentsflow;

import com.facebook.analytics.logger.HoneyClientEvent;

/* compiled from: page_admin_profile_pic_url_extra */
public class PayViewAnalyticsEvent extends HoneyClientEvent {

    /* compiled from: page_admin_profile_pic_url_extra */
    public class Builder {
        public final PayViewAnalyticsEvent f4363a;

        public Builder(String str, String str2) {
            this.f4363a = new PayViewAnalyticsEvent(str);
            this.f4363a.c = str2;
        }

        public final Builder m5358a(PayViewControllerParams payViewControllerParams) {
            this.f4363a.a("flow_context_id", payViewControllerParams.f4369f);
            this.f4363a.a("flow_type", payViewControllerParams.f4366c);
            this.f4363a.b("external_reference_id", payViewControllerParams.f4365b);
            this.f4363a.b("item_type", payViewControllerParams.f4367d.getValue());
            return this;
        }

        public final Builder m5359a(String str) {
            this.f4363a.b("credential_id", str);
            return this;
        }

        public final Builder m5360b(String str) {
            this.f4363a.b("error_message", str);
            return this;
        }
    }

    public static Builder m5361c(String str, String str2) {
        return new Builder(str, str2);
    }

    public PayViewAnalyticsEvent(String str) {
        super(str);
    }
}
