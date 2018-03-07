package com.facebook.photos.simplepicker.view;

import android.content.Context;
import android.view.ViewStub;
import android.widget.ImageView;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.photos.simplepicker.controller.PickerGridItemType;
import javax.annotation.Nullable;

/* compiled from: setImageForideConversation */
public class PickerGridPhotoItemDraweeView extends PickerGridItemDraweeView {
    public ImageView f3245a;
    public boolean f3246c = false;

    public PickerGridPhotoItemDraweeView(Context context) {
        super(context);
    }

    public PickerGridPhotoItemDraweeView(Context context, @Nullable byte b) {
        super(context, null);
    }

    public int getLayoutResourceId() {
        return 2130906233;
    }

    public PickerGridItemType getItemType() {
        return PickerGridItemType.PHOTO;
    }

    protected void mo162a() {
        super.mo162a();
        if (this.f3237b != null && (this.f3237b instanceof PhotoItem)) {
            if (!(this.f3245a == null || ((PhotoItem) this.f3237b).c)) {
                this.f3245a.setVisibility(8);
            }
            if (((PhotoItem) this.f3237b).c && this.f3246c) {
                if (this.f3245a == null) {
                    this.f3245a = (ImageView) ((ViewStub) c(2131565957)).inflate();
                }
                this.f3245a.setVisibility(0);
            }
        }
    }
}
