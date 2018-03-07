package com.facebook.photos.warning;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.attachments.angora.GenericAttachmentView;
import com.facebook.multirow.api.ViewType;
import javax.annotation.Nullable;

/* compiled from: select_from_cta_list */
public class ObjectionableContentAttachmentView extends GenericAttachmentView {
    public static final ViewType f3507a = new C04471();
    public final ObjectionableContentView f3508b;

    /* compiled from: select_from_cta_list */
    final class C04471 extends ViewType {
        C04471() {
        }

        public final View m3453a(Context context) {
            return new ObjectionableContentAttachmentView(context);
        }
    }

    public ObjectionableContentAttachmentView(Context context) {
        this(context, null);
    }

    private ObjectionableContentAttachmentView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private ObjectionableContentAttachmentView(Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 2130905520);
    }

    private ObjectionableContentAttachmentView(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f3508b = (ObjectionableContentView) a(2131564310);
        this.f3508b.f3517b.setLayoutParams(new LayoutParams(-1, -2));
    }
}
