package com.facebook.messaging.chatheads.detect;

import android.content.Context;
import com.facebook.analytics.tagging.ContextBasedAppInterface;
import com.facebook.common.util.ContextUtils;

/* compiled from: deep_link_urls */
public class ChatHeadsContextDetector {
    private ChatHeadsContextDetector() {
    }

    public static boolean m10057a(Context context) {
        ContextBasedAppInterface contextBasedAppInterface = (ContextBasedAppInterface) ContextUtils.a(context, ContextBasedAppInterface.class);
        return contextBasedAppInterface != null && contextBasedAppInterface.m2596a() == "chat_heads";
    }
}
