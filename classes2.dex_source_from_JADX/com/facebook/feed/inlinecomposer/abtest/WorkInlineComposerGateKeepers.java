package com.facebook.feed.inlinecomposer.abtest;

import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: percent_time_dropped_frames_5+ */
public class WorkInlineComposerGateKeepers {
    private final GatekeeperStoreImpl f10217a;
    private final boolean f10218b;

    public static WorkInlineComposerGateKeepers m15308b(InjectorLike injectorLike) {
        return new WorkInlineComposerGateKeepers(GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), Boolean_IsWorkBuildMethodAutoProvider.m4525a(injectorLike));
    }

    @Inject
    public WorkInlineComposerGateKeepers(GatekeeperStoreImpl gatekeeperStoreImpl, Boolean bool) {
        this.f10217a = gatekeeperStoreImpl;
        this.f10218b = bool.booleanValue();
    }

    public final boolean m15309a() {
        return this.f10218b && this.f10217a.m2189a(1184, false);
    }

    public final boolean m15310b() {
        return this.f10218b && this.f10217a.m2189a(1122, false);
    }

    public static WorkInlineComposerGateKeepers m15307a(InjectorLike injectorLike) {
        return m15308b(injectorLike);
    }
}
