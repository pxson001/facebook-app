package com.facebook.http.protocol;

import com.facebook.common.locale.Locales;
import com.facebook.crudolib.params.ParamsCollectionMap;
import com.facebook.crudolib.params.ParamsCollectionPool;
import com.facebook.http.common.C0309xb6c3435b;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.apache.http.NameValuePair;

@Singleton
@Immutable
/* compiled from: request_status */
public class ApiRequestUtils {
    private static volatile ApiRequestUtils f7273d;
    public final Locales f7274a;
    public final Provider<String> f7275b;
    private final ParamsCollectionPool f7276c;

    public static com.facebook.http.protocol.ApiRequestUtils m11769a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7273d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.protocol.ApiRequestUtils.class;
        monitor-enter(r1);
        r0 = f7273d;	 Catch:{ all -> 0x003a }
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
        r0 = m11770b(r0);	 Catch:{ all -> 0x0035 }
        f7273d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7273d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.protocol.ApiRequestUtils.a(com.facebook.inject.InjectorLike):com.facebook.http.protocol.ApiRequestUtils");
    }

    private static ApiRequestUtils m11770b(InjectorLike injectorLike) {
        return new ApiRequestUtils(Locales.m2604a(injectorLike), IdBasedProvider.m1811a(injectorLike, 4446), C0309xb6c3435b.m11772a(injectorLike));
    }

    @Inject
    public ApiRequestUtils(Locales locales, Provider<String> provider, ParamsCollectionPool paramsCollectionPool) {
        this.f7274a = locales;
        this.f7275b = provider;
        this.f7276c = paramsCollectionPool;
    }

    public final ParamsCollectionMap m11771a(ApiRequest apiRequest) {
        Object obj;
        ParamsCollectionMap j;
        if (apiRequest.f7503h != null) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            j = apiRequest.m12108j();
        } else {
            ParamsCollectionMap b = this.f7276c.m5398b();
            ImmutableList h = apiRequest.m12107h();
            int size = h.size();
            for (int i = 0; i < size; i++) {
                NameValuePair nameValuePair = (NameValuePair) h.get(i);
                b.m5421a(nameValuePair.getName(), nameValuePair.getValue());
            }
            j = b;
        }
        j.m5421a("locale", this.f7274a.m2613c());
        String str = (String) this.f7275b.get();
        if (str != null) {
            j.m5421a("client_country_code", str);
        }
        return j;
    }
}
