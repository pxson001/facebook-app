package com.facebook.privacy.audience;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.fragment.ActivityResultCallback;
import com.facebook.controllercallbacks.fragment.ActivityResultUtil;
import com.facebook.controllercallbacks.fragment.ViewCreatedDestroyedCallbacks;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: omnistore_remove_called */
public class PostPrivacyUpsellDialogFragmentController extends BaseController implements ActivityResultCallback, ViewCreatedDestroyedCallbacks {
    private final PostPrivacyUpsellDialogController$EntryPoint f11207a;
    private final Lazy<PostPrivacyUpsellDialogController> f11208b;
    private ViewGroup f11209c;

    @Inject
    public PostPrivacyUpsellDialogFragmentController(@Assisted PostPrivacyUpsellDialogController$EntryPoint postPrivacyUpsellDialogController$EntryPoint, Lazy<PostPrivacyUpsellDialogController> lazy) {
        this.f11208b = lazy;
        this.f11207a = postPrivacyUpsellDialogController$EntryPoint;
    }

    public final void mo1886a(View view) {
        this.f11209c = (ViewGroup) view;
    }

    public final void mo1941a(int i, int i2, Intent intent) {
        if (ActivityResultUtil.a(1856, i, i, intent)) {
            ((PostPrivacyUpsellDialogController) this.f11208b.get()).a(this.f11209c.getContext(), this.f11209c, (GraphQLPrivacyOption) FlatBufferModelHelper.a(intent, "privacy_option_to_upsell"), this.f11207a);
        }
    }

    public final void kG_() {
        this.f11209c = null;
    }
}
