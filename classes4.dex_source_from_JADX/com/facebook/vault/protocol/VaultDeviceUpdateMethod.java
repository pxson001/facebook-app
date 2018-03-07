package com.facebook.vault.protocol;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.tigon.iface.TigonRequest;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: filters */
public class VaultDeviceUpdateMethod implements ApiMethod<VaultDeviceUpdateParams, Boolean> {
    private static final Class<?> f11614a = VaultDeviceUpdateMethod.class;

    public static VaultDeviceUpdateMethod m12119a(InjectorLike injectorLike) {
        return new VaultDeviceUpdateMethod();
    }

    public final ApiRequest m12120a(Object obj) {
        VaultDeviceUpdateParams vaultDeviceUpdateParams = (VaultDeviceUpdateParams) obj;
        List a = Lists.a();
        if (vaultDeviceUpdateParams.b != null) {
            a.add(new BasicNameValuePair("last_sync_time", vaultDeviceUpdateParams.b.toString()));
        }
        if (vaultDeviceUpdateParams.c != null) {
            a.add(new BasicNameValuePair("enabled", vaultDeviceUpdateParams.c.toString()));
        }
        if (vaultDeviceUpdateParams.d != null) {
            a.add(new BasicNameValuePair("sync_mode", vaultDeviceUpdateParams.d));
        }
        if (vaultDeviceUpdateParams.e != null) {
            a.add(new BasicNameValuePair("sync_older_photos", vaultDeviceUpdateParams.e.toString()));
        }
        List list = a;
        Long.valueOf(vaultDeviceUpdateParams.a);
        list.toString();
        return new ApiRequest("vaultDeviceUpdate", TigonRequest.POST, Long.toString(vaultDeviceUpdateParams.a), list, ApiResponseType.JSON);
    }

    public final Object m12121a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(true);
    }
}
