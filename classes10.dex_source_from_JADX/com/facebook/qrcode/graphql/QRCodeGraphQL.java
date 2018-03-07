package com.facebook.qrcode.graphql;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.qrcode.graphql.QRCodeGraphQLModels.CreateQRCodeMutationModel;
import com.facebook.qrcode.graphql.QRCodeGraphQLModels.FetchQRCodesQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: limitEventUsage */
public final class QRCodeGraphQL {

    /* compiled from: limitEventUsage */
    public class CreateQRCodeMutationString extends TypedGraphQLMutationString<CreateQRCodeMutationModel> {
        public CreateQRCodeMutationString() {
            super(CreateQRCodeMutationModel.class, false, "CreateQRCodeMutation", "bc94a5e3b816a8171257ece5c7f09107", "qrcode_create", "0", "10154204805111729", RegularImmutableSet.a);
        }

        public final String m8600a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: limitEventUsage */
    public class FetchQRCodesQueryString extends TypedGraphQlQueryString<FetchQRCodesQueryModel> {
        public FetchQRCodesQueryString() {
            super(FetchQRCodesQueryModel.class, false, "FetchQRCodesQuery", "27f2266f1ff673169c2fdb8a519d7ebd", "viewer", "10152984121321729", RegularImmutableSet.a);
        }
    }
}
