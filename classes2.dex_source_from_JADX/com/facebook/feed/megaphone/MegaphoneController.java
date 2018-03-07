package com.facebook.feed.megaphone;

import android.content.Context;
import android.widget.BaseAdapter;
import com.facebook.config.versioninfo.module.VersionStringComparatorMethodAutoProvider;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.dialtone.DialtoneController;
import com.facebook.dialtone.DialtoneControllerImpl;
import com.facebook.dialtone.common.DialtoneStateChangedListener;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.rows.adapter.api.HasMultiRow;
import com.facebook.feed.rows.controllercallbacks.AdapterCreatedCallback;
import com.facebook.graphql.enums.GraphQLMegaphoneLocation;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.megaphone.data.MegaphoneStore;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ultralight.Inject;
import com.facebook.widget.listview.ScrollingViewProxy;

/* compiled from: pending_story_has_null_id */
public class MegaphoneController extends BaseController implements DialtoneStateChangedListener, AdapterCreatedCallback {
    @Inject
    public DialtoneController f10269a;
    @Inject
    public FeedMegaphoneAdapter f10270b;
    @Inject
    public MegaphoneStore f10271c;
    public HasInvalidate f10272d;

    public static MegaphoneController m15348a(InjectorLike injectorLike) {
        MegaphoneController megaphoneController = new MegaphoneController();
        FeedMegaphoneAdapter feedMegaphoneAdapter = new FeedMegaphoneAdapter((Context) injectorLike.getInstance(Context.class), IdBasedSingletonScopeProvider.m1810b(injectorLike, 9772), MegaphoneStore.m15368a(injectorLike), InterstitialManager.m8082a(injectorLike), VersionStringComparatorMethodAutoProvider.m8670a(injectorLike));
        MegaphoneStore a = MegaphoneStore.m15368a(injectorLike);
        megaphoneController.f10269a = DialtoneControllerImpl.m8272a(injectorLike);
        megaphoneController.f10270b = feedMegaphoneAdapter;
        megaphoneController.f10271c = a;
        return megaphoneController;
    }

    public final void iw_() {
    }

    public final void b_(boolean z) {
        BaseAdapter baseAdapter = this.f10270b;
        FeedMegaphoneAdapter.m15357g(baseAdapter);
        AdapterDetour.a(baseAdapter, 1840070602);
        this.f10272d.hL_();
    }

    public final void mo1889a(HasMultiRow hasMultiRow, ScrollingViewProxy scrollingViewProxy, FeedEnvironment feedEnvironment) {
        this.f10272d = feedEnvironment;
        this.f10269a.mo1210a((DialtoneStateChangedListener) this);
        MegaphoneStore megaphoneStore = this.f10271c;
        megaphoneStore.f10303j.mo431a(GraphQLMegaphoneLocation.NEWSFEED, (Object) this);
    }

    public final void kF_() {
        this.f10272d = null;
        this.f10269a.mo1220b((DialtoneStateChangedListener) this);
        MegaphoneStore megaphoneStore = this.f10271c;
        megaphoneStore.f10303j.mo412c(GraphQLMegaphoneLocation.NEWSFEED, this);
    }

    public final FeedMegaphoneAdapter m15350c() {
        return this.f10270b;
    }
}
