package com.facebook.instantarticles.model.wrapper;

import android.content.Context;
import com.facebook.graphql.enums.GraphQLDocumentMediaPresentationStyle;
import com.facebook.instantarticles.model.data.RichDocumentSlidesAdapter;
import com.facebook.richdocument.model.block.v2.RichDocumentBlocks;
import com.facebook.richdocument.model.data.ImageBlockData;
import com.facebook.richdocument.model.data.VideoBlockData;
import com.facebook.richdocument.model.data.impl.BaseAnnotableBlockData.BaseAnnotatableBlockBuilder;
import com.facebook.richdocument.model.data.impl.ImageBlockDataImpl.ImageBlockDataBuilder;
import com.facebook.richdocument.model.data.impl.VideoBlockDataImpl.VideoBlockDataBuilder;
import com.facebook.richdocument.model.data.impl.WebViewBlockDataImpl;
import com.facebook.richdocument.model.data.impl.WebViewBlockDataImpl.WebViewBlockDataBuilder;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentSlide;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentSectionEdgeModel.RichDocumentSectionModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentSlideModel;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

/* compiled from: video_cover_prefetch */
public class InstantArticlesBlockDataHelper {
    public static ImageBlockData m614a(RichDocumentSectionModel richDocumentSectionModel, String str) {
        ImageBlockDataBuilder imageBlockDataBuilder = new ImageBlockDataBuilder(richDocumentSectionModel.n(), richDocumentSectionModel.z());
        imageBlockDataBuilder.g = str;
        BaseAnnotatableBlockBuilder baseAnnotatableBlockBuilder = imageBlockDataBuilder;
        baseAnnotatableBlockBuilder.c = richDocumentSectionModel.g();
        baseAnnotatableBlockBuilder = baseAnnotatableBlockBuilder;
        baseAnnotatableBlockBuilder.d = richDocumentSectionModel.u();
        baseAnnotatableBlockBuilder = baseAnnotatableBlockBuilder;
        baseAnnotatableBlockBuilder.a = richDocumentSectionModel.D();
        baseAnnotatableBlockBuilder = baseAnnotatableBlockBuilder;
        baseAnnotatableBlockBuilder.b = richDocumentSectionModel.C();
        return (ImageBlockData) baseAnnotatableBlockBuilder.a(richDocumentSectionModel.d(), richDocumentSectionModel.b(), richDocumentSectionModel.c()).a(richDocumentSectionModel.p(), richDocumentSectionModel.o()).a(richDocumentSectionModel.r()).b();
    }

    public static VideoBlockData m615a(RichDocumentSectionModel richDocumentSectionModel) {
        VideoBlockDataBuilder videoBlockDataBuilder = new VideoBlockDataBuilder(richDocumentSectionModel.ig_(), richDocumentSectionModel.z(), richDocumentSectionModel.E(), richDocumentSectionModel.F(), richDocumentSectionModel.G());
        videoBlockDataBuilder.b = richDocumentSectionModel.y();
        BaseAnnotatableBlockBuilder baseAnnotatableBlockBuilder = videoBlockDataBuilder;
        baseAnnotatableBlockBuilder.c = richDocumentSectionModel.g();
        baseAnnotatableBlockBuilder = baseAnnotatableBlockBuilder;
        baseAnnotatableBlockBuilder.d = richDocumentSectionModel.u();
        baseAnnotatableBlockBuilder = baseAnnotatableBlockBuilder;
        baseAnnotatableBlockBuilder.a = richDocumentSectionModel.D();
        baseAnnotatableBlockBuilder = baseAnnotatableBlockBuilder;
        baseAnnotatableBlockBuilder.b = richDocumentSectionModel.C();
        return (VideoBlockData) baseAnnotatableBlockBuilder.a(richDocumentSectionModel.d(), richDocumentSectionModel.b(), richDocumentSectionModel.c()).a(richDocumentSectionModel.p(), richDocumentSectionModel.o()).a(richDocumentSectionModel.r()).b();
    }

    public static VideoBlockData m616a(RichDocumentSlideModel richDocumentSlideModel, GraphQLDocumentMediaPresentationStyle graphQLDocumentMediaPresentationStyle) {
        VideoBlockDataBuilder videoBlockDataBuilder = new VideoBlockDataBuilder(richDocumentSlideModel.ig_(), richDocumentSlideModel.o(), richDocumentSlideModel.r(), richDocumentSlideModel.s(), richDocumentSlideModel.t());
        videoBlockDataBuilder.h = true;
        videoBlockDataBuilder = videoBlockDataBuilder;
        videoBlockDataBuilder.i = graphQLDocumentMediaPresentationStyle;
        videoBlockDataBuilder = videoBlockDataBuilder;
        videoBlockDataBuilder.b = richDocumentSlideModel.m();
        BaseAnnotatableBlockBuilder baseAnnotatableBlockBuilder = videoBlockDataBuilder;
        baseAnnotatableBlockBuilder.c = richDocumentSlideModel.in_();
        baseAnnotatableBlockBuilder = baseAnnotatableBlockBuilder;
        baseAnnotatableBlockBuilder.d = richDocumentSlideModel.l();
        baseAnnotatableBlockBuilder = baseAnnotatableBlockBuilder;
        baseAnnotatableBlockBuilder.a = richDocumentSlideModel.q();
        baseAnnotatableBlockBuilder = baseAnnotatableBlockBuilder;
        baseAnnotatableBlockBuilder.b = richDocumentSlideModel.p();
        return (VideoBlockData) baseAnnotatableBlockBuilder.a(richDocumentSlideModel.d(), richDocumentSlideModel.b(), richDocumentSlideModel.c()).a(richDocumentSlideModel.j(), richDocumentSlideModel.im_()).a(richDocumentSlideModel.k()).b();
    }

    public static RichDocumentBlocks m613a(ImmutableList<? extends RichDocumentSlide> immutableList, Context context, GraphQLDocumentMediaPresentationStyle graphQLDocumentMediaPresentationStyle) {
        List arrayList = new ArrayList();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            arrayList.add((RichDocumentSlideModel) immutableList.get(i));
        }
        return new RichDocumentSlidesAdapter(context, graphQLDocumentMediaPresentationStyle).m611a(arrayList);
    }

    public static WebViewBlockDataImpl m617b(RichDocumentSectionModel richDocumentSectionModel, String str) {
        WebViewBlockDataBuilder webViewBlockDataBuilder = new WebViewBlockDataBuilder(richDocumentSectionModel.H(), richDocumentSectionModel.x());
        webViewBlockDataBuilder.a = richDocumentSectionModel.ik_();
        webViewBlockDataBuilder = webViewBlockDataBuilder;
        webViewBlockDataBuilder.b = richDocumentSectionModel.q();
        webViewBlockDataBuilder.c = str;
        webViewBlockDataBuilder = webViewBlockDataBuilder;
        webViewBlockDataBuilder.f = richDocumentSectionModel.y();
        webViewBlockDataBuilder = webViewBlockDataBuilder;
        webViewBlockDataBuilder.i = richDocumentSectionModel.m();
        webViewBlockDataBuilder = webViewBlockDataBuilder;
        webViewBlockDataBuilder.d = richDocumentSectionModel.il_();
        webViewBlockDataBuilder = webViewBlockDataBuilder;
        webViewBlockDataBuilder.e = richDocumentSectionModel.j();
        BaseAnnotatableBlockBuilder baseAnnotatableBlockBuilder = webViewBlockDataBuilder;
        baseAnnotatableBlockBuilder.c = richDocumentSectionModel.g();
        baseAnnotatableBlockBuilder = baseAnnotatableBlockBuilder;
        baseAnnotatableBlockBuilder.d = richDocumentSectionModel.u();
        baseAnnotatableBlockBuilder = baseAnnotatableBlockBuilder;
        baseAnnotatableBlockBuilder.a = richDocumentSectionModel.D();
        baseAnnotatableBlockBuilder = baseAnnotatableBlockBuilder;
        baseAnnotatableBlockBuilder.b = richDocumentSectionModel.C();
        return (WebViewBlockDataImpl) baseAnnotatableBlockBuilder.a(richDocumentSectionModel.d(), richDocumentSectionModel.b(), richDocumentSectionModel.c()).a(richDocumentSectionModel.p(), richDocumentSectionModel.o()).a(richDocumentSectionModel.r()).b();
    }
}
