package com.facebook.instantarticles.model.data;

import android.content.Context;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.graphql.enums.GraphQLDocumentMediaPresentationStyle;
import com.facebook.instantarticles.model.data.RichDocumentBlocksBuilder.C00801;
import com.facebook.instantarticles.model.wrapper.InstantArticlesBlockDataHelper;
import com.facebook.richdocument.model.block.v2.RichDocumentBlocks;
import com.facebook.richdocument.model.data.ImageBlockData;
import com.facebook.richdocument.model.data.impl.BaseAnnotableBlockData.BaseAnnotatableBlockBuilder;
import com.facebook.richdocument.model.data.impl.ImageBlockDataImpl.ImageBlockDataBuilder;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentSlide;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentSlideModel;
import java.util.Iterator;
import java.util.List;

/* compiled from: video_element_start */
public class RichDocumentSlidesAdapter {
    private final Context f511a;
    private final GraphQLDocumentMediaPresentationStyle f512b;

    public RichDocumentSlidesAdapter(Context context, GraphQLDocumentMediaPresentationStyle graphQLDocumentMediaPresentationStyle) {
        this.f511a = context;
        this.f512b = graphQLDocumentMediaPresentationStyle;
    }

    public final RichDocumentBlocks m611a(List<RichDocumentSlide> list) {
        RichDocumentBlocksBuilder richDocumentBlocksBuilder = new RichDocumentBlocksBuilder(this.f511a);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            RichDocumentSlideModel richDocumentSlideModel = (RichDocumentSlideModel) it.next();
            GraphQLDocumentMediaPresentationStyle graphQLDocumentMediaPresentationStyle = this.f512b;
            switch (C00801.f483a[richDocumentSlideModel.g().ordinal()]) {
                case 4:
                    List list2 = richDocumentBlocksBuilder.f501q;
                    String str = richDocumentBlocksBuilder.f494j;
                    ImageBlockDataBuilder imageBlockDataBuilder = new ImageBlockDataBuilder(richDocumentSlideModel.n(), richDocumentSlideModel.o());
                    imageBlockDataBuilder.f = true;
                    imageBlockDataBuilder = imageBlockDataBuilder;
                    imageBlockDataBuilder.c = graphQLDocumentMediaPresentationStyle;
                    imageBlockDataBuilder = imageBlockDataBuilder;
                    imageBlockDataBuilder.g = str;
                    BaseAnnotatableBlockBuilder baseAnnotatableBlockBuilder = imageBlockDataBuilder;
                    baseAnnotatableBlockBuilder.c = richDocumentSlideModel.in_();
                    baseAnnotatableBlockBuilder = baseAnnotatableBlockBuilder;
                    baseAnnotatableBlockBuilder.d = richDocumentSlideModel.l();
                    baseAnnotatableBlockBuilder = baseAnnotatableBlockBuilder;
                    baseAnnotatableBlockBuilder.a = richDocumentSlideModel.q();
                    baseAnnotatableBlockBuilder = baseAnnotatableBlockBuilder;
                    baseAnnotatableBlockBuilder.b = richDocumentSlideModel.p();
                    list2.add((ImageBlockData) baseAnnotatableBlockBuilder.a(richDocumentSlideModel.d(), richDocumentSlideModel.b(), richDocumentSlideModel.c()).a(richDocumentSlideModel.j(), richDocumentSlideModel.im_()).a(richDocumentSlideModel.k()).b());
                    break;
                case 5:
                    richDocumentBlocksBuilder.f501q.add(InstantArticlesBlockDataHelper.m616a(richDocumentSlideModel, graphQLDocumentMediaPresentationStyle));
                    break;
                default:
                    richDocumentBlocksBuilder.f489e.a(SoftError.a(RichDocumentBlocksBuilder.f484y + ".addSlideBlock", "Error attempting to add slide block of type " + richDocumentSlideModel.g()).g());
                    break;
            }
        }
        return richDocumentBlocksBuilder.m608b();
    }
}
