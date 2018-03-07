package com.facebook.attachments.angora;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.facebook.multirow.api.ViewType;
import javax.annotation.Nullable;

/* compiled from: videoURI */
public class AngoraAttachmentWithSubcontextView extends AngoraAttachmentView implements AttachmentHasSubcontext {
    public static final ViewType f622c = new C00581();
    private final TextView f623e;

    /* compiled from: videoURI */
    final class C00581 extends ViewType {
        C00581() {
        }

        public final View m712a(Context context) {
            return new AngoraAttachmentWithSubcontextView(context);
        }
    }

    public AngoraAttachmentWithSubcontextView(Context context) {
        this(context, null);
    }

    private AngoraAttachmentWithSubcontextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private AngoraAttachmentWithSubcontextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 2130903247);
        this.f623e = (TextView) a(2131559576);
    }

    public void setSubcontextText(@Nullable CharSequence charSequence) {
        GenericAttachmentView.a(this.f623e, charSequence);
    }
}
