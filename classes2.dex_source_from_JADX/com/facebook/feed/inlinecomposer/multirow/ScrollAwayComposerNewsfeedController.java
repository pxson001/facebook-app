package com.facebook.feed.inlinecomposer.multirow;

import android.content.res.Resources;
import android.net.Uri;
import android.support.design.widget.AppBarLayout.ScrollingViewBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.util.UriUtil;
import com.facebook.composer.ui.drawables.GlyphpileDrawable;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.fragment.ViewCreatedDestroyedCallbacks;
import com.facebook.feed.inlinecomposer.multirow.ScrollAwayComposerController.1;
import com.facebook.feed.util.composer.abtest.ExperimentsForFeedUtilComposerAbtestModule;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: pages_service_create_edit_react_native */
public class ScrollAwayComposerNewsfeedController extends BaseController implements ViewCreatedDestroyedCallbacks {
    private final AbstractFbErrorReporter f10403a;
    private final ScrollAwayComposerController f10404b;

    public static ScrollAwayComposerNewsfeedController m15500a(InjectorLike injectorLike) {
        return new ScrollAwayComposerNewsfeedController(FbErrorReporterImpl.m2317a(injectorLike), ScrollAwayComposerController.m15502a(injectorLike));
    }

    @Inject
    public ScrollAwayComposerNewsfeedController(AbstractFbErrorReporter abstractFbErrorReporter, ScrollAwayComposerController scrollAwayComposerController) {
        this.f10403a = abstractFbErrorReporter;
        this.f10404b = scrollAwayComposerController;
    }

    public final boolean kJ_() {
        return this.f10404b.m15504a();
    }

    public final void mo1886a(View view) {
        View findViewById = view.findViewById(2131562166);
        ScrollAwayComposerView scrollAwayComposerView = (ScrollAwayComposerView) view.findViewById(2131562168);
        if (findViewById == null || scrollAwayComposerView == null) {
            this.f10403a.m2350b("scroll_away_composer", "layout is not valid for scroll away composer");
            return;
        }
        LayoutParams layoutParams = findViewById.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            ((CoordinatorLayout.LayoutParams) layoutParams).a(new ScrollingViewBehavior());
            ScrollAwayComposerController scrollAwayComposerController = this.f10404b;
            if (scrollAwayComposerView != null) {
                Uri a = UriUtil.m18787a(scrollAwayComposerController.f10412f.m2523c().m5856x());
                scrollAwayComposerView.setTitleText(scrollAwayComposerController.f10408b.mo580a(ExperimentsForFeedUtilComposerAbtestModule.ag, 2131234528, scrollAwayComposerController.f10407a.getResources()));
                scrollAwayComposerView.setProfilePhotoUri(a);
                scrollAwayComposerView.setOnClickListener(new 1(scrollAwayComposerController));
                Resources resources = scrollAwayComposerController.f10407a.getResources();
                GlyphpileDrawable glyphpileDrawable = new GlyphpileDrawable(ImmutableList.of(resources.getDrawable(2130838228), resources.getDrawable(2130838227), resources.getDrawable(2130838229)), 0);
                glyphpileDrawable.setColorFilter(scrollAwayComposerController.f10410d.m11488a(resources.getColor(2131361936)));
                scrollAwayComposerView.setIcon(glyphpileDrawable);
            }
            return;
        }
        this.f10403a.m2350b("scroll_away_composer", "newsfeed container is not in a CoordinatorLayout");
    }

    public final void kG_() {
    }
}
