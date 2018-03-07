package com.facebook.search.suggestions.simplesearch;

import com.facebook.common.diagnostics.VMMemoryInfo;
import com.facebook.common.diagnostics.VMMemoryInfoMethodAutoProvider;
import com.facebook.common.memory.MemoryManager;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.typeahead.querycache.DefaultTypeaheadQueryCachePolicy;
import javax.inject.Inject;

/* compiled from: vnd.android.cursor.item/contact */
public class SimpleSearchSuggestionTypeaheadQueryCachePolicy extends DefaultTypeaheadQueryCachePolicy {
    private final VMMemoryInfo f283a;

    public static SimpleSearchSuggestionTypeaheadQueryCachePolicy m412c(InjectorLike injectorLike) {
        return new SimpleSearchSuggestionTypeaheadQueryCachePolicy(VMMemoryInfoMethodAutoProvider.a(injectorLike), (MemoryTrimmableRegistry) MemoryManager.a(injectorLike));
    }

    @Inject
    public SimpleSearchSuggestionTypeaheadQueryCachePolicy(VMMemoryInfo vMMemoryInfo, MemoryTrimmableRegistry memoryTrimmableRegistry) {
        super(memoryTrimmableRegistry);
        this.f283a = vMMemoryInfo;
    }

    public final boolean m413a() {
        return this.f283a.a();
    }

    public final boolean m414a(MemoryTrimType memoryTrimType) {
        return memoryTrimType != MemoryTrimType.OnAppBackgrounded;
    }
}
