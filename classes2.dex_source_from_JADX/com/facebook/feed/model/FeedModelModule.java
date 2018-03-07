package com.facebook.feed.model;

import com.facebook.feed.flatbuffers.FlatBufferFileLoader;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: session_write_fail_count */
public class FeedModelModule extends AbstractLibraryModule {
    @ProviderMethod
    @Singleton
    static FlatBufferFileLoader m9278a() {
        return new FlatBufferFileLoader();
    }

    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }
}
