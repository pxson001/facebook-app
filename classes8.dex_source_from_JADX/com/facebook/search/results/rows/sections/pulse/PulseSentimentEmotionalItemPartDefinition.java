package com.facebook.search.results.rows.sections.pulse;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.graphql.model.GraphQLImage;
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
import java.text.NumberFormat;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PRIMARY */
public class PulseSentimentEmotionalItemPartDefinition<E extends HasPositionInformation & HasContext> extends MultiRowSinglePartDefinition<PulseEmotionalIconData, PulseEmotionalIconState, E, EmotionalIconItemView> {
    public static final ViewType<EmotionalIconItemView> f24900a = ViewType.a(2130906515);
    public static final CallerContext f24901b = CallerContext.a(PulseSentimentEmotionalItemPartDefinition.class, "keyword_search");
    private static PulseSentimentEmotionalItemPartDefinition f24902d;
    private static final Object f24903e = new Object();
    public final GlyphColorizer f24904c;

    /* compiled from: PRIMARY */
    public class PulseEmotionalIconData {
        public final String f24892a;
        public final int f24893b;
        public final GraphQLImage f24894c;
        public final Integer f24895d;

        public PulseEmotionalIconData(String str, int i, GraphQLImage graphQLImage) {
            this.f24892a = str;
            this.f24893b = i;
            this.f24894c = graphQLImage;
            this.f24895d = null;
        }

        public PulseEmotionalIconData(int i) {
            this.f24892a = null;
            this.f24893b = i;
            this.f24895d = Integer.valueOf(2130837668);
            this.f24894c = null;
        }
    }

    /* compiled from: PRIMARY */
    public class PulseEmotionalIconState {
        public final String f24896a;
        public final String f24897b;
        public final Drawable f24898c;
        public final Uri f24899d;

        public PulseEmotionalIconState(String str, String str2, Drawable drawable) {
            this.f24896a = str;
            this.f24897b = str2;
            this.f24898c = drawable;
            this.f24899d = null;
        }

        public PulseEmotionalIconState(String str, String str2, Uri uri) {
            this.f24896a = str;
            this.f24897b = str2;
            this.f24898c = null;
            this.f24899d = uri;
        }
    }

    private static PulseSentimentEmotionalItemPartDefinition m28260b(InjectorLike injectorLike) {
        return new PulseSentimentEmotionalItemPartDefinition(GlyphColorizer.a(injectorLike));
    }

    public final Object m28262a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        PulseEmotionalIconState pulseEmotionalIconState;
        PulseEmotionalIconData pulseEmotionalIconData = (PulseEmotionalIconData) obj;
        Context context = ((HasContext) ((HasPositionInformation) anyEnvironment)).getContext();
        if (pulseEmotionalIconData.f24892a == null && pulseEmotionalIconData.f24894c == null) {
            pulseEmotionalIconState = new PulseEmotionalIconState(NumberFormat.getNumberInstance().format((long) pulseEmotionalIconData.f24893b), context.getString(2131239017), this.f24904c.a(pulseEmotionalIconData.f24895d.intValue(), -10972929));
        } else {
            pulseEmotionalIconState = new PulseEmotionalIconState(StringUtil.c(pulseEmotionalIconData.f24892a), context.getString(2131239018, new Object[]{NumberFormat.getNumberInstance().format((long) pulseEmotionalIconData.f24893b)}), pulseEmotionalIconData.f24894c != null ? ImageUtil.a(pulseEmotionalIconData.f24894c) : null);
        }
        return pulseEmotionalIconState;
    }

    public final /* bridge */ /* synthetic */ void m28263a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1500279461);
        PulseEmotionalIconState pulseEmotionalIconState = (PulseEmotionalIconState) obj2;
        EmotionalIconItemView emotionalIconItemView = (EmotionalIconItemView) view;
        if (pulseEmotionalIconState != null) {
            if (pulseEmotionalIconState.f24898c != null) {
                emotionalIconItemView.setEmotionalDrawable(pulseEmotionalIconState.f24898c);
            }
            if (pulseEmotionalIconState.f24899d != null) {
                emotionalIconItemView.m28129a(pulseEmotionalIconState.f24899d, f24901b);
            }
            emotionalIconItemView.setEmotionName(pulseEmotionalIconState.f24896a);
            emotionalIconItemView.setEmotionCount(pulseEmotionalIconState.f24897b);
        }
        Logger.a(8, EntryType.MARK_POP, 249494270, a);
    }

    public static PulseSentimentEmotionalItemPartDefinition m28259a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PulseSentimentEmotionalItemPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24903e) {
                PulseSentimentEmotionalItemPartDefinition pulseSentimentEmotionalItemPartDefinition;
                if (a2 != null) {
                    pulseSentimentEmotionalItemPartDefinition = (PulseSentimentEmotionalItemPartDefinition) a2.a(f24903e);
                } else {
                    pulseSentimentEmotionalItemPartDefinition = f24902d;
                }
                if (pulseSentimentEmotionalItemPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28260b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24903e, b3);
                        } else {
                            f24902d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pulseSentimentEmotionalItemPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PulseSentimentEmotionalItemPartDefinition(GlyphColorizer glyphColorizer) {
        this.f24904c = glyphColorizer;
    }

    public final ViewType<EmotionalIconItemView> m28261a() {
        return f24900a;
    }

    public final boolean m28264a(Object obj) {
        return true;
    }
}
