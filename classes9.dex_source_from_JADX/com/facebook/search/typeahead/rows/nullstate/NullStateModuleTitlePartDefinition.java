package com.facebook.search.typeahead.rows.nullstate;

import android.content.Context;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.SeparatedSpannableStringBuilder;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.fbui.widget.contentview.ContentView.ThumbnailSize;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
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
import com.facebook.multirow.parts.ContentViewTitlePartDefinition;
import com.facebook.search.model.NullStateModuleCollectionUnit;
import com.facebook.search.results.rows.SearchBackgroundPartDefinition;
import com.facebook.search.suggestions.environment.SearchSuggestionsEnvironment;
import com.facebook.search.suggestions.nullstate.ContentDiscoveryNullStateSupplier;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: utf-16 */
public class NullStateModuleTitlePartDefinition extends MultiRowSinglePartDefinition<FeedProps<NullStateModuleCollectionUnit>, String, SearchSuggestionsEnvironment, ContentView> {
    public static final ViewType<ContentView> f684a = ViewType.a(2130905503);
    private static final PaddingStyle f685b;
    private static NullStateModuleTitlePartDefinition f686f;
    private static final Object f687g = new Object();
    public final Context f688c;
    private final ContentViewTitlePartDefinition f689d;
    private final SearchBackgroundPartDefinition f690e;

    private static NullStateModuleTitlePartDefinition m772b(InjectorLike injectorLike) {
        return new NullStateModuleTitlePartDefinition((Context) injectorLike.getInstance(Context.class), ContentViewTitlePartDefinition.a(injectorLike), SearchBackgroundPartDefinition.a(injectorLike));
    }

    public final Object m774a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        SeparatedSpannableStringBuilder separatedSpannableStringBuilder;
        FeedProps feedProps = (FeedProps) obj;
        NullStateModuleCollectionUnit nullStateModuleCollectionUnit = (NullStateModuleCollectionUnit) feedProps.a;
        ContentViewTitlePartDefinition contentViewTitlePartDefinition = this.f689d;
        String str = nullStateModuleCollectionUnit.c;
        String str2 = nullStateModuleCollectionUnit.d;
        if (Strings.isNullOrEmpty(str) && Strings.isNullOrEmpty(str2)) {
            separatedSpannableStringBuilder = null;
        } else {
            separatedSpannableStringBuilder = new SeparatedSpannableStringBuilder(" ");
            separatedSpannableStringBuilder.a(str);
            if (!Strings.isNullOrEmpty(str2)) {
                separatedSpannableStringBuilder.a(str2, new TextAppearanceSpan(this.f688c, 2131625903), 17);
            }
        }
        subParts.a(contentViewTitlePartDefinition, separatedSpannableStringBuilder);
        subParts.a(this.f690e, new StylingData(feedProps, f685b, Position.MIDDLE));
        if (nullStateModuleCollectionUnit.h <= 0) {
            return null;
        }
        return this.f688c.getResources().getQuantityString(2131689688, nullStateModuleCollectionUnit.h, new Object[]{Integer.valueOf(nullStateModuleCollectionUnit.h)});
    }

    public final /* bridge */ /* synthetic */ void m775a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1663339824);
        String str = (String) obj2;
        SearchSuggestionsEnvironment searchSuggestionsEnvironment = (SearchSuggestionsEnvironment) anyEnvironment;
        ContentView contentView = (ContentView) view;
        NullStateModuleCollectionUnit nullStateModuleCollectionUnit = (NullStateModuleCollectionUnit) ((FeedProps) obj).a;
        contentView.setThumbnailSize(ThumbnailSize.SMALL);
        contentView.setGravity(16);
        contentView.setTitleTextAppearance(2131625898);
        contentView.setThumbnailView(null);
        if (nullStateModuleCollectionUnit.h > 0) {
            contentView.setShowAuxView(true);
            ((BetterTextView) contentView.a).setText(str);
            if (searchSuggestionsEnvironment.f116p != null) {
                ((ContentDiscoveryNullStateSupplier) searchSuggestionsEnvironment.f116p.get()).e();
            }
        } else {
            contentView.setShowAuxView(false);
            ((BetterTextView) contentView.a).setText(str);
        }
        Logger.a(8, EntryType.MARK_POP, -1756848836, a);
    }

    static {
        Builder c = Builder.c();
        c.b = -2.0f;
        c = c;
        c.c = -2.0f;
        c = c;
        c.d = 12.0f;
        f685b = c.i();
    }

    @Inject
    public NullStateModuleTitlePartDefinition(Context context, ContentViewTitlePartDefinition contentViewTitlePartDefinition, SearchBackgroundPartDefinition searchBackgroundPartDefinition) {
        this.f688c = context;
        this.f689d = contentViewTitlePartDefinition;
        this.f690e = searchBackgroundPartDefinition;
    }

    public static NullStateModuleTitlePartDefinition m771a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NullStateModuleTitlePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f687g) {
                NullStateModuleTitlePartDefinition nullStateModuleTitlePartDefinition;
                if (a2 != null) {
                    nullStateModuleTitlePartDefinition = (NullStateModuleTitlePartDefinition) a2.a(f687g);
                } else {
                    nullStateModuleTitlePartDefinition = f686f;
                }
                if (nullStateModuleTitlePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m772b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f687g, b3);
                        } else {
                            f686f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = nullStateModuleTitlePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<ContentView> m773a() {
        return f684a;
    }

    public final boolean m776a(Object obj) {
        return true;
    }
}
