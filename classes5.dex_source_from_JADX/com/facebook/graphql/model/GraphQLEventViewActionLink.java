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
import com.facebook.graphql.deserializers.GraphQLEventViewActionLinkDeserializer;
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
/* compiled from: imageVideoThumbnail */
public final class GraphQLEventViewActionLink extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLEventViewActionLink> CREATOR = new C03171();
    @Nullable
    GraphQLEvent f3674d;
    @Nullable
    String f3675e;
    @Nullable
    String f3676f;

    /* compiled from: imageVideoThumbnail */
    final class C03171 implements Creator<GraphQLEventViewActionLink> {
        C03171() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLEventViewActionLink(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLEventViewActionLink[i];
        }
    }

    /* compiled from: imageVideoThumbnail */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLEventViewActionLink.class, new Deserializer());
        }

        public Object m7312a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLEventViewActionLinkDeserializer.m4840a(jsonParser, (short) 526);
            Object graphQLEventViewActionLink = new GraphQLEventViewActionLink();
            ((BaseModel) graphQLEventViewActionLink).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLEventViewActionLink instanceof Postprocessable) {
                return ((Postprocessable) graphQLEventViewActionLink).a();
            }
            return graphQLEventViewActionLink;
        }
    }

    /* compiled from: imageVideoThumbnail */
    public final class Serializer extends JsonSerializer<GraphQLEventViewActionLink> {
        public final void m7313a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLEventViewActionLink graphQLEventViewActionLink = (GraphQLEventViewActionLink) obj;
            GraphQLEventViewActionLinkDeserializer.m4841a(graphQLEventViewActionLink.w_(), graphQLEventViewActionLink.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLEventViewActionLink.class, new Serializer());
            FbSerializerProvider.a(GraphQLEventViewActionLink.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLEvent m7315a() {
        this.f3674d = (GraphQLEvent) super.a(this.f3674d, 0, GraphQLEvent.class);
        return this.f3674d;
    }

    @FieldOffset
    @Nullable
    public final String m7317j() {
        this.f3675e = super.a(this.f3675e, 1);
        return this.f3675e;
    }

    @FieldOffset
    @Nullable
    public final String m7318k() {
        this.f3676f = super.a(this.f3676f, 2);
        return this.f3676f;
    }

    public final int jK_() {
        return 1511838959;
    }

    public final GraphQLVisitableModel m7316a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7315a() != null) {
            GraphQLEvent graphQLEvent = (GraphQLEvent) graphQLModelMutatingVisitor.b(m7315a());
            if (m7315a() != graphQLEvent) {
                graphQLVisitableModel = (GraphQLEventViewActionLink) ModelHelper.a(null, this);
                graphQLVisitableModel.f3674d = graphQLEvent;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLEventViewActionLink() {
        super(4);
    }

    public final int m7314a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m7315a());
        int b = flatBufferBuilder.b(m7317j());
        int b2 = flatBufferBuilder.b(m7318k());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLEventViewActionLink(Parcel parcel) {
        super(4);
        this.f3674d = (GraphQLEvent) parcel.readValue(GraphQLEvent.class.getClassLoader());
        this.f3675e = parcel.readString();
        this.f3676f = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m7315a());
        parcel.writeString(m7317j());
        parcel.writeString(m7318k());
    }
}
