package com.facebook.facecastdisplay.protocol;

import com.facebook.facecastdisplay.protocol.FetchViewerCountAndBroadcastStatusQueryModels.FetchViewerCountAndBroadcastStatusQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;
import java.util.Map;

/* compiled from: sticker_keyboard_shown */
public final class FetchViewerCountAndBroadcastStatusQuery {

    /* compiled from: sticker_keyboard_shown */
    public class FetchViewerCountAndBroadcastStatusQueryString extends TypedGraphQlQueryString<Map<String, FetchViewerCountAndBroadcastStatusQueryModel>> {
        public FetchViewerCountAndBroadcastStatusQueryString() {
            super(FetchViewerCountAndBroadcastStatusQueryModel.class, true, "FetchViewerCountAndBroadcastStatusQuery", "a6f253b2a73c4aed21327f1d869e2de6", "videos", "10154546675281729", RegularImmutableSet.a);
        }

        public final String m4027a(String str) {
            switch (str.hashCode()) {
                case 159461928:
                    return "1";
                case 1333273844:
                    return "0";
                default:
                    return str;
            }
        }

        protected final boolean m4028a(String str, Object obj) {
            Object obj2 = -1;
            switch (str.hashCode()) {
                case 49:
                    if (str.equals("1")) {
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

    public static final FetchViewerCountAndBroadcastStatusQueryString m4029a() {
        return new FetchViewerCountAndBroadcastStatusQueryString();
    }
}
