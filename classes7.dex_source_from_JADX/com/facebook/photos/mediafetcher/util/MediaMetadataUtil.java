package com.facebook.photos.mediafetcher.util;

import android.content.res.Resources;
import com.facebook.api.ufiservices.common.FetchReactorsParamBuilderUtil;
import com.facebook.api.ufiservices.common.FetchRecentActivityParamBuilderUtil;
import com.facebook.api.ufiservices.qe.ExperimentsForUfiServiceQeModule;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.inject.InjectorLike;
import com.facebook.location.FbLocationStatus.State;
import com.facebook.location.FbLocationStatusUtil;
import com.facebook.photos.data.protocol.SizeAwareImageUtil;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: justifyContent */
public class MediaMetadataUtil {
    private static volatile MediaMetadataUtil f10641h;
    private final SizeAwareImageUtil f10642a;
    private final Resources f10643b;
    private final FbLocationStatusUtil f10644c;
    private final FetchReactorsParamBuilderUtil f10645d;
    private final FetchRecentActivityParamBuilderUtil f10646e;
    public final QeAccessor f10647f;
    public Boolean f10648g = null;

    public static com.facebook.photos.mediafetcher.util.MediaMetadataUtil m12709a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10641h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.mediafetcher.util.MediaMetadataUtil.class;
        monitor-enter(r1);
        r0 = f10641h;	 Catch:{ all -> 0x003a }
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
        r0 = m12710b(r0);	 Catch:{ all -> 0x0035 }
        f10641h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10641h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.mediafetcher.util.MediaMetadataUtil.a(com.facebook.inject.InjectorLike):com.facebook.photos.mediafetcher.util.MediaMetadataUtil");
    }

    private static MediaMetadataUtil m12710b(InjectorLike injectorLike) {
        return new MediaMetadataUtil(SizeAwareImageUtil.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), FbLocationStatusUtil.a(injectorLike), FetchReactorsParamBuilderUtil.a(injectorLike), FetchRecentActivityParamBuilderUtil.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public MediaMetadataUtil(SizeAwareImageUtil sizeAwareImageUtil, Resources resources, FbLocationStatusUtil fbLocationStatusUtil, FetchReactorsParamBuilderUtil fetchReactorsParamBuilderUtil, FetchRecentActivityParamBuilderUtil fetchRecentActivityParamBuilderUtil, QeAccessor qeAccessor) {
        this.f10642a = sizeAwareImageUtil;
        this.f10643b = resources;
        this.f10644c = fbLocationStatusUtil;
        this.f10645d = fetchReactorsParamBuilderUtil;
        this.f10646e = fetchRecentActivityParamBuilderUtil;
        this.f10647f = qeAccessor;
    }

    public final GraphQlQueryString m12711a(GraphQlQueryString graphQlQueryString) {
        boolean z = true;
        GraphQlQueryString a = graphQlQueryString.a("icon_scale", GraphQlQueryDefaults.a());
        String str = "include_replies_in_total_count";
        if (this.f10648g == null) {
            this.f10648g = Boolean.valueOf(this.f10647f.a(ExperimentsForUfiServiceQeModule.l, false));
        }
        a.a(str, Boolean.toString(this.f10648g.booleanValue())).a("fetch_heisman_cta", Boolean.valueOf(true));
        if (this.f10644c.b().a != State.OKAY) {
            z = false;
        }
        graphQlQueryString.a("can_fetch_suggestion", Boolean.toString(z));
        graphQlQueryString.a("location_suggestion_profile_image_size", Integer.valueOf(this.f10643b.getDimensionPixelSize(2131431947)));
        this.f10645d.a(graphQlQueryString);
        this.f10646e.a(graphQlQueryString);
        return this.f10642a.b(graphQlQueryString);
    }
}
