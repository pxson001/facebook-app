package com.facebook.pages.fb4a.admin_activity.views;

import android.content.Context;
import android.support.v4.util.Pair;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.graphql.enums.GraphQLPageActivityFeedType;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.pages.common.protocol.graphql.FetchPageActivityGraphQLInterfaces.FetchPageActivityQuery.ActivityFeeds;
import com.facebook.pages.common.protocol.graphql.FetchPageActivityGraphQLModels.FetchPageActivityQueryModel.ActivityFeedsModel;
import com.facebook.pages.fb4a.admin_activity.views.PageIdentityLinkView.WebViewLaunchedListener;
import com.facebook.pages.fb4a.prefkeys.PagesPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: queryInterface returns null for mPageFragmentUuid  */
public class PageAdminSecondaryLinksCardView extends CustomFrameLayout {
    @Inject
    public Lazy<FbSharedPreferences> f2881a;
    private Map<GraphQLPageActivityFeedType, ActivityFeeds> f2882b;

    private static <T extends View> void m3839a(Class<T> cls, T t) {
        m3840a((Object) t, t.getContext());
    }

    private static void m3840a(Object obj, Context context) {
        ((PageAdminSecondaryLinksCardView) obj).f2881a = IdBasedSingletonScopeProvider.b(FbInjector.get(context), 3078);
    }

    public PageAdminSecondaryLinksCardView(Context context) {
        super(context);
        m3841e();
    }

    public PageAdminSecondaryLinksCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3841e();
    }

    public PageAdminSecondaryLinksCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3841e();
    }

    private void m3841e() {
        setContentView(2130905963);
        m3839a(PageAdminSecondaryLinksCardView.class, (View) this);
        this.f2882b = new HashMap();
    }

    private void m3838a(Lazy<FbSharedPreferences> lazy) {
        this.f2881a = lazy;
    }

    public final void m3843a(long j, ImmutableList<? extends ActivityFeeds> immutableList, Optional<? extends WebViewLaunchedListener> optional) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ActivityFeedsModel activityFeedsModel = (ActivityFeedsModel) immutableList.get(i);
            this.f2882b.put(activityFeedsModel.m2756a(), activityFeedsModel);
        }
        ImmutableList items = getItems();
        int size2 = items.size();
        for (int i2 = 0; i2 < size2; i2++) {
            Pair pair = (Pair) items.get(i2);
            PageIdentityLinkView pageIdentityLinkView = (PageIdentityLinkView) c(((PageAdminActionItem) pair.b).resId);
            pageIdentityLinkView.mo75a(((PageAdminActionItem) pair.b).uri, j, optional);
            pageIdentityLinkView.f2892b = ((PageAdminActionItem) pair.b).loggingEvent;
            pageIdentityLinkView.setBadgeStyle(PagesLinkViewBadgeStyle.SECONDARY);
            pageIdentityLinkView.setBadgeNumber((long) ((ActivityFeedsModel) this.f2882b.get(pair.a)).m2759b());
            pageIdentityLinkView.setVisibility(0);
        }
    }

    public final void m3842a() {
        this.f2882b.clear();
    }

    public final void m3844b() {
        if (!((FbSharedPreferences) this.f2881a.get()).a(PagesPrefKeys.c, false)) {
            FbTextView fbTextView = (FbTextView) c(2131565355);
            Tooltip tooltip = new Tooltip(fbTextView.getContext(), 2);
            tooltip.b(getResources().getString(2131235498));
            tooltip.a(Position.ABOVE);
            tooltip.f(fbTextView);
            ((FbSharedPreferences) this.f2881a.get()).edit().putBoolean(PagesPrefKeys.c, true).commit();
        }
    }

    private ImmutableList<Pair<GraphQLPageActivityFeedType, PageAdminActionItem>> getItems() {
        Builder builder = ImmutableList.builder();
        if (this.f2882b.get(GraphQLPageActivityFeedType.ALL) != null) {
            builder.c(new Pair(GraphQLPageActivityFeedType.ALL, PageAdminActionItem.RECENT_ACTIVITY));
        }
        if (this.f2882b.get(GraphQLPageActivityFeedType.MENTION) != null) {
            builder.c(new Pair(GraphQLPageActivityFeedType.MENTION, PageAdminActionItem.RECENT_MENTIONS));
        }
        if (this.f2882b.get(GraphQLPageActivityFeedType.SHARE) != null) {
            builder.c(new Pair(GraphQLPageActivityFeedType.SHARE, PageAdminActionItem.RECENT_SHARES));
        }
        if (this.f2882b.get(GraphQLPageActivityFeedType.REVIEW) != null) {
            builder.c(new Pair(GraphQLPageActivityFeedType.REVIEW, PageAdminActionItem.RECENT_REVIEWS));
        }
        if (this.f2882b.get(GraphQLPageActivityFeedType.CHECKIN) != null) {
            builder.c(new Pair(GraphQLPageActivityFeedType.CHECKIN, PageAdminActionItem.RECENT_CHECK_INS));
        }
        return builder.b();
    }
}
