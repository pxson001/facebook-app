package com.facebook.facecastdisplay.friendInviter;

import android.content.Context;
import android.os.Bundle;
import com.facebook.groups.members.GroupsMembersSelectorFragment;
import com.facebook.inject.FbInjector;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: at least 20 */
public class LiveVideoInviteGroupMembersFragment extends GroupsMembersSelectorFragment {
    @Inject
    public LiveVideoInviteHelper aw;
    @Nullable
    public LiveVideoFriendInviterDialog ax;
    @Nullable
    public String ay;

    public static void m22628a(Object obj, Context context) {
        ((LiveVideoInviteGroupMembersFragment) obj).aw = LiveVideoInviteHelper.m22630b(FbInjector.get(context));
    }

    public final void mo321c(Bundle bundle) {
        super.mo321c(bundle);
        Class cls = LiveVideoInviteGroupMembersFragment.class;
        m22628a(this, getContext());
    }

    protected final void aH() {
        this.aw.m22631a(this.ay, ax());
        if (this.ax != null) {
            this.ax.a();
        }
    }
}
