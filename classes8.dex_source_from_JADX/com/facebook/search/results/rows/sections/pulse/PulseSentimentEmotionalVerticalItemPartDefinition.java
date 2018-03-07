package com.facebook.search.results.rows.sections.pulse;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.fbui.widget.contentview.ContentView.ThumbnailSize;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.ImageUtil;
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
import com.facebook.search.results.rows.sections.pulse.PulseSentimentEmotionalItemPartDefinition.PulseEmotionalIconData;
import java.text.NumberFormat;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PRICE_RATING */
public class PulseSentimentEmotionalVerticalItemPartDefinition<E extends HasContext & HasPositionInformation> extends MultiRowSinglePartDefinition<PulseEmotionalIconData, IconState, E, ContentView> {
    public static final ViewType<ContentView> f24908a = new C26231();
    private static final PaddingStyle f24909b;
    private static PulseSentimentEmotionalVerticalItemPartDefinition f24910e;
    private static final Object f24911f = new Object();
    private final GlyphColorizer f24912c;
    private final BackgroundPartDefinition f24913d;

    /* compiled from: PRICE_RATING */
    final class C26231 extends ViewType<ContentView> {
        C26231() {
        }

        public final View m28265a(Context context) {
            return new ContentView(context);
        }
    }

    /* compiled from: PRICE_RATING */
    public class IconState {
        public final Drawable f24905a;
        public final Uri f24906b;
        public final SpannableStringBuilder f24907c;

        public IconState(Drawable drawable, SpannableStringBuilder spannableStringBuilder) {
            this.f24907c = spannableStringBuilder;
            this.f24905a = drawable;
            this.f24906b = null;
        }

        public IconState(Uri uri, SpannableStringBuilder spannableStringBuilder) {
            this.f24905a = null;
            this.f24906b = uri;
            this.f24907c = spannableStringBuilder;
        }
    }

    private static PulseSentimentEmotionalVerticalItemPartDefinition m28269b(InjectorLike injectorLike) {
        return new PulseSentimentEmotionalVerticalItemPartDefinition(GlyphColorizer.a(injectorLike), BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m28271a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        PulseEmotionalIconData pulseEmotionalIconData = (PulseEmotionalIconData) obj;
        HasContext hasContext = (HasContext) anyEnvironment;
        subParts.a(this.f24913d, new StylingData(null, f24909b));
        return m28266a(pulseEmotionalIconData, hasContext.getContext());
    }

    public final /* bridge */ /* synthetic */ void m28272a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 332104870);
        IconState iconState = (IconState) obj2;
        ContentView contentView = (ContentView) view;
        if (iconState != null) {
            if (iconState.f24905a != null) {
                contentView.setThumbnailDrawable(iconState.f24905a);
            }
            if (iconState.f24906b != null) {
                contentView.setThumbnailUri(iconState.f24906b);
            }
            contentView.setThumbnailSize(ThumbnailSize.XSMALL);
            contentView.setTitleText(iconState.f24907c);
            contentView.setTitleTextAppearance(2131624392);
        }
        Logger.a(8, EntryType.MARK_POP, 1101707493, a);
    }

    static {
        Builder a = Builder.a();
        a.b = -2.0f;
        a = a;
        a.c = -2.0f;
        f24909b = a.i();
    }

    public static PulseSentimentEmotionalVerticalItemPartDefinition m28267a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PulseSentimentEmotionalVerticalItemPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24911f) {
                PulseSentimentEmotionalVerticalItemPartDefinition pulseSentimentEmotionalVerticalItemPartDefinition;
                if (a2 != null) {
                    pulseSentimentEmotionalVerticalItemPartDefinition = (PulseSentimentEmotionalVerticalItemPartDefinition) a2.a(f24911f);
                } else {
                    pulseSentimentEmotionalVerticalItemPartDefinition = f24910e;
                }
                if (pulseSentimentEmotionalVerticalItemPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28269b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24911f, b3);
                        } else {
                            f24910e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pulseSentimentEmotionalVerticalItemPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PulseSentimentEmotionalVerticalItemPartDefinition(GlyphColorizer glyphColorizer, BackgroundPartDefinition backgroundPartDefinition) {
        this.f24912c = glyphColorizer;
        this.f24913d = backgroundPartDefinition;
    }

    public final ViewType<ContentView> m28270a() {
        return f24908a;
    }

    public final boolean m28273a(Object obj) {
        return true;
    }

    private IconState m28266a(PulseEmotionalIconData pulseEmotionalIconData, Context context) {
        if (pulseEmotionalIconData.f24892a == null && pulseEmotionalIconData.f24894c == null) {
            Drawable a = this.f24912c.a(pulseEmotionalIconData.f24895d.intValue(), -10972929);
            String string = context.getString(2131239020, new Object[]{NumberFormat.getNumberInstance().format((long) pulseEmotionalIconData.f24893b)});
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
            m28268a(spannableStringBuilder, string, r4);
            return new IconState(a, spannableStringBuilder);
        }
        Uri a2 = pulseEmotionalIconData.f24894c != null ? ImageUtil.a(pulseEmotionalIconData.f24894c) : null;
        string = context.getString(2131239019, new Object[]{NumberFormat.getNumberInstance().format((long) pulseEmotionalIconData.f24893b), pulseEmotionalIconData.f24892a});
        spannableStringBuilder = new SpannableStringBuilder(string);
        m28268a(spannableStringBuilder, string, r4);
        m28268a(spannableStringBuilder, string, pulseEmotionalIconData.f24892a);
        return new IconState(a2, spannableStringBuilder);
    }

    public static void m28268a(SpannableStringBuilder spannableStringBuilder, String str, String str2) {
        if (!StringUtil.a(str2)) {
            StyleSpan styleSpan = new StyleSpan(1);
            int indexOf = str.indexOf(str2);
            if (indexOf != -1) {
                spannableStringBuilder.setSpan(styleSpan, indexOf, str2.length() + indexOf, 33);
            }
        }
    }
}
