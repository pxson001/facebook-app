package com.facebook.groups.feed.ui;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.bookmark.client.BookmarkClient;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.shortcuts.InstallShortcutHelper;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.config.application.FbAppType;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.groups.fb4a.memberpicker.FB4AGroupsAddMemberIntentProvider;
import com.facebook.groups.feed.ui.GroupsFeedFragment.AnonymousClass15;
import com.facebook.groups.info.GroupInfoIntentBuilder;
import com.facebook.groups.memberpicker.GroupsAddMemberIntentProvider;
import com.facebook.groups.mutations.GroupsClient;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.search.titlebar.GraphSearchIntentLauncher;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.Toaster;

/* compiled from: ThreadViewMessagesFragment.forceUpdateMessageListUI */
public class GroupsPlutoniumHeaderActionBarControllerProvider extends AbstractAssistedProvider<GroupsPlutoniumHeaderActionBarController> {
    public final GroupsPlutoniumHeaderActionBarController m23413a(AnonymousClass15 anonymousClass15) {
        return new GroupsPlutoniumHeaderActionBarController(anonymousClass15, FbUriIntentHandler.a(this), (SecureContextHelper) DefaultSecureContextHelper.a(this), AnalyticsLoggerMethodAutoProvider.a(this), InstallShortcutHelper.a(this), Toaster.a(this), GroupsClient.a(this), IdBasedProvider.a(this, 12), DefaultAndroidThreadUtil.a(this), BookmarkClient.a(this), TasksManager.a(this), (FbAppType) getInstance(FbAppType.class), IdBasedProvider.a(this, 372), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), GraphSearchIntentLauncher.a(this), (GroupsAddMemberIntentProvider) FB4AGroupsAddMemberIntentProvider.a(this), GroupInfoIntentBuilder.m23666a((InjectorLike) this), Boolean_IsWorkBuildMethodAutoProvider.a(this));
    }
}
