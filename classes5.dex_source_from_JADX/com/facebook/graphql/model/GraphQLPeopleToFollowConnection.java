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
import com.facebook.graphql.deserializers.GraphQLPeopleToFollowConnectionDeserializer;
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
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: WORK_POSITION */
public final class GraphQLPeopleToFollowConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPeopleToFollowConnection> CREATOR = new C11611();
    public List<GraphQLPeopleYouShouldFollowFeedUnitItem> f12438d;

    /* compiled from: WORK_POSITION */
    final class C11611 implements Creator<GraphQLPeopleToFollowConnection> {
        C11611() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLPeopleToFollowConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLPeopleToFollowConnection[i];
        }
    }

    /* compiled from: WORK_POSITION */
    public class Builder extends com.facebook.graphql.modelutil.BaseModel.Builder {
        public ImmutableList<GraphQLPeopleYouShouldFollowFeedUnitItem> f12437d;

        public Builder() {
            Preconditions.checkState(this instanceof Builder);
        }
    }

    /* compiled from: WORK_POSITION */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLPeopleToFollowConnection.class, new Deserializer());
        }

        public Object m20633a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLPeopleToFollowConnectionDeserializer.m5573a(jsonParser, (short) 341);
            Object graphQLPeopleToFollowConnection = new GraphQLPeopleToFollowConnection();
            ((BaseModel) graphQLPeopleToFollowConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLPeopleToFollowConnection instanceof Postprocessable) {
                return ((Postprocessable) graphQLPeopleToFollowConnection).a();
            }
            return graphQLPeopleToFollowConnection;
        }
    }

    /* compiled from: WORK_POSITION */
    public final class Serializer extends JsonSerializer<GraphQLPeopleToFollowConnection> {
        public final void m20634a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLPeopleToFollowConnection graphQLPeopleToFollowConnection = (GraphQLPeopleToFollowConnection) obj;
            GraphQLPeopleToFollowConnectionDeserializer.m5574a(graphQLPeopleToFollowConnection.w_(), graphQLPeopleToFollowConnection.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLPeopleToFollowConnection.class, new Serializer());
            FbSerializerProvider.a(GraphQLPeopleToFollowConnection.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLPeopleYouShouldFollowFeedUnitItem> m20637a() {
        this.f12438d = super.a(this.f12438d, 0, GraphQLPeopleYouShouldFollowFeedUnitItem.class);
        return (ImmutableList) this.f12438d;
    }

    public final int jK_() {
        return -1799121127;
    }

    public final GraphQLVisitableModel m20636a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m20637a() != null) {
            com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m20637a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLPeopleToFollowConnection) ModelHelper.a(null, this);
                graphQLVisitableModel.f12438d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPeopleToFollowConnection() {
        super(2);
    }

    public final int m20635a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m20637a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLPeopleToFollowConnection(Parcel parcel) {
        super(2);
        this.f12438d = ImmutableListHelper.a(parcel.readArrayList(GraphQLPeopleYouShouldFollowFeedUnitItem.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m20637a());
    }

    public GraphQLPeopleToFollowConnection(Builder builder) {
        super(2);
        this.b = builder.a;
        this.c = builder.b;
        this.f12438d = builder.f12437d;
    }
}
