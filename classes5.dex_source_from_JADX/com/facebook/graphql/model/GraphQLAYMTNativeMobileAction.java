package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLAYMTNativeMobileActionDeserializer;
import com.facebook.graphql.enums.GraphQLObjectType;
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
/* compiled from: layout_params */
public final class GraphQLAYMTNativeMobileAction extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLAYMTNativeMobileAction> CREATOR = new C02551();
    @Nullable
    GraphQLObjectType f3258d;
    @Nullable
    GraphQLTextWithEntities f3259e;
    @Nullable
    String f3260f;

    /* compiled from: layout_params */
    final class C02551 implements Creator<GraphQLAYMTNativeMobileAction> {
        C02551() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLAYMTNativeMobileAction(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLAYMTNativeMobileAction[i];
        }
    }

    /* compiled from: layout_params */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLAYMTNativeMobileAction.class, new Deserializer());
        }

        public Object m6356a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLAYMTNativeMobileActionDeserializer.m4509a(jsonParser, (short) 504);
            Object graphQLAYMTNativeMobileAction = new GraphQLAYMTNativeMobileAction();
            ((BaseModel) graphQLAYMTNativeMobileAction).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLAYMTNativeMobileAction instanceof Postprocessable) {
                return ((Postprocessable) graphQLAYMTNativeMobileAction).a();
            }
            return graphQLAYMTNativeMobileAction;
        }
    }

    /* compiled from: layout_params */
    public final class Serializer extends JsonSerializer<GraphQLAYMTNativeMobileAction> {
        public final void m6357a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLAYMTNativeMobileAction graphQLAYMTNativeMobileAction = (GraphQLAYMTNativeMobileAction) obj;
            GraphQLAYMTNativeMobileActionDeserializer.m4510a(graphQLAYMTNativeMobileAction.w_(), graphQLAYMTNativeMobileAction.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLAYMTNativeMobileAction.class, new Serializer());
            FbSerializerProvider.a(GraphQLAYMTNativeMobileAction.class, new Serializer());
        }
    }

    @Nullable
    public final GraphQLObjectType m6359a() {
        if (this.b != null && this.f3258d == null) {
            this.f3258d = new GraphQLObjectType(this.b.b(this.c, 0));
        }
        if (this.f3258d == null || this.f3258d.g() != 0) {
            return this.f3258d;
        }
        return null;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m6361j() {
        this.f3259e = (GraphQLTextWithEntities) super.a(this.f3259e, 1, GraphQLTextWithEntities.class);
        return this.f3259e;
    }

    @FieldOffset
    @Nullable
    public final String m6362k() {
        this.f3260f = super.a(this.f3260f, 2);
        return this.f3260f;
    }

    public final int jK_() {
        return -960841362;
    }

    public final GraphQLVisitableModel m6360a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m6361j() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m6361j());
            if (m6361j() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLAYMTNativeMobileAction) ModelHelper.a(null, this);
                graphQLVisitableModel.f3259e = graphQLTextWithEntities;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLAYMTNativeMobileAction() {
        super(4);
    }

    public final int m6358a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = flatBufferBuilder.a(m6359a() != null ? m6359a().e() : null);
        int a2 = ModelHelper.a(flatBufferBuilder, m6361j());
        int b = flatBufferBuilder.b(m6362k());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.b(2, b);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLAYMTNativeMobileAction(Parcel parcel) {
        super(4);
        this.f3259e = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3260f = parcel.readString();
        this.f3258d = (GraphQLObjectType) ParcelUtil.m3828b(parcel, GraphQLObjectType.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m6361j());
        parcel.writeString(m6362k());
        parcel.writeParcelable(this.f3258d, i);
    }
}
