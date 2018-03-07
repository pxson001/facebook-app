package com.facebook.search.model;

import com.facebook.search.model.NullStateModuleSuggestionUnit.Type;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: TOP_FLUSH */
public class NullStateModuleCollectionUnit extends TypeaheadCollectionUnit {
    public final Type f22187a;
    public final String f22188b;
    public final String f22189c;
    @Nullable
    public final String f22190d;
    private final ImmutableList<NullStateModuleSuggestionUnit> f22191e;
    public final int f22192f;
    public final boolean f22193g;
    public final int f22194h;

    /* compiled from: TOP_FLUSH */
    public class Builder {
        public Type f22179a;
        public String f22180b;
        public String f22181c;
        public String f22182d;
        public ImmutableList<NullStateModuleSuggestionUnit> f22183e;
        public int f22184f;
        public boolean f22185g;
        public int f22186h;

        public final NullStateModuleCollectionUnit m25687a() {
            return new NullStateModuleCollectionUnit(this);
        }

        public final Builder m25686a(String str) {
            try {
                this.f22179a = Type.valueOf(str.toLowerCase());
            } catch (IllegalArgumentException e) {
                this.f22179a = Type.unset;
            }
            return this;
        }
    }

    public NullStateModuleCollectionUnit(Builder builder) {
        this.f22187a = builder.f22179a;
        this.f22188b = builder.f22180b;
        this.f22189c = builder.f22181c;
        this.f22190d = builder.f22182d;
        this.f22191e = builder.f22183e;
        this.f22192f = builder.f22184f;
        this.f22193g = builder.f22185g;
        this.f22194h = builder.f22186h;
    }

    public final ImmutableList<NullStateModuleSuggestionUnit> mo1222f() {
        return this.f22191e;
    }

    public final <T> T m25689a(TypeaheadSuggestionVisitorWithReturn<T> typeaheadSuggestionVisitorWithReturn) {
        return null;
    }

    public final void m25690a(TypeaheadSuggestionVisitor typeaheadSuggestionVisitor) {
    }

    public final boolean m25693l() {
        return false;
    }

    public final boolean jG_() {
        return true;
    }

    public final SuggestionGroup.Type m25692k() {
        SuggestionGroup.Type type;
        if (this.f22187a != null) {
            switch (this.f22187a) {
                case ns_pulse:
                    type = SuggestionGroup.Type.NS_PULSE;
                    break;
                case ns_trending:
                    type = SuggestionGroup.Type.TRENDING;
                    break;
                case ns_social:
                    type = SuggestionGroup.Type.NS_SOCIAL;
                    break;
                case ns_interest:
                    type = SuggestionGroup.Type.NS_INTERESTED;
                    break;
                case ns_local:
                    type = SuggestionGroup.Type.NEARBY;
                    break;
                case ns_suggested:
                    type = SuggestionGroup.Type.NS_SUGGESTED;
                    break;
                case recent_search:
                    type = SuggestionGroup.Type.RECENT;
                    break;
                case ns_top:
                    type = SuggestionGroup.Type.NS_TOP;
                    break;
                default:
                    type = SuggestionGroup.Type.NO_GROUP;
                    break;
            }
        }
        type = SuggestionGroup.Type.NO_GROUP;
        return type;
    }

    public static NullStateModuleCollectionUnit m25688a(NullStateModuleCollectionUnit nullStateModuleCollectionUnit, int i) {
        Builder a = new Builder().m25686a(nullStateModuleCollectionUnit.f22187a.name());
        a.f22180b = nullStateModuleCollectionUnit.f22188b;
        a = a;
        a.f22181c = nullStateModuleCollectionUnit.f22189c;
        a = a;
        a.f22182d = nullStateModuleCollectionUnit.f22190d;
        a = a;
        a.f22183e = nullStateModuleCollectionUnit.mo1222f();
        a = a;
        a.f22184f = nullStateModuleCollectionUnit.f22192f;
        a = a;
        a.f22185g = nullStateModuleCollectionUnit.f22193g;
        a = a;
        a.f22186h = i;
        return a.m25687a();
    }
}
