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
import com.facebook.graphql.deserializers.GraphQLPostChannelDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: WALL */
public final class GraphQLPostChannel extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLPostChannel> CREATOR = new C11841();
    @Nullable
    GraphQLFocusedPhoto f12675d;
    boolean f12676e;
    boolean f12677f;
    @Nullable
    GraphQLFocusedPhoto f12678g;
    long f12679h;
    @Nullable
    GraphQLFeedback f12680i;
    @Nullable
    String f12681j;
    long f12682k;
    @Nullable
    GraphQLPrivacyScope f12683l;
    @Nullable
    GraphQLTextWithEntities f12684m;
    @Nullable
    GraphQLTextWithEntities f12685n;
    @Nullable
    String f12686o;

    /* compiled from: WALL */
    final class C11841 implements Creator<GraphQLPostChannel> {
        C11841() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLPostChannel(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLPostChannel[i];
        }
    }

    /* compiled from: WALL */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLPostChannel.class, new Deserializer());
        }

        public Object m20945a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLPostChannelDeserializer.m5680a(jsonParser, (short) 87);
            Object graphQLPostChannel = new GraphQLPostChannel();
            ((BaseModel) graphQLPostChannel).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLPostChannel instanceof Postprocessable) {
                return ((Postprocessable) graphQLPostChannel).a();
            }
            return graphQLPostChannel;
        }
    }

    /* compiled from: WALL */
    public final class Serializer extends JsonSerializer<GraphQLPostChannel> {
        public final void m20946a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLPostChannel graphQLPostChannel = (GraphQLPostChannel) obj;
            GraphQLPostChannelDeserializer.m5681a(graphQLPostChannel.w_(), graphQLPostChannel.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLPostChannel.class, new Serializer());
            FbSerializerProvider.a(GraphQLPostChannel.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLFocusedPhoto m20951j() {
        this.f12675d = (GraphQLFocusedPhoto) super.a(this.f12675d, 0, GraphQLFocusedPhoto.class);
        return this.f12675d;
    }

    @FieldOffset
    public final boolean m20952k() {
        a(0, 1);
        return this.f12676e;
    }

    @FieldOffset
    public final boolean m20953l() {
        a(0, 2);
        return this.f12677f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFocusedPhoto m20954m() {
        this.f12678g = (GraphQLFocusedPhoto) super.a(this.f12678g, 3, GraphQLFocusedPhoto.class);
        return this.f12678g;
    }

    @FieldOffset
    public final long m20955n() {
        a(0, 4);
        return this.f12679h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFeedback m20956o() {
        this.f12680i = (GraphQLFeedback) super.a(this.f12680i, 5, GraphQLFeedback.class);
        return this.f12680i;
    }

    @FieldOffset
    @Nullable
    public final String m20957p() {
        this.f12681j = super.a(this.f12681j, 6);
        return this.f12681j;
    }

    @FieldOffset
    public final long m20958q() {
        a(0, 7);
        return this.f12682k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPrivacyScope m20959r() {
        this.f12683l = (GraphQLPrivacyScope) super.a(this.f12683l, 8, GraphQLPrivacyScope.class);
        return this.f12683l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m20960s() {
        this.f12684m = (GraphQLTextWithEntities) super.a(this.f12684m, 10, GraphQLTextWithEntities.class);
        return this.f12684m;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m20961t() {
        this.f12685n = (GraphQLTextWithEntities) super.a(this.f12685n, 11, GraphQLTextWithEntities.class);
        return this.f12685n;
    }

    @FieldOffset
    @Nullable
    public final String m20962u() {
        this.f12686o = super.a(this.f12686o, 12);
        return this.f12686o;
    }

    @Nullable
    public final String m20949a() {
        return m20957p();
    }

    public final int jK_() {
        return -1353043933;
    }

    public final GraphQLVisitableModel m20948a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLFocusedPhoto graphQLFocusedPhoto;
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m20951j() != null) {
            graphQLFocusedPhoto = (GraphQLFocusedPhoto) graphQLModelMutatingVisitor.b(m20951j());
            if (m20951j() != graphQLFocusedPhoto) {
                graphQLVisitableModel = (GraphQLPostChannel) ModelHelper.a(null, this);
                graphQLVisitableModel.f12675d = graphQLFocusedPhoto;
            }
        }
        if (m20954m() != null) {
            graphQLFocusedPhoto = (GraphQLFocusedPhoto) graphQLModelMutatingVisitor.b(m20954m());
            if (m20954m() != graphQLFocusedPhoto) {
                graphQLVisitableModel = (GraphQLPostChannel) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12678g = graphQLFocusedPhoto;
            }
        }
        if (m20956o() != null) {
            GraphQLFeedback graphQLFeedback = (GraphQLFeedback) graphQLModelMutatingVisitor.b(m20956o());
            if (m20956o() != graphQLFeedback) {
                graphQLVisitableModel = (GraphQLPostChannel) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12680i = graphQLFeedback;
            }
        }
        if (m20959r() != null) {
            GraphQLPrivacyScope graphQLPrivacyScope = (GraphQLPrivacyScope) graphQLModelMutatingVisitor.b(m20959r());
            if (m20959r() != graphQLPrivacyScope) {
                graphQLVisitableModel = (GraphQLPostChannel) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12683l = graphQLPrivacyScope;
            }
        }
        if (m20960s() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m20960s());
            if (m20960s() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLPostChannel) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12684m = graphQLTextWithEntities;
            }
        }
        if (m20961t() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m20961t());
            if (m20961t() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLPostChannel) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12685n = graphQLTextWithEntities;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPostChannel() {
        super(14);
    }

    public final void m20950a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f12676e = mutableFlatBuffer.a(i, 1);
        this.f12677f = mutableFlatBuffer.a(i, 2);
        this.f12679h = mutableFlatBuffer.a(i, 4, 0);
        this.f12682k = mutableFlatBuffer.a(i, 7, 0);
    }

    public final int m20947a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m20951j());
        int a2 = ModelHelper.a(flatBufferBuilder, m20954m());
        int a3 = ModelHelper.a(flatBufferBuilder, m20956o());
        int b = flatBufferBuilder.b(m20957p());
        int a4 = ModelHelper.a(flatBufferBuilder, m20959r());
        int a5 = ModelHelper.a(flatBufferBuilder, m20960s());
        int a6 = ModelHelper.a(flatBufferBuilder, m20961t());
        int b2 = flatBufferBuilder.b(m20962u());
        flatBufferBuilder.c(13);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.a(1, m20952k());
        flatBufferBuilder.a(2, m20953l());
        flatBufferBuilder.b(3, a2);
        flatBufferBuilder.a(4, m20955n(), 0);
        flatBufferBuilder.b(5, a3);
        flatBufferBuilder.b(6, b);
        flatBufferBuilder.a(7, m20958q(), 0);
        flatBufferBuilder.b(8, a4);
        flatBufferBuilder.b(10, a5);
        flatBufferBuilder.b(11, a6);
        flatBufferBuilder.b(12, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLPostChannel(Parcel parcel) {
        boolean z = true;
        super(14);
        this.f12675d = (GraphQLFocusedPhoto) parcel.readValue(GraphQLFocusedPhoto.class.getClassLoader());
        this.f12676e = parcel.readByte() == (byte) 1;
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f12677f = z;
        this.f12678g = (GraphQLFocusedPhoto) parcel.readValue(GraphQLFocusedPhoto.class.getClassLoader());
        this.f12679h = parcel.readLong();
        this.f12680i = (GraphQLFeedback) parcel.readValue(GraphQLFeedback.class.getClassLoader());
        this.f12681j = parcel.readString();
        this.f12682k = parcel.readLong();
        this.f12683l = (GraphQLPrivacyScope) parcel.readValue(GraphQLPrivacyScope.class.getClassLoader());
        this.f12684m = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f12685n = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f12686o = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeValue(m20951j());
        parcel.writeByte((byte) (m20952k() ? 1 : 0));
        if (!m20953l()) {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeValue(m20954m());
        parcel.writeLong(m20955n());
        parcel.writeValue(m20956o());
        parcel.writeString(m20957p());
        parcel.writeLong(m20958q());
        parcel.writeValue(m20959r());
        parcel.writeValue(m20960s());
        parcel.writeValue(m20961t());
        parcel.writeString(m20962u());
    }
}
