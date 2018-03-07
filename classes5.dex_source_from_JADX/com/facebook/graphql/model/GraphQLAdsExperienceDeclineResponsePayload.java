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
import com.facebook.graphql.deserializers.GraphQLAdsExperienceDeclineResponsePayloadDeserializer;
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
/* compiled from: keywords_suggestions */
public final class GraphQLAdsExperienceDeclineResponsePayload extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLAdsExperienceDeclineResponsePayload> CREATOR = new C02601();
    @Nullable
    public GraphQLViewer f3307d;

    /* compiled from: keywords_suggestions */
    final class C02601 implements Creator<GraphQLAdsExperienceDeclineResponsePayload> {
        C02601() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLAdsExperienceDeclineResponsePayload(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLAdsExperienceDeclineResponsePayload[i];
        }
    }

    /* compiled from: keywords_suggestions */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLAdsExperienceDeclineResponsePayload.class, new Deserializer());
        }

        public Object m6464a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLAdsExperienceDeclineResponsePayloadDeserializer.m4535a(jsonParser, (short) 578);
            Object graphQLAdsExperienceDeclineResponsePayload = new GraphQLAdsExperienceDeclineResponsePayload();
            ((BaseModel) graphQLAdsExperienceDeclineResponsePayload).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLAdsExperienceDeclineResponsePayload instanceof Postprocessable) {
                return ((Postprocessable) graphQLAdsExperienceDeclineResponsePayload).a();
            }
            return graphQLAdsExperienceDeclineResponsePayload;
        }
    }

    /* compiled from: keywords_suggestions */
    public final class Serializer extends JsonSerializer<GraphQLAdsExperienceDeclineResponsePayload> {
        public final void m6465a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLAdsExperienceDeclineResponsePayload graphQLAdsExperienceDeclineResponsePayload = (GraphQLAdsExperienceDeclineResponsePayload) obj;
            GraphQLAdsExperienceDeclineResponsePayloadDeserializer.m4536a(graphQLAdsExperienceDeclineResponsePayload.w_(), graphQLAdsExperienceDeclineResponsePayload.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLAdsExperienceDeclineResponsePayload.class, new Serializer());
            FbSerializerProvider.a(GraphQLAdsExperienceDeclineResponsePayload.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLViewer m6467a() {
        this.f3307d = (GraphQLViewer) super.a(this.f3307d, 0, GraphQLViewer.class);
        return this.f3307d;
    }

    public final int jK_() {
        return -1405283599;
    }

    public final GraphQLVisitableModel m6468a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m6467a() != null) {
            GraphQLViewer graphQLViewer = (GraphQLViewer) graphQLModelMutatingVisitor.b(m6467a());
            if (m6467a() != graphQLViewer) {
                graphQLVisitableModel = (GraphQLAdsExperienceDeclineResponsePayload) ModelHelper.a(null, this);
                graphQLVisitableModel.f3307d = graphQLViewer;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLAdsExperienceDeclineResponsePayload() {
        super(2);
    }

    public final int m6466a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m6467a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLAdsExperienceDeclineResponsePayload(Parcel parcel) {
        super(2);
        this.f3307d = (GraphQLViewer) parcel.readValue(GraphQLViewer.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m6467a());
    }
}
