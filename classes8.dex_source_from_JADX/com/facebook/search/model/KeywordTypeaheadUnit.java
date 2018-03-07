package com.facebook.search.model;

import android.os.Parcelable;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.graphql.calls.ExactMatchInputExactMatch;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.search.api.GraphSearchQuery.ScopedEntityType;
import com.facebook.search.api.SearchQueryFunctions;
import com.facebook.search.model.SuggestionGroup.Type;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.RegularImmutableBiMap;
import javax.annotation.Nullable;

/* compiled from: TRENDING_ENTITY */
public class KeywordTypeaheadUnit extends TypeaheadUnit implements GraphSearchQuerySpec {
    private final String f22112a;
    private final String f22113b;
    private final ImmutableList<GraphQLGraphSearchResultsDisplayStyle> f22114c;
    private final String f22115d;
    private final String f22116e;
    private final ExactMatchInputExactMatch f22117f;
    public final KeywordType f22118g;
    @Nullable
    public final String f22119h;
    @Nullable
    public final String f22120i;
    private final ReactionSearchData f22121j;
    public final Source f22122k;
    public final String f22123l;
    public final boolean f22124m;
    private final String f22125n;
    private final String f22126o;
    private final ScopedEntityType f22127p;
    public final String f22128q;
    @Nullable
    public final String f22129r;
    @Nullable
    public final String f22130s;
    private final ImmutableMap<String, Parcelable> f22131t;
    public final int f22132u;
    public final int f22133v;
    public final boolean f22134w;
    public final boolean f22135x;
    private final boolean f22136y;
    public final boolean f22137z;

    /* compiled from: TRENDING_ENTITY */
    public class Builder {
        private static final ImmutableList<GraphQLGraphSearchResultsDisplayStyle> f22085a = ImmutableList.of(GraphQLGraphSearchResultsDisplayStyle.BLENDED);
        public boolean f22086A = false;
        public String f22087b = "";
        public String f22088c;
        public String f22089d = "";
        public String f22090e = "";
        public ExactMatchInputExactMatch f22091f = ExactMatchInputExactMatch.FALSE;
        public KeywordType f22092g = KeywordType.keyword;
        public String f22093h = null;
        public String f22094i = null;
        public ReactionSearchData f22095j;
        public Source f22096k = Source.SUGGESTION;
        public String f22097l;
        public boolean f22098m = false;
        public String f22099n = null;
        public boolean f22100o;
        public String f22101p = null;
        public ScopedEntityType f22102q = null;
        public String f22103r = null;
        public String f22104s = null;
        public boolean f22105t = true;
        public boolean f22106u = false;
        public ImmutableList<GraphQLGraphSearchResultsDisplayStyle> f22107v = f22085a;
        public ImmutableMap<String, Parcelable> f22108w = RegularImmutableBiMap.a;
        @Nullable
        public String f22109x;
        public int f22110y = 0;
        public int f22111z = 0;

        public final Builder m25650a(String str, String str2, ScopedEntityType scopedEntityType) {
            this.f22101p = str;
            this.f22099n = str2;
            this.f22102q = scopedEntityType;
            return this;
        }

        public final KeywordTypeaheadUnit m25651b() {
            return new KeywordTypeaheadUnit(this);
        }

        public static Builder m25648a(String str, Source source) {
            String o = SearchQueryFunctions.o(str);
            Builder builder = new Builder();
            builder.f22087b = str;
            builder = builder;
            builder.f22089d = str;
            builder = builder;
            builder.f22088c = o;
            Builder builder2 = builder;
            builder2.f22090e = "content";
            builder2 = builder2;
            builder2.f22091f = ExactMatchInputExactMatch.FALSE;
            builder2 = builder2;
            builder2.f22096k = source;
            return builder2;
        }

        public static KeywordTypeaheadUnit m25649a(String str, String str2, String str3, boolean z, Source source, KeywordType keywordType) {
            String o = SearchQueryFunctions.o(str);
            Builder builder = new Builder();
            builder.f22087b = str;
            builder = builder;
            builder.f22089d = str;
            builder = builder;
            builder.f22104s = str2;
            builder = builder;
            builder.f22103r = str3;
            builder = builder;
            builder.f22105t = z;
            builder = builder;
            builder.f22088c = o;
            Builder builder2 = builder;
            builder2.f22090e = "content";
            builder2 = builder2;
            builder2.f22091f = ExactMatchInputExactMatch.FALSE;
            builder2 = builder2;
            builder2.f22092g = keywordType;
            builder2 = builder2;
            builder2.f22096k = source;
            return builder2.m25651b();
        }

        public static Builder m25647a(KeywordTypeaheadUnit keywordTypeaheadUnit) {
            Builder builder = new Builder();
            builder.f22087b = keywordTypeaheadUnit.mo1211a();
            builder = builder;
            builder.f22088c = keywordTypeaheadUnit.mo1212b();
            builder = builder;
            builder.f22089d = keywordTypeaheadUnit.mo1213c();
            builder = builder;
            builder.f22090e = keywordTypeaheadUnit.jH_();
            builder = builder;
            builder.f22091f = keywordTypeaheadUnit.mo1214e();
            builder = builder;
            builder.f22092g = keywordTypeaheadUnit.f22118g;
            builder = builder;
            builder.f22093h = keywordTypeaheadUnit.f22119h;
            builder = builder;
            builder.f22096k = keywordTypeaheadUnit.f22122k;
            builder = builder;
            builder.f22097l = keywordTypeaheadUnit.f22123l;
            builder = builder.m25650a(keywordTypeaheadUnit.mo1216h(), keywordTypeaheadUnit.mo1217i(), keywordTypeaheadUnit.jI_());
            builder.f22103r = keywordTypeaheadUnit.f22128q;
            builder = builder;
            builder.f22104s = keywordTypeaheadUnit.f22129r;
            builder = builder;
            builder.f22100o = keywordTypeaheadUnit.f22134w;
            builder = builder;
            builder.f22107v = keywordTypeaheadUnit.mo1215f();
            builder = builder;
            builder.f22106u = keywordTypeaheadUnit.x();
            builder = builder;
            builder.f22109x = keywordTypeaheadUnit.f22130s;
            builder = builder;
            builder.f22108w = keywordTypeaheadUnit.jJ_();
            builder = builder;
            builder.f22110y = keywordTypeaheadUnit.f22132u;
            builder = builder;
            builder.f22111z = keywordTypeaheadUnit.f22133v;
            return builder;
        }
    }

    /* compiled from: TRENDING_ENTITY */
    public enum KeywordType {
        keyword,
        trending,
        celebrity,
        escape,
        echo,
        recent,
        am_football,
        photos,
        videos,
        hashtag,
        local,
        company,
        movie,
        happening_now,
        link,
        special_intent_gener,
        local_category,
        escape_pps_style
    }

    /* compiled from: TRENDING_ENTITY */
    public enum Source {
        SUGGESTION,
        BOOTSTRAP,
        SINGLE_STATE,
        RECENT_SEARCHES,
        SEARCH_BUTTON,
        ECHO,
        TRENDING_ENTITY,
        NFL_SPORTS_TEAM,
        SPELL_CORRECTION_ESCAPE,
        ESCAPE,
        NULL_STATE_MODULE,
        INJECTED_SUGGESTION,
        SS_SEE_MORE_LINK,
        SS_SEE_MORE_BUTTON
    }

    public KeywordTypeaheadUnit(Builder builder) {
        this.f22112a = (String) Preconditions.checkNotNull(builder.f22087b);
        this.f22115d = (String) Preconditions.checkNotNull(builder.f22088c);
        this.f22113b = Strings.isNullOrEmpty(builder.f22089d) ? this.f22112a : builder.f22089d;
        this.f22114c = (ImmutableList) Preconditions.checkNotNull(builder.f22107v);
        this.f22116e = (String) Preconditions.checkNotNull(builder.f22090e);
        this.f22117f = (ExactMatchInputExactMatch) Preconditions.checkNotNull(builder.f22091f);
        this.f22118g = builder.f22092g;
        this.f22119h = builder.f22093h;
        this.f22120i = builder.f22094i;
        this.f22121j = builder.f22095j;
        this.f22122k = builder.f22096k;
        this.f22123l = builder.f22097l;
        this.f22124m = builder.f22098m;
        this.f22126o = builder.f22099n;
        this.f22134w = builder.f22100o;
        this.f22125n = builder.f22101p;
        this.f22127p = builder.f22102q;
        this.f22128q = builder.f22103r;
        this.f22129r = builder.f22104s;
        this.f22131t = builder.f22108w;
        this.f22132u = builder.f22110y;
        this.f22133v = builder.f22111z;
        this.f22135x = builder.f22105t;
        this.f22136y = builder.f22106u;
        this.f22130s = builder.f22109x;
        this.f22137z = builder.f22086A;
    }

    public final String mo1211a() {
        return this.f22112a;
    }

    public final String mo1212b() {
        if (!y() || Strings.isNullOrEmpty(this.f22113b)) {
            return this.f22115d;
        }
        return SearchQueryFunctions.a(this.f22127p, this.f22113b, this.f22125n, this.f22131t);
    }

    public final String mo1213c() {
        return this.f22113b;
    }

    public final String jH_() {
        return this.f22116e;
    }

    public final ExactMatchInputExactMatch mo1214e() {
        return this.f22117f;
    }

    public final KeywordType m25666o() {
        return this.f22118g;
    }

    @Nullable
    public final ReactionSearchData mo1221m() {
        return this.f22121j;
    }

    public final String mo1217i() {
        return this.f22126o;
    }

    public final String mo1216h() {
        return this.f22125n;
    }

    public final boolean m25667x() {
        return this.f22136y;
    }

    public final ScopedEntityType jI_() {
        return this.f22127p;
    }

    public final ImmutableList<GraphQLGraphSearchResultsDisplayStyle> mo1215f() {
        return this.f22114c;
    }

    public final ImmutableMap<String, Parcelable> jJ_() {
        return this.f22131t;
    }

    public final void m25656a(TypeaheadSuggestionVisitor typeaheadSuggestionVisitor) {
        typeaheadSuggestionVisitor.m25771a(this);
    }

    public final Type m25663k() {
        return Type.KEYWORD;
    }

    public final void m25655a(HoneyClientEvent honeyClientEvent) {
        if (y()) {
            honeyClientEvent.a("selected_is_scoped_keyword", true);
        }
        honeyClientEvent.b("keyword_source", this.f22119h);
    }

    public final <T> T m25653a(TypeaheadSuggestionVisitorWithReturn<T> typeaheadSuggestionVisitorWithReturn) {
        return typeaheadSuggestionVisitorWithReturn.mo1225a(this);
    }

    public boolean equals(Object obj) {
        if (obj instanceof KeywordTypeaheadUnit) {
            return Objects.equal(this.f22112a, ((KeywordTypeaheadUnit) obj).mo1211a());
        }
        return false;
    }

    public int hashCode() {
        return this.f22112a.hashCode();
    }

    public final boolean m25668y() {
        return (this.f22125n == null || this.f22127p == null || KeywordType.local.equals(this.f22118g) || KeywordType.local_category.equals(this.f22118g)) ? false : true;
    }

    public final int m25652D() {
        if (this.f22118g != null) {
            switch (this.f22118g) {
                case local:
                case local_category:
                    return 3;
                case trending:
                    return 2;
                case keyword:
                    return 1;
            }
        }
        return 0;
    }

    public final boolean m25664l() {
        return true;
    }

    public String toString() {
        return "KeywordTypeaheadUnit(" + mo1211a() + ") {type:" + this.f22118g + ", invalidated:" + x() + "}";
    }
}
