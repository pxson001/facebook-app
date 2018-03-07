package com.facebook.katana.app.module;

import com.facebook.http.qe.LigerEnabledQuickExperimentConfig;
import com.facebook.inject.AbstractProvider;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;

/* compiled from: work_community */
public class LigerEnabledQuickExperimentConfigMethodAutoProvider extends AbstractProvider<LigerEnabledQuickExperimentConfig> {
    public Object get() {
        return MainProcessModule.a((QeAccessor) QeInternalImplMethodAutoProvider.a(this));
    }
}
