package com.facebook.timeline.aboutpage.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.AppSectionInfoModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.TimelineCollectionAppSectionsModel;
import com.google.common.collect.ImmutableSet;

/* compiled from: MarketplaceBadgeCountQuery */
public final class FetchTimelineAppSectionsGraphQL {

    /* compiled from: MarketplaceBadgeCountQuery */
    public class AppSectionsNodeQueryString extends TypedGraphQlQueryString<AppSectionInfoModel> {
        public AppSectionsNodeQueryString() {
            super(AppSectionInfoModel.class, false, "AppSectionsNodeQuery", "5a28fdd3abce2ea422c01f5e7af89114", "user", "10154617223241729", ImmutableSet.of("collections_sections_end_cursor"));
        }

        public final String m14483a(String str) {
            switch (str.hashCode()) {
                case -2106201259:
                    return "7";
                case -1601966458:
                    return "6";
                case -1378150820:
                    return "8";
                case -1102636175:
                    return "0";
                case -1101600581:
                    return "13";
                case -997443983:
                    return "3";
                case -402358115:
                    return "9";
                case -400946241:
                    return "4";
                case -348540788:
                    return "11";
                case -206792125:
                    return "1";
                case -162300577:
                    return "10";
                case 25209764:
                    return "15";
                case 614012309:
                    return "5";
                case 689802720:
                    return "14";
                case 1186220722:
                    return "16";
                case 1259588176:
                    return "12";
                case 1598177384:
                    return "2";
                case 1853891989:
                    return "17";
                default:
                    return str;
            }
        }
    }

    /* compiled from: MarketplaceBadgeCountQuery */
    public class CollectionAppSectionsNodeQueryString extends TypedGraphQlQueryString<TimelineCollectionAppSectionsModel> {
        public CollectionAppSectionsNodeQueryString() {
            super(TimelineCollectionAppSectionsModel.class, false, "CollectionAppSectionsNodeQuery", "e44d034af1b91192511a7a30e9ac0fab", "user", "10154617223231729", ImmutableSet.of("collections_sections_end_cursor"));
        }

        public final String m14484a(String str) {
            switch (str.hashCode()) {
                case -2106201259:
                    return "6";
                case -1601966458:
                    return "5";
                case -1378150820:
                    return "7";
                case -1102636175:
                    return "0";
                case -1101600581:
                    return "12";
                case -997443983:
                    return "2";
                case -402358115:
                    return "8";
                case -400946241:
                    return "3";
                case -348540788:
                    return "10";
                case -162300577:
                    return "9";
                case 25209764:
                    return "14";
                case 614012309:
                    return "4";
                case 689802720:
                    return "13";
                case 1186220722:
                    return "15";
                case 1259588176:
                    return "11";
                case 1598177384:
                    return "1";
                case 1853891989:
                    return "16";
                default:
                    return str;
            }
        }
    }
}
