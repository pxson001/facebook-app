package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLBumpReason;
import com.facebook.graphql.model.PropertyBag.HasProperty;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.google.common.base.Preconditions;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: native_post/%s?story_cache_id=%s */
public class GraphQLFeedUnitEdge extends BaseModel implements HasFeedUnit, HasProperty, TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLFeedUnitEdge> CREATOR = new C06361();
    public GraphQLBumpReason f12975d;
    @Nullable
    public String f12976e;
    @Nullable
    public String f12977f;
    public boolean f12978g;
    @Nullable
    public String f12979h;
    @Nullable
    public FeedUnit f12980i;
    public double f12981j;
    @Nullable
    public String f12982k;
    @Nullable
    private PropertyBag f12983l = null;

    /* compiled from: native_post/%s?story_cache_id=%s */
    final class C06361 implements Creator<GraphQLFeedUnitEdge> {
        C06361() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLFeedUnitEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLFeedUnitEdge[i];
        }
    }

    /* compiled from: native_post/%s?story_cache_id=%s */
    public class Builder extends com.facebook.graphql.modelutil.BaseModel.Builder {
        public GraphQLBumpReason f15727d = GraphQLBumpReason.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        @Nullable
        public String f15728e;
        @Nullable
        public String f15729f;
        public boolean f15730g;
        @Nullable
        public String f15731h;
        @Nullable
        public FeedUnit f15732i;
        public double f15733j;
        @Nullable
        public String f15734k;
        @Nullable
        PropertyBag f15735l = null;

        public Builder() {
            Preconditions.checkState(this instanceof Builder);
        }

        public static Builder m22409a(GraphQLFeedUnitEdge graphQLFeedUnitEdge) {
            com.facebook.graphql.modelutil.BaseModel.Builder builder = new Builder();
            graphQLFeedUnitEdge.m9958h();
            builder.f15727d = graphQLFeedUnitEdge.m19090m();
            builder.f15728e = graphQLFeedUnitEdge.m19086g();
            builder.f15729f = graphQLFeedUnitEdge.m19080b();
            builder.f15730g = graphQLFeedUnitEdge.m19089l();
            builder.f15731h = graphQLFeedUnitEdge.m19088k();
            builder.f15732i = graphQLFeedUnitEdge.m19091n();
            builder.f15733j = graphQLFeedUnitEdge.X_();
            builder.f15734k = graphQLFeedUnitEdge.m19084d();
            com.facebook.graphql.modelutil.BaseModel.Builder.m22419a(builder, graphQLFeedUnitEdge);
            builder.f15735l = (PropertyBag) graphQLFeedUnitEdge.U_().clone();
            return builder;
        }

        public final Builder m22411a(GraphQLBumpReason graphQLBumpReason) {
            this.f15727d = graphQLBumpReason;
            return this;
        }

        public final Builder m22413a(@Nullable String str) {
            this.f15728e = str;
            return this;
        }

        public final Builder m22416b(@Nullable String str) {
            this.f15729f = str;
            return this;
        }

        public final Builder m22414a(boolean z) {
            this.f15730g = z;
            return this;
        }

        public final Builder m22417c(@Nullable String str) {
            this.f15731h = str;
            return this;
        }

        public final Builder m22412a(@Nullable FeedUnit feedUnit) {
            this.f15732i = feedUnit;
            return this;
        }

        public final Builder m22410a(double d) {
            this.f15733j = d;
            return this;
        }

        public final Builder m22418d(@Nullable String str) {
            this.f15734k = str;
            return this;
        }

        public final GraphQLFeedUnitEdge m22415a() {
            return new GraphQLFeedUnitEdge(this);
        }
    }

    public int hashCode() {
        String a = DedupableUtil.m23084a(this);
        return a == null ? 0 : a.hashCode();
    }

    public FeedUnit mo2540c() {
        return m19091n();
    }

    public final String V_() {
        String str = PropertyHelper.m21261a((Object) this).f14856e;
        if (str == null) {
            return m19084d();
        }
        return str;
    }

    public final String W_() {
        String str = PropertyHelper.m21261a((Object) this).f14858g;
        if (str == null) {
            return m19086g();
        }
        return str;
    }

    public final String m19087j() {
        String c = PropertyHelper.m21294c(this);
        if (c == null) {
            return "0";
        }
        return c;
    }

    public boolean equals(Object obj) {
        return HashCodeEqualsUtil.a(this, obj);
    }

    @FieldOffset
    public final GraphQLBumpReason m19090m() {
        this.f12975d = (GraphQLBumpReason) super.m9945a(this.f12975d, 0, GraphQLBumpReason.class, GraphQLBumpReason.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f12975d;
    }

    public final void m19076a(GraphQLBumpReason graphQLBumpReason) {
        this.f12975d = graphQLBumpReason;
    }

    @FieldOffset
    @Nullable
    public final String m19086g() {
        this.f12976e = super.m9948a(this.f12976e, 1);
        return this.f12976e;
    }

    public final void m19078a(@Nullable String str) {
        this.f12976e = str;
    }

    @FieldOffset
    @Nullable
    public final String m19080b() {
        this.f12977f = super.m9948a(this.f12977f, 2);
        return this.f12977f;
    }

    public final void m19081b(@Nullable String str) {
        this.f12977f = str;
    }

    @FieldOffset
    public final boolean m19089l() {
        m9949a(0, 3);
        return this.f12978g;
    }

    public final void m19079a(boolean z) {
        this.f12978g = z;
    }

    @FieldOffset
    @Nullable
    public final String m19088k() {
        this.f12979h = super.m9948a(this.f12979h, 4);
        return this.f12979h;
    }

    public final void m19083c(@Nullable String str) {
        this.f12979h = str;
    }

    @FieldOffset
    @Nullable
    public final FeedUnit m19091n() {
        this.f12980i = (FeedUnit) super.m9946a(this.f12980i, 5, VirtualFlattenableResolverImpl.f15617a);
        return this.f12980i;
    }

    public final void m19077a(@Nullable FeedUnit feedUnit) {
        this.f12980i = feedUnit;
    }

    @FieldOffset
    public final double X_() {
        m9949a(0, 6);
        return this.f12981j;
    }

    public final void m19074a(double d) {
        this.f12981j = d;
    }

    @FieldOffset
    @Nullable
    public final String m19084d() {
        this.f12982k = super.m9948a(this.f12982k, 7);
        return this.f12982k;
    }

    public final void m19085d(@Nullable String str) {
        this.f12982k = str;
    }

    public final int jK_() {
        return 384071999;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m19091n() != null) {
            FeedUnit feedUnit = (FeedUnit) graphQLModelMutatingVisitor.mo2928b(m19091n());
            if (m19091n() != feedUnit) {
                graphQLVisitableModel = (GraphQLFeedUnitEdge) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f12980i = feedUnit;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLFeedUnitEdge() {
        super(9);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f12978g = mutableFlatBuffer.m21540a(i, 3);
        this.f12981j = mutableFlatBuffer.m21523a(i, 6, 0.0d);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m19086g());
        int b2 = flatBufferBuilder.m21502b(m19080b());
        int b3 = flatBufferBuilder.m21502b(m19088k());
        int a = flatBufferBuilder.m21476a(m19091n(), VirtualFlattenableResolverImpl.f15617a);
        int b4 = flatBufferBuilder.m21502b(m19084d());
        flatBufferBuilder.m21510c(8);
        flatBufferBuilder.m21496a(0, m19090m() == GraphQLBumpReason.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m19090m());
        flatBufferBuilder.m21507b(1, b);
        flatBufferBuilder.m21507b(2, b2);
        flatBufferBuilder.m21498a(3, m19089l());
        flatBufferBuilder.m21507b(4, b3);
        flatBufferBuilder.m21507b(5, a);
        flatBufferBuilder.m21492a(6, X_(), 0.0d);
        flatBufferBuilder.m21507b(7, b4);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLFeedUnitEdge(Parcel parcel) {
        boolean z = true;
        super(9);
        this.f12975d = GraphQLBumpReason.fromString(parcel.readString());
        this.f12976e = parcel.readString();
        this.f12977f = parcel.readString();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f12978g = z;
        this.f12979h = parcel.readString();
        this.f12980i = (FeedUnit) parcel.readValue(FeedUnit.class.getClassLoader());
        this.f12981j = parcel.readDouble();
        this.f12982k = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m19090m().name());
        parcel.writeString(m19086g());
        parcel.writeString(m19080b());
        parcel.writeByte((byte) (m19089l() ? 1 : 0));
        parcel.writeString(m19088k());
        parcel.writeValue(m19091n());
        parcel.writeDouble(X_());
        parcel.writeString(m19084d());
    }

    public GraphQLFeedUnitEdge(Builder builder) {
        super(9);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f12975d = builder.f15727d;
        this.f12976e = builder.f15728e;
        this.f12977f = builder.f15729f;
        this.f12978g = builder.f15730g;
        this.f12979h = builder.f15731h;
        this.f12980i = builder.f15732i;
        this.f12981j = builder.f15733j;
        this.f12982k = builder.f15734k;
        this.f12983l = builder.f15735l;
    }

    public final PropertyBag U_() {
        if (this.f12983l == null) {
            this.f12983l = new PropertyBag();
        }
        return this.f12983l;
    }
}
