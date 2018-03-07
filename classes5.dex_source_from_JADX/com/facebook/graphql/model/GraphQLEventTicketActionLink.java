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
import com.facebook.graphql.deserializers.GraphQLEventTicketActionLinkDeserializer;
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
/* compiled from: immersive */
public final class GraphQLEventTicketActionLink extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLEventTicketActionLink> CREATOR = new C03151();
    @Nullable
    GraphQLEvent f3670d;
    @Nullable
    String f3671e;
    @Nullable
    String f3672f;

    /* compiled from: immersive */
    final class C03151 implements Creator<GraphQLEventTicketActionLink> {
        C03151() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLEventTicketActionLink(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLEventTicketActionLink[i];
        }
    }

    /* compiled from: immersive */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLEventTicketActionLink.class, new Deserializer());
        }

        public Object m7283a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLEventTicketActionLinkDeserializer.m4828a(jsonParser, (short) 178);
            Object graphQLEventTicketActionLink = new GraphQLEventTicketActionLink();
            ((BaseModel) graphQLEventTicketActionLink).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLEventTicketActionLink instanceof Postprocessable) {
                return ((Postprocessable) graphQLEventTicketActionLink).a();
            }
            return graphQLEventTicketActionLink;
        }
    }

    /* compiled from: immersive */
    public final class Serializer extends JsonSerializer<GraphQLEventTicketActionLink> {
        public final void m7284a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLEventTicketActionLink graphQLEventTicketActionLink = (GraphQLEventTicketActionLink) obj;
            GraphQLEventTicketActionLinkDeserializer.m4829a(graphQLEventTicketActionLink.w_(), graphQLEventTicketActionLink.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLEventTicketActionLink.class, new Serializer());
            FbSerializerProvider.a(GraphQLEventTicketActionLink.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLEvent m7286a() {
        this.f3670d = (GraphQLEvent) super.a(this.f3670d, 0, GraphQLEvent.class);
        return this.f3670d;
    }

    @FieldOffset
    @Nullable
    public final String m7288j() {
        this.f3671e = super.a(this.f3671e, 1);
        return this.f3671e;
    }

    @FieldOffset
    @Nullable
    public final String m7289k() {
        this.f3672f = super.a(this.f3672f, 2);
        return this.f3672f;
    }

    public final int jK_() {
        return -1610739178;
    }

    public final GraphQLVisitableModel m7287a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7286a() != null) {
            GraphQLEvent graphQLEvent = (GraphQLEvent) graphQLModelMutatingVisitor.b(m7286a());
            if (m7286a() != graphQLEvent) {
                graphQLVisitableModel = (GraphQLEventTicketActionLink) ModelHelper.a(null, this);
                graphQLVisitableModel.f3670d = graphQLEvent;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLEventTicketActionLink() {
        super(4);
    }

    public final int m7285a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m7286a());
        int b = flatBufferBuilder.b(m7288j());
        int b2 = flatBufferBuilder.b(m7289k());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLEventTicketActionLink(Parcel parcel) {
        super(4);
        this.f3670d = (GraphQLEvent) parcel.readValue(GraphQLEvent.class.getClassLoader());
        this.f3671e = parcel.readString();
        this.f3672f = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m7286a());
        parcel.writeString(m7288j());
        parcel.writeString(m7289k());
    }
}
