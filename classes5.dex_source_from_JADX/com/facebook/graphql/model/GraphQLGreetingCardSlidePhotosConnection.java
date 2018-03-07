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
import com.facebook.graphql.deserializers.GraphQLGreetingCardSlidePhotosConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: from_coupon */
public final class GraphQLGreetingCardSlidePhotosConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGreetingCardSlidePhotosConnection> CREATOR = new C03861();
    public List<GraphQLPhoto> f4136d;

    /* compiled from: from_coupon */
    final class C03861 implements Creator<GraphQLGreetingCardSlidePhotosConnection> {
        C03861() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGreetingCardSlidePhotosConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGreetingCardSlidePhotosConnection[i];
        }
    }

    /* compiled from: from_coupon */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGreetingCardSlidePhotosConnection.class, new Deserializer());
        }

        public Object m8340a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGreetingCardSlidePhotosConnectionDeserializer.m5131a(jsonParser, (short) 223);
            Object graphQLGreetingCardSlidePhotosConnection = new GraphQLGreetingCardSlidePhotosConnection();
            ((BaseModel) graphQLGreetingCardSlidePhotosConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGreetingCardSlidePhotosConnection instanceof Postprocessable) {
                return ((Postprocessable) graphQLGreetingCardSlidePhotosConnection).a();
            }
            return graphQLGreetingCardSlidePhotosConnection;
        }
    }

    /* compiled from: from_coupon */
    public final class Serializer extends JsonSerializer<GraphQLGreetingCardSlidePhotosConnection> {
        public final void m8341a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGreetingCardSlidePhotosConnection graphQLGreetingCardSlidePhotosConnection = (GraphQLGreetingCardSlidePhotosConnection) obj;
            GraphQLGreetingCardSlidePhotosConnectionDeserializer.m5132a(graphQLGreetingCardSlidePhotosConnection.w_(), graphQLGreetingCardSlidePhotosConnection.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLGreetingCardSlidePhotosConnection.class, new Serializer());
            FbSerializerProvider.a(GraphQLGreetingCardSlidePhotosConnection.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLPhoto> m8344a() {
        this.f4136d = super.a(this.f4136d, 0, GraphQLPhoto.class);
        return (ImmutableList) this.f4136d;
    }

    public final int jK_() {
        return -530041209;
    }

    public final GraphQLVisitableModel m8343a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m8344a() != null) {
            Builder a = ModelHelper.a(m8344a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLGreetingCardSlidePhotosConnection) ModelHelper.a(null, this);
                graphQLVisitableModel.f4136d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLGreetingCardSlidePhotosConnection() {
        super(2);
    }

    public final int m8342a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m8344a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGreetingCardSlidePhotosConnection(Parcel parcel) {
        super(2);
        this.f4136d = ImmutableListHelper.a(parcel.readArrayList(GraphQLPhoto.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m8344a());
    }
}
