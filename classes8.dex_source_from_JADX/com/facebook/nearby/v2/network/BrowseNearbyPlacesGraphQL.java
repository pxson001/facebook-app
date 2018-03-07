package com.facebook.nearby.v2.network;

import com.facebook.common.util.TriState;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPlacesHugeResultsSearchQueryV2Model;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPlacesOldBrowseOldResultsSearchQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: dialog_from_photo_viewer */
public final class BrowseNearbyPlacesGraphQL {

    /* compiled from: dialog_from_photo_viewer */
    public class NearbyPlacesHugeResultsSearchQueryV2String extends TypedGraphQlQueryString<NearbyPlacesHugeResultsSearchQueryV2Model> {
        public NearbyPlacesHugeResultsSearchQueryV2String() {
            super(NearbyPlacesHugeResultsSearchQueryV2Model.class, false, "NearbyPlacesHugeResultsSearchQueryV2", "cbb6962062b4148f6830f60ebf6fbd73", "nearby_search", "10154677990956729", RegularImmutableSet.a);
        }

        public final TriState m17764g() {
            return TriState.NO;
        }

        public final String m17762a(String str) {
            switch (str.hashCode()) {
                case -1482998339:
                    return "16";
                case -1439978388:
                    return "7";
                case -1424931565:
                    return "17";
                case -1417226288:
                    return "13";
                case -1389427104:
                    return "9";
                case -1207109595:
                    return "11";
                case -693999586:
                    return "15";
                case -504312991:
                    return "12";
                case 3105789:
                    return "4";
                case 3645871:
                    return "2";
                case 102976443:
                    return "14";
                case 105007365:
                    return "1";
                case 109250890:
                    return "19";
                case 109627853:
                    return "3";
                case 137365935:
                    return "8";
                case 331292119:
                    return "5";
                case 334980221:
                    return "21";
                case 461177713:
                    return "0";
                case 552319461:
                    return "6";
                case 855339215:
                    return "18";
                case 1018939763:
                    return "22";
                case 1704455739:
                    return "10";
                case 1939875509:
                    return "20";
                default:
                    return str;
            }
        }

        protected final boolean m17763a(String str, Object obj) {
            Object obj2 = -1;
            switch (str.hashCode()) {
                case 1572:
                    if (str.equals("15")) {
                        obj2 = null;
                        break;
                    }
                    break;
            }
            switch (obj2) {
                case null:
                    if (obj instanceof String) {
                        return "true".equals(obj);
                    }
                    if (!(obj instanceof Boolean)) {
                        return false;
                    }
                    if (!((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                default:
                    return false;
            }
        }
    }

    /* compiled from: dialog_from_photo_viewer */
    public class NearbyPlacesOldBrowseOldResultsSearchQueryString extends TypedGraphQlQueryString<NearbyPlacesOldBrowseOldResultsSearchQueryModel> {
        public NearbyPlacesOldBrowseOldResultsSearchQueryString() {
            super(NearbyPlacesOldBrowseOldResultsSearchQueryModel.class, false, "NearbyPlacesOldBrowseOldResultsSearchQuery", "f46d6cba7867c8a80abb5b46d231b644", "tiled_places_search", "10154651150066729", RegularImmutableSet.a);
        }

        public final String m17765a(String str) {
            switch (str.hashCode()) {
                case -1439978388:
                    return "8";
                case -1389427104:
                    return "10";
                case -1280731361:
                    return "2";
                case -1207109595:
                    return "18";
                case -894842210:
                    return "3";
                case -504312991:
                    return "19";
                case -210647372:
                    return "12";
                case 3744723:
                    return "5";
                case 109250890:
                    return "21";
                case 109641799:
                    return "17";
                case 110546223:
                    return "0";
                case 137365935:
                    return "9";
                case 331292119:
                    return "7";
                case 403001325:
                    return "4";
                case 552319461:
                    return "6";
                case 795311618:
                    return "16";
                case 855339215:
                    return "20";
                case 1245702758:
                    return "1";
                case 1262329779:
                    return "13";
                case 1450674082:
                    return "15";
                case 1704455739:
                    return "11";
                case 2036550306:
                    return "14";
                default:
                    return str;
            }
        }
    }
}
