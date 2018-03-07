package com.facebook.graphql.cursor;

import com.facebook.common.build.BuildConstants;
import com.google.common.base.Preconditions;

/* compiled from: messenger_update_message_phase_two_succeeded */
public class SessionIdFormatter {
    public static String m8195a(String str) {
        Preconditions.checkNotNull(str);
        if (BuildConstants.i) {
            return str + "#479478467";
        }
        return str;
    }
}
