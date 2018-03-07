package com.facebook.groups.info;

import android.support.v4.app.FragmentManager;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.events.protocol.EventGraphQLModelHelper;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.groups.constants.GroupsConstants.GroupMallType;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.FetchGroupInformationModel;
import com.facebook.groups.info.view.DefaultGroupInfoViewManager;
import com.facebook.groups.widget.groupeventrow.GroupEventRsvpViewListener;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncher;
import com.facebook.photos.mediagallery.ui.DefaultMediaGalleryLauncher;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.text.BetterLinkMovementMethod;
import com.facebook.work.groups.multicompany.gk.Boolean_IsWorkMultiCompanyGroupsEnabledGkMethodAutoProvider;

/* compiled from: ThreadListFragment */
public class GroupInfoAdapterProvider extends AbstractAssistedProvider<GroupInfoAdapter> {
    public final GroupInfoAdapter m23628a(BetterListView betterListView, FragmentManager fragmentManager, GroupEventRsvpViewListener groupEventRsvpViewListener, DefaultGroupLeaveActionResponder defaultGroupLeaveActionResponder, GroupMallType groupMallType, FetchGroupInformationModel fetchGroupInformationModel) {
        return new GroupInfoAdapter(betterListView, fragmentManager, groupEventRsvpViewListener, defaultGroupLeaveActionResponder, groupMallType, fetchGroupInformationModel, ResourcesMethodAutoProvider.a(this), (MediaGalleryLauncher) DefaultMediaGalleryLauncher.a(this), EventGraphQLModelHelper.m19271a((InjectorLike) this), DefaultGroupInfoClickHandler.m23585b(this), DefaultGroupInfoViewManager.m24006b(this), BetterLinkMovementMethod.a(this), GatekeeperStoreImplMethodAutoProvider.a(this), Boolean_IsWorkMultiCompanyGroupsEnabledGkMethodAutoProvider.b(this));
    }
}
