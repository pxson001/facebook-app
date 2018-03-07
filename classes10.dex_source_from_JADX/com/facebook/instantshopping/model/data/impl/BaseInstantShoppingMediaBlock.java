package com.facebook.instantshopping.model.data.impl;

import com.facebook.graphql.enums.GraphQLAudioAnnotationPlayMode;
import com.facebook.graphql.enums.GraphQLDocumentFeedbackOptions;
import com.facebook.graphql.enums.GraphQLDocumentMediaPresentationStyle;
import com.facebook.graphql.enums.GraphQLInstantShoppingPresentationStyle;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.instantshopping.logging.LoggingParams;
import com.facebook.instantshopping.model.data.InstantShoppingBlockData;
import com.facebook.instantshopping.model.data.InstantShoppingMediaBlock;
import com.facebook.instantshopping.model.data.impl.BaseInstantShoppingBlockData.BaseInstantShoppingBlockDataBuilder;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLInterfaces.InstantShoppingPhotoElementFragment;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLInterfaces.InstantShoppingTextElementFragment;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingActionFragmentModel;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingCompositeBlockElementFragmentModel.BlockElementsModel;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingElementDescriptorFragmentModel;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingPhotoElementFragmentModel.ElementPhotoModel;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.ShoppingDocumentElementsEdgeModel.NodeModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentLocationAnnotationModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextAnnotationModel;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: Saved2DashboardStartSequence */
public abstract class BaseInstantShoppingMediaBlock extends BaseElementDescriptorBlockData implements InstantShoppingMediaBlock {
    private final GraphQLDocumentMediaPresentationStyle f23624a;
    private final boolean f23625b;
    private final boolean f23626c;
    private final boolean f23627d;
    private final boolean f23628e;
    private final boolean f23629f;
    private final boolean f23630g;
    private final boolean f23631h;
    private final boolean f23632i;
    private final String f23633j;
    private final InstantShoppingActionFragmentModel f23634k;
    private final LoggingParams f23635l;
    private final InstantShoppingTextElementFragment f23636m;
    private final List<? extends InstantShoppingTextElementFragment> f23637n;
    private final List<GraphQLInstantShoppingPresentationStyle> f23638o;

    /* compiled from: Saved2DashboardStartSequence */
    public abstract class BaseInstantShoppingMediaBlockBuilder<T extends InstantShoppingBlockData> extends BaseInstantShoppingBlockDataBuilder<T> {
        public final String f23608a;
        public final InstantShoppingActionFragmentModel f23609b;
        public final LoggingParams f23610c;
        public final InstantShoppingElementDescriptorFragmentModel f23611d;
        public final List<? extends InstantShoppingTextElementFragment> f23612e;
        public final List<GraphQLInstantShoppingPresentationStyle> f23613f;
        public GraphQLDocumentMediaPresentationStyle f23614g = GraphQLDocumentMediaPresentationStyle.ASPECT_FIT;
        public boolean f23615h;
        public boolean f23616i;
        public boolean f23617j;
        public boolean f23618k;
        public boolean f23619l;
        public boolean f23620m;
        public boolean f23621n;
        public boolean f23622o;
        public InstantShoppingTextElementFragment f23623p;

        public BaseInstantShoppingMediaBlockBuilder(NodeModel nodeModel, int i, int i2) {
            super(i, i2);
            this.f23608a = BaseInstantShoppingMediaBlock.m24928b(nodeModel.m());
            this.f23609b = nodeModel.a();
            this.f23610c = new LoggingParams(nodeModel.iI_(), nodeModel.c().toString());
            this.f23611d = nodeModel.d();
            this.f23612e = nodeModel.l();
            this.f23613f = nodeModel.iJ_();
        }

        public BaseInstantShoppingMediaBlockBuilder(BlockElementsModel blockElementsModel, int i, int i2) {
            super(i, i2);
            this.f23608a = BaseInstantShoppingMediaBlock.m24928b(blockElementsModel.m());
            this.f23609b = blockElementsModel.a();
            this.f23610c = new LoggingParams(blockElementsModel.iI_(), blockElementsModel.c().toString());
            this.f23611d = blockElementsModel.d();
            this.f23612e = blockElementsModel.l();
            this.f23613f = blockElementsModel.iJ_();
        }

        public BaseInstantShoppingMediaBlockBuilder(InstantShoppingPhotoElementFragment instantShoppingPhotoElementFragment, int i, int i2) {
            super(i, i2);
            this.f23608a = BaseInstantShoppingMediaBlock.m24928b(instantShoppingPhotoElementFragment.m());
            this.f23609b = instantShoppingPhotoElementFragment.a();
            this.f23610c = new LoggingParams(instantShoppingPhotoElementFragment.iI_(), instantShoppingPhotoElementFragment.c().toString());
            this.f23611d = instantShoppingPhotoElementFragment.d();
            this.f23612e = instantShoppingPhotoElementFragment.l();
            this.f23613f = instantShoppingPhotoElementFragment.iJ_();
        }
    }

    public BaseInstantShoppingMediaBlock(BaseInstantShoppingMediaBlockBuilder baseInstantShoppingMediaBlockBuilder) {
        super(baseInstantShoppingMediaBlockBuilder, baseInstantShoppingMediaBlockBuilder.f23611d);
        this.f23624a = baseInstantShoppingMediaBlockBuilder.f23614g;
        this.f23625b = baseInstantShoppingMediaBlockBuilder.f23615h;
        this.f23626c = baseInstantShoppingMediaBlockBuilder.f23616i;
        this.f23627d = baseInstantShoppingMediaBlockBuilder.f23617j;
        this.f23628e = baseInstantShoppingMediaBlockBuilder.f23618k;
        this.f23629f = baseInstantShoppingMediaBlockBuilder.f23619l;
        this.f23630g = baseInstantShoppingMediaBlockBuilder.f23620m;
        this.f23631h = baseInstantShoppingMediaBlockBuilder.f23621n;
        this.f23632i = baseInstantShoppingMediaBlockBuilder.f23622o;
        this.f23633j = baseInstantShoppingMediaBlockBuilder.f23608a;
        this.f23634k = baseInstantShoppingMediaBlockBuilder.f23609b;
        this.f23635l = baseInstantShoppingMediaBlockBuilder.f23610c;
        this.f23636m = baseInstantShoppingMediaBlockBuilder.f23623p;
        this.f23637n = baseInstantShoppingMediaBlockBuilder.f23612e;
        this.f23638o = baseInstantShoppingMediaBlockBuilder.f23613f;
    }

    public final boolean mo1012b() {
        return this.f23625b;
    }

    public final boolean nx_() {
        return this.f23626c;
    }

    @Nullable
    public final String mo1019v() {
        return this.f23633j;
    }

    public final boolean ny_() {
        return this.f23627d;
    }

    public final InstantShoppingActionFragmentModel mo1020x() {
        return this.f23634k;
    }

    public final LoggingParams mo1008C() {
        return this.f23635l;
    }

    public final boolean nv_() {
        return this.f23628e;
    }

    public final InstantShoppingTextElementFragment nz_() {
        return this.f23636m;
    }

    public final boolean nw_() {
        return this.f23629f;
    }

    public final boolean nA_() {
        return this.f23632i;
    }

    public boolean iS_() {
        return this.f23630g;
    }

    public final GraphQLDocumentMediaPresentationStyle m24943o() {
        return this.f23624a;
    }

    public final boolean mo1011F() {
        return this.f23631h;
    }

    public final GraphQLDocumentMediaPresentationStyle m24942m() {
        return this.f23624a;
    }

    public final List<? extends InstantShoppingTextElementFragment> mo1009D() {
        return this.f23637n;
    }

    public final List<GraphQLInstantShoppingPresentationStyle> mo1010E() {
        return this.f23638o;
    }

    public final boolean iR_() {
        return false;
    }

    public final RichDocumentTextAnnotationModel m24934c() {
        return null;
    }

    public final RichDocumentTextAnnotationModel iV_() {
        return null;
    }

    public final RichDocumentTextAnnotationModel m24935e() {
        return null;
    }

    public final RichDocumentLocationAnnotationModel m24936f() {
        return null;
    }

    public final String m24937g() {
        return null;
    }

    public final GraphQLAudioAnnotationPlayMode m24938h() {
        return null;
    }

    public final RichDocumentTextAnnotationModel m24939i() {
        return null;
    }

    public final GraphQLDocumentFeedbackOptions m24940j() {
        return null;
    }

    public final GraphQLFeedback m24941k() {
        return null;
    }

    public static String m24928b(ElementPhotoModel elementPhotoModel) {
        return elementPhotoModel != null ? elementPhotoModel.a() : null;
    }
}
