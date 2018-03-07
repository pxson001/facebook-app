package com.facebook.crudolib.netengine.fbhttp;

import org.apache.http.HttpMessage;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.util.EntityUtils;

/* compiled from: TincanAdminMessage */
public class FbHttpEngineResponseHandler implements ResponseHandler<Void> {
    public volatile FbHttpEngineResponse f24072a;

    FbHttpEngineResponseHandler() {
    }

    public Object handleResponse(HttpResponse httpResponse) {
        httpResponse.setEntity(new ByteArrayEntity(EntityUtils.toByteArray(httpResponse.getEntity())));
        FbHttpHeaders fbHttpHeaders = this.f24072a;
        fbHttpHeaders.f24071b = httpResponse;
        fbHttpHeaders.m26005a((HttpMessage) httpResponse);
        fbHttpHeaders.f24070a.m26021a();
        this.f24072a.f24070a.m26024c();
        return null;
    }
}
