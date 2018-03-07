package com.facebook.vault.protocol;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.Lists;

/* compiled from: thread_fbid in ( */
public class VaultImageDeleteMethod implements ApiMethod<Long, Boolean> {
    public static VaultImageDeleteMethod m1944a(InjectorLike injectorLike) {
        return new VaultImageDeleteMethod();
    }

    public final ApiRequest m1945a(Object obj) {
        Long l = (Long) obj;
        return new ApiRequest("vaultImageDelete", "DELETE", l.toString(), Lists.a(), ApiResponseType.STRING);
    }

    public final Object m1946a(Object obj, ApiResponse apiResponse) {
        return Boolean.valueOf(apiResponse.b().equalsIgnoreCase("true"));
    }
}
