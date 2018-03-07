package com.facebook.video.settings.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.video.settings.graphql.AutoplaySettingsGraphQLModels.ViewerQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate */
public final class AutoplaySettingsGraphQL {

    /* compiled from: com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate */
    public class ViewerQueryString extends TypedGraphQlQueryString<ViewerQueryModel> {
        public ViewerQueryString() {
            super(ViewerQueryModel.class, false, "ViewerQuery", "d3f70c95a1a677a551e21d11c31dd721", "viewer", "10153658626726729", RegularImmutableSet.a);
        }

        public final String m28330a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
