package com.facebook.feedplugins.pysf.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollRecyclerViewRowType;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyle;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyleFactory;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSubParts;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition.Props;
import com.facebook.feed.rows.sections.hscrollrecyclerview.SimpleCallbacks;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.graphql.model.GraphQLPeopleYouShouldFollowFeedUnit;
import com.facebook.graphql.model.GraphQLPeopleYouShouldFollowFeedUnitItem;
import com.facebook.graphql.model.VisibleItemHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: checksum */
public class PeopleYouShouldFollowRecyclerViewPartDefinition<E extends HasPositionInformation & HasPersistentState & HasContext> extends MultiRowSinglePartDefinition<FeedProps<GraphQLPeopleYouShouldFollowFeedUnit>, Void, E, HScrollRecyclerView> {
    private static PeopleYouShouldFollowRecyclerViewPartDefinition f8828e;
    private static final Object f8829f = new Object();
    private final BackgroundPartDefinition f8830a;
    private final PageStyleFactory f8831b;
    private final PersistentRecyclerPartDefinition<Object, E> f8832c;
    public final PersonYouShouldFollowPagePartDefinition f8833d;

    private static PeopleYouShouldFollowRecyclerViewPartDefinition m9588b(InjectorLike injectorLike) {
        return new PeopleYouShouldFollowRecyclerViewPartDefinition(BackgroundPartDefinition.a(injectorLike), PageStyleFactory.b(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike), PersonYouShouldFollowPagePartDefinition.a(injectorLike));
    }

    public final Object m9590a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        final GraphQLPeopleYouShouldFollowFeedUnit graphQLPeopleYouShouldFollowFeedUnit = (GraphQLPeopleYouShouldFollowFeedUnit) feedProps.a;
        subParts.a(this.f8830a, new StylingData(feedProps, PageStyle.a));
        PersistentRecyclerPartDefinition persistentRecyclerPartDefinition = this.f8832c;
        PageStyle a = this.f8831b.a(PageStyle.a);
        int ac_ = graphQLPeopleYouShouldFollowFeedUnit.ac_();
        final ImmutableList o = graphQLPeopleYouShouldFollowFeedUnit.o();
        subParts.a(persistentRecyclerPartDefinition, new Props(a, ac_, new SimpleCallbacks<E>(this) {
            final /* synthetic */ PeopleYouShouldFollowRecyclerViewPartDefinition f8827c;

            public final void m9585a(PageSubParts<E> pageSubParts) {
                int size = o.size();
                for (int i = 0; i < size; i++) {
                    GraphQLPeopleYouShouldFollowFeedUnitItem graphQLPeopleYouShouldFollowFeedUnitItem = (GraphQLPeopleYouShouldFollowFeedUnitItem) o.get(i);
                    if (!graphQLPeopleYouShouldFollowFeedUnitItem.m().ad()) {
                        pageSubParts.a(this.f8827c.f8833d, new PersonYouShouldFollowPagePartDefinition$Props(graphQLPeopleYouShouldFollowFeedUnit, graphQLPeopleYouShouldFollowFeedUnitItem));
                    }
                }
            }

            public final void m9586c(int i) {
                VisibleItemHelper.a(graphQLPeopleYouShouldFollowFeedUnit, o, i);
            }
        }, graphQLPeopleYouShouldFollowFeedUnit.g(), graphQLPeopleYouShouldFollowFeedUnit));
        return null;
    }

    @Inject
    public PeopleYouShouldFollowRecyclerViewPartDefinition(BackgroundPartDefinition backgroundPartDefinition, PageStyleFactory pageStyleFactory, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, PersonYouShouldFollowPagePartDefinition personYouShouldFollowPagePartDefinition) {
        this.f8830a = backgroundPartDefinition;
        this.f8831b = pageStyleFactory;
        this.f8832c = persistentRecyclerPartDefinition;
        this.f8833d = personYouShouldFollowPagePartDefinition;
    }

    public final ViewType m9589a() {
        return HScrollRecyclerViewRowType.a;
    }

    public static PeopleYouShouldFollowRecyclerViewPartDefinition m9587a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PeopleYouShouldFollowRecyclerViewPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8829f) {
                PeopleYouShouldFollowRecyclerViewPartDefinition peopleYouShouldFollowRecyclerViewPartDefinition;
                if (a2 != null) {
                    peopleYouShouldFollowRecyclerViewPartDefinition = (PeopleYouShouldFollowRecyclerViewPartDefinition) a2.a(f8829f);
                } else {
                    peopleYouShouldFollowRecyclerViewPartDefinition = f8828e;
                }
                if (peopleYouShouldFollowRecyclerViewPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9588b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8829f, b3);
                        } else {
                            f8828e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = peopleYouShouldFollowRecyclerViewPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m9591a(Object obj) {
        return true;
    }
}
