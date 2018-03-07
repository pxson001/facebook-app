package com.facebook.vault.protocol;

import android.util.Log;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.tigon.iface.TigonRequest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;

/* compiled from: firstSection */
public class VaultGetSyncedImageStatusMethod implements ApiMethod<VaultGetSyncedImageStatusParams, VaultGetSyncedImageStatusResult> {
    private static final Class<?> f11592a = VaultGetSyncedImageStatusMethod.class;
    private final ObjectMapper f11593b;

    public final ApiRequest m12081a(Object obj) {
        VaultGetSyncedImageStatusParams vaultGetSyncedImageStatusParams = (VaultGetSyncedImageStatusParams) obj;
        List a = Lists.a();
        JSONArray jSONArray = new JSONArray(vaultGetSyncedImageStatusParams.b);
        a.add(new BasicNameValuePair("hashes", jSONArray.toString()));
        a.add(new BasicNameValuePair("time_start", vaultGetSyncedImageStatusParams.c()));
        if (Log.isLoggable("vault", 2)) {
            vaultGetSyncedImageStatusParams.c();
            jSONArray.toString();
        }
        return new ApiRequest("vaultGetSyncedImageStatus", TigonRequest.GET, StringFormatUtil.formatStrLocaleSafe("%s/vaultlocalimages", Long.toString(vaultGetSyncedImageStatusParams.a)), a, ApiResponseType.STRING);
    }

    @Inject
    public VaultGetSyncedImageStatusMethod(ObjectMapper objectMapper) {
        this.f11593b = objectMapper;
    }

    public final Object m12082a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        String b = apiResponse.b();
        JsonNode a = this.f11593b.a(b);
        if (a.b("data") == null || !a.b("data").h()) {
            return (VaultGetSyncedImageStatusResult) this.f11593b.a(b, VaultGetSyncedImageStatusResult.class);
        }
        return new VaultGetSyncedImageStatusResult();
    }
}
