package com.facebook.appinvites.protocol;

import com.facebook.appinvites.protocol.FetchAppInvitesListQueryModels.AppInvitesListQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: duplicate onclick for share composer */
public final class FetchAppInvitesListQuery {

    /* compiled from: duplicate onclick for share composer */
    public class AppInvitesListQueryString extends TypedGraphQlQueryString<AppInvitesListQueryModel> {
        public AppInvitesListQueryString() {
            super(AppInvitesListQueryModel.class, false, "AppInvitesListQuery", "54cd6b240eada3ff97b37e3beab40adb", "viewer", "10154559374081729", RegularImmutableSet.a);
        }

        public final String m14967a(String str) {
            switch (str.hashCode()) {
                case -1335157162:
                    return "1";
                case -487188583:
                    return "2";
                case 3779888:
                    return "3";
                case 1303287530:
                    return "0";
                case 1792554757:
                    return "4";
                default:
                    return str;
            }
        }
    }
}
