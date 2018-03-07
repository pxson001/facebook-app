package com.facebook.composer.minutiae.graphql;

import com.facebook.composer.minutiae.graphql.FetchTaggableActivitiesGraphQLModels.FetchRankedVerbsQueryModel;
import com.facebook.composer.minutiae.graphql.FetchTaggableActivitiesGraphQLModels.FetchTaggableActivitiesQueryModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableActivityIconsModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: ads_currency */
public final class FetchTaggableActivitiesGraphQL {

    /* compiled from: ads_currency */
    public class FetchRankedVerbsQueryString extends TypedGraphQlQueryString<FetchRankedVerbsQueryModel> {
        public FetchRankedVerbsQueryString() {
            super(FetchRankedVerbsQueryModel.class, false, "FetchRankedVerbsQuery", "5ff47dece411a86f227e615b33645fd6", "viewer", "10154405017756729", RegularImmutableSet.a);
        }

        public final String m19144a(String str) {
            switch (str.hashCode()) {
                case -2131707655:
                    return "9";
                case -2023697044:
                    return "6";
                case -1853231955:
                    return "4";
                case -1777441434:
                    return "14";
                case -1363693170:
                    return "16";
                case -1019779949:
                    return "12";
                case -168137647:
                    return "11";
                case 106911:
                    return "7";
                case 3327612:
                    return "8";
                case 37109963:
                    return "3";
                case 107944136:
                    return "1";
                case 351091771:
                    return "0";
                case 1128457243:
                    return "13";
                case 1262329779:
                    return "10";
                case 1423926404:
                    return "15";
                case 1661853540:
                    return "2";
                case 1858938707:
                    return "5";
                default:
                    return str;
            }
        }
    }

    /* compiled from: ads_currency */
    public class FetchTaggableActivitiesQueryString extends TypedGraphQlQueryString<FetchTaggableActivitiesQueryModel> {
        public FetchTaggableActivitiesQueryString() {
            super(FetchTaggableActivitiesQueryModel.class, false, "FetchTaggableActivitiesQuery", "ee751fc73ac84a25dfc3a68949d52a8c", "viewer", "10154358536266729", RegularImmutableSet.a);
        }

        public final String m19145a(String str) {
            switch (str.hashCode()) {
                case -1777441434:
                    return "0";
                case -1363693170:
                    return "2";
                case 1423926404:
                    return "1";
                default:
                    return str;
            }
        }
    }

    /* compiled from: ads_currency */
    public class FetchTaggableActivityForOldIconPickerString extends TypedGraphQlQueryString<MinutiaeTaggableActivityIconsModel> {
        public FetchTaggableActivityForOldIconPickerString() {
            super(MinutiaeTaggableActivityIconsModel.class, false, "FetchTaggableActivityForOldIconPicker", "152ca00abe0fa4f0cab868a95771daba", "taggable_activity", "10154429038026729", RegularImmutableSet.a);
        }

        public final String m19146a(String str) {
            switch (str.hashCode()) {
                case -1777441434:
                    return "2";
                case 1404348147:
                    return "0";
                case 1423926404:
                    return "1";
                default:
                    return str;
            }
        }
    }

    public static final FetchTaggableActivitiesQueryString m19147a() {
        return new FetchTaggableActivitiesQueryString();
    }
}
