package com.facebook.crudolib.net;

import com.facebook.crudolib.net.AppRequest.Builder;
import com.facebook.crudolib.netengine.HttpEngineRequest$Builder;

/* compiled from: Today Fragment does not contain NotificationCardShell */
public class RequestBuilder {
    public final CrudoNet f24033a;
    private final RequestFactory f24034b;
    public final Builder f24035c;
    public final HttpEngineRequest$Builder f24036d;

    public RequestBuilder(CrudoNet crudoNet, RequestFactory requestFactory, Builder builder) {
        this.f24033a = crudoNet;
        this.f24034b = requestFactory;
        this.f24035c = builder;
        this.f24036d = builder.f24007a;
    }

    public final RequestBuilder m25972a(String str, String str2) {
        this.f24036d.mo1114b(str, str2);
        return this;
    }
}
