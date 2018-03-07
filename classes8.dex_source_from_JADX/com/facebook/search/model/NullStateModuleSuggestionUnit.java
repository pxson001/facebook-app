package com.facebook.search.model;

import com.facebook.common.util.StringLocaleUtil;
import com.facebook.common.util.StringUtil;
import com.google.common.base.Objects;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: TOP_ENTITIES */
public class NullStateModuleSuggestionUnit extends TypeaheadUnit implements NullStateModuleUnit {
    public final Type f22208a;
    public final String f22209b;
    @Nullable
    public final String f22210c;
    @Nullable
    private final String f22211d;
    @Nullable
    private final String f22212e;
    @Nullable
    private final String f22213f;
    @Nullable
    public final String f22214g;
    public final String f22215h;
    public final String f22216i;
    public final String f22217j;
    @Nullable
    public final String f22218k;
    public final boolean f22219l;
    private final Type f22220m;
    public boolean f22221n = false;

    /* compiled from: TOP_ENTITIES */
    public class Builder {
        public Type f22195a;
        public String f22196b;
        public String f22197c;
        public String f22198d;
        public String f22199e;
        public String f22200f;
        public String f22201g;
        public String f22202h;
        public String f22203i;
        public String f22204j;
        public String f22205k;
        public boolean f22206l;
        public Type f22207m;

        public static Type m25694m(String str) {
            try {
                return Type.valueOf(StringLocaleUtil.a(str));
            } catch (IllegalArgumentException e) {
                return Type.unset;
            }
        }
    }

    /* compiled from: TOP_ENTITIES */
    public enum Type {
        ns_pulse,
        ns_trending,
        ns_social,
        ns_interest,
        ns_local,
        ns_suggested,
        recent_search,
        ns_top,
        unset
    }

    public NullStateModuleSuggestionUnit(Builder builder) {
        this.f22208a = builder.f22195a;
        this.f22209b = builder.f22196b;
        this.f22210c = builder.f22197c;
        this.f22211d = builder.f22198d;
        this.f22212e = builder.f22199e;
        this.f22213f = builder.f22200f;
        this.f22214g = builder.f22201g;
        this.f22215h = builder.f22202h;
        this.f22216i = builder.f22203i;
        this.f22217j = builder.f22204j;
        this.f22218k = builder.f22205k;
        this.f22219l = builder.f22206l;
        this.f22220m = builder.f22207m;
    }

    public final Type mo1223p() {
        return this.f22220m;
    }

    @Nullable
    public final String m25699n() {
        if (StringUtil.a(this.f22210c)) {
            return this.f22211d;
        }
        return this.f22210c + " ⋅ " + this.f22211d;
    }

    public final <T> T m25695a(TypeaheadSuggestionVisitorWithReturn<T> typeaheadSuggestionVisitorWithReturn) {
        return typeaheadSuggestionVisitorWithReturn.mo1227a(this);
    }

    public final void m25696a(TypeaheadSuggestionVisitor typeaheadSuggestionVisitor) {
        typeaheadSuggestionVisitor.m25773a(this);
    }

    public final com.facebook.search.model.SuggestionGroup.Type m25697k() {
        return null;
    }

    public final boolean m25698l() {
        return true;
    }

    public boolean equals(Object obj) {
        if (obj instanceof NullStateModuleSuggestionUnit) {
            return Objects.equal(this.f22215h, ((NullStateModuleSuggestionUnit) obj).f22215h);
        }
        return false;
    }

    public int hashCode() {
        return this.f22215h.hashCode();
    }
}
