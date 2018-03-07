package com.facebook.feedplugins.attachments.linkshare.follow;

import com.facebook.feedplugins.attachments.linkshare.follow.BaseFollowShareAttachmentPartDefinition.FollowShareButtonState;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.model.GraphQLProfile;

/* compiled from: fetchZeroHeaderRequest */
public class FollowShareAttachmentPersistentState {
    public FollowShareButtonState f24267a;
    public boolean f24268b;

    public final void m32606a(GraphQLProfile graphQLProfile) {
        if (graphQLProfile.m22967A()) {
            this.f24267a = FollowShareButtonState.LIKED_PAGE;
        } else if (graphQLProfile.ar() == GraphQLSubscribeStatus.IS_SUBSCRIBED) {
            this.f24267a = FollowShareButtonState.FOLLOWING_USER;
        } else if (graphQLProfile.ar() == GraphQLSubscribeStatus.CAN_SUBSCRIBE) {
            this.f24267a = FollowShareButtonState.FOLLOW_USER;
        } else if (graphQLProfile.m22967A()) {
            this.f24267a = FollowShareButtonState.CANNOT_SUBSCRIBE;
        } else {
            this.f24267a = FollowShareButtonState.LIKE_PAGE;
        }
    }

    public final void m32607a(boolean z) {
        this.f24268b = z;
    }
}
