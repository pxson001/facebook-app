package com.facebook.goodwill.feed.rows;

import android.content.Context;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.goodwill.feed.rows.ThrowbackFeedStorySectionHeaderPartDefinition.Props;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackFriendListEdge;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackFriendversaryStory;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.GraphQLUser;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.multirow.api.MultiRowSubParts;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fb4a_iab_spin_user_interaction */
public class ThrowbackFriendversaryGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLGoodwillThrowbackFriendversaryStory>, Void, FeedEnvironment> {
    private static ThrowbackFriendversaryGroupPartDefinition f13713g;
    private static final Object f13714h = new Object();
    private final ThrowbackFeedStorySectionHeaderPartDefinition f13715a;
    private final ThrowbackFriendversaryHeaderPartDefinition f13716b;
    private final ThrowbackFriendversaryFriendPartDefinitionProvider f13717c;
    private final ThrowbackFriendversaryAggregatedFriendListItemPartDefinition f13718d;
    private final ThrowbackFriendversaryFooterPartDefinition f13719e;
    private final AbstractFbErrorReporter f13720f;

    private static ThrowbackFriendversaryGroupPartDefinition m15403b(InjectorLike injectorLike) {
        return new ThrowbackFriendversaryGroupPartDefinition(ThrowbackFeedStorySectionHeaderPartDefinition.m15323a(injectorLike), ThrowbackFriendversaryAggregatedFriendListItemPartDefinition.m15348a(injectorLike), ThrowbackFriendversaryHeaderPartDefinition.m15406a(injectorLike), (ThrowbackFriendversaryFriendPartDefinitionProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ThrowbackFriendversaryFriendPartDefinitionProvider.class), ThrowbackFriendversaryFooterPartDefinition.m15383a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ Object m15404a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        return m15402a(baseMultiRowSubParts, (FeedProps) obj);
    }

    public final boolean m15405a(Object obj) {
        GraphQLGoodwillThrowbackFriendversaryStory graphQLGoodwillThrowbackFriendversaryStory = (GraphQLGoodwillThrowbackFriendversaryStory) ((FeedProps) obj).a;
        return (graphQLGoodwillThrowbackFriendversaryStory.l() == null || graphQLGoodwillThrowbackFriendversaryStory.l().a() == null || graphQLGoodwillThrowbackFriendversaryStory.l().a().isEmpty()) ? false : true;
    }

    @Inject
    public ThrowbackFriendversaryGroupPartDefinition(ThrowbackFeedStorySectionHeaderPartDefinition throwbackFeedStorySectionHeaderPartDefinition, ThrowbackFriendversaryAggregatedFriendListItemPartDefinition throwbackFriendversaryAggregatedFriendListItemPartDefinition, ThrowbackFriendversaryHeaderPartDefinition throwbackFriendversaryHeaderPartDefinition, ThrowbackFriendversaryFriendPartDefinitionProvider throwbackFriendversaryFriendPartDefinitionProvider, ThrowbackFriendversaryFooterPartDefinition throwbackFriendversaryFooterPartDefinition, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f13715a = throwbackFeedStorySectionHeaderPartDefinition;
        this.f13718d = throwbackFriendversaryAggregatedFriendListItemPartDefinition;
        this.f13716b = throwbackFriendversaryHeaderPartDefinition;
        this.f13717c = throwbackFriendversaryFriendPartDefinitionProvider;
        this.f13719e = throwbackFriendversaryFooterPartDefinition;
        this.f13720f = abstractFbErrorReporter;
    }

    public static ThrowbackFriendversaryGroupPartDefinition m15401a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackFriendversaryGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f13714h) {
                ThrowbackFriendversaryGroupPartDefinition throwbackFriendversaryGroupPartDefinition;
                if (a2 != null) {
                    throwbackFriendversaryGroupPartDefinition = (ThrowbackFriendversaryGroupPartDefinition) a2.a(f13714h);
                } else {
                    throwbackFriendversaryGroupPartDefinition = f13713g;
                }
                if (throwbackFriendversaryGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m15403b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f13714h, b3);
                        } else {
                            f13713g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackFriendversaryGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private Void m15402a(MultiRowSubParts<FeedEnvironment> multiRowSubParts, FeedProps<GraphQLGoodwillThrowbackFriendversaryStory> feedProps) {
        GraphQLGoodwillThrowbackFriendversaryStory graphQLGoodwillThrowbackFriendversaryStory = (GraphQLGoodwillThrowbackFriendversaryStory) feedProps.a;
        if ("redesign_v1".equals(graphQLGoodwillThrowbackFriendversaryStory.n())) {
            multiRowSubParts.a(this.f13715a, new Props(feedProps, graphQLGoodwillThrowbackFriendversaryStory.o(), true));
        } else {
            multiRowSubParts.a(this.f13716b, feedProps);
        }
        int i = 0;
        int size = graphQLGoodwillThrowbackFriendversaryStory.l().a().size();
        ImmutableList a = graphQLGoodwillThrowbackFriendversaryStory.l().a();
        int size2 = a.size();
        int i2 = 0;
        while (i2 < size2) {
            int i3;
            GraphQLGoodwillThrowbackFriendListEdge graphQLGoodwillThrowbackFriendListEdge = (GraphQLGoodwillThrowbackFriendListEdge) a.get(i2);
            if (graphQLGoodwillThrowbackFriendListEdge.a() != null) {
                int i4 = i + 1;
                if ("redesign_v1".equals(graphQLGoodwillThrowbackFriendversaryStory.n())) {
                    boolean z;
                    Object obj = (i4 == 3 || i4 == size) ? 1 : null;
                    ThrowbackFriendversaryAggregatedFriendListItemPartDefinition throwbackFriendversaryAggregatedFriendListItemPartDefinition = this.f13718d;
                    GraphQLUser a2 = graphQLGoodwillThrowbackFriendListEdge.a();
                    GraphQLTextWithEntities j = graphQLGoodwillThrowbackFriendListEdge.j();
                    if (obj == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    multiRowSubParts.a(throwbackFriendversaryAggregatedFriendListItemPartDefinition, new ThrowbackFriendversaryAggregatedFriendListProps(feedProps, a2, j, z));
                } else {
                    multiRowSubParts.a(this.f13717c.m15392a(Boolean.valueOf(i4 == size)), graphQLGoodwillThrowbackFriendListEdge.a());
                }
                if (i4 >= 3) {
                    break;
                }
                i3 = i4;
            } else {
                this.f13720f.b("ThrowbackFriendversaryGroupPartDefinition_null_friend_edge", "Received null friend edge");
                i3 = i;
            }
            i2++;
            i = i3;
        }
        multiRowSubParts.a(this.f13719e, graphQLGoodwillThrowbackFriendversaryStory);
        return null;
    }
}
