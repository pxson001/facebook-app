package com.facebook.omnistore.module;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.omnistore.CollectionName;
import com.facebook.omnistore.Delta;
import com.facebook.omnistore.Delta.Status;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;

@UserScoped
@Deprecated
/* compiled from: textString */
public class OmnistoreCallbackRegistration {
    private static final Class<?> TAG = OmnistoreCallbackRegistration.class;
    private static final Object f3208xac5707a0 = new Object();
    private final List<FilteredCallback> mFilteredCallbacks;

    /* compiled from: textString */
    public class BasicDeltaFilter {
        public static final ImmutableSet<Status> ALL_DELTA_STATUSES = ImmutableSet.copyOf(Status.values());
        public static final ImmutableSet<Status> DATA_DELTA_STATUSES = ImmutableSet.of(Status.LOCALLY_COMMITTED, Status.PERSISTED_REMOTE);
        public final ImmutableSet<CollectionName> mCollectionNames;
        public final ImmutableSet<Status> mDeltaStatuses;
    }

    /* compiled from: textString */
    public interface Callback {
        void onDeltas(List<Delta> list);
    }

    /* compiled from: textString */
    public final class FilteredCallback {
        public final Callback mCallback;
        public final BasicDeltaFilter mDeltaFilter;

        public FilteredCallback(Callback callback, BasicDeltaFilter basicDeltaFilter) {
            this.mCallback = callback;
            this.mDeltaFilter = basicDeltaFilter;
        }
    }

    /* compiled from: textString */
    public abstract class FilteredCallbackMultibindWrapper {
        public final Lazy<FilteredCallback> mLazy;

        protected FilteredCallbackMultibindWrapper(Lazy<FilteredCallback> lazy) {
            this.mLazy = lazy;
        }
    }

    private static OmnistoreCallbackRegistration m4245x811eebbb(InjectorLike injectorLike) {
        return new OmnistoreCallbackRegistration(C0177xdf989aac.getSet(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.omnistore.module.OmnistoreCallbackRegistration m4246x66f7df21(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f3208xac5707a0;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m4245x811eebbb(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f3208xac5707a0;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.omnistore.module.OmnistoreCallbackRegistration) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.omnistore.module.OmnistoreCallbackRegistration) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f3208xac5707a0;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.omnistore.module.OmnistoreCallbackRegistration) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.omnistore.module.OmnistoreCallbackRegistration.getInstance__com_facebook_omnistore_module_OmnistoreCallbackRegistration__INJECTED_BY_TemplateInjector(com.facebook.inject.InjectorLike):com.facebook.omnistore.module.OmnistoreCallbackRegistration");
    }

    @Inject
    public OmnistoreCallbackRegistration(Set<FilteredCallbackMultibindWrapper> set) {
        this.mFilteredCallbacks = Lists.a(set.size());
        for (FilteredCallbackMultibindWrapper filteredCallbackMultibindWrapper : set) {
            this.mFilteredCallbacks.add(filteredCallbackMultibindWrapper.mLazy.get());
        }
    }

    public void registerCallback(FilteredCallback filteredCallback) {
        this.mFilteredCallbacks.add(filteredCallback);
    }

    public void unregisterCallback(FilteredCallback filteredCallback) {
        this.mFilteredCallbacks.remove(filteredCallback);
    }

    @Deprecated
    public void onDeltaReceived(Delta[] deltaArr) {
        Integer.valueOf(deltaArr.length);
        for (FilteredCallback filteredCallback : this.mFilteredCallbacks) {
            List list = null;
            for (Delta delta : deltaArr) {
                Object obj;
                BasicDeltaFilter basicDeltaFilter = filteredCallback.mDeltaFilter;
                if (basicDeltaFilter.mCollectionNames.contains(delta.mCollectionName) && basicDeltaFilter.mDeltaStatuses.contains(delta.mStatus)) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    if (list == null) {
                        list = new ArrayList(1);
                    }
                    list.add(delta);
                }
            }
            if (list != null) {
                Integer.valueOf(list.size());
                filteredCallback.mCallback.onDeltas(list);
            }
        }
    }
}
