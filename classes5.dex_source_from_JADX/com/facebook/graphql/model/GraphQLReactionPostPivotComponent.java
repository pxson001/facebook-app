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
import com.facebook.graphql.deserializers.GraphQLReactionPostPivotComponentDeserializer;
import com.facebook.graphql.enums.GraphQLReactionUnitComponentStyle;
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
/* compiled from: VIEWER_FAVORITED */
public final class GraphQLReactionPostPivotComponent extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLReactionPostPivotComponent> CREATOR = new C12021();
    @Nullable
    public String f12884d;
    public GraphQLReactionUnitComponentStyle f12885e;
    @Nullable
    public String f12886f;
    @Nullable
    public GraphQLTextWithEntities f12887g;

    /* compiled from: VIEWER_FAVORITED */
    final class C12021 implements Creator<GraphQLReactionPostPivotComponent> {
        C12021() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLReactionPostPivotComponent(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLReactionPostPivotComponent[i];
        }
    }

    /* compiled from: VIEWER_FAVORITED */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLReactionPostPivotComponent.class, new Deserializer());
        }

        public Object m21312a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLReactionPostPivotComponentDeserializer.m5782a(jsonParser, (short) 510);
            Object graphQLReactionPostPivotComponent = new GraphQLReactionPostPivotComponent();
            ((BaseModel) graphQLReactionPostPivotComponent).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLReactionPostPivotComponent instanceof Postprocessable) {
                return ((Postprocessable) graphQLReactionPostPivotComponent).a();
            }
            return graphQLReactionPostPivotComponent;
        }
    }

    /* compiled from: VIEWER_FAVORITED */
    public final class Serializer extends JsonSerializer<GraphQLReactionPostPivotComponent> {
        public final void m21313a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLReactionPostPivotComponent graphQLReactionPostPivotComponent = (GraphQLReactionPostPivotComponent) obj;
            GraphQLReactionPostPivotComponentDeserializer.m5783a(graphQLReactionPostPivotComponent.w_(), graphQLReactionPostPivotComponent.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLReactionPostPivotComponent.class, new Serializer());
            FbSerializerProvider.a(GraphQLReactionPostPivotComponent.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m21316a() {
        this.f12884d = super.a(this.f12884d, 0);
        return this.f12884d;
    }

    @FieldOffset
    public final GraphQLReactionUnitComponentStyle m21317j() {
        this.f12885e = (GraphQLReactionUnitComponentStyle) super.a(this.f12885e, 1, GraphQLReactionUnitComponentStyle.class, GraphQLReactionUnitComponentStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f12885e;
    }

    @FieldOffset
    @Nullable
    public final String m21318k() {
        this.f12886f = super.a(this.f12886f, 2);
        return this.f12886f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m21319l() {
        this.f12887g = (GraphQLTextWithEntities) super.a(this.f12887g, 3, GraphQLTextWithEntities.class);
        return this.f12887g;
    }

    public final int jK_() {
        return -1497808444;
    }

    public final GraphQLVisitableModel m21315a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m21319l() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m21319l());
            if (m21319l() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLReactionPostPivotComponent) ModelHelper.a(null, this);
                graphQLVisitableModel.f12887g = graphQLTextWithEntities;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLReactionPostPivotComponent() {
        super(5);
    }

    public final int m21314a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m21316a());
        int b2 = flatBufferBuilder.b(m21318k());
        int a = ModelHelper.a(flatBufferBuilder, m21319l());
        flatBufferBuilder.c(4);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.a(1, m21317j() == GraphQLReactionUnitComponentStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m21317j());
        flatBufferBuilder.b(2, b2);
        flatBufferBuilder.b(3, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLReactionPostPivotComponent(Parcel parcel) {
        super(5);
        this.f12884d = parcel.readString();
        this.f12885e = GraphQLReactionUnitComponentStyle.fromString(parcel.readString());
        this.f12886f = parcel.readString();
        this.f12887g = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m21316a());
        parcel.writeString(m21317j().name());
        parcel.writeString(m21318k());
        parcel.writeValue(m21319l());
    }
}
