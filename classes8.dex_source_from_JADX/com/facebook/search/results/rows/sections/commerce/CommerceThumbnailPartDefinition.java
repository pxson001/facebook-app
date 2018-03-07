package com.facebook.search.results.rows.sections.commerce;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.search.results.model.unit.SearchResultsProductItemUnit;
import com.google.common.collect.ImmutableList;

@ContextScoped
/* compiled from: READY_TO_PLAY */
public class CommerceThumbnailPartDefinition<E extends AnyEnvironment> extends BaseSinglePartDefinition<SearchResultsProductItemUnit, Uri, E, ContentView> {
    private static CommerceThumbnailPartDefinition f23959a;
    private static final Object f23960b = new Object();

    private static CommerceThumbnailPartDefinition m27540a() {
        return new CommerceThumbnailPartDefinition();
    }

    public final Object m27542a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return m27539a((SearchResultsProductItemUnit) obj);
    }

    public final /* bridge */ /* synthetic */ void m27543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1841613791);
        Uri uri = (Uri) obj2;
        ContentView contentView = (ContentView) view;
        contentView.setThumbnailPlaceholderResource(2130840626);
        contentView.setThumbnailUri(uri);
        Logger.a(8, EntryType.MARK_POP, -762171926, a);
    }

    public static Uri m27539a(SearchResultsProductItemUnit searchResultsProductItemUnit) {
        if (searchResultsProductItemUnit.f23494a == null) {
            return Uri.EMPTY;
        }
        if (searchResultsProductItemUnit.f23494a.dq() != null && searchResultsProductItemUnit.mo1321k() == GraphQLGraphSearchResultRole.COMMERCE_B2C) {
            return Uri.parse(searchResultsProductItemUnit.f23494a.dq().b());
        }
        if (searchResultsProductItemUnit.f23494a.jT() == null || searchResultsProductItemUnit.f23494a.jT().M() == null || searchResultsProductItemUnit.f23494a.jT().M().isEmpty()) {
            return Uri.EMPTY;
        }
        ImmutableList M = searchResultsProductItemUnit.f23494a.jT().M();
        int size = M.size();
        for (int i = 0; i < size; i++) {
            GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) M.get(i);
            if (graphQLStoryAttachment.r() != null && graphQLStoryAttachment.r().S() != null) {
                return Uri.parse(graphQLStoryAttachment.r().S().b());
            }
            if (!graphQLStoryAttachment.x().isEmpty()) {
                return Uri.parse(((GraphQLStoryAttachment) graphQLStoryAttachment.x().get(0)).r().S().b());
            }
        }
        return Uri.EMPTY;
    }

    public static CommerceThumbnailPartDefinition m27541a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CommerceThumbnailPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f23960b) {
                CommerceThumbnailPartDefinition commerceThumbnailPartDefinition;
                if (a3 != null) {
                    commerceThumbnailPartDefinition = (CommerceThumbnailPartDefinition) a3.a(f23960b);
                } else {
                    commerceThumbnailPartDefinition = f23959a;
                }
                if (commerceThumbnailPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m27540a();
                        if (a3 != null) {
                            a3.a(f23960b, a2);
                        } else {
                            f23959a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = commerceThumbnailPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
