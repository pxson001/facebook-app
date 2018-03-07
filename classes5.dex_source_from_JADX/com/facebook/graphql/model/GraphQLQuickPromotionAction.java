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
import com.facebook.graphql.deserializers.GraphQLQuickPromotionActionDeserializer;
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
/* compiled from: VIEW_PHOTO_MENU */
public final class GraphQLQuickPromotionAction extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLQuickPromotionAction> CREATOR = new C11921();
    @Nullable
    GraphQLTextWithEntities f12847d;
    @Nullable
    String f12848e;

    /* compiled from: VIEW_PHOTO_MENU */
    final class C11921 implements Creator<GraphQLQuickPromotionAction> {
        C11921() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLQuickPromotionAction(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLQuickPromotionAction[i];
        }
    }

    /* compiled from: VIEW_PHOTO_MENU */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLQuickPromotionAction.class, new Deserializer());
        }

        public Object m21202a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLQuickPromotionActionDeserializer.m5744a(jsonParser, (short) 363);
            Object graphQLQuickPromotionAction = new GraphQLQuickPromotionAction();
            ((BaseModel) graphQLQuickPromotionAction).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLQuickPromotionAction instanceof Postprocessable) {
                return ((Postprocessable) graphQLQuickPromotionAction).a();
            }
            return graphQLQuickPromotionAction;
        }
    }

    /* compiled from: VIEW_PHOTO_MENU */
    public final class Serializer extends JsonSerializer<GraphQLQuickPromotionAction> {
        public final void m21203a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLQuickPromotionAction graphQLQuickPromotionAction = (GraphQLQuickPromotionAction) obj;
            GraphQLQuickPromotionActionDeserializer.m5745a(graphQLQuickPromotionAction.w_(), graphQLQuickPromotionAction.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLQuickPromotionAction.class, new Serializer());
            FbSerializerProvider.a(GraphQLQuickPromotionAction.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m21205a() {
        this.f12847d = (GraphQLTextWithEntities) super.a(this.f12847d, 0, GraphQLTextWithEntities.class);
        return this.f12847d;
    }

    @FieldOffset
    @Nullable
    public final String m21207j() {
        this.f12848e = super.a(this.f12848e, 1);
        return this.f12848e;
    }

    public final int jK_() {
        return 134262572;
    }

    public final GraphQLVisitableModel m21206a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m21205a() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m21205a());
            if (m21205a() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLQuickPromotionAction) ModelHelper.a(null, this);
                graphQLVisitableModel.f12847d = graphQLTextWithEntities;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLQuickPromotionAction() {
        super(3);
    }

    public final int m21204a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m21205a());
        int b = flatBufferBuilder.b(m21207j());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLQuickPromotionAction(Parcel parcel) {
        super(3);
        this.f12847d = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f12848e = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m21205a());
        parcel.writeString(m21207j());
    }
}
