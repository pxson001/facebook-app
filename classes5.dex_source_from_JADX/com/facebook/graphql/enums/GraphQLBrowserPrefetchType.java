package com.facebook.graphql.enums;

/* compiled from: media_fbids */
public enum GraphQLBrowserPrefetchType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    HTML_ONLY,
    RENDER_BLOCKING,
    MEDIA,
    PRERENDER;

    public static GraphQLBrowserPrefetchType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("HTML_ONLY")) {
            return HTML_ONLY;
        }
        if (str.equalsIgnoreCase("RENDER_BLOCKING")) {
            return RENDER_BLOCKING;
        }
        if (str.equalsIgnoreCase("MEDIA")) {
            return MEDIA;
        }
        if (str.equalsIgnoreCase("PRERENDER")) {
            return PRERENDER;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
