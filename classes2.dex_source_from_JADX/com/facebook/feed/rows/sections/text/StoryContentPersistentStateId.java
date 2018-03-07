package com.facebook.feed.rows.sections.text;

import com.facebook.common.util.StringUtil;
import com.facebook.graphql.model.GraphQLGraphSearchResultDecoration;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.PropertyHelper;

/* compiled from: friending_update_people_you_may_know_history */
public final class StoryContentPersistentStateId {
    public static String m31224a(GraphQLStory graphQLStory, boolean z) {
        String g;
        String str = ":";
        Object[] objArr = new Object[5];
        objArr[0] = "story:body:content";
        if (graphQLStory.mo2507g() != null) {
            g = graphQLStory.mo2507g();
        } else {
            g = String.valueOf(graphQLStory.m22336V());
        }
        objArr[1] = g;
        objArr[2] = Boolean.valueOf(z);
        GraphQLGraphSearchResultDecoration i = PropertyHelper.m21307i(graphQLStory);
        objArr[3] = (i != null ? i.m() : null) == null ? "" : StringUtil.m3597b(",", i != null ? i.m() : null);
        objArr[4] = Long.valueOf(graphQLStory.T_());
        return StringUtil.m3597b(str, objArr);
    }
}
