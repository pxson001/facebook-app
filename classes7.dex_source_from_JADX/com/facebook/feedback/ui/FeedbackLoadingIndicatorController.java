package com.facebook.feedback.ui;

import android.content.res.Resources;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.Assisted;
import com.facebook.ufiservices.qe.UfiFlyoutQuickExperimentController;
import com.facebook.ui.errordialog.ErrorMessageGenerator;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicator.State;
import com.facebook.widget.loadingindicator.LoadingIndicatorController;
import com.facebook.widget.loadingindicator.LoadingIndicatorState;
import com.facebook.widget.loadingindicator.LoadingIndicatorState.Builder;
import javax.inject.Inject;

/* compiled from: sat */
public class FeedbackLoadingIndicatorController extends LoadingIndicatorController {
    private ErrorMessageGenerator f4552a;
    private UfiFlyoutQuickExperimentController f4553b;
    public LoadingIndicatorState f4554c;

    @Inject
    public FeedbackLoadingIndicatorController(@Assisted LoadingIndicatorState loadingIndicatorState, @Assisted RetryClickedListener retryClickedListener, ErrorMessageGenerator errorMessageGenerator, UfiFlyoutQuickExperimentController ufiFlyoutQuickExperimentController) {
        super(loadingIndicatorState, retryClickedListener);
        this.f4552a = errorMessageGenerator;
        this.f4553b = ufiFlyoutQuickExperimentController;
    }

    public final void m5109a(ServiceException serviceException, Resources resources, RetryClickedListener retryClickedListener) {
        LoadingIndicatorState loadingIndicatorState;
        if (serviceException.errorCode == ErrorCode.CONNECTION_FAILURE) {
            if (this.f4554c == null) {
                Builder newBuilder = LoadingIndicatorState.newBuilder();
                newBuilder.a = State.ERROR;
                newBuilder = newBuilder;
                newBuilder.b = resources.getString(2131233625);
                newBuilder = newBuilder;
                newBuilder.c = resources.getString(2131233626);
                newBuilder = newBuilder;
                newBuilder.d = 2130840225;
                this.f4554c = newBuilder.a();
            }
            loadingIndicatorState = this.f4554c;
        } else {
            String a = this.f4552a.a(serviceException, true, true);
            Builder newBuilder2 = LoadingIndicatorState.newBuilder();
            newBuilder2.a = State.ERROR;
            newBuilder2 = newBuilder2;
            newBuilder2.b = a;
            loadingIndicatorState = newBuilder2.a();
        }
        super.a(loadingIndicatorState);
    }
}
