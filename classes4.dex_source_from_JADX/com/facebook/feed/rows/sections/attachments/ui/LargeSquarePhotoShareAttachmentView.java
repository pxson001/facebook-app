package com.facebook.feed.rows.sections.attachments.ui;

import android.content.Context;
import android.view.View;
import com.facebook.feed.rows.sections.attachments.linkshare.MoreAttachmentContextUtil;
import com.facebook.inject.FbInjector;
import com.facebook.multirow.api.ViewType;
import com.facebook.resources.ui.EllipsizingTextView;
import javax.inject.Inject;

/* compiled from: not needed in emulated source. */
public class LargeSquarePhotoShareAttachmentView extends SidePhotoShareAttachmentView {
    public static final ViewType f6999h = new C03321();
    @Inject
    public MoreAttachmentContextUtil f7000i;

    /* compiled from: not needed in emulated source. */
    final class C03321 extends ViewType {
        C03321() {
        }

        public final View m7290a(Context context) {
            return new LargeSquarePhotoShareAttachmentView(context);
        }
    }

    public static void m7287a(Object obj, Context context) {
        ((LargeSquarePhotoShareAttachmentView) obj).f7000i = MoreAttachmentContextUtil.m7292a(FbInjector.get(context));
    }

    public LargeSquarePhotoShareAttachmentView(Context context) {
        super(context, 2130907206);
        Class cls = LargeSquarePhotoShareAttachmentView.class;
        m7287a(this, getContext());
        this.f7000i.m7293a(getResources().getDimensionPixelSize(2131427518), (EllipsizingTextView) getView(2131559571), (EllipsizingTextView) getView(2131559572));
    }
}
