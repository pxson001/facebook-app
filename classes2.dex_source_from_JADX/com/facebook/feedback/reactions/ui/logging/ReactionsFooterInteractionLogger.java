package com.facebook.feedback.reactions.ui.logging;

import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.time.Clock;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.feedback.reactions.ui.overlay.ReactionsDockOverlay.TouchMode;
import com.facebook.feedback.reactions.ui.overlay.ReactionsDockView$DockPosition;
import com.facebook.feedback.reactions.ui.overlay.ReactionsDockView$PointerPosition;
import com.facebook.funnellogger.FunnelDefinition;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.inject.Assisted;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: gift/receive?gid=%s */
public class ReactionsFooterInteractionLogger {
    public static final FunnelDefinition f22362a = FunnelRegistry.f21174u;
    public final FunnelLoggerImpl f22363b;
    public final AnalyticsLogger f22364c;
    public final Clock f22365d;
    public final String f22366e;
    public final String f22367f;
    public String f22368g;
    public long f22369h;
    public ReactionsDockView$DockPosition f22370i;
    public ReactionsDockView$PointerPosition f22371j;
    public TouchMode f22372k = TouchMode.NONE;
    public FeedbackReaction f22373l = FeedbackReaction.f21476c;
    public FeedbackReaction f22374m = FeedbackReaction.f21476c;
    private FeedbackReaction f22375n = FeedbackReaction.f21476c;

    @Inject
    public ReactionsFooterInteractionLogger(FunnelLoggerImpl funnelLoggerImpl, AnalyticsLogger analyticsLogger, Clock clock, @Assisted String str, @Assisted String str2, @Assisted String str3) {
        this.f22363b = funnelLoggerImpl;
        this.f22364c = analyticsLogger;
        this.f22365d = clock;
        this.f22366e = str;
        this.f22368g = str2;
        this.f22367f = str3;
        m30289c();
    }

    public final void m30291a(FeedbackReaction feedbackReaction) {
        if (feedbackReaction == null) {
            feedbackReaction = FeedbackReaction.f21477d;
        }
        this.f22373l = feedbackReaction;
    }

    public final void m30293c(FeedbackReaction feedbackReaction) {
        if (feedbackReaction != this.f22375n) {
            this.f22375n = feedbackReaction;
            this.f22363b.m8038a(f22362a, "reaction_hover", Integer.toString(feedbackReaction.f21478e));
        }
    }

    public final void m30292a(FeedbackReaction feedbackReaction, ReactionsDockView$PointerPosition reactionsDockView$PointerPosition) {
        this.f22374m = feedbackReaction;
        this.f22371j = reactionsDockView$PointerPosition;
        Preconditions.checkNotNull(this.f22368g);
        HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent("feedback_reactions_footer_interaction");
        int i = -1;
        if (this.f22372k != TouchMode.NONE) {
            i = this.f22372k == TouchMode.LINGER ? 1 : 0;
        }
        honeyClientEvent.f3099c = this.f22367f;
        honeyClientEvent.m5090b("story_id", this.f22366e);
        honeyClientEvent.m5090b("feedback_id", this.f22368g);
        honeyClientEvent.m5083a("dock_location", this.f22370i.ordinal());
        honeyClientEvent.m5083a("persisted", i);
        honeyClientEvent.m5083a("initial_reaction", this.f22373l.f21478e);
        honeyClientEvent.m5083a("final_reaction", this.f22374m.f21478e);
        honeyClientEvent.m5083a("dismiss_location", this.f22371j.ordinal());
        honeyClientEvent.m5084a("time_spent", this.f22365d.mo211a() - this.f22369h);
        this.f22364c.mo526a(honeyClientEvent);
        this.f22363b.m8038a(f22362a, "dock_dismiss", reactionsDockView$PointerPosition.name());
        m30289c();
    }

    private void m30289c() {
        Object obj;
        this.f22369h = 0;
        if (this.f22374m == FeedbackReaction.f21476c) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            this.f22373l = this.f22374m;
        }
        this.f22370i = ReactionsDockView$DockPosition.ABOVE_FOOTER;
        this.f22371j = ReactionsDockView$PointerPosition.UNKNOWN;
        this.f22375n = FeedbackReaction.f21476c;
        this.f22374m = FeedbackReaction.f21476c;
        this.f22372k = TouchMode.NONE;
    }

    public final void m30290a() {
        Object obj;
        if (this.f22369h != 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            this.f22369h = this.f22365d.mo211a();
            this.f22363b.m8033a(f22362a);
            this.f22363b.m8037a(f22362a, this.f22370i.name());
            this.f22363b.m8037a(f22362a, "initial_reaction" + this.f22373l.f21478e);
            this.f22363b.m8037a(f22362a, this.f22367f);
        }
    }
}
