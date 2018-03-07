package com.facebook.feedplugins.pymk.rows.components;

import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.PeopleYouMayKnowFeedUnitItem;
import com.facebook.graphql.model.conversion.FeedUnitItemProfileHelper;
import javax.annotation.Nullable;

/* compiled from: THREAD_KEY_STRING */
public class PeopleYouMayKnowFeedUnitItems {
    @Nullable
    public static String m26669a(PeopleYouMayKnowFeedUnitItem peopleYouMayKnowFeedUnitItem) {
        GraphQLProfile a = FeedUnitItemProfileHelper.a(peopleYouMayKnowFeedUnitItem);
        if (a == null) {
            return null;
        }
        GraphQLImage ai = a.ai();
        if (ai != null) {
            return ai.b();
        }
        return null;
    }

    @Nullable
    public static String m26670c(PeopleYouMayKnowFeedUnitItem peopleYouMayKnowFeedUnitItem) {
        GraphQLProfile a = FeedUnitItemProfileHelper.a(peopleYouMayKnowFeedUnitItem);
        if (a == null) {
            return null;
        }
        return a.U();
    }
}
