package com.facebook.goodwill.feed.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.goodwill.feed.protocol.FetchThrowbackFeedGraphQLModels.ThrowbackSectionFragmentModel;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoFields;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.collect.RegularImmutableList;
import java.util.Collection;
import java.util.HashMap;

/* compiled from: Video Home */
public class ThrowbackFeedStories implements Parcelable {
    public static final Creator<ThrowbackFeedStories> CREATOR = new C30031();
    public final ImmutableList<GraphQLFeedUnitEdge> f21106a;
    public final ImmutableList<String> f21107b;
    public final ImmutableMap<String, ThrowbackSectionFragmentModel> f21108c;
    public final ThrowbackFeedResources f21109d;
    public final DefaultPageInfoFields f21110e;
    public final DataFreshnessResult f21111f;

    /* compiled from: Video Home */
    final class C30031 implements Creator<ThrowbackFeedStories> {
        C30031() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ThrowbackFeedStories(parcel);
        }

        public final Object[] newArray(int i) {
            return new ThrowbackFeedStories[i];
        }
    }

    /* compiled from: Video Home */
    public class Builder {
        public ImmutableList<GraphQLFeedUnitEdge> f21100a;
        public ImmutableList<String> f21101b;
        public ImmutableMap<String, ThrowbackSectionFragmentModel> f21102c;
        public ThrowbackFeedResources f21103d;
        public DefaultPageInfoFields f21104e;
        public DataFreshnessResult f21105f;

        public static Builder m22046a(ThrowbackFeedStories throwbackFeedStories) {
            Builder builder = new Builder();
            builder.f21100a = throwbackFeedStories.f21106a;
            builder = builder;
            builder.f21101b = throwbackFeedStories.f21107b;
            builder = builder;
            builder.f21102c = throwbackFeedStories.f21108c;
            builder = builder;
            builder.f21103d = throwbackFeedStories.f21109d;
            builder = builder;
            builder.f21104e = throwbackFeedStories.f21110e;
            builder = builder;
            builder.f21105f = throwbackFeedStories.f21111f;
            return builder;
        }

        public final ThrowbackFeedStories m22052a() {
            return new ThrowbackFeedStories(this.f21100a, this.f21101b, this.f21102c, this.f21103d, this.f21104e, this.f21105f);
        }

        public final Builder m22050a(ImmutableList<GraphQLFeedUnitEdge> immutableList) {
            this.f21100a = immutableList;
            return this;
        }

        public final Builder m22053b(ImmutableList<String> immutableList) {
            this.f21101b = immutableList;
            return this;
        }

        public final Builder m22051a(ImmutableMap<String, ThrowbackSectionFragmentModel> immutableMap) {
            this.f21102c = immutableMap;
            return this;
        }

        public final Builder m22048a(ThrowbackFeedResources throwbackFeedResources) {
            this.f21103d = throwbackFeedResources;
            return this;
        }

        public final Builder m22049a(DefaultPageInfoFields defaultPageInfoFields) {
            this.f21104e = defaultPageInfoFields;
            return this;
        }

        public final Builder m22047a(DataFreshnessResult dataFreshnessResult) {
            this.f21105f = dataFreshnessResult;
            return this;
        }
    }

    private ThrowbackFeedStories(ImmutableList<GraphQLFeedUnitEdge> immutableList, ImmutableList<String> immutableList2, ImmutableMap<String, ThrowbackSectionFragmentModel> immutableMap, ThrowbackFeedResources throwbackFeedResources, DefaultPageInfoFields defaultPageInfoFields, DataFreshnessResult dataFreshnessResult) {
        this.f21106a = immutableList;
        this.f21107b = immutableList2;
        this.f21108c = immutableMap;
        this.f21109d = throwbackFeedResources;
        this.f21110e = defaultPageInfoFields;
        this.f21111f = dataFreshnessResult;
    }

    public ThrowbackFeedStories(Parcel parcel) {
        ImmutableList immutableList;
        ImmutableMap immutableMap;
        Collection readArrayList = parcel.readArrayList(getClass().getClassLoader());
        if (readArrayList == null) {
            immutableList = RegularImmutableList.a;
        } else {
            immutableList = ImmutableList.copyOf(readArrayList);
        }
        this.f21106a = immutableList;
        readArrayList = parcel.readArrayList(getClass().getClassLoader());
        if (readArrayList == null) {
            immutableList = RegularImmutableList.a;
        } else {
            immutableList = ImmutableList.copyOf(readArrayList);
        }
        this.f21107b = immutableList;
        HashMap hashMap = (HashMap) FlatBufferModelHelper.c(parcel);
        if (hashMap == null) {
            immutableMap = RegularImmutableBiMap.a;
        } else {
            immutableMap = ImmutableMap.copyOf(hashMap);
        }
        this.f21108c = immutableMap;
        this.f21109d = (ThrowbackFeedResources) parcel.readParcelable(ThrowbackFeedResources.class.getClassLoader());
        this.f21110e = (DefaultPageInfoFields) FlatBufferModelHelper.a(parcel);
        this.f21111f = (DataFreshnessResult) parcel.readSerializable();
    }

    public final ImmutableList<GraphQLFeedUnitEdge> m22054a() {
        return this.f21106a;
    }

    public final ImmutableList<String> m22055b() {
        return this.f21107b;
    }

    public final ImmutableMap<String, ThrowbackSectionFragmentModel> m22056c() {
        return this.f21108c;
    }

    public final ThrowbackFeedResources m22057d() {
        return this.f21109d;
    }

    public final DefaultPageInfoFields m22058e() {
        return this.f21110e;
    }

    public final DataFreshnessResult m22059f() {
        return this.f21111f;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f21106a);
        parcel.writeList(this.f21107b);
        FlatBufferModelHelper.a(parcel, this.f21108c);
        parcel.writeParcelable(this.f21109d, i);
        FlatBufferModelHelper.a(parcel, (Flattenable) this.f21110e);
        parcel.writeSerializable(this.f21111f);
    }
}
