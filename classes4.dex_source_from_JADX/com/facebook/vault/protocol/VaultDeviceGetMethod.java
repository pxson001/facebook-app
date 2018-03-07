package com.facebook.vault.protocol;

import com.facebook.common.json.JsonFactoryMethodAutoProvider;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.tigon.iface.TigonRequest;
import com.facebook.vault.model.FacebookVaultDevice;
import com.fasterxml.jackson.core.JsonFactory;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: final_tone */
public class VaultDeviceGetMethod implements ApiMethod<VaultDeviceGetParams, FacebookVaultDevice> {
    private static final Class<?> f11612a = VaultDeviceGetMethod.class;
    private final JsonFactory f11613b;

    public static VaultDeviceGetMethod m12116b(InjectorLike injectorLike) {
        return new VaultDeviceGetMethod(JsonFactoryMethodAutoProvider.a(injectorLike));
    }

    public final ApiRequest m12117a(Object obj) {
        VaultDeviceGetParams vaultDeviceGetParams = (VaultDeviceGetParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("identifier_value", vaultDeviceGetParams.f11619a));
        new StringBuilder("vault device GET: ").append(a.toString());
        return new ApiRequest("vaultDeviceGet", TigonRequest.GET, "me/vaultdevices", RequestPriority.CAN_WAIT, a, ApiResponseType.STRING);
    }

    @Inject
    public VaultDeviceGetMethod(JsonFactory jsonFactory) {
        this.f11613b = jsonFactory;
    }

    public final Object m12118a(Object obj, ApiResponse apiResponse) {
        VaultDeviceGetResult vaultDeviceGetResult = (VaultDeviceGetResult) this.f11613b.a(apiResponse.b()).a(VaultDeviceGetResult.class);
        if (vaultDeviceGetResult == null || vaultDeviceGetResult.data == null || vaultDeviceGetResult.data.isEmpty()) {
            return null;
        }
        return (FacebookVaultDevice) vaultDeviceGetResult.data.get(0);
    }
}
