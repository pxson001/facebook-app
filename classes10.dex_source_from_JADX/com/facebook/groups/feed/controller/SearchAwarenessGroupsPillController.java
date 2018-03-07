package com.facebook.groups.feed.controller;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.fbui.widget.text.GlyphWithTextView;
import com.facebook.feedback.ui.AbstractPillController;
import com.facebook.groups.feed.ui.GroupsFeedFragment;
import com.facebook.groups.feed.ui.GroupsFeedFragment.AnonymousClass11;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.logging.SearchAwarenessLogger;
import com.facebook.springs.SpringSystem;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.animations.ViewAnimatorFactory;
import com.facebook.widget.LazyView;
import javax.inject.Inject;

/* compiled from: Tor integrity checker */
public class SearchAwarenessGroupsPillController extends AbstractPillController {
    public final LazyView<View> f21973a;
    public final AnonymousClass11 f21974b;
    private final GroupsFeedController f21975c;
    public final SearchAwarenessLogger f21976d;
    private final QeAccessor f21977e;
    public final Context f21978f;
    private final boolean f21979g;
    private final Handler f21980h = new Handler();
    public int f21981i;
    public int f21982j;
    public boolean f21983k;
    private Runnable f21984l;
    public OnClickListener f21985m;

    /* compiled from: Tor integrity checker */
    public class C31482 implements OnClickListener {
        final /* synthetic */ SearchAwarenessGroupsPillController f21972a;

        public C31482(SearchAwarenessGroupsPillController searchAwarenessGroupsPillController) {
            this.f21972a = searchAwarenessGroupsPillController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1645238709);
            AnonymousClass11 anonymousClass11 = this.f21972a.f21974b;
            anonymousClass11.f22126a.aW.a(GroupsFeedFragment.m23268i(anonymousClass11.f22126a, true));
            this.f21972a.m23105b(SearchAwarenessGroupsPillController.m23103g(this.f21972a, this.f21972a.f21982j));
            Logger.a(2, EntryType.UI_INPUT_END, -1776590496, a);
        }
    }

    /* compiled from: Tor integrity checker */
    enum ScrollDirection {
        SCROLL_DOWN,
        SCROLL_UP,
        UNKNOWN
    }

    @Inject
    public SearchAwarenessGroupsPillController(@Assisted LazyView<View> lazyView, @Assisted GroupsFeedController groupsFeedController, @Assisted Context context, @Assisted OnClickViewCallback onClickViewCallback, SearchAwarenessLogger searchAwarenessLogger, QeAccessor qeAccessor, SpringSystem springSystem, ViewAnimatorFactory viewAnimatorFactory) {
        super(springSystem, viewAnimatorFactory);
        this.f21973a = lazyView;
        this.f21974b = onClickViewCallback;
        this.f21975c = groupsFeedController;
        this.f21976d = searchAwarenessLogger;
        this.f21977e = qeAccessor;
        this.f21978f = context;
        this.f21979g = qeAccessor.a(ExperimentsForSearchAbTestModule.ap, false);
        this.f21981i = qeAccessor.a(ExperimentsForSearchAbTestModule.ar, Integer.MAX_VALUE);
        this.f21982j = 0;
    }

    protected final LazyView<? extends View> m23106g() {
        return this.f21973a;
    }

    public final void m23104a(int i) {
        if (this.f21979g) {
            final int g = m23103g(this, i);
            if (m23102f(i) == ScrollDirection.SCROLL_UP) {
                m23100c(g);
            } else if (m23102f(i) == ScrollDirection.SCROLL_DOWN) {
                HandlerDetour.a(this.f21980h, this.f21984l);
                this.f21984l = new Runnable(this) {
                    final /* synthetic */ SearchAwarenessGroupsPillController f21971b;

                    public void run() {
                        SearchAwarenessGroupsPillController searchAwarenessGroupsPillController = this.f21971b;
                        int i = g;
                        if (!searchAwarenessGroupsPillController.f21983k && i >= searchAwarenessGroupsPillController.f21981i) {
                            GlyphWithTextView glyphWithTextView = (GlyphWithTextView) searchAwarenessGroupsPillController.f21973a.a();
                            glyphWithTextView.setText(searchAwarenessGroupsPillController.f21978f.getResources().getString(2131238074));
                            if (searchAwarenessGroupsPillController.f21985m == null) {
                                searchAwarenessGroupsPillController.f21985m = new C31482(searchAwarenessGroupsPillController);
                            }
                            glyphWithTextView.setOnClickListener(searchAwarenessGroupsPillController.f21985m);
                            searchAwarenessGroupsPillController.f21983k = searchAwarenessGroupsPillController.a();
                            if (searchAwarenessGroupsPillController.f21983k) {
                                searchAwarenessGroupsPillController.f21976d.b();
                            }
                        }
                    }
                };
                HandlerDetour.b(this.f21980h, this.f21984l, 500, 1180119203);
            }
            this.f21982j = i;
        }
    }

    public final void m23107h() {
        m23100c(0);
    }

    private void m23100c(int i) {
        if (this.f21983k) {
            this.f21976d.b(false);
            m23101d(i);
        }
    }

    public final void m23105b(int i) {
        if (this.f21983k) {
            this.f21976d.b(true);
            m23101d(i);
        }
    }

    private void m23101d(int i) {
        b();
        this.f21983k = false;
        this.f21981i = this.f21977e.a(ExperimentsForSearchAbTestModule.ar, Integer.MAX_VALUE) + i;
    }

    private ScrollDirection m23102f(int i) {
        if (i > this.f21982j) {
            return ScrollDirection.SCROLL_DOWN;
        }
        if (i < this.f21982j) {
            return ScrollDirection.SCROLL_UP;
        }
        return ScrollDirection.UNKNOWN;
    }

    public static int m23103g(SearchAwarenessGroupsPillController searchAwarenessGroupsPillController, int i) {
        return searchAwarenessGroupsPillController.f21975c.u.s_(i);
    }
}
