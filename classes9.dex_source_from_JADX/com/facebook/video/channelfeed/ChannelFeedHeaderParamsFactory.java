package com.facebook.video.channelfeed;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.graphql.calls.VideoChannelSetPinStateInputData.ChannelType;
import com.facebook.graphql.calls.VideoChannelSetPinStateInputData.PinState;
import com.facebook.graphql.calls.VideoChannelSetPinStateInputData.Surface;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.inject.InjectorLike;
import com.facebook.topics.data.VideoChannelPinStateMutator;
import com.facebook.topics.protocol.TopicFavoritesQueryInterfaces.VideoTopicFragment;
import com.facebook.video.channelfeed.ChannelFeedHeaderParams.Builder;
import com.facebook.video.followvideos.VideoHomeFollowVideosButton.SubscribeStateChangedListener;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: target_ent_id */
public class ChannelFeedHeaderParamsFactory {
    private static volatile ChannelFeedHeaderParamsFactory f2276d;
    private final Resources f2277a;
    public final VideoChannelPinStateMutator f2278b;
    private final Context f2279c;

    public static com.facebook.video.channelfeed.ChannelFeedHeaderParamsFactory m2263a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2276d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.channelfeed.ChannelFeedHeaderParamsFactory.class;
        monitor-enter(r1);
        r0 = f2276d;	 Catch:{ all -> 0x003a }
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
        r0 = m2264b(r0);	 Catch:{ all -> 0x0035 }
        f2276d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2276d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.channelfeed.ChannelFeedHeaderParamsFactory.a(com.facebook.inject.InjectorLike):com.facebook.video.channelfeed.ChannelFeedHeaderParamsFactory");
    }

    private static ChannelFeedHeaderParamsFactory m2264b(InjectorLike injectorLike) {
        return new ChannelFeedHeaderParamsFactory(ResourcesMethodAutoProvider.a(injectorLike), VideoChannelPinStateMutator.b(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public ChannelFeedHeaderParamsFactory(Resources resources, VideoChannelPinStateMutator videoChannelPinStateMutator, Context context) {
        this.f2277a = resources;
        this.f2278b = videoChannelPinStateMutator;
        this.f2279c = context;
    }

    @Nullable
    public static ChannelFeedHeaderParams m2262a(@Nullable GraphQLActor graphQLActor) {
        String str = null;
        if (graphQLActor == null) {
            return null;
        }
        GraphQLTextWithEntities aF = graphQLActor.aF();
        GraphQLTextWithEntities aE = graphQLActor.aE();
        GraphQLProfile az = graphQLActor.az();
        if (az == null || az.ai() == null || az.ai().b() == null) {
            return null;
        }
        String a;
        Builder builder = new Builder();
        builder.f2247a = graphQLActor.H();
        builder = builder;
        if (aF != null) {
            a = aF.a();
        } else {
            a = null;
        }
        builder.f2248b = a;
        Builder builder2 = builder;
        if (aE != null) {
            str = aE.a();
        }
        builder2.f2249c = str;
        builder2 = builder2;
        builder2.f2251e = az.ai().b();
        builder2 = builder2;
        builder2.f2252f = graphQLActor.aB();
        builder2 = builder2;
        builder2.f2253g = graphQLActor.aI();
        builder2 = builder2;
        builder2.f2254h = graphQLActor.ay();
        builder2 = builder2;
        builder2.f2255i = graphQLActor.aJ();
        builder2 = builder2;
        builder2.f2259m = graphQLActor;
        return builder2.m2260a();
    }

    @Nullable
    public final ChannelFeedHeaderParams m2265a(@Nullable final VideoTopicFragment videoTopicFragment, final String str) {
        String str2 = null;
        if (videoTopicFragment == null) {
            return null;
        }
        String a;
        C02121 c02121 = new SubscribeStateChangedListener(this) {
            final /* synthetic */ ChannelFeedHeaderParamsFactory f2275c;

            public final void m2261a(boolean z) {
                this.f2275c.f2278b.a(videoTopicFragment, z ? PinState.PINNED : PinState.UNPINNED, ChannelType.TOPICAL_LIVE_VIDEOS, str, Surface.VIDEO_CHANNEL_HEADER, null);
            }
        };
        String a2 = videoTopicFragment.j() != null ? videoTopicFragment.j().a() : null;
        if (videoTopicFragment.fg_() != null) {
            a = videoTopicFragment.fg_().a();
        } else {
            a = null;
        }
        if (videoTopicFragment.d() != null) {
            str2 = videoTopicFragment.d().a();
        }
        int c = videoTopicFragment.c();
        int ff_ = videoTopicFragment.ff_();
        String str3 = "";
        if (c > 0) {
            str3 = c > ff_ ? this.f2277a.getString(2131237309, new Object[]{Integer.valueOf(ff_)}) : this.f2277a.getString(2131237308, new Object[]{Integer.valueOf(c)});
        }
        String string = this.f2279c.getResources().getString(2131237313);
        String string2 = this.f2279c.getResources().getString(2131237312);
        Builder builder = new Builder();
        builder.f2247a = videoTopicFragment.b();
        builder = builder;
        builder.f2248b = a2;
        Builder builder2 = builder;
        builder2.f2249c = a;
        builder2 = builder2;
        builder2.f2250d = str3;
        builder2 = builder2;
        builder2.f2251e = str2;
        builder2 = builder2;
        builder2.f2252f = videoTopicFragment.g();
        builder2 = builder2;
        builder2.f2254h = true;
        builder2 = builder2;
        builder2.f2256j = string;
        builder2 = builder2;
        builder2.f2257k = string2;
        builder2 = builder2;
        builder2.f2258l = c02121;
        return builder2.m2260a();
    }
}
