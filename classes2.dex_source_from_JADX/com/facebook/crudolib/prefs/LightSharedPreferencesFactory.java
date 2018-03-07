package com.facebook.crudolib.prefs;

import android.content.Context;
import com.facebook.crudolib.processname.ProcessNameHelper;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: verified_caller_intent */
public class LightSharedPreferencesFactory {
    private final Executor f1303a;
    private final File f1304b;
    private final Map<String, LightSharedPreferences> f1305c = new HashMap();

    /* compiled from: verified_caller_intent */
    public class Builder {
        final Context f1301a;
        public Executor f1302b;

        public Builder(Context context) {
            this.f1301a = context.getApplicationContext();
        }

        public final LightSharedPreferencesFactory m2548a() {
            Executor b = LightSharedPreferencesFactory.m2549b(this.f1302b);
            Context context = this.f1301a;
            String a = ProcessNameHelper.m2551a();
            if (a == null) {
                a = "default";
            }
            File file = new File(context.getDir("light_prefs", 0), a);
            file.mkdirs();
            return new LightSharedPreferencesFactory(b, file);
        }
    }

    protected LightSharedPreferencesFactory(Executor executor, File file) {
        this.f1303a = executor;
        this.f1304b = file;
    }

    public static Executor m2549b(@Nullable Executor executor) {
        return executor != null ? executor : Executors.newSingleThreadExecutor();
    }

    public final synchronized LightSharedPreferencesImpl m2550a(String str) {
        LightSharedPreferencesImpl lightSharedPreferencesImpl;
        lightSharedPreferencesImpl = (LightSharedPreferencesImpl) this.f1305c.get(str);
        if (lightSharedPreferencesImpl == null) {
            lightSharedPreferencesImpl = new LightSharedPreferencesImpl(new File(this.f1304b, str), this.f1303a);
            this.f1305c.put(str, lightSharedPreferencesImpl);
        }
        return lightSharedPreferencesImpl;
    }
}
