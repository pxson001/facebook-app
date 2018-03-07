package com.facebook.reaction.event;

import com.facebook.content.event.FbEventSubscriber;
import com.facebook.graphql.enums.GraphQLPagePresenceTabType;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.reaction.common.ReactionAttachmentIntent;

/* compiled from: billing_zip_edit_text */
public class ReactionUiEvents {

    /* compiled from: billing_zip_edit_text */
    public class ReactionEventsSeeAllPostsEvent implements ReactionEvent {
        public final String f18900a;
        private final String f18901b;

        public ReactionEventsSeeAllPostsEvent(String str, String str2) {
            this.f18900a = str;
            this.f18901b = str2;
        }

        public final String mo1120a() {
            return this.f18901b;
        }
    }

    /* compiled from: billing_zip_edit_text */
    public abstract class ReactionEventsSeeAllPostsEventSubscriber extends FbEventSubscriber<ReactionEventsSeeAllPostsEvent> {
        public final Class<ReactionEventsSeeAllPostsEvent> m22928a() {
            return ReactionEventsSeeAllPostsEvent.class;
        }
    }

    /* compiled from: billing_zip_edit_text */
    public class ReactionFavoriteButtonEvent implements ReactionEvent {
        private final String f18902a;
        private final boolean f18903b;
        private final String f18904c;

        public ReactionFavoriteButtonEvent(String str, boolean z, String str2) {
            this.f18902a = str;
            this.f18903b = z;
            this.f18904c = str2;
        }

        public final String mo1120a() {
            return this.f18904c;
        }
    }

    /* compiled from: billing_zip_edit_text */
    public class ReactionFollowActionSyncEvent implements ReactionEvent {
        private final String f18905a;
        public final GraphQLSubscribeStatus f18906b;

        public ReactionFollowActionSyncEvent(GraphQLSubscribeStatus graphQLSubscribeStatus, String str) {
            this.f18906b = graphQLSubscribeStatus;
            this.f18905a = str;
        }

        public final String mo1120a() {
            return this.f18905a;
        }
    }

    /* compiled from: billing_zip_edit_text */
    public abstract class ReactionFollowActionSyncEventSubscriber extends FbEventSubscriber<ReactionFollowActionSyncEvent> {
        public final Class<ReactionFollowActionSyncEvent> m22931a() {
            return ReactionFollowActionSyncEvent.class;
        }
    }

    /* compiled from: billing_zip_edit_text */
    public class ReactionPageAddTabEvent implements ReactionEvent {
        private final String f18907a;
        public final String f18908b;
        public final GraphQLPagePresenceTabType f18909c;
        public final ReactionAttachmentIntent f18910d;

        public ReactionPageAddTabEvent(String str, String str2, GraphQLPagePresenceTabType graphQLPagePresenceTabType, ReactionAttachmentIntent reactionAttachmentIntent) {
            this.f18907a = str;
            this.f18908b = str2;
            this.f18909c = graphQLPagePresenceTabType;
            this.f18910d = reactionAttachmentIntent;
        }

        public final String mo1120a() {
            return this.f18907a;
        }
    }

    /* compiled from: billing_zip_edit_text */
    public abstract class ReactionPageAddTabEventSubscriber extends FbEventSubscriber<ReactionPageAddTabEvent> {
        public final Class<ReactionPageAddTabEvent> m22933a() {
            return ReactionPageAddTabEvent.class;
        }
    }

    /* compiled from: billing_zip_edit_text */
    public class ReactionPageCreatePhotoAlbumEvent implements ReactionEvent {
        private final String f18911a;
        public final String f18912b;

        public ReactionPageCreatePhotoAlbumEvent(String str, String str2) {
            this.f18911a = str;
            this.f18912b = str2;
        }

        public final String mo1120a() {
            return this.f18911a;
        }
    }

    /* compiled from: billing_zip_edit_text */
    public abstract class ReactionPageCreatePhotoAlbumEventSubscriber extends FbEventSubscriber<ReactionPageCreatePhotoAlbumEvent> {
        public final Class<ReactionPageCreatePhotoAlbumEvent> m22935a() {
            return ReactionPageCreatePhotoAlbumEvent.class;
        }
    }

    /* compiled from: billing_zip_edit_text */
    public class ReactionPagePublishEvent implements ReactionEvent {
        private final String f18913a;
        private final String f18914b;
        private final String f18915c;
        private final String f18916d;

        public ReactionPagePublishEvent(String str, String str2, String str3, String str4) {
            this.f18913a = str;
            this.f18914b = str2;
            this.f18915c = str3;
            this.f18916d = str4;
        }

        public final String mo1120a() {
            return this.f18913a;
        }
    }

    /* compiled from: billing_zip_edit_text */
    public class ReactionPageSeeAllEvent implements ReactionEvent {
        private final String f18917a;
        public final String f18918b;
        public final String f18919c;
        public final ReactionAttachmentIntent f18920d;

        public ReactionPageSeeAllEvent(String str, String str2, String str3, ReactionAttachmentIntent reactionAttachmentIntent) {
            this.f18917a = str;
            this.f18918b = str2;
            this.f18919c = str3;
            this.f18920d = reactionAttachmentIntent;
        }

        public final String mo1120a() {
            return this.f18917a;
        }
    }

    /* compiled from: billing_zip_edit_text */
    public abstract class ReactionPageSeeAllEventSubscriber extends FbEventSubscriber<ReactionPageSeeAllEvent> {
        public final Class<ReactionPageSeeAllEvent> m22938a() {
            return ReactionPageSeeAllEvent.class;
        }
    }

    /* compiled from: billing_zip_edit_text */
    public class ReactionPageViewPhotosOfPageAlbumEvent implements ReactionEvent {
        private final String f18921a;
        public final String f18922b;
        public final String f18923c;

        public ReactionPageViewPhotosOfPageAlbumEvent(String str, String str2, String str3) {
            this.f18921a = str;
            this.f18922b = str2;
            this.f18923c = str3;
        }

        public final String mo1120a() {
            return this.f18921a;
        }
    }

    /* compiled from: billing_zip_edit_text */
    public abstract class ReactionPageViewPhotosOfPageAlbumEventSubscriber extends FbEventSubscriber<ReactionPageViewPhotosOfPageAlbumEvent> {
        public final Class<ReactionPageViewPhotosOfPageAlbumEvent> m22940a() {
            return ReactionPageViewPhotosOfPageAlbumEvent.class;
        }
    }

    /* compiled from: billing_zip_edit_text */
    public class ReactionPromotePageEvent implements ReactionEvent {
        private final String f18924a;
        private final String f18925b;

        public ReactionPromotePageEvent(String str, String str2) {
            this.f18924a = str;
            this.f18925b = str2;
        }

        public final String mo1120a() {
            return this.f18924a;
        }
    }

    /* compiled from: billing_zip_edit_text */
    public class ReactionPymlSeeMoreEvent implements ReactionEvent {
        private final String f18926a;

        public ReactionPymlSeeMoreEvent(String str) {
            this.f18926a = str;
        }

        public final String mo1120a() {
            return this.f18926a;
        }
    }

    /* compiled from: billing_zip_edit_text */
    public abstract class ReactionPymlSeeMoreEventSubscriber extends FbEventSubscriber<ReactionPymlSeeMoreEvent> {
        public final Class<ReactionPymlSeeMoreEvent> m22943a() {
            return ReactionPymlSeeMoreEvent.class;
        }
    }

    /* compiled from: billing_zip_edit_text */
    public class ReactionSeePageAllMessagesEvent implements ReactionEvent {
        private final String f18927a;

        public ReactionSeePageAllMessagesEvent(String str) {
            this.f18927a = str;
        }

        public final String mo1120a() {
            return this.f18927a;
        }
    }

    /* compiled from: billing_zip_edit_text */
    public class ReactionSeePageInsightsEvent implements ReactionEvent {
        private final String f18928a;

        public ReactionSeePageInsightsEvent(String str) {
            this.f18928a = str;
        }

        public final String mo1120a() {
            return this.f18928a;
        }
    }

    /* compiled from: billing_zip_edit_text */
    public class ReactionSeePageProfileEvent implements ReactionEvent {
        private final String f18929a;

        public ReactionSeePageProfileEvent(String str) {
            this.f18929a = str;
        }

        public final String mo1120a() {
            return this.f18929a;
        }
    }

    /* compiled from: billing_zip_edit_text */
    public class ReactionSendMessageAsPageEvent implements ReactionEvent {
        private final String f18930a;
        private final String f18931b;

        public ReactionSendMessageAsPageEvent(String str, String str2) {
            this.f18930a = str;
            this.f18931b = str2;
        }

        public final String mo1120a() {
            return this.f18931b;
        }
    }

    /* compiled from: billing_zip_edit_text */
    public class ReactionUpdateLikeButtonEvent implements ReactionEvent {
        private final String f18932a;
        public final boolean f18933b;

        public ReactionUpdateLikeButtonEvent(boolean z, String str) {
            this.f18932a = str;
            this.f18933b = z;
        }

        public final String mo1120a() {
            return this.f18932a;
        }
    }

    /* compiled from: billing_zip_edit_text */
    public abstract class ReactionUpdateLikeButtonEventSubscriber extends FbEventSubscriber<ReactionUpdateLikeButtonEvent> {
        public final Class<ReactionUpdateLikeButtonEvent> m22949a() {
            return ReactionUpdateLikeButtonEvent.class;
        }
    }

    /* compiled from: billing_zip_edit_text */
    public class ReactionViewPageSettingsEvent implements ReactionEvent {
        private final String f18934a;

        public ReactionViewPageSettingsEvent(String str) {
            this.f18934a = str;
        }

        public final String mo1120a() {
            return this.f18934a;
        }
    }
}
