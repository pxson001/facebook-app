package com.facebook.adinterfaces.ui;

import com.facebook.adinterfaces.util.BoostMutationHelper;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;

/* compiled from: VERIFY_PAYMENT_METHOD */
public class AdInterfacesBoostPostFooterViewControllerProvider extends AbstractAssistedProvider<AdInterfacesBoostPostFooterViewController> {
    public final AdInterfacesBoostPostFooterViewController m24509a(BoostMutationHelper boostMutationHelper) {
        return new AdInterfacesBoostPostFooterViewController(boostMutationHelper, BudgetHelper.m25096a((InjectorLike) this), AdInterfacesLegalUtil.m24675a(this), (QeAccessor) QeInternalImplMethodAutoProvider.a(this));
    }
}
