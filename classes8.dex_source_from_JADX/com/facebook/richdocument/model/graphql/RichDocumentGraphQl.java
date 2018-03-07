package com.facebook.richdocument.model.graphql;

import com.facebook.common.util.TriState;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentMasterModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTrackerModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: photo_picker_camera_media_captured */
public final class RichDocumentGraphQl {

    /* compiled from: photo_picker_camera_media_captured */
    public class RichDocumentNodeFeedbackString extends TypedGraphQlQueryString<GraphQLFeedback> {
        public RichDocumentNodeFeedbackString() {
            super(GraphQLFeedback.class, false, "RichDocumentNodeFeedback", "d5540bef985ad792ceaa0ddf7c137c1e", "node", "10154388038866729", RegularImmutableSet.a);
        }

        public final TriState m5570g() {
            return TriState.NO;
        }

        public final String m5569a(String str) {
            switch (str.hashCode()) {
                case 1939876286:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: photo_picker_camera_media_captured */
    public class RichDocumentQueryString extends TypedGraphQlQueryString<RichDocumentMasterModel> {
        public RichDocumentQueryString() {
            super(RichDocumentMasterModel.class, false, "RichDocumentQuery", "0859c56c5159ff3f03d1112c71cdbc51", "node", "10154683632246729", RegularImmutableSet.a);
        }

        public final TriState m5572g() {
            return TriState.NO;
        }

        public final String m5571a(String str) {
            switch (str.hashCode()) {
                case -1965309482:
                    return "12";
                case -1750447706:
                    return "20";
                case -1228046569:
                    return "13";
                case -871916350:
                    return "9";
                case -771996803:
                    return "18";
                case -363845479:
                    return "3";
                case -288990407:
                    return "17";
                case -59418986:
                    return "10";
                case 49242945:
                    return "8";
                case 109250890:
                    return "1";
                case 156681946:
                    return "19";
                case 527428164:
                    return "14";
                case 559509649:
                    return "0";
                case 778154042:
                    return "5";
                case 1172697268:
                    return "4";
                case 1724447644:
                    return "6";
                case 1905383601:
                    return "7";
                case 1939875509:
                    return "2";
                case 2019983959:
                    return "11";
                case 2023958139:
                    return "16";
                case 2121067403:
                    return "15";
                default:
                    return str;
            }
        }
    }

    /* compiled from: photo_picker_camera_media_captured */
    public class RichDocumentTrackerBlockQueryString extends TypedGraphQlQueryString<RichDocumentTrackerModel> {
        public RichDocumentTrackerBlockQueryString() {
            super(RichDocumentTrackerModel.class, false, "RichDocumentTrackerBlockQuery", "06c94d5171c3d8d4b6c3b8ed46bda6a6", "node", "10154407183976729", RegularImmutableSet.a);
        }

        public final String m5573a(String str) {
            switch (str.hashCode()) {
                case 947774794:
                    return "0";
                case 1022128354:
                    return "1";
                default:
                    return str;
            }
        }
    }
}
