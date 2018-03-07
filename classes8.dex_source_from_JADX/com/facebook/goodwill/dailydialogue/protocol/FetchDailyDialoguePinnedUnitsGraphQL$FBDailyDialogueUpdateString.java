package com.facebook.goodwill.dailydialogue.protocol;

import com.facebook.goodwill.dailydialogue.protocol.FetchDailyDialoguePinnedUnitsGraphQLModels.FBDailyDialogueUpdateModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: fetchVideoAlbum */
public class FetchDailyDialoguePinnedUnitsGraphQL$FBDailyDialogueUpdateString extends TypedGraphQLMutationString<FBDailyDialogueUpdateModel> {
    public FetchDailyDialoguePinnedUnitsGraphQL$FBDailyDialogueUpdateString() {
        super(FBDailyDialogueUpdateModel.class, false, "FBDailyDialogueUpdate", "8535eb50ec023f86e95464013b664f34", "daily_dialogue_update", "0", "10154204803296729", RegularImmutableSet.a);
    }

    public final String m15062a(String str) {
        switch (str.hashCode()) {
            case 100358090:
                return "0";
            default:
                return str;
        }
    }
}
