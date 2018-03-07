package com.facebook.push.mqtt.service;

import com.facebook.common.errorreporting.FbCustomReportDataSupplier;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.inject.Lazy;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: traffic_stats */
public class ClientSubscriptionDataSupplier implements FbCustomReportDataSupplier {
    private final Lazy<ClientSubscriptionAutoSubscriber> f2273a;

    @Inject
    public ClientSubscriptionDataSupplier(Lazy<ClientSubscriptionAutoSubscriber> lazy) {
        this.f2273a = lazy;
    }

    public final String mo633a(Throwable th) {
        Set j = ((ClientSubscriptionAutoSubscriber) this.f2273a.get()).j();
        if (j == null) {
            return "No currently active non-sticky topics";
        }
        return StringFormatUtil.formatStrLocaleSafe("Currently active non-sticky topics : %s", j.toString());
    }

    public final String mo632a() {
        return "mqtt_client_nonsticky_subscription_data";
    }
}
