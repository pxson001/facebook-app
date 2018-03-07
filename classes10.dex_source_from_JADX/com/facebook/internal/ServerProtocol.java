package com.facebook.internal;

import com.facebook.FacebookSdk;
import java.util.Collection;

/* compiled from: SEND_FAILED_TIMED_OUT_WAITING_FOR_RESPONSE */
public final class ServerProtocol {
    public static final Collection<String> f24029a = Utility.m25330a("service_disabled", "AndroidAuthKillSwitchException");
    public static final Collection<String> f24030b = Utility.m25330a("access_denied", "OAuthAccessDeniedException");
    private static final String f24031c = ServerProtocol.class.getName();

    public static final String m25308a() {
        return String.format("m.%s", new Object[]{FacebookSdk.f13771h});
    }

    public static final String m25309b() {
        return String.format("https://graph.%s", new Object[]{FacebookSdk.f13771h});
    }
}
