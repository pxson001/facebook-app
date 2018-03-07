package com.facebook.search.typeahead.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
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
import com.facebook.search.model.TypeaheadThumbnailModel;

@ContextScoped
/* compiled from: value is absent */
public class SearchTypeaheadThumbnailPartDefinition extends BaseSinglePartDefinition<TypeaheadThumbnailModel, Void, AnyEnvironment, FbDraweeView> {
    public static final CallerContext f632a = CallerContext.a(SearchTypeaheadThumbnailPartDefinition.class, "search");
    private static SearchTypeaheadThumbnailPartDefinition f633b;
    private static final Object f634c = new Object();

    private static SearchTypeaheadThumbnailPartDefinition m727a() {
        return new SearchTypeaheadThumbnailPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m729a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -257547974);
        TypeaheadThumbnailModel typeaheadThumbnailModel = (TypeaheadThumbnailModel) obj;
        FbDraweeView fbDraweeView = (FbDraweeView) view;
        fbDraweeView.a(typeaheadThumbnailModel.a, f632a);
        ((GenericDraweeHierarchy) fbDraweeView.getHierarchy()).b(typeaheadThumbnailModel.b);
        Logger.a(8, EntryType.MARK_POP, 562194518, a);
    }

    public static SearchTypeaheadThumbnailPartDefinition m728a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchTypeaheadThumbnailPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f634c) {
                SearchTypeaheadThumbnailPartDefinition searchTypeaheadThumbnailPartDefinition;
                if (a3 != null) {
                    searchTypeaheadThumbnailPartDefinition = (SearchTypeaheadThumbnailPartDefinition) a3.a(f634c);
                } else {
                    searchTypeaheadThumbnailPartDefinition = f633b;
                }
                if (searchTypeaheadThumbnailPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m727a();
                        if (a3 != null) {
                            a3.a(f634c, a2);
                        } else {
                            f633b = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = searchTypeaheadThumbnailPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
