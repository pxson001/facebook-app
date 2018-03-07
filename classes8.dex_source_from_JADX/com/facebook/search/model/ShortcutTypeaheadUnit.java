package com.facebook.search.model;

import android.net.Uri;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.search.model.SuggestionGroup.Type;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: TIMELINE_CONTEXT_ITEM */
public class ShortcutTypeaheadUnit extends TypeaheadUnit {
    public final String f22275a;
    public final String f22276b;
    public final GraphQLObjectType f22277c;
    @Nullable
    public final Uri f22278d;
    @Nullable
    private final String f22279e;
    @Nullable
    public final String f22280f;
    @Nullable
    public final Uri f22281g;
    @Nullable
    public final Uri f22282h;

    /* compiled from: TIMELINE_CONTEXT_ITEM */
    public class Builder {
        public String f22267a;
        public String f22268b;
        public GraphQLObjectType f22269c;
        public Uri f22270d;
        public String f22271e;
        public String f22272f;
        public Uri f22273g;
        public Uri f22274h;

        public final ShortcutTypeaheadUnit m25748i() {
            return new ShortcutTypeaheadUnit(this);
        }
    }

    public ShortcutTypeaheadUnit(Builder builder) {
        this.f22275a = (String) Preconditions.checkNotNull(builder.f22267a);
        this.f22276b = (String) Preconditions.checkNotNull(builder.f22268b);
        this.f22277c = (GraphQLObjectType) Preconditions.checkNotNull(builder.f22269c);
        this.f22281g = builder.f22273g;
        this.f22282h = builder.f22274h;
        this.f22278d = builder.f22270d;
        this.f22279e = builder.f22271e;
        this.f22280f = builder.f22272f;
    }

    public final <T> T m25749a(TypeaheadSuggestionVisitorWithReturn<T> typeaheadSuggestionVisitorWithReturn) {
        return typeaheadSuggestionVisitorWithReturn.mo1233a(this);
    }

    public final void m25750a(TypeaheadSuggestionVisitor typeaheadSuggestionVisitor) {
        typeaheadSuggestionVisitor.m25779a(this);
    }

    public final Type m25751k() {
        return Type.ENTITY;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ShortcutTypeaheadUnit) {
            return this.f22275a.equals(((ShortcutTypeaheadUnit) obj).f22275a);
        }
        return false;
    }

    public int hashCode() {
        return this.f22275a.hashCode();
    }

    public String toString() {
        return "ShortcutTypeaheadUnit[" + this.f22276b + "]";
    }

    public final boolean m25752l() {
        return true;
    }
}
