package com.facebook.friending.suggestion.ui;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.friending.common.list.FriendListItemView;
import com.facebook.friending.suggestion.model.FriendingSuggestionItemModel;
import javax.inject.Inject;

/* compiled from: TEXTURE */
public class FriendingSuggestionBinder {
    public final Resources f24978a;

    @Inject
    public FriendingSuggestionBinder(Context context) {
        this.f24978a = context.getResources();
    }

    public final void m26770a(FriendListItemView friendListItemView, FriendingSuggestionItemModel friendingSuggestionItemModel) {
        friendListItemView.setThumbnailUri(friendingSuggestionItemModel.m26715d());
        friendListItemView.setTitleText(friendingSuggestionItemModel.m26714b());
        m26769a(friendListItemView);
        if (friendingSuggestionItemModel.f24958e) {
            friendListItemView.setSubtitleText(2131241370);
            friendListItemView.a.setVisibility(8);
            return;
        }
        String quantityString;
        int e = friendingSuggestionItemModel.m26716e();
        if (e > 0) {
            quantityString = this.f24978a.getQuantityString(2131689520, e, new Object[]{Integer.valueOf(e)});
        } else {
            quantityString = "";
        }
        friendListItemView.setSubtitleText(quantityString);
        friendListItemView.a.setVisibility(0);
    }

    private void m26769a(FriendListItemView friendListItemView) {
        friendListItemView.a(m26768a(2131241368), m26768a(2131241369));
    }

    private String m26768a(int i) {
        return this.f24978a.getString(i).toUpperCase(this.f24978a.getConfiguration().locale);
    }
}
