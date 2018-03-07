package com.facebook.redspace.fragment.controllercallbacks;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import com.facebook.base.fragment.FbFragmentController;
import com.facebook.controllercallbacks.api.BaseDispatcher;
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
import com.facebook.feed.fragment.controllercallbacks.SwipeRefreshController.Callback;
import com.facebook.redspace.data.RedSpaceFriendsCollection;
import com.facebook.redspace.data.RedSpaceFriendsFetchResult;
import com.facebook.redspace.data.RedSpaceFriendsSection;
import com.facebook.redspace.fragment.controllercallbacks.RedSpaceHomeDispatcherFactory.RedSpaceHomeControllerCallbacks;
import com.facebook.redspace.fragment.controllercallbacks.api.RedSpaceFriendsFetchCallback;
import com.facebook.redspace.fragment.controllercallbacks.controller.RedSpaceBadgeController;
import com.facebook.redspace.fragment.controllercallbacks.controller.RedSpaceHomeViewMutatorController;
import com.facebook.redspace.fragment.controllercallbacks.controller.RedSpaceSelfProfileDataController;

/* compiled from: PandoraAlbumPermalinkDetailsView layout mismatch */
public class RedSpaceHomeControllerCallbacksDispatcher extends BaseDispatcher implements ActivityResultCallback, ConfigurationChangedCallback, FragmentCreateDestroyCallbacks, OnSaveInstanceStateCallback, OnUserVisibleHintCallback, ResumePauseCallbacks, StartStopCallbacks, ViewCreatedDestroyedCallbacks, Callback, RedSpaceFriendsFetchCallback {
    public FbFragmentController<RedSpaceHomeControllerCallbacks> f12006a;
    public RedSpaceBadgeController f12007b;
    public RedSpaceSelfProfileDataController f12008c;
    public RedSpaceHomeViewMutatorController f12009d;

    public RedSpaceHomeControllerCallbacksDispatcher(FbFragmentController<RedSpaceHomeControllerCallbacks> fbFragmentController, RedSpaceBadgeController redSpaceBadgeController, RedSpaceSelfProfileDataController redSpaceSelfProfileDataController, RedSpaceHomeViewMutatorController redSpaceHomeViewMutatorController) {
        this.f12006a = fbFragmentController;
        this.f12007b = redSpaceBadgeController;
        this.f12008c = redSpaceSelfProfileDataController;
        this.f12009d = redSpaceHomeViewMutatorController;
    }

    @SetUp
    public final void m12463c() {
        if (this.f12008c != null) {
            this.f12008c.m12550c();
        }
        if (this.f12009d != null) {
            this.f12009d.m12533c();
        }
    }

    @TearDown
    public final void m12464d() {
        if (this.f12009d != null) {
            this.f12009d.m12534d();
        }
        if (this.f12008c != null) {
            this.f12008c.m12551d();
        }
    }

    @SetUp
    public final void m12465e() {
    }

    @TearDown
    public final void m12466f() {
    }

    public final void m12461a(boolean z) {
    }

    public final void m12457a(Bundle bundle) {
    }

    @TearDown
    public final void m12462b() {
        if (this.f12008c != null) {
            this.f12008c.m12549b();
        }
        if (this.f12007b != null) {
            this.f12007b.m12503b();
        }
        if (this.f12006a != null) {
            this.f12006a.b();
        }
    }

    @SetUp
    public final void m12458a(View view) {
    }

    @TearDown
    public final void kG_() {
    }

    public final void m12456a(Configuration configuration) {
    }

    public final void m12455a(int i, int i2, Intent intent) {
    }

    public final void mo343a(RedSpaceFriendsSection redSpaceFriendsSection, RedSpaceFriendsCollection redSpaceFriendsCollection) {
        if (this.f12007b != null) {
            this.f12007b.mo343a(redSpaceFriendsSection, redSpaceFriendsCollection);
        }
    }

    public final void mo344a(RedSpaceFriendsSection redSpaceFriendsSection, RedSpaceFriendsCollection redSpaceFriendsCollection, RedSpaceFriendsFetchResult redSpaceFriendsFetchResult) {
        if (this.f12007b != null) {
            this.f12007b.mo344a(redSpaceFriendsSection, redSpaceFriendsCollection, redSpaceFriendsFetchResult);
        }
    }

    public final void a_(Throwable th) {
        if (this.f12007b != null) {
            this.f12007b.a_(th);
        }
    }

    public final void av() {
        if (this.f12008c != null) {
            this.f12008c.av();
        }
        if (this.f12009d != null) {
            this.f12009d.av();
        }
    }

    public final void m12454a() {
        this.f12006a = null;
        this.f12007b = null;
        this.f12008c = null;
        this.f12009d = null;
        super.a();
    }
}
