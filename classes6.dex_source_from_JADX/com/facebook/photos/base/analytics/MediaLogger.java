package com.facebook.photos.base.analytics;

import android.content.Context;
import android.util.Log;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.photos.base.analytics.constants.ConsumptionLoggingConstants.ContentViewingSurface;
import com.facebook.photos.base.analytics.constants.ConsumptionLoggingConstants.UserAction;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.Event;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.TagScreen;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.TagSource;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: keywords_commerce(%s) */
public class MediaLogger implements PhotoLoggingConstants {
    private static final Class<?> f12632a = MediaLogger.class;
    private static final boolean f12633b = Log.isLoggable("MediaLogger", 3);
    private static MediaLogger f12634i;
    private static final Object f12635j = new Object();
    private String f12636c;
    public String f12637d;
    private ContentViewingSurface f12638e;
    private FullscreenGallerySource f12639f;
    public String f12640g;
    private final AnalyticsLogger f12641h;

    private static MediaLogger m19975b(InjectorLike injectorLike) {
        return new MediaLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), String_LoggedInUserIdMethodAutoProvider.b(injectorLike));
    }

    public static MediaLogger m19973a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MediaLogger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12635j) {
                MediaLogger mediaLogger;
                if (a2 != null) {
                    mediaLogger = (MediaLogger) a2.a(f12635j);
                } else {
                    mediaLogger = f12634i;
                }
                if (mediaLogger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m19975b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12635j, b3);
                        } else {
                            f12634i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = mediaLogger;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public MediaLogger(AnalyticsLogger analyticsLogger, String str) {
        this.f12641h = analyticsLogger;
        this.f12636c = str;
    }

    public final MediaLogger m19979a(String str) {
        Preconditions.checkNotNull(str);
        this.f12637d = str;
        return this;
    }

    public final MediaLogger m19977a(ContentViewingSurface contentViewingSurface) {
        Preconditions.checkNotNull(contentViewingSurface);
        this.f12638e = contentViewingSurface;
        return this;
    }

    public final MediaLogger m19978a(FullscreenGallerySource fullscreenGallerySource) {
        Preconditions.checkNotNull(fullscreenGallerySource);
        this.f12639f = fullscreenGallerySource;
        return this;
    }

    public final void m19981a(@Nonnull String str, @Nullable String str2, @Nonnull UserAction userAction) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(userAction);
        Map d = m19976d();
        d.put("content_id", str);
        d.put("action", userAction.value);
        if (str2 != null) {
            d.put("owner_id", str2);
        }
        m19974a(Event.ANDROID_PHOTOS_CONSUMPTION, d, str);
    }

    public final void m19985b(String str, @Nullable String str2, UserAction userAction) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(userAction);
        Map d = m19976d();
        d.put("content_id", str);
        d.put("action", userAction.value);
        if (str2 != null) {
            d.put("owner_id", str2);
        }
        m19974a(Event.PHOTO_GALLERY_MENU_SHOWN, d, str);
    }

    public final void m19987c(String str) {
        Map d = m19976d();
        d.put("content_id", str);
        m19974a(Event.PHOTO_SAVE_SUCCEEDED, d, str);
    }

    public final void m19982a(String str, @Nullable String str2, UserAction userAction, String str3, ContentViewingSurface contentViewingSurface, FullscreenGallerySource fullscreenGallerySource) {
        m19979a((String) Preconditions.checkNotNull(str3));
        m19977a((ContentViewingSurface) Preconditions.checkNotNull(contentViewingSurface));
        m19978a((FullscreenGallerySource) Preconditions.checkNotNull(fullscreenGallerySource));
        Map d = m19976d();
        d.put("content_id", Preconditions.checkNotNull(str));
        d.put("action", ((UserAction) Preconditions.checkNotNull(userAction)).value);
        if (str2 != null) {
            d.put("owner_id", str2);
        }
        m19974a(Event.ANDROID_PHOTOS_CONSUMPTION, d, str);
    }

    public final void m19983a(boolean z, int i, @Nonnull TagSource tagSource, @Nonnull TagScreen tagScreen) {
        Preconditions.checkNotNull(tagSource);
        Preconditions.checkNotNull(tagScreen);
        Map d = m19976d();
        d.put("is_text", Boolean.toString(z));
        d.put("ex_tag_screen", tagScreen.name());
        d.put("tag_src", tagSource.name());
        d.put("ex_tag_index", Integer.toString(i));
        m19974a(Event.TAG_CREATED, d, null);
    }

    public final void m19980a(@Nonnull TagScreen tagScreen, boolean z) {
        Preconditions.checkNotNull(tagScreen);
        Map d = m19976d();
        d.put("ex_tag_screen", tagScreen.name());
        d.put("is_text", Boolean.toString(z));
        m19974a(Event.TAG_DELETED, d, null);
    }

    public final void m19984b() {
        m19974a(Event.TAGS_DELETE_SUCCEEDED, null, null);
    }

    public final void m19986c() {
        m19974a(Event.TAGS_DELETE_FAILED, null, null);
    }

    private HashMap<String, String> m19976d() {
        HashMap<String, String> c = Maps.c();
        Preconditions.checkNotNull(this.f12636c);
        Preconditions.checkNotNull(this.f12637d);
        Preconditions.checkNotNull(this.f12638e);
        Preconditions.checkNotNull(this.f12639f);
        c.put("viewer_id", this.f12636c);
        c.put("viewing_session_id", this.f12637d);
        c.put("viewing_surface", this.f12638e.value);
        c.put("referrer", String.valueOf(this.f12639f.referrer));
        if (this.f12640g != null) {
            c.put("referrer_id", this.f12640g);
        }
        return c;
    }

    private void m19974a(Event event, Map<String, String> map, String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(event.toString().toLowerCase(Locale.US));
        honeyClientEvent.c = "composer";
        if (map == null) {
            map = Maps.c();
        }
        for (Entry entry : r14.entrySet()) {
            honeyClientEvent.b((String) entry.getKey(), (String) entry.getValue());
        }
        if (!StringUtil.a(this.f12637d)) {
            honeyClientEvent.f = this.f12637d;
        }
        if (!StringUtil.a(str)) {
            honeyClientEvent.j(str);
        }
        if (f12633b) {
            StringBuilder stringBuilder = new StringBuilder();
            int i = 1;
            for (Entry entry2 : r14.entrySet()) {
                String str2 = "%s%s:%s";
                Object[] objArr = new Object[3];
                objArr[0] = i != 0 ? "" : ", ";
                objArr[1] = entry2.getKey();
                objArr[2] = entry2.getValue();
                stringBuilder.append(StringFormatUtil.a(str2, objArr));
                i = 0;
            }
        }
        this.f12641h.c(honeyClientEvent);
    }
}
