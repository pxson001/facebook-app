package com.facebook.timeline.aboutpage.summary;

import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.aboutpage.Boolean_IsTheWhoEnabledMethodAutoProvider;
import com.facebook.timeline.aboutpage.CollectionsQeHelper;
import com.facebook.timeline.aboutpage.CollectionsQueryExecutor;
import com.facebook.timeline.aboutpage.views.CollectionStyleMapper;

/* compiled from: Loaded %d ads */
public class SummaryInitialConnectionConfigurationProvider extends AbstractAssistedProvider<SummaryInitialConnectionConfiguration> {
    public final SummaryInitialConnectionConfiguration m14854a(String str) {
        return new SummaryInitialConnectionConfiguration(str, (QeAccessor) QeInternalImplMethodAutoProvider.a(this), Boolean_IsTheWhoEnabledMethodAutoProvider.m13738a(this), Boolean_IsWorkBuildMethodAutoProvider.a(this), CollectionsQueryExecutor.m13769a((InjectorLike) this), CollectionStyleMapper.m14915a((InjectorLike) this), CollectionsQeHelper.m13763b(this), SummaryConnectionConfigurationHelper.m14849b(this));
    }
}
