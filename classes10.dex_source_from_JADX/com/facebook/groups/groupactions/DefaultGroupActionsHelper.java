package com.facebook.groups.groupactions;

import android.net.Uri;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.shortcuts.InstallShortcutHelper;
import com.facebook.common.shortcuts.InstallShortcutHelper.IconStyle;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.groups.groupsgrid.mutations.GroupLeaveDialogHelper;
import com.facebook.groups.mutations.GroupsClient;
import com.facebook.groups.settings.GroupSubscriptionController;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: ThreadListFragment.onViewCreatedListenerSetup */
public class DefaultGroupActionsHelper extends AbstractGroupActionsHelper {
    private final Lazy<InstallShortcutHelper> f22564a;

    public static DefaultGroupActionsHelper m23579b(InjectorLike injectorLike) {
        return new DefaultGroupActionsHelper(DefaultAndroidThreadUtil.b(injectorLike), GroupsClient.b(injectorLike), IdBasedLazy.a(injectorLike, 7096), GroupLeaveDialogHelper.b(injectorLike), IdBasedLazy.a(injectorLike, 5162));
    }

    @Inject
    public DefaultGroupActionsHelper(AndroidThreadUtil androidThreadUtil, GroupsClient groupsClient, Lazy<GroupSubscriptionController> lazy, GroupLeaveDialogHelper groupLeaveDialogHelper, Lazy<InstallShortcutHelper> lazy2) {
        super(androidThreadUtil, groupsClient, lazy, groupLeaveDialogHelper);
        this.f22564a = lazy2;
    }

    public final void mo989a(Uri uri, String str, String str2) {
        ((InstallShortcutHelper) this.f22564a.get()).b(StringFormatUtil.formatStrLocaleSafe(FBLinks.u, str), str2, uri, IconStyle.ROUNDED);
    }
}
