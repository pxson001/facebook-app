package com.facebook.groups.groupsgrid.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.LayoutInflater;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.config.application.FbAppType;
import com.facebook.config.application.Product;
import com.facebook.groups.fb4a.groupsections.view.FB4AGroupsPogGridViewFactory;
import com.facebook.groups.groupsections.Enums.GroupSections;
import com.facebook.groups.groupsections.GroupsSectionInterface;
import com.facebook.groups.groupsections.SectionedGroupsQueryManager;
import com.facebook.groups.groupsections.SectionedGroupsQueryManager.SectionRequeryListener;
import com.facebook.groups.groupsections.SectionedGroupsQueryManager.SectionTailLoadListener;
import com.facebook.groups.groupsections.noncursored.AbstractGraphQLBackedSection;
import com.facebook.groups.groupsgrid.GroupsSectionedGridLayoutManagerSpanSizeLookup;
import com.facebook.groups.groupsgrid.adapter.GroupsRecyclerViewSectionedGridAdapter;
import com.facebook.groups.groupsgrid.utils.ResizeValues;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tablet.Boolean_IsTabletMethodAutoProvider;
import com.facebook.tablet.IsTablet;
import com.facebook.tablet.abtest.TabletColumnLayoutManager;
import com.facebook.tablet.abtest.TabletColumnLayoutManager.ColumnWidthConfig;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.recyclerview.BetterRecyclerView.OnItemClickListener;
import com.facebook.widget.recyclerview.BetterRecyclerView.OnItemLongClickListener;
import java.util.HashMap;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: accepted_legal */
public abstract class AbstractGroupsPogGridFragment extends FbFragment implements AnalyticsFragment {
    public static final String am = AbstractGroupsPogGridFragment.class.getName();
    @Inject
    Lazy<FbErrorReporter> f10172a;
    protected View al;
    private View an;
    public GroupsRecyclerViewSectionedGridAdapter ao;
    public FB4AGroupsPogGridViewFactory ap;
    private SectionTailLoadListener aq;
    private PogGridOrientationEventListener ar;
    private final OnClickListener as = new C12191(this);
    public final C12202 at = new C12202(this);
    @Inject
    @IsTablet
    Boolean f10173b;
    @Inject
    FbAppType f10174c;
    @Inject
    Resources f10175d;
    @Inject
    TabletColumnLayoutManager f10176e;
    @Inject
    Lazy<LayoutInflater> f10177f;
    public RecyclerView f10178g;
    protected LoadingState f10179h;
    public ResizeValues f10180i;

    /* compiled from: accepted_legal */
    class C12191 implements OnClickListener {
        final /* synthetic */ AbstractGroupsPogGridFragment f10348a;

        C12191(AbstractGroupsPogGridFragment abstractGroupsPogGridFragment) {
            this.f10348a = abstractGroupsPogGridFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1448606262);
            this.f10348a.m10504b(LoadingState.LOADING);
            this.f10348a.ax();
            Logger.a(2, EntryType.UI_INPUT_END, -353693838, a);
        }
    }

    /* compiled from: accepted_legal */
    public class C12202 {
        public final /* synthetic */ AbstractGroupsPogGridFragment f10349a;

        C12202(AbstractGroupsPogGridFragment abstractGroupsPogGridFragment) {
            this.f10349a = abstractGroupsPogGridFragment;
        }
    }

    /* compiled from: accepted_legal */
    public class C12213 extends OnScrollListener {
        final /* synthetic */ AbstractGroupsPogGridFragment f10350a;
        private boolean f10351b = false;

        public C12213(AbstractGroupsPogGridFragment abstractGroupsPogGridFragment) {
            this.f10350a = abstractGroupsPogGridFragment;
        }

        public final void m10765a(RecyclerView recyclerView, int i) {
            super.a(recyclerView, i);
            this.f10351b = false;
        }

        public final void m10766a(RecyclerView recyclerView, int i, int i2) {
            super.a(recyclerView, i, i2);
            GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
            int aZ_ = recyclerView.o.aZ_();
            int l = gridLayoutManager.l();
            if ((gridLayoutManager.n() - l) + l < aZ_ - (this.f10350a.f10180i.f10357b * 2) || aZ_ <= 0) {
                this.f10351b = false;
                return;
            }
            if (!this.f10351b) {
                this.f10350a.av();
            }
            this.f10351b = true;
        }
    }

    /* compiled from: accepted_legal */
    class C12224 implements SectionTailLoadListener {
        final /* synthetic */ AbstractGroupsPogGridFragment f10352a;

        C12224(AbstractGroupsPogGridFragment abstractGroupsPogGridFragment) {
            this.f10352a = abstractGroupsPogGridFragment;
        }

        public final void mo259a(GroupSections groupSections, boolean z) {
            if (this.f10352a.f10178g != null && this.f10352a.f10178g.o != null) {
                GroupsRecyclerViewSectionedGridAdapter groupsRecyclerViewSectionedGridAdapter = (GroupsRecyclerViewSectionedGridAdapter) this.f10352a.f10178g.o;
                if (groupsRecyclerViewSectionedGridAdapter.f10336k != null && groupsRecyclerViewSectionedGridAdapter.f10336k.get(groupSections) != null) {
                    ((AbstractGraphQLBackedSection) groupsRecyclerViewSectionedGridAdapter.f10336k.get(groupSections)).f10220d = z;
                    int a = groupsRecyclerViewSectionedGridAdapter.f10328c.m10762a((Enum) groupSections);
                    if (a != -1) {
                        groupsRecyclerViewSectionedGridAdapter.j_(a);
                    }
                }
            }
        }
    }

    /* compiled from: accepted_legal */
    class C12235 implements SectionRequeryListener {
        final /* synthetic */ AbstractGroupsPogGridFragment f10353a;

        C12235(AbstractGroupsPogGridFragment abstractGroupsPogGridFragment) {
            this.f10353a = abstractGroupsPogGridFragment;
        }

        public final void mo258a(HashMap<GroupSections, GroupsSectionInterface> hashMap, boolean z, int i) {
            LoadingState loadingState = z ? LoadingState.LOADING : i == 0 ? LoadingState.EMPTY : LoadingState.LOADED;
            GroupsRecyclerViewSectionedGridAdapter groupsRecyclerViewSectionedGridAdapter = this.f10353a.ao;
            groupsRecyclerViewSectionedGridAdapter.f10336k = hashMap;
            groupsRecyclerViewSectionedGridAdapter.f10335j = i;
            groupsRecyclerViewSectionedGridAdapter.f10328c.m10764c(hashMap);
            this.f10353a.mo265a(loadingState);
        }

        public final void mo257a() {
            ((AbstractFbErrorReporter) this.f10353a.f10172a.get()).a(AbstractGroupsPogGridFragment.am, "Groups Initial Load Failed");
            this.f10353a.mo265a(LoadingState.FAILED);
        }
    }

    /* compiled from: accepted_legal */
    public enum LoadingState {
        LOADING,
        EMPTY,
        LOADED,
        FAILED
    }

    /* compiled from: accepted_legal */
    class PogGridOrientationEventListener extends OrientationEventListener {
        final /* synthetic */ AbstractGroupsPogGridFragment f10354a;
        private int f10355b;

        PogGridOrientationEventListener(AbstractGroupsPogGridFragment abstractGroupsPogGridFragment, int i) {
            this.f10354a = abstractGroupsPogGridFragment;
            super(abstractGroupsPogGridFragment.o());
            this.f10355b = i;
        }

        public void onOrientationChanged(int i) {
            int i2 = this.f10354a.f10175d.getConfiguration().orientation;
            if (this.f10355b != i2) {
                this.f10355b = i2;
                i2 = ((GridLayoutManager) this.f10354a.f10178g.getLayoutManager()).l();
                this.f10354a.au();
                this.f10354a.f10178g.setLayoutManager(AbstractGroupsPogGridFragment.az(this.f10354a));
                this.f10354a.f10178g.a(i2);
                if (this.f10354a.ao != null) {
                    this.f10354a.ao.m10753e();
                }
            }
        }
    }

    public static void m10497a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((AbstractGroupsPogGridFragment) obj).m10496a(IdBasedSingletonScopeProvider.b(fbInjector, 494), Boolean_IsTabletMethodAutoProvider.a(fbInjector), (FbAppType) fbInjector.getInstance(FbAppType.class), ResourcesMethodAutoProvider.a(fbInjector), TabletColumnLayoutManager.a(fbInjector), IdBasedLazy.a(fbInjector, 60));
    }

    public abstract GroupsRecyclerViewSectionedGridAdapter mo263a(ResizeValues resizeValues, C12202 c12202);

    protected abstract void mo265a(LoadingState loadingState);

    public abstract OnItemLongClickListener aq();

    public abstract OnDrawListener ar();

    public abstract SectionedGroupsQueryManager as();

    protected abstract FB4AGroupsPogGridViewFactory at();

    public abstract OnItemClickListener mo271e();

    private void m10496a(Lazy<FbErrorReporter> lazy, Boolean bool, FbAppType fbAppType, Resources resources, TabletColumnLayoutManager tabletColumnLayoutManager, Lazy<LayoutInflater> lazy2) {
        this.f10172a = lazy;
        this.f10173b = bool;
        this.f10174c = fbAppType;
        this.f10175d = resources;
        this.f10176e = tabletColumnLayoutManager;
        this.f10177f = lazy2;
    }

    public void mo270c(Bundle bundle) {
        super.c(bundle);
        Class cls = AbstractGroupsPogGridFragment.class;
        m10497a((Object) this, getContext());
    }

    public final View m10500a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 239389001);
        View inflate = layoutInflater.inflate(2130904724, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -20647074, a);
        return inflate;
    }

    public void mo264a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.ap = at();
        this.ar = new PogGridOrientationEventListener(this, this.f10175d.getConfiguration().orientation);
    }

    public void mo262G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1933415679);
        super.G();
        this.ar.enable();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1111171826, a);
    }

    public final void m10499H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -138759025);
        super.H();
        this.ar.disable();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1949075122, a);
    }

    protected final void au() {
        if (this.f10173b.booleanValue() && this.f10174c.j == Product.FB4A) {
            ColumnWidthConfig b = this.f10176e.b(ContentFragmentType.GROUPS_TAB_FRAGMENT);
            this.f10180i = ResizeValues.m10770a(Integer.valueOf((b.a - b.c) - b.d), getContext(), this.f10175d);
            return;
        }
        this.f10180i = ResizeValues.m10770a(null, getContext(), this.f10175d);
    }

    public static GridLayoutManager az(AbstractGroupsPogGridFragment abstractGroupsPogGridFragment) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(abstractGroupsPogGridFragment.getContext(), abstractGroupsPogGridFragment.f10180i.f10357b);
        gridLayoutManager.h = new GroupsSectionedGridLayoutManagerSpanSizeLookup(abstractGroupsPogGridFragment.f10180i.f10357b, abstractGroupsPogGridFragment.ao);
        return gridLayoutManager;
    }

    protected final void m10504b(LoadingState loadingState) {
        int i = 0;
        this.f10179h = loadingState;
        if (this.T != null && this.f10178g != null) {
            int i2;
            LayoutInflater layoutInflater;
            FB4AGroupsPogGridViewFactory fB4AGroupsPogGridViewFactory;
            FB4AGroupsPogGridViewFactory fB4AGroupsPogGridViewFactory2;
            this.f10178g.setVisibility(this.f10179h == LoadingState.LOADED ? 0 : 8);
            View e = e(2131562785);
            if (this.f10179h == LoadingState.LOADING) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            e.setVisibility(i2);
            if (this.f10179h == LoadingState.EMPTY && this.al == null) {
                layoutInflater = (LayoutInflater) this.f10177f.get();
                fB4AGroupsPogGridViewFactory = this.ap;
                layoutInflater.inflate(2130904742, (ViewGroup) this.T, true);
                fB4AGroupsPogGridViewFactory2 = this.ap;
                this.al = e(2131562817);
            }
            if (this.al != null) {
                this.al.setVisibility(this.f10179h == LoadingState.EMPTY ? 0 : 8);
            }
            if (this.f10179h == LoadingState.FAILED && this.an == null) {
                layoutInflater = (LayoutInflater) this.f10177f.get();
                fB4AGroupsPogGridViewFactory = this.ap;
                layoutInflater.inflate(2130904743, (ViewGroup) this.T, true);
                fB4AGroupsPogGridViewFactory2 = this.ap;
                this.an = e(2131562818);
                this.an.setOnClickListener(this.as);
            }
            if (this.an != null) {
                View view = this.an;
                if (this.f10179h != LoadingState.FAILED) {
                    i = 8;
                }
                view.setVisibility(i);
            }
        }
    }

    protected final void av() {
        as().mo278a(aA(), aw());
    }

    public final SectionTailLoadListener aw() {
        if (this.aq == null) {
            this.aq = new C12224(this);
        }
        return this.aq;
    }

    protected final void ax() {
        as().mo280a(this.ao.m10751d(), aA(), new C12235(this));
    }

    private int aA() {
        if (this.f10173b.booleanValue()) {
            return this.f10180i.f10357b * (this.f10180i.f10358c + 2);
        }
        ResizeValues resizeValues = this.f10180i;
        return (resizeValues.f10357b * resizeValues.f10358c) * 2;
    }

    public final String am_() {
        return "groups_grid";
    }
}
