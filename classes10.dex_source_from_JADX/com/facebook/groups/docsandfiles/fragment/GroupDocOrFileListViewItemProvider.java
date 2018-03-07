package com.facebook.groups.docsandfiles.fragment;

import android.content.Context;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.dateformatter.EventsDashboardTimeFormatUtil;
import com.facebook.groups.docsandfiles.intent.GroupDocsAndFilesDefaultPermalinkIntentFactory;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.ipc.feed.ViewPermalinkIntentFactory;

/* compiled from: Upload */
public class GroupDocOrFileListViewItemProvider extends AbstractAssistedProvider<GroupDocOrFileListViewItem> {
    public final GroupDocOrFileListViewItem m22349a(Context context, GroupDocsAndFilesFragment groupDocsAndFilesFragment) {
        return new GroupDocOrFileListViewItem(context, groupDocsAndFilesFragment, ResourcesMethodAutoProvider.a(this), EventsDashboardTimeFormatUtil.a(this), (SecureContextHelper) DefaultSecureContextHelper.a(this), new GroupDocsAndFilesDefaultPermalinkIntentFactory(ViewPermalinkIntentFactory.a(this)), IdBasedProvider.a(this, 11752), IdBasedSingletonScopeProvider.b(this, 2128));
    }
}
