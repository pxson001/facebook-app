package com.facebook.survey.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.survey.graphql.StructuredSurveySessionFragmentsModels.StructuredSurveyFlowFragmentModel;
import com.facebook.survey.graphql.StructuredSurveySessionFragmentsParsers.StructuredSurveySessionFragmentParser.SurveyParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = -1938861645)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: direct_next_page_index_int */
public final class C1256x6f03e81b extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
    @Nullable
    private String f17290d;
    @Nullable
    private String f17291e;
    @Nullable
    private StructuredSurveyFlowFragmentModel f17292f;

    /* compiled from: direct_next_page_index_int */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C1256x6f03e81b.class, new Deserializer());
        }

        public Object m25094a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(SurveyParser.m25140a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c1256x6f03e81b = new C1256x6f03e81b();
            ((BaseModel) c1256x6f03e81b).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c1256x6f03e81b instanceof Postprocessable) {
                return ((Postprocessable) c1256x6f03e81b).a();
            }
            return c1256x6f03e81b;
        }
    }

    /* compiled from: direct_next_page_index_int */
    public class Serializer extends JsonSerializer<C1256x6f03e81b> {
        public final void m25095a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C1256x6f03e81b c1256x6f03e81b = (C1256x6f03e81b) obj;
            if (c1256x6f03e81b.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c1256x6f03e81b.m25097a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c1256x6f03e81b.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            SurveyParser.m25141a(c1256x6f03e81b.w_(), c1256x6f03e81b.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(C1256x6f03e81b.class, new Serializer());
        }
    }

    public C1256x6f03e81b() {
        super(3);
    }

    @Nullable
    public final String m25100j() {
        this.f17290d = super.a(this.f17290d, 0);
        return this.f17290d;
    }

    @Nullable
    private String m25096l() {
        this.f17291e = super.a(this.f17291e, 1);
        return this.f17291e;
    }

    @Nullable
    public final StructuredSurveyFlowFragmentModel m25101k() {
        this.f17292f = (StructuredSurveyFlowFragmentModel) super.a(this.f17292f, 2, StructuredSurveyFlowFragmentModel.class);
        return this.f17292f;
    }

    @Nullable
    public final String m25099a() {
        return m25100j();
    }

    public final int jK_() {
        return -943106005;
    }

    public final GraphQLVisitableModel m25098a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m25101k() != null) {
            StructuredSurveyFlowFragmentModel structuredSurveyFlowFragmentModel = (StructuredSurveyFlowFragmentModel) graphQLModelMutatingVisitor.b(m25101k());
            if (m25101k() != structuredSurveyFlowFragmentModel) {
                graphQLVisitableModel = (C1256x6f03e81b) ModelHelper.a(null, this);
                graphQLVisitableModel.f17292f = structuredSurveyFlowFragmentModel;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m25097a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m25100j());
        int b2 = flatBufferBuilder.b(m25096l());
        int a = ModelHelper.a(flatBufferBuilder, m25101k());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        flatBufferBuilder.b(2, a);
        i();
        return flatBufferBuilder.d();
    }
}
