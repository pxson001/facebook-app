package com.facebook.orca.threadlist;

import com.facebook.config.application.FbAppType;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: nearby_friends_now_nux_more_info_click */
public class Boolean_IsStartNewConversationEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    private static Boolean m6092b(InjectorLike injectorLike) {
        return ThreadListModule.m6422a((FbAppType) injectorLike.getInstance(FbAppType.class));
    }

    public Object get() {
        return ThreadListModule.m6422a((FbAppType) getInstance(FbAppType.class));
    }
}
