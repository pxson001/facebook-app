package com.facebook.platform.webdialogs.bridgeapi;

import com.facebook.common.stringformat.StringFormatUtil;
import org.json.JSONObject;

/* compiled from: locationPingFromUser */
public abstract class AbstractPlatformWebDialogsBridgeApiFactory {
    public abstract PlatformWebDialogsBridgeApi mo372a(JSONObject jSONObject);

    public abstract String mo373a();

    public String mo374b() {
        return StringFormatUtil.formatStrLocaleSafe("bridgeMethodImpl('%s')", mo373a());
    }
}
