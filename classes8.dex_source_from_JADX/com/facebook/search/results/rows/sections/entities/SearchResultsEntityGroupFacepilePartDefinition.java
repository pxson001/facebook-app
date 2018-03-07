package com.facebook.search.results.rows.sections.entities;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.facepile.Face;
import com.facebook.fbui.facepile.FacepileGridView;
import com.facebook.feed.environment.HasContext;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLUser;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

@ContextScoped
/* compiled from: QuickPromotion_action */
public class SearchResultsEntityGroupFacepilePartDefinition extends BaseSinglePartDefinition<FacepileData, ImmutableList<Face>, HasContext, FacepileGridView> {
    private static final int f24180a = 2131361939;
    private static SearchResultsEntityGroupFacepilePartDefinition f24181b;
    private static final Object f24182c = new Object();

    /* compiled from: QuickPromotion_action */
    public final class FacepileData {
        public final int f24178a;
        public final ImmutableList<GraphQLUser> f24179b;

        public FacepileData(int i, ImmutableList<GraphQLUser> immutableList) {
            this.f24178a = i;
            this.f24179b = immutableList;
        }
    }

    private static SearchResultsEntityGroupFacepilePartDefinition m27720a() {
        return new SearchResultsEntityGroupFacepilePartDefinition();
    }

    public final Object m27722a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        int i;
        FacepileData facepileData = (FacepileData) obj;
        HasContext hasContext = (HasContext) anyEnvironment;
        Builder builder = new Builder();
        ImmutableList immutableList = facepileData.f24179b;
        int size = immutableList.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            GraphQLImage aI = ((GraphQLUser) immutableList.get(i2)).aI();
            String b = aI != null ? aI.b() : null;
            if (b != null) {
                builder.c(new Face(Uri.parse(b), 1, 1));
                i = i3 + 1;
                if (i == facepileData.f24178a) {
                    return builder.b();
                }
            } else {
                i = i3;
            }
            i2++;
            i3 = i;
        }
        i = hasContext.getContext().getResources().getColor(f24180a);
        while (i3 < facepileData.f24178a) {
            builder.c(new Face(new ColorDrawable(i), 1, 1));
            i3++;
        }
        return builder.b();
    }

    public final /* bridge */ /* synthetic */ void m27723a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1201355025);
        ((FacepileGridView) view).setFaces((ImmutableList) obj2);
        Logger.a(8, EntryType.MARK_POP, -1199711611, a);
    }

    public static SearchResultsEntityGroupFacepilePartDefinition m27721a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsEntityGroupFacepilePartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f24182c) {
                SearchResultsEntityGroupFacepilePartDefinition searchResultsEntityGroupFacepilePartDefinition;
                if (a3 != null) {
                    searchResultsEntityGroupFacepilePartDefinition = (SearchResultsEntityGroupFacepilePartDefinition) a3.a(f24182c);
                } else {
                    searchResultsEntityGroupFacepilePartDefinition = f24181b;
                }
                if (searchResultsEntityGroupFacepilePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m27720a();
                        if (a3 != null) {
                            a3.a(f24182c, a2);
                        } else {
                            f24181b = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = searchResultsEntityGroupFacepilePartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
