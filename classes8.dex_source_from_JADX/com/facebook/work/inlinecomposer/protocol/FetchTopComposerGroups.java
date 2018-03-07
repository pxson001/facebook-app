package com.facebook.work.inlinecomposer.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.work.inlinecomposer.protocol.FetchTopComposerGroupsModels.FetchTopComposerGroupsModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: location_opt_in_error_try_again_tapped */
public final class FetchTopComposerGroups {

    /* compiled from: location_opt_in_error_try_again_tapped */
    public class FetchTopComposerGroupsString extends TypedGraphQlQueryString<FetchTopComposerGroupsModel> {
        public FetchTopComposerGroupsString() {
            super(FetchTopComposerGroupsModel.class, false, "FetchTopComposerGroups", "256286b482ad08fdf24bbe3dd3fe1cfd", "viewer", "10154443191556729", RegularImmutableSet.a);
        }

        public final String m11638a(String str) {
            switch (str.hashCode()) {
                case -1398151987:
                    return "1";
                case 102976443:
                    return "0";
                case 109250890:
                    return "2";
                default:
                    return str;
            }
        }
    }
}
