package com.facebook.heisman;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.facebook.base.fragment.FbFragment;
import com.facebook.heisman.intent.ProfilePictureOverlayPivotIntentData;
import com.facebook.heisman.protocol.ProfileOverlayCategoryGraphQLModels.ProfileOverlayCategoryPageFieldsModel;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ultralight.Inject;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import javax.annotation.Nullable;

/* compiled from: video_lists */
public class SingleCategoryFragment extends FbFragment {
    @Inject
    public SingleCategoryFragmentControllerProvider f771a;
    @Nullable
    private SingleCategoryFragmentController f772b;
    public SingleCategoryFragmentDelegate f773c;

    /* compiled from: video_lists */
    public interface SingleCategoryFragmentDelegate {
        void mo16a(ProfileOverlayCategoryPageFieldsModel profileOverlayCategoryPageFieldsModel, int i);

        void mo17b(String str);
    }

    public static void m811a(Object obj, Context context) {
        ((SingleCategoryFragment) obj).f771a = (SingleCategoryFragmentControllerProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(SingleCategoryFragmentControllerProvider.class);
    }

    public static SingleCategoryFragment m810a(ProfilePictureOverlayPivotIntentData profilePictureOverlayPivotIntentData) {
        SingleCategoryFragment singleCategoryFragment = new SingleCategoryFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("heisman_pivot_intent_data", profilePictureOverlayPivotIntentData);
        singleCategoryFragment.g(bundle);
        return singleCategoryFragment;
    }

    public final void m814c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = SingleCategoryFragment.class;
        m811a((Object) this, getContext());
    }

    public final View m812a(LayoutInflater layoutInflater, ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2142978601);
        View inflate = layoutInflater.inflate(2130907121, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1625126681, a);
        return inflate;
    }

    public final void m813a(View view, @Nullable Bundle bundle) {
        FrameLayout frameLayout = (FrameLayout) e(2131567301);
        LoadingIndicatorView loadingIndicatorView = (LoadingIndicatorView) e(2131567474);
        BetterRecyclerView betterRecyclerView = (BetterRecyclerView) e(2131566381);
        this.f772b = this.f771a.m823a(ao(), this.f773c, frameLayout, loadingIndicatorView, betterRecyclerView, (ProfilePictureOverlayPivotIntentData) this.s.getParcelable("heisman_pivot_intent_data"));
        SingleCategoryFragmentController singleCategoryFragmentController = this.f772b;
        singleCategoryFragmentController.f790j.m672e(singleCategoryFragmentController.f789i.a(), singleCategoryFragmentController.f789i.f());
        if (singleCategoryFragmentController.f789i.c != null) {
            SingleCategoryFragmentController.m821c(singleCategoryFragmentController);
        } else {
            SingleCategoryFragmentController.m820b(singleCategoryFragmentController);
        }
    }
}
