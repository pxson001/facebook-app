package com.facebook.feedplugins.researchpoll;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feedplugins.researchpoll.views.ResearchPollResultView;
import com.facebook.graphql.model.GraphQLResearchPollFeedUnit;
import com.facebook.graphql.model.GraphQLResearchPollMultipleChoiceQuestion;
import com.facebook.graphql.model.ItemListFeedUnitImpl;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: calendar_access_level */
public class ResearchPollSingleResultPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLResearchPollFeedUnit>, Void, HasPositionInformation, ResearchPollResultView> {
    public static final ViewType f9088a = new C10981();
    private static ResearchPollSingleResultPartDefinition f9089d;
    private static final Object f9090e = new Object();
    private final BackgroundPartDefinition f9091b;
    private final ResultItemPartDefinition f9092c;

    /* compiled from: calendar_access_level */
    final class C10981 extends ViewType {
        C10981() {
        }

        public final View m9777a(Context context) {
            return new ResearchPollResultView(context);
        }
    }

    private static ResearchPollSingleResultPartDefinition m9779b(InjectorLike injectorLike) {
        return new ResearchPollSingleResultPartDefinition(BackgroundPartDefinition.a(injectorLike), ResultItemPartDefinition.a(injectorLike));
    }

    public final Object m9781a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        ImmutableList a = ItemListFeedUnitImpl.a((GraphQLResearchPollFeedUnit) feedProps.a);
        subParts.a(this.f9091b, new StylingData(feedProps, PaddingStyle.a));
        subParts.a(this.f9092c, new ResultItemPartDefinition$Props((GraphQLResearchPollMultipleChoiceQuestion) a.get(0), ResearchPollUnitHelper.m9817a(a)));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m9782a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        Object obj3;
        int a = Logger.a(8, EntryType.MARK_PUSH, -965482996);
        ResearchPollResultView researchPollResultView = (ResearchPollResultView) view;
        GraphQLResearchPollFeedUnit graphQLResearchPollFeedUnit = (GraphQLResearchPollFeedUnit) ((FeedProps) obj).a;
        if (graphQLResearchPollFeedUnit.H().n() != 0 || graphQLResearchPollFeedUnit.U().b) {
            obj3 = 1;
        } else {
            obj3 = null;
        }
        researchPollResultView.setVisibility(obj3 != null ? 0 : 8);
        Logger.a(8, EntryType.MARK_POP, 840784288, a);
    }

    public final boolean m9783a(Object obj) {
        GraphQLResearchPollFeedUnit graphQLResearchPollFeedUnit = (GraphQLResearchPollFeedUnit) ((FeedProps) obj).a;
        return graphQLResearchPollFeedUnit.x().size() == 1 && ResearchPollUnitHelper.m9821a(graphQLResearchPollFeedUnit);
    }

    @Inject
    public ResearchPollSingleResultPartDefinition(BackgroundPartDefinition backgroundPartDefinition, ResultItemPartDefinition resultItemPartDefinition) {
        this.f9091b = backgroundPartDefinition;
        this.f9092c = resultItemPartDefinition;
    }

    public final ViewType m9780a() {
        return f9088a;
    }

    public static ResearchPollSingleResultPartDefinition m9778a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ResearchPollSingleResultPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9090e) {
                ResearchPollSingleResultPartDefinition researchPollSingleResultPartDefinition;
                if (a2 != null) {
                    researchPollSingleResultPartDefinition = (ResearchPollSingleResultPartDefinition) a2.a(f9090e);
                } else {
                    researchPollSingleResultPartDefinition = f9089d;
                }
                if (researchPollSingleResultPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9779b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9090e, b3);
                        } else {
                            f9089d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = researchPollSingleResultPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
