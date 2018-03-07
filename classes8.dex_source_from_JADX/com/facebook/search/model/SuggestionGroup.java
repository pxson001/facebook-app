package com.facebook.search.model;

import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: TIMELINE_ABOUT_FRIENDS_APP_MUTUAL_FRIENDS_LINK */
public class SuggestionGroup {
    public final Type f22289a;
    public final ImmutableList<TypeaheadUnit> f22290b;
    @Nullable
    public final String f22291c;
    @Nullable
    public final String f22292d;
    private final int f22293e;
    public final boolean f22294f;

    /* compiled from: TIMELINE_ABOUT_FRIENDS_APP_MUTUAL_FRIENDS_LINK */
    public class Builder {
        public Type f22283a;
        public ImmutableList<TypeaheadUnit> f22284b;
        public String f22285c;
        public String f22286d;
        public int f22287e;
        public boolean f22288f;

        public final Builder m25753a(Type type) {
            this.f22283a = type;
            return this;
        }

        public final Builder m25754a(ImmutableList<TypeaheadUnit> immutableList) {
            this.f22284b = immutableList;
            return this;
        }

        public final Builder m25755a(@Nullable String str) {
            this.f22285c = str;
            return this;
        }

        public final SuggestionGroup m25756a() {
            return new SuggestionGroup(this);
        }
    }

    /* compiled from: TIMELINE_ABOUT_FRIENDS_APP_MUTUAL_FRIENDS_LINK */
    public enum Type {
        DEFAULT,
        NO_GROUP,
        RECENT,
        RECENT_VIDEOS,
        TRENDING,
        PYMK,
        KEYWORD,
        ENTITY,
        BLENDED,
        PLACE_TIP,
        NEARBY,
        NS_PULSE,
        NS_INTERESTED,
        NS_SOCIAL,
        NS_SUGGESTED,
        NS_TOP,
        NS_SEARCH_SPOTLIGHT
    }

    public SuggestionGroup(Builder builder) {
        this.f22289a = builder.f22283a;
        this.f22290b = builder.f22284b;
        this.f22291c = builder.f22285c;
        this.f22292d = builder.f22286d;
        this.f22293e = builder.f22287e;
        this.f22294f = builder.f22288f;
    }
}
