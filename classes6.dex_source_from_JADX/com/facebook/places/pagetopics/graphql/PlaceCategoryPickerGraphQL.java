package com.facebook.places.pagetopics.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.places.pagetopics.graphql.PlaceCategoryPickerGraphQLModels.PlaceCategoryPickerChildrenModel;
import com.facebook.places.pagetopics.graphql.PlaceCategoryPickerGraphQLModels.PlaceCategoryPickerSearchModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: focus_y */
public final class PlaceCategoryPickerGraphQL {

    /* compiled from: focus_y */
    public class PlaceCategoryPickerChildrenString extends TypedGraphQlQueryString<PlaceCategoryPickerChildrenModel> {
        public PlaceCategoryPickerChildrenString() {
            super(PlaceCategoryPickerChildrenModel.class, false, "PlaceCategoryPickerChildren", "c77a9e8a06796088055c22f6a7fc32c6", "node", "10154444218136729", RegularImmutableSet.a);
        }

        public final String m22328a(String str) {
            switch (str.hashCode()) {
                case 1537780732:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: focus_y */
    public class PlaceCategoryPickerSearchString extends TypedGraphQlQueryString<PlaceCategoryPickerSearchModel> {
        public PlaceCategoryPickerSearchString() {
            super(PlaceCategoryPickerSearchModel.class, false, "PlaceCategoryPickerSearch", "2d3f0ad6fc09fda7b47182170819e3a5", "entity_category_search", "10154444218131729", RegularImmutableSet.a);
        }

        public final String m22329a(String str) {
            switch (str.hashCode()) {
                case 107944136:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
