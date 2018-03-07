package com.facebook.photos.intent;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: hashtag/{%s}?name={%s} */
public class PhotosViewIntentProvider {
    private final String f13079a = "com.facebook.photos.photogallery.";
    public final Context f13080b;
    public final UriIntentMapper f13081c;

    public static PhotosViewIntentProvider m20408b(InjectorLike injectorLike) {
        return new PhotosViewIntentProvider((Context) injectorLike.getInstance(Context.class), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike));
    }

    @Inject
    public PhotosViewIntentProvider(Context context, UriIntentMapper uriIntentMapper) {
        this.f13080b = context;
        this.f13081c = uriIntentMapper;
    }

    public static PhotosViewIntentProvider m20407a(InjectorLike injectorLike) {
        return m20408b(injectorLike);
    }

    public final Intent m20410a(Context context, String str) {
        Preconditions.checkState(!Strings.isNullOrEmpty(str));
        return this.f13081c.a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.aL, str));
    }

    public final Intent m20409a(long j) {
        return this.f13081c.a(this.f13080b, StringFormatUtil.a(FBLinks.af, new Object[]{Long.valueOf(j)}));
    }

    @Nullable
    public final Intent m20411b(long j) {
        return this.f13081c.a(this.f13080b, StringFormatUtil.a(FBLinks.dv, new Object[]{Long.valueOf(j)}));
    }
}
