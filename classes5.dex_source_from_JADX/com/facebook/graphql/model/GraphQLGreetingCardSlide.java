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
import com.facebook.graphql.deserializers.GraphQLGreetingCardSlideDeserializer;
import com.facebook.graphql.enums.GraphQLGreetingCardSlideType;
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
/* compiled from: from_coupon_email */
public final class GraphQLGreetingCardSlide extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGreetingCardSlide> CREATOR = new C03851();
    @Nullable
    GraphQLTextWithEntities f4132d;
    @Nullable
    GraphQLGreetingCardSlidePhotosConnection f4133e;
    GraphQLGreetingCardSlideType f4134f;
    @Nullable
    GraphQLTextWithEntities f4135g;

    /* compiled from: from_coupon_email */
    final class C03851 implements Creator<GraphQLGreetingCardSlide> {
        C03851() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGreetingCardSlide(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGreetingCardSlide[i];
        }
    }

    /* compiled from: from_coupon_email */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGreetingCardSlide.class, new Deserializer());
        }

        public Object m8331a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGreetingCardSlideDeserializer.m5128a(jsonParser, (short) 222);
            Object graphQLGreetingCardSlide = new GraphQLGreetingCardSlide();
            ((BaseModel) graphQLGreetingCardSlide).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGreetingCardSlide instanceof Postprocessable) {
                return ((Postprocessable) graphQLGreetingCardSlide).a();
            }
            return graphQLGreetingCardSlide;
        }
    }

    /* compiled from: from_coupon_email */
    public final class Serializer extends JsonSerializer<GraphQLGreetingCardSlide> {
        public final void m8332a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGreetingCardSlide graphQLGreetingCardSlide = (GraphQLGreetingCardSlide) obj;
            GraphQLGreetingCardSlideDeserializer.m5129b(graphQLGreetingCardSlide.w_(), graphQLGreetingCardSlide.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLGreetingCardSlide.class, new Serializer());
            FbSerializerProvider.a(GraphQLGreetingCardSlide.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m8334a() {
        this.f4132d = (GraphQLTextWithEntities) super.a(this.f4132d, 0, GraphQLTextWithEntities.class);
        return this.f4132d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGreetingCardSlidePhotosConnection m8336j() {
        this.f4133e = (GraphQLGreetingCardSlidePhotosConnection) super.a(this.f4133e, 1, GraphQLGreetingCardSlidePhotosConnection.class);
        return this.f4133e;
    }

    @FieldOffset
    public final GraphQLGreetingCardSlideType m8337k() {
        this.f4134f = (GraphQLGreetingCardSlideType) super.a(this.f4134f, 2, GraphQLGreetingCardSlideType.class, GraphQLGreetingCardSlideType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f4134f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m8338l() {
        this.f4135g = (GraphQLTextWithEntities) super.a(this.f4135g, 3, GraphQLTextWithEntities.class);
        return this.f4135g;
    }

    public final int jK_() {
        return 1230654504;
    }

    public final GraphQLVisitableModel m8335a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m8334a() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m8334a());
            if (m8334a() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGreetingCardSlide) ModelHelper.a(null, this);
                graphQLVisitableModel.f4132d = graphQLTextWithEntities;
            }
        }
        if (m8336j() != null) {
            GraphQLGreetingCardSlidePhotosConnection graphQLGreetingCardSlidePhotosConnection = (GraphQLGreetingCardSlidePhotosConnection) graphQLModelMutatingVisitor.b(m8336j());
            if (m8336j() != graphQLGreetingCardSlidePhotosConnection) {
                graphQLVisitableModel = (GraphQLGreetingCardSlide) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4133e = graphQLGreetingCardSlidePhotosConnection;
            }
        }
        if (m8338l() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m8338l());
            if (m8338l() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGreetingCardSlide) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4135g = graphQLTextWithEntities;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLGreetingCardSlide() {
        super(5);
    }

    public final int m8333a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m8334a());
        int a2 = ModelHelper.a(flatBufferBuilder, m8336j());
        int a3 = ModelHelper.a(flatBufferBuilder, m8338l());
        flatBufferBuilder.c(4);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.a(2, m8337k() == GraphQLGreetingCardSlideType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m8337k());
        flatBufferBuilder.b(3, a3);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGreetingCardSlide(Parcel parcel) {
        super(5);
        this.f4132d = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f4133e = (GraphQLGreetingCardSlidePhotosConnection) parcel.readValue(GraphQLGreetingCardSlidePhotosConnection.class.getClassLoader());
        this.f4134f = GraphQLGreetingCardSlideType.fromString(parcel.readString());
        this.f4135g = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m8334a());
        parcel.writeValue(m8336j());
        parcel.writeString(m8337k().name());
        parcel.writeValue(m8338l());
    }
}
