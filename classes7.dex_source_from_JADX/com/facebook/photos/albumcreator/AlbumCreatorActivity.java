package com.facebook.photos.albumcreator;

import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.widget.titlebar.FbTitleBarUtil;

/* compiled from: match_post_composer */
public class AlbumCreatorActivity extends FbFragmentActivity {
    AlbumCreatorFragment f9253p;

    public final void m11287b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130903228);
        FbTitleBarUtil.b(this);
        this.f9253p = m11286i();
    }

    public void onBackPressed() {
        AlbumCreatorFragment albumCreatorFragment = this.f9253p;
        ((AlbumCreatorController) albumCreatorFragment.f9300f.get()).m11292a(albumCreatorFragment.o(), AlbumCreatorFragment.ax(albumCreatorFragment));
        AlbumCreatorFragment.aw(albumCreatorFragment);
        if (null != null) {
            super.onBackPressed();
        }
    }

    public void onUserInteraction() {
        super.onUserInteraction();
        this.f9253p.ax = true;
    }

    private AlbumCreatorFragment m11286i() {
        AlbumCreatorFragment albumCreatorFragment = (AlbumCreatorFragment) kO_().a(2131558429);
        if (albumCreatorFragment != null) {
            return albumCreatorFragment;
        }
        albumCreatorFragment = new AlbumCreatorFragment();
        kO_().a().b(2131558429, albumCreatorFragment).b();
        return albumCreatorFragment;
    }
}
