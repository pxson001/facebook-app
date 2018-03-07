package com.facebook.friending.newuserpromotion.pymk;

import android.content.res.Resources;
import android.view.View.OnClickListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.friending.common.list.FriendListItemView;
import com.facebook.friends.model.PersonYouMayKnow;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: fetching suggestions members failed */
public class NewUserPYMKBinder {
    public final Resources f13387a;

    public static NewUserPYMKBinder m15017b(InjectorLike injectorLike) {
        return new NewUserPYMKBinder(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public NewUserPYMKBinder(Resources resources) {
        this.f13387a = resources;
    }

    public final void m15019a(FriendListItemView friendListItemView, PersonYouMayKnow personYouMayKnow, OnClickListener onClickListener) {
        friendListItemView.setThumbnailUri(personYouMayKnow.d());
        friendListItemView.setTitleText(personYouMayKnow.b());
        CharSequence charSequence = "";
        if (personYouMayKnow.f() == GraphQLFriendshipStatus.OUTGOING_REQUEST) {
            charSequence = this.f13387a.getString(2131233219);
        } else if (personYouMayKnow.f() == GraphQLFriendshipStatus.CAN_REQUEST && personYouMayKnow.f == GraphQLFriendshipStatus.OUTGOING_REQUEST) {
            charSequence = this.f13387a.getString(2131233220);
        } else {
            int e = personYouMayKnow.e();
            if (e > 0) {
                charSequence = this.f13387a.getQuantityString(2131689520, e, new Object[]{Integer.valueOf(e)});
            }
        }
        friendListItemView.setSubtitleText(charSequence);
        m15018b(friendListItemView, personYouMayKnow, onClickListener);
        friendListItemView.setContentDescription(StringFormatUtil.a("%s %s", new Object[]{friendListItemView.getTitleText(), friendListItemView.getSubtitleText()}));
    }

    private void m15018b(FriendListItemView friendListItemView, PersonYouMayKnow personYouMayKnow, OnClickListener onClickListener) {
        String str = "";
        friendListItemView.setActionButtonOnClickListener(onClickListener);
        if (personYouMayKnow.f() == GraphQLFriendshipStatus.CAN_REQUEST) {
            str = this.f13387a.getString(2131233212);
        } else if (personYouMayKnow.f() == GraphQLFriendshipStatus.OUTGOING_REQUEST) {
            str = this.f13387a.getString(2131230727);
        }
        friendListItemView.setActionButtonText(str.toUpperCase(this.f13387a.getConfiguration().locale));
    }
}
