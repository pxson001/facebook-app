package com.facebook.groups.fb4a.memberpicker;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.facebook.base.activity.ReactFragmentActivity;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.groups.memberpicker.GroupsAddMemberIntentProvider;
import com.facebook.groups.memberpicker.abtest.ExperimentsForMemberPickerModule;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.widget.friendselector.CaspianFriendSelectorActivity;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: \\> */
public class FB4AGroupsAddMemberIntentProvider implements GroupsAddMemberIntentProvider {
    private final QeAccessor f10212a;
    private final Provider<Boolean> f10213b;
    private final Provider<ComponentName> f10214c;

    public static FB4AGroupsAddMemberIntentProvider m10580b(InjectorLike injectorLike) {
        return new FB4AGroupsAddMemberIntentProvider((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 3967), IdBasedProvider.a(injectorLike, 13));
    }

    @Inject
    public FB4AGroupsAddMemberIntentProvider(QeAccessor qeAccessor, Provider<Boolean> provider, @ReactFragmentActivity Provider<ComponentName> provider2) {
        this.f10212a = qeAccessor;
        this.f10213b = provider;
        this.f10214c = provider2;
    }

    public final Intent m10581a(String str, Context context) {
        return m10582b(str, context);
    }

    public static FB4AGroupsAddMemberIntentProvider m10579a(InjectorLike injectorLike) {
        return m10580b(injectorLike);
    }

    public final Intent m10582b(String str, Context context) {
        if (((Boolean) this.f10213b.get()).booleanValue() && this.f10212a.a(Liveness.Live, ExperimentsForMemberPickerModule.d, false)) {
            Intent intent = new Intent();
            intent.setComponent((ComponentName) this.f10214c.get());
            intent.putExtra("target_fragment", ContentFragmentType.GROUP_MEMBER_PICKER_FRAGMENT.ordinal());
            intent.putExtra("group_feed_id", str);
            return intent;
        }
        Intent intent2 = new Intent(context, CaspianFriendSelectorActivity.class);
        intent2.putExtra("title", 2131239522);
        intent2.putExtra("target_fragment", ContentFragmentType.GROUP_MEMBER_PICKER_FRAGMENT.ordinal());
        intent2.putExtra("non_modal_display", true);
        intent2.putExtra("group_feed_id", str);
        return intent2;
    }
}
