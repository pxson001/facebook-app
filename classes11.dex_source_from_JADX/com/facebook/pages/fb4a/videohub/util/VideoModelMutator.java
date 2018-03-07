package com.facebook.pages.fb4a.videohub.util;

import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideoDetailFragmentModel;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideoDetailFragmentModel.Builder;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideoDetailFragmentModel.CreationStoryModel;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideoDetailFragmentModel.CreationStoryModel.FeedbackModel;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideoDetailFragmentModel.CreationStoryModel.FeedbackModel.LikersModel;
import com.google.common.base.Objects;

/* compiled from: privacy_review_type */
public class VideoModelMutator {
    public static VideoDetailFragmentModel m4233a(VideoDetailFragmentModel videoDetailFragmentModel, String str, boolean z) {
        if (videoDetailFragmentModel == null || videoDetailFragmentModel.j() == null || !Objects.equal(videoDetailFragmentModel.j(), str)) {
            return videoDetailFragmentModel;
        }
        CreationStoryModel g = videoDetailFragmentModel.g();
        if (g == null || g.d() == null || g.d().g() == z) {
            return videoDetailFragmentModel;
        }
        int a = (z ? 1 : -1) + g.d().j().a();
        VideoDetailFragmentModel a2 = VideoDetailFragmentModel.a(videoDetailFragmentModel);
        Builder builder = new Builder();
        builder.a = a2.b();
        builder.b = a2.c();
        builder.c = a2.d();
        builder.d = a2.cW_();
        builder.e = a2.I();
        builder.f = a2.J();
        builder.g = a2.cX_();
        builder.h = a2.j();
        builder.i = a2.k();
        builder.j = a2.l();
        builder.k = a2.m();
        builder.l = a2.n();
        builder.m = a2.o();
        builder.n = a2.p();
        builder.o = a2.q();
        builder.p = a2.r();
        builder.q = a2.K();
        builder.r = a2.t();
        builder.s = a2.u();
        builder.t = a2.v();
        builder.u = a2.w();
        builder.v = a2.x();
        builder.w = a2.y();
        builder.x = a2.z();
        builder.y = a2.A();
        builder.z = a2.B();
        builder.A = a2.C();
        builder.B = a2.D();
        builder.C = a2.L();
        builder.D = a2.M();
        builder.E = a2.G();
        builder.F = a2.H();
        Builder builder2 = builder;
        CreationStoryModel I = a2.I();
        CreationStoryModel.Builder builder3 = new CreationStoryModel.Builder();
        builder3.a = I.b();
        builder3.b = I.c();
        builder3.c = I.k();
        builder3.d = I.cZ_();
        builder3.e = I.l();
        builder3.f = I.m();
        builder3.g = I.n();
        builder3.h = I.o();
        CreationStoryModel.Builder builder4 = builder3;
        FeedbackModel k = a2.I().k();
        FeedbackModel.Builder builder5 = new FeedbackModel.Builder();
        builder5.a = k.b();
        builder5.b = k.c();
        builder5.c = k.d();
        builder5.d = k.k();
        builder5.e = k.g();
        builder5.f = k.dg_();
        builder5.g = k.dh_();
        builder5.h = k.l();
        FeedbackModel.Builder builder6 = builder5;
        builder6.e = z;
        builder6 = builder6;
        LikersModel l = a2.I().k().l();
        LikersModel.Builder builder7 = new LikersModel.Builder();
        builder7.a = l.a();
        LikersModel.Builder builder8 = builder7;
        builder8.a = a;
        builder6.h = builder8.a();
        builder4.c = builder6.a();
        builder2.e = builder4.a();
        return builder2.a();
    }
}
