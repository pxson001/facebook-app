package com.facebook.browser.prefetch;

import com.facebook.browser.prefetch.qe.ExperimentsForBrowserPrefetchModule;
import com.facebook.graphql.enums.GraphQLBrowserPrefetchType;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.annotations.VisibleForTesting;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: postponed_build */
public class StaticResourceUrlExtractor {
    private static final String f9360a = StaticResourceUrlExtractor.class.getSimpleName();
    private static volatile StaticResourceUrlExtractor f9361d;
    private BrowserPrefetchCacheManager f9362b;
    private final QeAccessor f9363c;

    public static com.facebook.browser.prefetch.StaticResourceUrlExtractor m14330a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9361d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.browser.prefetch.StaticResourceUrlExtractor.class;
        monitor-enter(r1);
        r0 = f9361d;	 Catch:{ all -> 0x003a }
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
        r0 = m14333b(r0);	 Catch:{ all -> 0x0035 }
        f9361d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9361d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.browser.prefetch.StaticResourceUrlExtractor.a(com.facebook.inject.InjectorLike):com.facebook.browser.prefetch.StaticResourceUrlExtractor");
    }

    private static StaticResourceUrlExtractor m14333b(InjectorLike injectorLike) {
        return new StaticResourceUrlExtractor(BrowserPrefetchCacheManager.m14306a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public StaticResourceUrlExtractor(BrowserPrefetchCacheManager browserPrefetchCacheManager, QeAccessor qeAccessor) {
        this.f9362b = browserPrefetchCacheManager;
        this.f9363c = qeAccessor;
    }

    private static boolean m14334b(String str) {
        if (str.endsWith(".pdf") || str.endsWith(".ps")) {
            return false;
        }
        return true;
    }

    public final List<String> m14335a(String str, GraphQLBrowserPrefetchType graphQLBrowserPrefetchType) {
        List<String> subList;
        Throwable th;
        List<String> arrayList = new ArrayList();
        Map hashMap = new HashMap();
        int a = this.f9363c.mo572a(ExperimentsForBrowserPrefetchModule.f9379h, 20);
        if (!m14334b(str)) {
            return arrayList;
        }
        String e = this.f9362b.m14322e(str);
        if (e == null) {
            return arrayList;
        }
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(new File(e)));
            try {
                StringBuilder stringBuilder = new StringBuilder();
                String readLine = bufferedReader2.readLine();
                while (readLine != null) {
                    stringBuilder.setLength(0);
                    String str2 = readLine;
                    int i = 1;
                    while (str2 != null && i <= 100) {
                        stringBuilder.append(str2);
                        stringBuilder.append("\n");
                        str2 = bufferedReader2.readLine();
                        i++;
                    }
                    if (!m14332a(stringBuilder.toString(), hashMap, a, graphQLBrowserPrefetchType)) {
                        readLine = str2;
                    }
                }
                try {
                    bufferedReader2.close();
                    arrayList.addAll(hashMap.keySet());
                    if (arrayList.size() > a) {
                        return arrayList.subList(0, a);
                    }
                    return arrayList;
                } catch (IOException e2) {
                    new Object[1][0] = e;
                    arrayList.addAll(hashMap.keySet());
                    return arrayList.subList(0, a);
                }
            } catch (IOException e3) {
                bufferedReader = bufferedReader2;
                try {
                    new Object[1][0] = e;
                    arrayList.addAll(hashMap.keySet());
                    subList = arrayList.subList(0, a);
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return subList;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                bufferedReader = bufferedReader2;
                th = th4;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
        } catch (IOException e4) {
            new Object[1][0] = e;
            arrayList.addAll(hashMap.keySet());
            subList = arrayList.subList(0, a);
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return subList;
        }
    }

    private static boolean m14332a(String str, Map<String, Boolean> map, int i, GraphQLBrowserPrefetchType graphQLBrowserPrefetchType) {
        if (str != null) {
            m14331a("href=[\"\\']([^\"\\']+\\.css(\\?[^\"\\']*)?)[\"\\']", str, 1, (Map) map);
            if (map.size() > i) {
                return true;
            }
            m14331a("[\"\\']([^\"\\']+\\.js(\\?[^\"\\']*)?)[\"\\']", str, 1, (Map) map);
            if (map.size() > i) {
                return true;
            }
            if (graphQLBrowserPrefetchType == GraphQLBrowserPrefetchType.MEDIA) {
                m14331a("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>", str, 1, (Map) map);
                if (map.size() > i) {
                    return true;
                }
            }
        }
        return false;
    }

    @VisibleForTesting
    private static void m14331a(String str, String str2, int i, Map<String, Boolean> map) {
        Matcher matcher = Pattern.compile(str).matcher(str2);
        while (matcher.find()) {
            String group = matcher.group(i);
            if (group != null) {
                map.put(group, Boolean.valueOf(true));
            }
        }
    }
}
