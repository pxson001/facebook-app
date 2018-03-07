package com.facebook.feed.storypermalink;

import android.content.Context;
import android.os.Bundle;
import com.facebook.api.feed.data.FeedUnitDataController;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.feed.permalink.PYMLPermalinkController;
import com.facebook.feed.permalink.PermalinkRenderUtils;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLPYMLWithLargeImageFeedUnit;
import com.facebook.graphql.model.VisibleItemHelper;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.titlebar.HasTitleBar;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.util.concurrent.FutureCallback;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: TWO_LINE */
public class PYMLPermalinkFragment extends StoryPermalinkFragment {
    @Inject
    public PYMLPermalinkController f24511a;
    private GraphQLPYMLWithLargeImageFeedUnit aS;
    @Inject
    public FeedUnitDataController f24512b;

    /* compiled from: TWO_LINE */
    class C29411 implements FutureCallback<GraphQLPYMLWithLargeImageFeedUnit> {
        final /* synthetic */ PYMLPermalinkFragment f24501a;

        C29411(PYMLPermalinkFragment pYMLPermalinkFragment) {
            this.f24501a = pYMLPermalinkFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            FeedUnit feedUnit = (GraphQLPYMLWithLargeImageFeedUnit) obj;
            this.f24501a.m26414a(feedUnit, VisibleItemHelper.c(feedUnit));
        }

        public void onFailure(Throwable th) {
            this.f24501a.ax.c();
        }
    }

    public static void m26422a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PYMLPermalinkFragment pYMLPermalinkFragment = (PYMLPermalinkFragment) obj;
        PYMLPermalinkController pYMLPermalinkController = new PYMLPermalinkController((ObjectMapper) FbObjectMapperMethodAutoProvider.a(fbInjector), TasksManager.b(fbInjector));
        FeedUnitDataController a = FeedUnitDataController.a(fbInjector);
        pYMLPermalinkFragment.f24511a = pYMLPermalinkController;
        pYMLPermalinkFragment.f24512b = a;
    }

    public final void mo1153c(Bundle bundle) {
        Class cls = PYMLPermalinkFragment.class;
        m26422a(this, getContext());
        super.mo1153c(bundle);
    }

    protected final void aq() {
        mo1148a(this.aS);
    }

    public final void mo1147I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1433773741);
        super.mo1147I();
        this.f24511a.b.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -369624660, a);
    }

    public final void mo1148a(FeedUnit feedUnit) {
        this.aS = (GraphQLPYMLWithLargeImageFeedUnit) feedUnit;
        m26416b(this.aS);
        if (hn_()) {
            PermalinkRenderUtils.a((HasTitleBar) a(HasTitleBar.class), feedUnit, this.f24512b);
        }
    }

    protected final void ar() {
        at();
        this.f24511a.a(this.bb, new C29411(this));
    }

    public final Map<String, Object> mo1152c() {
        Map<String, Object> hashMap = new HashMap();
        if (!(this.aS == null || this.aS.g() == null)) {
            hashMap.put("story_id", this.aS.g());
        }
        return hashMap;
    }

    public Map<String, String> getDebugInfo() {
        return m26418c(this.aS);
    }
}
