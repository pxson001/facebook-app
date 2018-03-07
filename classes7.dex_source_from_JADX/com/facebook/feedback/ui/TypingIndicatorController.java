package com.facebook.feedback.ui;

import android.os.Handler;
import com.facebook.common.time.Clock;
import com.facebook.feedback.abtest.ExperimentsForFeedbackTestModule;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.inject.Assisted;
import com.facebook.qe.api.QeAccessor;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.inject.Inject;

/* compiled from: right_handle_moves */
public class TypingIndicatorController {
    public final CommentListScrollStateController f4785a;
    public final FeedbackTypingPillController f4786b;
    public final CommentAdapter f4787c;
    public final Handler f4788d;
    private final Clock f4789e;
    public final Runnable f4790f = new C04691(this);
    public final FunnelLoggerImpl f4791g;
    public final boolean f4792h;
    public int f4793i;

    /* compiled from: right_handle_moves */
    class C04691 implements Runnable {
        final /* synthetic */ TypingIndicatorController f4784a;

        C04691(TypingIndicatorController typingIndicatorController) {
            this.f4784a = typingIndicatorController;
        }

        public void run() {
            this.f4784a.m5325a(0);
        }
    }

    @Inject
    public TypingIndicatorController(@Assisted CommentListScrollStateController commentListScrollStateController, @Assisted FeedbackTypingPillController feedbackTypingPillController, @Assisted CommentAdapter commentAdapter, Handler handler, Clock clock, FunnelLoggerImpl funnelLoggerImpl, QeAccessor qeAccessor) {
        this.f4785a = commentListScrollStateController;
        this.f4786b = feedbackTypingPillController;
        this.f4787c = commentAdapter;
        this.f4788d = handler;
        this.f4789e = clock;
        this.f4791g = funnelLoggerImpl;
        this.f4792h = qeAccessor.a(ExperimentsForFeedbackTestModule.Z, false);
    }

    public final void m5325a(int i) {
        if (i > 0) {
            if (this.f4793i < i) {
                this.f4787c.m4797d(i);
                if (this.f4785a.m4879a()) {
                    this.f4785a.m4884g();
                    if (this.f4793i == 0) {
                        this.f4791g.b(FunnelRegistry.t, "Typing_Indicator_Cell_Shown");
                    }
                } else if (this.f4786b.m5131a(i)) {
                    this.f4791g.b(FunnelRegistry.t, "Typing_Indicator_Pill_Shown");
                }
            }
            this.f4793i = i;
            HandlerDetour.a(this.f4788d, this.f4790f);
            HandlerDetour.b(this.f4788d, this.f4790f, 20100, 773096110);
        } else if (this.f4793i > 0) {
            this.f4793i = 0;
            this.f4787c.m4797d(this.f4793i);
            this.f4786b.m5131a(this.f4793i);
        }
    }
}
