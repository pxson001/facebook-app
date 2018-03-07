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

/* compiled from: Publish Mode not set. */
public class RedSpaceUserCollectionAdapterProvider extends AbstractAssistedProvider<RedSpaceUserCollectionAdapter> {
    public final RedSpaceUserCollectionAdapter m12174a(FragmentManager fragmentManager, RedSpaceFriendsCollection redSpaceFriendsCollection, int i) {
        return new RedSpaceUserCollectionAdapter(String_LoggedInUserIdMethodAutoProvider.b(this), LoggedInUserSessionManager.a(this), ResourcesMethodAutoProvider.a(this), RedSpaceFeedProfileUnreadStoriesHelper.m12202a((InjectorLike) this), RedSpaceStrings.a(this), fragmentManager, redSpaceFriendsCollection, i);
    }
}
