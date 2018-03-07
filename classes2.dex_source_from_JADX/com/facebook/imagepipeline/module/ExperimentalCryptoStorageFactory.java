package com.facebook.imagepipeline.module;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.crypto.Crypto;
import com.facebook.crypto.module.LoggedInUserCrypto;
import com.facebook.imagepipeline.core.DiskStorageFactory;
import com.facebook.imagepipeline.core.DynamicDefaultDiskStorageFactory;
import com.facebook.imagepipeline.internal.ExperimentalCryptoConfig;
import com.facebook.imagepipeline.internal.ExperimentalCryptoDiskStorage;
import com.facebook.inject.Lazy;
import javax.inject.Provider;

/* compiled from: orderby_home_story_param */
class ExperimentalCryptoStorageFactory implements DiskStorageFactory {
    private final Lazy<Crypto> f10826a;
    private final Lazy<Crypto> f10827b;
    private final Lazy<Crypto> f10828c;
    private final Lazy<LoggedInUserCrypto> f10829d;
    private final Provider<ExperimentalCryptoConfig> f10830e;
    private final AbstractFbErrorReporter f10831f;

    public ExperimentalCryptoStorageFactory(Lazy<Crypto> lazy, Lazy<Crypto> lazy2, Lazy<Crypto> lazy3, Lazy<LoggedInUserCrypto> lazy4, Provider<ExperimentalCryptoConfig> provider, FbErrorReporter fbErrorReporter) {
        this.f10826a = lazy;
        this.f10827b = lazy2;
        this.f10828c = lazy3;
        this.f10829d = lazy4;
        this.f10830e = provider;
        this.f10831f = fbErrorReporter;
    }

    public final DiskStorage mo2067a(DiskCacheConfig diskCacheConfig) {
        return new ExperimentalCryptoDiskStorage(new DynamicDefaultDiskStorageFactory().mo2067a(diskCacheConfig), (Crypto) this.f10826a.get(), (Crypto) this.f10827b.get(), (Crypto) this.f10828c.get(), (LoggedInUserCrypto) this.f10829d.get(), this.f10830e, this.f10831f);
    }
}
