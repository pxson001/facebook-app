package com.facebook.richdocument.model.graphql;

import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.FBFullImageFragmentModel;
import com.facebook.graphql.enums.GraphQLComposedBlockType;
import com.facebook.graphql.enums.GraphQLDocumentElementType;
import com.facebook.graphql.enums.GraphQLDocumentListStyle;
import com.facebook.graphql.enums.GraphQLDocumentTextDirectionEnum;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.FBMessengerSubscriptionInfoModel.MessengerContentSubscriptionOptionModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentEdgeModel.CoverMediaModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentMasterModel.RelatedArticleObjectsModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentStyleModel;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: upload_photo_menu_impression */
public class RichDocumentGraphQlInterfaces {

    /* compiled from: upload_photo_menu_impression */
    public interface RichDocumentFontResource {
        @Nullable
        String mo25a();

        @Nullable
        String mo26b();

        @Nullable
        String mo27c();
    }

    /* compiled from: upload_photo_menu_impression */
    public interface RichDocumentText {
        @Nullable
        GraphQLComposedBlockType mo300a();

        @Nonnull
        ImmutableList<? extends EntityRanges> mo301b();

        @Nonnull
        ImmutableList<? extends InlineStyleRanges> mo302c();

        @Nullable
        String mo303d();
    }

    /* compiled from: upload_photo_menu_impression */
    public interface FBMessengerSubscriptionInfo {
    }

    /* compiled from: upload_photo_menu_impression */
    public interface FBPage {
        boolean mo310b();

        boolean mo311c();

        @Nullable
        String mo312d();

        @Nullable
        FBFullImageFragmentModel mo313g();

        @Nullable
        String hR_();
    }

    /* compiled from: upload_photo_menu_impression */
    public interface FBPhoto {
        @Nullable
        String mo315b();

        @Nullable
        FBFullImageFragmentModel mo316c();

        @Nullable
        FBFullImageFragmentModel mo317d();

        @Nullable
        String hS_();
    }

    /* compiled from: upload_photo_menu_impression */
    public interface FBVideo {
        @Nullable
        String mo319b();

        int mo320g();

        int hU_();

        int hV_();

        int mo323j();

        boolean mo324k();

        int mo325l();

        @Nullable
        String mo326m();

        @Nullable
        String mo327n();

        @Nullable
        String mo328o();

        @Nullable
        String mo329p();

        @Nullable
        String mo330q();

        double mo331r();

        double mo332s();

        @Nullable
        String mo333t();

        @Nullable
        String mo334u();

        @Nullable
        String mo335v();

        int mo336w();

        @Nullable
        FBFullImageFragmentModel mo337x();

        int mo338y();
    }

    /* compiled from: upload_photo_menu_impression */
    public interface RichDocumentPhoto {
        @Nullable
        FBPhoto mo340n();
    }

    /* compiled from: upload_photo_menu_impression */
    public interface RichDocumentSlideshow {
    }

    /* compiled from: upload_photo_menu_impression */
    public interface RichDocumentVideo {
        @Nullable
        FBVideo ig_();
    }

    /* compiled from: upload_photo_menu_impression */
    public interface RichDocumentEdge {

        /* compiled from: upload_photo_menu_impression */
        public interface DocumentAuthors {
            @Nonnull
            ImmutableList<? extends RichDocumentAuthorEdge> mo341a();
        }

        /* compiled from: upload_photo_menu_impression */
        public interface DocumentBodyElements {
            @Nonnull
            ImmutableList<? extends RichDocumentSectionEdge> mo342a();
        }

        @Nullable
        String mo343b();

        int mo344c();

        @Nullable
        RichDocumentText mo345d();

        @Nullable
        RichDocumentText mo346g();

        @Nullable
        DocumentBodyElements ib_();

        @Nullable
        DocumentAuthors ic_();

        @Nullable
        CoverMediaModel id_();

        @Nullable
        RichDocumentText mo350j();

        @Nullable
        FBPage mo351k();

        @Nullable
        RichDocumentStyleModel mo352l();

        @Nullable
        RichDocumentText mo353m();

        @Nullable
        RichDocumentText mo354n();

        @Nullable
        String mo355o();

        long mo356p();

        @Nullable
        GraphQLDocumentTextDirectionEnum mo357q();
    }

    /* compiled from: upload_photo_menu_impression */
    public interface RichDocumentNestedListItemFields {
        @Nullable
        GraphQLDocumentElementType mo358b();

        @Nullable
        RichDocumentText mo359c();

        @Nullable
        GraphQLDocumentListStyle ih_();
    }

    /* compiled from: upload_photo_menu_impression */
    public interface RichDocumentNestedListItem extends RichDocumentNestedListItemFields {
    }

    /* compiled from: upload_photo_menu_impression */
    public interface RichDocumentRelatedArticles {
    }

    /* compiled from: upload_photo_menu_impression */
    public interface RichDocumentListItems {
    }

    /* compiled from: upload_photo_menu_impression */
    public interface RichDocumentMaster extends FBMessengerSubscriptionInfo {
        @Nullable
        GraphQLFeedback mo361b();

        @Nullable
        String mo362c();

        @Nullable
        MessengerContentSubscriptionOptionModel mo363d();

        @Nullable
        RichDocumentEdge mo364g();

        @Nullable
        RelatedArticleObjectsModel ij_();
    }
}
