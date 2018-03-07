package com.facebook.backgroundworklog;

import com.facebook.backgroundworklog.observer.MultiplexBackgroundWorkObserver;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;

/* compiled from: select_composer_shortcut_from_overflow */
public class DumpBackgroundWorkLoggerAutoProvider extends AbstractProvider<DumpBackgroundWorkLogger> {
    public Object get() {
        return new DumpBackgroundWorkLogger(IdBasedSingletonScopeProvider.b(this, 3078), (DumpStatsCollectorProvider) getInstance(DumpStatsCollectorProvider.class), MultiplexBackgroundWorkObserver.a(this));
    }
}
