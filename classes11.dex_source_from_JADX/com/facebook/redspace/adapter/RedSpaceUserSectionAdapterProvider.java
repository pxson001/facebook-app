package com.facebook.redspace.adapter;

import android.support.v4.app.FragmentManager;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.redspace.abtest.RedSpaceStrings;
import com.facebook.redspace.data.RedSpaceFeedProfileUnreadStoriesHelper;
import com.facebook.redspace.data.RedSpaceFriendsCollection;
import com.facebook.redspace.data.RedSpaceFriendsSection;

/* compiled from: Provider was null */
public class RedSpaceUserSectionAdapterProvider extends AbstractAssistedProvider<RedSpaceUserSectionAdapter> {
    public final RedSpaceUserSectionAdapter m12187a(FragmentManager fragmentManager, RedSpaceFriendsSection redSpaceFriendsSection, RedSpaceFriendsCollection redSpaceFriendsCollection, int i) {
        return new RedSpaceUserSectionAdapter(String_LoggedInUserIdMethodAutoProvider.b(this), ResourcesMethodAutoProvider.a(this), LoggedInUserSessionManager.a(this), RedSpaceFeedProfileUnreadStoriesHelper.m12202a((InjectorLike) this), RedSpaceStrings.a(this), fragmentManager, redSpaceFriendsSection, redSpaceFriendsCollection, i);
    }
}
