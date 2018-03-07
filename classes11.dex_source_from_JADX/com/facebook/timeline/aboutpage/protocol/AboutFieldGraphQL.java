package com.facebook.timeline.aboutpage.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLModels.AboutSectionInfoModel;
import com.google.common.collect.ImmutableSet;

/* compiled from: Master ViewPager must be set */
public final class AboutFieldGraphQL {

    /* compiled from: Master ViewPager must be set */
    public class AboutSectionsQueryString extends TypedGraphQlQueryString<AboutSectionInfoModel> {
        public AboutSectionsQueryString() {
            super(AboutSectionInfoModel.class, false, "AboutSectionsQuery", "4f063d6055930d1aaaca574225ecdc84", "user", "10154643283861729", ImmutableSet.of("profile_field_sections_end_cursor"));
        }

        public final String m13941a(String str) {
            switch (str.hashCode()) {
                case -1102636175:
                    return "0";
                case -1101600581:
                    return "2";
                case -206792125:
                    return "1";
                case -27473082:
                    return "4";
                case 614012309:
                    return "5";
                case 689802720:
                    return "3";
                default:
                    return str;
            }
        }
    }
}
