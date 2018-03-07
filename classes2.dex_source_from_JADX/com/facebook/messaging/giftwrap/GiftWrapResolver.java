package com.facebook.messaging.giftwrap;

import com.facebook.inject.InjectorLike;
import com.facebook.messaging.giftwrap.GiftWrapSettings.Builder;
import com.facebook.messaging.model.messages.Message;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mPropertyType */
public class GiftWrapResolver {
    public final FbSharedPreferences f15478a;
    private final GiftWrapFeature f15479b;

    public static GiftWrapResolver m22042b(InjectorLike injectorLike) {
        return new GiftWrapResolver(FbSharedPreferencesImpl.m1826a(injectorLike), GiftWrapFeature.m22045b(injectorLike));
    }

    @Inject
    public GiftWrapResolver(FbSharedPreferences fbSharedPreferences, GiftWrapFeature giftWrapFeature) {
        this.f15478a = fbSharedPreferences;
        this.f15479b = giftWrapFeature;
    }

    @Nullable
    public final GiftWrapSettings m22043a(Message message) {
        if (!this.f15479b.f15481b.m2189a(228, false)) {
            return null;
        }
        if (((String) message.v.get("gift_wrap")) == null) {
            return null;
        }
        Builder builder = new Builder();
        builder.d = -13361;
        builder = builder;
        builder.a = -377780;
        builder = builder;
        builder.c = -34428;
        builder = builder;
        builder.b = "hearts";
        return new GiftWrapSettings(builder);
    }

    public final boolean m22044b(Message message) {
        return (m22043a(message) == null || this.f15478a.mo286a(GiftWrapPrefKeys.a(message), false)) ? false : true;
    }

    public static GiftWrapResolver m22041a(InjectorLike injectorLike) {
        return m22042b(injectorLike);
    }
}
