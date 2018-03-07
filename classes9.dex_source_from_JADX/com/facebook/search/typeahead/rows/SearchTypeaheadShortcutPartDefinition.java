package com.facebook.search.typeahead.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
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
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.search.model.ShortcutTypeaheadUnit;
import javax.inject.Inject;

@ContextScoped
/* compiled from: vaultImageUpload */
public class SearchTypeaheadShortcutPartDefinition extends MultiRowSinglePartDefinition<ShortcutTypeaheadUnit, State, AnyEnvironment, ContentView> {
    public static final ViewType<ContentView> f613a = ViewType.a(2130907118);
    private static SearchTypeaheadShortcutPartDefinition f614c;
    private static final Object f615d = new Object();
    private final Context f616b;

    /* compiled from: vaultImageUpload */
    public class State {
        public final int f611a;
        public final int f612b;

        public State(int i, int i2) {
            this.f611a = i;
            this.f612b = i2;
        }
    }

    private static SearchTypeaheadShortcutPartDefinition m706b(InjectorLike injectorLike) {
        return new SearchTypeaheadShortcutPartDefinition((Context) injectorLike.getInstance(Context.class));
    }

    public final /* bridge */ /* synthetic */ void m709a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1789830471);
        ShortcutTypeaheadUnit shortcutTypeaheadUnit = (ShortcutTypeaheadUnit) obj;
        State state = (State) obj2;
        ContentView contentView = (ContentView) view;
        contentView.setThumbnailSize(ThumbnailSize.SMALL);
        contentView.setThumbnailUri(shortcutTypeaheadUnit.d);
        contentView.setThumbnailPadding(state.f611a);
        contentView.setMaxLinesFromThumbnailSize(false);
        contentView.e(1, 1);
        contentView.setTitleTextAppearance(2131625904);
        contentView.setTitleText(shortcutTypeaheadUnit.b);
        contentView.setSubtitleText(shortcutTypeaheadUnit.f);
        contentView.setSubtitleTextAppearance(2131625912);
        contentView.setPadding(contentView.getPaddingLeft(), state.f612b, contentView.getPaddingRight(), state.f612b);
        Logger.a(8, EntryType.MARK_POP, 433569990, a);
    }

    @Inject
    public SearchTypeaheadShortcutPartDefinition(Context context) {
        this.f616b = context;
    }

    public final ViewType m707a() {
        return f613a;
    }

    public final boolean m710a(Object obj) {
        return true;
    }

    public final Object m708a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return new State(this.f616b.getResources().getDimensionPixelSize(2131431726), this.f616b.getResources().getDimensionPixelSize(2131431731));
    }

    public static SearchTypeaheadShortcutPartDefinition m705a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchTypeaheadShortcutPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f615d) {
                SearchTypeaheadShortcutPartDefinition searchTypeaheadShortcutPartDefinition;
                if (a2 != null) {
                    searchTypeaheadShortcutPartDefinition = (SearchTypeaheadShortcutPartDefinition) a2.a(f615d);
                } else {
                    searchTypeaheadShortcutPartDefinition = f614c;
                }
                if (searchTypeaheadShortcutPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m706b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f615d, b3);
                        } else {
                            f614c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchTypeaheadShortcutPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
