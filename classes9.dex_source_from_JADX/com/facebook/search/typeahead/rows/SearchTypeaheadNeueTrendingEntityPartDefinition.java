package com.facebook.search.typeahead.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.fbui.widget.contentview.ContentView.ThumbnailSize;
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
import com.facebook.multirow.api.ViewType;
import com.facebook.search.model.TrendingTypeaheadUnit;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: vault_temp */
public class SearchTypeaheadNeueTrendingEntityPartDefinition extends MultiRowSinglePartDefinition<TrendingTypeaheadUnit, Void, AnyEnvironment, ContentView> {
    public static final ViewType f581a = ViewType.a(2130904633);
    private static SearchTypeaheadNeueTrendingEntityPartDefinition f582d;
    private static final Object f583e = new Object();
    public final Context f584b;
    public final GlyphColorizer f585c;

    private static SearchTypeaheadNeueTrendingEntityPartDefinition m670b(InjectorLike injectorLike) {
        return new SearchTypeaheadNeueTrendingEntityPartDefinition((Context) injectorLike.getInstance(Context.class), GlyphColorizer.a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ void m672a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -2027698688);
        TrendingTypeaheadUnit trendingTypeaheadUnit = (TrendingTypeaheadUnit) obj;
        ContentView contentView = (ContentView) view;
        contentView.setMaxLinesFromThumbnailSize(false);
        contentView.e(1, 1);
        contentView.setTitleTextAppearance(2131625904);
        contentView.setTitleText(trendingTypeaheadUnit.b);
        contentView.setThumbnailSize(ThumbnailSize.SMALL);
        contentView.setThumbnailPadding(this.f584b.getResources().getDimensionPixelSize(2131431729));
        contentView.setThumbnailGravity(17);
        if (trendingTypeaheadUnit.u()) {
            contentView.setThumbnailResource(2130840605);
        } else {
            contentView.setThumbnailDrawable(this.f585c.a(2130841681, this.f584b.getResources().getColor(2131363413)));
        }
        contentView.setSubtitleTextAppearance(2131625912);
        if (!Strings.isNullOrEmpty(trendingTypeaheadUnit.g)) {
            contentView.setSubtitleText(trendingTypeaheadUnit.g);
        }
        contentView.setPadding(contentView.getPaddingLeft(), this.f584b.getResources().getDimensionPixelSize(2131431730), contentView.getPaddingRight(), this.f584b.getResources().getDimensionPixelSize(2131431730));
        Logger.a(8, EntryType.MARK_POP, 1410416428, a);
    }

    @Inject
    public SearchTypeaheadNeueTrendingEntityPartDefinition(Context context, GlyphColorizer glyphColorizer) {
        this.f584b = context;
        this.f585c = glyphColorizer;
    }

    public final boolean m673a(Object obj) {
        return true;
    }

    public final ViewType<ContentView> m671a() {
        return f581a;
    }

    public static SearchTypeaheadNeueTrendingEntityPartDefinition m669a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchTypeaheadNeueTrendingEntityPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f583e) {
                SearchTypeaheadNeueTrendingEntityPartDefinition searchTypeaheadNeueTrendingEntityPartDefinition;
                if (a2 != null) {
                    searchTypeaheadNeueTrendingEntityPartDefinition = (SearchTypeaheadNeueTrendingEntityPartDefinition) a2.a(f583e);
                } else {
                    searchTypeaheadNeueTrendingEntityPartDefinition = f582d;
                }
                if (searchTypeaheadNeueTrendingEntityPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m670b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f583e, b3);
                        } else {
                            f582d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchTypeaheadNeueTrendingEntityPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
