package com.facebook.graphql.executor.filemap;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;

/* compiled from: smsto */
public class DefaultFlatBufferCorruptionHandlerProvider extends AbstractAssistedProvider<DefaultFlatBufferCorruptionHandler> {
    public final DefaultFlatBufferCorruptionHandler m8185a(PrefKey prefKey) {
        return new DefaultFlatBufferCorruptionHandler(FbSharedPreferencesImpl.m1826a((InjectorLike) this), prefKey);
    }
}
