package com.facebook.feed.fragment.subscriber;

import com.facebook.controller.mutation.BaseMutationCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.feed.util.event.DataSetEvents.DataSetUpdatedEvent;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.sentry.SentryUtil;
import com.facebook.sentry.SentryUtil.SentryBlockTitle;
import com.facebook.ui.errordialog.ErrorDialogParams;
import com.facebook.ui.errordialog.ErrorDialogParamsBuilder;
import com.facebook.ui.errordialog.ErrorDialogs;
import com.facebook.ui.toaster.ToastBuilder;

/* compiled from: group_pin_story */
class SetNotifyMeSubscriber$1 extends BaseMutationCallback<FeedUnit> {
    final /* synthetic */ SetNotifyMeSubscriber f11896a;

    SetNotifyMeSubscriber$1(SetNotifyMeSubscriber setNotifyMeSubscriber) {
        this.f11896a = setNotifyMeSubscriber;
    }

    public final void m13993a(Object obj) {
        this.f11896a.j.a((FeedUnit) obj);
        this.f11896a.g.a(new DataSetUpdatedEvent());
    }

    public final void m13994a(Object obj, ServiceException serviceException) {
        FeedUnit feedUnit = (FeedUnit) obj;
        this.f11896a.b.a("set_notify_me_fail", serviceException);
        this.f11896a.j.a(feedUnit);
        this.f11896a.g.a(new DataSetUpdatedEvent());
        if (this.f11896a.i) {
            CharSequence a = this.f11896a.c.a(serviceException, true, true);
            if (this.f11896a.c.b(serviceException)) {
                ErrorDialogs errorDialogs = this.f11896a.f;
                ErrorDialogParamsBuilder a2 = ErrorDialogParams.a(this.f11896a.d).a(SentryBlockTitle.SENTRY_BLOCK.getTitleId());
                a2.c = a;
                ErrorDialogParamsBuilder c = a2.c(2131230784);
                c.e = SentryUtil.a;
                errorDialogs.a(c.l());
                return;
            }
            this.f11896a.e.b(new ToastBuilder(a));
        }
    }
}
