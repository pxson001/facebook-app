package com.facebook.pages.data.cache;

import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.common.json.FBJsonFactory;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.pages.PageInfo;
import com.facebook.pages.adminedpages.protocol.FetchAllPagesResult;
import com.facebook.pages.adminedpages.protocol.PagesInfoFqlHelper;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: mRegisteredWebviews gc'ed from  */
public class PagesInfoCache implements IHaveUserData {
    public static final PrefKey f8353a = ((PrefKey) SharedPrefKeys.d.a("pages/app/all_pages"));
    public static final PrefKey f8354b = ((PrefKey) SharedPrefKeys.d.a("pages/app/all_pages/last_fetch"));
    private static final Class<?> f8355c = PagesInfoCache.class;
    private static volatile PagesInfoCache f8356i;
    private final FbSharedPreferences f8357d;
    private final PagesInfoFqlHelper f8358e;
    private final ObjectMapper f8359f;
    private FetchAllPagesResult f8360g;
    private long f8361h;

    public static com.facebook.pages.data.cache.PagesInfoCache m8309a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8356i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.pages.data.cache.PagesInfoCache.class;
        monitor-enter(r1);
        r0 = f8356i;	 Catch:{ all -> 0x003a }
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
        r0 = m8310b(r0);	 Catch:{ all -> 0x0035 }
        f8356i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8356i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.cache.PagesInfoCache.a(com.facebook.inject.InjectorLike):com.facebook.pages.data.cache.PagesInfoCache");
    }

    private static PagesInfoCache m8310b(InjectorLike injectorLike) {
        return new PagesInfoCache((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), PagesInfoFqlHelper.b(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PagesInfoCache(FbSharedPreferences fbSharedPreferences, PagesInfoFqlHelper pagesInfoFqlHelper, ObjectMapper objectMapper) {
        this.f8357d = fbSharedPreferences;
        this.f8358e = pagesInfoFqlHelper;
        this.f8359f = objectMapper;
    }

    @Nullable
    private FetchAllPagesResult m8308a() {
        m8311b();
        return this.f8360g;
    }

    @Nullable
    public final PageInfo m8312a(String str) {
        if (str == null) {
            return null;
        }
        FetchAllPagesResult a = m8308a();
        if (a == null) {
            return null;
        }
        ArrayList arrayList = a.a;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            PageInfo pageInfo = (PageInfo) arrayList.get(i);
            if (String.valueOf(pageInfo.pageId).equals(str)) {
                return pageInfo;
            }
        }
        return null;
    }

    private void m8311b() {
        ArrayList arrayList = null;
        if (this.f8360g == null) {
            String a = this.f8357d.a(f8353a, arrayList);
            this.f8361h = this.f8357d.a(f8354b, 0);
            if (a == null || this.f8361h == 0) {
                this.f8360g = arrayList;
                return;
            }
            try {
                arrayList = this.f8358e.a((JsonNode) this.f8359f.a(FBJsonFactory.g.b(a)));
            } catch (Throwable e) {
                BLog.a(f8355c, "IOException parsing all pages info", e);
            }
            this.f8360g = new FetchAllPagesResult(DataFreshnessResult.FROM_CACHE_UP_TO_DATE, arrayList, a, this.f8361h);
        }
    }

    public void clearUserData() {
        this.f8360g = null;
        this.f8357d.edit().a(f8353a).a(f8354b).commit();
    }
}
