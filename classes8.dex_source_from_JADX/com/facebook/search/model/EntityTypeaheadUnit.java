package com.facebook.search.model;

import android.net.Uri;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLPageVerificationBadge;
import com.facebook.search.bootstrap.model.BootstrapEntity;
import com.facebook.search.model.SuggestionGroup.Type;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: TYPEFACE */
public class EntityTypeaheadUnit extends TypeaheadUnit {
    public final String f22045a;
    public final String f22046b;
    public final GraphQLObjectType f22047c;
    public final Uri f22048d;
    public final String f22049e;
    public final String f22050f;
    public final boolean f22051g;
    public final GraphQLPageVerificationBadge f22052h;
    public final boolean f22053i;
    public final boolean f22054j;
    public final ImmutableList<String> f22055k;
    public final boolean f22056l;
    private final boolean f22057m;
    private final boolean f22058n;
    public final boolean f22059o;

    /* compiled from: TYPEFACE */
    public class Builder {
        public String f22030a;
        public String f22031b;
        public GraphQLObjectType f22032c;
        public Uri f22033d;
        public String f22034e;
        @Nullable
        public String f22035f;
        public boolean f22036g = false;
        public GraphQLPageVerificationBadge f22037h = GraphQLPageVerificationBadge.NOT_VERIFIED;
        public boolean f22038i = false;
        public boolean f22039j = false;
        @Nullable
        public ImmutableList<String> f22040k;
        public boolean f22041l;
        public boolean f22042m;
        public boolean f22043n;
        public boolean f22044o = false;

        public final Builder m25605a(EntityTypeaheadUnit entityTypeaheadUnit) {
            this.f22031b = entityTypeaheadUnit.f22045a;
            this.f22030a = entityTypeaheadUnit.f22046b;
            this.f22032c = entityTypeaheadUnit.f22047c;
            this.f22033d = entityTypeaheadUnit.f22048d;
            this.f22034e = entityTypeaheadUnit.f22049e;
            this.f22035f = entityTypeaheadUnit.f22050f;
            this.f22036g = entityTypeaheadUnit.f22051g;
            this.f22037h = entityTypeaheadUnit.f22052h;
            this.f22038i = entityTypeaheadUnit.f22053i;
            this.f22039j = true;
            this.f22040k = entityTypeaheadUnit.f22055k;
            this.f22041l = entityTypeaheadUnit.f22056l;
            this.f22043n = entityTypeaheadUnit.x();
            this.f22044o = entityTypeaheadUnit.f22059o;
            return this;
        }

        public final Builder m25604a(int i) {
            this.f22032c = new GraphQLObjectType(i);
            return this;
        }

        public final EntityTypeaheadUnit m25606p() {
            return new EntityTypeaheadUnit(this);
        }
    }

    public EntityTypeaheadUnit(Builder builder) {
        this.f22045a = (String) Preconditions.checkNotNull(builder.f22031b);
        this.f22046b = (String) Preconditions.checkNotNull(builder.f22030a);
        this.f22047c = (GraphQLObjectType) Preconditions.checkNotNull(builder.f22032c);
        this.f22048d = builder.f22033d;
        this.f22050f = builder.f22035f;
        this.f22049e = builder.f22034e;
        this.f22051g = builder.f22036g;
        this.f22052h = builder.f22037h;
        this.f22053i = builder.f22038i;
        this.f22054j = builder.f22039j;
        this.f22055k = builder.f22040k;
        this.f22056l = builder.f22041l;
        this.f22057m = builder.f22042m;
        this.f22058n = builder.f22043n;
        this.f22059o = builder.f22044o;
    }

    public final <T extends TypeaheadUnit> boolean m25610a(T t, T t2) {
        if (t.getClass() != EntityTypeaheadUnit.class || t2.getClass() != EntityTypeaheadUnit.class) {
            return false;
        }
        EntityTypeaheadUnit entityTypeaheadUnit = (EntityTypeaheadUnit) t;
        EntityTypeaheadUnit entityTypeaheadUnit2 = (EntityTypeaheadUnit) t2;
        if (entityTypeaheadUnit.f22046b.equals(entityTypeaheadUnit2.f22046b) && entityTypeaheadUnit.f22049e != null && entityTypeaheadUnit.f22049e.equals(entityTypeaheadUnit2.f22049e) && entityTypeaheadUnit.f22048d != null && entityTypeaheadUnit.f22048d.equals(entityTypeaheadUnit2.f22048d) && entityTypeaheadUnit.f22054j == entityTypeaheadUnit2.f22054j && entityTypeaheadUnit.f22057m == entityTypeaheadUnit2.f22057m && entityTypeaheadUnit.f22058n == entityTypeaheadUnit2.f22058n && entityTypeaheadUnit.f22059o == entityTypeaheadUnit2.f22059o) {
            return true;
        }
        return false;
    }

    public final boolean m25613u() {
        return this.f22054j;
    }

    public final <T> T m25608a(TypeaheadSuggestionVisitorWithReturn<T> typeaheadSuggestionVisitorWithReturn) {
        return typeaheadSuggestionVisitorWithReturn.mo1224a(this);
    }

    public final void m25609a(TypeaheadSuggestionVisitor typeaheadSuggestionVisitor) {
        typeaheadSuggestionVisitor.m25770a(this);
    }

    public final Type m25611k() {
        return Type.ENTITY;
    }

    public final boolean m25614x() {
        return this.f22058n;
    }

    public final boolean m25615y() {
        return this.f22057m;
    }

    public boolean equals(Object obj) {
        if (obj instanceof EntityTypeaheadUnit) {
            return this.f22045a.equals(((EntityTypeaheadUnit) obj).f22045a);
        }
        return false;
    }

    public int hashCode() {
        return this.f22045a.hashCode();
    }

    public String toString() {
        return "EntityTypeaheadUnit(" + this.f22046b + ") {bootstrap: " + this.f22054j + ", phonetic: " + this.f22056l + "}";
    }

    public final BootstrapEntity m25607A() {
        com.facebook.search.bootstrap.model.BootstrapEntity.Builder builder = new com.facebook.search.bootstrap.model.BootstrapEntity.Builder();
        builder.b = this.f22045a;
        builder = builder;
        builder.a = this.f22046b;
        builder = builder;
        builder.f = this.f22050f;
        builder = builder;
        builder.e = this.f22049e;
        builder = builder;
        builder.d = this.f22048d;
        builder = builder;
        builder.c = this.f22047c;
        builder = builder;
        builder.i = this.f22053i;
        builder = builder;
        builder.g = this.f22051g;
        builder = builder;
        builder.h = this.f22052h;
        builder = builder.a(this.f22055k);
        builder.k = 0.5d;
        return builder.l();
    }

    public final boolean m25612l() {
        return true;
    }
}
