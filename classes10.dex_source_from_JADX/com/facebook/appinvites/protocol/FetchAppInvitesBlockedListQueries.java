package com.facebook.appinvites.protocol;

import com.facebook.appinvites.protocol.FetchAppInvitesBlockedListQueriesModels.AppInviteBlockedAppsQueryModel;
import com.facebook.appinvites.protocol.FetchAppInvitesBlockedListQueriesModels.AppInviteBlockedUsersQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: e00b601cc18f43d82509425914510b5c */
public final class FetchAppInvitesBlockedListQueries {

    /* compiled from: e00b601cc18f43d82509425914510b5c */
    public class AppInviteBlockedAppsQueryString extends TypedGraphQlQueryString<AppInviteBlockedAppsQueryModel> {
        public AppInviteBlockedAppsQueryString() {
            super(AppInviteBlockedAppsQueryModel.class, false, "AppInviteBlockedAppsQuery", "3349ecb18bd9c5dca288dfbaef6df060", "viewer", "10154429037826729", RegularImmutableSet.a);
        }

        public final String m14899a(String str) {
            switch (str.hashCode()) {
                case 1888798992:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: e00b601cc18f43d82509425914510b5c */
    public class AppInviteBlockedUsersQueryString extends TypedGraphQlQueryString<AppInviteBlockedUsersQueryModel> {
        public AppInviteBlockedUsersQueryString() {
            super(AppInviteBlockedUsersQueryModel.class, false, "AppInviteBlockedUsersQuery", "8f8c9a12f75ab8514e5c0ccdc426445d", "viewer", "10154429037836729", RegularImmutableSet.a);
        }

        public final String m14900a(String str) {
            switch (str.hashCode()) {
                case 1888798992:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
