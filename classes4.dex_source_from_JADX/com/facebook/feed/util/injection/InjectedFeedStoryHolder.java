package com.facebook.feed.util.injection;

import android.text.TextUtils;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.json.JsonFactoryMethodAutoProvider;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: platform_add_pending_media_upload_params */
public class InjectedFeedStoryHolder {
    public final JsonFactory f4606a;
    private final ObjectMapper f4607b;
    public ImmutableList<FeedUnit> f4608c = RegularImmutableList.a;

    public static InjectedFeedStoryHolder m5086b(InjectorLike injectorLike) {
        return new InjectedFeedStoryHolder(JsonFactoryMethodAutoProvider.a(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public InjectedFeedStoryHolder(JsonFactory jsonFactory, ObjectMapper objectMapper) {
        this.f4606a = jsonFactory;
        this.f4607b = objectMapper;
    }

    public final boolean m5089a(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            m5087a();
            return false;
        }
        m5084a(new 1(this, str));
        return m5090b();
    }

    public final boolean m5088a(File file) {
        if (!file.exists() || file.length() == 0) {
            m5087a();
            return false;
        }
        m5084a(new 2(this, file));
        return m5090b();
    }

    public final void m5087a() {
        if (m5090b()) {
            this.f4608c = RegularImmutableList.a;
        }
    }

    public final boolean m5090b() {
        return !this.f4608c.isEmpty();
    }

    public static void m5085a(InjectedFeedStoryHolder injectedFeedStoryHolder, JsonParser jsonParser) {
        Collection a = m5083a(jsonParser, injectedFeedStoryHolder.f4607b);
        if (a != null) {
            injectedFeedStoryHolder.f4608c = ImmutableList.copyOf(a);
        } else {
            injectedFeedStoryHolder.m5087a();
        }
    }

    private static List<FeedUnit> m5083a(JsonParser jsonParser, ObjectMapper objectMapper) {
        JsonToken c = jsonParser.c();
        if (c == JsonToken.START_OBJECT) {
            return ImmutableList.of((FeedUnit) objectMapper.a(jsonParser, FeedUnit.class));
        }
        if (c == JsonToken.START_ARRAY) {
            return (List) objectMapper.a(jsonParser, new 3());
        }
        throw new IOException("JSON feed injection data does not start with { or [");
    }

    private void m5084a(ThrowingRunnable throwingRunnable) {
        try {
            throwingRunnable.a();
        } catch (Throwable e) {
            m5087a();
            throw Throwables.propagate(e);
        }
    }
}
