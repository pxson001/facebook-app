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
import com.facebook.graphql.deserializers.GraphQLGroupConfigurationsConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: friends_count */
public final class GraphQLGroupConfigurationsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGroupConfigurationsConnection> CREATOR = new C03911();
    public List<GraphQLConfiguration> f4191d;

    /* compiled from: friends_count */
    final class C03911 implements Creator<GraphQLGroupConfigurationsConnection> {
        C03911() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGroupConfigurationsConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGroupConfigurationsConnection[i];
        }
    }

    /* compiled from: friends_count */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGroupConfigurationsConnection.class, new Deserializer());
        }

        public Object m8391a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGroupConfigurationsConnectionDeserializer.m5146a(jsonParser, (short) 545);
            Object graphQLGroupConfigurationsConnection = new GraphQLGroupConfigurationsConnection();
            ((BaseModel) graphQLGroupConfigurationsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGroupConfigurationsConnection instanceof Postprocessable) {
                return ((Postprocessable) graphQLGroupConfigurationsConnection).a();
            }
            return graphQLGroupConfigurationsConnection;
        }
    }

    /* compiled from: friends_count */
    public final class Serializer extends JsonSerializer<GraphQLGroupConfigurationsConnection> {
        public final void m8392a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGroupConfigurationsConnection graphQLGroupConfigurationsConnection = (GraphQLGroupConfigurationsConnection) obj;
            GraphQLGroupConfigurationsConnectionDeserializer.m5147a(graphQLGroupConfigurationsConnection.w_(), graphQLGroupConfigurationsConnection.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLGroupConfigurationsConnection.class, new Serializer());
            FbSerializerProvider.a(GraphQLGroupConfigurationsConnection.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLConfiguration> m8395a() {
        this.f4191d = super.a(this.f4191d, 0, GraphQLConfiguration.class);
        return (ImmutableList) this.f4191d;
    }

    public final int jK_() {
        return 1737120378;
    }

    public final GraphQLVisitableModel m8394a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m8395a() != null) {
            Builder a = ModelHelper.a(m8395a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLGroupConfigurationsConnection) ModelHelper.a(null, this);
                graphQLVisitableModel.f4191d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLGroupConfigurationsConnection() {
        super(2);
    }

    public final int m8393a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m8395a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGroupConfigurationsConnection(Parcel parcel) {
        super(2);
        this.f4191d = ImmutableListHelper.a(parcel.readArrayList(GraphQLConfiguration.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m8395a());
    }
}
