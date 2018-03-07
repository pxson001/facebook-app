package com.facebook.search.protocol.livefeed;

import com.facebook.common.util.TriState;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.search.protocol.livefeed.FetchLiveFeedGraphQLModels.FetchLiveFeedStoriesGraphQLModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: narrow_landscape_height */
public final class FetchLiveFeedGraphQL {

    /* compiled from: narrow_landscape_height */
    public class FetchLiveFeedStoriesGraphQLString extends TypedGraphQlQueryString<FetchLiveFeedStoriesGraphQLModel> {
        public FetchLiveFeedStoriesGraphQLString() {
            super(FetchLiveFeedStoriesGraphQLModel.class, false, "FetchLiveFeedStoriesGraphQL", "ec91c4ab6fe2994b14f9915984816e03", "graph_search_query", "10154678112811729", RegularImmutableSet.a);
        }

        public final TriState m9392g() {
            return TriState.NO;
        }

        public final String m9390a(String str) {
            switch (str.hashCode()) {
                case -1849402738:
                    return "3";
                case -1780769805:
                    return "12";
                case -1745741354:
                    return "11";
                case -1663499699:
                    return "24";
                case -1460262781:
                    return "28";
                case -1150725321:
                    return "10";
                case -1101600581:
                    return "17";
                case -1046091640:
                    return "1";
                case -1012194872:
                    return "23";
                case -817257615:
                    return "18";
                case -635376273:
                    return "0";
                case -631654088:
                    return "6";
                case -561505403:
                    return "14";
                case -461877888:
                    return "25";
                case -376687594:
                    return "20";
                case -317710003:
                    return "27";
                case -92787706:
                    return "8";
                case 3569626:
                    return "2";
                case 16907033:
                    return "21";
                case 94851343:
                    return "22";
                case 169846802:
                    return "9";
                case 557908192:
                    return "26";
                case 580042479:
                    return "13";
                case 609122022:
                    return "5";
                case 651215103:
                    return "15";
                case 1139691781:
                    return "29";
                case 1585010628:
                    return "16";
                case 1673542407:
                    return "7";
                case 1939875509:
                    return "4";
                case 1963391292:
                    return "19";
                default:
                    return str;
            }
        }

        protected final boolean m9391a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 1573:
                    if (str.equals("16")) {
                        z = false;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    return (obj instanceof Boolean) && !((Boolean) obj).booleanValue();
                default:
                    return false;
            }
        }
    }
}
