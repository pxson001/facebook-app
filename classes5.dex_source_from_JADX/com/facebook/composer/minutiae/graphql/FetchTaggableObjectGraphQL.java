package com.facebook.composer.minutiae.graphql;

import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLModels.FetchSingleTaggableSuggestionQueryModel;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLModels.FetchTaggableObjectsQueryModel;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLModels.FetchTaggableSuggestionsAtPlaceQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: admin_profile_pic */
public final class FetchTaggableObjectGraphQL {

    /* compiled from: admin_profile_pic */
    public class FetchSingleTaggableSuggestionQueryString extends TypedGraphQlQueryString<FetchSingleTaggableSuggestionQueryModel> {
        public FetchSingleTaggableSuggestionQueryString() {
            super(FetchSingleTaggableSuggestionQueryModel.class, false, "FetchSingleTaggableSuggestionQuery", "4d03ec6ca31a3f056af90a732d5511b9", "taggable_activity", "10154661258026729", RegularImmutableSet.a);
        }

        public final String m19175a(String str) {
            switch (str.hashCode()) {
                case -1777441434:
                    return "5";
                case -1489595877:
                    return "1";
                case -1363693170:
                    return "6";
                case -1355461064:
                    return "7";
                case -1256653634:
                    return "8";
                case -1145738214:
                    return "0";
                case -1101600581:
                    return "2";
                case -790595877:
                    return "9";
                case 689802720:
                    return "3";
                case 1423926404:
                    return "4";
                default:
                    return str;
            }
        }
    }

    /* compiled from: admin_profile_pic */
    public class FetchTaggableObjectsQueryString extends TypedGraphQlQueryString<FetchTaggableObjectsQueryModel> {
        public FetchTaggableObjectsQueryString() {
            super(FetchTaggableObjectsQueryModel.class, false, "FetchTaggableObjectsQuery", "0586590fa4139b34949d79ac835306ff", "node", "10154686241041729", RegularImmutableSet.a);
        }

        public final String m19176a(String str) {
            switch (str.hashCode()) {
                case -2023697044:
                    return "7";
                case -1997780377:
                    return "11";
                case -1853231955:
                    return "6";
                case -1796193026:
                    return "10";
                case -1777441434:
                    return "15";
                case -1363693170:
                    return "16";
                case -1355461064:
                    return "17";
                case -1256653634:
                    return "1";
                case -1101600581:
                    return "12";
                case -790595877:
                    return "18";
                case 37109963:
                    return "5";
                case 412346332:
                    return "4";
                case 559851280:
                    return "3";
                case 689802720:
                    return "13";
                case 1404348147:
                    return "0";
                case 1423926404:
                    return "14";
                case 1858938707:
                    return "2";
                case 2087059799:
                    return "8";
                case 2101367332:
                    return "9";
                default:
                    return str;
            }
        }
    }

    /* compiled from: admin_profile_pic */
    public class FetchTaggableSuggestionsAtPlaceQueryString extends TypedGraphQlQueryString<FetchTaggableSuggestionsAtPlaceQueryModel> {
        public FetchTaggableSuggestionsAtPlaceQueryString() {
            super(FetchTaggableSuggestionsAtPlaceQueryModel.class, false, "FetchTaggableSuggestionsAtPlaceQuery", "9b2e1031326f7f2431dbf9304ad441ea", "taggable_activity", "10154429178826729", RegularImmutableSet.a);
        }

        public final String m19177a(String str) {
            switch (str.hashCode()) {
                case -1997780377:
                    return "10";
                case -1853231955:
                    return "5";
                case -1796193026:
                    return "9";
                case -1777441434:
                    return "14";
                case -1363693170:
                    return "15";
                case -1355461064:
                    return "16";
                case -1256653634:
                    return "17";
                case -1145738214:
                    return "0";
                case -1101600581:
                    return "11";
                case -790595877:
                    return "18";
                case 37109963:
                    return "4";
                case 412346332:
                    return "3";
                case 559851280:
                    return "2";
                case 689802720:
                    return "12";
                case 1423926404:
                    return "13";
                case 1634948172:
                    return "6";
                case 1858938707:
                    return "1";
                case 2087059799:
                    return "7";
                case 2101367332:
                    return "8";
                default:
                    return str;
            }
        }
    }

    public static final FetchTaggableObjectsQueryString m19178a() {
        return new FetchTaggableObjectsQueryString();
    }

    public static final FetchTaggableSuggestionsAtPlaceQueryString m19179b() {
        return new FetchTaggableSuggestionsAtPlaceQueryString();
    }
}
