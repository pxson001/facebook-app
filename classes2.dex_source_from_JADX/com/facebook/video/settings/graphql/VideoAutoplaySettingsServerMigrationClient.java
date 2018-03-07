package com.facebook.video.settings.graphql;

import com.facebook.device_id.UniqueIdForDeviceHolderImpl;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import javax.inject.Inject;

/* compiled from: is_enabled */
public class VideoAutoplaySettingsServerMigrationClient {
    public final GraphQLQueryExecutor f19189a;
    public final UniqueIdForDeviceHolderImpl f19190b;
    public final GraphQLCacheManager f19191c;

    @Inject
    public VideoAutoplaySettingsServerMigrationClient(UniqueIdForDeviceHolderImpl uniqueIdForDeviceHolderImpl, GraphQLQueryExecutor graphQLQueryExecutor, GraphQLCacheManager graphQLCacheManager) {
        this.f19190b = uniqueIdForDeviceHolderImpl;
        this.f19189a = graphQLQueryExecutor;
        this.f19191c = graphQLCacheManager;
    }
}
