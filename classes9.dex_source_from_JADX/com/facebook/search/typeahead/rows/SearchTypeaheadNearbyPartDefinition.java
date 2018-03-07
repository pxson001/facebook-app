package com.facebook.search.typeahead.rows;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.search.model.NearbyTypeaheadUnit;
import javax.inject.Inject;

@ContextScoped
/* compiled from: vault_thread */
public class SearchTypeaheadNearbyPartDefinition extends MultiRowSinglePartDefinition<NearbyTypeaheadUnit, State, AnyEnvironment, ContentView> {
    public static final ViewType<ContentView> f577a = ViewType.a(2130906976);
    private static SearchTypeaheadNearbyPartDefinition f578c;
    private static final Object f579d = new Object();
    private final GlyphColorizer f580b;

    /* compiled from: vault_thread */
    public class State {
        public Drawable f576a;

        public State(Drawable drawable) {
            this.f576a = drawable;
        }
    }

    private static SearchTypeaheadNearbyPartDefinition m664b(InjectorLike injectorLike) {
        return new SearchTypeaheadNearbyPartDefinition(GlyphColorizer.a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ void m667a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -361616524);
        NearbyTypeaheadUnit nearbyTypeaheadUnit = (NearbyTypeaheadUnit) obj;
        State state = (State) obj2;
        ContentView contentView = (ContentView) view;
        contentView.setTitleText(nearbyTypeaheadUnit.b);
        contentView.setThumbnailDrawable(state.f576a);
        contentView.setSubtitleText(nearbyTypeaheadUnit.g);
        contentView.setShowAuxView(false);
        Logger.a(8, EntryType.MARK_POP, -1176107529, a);
    }

    @Inject
    public SearchTypeaheadNearbyPartDefinition(GlyphColorizer glyphColorizer) {
        this.f580b = glyphColorizer;
    }

    public final ViewType<ContentView> m665a() {
        return f577a;
    }

    public final boolean m668a(Object obj) {
        return true;
    }

    public final Object m666a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return new State(this.f580b.a(2130841642, -778386));
    }

    public static SearchTypeaheadNearbyPartDefinition m663a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchTypeaheadNearbyPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f579d) {
                SearchTypeaheadNearbyPartDefinition searchTypeaheadNearbyPartDefinition;
                if (a2 != null) {
                    searchTypeaheadNearbyPartDefinition = (SearchTypeaheadNearbyPartDefinition) a2.a(f579d);
                } else {
                    searchTypeaheadNearbyPartDefinition = f578c;
                }
                if (searchTypeaheadNearbyPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m664b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f579d, b3);
                        } else {
                            f578c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchTypeaheadNearbyPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
