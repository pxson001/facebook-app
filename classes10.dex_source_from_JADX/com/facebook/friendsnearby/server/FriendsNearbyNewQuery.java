package com.facebook.friendsnearby.server;

import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyContactsTabModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyHighlightQueryModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyInviteStatusQueryModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyLocationSharingQueryModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyMoreInSectionQueryModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbySearchQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;
import java.util.Map;

/* compiled from: [ -]*$ */
public final class FriendsNearbyNewQuery {

    /* compiled from: [ -]*$ */
    public class FriendsNearbyContactsTabQueryString extends TypedGraphQlQueryString<FriendsNearbyContactsTabModel> {
        public FriendsNearbyContactsTabQueryString() {
            super(FriendsNearbyContactsTabModel.class, false, "FriendsNearbyContactsTabQuery", "9953ef8fe8e8c11c9d422f0601e15c6e", "viewer", "10154479866056729", RegularImmutableSet.a);
        }

        public final String m21165a(String str) {
            switch (str.hashCode()) {
                case -1439978388:
                    return "2";
                case -1073853070:
                    return "8";
                case -749580906:
                    return "7";
                case -729108464:
                    return "4";
                case -512359801:
                    return "1";
                case -318427661:
                    return "5";
                case 137365935:
                    return "3";
                case 1182125491:
                    return "0";
                case 1307508398:
                    return "9";
                case 2144743097:
                    return "6";
                default:
                    return str;
            }
        }
    }

    /* compiled from: [ -]*$ */
    public class FriendsNearbyHighlightQueryString extends TypedGraphQlQueryString<Map<String, FriendsNearbyHighlightQueryModel>> {
        public FriendsNearbyHighlightQueryString() {
            super(FriendsNearbyHighlightQueryModel.class, true, "FriendsNearbyHighlightQuery", "23db98fdd175f413f927d76241925473", "nodes", "10154429038756729", RegularImmutableSet.a);
        }

        public final String m21166a(String str) {
            switch (str.hashCode()) {
                case -749580906:
                    return "1";
                case 104120:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: [ -]*$ */
    public class FriendsNearbyInviteStatusQueryString extends TypedGraphQlQueryString<FriendsNearbyInviteStatusQueryModel> {
        public FriendsNearbyInviteStatusQueryString() {
            super(FriendsNearbyInviteStatusQueryModel.class, false, "FriendsNearbyInviteStatusQuery", "0c1697d9887593736f8da9a580b38685", "viewer", "10154557146841729", RegularImmutableSet.a);
        }
    }

    /* compiled from: [ -]*$ */
    public class FriendsNearbyLocationSharingQueryString extends TypedGraphQlQueryString<FriendsNearbyLocationSharingQueryModel> {
        public FriendsNearbyLocationSharingQueryString() {
            super(FriendsNearbyLocationSharingQueryModel.class, false, "FriendsNearbyLocationSharingQuery", "6ba6351f097c8a854a93294b529c2bae", "viewer", "10154661258211729", RegularImmutableSet.a);
        }

        public final String m21167a(String str) {
            switch (str.hashCode()) {
                case -1777441434:
                    return "0";
                case -1442803611:
                    return "1";
                case -1439978388:
                    return "4";
                case -749580906:
                    return "8";
                case -729108464:
                    return "6";
                case -318427661:
                    return "7";
                case 137365935:
                    return "5";
                case 1222907506:
                    return "2";
                case 1544645326:
                    return "3";
                default:
                    return str;
            }
        }
    }

    /* compiled from: [ -]*$ */
    public class FriendsNearbyMoreInSectionQueryString extends TypedGraphQlQueryString<FriendsNearbyMoreInSectionQueryModel> {
        public FriendsNearbyMoreInSectionQueryString() {
            super(FriendsNearbyMoreInSectionQueryModel.class, false, "FriendsNearbyMoreInSectionQuery", "c13af363c7644914c43c3e899471d6c8", "node", "10154479866061729", RegularImmutableSet.a);
        }

        public final String m21168a(String str) {
            switch (str.hashCode()) {
                case -1073853070:
                    return "1";
                case -876253217:
                    return "0";
                case -749580906:
                    return "3";
                case 1307508398:
                    return "2";
                default:
                    return str;
            }
        }
    }

    /* compiled from: [ -]*$ */
    public class FriendsNearbySearchQueryString extends TypedGraphQlQueryString<FriendsNearbySearchQueryModel> {
        public FriendsNearbySearchQueryString() {
            super(FriendsNearbySearchQueryModel.class, false, "FriendsNearbySearchQuery", "9fda6becc552be30d6e0572cc8ecbf7e", "me", "10154479893541729", RegularImmutableSet.a);
        }

        public final String m21169a(String str) {
            switch (str.hashCode()) {
                case -1349119146:
                    return "2";
                case -749580906:
                    return "4";
                case -710472971:
                    return "0";
                case 94851343:
                    return "3";
                case 106006350:
                    return "1";
                default:
                    return str;
            }
        }
    }

    public static final FriendsNearbySearchQueryString m21170d() {
        return new FriendsNearbySearchQueryString();
    }
}
