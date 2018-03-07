package com.facebook.groups.photos.adapter;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.facebook.groups.adapter.AbstractFragmentHolderFragmentPagerAdapter;
import com.facebook.groups.photos.fragment.GroupAlbumsFragment;
import com.facebook.groups.photos.fragment.GroupAllPhotosFragment;
import com.facebook.photos.pandora.common.data.SimplePandoraInstanceId;

/* compiled from: TOXICLE_PUBLIC_GOING_SELECTED_WITH_CHEVRON */
public class GroupsPhotosPagerAdapter extends AbstractFragmentHolderFragmentPagerAdapter {
    private Resources f22996a;
    private String f22997b;
    private String f22998c;

    public GroupsPhotosPagerAdapter(FragmentManager fragmentManager, String str, String str2, Resources resources) {
        super(fragmentManager);
        this.f22997b = str;
        this.f22998c = str2;
        this.f22996a = resources;
    }

    public final Fragment m24215a(int i) {
        Bundle bundle = new Bundle();
        bundle.putString("group_feed_id", this.f22997b);
        bundle.putString("group_name", this.f22998c);
        Fragment groupAllPhotosFragment;
        switch (i) {
            case 0:
                groupAllPhotosFragment = new GroupAllPhotosFragment();
                groupAllPhotosFragment.g(bundle);
                bundle.putParcelable("pandora_instance_id", new SimplePandoraInstanceId(this.f22997b));
                return groupAllPhotosFragment;
            case 1:
                groupAllPhotosFragment = new GroupAlbumsFragment();
                groupAllPhotosFragment.g(bundle);
                return groupAllPhotosFragment;
            default:
                return null;
        }
    }

    public final CharSequence J_(int i) {
        switch (i) {
            case 0:
                return this.f22996a.getString(2131242204);
            case 1:
                return this.f22996a.getString(2131242205);
            default:
                return null;
        }
    }

    public final int m24216b() {
        return 2;
    }
}
