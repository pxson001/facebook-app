package com.facebook.platform.composer.titlebar;

import com.facebook.ipc.composer.model.TargetType;
import com.facebook.katana.activity.profilelist.FriendSingleSelectorActivity;
import com.facebook.katana.activity.profilelist.GroupSelectorActivity;
import com.google.common.collect.ImmutableList;
import java.util.Collection;

/* compiled from: result_list_id */
public class PlatformComposerTargetInfoProvider {
    public static Collection<PlatformComposerTargetSelectionInfo> m4289a() {
        return ImmutableList.of(new PlatformComposerTargetSelectionInfo(TargetType.UNDIRECTED, 0, 2131238371, 2130843559, null), new PlatformComposerTargetSelectionInfo(TargetType.USER, 1, 2131238372, 2130843557, FriendSingleSelectorActivity.class), new PlatformComposerTargetSelectionInfo(TargetType.GROUP, 2, 2131238373, 2130843558, GroupSelectorActivity.class));
    }
}
