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
import com.facebook.graphql.deserializers.GraphQLEventUserBlockResponsePayloadDeserializer;
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
/* compiled from: image_glyph */
public final class GraphQLEventUserBlockResponsePayload extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLEventUserBlockResponsePayload> CREATOR = new C03161();
    @Nullable
    public GraphQLUser f3673d;

    /* compiled from: image_glyph */
    final class C03161 implements Creator<GraphQLEventUserBlockResponsePayload> {
        C03161() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLEventUserBlockResponsePayload(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLEventUserBlockResponsePayload[i];
        }
    }

    /* compiled from: image_glyph */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLEventUserBlockResponsePayload.class, new Deserializer());
        }

        public Object m7305a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLEventUserBlockResponsePayloadDeserializer.m4837a(jsonParser, (short) 317);
            Object graphQLEventUserBlockResponsePayload = new GraphQLEventUserBlockResponsePayload();
            ((BaseModel) graphQLEventUserBlockResponsePayload).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLEventUserBlockResponsePayload instanceof Postprocessable) {
                return ((Postprocessable) graphQLEventUserBlockResponsePayload).a();
            }
            return graphQLEventUserBlockResponsePayload;
        }
    }

    /* compiled from: image_glyph */
    public final class Serializer extends JsonSerializer<GraphQLEventUserBlockResponsePayload> {
        public final void m7306a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLEventUserBlockResponsePayload graphQLEventUserBlockResponsePayload = (GraphQLEventUserBlockResponsePayload) obj;
            GraphQLEventUserBlockResponsePayloadDeserializer.m4838a(graphQLEventUserBlockResponsePayload.w_(), graphQLEventUserBlockResponsePayload.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLEventUserBlockResponsePayload.class, new Serializer());
            FbSerializerProvider.a(GraphQLEventUserBlockResponsePayload.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLUser m7308a() {
        this.f3673d = (GraphQLUser) super.a(this.f3673d, 0, GraphQLUser.class);
        return this.f3673d;
    }

    public final int jK_() {
        return 173053637;
    }

    public final GraphQLVisitableModel m7309a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7308a() != null) {
            GraphQLUser graphQLUser = (GraphQLUser) graphQLModelMutatingVisitor.b(m7308a());
            if (m7308a() != graphQLUser) {
                graphQLVisitableModel = (GraphQLEventUserBlockResponsePayload) ModelHelper.a(null, this);
                graphQLVisitableModel.f3673d = graphQLUser;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLEventUserBlockResponsePayload() {
        super(2);
    }

    public final int m7307a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m7308a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLEventUserBlockResponsePayload(Parcel parcel) {
        super(2);
        this.f3673d = (GraphQLUser) parcel.readValue(GraphQLUser.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m7308a());
    }
}
