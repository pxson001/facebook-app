package com.facebook.feedback.ui.rows.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.text.Layout;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.feedback.reactions.ui.FeedbackFooterMode;
import com.facebook.feedback.reactions.ui.FeedbackReactionsController;
import com.facebook.feedback.reactions.ui.ReactionMutateListener;
import com.facebook.feedback.reactions.ui.ReactionsFooterSelectionView;
import com.facebook.feedback.reactions.ui.ReactionsLongPressTouchListener;
import com.facebook.feedback.reactions.ui.ReactionsLongPressTouchListener.LongPressListener;
import com.facebook.feedback.reactions.ui.ReactionsLongPressTouchListenerProvider;
import com.facebook.feedback.reactions.ui.logging.ReactionsFooterInteractionLogger;
import com.facebook.feedback.reactions.ui.overlay.ReactionsDockOverlay;
import com.facebook.feedback.reactions.ui.overlay.ReactionsDockOverlay.DockTheme;
import com.facebook.feedback.reactions.ui.overlay.ReactionsDockOverlay.ReactionsDockSupport;
import com.facebook.feedback.ui.CommentBackgroundUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ufiservices.flyout.views.DefaultCommentMetadataSpannableBuilder.ReactionActionClickSpan;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.accessibility.AccessibleTextView;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: reverse_geocode_detailed */
public class CommentActionsWithReactionsView extends CustomFrameLayout implements LongPressListener, ReactionsDockSupport, HighlightableView {
    @Inject
    public CommentBackgroundUtil f5148a;
    @Inject
    public FeedbackReactionsController f5149b;
    @Inject
    public ReactionsDockOverlay f5150c;
    @Inject
    public ReactionsLongPressTouchListenerProvider f5151d;
    public final AccessibleTextView f5152e;
    private final ReactionsFooterSelectionView f5153f;
    public final ReactionsLongPressTouchListener f5154g;
    public ImmutableList<FeedbackReaction> f5155h;
    public ReactionsFooterInteractionLogger f5156i;
    public ReactionMutateListener f5157j;
    private FeedbackFooterMode f5158k;
    public boolean f5159l;

    /* compiled from: reverse_geocode_detailed */
    public class C05081 implements OnTouchListener {
        final /* synthetic */ CommentActionsWithReactionsView f5146a;

        public C05081(CommentActionsWithReactionsView commentActionsWithReactionsView) {
            this.f5146a = commentActionsWithReactionsView;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int i;
            CommentActionsWithReactionsView commentActionsWithReactionsView = this.f5146a;
            if (motionEvent.getActionMasked() != 0) {
                i = 0;
            } else {
                i = ((int) motionEvent.getX()) - commentActionsWithReactionsView.f5152e.getTotalPaddingLeft();
                int y = ((int) motionEvent.getY()) - commentActionsWithReactionsView.f5152e.getTotalPaddingTop();
                Layout layout = commentActionsWithReactionsView.f5152e.getLayout();
                SpannableString valueOf = SpannableString.valueOf(commentActionsWithReactionsView.f5152e.getText());
                i = layout.getOffsetForHorizontal(layout.getLineForVertical(y), (float) i);
                ReactionActionClickSpan[] reactionActionClickSpanArr = (ReactionActionClickSpan[]) valueOf.getSpans(Math.max(0, i - 4), Math.min(valueOf.length() - 1, i + 4), ReactionActionClickSpan.class);
                i = (reactionActionClickSpanArr == null || reactionActionClickSpanArr.length <= 0) ? 0 : 1;
            }
            if (i != 0) {
                this.f5146a.f5159l = true;
                this.f5146a.f5154g.onTouch(this.f5146a.f5152e, motionEvent);
            }
            return false;
        }
    }

    /* compiled from: reverse_geocode_detailed */
    /* synthetic */ class C05092 {
        static final /* synthetic */ int[] f5147a = new int[FeedbackFooterMode.values().length];

        static {
            try {
                f5147a[FeedbackFooterMode.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5147a[FeedbackFooterMode.REACTIONS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public static void m5607a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        CommentActionsWithReactionsView commentActionsWithReactionsView = (CommentActionsWithReactionsView) obj;
        CommentBackgroundUtil a = CommentBackgroundUtil.m4807a(injectorLike);
        FeedbackReactionsController a2 = FeedbackReactionsController.a(injectorLike);
        ReactionsDockOverlay a3 = ReactionsDockOverlay.a(injectorLike);
        ReactionsLongPressTouchListenerProvider reactionsLongPressTouchListenerProvider = (ReactionsLongPressTouchListenerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ReactionsLongPressTouchListenerProvider.class);
        commentActionsWithReactionsView.f5148a = a;
        commentActionsWithReactionsView.f5149b = a2;
        commentActionsWithReactionsView.f5150c = a3;
        commentActionsWithReactionsView.f5151d = reactionsLongPressTouchListenerProvider;
    }

    public CommentActionsWithReactionsView(Context context) {
        this(context, null);
    }

    private CommentActionsWithReactionsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private CommentActionsWithReactionsView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5158k = FeedbackFooterMode.DEFAULT;
        Class cls = CommentActionsWithReactionsView.class;
        m5607a(this, getContext());
        setContentView(2130903615);
        setBackgroundDrawable(this.f5148a.m4813a(context));
        this.f5152e = (AccessibleTextView) c(2131560421);
        this.f5153f = (ReactionsFooterSelectionView) c(2131560422);
        this.f5152e.setMovementMethod(LinkMovementMethod.getInstance());
        this.f5152e.setTextSize(0, context.getResources().getDimension(2131428739));
        this.f5154g = this.f5151d.a(this);
        this.f5152e.setOnTouchListener(new C05081(this));
    }

    public final void m5613a(boolean z) {
        setMode(z ? FeedbackFooterMode.REACTIONS : FeedbackFooterMode.DEFAULT);
    }

    public final void m5614b(boolean z) {
        this.f5153f.a(z);
    }

    public ReactionsFooterInteractionLogger getInteractionLogger() {
        return this.f5156i;
    }

    public ImmutableList<FeedbackReaction> getSupportedReactions() {
        if (this.f5155h != null) {
            return this.f5155h;
        }
        return this.f5149b.c();
    }

    public final void m5612a(FeedbackReaction feedbackReaction) {
        if (this.f5157j != null && feedbackReaction != FeedbackReaction.c) {
            this.f5157j.a(this, feedbackReaction, null);
        }
    }

    public DockTheme getDockTheme() {
        return DockTheme.LIGHT;
    }

    public void setMode(FeedbackFooterMode feedbackFooterMode) {
        switch (C05092.f5147a[feedbackFooterMode.ordinal()]) {
            case 1:
                this.f5152e.setVisibility(0);
                this.f5153f.setVisibility(8);
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                    break;
                }
                break;
            case 2:
                this.f5152e.setVisibility(8);
                this.f5153f.setVisibility(0);
                this.f5153f.a(false);
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
        }
        this.f5158k = feedbackFooterMode;
    }

    public FeedbackFooterMode getCurrentFooterMode() {
        return this.f5158k;
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setMode(FeedbackFooterMode.DEFAULT);
        m5609a();
    }

    public final void m5609a() {
        this.f5150c.a();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            this.f5159l = false;
        }
        if (this.f5159l) {
            this.f5154g.onTouch(this.f5152e, motionEvent);
        }
        return m5608b(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1063232201);
        boolean b = m5608b(motionEvent);
        Logger.a(2, EntryType.UI_INPUT_END, 1551313830, a);
        return b;
    }

    private boolean m5608b(MotionEvent motionEvent) {
        if (this.f5158k != FeedbackFooterMode.REACTIONS) {
            return false;
        }
        this.f5150c.a(this);
        this.f5150c.a(this.f5152e, motionEvent);
        return true;
    }

    public final void m5611a(MotionEvent motionEvent) {
        setMode(FeedbackFooterMode.REACTIONS);
        m5608b(motionEvent);
    }

    public final void mo279a(ValueAnimator valueAnimator) {
        CommentBackgroundUtil.m4809a(getBackground(), valueAnimator);
    }
}
