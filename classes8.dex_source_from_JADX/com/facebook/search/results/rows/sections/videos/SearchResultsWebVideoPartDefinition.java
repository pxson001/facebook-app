package com.facebook.search.results.rows.sections.videos;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.numbers.NumberTruncationUtil;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.graphql.enums.GraphQLObjectType;
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
import com.facebook.multirow.parts.FbDraweePartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition.Props.Builder;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.results.environment.HasSearchResultPosition;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.search.results.protocol.SearchResultsEdgeUtil;
import com.facebook.search.results.protocol.video.SearchResultsWebVideoInterfaces.SearchResultsWebVideo;
import com.facebook.search.results.rows.SearchBackgroundPartDefinition;
import com.facebook.search.results.util.SearchResultsFormatUtil;
import java.util.Locale;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PLACEHOLDER_SRC */
public class SearchResultsWebVideoPartDefinition<E extends HasPositionInformation & HasSearchResultsContext & HasSearchResultPosition & HasContext & HasPrefetcher & HasRowKey> extends MultiRowSinglePartDefinition<SearchResultsProps<SearchResultsWebVideo>, Void, E, ImageBlockLayout> {
    public static final ViewType<ImageBlockLayout> f25258a = ViewType.a(2130907126);
    private static final CallerContext f25259b = CallerContext.a(SearchResultsWebVideoPartDefinition.class, "graph_search_results_page");
    public static final String f25260c = new GraphQLObjectType(514783620).toString().toLowerCase(Locale.US);
    private static SearchResultsWebVideoPartDefinition f25261m;
    private static final Object f25262n = new Object();
    private final SearchBackgroundPartDefinition<E> f25263d;
    private final FbDraweePartDefinition<E> f25264e;
    private final TextPartDefinition f25265f;
    private final NumberTruncationUtil f25266g;
    public final SecureContextHelper f25267h;
    private final TimeFormatUtil f25268i;
    public final ClickListenerPartDefinition f25269j;
    private final GlyphColorizer f25270k;
    public final SearchResultsLogger f25271l;

    private static SearchResultsWebVideoPartDefinition m28510b(InjectorLike injectorLike) {
        return new SearchResultsWebVideoPartDefinition(SearchBackgroundPartDefinition.m27225a(injectorLike), FbDraweePartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), NumberTruncationUtil.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (TimeFormatUtil) DefaultTimeFormatUtil.a(injectorLike), GlyphColorizer.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), SearchResultsLogger.m25460a(injectorLike));
    }

    public final Object m28514a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final SearchResultsProps searchResultsProps = (SearchResultsProps) obj;
        final HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        m28509a(subParts, (SearchResultsWebVideo) searchResultsProps.f23388a, hasPositionInformation);
        subParts.a(2131558927, this.f25265f, ((SearchResultsWebVideo) searchResultsProps.f23388a).at().a());
        m28511b(subParts, (SearchResultsWebVideo) searchResultsProps.f23388a, hasPositionInformation);
        m28512c(subParts, (SearchResultsWebVideo) searchResultsProps.f23388a, hasPositionInformation);
        subParts.a(this.f25269j, new OnClickListener(this) {
            final /* synthetic */ SearchResultsWebVideoPartDefinition f25257c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 2061386820);
                this.f25257c.f25271l.m25482a(((HasSearchResultsContext) hasPositionInformation).mo1248s(), searchResultsProps.m27106d(), (String) searchResultsProps.f23391d.orNull(), ((HasSearchResultPosition) hasPositionInformation).mo1246a(searchResultsProps), searchResultsProps.f23389b, SearchResultsEdgeUtil.m9804f(searchResultsProps.f23390c), SearchResultsWebVideoPartDefinition.f25260c, ((SearchResultsWebVideo) searchResultsProps.f23388a).mo572C());
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(((SearchResultsWebVideo) searchResultsProps.f23388a).mo593v()));
                this.f25257c.f25267h.b(intent, ((HasContext) hasPositionInformation).getContext());
                Logger.a(2, EntryType.UI_INPUT_END, 1264269183, a);
            }
        });
        subParts.a(this.f25263d, new StylingData(null, SearchResultsVideoPartDefinition.f25208b, SearchBackgroundPartDefinition.m27224a(searchResultsProps, hasPositionInformation)));
        return null;
    }

    public static SearchResultsWebVideoPartDefinition m28508a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsWebVideoPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25262n) {
                SearchResultsWebVideoPartDefinition searchResultsWebVideoPartDefinition;
                if (a2 != null) {
                    searchResultsWebVideoPartDefinition = (SearchResultsWebVideoPartDefinition) a2.a(f25262n);
                } else {
                    searchResultsWebVideoPartDefinition = f25261m;
                }
                if (searchResultsWebVideoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28510b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25262n, b3);
                        } else {
                            f25261m = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsWebVideoPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SearchResultsWebVideoPartDefinition(SearchBackgroundPartDefinition searchBackgroundPartDefinition, FbDraweePartDefinition fbDraweePartDefinition, TextPartDefinition textPartDefinition, NumberTruncationUtil numberTruncationUtil, SecureContextHelper secureContextHelper, TimeFormatUtil timeFormatUtil, GlyphColorizer glyphColorizer, ClickListenerPartDefinition clickListenerPartDefinition, SearchResultsLogger searchResultsLogger) {
        this.f25263d = searchBackgroundPartDefinition;
        this.f25264e = fbDraweePartDefinition;
        this.f25265f = textPartDefinition;
        this.f25266g = numberTruncationUtil;
        this.f25267h = secureContextHelper;
        this.f25268i = timeFormatUtil;
        this.f25270k = glyphColorizer;
        this.f25269j = clickListenerPartDefinition;
        this.f25271l = searchResultsLogger;
    }

    public final ViewType<ImageBlockLayout> m28513a() {
        return f25258a;
    }

    public final boolean m28515a(Object obj) {
        return true;
    }

    private void m28509a(SubParts<E> subParts, SearchResultsWebVideo searchResultsWebVideo, E e) {
        Resources resources = ((HasContext) e).getContext().getResources();
        if (!(searchResultsWebVideo.mo577N() == null || searchResultsWebVideo.mo577N().mo567j() == null)) {
            FbDraweePartDefinition fbDraweePartDefinition = this.f25264e;
            Builder a = new Builder().a(searchResultsWebVideo.mo577N().mo567j().b());
            a.c = f25259b;
            a = a.a(resources.getDimensionPixelSize(2131432641), resources.getDimensionPixelSize(2131432642));
            a.h = ScaleType.h;
            subParts.a(2131567481, fbDraweePartDefinition, a.a());
        }
        String string = resources.getString(2131239059, new Object[]{SearchResultsFormatUtil.m28568a((long) searchResultsWebVideo.av().mo570b())});
        Drawable a2 = this.f25270k.a(2130839952, -1);
        Spannable spannableString = new SpannableString("  " + string);
        int dimensionPixelSize = resources.getDimensionPixelSize(2131427400);
        a2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        spannableString.setSpan(new ImageSpan(a2, 1), 0, 1, 18);
        subParts.a(2131567482, this.f25265f, spannableString);
    }

    private void m28511b(SubParts<E> subParts, SearchResultsWebVideo searchResultsWebVideo, E e) {
        String str;
        Resources resources = ((HasContext) e).getContext().getResources();
        Object[] objArr = new Object[2];
        objArr[0] = this.f25268i.a(TimeFormatStyle.SHORT_DATE_STYLE, searchResultsWebVideo.mo592q() * 1000);
        if (searchResultsWebVideo.al() == null || searchResultsWebVideo.al().a() == null) {
            str = "";
        } else if (!searchResultsWebVideo.al().a().startsWith("www.") || searchResultsWebVideo.al().a().length() <= 4) {
            str = searchResultsWebVideo.al().a();
        } else {
            str = searchResultsWebVideo.al().a().substring(4);
        }
        objArr[1] = str;
        subParts.a(2131558926, this.f25265f, resources.getString(2131239057, objArr));
    }

    private void m28512c(SubParts<E> subParts, SearchResultsWebVideo searchResultsWebVideo, E e) {
        Resources resources = ((HasContext) e).getContext().getResources();
        String toUpperCase = this.f25266g.a(searchResultsWebVideo.mo588d().mo564a(), 0).toUpperCase(Locale.US);
        subParts.a(2131567483, this.f25265f, resources.getQuantityString(2131689719, searchResultsWebVideo.mo588d().mo564a(), new Object[]{toUpperCase}));
    }
}
