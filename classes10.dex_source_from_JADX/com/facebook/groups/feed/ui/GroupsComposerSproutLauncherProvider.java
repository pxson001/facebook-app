package com.facebook.groups.feed.ui;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.locale.Locales;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.feed.util.composer.sprout.SproutAnalyticsLogger.SproutSource;
import com.facebook.feed.util.composer.sprout.header.GroupsInlineComposerSproutHeaderControllerProvider;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.FetchGroupInformationModel;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.composer.launch.ComposerLauncher;

/* compiled from: TimelineFirstUnitsSelf */
public class GroupsComposerSproutLauncherProvider extends AbstractAssistedProvider<GroupsComposerSproutLauncher> {
    public final GroupsComposerSproutLauncher m23220a(SproutSource sproutSource, FragmentManager fragmentManager, Activity activity, FetchGroupInformationModel fetchGroupInformationModel) {
        return new GroupsComposerSproutLauncher(ResourcesMethodAutoProvider.a(this), (GroupsInlineComposerSproutHeaderControllerProvider) getOnDemandAssistedProviderForStaticDi(GroupsInlineComposerSproutHeaderControllerProvider.class), (ComposerLauncher) ComposerLauncherImpl.a(this), Locales.a(this), GatekeeperStoreImplMethodAutoProvider.a(this), GroupsInlineComposerActionOptionController.m23349b(this), sproutSource, fragmentManager, activity, fetchGroupInformationModel);
    }
}
