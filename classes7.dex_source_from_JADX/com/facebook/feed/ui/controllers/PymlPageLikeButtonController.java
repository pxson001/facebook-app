package com.facebook.feed.ui.controllers;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.CommonEventsBuilder;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.ui.animation.LikeIconPopAnimationHelper;
import com.facebook.controller.mutation.MutationCallback;
import com.facebook.controller.mutation.RawLikeHelper;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.ui.itemlistfeedunits.FeedListItemUserActionListener;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLPagesYouMayLikeFeedUnit;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.graphql.model.SuggestedPageUnitItem;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import java.util.Timer;
import java.util.TimerTask;
import javax.inject.Inject;

/* compiled from: TopicHideUserMutation */
public class PymlPageLikeButtonController {
    private final Context f21874a;
    public final AnalyticsLogger f21875b;
    public final DefaultAndroidThreadUtil f21876c;
    private final CommonEventsBuilder f21877d;
    private final NewsFeedAnalyticsEventBuilder f21878e;
    public final RawLikeHelper f21879f;

    public static PymlPageLikeButtonController m24464b(InjectorLike injectorLike) {
        return new PymlPageLikeButtonController((Context) injectorLike.getInstance(Context.class), NewsFeedAnalyticsEventBuilder.a(injectorLike), CommonEventsBuilder.b(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), RawLikeHelper.b(injectorLike));
    }

    @Inject
    public PymlPageLikeButtonController(Context context, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, CommonEventsBuilder commonEventsBuilder, DefaultAndroidThreadUtil defaultAndroidThreadUtil, AnalyticsLogger analyticsLogger, RawLikeHelper rawLikeHelper) {
        this.f21874a = context;
        this.f21877d = commonEventsBuilder;
        this.f21876c = defaultAndroidThreadUtil;
        this.f21875b = analyticsLogger;
        this.f21878e = newsFeedAnalyticsEventBuilder;
        this.f21879f = rawLikeHelper;
    }

    public final void m24465a(GraphQLPagesYouMayLikeFeedUnit graphQLPagesYouMayLikeFeedUnit, SuggestedPageUnitItem suggestedPageUnitItem, GlyphView glyphView, FeedListItemUserActionListener feedListItemUserActionListener) {
        final GraphQLPage m = suggestedPageUnitItem.m();
        m24462a(glyphView, m.O(), false);
        final GlyphView glyphView2 = glyphView;
        final GraphQLPagesYouMayLikeFeedUnit graphQLPagesYouMayLikeFeedUnit2 = graphQLPagesYouMayLikeFeedUnit;
        final SuggestedPageUnitItem suggestedPageUnitItem2 = suggestedPageUnitItem;
        final FeedListItemUserActionListener feedListItemUserActionListener2 = feedListItemUserActionListener;
        glyphView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PymlPageLikeButtonController f21873f;

            /* compiled from: TopicHideUserMutation */
            class C18521 implements MutationCallback<String> {
                final /* synthetic */ C18551 f21864a;

                C18521(C18551 c18551) {
                    this.f21864a = c18551;
                }

                public final /* bridge */ /* synthetic */ void m24456a(Object obj) {
                }

                public final /* bridge */ /* synthetic */ void m24458b(Object obj) {
                }

                public final /* bridge */ /* synthetic */ void m24459c(Object obj) {
                }

                public final void m24457a(Object obj, ServiceException serviceException) {
                    PymlPageLikeButtonController.m24463a(this.f21864a.f21873f, glyphView2, m, false);
                    this.f21864a.f21873f.f21875b.a(CommonEventsBuilder.a("ego_page_like_fail", m.ae(), String.valueOf(m.O()), "native_newsfeed"));
                }
            }

            /* compiled from: TopicHideUserMutation */
            class C18532 implements Runnable {
                final /* synthetic */ C18551 f21865a;

                C18532(C18551 c18551) {
                    this.f21865a = c18551;
                }

                public void run() {
                    if (feedListItemUserActionListener2 != null) {
                        feedListItemUserActionListener2.mR_();
                    }
                }
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -261515778);
                PymlPageLikeButtonController.m24463a(this.f21873f, glyphView2, m, true);
                this.f21873f.f21879f.a(m.ae(), m.O(), null, "native_newsfeed", null, PropertyHelper.a(graphQLPagesYouMayLikeFeedUnit2).k, GraphQLHelper.a(suggestedPageUnitItem2, graphQLPagesYouMayLikeFeedUnit2), false, new C18521(this));
                this.f21873f.f21875b.c(PymlPageLikeButtonController.m24460a(this.f21873f, graphQLPagesYouMayLikeFeedUnit2, suggestedPageUnitItem2, m.O()));
                if (m.O()) {
                    final Runnable c18532 = new C18532(this);
                    new Timer().schedule(new TimerTask(this) {
                        final /* synthetic */ C18551 f21867b;

                        public void run() {
                            this.f21867b.f21873f.f21876c.a(c18532);
                        }
                    }, 500);
                }
                Logger.a(2, EntryType.UI_INPUT_END, -1133927450, a);
            }
        });
    }

    public static void m24463a(PymlPageLikeButtonController pymlPageLikeButtonController, GlyphView glyphView, GraphQLPage graphQLPage, boolean z) {
        graphQLPage.a(!graphQLPage.O());
        pymlPageLikeButtonController.m24462a(glyphView, graphQLPage.O(), z);
    }

    public static HoneyClientEvent m24460a(PymlPageLikeButtonController pymlPageLikeButtonController, GraphQLPagesYouMayLikeFeedUnit graphQLPagesYouMayLikeFeedUnit, SuggestedPageUnitItem suggestedPageUnitItem, boolean z) {
        return NewsFeedAnalyticsEventBuilder.a(suggestedPageUnitItem.A() != null, GraphQLHelper.a(suggestedPageUnitItem, graphQLPagesYouMayLikeFeedUnit), z);
    }

    private void m24462a(GlyphView glyphView, boolean z, boolean z2) {
        if (z) {
            glyphView.setSelected(true);
            m24461a(glyphView, 2131233427);
            if (z2) {
                LikeIconPopAnimationHelper.a(glyphView);
                return;
            }
            return;
        }
        glyphView.setSelected(false);
        m24461a(glyphView, 2131233426);
    }

    private void m24461a(View view, int i) {
        view.setContentDescription(this.f21874a.getResources().getString(i));
    }
}
