package com.facebook.timeline.search;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.fbui.widget.text.GlyphWithTextView;
import com.facebook.feedback.ui.AbstractPillController;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.logging.SearchAwarenessLogger;
import com.facebook.springs.SpringSystem;
import com.facebook.timeline.TimelineFragment.C15097;
import com.facebook.ui.animations.ViewAnimatorFactory;
import com.facebook.ultralight.Inject;
import com.facebook.widget.LazyView;

/* compiled from: extra_selected_theme_uri */
public class SearchAwarenessProfilePillController extends AbstractPillController {
    public final LazyView<View> f12634a;
    public final C15097 f12635b;
    public final SearchAwarenessLogger f12636c;
    public final Context f12637d;
    public final boolean f12638e;
    public final int f12639f;
    public final Handler f12640g = new Handler();
    public final Runnable f12641h = new C17751(this);
    public int f12642i;
    public int f12643j;
    public boolean f12644k;
    public OnClickListener f12645l;

    /* compiled from: extra_selected_theme_uri */
    class C17751 implements Runnable {
        final /* synthetic */ SearchAwarenessProfilePillController f12632a;

        C17751(SearchAwarenessProfilePillController searchAwarenessProfilePillController) {
            this.f12632a = searchAwarenessProfilePillController;
        }

        public void run() {
            Object obj;
            SearchAwarenessProfilePillController searchAwarenessProfilePillController = this.f12632a;
            if (searchAwarenessProfilePillController.f12642i >= searchAwarenessProfilePillController.f12639f) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null && !searchAwarenessProfilePillController.f12644k) {
                GlyphWithTextView glyphWithTextView = (GlyphWithTextView) searchAwarenessProfilePillController.f12634a.a();
                glyphWithTextView.setText(searchAwarenessProfilePillController.f12637d.getResources().getString(2131235057));
                if (searchAwarenessProfilePillController.f12645l == null) {
                    searchAwarenessProfilePillController.f12645l = new C17762(searchAwarenessProfilePillController);
                }
                glyphWithTextView.setOnClickListener(searchAwarenessProfilePillController.f12645l);
                searchAwarenessProfilePillController.f12644k = searchAwarenessProfilePillController.a();
                searchAwarenessProfilePillController.f12636c.a();
            }
        }
    }

    /* compiled from: extra_selected_theme_uri */
    public class C17762 implements OnClickListener {
        final /* synthetic */ SearchAwarenessProfilePillController f12633a;

        public C17762(SearchAwarenessProfilePillController searchAwarenessProfilePillController) {
            this.f12633a = searchAwarenessProfilePillController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -694821390);
            C15097 c15097 = this.f12633a.f12635b;
            c15097.f10231a.aR.a(c15097.f10231a.m10322q());
            this.f12633a.m12593i();
            Logger.a(2, EntryType.UI_INPUT_END, 1902481546, a);
        }
    }

    @Inject
    public SearchAwarenessProfilePillController(@Assisted LazyView<View> lazyView, @Assisted OnClickViewCallback onClickViewCallback, SearchAwarenessLogger searchAwarenessLogger, Context context, QeAccessor qeAccessor, SpringSystem springSystem, ViewAnimatorFactory viewAnimatorFactory) {
        super(springSystem, viewAnimatorFactory);
        this.f12634a = lazyView;
        this.f12635b = onClickViewCallback;
        this.f12636c = searchAwarenessLogger;
        this.f12637d = context;
        this.f12638e = qeAccessor.a(ExperimentsForSearchAbTestModule.aB, false);
        this.f12639f = qeAccessor.a(ExperimentsForSearchAbTestModule.aC, Integer.MAX_VALUE);
        m12590j();
    }

    protected final LazyView<? extends View> m12591g() {
        return this.f12634a;
    }

    private void m12590j() {
        b();
        this.f12642i = 0;
        this.f12644k = false;
    }

    public final void m12592h() {
        if (this.f12638e && this.f12644k) {
            this.f12636c.a(false);
        }
        m12590j();
    }

    public final void m12593i() {
        if (this.f12638e && this.f12644k) {
            this.f12636c.a(true);
        }
        m12590j();
    }
}
