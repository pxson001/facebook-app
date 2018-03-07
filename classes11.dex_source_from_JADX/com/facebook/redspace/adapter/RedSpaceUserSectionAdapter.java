package com.facebook.redspace.adapter;

import android.content.res.Resources;
import android.support.v4.app.FragmentManager;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.inject.Assisted;
import com.facebook.redspace.abtest.RedSpaceStrings;
import com.facebook.redspace.data.RedSpaceFeedProfileUnreadStoriesHelper;
import com.facebook.redspace.data.RedSpaceFriendsCollection;
import com.facebook.redspace.data.RedSpaceFriendsSection;
import javax.inject.Inject;

/* compiled from: Proxy Authentication Required */
public class RedSpaceUserSectionAdapter extends RedSpaceUserCollectionAdapter {
    public final RedSpaceFriendsSection f11749a;

    @Inject
    public RedSpaceUserSectionAdapter(String str, Resources resources, LoggedInUserSessionManager loggedInUserSessionManager, RedSpaceFeedProfileUnreadStoriesHelper redSpaceFeedProfileUnreadStoriesHelper, RedSpaceStrings redSpaceStrings, @Assisted FragmentManager fragmentManager, @Assisted RedSpaceFriendsSection redSpaceFriendsSection, @Assisted RedSpaceFriendsCollection redSpaceFriendsCollection, @Assisted int i) {
        super(str, loggedInUserSessionManager, resources, redSpaceFeedProfileUnreadStoriesHelper, redSpaceStrings, fragmentManager, redSpaceFriendsCollection, i);
        this.f11749a = redSpaceFriendsSection;
    }
}
