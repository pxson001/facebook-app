package com.facebook.common.intent;

import android.content.Intent;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.client.utils.URIUtils;

/* compiled from: pymk_ccu_promo_card_clicked */
public class ActivityLaunchIntentUtil {
    public static String m6301a(Intent intent) {
        if (intent == null) {
            return null;
        }
        intent.setExtrasClassLoader(ActivityLaunchIntentUtil.class.getClassLoader());
        if (intent.hasExtra("extra_launch_uri")) {
            return intent.getStringExtra("extra_launch_uri");
        }
        return intent.getDataString();
    }

    public static String m6302b(Intent intent) {
        try {
            String a = m6301a(intent);
            if (a == null) {
                return null;
            }
            URI uri = new URI(a);
            return URIUtils.createURI(uri.getScheme(), uri.getHost(), uri.getPort(), uri.getPath(), null, null).toString();
        } catch (URISyntaxException e) {
            return null;
        }
    }
}
