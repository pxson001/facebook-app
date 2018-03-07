package com.facebook.common.ui.animation;

import android.animation.ObjectAnimator;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.animations.AnimationUtil;
import com.facebook.zero.FbZeroFeatureVisibilityHelper;
import javax.inject.Inject;

/* compiled from: place_picker_nonintrusive_error_no_wireless */
public class JewelPopupCommonAnimationHelper {
    private ObjectAnimator f7753a = null;
    private final AnimationUtil f7754b;
    private final FbZeroFeatureVisibilityHelper f7755c;
    private final Boolean f7756d;

    private static JewelPopupCommonAnimationHelper m11078b(InjectorLike injectorLike) {
        return new JewelPopupCommonAnimationHelper(AnimationUtil.a(injectorLike), FbZeroFeatureVisibilityHelper.a(injectorLike), Boolean_IsJewelPopupZeroRatingFeatureEnabledMethodAutoProvider.m11076a(injectorLike));
    }

    @Inject
    public JewelPopupCommonAnimationHelper(AnimationUtil animationUtil, FbZeroFeatureVisibilityHelper fbZeroFeatureVisibilityHelper, Boolean bool) {
        this.f7754b = animationUtil;
        this.f7755c = fbZeroFeatureVisibilityHelper;
        this.f7756d = bool;
    }
}
