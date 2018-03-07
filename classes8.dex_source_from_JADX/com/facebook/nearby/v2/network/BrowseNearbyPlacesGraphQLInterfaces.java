package com.facebook.nearby.v2.network;

import com.facebook.graphql.enums.GraphQLPageCategoryType;
import com.facebook.graphql.enums.GraphQLPageOpenHoursDisplayDecisionEnum;
import com.facebook.graphql.enums.GraphQLPageSuperCategoryType;
import com.facebook.graphql.enums.GraphQLPermanentlyClosedStatus;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.BrowseNearbyPlacesFullImageFragmentModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPagePlaceInfoFragmentModel.AddressModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPagePlaceInfoFragmentModel.LocationModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPagePlaceInfoFragmentModel.OverallStarRatingModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPagePlaceInfoFragmentModel.PageLikersModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPagePlaceInfoFragmentModel.PageVisitsModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPagePlaceInfoFragmentModel.PlaceOpenStatusModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPagePlaceInfoFragmentModel.RatersModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPlacesFriendsWhoVisitedFragmentModel.FriendsWhoVisitedModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPlacesPageProfilePhotoModel.ProfilePhotoModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyRecommendationsConnectionFragmentModel;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: dfps */
public class BrowseNearbyPlacesGraphQLInterfaces {

    /* compiled from: dfps */
    public interface FullAlbumFragment {
    }

    /* compiled from: dfps */
    public interface PageTWEFragment {
    }

    public interface PageBaseFragment extends PageTWEFragment {
    }

    public interface PageBaseWithSmallProfilePicturesFragment extends PageBaseFragment {
    }

    /* compiled from: dfps */
    public interface NearbyPagePlaceInfoFragment extends PageBaseWithSmallProfilePicturesFragment {
    }

    /* compiled from: dfps */
    public interface NearbyPlacesFriendsWhoVisitedFragment {
    }

    /* compiled from: dfps */
    public interface NearbyPlacesPageProfilePhoto {
    }

    /* compiled from: dfps */
    public interface NearbyPlacesHugeResultCellPageInformationFragment extends NearbyPagePlaceInfoFragment, NearbyPlacesFriendsWhoVisitedFragment, NearbyPlacesPageProfilePhoto {
        boolean mo919A();

        @Nullable
        RatersModel mo920B();

        @Nullable
        NearbyRecommendationsConnectionFragmentModel mo921C();

        @Nonnull
        ImmutableList<? extends RedirectionInfo> mo922D();

        @Nonnull
        ImmutableList<? extends Photo320Fragment> mo923E();

        @Nonnull
        ImmutableList<String> mo924F();

        boolean mo925G();

        @Nonnull
        ImmutableList<String> mo926H();

        @Nullable
        GraphQLPageSuperCategoryType mo927I();

        @Nonnull
        ImmutableList<String> mo928J();

        @Nullable
        GraphQLSavedState mo929K();

        @Nullable
        AddressModel mo930b();

        boolean mo931c();

        boolean mo932d();

        @Nullable
        GraphQLPageCategoryType mo933g();

        @Nullable
        FriendsWhoVisitedModel mo934j();

        @Nonnull
        ImmutableList<String> jY_();

        boolean jZ_();

        @Nonnull
        ImmutableList<? extends Hours> mo937k();

        boolean ka_();

        @Nullable
        String mo939l();

        boolean mo940m();

        @Nullable
        LocationModel mo941n();

        @Nullable
        String mo942o();

        @Nullable
        OverallStarRatingModel mo943p();

        @Nullable
        PageLikersModel mo944q();

        @Nullable
        PageVisitsModel mo945r();

        @Nullable
        GraphQLPermanentlyClosedStatus mo946s();

        @Nullable
        PlaceOpenStatusModel mo947t();

        @Nullable
        GraphQLPageOpenHoursDisplayDecisionEnum mo948u();

        @Nullable
        GraphQLPlaceType mo949v();

        @Nullable
        String mo950w();

        @Nullable
        BrowseNearbyPlacesFullImageFragmentModel mo951x();

        @Nullable
        BrowseNearbyPlacesFullImageFragmentModel mo952y();

        @Nullable
        ProfilePhotoModel mo953z();
    }

    /* compiled from: dfps */
    public interface NearbyPlacesNewBrowsePaginationInfo {
    }

    /* compiled from: dfps */
    public interface PhotoWithoutSizedImagesFragment {
    }
}
