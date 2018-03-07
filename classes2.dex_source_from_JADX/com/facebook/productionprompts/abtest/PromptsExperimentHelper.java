package com.facebook.productionprompts.abtest;

import com.facebook.feed.inlinecomposer.abtest.ExperimentsForInlineComposerTestModule;
import com.facebook.feed.inlinecomposer.abtest.InlineComposerGatekeepers;
import com.facebook.feed.photoreminder.abtest.PhotoReminderGatekeeperHelper;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: percent_time_dropped_frames_2+ */
public class PromptsExperimentHelper {
    public final QeAccessor f10219a;
    public final PhotoReminderGatekeeperHelper f10220b;
    public final GatekeeperStoreImpl f10221c;

    public static PromptsExperimentHelper m15312b(InjectorLike injectorLike) {
        return new PromptsExperimentHelper(QeInternalImplMethodAutoProvider.m3744a(injectorLike), PhotoReminderGatekeeperHelper.m15318b(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike));
    }

    @Inject
    public PromptsExperimentHelper(QeAccessor qeAccessor, PhotoReminderGatekeeperHelper photoReminderGatekeeperHelper, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f10219a = qeAccessor;
        this.f10220b = photoReminderGatekeeperHelper;
        this.f10221c = gatekeeperStoreImpl;
    }

    public static PromptsExperimentHelper m15311a(InjectorLike injectorLike) {
        return m15312b(injectorLike);
    }

    public final boolean m15313b() {
        return !m15314c();
    }

    public final boolean m15314c() {
        return this.f10219a.mo596a(ExperimentsForProductionPromptsAbtestModule.f13419h, false);
    }

    public final boolean m15315d() {
        return this.f10221c.m2189a(InlineComposerGatekeepers.f14280a, false);
    }

    public final boolean m15316f() {
        return this.f10219a.mo596a(ExperimentsForInlineComposerTestModule.f12760e, false);
    }

    public final boolean m15317r() {
        return this.f10219a.mo596a(ExperimentsForProductionPromptsAbtestModule.f13417f, true);
    }
}
