package com.facebook.groups.editfavorites;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.groups.editfavorites.fragment.GroupsEditFavoritesFragment;

/* compiled from: admin_can_edit */
public class GroupEditFavoritesFragmentFactory implements IFragmentFactory {
    public final Fragment m10442a(Intent intent) {
        GroupsEditFavoritesFragment groupsEditFavoritesFragment = new GroupsEditFavoritesFragment();
        groupsEditFavoritesFragment.g(intent.getExtras());
        return groupsEditFavoritesFragment;
    }
}
