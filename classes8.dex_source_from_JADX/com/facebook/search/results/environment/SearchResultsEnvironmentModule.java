package com.facebook.search.results.environment;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;

@InjectorModule
/* compiled from: Should only be called for One-to-one threads! */
public class SearchResultsEnvironmentModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }
}
