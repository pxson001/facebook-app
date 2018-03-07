package com.facebook.tablet.sideshow.ads.util;

import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLNegativeFeedbackAction;
import com.facebook.graphql.model.GraphQLNegativeFeedbackActionsEdge;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.tablet.sideshow.ads.model.AppAdsSideshowSecondaryAction;
import com.facebook.tablet.sideshow.ads.model.AppAdsSideshowSecondaryAction.SecondaryActionType;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

/* compiled from: onRequestClose */
public class AppAdsSideshowStoryAccessor {
    public static String m5867g(GraphQLStory graphQLStory) {
        if (!(graphQLStory == null || StoryAttachmentHelper.o(graphQLStory) == null)) {
            GraphQLStoryActionLink a = ActionLinkHelper.a(StoryAttachmentHelper.o(graphQLStory));
            if (a != null) {
                return a.aE();
            }
        }
        return null;
    }

    public static ImmutableMap<SecondaryActionType, AppAdsSideshowSecondaryAction> m5868i(GraphQLStory graphQLStory) {
        Builder builder = ImmutableMap.builder();
        if (!(graphQLStory == null || graphQLStory.C() == null || graphQLStory.C().a() == null)) {
            ImmutableList a = graphQLStory.C().a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                GraphQLNegativeFeedbackAction a2 = ((GraphQLNegativeFeedbackActionsEdge) a.get(i)).a();
                if (a2 != null) {
                    String a3;
                    String a4;
                    if (a2.s() != null) {
                        a3 = a2.s().a();
                    } else {
                        a3 = null;
                    }
                    if (a2.p() != null) {
                        a4 = a2.p().a();
                    } else {
                        a4 = null;
                    }
                    if (a2.b() == GraphQLNegativeFeedbackActionType.HIDE) {
                        builder.b(SecondaryActionType.HIDE, new AppAdsSideshowSecondaryAction(SecondaryActionType.HIDE, a3, a4));
                    }
                }
            }
        }
        return builder.b();
    }
}
