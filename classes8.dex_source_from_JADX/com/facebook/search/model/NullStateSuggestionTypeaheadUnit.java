package com.facebook.search.model;

import android.net.Uri;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.search.model.KeywordTypeaheadUnit.KeywordType;
import com.facebook.search.model.NullStateModuleSuggestionUnit.Type;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: TOPIC_HEADER */
public class NullStateSuggestionTypeaheadUnit extends TypeaheadUnit implements NullStateModuleUnit {
    public final String f22234a;
    public final String f22235b;
    public final GraphQLObjectType f22236c;
    public final boolean f22237d;
    @Nullable
    public final Uri f22238e;
    @Nullable
    public final Uri f22239f;
    @Nullable
    public final Uri f22240g;
    @Nullable
    public final KeywordType f22241h;
    public final int f22242i;
    private final Type f22243j;
    public final ImmutableList<GraphQLGraphSearchResultsDisplayStyle> f22244k;

    /* compiled from: TOPIC_HEADER */
    public class Builder {
        public String f22223a;
        public String f22224b;
        public GraphQLObjectType f22225c;
        public boolean f22226d;
        public Uri f22227e;
        public Uri f22228f;
        public Uri f22229g;
        public KeywordType f22230h;
        public int f22231i;
        public Type f22232j = Type.recent_search;
        public ImmutableList<GraphQLGraphSearchResultsDisplayStyle> f22233k;

        public final NullStateSuggestionTypeaheadUnit m25705j() {
            return new NullStateSuggestionTypeaheadUnit(this);
        }
    }

    public NullStateSuggestionTypeaheadUnit(Builder builder) {
        Uri uri;
        this.f22234a = (String) Preconditions.checkNotNull(builder.f22224b);
        this.f22235b = (String) Preconditions.checkNotNull(builder.f22223a);
        this.f22237d = builder.f22226d;
        this.f22236c = (GraphQLObjectType) Preconditions.checkNotNull(builder.f22225c);
        if (m25717z()) {
            uri = null;
        } else {
            uri = (Uri) Preconditions.checkNotNull(builder.f22227e);
        }
        this.f22238e = uri;
        this.f22239f = builder.f22228f;
        this.f22240g = builder.f22229g;
        this.f22241h = builder.f22230h;
        this.f22242i = builder.f22231i;
        this.f22243j = builder.f22232j;
        this.f22244k = builder.f22233k;
    }

    public final String m25714m() {
        return this.f22235b;
    }

    public final int m25716v() {
        return this.f22242i;
    }

    public final <T> T m25710a(TypeaheadSuggestionVisitorWithReturn<T> typeaheadSuggestionVisitorWithReturn) {
        return typeaheadSuggestionVisitorWithReturn.mo1229a(this);
    }

    public final void m25711a(TypeaheadSuggestionVisitor typeaheadSuggestionVisitor) {
        typeaheadSuggestionVisitor.m25775a(this);
    }

    public final SuggestionGroup.Type m25712k() {
        return SuggestionGroup.Type.RECENT;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof NullStateSuggestionTypeaheadUnit)) {
            return false;
        }
        if (m25717z() && ((NullStateSuggestionTypeaheadUnit) obj).m25717z()) {
            return this.f22235b.equals(((NullStateSuggestionTypeaheadUnit) obj).f22235b);
        }
        return this.f22234a.equals(((NullStateSuggestionTypeaheadUnit) obj).f22234a) && this.f22235b.equals(((NullStateSuggestionTypeaheadUnit) obj).f22235b);
    }

    public int hashCode() {
        return this.f22234a.hashCode();
    }

    public final boolean m25717z() {
        return this.f22236c.g() == 907720311 || this.f22236c.g() == -466486798;
    }

    public final Type mo1223p() {
        return this.f22243j;
    }

    public static NullStateSuggestionTypeaheadUnit m25706a(EntityTypeaheadUnit entityTypeaheadUnit) {
        Builder builder = new Builder();
        builder.f22224b = entityTypeaheadUnit.f22045a;
        builder = builder;
        builder.f22225c = entityTypeaheadUnit.f22047c;
        builder = builder;
        builder.f22223a = entityTypeaheadUnit.f22046b;
        builder = builder;
        builder.f22227e = entityTypeaheadUnit.f22048d;
        builder = builder;
        builder.f22226d = true;
        return builder.m25705j();
    }

    public static NullStateSuggestionTypeaheadUnit m25709a(ShortcutTypeaheadUnit shortcutTypeaheadUnit) {
        Builder builder = new Builder();
        builder.f22224b = shortcutTypeaheadUnit.f22275a;
        builder = builder;
        builder.f22225c = shortcutTypeaheadUnit.f22277c;
        builder = builder;
        builder.f22223a = shortcutTypeaheadUnit.f22276b;
        builder = builder;
        builder.f22227e = shortcutTypeaheadUnit.f22278d;
        builder = builder;
        builder.f22228f = shortcutTypeaheadUnit.f22281g;
        builder = builder;
        builder.f22229g = shortcutTypeaheadUnit.f22282h;
        builder = builder;
        builder.f22226d = true;
        return builder.m25705j();
    }

    public static NullStateSuggestionTypeaheadUnit m25708a(NullStateSuggestionTypeaheadUnit nullStateSuggestionTypeaheadUnit) {
        KeywordType keywordType = KeywordType.keyword;
        if (nullStateSuggestionTypeaheadUnit.f22241h == KeywordType.local || nullStateSuggestionTypeaheadUnit.f22241h == KeywordType.local_category) {
            keywordType = nullStateSuggestionTypeaheadUnit.f22241h;
        }
        Builder builder = new Builder();
        builder.f22224b = nullStateSuggestionTypeaheadUnit.f22234a;
        builder = builder;
        builder.f22225c = nullStateSuggestionTypeaheadUnit.f22236c;
        builder = builder;
        builder.f22223a = nullStateSuggestionTypeaheadUnit.f22235b;
        builder = builder;
        builder.f22227e = nullStateSuggestionTypeaheadUnit.f22238e;
        builder = builder;
        builder.f22230h = keywordType;
        Builder builder2 = builder;
        builder2.f22226d = true;
        builder2 = builder2;
        builder2.f22233k = nullStateSuggestionTypeaheadUnit.f22244k;
        builder2 = builder2;
        builder2.f22229g = nullStateSuggestionTypeaheadUnit.f22240g;
        return builder2.m25705j();
    }

    public static NullStateSuggestionTypeaheadUnit m25707a(KeywordTypeaheadUnit keywordTypeaheadUnit) {
        KeywordType keywordType;
        Builder builder = new Builder();
        builder.f22224b = keywordTypeaheadUnit.mo1212b();
        builder = builder;
        builder.f22225c = new GraphQLObjectType(907720311);
        builder = builder;
        builder.f22223a = keywordTypeaheadUnit.mo1211a();
        Builder builder2 = builder;
        if (keywordTypeaheadUnit.f22118g == KeywordType.escape) {
            keywordType = KeywordType.keyword;
        } else {
            keywordType = keywordTypeaheadUnit.f22118g;
        }
        builder2.f22230h = keywordType;
        builder = builder2;
        builder.f22226d = true;
        builder = builder;
        builder.f22233k = keywordTypeaheadUnit.mo1215f();
        return builder.m25705j();
    }

    public final boolean m25713l() {
        return true;
    }

    public String toString() {
        return "NullStateSuggestionTypeaheadUnit(" + this.f22235b + ") {iskeyword: " + m25717z() + "}";
    }
}
