package com.facebook.search.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.ui.typeahead.TypeaheadRequest;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.RegularImmutableBiMap;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: extra_wait_for_mutation_finish */
public class GraphSearchQuery extends TypeaheadRequest implements Parcelable {
    public static final Creator<GraphSearchQuery> CREATOR = new C10971();
    public static final GraphSearchQuery f15461e = new GraphSearchQuery("", "", null, null, null, false, RegularImmutableBiMap.a);
    @Nullable
    public final String f15462f;
    @Nullable
    public final String f15463g;
    @Nullable
    public final ScopedEntityType f15464h;
    @Nullable
    public final ScopedSearchStyle f15465i;
    public final boolean f15466j;
    public ImmutableMap<String, Parcelable> f15467k;
    public boolean f15468l;
    public boolean f15469m;

    /* compiled from: extra_wait_for_mutation_finish */
    final class C10971 implements Creator<GraphSearchQuery> {
        C10971() {
        }

        public final Object createFromParcel(Parcel parcel) {
            ScopedEntityType scopedEntityType;
            ScopedSearchStyle scopedSearchStyle = null;
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            boolean booleanValue = ((Boolean) parcel.readValue(null)).booleanValue();
            if (Strings.isNullOrEmpty(readString3)) {
                scopedEntityType = null;
            } else {
                scopedEntityType = ScopedEntityType.valueOf(readString3);
            }
            if (!Strings.isNullOrEmpty(readString5)) {
                scopedSearchStyle = ScopedSearchStyle.valueOf(readString5);
            }
            GraphSearchQuery graphSearchQuery = new GraphSearchQuery(readString, readString2, scopedEntityType, readString4, scopedSearchStyle, booleanValue, RegularImmutableBiMap.a);
            Map hashMap = new HashMap();
            parcel.readMap(hashMap, GraphSearchQuery.class.getClassLoader());
            graphSearchQuery.f15467k = ImmutableMap.copyOf(hashMap);
            graphSearchQuery.f15468l = ((Boolean) parcel.readValue(Boolean.TYPE.getClassLoader())).booleanValue();
            graphSearchQuery.f15469m = ((Boolean) parcel.readValue(Boolean.TYPE.getClassLoader())).booleanValue();
            return graphSearchQuery;
        }

        public final Object[] newArray(int i) {
            return new GraphSearchQuery[i];
        }
    }

    /* compiled from: extra_wait_for_mutation_finish */
    public class Builder extends com.facebook.ui.typeahead.TypeaheadRequest.Builder {
        final /* synthetic */ GraphSearchQuery f15450e;
        @Nullable
        public String f15451f;
        @Nullable
        public String f15452g;
        @Nullable
        public ScopedEntityType f15453h;
        @Nullable
        public ScopedSearchStyle f15454i;
        public boolean f15455j;
        public ImmutableMap<String, Parcelable> f15456k;

        public final /* synthetic */ TypeaheadRequest mo1223a() {
            return m23084b();
        }

        public Builder(GraphSearchQuery graphSearchQuery, GraphSearchQuery graphSearchQuery2) {
            this.f15450e = graphSearchQuery;
            super(graphSearchQuery, graphSearchQuery2);
            this.f15451f = graphSearchQuery2.f15462f;
            this.f15452g = graphSearchQuery2.f15463g;
            this.f15453h = graphSearchQuery2.f15464h;
            this.f15454i = graphSearchQuery2.f15465i;
            this.f15455j = graphSearchQuery2.f15466j;
            this.f15456k = graphSearchQuery2.f15467k;
        }

        public final GraphSearchQuery m23084b() {
            return new GraphSearchQuery(this);
        }
    }

    /* compiled from: extra_wait_for_mutation_finish */
    public enum ModifierKeys {
        GROUP_COMMERCE,
        SCOPED_TAB,
        PLACE,
        AWARENESS,
        MARKETPLACE
    }

    /* compiled from: extra_wait_for_mutation_finish */
    public enum ScopedSearchStyle {
        SINGLE_STATE,
        TAB
    }

    public final /* synthetic */ com.facebook.ui.typeahead.TypeaheadRequest.Builder mo1226c() {
        return m23104l();
    }

    public GraphSearchQuery(Builder builder) {
        super((com.facebook.ui.typeahead.TypeaheadRequest.Builder) builder);
        this.f15468l = false;
        this.f15469m = false;
        this.f15462f = builder.f15451f;
        this.f15464h = builder.f15453h;
        this.f15463g = builder.f15452g;
        this.f15465i = builder.f15454i;
        this.f15466j = builder.f15455j;
        this.f15467k = builder.f15456k;
        m23093o();
    }

    private GraphSearchQuery(String str, String str2, ScopedEntityType scopedEntityType, String str3, @Nullable ScopedSearchStyle scopedSearchStyle, boolean z, ImmutableMap<String, Parcelable> immutableMap) {
        String str4;
        if (!z || scopedSearchStyle == null) {
            str4 = str2;
        } else {
            str4 = str2 + scopedSearchStyle.toString();
        }
        super(str, str4, RegularImmutableBiMap.a);
        this.f15468l = false;
        this.f15469m = false;
        this.f15462f = str2;
        this.f15464h = scopedEntityType;
        this.f15463g = str3;
        this.f15465i = scopedSearchStyle;
        this.f15466j = z;
        this.f15467k = immutableMap;
        m23093o();
    }

    public final boolean mo1224a() {
        return m23103j();
    }

    public final boolean mo1225b() {
        return !m23103j();
    }

    public final String m23099e() {
        return this.f15458b;
    }

    @Nullable
    public final String m23100f() {
        return this.f15462f;
    }

    @Nullable
    public final String m23101g() {
        return this.f15463g;
    }

    public final ScopedEntityType m23102h() {
        return this.f15464h;
    }

    public final boolean m23103j() {
        if (this.f15464h == ScopedEntityType.URL) {
            if (Strings.isNullOrEmpty(this.f15463g)) {
                return false;
            }
            return true;
        } else if (Strings.isNullOrEmpty(this.f15462f) || Strings.isNullOrEmpty(this.f15463g) || this.f15464h == null) {
            return false;
        } else {
            return true;
        }
    }

    public final Parcelable m23094a(ModifierKeys modifierKeys) {
        if (this.f15467k.containsKey(modifierKeys.name())) {
            return (Parcelable) this.f15467k.get(modifierKeys.name());
        }
        return null;
    }

    public final void m23095a(ModifierKeys modifierKeys, Parcelable parcelable) {
        this.f15467k = ImmutableMap.builder().b(modifierKeys.name(), parcelable).b();
    }

    private void m23093o() {
        boolean z = this.f15464h == ScopedEntityType.USER || this.f15464h == ScopedEntityType.PAGE;
        this.f15469m = z;
    }

    public static GraphSearchQuery m23091a(String str) {
        return new GraphSearchQuery(str, "", null, null, null, false, RegularImmutableBiMap.a);
    }

    public static GraphSearchQuery m23090a(GraphSearchQuery graphSearchQuery, String str) {
        if (graphSearchQuery == null) {
            graphSearchQuery = f15461e;
        }
        GraphSearchQuery graphSearchQuery2 = new GraphSearchQuery(str, graphSearchQuery.f15462f, graphSearchQuery.f15464h, graphSearchQuery.f15463g, graphSearchQuery.f15465i, graphSearchQuery.f15466j, graphSearchQuery.f15467k);
        graphSearchQuery2.f15468l = graphSearchQuery.f15468l;
        graphSearchQuery2.f15469m = graphSearchQuery.f15469m;
        return graphSearchQuery2;
    }

    public static GraphSearchQuery m23089a(GraphSearchQuery graphSearchQuery) {
        if (graphSearchQuery.f15464h == ScopedEntityType.VIDEO || graphSearchQuery.f15464h == ScopedEntityType.GROUP || graphSearchQuery.f15464h == ScopedEntityType.MARKETPLACE) {
            return new GraphSearchQuery(graphSearchQuery.f15458b, "", null, null, graphSearchQuery.f15465i, false, RegularImmutableBiMap.a);
        }
        ScopedSearchStyle scopedSearchStyle;
        String str = graphSearchQuery.f15458b;
        String str2 = graphSearchQuery.f15462f;
        ScopedEntityType scopedEntityType = graphSearchQuery.f15464h;
        String str3 = graphSearchQuery.f15463g;
        if (graphSearchQuery.f15462f == null) {
            scopedSearchStyle = null;
        } else {
            scopedSearchStyle = ScopedSearchStyle.SINGLE_STATE;
        }
        return new GraphSearchQuery(str, str2, scopedEntityType, str3, scopedSearchStyle, graphSearchQuery.f15466j, graphSearchQuery.f15467k);
    }

    public static GraphSearchQuery m23088a(ScopedEntityType scopedEntityType, String str, String str2, ScopedSearchStyle scopedSearchStyle, boolean z) {
        return m23092a("", scopedEntityType, str, str2, scopedSearchStyle, z);
    }

    public static GraphSearchQuery m23092a(String str, ScopedEntityType scopedEntityType, String str2, String str3, ScopedSearchStyle scopedSearchStyle, boolean z) {
        return new GraphSearchQuery(str, str2, scopedEntityType, str3, scopedSearchStyle, z, RegularImmutableBiMap.a);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        String str = null;
        parcel.writeString(this.f15458b);
        parcel.writeString(this.f15462f);
        parcel.writeString(this.f15464h != null ? this.f15464h.name() : null);
        parcel.writeString(this.f15463g);
        if (this.f15465i != null) {
            str = this.f15465i.name();
        }
        parcel.writeString(str);
        parcel.writeValue(Boolean.valueOf(this.f15466j));
        parcel.writeMap(this.f15467k);
        parcel.writeValue(Boolean.valueOf(this.f15468l));
        parcel.writeValue(Boolean.valueOf(this.f15469m));
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GraphSearchQuery graphSearchQuery = (GraphSearchQuery) obj;
        if (Objects.equal(this.f15458b, graphSearchQuery.f15458b) && Objects.equal(this.f15459c, graphSearchQuery.f15459c) && Objects.equal(this.f15462f, graphSearchQuery.f15462f) && Objects.equal(this.f15464h, graphSearchQuery.f15464h) && Objects.equal(this.f15463g, graphSearchQuery.f15463g) && Objects.equal(this.f15467k, graphSearchQuery.f15467k) && Objects.equal(Boolean.valueOf(this.f15466j), Boolean.valueOf(graphSearchQuery.f15466j)) && this.f15468l == graphSearchQuery.f15468l && this.f15469m == graphSearchQuery.f15469m) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f15458b, this.f15459c, this.f15462f, this.f15464h, this.f15463g, this.f15467k, Boolean.valueOf(this.f15468l), Boolean.valueOf(this.f15469m), Boolean.valueOf(this.f15466j)});
    }

    public final Builder m23104l() {
        return new Builder(this, this);
    }
}
