package com.facebook.vault.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.base.activity.FbRootViewUtil;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.base.photos.VaultPhoto;
import com.facebook.photos.grid.UrlImageGridAdapterImmutablePhotoSource;
import com.facebook.photos.photogallery.PhotoViewFactory;
import com.facebook.vault.gallery.VaultPhotoGalleryFragment;
import java.util.ArrayList;

/* compiled from: text/vnd.wap.wta-event */
public class VaultFullScreenGalleryActivity extends FbFragmentActivity {
    private UrlImageGridAdapterImmutablePhotoSource f1988p;
    private long f1989q;
    public ArrayList<VaultPhoto> f1990r;
    private VaultPhotoGalleryFragment f1991s;
    private final C01861 f1992t = new C01861(this);

    /* compiled from: text/vnd.wap.wta-event */
    public class C01861 {
        final /* synthetic */ VaultFullScreenGalleryActivity f1987a;

        C01861(VaultFullScreenGalleryActivity vaultFullScreenGalleryActivity) {
            this.f1987a = vaultFullScreenGalleryActivity;
        }

        public final boolean m2028a(int i) {
            return ((VaultPhoto) this.f1987a.f1990r.get(i)).a != 0;
        }

        public final void m2029b(int i) {
            VaultPhoto vaultPhoto = (VaultPhoto) this.f1987a.f1990r.get(i);
            Intent intent = new Intent();
            intent.putExtra("onResultPhotoObjectParam", vaultPhoto);
            this.f1987a.setResult(-1, intent);
            this.f1987a.finish();
        }
    }

    protected final void m2032b(Bundle bundle) {
        super.b(bundle);
        this.f1989q = getIntent().getLongExtra("selectedPhotoIdParam", 0);
        this.f1990r = getIntent().getParcelableArrayListExtra("photoObjectsParam");
        m2031i();
    }

    private void m2031i() {
        if (this.f1991s == null || !(this.f1991s.hn_() || this.f1991s.A)) {
            FragmentManager kO_ = kO_();
            this.f1991s = new VaultPhotoGalleryFragment();
            this.f1988p = new UrlImageGridAdapterImmutablePhotoSource(this.f1990r);
            UrlImageGridAdapterImmutablePhotoSource urlImageGridAdapterImmutablePhotoSource = this.f1988p;
            long j = this.f1989q;
            int i = 0;
            while (i < urlImageGridAdapterImmutablePhotoSource.a.size()) {
                if (((VaultPhoto) urlImageGridAdapterImmutablePhotoSource.a.get(i)).a == j) {
                    break;
                }
                i++;
            }
            i = -1;
            int i2 = i;
            VaultPhotoGalleryFragment vaultPhotoGalleryFragment = this.f1991s;
            UrlImageGridAdapterImmutablePhotoSource urlImageGridAdapterImmutablePhotoSource2 = this.f1988p;
            PhotoViewFactory photoViewFactory = new PhotoViewFactory();
            FullscreenGallerySource fullscreenGallerySource = FullscreenGallerySource.TIMELINE_PHOTOS_SYNCED;
            vaultPhotoGalleryFragment.b = i2;
            vaultPhotoGalleryFragment.c = urlImageGridAdapterImmutablePhotoSource2;
            vaultPhotoGalleryFragment.d = photoViewFactory;
            vaultPhotoGalleryFragment.f = true;
            vaultPhotoGalleryFragment.e = fullscreenGallerySource;
            vaultPhotoGalleryFragment.am = -1;
            this.f1991s.f1709c = this.f1992t;
            kO_.a().b(FbRootViewUtil.b(this), this.f1991s, VaultPhotoGalleryFragment.class.getSimpleName()).c();
            kO_.b();
        }
    }
}
