package com.facebook.graphql.model;

import com.facebook.common.util.StringUtil;
import com.google.common.base.Strings;
import java.util.List;

/* compiled from: gif */
public class StorySharingHelper {
    private StorySharingHelper() {
    }

    public static String m30304a(GraphQLStory graphQLStory) {
        return graphQLStory.av() != null ? Strings.nullToEmpty(graphQLStory.av().mo2906d()) : "";
    }

    public static boolean m30305b(GraphQLStory graphQLStory) {
        GraphQLEntity av = graphQLStory.av();
        if (av != null) {
            Object obj = (StringUtil.m3589a(av.mo2906d()) || av.mo2904b() == null) ? null : 1;
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    public static GraphQLStoryAttachment m30303a(GraphQLStory graphQLStory, List<GraphQLStoryAttachment> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        if (StoryInstagramHelper.a(graphQLStory) || StoryInstagramHelper.b(graphQLStory)) {
            return (GraphQLStoryAttachment) list.get(0);
        }
        for (GraphQLStoryAttachment graphQLStoryAttachment : list) {
            GraphQLMedia r = graphQLStoryAttachment.m23979r();
            GraphQLNode z = graphQLStoryAttachment.m23987z();
            if (r != null && graphQLStory.av().mo2906d().equals(r.m24452b())) {
                return graphQLStoryAttachment;
            }
            if (graphQLStoryAttachment.m23987z() != null && graphQLStory.av().mo2906d().equals(z.dp())) {
                return graphQLStoryAttachment;
            }
        }
        return null;
    }
}
