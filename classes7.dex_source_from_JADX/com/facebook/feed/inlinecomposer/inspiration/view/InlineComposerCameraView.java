package com.facebook.feed.inlinecomposer.inspiration.view;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.optic.CameraPreviewView;
import com.facebook.photos.creativeediting.swipeable.composer.CreativeEditingSwipeableLayout;
import com.facebook.widget.SquareFrameLayout;
import javax.annotation.Nullable;

/* compiled from: android_newsfeed_refresh_events_1_29 */
public class InlineComposerCameraView extends SquareFrameLayout {
    public final CameraPreviewView f19240a;
    public final CreativeEditingSwipeableLayout f19241b;

    public InlineComposerCameraView(Context context) {
        this(context, null);
    }

    public InlineComposerCameraView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InlineComposerCameraView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130904309);
        this.f19240a = (CameraPreviewView) c(2131560152);
        this.f19241b = (CreativeEditingSwipeableLayout) c(2131561936);
    }

    public CameraPreviewView getCameraPreview() {
        return this.f19240a;
    }

    public CreativeEditingSwipeableLayout getSwipeableLayout() {
        return this.f19241b;
    }
}
