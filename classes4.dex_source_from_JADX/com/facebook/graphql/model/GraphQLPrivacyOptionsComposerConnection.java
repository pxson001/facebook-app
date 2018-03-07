package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: smsMessages */
public final class GraphQLPrivacyOptionsComposerConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPrivacyOptionsComposerConnection> CREATOR = new C01091();
    public List<GraphQLPrivacyOptionsComposerEdge> f2133d;

    /* compiled from: smsMessages */
    final class C01091 implements Creator<GraphQLPrivacyOptionsComposerConnection> {
        C01091() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLPrivacyOptionsComposerConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLPrivacyOptionsComposerConnection[i];
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLPrivacyOptionsComposerEdge> m2244a() {
        this.f2133d = super.a(this.f2133d, 0, GraphQLPrivacyOptionsComposerEdge.class);
        return (ImmutableList) this.f2133d;
    }

    public final int jK_() {
        return 745673940;
    }

    public final GraphQLVisitableModel m2243a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m2244a() != null) {
            Builder a = ModelHelper.a(m2244a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLPrivacyOptionsComposerConnection) ModelHelper.a(null, this);
                graphQLVisitableModel.f2133d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPrivacyOptionsComposerConnection() {
        super(2);
    }

    public final int m2242a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m2244a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLPrivacyOptionsComposerConnection(Parcel parcel) {
        super(2);
        this.f2133d = ImmutableListHelper.a(parcel.readArrayList(GraphQLPrivacyOptionsComposerEdge.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m2244a());
    }
}
