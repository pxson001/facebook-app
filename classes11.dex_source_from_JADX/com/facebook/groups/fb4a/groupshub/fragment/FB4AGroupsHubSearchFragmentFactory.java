package com.facebook.groups.fb4a.groupshub.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.fbreact.fragment.ImmersiveReactFragment;
import com.facebook.groups.fb4a.react.GroupsReactFragment;
import com.facebook.groups.fb4a.react.GroupsReactFragment.Builder;

/* compiled from: _from_UNREAD_to_READ */
public class FB4AGroupsHubSearchFragmentFactory implements IFragmentFactory {
    public final Fragment m10550a(Intent intent) {
        Builder av = GroupsReactFragment.av();
        ImmersiveReactFragment.Builder newBuilder = ImmersiveReactFragment.newBuilder();
        newBuilder.a = StringFormatUtil.formatStrLocaleSafe("/groups_discovery");
        newBuilder = newBuilder;
        newBuilder.b = "FBGroupsHubSearchRoute";
        av = av.a(newBuilder.a());
        av.a.putBoolean("show_search_bar", true);
        return av.a();
    }
}
