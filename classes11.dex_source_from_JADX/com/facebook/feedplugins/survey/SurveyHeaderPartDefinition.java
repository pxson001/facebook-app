package com.facebook.feedplugins.survey;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.MenuButtonPartDefinition;
import com.facebook.feed.rows.sections.header.MenuButtonPartDefinition.Props;
import com.facebook.feed.rows.sections.header.ui.HeaderView;
import com.facebook.feed.rows.sections.header.ui.MenuConfig;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.enums.GraphQLStructuredSurveyFlowType;
import com.facebook.graphql.model.GraphQLActorUtil;
import com.facebook.graphql.model.GraphQLSurveyFeedUnit;
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
import com.facebook.privacy.ui.DefaultPrivacyScopeResourceResolver;
import javax.inject.Inject;

@ContextScoped
/* compiled from: animating */
public class SurveyHeaderPartDefinition<E extends HasPositionInformation & HasMenuButtonProvider & HasPersistentState> extends MultiRowSinglePartDefinition<FeedProps<GraphQLSurveyFeedUnit>, State, E, HeaderView> {
    public static final CallerContext f9890a = CallerContext.a(SurveyHeaderPartDefinition.class, "native_newsfeed");
    private static SurveyHeaderPartDefinition f9891g;
    private static final Object f9892h = new Object();
    private final BackgroundPartDefinition f9893b;
    private final MenuButtonPartDefinition f9894c;
    private final DefaultPrivacyScopeResourceResolver f9895d;
    private final SurveyHeaderTitlePartDefinition f9896e;
    private final Resources f9897f;

    /* compiled from: animating */
    public class State {
        public final SurveyPersistentState f9886a;
        public final String f9887b;
        public final int f9888c;
        public final Uri f9889d;

        public State(SurveyPersistentState surveyPersistentState, String str, int i, Uri uri) {
            this.f9886a = surveyPersistentState;
            this.f9887b = str;
            this.f9888c = i;
            this.f9889d = uri;
        }
    }

    private static SurveyHeaderPartDefinition m10263b(InjectorLike injectorLike) {
        return new SurveyHeaderPartDefinition(BackgroundPartDefinition.a(injectorLike), MenuButtonPartDefinition.a(injectorLike), DefaultPrivacyScopeResourceResolver.a(injectorLike), SurveyHeaderTitlePartDefinition.m10274a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final Object m10265a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        GraphQLSurveyFeedUnit graphQLSurveyFeedUnit = (GraphQLSurveyFeedUnit) feedProps.a;
        subParts.a(this.f9893b, new StylingData(feedProps, PaddingStyle.i));
        subParts.a(2131560877, this.f9894c, new Props(feedProps, MenuConfig.CLICKABLE));
        subParts.a(2131562765, this.f9896e, graphQLSurveyFeedUnit);
        int a = this.f9895d.a("only_me");
        String string = this.f9897f.getString(2131233390);
        SurveyPersistentState surveyPersistentState = (SurveyPersistentState) ((HasPersistentState) hasPositionInformation).a(new SurveyStoryKey(graphQLSurveyFeedUnit), graphQLSurveyFeedUnit);
        String c = GraphQLActorUtil.c(graphQLSurveyFeedUnit.r());
        return new State(surveyPersistentState, string, a, c != null ? Uri.parse(c) : null);
    }

    public final /* bridge */ /* synthetic */ void m10266a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -880986620);
        State state = (State) obj2;
        HeaderView headerView = (HeaderView) view;
        GraphQLSurveyFeedUnit graphQLSurveyFeedUnit = (GraphQLSurveyFeedUnit) ((FeedProps) obj).a;
        headerView.a(state.f9889d, f9890a);
        m10262a(headerView, state, graphQLSurveyFeedUnit);
        Logger.a(8, EntryType.MARK_POP, 1863123463, a);
    }

    public static SurveyHeaderPartDefinition m10261a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SurveyHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9892h) {
                SurveyHeaderPartDefinition surveyHeaderPartDefinition;
                if (a2 != null) {
                    surveyHeaderPartDefinition = (SurveyHeaderPartDefinition) a2.a(f9892h);
                } else {
                    surveyHeaderPartDefinition = f9891g;
                }
                if (surveyHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10263b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9892h, b3);
                        } else {
                            f9891g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = surveyHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SurveyHeaderPartDefinition(BackgroundPartDefinition backgroundPartDefinition, MenuButtonPartDefinition menuButtonPartDefinition, DefaultPrivacyScopeResourceResolver defaultPrivacyScopeResourceResolver, SurveyHeaderTitlePartDefinition surveyHeaderTitlePartDefinition, Resources resources) {
        this.f9893b = backgroundPartDefinition;
        this.f9894c = menuButtonPartDefinition;
        this.f9895d = defaultPrivacyScopeResourceResolver;
        this.f9896e = surveyHeaderTitlePartDefinition;
        this.f9897f = resources;
    }

    public final boolean m10267a(Object obj) {
        return true;
    }

    public final ViewType m10264a() {
        return HeaderView.h;
    }

    public static void m10262a(HeaderView headerView, State state, GraphQLSurveyFeedUnit graphQLSurveyFeedUnit) {
        if (graphQLSurveyFeedUnit.E().b || state.f9886a.f9925a == com.facebook.feedplugins.survey.SurveyPersistentState.State.COMPLETE) {
            headerView.a(null, null);
            return;
        }
        CharSequence a;
        int i = state.f9886a.f9926b;
        int size = graphQLSurveyFeedUnit.s().m().a().size();
        GraphQLStructuredSurveyFlowType n = graphQLSurveyFeedUnit.s().n();
        if (n == GraphQLStructuredSurveyFlowType.LINEAR || n == GraphQLStructuredSurveyFlowType.RANDOMIZED) {
            a = StringLocaleUtil.a("%s %d/%d ", new Object[]{state.f9887b, Integer.valueOf(i), Integer.valueOf(size)});
        } else {
            a = StringLocaleUtil.a("%s %d", new Object[]{state.f9887b, Integer.valueOf(i)});
        }
        headerView.a(a, null);
        headerView.setSubtitleIcon(state.f9888c);
    }
}
