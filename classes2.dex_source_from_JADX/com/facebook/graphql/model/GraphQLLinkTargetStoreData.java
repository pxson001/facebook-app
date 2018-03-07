package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
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
/* compiled from: location_manager_params */
public final class GraphQLLinkTargetStoreData extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLLinkTargetStoreData> CREATOR = new 1();
    @Nullable
    String f16585d;
    @Nullable
    GraphQLTextWithEntities f16586e;
    boolean f16587f;
    boolean f16588g;
    @Nullable
    GraphQLTextWithEntities f16589h;

    @FieldOffset
    @Nullable
    public final String m23443a() {
        this.f16585d = super.m9948a(this.f16585d, 0);
        return this.f16585d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m23445j() {
        this.f16586e = (GraphQLTextWithEntities) super.m9947a(this.f16586e, 1, GraphQLTextWithEntities.class);
        return this.f16586e;
    }

    @FieldOffset
    public final boolean m23446k() {
        m9949a(0, 2);
        return this.f16587f;
    }

    @FieldOffset
    public final boolean m23447l() {
        m9949a(0, 3);
        return this.f16588g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m23448m() {
        this.f16589h = (GraphQLTextWithEntities) super.m9947a(this.f16589h, 4, GraphQLTextWithEntities.class);
        return this.f16589h;
    }

    public final int jK_() {
        return 1258324512;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m23445j() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m23445j());
            if (m23445j() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLLinkTargetStoreData) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16586e = graphQLTextWithEntities;
            }
        }
        if (m23448m() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m23448m());
            if (m23448m() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLLinkTargetStoreData) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16589h = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLLinkTargetStoreData() {
        super(6);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f16587f = mutableFlatBuffer.m21540a(i, 2);
        this.f16588g = mutableFlatBuffer.m21540a(i, 3);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m23443a());
        int a = ModelHelper.m23093a(flatBufferBuilder, m23445j());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m23448m());
        flatBufferBuilder.m21510c(5);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, a);
        flatBufferBuilder.m21498a(2, m23446k());
        flatBufferBuilder.m21498a(3, m23447l());
        flatBufferBuilder.m21507b(4, a2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLLinkTargetStoreData(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(6);
        this.f16585d = parcel.readString();
        this.f16586e = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16587f = z;
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.f16588g = z2;
        this.f16589h = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(m23443a());
        parcel.writeValue(m23445j());
        if (m23446k()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!m23447l()) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeValue(m23448m());
    }
}
