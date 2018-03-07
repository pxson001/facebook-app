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
import com.facebook.graphql.deserializers.GraphQLSideFeedEdgeDeserializer;
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
/* compiled from: VERIFICATION */
public final class GraphQLSideFeedEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLSideFeedEdge> CREATOR = new C12231();
    @Nullable
    public GraphQLSideFeedUnit f13020d;

    /* compiled from: VERIFICATION */
    final class C12231 implements Creator<GraphQLSideFeedEdge> {
        C12231() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLSideFeedEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLSideFeedEdge[i];
        }
    }

    /* compiled from: VERIFICATION */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLSideFeedEdge.class, new Deserializer());
        }

        public Object m21639a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLSideFeedEdgeDeserializer.m5884a(jsonParser, (short) 497);
            Object graphQLSideFeedEdge = new GraphQLSideFeedEdge();
            ((BaseModel) graphQLSideFeedEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLSideFeedEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLSideFeedEdge).a();
            }
            return graphQLSideFeedEdge;
        }
    }

    /* compiled from: VERIFICATION */
    public final class Serializer extends JsonSerializer<GraphQLSideFeedEdge> {
        public final void m21640a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLSideFeedEdge graphQLSideFeedEdge = (GraphQLSideFeedEdge) obj;
            GraphQLSideFeedEdgeDeserializer.m5885b(graphQLSideFeedEdge.w_(), graphQLSideFeedEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLSideFeedEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLSideFeedEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLSideFeedUnit m21642a() {
        this.f13020d = (GraphQLSideFeedUnit) super.a(this.f13020d, 0, GraphQLSideFeedUnit.class);
        return this.f13020d;
    }

    public final int jK_() {
        return 1954092818;
    }

    public final GraphQLVisitableModel m21643a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m21642a() != null) {
            GraphQLSideFeedUnit graphQLSideFeedUnit = (GraphQLSideFeedUnit) graphQLModelMutatingVisitor.b(m21642a());
            if (m21642a() != graphQLSideFeedUnit) {
                graphQLVisitableModel = (GraphQLSideFeedEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f13020d = graphQLSideFeedUnit;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLSideFeedEdge() {
        super(2);
    }

    public final int m21641a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m21642a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLSideFeedEdge(Parcel parcel) {
        super(2);
        this.f13020d = (GraphQLSideFeedUnit) parcel.readValue(GraphQLSideFeedUnit.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m21642a());
    }
}
