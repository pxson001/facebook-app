package com.facebook.redspace.fragment.controllercallbacks.controller;

import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.fragment.FragmentCreateDestroyCallbacks;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.adapter.api.HasMultiRow;
import com.facebook.feed.rows.controllercallbacks.AdapterCreatedCallback;
import com.facebook.feed.util.composer.ComposerActivityReceiver;
import com.facebook.feed.util.composer.ComposerActivityReceiver.Listener;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.redspace.data.RedSpaceWallCollection;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.listview.MultiAdapterListAdapter;
import com.facebook.widget.listview.ScrollingViewProxy;

/* compiled from: PagesContactInboxLeadUpdateStateMutation */
public class RedSpaceComposerActivityController extends BaseController implements FragmentCreateDestroyCallbacks, AdapterCreatedCallback {
    @Inject
    public ComposerActivityReceiver f12037a;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<GraphQLSubscriptionHolder> f12038b = UltralightRuntime.b;
    private MultiAdapterListAdapter f12039c;
    public TimelineContext f12040d;
    public RedSpaceWallCollection f12041e;
    public final Listener f12042f = new C14421(this);

    /* compiled from: PagesContactInboxLeadUpdateStateMutation */
    class C14421 implements Listener {
        final /* synthetic */ RedSpaceComposerActivityController f12036a;

        C14421(RedSpaceComposerActivityController redSpaceComposerActivityController) {
            this.f12036a = redSpaceComposerActivityController;
        }

        public final boolean m12506a(long j, GraphQLStory graphQLStory) {
            return this.f12036a.f12040d != null && j == this.f12036a.f12040d.b;
        }

        public final void m12505a(GraphQLStory graphQLStory) {
            if (this.f12036a.f12041e != null) {
                this.f12036a.f12041e.m12344a(graphQLStory);
                RedSpaceComposerActivityController.m12510d(this.f12036a);
            }
        }

        public final void m12508b(GraphQLStory graphQLStory) {
            if (this.f12036a.f12041e != null && graphQLStory != null) {
                this.f12036a.f12041e.m12344a(graphQLStory);
                this.f12036a.f12041e.m12343a((GraphQLSubscriptionHolder) this.f12036a.f12038b.get(), graphQLStory);
                RedSpaceComposerActivityController.m12510d(this.f12036a);
            }
        }

        public final void m12504a() {
        }

        public final void m12507b() {
            RedSpaceComposerActivityController.m12510d(this.f12036a);
        }
    }

    public static RedSpaceComposerActivityController m12509b(InjectorLike injectorLike) {
        RedSpaceComposerActivityController redSpaceComposerActivityController = new RedSpaceComposerActivityController();
        ComposerActivityReceiver b = ComposerActivityReceiver.b(injectorLike);
        com.facebook.inject.Lazy a = IdBasedLazy.a(injectorLike, 2169);
        redSpaceComposerActivityController.f12037a = b;
        redSpaceComposerActivityController.f12038b = a;
        return redSpaceComposerActivityController;
    }

    public final void m12511a(HasMultiRow hasMultiRow, ScrollingViewProxy scrollingViewProxy, FeedEnvironment feedEnvironment) {
        this.f12039c = (MultiAdapterListAdapter) hasMultiRow;
    }

    public final void kF_() {
    }

    public final void m12512b() {
        this.f12037a.b();
    }

    public static void m12510d(RedSpaceComposerActivityController redSpaceComposerActivityController) {
        if (redSpaceComposerActivityController.f12039c != null) {
            AdapterDetour.a(redSpaceComposerActivityController.f12039c, -421308170);
        }
    }
}
