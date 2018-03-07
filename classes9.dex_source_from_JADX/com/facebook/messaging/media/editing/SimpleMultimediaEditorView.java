package com.facebook.messaging.media.editing;

import android.content.Context;
import android.support.v7.internal.widget.ViewStubCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.facebook.fbui.widget.text.ImageWithTextView;
import com.facebook.messaging.photos.editing.LayerGroupLayout;
import com.facebook.messaging.photos.editing.PhotoEditingControlsLayout;
import com.facebook.messaging.photos.editing.TextStylesLayout;
import com.facebook.video.player.InlineVideoView;
import com.facebook.widget.ViewStubHolder;
import javax.annotation.Nullable;

/* compiled from: mCurrency */
public class SimpleMultimediaEditorView extends MultimediaEditorView {
    private final ViewStubHolder<ImageView> f11586b;
    private final ViewStubHolder<InlineVideoView> f11587c;
    private final View f11588d;
    private final View f11589e;
    private final LayerGroupLayout f11590f;
    private final PhotoEditingControlsLayout f11591g;
    private final TextStylesLayout f11592h;
    private final ImageWithTextView f11593i;

    public SimpleMultimediaEditorView(Context context) {
        this(context, null);
    }

    public SimpleMultimediaEditorView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SimpleMultimediaEditorView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130905355);
        this.f11586b = ViewStubHolder.a((ViewStubCompat) c(2131564006));
        this.f11587c = ViewStubHolder.a((ViewStubCompat) c(2131564007));
        this.f11588d = c(2131560414);
        this.f11589e = c(2131559325);
        this.f11590f = (LayerGroupLayout) c(2131564008);
        this.f11591g = (PhotoEditingControlsLayout) c(2131565045);
        this.f11592h = (TextStylesLayout) c(2131565047);
        this.f11593i = (ImageWithTextView) c(2131565046);
    }

    public ViewStubHolder<ImageView> getImagePreviewStubHolder() {
        return this.f11586b;
    }

    public ViewStubHolder<InlineVideoView> getVideoPreviewStubHolder() {
        return this.f11587c;
    }

    @Nullable
    public View getCancelButton() {
        return this.f11588d;
    }

    public View getDoneButton() {
        return this.f11589e;
    }

    public LayerGroupLayout getLayers() {
        return this.f11590f;
    }

    public PhotoEditingControlsLayout getPhotoEditingControls() {
        return this.f11591g;
    }

    public TextStylesLayout getTextStyles() {
        return this.f11592h;
    }

    public ImageWithTextView getDeleteLayerButton() {
        return this.f11593i;
    }
}
