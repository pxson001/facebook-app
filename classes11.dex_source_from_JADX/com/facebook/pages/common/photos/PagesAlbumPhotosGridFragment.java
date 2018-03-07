package com.facebook.pages.common.photos;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import com.facebook.auth.module.ViewerContextMethodAutoProvider;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.device.ScreenUtil;
import com.facebook.graphql.enums.GraphQLPhotosAlbumAPIType;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.surfaceinterfaces.PagesSurfaceTabFragment;
import com.facebook.pages.common.util.PagesScrollUtils;
import com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment;
import com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment.C05581;
import com.facebook.photos.pandora.common.ui.views.PandoraInlineVideoEnvironmentProvider;
import com.facebook.photos.pandora.logging.PandoraSequenceLogger;
import com.facebook.photos.pandora.ui.PandoraAlbumMediaSetAdapter;
import com.facebook.photos.pandora.ui.PandoraAlbumMediaSetFragment;
import com.facebook.reaction.ui.recyclerview.ReactionHeaderTouchDelegateView;
import com.facebook.reaction.ui.recyclerview.ReactionHeaderViewWithTouchDelegate;
import com.facebook.widget.CustomViewUtils;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: settling */
public class PagesAlbumPhotosGridFragment extends PandoraAlbumMediaSetFragment implements CanHandleBackPressed, PagesSurfaceTabFragment {
    public static final int[] aX = new int[2];
    @Inject
    public ScreenUtil aM;
    @Inject
    public PageAlbumMediaSetAdapter aN;
    private View aO;
    private C02312 aP;
    private ReactionHeaderTouchDelegateView aQ;
    private ReactionHeaderViewWithTouchDelegate aR;
    public View aS;
    public PagesSurfaceFragment aT;
    public int aU;
    private int aV;
    private int aW = -1;
    public boolean aY = false;
    public int aZ = -1;

    public static void m2500a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PagesAlbumPhotosGridFragment pagesAlbumPhotosGridFragment = (PagesAlbumPhotosGridFragment) obj;
        ScreenUtil a = ScreenUtil.a(fbInjector);
        PageAlbumMediaSetAdapter pageAlbumMediaSetAdapter = new PageAlbumMediaSetAdapter(IdBasedLazy.a(fbInjector, 9373), IdBasedLazy.a(fbInjector, 9376), IdBasedLazy.a(fbInjector, 3561), IdBasedSingletonScopeProvider.b(fbInjector, 9384), IdBasedLazy.a(fbInjector, 9385), IdBasedSingletonScopeProvider.b(fbInjector, 9414), IdBasedSingletonScopeProvider.b(fbInjector, 494), ViewerContextMethodAutoProvider.b(fbInjector), PandoraSequenceLogger.a(fbInjector), (PandoraInlineVideoEnvironmentProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(PandoraInlineVideoEnvironmentProvider.class));
        pagesAlbumPhotosGridFragment.aM = a;
        pagesAlbumPhotosGridFragment.aN = pageAlbumMediaSetAdapter;
    }

    public final void m2508c(@Nullable Bundle bundle) {
        Class cls = PagesAlbumPhotosGridFragment.class;
        m2500a(this, getContext());
        super.c(bundle);
    }

    public final View m2501a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1352944412);
        this.aO = super.a(layoutInflater, viewGroup, bundle);
        CustomViewUtils.b(this.aO, new ColorDrawable(0));
        final View view = this.bg;
        view.setFooterDividersEnabled(false);
        view.setDrawingCacheBackgroundColor(0);
        view.setOverscrollFooter(new ColorDrawable(0));
        view.setSelector(new ColorDrawable(0));
        CustomViewUtils.b(view, new ColorDrawable(0));
        aw();
        view.addHeaderView(this.aQ);
        this.aS = new View(getContext());
        E_(this.aW);
        view.addFooterView(this.aS);
        view.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ PagesAlbumPhotosGridFragment f1689b;

            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int count = view.getAdapter() != null ? view.getAdapter().getCount() : 0;
                if (!(this.f1689b.aY && this.f1689b.aZ == count)) {
                    Pair a = PagesScrollUtils.a(this.f1689b.aS, view, i, PagesAlbumPhotosGridFragment.aX, this.f1689b.aM.d());
                    this.f1689b.aY = ((Boolean) a.a).booleanValue();
                    if (this.f1689b.aY) {
                        this.f1689b.E_(((Integer) a.b).intValue());
                        this.f1689b.aZ = count;
                    }
                }
                int top = view.getChildAt(0).getTop();
                if (this.f1689b.aT != null && view != null && this.f1689b.aU != top && this.f1689b.D()) {
                    this.f1689b.aT.m5039a(view, i);
                    this.f1689b.aU = top;
                }
            }
        });
        view = this.aO;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -293501979, a);
        return view;
    }

    protected final PandoraAlbumMediaSetAdapter m2507b() {
        return this.aN;
    }

    protected final void m2505a(PandoraAlbumMediaSetAdapter pandoraAlbumMediaSetAdapter) {
        this.aN = (PageAlbumMediaSetAdapter) pandoraAlbumMediaSetAdapter;
    }

    protected final void m2502a(GraphQLAlbum graphQLAlbum) {
        boolean z = true;
        if (m2507b() instanceof PageAlbumMediaSetAdapter) {
            PageAlbumMediaSetAdapter pageAlbumMediaSetAdapter = (PageAlbumMediaSetAdapter) m2507b();
            boolean z2 = graphQLAlbum.k() == GraphQLPhotosAlbumAPIType.PROFILE || graphQLAlbum.k() == GraphQLPhotosAlbumAPIType.WALL || graphQLAlbum.k() == GraphQLPhotosAlbumAPIType.COVER || graphQLAlbum.k() == GraphQLPhotosAlbumAPIType.MOBILE || graphQLAlbum.k() == GraphQLPhotosAlbumAPIType.APP;
            boolean b = b(graphQLAlbum);
            if (z2 || !b) {
                z = false;
            }
            if (this.aP == null || this.aP.f1690a != z) {
                this.aP = new OnClickListener(this) {
                    final /* synthetic */ PagesAlbumPhotosGridFragment f1691b;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, -955998248);
                        PagesAlbumPhotosGridFragment pagesAlbumPhotosGridFragment = this.f1691b;
                        pagesAlbumPhotosGridFragment.an.a(pagesAlbumPhotosGridFragment.bb).a(view, this.f1691b.ao(), this.f1691b, this.f1691b.as(), false);
                        Logger.a(2, EntryType.UI_INPUT_END, -1720367608, a);
                    }
                };
            }
            pageAlbumMediaSetAdapter.f1677u = this.aP;
        }
    }

    private void aw() {
        if (this.aQ == null) {
            if (this.aR == null) {
                this.aQ = new ReactionHeaderTouchDelegateView(new View(getContext()));
            } else {
                this.aQ = new ReactionHeaderTouchDelegateView(this.aR);
                this.aR.a(this.aQ);
            }
            this.aQ.c = true;
        } else if (this.aR != null) {
            this.aQ.a = this.aR;
            this.aR.a(this.aQ);
            this.aQ.requestLayout();
        }
    }

    public final void m2504a(PagesSurfaceFragment pagesSurfaceFragment) {
        this.aT = pagesSurfaceFragment;
    }

    public final void m2509j() {
    }

    public final void m2506a(ReactionHeaderViewWithTouchDelegate reactionHeaderViewWithTouchDelegate) {
        this.aR = reactionHeaderViewWithTouchDelegate;
        aw();
    }

    public final void D_(int i) {
        this.aV = i;
        PagesScrollUtils.a(this.bg, this.aV);
    }

    public final void E_(int i) {
        if (this.aW < 0 || i <= this.aW) {
            this.aW = i;
            if (this.aS != null) {
                this.aS.setLayoutParams(new LayoutParams(-1, this.aW));
            }
        }
    }

    public final void m2503a(C05581 c05581) {
    }

    public final boolean O_() {
        return false;
    }
}
