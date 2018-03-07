package com.facebook.photos.simplepicker.view;

import android.content.Context;
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

/* compiled from: setComposerConfiguration */
public class PickerGridGifItemDraweeView extends PickerGridPhotoItemDraweeView {
    @Inject
    public QeAccessor f3247a;
    private View f3248c;

    public static void m3209a(Object obj, Context context) {
        ((PickerGridGifItemDraweeView) obj).f3247a = (QeAccessor) QeInternalImplMethodAutoProvider.a(FbInjector.get(context));
    }

    public PickerGridGifItemDraweeView(Context context) {
        super(context);
        Class cls = PickerGridGifItemDraweeView.class;
        m3209a(this, getContext());
    }

    protected final void mo162a() {
        if (this.f3247a.a(ExperimentsForAnimatedGifAbTestModule.a, false)) {
            m3210g();
        }
        super.mo162a();
    }

    protected final void mo165b() {
        m3210g();
        super.mo165b();
    }

    public PickerGridItemType getItemType() {
        return PickerGridItemType.GIF;
    }

    private void m3210g() {
        if (this.f3248c == null) {
            ViewGroup frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new LayoutParams(-2, -2, 17));
            this.f3248c = LayoutInflater.from(getContext()).inflate(2130904591, frameLayout, true);
            addView(this.f3248c);
        }
        this.f3248c.setVisibility(0);
    }
}
