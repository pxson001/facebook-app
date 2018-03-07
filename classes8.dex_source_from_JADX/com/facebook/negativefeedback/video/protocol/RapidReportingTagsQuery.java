package com.facebook.negativefeedback.video.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.negativefeedback.video.protocol.RapidReportingTagsQueryModels.RapidReportingTagsQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: text_entity_tap */
public final class RapidReportingTagsQuery {

    /* compiled from: text_entity_tap */
    public class RapidReportingTagsQueryString extends TypedGraphQlQueryString<RapidReportingTagsQueryModel> {
        public RapidReportingTagsQueryString() {
            super(RapidReportingTagsQueryModel.class, false, "RapidReportingTagsQuery", "38a321e8a51883099aed813873f3aca5", "node", "10154493277756729", RegularImmutableSet.a);
        }

        public final String m1833a(String str) {
            switch (str.hashCode()) {
                case 1555612028:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
