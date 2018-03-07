package com.facebook.base.fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.api.BaseDispatcher;
import com.facebook.controllercallbacks.api.Holder;
import com.facebook.controllercallbacks.fragment.ActivityResultCallback;
import com.facebook.controllercallbacks.fragment.ConfigurationChangedCallback;
import com.facebook.controllercallbacks.fragment.FragmentCreateDestroyCallbacks;
import com.facebook.controllercallbacks.fragment.OnSaveInstanceStateCallback;
import com.facebook.controllercallbacks.fragment.OnUserVisibleHintCallback;
import com.facebook.controllercallbacks.fragment.ResumePauseCallbacks;
import com.facebook.controllercallbacks.fragment.StartStopCallbacks;
import com.facebook.controllercallbacks.fragment.ViewCreatedDestroyedCallbacks;
import javax.annotation.Nullable;

/* compiled from: on */
public class FbFragmentController<Dispatcher extends ActivityResultCallback & ConfigurationChangedCallback & FragmentCreateDestroyCallbacks & OnUserVisibleHintCallback & OnSaveInstanceStateCallback & ResumePauseCallbacks & StartStopCallbacks & ViewCreatedDestroyedCallbacks> extends BaseController implements FragmentCreateDestroyCallbacks {
    public Dispatcher f11200a;
    public Holder<FbFragment> f11201b;
    private FbFragmentListener f11202c;

    /* compiled from: on */
    class FragmentListener extends AbstractFbFragmentListener {
        final /* synthetic */ FbFragmentController f11379a;

        public FragmentListener(FbFragmentController fbFragmentController) {
            this.f11379a = fbFragmentController;
        }

        public final void mo2135a(Fragment fragment, View view, @Nullable Bundle bundle) {
            ((ViewCreatedDestroyedCallbacks) this.f11379a.f11200a).mo1886a(view);
        }

        public final void mo2139b(Fragment fragment) {
            ((ViewCreatedDestroyedCallbacks) this.f11379a.f11200a).kG_();
        }

        public final void mo2141c(Fragment fragment) {
            ((ResumePauseCallbacks) this.f11379a.f11200a).mo1265d();
        }

        public final void mo2142d(Fragment fragment) {
            ((ResumePauseCallbacks) this.f11379a.f11200a).mo1264c();
        }

        public final void mo2143e(Fragment fragment) {
            ((FragmentCreateDestroyCallbacks) this.f11379a.f11200a).mo1949b();
            ((BaseDispatcher) this.f11379a.f11200a).mo2117a();
        }

        public final void mo2137b() {
            ((StartStopCallbacks) this.f11379a.f11200a).mo2120f();
        }

        public final void mo2140c() {
            ((StartStopCallbacks) this.f11379a.f11200a).mo2119e();
        }

        public final void mo2133a(int i, int i2, Intent intent) {
            this.f11379a.f11200a.mo1941a(i, i2, intent);
        }

        public final void mo2134a(Configuration configuration) {
            ((ConfigurationChangedCallback) this.f11379a.f11200a).mo1947a(configuration);
        }

        public final void mo2136a(boolean z) {
            ((OnUserVisibleHintCallback) this.f11379a.f11200a).mo1948a(z);
        }

        public final void mo2138b(Bundle bundle) {
            ((OnSaveInstanceStateCallback) this.f11379a.f11200a).mo2118a(bundle);
        }
    }

    public final void m16520a(Fragment fragment) {
        this.f11201b.m15525a((FbFragment) fragment);
        this.f11202c = new FragmentListener(this);
        ((FbFragment) this.f11201b.f10429a).m13758a(this.f11202c);
    }

    public final void mo1949b() {
        ((FbFragment) this.f11201b.f10429a).m13761b(this.f11202c);
        this.f11201b.f10429a = null;
        this.f11202c = null;
    }
}
