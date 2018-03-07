package com.facebook.messaging.business.common.calltoaction.model;

import android.net.Uri;
import com.facebook.messaging.business.common.calltoaction.model.CallToAction.Type;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;

/* compiled from: defaultGoogleSignInAccount */
public class CallToActionBuilder {
    public String f5183a;
    public String f5184b;
    public Uri f5185c;
    public Type f5186d;
    public ImmutableList<String> f5187e;
    public boolean f5188f;

    public final CallToActionBuilder m10055c(String str) {
        this.f5185c = !Strings.isNullOrEmpty(str) ? Uri.parse(str) : null;
        return this;
    }

    public final CallToAction m10056g() {
        return new CallToAction(this);
    }
}
