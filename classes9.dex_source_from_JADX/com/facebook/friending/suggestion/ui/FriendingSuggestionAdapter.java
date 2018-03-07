package com.facebook.friending.suggestion.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.fbui.widget.contentview.ContentView.ThumbnailSize;
import com.facebook.friending.common.list.FriendListItemView;
import com.facebook.friending.suggestion.model.FriendingSuggestionItemModel;
import com.facebook.inject.Assisted;
import com.facebook.widget.listview.FbBaseAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: TEXTURE_VIEW_RENDER_TEST1 */
public class FriendingSuggestionAdapter extends FbBaseAdapter {
    private final FriendingSuggestionBinder f24975a;
    public final List<FriendingSuggestionItemModel> f24976b = new ArrayList();
    private OnClickListener f24977c;

    @Inject
    public FriendingSuggestionAdapter(FriendingSuggestionBinder friendingSuggestionBinder, @Assisted OnClickListener onClickListener) {
        this.f24975a = friendingSuggestionBinder;
        this.f24977c = onClickListener;
    }

    public final View m26766a(int i, ViewGroup viewGroup) {
        FriendListItemView friendListItemView = new FriendListItemView(viewGroup.getContext());
        friendListItemView.setThumbnailSize(ThumbnailSize.XLARGE);
        return friendListItemView;
    }

    public final void m26767a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        FriendingSuggestionItemModel friendingSuggestionItemModel = (FriendingSuggestionItemModel) obj;
        FriendListItemView friendListItemView = (FriendListItemView) view;
        this.f24975a.m26770a(friendListItemView, friendingSuggestionItemModel);
        friendListItemView.a.setTag(2131558806, friendingSuggestionItemModel);
        friendListItemView.setActionButtonOnClickListener(this.f24977c);
    }

    public int getCount() {
        return this.f24976b.size();
    }

    public Object getItem(int i) {
        return this.f24976b.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }
}
