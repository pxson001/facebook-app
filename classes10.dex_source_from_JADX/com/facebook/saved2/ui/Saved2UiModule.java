package com.facebook.saved2.ui;

import com.facebook.crudolib.dbquery.loader.inprocess.NoContentProviderQueryExecutor;
import com.facebook.crudolib.dbquery.loader.inprocessmodule.NoContentProviderQueryExecutorFactory;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.saved2.model.Saved2DatabaseProvider;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: instant_shopping/ */
public class Saved2UiModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    @Saved2QueryExecutor
    static NoContentProviderQueryExecutor m9782a(NoContentProviderQueryExecutorFactory noContentProviderQueryExecutorFactory, Saved2DatabaseProvider saved2DatabaseProvider) {
        return new NoContentProviderQueryExecutor(noContentProviderQueryExecutorFactory.a, noContentProviderQueryExecutorFactory.b, saved2DatabaseProvider);
    }
}
