package com.facebook.events.ui.themeselector.protocol;

import com.facebook.events.ui.themeselector.protocol.EventsThemeSelectorGraphQLModels.EventsThemeCategoriesModel;
import com.facebook.events.ui.themeselector.protocol.EventsThemeSelectorGraphQLModels.EventsThemeSuggestionsModel;
import com.facebook.events.ui.themeselector.protocol.EventsThemeSelectorGraphQLModels.FetchSingleEventThemePhotoQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: app_invite_cell_did_show */
public final class EventsThemeSelectorGraphQL {

    /* compiled from: app_invite_cell_did_show */
    public class EventsThemeCategoriesString extends TypedGraphQlQueryString<EventsThemeCategoriesModel> {
        public EventsThemeCategoriesString() {
            super(EventsThemeCategoriesModel.class, false, "EventsThemeCategories", "6d41725e35e9034b2ec813c51e3497d5", "viewer", "10153935035061729", RegularImmutableSet.a);
        }
    }

    /* compiled from: app_invite_cell_did_show */
    public class EventsThemeSuggestionsString extends TypedGraphQlQueryString<EventsThemeSuggestionsModel> {
        public EventsThemeSuggestionsString() {
            super(EventsThemeSuggestionsModel.class, false, "EventsThemeSuggestions", "17e99568bc0be6f1656b5bad9d7cc384", "viewer", "10154484807111729", RegularImmutableSet.a);
        }

        public final String m19802a(String str) {
            switch (str.hashCode()) {
                case -1321845545:
                    return "6";
                case -444314602:
                    return "5";
                case -78045510:
                    return "7";
                case -77796550:
                    return "0";
                case 17717284:
                    return "2";
                case 94851343:
                    return "4";
                case 528554630:
                    return "1";
                case 984038195:
                    return "3";
                case 1442561715:
                    return "8";
                default:
                    return str;
            }
        }
    }

    /* compiled from: app_invite_cell_did_show */
    public class FetchSingleEventThemePhotoQueryString extends TypedGraphQlQueryString<FetchSingleEventThemePhotoQueryModel> {
        public FetchSingleEventThemePhotoQueryString() {
            super(FetchSingleEventThemePhotoQueryModel.class, false, "FetchSingleEventThemePhotoQuery", "3f4c23e3cddc354a5e8c18de2d5c0457", "node", "10154427407336729", RegularImmutableSet.a);
        }

        public final String m19803a(String str) {
            switch (str.hashCode()) {
                case -805063587:
                    return "2";
                case -150549552:
                    return "1";
                case 1108949841:
                    return "0";
                default:
                    return str;
            }
        }
    }

    public static final EventsThemeSuggestionsString m19804a() {
        return new EventsThemeSuggestionsString();
    }

    public static final EventsThemeCategoriesString m19805c() {
        return new EventsThemeCategoriesString();
    }
}
