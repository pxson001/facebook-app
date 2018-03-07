package com.facebook.video.feed;

import android.net.Uri;
import com.facebook.common.util.UriUtil;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.graphql.model.GraphQLVideoGuidedTourKeyframe;
import com.facebook.inject.Assisted;
import com.facebook.qe.api.QeAccessor;
import com.facebook.spherical.model.GuidedTourParams;
import com.facebook.spherical.model.KeyframeParams;
import com.facebook.spherical.model.KeyframeParams.Builder;
import com.facebook.spherical.model.SphericalVideoParams;
import com.facebook.video.abtest.Video360DashConfig;
import com.facebook.video.abtest.Video360PlayerConfig;
import com.facebook.video.abtest.VideoDashConfig;
import com.facebook.video.analytics.VideoAnalytics.StreamSourceType;
import com.facebook.video.engine.VideoDataSource;
import com.facebook.video.engine.VideoDataSourceBuilder;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.engine.VideoPlayerParamsBuilder;
import com.facebook.video.server.VideoServer;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: photos_eviction */
public class FeedVideoPlayerParamBuilder {
    public final VideoServer f4804a;
    private final Video360PlayerConfig f4805b;
    private final QeAccessor f4806c;
    private final VideoDashConfig f4807d;
    public final FeedProps<GraphQLStoryAttachment> f4808e;
    public final GraphQLVideo f4809f;
    public final boolean f4810g;
    public final boolean f4811h;
    private Uri f4812i;
    private boolean f4813j = false;
    @Nullable
    private Video360DashConfig f4814k;

    @Inject
    public FeedVideoPlayerParamBuilder(@Nullable @Assisted FeedProps<GraphQLStoryAttachment> feedProps, @Assisted GraphQLVideo graphQLVideo, VideoServer videoServer, Provider<Video360PlayerConfig> provider, QeAccessor qeAccessor, Provider<VideoDashConfig> provider2) {
        boolean z;
        boolean z2 = true;
        this.f4804a = videoServer;
        this.f4805b = (Video360PlayerConfig) provider.get();
        this.f4808e = feedProps;
        this.f4809f = graphQLVideo;
        FeedProps e = this.f4808e == null ? null : AttachmentProps.e(this.f4808e);
        if (this.f4808e == null || e == null || !StoryProps.p(e)) {
            z = false;
        } else {
            z = true;
        }
        this.f4810g = z;
        if (!(this.f4805b.e && this.f4809f.ai())) {
            z2 = false;
        }
        this.f4811h = z2;
        this.f4806c = qeAccessor;
        this.f4807d = (VideoDashConfig) provider2.get();
    }

    public final VideoPlayerParams m5249a(boolean z, boolean z2) {
        String aA;
        String str;
        Uri uri;
        VideoDataSourceBuilder newBuilder;
        VideoDataSourceBuilder videoDataSourceBuilder;
        VideoDataSource i;
        Iterable arrayList;
        ImmutableList a;
        int size;
        int i2;
        GuidedTourParams guidedTourParams;
        SphericalVideoParams sphericalVideoParams;
        VideoPlayerParamsBuilder a2;
        VideoPlayerParamsBuilder videoPlayerParamsBuilder;
        boolean z3;
        VideoPlayerParamsBuilder videoPlayerParamsBuilder2;
        FeedProps feedProps;
        FeedProps e;
        ArrayNode a3;
        Object obj = !Strings.isNullOrEmpty(this.f4809f.be()) ? 1 : null;
        if (!this.f4811h || obj == null) {
            aA = this.f4809f.aA();
        } else {
            aA = this.f4809f.bd();
        }
        Uri a4 = UriUtil.a(aA);
        Uri a5 = UriUtil.a(this.f4809f.aJ());
        Uri a6 = UriUtil.a(this.f4809f.aB());
        String aH = this.f4809f.aH();
        Object obj2 = (a5 == null || !a5.toString().endsWith(".mpd") || Strings.isNullOrEmpty(aH)) ? null : 1;
        Object obj3 = (this.f4811h && this.f4805b.c() && this.f4807d.a()) ? 1 : null;
        if (!(obj3 == null || obj2 == null)) {
            if (this.f4814k == null) {
                this.f4814k = new Video360DashConfig(this.f4805b, this.f4806c);
            }
            if (!this.f4814k.c) {
                str = "";
                uri = null;
                newBuilder = VideoDataSource.newBuilder();
                newBuilder.f4829f = StreamSourceType.FROM_STREAM;
                newBuilder = newBuilder;
                newBuilder.f4824a = m5246c();
                newBuilder = newBuilder;
                newBuilder.f4825b = a4;
                newBuilder = newBuilder;
                newBuilder.f4826c = uri;
                videoDataSourceBuilder = newBuilder;
                videoDataSourceBuilder.f4827d = a6;
                videoDataSourceBuilder = videoDataSourceBuilder;
                videoDataSourceBuilder.f4828e = str;
                i = videoDataSourceBuilder.m5254i();
                if (Strings.isNullOrEmpty(this.f4809f.be())) {
                    aH = "CUBEMAP";
                } else {
                    aH = null;
                }
                arrayList = new ArrayList();
                if (!(this.f4809f.C() == null || this.f4809f.C().a() == null)) {
                    a = this.f4809f.C().a();
                    size = a.size();
                    for (i2 = 0; i2 < size; i2++) {
                        GraphQLVideoGuidedTourKeyframe graphQLVideoGuidedTourKeyframe = (GraphQLVideoGuidedTourKeyframe) a.get(i2);
                        Builder builder = new Builder();
                        builder.a = graphQLVideoGuidedTourKeyframe.j();
                        builder = builder;
                        builder.b = graphQLVideoGuidedTourKeyframe.a();
                        builder = builder;
                        builder.c = graphQLVideoGuidedTourKeyframe.k();
                        arrayList.add(new KeyframeParams(builder));
                    }
                }
                if (this.f4811h) {
                    guidedTourParams = null;
                } else {
                    GuidedTourParams.Builder builder2 = new GuidedTourParams.Builder();
                    builder2.a = Lists.a(arrayList);
                    guidedTourParams = new GuidedTourParams(builder2);
                }
                if (this.f4811h) {
                    sphericalVideoParams = null;
                } else {
                    SphericalVideoParams.Builder builder3 = new SphericalVideoParams.Builder();
                    builder3.a = this.f4809f.aT();
                    builder3 = builder3;
                    builder3.c = this.f4809f.Y();
                    builder3 = builder3;
                    builder3.d = -this.f4809f.Z();
                    builder3 = builder3;
                    builder3.e = this.f4809f.aa();
                    builder3 = builder3;
                    builder3.b = aH;
                    SphericalVideoParams.Builder builder4 = builder3;
                    builder4.f = this.f4809f.bf();
                    builder4 = builder4;
                    builder4.g = this.f4809f.bc();
                    builder4 = builder4;
                    builder4.h = this.f4809f.bb();
                    builder4 = builder4;
                    builder4.i = guidedTourParams;
                    sphericalVideoParams = builder4.a();
                }
                a2 = VideoPlayerParams.newBuilder().m5261a(i);
                a2.f4852b = m5247e();
                a2 = a2;
                a2.f4853c = this.f4809f.aD();
                a2 = a2;
                a2.f4856f = this.f4810g;
                videoPlayerParamsBuilder = a2;
                if (this.f4809f.af() || !z) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                videoPlayerParamsBuilder.f4857g = z3;
                a2 = videoPlayerParamsBuilder.m5259a(this.f4809f.s(), this.f4809f.G());
                a2.f4861k = this.f4809f.o();
                a2 = a2;
                a2.f4862l = sphericalVideoParams;
                videoPlayerParamsBuilder2 = a2;
                videoPlayerParamsBuilder2.f4869s = this.f4809f.aj();
                videoPlayerParamsBuilder2 = videoPlayerParamsBuilder2;
                videoPlayerParamsBuilder2.f4858h = this.f4809f.ae();
                videoPlayerParamsBuilder2 = videoPlayerParamsBuilder2;
                videoPlayerParamsBuilder2.f4864n = z2;
                videoPlayerParamsBuilder2 = videoPlayerParamsBuilder2;
                videoPlayerParamsBuilder2.f4867q = this.f4809f.ap();
                videoPlayerParamsBuilder2 = videoPlayerParamsBuilder2;
                if (this.f4808e != null) {
                    feedProps = this.f4808e;
                    e = AttachmentProps.e(feedProps);
                    if (e == null) {
                        a3 = TrackableFeedProps.a(e);
                    } else {
                        a3 = TrackableFeedProps.a(feedProps);
                    }
                    videoPlayerParamsBuilder2.f4855e = a3;
                }
                return videoPlayerParamsBuilder2.m5271m();
            }
        }
        str = aH;
        uri = a5;
        newBuilder = VideoDataSource.newBuilder();
        newBuilder.f4829f = StreamSourceType.FROM_STREAM;
        newBuilder = newBuilder;
        newBuilder.f4824a = m5246c();
        newBuilder = newBuilder;
        newBuilder.f4825b = a4;
        newBuilder = newBuilder;
        newBuilder.f4826c = uri;
        videoDataSourceBuilder = newBuilder;
        videoDataSourceBuilder.f4827d = a6;
        videoDataSourceBuilder = videoDataSourceBuilder;
        videoDataSourceBuilder.f4828e = str;
        i = videoDataSourceBuilder.m5254i();
        if (Strings.isNullOrEmpty(this.f4809f.be())) {
            aH = null;
        } else {
            aH = "CUBEMAP";
        }
        arrayList = new ArrayList();
        a = this.f4809f.C().a();
        size = a.size();
        for (i2 = 0; i2 < size; i2++) {
            GraphQLVideoGuidedTourKeyframe graphQLVideoGuidedTourKeyframe2 = (GraphQLVideoGuidedTourKeyframe) a.get(i2);
            Builder builder5 = new Builder();
            builder5.a = graphQLVideoGuidedTourKeyframe2.j();
            builder5 = builder5;
            builder5.b = graphQLVideoGuidedTourKeyframe2.a();
            builder5 = builder5;
            builder5.c = graphQLVideoGuidedTourKeyframe2.k();
            arrayList.add(new KeyframeParams(builder5));
        }
        if (this.f4811h) {
            GuidedTourParams.Builder builder22 = new GuidedTourParams.Builder();
            builder22.a = Lists.a(arrayList);
            guidedTourParams = new GuidedTourParams(builder22);
        } else {
            guidedTourParams = null;
        }
        if (this.f4811h) {
            SphericalVideoParams.Builder builder32 = new SphericalVideoParams.Builder();
            builder32.a = this.f4809f.aT();
            builder32 = builder32;
            builder32.c = this.f4809f.Y();
            builder32 = builder32;
            builder32.d = -this.f4809f.Z();
            builder32 = builder32;
            builder32.e = this.f4809f.aa();
            builder32 = builder32;
            builder32.b = aH;
            SphericalVideoParams.Builder builder42 = builder32;
            builder42.f = this.f4809f.bf();
            builder42 = builder42;
            builder42.g = this.f4809f.bc();
            builder42 = builder42;
            builder42.h = this.f4809f.bb();
            builder42 = builder42;
            builder42.i = guidedTourParams;
            sphericalVideoParams = builder42.a();
        } else {
            sphericalVideoParams = null;
        }
        a2 = VideoPlayerParams.newBuilder().m5261a(i);
        a2.f4852b = m5247e();
        a2 = a2;
        a2.f4853c = this.f4809f.aD();
        a2 = a2;
        a2.f4856f = this.f4810g;
        videoPlayerParamsBuilder = a2;
        if (this.f4809f.af()) {
        }
        z3 = false;
        videoPlayerParamsBuilder.f4857g = z3;
        a2 = videoPlayerParamsBuilder.m5259a(this.f4809f.s(), this.f4809f.G());
        a2.f4861k = this.f4809f.o();
        a2 = a2;
        a2.f4862l = sphericalVideoParams;
        videoPlayerParamsBuilder2 = a2;
        videoPlayerParamsBuilder2.f4869s = this.f4809f.aj();
        videoPlayerParamsBuilder2 = videoPlayerParamsBuilder2;
        videoPlayerParamsBuilder2.f4858h = this.f4809f.ae();
        videoPlayerParamsBuilder2 = videoPlayerParamsBuilder2;
        videoPlayerParamsBuilder2.f4864n = z2;
        videoPlayerParamsBuilder2 = videoPlayerParamsBuilder2;
        videoPlayerParamsBuilder2.f4867q = this.f4809f.ap();
        videoPlayerParamsBuilder2 = videoPlayerParamsBuilder2;
        if (this.f4808e != null) {
            feedProps = this.f4808e;
            e = AttachmentProps.e(feedProps);
            if (e == null) {
                a3 = TrackableFeedProps.a(feedProps);
            } else {
                a3 = TrackableFeedProps.a(e);
            }
            videoPlayerParamsBuilder2.f4855e = a3;
        }
        return videoPlayerParamsBuilder2.m5271m();
    }

    public final VideoPlayerParams m5248a() {
        return m5249a(true, false);
    }

    @Nullable
    private Uri m5246c() {
        if (!this.f4813j) {
            Uri a;
            if (this.f4808e == null || !((GraphQLStoryAttachment) this.f4808e.a).q()) {
                a = UriUtil.a(this.f4809f.bm());
                if (a == null) {
                    String be = this.f4809f.be();
                    String aE = this.f4809f.aE();
                    if (!this.f4811h || Strings.isNullOrEmpty(be)) {
                        be = aE;
                    }
                    a = this.f4804a.a(be, this.f4809f.J(), this.f4810g);
                }
            } else {
                a = UriUtil.a(this.f4809f.aE());
            }
            this.f4812i = a;
            this.f4813j = true;
        }
        return this.f4812i;
    }

    private String m5247e() {
        if (this.f4808e != null) {
            ImmutableList w = ((GraphQLStoryAttachment) this.f4808e.a).w();
            if (w.contains(GraphQLStoryAttachmentStyle.ANIMATED_IMAGE_VIDEO) || w.contains(GraphQLStoryAttachmentStyle.ANIMATED_IMAGE_VIDEO_AUTOPLAY)) {
                return "GIF:" + this.f4809f.J();
            }
        }
        return this.f4809f.J();
    }
}
