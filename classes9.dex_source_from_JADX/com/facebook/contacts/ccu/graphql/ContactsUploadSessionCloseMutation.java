package com.facebook.contacts.ccu.graphql;

import com.facebook.contacts.ccu.graphql.ContactsUploadSessionCloseMutationModels.ContactUploadSessionCloseMutationFieldsModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: product_type */
public final class ContactsUploadSessionCloseMutation {

    /* compiled from: product_type */
    public class ContactUploadSessionCloseMutationString extends TypedGraphQLMutationString<ContactUploadSessionCloseMutationFieldsModel> {
        public ContactUploadSessionCloseMutationString() {
            super(ContactUploadSessionCloseMutationFieldsModel.class, false, "ContactUploadSessionCloseMutation", "05fb2103d527b78ee175b7a807dda2a4", "contact_upload_session_close", "0", "10154514378211729", RegularImmutableSet.a);
        }

        public final String m6583a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
