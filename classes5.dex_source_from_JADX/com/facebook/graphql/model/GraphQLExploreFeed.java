package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLExploreFeedDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.common.base.Preconditions;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: idempotence_token */
public final class GraphQLExploreFeed extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    public static final Creator<GraphQLExploreFeed> CREATOR = new C03201();
    @Nullable
    String f3712A;
    boolean f3713d;
    @Nullable
    GraphQLImage f3714e;
    @Nullable
    GraphQLImage f3715f;
    @Nullable
    GraphQLImage f3716g;
    @Nullable
    String f3717h;
    public boolean f3718i;
    int f3719j;
    @Nullable
    String f3720k;
    boolean f3721l;
    @Nullable
    GraphQLImage f3722m;
    @Nullable
    String f3723n;
    boolean f3724o;
    boolean f3725p;
    boolean f3726q;
    @Nullable
    GraphQLProfile f3727r;
    boolean f3728s;
    boolean f3729t;
    boolean f3730u;
    public boolean f3731v;
    int f3732w;
    int f3733x;
    @Nullable
    GraphQLTextWithEntities f3734y;
    @Nullable
    GraphQLTextWithEntities f3735z;

    /* compiled from: idempotence_token */
    final class C03201 implements Creator<GraphQLExploreFeed> {
        C03201() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLExploreFeed(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLExploreFeed[i];
        }
    }

    /* compiled from: idempotence_token */
    public class Builder extends com.facebook.graphql.modelutil.BaseModel.Builder {
        @Nullable
        public GraphQLTextWithEntities f3688A;
        @Nullable
        public String f3689d;
        public boolean f3690e;
        @Nullable
        public GraphQLImage f3691f;
        @Nullable
        public GraphQLImage f3692g;
        @Nullable
        public GraphQLImage f3693h;
        @Nullable
        public String f3694i;
        public boolean f3695j;
        public int f3696k;
        @Nullable
        public String f3697l;
        public boolean f3698m;
        @Nullable
        public GraphQLImage f3699n;
        @Nullable
        public String f3700o;
        public boolean f3701p;
        public boolean f3702q;
        public boolean f3703r;
        @Nullable
        public GraphQLProfile f3704s;
        public boolean f3705t;
        public boolean f3706u;
        public boolean f3707v;
        public boolean f3708w;
        public int f3709x;
        public int f3710y;
        @Nullable
        public GraphQLTextWithEntities f3711z;

        public Builder() {
            Preconditions.checkState(this instanceof Builder);
        }

        public final GraphQLExploreFeed m7369a() {
            return new GraphQLExploreFeed(this);
        }
    }

    /* compiled from: idempotence_token */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLExploreFeed.class, new Deserializer());
        }

        public Object m7370a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLExploreFeedDeserializer.m4862a(jsonParser, (short) 26);
            Object graphQLExploreFeed = new GraphQLExploreFeed();
            ((BaseModel) graphQLExploreFeed).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLExploreFeed instanceof Postprocessable) {
                return ((Postprocessable) graphQLExploreFeed).a();
            }
            return graphQLExploreFeed;
        }
    }

    /* compiled from: idempotence_token */
    public final class Serializer extends JsonSerializer<GraphQLExploreFeed> {
        public final void m7371a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLExploreFeed graphQLExploreFeed = (GraphQLExploreFeed) obj;
            GraphQLExploreFeedDeserializer.m4863b(graphQLExploreFeed.w_(), graphQLExploreFeed.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLExploreFeed.class, new Serializer());
            FbSerializerProvider.a(GraphQLExploreFeed.class, new Serializer());
        }
    }

    @FieldOffset
    public final boolean m7385j() {
        a(0, 0);
        return this.f3713d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m7386k() {
        this.f3714e = (GraphQLImage) super.a(this.f3714e, 1, GraphQLImage.class);
        return this.f3714e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m7387l() {
        this.f3715f = (GraphQLImage) super.a(this.f3715f, 2, GraphQLImage.class);
        return this.f3715f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m7388m() {
        this.f3716g = (GraphQLImage) super.a(this.f3716g, 3, GraphQLImage.class);
        return this.f3716g;
    }

    @FieldOffset
    @Nullable
    public final String m7389n() {
        this.f3717h = super.a(this.f3717h, 5);
        return this.f3717h;
    }

    @FieldOffset
    public final boolean m7390o() {
        a(0, 6);
        return this.f3718i;
    }

    @FieldOffset
    public final int m7391p() {
        a(0, 7);
        return this.f3719j;
    }

    @FieldOffset
    @Nullable
    public final String m7392q() {
        this.f3720k = super.a(this.f3720k, 8);
        return this.f3720k;
    }

    @FieldOffset
    public final boolean m7393r() {
        a(1, 1);
        return this.f3721l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m7394s() {
        this.f3722m = (GraphQLImage) super.a(this.f3722m, 10, GraphQLImage.class);
        return this.f3722m;
    }

    @FieldOffset
    @Nullable
    public final String m7395t() {
        this.f3723n = super.a(this.f3723n, 11);
        return this.f3723n;
    }

    @FieldOffset
    public final boolean m7396u() {
        a(1, 4);
        return this.f3724o;
    }

    @FieldOffset
    public final boolean m7397v() {
        a(1, 5);
        return this.f3725p;
    }

    @FieldOffset
    public final boolean m7398w() {
        a(1, 6);
        return this.f3726q;
    }

    @FieldOffset
    @Nullable
    public final GraphQLProfile m7399x() {
        this.f3727r = (GraphQLProfile) super.a(this.f3727r, 15, GraphQLProfile.class);
        return this.f3727r;
    }

    @FieldOffset
    public final boolean m7400y() {
        a(2, 0);
        return this.f3728s;
    }

    @FieldOffset
    public final boolean m7401z() {
        a(2, 1);
        return this.f3729t;
    }

    @FieldOffset
    public final boolean m7372A() {
        a(2, 2);
        return this.f3730u;
    }

    @FieldOffset
    public final boolean m7373B() {
        a(2, 3);
        return this.f3731v;
    }

    @FieldOffset
    public final int m7374C() {
        a(2, 4);
        return this.f3732w;
    }

    @FieldOffset
    public final int m7375D() {
        a(2, 5);
        return this.f3733x;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m7376E() {
        this.f3734y = (GraphQLTextWithEntities) super.a(this.f3734y, 22, GraphQLTextWithEntities.class);
        return this.f3734y;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m7377F() {
        this.f3735z = (GraphQLTextWithEntities) super.a(this.f3735z, 23, GraphQLTextWithEntities.class);
        return this.f3735z;
    }

    @FieldOffset
    @Nullable
    public final String m7378G() {
        this.f3712A = super.a(this.f3712A, 24);
        return this.f3712A;
    }

    @Nullable
    public final String m7381a() {
        return m7389n();
    }

    public final int jK_() {
        return 218987185;
    }

    public final GraphQLVisitableModel m7380a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLImage graphQLImage;
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7386k() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m7386k());
            if (m7386k() != graphQLImage) {
                graphQLVisitableModel = (GraphQLExploreFeed) ModelHelper.a(null, this);
                graphQLVisitableModel.f3714e = graphQLImage;
            }
        }
        if (m7387l() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m7387l());
            if (m7387l() != graphQLImage) {
                graphQLVisitableModel = (GraphQLExploreFeed) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3715f = graphQLImage;
            }
        }
        if (m7388m() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m7388m());
            if (m7388m() != graphQLImage) {
                graphQLVisitableModel = (GraphQLExploreFeed) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3716g = graphQLImage;
            }
        }
        if (m7394s() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m7394s());
            if (m7394s() != graphQLImage) {
                graphQLVisitableModel = (GraphQLExploreFeed) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3722m = graphQLImage;
            }
        }
        if (m7399x() != null) {
            GraphQLProfile graphQLProfile = (GraphQLProfile) graphQLModelMutatingVisitor.b(m7399x());
            if (m7399x() != graphQLProfile) {
                graphQLVisitableModel = (GraphQLExploreFeed) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3727r = graphQLProfile;
            }
        }
        if (m7376E() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7376E());
            if (m7376E() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLExploreFeed) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3734y = graphQLTextWithEntities;
            }
        }
        if (m7377F() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7377F());
            if (m7377F() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLExploreFeed) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3735z = graphQLTextWithEntities;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final void m7383a(String str, ConsistencyTuple consistencyTuple) {
        if ("is_favorited".equals(str)) {
            consistencyTuple.a = Boolean.valueOf(m7390o());
            consistencyTuple.b = u_();
            consistencyTuple.c = 6;
        } else if ("video_channel_is_viewer_pinned".equals(str)) {
            consistencyTuple.a = Boolean.valueOf(m7373B());
            consistencyTuple.b = u_();
            consistencyTuple.c = 19;
        } else {
            consistencyTuple.a();
        }
    }

    public final void m7384a(String str, Object obj, boolean z) {
        boolean booleanValue;
        if ("is_favorited".equals(str)) {
            booleanValue = ((Boolean) obj).booleanValue();
            this.f3718i = booleanValue;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 6, booleanValue);
            }
        } else if ("video_channel_is_viewer_pinned".equals(str)) {
            booleanValue = ((Boolean) obj).booleanValue();
            this.f3731v = booleanValue;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 19, booleanValue);
            }
        }
    }

    public GraphQLExploreFeed() {
        super(26);
    }

    public final void m7382a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f3713d = mutableFlatBuffer.a(i, 0);
        this.f3718i = mutableFlatBuffer.a(i, 6);
        this.f3719j = mutableFlatBuffer.a(i, 7, 0);
        this.f3721l = mutableFlatBuffer.a(i, 9);
        this.f3724o = mutableFlatBuffer.a(i, 12);
        this.f3725p = mutableFlatBuffer.a(i, 13);
        this.f3726q = mutableFlatBuffer.a(i, 14);
        this.f3728s = mutableFlatBuffer.a(i, 16);
        this.f3729t = mutableFlatBuffer.a(i, 17);
        this.f3730u = mutableFlatBuffer.a(i, 18);
        this.f3731v = mutableFlatBuffer.a(i, 19);
        this.f3732w = mutableFlatBuffer.a(i, 20, 0);
        this.f3733x = mutableFlatBuffer.a(i, 21, 0);
    }

    public final int m7379a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m7386k());
        int a2 = ModelHelper.a(flatBufferBuilder, m7387l());
        int a3 = ModelHelper.a(flatBufferBuilder, m7388m());
        int b = flatBufferBuilder.b(m7389n());
        int b2 = flatBufferBuilder.b(m7392q());
        int a4 = ModelHelper.a(flatBufferBuilder, m7394s());
        int b3 = flatBufferBuilder.b(m7395t());
        int a5 = ModelHelper.a(flatBufferBuilder, m7399x());
        int a6 = ModelHelper.a(flatBufferBuilder, m7376E());
        int a7 = ModelHelper.a(flatBufferBuilder, m7377F());
        int b4 = flatBufferBuilder.b(m7378G());
        flatBufferBuilder.c(25);
        flatBufferBuilder.a(0, m7385j());
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.b(3, a3);
        flatBufferBuilder.b(5, b);
        flatBufferBuilder.a(6, m7390o());
        flatBufferBuilder.a(7, m7391p(), 0);
        flatBufferBuilder.b(8, b2);
        flatBufferBuilder.a(9, m7393r());
        flatBufferBuilder.b(10, a4);
        flatBufferBuilder.b(11, b3);
        flatBufferBuilder.a(12, m7396u());
        flatBufferBuilder.a(13, m7397v());
        flatBufferBuilder.a(14, m7398w());
        flatBufferBuilder.b(15, a5);
        flatBufferBuilder.a(16, m7400y());
        flatBufferBuilder.a(17, m7401z());
        flatBufferBuilder.a(18, m7372A());
        flatBufferBuilder.a(19, m7373B());
        flatBufferBuilder.a(20, m7374C(), 0);
        flatBufferBuilder.a(21, m7375D(), 0);
        flatBufferBuilder.b(22, a6);
        flatBufferBuilder.b(23, a7);
        flatBufferBuilder.b(24, b4);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLExploreFeed(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(26);
        this.f3712A = parcel.readString();
        this.f3713d = parcel.readByte() == (byte) 1;
        this.f3714e = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3715f = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3716g = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3717h = parcel.readString();
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f3718i = z;
        this.f3719j = parcel.readInt();
        this.f3720k = parcel.readString();
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f3721l = z;
        this.f3722m = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3723n = parcel.readString();
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f3724o = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f3725p = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f3726q = z;
        this.f3727r = (GraphQLProfile) parcel.readValue(GraphQLProfile.class.getClassLoader());
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f3728s = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f3729t = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f3730u = z;
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.f3731v = z2;
        this.f3732w = parcel.readInt();
        this.f3733x = parcel.readInt();
        this.f3734y = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3735z = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(m7378G());
        parcel.writeByte((byte) (m7385j() ? 1 : 0));
        parcel.writeValue(m7386k());
        parcel.writeValue(m7387l());
        parcel.writeValue(m7388m());
        parcel.writeString(m7389n());
        if (m7390o()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeInt(m7391p());
        parcel.writeString(m7392q());
        if (m7393r()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeValue(m7394s());
        parcel.writeString(m7395t());
        if (m7396u()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m7397v()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m7398w()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeValue(m7399x());
        if (m7400y()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m7401z()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m7372A()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!m7373B()) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeInt(m7374C());
        parcel.writeInt(m7375D());
        parcel.writeValue(m7376E());
        parcel.writeValue(m7377F());
    }

    public GraphQLExploreFeed(Builder builder) {
        super(26);
        this.b = builder.a;
        this.c = builder.b;
        this.f3712A = builder.f3689d;
        this.f3713d = builder.f3690e;
        this.f3714e = builder.f3691f;
        this.f3715f = builder.f3692g;
        this.f3716g = builder.f3693h;
        this.f3717h = builder.f3694i;
        this.f3718i = builder.f3695j;
        this.f3719j = builder.f3696k;
        this.f3720k = builder.f3697l;
        this.f3721l = builder.f3698m;
        this.f3722m = builder.f3699n;
        this.f3723n = builder.f3700o;
        this.f3724o = builder.f3701p;
        this.f3725p = builder.f3702q;
        this.f3726q = builder.f3703r;
        this.f3727r = builder.f3704s;
        this.f3728s = builder.f3705t;
        this.f3729t = builder.f3706u;
        this.f3730u = builder.f3707v;
        this.f3731v = builder.f3708w;
        this.f3732w = builder.f3709x;
        this.f3733x = builder.f3710y;
        this.f3734y = builder.f3711z;
        this.f3735z = builder.f3688A;
    }
}
