package com.facebook.graphql.executor.iface;

import com.facebook.graphql.cursor.database.GraphCursorDatabase;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$GraphQLOptimisticConsistentCache implements MultiBindIndexedProvider<GraphQLOptimisticConsistentCache>, Provider<Set<GraphQLOptimisticConsistentCache>> {
    private final InjectorLike f12483a;

    public STATICDI_MULTIBIND_PROVIDER$GraphQLOptimisticConsistentCache(InjectorLike injectorLike) {
        this.f12483a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f12483a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 1;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return GraphCursorDatabase.a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
