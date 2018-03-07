package com.facebook.redspace.fragment.controllercallbacks.controller;

import android.os.Bundle;
import com.facebook.controllercallbacks.fragment.FragmentCreateDestroyCallbacks;
import com.facebook.controllercallbacks.fragment.OnSaveInstanceStateCallback;
import com.facebook.controllercallbacks.fragment.OnUserVisibleHintCallback;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.RedspaceSelfViewInputData;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.redspace.data.RedSpaceSelfViewMutator;
import com.facebook.redspace.protocol.RedSpaceMutationFragments.RedSpaceSelfViewMutationString;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;

/* compiled from: PageServicesCardEnabled */
public class RedSpaceSelfViewMutationController implements FragmentCreateDestroyCallbacks, OnSaveInstanceStateCallback, OnUserVisibleHintCallback {
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<RedSpaceSelfViewMutator> f12103a = UltralightRuntime.b;
    public TimelineContext f12104b;
    public boolean f12105c;
    public boolean f12106d;
    private boolean f12107e;

    public final void m12556a(boolean z) {
        this.f12107e = z;
        m12553d();
    }

    public final void m12554a() {
        this.f12106d = true;
        m12553d();
    }

    private void m12553d() {
        if (!this.f12105c && this.f12106d && this.f12107e) {
            RedSpaceSelfViewMutator redSpaceSelfViewMutator = (RedSpaceSelfViewMutator) this.f12103a.get();
            RedspaceSelfViewInputData redspaceSelfViewInputData = new RedspaceSelfViewInputData();
            redspaceSelfViewInputData.a("actor_id", redSpaceSelfViewMutator.f11874b);
            GraphQlCallInput graphQlCallInput = redspaceSelfViewInputData;
            GraphQlQueryString redSpaceSelfViewMutationString = new RedSpaceSelfViewMutationString();
            redSpaceSelfViewMutationString.a("input", graphQlCallInput);
            redSpaceSelfViewMutator.f11873a.a(GraphQLRequest.a(redSpaceSelfViewMutationString));
            this.f12105c = true;
        }
    }

    public final void m12557b() {
    }

    public final void m12555a(Bundle bundle) {
        bundle.putBoolean("bundle_self_view_sent", this.f12105c);
        bundle.putBoolean("bundle_self_view_fetch", this.f12106d);
    }
}
