package com.facebook.entitycards.model;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.entitycards.EntityCardsAdapterProvider;
import com.facebook.entitycards.analytics.EntityCardsAnalyticsLogger;
import com.facebook.entitycards.analytics.EntityCardsPerfLogger;
import com.facebook.entitycards.collect.ImmutableOffsetArray;
import com.facebook.entitycards.service.EntityCardsEntityLoader;
import com.facebook.entitycards.service.EntityCardsPageLoader;
import com.facebook.inject.AbstractAssistedProvider;
import com.google.common.collect.ImmutableMap;
import java.util.concurrent.Executor;

/* compiled from: horizontal_position */
public class PagedEntityCardsDataSourceProvider extends AbstractAssistedProvider<PagedEntityCardsDataSource> {
    public final PagedEntityCardsDataSource m13021a(EntityCardsPageLoader entityCardsPageLoader, EntityCardsEntityLoader entityCardsEntityLoader, EntityCardsAnalyticsLogger entityCardsAnalyticsLogger, EntityCardsPerfLogger entityCardsPerfLogger, String str, ImmutableOffsetArray<String> immutableOffsetArray, ImmutableMap<String, ?> immutableMap, String str2, Integer num, Integer num2) {
        return new PagedEntityCardsDataSource(entityCardsPageLoader, entityCardsEntityLoader, entityCardsAnalyticsLogger, entityCardsPerfLogger, str, immutableOffsetArray, immutableMap, str2, num, num2, (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), (EntityCardsAdapterProvider) getOnDemandAssistedProviderForStaticDi(EntityCardsAdapterProvider.class));
    }
}
