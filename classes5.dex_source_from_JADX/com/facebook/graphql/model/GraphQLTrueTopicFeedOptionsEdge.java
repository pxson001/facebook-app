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
import com.facebook.graphql.deserializers.GraphQLTrueTopicFeedOptionsEdgeDeserializer;
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
/* compiled from: Total wifi power */
public final class GraphQLTrueTopicFeedOptionsEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLTrueTopicFeedOptionsEdge> CREATOR = new C12631();
    @Nullable
    public GraphQLTrueTopicFeedOption f13373d;

    /* compiled from: Total wifi power */
    final class C12631 implements Creator<GraphQLTrueTopicFeedOptionsEdge> {
        C12631() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLTrueTopicFeedOptionsEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLTrueTopicFeedOptionsEdge[i];
        }
    }

    /* compiled from: Total wifi power */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLTrueTopicFeedOptionsEdge.class, new Deserializer());
        }

        public Object m22330a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLTrueTopicFeedOptionsEdgeDeserializer.m6137a(jsonParser, (short) 533);
            Object graphQLTrueTopicFeedOptionsEdge = new GraphQLTrueTopicFeedOptionsEdge();
            ((BaseModel) graphQLTrueTopicFeedOptionsEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLTrueTopicFeedOptionsEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLTrueTopicFeedOptionsEdge).a();
            }
            return graphQLTrueTopicFeedOptionsEdge;
        }
    }

    /* compiled from: Total wifi power */
    public final class Serializer extends JsonSerializer<GraphQLTrueTopicFeedOptionsEdge> {
        public final void m22331a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLTrueTopicFeedOptionsEdge graphQLTrueTopicFeedOptionsEdge = (GraphQLTrueTopicFeedOptionsEdge) obj;
            GraphQLTrueTopicFeedOptionsEdgeDeserializer.m6138b(graphQLTrueTopicFeedOptionsEdge.w_(), graphQLTrueTopicFeedOptionsEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLTrueTopicFeedOptionsEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLTrueTopicFeedOptionsEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLTrueTopicFeedOption m22333a() {
        this.f13373d = (GraphQLTrueTopicFeedOption) super.a(this.f13373d, 0, GraphQLTrueTopicFeedOption.class);
        return this.f13373d;
    }

    public final int jK_() {
        return -979820900;
    }

    public final GraphQLVisitableModel m22334a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m22333a() != null) {
            GraphQLTrueTopicFeedOption graphQLTrueTopicFeedOption = (GraphQLTrueTopicFeedOption) graphQLModelMutatingVisitor.b(m22333a());
            if (m22333a() != graphQLTrueTopicFeedOption) {
                graphQLVisitableModel = (GraphQLTrueTopicFeedOptionsEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f13373d = graphQLTrueTopicFeedOption;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLTrueTopicFeedOptionsEdge() {
        super(2);
    }

    public final int m22332a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m22333a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLTrueTopicFeedOptionsEdge(Parcel parcel) {
        super(2);
        this.f13373d = (GraphQLTrueTopicFeedOption) parcel.readValue(GraphQLTrueTopicFeedOption.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m22333a());
    }
}
