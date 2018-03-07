package com.facebook.photos.simplepicker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.ViewStub;
import android.widget.ImageView;
import com.facebook.ipc.media.MediaItem;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.photos.simplepicker.controller.PickerGridItemType;
import javax.annotation.Nullable;

/* compiled from: setAlpha not implemented */
public class PickerGridPhotoItemView extends PickerGridItemView {
    private boolean f3262a;
    public ImageView f3263h;
    public boolean f3264i = false;

    public PickerGridPhotoItemView(Context context) {
        super(context);
    }

    public int getLayoutResourceId() {
        return 2130906236;
    }

    protected void mo166a() {
        ((ImageView) this.f3250b).setImageBitmap(null);
    }

    public final void mo167b() {
        mo178a(null, null);
        mo155e();
        hP_();
    }

    public PickerGridItemType getItemType() {
        return PickerGridItemType.PHOTO;
    }

    public final boolean mo168g() {
        return this.f3262a;
    }

    public final void hP_() {
        this.f3262a = false;
    }

    public void setMediaBitmap(@Nullable Bitmap bitmap) {
        boolean z;
        ImageView imageView = (ImageView) this.f3250b;
        Object obj = (imageView.getDrawable() == null || ((BitmapDrawable) imageView.getDrawable()).getBitmap() == null) ? null : 1;
        if (obj == null && bitmap != null) {
            imageView.startAnimation(this.f3253e);
        }
        imageView.setImageBitmap(bitmap);
        if (bitmap != null) {
            z = true;
        } else {
            z = false;
        }
        this.f3262a = z;
        this.f3251c.setImageDrawable(this.f3255g != null ? this.f3252d : null);
        if (this.f3255g != null && (this.f3255g instanceof PhotoItem)) {
            if (!(this.f3263h == null || ((PhotoItem) this.f3255g).c)) {
                this.f3263h.setVisibility(8);
            }
            if (((PhotoItem) this.f3255g).c && this.f3264i) {
                if (this.f3263h == null) {
                    this.f3263h = (ImageView) ((ViewStub) c(2131565957)).inflate();
                }
                this.f3263h.setVisibility(0);
            }
        }
    }

    public void mo178a(@Nullable MediaItem mediaItem, @Nullable Bitmap bitmap) {
        this.g = mediaItem;
        setMediaBitmap(bitmap);
    }
}
