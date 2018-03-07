package com.facebook.richdocument.model.block;

import android.net.Uri;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.FBFullImageFragmentModel;
import com.facebook.graphql.enums.GraphQLDocumentMediaPresentationStyle;
import com.facebook.graphql.enums.GraphQLDocumentVideoAutoplayStyle;
import com.facebook.graphql.enums.GraphQLDocumentVideoControlStyle;
import com.facebook.graphql.enums.GraphQLDocumentVideoLoopingStyle;
import com.facebook.richdocument.model.data.VideoBlockData;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.FBPhoto;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.FBVideo;
import com.facebook.richdocument.model.graphql.RichDocumentNativeAdsGraphqlModels.RichDocumentHTMLNativeAdFragmentModel.FallbackNativeAdModel;
import com.facebook.richdocument.view.autoplay.VideoAutoPlayPolicy;
import com.facebook.spherical.model.SphericalVideoParams;
import com.facebook.spherical.model.SphericalVideoParams.Builder;
import com.facebook.video.analytics.VideoAnalytics.StreamSourceType;
import com.facebook.video.engine.VideoDataSource;
import com.facebook.video.engine.VideoDataSourceBuilder;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.engine.VideoPlayerParamsBuilder;
import com.facebook.video.server.VideoServer;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

/* compiled from: pin_state */
public final class VideoBlockInput {
    public final String f5645a;
    public final VideoPlayerParams f5646b;
    public final int f5647c;
    public final int f5648d;
    public final String f5649e;
    public final String f5650f;
    public final int f5651g;
    public final int f5652h;
    public final boolean f5653i;
    public final GraphQLDocumentMediaPresentationStyle f5654j;
    public final GraphQLDocumentVideoAutoplayStyle f5655k;
    public final GraphQLDocumentVideoControlStyle f5656l;
    private final GraphQLDocumentVideoLoopingStyle f5657m;

    private VideoBlockInput(String str, VideoPlayerParams videoPlayerParams, int i, int i2, String str2, String str3, int i3, int i4, boolean z, GraphQLDocumentMediaPresentationStyle graphQLDocumentMediaPresentationStyle, GraphQLDocumentVideoAutoplayStyle graphQLDocumentVideoAutoplayStyle, GraphQLDocumentVideoControlStyle graphQLDocumentVideoControlStyle, GraphQLDocumentVideoLoopingStyle graphQLDocumentVideoLoopingStyle) {
        this.f5645a = str;
        this.f5646b = videoPlayerParams;
        this.f5647c = i;
        this.f5648d = i2;
        this.f5649e = str2;
        this.f5650f = str3;
        this.f5651g = i3;
        this.f5652h = i4;
        this.f5653i = z;
        this.f5654j = graphQLDocumentMediaPresentationStyle;
        this.f5655k = graphQLDocumentVideoAutoplayStyle;
        this.f5656l = graphQLDocumentVideoControlStyle;
        this.f5657m = graphQLDocumentVideoLoopingStyle;
    }

    public static VideoBlockInput m5450a(VideoBlockData videoBlockData, VideoServer videoServer, VideoAutoPlayPolicy videoAutoPlayPolicy, boolean z) {
        if (videoBlockData == null || videoBlockData.mo305p() == null || videoServer == null) {
            return null;
        }
        int i;
        String d;
        int bD_;
        int a;
        FBVideo p = videoBlockData.mo305p();
        String b = p.mo319b();
        boolean k = p.mo324k();
        VideoDataSource a2 = m5453a(p, videoServer, z);
        boolean z2 = videoBlockData.mo309t() == GraphQLDocumentVideoLoopingStyle.LOOPING || videoBlockData.mo309t() == GraphQLDocumentVideoLoopingStyle.LOOPING_WITH_CROSS_FADE;
        int i2 = p.mo329p() != null ? 1 : 0;
        SphericalVideoParams sphericalVideoParams = null;
        if (k && z) {
            i = (p.mo335v() != null ? 1 : 0) | i2;
            sphericalVideoParams = new Builder().a(p.mo330q()).a(p.hU_()).b(p.hV_()).c(p.mo323j()).b("CUBEMAP").d(p.mo336w()).a(p.mo332s()).b(p.mo331r()).a();
        } else {
            i = i2;
        }
        VideoPlayerParamsBuilder c = VideoPlayerParams.newBuilder().a(a2).a(b).a(p.mo325l()).c(z2);
        if (i == 0 && videoAutoPlayPolicy != null && videoAutoPlayPolicy.m6891a()) {
            z2 = true;
        } else {
            z2 = false;
        }
        VideoPlayerParams m = c.d(z2).a(sphericalVideoParams).m();
        i = videoBlockData.mo305p().mo338y();
        i2 = videoBlockData.mo305p().mo320g();
        FBPhoto q = videoBlockData.mo306q();
        FBFullImageFragmentModel x = p.mo337x();
        Object obj = (q == null || q.mo316c() == null) ? null : 1;
        String str = null;
        if (obj != null) {
            d = q.mo316c().d();
            bD_ = q.mo316c().bD_();
            a = q.mo316c().a();
            str = q.hS_();
        } else {
            d = x.d();
            bD_ = x.bD_();
            a = x.a();
        }
        return new VideoBlockInput(b, m, i, i2, d, str, bD_, a, k, videoBlockData.mo293m(), videoBlockData.mo307r(), videoBlockData.mo308s(), videoBlockData.mo309t());
    }

    private static VideoPlayerParams m5454a(FBVideo fBVideo, boolean z, ArrayNode arrayNode, VideoServer videoServer, VideoAutoPlayPolicy videoAutoPlayPolicy, boolean z2) {
        boolean z3 = false;
        String b = fBVideo.mo319b();
        VideoDataSource a = m5453a(fBVideo, videoServer, z2);
        boolean z4 = fBVideo.mo329p() != null || (z2 && fBVideo.mo324k() && fBVideo.mo335v() != null);
        VideoPlayerParamsBuilder a2 = VideoPlayerParams.newBuilder().a(a);
        a2.b = b;
        VideoPlayerParamsBuilder videoPlayerParamsBuilder = a2;
        videoPlayerParamsBuilder.c = fBVideo.mo325l();
        videoPlayerParamsBuilder = videoPlayerParamsBuilder;
        videoPlayerParamsBuilder.g = z;
        videoPlayerParamsBuilder = videoPlayerParamsBuilder;
        if (!(z4 || videoAutoPlayPolicy == null || !videoAutoPlayPolicy.m6891a())) {
            z3 = true;
        }
        videoPlayerParamsBuilder.m = z3;
        VideoPlayerParamsBuilder videoPlayerParamsBuilder2 = videoPlayerParamsBuilder;
        videoPlayerParamsBuilder2.e = arrayNode;
        videoPlayerParamsBuilder2 = videoPlayerParamsBuilder2;
        videoPlayerParamsBuilder2.f = true;
        return videoPlayerParamsBuilder2.m();
    }

    public static VideoBlockInput m5452a(FallbackNativeAdModel fallbackNativeAdModel, VideoServer videoServer, VideoAutoPlayPolicy videoAutoPlayPolicy, AbstractFbErrorReporter abstractFbErrorReporter, boolean z) {
        if (fallbackNativeAdModel == null || fallbackNativeAdModel.m6721t() == null || videoServer == null) {
            return null;
        }
        FBVideo t = fallbackNativeAdModel.m6721t();
        ArrayNode b = JsonNodeFactory.a.b();
        try {
            b.h(fallbackNativeAdModel.m6720s());
        } catch (Exception e) {
            if (abstractFbErrorReporter != null) {
                abstractFbErrorReporter.a("NativeVideoAd", "Error Parsing tracking codes", e.getCause());
            }
        }
        boolean z2 = fallbackNativeAdModel.m6724w() == GraphQLDocumentVideoLoopingStyle.LOOPING || fallbackNativeAdModel.m6724w() == GraphQLDocumentVideoLoopingStyle.LOOPING_WITH_CROSS_FADE;
        return new VideoBlockInput(t.mo319b(), m5454a(t, z2, b, videoServer, videoAutoPlayPolicy, z), t.mo338y(), t.mo320g(), t.mo337x().d(), null, 0, 0, false, GraphQLDocumentMediaPresentationStyle.ASPECT_FIT, fallbackNativeAdModel.m6722u(), fallbackNativeAdModel.m6723v(), fallbackNativeAdModel.m6724w());
    }

    private static VideoDataSource m5453a(FBVideo fBVideo, VideoServer videoServer, boolean z) {
        Uri uri = null;
        if (fBVideo == null || videoServer == null) {
            return null;
        }
        Uri parse;
        boolean z2 = fBVideo.mo324k() && z;
        String b = fBVideo.mo319b();
        String u = z2 ? fBVideo.mo334u() : fBVideo.mo326m();
        String t = z2 ? fBVideo.mo333t() : fBVideo.mo327n();
        String t2 = z2 ? fBVideo.mo333t() : fBVideo.mo328o();
        String v = z2 ? fBVideo.mo335v() : fBVideo.mo329p();
        if (u != null) {
            parse = Uri.parse(u);
        } else {
            parse = null;
        }
        Uri a = videoServer.a(parse, b, true);
        if (a == null) {
            a = parse;
        }
        parse = t == null ? null : videoServer.a(Uri.parse(t), b, true);
        if (t2 != null) {
            uri = videoServer.a(Uri.parse(t2), b, true);
        }
        VideoDataSourceBuilder newBuilder = VideoDataSource.newBuilder();
        newBuilder.a = a;
        newBuilder = newBuilder;
        newBuilder.b = parse;
        VideoDataSourceBuilder videoDataSourceBuilder = newBuilder;
        videoDataSourceBuilder.c = uri;
        videoDataSourceBuilder = videoDataSourceBuilder;
        videoDataSourceBuilder.e = v;
        videoDataSourceBuilder = videoDataSourceBuilder;
        videoDataSourceBuilder.f = StreamSourceType.FROM_STREAM;
        return videoDataSourceBuilder.i();
    }

    public static VideoBlockInput m5451a(FBVideo fBVideo, String str, GraphQLDocumentVideoAutoplayStyle graphQLDocumentVideoAutoplayStyle, GraphQLDocumentVideoControlStyle graphQLDocumentVideoControlStyle, GraphQLDocumentVideoLoopingStyle graphQLDocumentVideoLoopingStyle, VideoServer videoServer, VideoAutoPlayPolicy videoAutoPlayPolicy, AbstractFbErrorReporter abstractFbErrorReporter, boolean z) {
        ArrayNode b = JsonNodeFactory.a.b();
        try {
            b.h(str);
        } catch (Exception e) {
            if (abstractFbErrorReporter != null) {
                abstractFbErrorReporter.a("NativeVideoAd", "Error Parsing tracking codes", e.getCause());
            }
        }
        boolean z2 = graphQLDocumentVideoLoopingStyle == GraphQLDocumentVideoLoopingStyle.LOOPING || graphQLDocumentVideoLoopingStyle == GraphQLDocumentVideoLoopingStyle.LOOPING_WITH_CROSS_FADE;
        return new VideoBlockInput(fBVideo.mo319b(), m5454a(fBVideo, z2, b, videoServer, videoAutoPlayPolicy, z), fBVideo.mo338y(), fBVideo.mo320g(), fBVideo.mo337x().d(), null, 0, 0, false, GraphQLDocumentMediaPresentationStyle.ASPECT_FIT, graphQLDocumentVideoAutoplayStyle, graphQLDocumentVideoControlStyle, graphQLDocumentVideoLoopingStyle);
    }
}
