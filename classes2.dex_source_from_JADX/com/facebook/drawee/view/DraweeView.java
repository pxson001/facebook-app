package com.facebook.drawee.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.facebook.common.internal.Objects;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.AspectRatioMeasure.Spec;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.annotation.Nullable;

/* compiled from: messenger_android_show_user_name_gk */
public class DraweeView<DH extends DraweeHierarchy> extends ImageView {
    private final Spec f14175a = new Spec();
    public float f14176b = 0.0f;
    private DraweeHolder<DH> f14177c;
    private boolean f14178d = false;

    public DraweeView(Context context) {
        super(context);
        m20509a(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20509a(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20509a(context);
    }

    @TargetApi(21)
    public DraweeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m20509a(context);
    }

    private void m20509a(Context context) {
        if (!this.f14178d) {
            this.f14178d = true;
            this.f14177c = DraweeHolder.m20512a(null, context);
            if (VERSION.SDK_INT >= 21) {
                ColorStateList imageTintList = getImageTintList();
                if (imageTintList != null) {
                    setColorFilter(imageTintList.getDefaultColor());
                }
            }
        }
    }

    public void setHierarchy(DH dh) {
        this.f14177c.m20519a((DraweeHierarchy) dh);
        super.setImageDrawable(this.f14177c.m20526h());
    }

    public DH getHierarchy() {
        return this.f14177c.m20525f();
    }

    public final boolean m20510a() {
        return this.f14177c.f14185e != null;
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        return this.f14177c.m20526h();
    }

    public void setController(@Nullable DraweeController draweeController) {
        this.f14177c.mo3378a(draweeController);
        super.setImageDrawable(this.f14177c.m20526h());
    }

    @Nullable
    public DraweeController getController() {
        return this.f14177c.f14186f;
    }

    public final boolean m20511b() {
        return this.f14177c.f14186f != null;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 930797655);
        super.onAttachedToWindow();
        this.f14177c.m20522b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -913680866, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1346235683);
        super.onDetachedFromWindow();
        this.f14177c.m20523d();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1658255030, a);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.f14177c.m20523d();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.f14177c.m20522b();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -2129966317);
        if (this.f14177c.m20521a(motionEvent)) {
            Logger.a(2, EntryType.UI_INPUT_END, -1852445464, a);
            return true;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        LogUtils.a(1964668756, a);
        return onTouchEvent;
    }

    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        m20509a(getContext());
        this.f14177c.mo3378a(null);
        super.setImageDrawable(drawable);
    }

    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        m20509a(getContext());
        this.f14177c.mo3378a(null);
        super.setImageBitmap(bitmap);
    }

    @Deprecated
    public void setImageResource(int i) {
        m20509a(getContext());
        this.f14177c.mo3378a(null);
        super.setImageResource(i);
    }

    @Deprecated
    public void setImageURI(Uri uri) {
        m20509a(getContext());
        this.f14177c.mo3378a(null);
        super.setImageURI(uri);
    }

    public void setAspectRatio(float f) {
        if (f != this.f14176b) {
            this.f14176b = f;
            requestLayout();
        }
    }

    public float getAspectRatio() {
        return this.f14176b;
    }

    protected void onMeasure(int i, int i2) {
        this.f14175a.f14179a = i;
        this.f14175a.f14180b = i2;
        AspectRatioMeasure.m20534a(this.f14175a, this.f14176b, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        super.onMeasure(this.f14175a.f14179a, this.f14175a.f14180b);
    }

    public String toString() {
        return Objects.m20537a((Object) this).m20544a("holder", this.f14177c != null ? this.f14177c.toString() : "<no holder set>").toString();
    }
}
