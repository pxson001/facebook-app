package com.facebook.search.abtest;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.video.videohome.abtest.ExperimentsForVideoHomeAbTestModule;
import javax.inject.Inject;

/* compiled from: souvenirs_db */
public class VideoSearchExperimentHelper {
    public final QeAccessor f4264a;
    public final GatekeeperStoreImpl f4265b;

    public static VideoSearchExperimentHelper m7893b(InjectorLike injectorLike) {
        return new VideoSearchExperimentHelper(QeInternalImplMethodAutoProvider.m3744a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike));
    }

    @Inject
    public VideoSearchExperimentHelper(QeAccessor qeAccessor, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f4264a = qeAccessor;
        this.f4265b = gatekeeperStoreImpl;
    }

    public final boolean m7894a() {
        int a = this.f4264a.mo572a(ExperimentsForVideoHomeAbTestModule.f6999m, -1);
        if (a == -1) {
            return this.f4265b.m2189a(SearchAbTestGatekeepers.f7124F, false);
        }
        if (a != 1) {
            return false;
        }
        return true;
    }

    public static VideoSearchExperimentHelper m7892a(InjectorLike injectorLike) {
        return m7893b(injectorLike);
    }
}
