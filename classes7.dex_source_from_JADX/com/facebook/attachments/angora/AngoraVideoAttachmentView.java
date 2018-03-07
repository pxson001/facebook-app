package com.facebook.attachments.angora;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.attachments.videos.ui.InlineVideoAttachmentView;
import com.facebook.multirow.api.ViewType;
import javax.annotation.Nullable;

/* compiled from: videoAspectRation */
public class AngoraVideoAttachmentView extends GenericAttachmentView {
    public static final ViewType f636a = new C00621();
    private InlineVideoAttachmentView f637b;

    /* compiled from: videoAspectRation */
    final class C00621 extends ViewType {
        C00621() {
        }

        public final View m724a(Context context) {
            return new AngoraVideoAttachmentView(context);
        }
    }

    public AngoraVideoAttachmentView(Context context) {
        this(context, null);
    }

    private AngoraVideoAttachmentView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private AngoraVideoAttachmentView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 2130903250);
        this.f637b = (InlineVideoAttachmentView) a(2131559579);
        this.f637b.c = 1.9318181f;
    }

    public InlineVideoAttachmentView getInlineVideoAttachmentView() {
        return this.f637b;
    }
}
