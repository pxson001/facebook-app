package com.facebook.entitycards.analytics;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.PerformanceLogger;
import com.google.common.base.Optional;

/* compiled from: indices_selected */
public class EntityCardsPerfLoggerProvider extends AbstractAssistedProvider<EntityCardsPerfLogger> {
    public final EntityCardsPerfLogger m12830a(String str, String str2, Optional<String> optional) {
        return new EntityCardsPerfLogger((PerformanceLogger) DelegatingPerformanceLogger.a(this), str, str2, optional);
    }
}
