package com.facebook.feedback.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.springs.SpringSystem;
import com.facebook.ui.animations.ViewHelperViewAnimatorFactory;
import com.facebook.widget.LazyView;
import com.facebook.widget.listview.BaseProxyOnScrollListener;
import com.facebook.widget.listview.ScrollingViewProxy;
import javax.inject.Inject;

/* compiled from: rtc_voicemail */
public class FeedbackTypingPillController extends AbstractPillController {
    public CommentListScrollStateController f4577a;
    public LazyView<TypingDotsView> f4578b;
    public OnClickListener f4579c;
    public FunnelLoggerImpl f4580d;

    /* compiled from: rtc_voicemail */
    public class C04371 extends BaseProxyOnScrollListener {
        final /* synthetic */ FeedbackTypingPillController f4575a;

        public C04371(FeedbackTypingPillController feedbackTypingPillController) {
            this.f4575a = feedbackTypingPillController;
        }

        public final void m5129a(ScrollingViewProxy scrollingViewProxy, int i) {
            if (i == 1) {
                this.f4575a.m3238b();
            }
        }
    }

    /* compiled from: rtc_voicemail */
    public class C04382 implements OnClickListener {
        final /* synthetic */ FeedbackTypingPillController f4576a;

        public C04382(FeedbackTypingPillController feedbackTypingPillController) {
            this.f4576a = feedbackTypingPillController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1236304145);
            this.f4576a.m3238b();
            this.f4576a.f4577a.m4884g();
            this.f4576a.f4580d.b(FunnelRegistry.t, "Typing_Indicator_Pill_Tapped");
            Logger.a(2, EntryType.UI_INPUT_END, 149553384, a);
        }
    }

    public static FeedbackTypingPillController m5130a(InjectorLike injectorLike) {
        return new FeedbackTypingPillController(SpringSystem.b(injectorLike), ViewHelperViewAnimatorFactory.a(injectorLike), FunnelLoggerImpl.a(injectorLike));
    }

    @Inject
    public FeedbackTypingPillController(SpringSystem springSystem, ViewHelperViewAnimatorFactory viewHelperViewAnimatorFactory, FunnelLoggerImpl funnelLoggerImpl) {
        super(springSystem, viewHelperViewAnimatorFactory);
        this.f4580d = funnelLoggerImpl;
    }

    protected final LazyView<? extends View> mo130g() {
        return this.f4578b;
    }

    public final boolean m5131a(int i) {
        if (this.f4578b == null) {
            return false;
        }
        ((TypingDotsView) this.f4578b.a()).setOnClickListener(this.f4579c);
        if (i > 0) {
            return mo230a();
        }
        m3238b();
        return false;
    }
}
