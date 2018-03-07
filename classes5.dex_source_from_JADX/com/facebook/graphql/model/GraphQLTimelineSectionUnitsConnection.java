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
import com.facebook.graphql.deserializers.GraphQLTimelineSectionUnitsConnectionDeserializer;
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
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: UNIQUE */
public final class GraphQLTimelineSectionUnitsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLTimelineSectionUnitsConnection> CREATOR = new C12551();
    public List<GraphQLTimelineSectionUnitsEdge> f13342d;
    @Nullable
    public GraphQLPageInfo f13343e;

    /* compiled from: UNIQUE */
    final class C12551 implements Creator<GraphQLTimelineSectionUnitsConnection> {
        C12551() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLTimelineSectionUnitsConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLTimelineSectionUnitsConnection[i];
        }
    }

    /* compiled from: UNIQUE */
    public class Builder extends com.facebook.graphql.modelutil.BaseModel.Builder {
        public ImmutableList<GraphQLTimelineSectionUnitsEdge> f13340d;
        @Nullable
        public GraphQLPageInfo f13341e;

        public Builder() {
            Preconditions.checkState(this instanceof Builder);
        }
    }

    /* compiled from: UNIQUE */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLTimelineSectionUnitsConnection.class, new Deserializer());
        }

        public Object m22195a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLTimelineSectionUnitsConnectionDeserializer.m6087a(jsonParser, (short) 465);
            Object graphQLTimelineSectionUnitsConnection = new GraphQLTimelineSectionUnitsConnection();
            ((BaseModel) graphQLTimelineSectionUnitsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLTimelineSectionUnitsConnection instanceof Postprocessable) {
                return ((Postprocessable) graphQLTimelineSectionUnitsConnection).a();
            }
            return graphQLTimelineSectionUnitsConnection;
        }
    }

    /* compiled from: UNIQUE */
    public final class Serializer extends JsonSerializer<GraphQLTimelineSectionUnitsConnection> {
        public final void m22196a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLTimelineSectionUnitsConnection graphQLTimelineSectionUnitsConnection = (GraphQLTimelineSectionUnitsConnection) obj;
            GraphQLTimelineSectionUnitsConnectionDeserializer.m6088a(graphQLTimelineSectionUnitsConnection.w_(), graphQLTimelineSectionUnitsConnection.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLTimelineSectionUnitsConnection.class, new Serializer());
            FbSerializerProvider.a(GraphQLTimelineSectionUnitsConnection.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLTimelineSectionUnitsEdge> m22199a() {
        this.f13342d = super.a(this.f13342d, 0, GraphQLTimelineSectionUnitsEdge.class);
        return (ImmutableList) this.f13342d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m22200j() {
        this.f13343e = (GraphQLPageInfo) super.a(this.f13343e, 1, GraphQLPageInfo.class);
        return this.f13343e;
    }

    public final int jK_() {
        return 495147977;
    }

    public final GraphQLVisitableModel m22198a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLPageInfo graphQLPageInfo;
        h();
        if (m22199a() != null) {
            com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m22199a(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLTimelineSectionUnitsConnection graphQLTimelineSectionUnitsConnection = (GraphQLTimelineSectionUnitsConnection) ModelHelper.a(null, this);
                graphQLTimelineSectionUnitsConnection.f13342d = a.b();
                graphQLVisitableModel = graphQLTimelineSectionUnitsConnection;
                if (m22200j() != null) {
                    graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.b(m22200j());
                    if (m22200j() != graphQLPageInfo) {
                        graphQLVisitableModel = (GraphQLTimelineSectionUnitsConnection) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f13343e = graphQLPageInfo;
                    }
                }
                i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m22200j() != null) {
            graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.b(m22200j());
            if (m22200j() != graphQLPageInfo) {
                graphQLVisitableModel = (GraphQLTimelineSectionUnitsConnection) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13343e = graphQLPageInfo;
            }
        }
        i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLTimelineSectionUnitsConnection() {
        super(3);
    }

    public final int m22197a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m22199a());
        int a2 = ModelHelper.a(flatBufferBuilder, m22200j());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLTimelineSectionUnitsConnection(Parcel parcel) {
        super(3);
        this.f13342d = ImmutableListHelper.a(parcel.readArrayList(GraphQLTimelineSectionUnitsEdge.class.getClassLoader()));
        this.f13343e = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m22199a());
        parcel.writeValue(m22200j());
    }

    public GraphQLTimelineSectionUnitsConnection(Builder builder) {
        super(3);
        this.b = builder.a;
        this.c = builder.b;
        this.f13342d = builder.f13340d;
        this.f13343e = builder.f13341e;
    }
}
