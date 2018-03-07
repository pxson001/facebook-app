package com.facebook.feedback.ui;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ufiservices.qe.UfiFlyoutQuickExperimentController;
import com.facebook.ui.errordialog.ErrorMessageGenerator;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicatorState;

/* compiled from: samr */
public class FeedbackLoadingIndicatorControllerProvider extends AbstractAssistedProvider<FeedbackLoadingIndicatorController> {
    public final FeedbackLoadingIndicatorController m5110a(LoadingIndicatorState loadingIndicatorState, RetryClickedListener retryClickedListener) {
        return new FeedbackLoadingIndicatorController(loadingIndicatorState, retryClickedListener, ErrorMessageGenerator.b(this), UfiFlyoutQuickExperimentController.b(this));
    }
}
