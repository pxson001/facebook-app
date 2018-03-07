package com.facebook.timeline.aboutpage.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionItemsGraphQLModels.CollectionWithItemsAndSuggestionsModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: MalwareScanner */
public final class FetchTimelineCollectionItemsGraphQL {

    /* compiled from: MalwareScanner */
    public class CollectionItemsPageQueryString extends TypedGraphQlQueryString<CollectionWithItemsAndSuggestionsModel> {
        public CollectionItemsPageQueryString() {
            super(CollectionWithItemsAndSuggestionsModel.class, false, "CollectionItemsPageQuery", "413d23e2f579e3d32ae209ac1794d851", "node", "10154617223256729", RegularImmutableSet.a);
        }

        public final String m14668a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "9";
                case -997443983:
                    return "2";
                case -821242276:
                    return "0";
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

        protected final boolean m14669a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 54:
                    if (str.equals("6")) {
                        z = false;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (obj instanceof String) {
                        return "18".equals(obj);
                    }
                    return (obj instanceof Integer) && ((Integer) obj).intValue() == 18;
                default:
                    return false;
            }
        }
    }
}
