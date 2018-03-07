package com.facebook.reaction.common;

import android.support.v7.widget.LinearLayoutManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.analytics.ReactionAnalyticsLogger;
import com.facebook.reaction.analytics.perflog.ReactionPerfLogger;

/* compiled from: block_type */
public class ReactionInteractionTrackerProvider extends AbstractAssistedProvider<ReactionInteractionTracker> {
    public final ReactionInteractionTracker m22880a(ReactionSession reactionSession, LinearLayoutManager linearLayoutManager) {
        return new ReactionInteractionTracker(reactionSession, linearLayoutManager, (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), ReactionAnalyticsLogger.m22814a((InjectorLike) this), ReactionPerfLogger.a(this));
    }
}
