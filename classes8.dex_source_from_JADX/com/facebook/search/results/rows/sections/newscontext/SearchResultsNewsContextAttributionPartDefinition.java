package com.facebook.search.results.rows.sections.newscontext;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
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
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PageInfoCardContextItemQuery */
public class SearchResultsNewsContextAttributionPartDefinition<E extends HasContext & HasPositionInformation> extends MultiRowSinglePartDefinition<String, Void, E, BetterTextView> {
    public static final ViewType f24617a = ViewType.a(2130905447);
    private static final PaddingStyle f24618b;
    private static SearchResultsNewsContextAttributionPartDefinition f24619g;
    private static final Object f24620h = new Object();
    private final TextPartDefinition f24621c;
    private final BackgroundPartDefinition f24622d;
    private final ClickListenerPartDefinition f24623e;
    public final SecureContextHelper f24624f;

    private static SearchResultsNewsContextAttributionPartDefinition m28040b(InjectorLike injectorLike) {
        return new SearchResultsNewsContextAttributionPartDefinition(TextPartDefinition.a(injectorLike), BackgroundPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    public final Object m28042a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final HasContext hasContext = (HasContext) anyEnvironment;
        final Uri parse = Uri.parse((String) obj);
        subParts.a(this.f24623e, new OnClickListener(this) {
            final /* synthetic */ SearchResultsNewsContextAttributionPartDefinition f24616c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -2044814948);
                this.f24616c.f24624f.b(new Intent("android.intent.action.VIEW").setData(parse), hasContext.getContext());
                Logger.a(2, EntryType.UI_INPUT_END, -372665980, a);
            }
        });
        Object host = parse.getHost();
        TextPartDefinition textPartDefinition = this.f24621c;
        if (host.startsWith("www.")) {
            host = host.substring(4);
        }
        subParts.a(textPartDefinition, host);
        subParts.a(this.f24622d, new StylingData(null, f24618b, Position.BOTTOM));
        return null;
    }

    static {
        Builder a = Builder.a();
        a.b = -4.0f;
        a = a;
        a.c = 0.0f;
        f24618b = a.i();
    }

    @Inject
    public SearchResultsNewsContextAttributionPartDefinition(TextPartDefinition textPartDefinition, BackgroundPartDefinition backgroundPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, SecureContextHelper secureContextHelper) {
        this.f24621c = textPartDefinition;
        this.f24622d = backgroundPartDefinition;
        this.f24623e = clickListenerPartDefinition;
        this.f24624f = secureContextHelper;
    }

    public static SearchResultsNewsContextAttributionPartDefinition m28039a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsNewsContextAttributionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24620h) {
                SearchResultsNewsContextAttributionPartDefinition searchResultsNewsContextAttributionPartDefinition;
                if (a2 != null) {
                    searchResultsNewsContextAttributionPartDefinition = (SearchResultsNewsContextAttributionPartDefinition) a2.a(f24620h);
                } else {
                    searchResultsNewsContextAttributionPartDefinition = f24619g;
                }
                if (searchResultsNewsContextAttributionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28040b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24620h, b3);
                        } else {
                            f24619g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsNewsContextAttributionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m28041a() {
        return f24617a;
    }

    public final boolean m28043a(Object obj) {
        return true;
    }
}
