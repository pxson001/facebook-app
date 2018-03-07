package com.facebook.search.results.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.graphql.calls.ExactMatchInputExactMatch;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.search.api.GraphSearchQuery.ScopedEntityType;
import com.facebook.search.api.SearchQueryFunctions;
import com.facebook.search.api.SearchTheme;
import com.facebook.search.logging.api.SearchResultsAnalytics;
import com.facebook.search.logging.api.SearchResultsSource;
import com.facebook.search.logging.api.SearchTypeaheadSession;
import com.facebook.search.model.GraphSearchQuerySpec;
import com.facebook.search.model.ReactionSearchData;
import com.facebook.search.results.protocol.SearchResultsMetaDataInterfaces.SearchResultsMetaData;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.collect.RegularImmutableList;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: RichMediaDocumentQuery */
public class SearchResultsMutableContext implements Parcelable, GraphSearchQuerySpec {
    public static final Creator<SearchResultsMutableContext> CREATOR = new C25141();
    public SearchTheme f23366a = SearchTheme.LIGHT;
    public SearchResultsSource f23367b = SearchResultsSource.H;
    public GraphQLGraphSearchResultRole f23368c;
    public SearchTypeaheadSession f23369d = SearchTypeaheadSession.a;
    public String f23370e = SearchResultsAnalytics.a();
    private String f23371f;
    private String f23372g;
    private String f23373h;
    private String f23374i;
    private ExactMatchInputExactMatch f23375j = ExactMatchInputExactMatch.FALSE;
    private ImmutableList<GraphQLGraphSearchResultsDisplayStyle> f23376k = RegularImmutableList.a;
    private ImmutableMap<String, Parcelable> f23377l = RegularImmutableBiMap.a;
    private ReactionSearchData f23378m;
    private String f23379n;
    private String f23380o;
    private ScopedEntityType f23381p;
    public String f23382q;
    public String f23383r;
    public String f23384s;
    public SearchResultsMetaData f23385t;

    /* compiled from: RichMediaDocumentQuery */
    final class C25141 implements Creator<SearchResultsMutableContext> {
        C25141() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SearchResultsMutableContext(parcel);
        }

        public final Object[] newArray(int i) {
            return new SearchResultsMutableContext[i];
        }
    }

    /* compiled from: RichMediaDocumentQuery */
    class C25163 implements SearchResultsMetaData {
        final /* synthetic */ SearchResultsMutableContext f23365a;

        C25163(SearchResultsMutableContext searchResultsMutableContext) {
            this.f23365a = searchResultsMutableContext;
        }

        @Nullable
        public final String mo595k() {
            return this.f23365a.f23383r;
        }

        @Nullable
        public final String mo596l() {
            return this.f23365a.f23382q;
        }

        @Nullable
        public final String mo594j() {
            return this.f23365a.f23384s;
        }
    }

    public SearchResultsMutableContext(Parcel parcel) {
        this.f23366a = (SearchTheme) parcel.readSerializable();
        this.f23367b = SearchResultsSource.a(parcel.readString());
        this.f23368c = (GraphQLGraphSearchResultRole) parcel.readSerializable();
        this.f23369d = (SearchTypeaheadSession) parcel.readParcelable(SearchTypeaheadSession.class.getClassLoader());
        this.f23370e = parcel.readString();
        this.f23371f = parcel.readString();
        this.f23372g = parcel.readString();
        this.f23373h = parcel.readString();
        this.f23374i = parcel.readString();
        this.f23375j = (ExactMatchInputExactMatch) parcel.readSerializable();
        List<String> arrayList = new ArrayList();
        parcel.readList(arrayList, String.class.getClassLoader());
        Builder builder = new Builder();
        for (String valueOf : arrayList) {
            builder.c(GraphQLGraphSearchResultsDisplayStyle.valueOf(valueOf));
        }
        this.f23376k = builder.b();
        Map hashMap = new HashMap();
        parcel.readMap(hashMap, Parcelable.class.getClassLoader());
        this.f23377l = ImmutableMap.copyOf(hashMap);
        this.f23378m = (ReactionSearchData) parcel.readParcelable(ReactionSearchData.class.getClassLoader());
        this.f23379n = parcel.readString();
        this.f23380o = parcel.readString();
        String valueOf2 = parcel.readString();
        this.f23381p = valueOf2 != null ? ScopedEntityType.valueOf(valueOf2) : null;
        this.f23382q = parcel.readString();
        this.f23383r = parcel.readString();
        this.f23384s = parcel.readString();
        valueOf2 = parcel.readString();
        final String readString = parcel.readString();
        final String readString2 = parcel.readString();
        if (valueOf2 != null || readString != null || readString2 != null) {
            this.f23385t = new SearchResultsMetaData(this) {
                final /* synthetic */ SearchResultsMutableContext f23364d;

                @Nullable
                public final String mo594j() {
                    return valueOf2;
                }

                @Nullable
                public final String mo595k() {
                    return readString;
                }

                @Nullable
                public final String mo596l() {
                    return readString2;
                }
            };
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Serializable name;
        String j;
        String str = null;
        parcel.writeSerializable(this.f23366a);
        parcel.writeString(this.f23367b != null ? this.f23367b.toString() : null);
        if (this.f23368c != null) {
            name = this.f23368c.name();
        } else {
            name = null;
        }
        parcel.writeSerializable(name);
        parcel.writeParcelable(this.f23369d, i);
        parcel.writeString(this.f23370e);
        parcel.writeString(this.f23371f);
        parcel.writeString(this.f23372g);
        parcel.writeString(this.f23373h);
        parcel.writeString(this.f23374i);
        parcel.writeSerializable(this.f23375j);
        List arrayList = new ArrayList();
        int size = this.f23376k.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(((GraphQLGraphSearchResultsDisplayStyle) this.f23376k.get(i2)).name());
        }
        parcel.writeList(arrayList);
        parcel.writeMap(this.f23377l);
        parcel.writeParcelable(this.f23378m, i);
        parcel.writeString(this.f23379n);
        parcel.writeString(this.f23380o);
        parcel.writeString(this.f23381p != null ? this.f23381p.name() : null);
        parcel.writeString(this.f23382q);
        parcel.writeString(this.f23383r);
        parcel.writeString(this.f23384s);
        if (this.f23385t != null) {
            j = this.f23385t.mo594j();
        } else {
            j = null;
        }
        parcel.writeString(j);
        if (this.f23385t != null) {
            j = this.f23385t.mo595k();
        } else {
            j = null;
        }
        parcel.writeString(j);
        if (this.f23385t != null) {
            str = this.f23385t.mo596l();
        }
        parcel.writeString(str);
    }

    public String toString() {
        return StringFormatUtil.a("%s: \nSource: %s\nFilter Type: %s\nQuery Title: %s\n Query Function: %s\n", new Object[]{super.toString(), this.f23367b, m27098l(), this.f23371f, this.f23372g});
    }

    public final void m27087a(GraphSearchQuerySpec graphSearchQuerySpec, SearchTypeaheadSession searchTypeaheadSession, SearchResultsSource searchResultsSource) {
        this.f23371f = graphSearchQuerySpec.mo1211a();
        this.f23374i = graphSearchQuerySpec.mo1213c();
        m27088a(graphSearchQuerySpec.mo1212b());
        this.f23373h = graphSearchQuerySpec.jH_();
        this.f23375j = graphSearchQuerySpec.mo1214e();
        this.f23376k = graphSearchQuerySpec.mo1215f();
        this.f23369d = searchTypeaheadSession;
        this.f23367b = searchResultsSource;
        this.f23377l = graphSearchQuerySpec.jJ_();
        this.f23378m = graphSearchQuerySpec.mo1221m();
        this.f23379n = graphSearchQuerySpec.mo1216h();
        this.f23380o = graphSearchQuerySpec.mo1217i();
        this.f23381p = graphSearchQuerySpec.jI_();
    }

    public final GraphQLGraphSearchResultsDisplayStyle m27098l() {
        return !this.f23376k.isEmpty() ? (GraphQLGraphSearchResultsDisplayStyle) this.f23376k.get(0) : null;
    }

    public final String mo1213c() {
        return this.f23374i;
    }

    public final String jH_() {
        return this.f23373h;
    }

    public final ExactMatchInputExactMatch mo1214e() {
        return this.f23375j;
    }

    public final ImmutableList<GraphQLGraphSearchResultsDisplayStyle> mo1215f() {
        return this.f23376k;
    }

    public final ImmutableMap<String, Parcelable> jJ_() {
        return this.f23377l;
    }

    public final SearchTypeaheadSession m27100o() {
        return this.f23369d;
    }

    @Nullable
    public final String mo1211a() {
        return this.f23371f;
    }

    @Nullable
    public final String mo1212b() {
        if (this.f23379n == null || this.f23381p == null || Strings.isNullOrEmpty(this.f23374i)) {
            return this.f23372g;
        }
        return SearchQueryFunctions.a(this.f23381p, this.f23374i, this.f23379n, this.f23377l);
    }

    @Nullable
    public final ReactionSearchData mo1221m() {
        return this.f23378m;
    }

    public final void m27088a(String str) {
        if (!(this.f23372g == null || this.f23372g.equals(str))) {
            this.f23370e = SearchResultsAnalytics.a();
        }
        this.f23372g = str;
    }

    @Nullable
    public final GraphQLGraphSearchResultsDisplayStyle m27101u() {
        return (this.f23376k == null || this.f23376k.isEmpty()) ? null : (GraphQLGraphSearchResultsDisplayStyle) this.f23376k.get(0);
    }

    @Deprecated
    public final void m27090b(String str) {
        Preconditions.checkState(this.f23385t == null, "You already set the metadata. Can't use deprecated API in combination with new one.");
        this.f23382q = str;
    }

    @Deprecated
    public final void m27092c(String str) {
        Preconditions.checkState(this.f23385t == null, "You already set the metadata. Can't use deprecated API in combination with new one.");
        this.f23383r = str;
    }

    @Deprecated
    public final void m27093d(String str) {
        Preconditions.checkState(this.f23385t == null, "You already set the metadata. Can't use deprecated API in combination with new one.");
        this.f23384s = str;
    }

    public final SearchResultsMetaData m27102v() {
        if (this.f23385t != null) {
            return this.f23385t;
        }
        return new C25163(this);
    }

    public final String mo1216h() {
        return this.f23379n;
    }

    public final ScopedEntityType jI_() {
        return this.f23381p;
    }

    public final String mo1217i() {
        return this.f23380o;
    }
}
