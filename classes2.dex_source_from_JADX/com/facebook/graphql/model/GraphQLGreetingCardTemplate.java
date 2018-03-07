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
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: loadExceptionCount */
public final class GraphQLGreetingCardTemplate extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLGreetingCardTemplate> CREATOR = new 1();
    @Nullable
    String f17249d;
    List<GraphQLImage> f17250e;
    List<GraphQLGreetingCardTemplateTheme> f17251f;
    @Nullable
    String f17252g;

    @FieldOffset
    @Nullable
    public final String m24301j() {
        this.f17249d = super.m9948a(this.f17249d, 0);
        return this.f17249d;
    }

    @FieldOffset
    public final ImmutableList<GraphQLImage> m24302k() {
        this.f17250e = super.m9944a(this.f17250e, 1, GraphQLImage.class);
        return (ImmutableList) this.f17250e;
    }

    @FieldOffset
    public final ImmutableList<GraphQLGreetingCardTemplateTheme> m24303l() {
        this.f17251f = super.m9944a(this.f17251f, 2, GraphQLGreetingCardTemplateTheme.class);
        return (ImmutableList) this.f17251f;
    }

    @FieldOffset
    @Nullable
    public final String m24304m() {
        this.f17252g = super.m9948a(this.f17252g, 3);
        return this.f17252g;
    }

    @Nullable
    public final String mo2834a() {
        return m24301j();
    }

    public final int jK_() {
        return 538646179;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        Builder a;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24302k() != null) {
            a = ModelHelper.m23097a(m24302k(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLGreetingCardTemplate) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17250e = a.m1068b();
            }
        }
        if (m24303l() != null) {
            a = ModelHelper.m23097a(m24303l(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLGreetingCardTemplate) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17251f = a.m1068b();
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLGreetingCardTemplate() {
        super(5);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m24301j());
        int a = ModelHelper.m23094a(flatBufferBuilder, m24302k());
        int a2 = ModelHelper.m23094a(flatBufferBuilder, m24303l());
        int b2 = flatBufferBuilder.m21502b(m24304m());
        flatBufferBuilder.m21510c(4);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, a);
        flatBufferBuilder.m21507b(2, a2);
        flatBufferBuilder.m21507b(3, b2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLGreetingCardTemplate(Parcel parcel) {
        super(5);
        this.f17249d = parcel.readString();
        this.f17250e = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLImage.class.getClassLoader()));
        this.f17251f = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLGreetingCardTemplateTheme.class.getClassLoader()));
        this.f17252g = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m24301j());
        parcel.writeList(m24302k());
        parcel.writeList(m24303l());
        parcel.writeString(m24304m());
    }
}
