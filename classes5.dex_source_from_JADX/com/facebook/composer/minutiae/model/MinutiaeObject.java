package com.facebook.composer.minutiae.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLModels.TaggableObjectEdgeModel;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLModels.TaggableObjectEdgeModel.AssociatedPlacesInfoModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLInterfaces.MinutiaeIcon;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLInterfaces.MinutiaeTaggableActivity;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeIconModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableActivityFieldsModel.GlyphModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableActivityFieldsModel.IconImageLargeModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableActivityModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableActivityModel.AllIconsModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableObjectFieldsModel;
import com.facebook.composer.minutiae.graphql.MinutiaeSuggestionDefaultsGraphQLModels.MinutiaeTaggableSuggestionsModel;
import com.facebook.composer.minutiae.graphql.MinutiaeSuggestionDefaultsGraphQLModels.MinutiaeTaggableSuggestionsModel.NodeModel;
import com.facebook.composer.minutiae.graphql.MinutiaeSuggestionDefaultsGraphQLModels.MinutiaeTaggableSuggestionsModel.NodeModel.TaggableActivityIconModel;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.enums.GraphQLTaggableActivitySuggestionMechanism;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLInlineActivitiesConnection;
import com.facebook.graphql.model.GraphQLInlineActivitiesConnection$Builder;
import com.facebook.graphql.model.GraphQLInlineActivity;
import com.facebook.graphql.model.GraphQLInlineActivity$Builder;
import com.facebook.graphql.model.GraphQLNode$Builder;
import com.facebook.graphql.model.GraphQLProfile$Builder;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTaggableActivity;
import com.facebook.graphql.model.GraphQLTaggableActivity$Builder;
import com.facebook.graphql.model.GraphQLTaggableActivityAllIconsConnection;
import com.facebook.graphql.model.GraphQLTaggableActivityAllIconsConnection$Builder;
import com.facebook.graphql.model.GraphQLTaggableActivityIcon$Builder;
import com.facebook.graphql.model.GraphQLTaggableActivitySuggestionsEdge;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.ipc.composer.model.MinutiaeTag;
import com.facebook.linkify.LinkifyTargetGraphQLInterfaces.LinkifyTargetGraphQL;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.nio.ByteBuffer;
import java.util.Collection;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = MinutiaeObjectDeserializer.class)
@JsonSerialize(using = MinutiaeObjectSerializer.class)
/* compiled from: added_time */
public class MinutiaeObject implements Parcelable {
    public static final Creator<MinutiaeObject> CREATOR = new C10801();
    @Nullable
    public final AssociatedPlacesInfoModel f11477a;
    @JsonProperty("custom_icon")
    public final MinutiaeIconModel customIcon;
    @JsonProperty("hide_attachment")
    public final boolean hideAttachment;
    @JsonProperty("object")
    public final TaggableObjectEdgeModel object;
    @JsonProperty("suggestion_mechanism")
    @Nullable
    public final String suggestionMechanism;
    @JsonProperty("verb")
    public final MinutiaeTaggableActivityModel verb;

    /* compiled from: added_time */
    final class C10801 implements Creator<MinutiaeObject> {
        C10801() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MinutiaeObject(parcel);
        }

        public final Object[] newArray(int i) {
            return new MinutiaeObject[0];
        }
    }

    /* compiled from: added_time */
    final class C10812 implements Function<MinutiaeIcon, MinutiaeIconModel> {
        C10812() {
        }

        public final Object apply(@Nullable Object obj) {
            return MinutiaeIconModel.m19356a((MinutiaeIconModel) obj);
        }
    }

    /* compiled from: added_time */
    public class Builder {
        public MinutiaeTaggableActivity f11470a;
        public TaggableObjectEdgeModel f11471b;
        @Nullable
        public MinutiaeIconModel f11472c;
        @Nullable
        public String f11473d;
        public boolean f11474e = false;
        private boolean f11475f = false;
        public AssociatedPlacesInfoModel f11476g = null;

        public static Builder m19613a(MinutiaeObject minutiaeObject) {
            Builder builder = new Builder();
            builder.f11471b = minutiaeObject.object;
            builder = builder;
            builder.f11472c = minutiaeObject.customIcon;
            builder = builder;
            builder.f11470a = minutiaeObject.verb;
            builder = builder;
            builder.f11473d = minutiaeObject.suggestionMechanism;
            builder = builder;
            builder.f11474e = minutiaeObject.hideAttachment;
            builder = builder;
            builder.f11476g = minutiaeObject.f11477a;
            return builder;
        }

        public final MinutiaeObject m19614a() {
            if (this.f11471b != null && this.f11471b.m19334d() != null && this.f11471b.af_() != null && this.f11471b.m19333c() != null && this.f11470a != null) {
                return new MinutiaeObject(this);
            }
            throw new IllegalStateException("Required attribute is null. " + this);
        }

        public String toString() {
            return Objects.toStringHelper(this).add("verb", this.f11470a).add("object", this.f11471b).add("customIcon", this.f11472c).add("suggestionMechanism", this.f11473d).add("hideAttachment", this.f11474e).add("isAttachmentReadOnly", this.f11475f).add("associatedPlacesInfo", this.f11476g).toString();
        }
    }

    /* compiled from: added_time */
    public interface ProvidesMinutiae {
        @Nullable
        MinutiaeObject m19615l();
    }

    public static MinutiaeTag m19623a(MinutiaeObject minutiaeObject) {
        return minutiaeObject == null ? MinutiaeTag.f13999a : minutiaeObject.m19631d();
    }

    private MinutiaeObject() {
        this.verb = null;
        this.object = null;
        this.customIcon = null;
        this.suggestionMechanism = null;
        this.hideAttachment = false;
        this.f11477a = null;
    }

    public MinutiaeObject(Builder builder) {
        this.verb = MinutiaeTaggableActivityModel.m19427a(builder.f11470a);
        this.object = builder.f11471b;
        this.customIcon = builder.f11472c;
        this.suggestionMechanism = builder.f11473d;
        this.hideAttachment = builder.f11474e;
        this.f11477a = builder.f11476g;
    }

    public MinutiaeObject(Parcel parcel) {
        this.verb = (MinutiaeTaggableActivityModel) FlatBufferModelHelper.m4278a(parcel);
        this.object = (TaggableObjectEdgeModel) FlatBufferModelHelper.m4278a(parcel);
        this.customIcon = (MinutiaeIconModel) FlatBufferModelHelper.m4278a(parcel);
        this.suggestionMechanism = parcel.readString();
        this.hideAttachment = parcel.readInt() == 1;
        this.f11477a = (AssociatedPlacesInfoModel) FlatBufferModelHelper.m4278a(parcel);
    }

    public static MinutiaeObject m19616a(MinutiaeTaggableSuggestionsModel minutiaeTaggableSuggestionsModel) {
        NodeModel c = minutiaeTaggableSuggestionsModel.m19572c();
        TaggableActivityIconModel a = TaggableActivityIconModel.m19546a(c.m19558c());
        Collection a2 = Lists.a(minutiaeTaggableSuggestionsModel.m19570a(), new C10812());
        com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLModels.TaggableObjectEdgeModel.Builder builder = new com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLModels.TaggableObjectEdgeModel.Builder();
        builder.f11338f = a.m19550j();
        com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLModels.TaggableObjectEdgeModel.Builder builder2 = builder;
        builder2.f11339g = MinutiaeTaggableObjectFieldsModel.m19494a(c.m19555a());
        builder2 = builder2;
        builder2.f11336d = minutiaeTaggableSuggestionsModel.m19571b();
        builder2 = builder2;
        builder2.f11335c = ImmutableList.copyOf(a2);
        builder2 = builder2;
        builder2.f11340h = true;
        TaggableObjectEdgeModel a3 = builder2.m19309a();
        String name = (minutiaeTaggableSuggestionsModel.ag_() == null || minutiaeTaggableSuggestionsModel.ag_().size() <= 0) ? null : ((GraphQLTaggableActivitySuggestionMechanism) minutiaeTaggableSuggestionsModel.ag_().get(0)).name();
        Builder builder3 = new Builder();
        builder3.f11471b = a3;
        Builder builder4 = builder3;
        builder4.f11470a = c.m19557b();
        Builder builder5 = builder4;
        builder5.f11473d = name;
        return builder5.m19614a();
    }

    public static MinutiaeObject m19622a(String str, DefaultImageFieldsModel defaultImageFieldsModel, MinutiaeTaggableActivityModel minutiaeTaggableActivityModel, MinutiaeTaggableObjectFieldsModel minutiaeTaggableObjectFieldsModel) {
        com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLModels.TaggableObjectEdgeModel.Builder builder = new com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLModels.TaggableObjectEdgeModel.Builder();
        builder.f11338f = defaultImageFieldsModel;
        builder = builder;
        builder.f11339g = minutiaeTaggableObjectFieldsModel;
        builder = builder;
        builder.f11336d = str;
        TaggableObjectEdgeModel a = builder.m19309a();
        Builder builder2 = new Builder();
        builder2.f11471b = a;
        Builder builder3 = builder2;
        builder3.f11470a = minutiaeTaggableActivityModel;
        return builder3.m19614a();
    }

    public final Uri m19627a() {
        return (this.customIcon == null || this.customIcon.m19362j() == null) ? Uri.parse(this.object.m19336j().b()) : Uri.parse(this.customIcon.m19362j().b());
    }

    public final ImmutableList<? extends MinutiaeIcon> m19628b() {
        if (m19630c()) {
            return this.object.m19332b();
        }
        return null;
    }

    public final boolean m19630c() {
        return (this.object.m19332b() == null || this.object.m19332b().isEmpty()) ? false : true;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        FlatBufferModelHelper.m4288a(parcel, this.verb);
        FlatBufferModelHelper.m4288a(parcel, this.object);
        FlatBufferModelHelper.m4288a(parcel, this.customIcon);
        parcel.writeString(this.suggestionMechanism);
        parcel.writeInt(this.hideAttachment ? 1 : 0);
        FlatBufferModelHelper.m4288a(parcel, (Flattenable) this.f11477a);
    }

    public final MinutiaeTag m19631d() {
        String b = this.customIcon != null ? this.customIcon.m19360b() : null;
        if (this.object.m19337k().m19506d() == null) {
            return MinutiaeTag.m23383c(this.verb.mo1195l(), this.object.m19333c(), b, this.suggestionMechanism);
        }
        if (this.hideAttachment) {
            return MinutiaeTag.m23382b(this.verb.mo1195l(), this.object.m19337k().m19506d(), b, this.suggestionMechanism);
        }
        return MinutiaeTag.m23381a(this.verb.mo1195l(), this.object.m19337k().m19506d(), b, this.suggestionMechanism);
    }

    public final LinkifyTargetGraphQL m19632e() {
        if (this.verb == null || this.verb.mo1194k() || this.object == null || this.object.m19337k() == null) {
            return null;
        }
        return this.object.m19337k();
    }

    public final boolean m19633f() {
        return (this.verb == null || this.verb.m19437J() == null) ? false : true;
    }

    public final GraphQLInlineActivitiesConnection m19634g() {
        GraphQLTaggableActivity graphQLTaggableActivity;
        DefaultImageFields j;
        GraphQLImage graphQLImage;
        GraphQLInlineActivitiesConnection$Builder graphQLInlineActivitiesConnection$Builder = new GraphQLInlineActivitiesConnection$Builder();
        GraphQLInlineActivity$Builder graphQLInlineActivity$Builder = new GraphQLInlineActivity$Builder();
        GraphQLNode$Builder graphQLNode$Builder = new GraphQLNode$Builder();
        graphQLNode$Builder.fw = this.object.m19333c();
        graphQLInlineActivity$Builder.f4308e = graphQLNode$Builder.m9287a();
        graphQLInlineActivity$Builder = graphQLInlineActivity$Builder;
        MinutiaeTaggableActivity minutiaeTaggableActivity = this.verb;
        if (minutiaeTaggableActivity == null) {
            graphQLTaggableActivity = null;
        } else {
            GraphQLTaggableActivityAllIconsConnection graphQLTaggableActivityAllIconsConnection;
            GraphQLImage graphQLImage2;
            com.facebook.graphql.model.GraphQLImage.Builder builder;
            GraphQLTaggableActivity$Builder graphQLTaggableActivity$Builder = new GraphQLTaggableActivity$Builder();
            AllIconsModel B = minutiaeTaggableActivity.mo1192B();
            if (B == null) {
                graphQLTaggableActivityAllIconsConnection = null;
            } else {
                GraphQLTaggableActivityAllIconsConnection$Builder graphQLTaggableActivityAllIconsConnection$Builder = new GraphQLTaggableActivityAllIconsConnection$Builder();
                graphQLTaggableActivityAllIconsConnection$Builder.f13252d = B.m19419a();
                graphQLTaggableActivityAllIconsConnection = graphQLTaggableActivityAllIconsConnection$Builder.m22041a();
            }
            graphQLTaggableActivity$Builder.f13233d = graphQLTaggableActivityAllIconsConnection;
            GlyphModel A = minutiaeTaggableActivity.mo1191A();
            if (A == null) {
                graphQLImage2 = null;
            } else {
                builder = new com.facebook.graphql.model.GraphQLImage.Builder();
                builder.g = A.m19385a();
                graphQLImage2 = builder.a();
            }
            graphQLTaggableActivity$Builder.f13234e = graphQLImage2;
            IconImageLargeModel z = minutiaeTaggableActivity.mo1202z();
            if (z == null) {
                graphQLImage2 = null;
            } else {
                builder = new com.facebook.graphql.model.GraphQLImage.Builder();
                builder.g = z.m19392a();
                graphQLImage2 = builder.a();
            }
            graphQLTaggableActivity$Builder.f13235f = graphQLImage2;
            graphQLTaggableActivity$Builder.f13236g = minutiaeTaggableActivity.mo1193j();
            graphQLTaggableActivity$Builder.f13237h = minutiaeTaggableActivity.mo1194k();
            graphQLTaggableActivity$Builder.f13238i = minutiaeTaggableActivity.mo1195l();
            graphQLTaggableActivity$Builder.f13239j = minutiaeTaggableActivity.mo1196m();
            graphQLTaggableActivity$Builder.f13240k = minutiaeTaggableActivity.mo1197n();
            graphQLTaggableActivity$Builder.f13241l = MinutiaeModelConversionHelper.m19608a(minutiaeTaggableActivity.mo1190y());
            graphQLTaggableActivity$Builder.f13242m = MinutiaeModelConversionHelper.m19608a(minutiaeTaggableActivity.mo1189x());
            graphQLTaggableActivity$Builder.f13243n = MinutiaeModelConversionHelper.m19608a(minutiaeTaggableActivity.mo1188w());
            graphQLTaggableActivity$Builder.f13244o = MinutiaeModelConversionHelper.m19608a(minutiaeTaggableActivity.mo1187v());
            graphQLTaggableActivity$Builder.f13245p = MinutiaeModelConversionHelper.m19608a(minutiaeTaggableActivity.mo1186u());
            graphQLTaggableActivity$Builder.f13246q = MinutiaeModelConversionHelper.m19608a(minutiaeTaggableActivity.mo1185t());
            graphQLTaggableActivity$Builder.f13247r = minutiaeTaggableActivity.mo1198o();
            graphQLTaggableActivity$Builder.f13248s = minutiaeTaggableActivity.mo1199p();
            graphQLTaggableActivity$Builder.f13249t = minutiaeTaggableActivity.mo1200q();
            graphQLTaggableActivity$Builder.f13250u = minutiaeTaggableActivity.mo1201r();
            graphQLTaggableActivity = graphQLTaggableActivity$Builder.m22038a();
        }
        graphQLInlineActivity$Builder.f4309f = graphQLTaggableActivity;
        GraphQLInlineActivity$Builder graphQLInlineActivity$Builder2 = graphQLInlineActivity$Builder;
        GraphQLTaggableActivityIcon$Builder graphQLTaggableActivityIcon$Builder = new GraphQLTaggableActivityIcon$Builder();
        if (this.customIcon != null) {
            j = this.customIcon.m19362j();
        } else {
            j = this.object.m19336j();
        }
        if (j == null) {
            graphQLImage = null;
        } else {
            com.facebook.graphql.model.GraphQLImage.Builder builder2 = new com.facebook.graphql.model.GraphQLImage.Builder();
            builder2.d = j.a();
            builder2.g = j.b();
            builder2.h = j.c();
            graphQLImage = builder2.a();
        }
        graphQLTaggableActivityIcon$Builder.f13256f = graphQLImage;
        graphQLInlineActivity$Builder2.f4310g = graphQLTaggableActivityIcon$Builder.m22049a();
        graphQLInlineActivitiesConnection$Builder.f4306d = ImmutableList.of(graphQLInlineActivity$Builder2.m8691a());
        return graphQLInlineActivitiesConnection$Builder.m8684a();
    }

    @Nullable
    public static MinutiaeObject m19621a(@Nonnull GraphQLStory graphQLStory) {
        GraphQLStoryAttachment graphQLStoryAttachment = null;
        if (!m19624b(graphQLStory.af())) {
            return null;
        }
        if (m19626b(graphQLStory)) {
            graphQLStoryAttachment = StoryAttachmentHelper.o(graphQLStory);
        }
        return m19618a(graphQLStory.af(), graphQLStoryAttachment);
    }

    @Nullable
    public static MinutiaeObject m19617a(GraphQLInlineActivitiesConnection graphQLInlineActivitiesConnection) {
        return m19618a(graphQLInlineActivitiesConnection, null);
    }

    @Nullable
    public static MinutiaeObject m19619a(GraphQLInlineActivity graphQLInlineActivity) {
        return m19620a(graphQLInlineActivity, null);
    }

    @Nullable
    private static MinutiaeObject m19618a(GraphQLInlineActivitiesConnection graphQLInlineActivitiesConnection, GraphQLStoryAttachment graphQLStoryAttachment) {
        if (m19624b(graphQLInlineActivitiesConnection)) {
            return m19620a((GraphQLInlineActivity) graphQLInlineActivitiesConnection.a().get(0), graphQLStoryAttachment);
        }
        return null;
    }

    @Nullable
    public static MinutiaeObject m19620a(GraphQLInlineActivity graphQLInlineActivity, @Nullable GraphQLStoryAttachment graphQLStoryAttachment) {
        String str = null;
        if (!m19625b(graphQLInlineActivity)) {
            return null;
        }
        boolean z;
        com.facebook.graphql.model.GraphQLTaggableActivitySuggestionsEdge.Builder builder = new com.facebook.graphql.model.GraphQLTaggableActivitySuggestionsEdge.Builder();
        builder.f13268i = graphQLInlineActivity.m().l();
        builder = builder;
        GraphQLProfile$Builder graphQLProfile$Builder = new GraphQLProfile$Builder();
        graphQLProfile$Builder.f12784Q = graphQLInlineActivity.k().eP();
        graphQLProfile$Builder = graphQLProfile$Builder;
        graphQLProfile$Builder.f12787T = graphQLStoryAttachment;
        graphQLProfile$Builder = graphQLProfile$Builder;
        if (!(graphQLStoryAttachment == null || graphQLStoryAttachment.z() == null)) {
            str = graphQLStoryAttachment.z().dp();
        }
        graphQLProfile$Builder.f12774G = str;
        GraphQLProfile$Builder graphQLProfile$Builder2 = graphQLProfile$Builder;
        graphQLProfile$Builder2.aE = graphQLInlineActivity.k().j();
        builder.f13269j = graphQLProfile$Builder2.m21095a();
        com.facebook.graphql.model.GraphQLTaggableActivitySuggestionsEdge.Builder builder2 = builder;
        builder2.f13266g = graphQLInlineActivity.k().eP();
        builder = builder2;
        if (graphQLStoryAttachment != null) {
            z = true;
        } else {
            z = false;
        }
        builder.f13270k = z;
        GraphQLTaggableActivitySuggestionsEdge graphQLTaggableActivitySuggestionsEdge = new GraphQLTaggableActivitySuggestionsEdge(builder);
        GraphQLTaggableActivity l = graphQLInlineActivity.l();
        Builder builder3 = new Builder();
        ByteBuffer byteBuffer = null;
        if (graphQLTaggableActivitySuggestionsEdge != null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = MinutiaeModelConversionHelper.m19605a(flatBufferBuilder, graphQLTaggableActivitySuggestionsEdge);
            if (a != 0) {
                flatBufferBuilder.d(a);
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                byteBuffer = new TaggableObjectEdgeModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }
        builder3.f11471b = byteBuffer;
        Builder builder4 = builder3;
        builder4.f11470a = MinutiaeModelConversionHelper.m19607a(l);
        return builder4.m19614a();
    }

    private static boolean m19624b(GraphQLInlineActivitiesConnection graphQLInlineActivitiesConnection) {
        return (graphQLInlineActivitiesConnection == null || graphQLInlineActivitiesConnection.a() == null || graphQLInlineActivitiesConnection.a().isEmpty() || !m19625b((GraphQLInlineActivity) graphQLInlineActivitiesConnection.a().get(0))) ? false : true;
    }

    private static boolean m19625b(GraphQLInlineActivity graphQLInlineActivity) {
        return (graphQLInlineActivity.k() == null || graphQLInlineActivity.k().eP() == null || graphQLInlineActivity.m() == null || graphQLInlineActivity.m().l() == null || graphQLInlineActivity.l() == null) ? false : true;
    }

    private static boolean m19626b(@Nonnull GraphQLStory graphQLStory) {
        return (!m19624b(graphQLStory.af()) || StoryAttachmentHelper.o(graphQLStory) == null || StoryAttachmentHelper.o(graphQLStory).m() == null || ((GraphQLInlineActivity) graphQLStory.af().a().get(0)).k().eS() == null || ((GraphQLInlineActivity) graphQLStory.af().a().get(0)).k().eS().m() == null || !StoryAttachmentHelper.o(graphQLStory).m().equals(((GraphQLInlineActivity) graphQLStory.af().a().get(0)).k().eS().m())) ? false : true;
    }

    public final boolean m19635h() {
        return (this.hideAttachment || this.object == null || this.object.m19337k() == null || this.object.m19337k().m19510l() == null || !this.object.m19338l()) ? false : true;
    }

    public final boolean m19629b(MinutiaeObject minutiaeObject) {
        if (this == minutiaeObject) {
            return true;
        }
        if (minutiaeObject == null) {
            return false;
        }
        return m19631d().equals(minutiaeObject.m19631d());
    }
}
