package com.facebook.vault.protocol;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.Lists;

/* compiled from: thread_db_duration */
public class VaultImageGetMethod implements ApiMethod<Long, Boolean> {
    public static VaultImageGetMethod m1947a(InjectorLike injectorLike) {
        return new VaultImageGetMethod();
    }

    public final ApiRequest m1948a(Object obj) {
        Long l = (Long) obj;
        return new ApiRequest("vaultImageGet", "GET", l.toString(), Lists.a(), ApiResponseType.STRING);
    }

    public final Object m1949a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(true);
    }
}
