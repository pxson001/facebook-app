package com.facebook.composer.activity;

import com.facebook.composer.targetselection.ComposerTargetInfoProvider;
import com.facebook.composer.targetselection.ComposerTargetSelectionInfo;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.katana.activity.profilelist.FriendSingleSelectorActivity;
import com.facebook.katana.activity.profilelist.GroupSelectorActivity;
import com.google.common.collect.ImmutableList;
import java.util.Collection;

/* compiled from: install_date */
public class DefaultComposerTargetInfoProvider implements ComposerTargetInfoProvider {
    public final Collection<ComposerTargetSelectionInfo> mo186a() {
        return ImmutableList.of(new ComposerTargetSelectionInfo(TargetType.UNDIRECTED, 0, 2131234268, 2130843559, null), new ComposerTargetSelectionInfo(TargetType.USER, 1, 2131234612, 2130843557, FriendSingleSelectorActivity.class), new ComposerTargetSelectionInfo(TargetType.GROUP, 2, 2131234614, 2130843558, GroupSelectorActivity.class));
    }
}
