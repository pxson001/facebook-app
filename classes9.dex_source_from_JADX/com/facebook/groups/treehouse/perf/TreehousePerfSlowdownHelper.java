package com.facebook.groups.treehouse.perf;

import android.util.SparseArray;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.groups.treehouse.constants.UseReact;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;

/* compiled from: payment_card */
public class TreehousePerfSlowdownHelper {
    private static final SparseArray<NavigationType> f7050a = new C07411();
    private final ScheduledExecutorService f7051b;
    private final UseReact f7052c;
    private final QeAccessor f7053d;

    /* compiled from: payment_card */
    final class C07411 extends SparseArray<NavigationType> {
        C07411() {
            put(ContentFragmentType.GROUPS_MALL_FRAGMENT.ordinal(), NavigationType.GROUP_MALL);
            put(ContentFragmentType.GROUPS_TABBED_MALL_FRAGMENT.ordinal(), NavigationType.GROUP_MALL);
        }
    }

    /* compiled from: payment_card */
    public enum NavigationType {
        GROUP_MALL(ExperimentsForTreehousePerfModule.f7041a),
        TAIL_FETCH(ExperimentsForTreehousePerfModule.f7042b);
        
        private final int param;

        private NavigationType(int i) {
            this.param = i;
        }

        public final int getParam() {
            return this.param;
        }
    }

    private static TreehousePerfSlowdownHelper m7328b(InjectorLike injectorLike) {
        return new TreehousePerfSlowdownHelper((ScheduledExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (UseReact) null, (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public TreehousePerfSlowdownHelper(ScheduledExecutorService scheduledExecutorService, UseReact useReact, QeAccessor qeAccessor) {
        this.f7051b = scheduledExecutorService;
        this.f7052c = useReact;
        this.f7053d = qeAccessor;
    }
}
