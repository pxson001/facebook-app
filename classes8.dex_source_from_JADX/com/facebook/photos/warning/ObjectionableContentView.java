package com.facebook.photos.warning;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.attachments.photos.ui.PhotoAttachmentView;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;

/* compiled from: select-slide */
public class ObjectionableContentView extends CustomFrameLayout {
    public final ObjectionableContentWarningView f3516a;
    public final PhotoAttachmentView f3517b;
    public final View f3518c;

    /* compiled from: select-slide */
    public class State {
        public final DraweeController f3514a;
        public final int f3515b;

        public State(DraweeController draweeController, int i) {
            this.f3514a = draweeController;
            this.f3515b = i;
        }
    }

    public ObjectionableContentView(Context context) {
        this(context, null);
    }

    public ObjectionableContentView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ObjectionableContentView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130905522);
        this.f3516a = (ObjectionableContentWarningView) c(2131564311);
        this.f3517b = (PhotoAttachmentView) c(2131564312);
        this.f3518c = c(2131564313);
    }

    public PhotoAttachmentView getPhotoAttachmentView() {
        return this.f3517b;
    }

    public ObjectionableContentWarningView getWarningView() {
        return this.f3516a;
    }

    public View getLowFidelityBackgroundView() {
        return this.f3518c;
    }
}
