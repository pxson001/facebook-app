package com.facebook.richdocument.fonts;

import android.content.Context;
import android.util.LruCache;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.util.CollectionUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Objects;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: prefetch_show_failed_no_data */
public class FontResourceCache {
    private static final Class<?> f5259a = FontResourceCache.class;
    private static volatile FontResourceCache f5260f;
    private final File f5261b;
    private final Lazy<ObjectMapper> f5262c;
    private final Lazy<FbErrorReporter> f5263d;
    public final LruCache<FontResourceKey, FontResourceEntry> f5264e = new LruCache(100);

    /* compiled from: prefetch_show_failed_no_data */
    public class FontResourceCacheSnapshot {
        @JsonProperty("resources")
        private final List<FontResourceEntry> mResources;

        public FontResourceCacheSnapshot(@JsonProperty("resources") List<FontResourceEntry> list) {
            this.mResources = list;
        }

        public final List<FontResourceEntry> m5191a() {
            return this.mResources;
        }
    }

    /* compiled from: prefetch_show_failed_no_data */
    public class FontResourceEntry {
        @JsonProperty("fonts")
        private final List<String> mFonts;
        @JsonProperty("name")
        private final String mName;
        @JsonProperty("version")
        private final String mVersion;

        public FontResourceEntry(@JsonProperty("name") String str, @JsonProperty("version") String str2, @JsonProperty("fonts") List<String> list) {
            this.mName = str;
            this.mVersion = str2;
            this.mFonts = list;
        }

        public final String m5192a() {
            return this.mName;
        }

        public final String m5193b() {
            return this.mVersion;
        }

        @JsonIgnore
        public final List<FontCacheKey> m5194c() {
            List<FontCacheKey> arrayList = new ArrayList();
            if (CollectionUtil.b(this.mFonts)) {
                for (String fontCacheKey : this.mFonts) {
                    arrayList.add(new FontCacheKey(this.mName, this.mVersion, fontCacheKey));
                }
            }
            return arrayList;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof FontResourceEntry)) {
                return super.equals(obj);
            }
            FontResourceEntry fontResourceEntry = (FontResourceEntry) obj;
            return Objects.equal(this.mName, fontResourceEntry.mName) && Objects.equal(this.mVersion, fontResourceEntry.mVersion) && Objects.equal(this.mFonts, fontResourceEntry.mFonts);
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{this.mName, this.mVersion, this.mFonts});
        }
    }

    /* compiled from: prefetch_show_failed_no_data */
    public class FontResourceKey {
        private final String f5257a;
        private final String f5258b;

        public FontResourceKey(String str, String str2) {
            this.f5257a = str;
            this.f5258b = str2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof FontResourceKey)) {
                return super.equals(obj);
            }
            FontResourceKey fontResourceKey = (FontResourceKey) obj;
            return Objects.equal(this.f5257a, fontResourceKey.f5257a) && Objects.equal(this.f5258b, fontResourceKey.f5258b);
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{this.f5257a, this.f5258b});
        }

        public String toString() {
            return this.f5257a + "_" + this.f5258b;
        }
    }

    public static com.facebook.richdocument.fonts.FontResourceCache m5195a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5260f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.richdocument.fonts.FontResourceCache.class;
        monitor-enter(r1);
        r0 = f5260f;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m5196b(r0);	 Catch:{ all -> 0x0035 }
        f5260f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5260f;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.fonts.FontResourceCache.a(com.facebook.inject.InjectorLike):com.facebook.richdocument.fonts.FontResourceCache");
    }

    private static FontResourceCache m5196b(InjectorLike injectorLike) {
        return new FontResourceCache((Context) injectorLike.getInstance(Context.class), IdBasedSingletonScopeProvider.b(injectorLike, 572), IdBasedSingletonScopeProvider.b(injectorLike, 494));
    }

    @Inject
    public FontResourceCache(Context context, Lazy<ObjectMapper> lazy, Lazy<FbErrorReporter> lazy2) {
        this.f5262c = lazy;
        this.f5263d = lazy2;
        if (context != null) {
            this.f5261b = new File(context.getCacheDir(), "fontResourceCache.json");
        } else {
            this.f5261b = null;
        }
        m5197b();
    }

    public final void m5199a() {
        try {
            ((ObjectMapper) this.f5262c.get()).a(m5198c(), new FontResourceCacheSnapshot(new ArrayList(this.f5264e.snapshot().values())));
        } catch (Throwable th) {
            Throwable th2 = th;
            ((AbstractFbErrorReporter) this.f5263d.get()).a(f5259a.getSimpleName(), "Failed to save font resource cache file fontResourceCache.json", th2);
        }
    }

    private void m5197b() {
        this.f5264e.evictAll();
        try {
            File c = m5198c();
            if (c.exists()) {
                FontResourceCacheSnapshot fontResourceCacheSnapshot = (FontResourceCacheSnapshot) ((ObjectMapper) this.f5262c.get()).a(c, FontResourceCacheSnapshot.class);
                if (fontResourceCacheSnapshot != null) {
                    for (FontResourceEntry fontResourceEntry : fontResourceCacheSnapshot.m5191a()) {
                        this.f5264e.put(new FontResourceKey(fontResourceEntry.m5192a(), fontResourceEntry.m5193b()), fontResourceEntry);
                    }
                }
            }
        } catch (Throwable th) {
            BLog.b(f5259a, th, "Failed to load font resource cache file %s", new Object[]{"fontResourceCache.json"});
        }
    }

    private File m5198c() {
        return this.f5261b;
    }
}
