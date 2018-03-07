package com.facebook.vault.gallery;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.photos.LocalPhoto;
import com.facebook.photos.photogallery.LaunchableGalleryFragment;
import com.facebook.photos.photogallery.PhotoGallery;
import com.facebook.photos.photogallery.PhotoView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.vault.ui.VaultFullScreenGalleryActivity.C01861;
import com.facebook.widget.ViewTransform;

/* compiled from: thumbnail_data */
public class VaultPhotoGalleryFragment extends LaunchableGalleryFragment<LocalPhoto, PhotoView> {
    private View f1708b;
    public C01861 f1709c;

    /* compiled from: thumbnail_data */
    class C01691 implements OnClickListener {
        final /* synthetic */ VaultPhotoGalleryFragment f1707a;

        /* compiled from: thumbnail_data */
        class C01681 implements DialogInterface.OnClickListener {
            final /* synthetic */ C01691 f1706a;

            C01681(C01691 c01691) {
                this.f1706a = c01691;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f1706a.f1707a.f1709c.m2029b(this.f1706a.f1707a.b());
                this.f1706a.f1707a.E.p().d();
                this.f1706a.f1707a.E.p().b();
            }
        }

        C01691(VaultPhotoGalleryFragment vaultPhotoGalleryFragment) {
            this.f1707a = vaultPhotoGalleryFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -583526077);
            Builder builder = new Builder(this.f1707a.getContext());
            builder.a(this.f1707a.b(2131234334));
            builder.b(2131234335);
            builder.a(2131234336, new C01681(this));
            builder.b(2131234337, null);
            builder.a(true);
            builder.a().show();
            Logger.a(2, EntryType.UI_INPUT_END, 2009716946, a);
        }
    }

    public final View m1738a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 114418313);
        if (this.f) {
            View inflate = layoutInflater.inflate(2130907644, viewGroup, false);
            a((PhotoGallery) inflate.findViewById(2131560643));
            this.f1708b = inflate.findViewById(2131560526);
            this.f1708b.setOnClickListener(new C01691(this));
            new ViewTransform(this.f1708b).setAlpha(0.0f);
            ViewPropertyAnimator animate = this.f1708b.animate();
            animate.setDuration(100);
            animate.alpha(1.0f);
            ar();
            LogUtils.f(-1309692735, a);
            return inflate;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2030450077, a);
        return null;
    }

    protected final void aq() {
        ar();
    }

    private void ar() {
        if (this.f1709c.m2028a(b())) {
            this.f1708b.setVisibility(0);
        } else {
            this.f1708b.setVisibility(8);
        }
    }

    public final void m1737I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -855925570);
        super.I();
        this.f1709c = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -773502048, a);
    }
}
