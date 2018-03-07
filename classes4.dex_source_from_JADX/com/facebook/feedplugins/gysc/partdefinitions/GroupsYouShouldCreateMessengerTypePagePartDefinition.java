package com.facebook.feedplugins.gysc.partdefinitions;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.api.feedcache.mutator.FeedUnitCacheMutator;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feedplugins.gysc.partdefinitions.GroupsYouShouldCreateUtil.Props;
import com.facebook.feedplugins.gysc.partdefinitions.GroupsYouShouldCreateUtil.State;
import com.facebook.feedplugins.gysc.partdefinitions.GroupsYouShouldCreateUtil.State.Builder;
import com.facebook.feedplugins.gysc.views.GroupsYouShouldCreateMessengerTypeCardView;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.model.GraphQLGroupsYouShouldCreateFeedUnitItem;
import com.facebook.graphql.model.GraphQLUser;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

@ContextScoped
/* compiled from: num_au_manager_changed */
public class GroupsYouShouldCreateMessengerTypePagePartDefinition extends BaseSinglePartDefinitionWithViewType<Props, State, FeedEnvironment, GroupsYouShouldCreateMessengerTypeCardView> {
    public static final ViewType<GroupsYouShouldCreateMessengerTypeCardView> f6605a = new C02991();
    private static GroupsYouShouldCreateMessengerTypePagePartDefinition f6606j;
    private static final Object f6607k = new Object();
    private final NewsFeedAnalyticsEventBuilder f6608b;
    private final AnalyticsLogger f6609c;
    private final FbUriIntentHandler f6610d;
    private final Context f6611e;
    private final String f6612f;
    private final FeedUnitCacheMutator f6613g;
    private final GraphQLQueryExecutor f6614h;
    private final ExecutorService f6615i;

    /* compiled from: num_au_manager_changed */
    final class C02991 extends ViewType<GroupsYouShouldCreateMessengerTypeCardView> {
        C02991() {
        }

        public final View m7020a(Context context) {
            return new GroupsYouShouldCreateMessengerTypeCardView(context);
        }
    }

    private static GroupsYouShouldCreateMessengerTypePagePartDefinition m7015b(InjectorLike injectorLike) {
        return new GroupsYouShouldCreateMessengerTypePagePartDefinition((Context) injectorLike.getInstance(Context.class), FbUriIntentHandler.a(injectorLike), NewsFeedAnalyticsEventBuilder.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), String_LoggedInUserIdMethodAutoProvider.b(injectorLike), FeedUnitCacheMutator.a(injectorLike), GraphQLQueryExecutor.a(injectorLike));
    }

    public final Object m7017a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        FeedEnvironment feedEnvironment = (FeedEnvironment) anyEnvironment;
        GraphQLGroupsYouShouldCreateFeedUnitItem graphQLGroupsYouShouldCreateFeedUnitItem = props.b;
        OnClickListener a = GroupsYouShouldCreateUtil.a(props.a, graphQLGroupsYouShouldCreateFeedUnitItem, this.f6610d, this.f6611e, this.f6608b, this.f6609c, feedEnvironment.c().a());
        OnClickListener a2 = GroupsYouShouldCreateUtil.a(feedEnvironment.c().a(), this.f6612f, props.a, props.b, this.f6614h, this.f6613g, this.f6615i);
        int size = graphQLGroupsYouShouldCreateFeedUnitItem.n().size();
        String str = null;
        if (!(size <= 0 || graphQLGroupsYouShouldCreateFeedUnitItem.j() == null || graphQLGroupsYouShouldCreateFeedUnitItem.j().a() == null || graphQLGroupsYouShouldCreateFeedUnitItem.j().a().get(0) == null)) {
            str = ((GraphQLUser) graphQLGroupsYouShouldCreateFeedUnitItem.j().a().get(0)).ar();
        }
        Builder builder = new Builder();
        builder.a = a;
        Builder builder2 = builder;
        builder2.b = a2;
        Builder builder3 = builder2;
        builder3.d = size;
        builder3 = builder3;
        builder3.f = str;
        Builder builder4 = builder3;
        builder4.e = graphQLGroupsYouShouldCreateFeedUnitItem.n().size();
        builder4 = builder4;
        builder4.g = graphQLGroupsYouShouldCreateFeedUnitItem.a();
        builder4.h = GroupsYouShouldCreateUtil.a(graphQLGroupsYouShouldCreateFeedUnitItem);
        return builder.b();
    }

    public final /* bridge */ /* synthetic */ void m7018a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1908159739);
        State state = (State) obj2;
        GroupsYouShouldCreateMessengerTypeCardView groupsYouShouldCreateMessengerTypeCardView = (GroupsYouShouldCreateMessengerTypeCardView) view;
        groupsYouShouldCreateMessengerTypeCardView.setOnClickListener(state.a);
        groupsYouShouldCreateMessengerTypeCardView.setButtonOnclickListener(state.a);
        groupsYouShouldCreateMessengerTypeCardView.setSuggestGroupName(state.g);
        groupsYouShouldCreateMessengerTypeCardView.a(state.d, state.f);
        groupsYouShouldCreateMessengerTypeCardView.a(state.h, state.e);
        OnClickListener onClickListener = state.b;
        if (groupsYouShouldCreateMessengerTypeCardView.f == null) {
            groupsYouShouldCreateMessengerTypeCardView.f = groupsYouShouldCreateMessengerTypeCardView.findViewById(2131562744);
            groupsYouShouldCreateMessengerTypeCardView.f.setVisibility(0);
        }
        groupsYouShouldCreateMessengerTypeCardView.f.setOnClickListener(onClickListener);
        Logger.a(8, EntryType.MARK_POP, -1719724083, a);
    }

    public final void m7019b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        GroupsYouShouldCreateMessengerTypeCardView groupsYouShouldCreateMessengerTypeCardView = (GroupsYouShouldCreateMessengerTypeCardView) view;
        groupsYouShouldCreateMessengerTypeCardView.setButtonOnclickListener(null);
        groupsYouShouldCreateMessengerTypeCardView.setSuggestGroupName(null);
        groupsYouShouldCreateMessengerTypeCardView.a(0, null);
        groupsYouShouldCreateMessengerTypeCardView.a(null, 0);
    }

    public static GroupsYouShouldCreateMessengerTypePagePartDefinition m7014a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GroupsYouShouldCreateMessengerTypePagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6607k) {
                GroupsYouShouldCreateMessengerTypePagePartDefinition groupsYouShouldCreateMessengerTypePagePartDefinition;
                if (a2 != null) {
                    groupsYouShouldCreateMessengerTypePagePartDefinition = (GroupsYouShouldCreateMessengerTypePagePartDefinition) a2.a(f6607k);
                } else {
                    groupsYouShouldCreateMessengerTypePagePartDefinition = f6606j;
                }
                if (groupsYouShouldCreateMessengerTypePagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7015b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6607k, b3);
                        } else {
                            f6606j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = groupsYouShouldCreateMessengerTypePagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public GroupsYouShouldCreateMessengerTypePagePartDefinition(Context context, FbUriIntentHandler fbUriIntentHandler, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, AnalyticsLogger analyticsLogger, ExecutorService executorService, String str, FeedUnitCacheMutator feedUnitCacheMutator, GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f6611e = context;
        this.f6610d = fbUriIntentHandler;
        this.f6608b = newsFeedAnalyticsEventBuilder;
        this.f6609c = analyticsLogger;
        this.f6612f = str;
        this.f6613g = feedUnitCacheMutator;
        this.f6614h = graphQLQueryExecutor;
        this.f6615i = executorService;
    }

    public final ViewType<GroupsYouShouldCreateMessengerTypeCardView> m7016a() {
        return f6605a;
    }
}
