package com.facebook.search.results.rows.sections.entities;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.feed.environment.HasContext;
import com.facebook.fig.listitem.FigListItem;
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
import com.facebook.search.results.rows.sections.entities.SearchResultsEntityActionButtonPartDefinition.ActionButtonData;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: RANKED_BOOKMARKS_SECTION */
public class SearchResultsEntityActionButtonFigPartDefinition extends BaseSinglePartDefinition<ActionButtonData, State, HasContext, FigListItem> {
    private static SearchResultsEntityActionButtonFigPartDefinition f24154b;
    private static final Object f24155c = new Object();
    private final GlyphColorizer f24156a;

    /* compiled from: RANKED_BOOKMARKS_SECTION */
    public class State {
        @Nullable
        public final Drawable f24152a;
        @Nullable
        public final CharSequence f24153b;

        public State(Drawable drawable, CharSequence charSequence) {
            this.f24152a = drawable;
            this.f24153b = charSequence;
        }
    }

    private static SearchResultsEntityActionButtonFigPartDefinition m27696b(InjectorLike injectorLike) {
        return new SearchResultsEntityActionButtonFigPartDefinition(GlyphColorizer.a(injectorLike));
    }

    public final Object m27697a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return m27694a((ActionButtonData) obj, (HasContext) anyEnvironment, this.f24156a);
    }

    public final /* bridge */ /* synthetic */ void m27698a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1757580114);
        ActionButtonData actionButtonData = (ActionButtonData) obj;
        State state = (State) obj2;
        FigListItem figListItem = (FigListItem) view;
        figListItem.setActionType(state.f24152a != null ? 7 : 0);
        figListItem.setActionDrawable(state.f24152a);
        figListItem.setActionOnClickListener(actionButtonData.f24158b);
        figListItem.setActionContentDescription(state.f24153b);
        Logger.a(8, EntryType.MARK_POP, 433306871, a);
    }

    public final void m27699b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((FigListItem) view).setActionOnClickListener(null);
    }

    @Inject
    public SearchResultsEntityActionButtonFigPartDefinition(GlyphColorizer glyphColorizer) {
        this.f24156a = glyphColorizer;
    }

    public static SearchResultsEntityActionButtonFigPartDefinition m27695a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsEntityActionButtonFigPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24155c) {
                SearchResultsEntityActionButtonFigPartDefinition searchResultsEntityActionButtonFigPartDefinition;
                if (a2 != null) {
                    searchResultsEntityActionButtonFigPartDefinition = (SearchResultsEntityActionButtonFigPartDefinition) a2.a(f24155c);
                } else {
                    searchResultsEntityActionButtonFigPartDefinition = f24154b;
                }
                if (searchResultsEntityActionButtonFigPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27696b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24155c, b3);
                        } else {
                            f24154b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsEntityActionButtonFigPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public static State m27694a(ActionButtonData actionButtonData, HasContext hasContext, GlyphColorizer glyphColorizer) {
        CharSequence charSequence = null;
        Context context = hasContext.getContext();
        Drawable drawable = actionButtonData.f24157a != 0 ? context.getResources().getDrawable(actionButtonData.f24157a) : null;
        if (drawable != null) {
            drawable.setColorFilter(glyphColorizer.a(-7235677));
        }
        if (actionButtonData.f24159c != 0) {
            charSequence = context.getText(actionButtonData.f24159c);
        }
        return new State(drawable, charSequence);
    }
}
