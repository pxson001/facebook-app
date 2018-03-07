package com.facebook.photos.simplepicker.view;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.util.AttributeSet;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.ipc.media.MediaItem;
import com.facebook.photos.simplepicker.SimplePickerFragment.C03817;
import com.facebook.widget.CustomFrameLayout;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

/* compiled from: setMediaItems */
public abstract class PickerGridItemDraweeView extends CustomFrameLayout implements SelectableView {
    private static final AtomicInteger f3235c = new AtomicInteger(0);
    public int f3236a;
    @Nullable
    public MediaItem f3237b;
    private int f3238d;
    private ImageView f3239e;
    private TextView f3240f;
    public int f3241g;
    private int f3242h;
    private boolean f3243i;
    private C03817 f3244j;

    /* compiled from: setMediaItems */
    final class ImageLoadListener extends BaseControllerListener {
        final /* synthetic */ PickerGridItemDraweeView f3267a;

        public ImageLoadListener(PickerGridItemDraweeView pickerGridItemDraweeView) {
            this.f3267a = pickerGridItemDraweeView;
        }

        public final void m3229a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            this.f3267a.mo162a();
        }

        public final void m3230b(String str, Throwable th) {
            this.f3267a.mo165b();
        }

        public final void m3228a(String str, Object obj) {
            this.f3267a.f3236a = 0;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: setMediaItems */
    public @interface ImageState {
    }

    public PickerGridItemDraweeView(Context context) {
        this(context, null);
    }

    public PickerGridItemDraweeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3236a = 0;
        m3201g();
    }

    private void m3201g() {
        this.f3238d = f3235c.getAndIncrement();
        setContentView(getLayoutResourceId());
        this.f3243i = true;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i);
    }

    public int getId() {
        return this.f3238d;
    }

    public int getIndex() {
        return this.f3241g;
    }

    @Nullable
    public MediaItem getMediaItem() {
        return this.f3237b;
    }

    public int getSelectedOrder() {
        return this.f3242h;
    }

    public final void mo154a(int i, boolean z) {
        if (this.f3239e == null) {
            this.f3239e = (ImageView) ((ViewStub) c(2131565955)).inflate();
        }
        this.f3239e.setBackgroundResource(z ? 2130843324 : 2130843392);
        this.f3239e.setVisibility(0);
        this.f3242h = i;
        if (z) {
            if (this.f3240f == null) {
                this.f3240f = (TextView) ((ViewStub) c(2131565956)).inflate();
            } else {
                this.f3240f.setVisibility(0);
            }
            this.f3240f.setText(String.valueOf(i));
        }
    }

    public final void mo155e() {
        if (this.f3239e != null) {
            this.f3239e.setVisibility(4);
        }
        if (this.f3240f != null) {
            this.f3240f.setVisibility(4);
        }
        this.f3242h = 0;
    }

    public boolean isSelected() {
        return this.f3242h > 0;
    }

    public final boolean mo156f() {
        return getController() != null && this.f3236a == 1 && this.f3243i;
    }

    public void setViewEnabled(boolean z) {
        this.f3243i = z;
        setAlpha(this.f3243i ? 1.0f : 0.2f);
    }

    protected void mo165b() {
        this.f3236a = 2;
    }

    protected void mo162a() {
        this.f3236a = 1;
        if (this.f3244j != null) {
            this.f3244j.m2977a(this.f3237b, true);
        }
    }

    public void setController(@Nullable AbstractDraweeController abstractDraweeController) {
        m3204a(abstractDraweeController, null);
    }

    public final void m3204a(@Nullable AbstractDraweeController abstractDraweeController, C03817 c03817) {
        if (abstractDraweeController != null) {
            abstractDraweeController.a(new ImageLoadListener(this));
            this.f3244j = c03817;
        }
        ((FbDraweeView) c(2131559119)).setController(abstractDraweeController);
    }

    public DraweeController getController() {
        return ((FbDraweeView) c(2131559119)).getController();
    }
}
