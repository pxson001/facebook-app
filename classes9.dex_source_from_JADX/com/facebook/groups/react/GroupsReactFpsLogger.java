package com.facebook.groups.react;

import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.debug.fps.FrameRateLogger;
import com.facebook.debug.fps.FrameRateLoggerProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.react.views.scroll.FpsListener;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.base.Optional;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import javax.inject.Inject;

/* compiled from: payment_options */
public class GroupsReactFpsLogger implements FpsListener {
    private final FrameRateLoggerProvider f7024a;
    private final Map<String, FrameRateLogger> f7025b = new HashMap();
    private final ExecutorService f7026c;
    private Future f7027d;
    private String f7028e = "";

    private static GroupsReactFpsLogger m7321b(InjectorLike injectorLike) {
        return new GroupsReactFpsLogger((FrameRateLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FrameRateLoggerProvider.class), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public GroupsReactFpsLogger(FrameRateLoggerProvider frameRateLoggerProvider, ExecutorService executorService) {
        this.f7026c = executorService;
        this.f7024a = frameRateLoggerProvider;
    }

    public static FrameRateLogger m7322c(GroupsReactFpsLogger groupsReactFpsLogger, String str) {
        groupsReactFpsLogger.f7028e = str;
        if (!groupsReactFpsLogger.f7025b.containsKey(str)) {
            groupsReactFpsLogger.f7025b.put(str, groupsReactFpsLogger.f7024a.a(Boolean.valueOf(false), str, Optional.of("GROUPS_SCROLL_PERF")));
        }
        return (FrameRateLogger) groupsReactFpsLogger.f7025b.get(str);
    }

    public final void mo274a(String str) {
        if (!(this.f7027d == null || this.f7027d.isCancelled() || this.f7027d.isDone())) {
            this.f7027d.cancel(false);
        }
        m7322c(this, str).a();
    }

    public final void mo275b(final String str) {
        this.f7027d = ExecutorDetour.a(this.f7026c, new Runnable(this) {
            final /* synthetic */ GroupsReactFpsLogger f7023b;

            public void run() {
                GroupsReactFpsLogger.m7322c(this.f7023b, str).b();
            }
        }, Integer.valueOf(40), 191333203);
    }
}
