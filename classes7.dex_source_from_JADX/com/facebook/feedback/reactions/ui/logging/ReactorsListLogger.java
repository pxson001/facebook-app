package com.facebook.feedback.reactions.ui.logging;

import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.funnellogger.FunnelDefinition;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import javax.inject.Inject;

/* compiled from: server_sync_check_enabled */
public class ReactorsListLogger {
    public static final FunnelDefinition f3968a = FunnelRegistry.v;
    public final FunnelLoggerImpl f3969b;

    /* compiled from: server_sync_check_enabled */
    public enum NavigationReason {
        SWIPE("navigate_page_swipe"),
        TAP("navigate_tab_click");
        
        private final String mAction;

        private NavigationReason(String str) {
            this.mAction = str;
        }

        public final String getAction() {
            return this.mAction;
        }
    }

    @Inject
    public ReactorsListLogger(FunnelLoggerImpl funnelLoggerImpl) {
        this.f3969b = funnelLoggerImpl;
    }

    public final void m4626a(int i, FeedbackReaction feedbackReaction) {
        this.f3969b.a(f3968a, "tabs_count_" + i);
        this.f3969b.a(f3968a, "first_tab_" + feedbackReaction.e);
    }

    public final void m4627a(NavigationReason navigationReason, FeedbackReaction feedbackReaction) {
        this.f3969b.a(f3968a, navigationReason.getAction(), "reaction_" + feedbackReaction.e);
    }
}
