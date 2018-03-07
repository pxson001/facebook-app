package com.facebook.friending.newuserpromotion.friendrequests;

import android.content.res.Resources;
import android.net.Uri;
import android.view.View.OnClickListener;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.friending.common.list.FriendRequestItemView;
import com.facebook.friends.model.FriendRequest;
import com.facebook.friends.model.FriendRequestState;
import javax.inject.Inject;

/* compiled from: field_name */
public class NewUserFriendRequestsBinder {
    private final AllCapsTransformationMethod f13376a;
    public final Resources f13377b;

    /* compiled from: field_name */
    public /* synthetic */ class C14221 {
        public static final /* synthetic */ int[] f13375a = new int[FriendRequestState.values().length];

        static {
            try {
                f13375a[FriendRequestState.NEEDS_RESPONSE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f13375a[FriendRequestState.ACCEPTED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f13375a[FriendRequestState.REJECTED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    @Inject
    public NewUserFriendRequestsBinder(AllCapsTransformationMethod allCapsTransformationMethod, Resources resources) {
        this.f13376a = allCapsTransformationMethod;
        this.f13377b = resources;
    }

    public final void m15013a(FriendRequestItemView friendRequestItemView, FriendRequest friendRequest, OnClickListener onClickListener, OnClickListener onClickListener2) {
        int i;
        Object d = friendRequest.d();
        friendRequestItemView.setThumbnailUri(StringUtil.a(d) ? null : Uri.parse(d));
        friendRequestItemView.setTitleText(friendRequest.b());
        CharSequence charSequence = "";
        if (friendRequest.j == FriendRequestState.ACCEPTED) {
            charSequence = this.f13377b.getString(2131233222);
        } else if (friendRequest.j == FriendRequestState.REJECTED) {
            charSequence = this.f13377b.getString(2131233223);
        }
        if (StringUtil.a(charSequence)) {
            charSequence = friendRequest.h();
        }
        friendRequestItemView.setSubtitleText(charSequence);
        m15012b(friendRequestItemView, friendRequest, onClickListener, onClickListener2);
        switch (C14221.f13375a[friendRequest.j.ordinal()]) {
            case 2:
                i = 2131363701;
                break;
            case 3:
                i = 2131363702;
                break;
            default:
                if (!friendRequest.h) {
                    i = 2130840432;
                    break;
                } else {
                    i = 2131361871;
                    break;
                }
        }
        friendRequestItemView.setBackgroundResource(i);
        friendRequestItemView.setContentDescription(StringFormatUtil.a("%s %s", new Object[]{friendRequestItemView.getTitleText(), friendRequestItemView.getSubtitleText()}));
    }

    private void m15012b(FriendRequestItemView friendRequestItemView, FriendRequest friendRequest, OnClickListener onClickListener, OnClickListener onClickListener2) {
        switch (C14221.f13375a[friendRequest.j.ordinal()]) {
            case 1:
                friendRequestItemView.setFriendRequestButtonsVisible(true);
                friendRequestItemView.m14781a(m15011a(this.f13377b.getString(2131233218)), null);
                friendRequestItemView.setPositiveButtonOnClickListener(onClickListener);
                friendRequestItemView.setNegativeButtonText(m15011a(this.f13377b.getString(2131233217)));
                friendRequestItemView.setNegativeButtonOnClickListener(onClickListener2);
                return;
            default:
                friendRequestItemView.setFriendRequestButtonsVisible(false);
                return;
        }
    }

    private CharSequence m15011a(CharSequence charSequence) {
        return this.f13376a.getTransformation(charSequence, null);
    }
}
