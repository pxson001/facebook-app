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
import com.facebook.graphql.deserializers.GraphQLBoostedComponentActionLinkDeserializer;
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
/* compiled from: is_official */
public final class GraphQLBoostedComponentActionLink extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLBoostedComponentActionLink> CREATOR = new C02751();
    @Nullable
    GraphQLTextWithEntities f3394d;
    @Nullable
    String f3395e;

    /* compiled from: is_official */
    final class C02751 implements Creator<GraphQLBoostedComponentActionLink> {
        C02751() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLBoostedComponentActionLink(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLBoostedComponentActionLink[i];
        }
    }

    /* compiled from: is_official */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLBoostedComponentActionLink.class, new Deserializer());
        }

        public Object m6637a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLBoostedComponentActionLinkDeserializer.m4609a(jsonParser, (short) 280);
            Object graphQLBoostedComponentActionLink = new GraphQLBoostedComponentActionLink();
            ((BaseModel) graphQLBoostedComponentActionLink).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLBoostedComponentActionLink instanceof Postprocessable) {
                return ((Postprocessable) graphQLBoostedComponentActionLink).a();
            }
            return graphQLBoostedComponentActionLink;
        }
    }

    /* compiled from: is_official */
    public final class Serializer extends JsonSerializer<GraphQLBoostedComponentActionLink> {
        public final void m6638a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLBoostedComponentActionLink graphQLBoostedComponentActionLink = (GraphQLBoostedComponentActionLink) obj;
            GraphQLBoostedComponentActionLinkDeserializer.m4610a(graphQLBoostedComponentActionLink.w_(), graphQLBoostedComponentActionLink.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLBoostedComponentActionLink.class, new Serializer());
            FbSerializerProvider.a(GraphQLBoostedComponentActionLink.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m6640a() {
        this.f3394d = (GraphQLTextWithEntities) super.a(this.f3394d, 0, GraphQLTextWithEntities.class);
        return this.f3394d;
    }

    @FieldOffset
    @Nullable
    public final String m6642j() {
        this.f3395e = super.a(this.f3395e, 1);
        return this.f3395e;
    }

    public final int jK_() {
        return -1420114581;
    }

    public final GraphQLVisitableModel m6641a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m6640a() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m6640a());
            if (m6640a() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLBoostedComponentActionLink) ModelHelper.a(null, this);
                graphQLVisitableModel.f3394d = graphQLTextWithEntities;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLBoostedComponentActionLink() {
        super(3);
    }

    public final int m6639a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m6640a());
        int b = flatBufferBuilder.b(m6642j());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLBoostedComponentActionLink(Parcel parcel) {
        super(3);
        this.f3394d = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3395e = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m6640a());
        parcel.writeString(m6642j());
    }
}
