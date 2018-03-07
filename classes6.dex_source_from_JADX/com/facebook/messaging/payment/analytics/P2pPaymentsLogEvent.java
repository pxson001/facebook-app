package com.facebook.messaging.payment.analytics;

import com.facebook.analytics.logger.HoneyClientEvent;

/* compiled from: unseen_count */
public class P2pPaymentsLogEvent extends HoneyClientEvent {

    /* compiled from: unseen_count */
    public class Builder {
        public final P2pPaymentsLogEvent f2420a;

        public Builder(String str, String str2) {
            this.f2420a = new P2pPaymentsLogEvent(str);
            this.f2420a.c = str2;
        }

        public final Builder m3637a(String str) {
            this.f2420a.b("payment_value", str);
            return this;
        }

        public final Builder m3640c(String str) {
            this.f2420a.b("offline_threading_id", str);
            return this;
        }

        public final Builder m3638a(boolean z) {
            this.f2420a.a("from_payment_trigger", z);
            return this;
        }

        public final Builder m3641d(String str) {
            this.f2420a.b("card_issuer", str);
            return this;
        }

        public final Builder m3642e(String str) {
            this.f2420a.b("tab_name", str);
            return this;
        }

        public final Builder m3643f(String str) {
            this.f2420a.b("request_id", str);
            return this;
        }

        public final Builder m3644g(String str) {
            this.f2420a.b("transaction_id", str);
            return this;
        }

        public final Builder m3645k(String str) {
            this.f2420a.b("message", str);
            return this;
        }

        public final Builder m3646l(String str) {
            this.f2420a.b("error_domain", str);
            return this;
        }

        public final Builder m3647o(String str) {
            this.f2420a.e = str;
            return this;
        }

        public final Builder m3648w(String str) {
            this.f2420a.b("delta_name", str);
            return this;
        }

        public final Builder m3636a(Long l) {
            this.f2420a.a("iris_seq_id", l);
            return this;
        }

        public final P2pPaymentsLogEvent m3639a() {
            return this.f2420a;
        }
    }

    public static P2pPaymentsLogEvent m3649c(String str, String str2) {
        return m3650d(str2, str).f2420a;
    }

    public static Builder m3650d(String str, String str2) {
        return new Builder(str, str2);
    }

    public P2pPaymentsLogEvent(String str) {
        super(str);
    }
}
