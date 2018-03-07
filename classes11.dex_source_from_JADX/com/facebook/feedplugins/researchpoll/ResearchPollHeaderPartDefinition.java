package com.facebook.feedplugins.researchpoll;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasMenuButtonProvider;
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
import com.facebook.graphql.linkutil.GraphQLLinkExtractor;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLActorUtil;
import com.facebook.graphql.model.GraphQLResearchPollFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.privacy.ui.DefaultPrivacyScopeResourceResolver;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.inject.Inject;

@ContextScoped
/* compiled from: camera_session_id */
public class ResearchPollHeaderPartDefinition<E extends HasPositionInformation & HasMenuButtonProvider> extends MultiRowSinglePartDefinition<FeedProps<GraphQLResearchPollFeedUnit>, State, E, HeaderView> {
    public static final CallerContext f9050a = CallerContext.a(ResearchPollHeaderPartDefinition.class, "native_newsfeed");
    private static ResearchPollHeaderPartDefinition f9051h;
    private static final Object f9052i = new Object();
    private final BackgroundPartDefinition f9053b;
    private final MenuButtonPartDefinition f9054c;
    private final DefaultPrivacyScopeResourceResolver f9055d;
    public final GraphQLLinkExtractor f9056e;
    public final IFeedIntentBuilder f9057f;
    private final ResearchPollHeaderTitlePartDefinition f9058g;

    /* compiled from: camera_session_id */
    public class State {
        public final OnClickListener f9046a;
        public final Uri f9047b;
        public final String f9048c;
        public final int f9049d;

        public State(OnClickListener onClickListener, Uri uri, String str, int i) {
            this.f9046a = onClickListener;
            this.f9047b = uri;
            this.f9048c = str;
            this.f9049d = i;
        }
    }

    private static ResearchPollHeaderPartDefinition m9746b(InjectorLike injectorLike) {
        return new ResearchPollHeaderPartDefinition(BackgroundPartDefinition.a(injectorLike), MenuButtonPartDefinition.a(injectorLike), DefaultPrivacyScopeResourceResolver.a(injectorLike), GraphQLLinkExtractor.a(injectorLike), (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(injectorLike), ResearchPollHeaderTitlePartDefinition.m9756a(injectorLike));
    }

    public final Object m9748a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        Uri uri = null;
        GraphQLResearchPollFeedUnit graphQLResearchPollFeedUnit = (GraphQLResearchPollFeedUnit) feedProps.a;
        subParts.a(this.f9053b, new StylingData(feedProps, PaddingStyle.i));
        subParts.a(2131560877, this.f9054c, new Props(feedProps, MenuConfig.CLICKABLE));
        subParts.a(2131562765, this.f9058g, graphQLResearchPollFeedUnit);
        final GraphQLActor j = graphQLResearchPollFeedUnit.H().j();
        OnClickListener c10961 = new OnClickListener(this) {
            final /* synthetic */ ResearchPollHeaderPartDefinition f9045b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1878346300);
                ResearchPollHeaderPartDefinition researchPollHeaderPartDefinition = this.f9045b;
                GraphQLActor graphQLActor = j;
                String a2 = researchPollHeaderPartDefinition.f9056e.a(graphQLActor.b(), graphQLActor.H());
                if (a2 == null) {
                    a2 = graphQLActor.aw();
                }
                String str = a2;
                if (str == null) {
                    Logger.a(2, EntryType.UI_INPUT_END, -477725007, a);
                    return;
                }
                this.f9045b.f9057f.a(view.getContext(), str, null, null);
                LogUtils.a(-12170572, a);
            }
        };
        String c = GraphQLActorUtil.c(j) != null ? GraphQLActorUtil.c(j) : null;
        if (c != null) {
            uri = Uri.parse(c);
        }
        return new State(c10961, uri, graphQLResearchPollFeedUnit.M(), this.f9055d.a("only_me"));
    }

    public final /* bridge */ /* synthetic */ void m9749a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -937534043);
        State state = (State) obj2;
        HeaderView headerView = (HeaderView) view;
        headerView.setProfileImageOnClickListener(state.f9046a);
        headerView.a(state.f9047b, f9050a);
        headerView.a(state.f9048c, null);
        headerView.setSubtitleIcon(state.f9049d);
        Logger.a(8, EntryType.MARK_POP, -1689894037, a);
    }

    public final void m9751b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((HeaderView) view).setProfileImageOnClickListener(null);
    }

    public static ResearchPollHeaderPartDefinition m9745a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ResearchPollHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9052i) {
                ResearchPollHeaderPartDefinition researchPollHeaderPartDefinition;
                if (a2 != null) {
                    researchPollHeaderPartDefinition = (ResearchPollHeaderPartDefinition) a2.a(f9052i);
                } else {
                    researchPollHeaderPartDefinition = f9051h;
                }
                if (researchPollHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9746b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9052i, b3);
                        } else {
                            f9051h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = researchPollHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ResearchPollHeaderPartDefinition(BackgroundPartDefinition backgroundPartDefinition, MenuButtonPartDefinition menuButtonPartDefinition, DefaultPrivacyScopeResourceResolver defaultPrivacyScopeResourceResolver, GraphQLLinkExtractor graphQLLinkExtractor, IFeedIntentBuilder iFeedIntentBuilder, ResearchPollHeaderTitlePartDefinition researchPollHeaderTitlePartDefinition) {
        this.f9053b = backgroundPartDefinition;
        this.f9054c = menuButtonPartDefinition;
        this.f9055d = defaultPrivacyScopeResourceResolver;
        this.f9056e = graphQLLinkExtractor;
        this.f9057f = iFeedIntentBuilder;
        this.f9058g = researchPollHeaderTitlePartDefinition;
    }

    public final boolean m9750a(Object obj) {
        return true;
    }

    public final ViewType m9747a() {
        return HeaderView.h;
    }
}
