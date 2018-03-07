package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdAccountAudiencesModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: Video segment transcoding upload failed.  */
public final class FetchSavedAudiencesQuery {

    /* compiled from: Video segment transcoding upload failed.  */
    public class FetchSavedAudiencesQueryString extends TypedGraphQlQueryString<AdAccountAudiencesModel> {
        public FetchSavedAudiencesQueryString() {
            super(AdAccountAudiencesModel.class, false, "FetchSavedAudiencesQuery", "b3d016417700d34ff25d68199eb30138", "node", "10154373001276729", RegularImmutableSet.a);
        }

        public final String m24238a(String str) {
            switch (str.hashCode()) {
                case -803333011:
                    return "0";
                case -554685518:
                    return "1";
                case -247173063:
                    return "2";
                case 182666285:
                    return "3";
                default:
                    return str;
            }
        }
    }
}
