package com.facebook.si;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: media_ids */
public class LinkshimUtil {
    private static volatile LinkshimUtil f9003c;
    private final DefaultBlueServiceOperationFactory f9004a;
    public final Provider<String> f9005b;

    public static com.facebook.si.LinkshimUtil m10718a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9003c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.si.LinkshimUtil.class;
        monitor-enter(r1);
        r0 = f9003c;	 Catch:{ all -> 0x003a }
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
        r0 = m10720b(r0);	 Catch:{ all -> 0x0035 }
        f9003c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9003c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.si.LinkshimUtil.a(com.facebook.inject.InjectorLike):com.facebook.si.LinkshimUtil");
    }

    private static LinkshimUtil m10720b(InjectorLike injectorLike) {
        return new LinkshimUtil(DefaultBlueServiceOperationFactory.b(injectorLike), IdBasedProvider.a(injectorLike, 4442));
    }

    @Inject
    public LinkshimUtil(BlueServiceOperationFactory blueServiceOperationFactory, Provider<String> provider) {
        this.f9004a = blueServiceOperationFactory;
        this.f9005b = provider;
    }

    public static Uri m10717a(Uri uri) {
        if (FacebookUriUtil.a(uri)) {
            try {
                if (uri.getQueryParameter("s") != null) {
                    String queryParameter = uri.getQueryParameter("u");
                    if (queryParameter != null) {
                        uri = Uri.parse(queryParameter);
                    }
                }
            } catch (Exception e) {
            }
        }
        return uri;
    }

    public final void m10721b(Uri uri) {
        Bundle bundle = new Bundle();
        Builder buildUpon = Uri.parse("https://www.facebook.com").buildUpon();
        buildUpon.path("/si/ajax/l/render_linkshim_log");
        m10719a(buildUpon, uri, "s");
        m10719a(buildUpon, uri, "u");
        m10719a(buildUpon, uri, "h");
        buildUpon.appendQueryParameter("__a", "1");
        buildUpon.appendQueryParameter("__user", (String) this.f9005b.get());
        bundle.putString("linkshim_link_extra", buildUpon.build().toString());
        BlueServiceOperationFactoryDetour.a(this.f9004a, "linkshim_click", bundle, -1649596579).a(true).a();
    }

    public static void m10719a(Builder builder, Uri uri, String str) {
        String queryParameter = uri.getQueryParameter(str);
        if (queryParameter != null) {
            builder.appendQueryParameter(str, queryParameter);
        }
    }
}
