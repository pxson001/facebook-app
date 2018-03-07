package com.facebook.feedback.reactions.api;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: growth_set_profile_photo */
public class C0849x58811274 extends TypedGraphQlQueryString<C0850x41c6c670> {
    public C0849x58811274() {
        super(C0850x41c6c670.class, false, "FetchFeedbackReactionSettingsQuery", "53b544b7a4c4cad252c25888b72a559c", "viewer", "10154390379936729", RegularImmutableSet.f688a);
    }

    public final String mo1605a(String str) {
        switch (str.hashCode()) {
            case 109250890:
                return "1";
            case 1160342101:
                return "0";
            default:
                return str;
        }
    }

    protected final boolean mo1606a(String str, Object obj) {
        Object obj2 = -1;
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
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
