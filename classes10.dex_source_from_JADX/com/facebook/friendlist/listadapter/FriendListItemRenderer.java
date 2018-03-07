package com.facebook.friendlist.listadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.fbui.widget.contentview.ContentView.ThumbnailSize;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.friendlist.constants.FriendListSource;
import com.facebook.friendlist.constants.FriendListType;
import com.facebook.friendlist.data.FriendPageListItemModel;
import com.facebook.inject.Assisted;
import com.facebook.widget.compositeadapter.stickyheader.StickyHeaderCompositeAdapter.StickyHeaderRenderer;
import javax.inject.Inject;

/* compiled from: action_list */
public class FriendListItemRenderer implements StickyHeaderRenderer {
    private final Context f20383a;
    private final ProfileFriendListBinder f20384b;

    @Inject
    public FriendListItemRenderer(@Assisted Context context, @Assisted FriendListType friendListType, @Assisted FriendListSource friendListSource, ProfileFriendListBinderProvider profileFriendListBinderProvider) {
        this.f20383a = context;
        this.f20384b = new ProfileFriendListBinder(String_LoggedInUserIdMethodAutoProvider.b(profileFriendListBinderProvider), context, friendListType, friendListSource, (ActionButtonsControllerProvider) profileFriendListBinderProvider.getOnDemandAssistedProviderForStaticDi(ActionButtonsControllerProvider.class), AllCapsTransformationMethod.b(profileFriendListBinderProvider));
    }

    public final View m20650a(int i, ViewGroup viewGroup) {
        switch ((FriendListItemTypes) FriendListItemTypes.VALUES.get(i)) {
            case HEADER:
                return LayoutInflater.from(this.f20383a).inflate(2130906436, viewGroup, false);
            case FRIEND:
                View profileFriendListItemView = new ProfileFriendListItemView(this.f20383a);
                profileFriendListItemView.setThumbnailSize(ThumbnailSize.XLARGE);
                profileFriendListItemView.setBackgroundResource(2130839798);
                profileFriendListItemView.setId(2131558478);
                return profileFriendListItemView;
            default:
                return null;
        }
    }

    public final void m20651a(Object obj, View view, int i, ViewGroup viewGroup) {
        switch ((FriendListItemTypes) FriendListItemTypes.VALUES.get(i)) {
            case HEADER:
                ((TextView) view).setText((String) obj);
                return;
            case FRIEND:
                this.f20384b.m20669a((ProfileFriendListItemView) view, (FriendPageListItemModel) obj);
                return;
            default:
                return;
        }
    }

    public final int m20649a() {
        return (int) this.f20383a.getResources().getDimension(2131434229);
    }

    public final int m20652b() {
        return this.f20383a.getResources().getColor(2131361993);
    }
}
