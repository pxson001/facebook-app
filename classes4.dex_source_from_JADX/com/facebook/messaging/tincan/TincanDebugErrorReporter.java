package com.facebook.messaging.tincan;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.tincan.prefs.TincanPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.inject.Inject;

/* compiled from: la_push_authenticate */
public class TincanDebugErrorReporter {
    private static final Class<?> f9669a = TincanDebugErrorReporter.class;
    public final Context f9670b;
    private final FbSharedPreferences f9671c;

    public static TincanDebugErrorReporter m10099b(InjectorLike injectorLike) {
        return new TincanDebugErrorReporter((Context) injectorLike.getInstance(Context.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public TincanDebugErrorReporter(Context context, FbSharedPreferences fbSharedPreferences) {
        this.f9670b = context;
        this.f9671c = fbSharedPreferences;
    }

    public final void m10100a(Class<?> cls, String str) {
        BLog.b(cls, str);
        m10098a(cls.getSimpleName().concat(": ").concat(str));
    }

    public final void m10101a(Class<?> cls, String str, Throwable th) {
        String message = th.getMessage();
        if (message == null) {
            message = th.toString();
        }
        BLog.b(cls, str, th);
        m10098a(cls.getSimpleName().concat(": ").concat(str).concat("\n").concat(message));
    }

    private void m10098a(String str) {
        if (this.f9671c.a(TincanPrefKeys.c, false)) {
            HandlerDetour.a(new Handler(Looper.getMainLooper()), new 1(this, str), -759748632);
        }
    }
}
