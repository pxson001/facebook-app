package com.facebook.video.channelfeed.protocol;

import com.facebook.graphql.calls.EntryPointInputVideoChannelEntryPoint;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.facebook.video.channelfeed.abtest.ChannelFeedConfig;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: scheduled_time */
public class FetchVideoChannelParamBuilderUtil {
    private static volatile FetchVideoChannelParamBuilderUtil f6031b;
    private final ChannelFeedConfig f6032a;

    public static com.facebook.video.channelfeed.protocol.FetchVideoChannelParamBuilderUtil m10180a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6031b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.channelfeed.protocol.FetchVideoChannelParamBuilderUtil.class;
        monitor-enter(r1);
        r0 = f6031b;	 Catch:{ all -> 0x003a }
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
        r0 = m10181b(r0);	 Catch:{ all -> 0x0035 }
        f6031b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6031b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.channelfeed.protocol.FetchVideoChannelParamBuilderUtil.a(com.facebook.inject.InjectorLike):com.facebook.video.channelfeed.protocol.FetchVideoChannelParamBuilderUtil");
    }

    private static FetchVideoChannelParamBuilderUtil m10181b(InjectorLike injectorLike) {
        return new FetchVideoChannelParamBuilderUtil(ChannelFeedConfig.m10184a(injectorLike));
    }

    @Inject
    public FetchVideoChannelParamBuilderUtil(ChannelFeedConfig channelFeedConfig) {
        this.f6032a = channelFeedConfig;
    }

    public final void m10182a(GraphQlQueryString graphQlQueryString) {
        m10183a(graphQlQueryString, EntryPointInputVideoChannelEntryPoint.UNKNOWN);
    }

    public final void m10183a(GraphQlQueryString graphQlQueryString, EntryPointInputVideoChannelEntryPoint entryPointInputVideoChannelEntryPoint) {
        boolean z = this.f6032a.f6043j;
        graphQlQueryString.m11312a("in_channel_eligibility_experiment", Boolean.valueOf(z));
        if (z) {
            graphQlQueryString.m11313a("video_channel_entry_point", (Enum) entryPointInputVideoChannelEntryPoint);
        }
    }
}
