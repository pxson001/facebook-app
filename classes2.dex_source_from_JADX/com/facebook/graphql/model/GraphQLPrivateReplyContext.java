package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLPrivateReplyStatus;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: inline_composer_glyphs_incorrect_type */
public final class GraphQLPrivateReplyContext extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPrivateReplyContext> CREATOR = new 1();
    boolean f19910d;
    @Nullable
    GraphQLPage f19911e;
    GraphQLPrivateReplyStatus f19912f;

    @FieldOffset
    public final boolean m27693a() {
        m9949a(0, 0);
        return this.f19910d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPage m27694j() {
        this.f19911e = (GraphQLPage) super.m9947a(this.f19911e, 1, GraphQLPage.class);
        return this.f19911e;
    }

    @FieldOffset
    public final GraphQLPrivateReplyStatus m27695k() {
        this.f19912f = (GraphQLPrivateReplyStatus) super.m9945a(this.f19912f, 2, GraphQLPrivateReplyStatus.class, GraphQLPrivateReplyStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f19912f;
    }

    public final int jK_() {
        return -1292790680;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m27694j() != null) {
            GraphQLPage graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.mo2928b(m27694j());
            if (m27694j() != graphQLPage) {
                graphQLVisitableModel = (GraphQLPrivateReplyContext) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19911e = graphQLPage;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPrivateReplyContext() {
        super(4);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f19910d = mutableFlatBuffer.m21540a(i, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m27694j());
        flatBufferBuilder.m21510c(3);
        flatBufferBuilder.m21498a(0, m27693a());
        flatBufferBuilder.m21507b(1, a);
        flatBufferBuilder.m21496a(2, m27695k() == GraphQLPrivateReplyStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m27695k());
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLPrivateReplyContext(Parcel parcel) {
        boolean z = true;
        super(4);
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f19910d = z;
        this.f19911e = (GraphQLPage) parcel.readValue(GraphQLPage.class.getClassLoader());
        this.f19912f = GraphQLPrivateReplyStatus.fromString(parcel.readString());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (m27693a() ? 1 : 0));
        parcel.writeValue(m27694j());
        parcel.writeString(m27695k().name());
    }
}
