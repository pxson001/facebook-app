package com.facebook.katana.app.module;

import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.provider.legacykeyvalue.LegacyKeyValueStore;

/* compiled from: get_robotext_preview_method */
public class LegacyKeyValueStore_UserValuesManagerBackendMethodAutoProvider extends AbstractProvider<LegacyKeyValueStore> {
    public static LegacyKeyValueStore m11495b(InjectorLike injectorLike) {
        return MainProcessModule.a(ContentResolverMethodAutoProvider.b(injectorLike.getApplicationInjector()), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    public Object get() {
        return MainProcessModule.a(ContentResolverMethodAutoProvider.b(getApplicationInjector()), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this));
    }
}
