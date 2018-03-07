package com.facebook.feed.rows.styling;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.facebook.feed.viewstate.UnseenBackgroundDrawable;
import com.facebook.graphql.enums.GraphQLStorySeenState;

/* compiled from: native_album/%s */
public class BackgroundResourceDefinition {
    private final int f13023a;
    private final int f13024b;
    private final int f13025c;
    private final int f13026d;

    public BackgroundResourceDefinition(int i, int i2, int i3, int i4) {
        this.f13023a = i;
        this.f13024b = i2;
        this.f13025c = i3;
        this.f13026d = i4;
    }

    public final Drawable m19155a(Resources resources, int i, GraphQLStorySeenState graphQLStorySeenState) {
        if (i > 0) {
            return m19154a(resources, this.f13024b, this.f13026d, graphQLStorySeenState);
        }
        return m19154a(resources, this.f13023a, this.f13025c, graphQLStorySeenState);
    }

    private static Drawable m19154a(Resources resources, int i, int i2, GraphQLStorySeenState graphQLStorySeenState) {
        if (graphQLStorySeenState != GraphQLStorySeenState.UNSEEN_AND_UNREAD || i2 == -1) {
            return resources.getDrawable(i);
        }
        return new UnseenBackgroundDrawable(new Drawable[]{resources.getDrawable(i), resources.getDrawable(i2)});
    }
}
