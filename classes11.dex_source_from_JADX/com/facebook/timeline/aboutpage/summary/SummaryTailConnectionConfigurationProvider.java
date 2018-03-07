package com.facebook.timeline.aboutpage.summary;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.timeline.aboutpage.Boolean_IsTheWhoEnabledMethodAutoProvider;
import com.facebook.timeline.aboutpage.CollectionsQeHelper;
import com.facebook.timeline.aboutpage.CollectionsQueryExecutor;
import com.facebook.timeline.aboutpage.views.CollectionStyleMapper;

/* compiled from: Ljava/util/concurrent/atomic/AtomicReference */
public class SummaryTailConnectionConfigurationProvider extends AbstractAssistedProvider<SummaryTailConnectionConfiguration> {
    public final SummaryTailConnectionConfiguration m14859a(String str) {
        return new SummaryTailConnectionConfiguration(str, Boolean_IsTheWhoEnabledMethodAutoProvider.m13738a(this), CollectionsQueryExecutor.m13769a((InjectorLike) this), CollectionStyleMapper.m14915a((InjectorLike) this), CollectionsQeHelper.m13763b(this), SummaryConnectionConfigurationHelper.m14849b(this));
    }
}
