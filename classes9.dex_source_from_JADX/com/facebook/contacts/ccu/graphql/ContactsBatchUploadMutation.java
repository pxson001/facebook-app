package com.facebook.contacts.ccu.graphql;

import com.facebook.contacts.ccu.graphql.ContactsBatchUploadMutationModels.ContactBatchUploadMutationFieldsModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: profile/ */
public final class ContactsBatchUploadMutation {

    /* compiled from: profile/ */
    public class ContactBatchUploadMutationString extends TypedGraphQLMutationString<ContactBatchUploadMutationFieldsModel> {
        public ContactBatchUploadMutationString() {
            super(ContactBatchUploadMutationFieldsModel.class, false, "ContactBatchUploadMutation", "5545d59256045622b0b4ec72a73f359a", "contact_batch_upload", "0", "10154514475256729", RegularImmutableSet.a);
        }

        public final String m6536a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
