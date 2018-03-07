package com.facebook.messaging.montage;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.user.cache.UserCache;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: iso-8859-3 */
public class MontageTestHelper {
    private static final Map<Long, Long> f12396a = ImmutableMap.builder().b(Long.valueOf(553165088), Long.valueOf(1420553141608097L)).b(Long.valueOf(4811245), Long.valueOf(774790075967141L)).b(Long.valueOf(1340940008), Long.valueOf(890901957649127L)).b(Long.valueOf(1348324005), Long.valueOf(436780519863714L)).b(Long.valueOf(1214261443), Long.valueOf(1644545592466640L)).b(Long.valueOf(800665194), Long.valueOf(888372717899374L)).b(Long.valueOf(810341), Long.valueOf(760129244095954L)).b(Long.valueOf(505131734), Long.valueOf(1079155135460001L)).b(Long.valueOf(499601341), Long.valueOf(991540034273183L)).b(Long.valueOf(616344404), Long.valueOf(1466178137026549L)).b(Long.valueOf(1108680390), Long.valueOf(596343097172876L)).b(Long.valueOf(209206), Long.valueOf(1592766084321708L)).b(Long.valueOf(517294852), Long.valueOf(710762482363587L)).b(Long.valueOf(2500173), Long.valueOf(479489615542749L)).b(Long.valueOf(1239220), Long.valueOf(863090383787546L)).b(Long.valueOf(122601020), Long.valueOf(906186226091037L)).b(Long.valueOf(807465453), Long.valueOf(522834447863980L)).b(Long.valueOf(509407057), Long.valueOf(632201456915721L)).b(Long.valueOf(500136192), Long.valueOf(909245649137597L)).b(Long.valueOf(590655129), Long.valueOf(558330517650351L)).b();
    private final GatekeeperStoreImpl f12397b;
    private final Provider<UserCache> f12398c;
    private final Provider<UserKey> f12399d;

    public static MontageTestHelper m12872b(InjectorLike injectorLike) {
        return new MontageTestHelper(GatekeeperStoreImplMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 3593), IdBasedProvider.a(injectorLike, 3597));
    }

    public static MontageTestHelper m12871a(InjectorLike injectorLike) {
        return m12872b(injectorLike);
    }

    @Inject
    public MontageTestHelper(GatekeeperStore gatekeeperStore, Provider<UserCache> provider, Provider<UserKey> provider2) {
        this.f12397b = gatekeeperStore;
        this.f12398c = provider;
        this.f12399d = provider2;
    }

    public final boolean m12876a(ThreadKey threadKey) {
        ThreadKey a = m12874a();
        return a != null && a.equals(threadKey);
    }

    @Nullable
    public final ThreadKey m12874a() {
        UserKey userKey = (UserKey) this.f12399d.get();
        if (userKey == null) {
            return null;
        }
        return m12875a(userKey);
    }

    public final boolean m12878b() {
        return this.f12397b.a(970, false);
    }

    public final boolean m12879c() {
        return m12878b() && this.f12397b.a(951, false);
    }

    @Nullable
    public final ThreadKey m12877b(ThreadKey threadKey) {
        if (!m12878b() || threadKey.b() || threadKey.c()) {
            return null;
        }
        if (threadKey.d()) {
            return threadKey;
        }
        UserKey a = ThreadKey.a(threadKey);
        if (a == null) {
            return null;
        }
        return m12875a(a);
    }

    public final boolean m12880c(@Nullable ThreadKey threadKey) {
        if (threadKey == null || !m12878b()) {
            return false;
        }
        if (threadKey.d()) {
            return true;
        }
        if (m12873d()) {
            for (Long longValue : f12396a.values()) {
                if (longValue.longValue() == threadKey.b) {
                    return true;
                }
            }
        }
        return false;
    }

    @Nullable
    public final ThreadKey m12875a(UserKey userKey) {
        long parseLong = Long.parseLong(userKey.b());
        if (m12873d()) {
            Long l = (Long) f12396a.get(Long.valueOf(parseLong));
            if (l != null) {
                return ThreadKey.b(l.longValue(), parseLong);
            }
        }
        User a = ((UserCache) this.f12398c.get()).a(userKey);
        if (a != null) {
            long j = a.M;
            if (j != 0) {
                return ThreadKey.b(j, parseLong);
            }
        }
        return null;
    }

    private boolean m12873d() {
        return this.f12397b.a(952, false);
    }
}
