package com.facebook.friendlist.protocol;

import com.facebook.friendlist.protocol.FetchFriendListGraphQLModels.FetchFriendListQueryModel;
import com.facebook.friendlist.protocol.FetchFriendListGraphQLModels.FetchMutualFriendListQueryModel;
import com.facebook.friendlist.protocol.FetchFriendListGraphQLModels.FetchRecentlyAddedFriendListQueryModel;
import com.facebook.friendlist.protocol.FetchFriendListGraphQLModels.FetchSuggestionsFriendListQueryModel;
import com.facebook.friendlist.protocol.FetchFriendListGraphQLModels.FetchWithNewPostsFriendListQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: access_token parameter not found. */
public final class FetchFriendListGraphQL {

    /* compiled from: access_token parameter not found. */
    public class FetchFriendListQueryString extends TypedGraphQlQueryString<FetchFriendListQueryModel> {
        public FetchFriendListQueryString() {
            super(FetchFriendListQueryModel.class, false, "FetchFriendListQuery", "644c917ac8f24741efba0575a7fbc2ab", "user", "10154564856226729", RegularImmutableSet.a);
        }

        public final String m20683a(String str) {
            switch (str.hashCode()) {
                case -1993439567:
                    return "5";
                case -1102636175:
                    return "0";
                case -693728706:
                    return "2";
                case 169299563:
                    return "4";
                case 566144106:
                    return "1";
                case 1819236250:
                    return "3";
                default:
                    return str;
            }
        }

        protected final boolean m20684a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 50:
                    if (str.equals("2")) {
                        z = false;
                        break;
                    }
                    break;
                case 52:
                    if (str.equals("4")) {
                        z = true;
                        break;
                    }
                    break;
                case 53:
                    if (str.equals("5")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (obj instanceof String) {
                        return "20".equals(obj);
                    }
                    if (!(obj instanceof Integer)) {
                        return false;
                    }
                    if (((Integer) obj).intValue() != 20) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "true".equals(obj);
                    }
                    if (!(obj instanceof Boolean)) {
                        return false;
                    }
                    if (!((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "true".equals(obj);
                    }
                    if (!(obj instanceof Boolean)) {
                        return false;
                    }
                    if (!((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                default:
                    return false;
            }
        }
    }

    /* compiled from: access_token parameter not found. */
    public class FetchMutualFriendListQueryString extends TypedGraphQlQueryString<FetchMutualFriendListQueryModel> {
        public FetchMutualFriendListQueryString() {
            super(FetchMutualFriendListQueryModel.class, false, "FetchMutualFriendListQuery", "4dc249af9e5ff44d2ea13ce0c24cb63f", "user", "10154564856296729", RegularImmutableSet.a);
        }

        public final String m20685a(String str) {
            switch (str.hashCode()) {
                case -1993439567:
                    return "5";
                case -1102636175:
                    return "0";
                case -693728706:
                    return "2";
                case 169299563:
                    return "4";
                case 566144106:
                    return "1";
                case 1819236250:
                    return "3";
                default:
                    return str;
            }
        }

        protected final boolean m20686a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 50:
                    if (str.equals("2")) {
                        z = false;
                        break;
                    }
                    break;
                case 52:
                    if (str.equals("4")) {
                        z = true;
                        break;
                    }
                    break;
                case 53:
                    if (str.equals("5")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (obj instanceof String) {
                        return "20".equals(obj);
                    }
                    if (!(obj instanceof Integer)) {
                        return false;
                    }
                    if (((Integer) obj).intValue() != 20) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean)) {
                        return false;
                    }
                    if (((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "true".equals(obj);
                    }
                    if (!(obj instanceof Boolean)) {
                        return false;
                    }
                    if (!((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                default:
                    return false;
            }
        }
    }

    /* compiled from: access_token parameter not found. */
    public class FetchRecentlyAddedFriendListQueryString extends TypedGraphQlQueryString<FetchRecentlyAddedFriendListQueryModel> {
        public FetchRecentlyAddedFriendListQueryString() {
            super(FetchRecentlyAddedFriendListQueryModel.class, false, "FetchRecentlyAddedFriendListQuery", "54dbd0a0d10e0792ededfd3a69fcd777", "user", "10154564856216729", RegularImmutableSet.a);
        }

        public final String m20687a(String str) {
            switch (str.hashCode()) {
                case -1993439567:
                    return "4";
                case -1102636175:
                    return "0";
                case 169299563:
                    return "3";
                case 525895283:
                    return "1";
                case 1819236250:
                    return "2";
                default:
                    return str;
            }
        }

        protected final boolean m20688a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 51:
                    if (str.equals("3")) {
                        z = false;
                        break;
                    }
                    break;
                case 52:
                    if (str.equals("4")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean)) {
                        return false;
                    }
                    if (((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "true".equals(obj);
                    }
                    if (!(obj instanceof Boolean)) {
                        return false;
                    }
                    if (!((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                default:
                    return false;
            }
        }
    }

    /* compiled from: access_token parameter not found. */
    public class FetchSuggestionsFriendListQueryString extends TypedGraphQlQueryString<FetchSuggestionsFriendListQueryModel> {
        public FetchSuggestionsFriendListQueryString() {
            super(FetchSuggestionsFriendListQueryModel.class, false, "FetchSuggestionsFriendListQuery", "423f4cbbda46c528fb77fd7c67b9e755", "user", "10154564856201729", RegularImmutableSet.a);
        }

        public final String m20689a(String str) {
            switch (str.hashCode()) {
                case -1993439567:
                    return "5";
                case -1102636175:
                    return "0";
                case -693728706:
                    return "2";
                case 169299563:
                    return "4";
                case 566144106:
                    return "1";
                case 1819236250:
                    return "3";
                default:
                    return str;
            }
        }

        protected final boolean m20690a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 50:
                    if (str.equals("2")) {
                        z = false;
                        break;
                    }
                    break;
                case 52:
                    if (str.equals("4")) {
                        z = true;
                        break;
                    }
                    break;
                case 53:
                    if (str.equals("5")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (obj instanceof String) {
                        return "20".equals(obj);
                    }
                    if (!(obj instanceof Integer)) {
                        return false;
                    }
                    if (((Integer) obj).intValue() != 20) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean)) {
                        return false;
                    }
                    if (((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean)) {
                        return false;
                    }
                    if (((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                default:
                    return false;
            }
        }
    }

    /* compiled from: access_token parameter not found. */
    public class FetchWithNewPostsFriendListQueryString extends TypedGraphQlQueryString<FetchWithNewPostsFriendListQueryModel> {
        public FetchWithNewPostsFriendListQueryString() {
            super(FetchWithNewPostsFriendListQueryModel.class, false, "FetchWithNewPostsFriendListQuery", "413dec835688ff34d8828a2bf55b3969", "user", "10154564856236729", RegularImmutableSet.a);
        }

        public final String m20691a(String str) {
            switch (str.hashCode()) {
                case -1993439567:
                    return "5";
                case -1102636175:
                    return "0";
                case -693728706:
                    return "2";
                case 169299563:
                    return "4";
                case 566144106:
                    return "1";
                case 1819236250:
                    return "3";
                default:
                    return str;
            }
        }

        protected final boolean m20692a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 50:
                    if (str.equals("2")) {
                        z = false;
                        break;
                    }
                    break;
                case 52:
                    if (str.equals("4")) {
                        z = true;
                        break;
                    }
                    break;
                case 53:
                    if (str.equals("5")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (obj instanceof String) {
                        return "20".equals(obj);
                    }
                    if (!(obj instanceof Integer)) {
                        return false;
                    }
                    if (((Integer) obj).intValue() != 20) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean)) {
                        return false;
                    }
                    if (((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "true".equals(obj);
                    }
                    if (!(obj instanceof Boolean)) {
                        return false;
                    }
                    if (!((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                default:
                    return false;
            }
        }
    }
}
