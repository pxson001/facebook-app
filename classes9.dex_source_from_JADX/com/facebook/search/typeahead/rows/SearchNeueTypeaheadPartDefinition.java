package com.facebook.search.typeahead.rows;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
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
import com.facebook.search.model.NeueTypeaheadUnit;
import javax.inject.Inject;

@ContextScoped
/* compiled from: video_attachment_count */
public class SearchNeueTypeaheadPartDefinition extends MultiRowSinglePartDefinition<NeueTypeaheadUnit, Void, AnyEnvironment, ImageBlockLayout> {
    public static final ViewType f449a = new C00431();
    private static SearchNeueTypeaheadPartDefinition f450e;
    private static final Object f451f = new Object();
    private final SearchTypeaheadThumbnailPartDefinition f452b;
    private final SearchTypeaheadTitlePartDefinition f453c;
    private final SearchTypeaheadSnippetPartDefinition f454d;

    /* compiled from: video_attachment_count */
    final class C00431 extends ViewType {
        C00431() {
        }

        public final View m558a(Context context) {
            return LayoutInflater.from(context).inflate(2130905431, null);
        }
    }

    private static SearchNeueTypeaheadPartDefinition m560b(InjectorLike injectorLike) {
        return new SearchNeueTypeaheadPartDefinition(SearchTypeaheadThumbnailPartDefinition.m728a(injectorLike), SearchTypeaheadTitlePartDefinition.m731a(injectorLike), SearchTypeaheadSnippetPartDefinition.m723a(injectorLike));
    }

    public final Object m562a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        NeueTypeaheadUnit neueTypeaheadUnit = (NeueTypeaheadUnit) obj;
        subParts.a(2131564204, this.f452b, neueTypeaheadUnit.c);
        subParts.a(2131564206, this.f453c, neueTypeaheadUnit.a);
        subParts.a(2131564207, this.f454d, neueTypeaheadUnit.b);
        return null;
    }

    public final /* bridge */ /* synthetic */ void m563a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1043964424);
        ImageBlockLayout imageBlockLayout = (ImageBlockLayout) view;
        imageBlockLayout.setThumbnailPadding(imageBlockLayout.getResources().getDimensionPixelSize(2131431729));
        Logger.a(8, EntryType.MARK_POP, 252243745, a);
    }

    public final boolean m564a(Object obj) {
        NeueTypeaheadUnit neueTypeaheadUnit = (NeueTypeaheadUnit) obj;
        return (neueTypeaheadUnit.a == null || neueTypeaheadUnit.b == null || neueTypeaheadUnit.c == null) ? false : true;
    }

    @Inject
    public SearchNeueTypeaheadPartDefinition(SearchTypeaheadThumbnailPartDefinition searchTypeaheadThumbnailPartDefinition, SearchTypeaheadTitlePartDefinition searchTypeaheadTitlePartDefinition, SearchTypeaheadSnippetPartDefinition searchTypeaheadSnippetPartDefinition) {
        this.f452b = searchTypeaheadThumbnailPartDefinition;
        this.f453c = searchTypeaheadTitlePartDefinition;
        this.f454d = searchTypeaheadSnippetPartDefinition;
    }

    public static SearchNeueTypeaheadPartDefinition m559a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchNeueTypeaheadPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f451f) {
                SearchNeueTypeaheadPartDefinition searchNeueTypeaheadPartDefinition;
                if (a2 != null) {
                    searchNeueTypeaheadPartDefinition = (SearchNeueTypeaheadPartDefinition) a2.a(f451f);
                } else {
                    searchNeueTypeaheadPartDefinition = f450e;
                }
                if (searchNeueTypeaheadPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m560b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f451f, b3);
                        } else {
                            f450e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchNeueTypeaheadPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<ImageBlockLayout> m561a() {
        return f449a;
    }
}
