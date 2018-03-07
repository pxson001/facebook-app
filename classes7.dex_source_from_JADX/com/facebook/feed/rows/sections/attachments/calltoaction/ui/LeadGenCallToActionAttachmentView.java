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

/* compiled from: WATCH_AND_BROWSE */
public class LeadGenCallToActionAttachmentView extends CallToActionAttachmentViewBase {
    public static final ViewType f20892a = new C17801();
    private final GenericActionButtonView f20893g;

    /* compiled from: WATCH_AND_BROWSE */
    final class C17801 extends ViewType {
        C17801() {
        }

        public final View m23816a(Context context) {
            return new LeadGenCallToActionAttachmentView(context);
        }
    }

    public LeadGenCallToActionAttachmentView(Context context) {
        this(context, null);
    }

    private LeadGenCallToActionAttachmentView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130905009);
        this.f20893g = (GenericActionButtonView) a(2131563363);
        this.c = (TextView) a(2131560133);
        this.d = (TextView) a(2131560135);
        this.e = (TextView) a(2131560136);
        this.f = (RatingBar) a(2131560134);
        this.b = (FbDraweeView) a(2131560132);
    }

    public void setActionButtonOnClickListener(OnClickListener onClickListener) {
        this.f20893g.setOnClickListener(onClickListener);
    }

    public GenericActionButtonView getActionButton() {
        return this.f20893g;
    }
}
