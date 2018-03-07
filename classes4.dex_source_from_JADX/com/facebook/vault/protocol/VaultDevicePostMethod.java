package com.facebook.vault.protocol;

import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.tigon.iface.TigonRequest;
import com.facebook.vault.model.FacebookVaultDevice;
import com.fasterxml.jackson.core.JsonFactory;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: findMethods */
public class VaultDevicePostMethod implements ApiMethod<VaultDevicePostParams, FacebookVaultDevice> {
    private JsonFactory f11611a;

    public final ApiRequest m12114a(Object obj) {
        VaultDevicePostParams vaultDevicePostParams = (VaultDevicePostParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("identifier_value", vaultDevicePostParams.a));
        a.add(new BasicNameValuePair("name", vaultDevicePostParams.b));
        if (vaultDevicePostParams.c != null) {
            a.add(new BasicNameValuePair("enabled", Boolean.toString(vaultDevicePostParams.c.booleanValue())));
        }
        if (vaultDevicePostParams.d != null) {
            a.add(new BasicNameValuePair("sync_mode", vaultDevicePostParams.d));
        }
        if (vaultDevicePostParams.e != null) {
            a.add(new BasicNameValuePair("sync_older_photos", Boolean.toString(vaultDevicePostParams.e.booleanValue())));
        }
        return new ApiRequest("vaultDeviceGet", TigonRequest.POST, "me/vaultdevices", RequestPriority.CAN_WAIT, a, ApiResponseType.STRING);
    }

    @Inject
    public VaultDevicePostMethod(JsonFactory jsonFactory) {
        this.f11611a = jsonFactory;
    }

    public final Object m12115a(Object obj, ApiResponse apiResponse) {
        return (FacebookVaultDevice) this.f11611a.a(apiResponse.b()).a(FacebookVaultDevice.class);
    }
}
