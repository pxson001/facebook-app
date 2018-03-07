package com.facebook.photos.data.protocol;

import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultVect2Fields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLModels.ImageOverlayFieldsModel;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLInterfaces.SizeAwareMedia;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.LocationSuggestionModel.LocationTagSuggestionModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataAttributionAppModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataInlineActivitiesModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataOwnerModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataWithoutFeedbackModel.AlbumModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataWithoutFeedbackModel.ExplicitPlaceModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataWithoutFeedbackModel.PendingPlaceModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataWithoutFeedbackModel.WithTagsModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.PrivacyScopeModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.PageMediaWithAttributionModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.PageMediaWithAttributionModel.OwnerModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.PhotosFaceBoxesQueryModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.SimpleMediaFeedbackModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel;
import javax.annotation.Nullable;

/* compiled from: suggest_place_when_people_tagging */
public class PhotosMetadataGraphQLInterfaces {

    /* compiled from: suggest_place_when_people_tagging */
    public interface LocationSuggestion {
    }

    /* compiled from: suggest_place_when_people_tagging */
    public interface MediaPrivacyAndContainerStory {
    }

    /* compiled from: suggest_place_when_people_tagging */
    public interface MediaMetadata extends LocationSuggestion, MediaMetadataWithoutFeedback, MediaPrivacyAndContainerStory {
        @Nullable
        ExplicitPlaceModel mo233A();

        @Nullable
        PhotosFaceBoxesQueryModel mo234B();

        @Nullable
        SimpleMediaFeedbackModel mo235C();

        boolean mo236D();

        @Nullable
        String mo237E();

        @Nullable
        DefaultImageFields mo238F();

        @Nullable
        DefaultImageFields mo239G();

        @Nullable
        MediaMetadataInlineActivitiesModel mo240H();

        boolean mo241I();

        boolean mo242J();

        @Nullable
        DefaultImageFields mo243K();

        @Nullable
        LocationTagSuggestionModel mo244L();

        @Nullable
        DefaultTextWithEntitiesLongFields mo245M();

        @Nullable
        MediaMetadataOwnerModel mo246N();

        @Nullable
        PendingPlaceModel mo247O();

        int mo248P();

        @Nullable
        String mo249Q();

        @Nullable
        PrivacyScopeModel mo250R();

        @Nullable
        ImageOverlayFieldsModel mo251S();

        boolean mo252T();

        @Nullable
        TagInfoQueryModel mo253U();

        @Nullable
        WithTagsModel mo254V();

        @Nullable
        GraphQLObjectType mo255b();

        @Nullable
        DefaultImageFields bc_();

        @Nullable
        DefaultImageFields bd_();

        @Nullable
        DefaultImageFields be_();

        @Nullable
        DefaultVect2Fields mo259c();

        @Nullable
        String mo260d();

        @Nullable
        DefaultImageFields mo261g();

        @Nullable
        String mo262j();

        @Nullable
        AlbumModel mo263k();

        @Nullable
        MediaMetadataAttributionAppModel mo264l();

        @Nullable
        String mo265m();

        boolean mo266n();

        boolean mo267o();

        boolean mo268p();

        boolean mo269q();

        boolean mo270r();

        boolean mo271s();

        boolean mo272t();

        boolean mo273u();

        boolean mo274v();

        boolean mo275w();

        @Nullable
        MediaPrivacyContainerStoryModel mo276x();

        long mo277y();

        @Nullable
        MediaMetadataCreationStoryModel mo278z();
    }

    /* compiled from: suggest_place_when_people_tagging */
    public interface PageMediaWithAttribution extends SizeAwareMedia {
        @Nullable
        GraphQLObjectType mo279b();

        @Nullable
        DefaultImageFields bc_();

        @Nullable
        DefaultImageFields bd_();

        @Nullable
        DefaultImageFields be_();

        @Nullable
        DefaultVect2Fields mo283c();

        @Nullable
        String mo284d();

        @Nullable
        DefaultImageFields mo285g();

        long mo286j();

        @Nullable
        OwnerModel mo287k();

        @Nullable
        PageMediaWithAttributionModel.PrivacyScopeModel mo288l();
    }
}
