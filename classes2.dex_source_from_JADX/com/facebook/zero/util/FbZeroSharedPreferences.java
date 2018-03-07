package com.facebook.zero.util;

import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.zero.sdk.util.ZeroSharedPreferences;
import com.facebook.zero.sdk.util.ZeroSharedPreferences.Editor;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: sound_trigger_identifier */
public class FbZeroSharedPreferences implements ZeroSharedPreferences {
    private static volatile FbZeroSharedPreferences f4316b;
    private FbSharedPreferences f4317a;

    /* compiled from: sound_trigger_identifier */
    public class FbZeroEditor implements Editor {
        final /* synthetic */ FbZeroSharedPreferences f15192a;
        private FbSharedPreferences.Editor f15193b;

        public FbZeroEditor(FbZeroSharedPreferences fbZeroSharedPreferences, FbSharedPreferences.Editor editor) {
            this.f15192a = fbZeroSharedPreferences;
            this.f15193b = editor;
        }

        public final Editor mo2850a(String str, String str2) {
            this.f15193b.mo1276a((PrefKey) SharedPrefKeys.f987a.m2011a(FbZeroSharedPreferences.m7973c(str)), str2);
            return this;
        }

        public final Editor mo2848a(String str, int i) {
            this.f15193b.mo1274a((PrefKey) SharedPrefKeys.f987a.m2011a(FbZeroSharedPreferences.m7973c(str)), i);
            return this;
        }

        public final Editor mo2849a(String str, long j) {
            this.f15193b.mo1275a((PrefKey) SharedPrefKeys.f987a.m2011a(FbZeroSharedPreferences.m7973c(str)), j);
            return this;
        }

        public final Editor mo2851a(String str, boolean z) {
            this.f15193b.putBoolean((PrefKey) SharedPrefKeys.f987a.m2011a(FbZeroSharedPreferences.m7973c(str)), z);
            return this;
        }

        public final Editor mo2847a(String str) {
            this.f15193b.mo1278b((PrefKey) SharedPrefKeys.f987a.m2011a(FbZeroSharedPreferences.m7973c(str)));
            return this;
        }

        public final void mo2852a() {
            this.f15193b.commit();
        }
    }

    public static com.facebook.zero.util.FbZeroSharedPreferences m7971a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4316b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.zero.util.FbZeroSharedPreferences.class;
        monitor-enter(r1);
        r0 = f4316b;	 Catch:{ all -> 0x003a }
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
        r0 = m7972b(r0);	 Catch:{ all -> 0x0035 }
        f4316b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4316b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.zero.util.FbZeroSharedPreferences.a(com.facebook.inject.InjectorLike):com.facebook.zero.util.FbZeroSharedPreferences");
    }

    private static FbZeroSharedPreferences m7972b(InjectorLike injectorLike) {
        return new FbZeroSharedPreferences(FbSharedPreferencesImpl.m1826a(injectorLike));
    }

    @Inject
    public FbZeroSharedPreferences(FbSharedPreferences fbSharedPreferences) {
        this.f4317a = fbSharedPreferences;
    }

    public final Editor mo1195a() {
        return new FbZeroEditor(this, this.f4317a.edit());
    }

    public final String mo1196a(String str, String str2) {
        return this.f4317a.mo278a((PrefKey) SharedPrefKeys.f987a.m2011a(m7973c(str)), str2);
    }

    public final int mo1193a(String str, int i) {
        return this.f4317a.mo276a((PrefKey) SharedPrefKeys.f987a.m2011a(m7973c(str)), i);
    }

    public final long mo1194a(String str, long j) {
        return this.f4317a.mo277a((PrefKey) SharedPrefKeys.f987a.m2011a(m7973c(str)), j);
    }

    public final boolean mo1198a(String str, boolean z) {
        return this.f4317a.mo286a((PrefKey) SharedPrefKeys.f987a.m2011a(m7973c(str)), z);
    }

    public final boolean mo1197a(String str) {
        return this.f4317a.mo285a((PrefKey) SharedPrefKeys.f987a.m2011a(m7973c(str)));
    }

    public static String m7973c(String str) {
        if (str.charAt(0) == '/') {
            return str.substring(1);
        }
        return str;
    }
}
