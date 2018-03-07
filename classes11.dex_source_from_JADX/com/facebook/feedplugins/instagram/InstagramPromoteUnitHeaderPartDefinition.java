package com.facebook.feedplugins.instagram;

import android.content.Context;
import android.view.View;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.unicode.RangeConverter;
import com.facebook.common.unicode.UTF16Range;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.thirdparty.instagram.InstagramEntryPoint;
import com.facebook.feed.thirdparty.instagram.InstagramUtils;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLEntity;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLInstagramPhotosFromFriendsFeedUnit;
import com.facebook.graphql.model.GraphQLInstagramPhotosFromFriendsFeedUnitItem;
import com.facebook.graphql.model.GraphQLPhoto;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.fragments.GraphQLTextWithEntitiesFields;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.linkify.LinkifyTargetBuilder;
import com.facebook.linkify.LinkifyTargetGraphQLInterfaces.LinkifyTargetGraphQL;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.TextPartDefinition;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: crashInfo */
public class InstagramPromoteUnitHeaderPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLInstagramPhotosFromFriendsFeedUnit>, GraphQLTextWithEntitiesFields, HasPositionInformation, InstagramPromoteUnitHeaderView> {
    private static InstagramPromoteUnitHeaderPartDefinition f7933e;
    private static final Object f7934f = new Object();
    private final Context f7935a;
    private final InstagramUtils f7936b;
    private final BackgroundPartDefinition f7937c;
    private final TextPartDefinition f7938d;

    private static InstagramPromoteUnitHeaderPartDefinition m9024b(InjectorLike injectorLike) {
        return new InstagramPromoteUnitHeaderPartDefinition((Context) injectorLike.getInstance(Context.class), InstagramUtils.a(injectorLike), BackgroundPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m9028a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLInstagramPhotosFromFriendsFeedUnit graphQLInstagramPhotosFromFriendsFeedUnit = (GraphQLInstagramPhotosFromFriendsFeedUnit) feedProps.a;
        this.f7936b.b(InstagramEntryPoint.Ego);
        subParts.a(this.f7937c, new StylingData(feedProps, PaddingStyle.j));
        if (this.f7936b.j()) {
            return m9025b(graphQLInstagramPhotosFromFriendsFeedUnit);
        }
        Object string;
        if (this.f7936b.d() > 0) {
            string = this.f7935a.getResources().getString(2131233572, new Object[]{Integer.valueOf(r1)});
        } else {
            int size = graphQLInstagramPhotosFromFriendsFeedUnit.l().size();
            string = this.f7935a.getResources().getString(2131233568, new Object[]{Integer.valueOf(size)});
        }
        subParts.a(2131562912, this.f7938d, string);
        return null;
    }

    public final /* bridge */ /* synthetic */ void m9029a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 259832935);
        GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) obj2;
        InstagramPromoteUnitHeaderView instagramPromoteUnitHeaderView = (InstagramPromoteUnitHeaderView) view;
        if (graphQLTextWithEntities != null) {
            instagramPromoteUnitHeaderView.setTextWithEntities(graphQLTextWithEntities);
        }
        Logger.a(8, EntryType.MARK_POP, -516728457, a);
    }

    @Inject
    public InstagramPromoteUnitHeaderPartDefinition(Context context, InstagramUtils instagramUtils, BackgroundPartDefinition backgroundPartDefinition, TextPartDefinition textPartDefinition) {
        this.f7935a = context;
        this.f7936b = instagramUtils;
        this.f7937c = backgroundPartDefinition;
        this.f7938d = textPartDefinition;
    }

    public static InstagramPromoteUnitHeaderPartDefinition m9020a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InstagramPromoteUnitHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7934f) {
                InstagramPromoteUnitHeaderPartDefinition instagramPromoteUnitHeaderPartDefinition;
                if (a2 != null) {
                    instagramPromoteUnitHeaderPartDefinition = (InstagramPromoteUnitHeaderPartDefinition) a2.a(f7934f);
                } else {
                    instagramPromoteUnitHeaderPartDefinition = f7933e;
                }
                if (instagramPromoteUnitHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9024b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7934f, b3);
                        } else {
                            f7933e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = instagramPromoteUnitHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m9027a() {
        return InstagramPromoteUnitHeaderView.f7939a;
    }

    public final boolean m9030a(Object obj) {
        return true;
    }

    private GraphQLEntity m9026c() {
        String str = "162454007121996";
        return GraphQLHelper.a(str, new GraphQLObjectType(2479791), FBLinks.a("page/" + str));
    }

    private static GraphQLActor m9021a(GraphQLInstagramPhotosFromFriendsFeedUnit graphQLInstagramPhotosFromFriendsFeedUnit) {
        ImmutableList o = graphQLInstagramPhotosFromFriendsFeedUnit.o();
        int size = o.size();
        for (int i = 0; i < size; i++) {
            ImmutableList a = ((GraphQLInstagramPhotosFromFriendsFeedUnitItem) o.get(i)).a();
            int size2 = a.size();
            for (int i2 = 0; i2 < size2; i2++) {
                GraphQLActor aB = ((GraphQLPhoto) a.get(i2)).aB();
                if (aB != null) {
                    return aB;
                }
            }
        }
        return null;
    }

    private GraphQLTextWithEntities m9025b(GraphQLInstagramPhotosFromFriendsFeedUnit graphQLInstagramPhotosFromFriendsFeedUnit) {
        Object l;
        GraphQLEntity graphQLEntity;
        String a;
        ImmutableList o = graphQLInstagramPhotosFromFriendsFeedUnit.o();
        if (o.size() > 0) {
            l = ((GraphQLInstagramPhotosFromFriendsFeedUnitItem) o.get(0)).l();
        } else {
            l = null;
        }
        GraphQLActor a2 = m9021a(graphQLInstagramPhotosFromFriendsFeedUnit);
        List arrayList = new ArrayList();
        LinkifyTargetGraphQL a3 = LinkifyTargetBuilder.a(a2);
        if (a3 == null) {
            graphQLEntity = null;
        } else {
            String d = a3.d();
            graphQLEntity = GraphQLHelper.a(d, a3.b(), FBLinks.a("profile/" + d));
        }
        GraphQLEntity graphQLEntity2 = graphQLEntity;
        String aa = a2.aa();
        int parseInt = StringUtil.a(l) ? 0 : Integer.parseInt(l) - 1;
        if (parseInt <= 0) {
            a = m9022a(aa);
            arrayList.add(GraphQLHelper.a(graphQLEntity2, RangeConverter.a(a, new UTF16Range(a.indexOf(aa), aa.length()))));
        } else {
            a = m9023a(aa, parseInt);
            arrayList.add(GraphQLHelper.a(graphQLEntity2, RangeConverter.a(a, new UTF16Range(a.indexOf(aa), aa.length()))));
        }
        String str = "Instagram";
        if (str != aa) {
            arrayList.add(GraphQLHelper.a(m9026c(), RangeConverter.a(a, new UTF16Range(a.indexOf(str), str.length()))));
        }
        return GraphQLHelper.a(a, arrayList, null, null);
    }

    private String m9022a(String str) {
        return this.f7935a.getResources().getString(2131233569, new Object[]{str, "Instagram"});
    }

    private String m9023a(String str, int i) {
        return this.f7935a.getResources().getString(2131233571, new Object[]{str, Integer.valueOf(i), "Instagram"});
    }
}
