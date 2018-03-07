package com.facebook.nearby.v2.resultlist;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AnticipateInterpolator;
import android.widget.ViewFlipper;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.util.FindViewUtil;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.nearby.v2.NearbyPlacesV2Fragment;
import com.facebook.nearby.v2.model.NearbyPlacesFragmentModel;
import com.facebook.nearby.v2.model.NearbyPlacesPlaceModel;
import com.facebook.nearby.v2.model.NearbyPlacesSearchDataProvider;
import com.facebook.nearby.v2.resultlist.NearbyPlacesV2ResultsFragment.OnResultListModelUpdatedListener;
import com.facebook.nearby.v2.resultlist.logging.NearbyPlacesResultListLogger;
import com.facebook.nearby.v2.resultlist.logging.NearbyPlacesResultListLogger.TapAction;
import com.facebook.nearby.v2.resultlist.logging.NearbyPlacesResultListLoggerProvider;
import com.facebook.nearby.v2.resultlist.model.NearbyPlacesResultListModel;
import com.facebook.nearby.v2.resultlist.util.ListViewScrollHelper.OnScrollDirectionChangeListener;
import com.facebook.nearby.v2.resultlist.util.NearbyPlacesV2PageActionHandler;
import com.facebook.nearby.v2.resultlist.views.NearbyPlacesV2MapView;
import com.facebook.nearby.v2.resultlist.views.NearbyPlacesV2MapView.OnViewPagerHeightChangeListener;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.uicontrib.fab.FabView;
import com.facebook.widget.CustomViewUtils;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: default_value */
public class NearbyPlacesV2CombinedResultsFragment extends NearbyPlacesV2ResultsFragment implements OnResultListModelUpdatedListener, OnScrollDirectionChangeListener, OnViewPagerHeightChangeListener {
    private static final Class<?> f15806e = NearbyPlacesV2CombinedResultsFragment.class;
    @Inject
    public AbstractFbErrorReporter f15807a;
    private NearbyPlacesV2ResultListFragment al;
    private ViewStub am;
    private NearbyPlacesV2MapView an;
    public ViewFlipper ao;
    public FabView ap;
    private boolean aq = false;
    private NearbyPlacesResultListModel ar;
    private ViewState as = ViewState.SHOW_FAB;
    private ObjectAnimator at;
    public final Map<ViewState, Integer> au = new HashMap(ViewState.values().length);
    @Inject
    public NearbyPlacesV2PageActionHandler f15808b;
    @Inject
    public NearbyPlacesResultListLoggerProvider f15809c;
    NearbyPlacesResultListLogger f15810d;
    private NearbyPlacesFragmentModel f15811f;
    private NearbyPlacesSearchDataProvider f15812g;
    private NearbyPlacesV2Fragment f15813h;
    private OnResultListModelUpdatedListener f15814i;

    /* compiled from: default_value */
    class C16881 implements OnClickListener {
        final /* synthetic */ NearbyPlacesV2CombinedResultsFragment f15804a;

        C16881(NearbyPlacesV2CombinedResultsFragment nearbyPlacesV2CombinedResultsFragment) {
            this.f15804a = nearbyPlacesV2CombinedResultsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1242856995);
            NearbyPlacesV2CombinedResultsFragment.m18649g(this.f15804a, this.f15804a.ao.getDisplayedChild() == 0 ? 1 : 0);
            LogUtils.a(2030437747, a);
        }
    }

    /* compiled from: default_value */
    class C16892 implements OnGlobalLayoutListener {
        final /* synthetic */ NearbyPlacesV2CombinedResultsFragment f15805a;

        C16892(NearbyPlacesV2CombinedResultsFragment nearbyPlacesV2CombinedResultsFragment) {
            this.f15805a = nearbyPlacesV2CombinedResultsFragment;
        }

        public void onGlobalLayout() {
            int i;
            int height = this.f15805a.ap.getHeight();
            if (this.f15805a.ap.getLayoutParams() instanceof MarginLayoutParams) {
                i = ((MarginLayoutParams) this.f15805a.ap.getLayoutParams()).bottomMargin;
            } else {
                i = 0;
            }
            this.f15805a.au.put(ViewState.HIDE_FAB, Integer.valueOf(i + height));
            CustomViewUtils.a(this.f15805a.ap, this);
        }
    }

    /* compiled from: default_value */
    enum ViewState {
        SHOW_FAB,
        HIDE_FAB,
        SHOW_MAP
    }

    public static void m18648a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        NearbyPlacesV2CombinedResultsFragment nearbyPlacesV2CombinedResultsFragment = (NearbyPlacesV2CombinedResultsFragment) obj;
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        NearbyPlacesV2PageActionHandler a = NearbyPlacesV2PageActionHandler.m18723a(fbInjector);
        NearbyPlacesResultListLoggerProvider nearbyPlacesResultListLoggerProvider = (NearbyPlacesResultListLoggerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(NearbyPlacesResultListLoggerProvider.class);
        nearbyPlacesV2CombinedResultsFragment.f15807a = abstractFbErrorReporter;
        nearbyPlacesV2CombinedResultsFragment.f15808b = a;
        nearbyPlacesV2CombinedResultsFragment.f15809c = nearbyPlacesResultListLoggerProvider;
    }

    public NearbyPlacesV2CombinedResultsFragment() {
        for (Object put : ViewState.values()) {
            this.au.put(put, Integer.valueOf(0));
        }
    }

    public final String am_() {
        return "nearby_places_result_list";
    }

    public final void m18662c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = NearbyPlacesV2CombinedResultsFragment.class;
        m18648a((Object) this, getContext());
        FragmentManager s = s();
        this.al = (NearbyPlacesV2ResultListFragment) s.a("resultList");
        if (this.al == null) {
            this.al = NearbyPlacesV2ResultListFragment.m18669a(ar());
            s.a().a(2131564114, this.al).b();
        }
        this.al.mo960a(this.f15811f);
        this.al.mo961a(this.f15812g);
        this.al.mo962a((OnResultListModelUpdatedListener) this);
        this.al.ap = this;
    }

    public final View m18654a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 150772958);
        View inflate = layoutInflater.inflate(2130905392, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1270306181, a);
        return inflate;
    }

    public final void m18655a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.ao = (ViewFlipper) FindViewUtil.b(view, 2131564113);
        this.ap = (FabView) FindViewUtil.b(view, 2131564117);
        this.ap.setOnClickListener(new C16881(this));
        this.ap.getViewTreeObserver().addOnGlobalLayoutListener(new C16892(this));
        this.am = (ViewStub) FindViewUtil.b(view, 2131564115);
        if (bundle != null && bundle.getBoolean("map_exists")) {
            m18650n(bundle);
        }
    }

    public final void m18663d(@android.support.annotation.Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -390490260);
        super.d(bundle);
        if (this.f15813h != null) {
            this.al.mo959a(this.f15813h);
            this.f15813h = null;
        }
        if (this.aq) {
            this.aq = false;
            mo964e();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -959067289, a);
    }

    public final void m18651G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -164017938);
        super.G();
        if (this.an != null) {
            this.an.m18755a();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1485547944, a);
    }

    public final void m18652H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1313082511);
        super.H();
        if (this.an != null) {
            this.an.m18758b();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1884519269, a);
    }

    public final void m18653I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1006461598);
        super.I();
        if (this.an != null) {
            this.an.m18760e();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2056556040, a);
    }

    public final void m18665e(Bundle bundle) {
        super.e(bundle);
        bundle.putBoolean("map_exists", this.an != null);
        if (this.an != null) {
            this.an.m18759b(bundle);
        }
    }

    public void onLowMemory() {
        super.onLowMemory();
        if (this.an != null) {
            this.an.m18761f();
        }
    }

    private void m18650n(Bundle bundle) {
        if (this.an == null && this.am != null) {
            this.an = (NearbyPlacesV2MapView) this.am.inflate();
            this.an.m18756a(bundle);
            this.an.f15886a.f15906d = this;
            this.an.f15894i = this;
            if (this.ar != null) {
                this.an.m18757a(this.ar);
            }
            this.am = null;
        }
    }

    public final void mo960a(NearbyPlacesFragmentModel nearbyPlacesFragmentModel) {
        this.f15811f = nearbyPlacesFragmentModel;
        if (this.al != null) {
            this.al.mo960a(nearbyPlacesFragmentModel);
        }
    }

    public final void mo961a(NearbyPlacesSearchDataProvider nearbyPlacesSearchDataProvider) {
        this.f15812g = nearbyPlacesSearchDataProvider;
        if (this.al != null) {
            this.al.mo961a(nearbyPlacesSearchDataProvider);
        }
    }

    public final void mo962a(@Nullable OnResultListModelUpdatedListener onResultListModelUpdatedListener) {
        this.f15814i = onResultListModelUpdatedListener;
    }

    public final void mo959a(@Nullable NearbyPlacesV2Fragment nearbyPlacesV2Fragment) {
        if (this.al == null) {
            this.f15813h = nearbyPlacesV2Fragment;
        } else {
            this.al.mo959a(nearbyPlacesV2Fragment);
        }
    }

    public final void m18658a(NearbyPlacesPlaceModel nearbyPlacesPlaceModel, int i, int i2) {
        if (this.f15810d != null) {
            this.f15810d.m18691a(nearbyPlacesPlaceModel.m17738b(), i, i2, false, TapAction.CELL, null, null, null);
        }
        this.f15808b.m18728a(getContext(), nearbyPlacesPlaceModel, null, this.f15811f, this, f15806e);
    }

    public final void mo964e() {
        if (this.al == null) {
            this.aq = true;
        } else {
            this.al.mo964e();
        }
    }

    public final void mo963a(NearbyPlacesResultListModel nearbyPlacesResultListModel) {
        Object obj = (this.f15810d != null || nearbyPlacesResultListModel == null) ? null : 1;
        this.ar = nearbyPlacesResultListModel;
        if (obj != null) {
            this.f15810d = this.f15809c.m18694a(this.f15811f, this.f15812g, this.ar);
        }
        if (this.an != null) {
            this.an.m18757a(nearbyPlacesResultListModel);
        }
        if (this.f15814i != null) {
            this.f15814i.mo963a(nearbyPlacesResultListModel);
        }
    }

    public final void w_(int i) {
        if (i > 0) {
            m18647a(ViewState.HIDE_FAB);
        } else if (i < 0) {
            m18647a(ViewState.SHOW_FAB);
        }
    }

    public final void x_(int i) {
        this.au.put(ViewState.SHOW_MAP, Integer.valueOf(-i));
        m18647a(this.as);
    }

    public static void m18649g(NearbyPlacesV2CombinedResultsFragment nearbyPlacesV2CombinedResultsFragment, int i) {
        if (nearbyPlacesV2CombinedResultsFragment.ao.getDisplayedChild() != i) {
            ViewState viewState;
            Context context = nearbyPlacesV2CombinedResultsFragment.getContext();
            switch (i) {
                case 0:
                    nearbyPlacesV2CombinedResultsFragment.ap.setGlyphID(2130840023);
                    nearbyPlacesV2CombinedResultsFragment.ao.setOutAnimation(context, 2130968760);
                    nearbyPlacesV2CombinedResultsFragment.ao.setInAnimation(context, 2130968745);
                    viewState = ViewState.SHOW_FAB;
                    break;
                case 1:
                    nearbyPlacesV2CombinedResultsFragment.m18650n(null);
                    nearbyPlacesV2CombinedResultsFragment.ap.setGlyphID(2130839957);
                    nearbyPlacesV2CombinedResultsFragment.ao.setOutAnimation(context, 2130968759);
                    nearbyPlacesV2CombinedResultsFragment.ao.setInAnimation(context, 2130968746);
                    viewState = ViewState.SHOW_MAP;
                    break;
                default:
                    nearbyPlacesV2CombinedResultsFragment.f15807a.a(f15806e.getSimpleName(), "Unknown child passed to setViewFlipperDisplayedChild");
                    return;
            }
            nearbyPlacesV2CombinedResultsFragment.ao.setDisplayedChild(i);
            nearbyPlacesV2CombinedResultsFragment.m18647a(viewState);
        }
    }

    private void m18647a(ViewState viewState) {
        this.as = viewState;
        if (this.at != null && this.at.isRunning()) {
            this.at.cancel();
        }
        float q = ViewCompat.q(this.ap);
        float intValue = (float) ((Integer) this.au.get(viewState)).intValue();
        this.at = ObjectAnimator.ofFloat(this.ap, "translationY", new float[]{q, intValue}).setDuration((long) jW_().getInteger(2131492917));
        if (ViewState.HIDE_FAB.equals(viewState)) {
            this.at.setInterpolator(new AnticipateInterpolator());
        }
        this.at.start();
    }
}
