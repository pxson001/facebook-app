package com.facebook.feedback.ui;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.InjectorLike;
import com.facebook.sentry.SentryUtil;
import com.facebook.sentry.SentryUtil.SentryBlockTitle;
import com.facebook.ui.errordialog.ErrorDialogParams;
import com.facebook.ui.errordialog.ErrorDialogParamsBuilder;
import com.facebook.ui.errordialog.ErrorDialogs;
import com.facebook.ui.errordialog.ErrorMessageGenerator;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import javax.inject.Inject;

/* compiled from: savedLocation */
public class FeedbackErrorUtil {
    public static final String f4501a = FeedbackErrorUtil.class.getName();
    private final ErrorMessageGenerator f4502b;
    private final ErrorDialogs f4503c;
    public final AbstractFbErrorReporter f4504d;
    public final Toaster f4505e;
    private final Resources f4506f;

    public static FeedbackErrorUtil m5076b(InjectorLike injectorLike) {
        return new FeedbackErrorUtil(ErrorMessageGenerator.b(injectorLike), ErrorDialogs.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), Toaster.b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FeedbackErrorUtil(ErrorMessageGenerator errorMessageGenerator, ErrorDialogs errorDialogs, AbstractFbErrorReporter abstractFbErrorReporter, Toaster toaster, Resources resources) {
        this.f4503c = errorDialogs;
        this.f4502b = errorMessageGenerator;
        this.f4504d = abstractFbErrorReporter;
        this.f4505e = toaster;
        this.f4506f = resources;
    }

    public static FeedbackErrorUtil m5075a(InjectorLike injectorLike) {
        return m5076b(injectorLike);
    }

    public final void m5078a(Throwable th) {
        m5077a(ServiceException.a(th));
    }

    public final void m5077a(ServiceException serviceException) {
        CharSequence a = this.f4502b.a(serviceException, true, true);
        if (this.f4502b.b(serviceException)) {
            ErrorDialogs errorDialogs = this.f4503c;
            ErrorDialogParamsBuilder a2 = ErrorDialogParams.a(this.f4506f).a(SentryBlockTitle.SENTRY_LIKE_BLOCK.getTitleId());
            a2.c = a;
            ErrorDialogParamsBuilder c = a2.c(2131230784);
            c.e = SentryUtil.a;
            errorDialogs.a(c.l());
        } else {
            this.f4505e.b(new ToastBuilder(a));
        }
        this.f4504d.a(f4501a, serviceException);
    }
}
