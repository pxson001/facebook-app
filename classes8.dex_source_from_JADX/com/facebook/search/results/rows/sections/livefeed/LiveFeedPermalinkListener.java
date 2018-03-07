package com.facebook.search.results.rows.sections.livefeed;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.Assisted;
import com.facebook.ipc.feed.PermalinkStoryIdParams;
import com.facebook.ipc.feed.PermalinkStoryIdParams.Builder;
import com.facebook.ipc.feed.ViewPermalinkIntentFactory;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.logging.SearchResultsLogger.Event;
import com.facebook.search.results.model.SearchResultsMutableContext;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.inject.Inject;

/* compiled from: Places */
public class LiveFeedPermalinkListener implements OnClickListener {
    private final GraphQLStory f24505a;
    private final SearchResultsMutableContext f24506b;
    private final Context f24507c;
    private final ViewPermalinkIntentFactory f24508d;
    private final SecureContextHelper f24509e;
    private final SearchResultsLogger f24510f;

    @Inject
    public LiveFeedPermalinkListener(@Assisted GraphQLStory graphQLStory, @Assisted SearchResultsMutableContext searchResultsMutableContext, Context context, ViewPermalinkIntentFactory viewPermalinkIntentFactory, SecureContextHelper secureContextHelper, SearchResultsLogger searchResultsLogger) {
        this.f24505a = graphQLStory;
        this.f24506b = searchResultsMutableContext;
        this.f24507c = context;
        this.f24508d = viewPermalinkIntentFactory;
        this.f24509e = secureContextHelper;
        this.f24510f = searchResultsLogger;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1237855142);
        if (this.f24505a == null || this.f24505a.c() == null || this.f24505a.g() == null) {
            Logger.a(2, EntryType.UI_INPUT_END, -67048862, a);
            return;
        }
        Builder f = new Builder().e(this.f24505a).f(this.f24505a);
        f.a = this.f24505a.c();
        f = f;
        f.b = this.f24505a.g();
        PermalinkStoryIdParams a2 = f.a();
        if (this.f24506b.m27098l() == GraphQLGraphSearchResultsDisplayStyle.BLENDED) {
            SearchResultsLogger searchResultsLogger = this.f24510f;
            SearchResultsMutableContext searchResultsMutableContext = this.f24506b;
            HoneyClientEvent a3 = SearchResultsLogger.m25459a(Event.ITEM_IN_MODULE_TAPPED, searchResultsMutableContext).b("tapped_result_entity_id", this.f24505a.c()).a("results_module_role", GraphQLGraphSearchResultRole.LIVE_CONVERSATION_MODULE);
            searchResultsLogger.f21958c.a(a3);
            if (BLog.b(3)) {
                String str = a3.d;
                a3.u();
            }
        }
        Intent a4 = this.f24508d.a(a2);
        if (a4 != null) {
            this.f24509e.a(a4, this.f24507c);
        }
        LogUtils.a(-12324360, a);
    }
}
