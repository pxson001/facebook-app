package com.facebook.messaging.business.attachments.model;

import android.net.Uri;
import com.google.common.base.Strings;

/* compiled from: viewer_has_seen */
public class LogoImageBuilder {
    public Uri f434a;
    public int f435b;
    public int f436c;

    public final LogoImageBuilder m389a(String str) {
        this.f434a = !Strings.isNullOrEmpty(str) ? Uri.parse(str) : null;
        return this;
    }

    public final LogoImage m390d() {
        return new LogoImage(this);
    }
}
