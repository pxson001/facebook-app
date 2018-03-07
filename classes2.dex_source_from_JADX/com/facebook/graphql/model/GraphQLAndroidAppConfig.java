package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.google.common.collect.ImmutableList;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: localizedMessage */
public final class GraphQLAndroidAppConfig extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLAndroidAppConfig> CREATOR = new 1();
    public boolean f16912d;
    @Nullable
    public String f16913e;
    public List<String> f16914f;
    @Nullable
    public String f16915g;

    @FieldOffset
    public final boolean m23890a() {
        m9949a(0, 0);
        return this.f16912d;
    }

    @FieldOffset
    @Nullable
    public final String m23891j() {
        this.f16913e = super.m9948a(this.f16913e, 1);
        return this.f16913e;
    }

    @FieldOffset
    public final ImmutableList<String> m23892k() {
        this.f16914f = super.m9943a(this.f16914f, 2);
        return (ImmutableList) this.f16914f;
    }

    @FieldOffset
    @Nullable
    public final String m23893l() {
        this.f16915g = super.m9948a(this.f16915g, 3);
        return this.f16915g;
    }

    public final int jK_() {
        return -585955532;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public GraphQLAndroidAppConfig() {
        super(5);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f16912d = mutableFlatBuffer.m21540a(i, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m23891j());
        int c = flatBufferBuilder.m21509c(m23892k());
        int b2 = flatBufferBuilder.m21502b(m23893l());
        flatBufferBuilder.m21510c(4);
        flatBufferBuilder.m21498a(0, m23890a());
        flatBufferBuilder.m21507b(1, b);
        flatBufferBuilder.m21507b(2, c);
        flatBufferBuilder.m21507b(3, b2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLAndroidAppConfig(Parcel parcel) {
        boolean z = true;
        super(5);
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f16912d = z;
        this.f16913e = parcel.readString();
        this.f16914f = ImmutableListHelper.m21625a(parcel.readArrayList(String.class.getClassLoader()));
        this.f16915g = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (m23890a() ? 1 : 0));
        parcel.writeString(m23891j());
        parcel.writeList(m23892k());
        parcel.writeString(m23893l());
    }
}
