package com.facebook.photos.mediagallery.ui.tagging;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.Assisted;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: slideEdges */
public class TaggingIntentController {
    private final Context f2548a;
    private final UriIntentMapper f2549b;
    private final SecureContextHelper f2550c;

    @Inject
    public TaggingIntentController(@Assisted Context context, UriIntentMapper uriIntentMapper, SecureContextHelper secureContextHelper) {
        this.f2548a = context;
        this.f2549b = uriIntentMapper;
        this.f2550c = secureContextHelper;
    }

    public final void m2657a(String str, String str2) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(str2));
        Intent a = this.f2549b.a(this.f2548a, StringFormatUtil.formatStrLocaleSafe(str, str2));
        if (a != null) {
            this.f2550c.a(a, this.f2548a);
        }
    }
}
