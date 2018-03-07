package com.facebook.adinterfaces.ui;

import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.util.BoostMutationHelper;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;

/* compiled from: Unsupported operation type */
public class BoostPostPromotionDetailsViewControllerProvider extends AbstractAssistedProvider<BoostPostPromotionDetailsViewController> {
    public final BoostPostPromotionDetailsViewController m25061a(BoostMutationHelper boostMutationHelper) {
        return new BoostPostPromotionDetailsViewController(boostMutationHelper, AdInterfacesDataHelper.m22789a((InjectorLike) this), AdInterfacesReactUtil.m24849b(this), (QeAccessor) QeInternalImplMethodAutoProvider.a(this));
    }
}
