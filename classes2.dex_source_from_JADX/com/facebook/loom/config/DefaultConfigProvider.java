package com.facebook.loom.config;

import com.facebook.loom.config.Config.RootControllerConfig;
import com.facebook.loom.config.ConfigProvider.ConfigUpdateListener;
import javax.annotation.Nullable;

/* compiled from: zero_rating2/clearable/default_optin/last_displayed_time_key */
public class DefaultConfigProvider implements ConfigProvider {
    public static final Config f449a = new C00171();

    /* compiled from: zero_rating2/clearable/default_optin/last_displayed_time_key */
    final class C00171 implements Config {
        public final ControllerConfig f455a = new C00181(this);

        /* compiled from: zero_rating2/clearable/default_optin/last_displayed_time_key */
        class C00181 implements ControllerConfig {
            final /* synthetic */ C00171 f456a;

            C00181(C00171 c00171) {
                this.f456a = c00171;
            }
        }

        /* compiled from: zero_rating2/clearable/default_optin/last_displayed_time_key */
        class C00192 implements RootControllerConfig {
            final /* synthetic */ C00171 f493a;

            C00192(C00171 c00171) {
                this.f493a = c00171;
            }

            @Nullable
            public final ControllerConfig mo82a(int i) {
                if (i == 4) {
                    return this.f493a.f455a;
                }
                return null;
            }

            public final int mo83b() {
                return 30000;
            }

            public final int mo84c() {
                return 0;
            }
        }

        C00171() {
        }

        public final RootControllerConfig mo74a() {
            return new C00192(this);
        }

        public final SystemControlConfiguration mo75b() {
            return new SystemControlConfiguration();
        }

        public final int mo76c() {
            return 0;
        }

        public final long mo77d() {
            return 0;
        }
    }

    public final void mo63a(ConfigUpdateListener configUpdateListener) {
    }

    public final Config mo64b() {
        return f449a;
    }
}
