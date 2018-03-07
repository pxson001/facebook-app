package com.facebook.attachments.angora;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.facebook.multirow.api.ViewType;
import javax.annotation.Nullable;

/* compiled from: video/wvc1 */
public class ReshareAttachmentView extends AngoraAttachmentView {
    public static final ViewType f638c = new C00631();
    public final TextView f639e;

    /* compiled from: video/wvc1 */
    final class C00631 extends ViewType {
        C00631() {
        }

        public final View m727a(Context context) {
            return new ReshareAttachmentView(context);
        }
    }

    public ReshareAttachmentView(Context context) {
        this(context, null);
    }

    private ReshareAttachmentView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private ReshareAttachmentView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 2130906835);
        this.f639e = (TextView) a(2131566984);
    }
}
