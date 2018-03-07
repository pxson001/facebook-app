package com.facebook.platform.opengraph.server;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.tigon.iface.TigonRequest;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* compiled from: gcm_deleted_messages */
public class PublishOpenGraphActionMethod implements ApiMethod<Params, String> {
    private static final Class<?> f11313a = PublishOpenGraphActionMethod.class;

    public static PublishOpenGraphActionMethod m11729a(InjectorLike injectorLike) {
        return new PublishOpenGraphActionMethod();
    }

    public final ApiRequest m11730a(Object obj) {
        Params params = (Params) obj;
        Preconditions.checkNotNull(params);
        Preconditions.checkNotNull(params.d);
        Preconditions.checkNotNull(params.l);
        Preconditions.checkNotNull(params.a);
        Preconditions.checkNotNull(params.c);
        List arrayList = new ArrayList();
        params.a(arrayList);
        return new ApiRequest("graphOpenGraphActionPublish", TigonRequest.POST, StringFormatUtil.a("me/%s", new Object[]{params.d}), arrayList, ApiResponseType.JSON);
    }

    public final Object m11731a(Object obj, ApiResponse apiResponse) {
        return apiResponse.c().b("id").B();
    }
}
