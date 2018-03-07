package com.facebook.search;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.FindViewUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.search.fragment.GraphSearchChildFragment;
import com.facebook.search.fragment.GraphSearchChildFragment.OnResultClickListener;
import com.facebook.search.protocol.awareness.SearchAwarenessModels.TutorialNuxCardFieldsFragmentModel;
import com.facebook.search.protocol.awareness.SearchAwarenessModels.TutorialNuxCarouselFieldsFragmentModel;
import com.facebook.search.quickpromotion.ScaleTypeFitWidthAndCropBottom;
import com.facebook.search.quickpromotion.SearchAwarenessTutorialNuxAssetManager;
import com.facebook.search.quickpromotion.SearchAwarenessTutorialNuxAssetManagerProvider;
import com.facebook.search.quickpromotion.SearchAwarenessTutorialNuxController;
import com.facebook.search.searchbox.GraphSearchTitleSearchBoxSupplier;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: TimeToHeaderFuture */
public class AwarenessNullStateFragment extends FbFragment implements GraphSearchChildFragment {
    private static final CallerContext f21806d = CallerContext.a(AwarenessNullStateFragment.class, "search_awareness");
    @Inject
    public SearchAwarenessTutorialNuxAssetManagerProvider f21807a;
    @Inject
    public GraphSearchTitleSearchBoxSupplier f21808b;
    @Inject
    public SearchAwarenessTutorialNuxController f21809c;
    private SearchAwarenessTutorialNuxAssetManager f21810e;
    private BetterTextView f21811f;
    public CustomLinearLayout f21812g;
    private FbDraweeView f21813h;

    public static void m25291a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        AwarenessNullStateFragment awarenessNullStateFragment = (AwarenessNullStateFragment) obj;
        SearchAwarenessTutorialNuxAssetManagerProvider searchAwarenessTutorialNuxAssetManagerProvider = (SearchAwarenessTutorialNuxAssetManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SearchAwarenessTutorialNuxAssetManagerProvider.class);
        GraphSearchTitleSearchBoxSupplier a = GraphSearchTitleSearchBoxSupplier.m28576a(injectorLike);
        SearchAwarenessTutorialNuxController a2 = SearchAwarenessTutorialNuxController.m25941a(injectorLike);
        awarenessNullStateFragment.f21807a = searchAwarenessTutorialNuxAssetManagerProvider;
        awarenessNullStateFragment.f21808b = a;
        awarenessNullStateFragment.f21809c = a2;
    }

    public final void m25298c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = AwarenessNullStateFragment.class;
        m25291a((Object) this, getContext());
        this.f21810e = this.f21807a.m25931a(o().getResources().getDisplayMetrics().densityDpi);
    }

    public final View m25293a(LayoutInflater layoutInflater, @android.support.annotation.Nullable ViewGroup viewGroup, @android.support.annotation.Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1184026296);
        View inflate = layoutInflater.inflate(2130903331, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 245583290, a);
        return inflate;
    }

    public final void m25294a(View view, @android.support.annotation.Nullable Bundle bundle) {
        super.a(view, bundle);
        Preconditions.checkNotNull(this.f21809c.f22472l);
        Preconditions.checkNotNull(this.f21809c.f22472l.m9064a());
        TutorialNuxCarouselFieldsFragmentModel a = this.f21809c.f22472l.m9064a();
        this.f21812g = (CustomLinearLayout) FindViewUtil.b(view, 2131559782);
        this.f21811f = (BetterTextView) e(2131559783);
        this.f21813h = (FbDraweeView) e(2131559784);
        this.f21811f.setText(a.m9050k());
        ImmutableList j = a.m9049j();
        int size = j.size();
        for (int i = 0; i < size; i++) {
            TutorialNuxCardFieldsFragmentModel tutorialNuxCardFieldsFragmentModel = (TutorialNuxCardFieldsFragmentModel) j.get(i);
            CustomLinearLayout customLinearLayout = this.f21812g;
            BetterTextView betterTextView = (BetterTextView) ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(2130903332, this.f21812g, false);
            betterTextView.setText(tutorialNuxCardFieldsFragmentModel.m9041p());
            customLinearLayout.addView(betterTextView, this.f21812g.getChildCount() - 1);
        }
        this.f21813h.a(Uri.parse(this.f21810e.m25928a(a)), f21806d);
        ((GenericDraweeHierarchy) this.f21813h.getHierarchy()).a(ScaleTypeFitWidthAndCropBottom.f22351i);
    }

    public final void m25292G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 501129563);
        super.G();
        if (this.f21808b.f25334a != null) {
            this.f21808b.f25334a.e.b();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1681468978, a);
    }

    public final Fragment mo1192b() {
        return this;
    }

    public final boolean mo1191a(boolean z) {
        return false;
    }

    public final void mo1190a(OnResultClickListener onResultClickListener) {
    }
}
