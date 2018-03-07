package com.facebook.events.common;

import com.facebook.common.fblinks.FBLinks;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* compiled from: ZOOM_STARTED */
public class EventsUriUtil {
    public static final Pattern f12092a = Pattern.compile("/events/(\\d+)/?");
    private static final String f12093b;
    private static final Pattern f12094c;

    static {
        String str = FBLinks.a + "://event/\\d+";
        f12093b = str;
        f12094c = Pattern.compile(str);
    }

    public static boolean m20124a(@Nullable String str) {
        return str != null && f12094c.matcher(str).matches();
    }
}
