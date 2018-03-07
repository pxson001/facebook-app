package com.facebook.common.uri;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.common.uri.UriIntentBuilder.IUriTemplateIntentBuilder;

/* compiled from: after_party_popular_at_android */
public class UriFlaggedIntentBuilder implements IUriTemplateIntentBuilder {
    private final IUriTemplateIntentBuilder f11185a;
    private final int f11186b;

    public UriFlaggedIntentBuilder(IUriTemplateIntentBuilder iUriTemplateIntentBuilder, int i) {
        this.f11185a = iUriTemplateIntentBuilder;
        this.f11186b = i;
    }

    public final Intent mo1029a(Context context, Bundle bundle) {
        Intent a = this.f11185a.mo1029a(context, bundle);
        a.addFlags(this.f11186b);
        return a;
    }
}
