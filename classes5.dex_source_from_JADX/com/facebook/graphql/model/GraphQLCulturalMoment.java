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
import com.facebook.graphql.deserializers.GraphQLCulturalMomentDeserializer;
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
/* compiled from: ip */
public final class GraphQLCulturalMoment extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLCulturalMoment> CREATOR = new C02921();
    @Nullable
    GraphQLImage f3501d;
    @Nullable
    GraphQLImage f3502e;
    @Nullable
    String f3503f;
    @Nullable
    String f3504g;
    @Nullable
    String f3505h;
    @Nullable
    GraphQLVideo f3506i;

    /* compiled from: ip */
    final class C02921 implements Creator<GraphQLCulturalMoment> {
        C02921() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLCulturalMoment(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLCulturalMoment[i];
        }
    }

    /* compiled from: ip */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLCulturalMoment.class, new Deserializer());
        }

        public Object m6905a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLCulturalMomentDeserializer.m4698a(jsonParser, (short) 51);
            Object graphQLCulturalMoment = new GraphQLCulturalMoment();
            ((BaseModel) graphQLCulturalMoment).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLCulturalMoment instanceof Postprocessable) {
                return ((Postprocessable) graphQLCulturalMoment).a();
            }
            return graphQLCulturalMoment;
        }
    }

    /* compiled from: ip */
    public final class Serializer extends JsonSerializer<GraphQLCulturalMoment> {
        public final void m6906a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLCulturalMoment graphQLCulturalMoment = (GraphQLCulturalMoment) obj;
            GraphQLCulturalMomentDeserializer.m4699a(graphQLCulturalMoment.w_(), graphQLCulturalMoment.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLCulturalMoment.class, new Serializer());
            FbSerializerProvider.a(GraphQLCulturalMoment.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m6910j() {
        this.f3501d = (GraphQLImage) super.a(this.f3501d, 0, GraphQLImage.class);
        return this.f3501d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m6911k() {
        this.f3502e = (GraphQLImage) super.a(this.f3502e, 1, GraphQLImage.class);
        return this.f3502e;
    }

    @FieldOffset
    @Nullable
    public final String m6912l() {
        this.f3503f = super.a(this.f3503f, 2);
        return this.f3503f;
    }

    @FieldOffset
    @Nullable
    public final String m6913m() {
        this.f3504g = super.a(this.f3504g, 3);
        return this.f3504g;
    }

    @FieldOffset
    @Nullable
    public final String m6914n() {
        this.f3505h = super.a(this.f3505h, 5);
        return this.f3505h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLVideo m6915o() {
        this.f3506i = (GraphQLVideo) super.a(this.f3506i, 6, GraphQLVideo.class);
        return this.f3506i;
    }

    @Nullable
    public final String m6909a() {
        return m6912l();
    }

    public final int jK_() {
        return -1196289854;
    }

    public final GraphQLVisitableModel m6908a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLImage graphQLImage;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m6910j() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m6910j());
            if (m6910j() != graphQLImage) {
                graphQLVisitableModel = (GraphQLCulturalMoment) ModelHelper.a(null, this);
                graphQLVisitableModel.f3501d = graphQLImage;
            }
        }
        if (m6915o() != null) {
            GraphQLVideo graphQLVideo = (GraphQLVideo) graphQLModelMutatingVisitor.b(m6915o());
            if (m6915o() != graphQLVideo) {
                graphQLVisitableModel = (GraphQLCulturalMoment) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3506i = graphQLVideo;
            }
        }
        if (m6911k() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m6911k());
            if (m6911k() != graphQLImage) {
                graphQLVisitableModel = (GraphQLCulturalMoment) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3502e = graphQLImage;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLCulturalMoment() {
        super(8);
    }

    public final int m6907a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m6910j());
        int a2 = ModelHelper.a(flatBufferBuilder, m6911k());
        int b = flatBufferBuilder.b(m6912l());
        int b2 = flatBufferBuilder.b(m6913m());
        int b3 = flatBufferBuilder.b(m6914n());
        int a3 = ModelHelper.a(flatBufferBuilder, m6915o());
        flatBufferBuilder.c(7);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.b(2, b);
        flatBufferBuilder.b(3, b2);
        flatBufferBuilder.b(5, b3);
        flatBufferBuilder.b(6, a3);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLCulturalMoment(Parcel parcel) {
        super(8);
        this.f3501d = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3506i = (GraphQLVideo) parcel.readValue(GraphQLVideo.class.getClassLoader());
        this.f3502e = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3503f = parcel.readString();
        this.f3504g = parcel.readString();
        this.f3505h = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m6910j());
        parcel.writeValue(m6915o());
        parcel.writeValue(m6911k());
        parcel.writeString(m6912l());
        parcel.writeString(m6913m());
        parcel.writeString(m6914n());
    }
}
