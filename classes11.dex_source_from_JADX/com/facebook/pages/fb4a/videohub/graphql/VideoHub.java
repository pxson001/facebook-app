package com.facebook.pages.fb4a.videohub.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.pages.fb4a.videohub.graphql.VideoHubModels.PageVideoHubQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: profile/%s/aboutpage?is_combined=%b&v=7 */
public final class VideoHub {

    /* compiled from: profile/%s/aboutpage?is_combined=%b&v=7 */
    public class PageVideoHubQueryString extends TypedGraphQlQueryString<PageVideoHubQueryModel> {
        public PageVideoHubQueryString() {
            super(PageVideoHubQueryModel.class, false, "PageVideoHubQuery", "155f3c5e487df8a885669ba4c130cc24", "node", "10154561741366729", RegularImmutableSet.a);
        }

        public final String m4148a(String str) {
            switch (str.hashCode()) {
                case -1925666883:
                    return "4";
                case -1773565470:
                    return "9";
                case -1606466720:
                    return "3";
                case -1597296023:
                    return "6";
                case -826475764:
                    return "7";
                case -803548981:
                    return "0";
                case -631654088:
                    return "8";
                case -561505403:
                    return "13";
                case 420666299:
                    return "1";
                case 421050507:
                    return "10";
                case 571910232:
                    return "2";
                case 580042479:
                    return "12";
                case 651215103:
                    return "14";
                case 819250700:
                    return "5";
                case 1939875509:
                    return "11";
                default:
                    return str;
            }
        }
    }

    public static final PageVideoHubQueryString m4149a() {
        return new PageVideoHubQueryString();
    }
}
