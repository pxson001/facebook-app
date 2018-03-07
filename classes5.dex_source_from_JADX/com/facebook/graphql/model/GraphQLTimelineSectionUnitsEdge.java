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
import com.facebook.graphql.deserializers.GraphQLTimelineSectionUnitsEdgeDeserializer;
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
import com.google.common.base.Preconditions;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: UNHIGHLIGHT_RICH_NOTIF */
public final class GraphQLTimelineSectionUnitsEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLTimelineSectionUnitsEdge> CREATOR = new C12561();
    @Nullable
    String f13347d;
    @Nullable
    FeedUnit f13348e;
    @Nullable
    String f13349f;

    /* compiled from: UNHIGHLIGHT_RICH_NOTIF */
    final class C12561 implements Creator<GraphQLTimelineSectionUnitsEdge> {
        C12561() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLTimelineSectionUnitsEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLTimelineSectionUnitsEdge[i];
        }
    }

    /* compiled from: UNHIGHLIGHT_RICH_NOTIF */
    public class Builder extends com.facebook.graphql.modelutil.BaseModel.Builder {
        @Nullable
        public String f13344d;
        @Nullable
        public FeedUnit f13345e;
        @Nullable
        public String f13346f;

        public Builder() {
            Preconditions.checkState(this instanceof Builder);
        }
    }

    /* compiled from: UNHIGHLIGHT_RICH_NOTIF */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLTimelineSectionUnitsEdge.class, new Deserializer());
        }

        public Object m22205a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLTimelineSectionUnitsEdgeDeserializer.m6090a(jsonParser, (short) 466);
            Object graphQLTimelineSectionUnitsEdge = new GraphQLTimelineSectionUnitsEdge();
            ((BaseModel) graphQLTimelineSectionUnitsEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLTimelineSectionUnitsEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLTimelineSectionUnitsEdge).a();
            }
            return graphQLTimelineSectionUnitsEdge;
        }
    }

    /* compiled from: UNHIGHLIGHT_RICH_NOTIF */
    public final class Serializer extends JsonSerializer<GraphQLTimelineSectionUnitsEdge> {
        public final void m22206a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLTimelineSectionUnitsEdge graphQLTimelineSectionUnitsEdge = (GraphQLTimelineSectionUnitsEdge) obj;
            GraphQLTimelineSectionUnitsEdgeDeserializer.m6091b(graphQLTimelineSectionUnitsEdge.w_(), graphQLTimelineSectionUnitsEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLTimelineSectionUnitsEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLTimelineSectionUnitsEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m22209a() {
        this.f13347d = super.a(this.f13347d, 0);
        return this.f13347d;
    }

    @FieldOffset
    @Nullable
    public final FeedUnit m22210j() {
        this.f13348e = (FeedUnit) super.a(this.f13348e, 1, VirtualFlattenableResolverImpl.a);
        return this.f13348e;
    }

    @FieldOffset
    @Nullable
    public final String m22211k() {
        this.f13349f = super.a(this.f13349f, 2);
        return this.f13349f;
    }

    public final int jK_() {
        return -941287704;
    }

    public final GraphQLVisitableModel m22208a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m22210j() != null) {
            FeedUnit feedUnit = (FeedUnit) graphQLModelMutatingVisitor.b(m22210j());
            if (m22210j() != feedUnit) {
                graphQLVisitableModel = (GraphQLTimelineSectionUnitsEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f13348e = feedUnit;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLTimelineSectionUnitsEdge() {
        super(4);
    }

    public final int m22207a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m22209a());
        int a = flatBufferBuilder.a(m22210j(), VirtualFlattenableResolverImpl.a);
        int b2 = flatBufferBuilder.b(m22211k());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.b(2, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLTimelineSectionUnitsEdge(Parcel parcel) {
        super(4);
        this.f13347d = parcel.readString();
        this.f13348e = (FeedUnit) parcel.readValue(FeedUnit.class.getClassLoader());
        this.f13349f = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m22209a());
        parcel.writeValue(m22210j());
        parcel.writeString(m22211k());
    }

    public GraphQLTimelineSectionUnitsEdge(Builder builder) {
        super(4);
        this.b = builder.a;
        this.c = builder.b;
        this.f13347d = builder.f13344d;
        this.f13348e = builder.f13345e;
        this.f13349f = builder.f13346f;
    }
}
