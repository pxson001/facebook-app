package com.facebook.si;

import com.facebook.auth.credentials.SessionCookie;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.common.FbHttpRequest;
import com.facebook.http.common.FbHttpRequest.Builder;
import com.facebook.http.common.FbHttpRequestProcessor;
import com.facebook.http.interfaces.RequestPriority;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

/* compiled from: media_items */
public class LinkshimServiceHandler implements BlueServiceHandler {
    public final FbHttpRequestProcessor f9000a;
    public LoggedInUserSessionManager f9001b;
    public ObjectMapper f9002c;

    /* compiled from: media_items */
    public class C09301 implements ResponseHandler<EmptyLinkshimResult> {
        final /* synthetic */ LinkshimServiceHandler f8999a;

        public C09301(LinkshimServiceHandler linkshimServiceHandler) {
            this.f8999a = linkshimServiceHandler;
        }

        public Object handleResponse(HttpResponse httpResponse) {
            return new EmptyLinkshimResult();
        }
    }

    @Inject
    public LinkshimServiceHandler(FbHttpRequestProcessor fbHttpRequestProcessor, LoggedInUserSessionManager loggedInUserSessionManager, ObjectMapper objectMapper) {
        this.f9000a = fbHttpRequestProcessor;
        this.f9001b = loggedInUserSessionManager;
        this.f9002c = objectMapper;
    }

    public final OperationResult m10716a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("linkshim_click".equals(str)) {
            String string = operationParams.c.getString("linkshim_link_extra");
            String str2 = this.f9001b.a().mSessionCookiesString;
            StringBuilder stringBuilder = new StringBuilder();
            if (str2 != null) {
                ImmutableList a = SessionCookie.a(this.f9002c, str2);
                if (a != null) {
                    int size = a.size();
                    for (int i = 0; i < size; i++) {
                        stringBuilder.append(((SessionCookie) a.get(i)).toString()).append(";");
                    }
                }
            }
            HttpUriRequest httpGet = new HttpGet(string);
            httpGet.addHeader("Cookie", stringBuilder.toString());
            Builder newBuilder = FbHttpRequest.newBuilder();
            newBuilder.b = httpGet;
            Builder builder = newBuilder;
            builder.c = "linkshim";
            builder = builder;
            builder.l = RequestPriority.INTERACTIVE;
            builder = builder;
            builder.g = new C09301(this);
            this.f9000a.a(builder.a());
            return OperationResult.a;
        }
        throw new IllegalArgumentException("unknown operation type: " + str);
    }
}
