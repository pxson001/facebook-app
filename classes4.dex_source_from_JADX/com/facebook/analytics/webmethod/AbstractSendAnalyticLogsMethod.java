package com.facebook.analytics.webmethod;

import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.tigon.iface.TigonRequest;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: test */
public abstract class AbstractSendAnalyticLogsMethod<RESPONSE> implements ApiMethod<SendAnalyticLogsParams, RESPONSE> {
    private final ApiResponseType f1227a;
    private boolean f1228b = false;

    public final ApiRequest m1478a(Object obj) {
        SendAnalyticLogsParams sendAnalyticLogsParams = (SendAnalyticLogsParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("message", sendAnalyticLogsParams.a));
        a.add(new BasicNameValuePair("compressed", "0"));
        a.add(new BasicNameValuePair("format", "json"));
        if (sendAnalyticLogsParams.b) {
            a.add(new BasicNameValuePair("multi_batch", "1"));
        }
        return new ApiRequest("sendAnalyticsLog", TigonRequest.POST, "logging_client_events", RequestPriority.CAN_WAIT, a, this.f1227a);
    }

    protected AbstractSendAnalyticLogsMethod(ApiResponseType apiResponseType) {
        this.f1227a = apiResponseType;
    }
}
