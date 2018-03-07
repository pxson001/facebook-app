package com.facebook.loom.config.coldstart;

import com.facebook.loom.config.Config;
import com.facebook.loom.config.Config.RootControllerConfig;
import com.facebook.loom.config.SystemControlConfiguration;

/* compiled from: ticket_info_count */
public class InitFileConfig implements Config {
    private final long f1432a;
    public final InitFileRootControllerConfig f1433b;

    InitFileConfig(long j, InitFileConfigProvider$InitFileConfigData[] initFileConfigProvider$InitFileConfigDataArr) {
        this.f1432a = j;
        this.f1433b = new InitFileRootControllerConfig(initFileConfigProvider$InitFileConfigDataArr);
    }

    public final RootControllerConfig m1431a() {
        return this.f1433b;
    }

    public final int m1433c() {
        return 0;
    }

    public final long m1434d() {
        return this.f1432a;
    }

    public final SystemControlConfiguration m1432b() {
        return new SystemControlConfiguration();
    }
}
