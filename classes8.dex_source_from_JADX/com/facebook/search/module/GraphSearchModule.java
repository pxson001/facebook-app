package com.facebook.search.module;

import android.annotation.SuppressLint;
import android.content.Context;
import android.preference.Preference;
import com.facebook.analytics.logger.AnalyticsConfig;
import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.common.perftest.base.PerfTestConfigBase;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderMethod;
import com.facebook.prefs.provider.IProvidePreferences;
import com.facebook.search.logging.perf.SearchPerfLogger;
import com.facebook.search.logging.perf.SearchPerfLoggerImpl;
import com.facebook.search.logging.perf.SearchPerfNoOpLogger;
import com.facebook.search.prefs.ForGraphSearch;
import com.facebook.search.prefs.GraphSearchPreferenceCategory;
import com.facebook.search.suggestions.BaseSuggestionsTypeaheadController;
import com.facebook.search.suggestions.simplesearch.SimpleSearchSuggestionsTypeaheadController;
import com.facebook.ui.typeahead.BaseTypeaheadController.TypeaheadDispatchStrategy;
import com.facebook.ui.typeahead.DefaultTypeaheadDispatchStrategy;
import com.facebook.ui.typeahead.querycache.TypeaheadQueryCache;
import com.facebook.ui.typeahead.querycache.TypeaheadQueryCacheSupplier;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.inject.Provider;
import javax.inject.Singleton;

@InjectorModule
@SuppressLint({"NontrivialConfigureMethod"})
/* compiled from: TEXT_STYLE */
public class GraphSearchModule extends AbstractLibraryModule {

    /* compiled from: TEXT_STYLE */
    final class C23731 implements IProvidePreferences {
        C23731() {
        }

        public final List<Preference> m25828a(Context context) {
            return ImmutableList.of(new GraphSearchPreferenceCategory(context));
        }
    }

    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    static BaseSuggestionsTypeaheadController m25831a(Provider<SimpleSearchSuggestionsTypeaheadController> provider) {
        return (BaseSuggestionsTypeaheadController) provider.get();
    }

    @ProviderMethod
    static TypeaheadDispatchStrategy m25832b(Provider<DefaultTypeaheadDispatchStrategy> provider) {
        return (DefaultTypeaheadDispatchStrategy) provider.get();
    }

    @ProviderMethod
    static SearchPerfLogger m25830a(PerfTestConfig perfTestConfig, AnalyticsConfig analyticsConfig, Lazy<SearchPerfLoggerImpl> lazy, Lazy<SearchPerfNoOpLogger> lazy2) {
        return (PerfTestConfigBase.a() || analyticsConfig.c()) ? (SearchPerfLogger) lazy.get() : (SearchPerfLogger) lazy2.get();
    }

    @ProviderMethod
    @ForGraphSearch
    static IProvidePreferences m25829a() {
        return new C23731();
    }

    @ProviderMethod
    @Singleton
    static TypeaheadQueryCacheSupplier m25833c(Provider<TypeaheadQueryCache> provider) {
        return new TypeaheadQueryCacheSupplier((TypeaheadQueryCache) provider.get(), (TypeaheadQueryCache) provider.get(), (TypeaheadQueryCache) provider.get(), (TypeaheadQueryCache) provider.get());
    }
}
