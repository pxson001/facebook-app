package com.facebook.pages.common.surface.ui.header;

import android.content.Context;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.pages.common.abtest.qe.PagesExperimentUtils;

/* compiled from: remove_from_frequents */
public class CaspianPagesHeaderViewControllerProvider extends AbstractAssistedProvider<CaspianPagesHeaderViewController> {
    public final CaspianPagesHeaderViewController m3579a(Context context) {
        return new CaspianPagesHeaderViewController(context, CaspianPagesHeaderViewPerfLoggingImpl.m3600b((InjectorLike) this), IdBasedSingletonScopeProvider.a(this, 8617), IdBasedSingletonScopeProvider.a(this, 3863), IdBasedSingletonScopeProvider.b(this, 2128), IdBasedSingletonScopeProvider.a(this, 2436), IdBasedSingletonScopeProvider.a(this, 968), PagesExperimentUtils.a(this));
    }
}
