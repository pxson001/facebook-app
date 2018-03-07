package com.facebook.search.results.rows.sections.collection;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.graphql.model.GraphQLNode;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: REQUESTS_TAB_PYMK_QUERY_TAG */
public class SearchResultsExternalUrlContentViewSubtitlePartDefinition<E extends HasContext & HasPositionInformation> extends BaseSinglePartDefinition<GraphQLNode, CharSequence, E, ContentView> {
    private static SearchResultsExternalUrlContentViewSubtitlePartDefinition f23747b;
    private static final Object f23748c = new Object();
    public final TimeFormatUtil f23749a;

    private static SearchResultsExternalUrlContentViewSubtitlePartDefinition m27393b(InjectorLike injectorLike) {
        return new SearchResultsExternalUrlContentViewSubtitlePartDefinition(DefaultTimeFormatUtil.a(injectorLike));
    }

    public final Object m27394a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return m27392a((GraphQLNode) obj, ((HasContext) anyEnvironment).getContext());
    }

    public final /* bridge */ /* synthetic */ void m27395a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1206535104);
        ((ContentView) view).setSubtitleText((CharSequence) obj2);
        Logger.a(8, EntryType.MARK_POP, 1825519784, a);
    }

    @Inject
    public SearchResultsExternalUrlContentViewSubtitlePartDefinition(DefaultTimeFormatUtil defaultTimeFormatUtil) {
        this.f23749a = defaultTimeFormatUtil;
    }

    private CharSequence m27392a(GraphQLNode graphQLNode, Context context) {
        String a;
        CharSequence spannableStringBuilder = new SpannableStringBuilder();
        CharSequence a2 = graphQLNode.hw() != null ? graphQLNode.hw().a() : null;
        if (a2 != null) {
            spannableStringBuilder.append(a2);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(context.getResources().getColor(2131361924)), 0, spannableStringBuilder.length(), 17);
        }
        long bw = graphQLNode.bw();
        if (bw != 0) {
            a = this.f23749a.a(TimeFormatStyle.STREAM_RELATIVE_STYLE, bw * 1000);
        } else {
            a = null;
        }
        String str = a;
        if (str != null) {
            if (a2 != null) {
                spannableStringBuilder.append(context.getString(2131233658));
            }
            spannableStringBuilder.append(str);
        }
        return spannableStringBuilder;
    }

    public static SearchResultsExternalUrlContentViewSubtitlePartDefinition m27391a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsExternalUrlContentViewSubtitlePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23748c) {
                SearchResultsExternalUrlContentViewSubtitlePartDefinition searchResultsExternalUrlContentViewSubtitlePartDefinition;
                if (a2 != null) {
                    searchResultsExternalUrlContentViewSubtitlePartDefinition = (SearchResultsExternalUrlContentViewSubtitlePartDefinition) a2.a(f23748c);
                } else {
                    searchResultsExternalUrlContentViewSubtitlePartDefinition = f23747b;
                }
                if (searchResultsExternalUrlContentViewSubtitlePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27393b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23748c, b3);
                        } else {
                            f23747b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsExternalUrlContentViewSubtitlePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
