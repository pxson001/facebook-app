package com.facebook.messaging.photoreminders.inboxheader;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.i18n.I18nJoiner;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.orca.threadlist.ThreadListAdapter.AnonymousClass10;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: registration_step_validation_error */
public class PhotoRemindersHeaderView extends CustomFrameLayout {
    public static final CallerContext f3556d = CallerContext.a(PhotoRemindersHeaderView.class, "messenger_photo_reminders_inbox_header");
    @Inject
    public DefaultTimeFormatUtil f3557a;
    @Inject
    public I18nJoiner f3558b;
    @Inject
    public FbDraweeControllerBuilder f3559c;
    public FbDraweeView f3560e = ((FbDraweeView) c(2131565053));
    public FbDraweeView f3561f = ((FbDraweeView) c(2131565052));
    public FbDraweeView f3562g = ((FbDraweeView) c(2131565051));
    public TextView f3563h = ((TextView) c(2131565055));
    public TextView f3564i = ((TextView) c(2131565056));
    @Nullable
    public AnonymousClass10 f3565j;

    /* compiled from: registration_step_validation_error */
    public class C05541 implements OnClickListener {
        final /* synthetic */ PhotoRemindersHeaderView f3554a;

        public C05541(PhotoRemindersHeaderView photoRemindersHeaderView) {
            this.f3554a = photoRemindersHeaderView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1693627273);
            if (this.f3554a.f3565j != null) {
                this.f3554a.f3565j.f6542a.f6573j.m6289a(PhotoRemindersHeaderActionType.CLICK);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1137550544, a);
        }
    }

    /* compiled from: registration_step_validation_error */
    public class C05552 implements OnClickListener {
        final /* synthetic */ PhotoRemindersHeaderView f3555a;

        public C05552(PhotoRemindersHeaderView photoRemindersHeaderView) {
            this.f3555a = photoRemindersHeaderView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -254182503);
            if (this.f3555a.f3565j != null) {
                this.f3555a.f3565j.f6542a.f6573j.m6289a(PhotoRemindersHeaderActionType.CLOSE);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -699085493, a);
        }
    }

    public static void m3401a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PhotoRemindersHeaderView photoRemindersHeaderView = (PhotoRemindersHeaderView) obj;
        DefaultTimeFormatUtil a = DefaultTimeFormatUtil.a(fbInjector);
        I18nJoiner b = I18nJoiner.b(fbInjector);
        FbDraweeControllerBuilder b2 = FbDraweeControllerBuilder.b(fbInjector);
        photoRemindersHeaderView.f3557a = a;
        photoRemindersHeaderView.f3558b = b;
        photoRemindersHeaderView.f3559c = b2;
    }

    public PhotoRemindersHeaderView(Context context) {
        super(context);
        Class cls = PhotoRemindersHeaderView.class;
        m3401a(this, getContext());
        setContentView(2130905822);
        View c = c(2131565054);
        View c2 = c(2131565049);
        GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) this.f3561f.getHierarchy();
        GenericDraweeHierarchy genericDraweeHierarchy2 = (GenericDraweeHierarchy) this.f3562g.getHierarchy();
        ((GenericDraweeHierarchy) this.f3560e.getHierarchy()).a(0);
        genericDraweeHierarchy.a(0);
        genericDraweeHierarchy2.a(0);
        PointF pointF = new PointF(0.5f, 0.0f);
        genericDraweeHierarchy.a(pointF);
        genericDraweeHierarchy2.a(pointF);
        c2.setOnClickListener(new C05541(this));
        c.setOnClickListener(new C05552(this));
    }
}
