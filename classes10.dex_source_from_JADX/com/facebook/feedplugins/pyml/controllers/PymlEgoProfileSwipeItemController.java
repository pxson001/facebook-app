package com.facebook.feedplugins.pyml.controllers;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.LayoutParams;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.device.ScreenUtil;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbPipelineDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.hscroll.HScrollFeedItem.Position;
import com.facebook.feed.renderer.DefaultFeedUnitRenderer;
import com.facebook.feed.ui.controllers.PymlPageLikeButtonController;
import com.facebook.feed.ui.imageloader.FeedImageLoader;
import com.facebook.feed.ui.itemlistfeedunits.FeedListItemUserActionListener;
import com.facebook.feedplugins.pyml.EgoUnitUtil;
import com.facebook.feedplugins.pyml.controllers.HScrollFeedUnitView.ItemListRecyclablePagerAdapter;
import com.facebook.feedplugins.pyml.views.EgoProfileSwipeUnitItemView;
import com.facebook.feedplugins.pyml.views.EgoProfileSwipeUnitItemView$EgoItemContainer;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLPageBrowserCategoryInfo;
import com.facebook.graphql.model.GraphQLPagesYouMayLikeFeedUnit;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.graphql.model.SuggestedPageUnitItem;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.linkify.LinkifyTargetBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.utils.ResourceUtils;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.recyclablepager.PagerViewType;
import com.facebook.widget.CustomViewPager;
import com.google.common.base.Strings;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
@Deprecated
/* compiled from: android_messenger_cpe_push_first */
public class PymlEgoProfileSwipeItemController extends HScrollFeedUnitController {
    public static final CallerContext f19679a = CallerContext.a(PymlEgoProfileSwipeItemController.class, "photos_feed");
    private static final PagerViewType f19680b = new C27941();
    private static PymlEgoProfileSwipeItemController f19681q;
    private static final Object f19682r = new Object();
    private final Context f19683c;
    public final ScreenUtil f19684d;
    private final FeedImageLoader f19685e;
    public final AbstractFbErrorReporter f19686f;
    public final int f19687g;
    public final int f19688h;
    public int f19689i;
    public int f19690j;
    private final DefaultFeedUnitRenderer f19691k;
    private final NewsFeedAnalyticsEventBuilder f19692l;
    public final IFeedIntentBuilder f19693m;
    private final PymlPageLikeButtonController f19694n;
    private final EgoUnitUtil f19695o;
    public final FbDraweeControllerBuilder f19696p;

    /* compiled from: android_messenger_cpe_push_first */
    final class C27941 implements PagerViewType {
        C27941() {
        }

        public final Class m19958a() {
            return EgoProfileSwipeUnitItemView.class;
        }

        public final View m19957a(Context context) {
            return new EgoProfileSwipeUnitItemView(context);
        }
    }

    private static PymlEgoProfileSwipeItemController m19963b(InjectorLike injectorLike) {
        return new PymlEgoProfileSwipeItemController((Context) injectorLike.getInstance(Context.class), ScreenUtil.a(injectorLike), FeedImageLoader.a(injectorLike), DefaultFeedUnitRenderer.a(injectorLike), NewsFeedAnalyticsEventBuilder.a(injectorLike), (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), PymlPageLikeButtonController.b(injectorLike), EgoUnitUtil.b(injectorLike), FbDraweeControllerBuilder.b(injectorLike));
    }

    public final void mo887a(ItemListRecyclablePagerAdapter itemListRecyclablePagerAdapter, ViewPager viewPager) {
        if (itemListRecyclablePagerAdapter.b) {
            int i = viewPager.k + 1;
            if (i < itemListRecyclablePagerAdapter.b()) {
                viewPager.setCurrentItem(i);
            }
        }
    }

    public static PymlEgoProfileSwipeItemController m19960a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PymlEgoProfileSwipeItemController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19682r) {
                PymlEgoProfileSwipeItemController pymlEgoProfileSwipeItemController;
                if (a2 != null) {
                    pymlEgoProfileSwipeItemController = (PymlEgoProfileSwipeItemController) a2.a(f19682r);
                } else {
                    pymlEgoProfileSwipeItemController = f19681q;
                }
                if (pymlEgoProfileSwipeItemController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m19963b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19682r, b3);
                        } else {
                            f19681q = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pymlEgoProfileSwipeItemController;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PymlEgoProfileSwipeItemController(Context context, ScreenUtil screenUtil, FeedImageLoader feedImageLoader, DefaultFeedUnitRenderer defaultFeedUnitRenderer, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, IFeedIntentBuilder iFeedIntentBuilder, AbstractFbErrorReporter abstractFbErrorReporter, PymlPageLikeButtonController pymlPageLikeButtonController, EgoUnitUtil egoUnitUtil, FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f19683c = context;
        this.f19684d = screenUtil;
        this.f19685e = feedImageLoader;
        this.f19686f = abstractFbErrorReporter;
        Resources resources = this.f19683c.getResources();
        this.f19688h = resources.getDimensionPixelSize(2131427507);
        this.f19687g = resources.getDimensionPixelSize(2131428891) + (this.f19688h * 2);
        this.f19691k = defaultFeedUnitRenderer;
        this.f19692l = newsFeedAnalyticsEventBuilder;
        this.f19693m = iFeedIntentBuilder;
        this.f19694n = pymlPageLikeButtonController;
        this.f19695o = egoUnitUtil;
        this.f19696p = fbDraweeControllerBuilder;
    }

    public final void mo889a(ScrollableItemListFeedUnit scrollableItemListFeedUnit, TextView textView, View view) {
        CharSequence quantityString;
        int size = scrollableItemListFeedUnit.v().size();
        SuggestedPageUnitItem suggestedPageUnitItem = (SuggestedPageUnitItem) scrollableItemListFeedUnit.v().get(0);
        if (scrollableItemListFeedUnit.m() == null || StringUtil.c(scrollableItemListFeedUnit.m().a())) {
            quantityString = this.f19683c.getResources().getQuantityString(2131689529, size);
        } else {
            quantityString = scrollableItemListFeedUnit.m().a();
        }
        if (size > 1) {
            textView.setText(quantityString);
            view.setVisibility(8);
            return;
        }
        CharSequence b = this.f19695o.b(scrollableItemListFeedUnit, suggestedPageUnitItem);
        if (b != null) {
            textView.setText(b);
        } else {
            textView.setText(quantityString);
        }
        view.setVisibility(0);
    }

    public final PagerViewType m19969a() {
        return f19680b;
    }

    public final void m19974a(List list, CustomViewPager customViewPager) {
        customViewPager.b((int) TypedValue.applyDimension(1, 230.0f, this.f19683c.getResources().getDisplayMetrics()), true);
    }

    public final void m19973a(CustomViewPager customViewPager, Resources resources) {
        this.f19689i = this.f19684d.c();
        this.f19690j = (this.f19689i - this.f19687g) / 2;
        customViewPager.setPageMargin((this.f19688h + (this.f19690j * 2)) * -1);
    }

    public final float m19968a(Position position) {
        if (position == Position.FIRST) {
            return ((float) ((this.f19687g + this.f19690j) + this.f19688h)) / ((float) this.f19689i);
        }
        return 1.0f;
    }

    public final int m19975b() {
        return (this.f19689i / this.f19687g) + 1;
    }

    public final void mo888a(ScrollableItemListFeedUnit scrollableItemListFeedUnit, View view, Object obj, Position position, FeedListItemUserActionListener feedListItemUserActionListener) {
        EgoProfileSwipeUnitItemView egoProfileSwipeUnitItemView = (EgoProfileSwipeUnitItemView) view;
        EgoProfileSwipeUnitItemView$EgoItemContainer egoProfileSwipeUnitItemView$EgoItemContainer = egoProfileSwipeUnitItemView.a;
        SuggestedPageUnitItem suggestedPageUnitItem = (SuggestedPageUnitItem) obj;
        view.setLayoutParams(new LayoutParams());
        if (position == Position.FIRST) {
            egoProfileSwipeUnitItemView.setPadding(this.f19688h, 0, this.f19690j, 0);
        } else {
            egoProfileSwipeUnitItemView.setPadding(this.f19690j, 0, this.f19690j, 0);
        }
        GraphQLPagesYouMayLikeFeedUnit graphQLPagesYouMayLikeFeedUnit = (GraphQLPagesYouMayLikeFeedUnit) scrollableItemListFeedUnit;
        if (suggestedPageUnitItem.r()) {
            m19961a(egoProfileSwipeUnitItemView$EgoItemContainer, graphQLPagesYouMayLikeFeedUnit);
        } else {
            m19962a(egoProfileSwipeUnitItemView$EgoItemContainer, graphQLPagesYouMayLikeFeedUnit, suggestedPageUnitItem, feedListItemUserActionListener);
        }
    }

    private void m19961a(EgoProfileSwipeUnitItemView$EgoItemContainer egoProfileSwipeUnitItemView$EgoItemContainer, GraphQLPagesYouMayLikeFeedUnit graphQLPagesYouMayLikeFeedUnit) {
        if (egoProfileSwipeUnitItemView$EgoItemContainer.f19898h == null) {
            m19965b(egoProfileSwipeUnitItemView$EgoItemContainer, graphQLPagesYouMayLikeFeedUnit);
        }
        egoProfileSwipeUnitItemView$EgoItemContainer.f19891a.setVisibility(8);
        egoProfileSwipeUnitItemView$EgoItemContainer.f19898h.setVisibility(0);
    }

    private void m19962a(EgoProfileSwipeUnitItemView$EgoItemContainer egoProfileSwipeUnitItemView$EgoItemContainer, GraphQLPagesYouMayLikeFeedUnit graphQLPagesYouMayLikeFeedUnit, SuggestedPageUnitItem suggestedPageUnitItem, FeedListItemUserActionListener feedListItemUserActionListener) {
        GraphQLImage bs;
        String str;
        egoProfileSwipeUnitItemView$EgoItemContainer.f19891a.setVisibility(0);
        if (egoProfileSwipeUnitItemView$EgoItemContainer.f19898h != null) {
            egoProfileSwipeUnitItemView$EgoItemContainer.f19898h.setVisibility(8);
        }
        if (GraphQLHelper.d(suggestedPageUnitItem.m())) {
            bs = suggestedPageUnitItem.m().bs();
        } else {
            bs = null;
        }
        GraphQLImage graphQLImage = bs;
        if (graphQLImage != null) {
            FbPipelineDraweeController s = ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f19696p.a(f19679a).b(egoProfileSwipeUnitItemView$EgoItemContainer.f19892b.getController())).c(FeedImageLoader.a(graphQLImage))).s();
            ((GenericDraweeHierarchy) egoProfileSwipeUnitItemView$EgoItemContainer.f19892b.getHierarchy()).b(2130842529);
            egoProfileSwipeUnitItemView$EgoItemContainer.f19892b.setVisibility(0);
            egoProfileSwipeUnitItemView$EgoItemContainer.f19892b.setContentDescription(m19964b(suggestedPageUnitItem));
            egoProfileSwipeUnitItemView$EgoItemContainer.f19892b.setController(s);
        } else {
            egoProfileSwipeUnitItemView$EgoItemContainer.f19892b.setVisibility(8);
        }
        CharSequence b = m19964b(suggestedPageUnitItem);
        if (Strings.isNullOrEmpty(b)) {
            egoProfileSwipeUnitItemView$EgoItemContainer.f19893c.setVisibility(8);
        } else {
            egoProfileSwipeUnitItemView$EgoItemContainer.f19893c.setVisibility(0);
            egoProfileSwipeUnitItemView$EgoItemContainer.f19893c.setText(b);
        }
        if (suggestedPageUnitItem.m().F() == null || suggestedPageUnitItem.m().F().isEmpty()) {
            str = null;
        } else {
            str = TextUtils.join("/", suggestedPageUnitItem.m().F());
        }
        String str2 = str;
        if (StringUtil.a(str2)) {
            egoProfileSwipeUnitItemView$EgoItemContainer.f19894d.setVisibility(8);
        } else {
            egoProfileSwipeUnitItemView$EgoItemContainer.f19894d.setVisibility(0);
            egoProfileSwipeUnitItemView$EgoItemContainer.f19894d.setText(str2);
        }
        b = m19967d(suggestedPageUnitItem);
        if (StringUtil.a(b)) {
            egoProfileSwipeUnitItemView$EgoItemContainer.f19895e.setVisibility(8);
        } else {
            egoProfileSwipeUnitItemView$EgoItemContainer.f19895e.setVisibility(0);
            egoProfileSwipeUnitItemView$EgoItemContainer.f19895e.setText(b);
        }
        m19966b(egoProfileSwipeUnitItemView$EgoItemContainer, graphQLPagesYouMayLikeFeedUnit, suggestedPageUnitItem, feedListItemUserActionListener);
    }

    public static String m19964b(SuggestedPageUnitItem suggestedPageUnitItem) {
        return suggestedPageUnitItem.m().aG();
    }

    public final boolean mo891d() {
        return false;
    }

    protected final Class<? extends ScrollableItemListFeedUnit> mo890c() {
        return GraphQLPagesYouMayLikeFeedUnit.class;
    }

    private String m19967d(SuggestedPageUnitItem suggestedPageUnitItem) {
        int c = GraphQLHelper.c(suggestedPageUnitItem.m());
        if (c > 0) {
            return ResourceUtils.a(this.f19683c.getResources(), 2131233554, 2131233555, c);
        }
        return null;
    }

    private void m19966b(EgoProfileSwipeUnitItemView$EgoItemContainer egoProfileSwipeUnitItemView$EgoItemContainer, GraphQLPagesYouMayLikeFeedUnit graphQLPagesYouMayLikeFeedUnit, SuggestedPageUnitItem suggestedPageUnitItem, FeedListItemUserActionListener feedListItemUserActionListener) {
        boolean z;
        this.f19694n.a(graphQLPagesYouMayLikeFeedUnit, suggestedPageUnitItem, egoProfileSwipeUnitItemView$EgoItemContainer.f19896f, feedListItemUserActionListener);
        if (suggestedPageUnitItem.A() != null) {
            z = true;
        } else {
            z = false;
        }
        HoneyClientEvent b = NewsFeedAnalyticsEventBuilder.b(z, GraphQLHelper.a(suggestedPageUnitItem, graphQLPagesYouMayLikeFeedUnit));
        egoProfileSwipeUnitItemView$EgoItemContainer.f19893c.setOnClickListener(this.f19691k.a(egoProfileSwipeUnitItemView$EgoItemContainer.f19893c, LinkifyTargetBuilder.a(suggestedPageUnitItem.m()), b, null, null, null));
        egoProfileSwipeUnitItemView$EgoItemContainer.f19894d.setOnClickListener(this.f19691k.a(egoProfileSwipeUnitItemView$EgoItemContainer.f19894d, LinkifyTargetBuilder.a(suggestedPageUnitItem.m()), b, null, null, null));
        egoProfileSwipeUnitItemView$EgoItemContainer.f19895e.setOnClickListener(this.f19691k.a(egoProfileSwipeUnitItemView$EgoItemContainer.f19895e, LinkifyTargetBuilder.a(suggestedPageUnitItem.m()), b, null, null, null));
        egoProfileSwipeUnitItemView$EgoItemContainer.f19892b.setOnClickListener(this.f19691k.a(egoProfileSwipeUnitItemView$EgoItemContainer.f19892b, LinkifyTargetBuilder.a(suggestedPageUnitItem.m()), b, null, null, null));
    }

    private void m19965b(EgoProfileSwipeUnitItemView$EgoItemContainer egoProfileSwipeUnitItemView$EgoItemContainer, GraphQLPagesYouMayLikeFeedUnit graphQLPagesYouMayLikeFeedUnit) {
        egoProfileSwipeUnitItemView$EgoItemContainer.f19897g.setLayoutResource(2130906530);
        egoProfileSwipeUnitItemView$EgoItemContainer.f19898h = egoProfileSwipeUnitItemView$EgoItemContainer.f19897g.inflate();
        egoProfileSwipeUnitItemView$EgoItemContainer.f19898h.findViewById(2131560753).setOnClickListener(m19959a(graphQLPagesYouMayLikeFeedUnit));
        egoProfileSwipeUnitItemView$EgoItemContainer.f19898h.findViewById(2131560752).setOnClickListener(m19959a(graphQLPagesYouMayLikeFeedUnit));
    }

    private OnClickListener m19959a(GraphQLPagesYouMayLikeFeedUnit graphQLPagesYouMayLikeFeedUnit) {
        GraphQLPageBrowserCategoryInfo x = graphQLPagesYouMayLikeFeedUnit.x();
        final String a = x != null ? x.a() : null;
        return new OnClickListener(this) {
            final /* synthetic */ PymlEgoProfileSwipeItemController f19678b;

            public void onClick(View view) {
                String formatStrLocaleSafe;
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1903218731);
                if (a == null) {
                    this.f19678b.f19686f.b("PymlEgoProfileSwipeItemController.categoryMissing", "Must have category.");
                    formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.aJ);
                } else {
                    formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.aK, a);
                }
                this.f19678b.f19693m.a(view.getContext(), formatStrLocaleSafe);
                LogUtils.a(476365046, a);
            }
        };
    }
}
