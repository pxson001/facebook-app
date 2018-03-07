package com.facebook.composer.lifeevent.protocol;

import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLModels.BirthdayQueryModel;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLModels.CollegeEntitiesTypeAheadSuggestionsQueryModel;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLModels.FBLifeEventSuggestionsAllIconsQueryModel;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLModels.FBLifeEventSuggestionsQueryModel;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLModels.HighSchoolEntitiesTypeAheadSuggestionsQueryModel;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLModels.PeopleEntitiesTypeAheadSuggestionsQueryModel;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLModels.WorkEntitiesTypeAheadSuggestionsQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: place_is_permanently_closed */
public final class FetchLifeEventComposerDataGraphQL {

    /* compiled from: place_is_permanently_closed */
    public class BirthdayQueryString extends TypedGraphQlQueryString<BirthdayQueryModel> {
        public BirthdayQueryString() {
            super(BirthdayQueryModel.class, false, "BirthdayQuery", "6a46cfb7dddad61c6c753135a1233127", "node", "10154339187481729", RegularImmutableSet.a);
        }

        public final String m11274a(String str) {
            switch (str.hashCode()) {
                case -836030906:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: place_is_permanently_closed */
    public class CollegeEntitiesTypeAheadSuggestionsQueryString extends TypedGraphQlQueryString<CollegeEntitiesTypeAheadSuggestionsQueryModel> {
        public CollegeEntitiesTypeAheadSuggestionsQueryString() {
            super(CollegeEntitiesTypeAheadSuggestionsQueryModel.class, false, "CollegeEntitiesTypeAheadSuggestionsQuery", "0e10bf1fd8b770f8b7cb89b13e036fd4", "entities_named", "10154429038031729", RegularImmutableSet.a);
        }

        public final String m11275a(String str) {
            switch (str.hashCode()) {
                case -1442803611:
                    return "1";
                case 107944136:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: place_is_permanently_closed */
    public class FBLifeEventSuggestionsAllIconsQueryString extends TypedGraphQlQueryString<FBLifeEventSuggestionsAllIconsQueryModel> {
        public FBLifeEventSuggestionsAllIconsQueryString() {
            super(FBLifeEventSuggestionsAllIconsQueryModel.class, false, "FBLifeEventSuggestionsAllIconsQuery", "cb8e15896f68cd406033415d6b8e4ef3", "viewer", "10154429037831729", RegularImmutableSet.a);
        }

        public final String m11276a(String str) {
            switch (str.hashCode()) {
                case 109250890:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: place_is_permanently_closed */
    public class FBLifeEventSuggestionsQueryString extends TypedGraphQlQueryString<FBLifeEventSuggestionsQueryModel> {
        public FBLifeEventSuggestionsQueryString() {
            super(FBLifeEventSuggestionsQueryModel.class, false, "FBLifeEventSuggestionsQuery", "4f34a97cff5b3f8639b3c1d7557c3cb1", "viewer", "10154429037841729", RegularImmutableSet.a);
        }

        public final String m11277a(String str) {
            switch (str.hashCode()) {
                case 109250890:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: place_is_permanently_closed */
    public class HighSchoolEntitiesTypeAheadSuggestionsQueryString extends TypedGraphQlQueryString<HighSchoolEntitiesTypeAheadSuggestionsQueryModel> {
        public HighSchoolEntitiesTypeAheadSuggestionsQueryString() {
            super(HighSchoolEntitiesTypeAheadSuggestionsQueryModel.class, false, "HighSchoolEntitiesTypeAheadSuggestionsQuery", "02003b16d892e4616b93a3429d395560", "entities_named", "10154429038036729", RegularImmutableSet.a);
        }

        public final String m11278a(String str) {
            switch (str.hashCode()) {
                case -1442803611:
                    return "1";
                case 107944136:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: place_is_permanently_closed */
    public class PeopleEntitiesTypeAheadSuggestionsQueryString extends TypedGraphQlQueryString<PeopleEntitiesTypeAheadSuggestionsQueryModel> {
        public PeopleEntitiesTypeAheadSuggestionsQueryString() {
            super(PeopleEntitiesTypeAheadSuggestionsQueryModel.class, false, "PeopleEntitiesTypeAheadSuggestionsQuery", "92dfc991e03c74fc57745cf3f030f05d", "entities_named", "10154429038051729", RegularImmutableSet.a);
        }

        public final String m11279a(String str) {
            switch (str.hashCode()) {
                case -1442803611:
                    return "1";
                case 107944136:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: place_is_permanently_closed */
    public class WorkEntitiesTypeAheadSuggestionsQueryString extends TypedGraphQlQueryString<WorkEntitiesTypeAheadSuggestionsQueryModel> {
        public WorkEntitiesTypeAheadSuggestionsQueryString() {
            super(WorkEntitiesTypeAheadSuggestionsQueryModel.class, false, "WorkEntitiesTypeAheadSuggestionsQuery", "c88a4aa3f4003419ce2dcd325cdcd493", "entities_named", "10154429038056729", RegularImmutableSet.a);
        }

        public final String m11280a(String str) {
            switch (str.hashCode()) {
                case -1442803611:
                    return "1";
                case 107944136:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
