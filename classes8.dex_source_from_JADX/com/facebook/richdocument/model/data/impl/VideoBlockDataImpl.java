package com.facebook.richdocument.model.data.impl;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLDocumentElementType;
import com.facebook.graphql.enums.GraphQLDocumentMediaPresentationStyle;
import com.facebook.graphql.enums.GraphQLDocumentVideoAutoplayStyle;
import com.facebook.graphql.enums.GraphQLDocumentVideoControlStyle;
import com.facebook.graphql.enums.GraphQLDocumentVideoLoopingStyle;
import com.facebook.inject.FbInjector;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.model.data.PreloadableBlock;
import com.facebook.richdocument.model.data.VideoBlockData;
import com.facebook.richdocument.model.data.impl.BaseAnnotableBlockData.BaseAnnotatableBlockBuilder;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.FBPhoto;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.FBVideo;
import com.facebook.video.server.VideoPrefetchModelMethodAutoProvider;
import com.facebook.video.server.VideoResourceMetadata;
import com.facebook.video.server.prefetcher.VideoPrefetchList;
import com.facebook.video.server.prefetcher.VideoPrefetchLocation;
import com.facebook.video.server.prefetcher.VideoPrefetchModel;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: photo_picker_fragment_created */
public class VideoBlockDataImpl extends BaseAnnotableBlockData implements PreloadableBlock, VideoBlockData {
    @Inject
    public VideoPrefetchModel f5776a;
    private final FBVideo f5777b;
    private final FBPhoto f5778c;
    private final GraphQLDocumentMediaPresentationStyle f5779d;
    private final GraphQLDocumentVideoAutoplayStyle f5780e;
    private final GraphQLDocumentVideoControlStyle f5781f;
    private final GraphQLDocumentVideoLoopingStyle f5782g;
    private final boolean f5783h;
    private final boolean f5784i;
    private final GraphQLDocumentMediaPresentationStyle f5785j;
    private boolean f5786k = true;
    public VideoPrefetchList f5787l;

    /* compiled from: photo_picker_fragment_created */
    public class VideoBlockDataBuilder extends BaseAnnotatableBlockBuilder<VideoBlockData> {
        public final FBVideo f5767a;
        public FBPhoto f5768b;
        public final GraphQLDocumentMediaPresentationStyle f5769c;
        public final GraphQLDocumentVideoAutoplayStyle f5770d;
        public final GraphQLDocumentVideoControlStyle f5771e;
        public final GraphQLDocumentVideoLoopingStyle f5772f;
        public boolean f5773g;
        public boolean f5774h;
        public GraphQLDocumentMediaPresentationStyle f5775i;

        public VideoBlockDataBuilder(FBVideo fBVideo, GraphQLDocumentMediaPresentationStyle graphQLDocumentMediaPresentationStyle, GraphQLDocumentVideoAutoplayStyle graphQLDocumentVideoAutoplayStyle, GraphQLDocumentVideoControlStyle graphQLDocumentVideoControlStyle, GraphQLDocumentVideoLoopingStyle graphQLDocumentVideoLoopingStyle) {
            this(5, fBVideo, graphQLDocumentMediaPresentationStyle, graphQLDocumentVideoAutoplayStyle, graphQLDocumentVideoControlStyle, graphQLDocumentVideoLoopingStyle);
        }

        private VideoBlockDataBuilder(int i, FBVideo fBVideo, GraphQLDocumentMediaPresentationStyle graphQLDocumentMediaPresentationStyle, GraphQLDocumentVideoAutoplayStyle graphQLDocumentVideoAutoplayStyle, GraphQLDocumentVideoControlStyle graphQLDocumentVideoControlStyle, GraphQLDocumentVideoLoopingStyle graphQLDocumentVideoLoopingStyle) {
            super(i);
            this.f5767a = fBVideo;
            this.f5769c = graphQLDocumentMediaPresentationStyle;
            this.f5770d = graphQLDocumentVideoAutoplayStyle;
            this.f5771e = graphQLDocumentVideoControlStyle;
            this.f5772f = graphQLDocumentVideoLoopingStyle;
        }

        public final BlockData mo288b() {
            return new VideoBlockDataImpl(this);
        }
    }

    public static void m5553a(Object obj, Context context) {
        ((VideoBlockDataImpl) obj).f5776a = VideoPrefetchModelMethodAutoProvider.a(FbInjector.get(context));
    }

    public VideoBlockDataImpl(VideoBlockDataBuilder videoBlockDataBuilder) {
        super(videoBlockDataBuilder);
        this.f5777b = videoBlockDataBuilder.f5767a;
        this.f5778c = videoBlockDataBuilder.f5768b;
        this.f5779d = videoBlockDataBuilder.f5769c;
        this.f5780e = videoBlockDataBuilder.f5770d;
        this.f5781f = videoBlockDataBuilder.f5771e;
        this.f5782g = videoBlockDataBuilder.f5772f;
        this.f5783h = videoBlockDataBuilder.f5773g;
        this.f5784i = videoBlockDataBuilder.f5774h;
        this.f5785j = videoBlockDataBuilder.f5775i;
    }

    @Nullable
    public final FBVideo mo305p() {
        return this.f5777b;
    }

    @Nullable
    public final FBPhoto mo306q() {
        return this.f5778c;
    }

    @Nullable
    public final GraphQLDocumentMediaPresentationStyle mo293m() {
        return this.f5779d;
    }

    @Nullable
    public final GraphQLDocumentMediaPresentationStyle mo294o() {
        return this.f5785j;
    }

    @Nullable
    public final GraphQLDocumentVideoAutoplayStyle mo307r() {
        return this.f5780e;
    }

    @Nullable
    public final GraphQLDocumentVideoControlStyle mo308s() {
        return this.f5781f;
    }

    @Nullable
    public final GraphQLDocumentVideoLoopingStyle mo309t() {
        return this.f5782g;
    }

    public final boolean iR_() {
        return this.f5783h;
    }

    public final GraphQLDocumentElementType iT_() {
        return GraphQLDocumentElementType.VIDEO;
    }

    public final boolean iS_() {
        return this.f5784i;
    }

    public final void mo283a(boolean z) {
        this.f5786k = z;
    }

    public final boolean iU_() {
        return this.f5786k;
    }

    public final int mo284d() {
        return 10;
    }

    public final void mo282a(Context context) {
        Class cls = VideoBlockDataImpl.class;
        m5553a(this, context);
        this.f5787l = this.f5776a.a(VideoPrefetchLocation.INSTANT_ARTICLE);
        Object m = mo305p().mo326m();
        Object n = mo305p().mo327n();
        if (!StringUtil.a(m)) {
            this.f5787l.a(new VideoResourceMetadata[]{new VideoResourceMetadata(Uri.parse(m), mo271l())});
        }
        if (!StringUtil.a(n)) {
            this.f5787l.a(new VideoResourceMetadata[]{new VideoResourceMetadata(Uri.parse(n), mo271l())});
        }
        this.f5787l.a(true);
    }
}
