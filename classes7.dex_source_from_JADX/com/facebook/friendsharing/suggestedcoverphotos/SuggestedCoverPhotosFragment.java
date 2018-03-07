package com.facebook.friendsharing.suggestedcoverphotos;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.util.FindViewUtil;
import com.facebook.friendsharing.suggestedcoverphotos.analytics.SuggestedCoverPhotosLogger;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.productionprompts.logging.PromptAnalytics;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: ProtilesNetworkFetch */
public class SuggestedCoverPhotosFragment extends FbFragment {
    public static final String f24299a = SuggestedCoverPhotosFragment.class.getSimpleName();
    @Inject
    public CoverPhotoPickerScrollAdapterProvider f24300b;
    @Inject
    public SuggestedCoverPhotosLogger f24301c;
    public ImmutableList<String> f24302d;
    public String f24303e;
    public PromptAnalytics f24304f;
    public BetterRecyclerView f24305g;
    public Fb4aTitleBar f24306h;

    /* compiled from: ProtilesNetworkFetch */
    public class C21171 implements OnClickListener {
        final /* synthetic */ SuggestedCoverPhotosFragment f24297a;

        public C21171(SuggestedCoverPhotosFragment suggestedCoverPhotosFragment) {
            this.f24297a = suggestedCoverPhotosFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1406516652);
            this.f24297a.ao().onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, -652966339, a);
        }
    }

    /* compiled from: ProtilesNetworkFetch */
    public class C21182 extends ItemDecoration {
        final /* synthetic */ SuggestedCoverPhotosFragment f24298a;

        public C21182(SuggestedCoverPhotosFragment suggestedCoverPhotosFragment) {
            this.f24298a = suggestedCoverPhotosFragment;
        }

        public final void m26506a(Rect rect, View view, RecyclerView recyclerView, State state) {
            super.a(rect, view, recyclerView, state);
            rect.top = this.f24298a.getContext().getResources().getDimensionPixelSize(2131432480);
            rect.right = this.f24298a.getContext().getResources().getDimensionPixelSize(2131432480);
            rect.left = this.f24298a.getContext().getResources().getDimensionPixelSize(2131432480);
            rect.bottom = this.f24298a.getContext().getResources().getDimensionPixelSize(2131432480);
        }
    }

    public static void m26507a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        SuggestedCoverPhotosFragment suggestedCoverPhotosFragment = (SuggestedCoverPhotosFragment) obj;
        CoverPhotoPickerScrollAdapterProvider coverPhotoPickerScrollAdapterProvider = (CoverPhotoPickerScrollAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(CoverPhotoPickerScrollAdapterProvider.class);
        SuggestedCoverPhotosLogger b = SuggestedCoverPhotosLogger.b(fbInjector);
        suggestedCoverPhotosFragment.f24300b = coverPhotoPickerScrollAdapterProvider;
        suggestedCoverPhotosFragment.f24301c = b;
    }

    public final void m26510c(Bundle bundle) {
        super.c(bundle);
        Class cls = SuggestedCoverPhotosFragment.class;
        m26507a((Object) this, getContext());
    }

    public final View m26508a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1033355424);
        View inflate = layoutInflater.inflate(2130907314, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -871294282, a);
        return inflate;
    }

    public final void m26509a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.f24305g = (BetterRecyclerView) FindViewUtil.b(view, 2131567763);
        this.f24306h = (Fb4aTitleBar) FindViewUtil.b(view, 2131558563);
        this.f24306h.setTitle(2131238429);
        this.f24306h.a(new C21171(this));
        this.f24302d = ImmutableList.copyOf(this.s.getStringArrayList("photo_urls"));
        this.f24303e = this.s.getString("prompt_session_id");
        this.f24304f = (PromptAnalytics) this.s.getParcelable("prompt_analytics");
        this.f24305g.setLayoutManager(new BetterLinearLayoutManager(getContext(), 1, false));
        this.f24305g.setAdapter(this.f24300b.m26499a(this.f24302d, getContext(), this, this.f24303e, this.f24304f));
        this.f24305g.a(new C21182(this));
    }
}
