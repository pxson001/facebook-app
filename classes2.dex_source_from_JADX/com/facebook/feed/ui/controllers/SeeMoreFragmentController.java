package com.facebook.feed.ui.controllers;

import com.facebook.api.feed.data.LegacyFeedUnitUpdater;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.api.Holder;
import com.facebook.controllercallbacks.fragment.ResumePauseCallbacks;
import com.facebook.debug.log.BLog;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.rows.adapter.api.HasMultiRow;
import com.facebook.feed.rows.controllercallbacks.AdapterCreatedCallback;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.InjectorLike;
import com.facebook.ultralight.Inject;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.google.common.util.concurrent.FutureCallback;

/* compiled from: platform_copy_platform_app_content */
public class SeeMoreFragmentController extends BaseController implements ResumePauseCallbacks, AdapterCreatedCallback {
    public static final Class<?> f9715a = SeeMoreFragmentController.class;
    private final SeeMoreController f9716b;
    private final FeedEventBus f9717c;
    public HasInvalidate f9718d;
    public Holder<LegacyFeedUnitUpdater> f9719e;
    private FutureCallback<GraphQLStory> f9720f;

    /* compiled from: platform_copy_platform_app_content */
    public class C05731 implements FutureCallback<GraphQLStory> {
        final /* synthetic */ SeeMoreFragmentController f13915a;

        public C05731(SeeMoreFragmentController seeMoreFragmentController) {
            this.f13915a = seeMoreFragmentController;
        }

        public void onSuccess(Object obj) {
            FeedUnit feedUnit = (GraphQLStory) obj;
            if (this.f13915a.f9718d != null) {
                ((LegacyFeedUnitUpdater) this.f13915a.f9719e.f10429a).mo1379a(feedUnit);
                this.f13915a.f9718d.mo2438a(feedUnit);
            }
        }

        public void onFailure(Throwable th) {
            BLog.b(SeeMoreFragmentController.f9715a, "Failed to load substories", th);
        }
    }

    public static SeeMoreFragmentController m14731a(InjectorLike injectorLike) {
        return new SeeMoreFragmentController(FeedEventBus.m4573a(injectorLike), SeeMoreController.m14735a(injectorLike));
    }

    @Inject
    public SeeMoreFragmentController(FeedEventBus feedEventBus, SeeMoreController seeMoreController) {
        this.f9716b = seeMoreController;
        this.f9717c = feedEventBus;
    }

    public final void mo1889a(HasMultiRow hasMultiRow, ScrollingViewProxy scrollingViewProxy, FeedEnvironment feedEnvironment) {
        this.f9718d = feedEnvironment;
    }

    public final void kF_() {
        this.f9718d = null;
    }

    public final void mo1264c() {
        if (this.f9720f == null) {
            this.f9720f = new C05731(this);
        }
        this.f9716b.f9725c = this.f9720f;
        this.f9717c.m4568a(this.f9716b.f9724b);
    }

    public final void mo1265d() {
        this.f9717c.m4569b(this.f9716b.f9724b);
        this.f9716b.m14737b();
    }
}
