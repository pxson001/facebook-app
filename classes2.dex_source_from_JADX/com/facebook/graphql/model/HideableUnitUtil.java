package com.facebook.graphql.model;

import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.visitor.ConsistencyTuple;

/* compiled from: itself */
public class HideableUnitUtil {
    private static final StoryVisibility f18726a = StoryVisibility.VISIBLE;

    public static StoryVisibility m26319a(HideableUnit hideableUnit) {
        ConsistencyTuple consistencyTuple = new ConsistencyTuple();
        hideableUnit.mo2835a("local_story_visibility", consistencyTuple);
        if (consistencyTuple.f18727a == null) {
            return f18726a;
        }
        try {
            return StoryVisibility.valueOf((String) consistencyTuple.f18727a);
        } catch (IllegalArgumentException e) {
            return f18726a;
        }
    }

    public static int m26321b(HideableUnit hideableUnit) {
        ConsistencyTuple consistencyTuple = new ConsistencyTuple();
        hideableUnit.mo2835a("local_story_visible_height", consistencyTuple);
        if (consistencyTuple.f18727a == null) {
            return 0;
        }
        return ((Integer) consistencyTuple.f18727a).intValue();
    }

    public static String m26320a(HasHideableToken hasHideableToken) {
        return hasHideableToken.mo2896y();
    }
}
