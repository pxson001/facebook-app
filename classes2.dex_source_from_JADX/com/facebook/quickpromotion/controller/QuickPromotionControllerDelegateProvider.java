package com.facebook.quickpromotion.controller;

import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.quickpromotion.filter.QuickPromotionCounters;
import com.facebook.quickpromotion.validators.QuickPromotionActionLimitValidator;
import com.facebook.quickpromotion.validators.QuickPromotionDefinitionValidator;

/* compiled from: reactions_ufi */
public class QuickPromotionControllerDelegateProvider extends AbstractAssistedProvider<QuickPromotionControllerDelegate> {
    public final QuickPromotionControllerDelegate m12556a(QuickPromotionController quickPromotionController) {
        return new QuickPromotionControllerDelegate(quickPromotionController, QuickPromotionDefinitionValidator.m12569b((InjectorLike) this), IdBasedSingletonScopeProvider.m1810b(this, 9827), QuickPromotionActionLimitValidator.m12573b(this), IdBasedLazy.m1808a(this, 9826), IdBasedSingletonScopeProvider.m1810b(this, 3235), FbSharedPreferencesImpl.m1826a((InjectorLike) this), IdBasedLazy.m1808a(this, 3239), SystemClockMethodAutoProvider.m1498a(this), IdBasedSingletonScopeProvider.m1810b(this, 9822), QuickPromotionCounters.m12575a((InjectorLike) this), DefaultAppChoreographer.m1621a((InjectorLike) this), IdBasedSingletonScopeProvider.m1810b(this, 9772), QeInternalImplMethodAutoProvider.m3744a(this));
    }
}
