package com.facebook.resources.impl.loading;

import com.facebook.resources.impl.FbResourcesLogger;
import com.facebook.resources.impl.loading.LanguagePackLoader.Delegate;
import java.io.InputStream;
import javax.inject.Inject;

/* compiled from: work_registration_autologin_nonce */
public class AssetLanguagePackLoaderDelegate implements Delegate {
    private final LanguageAssetStreamProvider f74a;
    private final FbResourcesLogger f75b;

    @Inject
    public AssetLanguagePackLoaderDelegate(LanguageAssetStreamProvider languageAssetStreamProvider, FbResourcesLogger fbResourcesLogger) {
        this.f75b = fbResourcesLogger;
        this.f74a = languageAssetStreamProvider;
    }

    public final InputStream m73a(LanguageRequest languageRequest) {
        return this.f74a.m81a(languageRequest);
    }

    public final void m74a() {
        this.f75b.a();
    }

    public final void m75b() {
        this.f75b.b();
    }

    public final void m77c() {
        this.f75b.c();
    }

    public final void m76b(LanguageRequest languageRequest) {
    }
}
