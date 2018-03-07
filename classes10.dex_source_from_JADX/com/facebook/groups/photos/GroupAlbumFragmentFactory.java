package com.facebook.groups.photos;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.groups.photos.fragment.GroupAlbumPandoraFragment;

/* compiled from: TOXICLE_PUBLIC_INTERESTED_SELECTED */
public class GroupAlbumFragmentFactory implements IFragmentFactory {
    public final Fragment m24208a(Intent intent) {
        GroupAlbumPandoraFragment groupAlbumPandoraFragment = new GroupAlbumPandoraFragment();
        groupAlbumPandoraFragment.g(intent.getExtras());
        return groupAlbumPandoraFragment;
    }
}
