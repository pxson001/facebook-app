package com.facebook.platform.webdialogs;

import android.content.Context;
import android.util.Pair;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.file.FileTree;
import com.facebook.common.file.FileUtils;
import com.facebook.common.file.FileUtils.CreateDirectoryException;
import com.facebook.common.file.MoreFileUtils;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.SystemClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import java.io.File;
import java.io.FileFilter;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

@Singleton
/* compiled from: time_start */
public class PlatformWebDialogsCache {
    private static volatile PlatformWebDialogsCache f9053m;
    private final DefaultAndroidThreadUtil f9054a;
    private final AbstractFbErrorReporter f9055b;
    private final MoreFileUtils f9056c;
    private final Context f9057d;
    private final ObjectMapper f9058e;
    private final FbSharedPreferences f9059f;
    private final SystemClock f9060g;
    private final AtomicInteger f9061h = new AtomicInteger();
    private final Map<String, String> f9062i;
    private File f9063j;
    private File f9064k;
    private boolean f9065l;

    @AutoGenJsonDeserializer
    @JsonDeserialize(using = PlatformWebDialogsCache_CacheWrapperDeserializer.class)
    /* compiled from: time_start */
    public class CacheWrapper {
        @JsonProperty("urlMapCache")
        private Map<String, String> mCache;

        public CacheWrapper(Map<String, String> map) {
            this.mCache = map;
        }

        public final Map<String, String> m11792a() {
            return this.mCache;
        }
    }

    public static com.facebook.platform.webdialogs.PlatformWebDialogsCache m9392a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f9053m;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.platform.webdialogs.PlatformWebDialogsCache.class;
        monitor-enter(r1);
        r0 = f9053m;	 Catch:{ all -> 0x003a }
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
        r0 = m9396b(r0);	 Catch:{ all -> 0x0035 }
        f9053m = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9053m;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.platform.webdialogs.PlatformWebDialogsCache.a(com.facebook.inject.InjectorLike):com.facebook.platform.webdialogs.PlatformWebDialogsCache");
    }

    private static PlatformWebDialogsCache m9396b(InjectorLike injectorLike) {
        return new PlatformWebDialogsCache((Context) injectorLike.getInstance(Context.class), DefaultAndroidThreadUtil.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), MoreFileUtils.a(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PlatformWebDialogsCache(Context context, DefaultAndroidThreadUtil defaultAndroidThreadUtil, AbstractFbErrorReporter abstractFbErrorReporter, MoreFileUtils moreFileUtils, ObjectMapper objectMapper, FbSharedPreferences fbSharedPreferences, SystemClock systemClock) {
        this.f9057d = context;
        this.f9054a = defaultAndroidThreadUtil;
        this.f9055b = abstractFbErrorReporter;
        this.f9056c = moreFileUtils;
        this.f9058e = objectMapper;
        this.f9059f = fbSharedPreferences;
        this.f9060g = systemClock;
        this.f9062i = Maps.c();
    }

    private boolean m9399f() {
        if (m9411c()) {
            return false;
        }
        m9400g();
        return this.f9065l;
    }

    private synchronized void m9400g() {
        boolean z = true;
        synchronized (this) {
            this.f9054a.b("This method will perform disk I/O and should not be called on the UI thread");
            if (!this.f9065l && this.f9059f.a()) {
                this.f9061h.set(this.f9059f.a(PlatformWebDialogsPrefKeys.f11168f, 0));
                if (!m9411c()) {
                    File filesDir = this.f9057d.getFilesDir();
                    if (filesDir != null) {
                        this.f9063j = new File(filesDir, StringFormatUtil.formatStrLocaleSafe("%1$s%2$s", "PlatformWebDialogs_V", "1.1"));
                        m9401h();
                        this.f9064k = new File(this.f9063j, "CachedResponses");
                        boolean z2 = !this.f9063j.exists();
                        try {
                            FileUtils.a(this.f9064k);
                            if (z2) {
                                m9402i();
                            } else {
                                Pair b = m9395b(PlatformWebDialogsPrefKeys.f11169g, "PlatformWebDialogsCache.urlMap", CacheWrapper.class);
                                if (b != null) {
                                    z = ((Boolean) b.first).booleanValue();
                                    CacheWrapper cacheWrapper = (CacheWrapper) b.second;
                                    if (z && cacheWrapper != null) {
                                        Map a = cacheWrapper.m11792a();
                                        if (a != null) {
                                            this.f9062i.putAll(a);
                                        } else {
                                            m9405a();
                                            this.f9055b.a("PlatformWebDialogsCache", "Deserialized cache had a NULL cache-map");
                                            z = false;
                                        }
                                    }
                                }
                            }
                            this.f9065l = z;
                        } catch (CreateDirectoryException e) {
                            this.f9063j = null;
                            this.f9064k = null;
                            this.f9055b.a("PlatformWebDialogsCache", "Unable to create the directory for cached responses", e);
                        }
                    }
                }
            }
        }
    }

    private <T> Pair<Boolean, T> m9395b(PrefKey prefKey, String str, Class<T> cls) {
        boolean z = true;
        Object obj = null;
        if (this.f9063j == null) {
            return obj;
        }
        File file = new File(this.f9063j, this.f9059f.a(prefKey, str));
        if (file.exists()) {
            Editor editor = null;
            try {
                obj = this.f9058e.a(file, cls);
            } catch (Throwable e) {
                m9405a();
                this.f9055b.a("PlatformWebDialogsCache", StringFormatUtil.formatStrLocaleSafe("Unable to find file %s", file.getAbsolutePath()), e);
                z = editor;
                return new Pair(Boolean.valueOf(z), obj);
            } catch (Throwable e2) {
                m9405a();
                this.f9055b.a("PlatformWebDialogsCache", m9394a("Error while reading file", file), e2);
                z = editor;
                return new Pair(Boolean.valueOf(z), obj);
            } finally {
                editor = this.f9059f.edit().a(prefKey);
                editor.commit();
                m9397b(str, obj);
            }
        }
        return new Pair(Boolean.valueOf(z), obj);
    }

    public final synchronized void m9405a() {
        this.f9059f.edit().a(PlatformWebDialogsPrefKeys.f11168f, this.f9061h.incrementAndGet()).commit();
        if (m9411c()) {
            this.f9055b.a("PlatformWebDialogsCache", "Caching disabled for this device. Too many cache failures.");
        }
    }

    private static String m9394a(String str, File file) {
        if (file != null) {
            try {
                str = StringFormatUtil.formatStrLocaleSafe("%s. File size: %d", str, Long.valueOf(file.length()));
            } catch (Exception e) {
            }
        }
        return str;
    }

    public final synchronized boolean m9409b() {
        boolean z;
        z = this.f9065l && !m9411c();
        return z;
    }

    public final synchronized boolean m9411c() {
        return this.f9061h.intValue() >= 5;
    }

    public final synchronized <T> Pair<Boolean, T> m9403a(PrefKey prefKey, String str, Class<T> cls) {
        Pair<Boolean, T> b;
        if (m9399f()) {
            b = m9395b(prefKey, str, cls);
        } else {
            b = null;
        }
        return b;
    }

    public final synchronized <T> boolean m9407a(PrefKey prefKey, String str, T t) {
        boolean z = false;
        synchronized (this) {
            if (m9399f()) {
                String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("%s_%d", str, Long.valueOf(this.f9060g.a()));
                File file = new File(this.f9063j, formatStrLocaleSafe);
                try {
                    this.f9058e.a(file, t);
                    this.f9059f.edit().a(prefKey, formatStrLocaleSafe).commit();
                    m9397b(str, formatStrLocaleSafe);
                    z = true;
                } catch (Throwable e) {
                    m9405a();
                    this.f9055b.a("PlatformWebDialogsCache", m9394a("Error while writing to file", file), e);
                }
            }
        }
        return z;
    }

    public final synchronized InputStream m9404a(String str) {
        InputStream inputStream = null;
        synchronized (this) {
            this.f9054a.b("This method will perform disk I/O and should not be called on the UI thread");
            if (!Strings.isNullOrEmpty(str) && m9399f()) {
                String c = m9398c(str);
                if (c != null) {
                    String str2 = (String) this.f9062i.get(c);
                    if (str2 != null) {
                        InputStream a;
                        try {
                            a = MoreFileUtils.a(new File(this.f9064k, str2));
                        } catch (Throwable e) {
                            m9405a();
                            this.f9055b.a("PlatformWebDialogsCache", StringFormatUtil.formatStrLocaleSafe("Could not find the cached file for %s", c), e);
                            m9410b(str);
                            a = null;
                        }
                        inputStream = a;
                    }
                }
            }
        }
        return inputStream;
    }

    public final synchronized boolean m9406a(PlatformWebViewActionManifest platformWebViewActionManifest, HttpResponse httpResponse) {
        boolean z = false;
        synchronized (this) {
            this.f9054a.b("This method will perform disk I/O and should not be called on the UI thread");
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null && m9399f()) {
                String a = m9393a(platformWebViewActionManifest);
                if (a != null) {
                    try {
                        this.f9056c.a(entity.getContent(), new File(this.f9064k, a));
                        z = true;
                    } catch (Throwable e) {
                        this.f9055b.a("PlatformWebDialogsCache", "Exception caching http response", e);
                    }
                }
            }
        }
        return z;
    }

    public final synchronized boolean m9410b(String str) {
        boolean z;
        this.f9054a.b("This method will perform disk I/O and should not be called on the UI thread");
        if (str == null || !m9399f()) {
            z = false;
        } else {
            String c = m9398c(str);
            if (c == null) {
                z = false;
            } else {
                c = (String) this.f9062i.remove(c);
                z = c == null ? false : !new File(this.f9064k, c).exists();
            }
        }
        return z;
    }

    public final synchronized boolean m9408a(String str, String str2) {
        boolean z;
        if (Strings.isNullOrEmpty(str) || Strings.isNullOrEmpty(str2) || !m9409b()) {
            z = false;
        } else {
            String c = m9398c(str);
            String c2 = m9398c(str2);
            if (Strings.isNullOrEmpty(c2) || c2.equals(c)) {
                z = false;
            } else {
                c = (String) this.f9062i.remove(c);
                if (c != null) {
                    this.f9062i.put(c2, c);
                    z = true;
                } else {
                    z = false;
                }
            }
        }
        return z;
    }

    public final synchronized void m9412d() {
        this.f9054a.b("This method will perform disk I/O and should not be called on the UI thread");
        if (m9399f()) {
            Collection values = this.f9062i.values();
            File[] listFiles = this.f9064k.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    if (!values.contains(file.getName())) {
                        file.delete();
                    }
                }
            }
        }
    }

    public final synchronized void m9413e() {
        this.f9054a.b("This method will perform disk I/O and should not be called on the UI thread");
        m9407a(PlatformWebDialogsPrefKeys.f11169g, "PlatformWebDialogsCache.urlMap", new CacheWrapper(this.f9062i));
    }

    private String m9393a(PlatformWebViewActionManifest platformWebViewActionManifest) {
        String c = m9398c(platformWebViewActionManifest.m12492c());
        int i = 10;
        String str = null;
        while (str == null) {
            i--;
            if (i < 0) {
                break;
            }
            str = SafeUUIDGenerator.a().toString();
            if (this.f9062i.containsValue(str)) {
                str = null;
            } else {
                this.f9062i.put(c, str);
            }
        }
        return str;
    }

    private void m9397b(final String str, final String str2) {
        if (this.f9063j != null) {
            this.f9056c.a(this.f9063j, new Predicate<String>(this) {
                final /* synthetic */ PlatformWebDialogsCache f11545c;

                public boolean apply(@Nullable Object obj) {
                    String str = (String) obj;
                    return str != null && str.startsWith(str) && (str2 == null || !str.equals(str2));
                }
            });
        }
    }

    private void m9401h() {
        if (this.f9063j != null) {
            File file = new File(this.f9057d.getCacheDir(), StringFormatUtil.formatStrLocaleSafe("%1$s%2$s", "PlatformWebDialogs_V", "1.1"));
            if (file.exists() && !file.renameTo(this.f9063j)) {
                file.delete();
            }
        }
    }

    private void m9402i() {
        if (this.f9063j != null) {
            final String name = this.f9063j.getName();
            File filesDir = this.f9057d.getFilesDir();
            if (filesDir != null) {
                File[] listFiles = filesDir.listFiles(new FileFilter(this) {
                    final /* synthetic */ PlatformWebDialogsCache f1023b;

                    public boolean accept(File file) {
                        String name = file.getName();
                        if (!file.isDirectory() || name.equals(name)) {
                            return false;
                        }
                        return name.contains("PlatformWebDialogs_V");
                    }
                });
                if (listFiles != null) {
                    for (File file : listFiles) {
                        FileTree.m3117a(file);
                        file.delete();
                    }
                }
            }
        }
    }

    private static String m9398c(String str) {
        Iterable split = Splitter.on('#').split(str);
        String str2 = (String) Iterables.a(split, null);
        String str3 = (String) Iterables.b(split, null);
        if (Strings.isNullOrEmpty(str2) || Strings.isNullOrEmpty(str3)) {
            return str2;
        }
        Matcher matcher = Pattern.compile(StringFormatUtil.formatStrLocaleSafe("%1$s=\\d+", "platformurlversion")).matcher(str3);
        str3 = null;
        while (matcher.find()) {
            str3 = matcher.group();
        }
        return !Strings.isNullOrEmpty(str3) ? StringFormatUtil.formatStrLocaleSafe("%1$s#%2$s", str2, str3) : str2;
    }
}
