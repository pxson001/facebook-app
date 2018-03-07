package com.facebook.search.results.rows.sections.commerce;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.commerce.core.analytics.CommerceAnalytics.CommerceRefType;
import com.facebook.commerce.core.util.CommerceNavigationUtil;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.feed.PermalinkStoryIdParams.Builder;
import com.facebook.ipc.feed.ViewPermalinkIntentFactory;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.search.results.environment.common.CanLogCollectionItemNavigation;
import com.facebook.search.results.model.unit.SearchResultsProductItemUnit;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: RECENTLY_ADDED_FRIENDS */
public class CommerceProductItemsGridRowPartDefinition<E extends HasPositionInformation & HasContext & CanLogCollectionItemNavigation> extends MultiRowSinglePartDefinition<ImmutableList<SearchResultsProductItemUnit>, State, E, CommerceProductItemGridRowView> {
    public static ViewType<CommerceProductItemGridRowView> f23945a = ViewType.a(2130906983);
    private static final CallerContext f23946b = CallerContext.a(CommerceProductItemsGridRowPartDefinition.class, "places_search");
    private static CommerceProductItemsGridRowPartDefinition f23947g;
    private static final Object f23948h = new Object();
    private final BackgroundPartDefinition f23949c;
    public final CommerceNavigationUtil f23950d;
    public final ViewPermalinkIntentFactory f23951e;
    public final SecureContextHelper f23952f;

    /* compiled from: RECENTLY_ADDED_FRIENDS */
    public class State {
        OnClickListener f23943a;
        OnClickListener f23944b;

        public State(OnClickListener onClickListener, OnClickListener onClickListener2) {
            this.f23943a = onClickListener;
            this.f23944b = onClickListener2;
        }
    }

    private static CommerceProductItemsGridRowPartDefinition m27529b(InjectorLike injectorLike) {
        return new CommerceProductItemsGridRowPartDefinition(BackgroundPartDefinition.a(injectorLike), CommerceNavigationUtil.a(injectorLike), ViewPermalinkIntentFactory.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    public final Object m27531a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ImmutableList immutableList = (ImmutableList) obj;
        HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        subParts.a(this.f23949c, new StylingData(PaddingStyle.p));
        return new State(m27526a((SearchResultsProductItemUnit) immutableList.get(0), hasPositionInformation), m27526a((SearchResultsProductItemUnit) immutableList.get(1), hasPositionInformation));
    }

    public final /* bridge */ /* synthetic */ void m27532a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -255432421);
        m27528a((ImmutableList) obj, (State) obj2, (CommerceProductItemGridRowView) view);
        Logger.a(8, EntryType.MARK_POP, 1557038812, a);
    }

    public final boolean m27533a(Object obj) {
        return ((ImmutableList) obj).size() <= 2;
    }

    public final void m27534b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        CommerceProductItemGridRowView commerceProductItemGridRowView = (CommerceProductItemGridRowView) view;
        commerceProductItemGridRowView.f23926a.setOnClickListener(null);
        commerceProductItemGridRowView.f23927b.setOnClickListener(null);
    }

    public static CommerceProductItemsGridRowPartDefinition m27527a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CommerceProductItemsGridRowPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23948h) {
                CommerceProductItemsGridRowPartDefinition commerceProductItemsGridRowPartDefinition;
                if (a2 != null) {
                    commerceProductItemsGridRowPartDefinition = (CommerceProductItemsGridRowPartDefinition) a2.a(f23948h);
                } else {
                    commerceProductItemsGridRowPartDefinition = f23947g;
                }
                if (commerceProductItemsGridRowPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27529b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23948h, b3);
                        } else {
                            f23947g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = commerceProductItemsGridRowPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public CommerceProductItemsGridRowPartDefinition(BackgroundPartDefinition backgroundPartDefinition, CommerceNavigationUtil commerceNavigationUtil, ViewPermalinkIntentFactory viewPermalinkIntentFactory, SecureContextHelper secureContextHelper) {
        this.f23949c = backgroundPartDefinition;
        this.f23950d = commerceNavigationUtil;
        this.f23951e = viewPermalinkIntentFactory;
        this.f23952f = secureContextHelper;
    }

    public final ViewType<CommerceProductItemGridRowView> m27530a() {
        return f23945a;
    }

    private static void m27528a(ImmutableList<SearchResultsProductItemUnit> immutableList, State state, CommerceProductItemGridRowView commerceProductItemGridRowView) {
        SearchResultsProductItemUnit searchResultsProductItemUnit;
        CommerceProductGridItemView commerceProductGridItemView = commerceProductItemGridRowView.f23926a;
        CommerceProductGridItemView commerceProductGridItemView2 = commerceProductItemGridRowView.f23927b;
        if (immutableList.size() > 0) {
            searchResultsProductItemUnit = (SearchResultsProductItemUnit) immutableList.get(0);
            commerceProductGridItemView.m27511a(CommerceThumbnailPartDefinition.m27539a(searchResultsProductItemUnit), f23946b);
            if (searchResultsProductItemUnit.f23494a.gI() != null) {
                commerceProductGridItemView.setProductPrice(searchResultsProductItemUnit.f23494a.gI().l());
            } else {
                commerceProductGridItemView.setProductPrice(searchResultsProductItemUnit.f23494a.ec().l());
            }
            if (!(searchResultsProductItemUnit.f23494a.gU() == null || searchResultsProductItemUnit.f23494a.gU().ai() == null)) {
                commerceProductGridItemView.m27512b(Uri.parse(searchResultsProductItemUnit.f23494a.gU().ai().b()), f23946b);
            }
            commerceProductGridItemView.setOnClickListener(state.f23943a);
            commerceProductGridItemView.setVisibility(0);
        } else {
            commerceProductGridItemView.setVisibility(4);
        }
        if (immutableList.size() >= 2) {
            searchResultsProductItemUnit = (SearchResultsProductItemUnit) immutableList.get(1);
            commerceProductGridItemView2.m27511a(CommerceThumbnailPartDefinition.m27539a(searchResultsProductItemUnit), f23946b);
            if (searchResultsProductItemUnit.f23494a.gI() != null) {
                commerceProductGridItemView2.setProductPrice(searchResultsProductItemUnit.f23494a.gI().l());
            } else {
                commerceProductGridItemView2.setProductPrice(searchResultsProductItemUnit.f23494a.ec().l());
            }
            if (!(searchResultsProductItemUnit.f23494a.gU() == null || searchResultsProductItemUnit.f23494a.gU().ai() == null)) {
                commerceProductGridItemView2.m27512b(Uri.parse(searchResultsProductItemUnit.f23494a.gU().ai().b()), f23946b);
            }
            commerceProductGridItemView2.setOnClickListener(state.f23944b);
            commerceProductGridItemView2.setVisibility(0);
            return;
        }
        commerceProductGridItemView2.setVisibility(4);
    }

    private OnClickListener m27526a(final SearchResultsProductItemUnit searchResultsProductItemUnit, final E e) {
        if (searchResultsProductItemUnit == null) {
            return null;
        }
        return new OnClickListener(this) {
            final /* synthetic */ CommerceProductItemsGridRowPartDefinition f23942c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1439247089);
                GraphQLNode graphQLNode = searchResultsProductItemUnit.f23494a;
                if (searchResultsProductItemUnit.f23495b == GraphQLGraphSearchResultRole.COMMERCE_B2C) {
                    this.f23942c.f23950d.a(graphQLNode.dp(), CommerceRefType.GLOBAL_SEARCH);
                } else if (searchResultsProductItemUnit.f23495b == GraphQLGraphSearchResultRole.COMMERCE_C2C) {
                    GraphQLStory jT = graphQLNode.jT();
                    Builder builder = new Builder();
                    builder.a = jT.c();
                    builder = builder;
                    builder.b = jT.g();
                    Intent a2 = this.f23942c.f23951e.a(builder.a());
                    if (a2 != null) {
                        this.f23942c.f23952f.a(a2, ((HasContext) e).getContext());
                    }
                }
                ((CanLogCollectionItemNavigation) e).mo1259a(searchResultsProductItemUnit);
                LogUtils.a(-733773126, a);
            }
        };
    }
}
