package com.facebook.graphql.model;

import android.location.Location;
import com.facebook.common.unicode.CodePointRange;
import com.facebook.common.unicode.CodePointRangeTarget;
import com.facebook.common.util.CollectionUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLPrivateReplyStatus;
import com.facebook.graphql.enums.GraphQLRedSpaceVisibilityState;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.enums.GraphQLStorySaveType;
import com.facebook.graphql.enums.GraphQLStructuredNamePart;
import com.facebook.graphql.enums.GraphQLTranslatabilityType;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.GraphQLEntity.Builder;
import com.facebook.graphql.model.fragments.GraphQLTextWithEntitiesFields;
import com.facebook.graphql.model.interfaces.HasTracking;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.querybuilder.common.C0683x60b8f875.Ranges;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces$DefaultNameFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultNamePartFields;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: mAbandoned= */
public class GraphQLHelper {
    public static final GraphQLObjectType f15760a = new GraphQLObjectType(2645995);
    public static final GraphQLEntity f15761b = m22452a("0", 80218325);
    public static final GraphQLEditHistoryConnection f15762c = new GraphQLEditHistoryConnection();
    public static final GraphQLInteractorsConnection f15763d = new GraphQLInteractorsConnection();
    public static final GraphQLResharesOfContentConnection f15764e = new GraphQLResharesOfContentConnection();
    public static final GraphQLTopLevelCommentsConnection f15765f = new GraphQLTopLevelCommentsConnection();
    public static final GraphQLSubstoriesConnection f15766g = new GraphQLSubstoriesConnection();
    public static final GraphQLTextWithEntities f15767h = m22463a("");
    public static final Comparator<GraphQLEntityAtRange> f15768i = new C06861();
    public static final Comparator<Ranges> f15769j = new C06872();
    public static final Comparator<GraphQLAggregatedEntitiesAtRange> f15770k = new C06883();
    public static final GraphQLCommentsConnection f15771l = new GraphQLCommentsConnection();
    public static final GraphQLLikersOfContentConnection f15772m = new GraphQLLikersOfContentConnection();
    public static final GraphQLReactorsOfContentConnection f15773n = new GraphQLReactorsOfContentConnection();

    /* compiled from: mAbandoned= */
    final class C06861 implements Comparator<GraphQLEntityAtRange> {
        C06861() {
        }

        public final int compare(Object obj, Object obj2) {
            return ((GraphQLEntityAtRange) obj).mo2944c() - ((GraphQLEntityAtRange) obj2).mo2944c();
        }
    }

    /* compiled from: mAbandoned= */
    final class C06872 implements Comparator<Ranges> {
        C06872() {
        }

        public final int compare(Object obj, Object obj2) {
            return ((Ranges) obj).mo2944c() - ((Ranges) obj2).mo2944c();
        }
    }

    /* compiled from: mAbandoned= */
    final class C06883 implements Comparator<GraphQLAggregatedEntitiesAtRange> {
        C06883() {
        }

        public final int compare(Object obj, Object obj2) {
            return ((GraphQLAggregatedEntitiesAtRange) obj).mo2941c() - ((GraphQLAggregatedEntitiesAtRange) obj2).mo2941c();
        }
    }

    private GraphQLHelper() {
    }

    public static boolean m22483a(GraphQLProfile graphQLProfile) {
        return (graphQLProfile.ai() == null || graphQLProfile.ai().mo2924b() == null) ? false : true;
    }

    public static String m22471a(GraphQLActor graphQLActor) {
        Object obj = (graphQLActor == null || graphQLActor.ai() == null || graphQLActor.ai().mo2924b() == null) ? null : 1;
        return obj != null ? graphQLActor.ai().mo2924b() : "";
    }

    public static boolean m22498c(GraphQLProfile graphQLProfile) {
        return (graphQLProfile == null || graphQLProfile.m23016z() == null || graphQLProfile.m23016z().m23997j() == null || graphQLProfile.m23016z().m23997j().m24335L() == null || graphQLProfile.m23016z().m23997j().m24335L().mo2924b() == null) ? false : true;
    }

    public static Location m22446a(GraphQLLocation graphQLLocation) {
        Location location = new Location("");
        location.setLatitude(graphQLLocation.mo2957a());
        location.setLongitude(graphQLLocation.mo2958b());
        return location;
    }

    public static String m22470a(GraphQLStructuredNamePart graphQLStructuredNamePart, Iterable<? extends DefaultNamePartFields> iterable, String str) {
        if (graphQLStructuredNamePart == null) {
            return null;
        }
        for (DefaultNamePartFields defaultNamePartFields : iterable) {
            if (graphQLStructuredNamePart.equals(defaultNamePartFields.c())) {
                int offsetByCodePoints = str.offsetByCodePoints(0, defaultNamePartFields.t_());
                return str.substring(offsetByCodePoints, str.offsetByCodePoints(offsetByCodePoints, defaultNamePartFields.a()));
            }
        }
        return null;
    }

    public static String m22473a(GraphQLName graphQLName) {
        String str;
        GraphQLStructuredNamePart graphQLStructuredNamePart = GraphQLStructuredNamePart.FIRST;
        Iterable<GraphQLNamePart> a = graphQLName.mo2969a();
        String s_ = graphQLName.s_();
        if (graphQLStructuredNamePart == null) {
            str = null;
        } else {
            for (GraphQLNamePart graphQLNamePart : a) {
                if (graphQLStructuredNamePart.equals(graphQLNamePart.c())) {
                    int offsetByCodePoints = s_.offsetByCodePoints(0, graphQLNamePart.t_());
                    str = s_.substring(offsetByCodePoints, s_.offsetByCodePoints(offsetByCodePoints, graphQLNamePart.a()));
                    break;
                }
            }
            str = null;
        }
        return str;
    }

    public static String m22475a(CommonGraphQL2Interfaces$DefaultNameFields commonGraphQL2Interfaces$DefaultNameFields) {
        if (commonGraphQL2Interfaces$DefaultNameFields == null || commonGraphQL2Interfaces$DefaultNameFields.s_() == null) {
            return null;
        }
        ImmutableList a = commonGraphQL2Interfaces$DefaultNameFields.mo2969a();
        int size = a.size();
        int i = 0;
        while (i < size) {
            DefaultNamePartFields defaultNamePartFields = (DefaultNamePartFields) a.get(i);
            if (defaultNamePartFields.c() == null || !defaultNamePartFields.c().equals(GraphQLStructuredNamePart.FIRST)) {
                i++;
            } else {
                String s_ = commonGraphQL2Interfaces$DefaultNameFields.s_();
                i = s_.offsetByCodePoints(0, defaultNamePartFields.t_());
                return s_.substring(i, s_.offsetByCodePoints(i, defaultNamePartFields.a()));
            }
        }
        return null;
    }

    public static final int m22445a(GraphQLEntity graphQLEntity) {
        return graphQLEntity.mo2904b() == null ? 0 : graphQLEntity.mo2904b().m22301g();
    }

    public static final GraphQLEntity m22452a(String str, int i) {
        Builder builder = new Builder();
        builder.f15802m = str;
        builder = builder;
        builder.f15792S = new GraphQLObjectType(i);
        return builder.m22529a();
    }

    public static final GraphQLEntity m22453a(String str, GraphQLObjectType graphQLObjectType) {
        Builder builder = new Builder();
        builder.f15802m = str;
        builder = builder;
        builder.f15792S = graphQLObjectType;
        return builder.m22529a();
    }

    public static final GraphQLEntity m22454a(String str, GraphQLObjectType graphQLObjectType, String str2) {
        Builder builder = new Builder();
        builder.f15802m = str;
        builder = builder;
        builder.f15792S = graphQLObjectType;
        builder = builder;
        builder.f15789P = str2;
        return builder.m22529a();
    }

    public static final GraphQLTextWithEntities m22463a(String str) {
        GraphQLTextWithEntities.Builder builder = new GraphQLTextWithEntities.Builder();
        builder.f15877i = str;
        return builder.m22613a();
    }

    public static final GraphQLTextWithEntities m22464a(String str, List<GraphQLEntityAtRange> list, @Nullable List<GraphQLImageAtRange> list2, @Nullable List<GraphQLAggregatedEntitiesAtRange> list3) {
        GraphQLTextWithEntities.Builder builder = new GraphQLTextWithEntities.Builder();
        builder.f15877i = str;
        builder = builder;
        builder.f15874f = ImmutableListHelper.m21625a((Collection) list2);
        builder = builder;
        builder.f15876h = ImmutableListHelper.m21625a((Collection) list);
        builder = builder;
        builder.f15873e = ImmutableListHelper.m21625a((Collection) list3);
        return builder.m22613a();
    }

    public static final List<CodePointRangeTarget<String>> m22476a(GraphQLTextWithEntitiesFields graphQLTextWithEntitiesFields) {
        List<CodePointRangeTarget<String>> a = Lists.m1296a();
        if (graphQLTextWithEntitiesFields.mo2912b() != null) {
            ImmutableList b = graphQLTextWithEntitiesFields.mo2912b();
            int size = b.size();
            for (int i = 0; i < size; i++) {
                Object obj;
                GraphQLEntityAtRange graphQLEntityAtRange = (GraphQLEntityAtRange) b.get(i);
                if (graphQLEntityAtRange.m23615d() == null || graphQLEntityAtRange.m23615d().D_() == null) {
                    obj = null;
                } else {
                    obj = graphQLEntityAtRange.m23615d().D_();
                }
                a.add(new CodePointRangeTarget(m22448a(graphQLEntityAtRange), obj));
            }
        }
        if (graphQLTextWithEntitiesFields.mo2913c() != null) {
            ImmutableList c = graphQLTextWithEntitiesFields.mo2913c();
            int size2 = c.size();
            for (int i2 = 0; i2 < size2; i2++) {
                a.add(new CodePointRangeTarget(m22447a((GraphQLAggregatedEntitiesAtRange) c.get(i2)), null));
            }
        }
        return a;
    }

    public static GraphQLTextWithEntities m22462a(GraphQLTextWithEntities graphQLTextWithEntities, GraphQLTextWithEntities graphQLTextWithEntities2) {
        int i;
        int i2 = 0;
        int length = Strings.nullToEmpty(graphQLTextWithEntities.mo2911a()).length();
        List arrayList = new ArrayList();
        arrayList.addAll(graphQLTextWithEntities.mo2912b());
        ImmutableList b = graphQLTextWithEntities2.mo2912b();
        int size = b.size();
        for (i = 0; i < size; i++) {
            GraphQLEntityAtRange graphQLEntityAtRange = (GraphQLEntityAtRange) b.get(i);
            GraphQLEntityAtRange.Builder builder = new GraphQLEntityAtRange.Builder();
            graphQLEntityAtRange.m9958h();
            builder.d = graphQLEntityAtRange.m23616j();
            builder.e = graphQLEntityAtRange.mo2943b();
            builder.f = graphQLEntityAtRange.mo2944c();
            BaseModel.Builder.m22419a(builder, graphQLEntityAtRange);
            GraphQLEntityAtRange.Builder builder2 = builder;
            builder2.f = graphQLEntityAtRange.mo2944c() + length;
            arrayList.add(builder2.a());
        }
        List arrayList2 = new ArrayList();
        arrayList2.addAll(graphQLTextWithEntities.m22619d());
        ImmutableList d = graphQLTextWithEntities2.m22619d();
        int size2 = d.size();
        for (i = 0; i < size2; i++) {
            GraphQLImageAtRange graphQLImageAtRange = (GraphQLImageAtRange) d.get(i);
            GraphQLImageAtRange.Builder builder3 = new GraphQLImageAtRange.Builder();
            graphQLImageAtRange.m9958h();
            builder3.d = graphQLImageAtRange.m23596j();
            builder3.e = graphQLImageAtRange.m23594b();
            builder3.f = graphQLImageAtRange.m23595c();
            BaseModel.Builder.m22419a(builder3, graphQLImageAtRange);
            GraphQLImageAtRange.Builder builder4 = builder3;
            builder4.f = graphQLImageAtRange.m23595c() + length;
            arrayList2.add(builder4.a());
        }
        List arrayList3 = new ArrayList();
        arrayList3.addAll(graphQLTextWithEntities.mo2913c());
        d = graphQLTextWithEntities2.mo2913c();
        size2 = d.size();
        while (i2 < size2) {
            GraphQLAggregatedEntitiesAtRange graphQLAggregatedEntitiesAtRange = (GraphQLAggregatedEntitiesAtRange) d.get(i2);
            GraphQLAggregatedEntitiesAtRange.Builder builder5 = new GraphQLAggregatedEntitiesAtRange.Builder();
            graphQLAggregatedEntitiesAtRange.m9958h();
            builder5.d = graphQLAggregatedEntitiesAtRange.mo2939a();
            builder5.e = graphQLAggregatedEntitiesAtRange.mo2940b();
            builder5.f = graphQLAggregatedEntitiesAtRange.mo2941c();
            builder5.g = graphQLAggregatedEntitiesAtRange.m23586j();
            BaseModel.Builder.m22419a(builder5, graphQLAggregatedEntitiesAtRange);
            GraphQLAggregatedEntitiesAtRange.Builder builder6 = builder5;
            builder6.f = graphQLAggregatedEntitiesAtRange.mo2941c() + length;
            arrayList3.add(builder6.a());
            i2++;
        }
        return m22464a(Strings.nullToEmpty(graphQLTextWithEntities.mo2911a()) + Strings.nullToEmpty(graphQLTextWithEntities2.mo2911a()), arrayList, arrayList2, arrayList3);
    }

    public static boolean m22486a(GraphQLTimelineAppCollection graphQLTimelineAppCollection) {
        return (graphQLTimelineAppCollection == null || graphQLTimelineAppCollection.mo2915b() == null || graphQLTimelineAppCollection.m22860x() == null || graphQLTimelineAppCollection.m22853q() == null || graphQLTimelineAppCollection.m22850n() == null || StringUtil.m3589a(graphQLTimelineAppCollection.m22853q().mo2949c())) ? false : true;
    }

    public static ImmutableList<GraphQLActor> m22488b(GraphQLSeenByConnection graphQLSeenByConnection) {
        return graphQLSeenByConnection.m24797j() == null ? RegularImmutableList.f535a : graphQLSeenByConnection.m24797j();
    }

    public static final boolean m22484a(GraphQLStoryActionLink graphQLStoryActionLink) {
        return (graphQLStoryActionLink.m22883J() == null || StringUtil.m3589a(graphQLStoryActionLink.m22883J().dp()) || graphQLStoryActionLink.m22883J().gK() == null || !m22486a(graphQLStoryActionLink.m22883J().gK())) ? false : true;
    }

    public static final boolean m22493b(GraphQLStoryActionLink graphQLStoryActionLink) {
        return graphQLStoryActionLink.m22901a() != null && graphQLStoryActionLink.m22901a().m22301g() == -581184810;
    }

    public static final boolean m22485a(GraphQLStorySaveInfo graphQLStorySaveInfo) {
        return (graphQLStorySaveInfo == null || graphQLStorySaveInfo.m24777l() == GraphQLStorySaveType.UNKONWN || graphQLStorySaveInfo.m24777l() == GraphQLStorySaveType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE || graphQLStorySaveInfo.m24778m() == GraphQLSavedState.NOT_SAVABLE || graphQLStorySaveInfo.m24778m() == GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) ? false : true;
    }

    public static final GraphQLStructuredSurveyQuestion m22461a(GraphQLStructuredSurvey graphQLStructuredSurvey, String str) {
        if (!(graphQLStructuredSurvey.m24882m() == null || graphQLStructuredSurvey.m24882m().a() == null || StringUtil.m3589a((CharSequence) str))) {
            Iterator it = graphQLStructuredSurvey.m24882m().a().iterator();
            while (it.hasNext()) {
                GraphQLStructuredSurveyQuestion graphQLStructuredSurveyQuestion = (GraphQLStructuredSurveyQuestion) it.next();
                if (str.equalsIgnoreCase(graphQLStructuredSurveyQuestion.k())) {
                    return graphQLStructuredSurveyQuestion;
                }
            }
        }
        return null;
    }

    public static GraphQLPageInfo m22458a(GraphQLLikersOfContentConnection graphQLLikersOfContentConnection) {
        GraphQLPageInfo k = graphQLLikersOfContentConnection.m22669k();
        if (k == null) {
            return new GraphQLPageInfo();
        }
        return k;
    }

    public static ImmutableList<GraphQLStory> m22469a(ImmutableList<GraphQLStory> immutableList) {
        ImmutableList.Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            builder.m1069c(GraphQLStory.Builder.a((GraphQLStory) immutableList.get(i)).a());
        }
        return builder.m1068b();
    }

    public static boolean m22481a(GraphQLGeoRectangle graphQLGeoRectangle, GraphQLGeoRectangle graphQLGeoRectangle2) {
        if (graphQLGeoRectangle == null && graphQLGeoRectangle2 == null) {
            return true;
        }
        if (graphQLGeoRectangle == null || graphQLGeoRectangle2 == null) {
            return false;
        }
        if (Objects.equal(Double.valueOf(graphQLGeoRectangle.m27625a()), Double.valueOf(graphQLGeoRectangle2.m27625a())) && Objects.equal(Double.valueOf(graphQLGeoRectangle.m27631l()), Double.valueOf(graphQLGeoRectangle2.m27631l())) && Objects.equal(Double.valueOf(graphQLGeoRectangle.m27629j()), Double.valueOf(graphQLGeoRectangle2.m27629j())) && Objects.equal(Double.valueOf(graphQLGeoRectangle.m27630k()), Double.valueOf(graphQLGeoRectangle2.m27630k()))) {
            return true;
        }
        return false;
    }

    public static String m22474a(GraphQLPageInfo graphQLPageInfo) {
        if (graphQLPageInfo == null) {
            return "null";
        }
        return Objects.toStringHelper((Object) graphQLPageInfo).add("startCursor", graphQLPageInfo.v_()).add("endCursor", graphQLPageInfo.mo1405a()).add("hasPreviousPage", graphQLPageInfo.mo1408c()).add("hasNextPage", graphQLPageInfo.mo1407b()).toString();
    }

    public static CodePointRange m22447a(GraphQLAggregatedEntitiesAtRange graphQLAggregatedEntitiesAtRange) {
        return new CodePointRange(graphQLAggregatedEntitiesAtRange.mo2941c(), graphQLAggregatedEntitiesAtRange.mo2940b());
    }

    public static GraphQLEntityAtRange m22455a(GraphQLEntity graphQLEntity, CodePointRange codePointRange) {
        GraphQLEntityAtRange.Builder builder = new GraphQLEntityAtRange.Builder();
        builder.d = graphQLEntity;
        builder = builder;
        builder.f = codePointRange.f22084a;
        builder = builder;
        builder.e = codePointRange.f22085b;
        return builder.a();
    }

    public static CodePointRange m22448a(GraphQLEntityAtRange graphQLEntityAtRange) {
        return new CodePointRange(graphQLEntityAtRange.mo2944c(), graphQLEntityAtRange.mo2943b());
    }

    public static boolean m22478a(FeedUnit feedUnit) {
        if (feedUnit == null) {
            return true;
        }
        if (feedUnit.w_() == null || !feedUnit.w_().f15024d) {
            return false;
        }
        return true;
    }

    public static ArrayNode m22466a(GroupsYouShouldJoinFeedUnitItem groupsYouShouldJoinFeedUnitItem, ScrollableItemListFeedUnit<GroupsYouShouldJoinFeedUnitItem> scrollableItemListFeedUnit) {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.f3121a);
        arrayNode.m13394h(groupsYouShouldJoinFeedUnitItem.mo2877k());
        if (scrollableItemListFeedUnit != null) {
            String str = null;
            if (scrollableItemListFeedUnit instanceof GraphQLGroupsYouShouldJoinFeedUnit) {
                str = ((GraphQLGroupsYouShouldJoinFeedUnit) scrollableItemListFeedUnit).mo2877k();
            } else if (scrollableItemListFeedUnit instanceof GraphQLPaginatedGroupsYouShouldJoinFeedUnit) {
                str = ((GraphQLPaginatedGroupsYouShouldJoinFeedUnit) scrollableItemListFeedUnit).mo2877k();
            }
            if (str != null) {
                arrayNode.m13394h(str);
            }
        }
        return arrayNode;
    }

    public static ArrayNode m22465a(GraphQLGroupsYouShouldCreateFeedUnitItem graphQLGroupsYouShouldCreateFeedUnitItem, ScrollableItemListFeedUnit<GraphQLGroupsYouShouldCreateFeedUnitItem> scrollableItemListFeedUnit) {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.f3121a);
        arrayNode.m13394h(graphQLGroupsYouShouldCreateFeedUnitItem.k());
        if (!(scrollableItemListFeedUnit == null || !(scrollableItemListFeedUnit instanceof GraphQLGroupsYouShouldCreateFeedUnit) || ((GraphQLGroupsYouShouldCreateFeedUnit) scrollableItemListFeedUnit).mo2877k() == null)) {
            arrayNode.m13394h(((GraphQLGroupsYouShouldCreateFeedUnit) scrollableItemListFeedUnit).mo2877k());
        }
        return arrayNode;
    }

    public static ArrayNode m22467a(ScrollableItemListFeedUnit<GraphQLTopicCustomizationStory> scrollableItemListFeedUnit) {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.f3121a);
        arrayNode.m13394h(scrollableItemListFeedUnit.mo2877k());
        return arrayNode;
    }

    public static GraphQLGeoRectangle m22456a(float f, float f2, float f3, float f4) {
        GraphQLGeoRectangle.Builder builder = new GraphQLGeoRectangle.Builder();
        builder.e = (double) f;
        builder = builder;
        builder.g = (double) f2;
        builder = builder;
        builder.f = (double) f3;
        builder = builder;
        builder.d = (double) f4;
        return new GraphQLGeoRectangle(builder);
    }

    public static boolean m22482a(GraphQLPage graphQLPage) {
        return graphQLPage.m23454F() != null && graphQLPage.m23454F().size() > 0;
    }

    public static String m22489b(GraphQLPage graphQLPage) {
        return m22482a(graphQLPage) ? (String) graphQLPage.m23454F().get(0) : null;
    }

    public static int m22494c(GraphQLPage graphQLPage) {
        return graphQLPage.aP() != null ? graphQLPage.aP().m24631a() : 0;
    }

    public static boolean m22500d(GraphQLPage graphQLPage) {
        return (graphQLPage.bs() == null || graphQLPage.bs().mo2924b() == null) ? false : true;
    }

    public static GraphQLPageInfo m22460a(@Nullable String str, @Nullable String str2, boolean z, boolean z2) {
        GraphQLPageInfo.Builder builder = new GraphQLPageInfo.Builder();
        builder.f15933h = str;
        builder = builder;
        builder.f15930e = str2;
        builder = builder;
        builder.f15932g = z;
        builder = builder;
        builder.f15931f = z2;
        return builder.m22681a();
    }

    public static GraphQLPageInfo m22459a(GraphQLPageInfo graphQLPageInfo, GraphQLPageInfo graphQLPageInfo2) {
        Preconditions.checkNotNull(graphQLPageInfo2, "GraphQLPageInfo.mergeContinuous received null PageInfo");
        if (!IsValidUtil.m22952a(graphQLPageInfo)) {
            return graphQLPageInfo2;
        }
        if (!IsValidUtil.m22952a(graphQLPageInfo2)) {
            return graphQLPageInfo;
        }
        GraphQLPageInfo.Builder builder = new GraphQLPageInfo.Builder();
        builder.f15933h = graphQLPageInfo.v_();
        builder = builder;
        builder.f15932g = graphQLPageInfo.mo1408c();
        builder = builder;
        builder.f15930e = graphQLPageInfo2.mo1405a();
        builder = builder;
        builder.f15931f = graphQLPageInfo2.mo1407b();
        return builder.m22681a();
    }

    public static GraphQLComment m22451a(GraphQLStory graphQLStory) {
        if (graphQLStory == null || graphQLStory.aa() == null || graphQLStory.aa().m24205o() == null || graphQLStory.aa().m24205o().isEmpty()) {
            return null;
        }
        return (GraphQLComment) graphQLStory.aa().m24205o().get(0);
    }

    public static GraphQLComment m22487b(GraphQLStory graphQLStory) {
        GraphQLComment a = m22451a(graphQLStory);
        if (a == null) {
            return null;
        }
        return a.m27189v();
    }

    public static GraphQLComment m22495c(GraphQLStory graphQLStory) {
        if (graphQLStory == null || graphQLStory.aa() == null || graphQLStory.aa().m24200j() == null || graphQLStory.aa().m24200j().isEmpty()) {
            return null;
        }
        return (GraphQLComment) graphQLStory.aa().m24200j().get(0);
    }

    public static int m22501e(GraphQLStory graphQLStory) {
        if (graphQLStory == null || graphQLStory.aa() == null || graphQLStory.aa().m24207q() == null || graphQLStory.aa().m24207q().m27646j() == null || graphQLStory.aa().m24207q().m27646j().isEmpty()) {
            return -1;
        }
        return ((GraphQLRelevantReactorsEdge) graphQLStory.aa().m24207q().m27646j().get(0)).a().m27561m();
    }

    public static GraphQLTranslatabilityType m22449a(GraphQLComment graphQLComment) {
        if (graphQLComment.m27166J() == null) {
            return GraphQLTranslatabilityType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        return graphQLComment.m27166J().m24912o();
    }

    public static boolean m22490b(GraphQLComment graphQLComment) {
        GraphQLTranslatabilityType a = m22449a(graphQLComment);
        if (a == GraphQLTranslatabilityType.SEE_TRANSLATION || a == GraphQLTranslatabilityType.SEE_CONVERSION) {
            return true;
        }
        return false;
    }

    @Nullable
    public static GraphQLFeedback m22505f(GraphQLStory graphQLStory) {
        return (graphQLStory == null || graphQLStory.mo2879o() != StoryVisibility.VISIBLE) ? null : graphQLStory.mo2890l();
    }

    public static boolean m22479a(GraphQLFeedback graphQLFeedback) {
        if (graphQLFeedback == null) {
            return false;
        }
        GraphQLFeedbackRealTimeActivityInfo F = graphQLFeedback.m23212F();
        if (F == null || F.m27544a() == null || F.m27544a().a() == null || F.m27544a().a().isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean m22480a(GraphQLFeedback graphQLFeedback, GraphQLComment graphQLComment) {
        if (graphQLFeedback == null || graphQLComment == null) {
            return false;
        }
        ImmutableList i = m22509i(graphQLFeedback);
        int size = i.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (graphQLComment.equals((GraphQLComment) i.get(i2))) {
                return true;
            }
        }
        return false;
    }

    public static String m22508h(GraphQLStory graphQLStory) {
        if (graphQLStory == null) {
            return null;
        }
        if (graphQLStory.aa() != null && graphQLStory.aa().m24197a() != null && graphQLStory.aa().m24197a().m23252s() != null) {
            return graphQLStory.aa().m24197a().m23252s();
        }
        if (graphQLStory.mo2890l() != null) {
            return graphQLStory.mo2890l().m23252s();
        }
        return null;
    }

    public static boolean m22510i(GraphQLStory graphQLStory) {
        if (graphQLStory == null) {
            return false;
        }
        if (m22491b(graphQLStory.mo2890l())) {
            return true;
        }
        if (graphQLStory.m22326L() != null && m22491b(graphQLStory.m22326L().mo2890l())) {
            return true;
        }
        if (graphQLStory.aa() == null || !m22491b(graphQLStory.aa().m24197a())) {
            return false;
        }
        return true;
    }

    public static boolean m22491b(GraphQLFeedback graphQLFeedback) {
        if (graphQLFeedback == null || graphQLFeedback.mo2930c()) {
            return false;
        }
        return true;
    }

    public static GraphQLImage m22457a(String str, int i, int i2) {
        GraphQLImage.Builder builder = new GraphQLImage.Builder();
        builder.g = str;
        builder = builder;
        builder.h = i;
        builder = builder;
        builder.d = i2;
        return builder.a();
    }

    public static float m22444a(GraphQLImage graphQLImage) {
        return ((float) graphQLImage.mo2925c()) / ((float) graphQLImage.mo2923a());
    }

    public static boolean m22492b(GraphQLImage graphQLImage) {
        return graphQLImage.mo2925c() > graphQLImage.mo2923a();
    }

    public static boolean m22497c(GraphQLFeedback graphQLFeedback) {
        return !graphQLFeedback.m23254u();
    }

    public static void m22477a(GraphQLFeedback graphQLFeedback, boolean z) {
        boolean z2;
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        graphQLFeedback.f16406r = z2;
    }

    public static boolean m22499d(GraphQLFeedback graphQLFeedback) {
        return m22528w(graphQLFeedback) != null;
    }

    public static boolean m22496c(GraphQLComment graphQLComment) {
        return graphQLComment.m27163G() != null;
    }

    @Nullable
    public static GraphQLPrivateReplyStatus m22502e(GraphQLComment graphQLComment) {
        if (graphQLComment.m27163G() == null || graphQLComment.m27163G().m27695k() == null) {
            return null;
        }
        return graphQLComment.m27163G().m27695k();
    }

    @JsonIgnore
    public static boolean m22503e(GraphQLFeedback graphQLFeedback) {
        return graphQLFeedback.m23249p() == null && m22528w(graphQLFeedback) == null;
    }

    @JsonIgnore
    public static int m22504f(GraphQLFeedback graphQLFeedback) {
        if (!m22499d(graphQLFeedback)) {
            return m22527v(graphQLFeedback).m22656a();
        }
        GraphQLTopLevelCommentsConnection n = m22518n(graphQLFeedback);
        return n.mo2910b() != 0 ? n.mo2910b() : n.mo2909a();
    }

    @JsonIgnore
    public static int m22506g(GraphQLFeedback graphQLFeedback) {
        ImmutableList immutableList = null;
        if (m22499d(graphQLFeedback)) {
            GraphQLTopLevelCommentsConnection w = m22528w(graphQLFeedback);
            if (w != null) {
                immutableList = w.m22600j();
            }
        } else {
            GraphQLCommentsConnection p = graphQLFeedback.m23249p();
            if (p != null) {
                immutableList = p.m22661j();
            }
        }
        if (immutableList == null) {
            return 0;
        }
        return immutableList.size();
    }

    @JsonIgnore
    public static GraphQLPageInfo m22507h(GraphQLFeedback graphQLFeedback) {
        return m22499d(graphQLFeedback) ? m22518n(graphQLFeedback).m22601k() : m22527v(graphQLFeedback).m22662k();
    }

    @JsonIgnore
    public static ImmutableList<GraphQLComment> m22509i(GraphQLFeedback graphQLFeedback) {
        return m22499d(graphQLFeedback) ? m22518n(graphQLFeedback).m22600j() : m22527v(graphQLFeedback).m22661j();
    }

    @JsonIgnore
    public static GraphQLComment m22450a(GraphQLFeedback graphQLFeedback, int i) {
        Preconditions.checkElementIndex(i, m22506g(graphQLFeedback));
        return (GraphQLComment) m22509i(graphQLFeedback).get(i);
    }

    @JsonIgnore
    public static boolean m22512j(GraphQLFeedback graphQLFeedback) {
        return m22507h(graphQLFeedback) != null && m22507h(graphQLFeedback).mo1408c();
    }

    @JsonIgnore
    public static boolean m22514k(GraphQLFeedback graphQLFeedback) {
        return m22507h(graphQLFeedback) != null && m22507h(graphQLFeedback).mo1407b();
    }

    @JsonIgnore
    public static int m22516m(GraphQLFeedback graphQLFeedback) {
        if (graphQLFeedback == null || m22526u(graphQLFeedback) == null) {
            return 0;
        }
        return m22526u(graphQLFeedback).m22588a();
    }

    private static GraphQLResharesOfContentConnection m22526u(GraphQLFeedback graphQLFeedback) {
        GraphQLResharesOfContentConnection H = graphQLFeedback.m23214H();
        if (H == null) {
            return f15764e;
        }
        return H;
    }

    @Deprecated
    private static GraphQLCommentsConnection m22527v(GraphQLFeedback graphQLFeedback) {
        if (graphQLFeedback.m23249p() == null) {
            return f15771l;
        }
        return graphQLFeedback.m23249p();
    }

    @Deprecated
    public static GraphQLTopLevelCommentsConnection m22518n(GraphQLFeedback graphQLFeedback) {
        if (m22528w(graphQLFeedback) == null) {
            return f15765f;
        }
        return m22528w(graphQLFeedback);
    }

    public static GraphQLLikersOfContentConnection m22520o(GraphQLFeedback graphQLFeedback) {
        if (graphQLFeedback == null || graphQLFeedback.m23209C() == null) {
            return f15772m;
        }
        return graphQLFeedback.m23209C();
    }

    public static int m22522p(GraphQLFeedback graphQLFeedback) {
        return m22520o(graphQLFeedback).mo2914a();
    }

    public static int m22523q(GraphQLFeedback graphQLFeedback) {
        return m22524r(graphQLFeedback).m22671a();
    }

    public static GraphQLReactorsOfContentConnection m22524r(GraphQLFeedback graphQLFeedback) {
        if (graphQLFeedback == null || graphQLFeedback.m23211E() == null) {
            return f15773n;
        }
        return graphQLFeedback.m23211E();
    }

    @Nullable
    private static GraphQLTopLevelCommentsConnection m22528w(GraphQLFeedback graphQLFeedback) {
        if (graphQLFeedback.m23218L() != null) {
            return graphQLFeedback.m23218L();
        }
        if (graphQLFeedback.m23210D() != null) {
            return graphQLFeedback.m23210D();
        }
        return null;
    }

    public static ArrayNode m22468a(HasTracking hasTracking, HasTracking hasTracking2) {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.f3121a);
        arrayNode.m13394h(hasTracking.mo2877k());
        if (!(hasTracking2 == null || hasTracking2.mo2877k() == null)) {
            arrayNode.m13394h(hasTracking2.mo2877k());
        }
        return arrayNode;
    }

    public static boolean m22525s(GraphQLFeedback graphQLFeedback) {
        if (graphQLFeedback == null) {
            return false;
        }
        GraphQLTopReactionsConnection a = GraphQLFeedbackHelper.m30217a(graphQLFeedback);
        if (a == null || a.m24899a() == null) {
            return false;
        }
        ImmutableList a2 = a.m24899a();
        int size = a2.size();
        for (int i = 0; i < size; i++) {
            if (((GraphQLTopReactionsEdge) a2.get(i)).m27553j() > 0) {
                return true;
            }
        }
        return false;
    }

    public static GraphQLRedSpaceVisibilityState m22511j(GraphQLStory graphQLStory) {
        if (graphQLStory == null) {
            return GraphQLRedSpaceVisibilityState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        GraphQLRedSpaceStoryInfo aq = graphQLStory.aq();
        if (aq == null) {
            return GraphQLRedSpaceVisibilityState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        return aq.m24721a();
    }

    public static String m22472a(GraphQLFeedUnitEdge graphQLFeedUnitEdge) {
        String b = graphQLFeedUnitEdge.m19080b();
        if (b == null && (graphQLFeedUnitEdge.mo2540c() instanceof GraphQLStory)) {
            return graphQLFeedUnitEdge.m19084d();
        }
        return b;
    }

    public static GraphQLEditHistoryConnection m22513k(GraphQLStory graphQLStory) {
        if (graphQLStory.m22338X() == null) {
            return f15762c;
        }
        return graphQLStory.m22338X();
    }

    public static boolean m22515l(GraphQLStory graphQLStory) {
        return (graphQLStory.m22338X() != null && graphQLStory.m22338X().m22578a() > 0) || PropertyHelper.m21282a(graphQLStory);
    }

    public static boolean m22517m(GraphQLStory graphQLStory) {
        return (graphQLStory.m22339Y() == null || graphQLStory.m22339Y().m24173z() == null || !IsValidUtil.m22949a(graphQLStory.m22339Y().m24173z())) ? false : true;
    }

    public static boolean m22519n(GraphQLStory graphQLStory) {
        GraphQLStoryAttachment o = StoryAttachmentHelper.m28042o(graphQLStory);
        return (o == null || o.m23987z() == null || o.m23987z().er() == null || !IsValidUtil.m22949a(o.m23987z().er())) ? false : true;
    }

    public static boolean m22521o(GraphQLStory graphQLStory) {
        return CollectionUtil.m29343b(graphQLStory.m22349b()) && graphQLStory.m22349b().get(0) != null && ((GraphQLActor) graphQLStory.m22349b().get(0)).m23790b() != null && ((GraphQLActor) graphQLStory.m22349b().get(0)).m23790b().m22301g() == 2479791;
    }
}
