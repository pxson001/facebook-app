package com.facebook.heisman.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.heisman.protocol.CategoryBrowserGraphQLModels.CategoryBrowserQueryModel;
import com.facebook.heisman.protocol.CategoryBrowserGraphQLModels.CategoryBrowserSearchQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: mMontageThreadFBID */
public final class CategoryBrowserGraphQL {

    /* compiled from: mMontageThreadFBID */
    public class CategoryBrowserQueryString extends TypedGraphQlQueryString<CategoryBrowserQueryModel> {
        public CategoryBrowserQueryString() {
            super(CategoryBrowserQueryModel.class, false, "CategoryBrowserQuery", "3dbe02e338dc0e4642e13a9b3f00b654", "profile_overlay", "10154578652441729", RegularImmutableSet.a);
        }

        public final String m17653a(String str) {
            switch (str.hashCode()) {
                case -1663499699:
                    return "1";
                case 1369463909:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: mMontageThreadFBID */
    public class CategoryBrowserSearchQueryString extends TypedGraphQlQueryString<CategoryBrowserSearchQueryModel> {
        public CategoryBrowserSearchQueryString() {
            super(CategoryBrowserSearchQueryModel.class, false, "CategoryBrowserSearchQuery", "4196602b00075ade3985bcbde765dac4", "profile_overlay", "10154578685851729", RegularImmutableSet.a);
        }

        public final String m17654a(String str) {
            switch (str.hashCode()) {
                case -1663499699:
                    return "2";
                case 107944136:
                    return "0";
                case 1369463909:
                    return "1";
                default:
                    return str;
            }
        }
    }
}
