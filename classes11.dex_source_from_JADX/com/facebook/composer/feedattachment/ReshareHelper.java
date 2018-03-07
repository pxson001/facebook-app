package com.facebook.composer.feedattachment;

import com.facebook.common.util.StringUtil;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.PropertyHelper;

/* compiled from: google_play_referrer_login_attempt */
public class ReshareHelper {
    private ReshareHelper() {
    }

    public static boolean m7924a(GraphQLStoryAttachment graphQLStoryAttachment) {
        return (StringUtil.a(PropertyHelper.b(graphQLStoryAttachment)) || StringUtil.a(PropertyHelper.c(graphQLStoryAttachment))) ? false : true;
    }
}
