package com.facebook.ufiservices.ui;

import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.api.feed.data.AppendOnlyGraphQLObjectCollection;
import com.facebook.ufiservices.flyout.views.FlyoutLikerView;
import com.facebook.ufiservices.flyout.views.FlyoutLikerViewGraphQLInterfaces.FlyoutLikerViewGraphQL;
import com.facebook.ufiservices.ui.ProfileListFriendingControllerGraphQLInterfaces.ProfileListFriendingControllerGraphQL;
import com.facebook.widget.listview.FbBaseAdapter;

/* compiled from: curation_mechanism */
public class ProfileListAdapter<T extends FlyoutLikerViewGraphQL> extends FbBaseAdapter {
    private AppendOnlyGraphQLObjectCollection<T> f18253a;

    public ProfileListAdapter(AppendOnlyGraphQLObjectCollection<T> appendOnlyGraphQLObjectCollection) {
        this.f18253a = appendOnlyGraphQLObjectCollection;
    }

    public int getCount() {
        return this.f18253a.c();
    }

    public Object getItem(int i) {
        return this.f18253a.a(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public final View m26783a(int i, ViewGroup viewGroup) {
        return new FlyoutLikerView(viewGroup.getContext());
    }

    public final void m26784a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        int indexOf;
        boolean z;
        FlyoutLikerViewGraphQL flyoutLikerViewGraphQL = (FlyoutLikerViewGraphQL) obj;
        FlyoutLikerView flyoutLikerView = (FlyoutLikerView) view;
        AppendOnlyGraphQLObjectCollection appendOnlyGraphQLObjectCollection = this.f18253a;
        if (appendOnlyGraphQLObjectCollection.b.contains(appendOnlyGraphQLObjectCollection.a.apply(flyoutLikerViewGraphQL))) {
            indexOf = appendOnlyGraphQLObjectCollection.c.indexOf(flyoutLikerViewGraphQL);
        } else {
            indexOf = -1;
        }
        if (indexOf == 0) {
            z = true;
        } else {
            z = false;
        }
        flyoutLikerView.f18199j = z;
        FlyoutLikerView flyoutLikerView2 = (FlyoutLikerView) view;
        ProfileListFriendingControllerGraphQL profileListFriendingControllerGraphQL = (FlyoutLikerViewGraphQL) obj;
        if (profileListFriendingControllerGraphQL == null) {
            flyoutLikerView2.f18200k.a("FeedFlyoutLikesAdapter", "profile cannot be null");
            return;
        }
        flyoutLikerView2.f18191b.setVisibility(flyoutLikerView2.f18199j ? 8 : 0);
        flyoutLikerView2.f18195f.setVisibility(8);
        if (profileListFriendingControllerGraphQL.k() == null || profileListFriendingControllerGraphQL.k().mo1385b() == null) {
            flyoutLikerView2.f18192c.a(null, FlyoutLikerView.f18190a);
        } else {
            flyoutLikerView2.f18192c.a(Uri.parse(profileListFriendingControllerGraphQL.k().mo1385b()), FlyoutLikerView.f18190a);
        }
        flyoutLikerView2.f18193d.setText(profileListFriendingControllerGraphQL.C_());
        flyoutLikerView2.f18198i.m26795a(profileListFriendingControllerGraphQL);
    }
}
