package com.facebook.heisman;

import android.app.Activity;
import android.widget.FrameLayout;
import com.facebook.heisman.SingleCategoryFragment.SingleCategoryFragmentDelegate;
import com.facebook.heisman.intent.ProfilePictureOverlayPivotIntentData;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.recyclerview.BetterRecyclerView;

/* compiled from: user_blocked */
public class SingleCategoryFragmentControllerProvider extends AbstractAssistedProvider<SingleCategoryFragmentController> {
    public final SingleCategoryFragmentController m823a(Activity activity, SingleCategoryFragmentDelegate singleCategoryFragmentDelegate, FrameLayout frameLayout, LoadingIndicatorView loadingIndicatorView, BetterRecyclerView betterRecyclerView, ProfilePictureOverlayPivotIntentData profilePictureOverlayPivotIntentData) {
        SingleCategoryFragmentController singleCategoryFragmentController = new SingleCategoryFragmentController(activity, singleCategoryFragmentDelegate, frameLayout, loadingIndicatorView, betterRecyclerView, profilePictureOverlayPivotIntentData);
        singleCategoryFragmentController.m822a(IdBasedSingletonScopeProvider.a(this, 3863), IdBasedSingletonScopeProvider.a(this, 7169), ProfilePictureOverlayAnalyticsLogger.m653a((InjectorLike) this), (ProfilePictureOverlayPivotAdapterProvider) getOnDemandAssistedProviderForStaticDi(ProfilePictureOverlayPivotAdapterProvider.class), IdBasedSingletonScopeProvider.b(this, 494));
        return singleCategoryFragmentController;
    }
}
