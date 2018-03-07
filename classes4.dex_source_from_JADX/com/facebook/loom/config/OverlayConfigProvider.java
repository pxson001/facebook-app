package com.facebook.loom.config;

import com.facebook.loom.config.Config.RootControllerConfig;
import com.facebook.loom.config.ConfigProvider.ConfigUpdateListener;
import javax.annotation.Nullable;

/* compiled from: get_fbid_status */
public class OverlayConfigProvider implements ConfigProvider, ConfigUpdateListener {
    private final ConfigProvider f11079a;
    private final ConfigProvider f11080b;
    private Config f11081c = new OverlayConfig(this.f11079a.b(), this.f11080b.b());
    @Nullable
    private ConfigUpdateListener f11082d;

    /* compiled from: get_fbid_status */
    class OverlayConfig implements Config {
        private final Config f11112a;
        private final Config f11113b;
        private final OverlayRootControllerConfig f11114c = new OverlayRootControllerConfig(this.f11112a.a(), this.f11113b.a());
        private final OverlaySystemControlConfiguration f11115d = new OverlaySystemControlConfiguration(this.f11112a.b(), this.f11113b.b());

        OverlayConfig(Config config, Config config2) {
            this.f11112a = config;
            this.f11113b = config2;
        }

        public final RootControllerConfig m11570a() {
            return this.f11114c;
        }

        public final SystemControlConfiguration m11571b() {
            return this.f11115d;
        }

        public final int m11572c() {
            return this.f11112a.c() | this.f11113b.c();
        }

        public final long m11573d() {
            return this.f11112a.d() ^ this.f11113b.d();
        }
    }

    /* compiled from: get_fbid_status */
    class OverlayRootControllerConfig implements RootControllerConfig {
        private final RootControllerConfig f11116a;
        private final RootControllerConfig f11117b;

        OverlayRootControllerConfig(RootControllerConfig rootControllerConfig, RootControllerConfig rootControllerConfig2) {
            this.f11116a = rootControllerConfig;
            this.f11117b = rootControllerConfig2;
        }

        public final ControllerConfig m11574a(int i) {
            ControllerConfig a = this.f11116a.a(i);
            return a != null ? a : this.f11117b.a(i);
        }

        public final int m11575b() {
            return Math.max(this.f11116a.b(), this.f11117b.b());
        }

        public final int m11576c() {
            if (this.f11116a.c() == 0) {
                return this.f11117b.c();
            }
            if (this.f11117b.c() == 0) {
                return this.f11116a.c();
            }
            return Math.min(this.f11116a.c(), this.f11117b.c());
        }
    }

    /* compiled from: get_fbid_status */
    class OverlaySystemControlConfiguration extends SystemControlConfiguration {
        private final SystemControlConfiguration f11118a;
        private final SystemControlConfiguration f11119b;

        public OverlaySystemControlConfiguration(SystemControlConfiguration systemControlConfiguration, SystemControlConfiguration systemControlConfiguration2) {
            this.f11118a = systemControlConfiguration;
            this.f11119b = systemControlConfiguration2;
        }

        public final long m11577a() {
            return Math.max(this.f11118a.a(), this.f11119b.a());
        }

        public final long m11578b() {
            return Math.max(this.f11118a.b(), this.f11119b.b());
        }

        public final long m11579c() {
            return Math.min(this.f11118a.c(), this.f11119b.c());
        }
    }

    public OverlayConfigProvider(ConfigProvider configProvider, ConfigProvider configProvider2) {
        this.f11079a = configProvider;
        this.f11080b = configProvider2;
        this.f11079a.a(this);
        this.f11080b.a(this);
    }

    public final void m11503a(@Nullable ConfigUpdateListener configUpdateListener) {
        this.f11082d = configUpdateListener;
    }

    public final Config m11504b() {
        return this.f11081c;
    }

    public final void m11502a(Config config) {
        this.f11081c = new OverlayConfig(this.f11079a.b(), this.f11080b.b());
        ConfigUpdateListener configUpdateListener = this.f11082d;
        if (configUpdateListener != null) {
            configUpdateListener.a(this.f11081c);
        }
    }
}
