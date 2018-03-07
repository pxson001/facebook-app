package com.facebook.vault.protocol;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: thread_id IN (SELECT thread_id FROM #threads) AND timestamp > %1$d */
public class VaultAllImagesGetMethod implements ApiMethod<VaultAllImagesGetParams, VaultAllImagesGetResult> {
    public static VaultAllImagesGetMethod m1928a(InjectorLike injectorLike) {
        return new VaultAllImagesGetMethod();
    }

    public final ApiRequest m1929a(Object obj) {
        VaultAllImagesGetParams vaultAllImagesGetParams = (VaultAllImagesGetParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("limit", Integer.toString(vaultAllImagesGetParams.f1847b)));
        a.add(new BasicNameValuePair("after", vaultAllImagesGetParams.f1846a));
        return new ApiRequest("vaultGetSyncedImageStatus", "GET", "me/vaultimages", a, ApiResponseType.JSONPARSER);
    }

    public final Object m1930a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return (VaultAllImagesGetResult) apiResponse.d().a(VaultAllImagesGetResult.class);
    }
}
