package com.facebook.facecastdisplay.friendInviter;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.facecastdisplay.LiveFeedbackInputViewContainer.C16395;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.dialogs.FbDialogFragment;
import javax.annotation.Nullable;

/* compiled from: attachment_added */
public class LiveVideoFriendInviterDialog extends FbDialogFragment {
    @Nullable
    public String am;
    @Nullable
    public C16395 an;
    @Nullable
    public String ao;
    public int ap;

    /* compiled from: attachment_added */
    class C16561 implements OnClickListener {
        final /* synthetic */ LiveVideoFriendInviterDialog f19043a;

        C16561(LiveVideoFriendInviterDialog liveVideoFriendInviterDialog) {
            this.f19043a = liveVideoFriendInviterDialog;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 895106414);
            this.f19043a.b();
            Logger.a(2, EntryType.UI_INPUT_END, -30926374, a);
        }
    }

    public final void m22615a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1742568308);
        super.a(bundle);
        a(2, 2131624725);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -277291287, a);
    }

    public final void m22613G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -270536802);
        super.G();
        this.f.getWindow().setSoftInputMode(16);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -317436446, a);
    }

    public final View m22614a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -242632664);
        View inflate = layoutInflater.inflate(2130905099, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -390805900, a);
        return inflate;
    }

    public final void m22616a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        TextView textView = (TextView) e(2131558927);
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("is_show_caspian_style", true);
        bundle2.putBoolean("is_sticky_header_off", true);
        if (69076575 == this.ap) {
            LiveVideoInviteGroupMembersFragment liveVideoInviteGroupMembersFragment = new LiveVideoInviteGroupMembersFragment();
            bundle2.putString("group_feed_id", this.ao);
            liveVideoInviteGroupMembersFragment.g(bundle2);
            liveVideoInviteGroupMembersFragment.ax = this;
            liveVideoInviteGroupMembersFragment.ay = this.am;
            s().a().a(2131563523, liveVideoInviteGroupMembersFragment).b();
            textView.setText(2131232658);
        } else {
            LiveVideoFriendInviterFragment liveVideoFriendInviterFragment = new LiveVideoFriendInviterFragment();
            liveVideoFriendInviterFragment.g(bundle2);
            liveVideoFriendInviterFragment.ay = this;
            liveVideoFriendInviterFragment.az = this.am;
            s().a().a(2131563523, liveVideoFriendInviterFragment).b();
            textView.setText(2131232657);
        }
        OnClickListener c16561 = new C16561(this);
        e(2131560414).setOnClickListener(c16561);
        e(2131563522).setOnClickListener(c16561);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.an != null) {
            this.an.m22452a();
        }
    }
}
