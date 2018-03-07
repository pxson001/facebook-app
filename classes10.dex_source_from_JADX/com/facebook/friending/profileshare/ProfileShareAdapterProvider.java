package com.facebook.friending.profileshare;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: add-pinned-thread */
public class ProfileShareAdapterProvider extends AbstractAssistedProvider<ProfileShareAdapter> {
    public final ProfileShareAdapter m20538a(boolean z) {
        return new ProfileShareAdapter(AllCapsTransformationMethod.b(this), ResourcesMethodAutoProvider.a(this), z);
    }
}
