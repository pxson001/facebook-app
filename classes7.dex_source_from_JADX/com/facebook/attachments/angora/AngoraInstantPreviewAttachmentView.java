package com.facebook.attachments.angora;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.multirow.api.ViewType;
import com.facebook.resources.ui.EllipsizingTextView;
import javax.annotation.Nullable;

/* compiled from: videoCreativeEditingDataKey */
public class AngoraInstantPreviewAttachmentView extends AngoraAttachmentView {
    public static final ViewType f634c = new C00611();
    private final EllipsizingTextView f635e;

    /* compiled from: videoCreativeEditingDataKey */
    final class C00611 extends ViewType {
        C00611() {
        }

        public final View m723a(Context context) {
            return new AngoraInstantPreviewAttachmentView(context);
        }
    }

    public AngoraInstantPreviewAttachmentView(Context context) {
        this(context, null);
    }

    private AngoraInstantPreviewAttachmentView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private AngoraInstantPreviewAttachmentView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 2130903249);
        this.f635e = (EllipsizingTextView) a(2131559578);
    }

    public void setPreviewText(String str) {
        this.f635e.setText(str);
    }
}
