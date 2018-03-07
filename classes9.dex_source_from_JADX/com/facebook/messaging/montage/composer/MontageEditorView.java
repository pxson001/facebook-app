package com.facebook.messaging.montage.composer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.messaging.media.editing.SimpleMultimediaEditorView;
import javax.annotation.Nullable;

/* compiled from: is_optional_payment_enabled */
public class MontageEditorView extends SimpleMultimediaEditorView implements MontageComposerCanvas {
    public MontageEditorView(Context context) {
        this(context, null);
    }

    public MontageEditorView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MontageEditorView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        getDoneButton().setVisibility(8);
        View cancelButton = super.getCancelButton();
        if (cancelButton != null) {
            cancelButton.setVisibility(8);
        }
    }

    @Nullable
    public View getCancelButton() {
        return null;
    }

    public final boolean lV_() {
        return false;
    }

    protected final boolean mo490h() {
        return false;
    }

    public final void mo474a(int i, int i2, int i3, int i4) {
        getPhotoEditingControls().setPadding(i, i2, i3, i4);
    }
}
