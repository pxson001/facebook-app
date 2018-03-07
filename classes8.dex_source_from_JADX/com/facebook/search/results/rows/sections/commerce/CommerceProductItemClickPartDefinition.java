package com.facebook.search.results.rows.sections.commerce;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.commerce.core.analytics.CommerceAnalytics.CommerceRefType;
import com.facebook.commerce.core.util.CommerceNavigationUtil;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.environment.HasContext;
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
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.search.results.environment.common.CanLogCollectionItemNavigation;
import com.facebook.search.results.model.unit.SearchResultsProductItemUnit;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.inject.Inject;

@ContextScoped
/* compiled from: RECT */
public class CommerceProductItemClickPartDefinition<E extends HasContext & CanLogCollectionItemNavigation> extends BaseSinglePartDefinition<SearchResultsProductItemUnit, Void, E, View> {
    private static CommerceProductItemClickPartDefinition f23920e;
    private static final Object f23921f = new Object();
    private final ClickListenerPartDefinition f23922a;
    public final CommerceNavigationUtil f23923b;
    public final ViewPermalinkIntentFactory f23924c;
    public final SecureContextHelper f23925d;

    private static CommerceProductItemClickPartDefinition m27514b(InjectorLike injectorLike) {
        return new CommerceProductItemClickPartDefinition(ClickListenerPartDefinition.a(injectorLike), CommerceNavigationUtil.a(injectorLike), ViewPermalinkIntentFactory.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    public final Object m27515a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final SearchResultsProductItemUnit searchResultsProductItemUnit = (SearchResultsProductItemUnit) obj;
        final HasContext hasContext = (HasContext) anyEnvironment;
        subParts.a(this.f23922a, new OnClickListener(this) {
            final /* synthetic */ CommerceProductItemClickPartDefinition f23919c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 454592342);
                GraphQLNode graphQLNode = searchResultsProductItemUnit.f23494a;
                if (searchResultsProductItemUnit.f23495b == GraphQLGraphSearchResultRole.COMMERCE_B2C) {
                    this.f23919c.f23923b.a(graphQLNode.dp(), CommerceRefType.GLOBAL_SEARCH);
                } else if (searchResultsProductItemUnit.f23495b == GraphQLGraphSearchResultRole.COMMERCE_C2C) {
                    GraphQLStory jT = graphQLNode.jT();
                    Builder builder = new Builder();
                    builder.a = jT.c();
                    builder = builder;
                    builder.b = jT.g();
                    Intent a2 = this.f23919c.f23924c.a(builder.a());
                    if (a2 != null) {
                        this.f23919c.f23925d.a(a2, hasContext.getContext());
                    }
                }
                ((CanLogCollectionItemNavigation) hasContext).mo1259a(searchResultsProductItemUnit);
                LogUtils.a(-568736978, a);
            }
        });
        return null;
    }

    @Inject
    public CommerceProductItemClickPartDefinition(ClickListenerPartDefinition clickListenerPartDefinition, CommerceNavigationUtil commerceNavigationUtil, ViewPermalinkIntentFactory viewPermalinkIntentFactory, SecureContextHelper secureContextHelper) {
        this.f23922a = clickListenerPartDefinition;
        this.f23923b = commerceNavigationUtil;
        this.f23924c = viewPermalinkIntentFactory;
        this.f23925d = secureContextHelper;
    }

    public static CommerceProductItemClickPartDefinition m27513a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CommerceProductItemClickPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23921f) {
                CommerceProductItemClickPartDefinition commerceProductItemClickPartDefinition;
                if (a2 != null) {
                    commerceProductItemClickPartDefinition = (CommerceProductItemClickPartDefinition) a2.a(f23921f);
                } else {
                    commerceProductItemClickPartDefinition = f23920e;
                }
                if (commerceProductItemClickPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27514b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23921f, b3);
                        } else {
                            f23920e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = commerceProductItemClickPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
