package com.facebook.video.channelfeed.protocol;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.VideoChannelFollowInputData;
import com.facebook.graphql.calls.VideoChannelSubscribeInputData;
import com.facebook.graphql.calls.VideoChannelSubscribeInputData.Surface;
import com.facebook.graphql.calls.VideoChannelUnfollowInputData;
import com.facebook.graphql.calls.VideoChannelUnsubscribeInputData;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.inject.InjectorLike;
import com.facebook.video.channelfeed.protocol.VideoChannelMutations.VideoChannelFollowCoreMutationString;
import com.facebook.video.channelfeed.protocol.VideoChannelMutations.VideoChannelSubscribeCoreMutationString;
import com.facebook.video.channelfeed.protocol.VideoChannelMutations.VideoChannelUnfollowCoreMutationString;
import com.facebook.video.channelfeed.protocol.VideoChannelMutations.VideoChannelUnsubscribeCoreMutationString;
import com.facebook.video.channelfeed.protocol.VideoChannelMutationsModels.VideoChannelFollowCoreMutationModel;
import com.facebook.video.channelfeed.protocol.VideoChannelMutationsModels.VideoChannelSubscribeCoreMutationModel;
import com.facebook.video.channelfeed.protocol.VideoChannelMutationsModels.VideoChannelSubscribeCoreMutationModel.VideoChannelModel;
import com.facebook.video.channelfeed.protocol.VideoChannelMutationsModels.VideoChannelSubscribeCoreMutationModel.VideoChannelModel.Builder;
import java.nio.ByteBuffer;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: application/vnd.apple.mpegurl */
public class VideoChannelMutationsHelper {
    public static final String f267a = VideoChannelMutationsHelper.class.getSimpleName();
    private static volatile VideoChannelMutationsHelper f268d;
    private final DefaultAndroidThreadUtil f269b;
    private final GraphQLQueryExecutor f270c;

    public static com.facebook.video.channelfeed.protocol.VideoChannelMutationsHelper m244a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f268d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.channelfeed.protocol.VideoChannelMutationsHelper.class;
        monitor-enter(r1);
        r0 = f268d;	 Catch:{ all -> 0x003a }
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
        r0 = m246b(r0);	 Catch:{ all -> 0x0035 }
        f268d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f268d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.channelfeed.protocol.VideoChannelMutationsHelper.a(com.facebook.inject.InjectorLike):com.facebook.video.channelfeed.protocol.VideoChannelMutationsHelper");
    }

    private static VideoChannelMutationsHelper m246b(InjectorLike injectorLike) {
        return new VideoChannelMutationsHelper(DefaultAndroidThreadUtil.b(injectorLike), GraphQLQueryExecutor.a(injectorLike));
    }

    @Inject
    public VideoChannelMutationsHelper(DefaultAndroidThreadUtil defaultAndroidThreadUtil, GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f269b = defaultAndroidThreadUtil;
        this.f270c = graphQLQueryExecutor;
    }

    public final void m248a(String str, Surface surface) {
        VideoChannelSubscribeInputData videoChannelSubscribeInputData = new VideoChannelSubscribeInputData();
        videoChannelSubscribeInputData.a("video_channel_id", str);
        GraphQlCallInput graphQlCallInput = videoChannelSubscribeInputData;
        graphQlCallInput.a("surface", surface);
        graphQlCallInput = graphQlCallInput;
        GraphQlQueryString videoChannelSubscribeCoreMutationString = new VideoChannelSubscribeCoreMutationString();
        videoChannelSubscribeCoreMutationString.a("video_channel_subscribe_data", graphQlCallInput);
        this.f269b.a(this.f270c.a(GraphQLRequest.a(videoChannelSubscribeCoreMutationString).a(m243a(str, true))), new 1(this));
    }

    public final void m250a(String str, VideoChannelUnsubscribeInputData.Surface surface) {
        VideoChannelUnsubscribeInputData videoChannelUnsubscribeInputData = new VideoChannelUnsubscribeInputData();
        videoChannelUnsubscribeInputData.a("video_channel_id", str);
        GraphQlCallInput graphQlCallInput = videoChannelUnsubscribeInputData;
        graphQlCallInput.a("surface", surface);
        graphQlCallInput = graphQlCallInput;
        GraphQlQueryString videoChannelUnsubscribeCoreMutationString = new VideoChannelUnsubscribeCoreMutationString();
        videoChannelUnsubscribeCoreMutationString.a("video_channel_unsubscribe_data", graphQlCallInput);
        this.f269b.a(this.f270c.a(GraphQLRequest.a(videoChannelUnsubscribeCoreMutationString).a(m243a(str, false))), new 2(this));
    }

    public final void m247a(String str, VideoChannelFollowInputData.Surface surface) {
        VideoChannelFollowInputData videoChannelFollowInputData = new VideoChannelFollowInputData();
        videoChannelFollowInputData.a("video_channel_id", str);
        GraphQlCallInput graphQlCallInput = videoChannelFollowInputData;
        graphQlCallInput.a("surface", surface);
        graphQlCallInput = graphQlCallInput;
        GraphQlQueryString videoChannelFollowCoreMutationString = new VideoChannelFollowCoreMutationString();
        videoChannelFollowCoreMutationString.a("video_channel_follow_data", graphQlCallInput);
        this.f269b.a(this.f270c.a(GraphQLRequest.a(videoChannelFollowCoreMutationString).a(m245b(str, true))), new 3(this));
    }

    public final void m249a(String str, VideoChannelUnfollowInputData.Surface surface) {
        VideoChannelUnfollowInputData videoChannelUnfollowInputData = new VideoChannelUnfollowInputData();
        videoChannelUnfollowInputData.a("video_channel_id", str);
        GraphQlCallInput graphQlCallInput = videoChannelUnfollowInputData;
        graphQlCallInput.a("surface", surface);
        graphQlCallInput = graphQlCallInput;
        GraphQlQueryString videoChannelUnfollowCoreMutationString = new VideoChannelUnfollowCoreMutationString();
        videoChannelUnfollowCoreMutationString.a("video_channel_unfollow_data", graphQlCallInput);
        this.f269b.a(this.f270c.a(GraphQLRequest.a(videoChannelUnfollowCoreMutationString).a(m245b(str, false))), new 4(this));
    }

    private static GraphQLVisitableModel m243a(String str, boolean z) {
        Builder builder = new Builder();
        builder.b = str;
        builder = builder;
        builder.c = z;
        builder = builder;
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = ModelHelper.a(flatBufferBuilder, builder.a);
        int b = flatBufferBuilder.b(builder.b);
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.a(2, builder.c);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        VideoChannelModel videoChannelModel = new VideoChannelModel(new MutableFlatBuffer(wrap, null, null, true, null));
        VideoChannelSubscribeCoreMutationModel.Builder builder2 = new VideoChannelSubscribeCoreMutationModel.Builder();
        builder2.a = videoChannelModel;
        return builder2.a();
    }

    private static GraphQLVisitableModel m245b(String str, boolean z) {
        VideoChannelFollowCoreMutationModel.VideoChannelModel.Builder builder = new VideoChannelFollowCoreMutationModel.VideoChannelModel.Builder();
        builder.b = str;
        builder = builder;
        builder.d = z;
        builder = builder;
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = ModelHelper.a(flatBufferBuilder, builder.a);
        int b = flatBufferBuilder.b(builder.b);
        int a2 = flatBufferBuilder.a(builder.c);
        flatBufferBuilder.c(4);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.a(3, builder.d);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        VideoChannelFollowCoreMutationModel.VideoChannelModel videoChannelModel = new VideoChannelFollowCoreMutationModel.VideoChannelModel(new MutableFlatBuffer(wrap, null, null, true, null));
        VideoChannelFollowCoreMutationModel.Builder builder2 = new VideoChannelFollowCoreMutationModel.Builder();
        builder2.a = videoChannelModel;
        return builder2.a();
    }
}
