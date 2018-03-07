package com.facebook.api.graphql.reactions;

import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsMutationFragmentModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: android_place_picker_report_dialog */
public final class ReactionsGraphQL {

    /* compiled from: android_place_picker_report_dialog */
    public class ViewerReactionsMutationString extends TypedGraphQLMutationString<ViewerReactionsMutationFragmentModel> {
        public ViewerReactionsMutationString() {
            super(ViewerReactionsMutationFragmentModel.class, false, "ViewerReactionsMutation", "e4d338791e93269e82fbd5b665244019", "feedback_react", "0", "10154633955606729", RegularImmutableSet.a);
        }

        public final String m16993a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
