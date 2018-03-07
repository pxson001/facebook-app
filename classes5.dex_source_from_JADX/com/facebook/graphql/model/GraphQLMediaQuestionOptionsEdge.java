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
import com.facebook.graphql.deserializers.GraphQLMediaQuestionOptionsEdgeDeserializer;
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
/* compiled from: fb power is  */
public final class GraphQLMediaQuestionOptionsEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLMediaQuestionOptionsEdge> CREATOR = new C04341();
    @Nullable
    public GraphQLMediaQuestionOption f4486d;

    /* compiled from: fb power is  */
    final class C04341 implements Creator<GraphQLMediaQuestionOptionsEdge> {
        C04341() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLMediaQuestionOptionsEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLMediaQuestionOptionsEdge[i];
        }
    }

    /* compiled from: fb power is  */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLMediaQuestionOptionsEdge.class, new Deserializer());
        }

        public Object m9051a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLMediaQuestionOptionsEdgeDeserializer.m5353a(jsonParser, (short) 232);
            Object graphQLMediaQuestionOptionsEdge = new GraphQLMediaQuestionOptionsEdge();
            ((BaseModel) graphQLMediaQuestionOptionsEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLMediaQuestionOptionsEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLMediaQuestionOptionsEdge).a();
            }
            return graphQLMediaQuestionOptionsEdge;
        }
    }

    /* compiled from: fb power is  */
    public final class Serializer extends JsonSerializer<GraphQLMediaQuestionOptionsEdge> {
        public final void m9052a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLMediaQuestionOptionsEdge graphQLMediaQuestionOptionsEdge = (GraphQLMediaQuestionOptionsEdge) obj;
            GraphQLMediaQuestionOptionsEdgeDeserializer.m5354b(graphQLMediaQuestionOptionsEdge.w_(), graphQLMediaQuestionOptionsEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLMediaQuestionOptionsEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLMediaQuestionOptionsEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLMediaQuestionOption m9054a() {
        this.f4486d = (GraphQLMediaQuestionOption) super.a(this.f4486d, 0, GraphQLMediaQuestionOption.class);
        return this.f4486d;
    }

    public final int jK_() {
        return 34542417;
    }

    public final GraphQLVisitableModel m9055a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m9054a() != null) {
            GraphQLMediaQuestionOption graphQLMediaQuestionOption = (GraphQLMediaQuestionOption) graphQLModelMutatingVisitor.b(m9054a());
            if (m9054a() != graphQLMediaQuestionOption) {
                graphQLVisitableModel = (GraphQLMediaQuestionOptionsEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f4486d = graphQLMediaQuestionOption;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLMediaQuestionOptionsEdge() {
        super(2);
    }

    public final int m9053a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m9054a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLMediaQuestionOptionsEdge(Parcel parcel) {
        super(2);
        this.f4486d = (GraphQLMediaQuestionOption) parcel.readValue(GraphQLMediaQuestionOption.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m9054a());
    }
}
