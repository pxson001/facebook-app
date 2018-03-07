package com.facebook.groups.docsandfiles.protocol;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: Unregister */
public final class FileUploadingMutations {

    /* compiled from: Unregister */
    public class CreateFileMutationString extends TypedGraphQLMutationString<CreateFileMutationModel> {
        public CreateFileMutationString() {
            super(CreateFileMutationModel.class, false, "CreateFileMutation", "b5b2861a931e6697eae26b889561765a", "story_create", "0", "10154329824006729", RegularImmutableSet.a);
        }

        public final String m22384a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
