package com.facebook.feedback.ui;

import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;

/* compiled from: right_color */
public class TypingIndicatorControllerProvider extends AbstractAssistedProvider<TypingIndicatorController> {
    public final TypingIndicatorController m5326a(CommentListScrollStateController commentListScrollStateController, FeedbackTypingPillController feedbackTypingPillController, CommentAdapter commentAdapter) {
        return new TypingIndicatorController(commentListScrollStateController, feedbackTypingPillController, commentAdapter, Handler_ForUiThreadMethodAutoProvider.b(this), (Clock) SystemClockMethodAutoProvider.a(this), FunnelLoggerImpl.a(this), (QeAccessor) QeInternalImplMethodAutoProvider.a(this));
    }
}
