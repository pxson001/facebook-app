package com.facebook.messaging.contextbanner.model;

import com.google.common.base.Preconditions;

/* compiled from: sticker_prefetch */
public class ProfileContextItem {
    public final ProfileContextItemType f2222a;
    public final String f2223b;

    public ProfileContextItem(ProfileContextItemType profileContextItemType, String str) {
        this.f2222a = (ProfileContextItemType) Preconditions.checkNotNull(profileContextItemType);
        this.f2223b = (String) Preconditions.checkNotNull(str);
    }
}
