package com.facebook.photos.simplepicker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.gif.abtest.ExperimentsForAnimatedGifAbTestModule;
import com.facebook.inject.FbInjector;
import com.facebook.photos.simplepicker.controller.PickerGridItemType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: setActionWhenDone */
public class PickerGridGifItemView extends PickerGridPhotoItemView {
    @Inject
    public QeAccessor f3265a;
    private View f3266h;

    public static void m3225a(Object obj, Context context) {
        ((PickerGridGifItemView) obj).f3265a = (QeAccessor) QeInternalImplMethodAutoProvider.a(FbInjector.get(context));
    }

    public PickerGridGifItemView(Context context) {
        super(context);
    }

    public void setMediaBitmap(Bitmap bitmap) {
        super.setMediaBitmap(bitmap);
        Class cls = PickerGridGifItemView.class;
        m3225a(this, getContext());
        if (this.f3265a.a(ExperimentsForAnimatedGifAbTestModule.a, false)) {
            m3226j();
        }
    }

    protected final void mo166a() {
        super.mo166a();
        m3226j();
    }

    public PickerGridItemType getItemType() {
        return PickerGridItemType.GIF;
    }

    private void m3226j() {
        if (this.f3266h == null) {
            ViewGroup frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new LayoutParams(-2, -2, 17));
            this.f3266h = LayoutInflater.from(getContext()).inflate(2130904591, frameLayout, true);
            addView(this.f3266h);
        }
        this.f3266h.setVisibility(0);
    }
}
