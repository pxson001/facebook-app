package com.facebook.feed.ui.location;

import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.nux.interstitial.SaveNuxBubbleDelegate.NuxItemInfo;
import com.google.common.base.Preconditions;

/* compiled from: profile_picture_uri */
public class SaveNuxPlaceInfo implements NuxItemInfo {
    private GraphQLPlace f4102a;

    public SaveNuxPlaceInfo(GraphQLPlace graphQLPlace) {
        Preconditions.checkNotNull(graphQLPlace);
        this.f4102a = graphQLPlace;
    }

    public final boolean mo332a() {
        return this.f4102a.Z() == GraphQLSavedState.SAVED;
    }

    public final String mo333b() {
        return "native_newsfeed";
    }

    public final String mo334c() {
        return this.f4102a.x();
    }

    public final String mo335d() {
        return this.f4102a.S().b();
    }

    public final CurationSurface mo336e() {
        return CurationSurface.NATIVE_STORY;
    }

    public final CurationMechanism mo337f() {
        return CurationMechanism.SAVED_ADD;
    }
}
