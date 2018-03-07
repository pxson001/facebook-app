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
import com.facebook.graphql.deserializers.GraphQLStructuredSurveyResponseOptionDeserializer;
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
/* compiled from: URBAN_FARM */
public final class GraphQLStructuredSurveyResponseOption extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLStructuredSurveyResponseOption> CREATOR = new C12451();
    int f13224d;
    @Nullable
    GraphQLTextWithEntities f13225e;
    @Nullable
    String f13226f;

    /* compiled from: URBAN_FARM */
    final class C12451 implements Creator<GraphQLStructuredSurveyResponseOption> {
        C12451() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLStructuredSurveyResponseOption(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLStructuredSurveyResponseOption[i];
        }
    }

    /* compiled from: URBAN_FARM */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLStructuredSurveyResponseOption.class, new Deserializer());
        }

        public Object m21984a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLStructuredSurveyResponseOptionDeserializer.m6010a(jsonParser, (short) 355);
            Object graphQLStructuredSurveyResponseOption = new GraphQLStructuredSurveyResponseOption();
            ((BaseModel) graphQLStructuredSurveyResponseOption).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLStructuredSurveyResponseOption instanceof Postprocessable) {
                return ((Postprocessable) graphQLStructuredSurveyResponseOption).a();
            }
            return graphQLStructuredSurveyResponseOption;
        }
    }

    /* compiled from: URBAN_FARM */
    public final class Serializer extends JsonSerializer<GraphQLStructuredSurveyResponseOption> {
        public final void m21985a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLStructuredSurveyResponseOption graphQLStructuredSurveyResponseOption = (GraphQLStructuredSurveyResponseOption) obj;
            GraphQLStructuredSurveyResponseOptionDeserializer.m6013b(graphQLStructuredSurveyResponseOption.w_(), graphQLStructuredSurveyResponseOption.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLStructuredSurveyResponseOption.class, new Serializer());
            FbSerializerProvider.a(GraphQLStructuredSurveyResponseOption.class, new Serializer());
        }
    }

    @FieldOffset
    public final int m21986a() {
        a(0, 0);
        return this.f13224d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m21990j() {
        this.f13225e = (GraphQLTextWithEntities) super.a(this.f13225e, 1, GraphQLTextWithEntities.class);
        return this.f13225e;
    }

    @FieldOffset
    @Nullable
    public final String m21991k() {
        this.f13226f = super.a(this.f13226f, 2);
        return this.f13226f;
    }

    public final int jK_() {
        return 997036321;
    }

    public final GraphQLVisitableModel m21988a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m21990j() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m21990j());
            if (m21990j() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLStructuredSurveyResponseOption) ModelHelper.a(null, this);
                graphQLVisitableModel.f13225e = graphQLTextWithEntities;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLStructuredSurveyResponseOption() {
        super(4);
    }

    public final void m21989a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f13224d = mutableFlatBuffer.a(i, 0, 0);
    }

    public final int m21987a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m21990j());
        int b = flatBufferBuilder.b(m21991k());
        flatBufferBuilder.c(3);
        flatBufferBuilder.a(0, m21986a(), 0);
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.b(2, b);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLStructuredSurveyResponseOption(Parcel parcel) {
        super(4);
        this.f13224d = parcel.readInt();
        this.f13225e = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f13226f = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m21986a());
        parcel.writeValue(m21990j());
        parcel.writeString(m21991k());
    }
}
