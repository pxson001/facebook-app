package com.facebook.pages.browser.data.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.pages.browser.data.graphql.RecommendedPagesModels.AllSectionsRecommendedPagesModel;
import com.facebook.pages.browser.data.graphql.RecommendedPagesModels.RecommendedPagesInCategoryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: styleAttr */
public final class RecommendedPages {

    /* compiled from: styleAttr */
    public class AllSectionsRecommendedPagesString extends TypedGraphQlQueryString<AllSectionsRecommendedPagesModel> {
        public AllSectionsRecommendedPagesString() {
            super(AllSectionsRecommendedPagesModel.class, false, "AllSectionsRecommendedPages", "4f552265f198649a4a550d3087026039", "viewer", "10154429039331729", RegularImmutableSet.a);
        }

        public final String m1818a(String str) {
            switch (str.hashCode()) {
                case 741489506:
                    return "0";
                case 1602090896:
                    return "1";
                default:
                    return str;
            }
        }
    }

    /* compiled from: styleAttr */
    public class RecommendedPagesInCategoryString extends TypedGraphQlQueryString<RecommendedPagesInCategoryModel> {
        public RecommendedPagesInCategoryString() {
            super(RecommendedPagesInCategoryModel.class, false, "RecommendedPagesInCategory", "5382ccd1e1278cb61920f9a08c00b1e7", "viewer", "10154429039321729", RegularImmutableSet.a);
        }

        public final String m1819a(String str) {
            switch (str.hashCode()) {
                case 50511102:
                    return "0";
                case 1602090896:
                    return "2";
                case 1638521760:
                    return "1";
                default:
                    return str;
            }
        }
    }
}
