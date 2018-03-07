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
import com.facebook.graphql.deserializers.GraphQLSinglePublisherVideoChannelsEdgeDeserializer;
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
/* compiled from: UsernameUnavailable */
public final class GraphQLSinglePublisherVideoChannelsEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLSinglePublisherVideoChannelsEdge> CREATOR = new C12251();
    @Nullable
    public GraphQLVideoChannel f13023d;

    /* compiled from: UsernameUnavailable */
    final class C12251 implements Creator<GraphQLSinglePublisherVideoChannelsEdge> {
        C12251() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLSinglePublisherVideoChannelsEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLSinglePublisherVideoChannelsEdge[i];
        }
    }

    /* compiled from: UsernameUnavailable */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLSinglePublisherVideoChannelsEdge.class, new Deserializer());
        }

        public Object m21664a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLSinglePublisherVideoChannelsEdgeDeserializer.m5893a(jsonParser, (short) 394);
            Object graphQLSinglePublisherVideoChannelsEdge = new GraphQLSinglePublisherVideoChannelsEdge();
            ((BaseModel) graphQLSinglePublisherVideoChannelsEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLSinglePublisherVideoChannelsEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLSinglePublisherVideoChannelsEdge).a();
            }
            return graphQLSinglePublisherVideoChannelsEdge;
        }
    }

    /* compiled from: UsernameUnavailable */
    public final class Serializer extends JsonSerializer<GraphQLSinglePublisherVideoChannelsEdge> {
        public final void m21665a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLSinglePublisherVideoChannelsEdge graphQLSinglePublisherVideoChannelsEdge = (GraphQLSinglePublisherVideoChannelsEdge) obj;
            GraphQLSinglePublisherVideoChannelsEdgeDeserializer.m5894b(graphQLSinglePublisherVideoChannelsEdge.w_(), graphQLSinglePublisherVideoChannelsEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLSinglePublisherVideoChannelsEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLSinglePublisherVideoChannelsEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLVideoChannel m21667a() {
        this.f13023d = (GraphQLVideoChannel) super.a(this.f13023d, 0, GraphQLVideoChannel.class);
        return this.f13023d;
    }

    public final int jK_() {
        return 2122667444;
    }

    public final GraphQLVisitableModel m21668a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m21667a() != null) {
            GraphQLVideoChannel graphQLVideoChannel = (GraphQLVideoChannel) graphQLModelMutatingVisitor.b(m21667a());
            if (m21667a() != graphQLVideoChannel) {
                graphQLVisitableModel = (GraphQLSinglePublisherVideoChannelsEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f13023d = graphQLVideoChannel;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLSinglePublisherVideoChannelsEdge() {
        super(2);
    }

    public final int m21666a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m21667a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLSinglePublisherVideoChannelsEdge(Parcel parcel) {
        super(2);
        this.f13023d = (GraphQLVideoChannel) parcel.readValue(GraphQLVideoChannel.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m21667a());
    }
}
