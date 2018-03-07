package com.facebook.backstage.graphql;

import com.facebook.backstage.graphql.FBBackstageQueryModels.FBBackstageAllFriendsQueryModel;
import com.facebook.backstage.graphql.FBBackstageQueryModels.FBBackstagePostsModel;
import com.facebook.backstage.graphql.FBBackstageQueryModels.FBBackstageThreadsQueryModel;
import com.facebook.backstage.graphql.FBBackstageQueryModels.FBBackstageWhiteListedFriendsQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: requested_height */
public final class FBBackstageQuery {

    /* compiled from: requested_height */
    public class FBBackstageAllFriendsQueryString extends TypedGraphQlQueryString<FBBackstageAllFriendsQueryModel> {
        public FBBackstageAllFriendsQueryString() {
            super(FBBackstageAllFriendsQueryModel.class, false, "FBBackstageAllFriendsQuery", "8bfe75c28ec93abbe44b04beb8841764", "me", "10154373068516729", RegularImmutableSet.a);
        }

        public final String m5064a(String str) {
            switch (str.hashCode()) {
                case -1207110587:
                    return "0";
                case 109250890:
                    return "2";
                case 573842321:
                    return "1";
                default:
                    return str;
            }
        }
    }

    /* compiled from: requested_height */
    public class FBBackstagePostsString extends TypedGraphQlQueryString<FBBackstagePostsModel> {
        public FBBackstagePostsString() {
            super(FBBackstagePostsModel.class, false, "FBBackstagePosts", "0ebcf351dcd89d01eb479cf2e3ecaf07", "me", "10154406671236729", RegularImmutableSet.a);
        }

        public final String m5065a(String str) {
            switch (str.hashCode()) {
                case -381590603:
                    return "4";
                case -230346670:
                    return "3";
                case 3530753:
                    return "7";
                case 94851343:
                    return "5";
                case 109250890:
                    return "6";
                case 394110159:
                    return "0";
                case 573842321:
                    return "2";
                case 1748678246:
                    return "1";
                default:
                    return str;
            }
        }
    }

    /* compiled from: requested_height */
    public class FBBackstageThreadsQueryString extends TypedGraphQlQueryString<FBBackstageThreadsQueryModel> {
        public FBBackstageThreadsQueryString() {
            super(FBBackstageThreadsQueryModel.class, false, "FBBackstageThreadsQuery", "585031b787a4ce184f4a132ef3dac603", "me", "10154404652046729", RegularImmutableSet.a);
        }

        public final String m5066a(String str) {
            switch (str.hashCode()) {
                case -164000347:
                    return "0";
                case 3530753:
                    return "4";
                case 109250890:
                    return "3";
                case 394110159:
                    return "1";
                case 573842321:
                    return "2";
                default:
                    return str;
            }
        }
    }

    /* compiled from: requested_height */
    public class FBBackstageWhiteListedFriendsQueryString extends TypedGraphQlQueryString<FBBackstageWhiteListedFriendsQueryModel> {
        public FBBackstageWhiteListedFriendsQueryString() {
            super(FBBackstageWhiteListedFriendsQueryModel.class, false, "FBBackstageWhiteListedFriendsQuery", "f241bf0e75c6d8369ce15e0cc9a5085f", "me", "10154374477486729", RegularImmutableSet.a);
        }

        public final String m5067a(String str) {
            switch (str.hashCode()) {
                case 573842321:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
