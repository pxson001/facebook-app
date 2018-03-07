package com.facebook.timeline.aboutpage.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineCollectionsSectionViewQueryModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: MULTIMEDIA_NOT_ALLOWED */
public final class FetchTimelineCollectionsGraphQL {

    /* compiled from: MULTIMEDIA_NOT_ALLOWED */
    public class FetchTimelineCollectionsSectionViewQueryString extends TypedGraphQlQueryString<FetchTimelineCollectionsSectionViewQueryModel> {
        public FetchTimelineCollectionsSectionViewQueryString() {
            super(FetchTimelineCollectionsSectionViewQueryModel.class, false, "FetchTimelineCollectionsSectionViewQuery", "6d01f69f681e3a8496ff5bcdaaaac152", "node", "10154617223276729", RegularImmutableSet.a);
        }

        public final String m14693a(String str) {
            switch (str.hashCode()) {
                case -1496041069:
                    return "0";
                case -1101600581:
                    return "9";
                case -997443983:
                    return "2";
                case -402358115:
                    return "5";
                case -400946241:
                    return "3";
                case -348540788:
                    return "7";
                case -162300577:
                    return "6";
                case 25209764:
                    return "11";
                case 614012309:
                    return "4";
                case 689802720:
                    return "10";
                case 1259588176:
                    return "8";
                case 1598177384:
                    return "1";
                default:
                    return str;
            }
        }
    }

    /* compiled from: MULTIMEDIA_NOT_ALLOWED */
    public class FetchTimelineSingleCollectionViewQueryString extends TypedGraphQlQueryString<FetchTimelineSingleCollectionViewQueryModel> {
        public FetchTimelineSingleCollectionViewQueryString() {
            super(FetchTimelineSingleCollectionViewQueryModel.class, false, "FetchTimelineSingleCollectionViewQuery", "73db64681bd97da91c1cc52564e92029", "node", "10154617223221729", RegularImmutableSet.a);
        }

        public final String m14694a(String str) {
            switch (str.hashCode()) {
                case -1496041069:
                    return "0";
                case -1101600581:
                    return "10";
                case -997443983:
                    return "3";
                case -821242276:
                    return "1";
                case -402358115:
                    return "6";
                case -400946241:
                    return "4";
                case -348540788:
                    return "8";
                case -162300577:
                    return "7";
                case 25209764:
                    return "12";
                case 614012309:
                    return "5";
                case 689802720:
                    return "11";
                case 1259588176:
                    return "9";
                case 1598177384:
                    return "2";
                default:
                    return str;
            }
        }
    }
}
