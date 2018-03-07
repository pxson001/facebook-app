package com.facebook.platform.webdialogs.bridgeapi;

import com.facebook.platform.webdialogs.PlatformWebDialogsFragment;
import org.json.JSONObject;

/* compiled from: locationPingDeleteParams */
public abstract class PlatformWebDialogsBridgeApi {
    public JSONObject f8536a;
    public String f8537b;

    public abstract void mo371a(PlatformWebDialogsFragment platformWebDialogsFragment, PlatformWebDialogsFragment platformWebDialogsFragment2);

    protected PlatformWebDialogsBridgeApi(JSONObject jSONObject) {
        this.f8536a = jSONObject;
        this.f8537b = jSONObject.optString("__callbackToken");
    }
}
