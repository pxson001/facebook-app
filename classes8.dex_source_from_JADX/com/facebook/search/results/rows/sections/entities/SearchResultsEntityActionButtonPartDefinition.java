package com.facebook.search.results.rows.sections.entities;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.contentview.ContentViewWithButton;
import com.facebook.feed.environment.HasContext;
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
import com.facebook.search.results.rows.sections.entities.SearchResultsEntityActionButtonFigPartDefinition.State;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: RAISED */
public class SearchResultsEntityActionButtonPartDefinition extends BaseSinglePartDefinition<ActionButtonData, State, HasContext, ContentViewWithButton> {
    private static SearchResultsEntityActionButtonPartDefinition f24160b;
    private static final Object f24161c = new Object();
    private final GlyphColorizer f24162a;

    /* compiled from: RAISED */
    public class ActionButtonData {
        public final int f24157a;
        @Nullable
        public final OnClickListener f24158b;
        public final int f24159c;

        public ActionButtonData(int i, int i2, OnClickListener onClickListener) {
            this.f24157a = i;
            this.f24158b = onClickListener;
            this.f24159c = i2;
        }
    }

    private static SearchResultsEntityActionButtonPartDefinition m27701b(InjectorLike injectorLike) {
        return new SearchResultsEntityActionButtonPartDefinition(GlyphColorizer.a(injectorLike));
    }

    public final Object m27702a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return SearchResultsEntityActionButtonFigPartDefinition.m27694a((ActionButtonData) obj, (HasContext) anyEnvironment, this.f24162a);
    }

    public final /* bridge */ /* synthetic */ void m27703a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 27667660);
        ActionButtonData actionButtonData = (ActionButtonData) obj;
        State state = (State) obj2;
        ContentViewWithButton contentViewWithButton = (ContentViewWithButton) view;
        contentViewWithButton.setActionButtonDrawable(state.f24152a);
        contentViewWithButton.setShowActionButton(state.f24152a != null);
        contentViewWithButton.setActionButtonBackground(null);
        contentViewWithButton.setActionButtonOnClickListener(actionButtonData.f24158b);
        contentViewWithButton.setActionButtonContentDescription(state.f24153b);
        Logger.a(8, EntryType.MARK_POP, 485455981, a);
    }

    public final void m27704b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((ContentViewWithButton) view).setActionButtonOnClickListener(null);
    }

    @Inject
    public SearchResultsEntityActionButtonPartDefinition(GlyphColorizer glyphColorizer) {
        this.f24162a = glyphColorizer;
    }

    public static SearchResultsEntityActionButtonPartDefinition m27700a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsEntityActionButtonPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24161c) {
                SearchResultsEntityActionButtonPartDefinition searchResultsEntityActionButtonPartDefinition;
                if (a2 != null) {
                    searchResultsEntityActionButtonPartDefinition = (SearchResultsEntityActionButtonPartDefinition) a2.a(f24161c);
                } else {
                    searchResultsEntityActionButtonPartDefinition = f24160b;
                }
                if (searchResultsEntityActionButtonPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27701b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24161c, b3);
                        } else {
                            f24160b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsEntityActionButtonPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
