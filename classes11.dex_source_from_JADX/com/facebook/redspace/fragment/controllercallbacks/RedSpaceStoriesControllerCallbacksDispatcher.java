package com.facebook.redspace.fragment.controllercallbacks;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.util.SimpleArrayMap;
import android.view.View;
import com.facebook.base.fragment.FbFragment;
import com.facebook.base.fragment.FbFragmentController;
import com.facebook.common.viewport.ViewportEventListener;
import com.facebook.controllercallbacks.api.BaseDispatcher;
import com.facebook.controllercallbacks.api.Holder;
import com.facebook.controllercallbacks.api.SetUp;
import com.facebook.controllercallbacks.api.TearDown;
import com.facebook.controllercallbacks.fragment.ActivityResultCallback;
import com.facebook.controllercallbacks.fragment.ConfigurationChangedCallback;
import com.facebook.controllercallbacks.fragment.FragmentCreateDestroyCallbacks;
import com.facebook.controllercallbacks.fragment.OnSaveInstanceStateCallback;
import com.facebook.controllercallbacks.fragment.OnUserVisibleHintCallback;
import com.facebook.controllercallbacks.fragment.ResumePauseCallbacks;
import com.facebook.controllercallbacks.fragment.StartStopCallbacks;
import com.facebook.controllercallbacks.fragment.ViewCreatedDestroyedCallbacks;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.fragment.controllercallbacks.FeedLoggingViewportController;
import com.facebook.feed.rows.adapter.api.HasMultiRow;
import com.facebook.feed.rows.controllercallbacks.AdapterCreatedCallback;
import com.facebook.graphql.enums.GraphQLRedSpaceActivityType;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.redspace.badge.RedSpaceOptimisticBadgeViewportEventListener;
import com.facebook.redspace.data.RedSpaceFeedProfileUnreadStoriesHelper;
import com.facebook.redspace.data.RedSpaceHeaderCollection;
import com.facebook.redspace.data.RedSpaceWallCollection;
import com.facebook.redspace.fragment.controllercallbacks.RedSpaceStoriesDispatcherFactory.RedSpaceStoriesControllerCallbacks;
import com.facebook.redspace.fragment.controllercallbacks.controller.RedSpaceComposerActivityController;
import com.facebook.redspace.fragment.controllercallbacks.controller.RedSpaceFeedEventController;
import com.facebook.redspace.fragment.controllercallbacks.controller.RedSpaceFriendViewMutationController;
import com.facebook.redspace.fragment.controllercallbacks.controller.RedSpacePresenceActivityController;
import com.facebook.redspace.fragment.controllercallbacks.controller.RedSpacePresenceActivityController.PresenceChanged;
import com.facebook.redspace.fragment.controllercallbacks.controller.RedSpaceSelfViewMutationController;
import com.facebook.redspace.fragment.controllercallbacks.controller.RedSpaceViewportMonitorFragmentController;
import com.facebook.redspace.fragment.controllercallbacks.controller.RedSpaceWallLoadEventController;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel.RedspaceModel.ActivitiesModel.NodesModel;
import com.facebook.user.model.UserKey;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.google.common.collect.ImmutableList;

/* compiled from: PagesServicesItemFragment */
public class RedSpaceStoriesControllerCallbacksDispatcher extends BaseDispatcher implements ViewportEventListener, ActivityResultCallback, ConfigurationChangedCallback, FragmentCreateDestroyCallbacks, OnSaveInstanceStateCallback, OnUserVisibleHintCallback, ResumePauseCallbacks, StartStopCallbacks, ViewCreatedDestroyedCallbacks, AdapterCreatedCallback {
    public FbFragmentController<RedSpaceStoriesControllerCallbacks> f12013a;
    public RedSpaceViewportMonitorFragmentController<RedSpaceStoriesControllerCallbacks> f12014b;
    public RedSpaceFeedEventController f12015c;
    public RedSpaceFriendViewMutationController f12016d;
    private RedSpacePresenceActivityController f12017e;
    public RedSpaceWallLoadEventController f12018f;
    public RedSpaceComposerActivityController f12019g;
    public RedSpaceSelfViewMutationController f12020h;
    private RedSpaceOptimisticBadgeViewportEventListener f12021i;
    private FeedLoggingViewportController f12022j;

    public RedSpaceStoriesControllerCallbacksDispatcher(FbFragmentController<RedSpaceStoriesControllerCallbacks> fbFragmentController, RedSpaceViewportMonitorFragmentController<RedSpaceStoriesControllerCallbacks> redSpaceViewportMonitorFragmentController, RedSpaceFeedEventController redSpaceFeedEventController, RedSpaceFriendViewMutationController redSpaceFriendViewMutationController, RedSpacePresenceActivityController redSpacePresenceActivityController, RedSpaceWallLoadEventController redSpaceWallLoadEventController, RedSpaceComposerActivityController redSpaceComposerActivityController, RedSpaceSelfViewMutationController redSpaceSelfViewMutationController, RedSpaceOptimisticBadgeViewportEventListener redSpaceOptimisticBadgeViewportEventListener, FeedLoggingViewportController feedLoggingViewportController) {
        this.f12013a = fbFragmentController;
        this.f12014b = redSpaceViewportMonitorFragmentController;
        this.f12015c = redSpaceFeedEventController;
        this.f12016d = redSpaceFriendViewMutationController;
        this.f12017e = redSpacePresenceActivityController;
        this.f12018f = redSpaceWallLoadEventController;
        this.f12019g = redSpaceComposerActivityController;
        this.f12020h = redSpaceSelfViewMutationController;
        this.f12021i = redSpaceOptimisticBadgeViewportEventListener;
        this.f12022j = feedLoggingViewportController;
    }

    public final void m12495g() {
        RedSpaceViewportMonitorFragmentController redSpaceViewportMonitorFragmentController;
        RedSpaceFeedEventController redSpaceFeedEventController;
        Object obj;
        RedSpaceFriendViewMutationController redSpaceFriendViewMutationController;
        RedSpacePresenceActivityController redSpacePresenceActivityController;
        RedSpaceWallLoadEventController redSpaceWallLoadEventController;
        RedSpaceComposerActivityController redSpaceComposerActivityController;
        RedSpaceSelfViewMutationController redSpaceSelfViewMutationController;
        RedSpaceOptimisticBadgeViewportEventListener redSpaceOptimisticBadgeViewportEventListener;
        FeedLoggingViewportController feedLoggingViewportController = null;
        this.f12013a = this.f12013a.kJ_() ? this.f12013a : null;
        if (this.f12014b.kJ_()) {
            redSpaceViewportMonitorFragmentController = this.f12014b;
        } else {
            redSpaceViewportMonitorFragmentController = null;
        }
        this.f12014b = redSpaceViewportMonitorFragmentController;
        if (this.f12015c.kJ_()) {
            redSpaceFeedEventController = this.f12015c;
        } else {
            redSpaceFeedEventController = null;
        }
        this.f12015c = redSpaceFeedEventController;
        if (this.f12016d.f12070f.i()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            redSpaceFriendViewMutationController = this.f12016d;
        } else {
            redSpaceFriendViewMutationController = null;
        }
        this.f12016d = redSpaceFriendViewMutationController;
        if (this.f12017e.kJ_()) {
            redSpacePresenceActivityController = this.f12017e;
        } else {
            redSpacePresenceActivityController = null;
        }
        this.f12017e = redSpacePresenceActivityController;
        if (this.f12018f.kJ_()) {
            redSpaceWallLoadEventController = this.f12018f;
        } else {
            redSpaceWallLoadEventController = null;
        }
        this.f12018f = redSpaceWallLoadEventController;
        if (this.f12019g.kJ_()) {
            redSpaceComposerActivityController = this.f12019g;
        } else {
            redSpaceComposerActivityController = null;
        }
        this.f12019g = redSpaceComposerActivityController;
        if (this.f12020h.f12104b.i()) {
            redSpaceSelfViewMutationController = this.f12020h;
        } else {
            redSpaceSelfViewMutationController = null;
        }
        this.f12020h = redSpaceSelfViewMutationController;
        if (this.f12021i.a()) {
            redSpaceOptimisticBadgeViewportEventListener = this.f12021i;
        } else {
            redSpaceOptimisticBadgeViewportEventListener = null;
        }
        this.f12021i = redSpaceOptimisticBadgeViewportEventListener;
        if (this.f12022j.kJ_()) {
            feedLoggingViewportController = this.f12022j;
        }
        this.f12022j = feedLoggingViewportController;
    }

    public final void m12479a(RedSpaceStoriesControllerCallbacksDispatcher redSpaceStoriesControllerCallbacksDispatcher) {
        if (this.f12013a != null) {
            this.f12013a.a = redSpaceStoriesControllerCallbacksDispatcher;
        }
        if (this.f12014b != null) {
            this.f12014b.f12109b = redSpaceStoriesControllerCallbacksDispatcher;
        }
    }

    @SetUp
    public final void m12491c() {
        if (this.f12015c != null) {
            this.f12015c.m12524c();
        }
        if (this.f12018f != null) {
            this.f12018f.m12565c();
        }
        if (this.f12022j != null) {
            this.f12022j.c();
        }
    }

    @TearDown
    public final void m12492d() {
        if (this.f12022j != null) {
            this.f12022j.d();
        }
        if (this.f12018f != null) {
            this.f12018f.m12566d();
        }
        if (this.f12015c != null) {
            this.f12015c.m12525d();
        }
    }

    @SetUp
    public final void m12493e() {
        if (this.f12017e != null) {
            this.f12017e.m12539e();
        }
    }

    @TearDown
    public final void m12494f() {
        if (this.f12017e != null) {
            this.f12017e.m12540f();
        }
    }

    public final void m12486a(boolean z) {
        if (this.f12016d != null) {
            this.f12016d.m12529a(z);
        }
        if (this.f12018f != null) {
            this.f12018f.m12563a(z);
        }
        if (this.f12020h != null) {
            this.f12020h.m12556a(z);
        }
        if (this.f12022j != null) {
            this.f12022j.a(z);
        }
    }

    public final void m12471a(Bundle bundle) {
        if (this.f12016d != null) {
            this.f12016d.m12528a(bundle);
        }
        if (this.f12018f != null) {
            this.f12018f.m12562a(bundle);
        }
        if (this.f12020h != null) {
            this.f12020h.m12555a(bundle);
        }
    }

    @TearDown
    public final void m12487b() {
        if (this.f12020h != null) {
            this.f12020h.m12557b();
        }
        if (this.f12019g != null) {
            this.f12019g.m12512b();
        }
        if (this.f12018f != null) {
            this.f12018f.m12564b();
        }
        if (this.f12016d != null) {
            this.f12016d.m12530b();
        }
        if (this.f12015c != null) {
            this.f12015c.m12523b();
        }
        if (this.f12014b != null) {
            this.f12014b.m12558b();
        }
        if (this.f12013a != null) {
            this.f12013a.b();
        }
    }

    @SetUp
    public final void m12473a(View view) {
    }

    @TearDown
    public final void kG_() {
    }

    public final void m12470a(Configuration configuration) {
    }

    public final void m12469a(int i, int i2, Intent intent) {
    }

    public final void m12476a(TimelineContext timelineContext) {
        if (this.f12016d != null) {
            this.f12016d.f12070f = timelineContext;
        }
        if (this.f12017e != null) {
            this.f12017e.f12083c = timelineContext;
        }
        if (this.f12019g != null) {
            this.f12019g.f12040d = timelineContext;
        }
        if (this.f12020h != null) {
            this.f12020h.f12104b = timelineContext;
        }
    }

    public final void m12478a(RedSpaceWallCollection redSpaceWallCollection) {
        if (this.f12018f != null) {
            this.f12018f.f12116g = redSpaceWallCollection;
        }
        if (this.f12019g != null) {
            this.f12019g.f12041e = redSpaceWallCollection;
        }
    }

    public final void m12480a(RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel) {
        if (this.f12016d != null) {
            this.f12016d.f12069e = redSpaceFeedProfileFragmentModel;
        }
        if (this.f12017e != null) {
            RedSpacePresenceActivityController redSpacePresenceActivityController = this.f12017e;
            redSpacePresenceActivityController.f12082b = redSpaceFeedProfileFragmentModel;
            redSpacePresenceActivityController.f12085e = UserKey.b(redSpacePresenceActivityController.f12082b.k());
            if (redSpacePresenceActivityController.f12082b != null && redSpacePresenceActivityController.f12082b.m() != null && redSpacePresenceActivityController.f12082b.m().a() != null) {
                ImmutableList a = redSpacePresenceActivityController.f12082b.m().a().a();
                int size = a.size();
                for (int i = 0; i < size; i++) {
                    if (((NodesModel) a.get(i)).a() == GraphQLRedSpaceActivityType.PRESENCE) {
                        redSpacePresenceActivityController.f12086f = new PresenceChanged(redSpacePresenceActivityController);
                        redSpacePresenceActivityController.f12084d = true;
                        break;
                    }
                }
            }
        }
        if (this.f12018f != null) {
            RedSpaceWallLoadEventController redSpaceWallLoadEventController = this.f12018f;
            if (redSpaceWallLoadEventController.f12115f == 0) {
                redSpaceWallLoadEventController.f12115f = ((RedSpaceFeedProfileUnreadStoriesHelper) redSpaceWallLoadEventController.f12110a.get()).m12204a(redSpaceFeedProfileFragmentModel);
            }
        }
    }

    public final void m12477a(RedSpaceHeaderCollection redSpaceHeaderCollection) {
        if (this.f12017e != null) {
            this.f12017e.f12087g = redSpaceHeaderCollection;
        }
    }

    public final void m12482a(ScrollingViewProxy scrollingViewProxy, Object obj, int i) {
        if (this.f12021i != null) {
            this.f12021i.a(scrollingViewProxy, obj, i);
        }
        if (this.f12022j != null) {
            this.f12022j.a(scrollingViewProxy, obj, i);
        }
    }

    public final void m12484a(Object obj) {
        if (this.f12021i != null) {
            this.f12021i.a(obj);
        }
        if (this.f12022j != null) {
            this.f12022j.a(obj);
        }
    }

    public final void m12483a(ScrollingViewProxy scrollingViewProxy, Object obj, int i, int i2) {
        if (this.f12021i != null) {
            this.f12021i.a(scrollingViewProxy, obj, i, i2);
        }
        if (this.f12022j != null) {
            this.f12022j.a(scrollingViewProxy, obj, i, i2);
        }
    }

    public final void m12490b(Object obj) {
        if (this.f12021i != null) {
            this.f12021i.b(obj);
        }
        if (this.f12022j != null) {
            this.f12022j.b(obj);
        }
    }

    public final void m12489b(ScrollingViewProxy scrollingViewProxy, Object obj, int i) {
        if (this.f12021i != null) {
            this.f12021i.b(scrollingViewProxy, obj, i);
        }
        if (this.f12022j != null) {
            this.f12022j.b(scrollingViewProxy, obj, i);
        }
    }

    public final void m12481a(ScrollingViewProxy scrollingViewProxy) {
        if (this.f12021i != null) {
            this.f12021i.a(scrollingViewProxy);
        }
        if (this.f12022j != null) {
            this.f12022j.a(scrollingViewProxy);
        }
    }

    public final void m12488b(ScrollingViewProxy scrollingViewProxy) {
        if (this.f12021i != null) {
            this.f12021i.b(scrollingViewProxy);
        }
        if (this.f12022j != null) {
            this.f12022j.b(scrollingViewProxy);
        }
    }

    public final void m12472a(SimpleArrayMap<Object, Object> simpleArrayMap) {
        if (this.f12021i != null) {
            this.f12021i.a(simpleArrayMap);
        }
        if (this.f12022j != null) {
            this.f12022j.a(simpleArrayMap);
        }
    }

    public final void m12485a(String str) {
        if (this.f12022j != null) {
            this.f12022j.b = str;
        }
    }

    @SetUp
    public final void m12475a(HasMultiRow hasMultiRow, ScrollingViewProxy scrollingViewProxy, FeedEnvironment feedEnvironment) {
        if (this.f12017e != null) {
            this.f12017e.m12538a(hasMultiRow, scrollingViewProxy, feedEnvironment);
        }
        if (this.f12019g != null) {
            this.f12019g.m12511a(hasMultiRow, scrollingViewProxy, feedEnvironment);
        }
    }

    @TearDown
    public final void kF_() {
        if (this.f12019g != null) {
            this.f12019g.kF_();
        }
        if (this.f12017e != null) {
            this.f12017e.kF_();
        }
    }

    public final void m12474a(Holder<FbFragment> holder) {
        if (this.f12013a != null) {
            this.f12013a.b = holder;
        }
    }

    public final void m12468a() {
        this.f12013a = null;
        this.f12014b = null;
        this.f12015c = null;
        this.f12016d = null;
        this.f12017e = null;
        this.f12018f = null;
        this.f12019g = null;
        this.f12020h = null;
        this.f12021i = null;
        this.f12022j = null;
        super.a();
    }
}
