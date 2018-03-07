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
import com.facebook.graphql.deserializers.GraphQLEventCreateActionLinkDeserializer;
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
/* compiled from: input_domain */
public final class GraphQLEventCreateActionLink extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLEventCreateActionLink> CREATOR = new C03081();
    @Nullable
    GraphQLTemporalEventInfo f3626d;
    @Nullable
    String f3627e;
    @Nullable
    String f3628f;

    /* compiled from: input_domain */
    final class C03081 implements Creator<GraphQLEventCreateActionLink> {
        C03081() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLEventCreateActionLink(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLEventCreateActionLink[i];
        }
    }

    /* compiled from: input_domain */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLEventCreateActionLink.class, new Deserializer());
        }

        public Object m7155a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLEventCreateActionLinkDeserializer.m4783a(jsonParser, (short) 175);
            Object graphQLEventCreateActionLink = new GraphQLEventCreateActionLink();
            ((BaseModel) graphQLEventCreateActionLink).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLEventCreateActionLink instanceof Postprocessable) {
                return ((Postprocessable) graphQLEventCreateActionLink).a();
            }
            return graphQLEventCreateActionLink;
        }
    }

    /* compiled from: input_domain */
    public final class Serializer extends JsonSerializer<GraphQLEventCreateActionLink> {
        public final void m7156a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLEventCreateActionLink graphQLEventCreateActionLink = (GraphQLEventCreateActionLink) obj;
            GraphQLEventCreateActionLinkDeserializer.m4784a(graphQLEventCreateActionLink.w_(), graphQLEventCreateActionLink.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLEventCreateActionLink.class, new Serializer());
            FbSerializerProvider.a(GraphQLEventCreateActionLink.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLTemporalEventInfo m7158a() {
        this.f3626d = (GraphQLTemporalEventInfo) super.a(this.f3626d, 0, GraphQLTemporalEventInfo.class);
        return this.f3626d;
    }

    @FieldOffset
    @Nullable
    public final String m7160j() {
        this.f3627e = super.a(this.f3627e, 1);
        return this.f3627e;
    }

    @FieldOffset
    @Nullable
    public final String m7161k() {
        this.f3628f = super.a(this.f3628f, 2);
        return this.f3628f;
    }

    public final int jK_() {
        return -89875450;
    }

    public final GraphQLVisitableModel m7159a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7158a() != null) {
            GraphQLTemporalEventInfo graphQLTemporalEventInfo = (GraphQLTemporalEventInfo) graphQLModelMutatingVisitor.b(m7158a());
            if (m7158a() != graphQLTemporalEventInfo) {
                graphQLVisitableModel = (GraphQLEventCreateActionLink) ModelHelper.a(null, this);
                graphQLVisitableModel.f3626d = graphQLTemporalEventInfo;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLEventCreateActionLink() {
        super(4);
    }

    public final int m7157a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m7158a());
        int b = flatBufferBuilder.b(m7160j());
        int b2 = flatBufferBuilder.b(m7161k());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLEventCreateActionLink(Parcel parcel) {
        super(4);
        this.f3626d = (GraphQLTemporalEventInfo) parcel.readValue(GraphQLTemporalEventInfo.class.getClassLoader());
        this.f3627e = parcel.readString();
        this.f3628f = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m7158a());
        parcel.writeString(m7160j());
        parcel.writeString(m7161k());
    }
}
