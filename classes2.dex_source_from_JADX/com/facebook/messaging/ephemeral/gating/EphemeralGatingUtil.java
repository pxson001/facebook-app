package com.facebook.messaging.ephemeral.gating;

import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.ephemeral.abtest.ExperimentsForEphemeralModule;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mParentGroup */
public class EphemeralGatingUtil {
    public final GatekeeperStoreImpl f15487a;
    public final Product f15488b;
    public final QeAccessor f15489c;

    public static EphemeralGatingUtil m22102b(InjectorLike injectorLike) {
        return new EphemeralGatingUtil(GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), ProductMethodAutoProvider.m4524b(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public EphemeralGatingUtil(GatekeeperStoreImpl gatekeeperStoreImpl, Product product, QeAccessor qeAccessor) {
        this.f15487a = gatekeeperStoreImpl;
        this.f15488b = product;
        this.f15489c = qeAccessor;
    }

    public static EphemeralGatingUtil m22101a(InjectorLike injectorLike) {
        return m22102b(injectorLike);
    }

    public final boolean m22103a() {
        return this.f15487a.m2189a(216, false);
    }

    public final boolean m22105a(@Nullable ThreadSummary threadSummary) {
        return (threadSummary == null || ThreadKey.d(threadSummary.a) || ThreadKey.g(threadSummary.a) || !threadSummary.h() || m22103a()) ? false : true;
    }

    public final boolean m22104a(@Nullable Message message) {
        return (message == null || !MessageUtil.m22058V(message) || m22103a()) ? false : true;
    }

    public final boolean m22106b(ThreadSummary threadSummary) {
        if (threadSummary == null || ThreadKey.d(threadSummary.a) || m22103a()) {
            return false;
        }
        return this.f15489c.mo596a(ExperimentsForEphemeralModule.a, false);
    }
}
