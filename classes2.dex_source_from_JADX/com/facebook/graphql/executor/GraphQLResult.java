package com.facebook.graphql.executor;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.fbservice.results.BaseResult;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.executor.GraphQLQueryScheduler.GraphQLRequestLock;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.collect.RegularImmutableSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: saved_caret_nux_clicked */
public class GraphQLResult<T> extends BaseResult implements Parcelable {
    public static final Creator<GraphQLResult> CREATOR = new C02721();
    public final GraphQLRequestLock f6199a;
    final boolean f6200b;
    protected final transient long f6201c;
    protected final transient long f6202d;
    public final T f6203e;
    public final Class<T> f6204f;
    public final ImmutableSet<String> f6205g;
    @Nullable
    public ImmutableSet<String> f6206h;
    @Nullable
    public final String f6207i;
    @Nullable
    public final Map<String, Object> f6208j;
    @Nullable
    public final Map<String, List<String>> f6209k;

    /* compiled from: saved_caret_nux_clicked */
    final class C02721 implements Creator<GraphQLResult> {
        C02721() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLResult[i];
        }
    }

    /* compiled from: saved_caret_nux_clicked */
    public class Builder<T> {
        public Class<T> f15059a;
        public DataFreshnessResult f15060b;
        public long f15061c;
        public GraphQLRequestLock f15062d;
        public Map<String, Object> f15063e;
        public Map<String, List<String>> f15064f;
        public long f15065g = -1;
        public long f15066h = -1;
        public boolean f15067i = true;
        public String f15068j = null;
        public Object f15069k;
        private Set<String> f15070l;
        private Set<String> f15071m;

        public static <V> Builder<V> m21595a(GraphQLResult<V> graphQLResult) {
            Builder<V> builder = new Builder();
            builder.f15069k = graphQLResult.f6203e;
            builder.f15059a = graphQLResult.f6204f;
            builder.f15060b = graphQLResult.freshness;
            builder.f15061c = graphQLResult.clientTimeMs;
            builder.f15070l = graphQLResult.f6205g;
            builder.f15071m = graphQLResult.f6206h;
            builder.f15062d = graphQLResult.f6199a;
            builder.f15063e = graphQLResult.f6208j;
            builder.f15064f = graphQLResult.f6209k;
            builder.f15065g = graphQLResult.f6201c;
            builder.f15066h = graphQLResult.f6202d;
            builder.f15067i = graphQLResult.f6200b;
            builder.f15068j = graphQLResult.f6207i;
            return builder;
        }

        public final Builder<T> m21598a(T t) {
            this.f15069k = t;
            return this;
        }

        public final Builder<T> m21599a(Collection<String> collection) {
            if (!(collection == null || collection.isEmpty())) {
                if (!(this.f15070l instanceof HashSet)) {
                    if (this.f15070l == null) {
                        this.f15070l = new HashSet(collection.size());
                    } else {
                        Set hashSet = new HashSet(this.f15070l.size() + collection.size());
                        hashSet.addAll(this.f15070l);
                        this.f15070l = hashSet;
                    }
                }
                this.f15070l.addAll(collection);
            }
            return this;
        }

        public final Builder<T> m21597a(GraphQLRequestLock graphQLRequestLock) {
            this.f15062d = graphQLRequestLock;
            return this;
        }

        public final Builder<T> m21601b(long j) {
            this.f15065g = j;
            return this;
        }

        public final Builder<T> m21596a(DataFreshnessResult dataFreshnessResult) {
            this.f15060b = dataFreshnessResult;
            return this;
        }

        public final Builder m21602b(Collection<String> collection) {
            this.f15071m = ImmutableSet.copyOf((Collection) collection);
            return this;
        }

        public final GraphQLResult<T> m21600a() {
            ImmutableSet of;
            Object obj = this.f15069k;
            DataFreshnessResult dataFreshnessResult = this.f15060b;
            long j = this.f15061c;
            if (this.f15070l == null) {
                of = ImmutableSet.of();
            } else {
                of = ImmutableSet.copyOf(this.f15070l);
            }
            return new GraphQLResult(obj, dataFreshnessResult, j, of, this.f15071m, this.f15062d, this.f15063e, this.f15064f, this.f15066h, this.f15065g, this.f15067i, this.f15068j);
        }
    }

    public GraphQLResult(Object obj, DataFreshnessResult dataFreshnessResult, long j) {
        this(obj, dataFreshnessResult, j, null, null, null);
    }

    public GraphQLResult(Object obj, DataFreshnessResult dataFreshnessResult, long j, @Nullable Set<String> set) {
        this(obj, dataFreshnessResult, j, set, null, null);
    }

    public GraphQLResult(Object obj, DataFreshnessResult dataFreshnessResult, long j, @Nullable Set<String> set, @Nullable GraphQLRequestLock graphQLRequestLock, @Nullable Map<String, Object> map) {
        this(obj, dataFreshnessResult, j, ImmutableSet.of(), set, graphQLRequestLock, map, null, -1, -1, true, null);
    }

    public GraphQLResult(Object obj, DataFreshnessResult dataFreshnessResult, long j, @Nullable Set<String> set, @Nullable GraphQLRequestLock graphQLRequestLock, @Nullable Map<String, Object> map, @Nullable Map<String, List<String>> map2) {
        this(obj, dataFreshnessResult, j, ImmutableSet.of(), set, graphQLRequestLock, map, map2, -1, -1, true, null);
    }

    private GraphQLResult(Object obj, DataFreshnessResult dataFreshnessResult, long j, @Nullable ImmutableSet<String> immutableSet, @Nullable Set<String> set, @Nullable GraphQLRequestLock graphQLRequestLock, @Nullable Map<String, Object> map, @Nullable Map<String, List<String>> map2, long j2, long j3, boolean z, @Nullable String str) {
        super(dataFreshnessResult, j);
        this.f6203e = obj;
        this.f6204f = obj == null ? null : obj.getClass();
        if (immutableSet == null) {
            immutableSet = ImmutableSet.of();
        }
        this.f6205g = immutableSet;
        this.f6206h = set == null ? null : ImmutableSet.copyOf((Collection) set);
        this.f6199a = graphQLRequestLock;
        this.f6208j = map;
        this.f6209k = map2;
        this.f6202d = j2;
        this.f6201c = j3;
        this.f6200b = z;
        this.f6207i = str;
    }

    @Nonnull
    public final Map<String, List<String>> m10399c() {
        if (this.f6209k == null) {
            return RegularImmutableBiMap.f695a;
        }
        return this.f6209k;
    }

    public final T m10400d() {
        return this.f6203e;
    }

    public final Collection m10401e() {
        return m10397a(this.f6203e);
    }

    private static Collection m10397a(Object obj) {
        if (obj == null) {
            return RegularImmutableSet.f688a;
        }
        if (obj instanceof Map) {
            return ((Map) obj).values();
        }
        if (obj instanceof Collection) {
            return (Collection) obj;
        }
        return ImmutableSet.of(obj);
    }

    @Nonnull
    public final synchronized Set<String> m10402f() {
        Set<String> set;
        if (this.f6206h == null) {
            this.f6206h = m10398b(this.f6203e);
        }
        if (this.f6205g == null || this.f6205g.isEmpty()) {
            set = this.f6206h;
        } else if (this.f6206h.isEmpty()) {
            set = this.f6205g;
        } else {
            set = new com.google.common.collect.ImmutableSet.Builder().m4809b(this.f6206h).m4809b(this.f6205g).m4812b();
        }
        return set;
    }

    private static ImmutableSet<String> m10398b(Object obj) {
        if (obj == null) {
            return RegularImmutableSet.f688a;
        }
        if (!(obj instanceof Map) && !(obj instanceof Collection)) {
            return ImmutableSet.copyOf(GraphQLResponseParser.m11708a(obj));
        }
        com.google.common.collect.ImmutableSet.Builder builder = new com.google.common.collect.ImmutableSet.Builder();
        for (Object a : m10397a(obj)) {
            builder.m4809b(GraphQLResponseParser.m11708a(a));
        }
        return builder.m4812b();
    }

    public GraphQLResult(Parcel parcel) {
        ImmutableSet immutableSet;
        super(parcel);
        this.f6204f = (Class) parcel.readSerializable();
        ClassLoader classLoader = this.f6204f == null ? null : this.f6204f.getClassLoader();
        int readInt = parcel.readInt();
        if (readInt == 2) {
            this.f6203e = FlatBufferModelHelper.c(parcel);
        } else if (readInt == 1) {
            this.f6203e = FlatBufferModelHelper.b(parcel);
        } else if (readInt == 0) {
            this.f6203e = FlatBufferModelHelper.a(parcel);
        } else {
            throw new RuntimeException("Unknown value " + readInt);
        }
        Collection readArrayList = parcel.readArrayList(String.class.getClassLoader());
        if (readArrayList == null) {
            immutableSet = RegularImmutableSet.f688a;
        } else {
            immutableSet = ImmutableSet.copyOf(readArrayList);
        }
        this.f6205g = immutableSet;
        readArrayList = parcel.readArrayList(String.class.getClassLoader());
        this.f6206h = readArrayList == null ? null : ImmutableSet.copyOf(readArrayList);
        this.f6199a = null;
        this.f6208j = parcel.readHashMap(classLoader);
        this.f6209k = parcel.readHashMap(classLoader);
        this.f6201c = -1;
        this.f6202d = -1;
        this.f6200b = ParcelUtil.a(parcel);
        this.f6207i = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        List list = null;
        boolean z = true;
        super.writeToParcel(parcel, i);
        parcel.writeSerializable(this.f6204f);
        if (this.f6203e instanceof Map) {
            parcel.writeInt(2);
            FlatBufferModelHelper.a(parcel, (Map) this.f6203e);
        } else if (this.f6203e instanceof List) {
            parcel.writeInt(1);
            FlatBufferModelHelper.a(parcel, (List) this.f6203e);
        } else {
            if (!(this.f6203e == null || (this.f6203e instanceof Flattenable))) {
                z = false;
            }
            Preconditions.checkState(z);
            parcel.writeInt(0);
            FlatBufferModelHelper.a(parcel, (Flattenable) this.f6203e);
        }
        parcel.writeList(this.f6205g == null ? null : Lists.m1298a(this.f6205g));
        if (this.f6206h != null) {
            list = Lists.m1298a(this.f6206h);
        }
        parcel.writeList(list);
        parcel.writeMap(this.f6208j);
        parcel.writeMap(this.f6209k);
        ParcelUtil.a(parcel, this.f6200b);
        parcel.writeString(this.f6207i);
    }

    public int describeContents() {
        return 0;
    }

    public final GraphQLResult<T> m10403i() {
        return this.f6199a == null ? this : this.f6199a.m20455c(this);
    }
}
