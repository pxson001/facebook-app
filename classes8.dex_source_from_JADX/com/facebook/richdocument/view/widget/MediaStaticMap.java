package com.facebook.richdocument.view.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.maps.FbStaticMapView;
import com.facebook.richdocument.view.transition.ResizeTransitionStrategy;
import com.facebook.richdocument.view.transition.ViewAttribute.ViewAttributeType;
import com.facebook.richdocument.view.transition.ViewLayout;
import com.facebook.richdocument.view.transition.ViewRect;
import com.facebook.richdocument.view.widget.media.MediaFrame;

/* compiled from: onClickListener */
public class MediaStaticMap extends FbStaticMapView {
    public View f7229d;

    public MediaStaticMap(Context context) {
        super(context);
    }

    public MediaStaticMap(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MediaStaticMap(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setMapPlaceholder(View view) {
        this.f7229d = view;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1774910796);
        super.onAttachedToWindow();
        m7493b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1837678957, a);
    }

    private void m7493b() {
        MediaFrame mediaFrame = (MediaFrame) getParent().getParent();
        ResizeTransitionStrategy transitionStrategy = mediaFrame.getTransitionStrategy();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ImageView) {
                ViewLayout currentLayout = mediaFrame.getCurrentLayout();
                Rect rect = transitionStrategy.f6972b;
                ImageView imageView = (ImageView) childAt;
                LayoutParams layoutParams = (LayoutParams) imageView.getLayoutParams();
                layoutParams.width = rect.width();
                layoutParams.height = rect.height();
                layoutParams.gravity = 16;
                imageView.setLayoutParams(layoutParams);
                LayoutParams layoutParams2 = (LayoutParams) getLayoutParams();
                layoutParams2.height = ((ViewRect) currentLayout.mo428a(this.f7229d, ViewAttributeType.RECT, ViewRect.class)).f7004a.height();
                layoutParams2.gravity = 16;
                setLayoutParams(layoutParams2);
                return;
            }
        }
    }
}
