package com.facebook.places.views;

import android.content.Context;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: caption_description_large_style */
public class PlaceContentView extends ContentView {
    private DraweeHolder<GenericDraweeHierarchy> f18412h;

    public PlaceContentView(Context context) {
        super(context);
        m22346f();
    }

    public PlaceContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m22346f();
    }

    private void m22346f() {
        this.f18412h = DraweeHolder.a(new GenericDraweeHierarchyBuilder(getResources()).u(), getContext());
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Layout titleLayout = getTitleLayout();
        if (titleLayout != null && titleLayout.getEllipsisCount(0) > 0) {
            CharSequence subtitleText = getSubtitleText();
            CharSequence metaText = getMetaText();
            if (!TextUtils.isEmpty(metaText)) {
                if (TextUtils.isEmpty(subtitleText)) {
                    setSubtitleText(metaText.toString());
                } else {
                    setSubtitleText(subtitleText.toString() + " · " + metaText.toString());
                }
                setMetaText("");
            }
            super.onMeasure(i, i2);
        }
    }

    public void setMinutiaeIconController(DraweeController draweeController) {
        this.f18412h.a(draweeController);
        if (getVisibility() == 0) {
            this.f18412h.b();
        }
    }

    public DraweeHolder<GenericDraweeHierarchy> getMinutiaeHolder() {
        return this.f18412h;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1432309138);
        super.onAttachedToWindow();
        this.f18412h.b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1744732199, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1912904000);
        super.onDetachedFromWindow();
        this.f18412h.d();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1788643545, a);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.f18412h.d();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.f18412h.b();
    }
}
