package com.facebook.entitycardsplugins.person.loader;

import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.entitycardsplugins.person.view.PersonCardViewHelper;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.coverphotosize.CoverPhotoSize;
import com.facebook.timeline.widget.actionbar.PersonActionBarQueryParamsFactory;
import com.google.common.base.Optional;

/* compiled from: home_%s_backgrounded */
public class DefaultPersonCardsLoaderProvider extends AbstractAssistedProvider<DefaultPersonCardsLoader> {
    public final DefaultPersonCardsLoader m13092a(Optional<String> optional, CallerContext callerContext) {
        return new DefaultPersonCardsLoader(DefaultAppChoreographer.a(this), IdBasedSingletonScopeProvider.a(this, 2199), GraphQLQueryExecutor.a(this), PersonActionBarQueryParamsFactory.a(this), PersonCardViewHelper.m13239a(this), CoverPhotoSize.a(this), (QeAccessor) QeInternalImplMethodAutoProvider.a(this), optional, callerContext);
    }
}
