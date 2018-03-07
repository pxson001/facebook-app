package com.facebook.analytics.feature;

import com.facebook.datasensitivity.pref.DataSavingsFeatureStatus;
import com.facebook.datasensitivity.pref.DataSensitivitySettingsPrefUtil;
import com.facebook.dialtone.DialtoneFeatureStatus;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.zero.feature.ZeroFeatureStatus;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: updateDeviceSyncOlderPhotosOnServer */
public final class STATICDI_MULTIBIND_PROVIDER$FeatureStatus implements MultiBindIndexedProvider<FeatureStatus>, Provider<Set<FeatureStatus>> {
    private final InjectorLike f516a;

    public STATICDI_MULTIBIND_PROVIDER$FeatureStatus(InjectorLike injectorLike) {
        this.f516a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f516a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 3;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new DataSavingsFeatureStatus(DataSensitivitySettingsPrefUtil.a(injector));
            case 1:
                return new DialtoneFeatureStatus(IdBasedProvider.a(injector, 3954));
            case 2:
                return new ZeroFeatureStatus(IdBasedProvider.a(injector, 4034));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
