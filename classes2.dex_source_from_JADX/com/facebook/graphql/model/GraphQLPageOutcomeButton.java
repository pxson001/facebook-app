package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.graphql.enums.GraphQLPageCallToActionType;
import com.facebook.graphql.enums.GraphQLPageOutcomeButtonRenderType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: location_manager_google_play */
public final class GraphQLPageOutcomeButton extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLPageOutcomeButton> CREATOR = new 1();
    @Nullable
    GraphQLEntityCardContextItemIcon f16639d;
    GraphQLPageCallToActionType f16640e;
    @Nullable
    String f16641f;
    @Nullable
    String f16642g;
    GraphQLPageOutcomeButtonRenderType f16643h;
    @Nullable
    String f16644i;

    @FieldOffset
    @Nullable
    public final GraphQLEntityCardContextItemIcon m23502j() {
        this.f16639d = (GraphQLEntityCardContextItemIcon) super.m9947a(this.f16639d, 0, GraphQLEntityCardContextItemIcon.class);
        return this.f16639d;
    }

    @FieldOffset
    public final GraphQLPageCallToActionType m23503k() {
        this.f16640e = (GraphQLPageCallToActionType) super.m9945a(this.f16640e, 1, GraphQLPageCallToActionType.class, GraphQLPageCallToActionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16640e;
    }

    @FieldOffset
    @Nullable
    public final String m23504l() {
        this.f16641f = super.m9948a(this.f16641f, 2);
        return this.f16641f;
    }

    @FieldOffset
    @Nullable
    public final String m23505m() {
        this.f16642g = super.m9948a(this.f16642g, 3);
        return this.f16642g;
    }

    @FieldOffset
    public final GraphQLPageOutcomeButtonRenderType m23506n() {
        this.f16643h = (GraphQLPageOutcomeButtonRenderType) super.m9945a(this.f16643h, 4, GraphQLPageOutcomeButtonRenderType.class, GraphQLPageOutcomeButtonRenderType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16643h;
    }

    @FieldOffset
    @Nullable
    public final String m23507o() {
        this.f16644i = super.m9948a(this.f16644i, 5);
        return this.f16644i;
    }

    @Nullable
    public final String mo2834a() {
        return m23505m();
    }

    public final int jK_() {
        return -630013259;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m23502j() != null) {
            GraphQLEntityCardContextItemIcon graphQLEntityCardContextItemIcon = (GraphQLEntityCardContextItemIcon) graphQLModelMutatingVisitor.mo2928b(m23502j());
            if (m23502j() != graphQLEntityCardContextItemIcon) {
                graphQLVisitableModel = (GraphQLPageOutcomeButton) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16639d = graphQLEntityCardContextItemIcon;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPageOutcomeButton() {
        super(7);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        Enum enumR = null;
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m23502j());
        int b = flatBufferBuilder.m21502b(m23504l());
        int b2 = flatBufferBuilder.m21502b(m23505m());
        int b3 = flatBufferBuilder.m21502b(m23507o());
        flatBufferBuilder.m21510c(6);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21496a(1, m23503k() == GraphQLPageCallToActionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m23503k());
        flatBufferBuilder.m21507b(2, b);
        flatBufferBuilder.m21507b(3, b2);
        if (m23506n() != GraphQLPageOutcomeButtonRenderType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            enumR = m23506n();
        }
        flatBufferBuilder.m21496a(4, enumR);
        flatBufferBuilder.m21507b(5, b3);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLPageOutcomeButton(Parcel parcel) {
        super(7);
        this.f16639d = (GraphQLEntityCardContextItemIcon) parcel.readValue(GraphQLEntityCardContextItemIcon.class.getClassLoader());
        this.f16640e = GraphQLPageCallToActionType.fromString(parcel.readString());
        this.f16641f = parcel.readString();
        this.f16642g = parcel.readString();
        this.f16643h = GraphQLPageOutcomeButtonRenderType.fromString(parcel.readString());
        this.f16644i = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m23502j());
        parcel.writeString(m23503k().name());
        parcel.writeString(m23504l());
        parcel.writeString(m23505m());
        parcel.writeString(m23506n().name());
        parcel.writeString(m23507o());
    }
}
