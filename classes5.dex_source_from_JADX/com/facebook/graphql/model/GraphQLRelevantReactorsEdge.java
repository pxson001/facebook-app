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
import com.facebook.graphql.deserializers.GraphQLRelevantReactorsEdgeDeserializer;
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
/* compiled from: VIDEO_HOME_SHORTCUT */
public final class GraphQLRelevantReactorsEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLRelevantReactorsEdge> CREATOR = new C12051();
    @Nullable
    public GraphQLFeedbackReactionInfo f12914d;

    /* compiled from: VIDEO_HOME_SHORTCUT */
    final class C12051 implements Creator<GraphQLRelevantReactorsEdge> {
        C12051() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLRelevantReactorsEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLRelevantReactorsEdge[i];
        }
    }

    /* compiled from: VIDEO_HOME_SHORTCUT */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLRelevantReactorsEdge.class, new Deserializer());
        }

        public Object m21390a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLRelevantReactorsEdgeDeserializer.m5808a(jsonParser, (short) 543);
            Object graphQLRelevantReactorsEdge = new GraphQLRelevantReactorsEdge();
            ((BaseModel) graphQLRelevantReactorsEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLRelevantReactorsEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLRelevantReactorsEdge).a();
            }
            return graphQLRelevantReactorsEdge;
        }
    }

    /* compiled from: VIDEO_HOME_SHORTCUT */
    public final class Serializer extends JsonSerializer<GraphQLRelevantReactorsEdge> {
        public final void m21391a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLRelevantReactorsEdge graphQLRelevantReactorsEdge = (GraphQLRelevantReactorsEdge) obj;
            GraphQLRelevantReactorsEdgeDeserializer.m5809b(graphQLRelevantReactorsEdge.w_(), graphQLRelevantReactorsEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLRelevantReactorsEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLRelevantReactorsEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLFeedbackReactionInfo m21393a() {
        this.f12914d = (GraphQLFeedbackReactionInfo) super.a(this.f12914d, 0, GraphQLFeedbackReactionInfo.class);
        return this.f12914d;
    }

    public final int jK_() {
        return 586189259;
    }

    public final GraphQLVisitableModel m21394a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m21393a() != null) {
            GraphQLFeedbackReactionInfo graphQLFeedbackReactionInfo = (GraphQLFeedbackReactionInfo) graphQLModelMutatingVisitor.b(m21393a());
            if (m21393a() != graphQLFeedbackReactionInfo) {
                graphQLVisitableModel = (GraphQLRelevantReactorsEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f12914d = graphQLFeedbackReactionInfo;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLRelevantReactorsEdge() {
        super(2);
    }

    public final int m21392a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m21393a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLRelevantReactorsEdge(Parcel parcel) {
        super(2);
        this.f12914d = (GraphQLFeedbackReactionInfo) parcel.readValue(GraphQLFeedbackReactionInfo.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m21393a());
    }
}
