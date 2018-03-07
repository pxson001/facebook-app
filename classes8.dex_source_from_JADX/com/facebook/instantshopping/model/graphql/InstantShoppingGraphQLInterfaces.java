package com.facebook.instantshopping.model.graphql;

import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.FBFullImageFragmentModel;
import com.facebook.graphql.enums.GraphQLInstantShoppingDocumentElementType;
import com.facebook.graphql.enums.GraphQLInstantShoppingPresentationStyle;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingActionFragmentModel;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingElementDescriptorFragmentModel;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingPhotoElementFragmentModel.ElementPhotoModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentText;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: upload_photo_menu */
public class InstantShoppingGraphQLInterfaces {

    /* compiled from: upload_photo_menu */
    public interface InstantShoppingButtonElementFragment {
        @Nullable
        InstantShoppingActionFragmentModel mo28a();

        @Nullable
        String mo29b();

        @Nullable
        GraphQLInstantShoppingDocumentElementType mo30c();

        @Nullable
        InstantShoppingElementDescriptorFragmentModel mo31d();

        int mo32g();

        @Nullable
        String iI_();

        @Nonnull
        ImmutableList<GraphQLInstantShoppingPresentationStyle> iJ_();

        @Nullable
        RichDocumentText iK_();
    }

    /* compiled from: upload_photo_menu */
    public interface InstantShoppingColorSelectorElementFragment {
        @Nullable
        GraphQLInstantShoppingDocumentElementType mo30c();

        @Nullable
        InstantShoppingElementDescriptorFragmentModel mo31d();

        @Nullable
        String iI_();

        @Nonnull
        ImmutableList<? extends InstantShoppingColorSelectorColorFragment> mo36j();

        int mo37k();
    }

    /* compiled from: upload_photo_menu */
    public interface InstantShoppingDocumentExpandableSectionElementFragment {
        @Nullable
        GraphQLInstantShoppingDocumentElementType mo30c();

        @Nullable
        String iI_();

        @Nullable
        InstantShoppingTextElementFragment mo41o();

        @Nullable
        InstantShoppingTextElementFragment mo42p();
    }

    /* compiled from: upload_photo_menu */
    public interface InstantShoppingPhotoElementFragment {
        @Nullable
        InstantShoppingActionFragmentModel mo28a();

        @Nullable
        GraphQLInstantShoppingDocumentElementType mo30c();

        @Nullable
        InstantShoppingElementDescriptorFragmentModel mo31d();

        @Nullable
        String iI_();

        @Nonnull
        ImmutableList<GraphQLInstantShoppingPresentationStyle> iJ_();

        @Nonnull
        ImmutableList<? extends InstantShoppingTextElementFragment> mo38l();

        @Nullable
        ElementPhotoModel mo39m();

        @Nullable
        FBFullImageFragmentModel mo40n();
    }

    /* compiled from: upload_photo_menu */
    public interface InstantShoppingTextElementFragment {
        @Nullable
        GraphQLInstantShoppingDocumentElementType mo30c();

        @Nullable
        InstantShoppingElementDescriptorFragmentModel mo31d();

        @Nullable
        String iI_();

        @Nullable
        RichDocumentText iK_();
    }

    /* compiled from: upload_photo_menu */
    public interface InstantShoppingCompositeBlockElementFragment {
        @Nullable
        GraphQLInstantShoppingDocumentElementType mo43c();

        @Nullable
        InstantShoppingElementDescriptorFragmentModel mo44d();

        int mo45g();

        @Nonnull
        ImmutableList<? extends BlockElements> iF_();

        @Nullable
        String iI_();
    }

    /* compiled from: upload_photo_menu */
    public interface InstantShoppingToggleElementFragment {
        @Nullable
        GraphQLInstantShoppingDocumentElementType mo30c();

        @Nullable
        InstantShoppingElementDescriptorFragmentModel mo31d();

        @Nullable
        String iI_();

        @Nullable
        InstantShoppingActionFragmentModel mo48q();

        boolean mo49r();

        @Nullable
        RichDocumentText mo50s();

        @Nullable
        RichDocumentText mo51t();

        @Nullable
        InstantShoppingActionFragmentModel mo52u();
    }

    /* compiled from: upload_photo_menu */
    public interface InstantShoppingFooterElementFragment {
    }

    /* compiled from: upload_photo_menu */
    public interface InstantShoppingHeaderElementFragment {
    }
}
