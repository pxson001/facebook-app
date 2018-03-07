package com.facebook.timeline.favmediapicker.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.timeline.favmediapicker.protocol.FetchFavoriteMediaPickerSuggestionsModels.FavoriteMediaUserModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: friendsnearby_invite */
public final class FetchFavoriteMediaPickerSuggestions {

    /* compiled from: friendsnearby_invite */
    public class FavoriteMediaSuggestionsQueryString extends TypedGraphQlQueryString<FavoriteMediaUserModel> {
        public FavoriteMediaSuggestionsQueryString() {
            super(FavoriteMediaUserModel.class, false, "FavoriteMediaSuggestionsQuery", "232b05e6771a4fdd9e83ea05458e296b", "me", "10154679188441729", RegularImmutableSet.a);
        }

        public final String m11151a(String str) {
            switch (str.hashCode()) {
                case -507614738:
                    return "0";
                case 1800280017:
                    return "1";
                default:
                    return str;
            }
        }

        protected final boolean m11152a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 49:
                    if (str.equals("1")) {
                        z = false;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (obj instanceof String) {
                        return "6".equals(obj);
                    }
                    return (obj instanceof Integer) && ((Integer) obj).intValue() == 6;
                default:
                    return false;
            }
        }
    }
}
