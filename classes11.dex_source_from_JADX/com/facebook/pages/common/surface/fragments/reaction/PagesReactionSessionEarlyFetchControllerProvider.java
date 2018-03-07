package com.facebook.pages.common.surface.fragments.reaction;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.pages.common.job_sequencer.PagesJobSequencer;
import com.facebook.pages.common.sequencelogger.PagesSurfaceFirstCardPerfLogger;
import com.facebook.pages.common.surface.fragments.reaction.PagesGenericReactionSurfaceTabFragment.C03091;
import com.facebook.reaction.ReactionSessionManager;

/* compiled from: result_sections */
public class PagesReactionSessionEarlyFetchControllerProvider extends AbstractAssistedProvider<PagesReactionSessionEarlyFetchController> {
    public final PagesReactionSessionEarlyFetchController m3434a(String str, String str2, String str3, C03091 c03091, PagesSurfaceFirstCardPerfLogger pagesSurfaceFirstCardPerfLogger) {
        return new PagesReactionSessionEarlyFetchController(str, str2, str3, c03091, pagesSurfaceFirstCardPerfLogger, ReactionSessionManager.a(this), PagesJobSequencer.m2443a((InjectorLike) this), IdBasedSingletonScopeProvider.b(this, 3860));
    }
}
