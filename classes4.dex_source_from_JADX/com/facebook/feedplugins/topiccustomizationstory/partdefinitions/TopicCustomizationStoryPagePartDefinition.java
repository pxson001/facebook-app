package com.facebook.feedplugins.topiccustomizationstory.partdefinitions;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feedplugins.topiccustomizationstory.partdefinitions.TopicCustomizationStoryUtil.Props;
import com.facebook.feedplugins.topiccustomizationstory.views.TopicCustomizationStoryCardView;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.model.GraphQLTrueTopicFeedOption;
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
/* compiled from: notification_dismissed_from_tray */
public class TopicCustomizationStoryPagePartDefinition extends BaseSinglePartDefinitionWithViewType<Props, State, FeedEnvironment, TopicCustomizationStoryCardView> {
    public static final ViewType<TopicCustomizationStoryCardView> f6858a = new C03231();
    private static TopicCustomizationStoryPagePartDefinition f6859g;
    private static final Object f6860h = new Object();
    private final ExecutorService f6861b;
    private final String f6862c;
    private final GraphQLQueryExecutor f6863d;
    private final NewsFeedAnalyticsEventBuilder f6864e;
    private final AnalyticsLogger f6865f;

    /* compiled from: notification_dismissed_from_tray */
    final class C03231 extends ViewType<TopicCustomizationStoryCardView> {
        C03231() {
        }

        public final View m7208a(Context context) {
            return new TopicCustomizationStoryCardView(context);
        }
    }

    private static TopicCustomizationStoryPagePartDefinition m7203b(InjectorLike injectorLike) {
        return new TopicCustomizationStoryPagePartDefinition((ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), String_LoggedInUserIdMethodAutoProvider.b(injectorLike), GraphQLQueryExecutor.a(injectorLike), NewsFeedAnalyticsEventBuilder.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    public final Object m7205a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        return new State(props.b.m().b(), TopicCustomizationStoryUtil.a(this.f6862c, props, this.f6863d, this.f6861b, this.f6864e, this.f6865f));
    }

    public final /* bridge */ /* synthetic */ void m7206a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1622868096);
        State state = (State) obj2;
        TopicCustomizationStoryCardView topicCustomizationStoryCardView = (TopicCustomizationStoryCardView) view;
        GraphQLTrueTopicFeedOption graphQLTrueTopicFeedOption = ((Props) obj).b;
        topicCustomizationStoryCardView.c.a(Uri.parse(state.a), TopicCustomizationStoryCardView.a);
        topicCustomizationStoryCardView.c.setVisibility(0);
        topicCustomizationStoryCardView.a(Boolean.valueOf(graphQLTrueTopicFeedOption.l()), graphQLTrueTopicFeedOption.j());
        topicCustomizationStoryCardView.setOnClickListener(state.b);
        topicCustomizationStoryCardView.a(graphQLTrueTopicFeedOption.n().l(), graphQLTrueTopicFeedOption.j());
        Logger.a(8, EntryType.MARK_POP, -449085890, a);
    }

    public final void m7207b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((TopicCustomizationStoryCardView) view).setOnClickListener(null);
    }

    public static TopicCustomizationStoryPagePartDefinition m7202a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TopicCustomizationStoryPagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6860h) {
                TopicCustomizationStoryPagePartDefinition topicCustomizationStoryPagePartDefinition;
                if (a2 != null) {
                    topicCustomizationStoryPagePartDefinition = (TopicCustomizationStoryPagePartDefinition) a2.a(f6860h);
                } else {
                    topicCustomizationStoryPagePartDefinition = f6859g;
                }
                if (topicCustomizationStoryPagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7203b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6860h, b3);
                        } else {
                            f6859g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = topicCustomizationStoryPagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public TopicCustomizationStoryPagePartDefinition(ExecutorService executorService, String str, GraphQLQueryExecutor graphQLQueryExecutor, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, AnalyticsLogger analyticsLogger) {
        this.f6861b = executorService;
        this.f6862c = str;
        this.f6863d = graphQLQueryExecutor;
        this.f6864e = newsFeedAnalyticsEventBuilder;
        this.f6865f = analyticsLogger;
    }

    public final ViewType<TopicCustomizationStoryCardView> m7204a() {
        return f6858a;
    }
}
