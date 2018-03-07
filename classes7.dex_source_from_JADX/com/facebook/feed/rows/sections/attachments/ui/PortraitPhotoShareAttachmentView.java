package com.facebook.feed.rows.sections.attachments.ui;

import android.content.Context;
import android.view.View;
import com.facebook.feed.rows.sections.attachments.linkshare.MoreAttachmentContextUtil;
import com.facebook.inject.FbInjector;
import com.facebook.multirow.api.ViewType;
import com.facebook.resources.ui.EllipsizingTextView;
import javax.inject.Inject;

/* compiled from: VIEW_EDIT_HISTORY */
public class PortraitPhotoShareAttachmentView extends SidePhotoShareAttachmentView {
    public static final ViewType f21083h = new C17891();
    @Inject
    public MoreAttachmentContextUtil f21084i;

    /* compiled from: VIEW_EDIT_HISTORY */
    final class C17891 extends ViewType {
        C17891() {
        }

        public final View m23962a(Context context) {
            return new PortraitPhotoShareAttachmentView(context);
        }
    }

    public static void m23963a(Object obj, Context context) {
        ((PortraitPhotoShareAttachmentView) obj).f21084i = MoreAttachmentContextUtil.a(FbInjector.get(context));
    }

    public PortraitPhotoShareAttachmentView(Context context) {
        super(context, 2130906344);
        Class cls = PortraitPhotoShareAttachmentView.class;
        m23963a(this, getContext());
        this.f21084i.a(getResources().getDimensionPixelSize(2131427519), (EllipsizingTextView) getView(2131559571), (EllipsizingTextView) getView(2131559572));
    }
}
