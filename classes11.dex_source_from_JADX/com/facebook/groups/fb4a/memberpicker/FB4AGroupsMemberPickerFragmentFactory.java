package com.facebook.groups.fb4a.memberpicker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.fbreact.fragment.ImmersiveReactFragment;
import com.facebook.groups.fb4a.react.GroupsReactFragment;
import com.facebook.groups.fb4a.react.GroupsReactFragment.Builder;
import com.facebook.groups.memberpicker.MemberPickerFragment;
import com.facebook.groups.memberpicker.abtest.ExperimentsForMemberPickerModule;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: \\< */
public class FB4AGroupsMemberPickerFragmentFactory implements IFragmentFactory {
    private QeAccessor f10215a;
    private final Provider<Boolean> f10216b;

    @Inject
    public FB4AGroupsMemberPickerFragmentFactory(QeAccessor qeAccessor, Provider<Boolean> provider) {
        this.f10215a = qeAccessor;
        this.f10216b = provider;
    }

    public final Fragment m10583a(Intent intent) {
        if (((Boolean) this.f10216b.get()).booleanValue() && this.f10215a.a(Liveness.Live, ExperimentsForMemberPickerModule.d, false)) {
            Bundle bundle = new Bundle();
            bundle.putString("group", intent.getStringExtra("group_feed_id"));
            bundle.putBoolean("disableContactImporter", this.f10215a.a(Liveness.Live, ExperimentsForMemberPickerModule.c, false));
            bundle.putBoolean("disableAnimation", this.f10215a.a(Liveness.Live, ExperimentsForMemberPickerModule.b, false));
            Builder av = GroupsReactFragment.av();
            ImmersiveReactFragment.Builder newBuilder = ImmersiveReactFragment.newBuilder();
            newBuilder.b = "FBGroupsInviteFlowRoute";
            newBuilder = newBuilder;
            newBuilder.a = "/groups_invite_flow";
            newBuilder = newBuilder;
            newBuilder.h = 1;
            newBuilder = newBuilder;
            newBuilder.f = bundle;
            return av.a(newBuilder.a()).a();
        }
        Fragment memberPickerFragment = new MemberPickerFragment();
        memberPickerFragment.g(intent.getExtras());
        return memberPickerFragment;
    }
}
