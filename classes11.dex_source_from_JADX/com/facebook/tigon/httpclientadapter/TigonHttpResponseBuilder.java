package com.facebook.tigon.httpclientadapter;

import com.facebook.tigon.tigonapi.TigonResponse;
import java.util.Map.Entry;
import javax.annotation.Nonnull;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.message.BasicHttpResponse;

/* compiled from: not_flatbuffer_parser */
public class TigonHttpResponseBuilder {
    @Nonnull
    static HttpResponse m6244a(int i, TigonResponse tigonResponse) {
        int i2 = tigonResponse.f5057a;
        String str = (String) TigonHttpUtils.f4971a.get(i2);
        if (str == null) {
            str = Integer.toString(i2);
        }
        String str2 = str;
        HttpResponse basicHttpResponse = new BasicHttpResponse(HttpVersion.HTTP_1_1, tigonResponse.f5057a, str2);
        TigonHttpClientAdapterImpl.m6237a(i, "response", tigonResponse.f5057a + " " + str2);
        for (Entry entry : tigonResponse.f5058b.entrySet()) {
            basicHttpResponse.addHeader((String) entry.getKey(), (String) entry.getValue());
        }
        return basicHttpResponse;
    }
}
