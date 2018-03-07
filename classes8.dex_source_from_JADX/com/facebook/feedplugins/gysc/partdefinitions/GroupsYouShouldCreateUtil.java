package com.facebook.feedplugins.gysc.partdefinitions;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.api.feedcache.mutator.FeedUnitCacheMutator;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.rows.core.FeedListName;
import com.facebook.feedplugins.gysc.protocols.blacklistGroupsYouShouldCreateMutation.GroupsYouShouldCreateXoutMutationString;
import com.facebook.feedplugins.gysc.protocols.blacklistGroupsYouShouldCreateMutationModels.GroupsYouShouldCreateXoutMutationModel;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.GyscSuggestionXoutInputData;
import com.facebook.graphql.calls.GyscSuggestionXoutInputData.SuggestionType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLGroupsYouShouldCreateFeedUnit;
import com.facebook.graphql.model.GraphQLGroupsYouShouldCreateFeedUnitItem;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLUser;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;

/* compiled from: friends_tab_see_all_friends */
public class GroupsYouShouldCreateUtil {

    /* compiled from: friends_tab_see_all_friends */
    final class C13361 implements OnClickListener {
        final /* synthetic */ GraphQLGroupsYouShouldCreateFeedUnitItem f12838a;
        final /* synthetic */ GraphQLGroupsYouShouldCreateFeedUnit f12839b;
        final /* synthetic */ FeedListName f12840c;
        final /* synthetic */ FbUriIntentHandler f12841d;
        final /* synthetic */ Context f12842e;
        final /* synthetic */ NewsFeedAnalyticsEventBuilder f12843f;
        final /* synthetic */ AnalyticsLogger f12844g;

        C13361(GraphQLGroupsYouShouldCreateFeedUnitItem graphQLGroupsYouShouldCreateFeedUnitItem, GraphQLGroupsYouShouldCreateFeedUnit graphQLGroupsYouShouldCreateFeedUnit, FeedListName feedListName, FbUriIntentHandler fbUriIntentHandler, Context context, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, AnalyticsLogger analyticsLogger) {
            this.f12838a = graphQLGroupsYouShouldCreateFeedUnitItem;
            this.f12839b = graphQLGroupsYouShouldCreateFeedUnit;
            this.f12840c = feedListName;
            this.f12841d = fbUriIntentHandler;
            this.f12842e = context;
            this.f12843f = newsFeedAnalyticsEventBuilder;
            this.f12844g = analyticsLogger;
        }

        public final void onClick(View view) {
            String str;
            HoneyAnalyticsEvent honeyAnalyticsEvent;
            int a = Logger.a(2, EntryType.UI_INPUT_START, -890157286);
            this.f12841d.a(this.f12842e, FBLinks.D, GroupsYouShouldCreateUtil.m14610a(this.f12838a, this.f12839b, GraphQLHelper.a(this.f12838a, this.f12839b), this.f12840c));
            GraphQLGroupsYouShouldCreateFeedUnit graphQLGroupsYouShouldCreateFeedUnit = this.f12839b;
            GraphQLGroupsYouShouldCreateFeedUnitItem graphQLGroupsYouShouldCreateFeedUnitItem = this.f12838a;
            NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder = this.f12843f;
            AnalyticsLogger analyticsLogger = this.f12844g;
            FeedListName feedListName = this.f12840c;
            ArrayNode a2 = GraphQLHelper.a(graphQLGroupsYouShouldCreateFeedUnitItem, graphQLGroupsYouShouldCreateFeedUnit);
            String name = graphQLGroupsYouShouldCreateFeedUnitItem.q().name();
            String p = graphQLGroupsYouShouldCreateFeedUnitItem.p();
            if (feedListName == FeedListName.GROUPS) {
                str = "gysc_mall";
            } else {
                str = "gysc_feed";
            }
            if (NewsFeedAnalyticsEventBuilder.B(a2)) {
                honeyAnalyticsEvent = null;
            } else {
                HoneyClientEvent b = new HoneyClientEvent("gysc_click").a("tracking", a2).b("suggestion_type", name).b("suggestion_id", p).b("ref", str);
                b.c = "native_newsfeed";
                honeyAnalyticsEvent = b;
            }
            analyticsLogger.a(honeyAnalyticsEvent);
            Logger.a(2, EntryType.UI_INPUT_END, 259246128, a);
        }
    }

    /* compiled from: friends_tab_see_all_friends */
    final class C13372 implements OnClickListener {
        final /* synthetic */ FeedListName f12845a;
        final /* synthetic */ String f12846b;
        final /* synthetic */ GraphQLGroupsYouShouldCreateFeedUnit f12847c;
        final /* synthetic */ GraphQLGroupsYouShouldCreateFeedUnitItem f12848d;
        final /* synthetic */ GraphQLQueryExecutor f12849e;
        final /* synthetic */ FeedUnitCacheMutator f12850f;
        final /* synthetic */ ExecutorService f12851g;

        C13372(FeedListName feedListName, String str, GraphQLGroupsYouShouldCreateFeedUnit graphQLGroupsYouShouldCreateFeedUnit, GraphQLGroupsYouShouldCreateFeedUnitItem graphQLGroupsYouShouldCreateFeedUnitItem, GraphQLQueryExecutor graphQLQueryExecutor, FeedUnitCacheMutator feedUnitCacheMutator, ExecutorService executorService) {
            this.f12845a = feedListName;
            this.f12846b = str;
            this.f12847c = graphQLGroupsYouShouldCreateFeedUnit;
            this.f12848d = graphQLGroupsYouShouldCreateFeedUnitItem;
            this.f12849e = graphQLQueryExecutor;
            this.f12850f = feedUnitCacheMutator;
            this.f12851g = executorService;
        }

        public final void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 353492922);
            GroupsYouShouldCreateUtil.m14615b(this.f12845a == FeedListName.GROUPS ? "gysc_mall" : "gysc_feed", this.f12846b, this.f12847c, this.f12848d, this.f12849e, this.f12850f, this.f12851g);
            LogUtils.a(-1142416169, a);
        }
    }

    /* compiled from: friends_tab_see_all_friends */
    public final class C13383 implements FutureCallback<GraphQLResult<GroupsYouShouldCreateXoutMutationModel>> {
        public final /* bridge */ /* synthetic */ void onSuccess(@Nullable Object obj) {
        }

        public final void onFailure(Throwable th) {
        }
    }

    /* compiled from: friends_tab_see_all_friends */
    public class Props {
        public final GraphQLGroupsYouShouldCreateFeedUnit f12852a;
        public final GraphQLGroupsYouShouldCreateFeedUnitItem f12853b;

        public Props(GraphQLGroupsYouShouldCreateFeedUnit graphQLGroupsYouShouldCreateFeedUnit, GraphQLGroupsYouShouldCreateFeedUnitItem graphQLGroupsYouShouldCreateFeedUnitItem) {
            this.f12852a = graphQLGroupsYouShouldCreateFeedUnit;
            this.f12853b = graphQLGroupsYouShouldCreateFeedUnitItem;
        }
    }

    /* compiled from: friends_tab_see_all_friends */
    public class State {
        public final OnClickListener f12862a;
        public final OnClickListener f12863b;
        public final String f12864c;
        public final int f12865d;
        public final int f12866e;
        public final String f12867f;
        public final String f12868g;
        public final ImmutableList<String> f12869h;

        /* compiled from: friends_tab_see_all_friends */
        public class Builder {
            public OnClickListener f12854a;
            public OnClickListener f12855b;
            public String f12856c;
            public int f12857d;
            public int f12858e;
            public String f12859f;
            public String f12860g;
            public ImmutableList<String> f12861h;

            public final State m14609b() {
                return new State(this);
            }
        }

        public State(Builder builder) {
            this.f12862a = builder.f12854a;
            this.f12864c = builder.f12856c;
            this.f12865d = builder.f12857d;
            this.f12867f = builder.f12859f;
            this.f12868g = builder.f12860g;
            this.f12869h = builder.f12861h;
            this.f12866e = builder.f12858e;
            this.f12863b = builder.f12855b;
        }
    }

    public static Bundle m14610a(GraphQLGroupsYouShouldCreateFeedUnitItem graphQLGroupsYouShouldCreateFeedUnitItem, GraphQLGroupsYouShouldCreateFeedUnit graphQLGroupsYouShouldCreateFeedUnit, ArrayNode arrayNode, FeedListName feedListName) {
        Bundle bundle = new Bundle();
        List arrayList = new ArrayList();
        ImmutableList n = graphQLGroupsYouShouldCreateFeedUnitItem.n();
        int size = n.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(((GraphQLUser) n.get(i)).P());
        }
        String b = StringUtil.b(",", new Object[]{arrayList});
        bundle.putString("group_name", graphQLGroupsYouShouldCreateFeedUnitItem.a());
        bundle.putString("group_members", b);
        bundle.putString("group_visibility", graphQLGroupsYouShouldCreateFeedUnitItem.l().toString());
        bundle.putString("ref", feedListName == FeedListName.GROUPS ? "gysc_mall" : "gysc_feed");
        bundle.putString("suggestion_category", graphQLGroupsYouShouldCreateFeedUnitItem.q().name());
        bundle.putString("suggestion_identifier", graphQLGroupsYouShouldCreateFeedUnitItem.p());
        bundle.putString("cache_id", graphQLGroupsYouShouldCreateFeedUnit.g());
        if (arrayNode.a(0) != null) {
            bundle.putString("trackingcode_item", arrayNode.a(0).s());
        }
        if (arrayNode.a(1) != null) {
            bundle.putString("trackingcode_unit", arrayNode.a(1).s());
        }
        return bundle;
    }

    public static ImmutableList<String> m14613a(GraphQLGroupsYouShouldCreateFeedUnitItem graphQLGroupsYouShouldCreateFeedUnitItem) {
        Builder builder = ImmutableList.builder();
        if (graphQLGroupsYouShouldCreateFeedUnitItem.j() != null && graphQLGroupsYouShouldCreateFeedUnitItem.j().a() != null) {
            ImmutableList a = graphQLGroupsYouShouldCreateFeedUnitItem.j().a();
            int size = a.size();
            int i = 0;
            int i2 = 0;
            while (i < size) {
                int i3;
                GraphQLUser graphQLUser = (GraphQLUser) a.get(i);
                if (graphQLUser == null || graphQLUser.aI() == null || graphQLUser.aI().b() == null) {
                    i3 = i2;
                } else {
                    builder.c(graphQLUser.aI().b());
                    i3 = i2 + 1;
                }
                if (i3 >= 5) {
                    break;
                }
                i++;
                i2 = i3;
            }
        }
        return builder.b();
    }

    public static OnClickListener m14612a(GraphQLGroupsYouShouldCreateFeedUnit graphQLGroupsYouShouldCreateFeedUnit, GraphQLGroupsYouShouldCreateFeedUnitItem graphQLGroupsYouShouldCreateFeedUnitItem, FbUriIntentHandler fbUriIntentHandler, Context context, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, AnalyticsLogger analyticsLogger, FeedListName feedListName) {
        return new C13361(graphQLGroupsYouShouldCreateFeedUnitItem, graphQLGroupsYouShouldCreateFeedUnit, feedListName, fbUriIntentHandler, context, newsFeedAnalyticsEventBuilder, analyticsLogger);
    }

    public static OnClickListener m14611a(FeedListName feedListName, String str, GraphQLGroupsYouShouldCreateFeedUnit graphQLGroupsYouShouldCreateFeedUnit, GraphQLGroupsYouShouldCreateFeedUnitItem graphQLGroupsYouShouldCreateFeedUnitItem, GraphQLQueryExecutor graphQLQueryExecutor, FeedUnitCacheMutator feedUnitCacheMutator, ExecutorService executorService) {
        return new C13372(feedListName, str, graphQLGroupsYouShouldCreateFeedUnit, graphQLGroupsYouShouldCreateFeedUnitItem, graphQLQueryExecutor, feedUnitCacheMutator, executorService);
    }

    private static void m14615b(String str, String str2, GraphQLGroupsYouShouldCreateFeedUnit graphQLGroupsYouShouldCreateFeedUnit, GraphQLGroupsYouShouldCreateFeedUnitItem graphQLGroupsYouShouldCreateFeedUnitItem, GraphQLQueryExecutor graphQLQueryExecutor, FeedUnitCacheMutator feedUnitCacheMutator, ExecutorService executorService) {
        feedUnitCacheMutator.a(graphQLGroupsYouShouldCreateFeedUnit.g(), graphQLGroupsYouShouldCreateFeedUnitItem.p());
        GyscSuggestionXoutInputData gyscSuggestionXoutInputData = new GyscSuggestionXoutInputData();
        gyscSuggestionXoutInputData.a("actor_id", str2);
        GraphQlCallInput graphQlCallInput = gyscSuggestionXoutInputData;
        graphQlCallInput.a("ref", str);
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("suggestion_identifier", graphQLGroupsYouShouldCreateFeedUnitItem.p());
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("suggestion_type", SuggestionType.valueOf(graphQLGroupsYouShouldCreateFeedUnitItem.q().name()));
        Futures.a(graphQLQueryExecutor.a(GraphQLRequest.a((GroupsYouShouldCreateXoutMutationString) new GroupsYouShouldCreateXoutMutationString().a("input", graphQlCallInput))), new C13383(), executorService);
    }
}
