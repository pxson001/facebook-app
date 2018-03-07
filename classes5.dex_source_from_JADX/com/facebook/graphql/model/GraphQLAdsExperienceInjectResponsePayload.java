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
import com.facebook.graphql.deserializers.GraphQLAdsExperienceInjectResponsePayloadDeserializer;
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
/* compiled from: key_hashes */
public final class GraphQLAdsExperienceInjectResponsePayload extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLAdsExperienceInjectResponsePayload> CREATOR = new C02611();
    public boolean f3308d;
    @Nullable
    public GraphQLViewer f3309e;

    /* compiled from: key_hashes */
    final class C02611 implements Creator<GraphQLAdsExperienceInjectResponsePayload> {
        C02611() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLAdsExperienceInjectResponsePayload(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLAdsExperienceInjectResponsePayload[i];
        }
    }

    /* compiled from: key_hashes */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLAdsExperienceInjectResponsePayload.class, new Deserializer());
        }

        public Object m6471a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLAdsExperienceInjectResponsePayloadDeserializer.m4538a(jsonParser, (short) 577);
            Object graphQLAdsExperienceInjectResponsePayload = new GraphQLAdsExperienceInjectResponsePayload();
            ((BaseModel) graphQLAdsExperienceInjectResponsePayload).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLAdsExperienceInjectResponsePayload instanceof Postprocessable) {
                return ((Postprocessable) graphQLAdsExperienceInjectResponsePayload).a();
            }
            return graphQLAdsExperienceInjectResponsePayload;
        }
    }

    /* compiled from: key_hashes */
    public final class Serializer extends JsonSerializer<GraphQLAdsExperienceInjectResponsePayload> {
        public final void m6472a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLAdsExperienceInjectResponsePayload graphQLAdsExperienceInjectResponsePayload = (GraphQLAdsExperienceInjectResponsePayload) obj;
            GraphQLAdsExperienceInjectResponsePayloadDeserializer.m4539a(graphQLAdsExperienceInjectResponsePayload.w_(), graphQLAdsExperienceInjectResponsePayload.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLAdsExperienceInjectResponsePayload.class, new Serializer());
            FbSerializerProvider.a(GraphQLAdsExperienceInjectResponsePayload.class, new Serializer());
        }
    }

    @FieldOffset
    public final boolean m6476a() {
        a(0, 0);
        return this.f3308d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLViewer m6477j() {
        this.f3309e = (GraphQLViewer) super.a(this.f3309e, 1, GraphQLViewer.class);
        return this.f3309e;
    }

    public final int jK_() {
        return 1443800642;
    }

    public final GraphQLVisitableModel m6474a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m6477j() != null) {
            GraphQLViewer graphQLViewer = (GraphQLViewer) graphQLModelMutatingVisitor.b(m6477j());
            if (m6477j() != graphQLViewer) {
                graphQLVisitableModel = (GraphQLAdsExperienceInjectResponsePayload) ModelHelper.a(null, this);
                graphQLVisitableModel.f3309e = graphQLViewer;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLAdsExperienceInjectResponsePayload() {
        super(3);
    }

    public final void m6475a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f3308d = mutableFlatBuffer.a(i, 0);
    }

    public final int m6473a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m6477j());
        flatBufferBuilder.c(2);
        flatBufferBuilder.a(0, m6476a());
        flatBufferBuilder.b(1, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLAdsExperienceInjectResponsePayload(Parcel parcel) {
        boolean z = true;
        super(3);
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f3308d = z;
        this.f3309e = (GraphQLViewer) parcel.readValue(GraphQLViewer.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (m6476a() ? 1 : 0));
        parcel.writeValue(m6477j());
    }
}
