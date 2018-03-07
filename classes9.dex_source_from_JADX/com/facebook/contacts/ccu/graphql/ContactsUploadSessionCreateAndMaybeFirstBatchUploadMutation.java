package com.facebook.contacts.ccu.graphql;

import com.facebook.contacts.ccu.graphql.C0643xf635526d.ContactUploadSessionCreateAndMaybeBatchUploadMutationFieldsModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: product_item_id */
public final class ContactsUploadSessionCreateAndMaybeFirstBatchUploadMutation {

    /* compiled from: product_item_id */
    public class ContactUploadSessionCreateAndMaybeBatchUploadMutationString extends TypedGraphQLMutationString<ContactUploadSessionCreateAndMaybeBatchUploadMutationFieldsModel> {
        public ContactUploadSessionCreateAndMaybeBatchUploadMutationString() {
            super(ContactUploadSessionCreateAndMaybeBatchUploadMutationFieldsModel.class, false, "ContactUploadSessionCreateAndMaybeBatchUploadMutation", "7525f4cd2034317c62ba8e5417942782", "contact_upload_session_create_and_maybe_batch_upload", "0", "10154583289276729", RegularImmutableSet.a);
        }

        public final String m6592a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    public static final ContactUploadSessionCreateAndMaybeBatchUploadMutationString m6593a() {
        return new ContactUploadSessionCreateAndMaybeBatchUploadMutationString();
    }
}
