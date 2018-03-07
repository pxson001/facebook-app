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
import com.facebook.graphql.deserializers.GraphQLGraphSearchQueryFilterGroupDeserializer;
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
/* compiled from: generator */
public final class GraphQLGraphSearchQueryFilterGroup extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGraphSearchQueryFilterGroup> CREATOR = new C03771();
    @Nullable
    public GraphQLGraphSearchQueryFilter f4087d;

    /* compiled from: generator */
    final class C03771 implements Creator<GraphQLGraphSearchQueryFilterGroup> {
        C03771() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGraphSearchQueryFilterGroup(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGraphSearchQueryFilterGroup[i];
        }
    }

    /* compiled from: generator */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGraphSearchQueryFilterGroup.class, new Deserializer());
        }

        public Object m8226a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGraphSearchQueryFilterGroupDeserializer.m5093a(jsonParser, (short) 472);
            Object graphQLGraphSearchQueryFilterGroup = new GraphQLGraphSearchQueryFilterGroup();
            ((BaseModel) graphQLGraphSearchQueryFilterGroup).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGraphSearchQueryFilterGroup instanceof Postprocessable) {
                return ((Postprocessable) graphQLGraphSearchQueryFilterGroup).a();
            }
            return graphQLGraphSearchQueryFilterGroup;
        }
    }

    /* compiled from: generator */
    public final class Serializer extends JsonSerializer<GraphQLGraphSearchQueryFilterGroup> {
        public final void m8227a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGraphSearchQueryFilterGroup graphQLGraphSearchQueryFilterGroup = (GraphQLGraphSearchQueryFilterGroup) obj;
            GraphQLGraphSearchQueryFilterGroupDeserializer.m5096b(graphQLGraphSearchQueryFilterGroup.w_(), graphQLGraphSearchQueryFilterGroup.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLGraphSearchQueryFilterGroup.class, new Serializer());
            FbSerializerProvider.a(GraphQLGraphSearchQueryFilterGroup.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLGraphSearchQueryFilter m8229a() {
        this.f4087d = (GraphQLGraphSearchQueryFilter) super.a(this.f4087d, 0, GraphQLGraphSearchQueryFilter.class);
        return this.f4087d;
    }

    public final int jK_() {
        return -2147350379;
    }

    public final GraphQLVisitableModel m8230a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m8229a() != null) {
            GraphQLGraphSearchQueryFilter graphQLGraphSearchQueryFilter = (GraphQLGraphSearchQueryFilter) graphQLModelMutatingVisitor.b(m8229a());
            if (m8229a() != graphQLGraphSearchQueryFilter) {
                graphQLVisitableModel = (GraphQLGraphSearchQueryFilterGroup) ModelHelper.a(null, this);
                graphQLVisitableModel.f4087d = graphQLGraphSearchQueryFilter;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLGraphSearchQueryFilterGroup() {
        super(2);
    }

    public final int m8228a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m8229a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGraphSearchQueryFilterGroup(Parcel parcel) {
        super(2);
        this.f4087d = (GraphQLGraphSearchQueryFilter) parcel.readValue(GraphQLGraphSearchQueryFilter.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m8229a());
    }
}
