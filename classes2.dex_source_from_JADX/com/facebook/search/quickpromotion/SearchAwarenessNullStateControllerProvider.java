package com.facebook.search.quickpromotion;

import android.content.Context;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.logging.SearchAwarenessLogger;
import com.facebook.search.model.SearchAwarenessUnitProperties;

/* compiled from: show_comment_cache_state */
public class SearchAwarenessNullStateControllerProvider extends AbstractAssistedProvider<SearchAwarenessNullStateController> {
    public final SearchAwarenessNullStateController m8761a(SearchAwarenessUnitProperties searchAwarenessUnitProperties, boolean z) {
        return new SearchAwarenessNullStateController((Context) getInstance(Context.class), searchAwarenessUnitProperties, z, SearchAwarenessLogger.m12394b((InjectorLike) this), SearchAwarenessOptOutController.a(this), QeInternalImplMethodAutoProvider.m3744a(this), SystemClockMethodAutoProvider.m1498a(this));
    }
}
