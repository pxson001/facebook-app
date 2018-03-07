package com.facebook.zero.sdk.logging;

import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;

/* compiled from: com.facebook.dracula.transformer.Transformer */
public class ZeroLoggerBase implements ZeroLogger {
    private static final String f5893a = ZeroLoggerBase.class.getCanonicalName();

    public static ZeroLoggerBase m10624a(InjectorLike injectorLike) {
        return new ZeroLoggerBase();
    }

    private static String m10625d(String str, @Nullable Map<String, Object> map) {
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                str = str + " " + ((String) entry.getKey()) + ": " + entry.getValue() + ";";
            }
        }
        return str;
    }

    public final void m10628a(Throwable th, @Nullable Map<String, Object> map) {
        BLog.a(f5893a, m10625d("Zero Token Fetch Failed. ", map), th);
    }

    public final void m10626a(String str, String str2, @Nullable Map<String, Object> map) {
        m10625d("Rewrote uri " + str + " to " + str2 + ". ", map);
    }

    public final void m10627a(String str, @Nullable Map<String, Object> map) {
        m10625d("Did not rewrite uri " + str + ". ", map);
    }

    public final void m10629b(String str, @Nullable Map<String, Object> map) {
        m10625d("Zero Campaign is not enabled (uri was " + str + "). ", map);
    }

    public final void m10630c(String str, @Nullable Map<String, Object> map) {
        BLog.a(f5893a, m10625d(str + " is an invalid Mcc/Mnc string", map));
    }
}
