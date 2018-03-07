package com.facebook.feedplugins.instantarticles;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.attachments.angora.GenericAttachmentView;
import com.facebook.multirow.api.ViewType;
import javax.annotation.Nullable;

/* compiled from: copy_link_tag */
public class AngoraInstantArticleAttachmentLabelView extends GenericAttachmentView {
    public static final ViewType f7967a = new C10061();

    /* compiled from: copy_link_tag */
    final class C10061 extends ViewType {
        C10061() {
        }

        public final View m9043a(Context context) {
            return new AngoraInstantArticleAttachmentLabelView(context);
        }
    }

    public AngoraInstantArticleAttachmentLabelView(Context context) {
        this(context, null);
    }

    private AngoraInstantArticleAttachmentLabelView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private AngoraInstantArticleAttachmentLabelView(Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 2130904940);
    }

    private AngoraInstantArticleAttachmentLabelView(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
