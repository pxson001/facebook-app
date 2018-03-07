package com.facebook.groups.photos;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.groups.photos.fragment.GroupPhotosViewPagerContainerFragment;

/* compiled from: TOXICLE_PUBLIC_INTERESTED_OVERFLOW */
public class GroupsPhotosFragmentFactory implements IFragmentFactory {
    public final Fragment m24209a(Intent intent) {
        GroupPhotosViewPagerContainerFragment groupPhotosViewPagerContainerFragment = new GroupPhotosViewPagerContainerFragment();
        groupPhotosViewPagerContainerFragment.g(intent.getExtras());
        return groupPhotosViewPagerContainerFragment;
    }
}
