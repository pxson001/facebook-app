package com.facebook.growth.contactinviter.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.growth.contactinviter.graphql.ContactInviterModels.UploadContactsQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: TEMPLATE_ID */
public final class ContactInviter {

    /* compiled from: TEMPLATE_ID */
    public class UploadContactsQueryString extends TypedGraphQlQueryString<UploadContactsQueryModel> {
        public UploadContactsQueryString() {
            super(UploadContactsQueryModel.class, false, "UploadContactsQuery", "3c9cf4b1d70c0d39633ab15f65a1d4a5", "viewer", "10154445943381729", RegularImmutableSet.a);
        }

        public final String m24626a(String str) {
            switch (str.hashCode()) {
                case -1069773404:
                    return "2";
                case 3322014:
                    return "1";
                case 3575610:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
