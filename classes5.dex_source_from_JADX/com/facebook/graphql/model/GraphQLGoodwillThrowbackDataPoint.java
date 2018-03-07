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
import com.facebook.graphql.deserializers.GraphQLGoodwillThrowbackDataPointDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
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
/* compiled from: gps.on */
public final class GraphQLGoodwillThrowbackDataPoint extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGoodwillThrowbackDataPoint> CREATOR = new C03521();
    @Nullable
    public GraphQLImage f3938d;
    @Nullable
    public GraphQLTextWithEntities f3939e;

    /* compiled from: gps.on */
    final class C03521 implements Creator<GraphQLGoodwillThrowbackDataPoint> {
        C03521() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGoodwillThrowbackDataPoint(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGoodwillThrowbackDataPoint[i];
        }
    }

    /* compiled from: gps.on */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGoodwillThrowbackDataPoint.class, new Deserializer());
        }

        public Object m7926a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGoodwillThrowbackDataPointDeserializer.m5027a(jsonParser, (short) 235);
            Object graphQLGoodwillThrowbackDataPoint = new GraphQLGoodwillThrowbackDataPoint();
            ((BaseModel) graphQLGoodwillThrowbackDataPoint).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGoodwillThrowbackDataPoint instanceof Postprocessable) {
                return ((Postprocessable) graphQLGoodwillThrowbackDataPoint).a();
            }
            return graphQLGoodwillThrowbackDataPoint;
        }
    }

    /* compiled from: gps.on */
    public final class Serializer extends JsonSerializer<GraphQLGoodwillThrowbackDataPoint> {
        public final void m7927a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGoodwillThrowbackDataPoint graphQLGoodwillThrowbackDataPoint = (GraphQLGoodwillThrowbackDataPoint) obj;
            GraphQLGoodwillThrowbackDataPointDeserializer.m5028b(graphQLGoodwillThrowbackDataPoint.w_(), graphQLGoodwillThrowbackDataPoint.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLGoodwillThrowbackDataPoint.class, new Serializer());
            FbSerializerProvider.a(GraphQLGoodwillThrowbackDataPoint.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m7929a() {
        this.f3938d = (GraphQLImage) super.a(this.f3938d, 0, GraphQLImage.class);
        return this.f3938d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m7931j() {
        this.f3939e = (GraphQLTextWithEntities) super.a(this.f3939e, 1, GraphQLTextWithEntities.class);
        return this.f3939e;
    }

    public final int jK_() {
        return 938654280;
    }

    public final GraphQLVisitableModel m7930a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7929a() != null) {
            GraphQLImage graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m7929a());
            if (m7929a() != graphQLImage) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackDataPoint) ModelHelper.a(null, this);
                graphQLVisitableModel.f3938d = graphQLImage;
            }
        }
        if (m7931j() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7931j());
            if (m7931j() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackDataPoint) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3939e = graphQLTextWithEntities;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLGoodwillThrowbackDataPoint() {
        super(3);
    }

    public final int m7928a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m7929a());
        int a2 = ModelHelper.a(flatBufferBuilder, m7931j());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGoodwillThrowbackDataPoint(Parcel parcel) {
        super(3);
        this.f3938d = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3939e = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m7929a());
        parcel.writeValue(m7931j());
    }
}
