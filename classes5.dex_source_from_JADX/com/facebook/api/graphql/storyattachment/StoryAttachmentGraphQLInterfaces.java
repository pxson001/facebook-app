package com.facebook.api.graphql.storyattachment;

import com.facebook.api.graphql.place.NewsFeedExplicitPlaceFieldsGraphQLInterfaces.NewsFeedDefaultsPlaceFieldsWithoutMedia;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.EventAttachmentModel.EventCoverPhotoModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.NewsFeedDefaultsEventPlaceFieldsModel;
import com.facebook.graphql.enums.GraphQLConnectionStyle;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import javax.annotation.Nullable;

/* compiled from: app_store_identifier */
public class StoryAttachmentGraphQLInterfaces {

    /* compiled from: app_store_identifier */
    public interface EventAttachment {
        boolean mo1097b();

        @Nullable
        String bt_();

        boolean bu_();

        @Nullable
        EventCoverPhotoModel bv_();

        @Nullable
        GraphQLConnectionStyle mo1101c();

        long mo1102d();

        @Nullable
        NewsFeedDefaultsEventPlaceFieldsModel mo1103g();

        @Nullable
        String mo1104j();

        long mo1105k();

        @Nullable
        String mo1106l();

        @Nullable
        String mo1107m();

        @Nullable
        GraphQLEventGuestStatus mo1108n();

        boolean mo1109o();

        @Nullable
        GraphQLEventWatchStatus mo1110p();
    }

    public interface TravelAttachmentFields extends NewsFeedDefaultsPlaceFieldsWithoutMedia {
    }
}
