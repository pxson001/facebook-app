package com.facebook.growth.experiment;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.util.TriState;
import com.facebook.inject.InjectorLike;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: ui_thread_watchdog */
public class InitialAppLaunchExperimentLogger {
    private final AnalyticsLogger f614a;

    public static InitialAppLaunchExperimentLogger m986b(InjectorLike injectorLike) {
        return new InitialAppLaunchExperimentLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public InitialAppLaunchExperimentLogger(AnalyticsLogger analyticsLogger) {
        this.f614a = analyticsLogger;
    }

    public final void m988a(String str, boolean z) {
        m985a(str, z, null);
    }

    public static InitialAppLaunchExperimentLogger m983a(InjectorLike injectorLike) {
        return m986b(injectorLike);
    }

    private void m985a(String str, boolean z, @Nullable Map<String, ?> map) {
        m984a(str, z ? "test" : "control", (Map) map);
    }

    public final void m987a(String str, TriState triState, @Nullable Map<String, ?> map) {
        String str2;
        switch (1.a[triState.ordinal()]) {
            case 1:
                str2 = "test";
                break;
            case 2:
                str2 = "control";
                break;
            default:
                str2 = "unset";
                break;
        }
        m984a(str, str2, (Map) map);
    }

    private void m984a(String str, String str2, @Nullable Map<String, ?> map) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("initial_app_launch_experiment_exposure");
        honeyClientEvent.c = "experiment";
        this.f614a.c(honeyClientEvent.b("exp_name", str).b("exp_group", str2).a(map));
    }
}
