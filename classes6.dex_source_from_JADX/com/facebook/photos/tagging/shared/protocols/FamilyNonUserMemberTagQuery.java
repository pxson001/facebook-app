package com.facebook.photos.tagging.shared.protocols;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.photos.tagging.shared.protocols.FamilyNonUserMemberTagQueryModels.FamilyNonUserMemberTagQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: gt */
public final class FamilyNonUserMemberTagQuery {

    /* compiled from: gt */
    public class FamilyNonUserMemberTagQueryString extends TypedGraphQlQueryString<FamilyNonUserMemberTagQueryModel> {
        public FamilyNonUserMemberTagQueryString() {
            super(FamilyNonUserMemberTagQueryModel.class, false, "FamilyNonUserMemberTagQuery", "d90127d13a9a7693f17e4a637f89c0d5", "user", "10154405445726729", RegularImmutableSet.a);
        }

        public final String m21085a(String str) {
            switch (str.hashCode()) {
                case -2013888757:
                    return "2";
                case -1101600581:
                    return "1";
                case -441951604:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
