package com.facebook.ui.typeahead.querycache;

import com.facebook.common.memory.MemoryManager;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: counts */
public class DefaultTypeaheadQueryCachePolicy {
    private final MemoryTrimmableRegistry f18444a;

    public static DefaultTypeaheadQueryCachePolicy m27057b(InjectorLike injectorLike) {
        return new DefaultTypeaheadQueryCachePolicy((MemoryTrimmableRegistry) MemoryManager.a(injectorLike));
    }

    @Inject
    public DefaultTypeaheadQueryCachePolicy(MemoryTrimmableRegistry memoryTrimmableRegistry) {
        this.f18444a = memoryTrimmableRegistry;
    }

    public boolean m27058a() {
        return true;
    }

    public boolean m27059a(MemoryTrimType memoryTrimType) {
        return false;
    }
}
