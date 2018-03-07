package com.facebook.feed.rows.sections.attachments.ui;

import android.content.Context;
import android.view.View;
import android.widget.Space;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.rows.sections.attachments.linkshare.MoreAttachmentContextUtil;
import com.facebook.inject.FbInjector;
import com.facebook.multirow.api.ViewType;
import com.facebook.resources.ui.EllipsizingTextView;
import javax.inject.Inject;

/* compiled from: V_MPEG4/ISO/AVC */
public class LargeSquarePhotoInstantArticleAttachmentView extends SidePhotoShareAttachmentView {
    public static final ViewType f21066h = new C17871();
    @Inject
    public MoreAttachmentContextUtil f21067i;
    public final FbDraweeView f21068j = ((FbDraweeView) getView(2131566177));
    public final Space f21069k = ((Space) getView(2131567595));

    /* compiled from: V_MPEG4/ISO/AVC */
    final class C17871 extends ViewType {
        C17871() {
        }

        public final View m23939a(Context context) {
            return new LargeSquarePhotoInstantArticleAttachmentView(context);
        }
    }

    public static void m23940a(Object obj, Context context) {
        ((LargeSquarePhotoInstantArticleAttachmentView) obj).f21067i = MoreAttachmentContextUtil.a(FbInjector.get(context));
    }

    public LargeSquarePhotoInstantArticleAttachmentView(Context context) {
        super(context, 2130907207);
        Class cls = LargeSquarePhotoInstantArticleAttachmentView.class;
        m23940a(this, getContext());
        this.f21067i.a(getResources().getDimensionPixelSize(2131427518), (EllipsizingTextView) getView(2131559571), (EllipsizingTextView) getView(2131559572));
    }
}
