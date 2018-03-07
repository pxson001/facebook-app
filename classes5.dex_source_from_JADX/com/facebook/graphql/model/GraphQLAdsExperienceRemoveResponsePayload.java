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
import com.facebook.graphql.deserializers.GraphQLAdsExperienceRemoveResponsePayloadDeserializer;
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
/* compiled from: keyFlattener */
public final class GraphQLAdsExperienceRemoveResponsePayload extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLAdsExperienceRemoveResponsePayload> CREATOR = new C02621();
    @Nullable
    public GraphQLViewer f3310d;

    /* compiled from: keyFlattener */
    final class C02621 implements Creator<GraphQLAdsExperienceRemoveResponsePayload> {
        C02621() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLAdsExperienceRemoveResponsePayload(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLAdsExperienceRemoveResponsePayload[i];
        }
    }

    /* compiled from: keyFlattener */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLAdsExperienceRemoveResponsePayload.class, new Deserializer());
        }

        public Object m6480a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLAdsExperienceRemoveResponsePayloadDeserializer.m4541a(jsonParser, (short) 579);
            Object graphQLAdsExperienceRemoveResponsePayload = new GraphQLAdsExperienceRemoveResponsePayload();
            ((BaseModel) graphQLAdsExperienceRemoveResponsePayload).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLAdsExperienceRemoveResponsePayload instanceof Postprocessable) {
                return ((Postprocessable) graphQLAdsExperienceRemoveResponsePayload).a();
            }
            return graphQLAdsExperienceRemoveResponsePayload;
        }
    }

    /* compiled from: keyFlattener */
    public final class Serializer extends JsonSerializer<GraphQLAdsExperienceRemoveResponsePayload> {
        public final void m6481a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLAdsExperienceRemoveResponsePayload graphQLAdsExperienceRemoveResponsePayload = (GraphQLAdsExperienceRemoveResponsePayload) obj;
            GraphQLAdsExperienceRemoveResponsePayloadDeserializer.m4542a(graphQLAdsExperienceRemoveResponsePayload.w_(), graphQLAdsExperienceRemoveResponsePayload.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLAdsExperienceRemoveResponsePayload.class, new Serializer());
            FbSerializerProvider.a(GraphQLAdsExperienceRemoveResponsePayload.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLViewer m6483a() {
        this.f3310d = (GraphQLViewer) super.a(this.f3310d, 0, GraphQLViewer.class);
        return this.f3310d;
    }

    public final int jK_() {
        return 2122330863;
    }

    public final GraphQLVisitableModel m6484a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m6483a() != null) {
            GraphQLViewer graphQLViewer = (GraphQLViewer) graphQLModelMutatingVisitor.b(m6483a());
            if (m6483a() != graphQLViewer) {
                graphQLVisitableModel = (GraphQLAdsExperienceRemoveResponsePayload) ModelHelper.a(null, this);
                graphQLVisitableModel.f3310d = graphQLViewer;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLAdsExperienceRemoveResponsePayload() {
        super(2);
    }

    public final int m6482a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m6483a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLAdsExperienceRemoveResponsePayload(Parcel parcel) {
        super(2);
        this.f3310d = (GraphQLViewer) parcel.readValue(GraphQLViewer.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m6483a());
    }
}
