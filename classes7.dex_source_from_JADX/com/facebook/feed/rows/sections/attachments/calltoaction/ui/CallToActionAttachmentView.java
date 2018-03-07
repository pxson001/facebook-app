package com.facebook.feed.rows.sections.attachments.calltoaction.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RatingBar;
import android.widget.TextView;
import com.facebook.attachments.angora.actionbutton.GenericActionButtonView;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.multirow.api.ViewType;
import javax.annotation.Nullable;

/* compiled from: WEAK */
public class CallToActionAttachmentView extends CallToActionAttachmentViewBase {
    public static final ViewType f20890a = new C17791();
    private final GenericActionButtonView f20891g;

    /* compiled from: WEAK */
    final class C17791 extends ViewType {
        C17791() {
        }

        public final View m23814a(Context context) {
            return new CallToActionAttachmentView(context);
        }
    }

    public CallToActionAttachmentView(Context context) {
        this(context, null);
    }

    public CallToActionAttachmentView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130903479);
        this.f20891g = (GenericActionButtonView) a(2131560131);
        this.c = (TextView) a(2131560133);
        this.d = (TextView) a(2131560135);
        this.e = (TextView) a(2131560136);
        this.f = (RatingBar) a(2131560134);
        this.b = (FbDraweeView) a(2131560132);
    }

    public void setActionButtonOnClickListener(OnClickListener onClickListener) {
        this.f20891g.setOnClickListener(onClickListener);
    }

    public GenericActionButtonView getActionButton() {
        return this.f20891g;
    }
}
