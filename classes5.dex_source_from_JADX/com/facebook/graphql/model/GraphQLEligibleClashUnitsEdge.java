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
import com.facebook.graphql.deserializers.GraphQLEligibleClashUnitsEdgeDeserializer;
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
/* compiled from: ios_creation_v1_with_preform_category_picker */
public final class GraphQLEligibleClashUnitsEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLEligibleClashUnitsEdge> CREATOR = new C02961();
    @Nullable
    public GraphQLClashUnit f3524d;

    /* compiled from: ios_creation_v1_with_preform_category_picker */
    final class C02961 implements Creator<GraphQLEligibleClashUnitsEdge> {
        C02961() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLEligibleClashUnitsEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLEligibleClashUnitsEdge[i];
        }
    }

    /* compiled from: ios_creation_v1_with_preform_category_picker */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLEligibleClashUnitsEdge.class, new Deserializer());
        }

        public Object m6992a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLEligibleClashUnitsEdgeDeserializer.m4732a(jsonParser, (short) 585);
            Object graphQLEligibleClashUnitsEdge = new GraphQLEligibleClashUnitsEdge();
            ((BaseModel) graphQLEligibleClashUnitsEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLEligibleClashUnitsEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLEligibleClashUnitsEdge).a();
            }
            return graphQLEligibleClashUnitsEdge;
        }
    }

    /* compiled from: ios_creation_v1_with_preform_category_picker */
    public final class Serializer extends JsonSerializer<GraphQLEligibleClashUnitsEdge> {
        public final void m6993a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLEligibleClashUnitsEdge graphQLEligibleClashUnitsEdge = (GraphQLEligibleClashUnitsEdge) obj;
            GraphQLEligibleClashUnitsEdgeDeserializer.m4733b(graphQLEligibleClashUnitsEdge.w_(), graphQLEligibleClashUnitsEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLEligibleClashUnitsEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLEligibleClashUnitsEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLClashUnit m6995a() {
        this.f3524d = (GraphQLClashUnit) super.a(this.f3524d, 0, GraphQLClashUnit.class);
        return this.f3524d;
    }

    public final int jK_() {
        return -1795368778;
    }

    public final GraphQLVisitableModel m6996a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m6995a() != null) {
            GraphQLClashUnit graphQLClashUnit = (GraphQLClashUnit) graphQLModelMutatingVisitor.b(m6995a());
            if (m6995a() != graphQLClashUnit) {
                graphQLVisitableModel = (GraphQLEligibleClashUnitsEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f3524d = graphQLClashUnit;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLEligibleClashUnitsEdge() {
        super(2);
    }

    public final int m6994a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m6995a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLEligibleClashUnitsEdge(Parcel parcel) {
        super(2);
        this.f3524d = (GraphQLClashUnit) parcel.readValue(GraphQLClashUnit.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m6995a());
    }
}
