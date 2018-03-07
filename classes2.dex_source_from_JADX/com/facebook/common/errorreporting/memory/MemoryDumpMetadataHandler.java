package com.facebook.common.errorreporting.memory;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.base.Preconditions;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONObject;

@Singleton
/* compiled from: video_cover_image */
public class MemoryDumpMetadataHandler {
    private static final PrefKey f1227a = ((PrefKey) SharedPrefKeys.f987a.m2011a("hprof_dump_metadata"));
    private static final Class<?> f1228b = MemoryDumpMetadataHandler.class;
    public static SharedPreferences f1229c;
    private static AbstractFbErrorReporter f1230d;
    public static boolean f1231e;
    private static volatile MemoryDumpMetadataHandler f1232f;

    public static com.facebook.common.errorreporting.memory.MemoryDumpMetadataHandler m2366a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f1232f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.errorreporting.memory.MemoryDumpMetadataHandler.class;
        monitor-enter(r1);
        r0 = f1232f;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m2370b(r0);	 Catch:{ all -> 0x0035 }
        f1232f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1232f;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.errorreporting.memory.MemoryDumpMetadataHandler.a(com.facebook.inject.InjectorLike):com.facebook.common.errorreporting.memory.MemoryDumpMetadataHandler");
    }

    private static MemoryDumpMetadataHandler m2370b(InjectorLike injectorLike) {
        return new MemoryDumpMetadataHandler((Context) injectorLike.getInstance(Context.class), FbErrorReporterImpl.m2317a(injectorLike));
    }

    @Inject
    public MemoryDumpMetadataHandler(Context context, AbstractFbErrorReporter abstractFbErrorReporter) {
        f1230d = abstractFbErrorReporter;
        f1231e = false;
        if (f1229c != null) {
            f1229c.edit().apply();
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("dump_metadata", 0);
        f1229c = sharedPreferences;
        if (sharedPreferences == null) {
            f1231e = true;
            m2369a("Error@updateContext isInvalid is true", null);
        }
    }

    public final MemoryDumpMetadataHandler m2371a(String str, String str2, boolean z, boolean z2) {
        boolean z3 = false;
        if (!f1231e) {
            try {
                Preconditions.checkNotNull(str);
                Preconditions.checkNotNull(str2);
                if (str2.equals("")) {
                    m2369a("Warning@storeDumpMetadata Throwable .getClass().getName() returned a empty string", null);
                } else {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("Dump ID", str).put("Dump cause", str2).put("Is Backgrounded", Boolean.toString(z)).put("Was Ever Foregrounded", Boolean.toString(z2));
                        for (int i = 0; i < 3; i++) {
                            z3 = f1229c.edit().putString(f1227a.m2012a(), str).putString(m2367a(str).m2012a(), jSONObject.toString()).commit();
                            if (z3) {
                                break;
                            }
                        }
                        if (!z3) {
                            m2369a("Error@storeMetadata metadata didn't commit even after 3 retries", null);
                        }
                    } catch (Exception e) {
                        m2369a("Error@storeDumpMetadata(): Unable to put metadata to JSON ", e);
                    }
                }
            } catch (Exception e2) {
                m2369a("Warning@storeDumpMetadata invalid arguments while writing ", e2);
            }
        }
        return this;
    }

    public static String m2368a() {
        if (f1231e) {
            return "";
        }
        String string = f1229c.getString(f1227a.toString(), "");
        if (string.equals("")) {
            return "";
        }
        string = f1229c.getString(m2367a(string).toString(), "");
        if (!string.equals("")) {
            return string;
        }
        m2369a("Warning@getDumpMetadata(): No dump metadata found", null);
        return string;
    }

    public final MemoryDumpMetadataHandler m2372b() {
        if (!f1231e) {
            String string = f1229c.getString(f1227a.toString(), "");
            if (string.equals("")) {
                m2369a("Warning@deleteDumpMetadata(): No dump id found", null);
            } else {
                f1229c.edit().remove(f1227a.toString()).remove(m2367a(string).toString()).apply();
            }
        }
        return this;
    }

    private static PrefKey m2367a(String str) {
        return (PrefKey) f1227a.m2011a(str);
    }

    public static void m2369a(String str, Exception exception) {
        BLog.a(f1228b, str, exception);
        if (f1230d != null) {
            if (exception != null) {
                str = str.concat("\n" + exception.toString());
            }
            f1230d.mo336a(SoftError.b(f1228b.getName(), str));
        }
    }
}
