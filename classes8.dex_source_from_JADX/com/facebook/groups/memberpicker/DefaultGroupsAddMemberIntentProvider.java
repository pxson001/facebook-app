package com.facebook.groups.memberpicker;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.friendselector.CaspianFriendSelectorActivity;

/* compiled from: extra_album_selected */
public class DefaultGroupsAddMemberIntentProvider implements GroupsAddMemberIntentProvider {
    public static DefaultGroupsAddMemberIntentProvider m16398a(InjectorLike injectorLike) {
        return new DefaultGroupsAddMemberIntentProvider();
    }

    public final Intent mo883a(String str, Context context) {
        return mo884b(str, context);
    }

    public final Intent mo884b(String str, Context context) {
        Intent intent = new Intent(context, CaspianFriendSelectorActivity.class);
        intent.putExtra("title", 2131239522);
        intent.putExtra("target_fragment", ContentFragmentType.GROUP_MEMBER_PICKER_FRAGMENT.ordinal());
        intent.putExtra("group_feed_id", str);
        return intent;
    }
}
