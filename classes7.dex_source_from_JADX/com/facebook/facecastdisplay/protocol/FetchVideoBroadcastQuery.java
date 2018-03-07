package com.facebook.facecastdisplay.protocol;

import com.facebook.facecastdisplay.protocol.FetchVideoBroadcastQueryModels.VideoBroadcastFragmentModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: sticker_picker_tapped_back_button */
public final class FetchVideoBroadcastQuery {

    /* compiled from: sticker_picker_tapped_back_button */
    public class FetchVideoBroadcastQueryString extends TypedGraphQlQueryString<VideoBroadcastFragmentModel> {
        public FetchVideoBroadcastQueryString() {
            super(VideoBroadcastFragmentModel.class, false, "FetchVideoBroadcastQuery", "643e3325b70f1e0b10c4138a4bf061a9", "node", "10154668614031729", RegularImmutableSet.a);
        }

        public final String m4006a(String str) {
            switch (str.hashCode()) {
                case -631654088:
                    return "1";
                case -561505403:
                    return "4";
                case 159461928:
                    return "2";
                case 580042479:
                    return "3";
                case 651215103:
                    return "5";
                case 1151387487:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
