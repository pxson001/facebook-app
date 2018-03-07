package com.facebook.pages.common.photos;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import com.facebook.device.ScreenUtil;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.surfaceinterfaces.PagesSurfaceTabFragment;
import com.facebook.pages.common.util.PagesScrollUtils;
import com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment;
import com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment.C05581;
import com.facebook.photos.photoset.ui.photoset.PandoraAlbumsFragment;
import com.facebook.reaction.ui.recyclerview.ReactionHeaderTouchDelegateView;
import com.facebook.reaction.ui.recyclerview.ReactionHeaderViewWithTouchDelegate;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.EmptyListViewItem;
import javax.inject.Inject;

/* compiled from: setTaggedUsers */
public class PagesPhotosFragment extends PandoraAlbumsFragment implements PagesSurfaceTabFragment {
    public static final int[] am = new int[2];
    @Inject
    public ScreenUtil f1734a;
    private int al = -1;
    public boolean an = false;
    public int ao = -1;
    private View f1735b;
    private EmptyListViewItem f1736c;
    private ReactionHeaderTouchDelegateView f1737d;
    private ReactionHeaderViewWithTouchDelegate f1738e;
    public View f1739f;
    public PagesSurfaceFragment f1740g;
    public int f1741h;
    private int f1742i;

    public static void m2551a(Object obj, Context context) {
        ((PagesPhotosFragment) obj).f1734a = ScreenUtil.a(FbInjector.get(context));
    }

    public final void m2557c(Bundle bundle) {
        super.c(bundle);
        Class cls = PagesPhotosFragment.class;
        m2551a((Object) this, getContext());
    }

    public final View m2552a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1785881069);
        this.f1735b = super.a(layoutInflater, viewGroup, bundle);
        final BetterListView betterListView = this.d;
        if (betterListView != null) {
            as();
            betterListView.setVerticalScrollBarEnabled(false);
            betterListView.addHeaderView(this.f1737d);
            this.f1735b.findViewById(2131559561).setVisibility(8);
            this.f1736c = new EmptyListViewItem(getContext());
            this.f1736c.setBackgroundResource(0);
            this.f1736c.setVisibility(0);
            this.f1736c.a(true);
            betterListView.addHeaderView(this.f1736c);
            betterListView.setHeaderDividersEnabled(false);
            betterListView.setDivider(jW_().getDrawable(17170445));
            this.f1739f = new View(getContext());
            CustomViewUtils.b(this.f1739f, new ColorDrawable(jW_().getColor(2131361920)));
            E_(this.al);
            betterListView.addFooterView(this.f1739f);
            betterListView.a(new OnScrollListener(this) {
                final /* synthetic */ PagesPhotosFragment f1733b;

                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    int count = betterListView.getAdapter() != null ? betterListView.getAdapter().getCount() : 0;
                    if (!(this.f1733b.an && this.f1733b.ao == count)) {
                        Pair a = PagesScrollUtils.a(this.f1733b.f1739f, betterListView, i, PagesPhotosFragment.am, this.f1733b.f1734a.d());
                        this.f1733b.an = ((Boolean) a.a).booleanValue();
                        if (this.f1733b.an) {
                            this.f1733b.E_(((Integer) a.b).intValue());
                            this.f1733b.ao = count;
                        }
                    }
                    if (betterListView.getChildAt(0) != null && this.f1733b.D()) {
                        int top = betterListView.getChildAt(0).getTop();
                        if (this.f1733b.f1740g != null && this.f1733b.f1741h != top) {
                            this.f1733b.f1740g.m5039a(betterListView, i);
                            this.f1733b.f1741h = top;
                        }
                    }
                }
            });
            betterListView.setVisibility(0);
        }
        View view = this.f1735b;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1872972554, a);
        return view;
    }

    public final void m2553a(View view, Bundle bundle) {
        super.a(view, bundle);
        D_(this.f1742i);
    }

    protected final void aq() {
        super.aq();
        BetterListView betterListView = this.d;
        betterListView.removeHeaderView(this.f1736c);
        betterListView.setDivider(jW_().getDrawable(2131361920));
        betterListView.setDividerHeight(jW_().getDimensionPixelSize(2131427418));
    }

    private void as() {
        if (this.f1737d == null) {
            if (this.f1738e == null) {
                this.f1737d = new ReactionHeaderTouchDelegateView(new View(getContext()));
            } else {
                this.f1737d = new ReactionHeaderTouchDelegateView(this.f1738e);
                this.f1738e.a(this.f1737d);
            }
            this.f1737d.c = true;
        } else if (this.f1738e != null) {
            this.f1737d.a = this.f1738e;
            this.f1738e.a(this.f1737d);
            this.f1737d.requestLayout();
        }
    }

    public final void m2555a(PagesSurfaceFragment pagesSurfaceFragment) {
        this.f1740g = pagesSurfaceFragment;
    }

    public final void m2558j() {
        e();
    }

    public final void m2556a(ReactionHeaderViewWithTouchDelegate reactionHeaderViewWithTouchDelegate) {
        this.f1738e = reactionHeaderViewWithTouchDelegate;
        as();
    }

    public final void D_(int i) {
        this.f1742i = i;
        PagesScrollUtils.a(this.d, this.f1742i);
    }

    public final void E_(int i) {
        if (this.al < 0 || i <= this.al) {
            this.al = i;
            if (this.f1739f != null) {
                this.f1739f.setLayoutParams(new LayoutParams(-1, this.al));
            }
        }
    }

    public final void m2554a(C05581 c05581) {
    }
}
