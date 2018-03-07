package com.facebook.search.typeahead.rows;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.fbui.widget.contentview.ContentView.ThumbnailSize;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.search.constants.SearchActivityLogFilter;
import com.facebook.search.model.SuggestionGroup.Type;
import com.facebook.search.results.rows.SearchBackgroundPartDefinition;
import com.facebook.search.suggestions.model.HeaderRowTypeaheadUnit;
import com.facebook.search.suggestions.nullstate.RecentSearchesNullStateSupplier;
import com.facebook.search.suggestions.nullstate.RecentVideoSearchesNullStateSupplier;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: verification_succeeded */
public class SearchTypeaheadHeaderPartDefinition<E extends HasPositionInformation & HasContext> extends MultiRowSinglePartDefinition<HeaderRowTypeaheadUnit, OnClickListener, E, ContentView> {
    public static final ViewType f533a = new C00481();
    private static final PaddingStyle f534b;
    private static SearchTypeaheadHeaderPartDefinition f535i;
    private static final Object f536j = new Object();
    public final Context f537c;
    public final Lazy<RecentSearchesNullStateSupplier> f538d;
    public final Lazy<RecentVideoSearchesNullStateSupplier> f539e;
    public final String f540f;
    public final FbUriIntentHandler f541g;
    private final SearchBackgroundPartDefinition f542h;

    /* compiled from: verification_succeeded */
    final class C00481 extends ViewType {
        C00481() {
        }

        public final View m631a(Context context) {
            return LayoutInflater.from(context).inflate(2130903524, null);
        }
    }

    private static SearchTypeaheadHeaderPartDefinition m633b(InjectorLike injectorLike) {
        return new SearchTypeaheadHeaderPartDefinition((Context) injectorLike.getInstance(Context.class), IdBasedSingletonScopeProvider.b(injectorLike, 3397), IdBasedSingletonScopeProvider.b(injectorLike, 3398), String_LoggedInUserIdMethodAutoProvider.b(injectorLike), FbUriIntentHandler.a(injectorLike), SearchBackgroundPartDefinition.a(injectorLike));
    }

    public final Object m635a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final HeaderRowTypeaheadUnit headerRowTypeaheadUnit = (HeaderRowTypeaheadUnit) obj;
        subParts.a(this.f542h, new StylingData(FeedProps.c(headerRowTypeaheadUnit), f534b, Position.MIDDLE));
        return new OnClickListener(this) {
            final /* synthetic */ SearchTypeaheadHeaderPartDefinition f532b;

            public void onClick(View view) {
                String formatStrLocaleSafe;
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1617033843);
                if (headerRowTypeaheadUnit.k() == Type.RECENT) {
                    ((RecentSearchesNullStateSupplier) this.f532b.f538d.get()).e();
                    formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.bd, this.f532b.f540f);
                } else if (headerRowTypeaheadUnit.k() == Type.RECENT_VIDEOS) {
                    ((RecentVideoSearchesNullStateSupplier) this.f532b.f539e.get()).e();
                    formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.be, this.f532b.f540f, SearchActivityLogFilter.VIDEOS);
                } else {
                    LogUtils.a(1539398497, a);
                    return;
                }
                this.f532b.f541g.a(this.f532b.f537c, formatStrLocaleSafe);
                LogUtils.a(-1961005080, a);
            }
        };
    }

    public final /* bridge */ /* synthetic */ void m636a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1236054751);
        HeaderRowTypeaheadUnit headerRowTypeaheadUnit = (HeaderRowTypeaheadUnit) obj;
        OnClickListener onClickListener = (OnClickListener) obj2;
        ContentView contentView = (ContentView) view;
        contentView.setThumbnailSize(ThumbnailSize.SMALL);
        contentView.setTitleText(headerRowTypeaheadUnit.f171a.c);
        if (headerRowTypeaheadUnit.f171a.f) {
            BetterTextView betterTextView = (BetterTextView) contentView.a;
            betterTextView.setOnClickListener(onClickListener);
            betterTextView.setText(headerRowTypeaheadUnit.f171a.d);
            contentView.setShowAuxView(true);
        } else {
            contentView.setShowAuxView(false);
        }
        Logger.a(8, EntryType.MARK_POP, -1768458654, a);
    }

    public final void m638b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        BetterTextView betterTextView = (BetterTextView) ((ContentView) view).a;
        if (betterTextView != null) {
            betterTextView.setOnClickListener(null);
        }
    }

    static {
        Builder c = Builder.c();
        c.b = -2.0f;
        c = c;
        c.c = -2.0f;
        c = c;
        c.d = 12.0f;
        f534b = c.i();
    }

    public static SearchTypeaheadHeaderPartDefinition m632a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchTypeaheadHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f536j) {
                SearchTypeaheadHeaderPartDefinition searchTypeaheadHeaderPartDefinition;
                if (a2 != null) {
                    searchTypeaheadHeaderPartDefinition = (SearchTypeaheadHeaderPartDefinition) a2.a(f536j);
                } else {
                    searchTypeaheadHeaderPartDefinition = f535i;
                }
                if (searchTypeaheadHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m633b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f536j, b3);
                        } else {
                            f535i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchTypeaheadHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SearchTypeaheadHeaderPartDefinition(Context context, Lazy<RecentSearchesNullStateSupplier> lazy, Lazy<RecentVideoSearchesNullStateSupplier> lazy2, String str, FbUriIntentHandler fbUriIntentHandler, SearchBackgroundPartDefinition searchBackgroundPartDefinition) {
        this.f537c = context;
        this.f538d = lazy;
        this.f539e = lazy2;
        this.f540f = str;
        this.f541g = fbUriIntentHandler;
        this.f542h = searchBackgroundPartDefinition;
    }

    public final ViewType m634a() {
        return f533a;
    }

    public final boolean m637a(Object obj) {
        return true;
    }
}
