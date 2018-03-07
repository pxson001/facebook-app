package com.facebook.graphql.model;

import com.facebook.common.util.StringUtil;

/* compiled from: TV_CHANNEL */
public class StoryInstagramHelper {
    private StoryInstagramHelper() {
    }

    public static boolean m22581a(GraphQLStory graphQLStory) {
        if (GraphQLHelper.a(graphQLStory.av()) == -1703624614 && graphQLStory.J() != null) {
            if (!StringUtil.a(new CharSequence[]{graphQLStory.J().y()}) && graphQLStory.J().y().equals("Instagram")) {
                return true;
            }
        }
        return false;
    }

    public static boolean m22582b(GraphQLStory graphQLStory) {
        return (GraphQLHelper.a(graphQLStory.av()) != -1703624614 || graphQLStory.aH() == null || graphQLStory.aH().b() == null || graphQLStory.aH().b().size() <= 1 || graphQLStory.aH().b().get(1) == null || ((GraphQLEntityAtRange) graphQLStory.aH().b().get(1)).j() == null || ((GraphQLEntityAtRange) graphQLStory.aH().b().get(1)).j().C_() == null || !((GraphQLEntityAtRange) graphQLStory.aH().b().get(1)).j().C_().equals("Instagram")) ? false : true;
    }
}
