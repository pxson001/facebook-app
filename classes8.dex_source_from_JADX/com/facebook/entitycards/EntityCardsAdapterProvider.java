package com.facebook.entitycards;

import android.os.Bundle;
import android.view.LayoutInflater;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.entitycards.analytics.EntityCardsAnalyticsLogger;
import com.facebook.entitycards.analytics.EntityCardsInitialCardsSequenceLogger;
import com.facebook.entitycards.analytics.EntityCardsScrollTTITracker;
import com.facebook.entitycards.controller.EntityCardsController;
import com.facebook.entitycards.controller.EntityCardsPresenterRegistryProvider;
import com.facebook.entitycards.intent.EntityCardsFragment.C11761;
import com.facebook.entitycards.model.EntityCardsDataSource;
import com.facebook.entitycards.view.EntityCardContainerPresenterProvider;
import com.facebook.entitycards.view.EntityCardDimensionsHelper;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;

/* compiled from: initial_place_state */
public class EntityCardsAdapterProvider extends AbstractAssistedProvider<EntityCardsAdapter> {
    public final EntityCardsAdapter m12776a(EntityCardsAnalyticsLogger entityCardsAnalyticsLogger, EntityCardsController entityCardsController, EntityCardsDataSource entityCardsDataSource, C11761 c11761, EntityCardsScrollTTITracker entityCardsScrollTTITracker, LayoutInflater layoutInflater, RecyclableViewPoolManager recyclableViewPoolManager, Integer num, Bundle bundle) {
        return new EntityCardsAdapter(entityCardsAnalyticsLogger, entityCardsController, entityCardsDataSource, c11761, entityCardsScrollTTITracker, layoutInflater, recyclableViewPoolManager, num, bundle, DefaultAndroidThreadUtil.a(this), (EntityCardContainerPresenterProvider) getOnDemandAssistedProviderForStaticDi(EntityCardContainerPresenterProvider.class), EntityCardDimensionsHelper.m13043a(this), (EntityCardsPresenterRegistryProvider) getOnDemandAssistedProviderForStaticDi(EntityCardsPresenterRegistryProvider.class), EntityCardsInitialCardsSequenceLogger.m12807a((InjectorLike) this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), FbEventSubscriberListManager.a(this));
    }
}
