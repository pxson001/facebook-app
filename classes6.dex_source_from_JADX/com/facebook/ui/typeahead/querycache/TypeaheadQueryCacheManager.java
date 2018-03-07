package com.facebook.ui.typeahead.querycache;

import com.facebook.common.memory.MemoryManager;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.typeahead.FetchSource;
import com.facebook.ui.typeahead.TypeaheadAbTestGatekeepers;
import com.facebook.ui.typeahead.TypeaheadRequest;
import com.facebook.ui.typeahead.TypeaheadResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.inject.Inject;

/* compiled from: copyToLocalFile() was not successful */
public class TypeaheadQueryCacheManager<T> implements MemoryTrimmable {
    private final GatekeeperStoreImpl f18447a;
    public final HashMap<FetchSource, TypeaheadQueryCache<T>> f18448b = new HashMap();
    private final DefaultTypeaheadQueryCachePolicy f18449c;

    /* compiled from: copyToLocalFile() was not successful */
    public enum MergeStrategy {
        PREPEND,
        APPEND
    }

    public static TypeaheadQueryCacheManager m27069b(InjectorLike injectorLike) {
        return new TypeaheadQueryCacheManager(DefaultTypeaheadQueryCachePolicy.m27057b(injectorLike), (MemoryTrimmableRegistry) MemoryManager.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public TypeaheadQueryCacheManager(DefaultTypeaheadQueryCachePolicy defaultTypeaheadQueryCachePolicy, MemoryTrimmableRegistry memoryTrimmableRegistry, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f18449c = defaultTypeaheadQueryCachePolicy;
        this.f18447a = gatekeeperStoreImpl;
        memoryTrimmableRegistry.a(this);
    }

    public final void m27072a(FetchSource fetchSource, TypeaheadQueryCache<T> typeaheadQueryCache) {
        if (this.f18448b.containsKey(fetchSource)) {
            throw new UnsupportedOperationException("Key already exists.");
        }
        this.f18448b.put(fetchSource, typeaheadQueryCache);
    }

    public final void m27073a(Map<FetchSource, TypeaheadQueryCache<T>> map) {
        for (Entry entry : map.entrySet()) {
            m27072a((FetchSource) entry.getKey(), (TypeaheadQueryCache) entry.getValue());
        }
    }

    public final List<TypeaheadResponse<T>> m27070a(TypeaheadRequest typeaheadRequest) {
        List arrayList = new ArrayList();
        boolean a = this.f18447a.a(TypeaheadAbTestGatekeepers.f18438a, false);
        if (!a) {
            m27068a(typeaheadRequest, arrayList);
        }
        for (FetchSource fetchSource : this.f18448b.keySet()) {
            if (fetchSource.isRemote()) {
                arrayList.add(m27067a(typeaheadRequest, fetchSource));
            }
        }
        if (a) {
            m27068a(typeaheadRequest, arrayList);
        }
        return arrayList;
    }

    public final void m27071a(MemoryTrimType memoryTrimType) {
        if (this.f18449c.m27059a(memoryTrimType)) {
            for (FetchSource fetchSource : this.f18448b.keySet()) {
                TypeaheadQueryCache typeaheadQueryCache = (TypeaheadQueryCache) this.f18448b.get(fetchSource);
                if (typeaheadQueryCache != null) {
                    typeaheadQueryCache.m27063a();
                }
            }
        }
    }

    private void m27068a(TypeaheadRequest typeaheadRequest, List<TypeaheadResponse<T>> list) {
        for (FetchSource fetchSource : this.f18448b.keySet()) {
            if (!fetchSource.isRemote()) {
                TypeaheadResponse a = m27067a(typeaheadRequest, fetchSource);
                if (a != null) {
                    list.add(a);
                }
            }
        }
    }

    private TypeaheadResponse<T> m27067a(TypeaheadRequest typeaheadRequest, FetchSource fetchSource) {
        TypeaheadQueryCache typeaheadQueryCache = (TypeaheadQueryCache) this.f18448b.get(fetchSource);
        if (typeaheadQueryCache == null) {
            return null;
        }
        String str = typeaheadRequest.f15459c;
        String str2 = typeaheadRequest.f15458b;
        if (typeaheadQueryCache.m27065b(str, str2)) {
            return typeaheadQueryCache.m27062a(str, str2);
        }
        return typeaheadQueryCache.m27066c(str, str2);
    }
}
