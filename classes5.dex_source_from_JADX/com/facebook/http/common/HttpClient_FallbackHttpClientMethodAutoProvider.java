package com.facebook.http.common;

import com.facebook.config.server.String_UserAgentStringMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import org.apache.http.client.HttpClient;

/* compiled from: draw */
public class HttpClient_FallbackHttpClientMethodAutoProvider extends AbstractProvider<HttpClient> {
    public Object get() {
        return FbHttpModule.a(String_UserAgentStringMethodAutoProvider.b(this));
    }
}
