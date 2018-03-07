package com.facebook.entitycards.surface;

import com.facebook.debug.log.BLog;
import com.facebook.entitycards.analytics.EntityCardsAnalyticsLogger;
import com.facebook.entitycards.analytics.EntityCardsPerfLogger;
import com.facebook.entitycards.collect.ImmutableOffsetArray;
import com.facebook.entitycards.model.EntityCardsDataSource;
import com.facebook.entitycards.model.PagedEntityCardsDataSourceProvider;
import com.facebook.entitycards.service.EntityCardsEntityLoader;
import com.facebook.entitycards.service.EntityCardsPageLoader;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: home_creation_created */
public class EntityCardsSurfaceConfigurationHelper {
    private static final Class f11087a = EntityCardsSurfaceConfigurationHelper.class;
    private final PagedEntityCardsDataSourceProvider f11088b;

    public static EntityCardsSurfaceConfigurationHelper m13024b(InjectorLike injectorLike) {
        return new EntityCardsSurfaceConfigurationHelper((PagedEntityCardsDataSourceProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PagedEntityCardsDataSourceProvider.class));
    }

    @Inject
    public EntityCardsSurfaceConfigurationHelper(PagedEntityCardsDataSourceProvider pagedEntityCardsDataSourceProvider) {
        this.f11088b = pagedEntityCardsDataSourceProvider;
    }

    public final EntityCardsDataSource m13025a(EntityCardsPageLoader entityCardsPageLoader, EntityCardsEntityLoader entityCardsEntityLoader, EntityCardsAnalyticsLogger entityCardsAnalyticsLogger, EntityCardsPerfLogger entityCardsPerfLogger, String str, ImmutableOffsetArray<String> immutableOffsetArray, @Nullable ImmutableMap<String, ?> immutableMap, String str2) {
        ImmutableMap immutableMap2;
        if (immutableMap == null || immutableOffsetArray.m12838b() == immutableMap.size()) {
            ImmutableMap<String, ?> immutableMap3 = immutableMap;
        } else {
            BLog.a(f11087a, "Discarding preliminary {%d} models that don't match the {%d} initial ids", new Object[]{Integer.valueOf(immutableMap.size()), Integer.valueOf(immutableOffsetArray.m12838b())});
            immutableMap2 = null;
        }
        return this.f11088b.m13021a(entityCardsPageLoader, entityCardsEntityLoader, entityCardsAnalyticsLogger, entityCardsPerfLogger, str, immutableOffsetArray, immutableMap2, str2, Integer.valueOf(6), Integer.valueOf(6));
    }
}
