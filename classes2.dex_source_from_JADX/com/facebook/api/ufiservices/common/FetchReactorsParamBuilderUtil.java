package com.facebook.api.ufiservices.common;

import com.facebook.feedback.reactions.abtest.ReactionsExperimentUtil;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.facebook.story.GraphQLStoryHelper;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: saved/?section_name={%s}&referer={%s} */
public class FetchReactorsParamBuilderUtil {
    private static volatile FetchReactorsParamBuilderUtil f6210c;
    private final GraphQLStoryHelper f6211a;
    private final ReactionsExperimentUtil f6212b;

    public static com.facebook.api.ufiservices.common.FetchReactorsParamBuilderUtil m10406a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6210c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.api.ufiservices.common.FetchReactorsParamBuilderUtil.class;
        monitor-enter(r1);
        r0 = f6210c;	 Catch:{ all -> 0x003a }
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
        r0 = m10407b(r0);	 Catch:{ all -> 0x0035 }
        f6210c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6210c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.ufiservices.common.FetchReactorsParamBuilderUtil.a(com.facebook.inject.InjectorLike):com.facebook.api.ufiservices.common.FetchReactorsParamBuilderUtil");
    }

    private static FetchReactorsParamBuilderUtil m10407b(InjectorLike injectorLike) {
        return new FetchReactorsParamBuilderUtil(GraphQLStoryHelper.m10197a(injectorLike), ReactionsExperimentUtil.m10410a(injectorLike));
    }

    @Inject
    public FetchReactorsParamBuilderUtil(GraphQLStoryHelper graphQLStoryHelper, ReactionsExperimentUtil reactionsExperimentUtil) {
        this.f6211a = graphQLStoryHelper;
        this.f6212b = reactionsExperimentUtil;
    }

    public final void m10408a(GraphQlQueryString graphQlQueryString) {
        graphQlQueryString.m11312a("enable_comment_reactions", Boolean.valueOf(this.f6212b.m10413g()));
        graphQlQueryString.m11312a("enable_comment_reactions_icons", Boolean.valueOf(this.f6212b.m10414h()));
    }

    public final void m10409b(GraphQlQueryString graphQlQueryString) {
        graphQlQueryString.m11314a("reactors_profile_image_size", this.f6211a.m10216c());
    }
}
