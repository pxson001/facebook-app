package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.protocol.EditTargetingMutationModels.FBPagePostBoostEditTargetingModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: WebrtcUiHandler */
public final class EditTargetingMutation {

    /* compiled from: WebrtcUiHandler */
    public class FBPagePostBoostEditTargetingString extends TypedGraphQLMutationString<FBPagePostBoostEditTargetingModel> {
        public FBPagePostBoostEditTargetingString() {
            super(FBPagePostBoostEditTargetingModel.class, false, "FBPagePostBoostEditTargeting", "7d18cee09bb172790e384ff3db4f5097", "boost_info_edit_targeting", "0", "10154204801941729", RegularImmutableSet.a);
        }

        public final String m24073a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
