package com.facebook.timeline.intent;

import android.content.Context;
import android.content.Intent;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.editgallery.EditGalleryIpcBundle;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: deltaForcedFetch */
public class TimelineIntentFactory {
    private final Context f17633a;
    @LoggedInUserId
    private final Provider<String> f17634b;
    private final UriIntentMapper f17635c;

    public static TimelineIntentFactory m25633b(InjectorLike injectorLike) {
        return new TimelineIntentFactory((Context) injectorLike.getInstance(Context.class), IdBasedProvider.a(injectorLike, 4442), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike));
    }

    @Inject
    public TimelineIntentFactory(Context context, Provider<String> provider, UriIntentMapper uriIntentMapper) {
        this.f17633a = context;
        this.f17634b = provider;
        this.f17635c = uriIntentMapper;
    }

    public final Intent m25635a(EditGalleryIpcBundle editGalleryIpcBundle, @Nullable String str, long j, @Nullable String str2, String str3) {
        Intent a = m25634a();
        if (a == null) {
            return null;
        }
        a.putExtra(EditGalleryIpcBundle.f11617a, editGalleryIpcBundle);
        a.putExtra("extra_overlay_source_media_id", str);
        a.putExtra("extra_profile_pic_expiration", j);
        a.putExtra("extra_profile_pic_caption", str2);
        a.putExtra("profile_photo_method_extra", str3);
        return a;
    }

    public static TimelineIntentFactory m25632a(InjectorLike injectorLike) {
        return m25633b(injectorLike);
    }

    @Nullable
    public final Intent m25634a() {
        return this.f17635c.a(this.f17633a, StringFormatUtil.a(FBLinks.aX, new Object[]{this.f17634b.get()}));
    }
}
