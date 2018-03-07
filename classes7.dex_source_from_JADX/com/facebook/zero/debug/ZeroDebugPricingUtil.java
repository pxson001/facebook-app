package com.facebook.zero.debug;

import java.net.URI;
import java.net.URISyntaxException;

@Deprecated
/* compiled from: े */
public class ZeroDebugPricingUtil {
    private static final String[] f107a = new String[]{"b-api.facebook.com", "z-m-graph.facebook.com", "b-graph.facebook.com", "www.facebook.com", "z-m-scontent.xx.fbcdn.net", "z-m-api.facebook.com", "pixel.facebook.com", "z-m-static.xx.fbcdn.net", "h.facebook.com", "b-www.facebook.com", "b-m.facebook.com", "free.facebook.com", "facebook.com", "connect.facebook.com", "m.facebook.com", "lm.facebook.com", "0.freebasics.com", "www.internet.org", "0.internet.org", "graph.internet.org", "z-m-www.facebook.com", "z-m.ak.fbcdn.net"};

    public static boolean m97a(String str) {
        try {
            URI uri = new URI(str);
            for (String matches : f107a) {
                if (uri.getHost().matches(matches)) {
                    return true;
                }
            }
            return false;
        } catch (URISyntaxException e) {
            return false;
        }
    }
}
