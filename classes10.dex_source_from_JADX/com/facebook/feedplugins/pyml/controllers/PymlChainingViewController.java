package com.facebook.feedplugins.pyml.controllers;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.device.ScreenUtil;
import com.facebook.feed.hscroll.HScrollFeedItem.Position;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.ui.chaining.HScrollChainingViewController;
import com.facebook.feed.ui.itemlistfeedunits.FeedListItemUserActionListener;
import com.facebook.feed.util.render.FeedRenderUtils;
import com.facebook.feedplugins.pyml.views.EgoProfileSwipeUnitItemView;
import com.facebook.graphql.model.GraphQLPagesYouMayLikeFeedUnit;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.graphql.model.VisibleItemHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ui.recyclablepager.PagerViewType;
import com.facebook.widget.CustomViewPager;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: android_messenger_edit_username_save_successful */
public class PymlChainingViewController extends HScrollChainingViewController {
    private static final PagerViewType f19673e = new C27931();
    private static PymlChainingViewController f19674g;
    private static final Object f19675h = new Object();
    private final PymlEgoProfileSwipeItemController f19676f;

    /* compiled from: android_messenger_edit_username_save_successful */
    final class C27931 implements PagerViewType {
        C27931() {
        }

        public final Class m19945a() {
            return EgoProfileSwipeUnitItemView.class;
        }

        public final View m19944a(Context context) {
            return new EgoProfileSwipeUnitItemView(context);
        }
    }

    private static PymlChainingViewController m19947b(InjectorLike injectorLike) {
        return new PymlChainingViewController((Context) injectorLike.getInstance(Context.class), ScreenUtil.a(injectorLike), PymlEgoProfileSwipeItemController.m19960a(injectorLike), FeedRenderUtils.a(injectorLike));
    }

    @Inject
    public PymlChainingViewController(Context context, ScreenUtil screenUtil, PymlEgoProfileSwipeItemController pymlEgoProfileSwipeItemController, FeedRenderUtils feedRenderUtils) {
        super(context, screenUtil, feedRenderUtils);
        this.f19676f = pymlEgoProfileSwipeItemController;
    }

    public static PymlChainingViewController m19946a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PymlChainingViewController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19675h) {
                PymlChainingViewController pymlChainingViewController;
                if (a2 != null) {
                    pymlChainingViewController = (PymlChainingViewController) a2.a(f19675h);
                } else {
                    pymlChainingViewController = f19674g;
                }
                if (pymlChainingViewController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m19947b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19675h, b3);
                        } else {
                            f19674g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pymlChainingViewController;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    protected final Class<? extends ScrollableItemListFeedUnit> m19956c() {
        return GraphQLPagesYouMayLikeFeedUnit.class;
    }

    public final PagerViewType m19949a() {
        return f19673e;
    }

    public final void m19954a(List list, CustomViewPager customViewPager) {
        this.f19676f.a(list, customViewPager);
    }

    public final void m19953a(CustomViewPager customViewPager, Resources resources) {
        this.f19676f.a(customViewPager, resources);
    }

    public final float m19948a(Position position) {
        return this.f19676f.a(position);
    }

    public final ArrayNode m19950a(FeedProps<ScrollableItemListFeedUnit> feedProps) {
        ScrollableItemListFeedUnit scrollableItemListFeedUnit = (ScrollableItemListFeedUnit) feedProps.a;
        if (scrollableItemListFeedUnit instanceof GraphQLPagesYouMayLikeFeedUnit) {
            return VisibleItemHelper.c((GraphQLPagesYouMayLikeFeedUnit) scrollableItemListFeedUnit);
        }
        return null;
    }

    public final void m19952a(FeedProps<ScrollableItemListFeedUnit> feedProps, TextView textView) {
        CharSequence quantityString;
        ScrollableItemListFeedUnit scrollableItemListFeedUnit = (ScrollableItemListFeedUnit) feedProps.a;
        int size = scrollableItemListFeedUnit.v().size();
        if (scrollableItemListFeedUnit.m() == null || StringUtil.c(scrollableItemListFeedUnit.m().a())) {
            quantityString = this.a.getResources().getQuantityString(2131689529, size);
        } else {
            quantityString = scrollableItemListFeedUnit.m().a();
        }
        textView.setText(quantityString);
        textView.setVisibility(0);
    }

    public final int m19955b() {
        return this.f19676f.b();
    }

    public final void m19951a(View view, Object obj, Position position, FeedListItemUserActionListener feedListItemUserActionListener, ScrollableItemListFeedUnit scrollableItemListFeedUnit) {
        this.f19676f.mo888a(scrollableItemListFeedUnit, view, obj, position, feedListItemUserActionListener);
    }
}
