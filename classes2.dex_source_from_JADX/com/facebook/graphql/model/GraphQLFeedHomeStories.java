package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: mAdded= */
public final class GraphQLFeedHomeStories extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLFeedHomeStories> CREATOR = new C06751();
    public int f15747d;
    @Nullable
    public String f15748e;
    public List<GraphQLFeedUnitEdge> f15749f;
    public List<String> f15750g;
    public boolean f15751h;
    @Nullable
    public GraphQLPageInfo f15752i;
    @Nullable
    public String f15753j;
    @Nullable
    public String f15754k;

    /* compiled from: mAdded= */
    public class Builder extends com.facebook.graphql.modelutil.BaseModel.Builder {
        public int f15739d;
        @Nullable
        public String f15740e;
        public ImmutableList<GraphQLFeedUnitEdge> f15741f;
        public ImmutableList<String> f15742g;
        public boolean f15743h;
        @Nullable
        public GraphQLPageInfo f15744i;
        @Nullable
        public String f15745j;
        @Nullable
        public String f15746k;

        public Builder() {
            Preconditions.checkState(this instanceof Builder);
        }

        public final Builder m22422a(@Nullable String str) {
            this.f15740e = str;
            return this;
        }

        public final Builder m22421a(ImmutableList<GraphQLFeedUnitEdge> immutableList) {
            this.f15741f = immutableList;
            return this;
        }

        public final Builder m22423a(boolean z) {
            this.f15743h = z;
            return this;
        }

        public final Builder m22420a(@Nullable GraphQLPageInfo graphQLPageInfo) {
            this.f15744i = graphQLPageInfo;
            return this;
        }

        public final GraphQLFeedHomeStories m22424a() {
            return new GraphQLFeedHomeStories(this);
        }
    }

    /* compiled from: mAdded= */
    final class C06751 implements Creator<GraphQLFeedHomeStories> {
        C06751() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLFeedHomeStories(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLFeedHomeStories[i];
        }
    }

    public final String toString() {
        return Objects.toStringHelper(GraphQLFeedHomeStories.class).add("size", m22430k().size()).add("pi", GraphQLHelper.m22474a(m22433n())).add("di", m22429j()).add("ledk", m22431l().size()).toString();
    }

    @FieldOffset
    public final int m22425a() {
        m9949a(0, 0);
        return this.f15747d;
    }

    @FieldOffset
    @Nullable
    public final String m22429j() {
        this.f15748e = super.m9948a(this.f15748e, 1);
        return this.f15748e;
    }

    @FieldOffset
    public final ImmutableList<GraphQLFeedUnitEdge> m22430k() {
        this.f15749f = super.m9944a(this.f15749f, 2, GraphQLFeedUnitEdge.class);
        return (ImmutableList) this.f15749f;
    }

    @FieldOffset
    public final ImmutableList<String> m22431l() {
        this.f15750g = super.m9943a(this.f15750g, 3);
        return (ImmutableList) this.f15750g;
    }

    @FieldOffset
    public final boolean m22432m() {
        m9949a(0, 4);
        return this.f15751h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m22433n() {
        this.f15752i = (GraphQLPageInfo) super.m9947a(this.f15752i, 5, GraphQLPageInfo.class);
        return this.f15752i;
    }

    @FieldOffset
    @Nullable
    public final String m22434o() {
        this.f15753j = super.m9948a(this.f15753j, 6);
        return this.f15753j;
    }

    @FieldOffset
    @Nullable
    public final String m22435p() {
        this.f15754k = super.m9948a(this.f15754k, 7);
        return this.f15754k;
    }

    public final int jK_() {
        return -1516042794;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLPageInfo graphQLPageInfo;
        m9958h();
        if (m22430k() != null) {
            com.google.common.collect.ImmutableList.Builder a = ModelHelper.m23097a(m22430k(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLFeedHomeStories graphQLFeedHomeStories = (GraphQLFeedHomeStories) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLFeedHomeStories.f15749f = a.m1068b();
                graphQLVisitableModel = graphQLFeedHomeStories;
                if (m22433n() != null) {
                    graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m22433n());
                    if (m22433n() != graphQLPageInfo) {
                        graphQLVisitableModel = (GraphQLFeedHomeStories) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f15752i = graphQLPageInfo;
                    }
                }
                m9959i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m22433n() != null) {
            graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m22433n());
            if (m22433n() != graphQLPageInfo) {
                graphQLVisitableModel = (GraphQLFeedHomeStories) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15752i = graphQLPageInfo;
            }
        }
        m9959i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLFeedHomeStories() {
        super(9);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f15747d = mutableFlatBuffer.m21524a(i, 0, 0);
        this.f15751h = mutableFlatBuffer.m21540a(i, 4);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m22429j());
        int a = ModelHelper.m23094a(flatBufferBuilder, m22430k());
        int c = flatBufferBuilder.m21509c(m22431l());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m22433n());
        int b2 = flatBufferBuilder.m21502b(m22434o());
        int b3 = flatBufferBuilder.m21502b(m22435p());
        flatBufferBuilder.m21510c(8);
        flatBufferBuilder.m21494a(0, m22425a(), 0);
        flatBufferBuilder.m21507b(1, b);
        flatBufferBuilder.m21507b(2, a);
        flatBufferBuilder.m21507b(3, c);
        flatBufferBuilder.m21498a(4, m22432m());
        flatBufferBuilder.m21507b(5, a2);
        flatBufferBuilder.m21507b(6, b2);
        flatBufferBuilder.m21507b(7, b3);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLFeedHomeStories(Parcel parcel) {
        boolean z = true;
        super(9);
        this.f15747d = parcel.readInt();
        this.f15748e = parcel.readString();
        this.f15749f = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLFeedUnitEdge.class.getClassLoader()));
        this.f15750g = ImmutableListHelper.m21625a(parcel.readArrayList(String.class.getClassLoader()));
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f15751h = z;
        this.f15752i = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
        this.f15753j = parcel.readString();
        this.f15754k = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m22425a());
        parcel.writeString(m22429j());
        parcel.writeList(m22430k());
        parcel.writeList(m22431l());
        parcel.writeByte((byte) (m22432m() ? 1 : 0));
        parcel.writeValue(m22433n());
        parcel.writeString(m22434o());
        parcel.writeString(m22435p());
    }

    public GraphQLFeedHomeStories(Builder builder) {
        super(9);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f15747d = builder.f15739d;
        this.f15748e = builder.f15740e;
        this.f15749f = builder.f15741f;
        this.f15750g = builder.f15742g;
        this.f15751h = builder.f15743h;
        this.f15752i = builder.f15744i;
        this.f15753j = builder.f15745j;
        this.f15754k = builder.f15746k;
    }
}
