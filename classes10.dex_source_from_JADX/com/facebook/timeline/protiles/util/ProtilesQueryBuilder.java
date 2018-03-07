package com.facebook.timeline.protiles.util;

import com.facebook.accessibility.AutomaticPhotoCaptioningUtils;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.graphql.calls.SectionTypesInputProfileTileSectionType;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.data.protocol.SizeAwareImageUtil;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: fb4a_displaying_faceweb_feed */
public class ProtilesQueryBuilder {
    private static final List<SectionTypesInputProfileTileSectionType> f12388a = ImmutableList.of(SectionTypesInputProfileTileSectionType.PHOTOS, SectionTypesInputProfileTileSectionType.FRIENDS);
    private static volatile ProtilesQueryBuilder f12389g;
    public final ProtilesImageUtil f12390b;
    public final QeAccessor f12391c;
    public final GraphQLImageHelper f12392d;
    public final SizeAwareImageUtil f12393e;
    public final AutomaticPhotoCaptioningUtils f12394f;

    public static com.facebook.timeline.protiles.util.ProtilesQueryBuilder m12435a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12389g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.protiles.util.ProtilesQueryBuilder.class;
        monitor-enter(r1);
        r0 = f12389g;	 Catch:{ all -> 0x003a }
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
        r0 = m12437b(r0);	 Catch:{ all -> 0x0035 }
        f12389g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12389g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.protiles.util.ProtilesQueryBuilder.a(com.facebook.inject.InjectorLike):com.facebook.timeline.protiles.util.ProtilesQueryBuilder");
    }

    private static ProtilesQueryBuilder m12437b(InjectorLike injectorLike) {
        return new ProtilesQueryBuilder(ProtilesImageUtil.m12423a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), GraphQLImageHelper.a(injectorLike), SizeAwareImageUtil.a(injectorLike), AutomaticPhotoCaptioningUtils.b(injectorLike));
    }

    @Inject
    public ProtilesQueryBuilder(ProtilesImageUtil protilesImageUtil, QeAccessor qeAccessor, GraphQLImageHelper graphQLImageHelper, SizeAwareImageUtil sizeAwareImageUtil, AutomaticPhotoCaptioningUtils automaticPhotoCaptioningUtils) {
        this.f12390b = protilesImageUtil;
        this.f12391c = qeAccessor;
        this.f12392d = graphQLImageHelper;
        this.f12393e = sizeAwareImageUtil;
        this.f12394f = automaticPhotoCaptioningUtils;
    }

    public static ImmutableList<SectionTypesInputProfileTileSectionType> m12436a(String str) {
        String[] split = str.split(",");
        Builder builder = ImmutableList.builder();
        for (String trim : split) {
            try {
                SectionTypesInputProfileTileSectionType valueOf = SectionTypesInputProfileTileSectionType.valueOf(StringLocaleUtil.b(trim.trim()));
                if (f12388a.contains(valueOf)) {
                    builder.c(valueOf);
                }
            } catch (IllegalArgumentException e) {
            }
        }
        return builder.b();
    }
}
