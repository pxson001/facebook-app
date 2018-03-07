package com.facebook.richdocument.ham;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.richdocument.model.block.Annotation.AnnotationType;
import com.facebook.richdocument.view.widget.AnnotationView;
import com.facebook.richdocument.view.widget.TextAnnotationView;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.inject.Inject;

@ContextScoped
/* compiled from: placeholder-src */
public class RichDocumentPaddingCalculator {
    public static final int f5324a = 2131558729;
    public static final int f5325b = 2131558648;
    public static final int f5326c = 2131558649;
    public static final int f5327d = 2131558650;
    public static final int f5328e = 2131558728;
    public static final int f5329f = 2131558651;
    public static final int f5330g = 2131558652;
    private static RichDocumentPaddingCalculator f5331k;
    private static final Object f5332l = new Object();
    private final int f5333h;
    public final HamDimensions f5334i;
    public Map<HamContentType, PaddingRule> f5335j = new C07061();

    /* compiled from: placeholder-src */
    public class C07061 extends HashMap<HamContentType, PaddingRule> {

        /* compiled from: placeholder-src */
        class C06971 extends HashMap<HamContentType, Integer> {
            C06971() {
                put(HamContentType.TEXT_KICKER, Integer.valueOf(RichDocumentPaddingCalculator.f5326c));
            }
        }

        /* compiled from: placeholder-src */
        class C06982 extends HashMap<HamContentType, Integer> {
            C06982() {
                put(HamContentType.TEXT_SUBTITLE, Integer.valueOf(RichDocumentPaddingCalculator.f5326c));
            }
        }

        /* compiled from: placeholder-src */
        class C06993 extends HashMap<HamContentType, Integer> {
            C06993() {
                put(HamContentType.TEXT_PULL_QUOTE_ATTRIBUTION, Integer.valueOf(RichDocumentPaddingCalculator.f5326c));
            }
        }

        /* compiled from: placeholder-src */
        class C07004 extends HashMap<HamContentType, Integer> {
            C07004() {
                put(HamContentType.TEXT_CAPTION_CREDIT, Integer.valueOf(RichDocumentPaddingCalculator.f5324a));
                put(HamContentType.TEXT_END_CREDITS, Integer.valueOf(RichDocumentPaddingCalculator.f5324a));
                put(HamContentType.TEXT_END_CREDITS_BAR, Integer.valueOf(RichDocumentPaddingCalculator.f5324a));
            }
        }

        /* compiled from: placeholder-src */
        class C07015 extends HashMap<HamContentType, Integer> {
            C07015() {
                put(HamContentType.TEXT_CAPTION_CREDIT, Integer.valueOf(RichDocumentPaddingCalculator.f5324a));
                put(HamContentType.TEXT_END_CREDITS, Integer.valueOf(RichDocumentPaddingCalculator.f5324a));
                put(HamContentType.TEXT_END_CREDITS_BAR, Integer.valueOf(RichDocumentPaddingCalculator.f5324a));
            }
        }

        /* compiled from: placeholder-src */
        class C07026 extends HashMap<HamContentType, Integer> {
            C07026() {
                put(HamContentType.MEDIA_WITHOUT_ABOVE_OR_BELOW_CAPTION, Integer.valueOf(0));
                put(HamContentType.MEDIA_WITH_BELOW_CAPTION, Integer.valueOf(0));
            }
        }

        /* compiled from: placeholder-src */
        class C07037 extends HashMap<HamContentType, Integer> {
            C07037() {
                put(HamContentType.MEDIA_WITHOUT_ABOVE_OR_BELOW_CAPTION, Integer.valueOf(0));
                put(HamContentType.MEDIA_WITH_ABOVE_CAPTION, Integer.valueOf(0));
            }
        }

        /* compiled from: placeholder-src */
        class C07048 extends HashMap<HamContentType, Integer> {
            C07048() {
                put(HamContentType.MEDIA_WITHOUT_ABOVE_OR_BELOW_CAPTION, Integer.valueOf(0));
                put(HamContentType.MEDIA_WITH_ABOVE_CAPTION, Integer.valueOf(0));
            }
        }

        /* compiled from: placeholder-src */
        class C07059 extends HashMap<HamContentType, Integer> {
            C07059() {
                put(HamContentType.MEDIA_WITHOUT_ABOVE_OR_BELOW_CAPTION, Integer.valueOf(0));
                put(HamContentType.MEDIA_WITH_BELOW_CAPTION, Integer.valueOf(0));
            }
        }

        public C07061() {
            put(HamContentType.TEXT_KICKER, new SimplePaddingRule(RichDocumentPaddingCalculator.this, RichDocumentPaddingCalculator.f5327d, RichDocumentPaddingCalculator.f5326c));
            put(HamContentType.TEXT_TITLE, new ExceptionPaddingRule(RichDocumentPaddingCalculator.this, RichDocumentPaddingCalculator.f5327d, RichDocumentPaddingCalculator.f5327d, new C06971(), new C06982()));
            put(HamContentType.TEXT_SUBTITLE, new SimplePaddingRule(RichDocumentPaddingCalculator.this, RichDocumentPaddingCalculator.f5326c, RichDocumentPaddingCalculator.f5327d));
            put(HamContentType.TEXT_BYLINE, new SimplePaddingRule(RichDocumentPaddingCalculator.this, RichDocumentPaddingCalculator.f5327d, RichDocumentPaddingCalculator.f5329f));
            put(HamContentType.TEXT_AUTHOR_PIC, new SimplePaddingRule(RichDocumentPaddingCalculator.this, RichDocumentPaddingCalculator.f5327d, RichDocumentPaddingCalculator.f5329f));
            put(HamContentType.TEXT_BODY, new SimplePaddingRule(RichDocumentPaddingCalculator.this, RichDocumentPaddingCalculator.f5327d, RichDocumentPaddingCalculator.f5327d));
            put(HamContentType.TEXT_H1, new SimplePaddingRule(RichDocumentPaddingCalculator.this, RichDocumentPaddingCalculator.f5330g, RichDocumentPaddingCalculator.f5327d));
            put(HamContentType.TEXT_H2, new SimplePaddingRule(RichDocumentPaddingCalculator.this, RichDocumentPaddingCalculator.f5330g, RichDocumentPaddingCalculator.f5327d));
            put(HamContentType.TEXT_BLOCK_QUOTE, new SimplePaddingRule(RichDocumentPaddingCalculator.this, RichDocumentPaddingCalculator.f5330g, RichDocumentPaddingCalculator.f5330g));
            put(HamContentType.TEXT_PULL_QUOTE, new ExceptionPaddingRule(RichDocumentPaddingCalculator.this, RichDocumentPaddingCalculator.f5330g, RichDocumentPaddingCalculator.f5330g, null, new C06993()));
            put(HamContentType.TEXT_PULL_QUOTE_ATTRIBUTION, new SimplePaddingRule(RichDocumentPaddingCalculator.this, RichDocumentPaddingCalculator.f5326c, RichDocumentPaddingCalculator.f5330g));
            put(HamContentType.TEXT_CODE, new SimplePaddingRule(RichDocumentPaddingCalculator.this, 0, 0));
            ExceptionPaddingRule exceptionPaddingRule = new ExceptionPaddingRule(RichDocumentPaddingCalculator.this, RichDocumentPaddingCalculator.f5326c, RichDocumentPaddingCalculator.f5326c, null, new C07004());
            put(HamContentType.TEXT_CAPTION_SMALL, exceptionPaddingRule);
            put(HamContentType.TEXT_CAPTION_MEDIUM, exceptionPaddingRule);
            exceptionPaddingRule = new ExceptionPaddingRule(RichDocumentPaddingCalculator.this, RichDocumentPaddingCalculator.f5327d, RichDocumentPaddingCalculator.f5326c, null, new C07015());
            put(HamContentType.TEXT_CAPTION_LARGE, exceptionPaddingRule);
            put(HamContentType.TEXT_CAPTION_XLARGE, exceptionPaddingRule);
            put(HamContentType.TEXT_CAPTION_CREDIT, new SimplePaddingRule(RichDocumentPaddingCalculator.this, RichDocumentPaddingCalculator.f5324a, RichDocumentPaddingCalculator.f5326c));
            put(HamContentType.TEXT_ELEMENT_UFI, new SimplePaddingRule(RichDocumentPaddingCalculator.this, RichDocumentPaddingCalculator.f5326c, RichDocumentPaddingCalculator.f5329f));
            put(HamContentType.TEXT_BULLETED_LIST, new SimplePaddingRule(RichDocumentPaddingCalculator.this, RichDocumentPaddingCalculator.f5326c, RichDocumentPaddingCalculator.f5326c));
            put(HamContentType.TEXT_NUMBERED_LIST, new SimplePaddingRule(RichDocumentPaddingCalculator.this, RichDocumentPaddingCalculator.f5326c, RichDocumentPaddingCalculator.f5326c));
            put(HamContentType.TEXT_END_CREDITS_BAR, new SimplePaddingRule(RichDocumentPaddingCalculator.this, RichDocumentPaddingCalculator.f5327d, RichDocumentPaddingCalculator.f5326c));
            put(HamContentType.TEXT_END_CREDITS, new SimplePaddingRule(RichDocumentPaddingCalculator.this, RichDocumentPaddingCalculator.f5326c, RichDocumentPaddingCalculator.f5327d));
            put(HamContentType.MEDIA_WITH_ABOVE_AND_BELOW_CAPTION, new SimplePaddingRule(RichDocumentPaddingCalculator.this, RichDocumentPaddingCalculator.f5329f, RichDocumentPaddingCalculator.f5326c));
            put(HamContentType.MEDIA_WITH_ABOVE_CAPTION, new ExceptionPaddingRule(RichDocumentPaddingCalculator.this, RichDocumentPaddingCalculator.f5329f, RichDocumentPaddingCalculator.f5329f, null, new C07026()));
            put(HamContentType.MEDIA_WITH_BELOW_CAPTION, new ExceptionPaddingRule(RichDocumentPaddingCalculator.this, RichDocumentPaddingCalculator.f5329f, RichDocumentPaddingCalculator.f5329f, new C07037(), null));
            put(HamContentType.MEDIA_WITHOUT_ABOVE_OR_BELOW_CAPTION, new ExceptionPaddingRule(RichDocumentPaddingCalculator.this, RichDocumentPaddingCalculator.f5329f, RichDocumentPaddingCalculator.f5329f, new C07048(), new C07059()));
            put(HamContentType.AD_WITH_CAPTION, new AdPaddingRule(RichDocumentPaddingCalculator.this, true));
            put(HamContentType.AD_WITHOUT_CAPTION, new AdPaddingRule(RichDocumentPaddingCalculator.this, false));
            put(HamContentType.MAP_WITH_CAPTION, new SimplePaddingRule(RichDocumentPaddingCalculator.this, RichDocumentPaddingCalculator.f5329f, RichDocumentPaddingCalculator.f5326c));
            put(HamContentType.MAP_WITHOUT_CAPTION, new SimplePaddingRule(RichDocumentPaddingCalculator.this, RichDocumentPaddingCalculator.f5329f, RichDocumentPaddingCalculator.f5329f));
            put(HamContentType.HTML_WITH_CAPTION, new SimplePaddingRule(RichDocumentPaddingCalculator.this, RichDocumentPaddingCalculator.f5329f, RichDocumentPaddingCalculator.f5326c));
            put(HamContentType.HTML_WITHOUT_CAPTION, new SimplePaddingRule(RichDocumentPaddingCalculator.this, RichDocumentPaddingCalculator.f5329f, RichDocumentPaddingCalculator.f5329f));
            put(HamContentType.SOCIAL_EMBED_WITH_CAPTION, new SimplePaddingRule(RichDocumentPaddingCalculator.this, RichDocumentPaddingCalculator.f5329f, RichDocumentPaddingCalculator.f5326c));
            put(HamContentType.SOCIAL_EMBED_WITHOUT_CAPTION, new SimplePaddingRule(RichDocumentPaddingCalculator.this, RichDocumentPaddingCalculator.f5329f, RichDocumentPaddingCalculator.f5329f));
            put(HamContentType.RELATED_ARTICLE_CELL, new SimplePaddingRule(RichDocumentPaddingCalculator.this, RichDocumentPaddingCalculator.f5325b, RichDocumentPaddingCalculator.f5326c));
            put(HamContentType.AUTHORS_CONTRIBUTORS_HEADER, new SimplePaddingRule(RichDocumentPaddingCalculator.this, RichDocumentPaddingCalculator.f5330g, RichDocumentPaddingCalculator.f5324a));
            put(HamContentType.RELATED_ARTICLES_HEADER, new SimplePaddingRule(RichDocumentPaddingCalculator.this, 0, RichDocumentPaddingCalculator.f5324a));
            put(HamContentType.INLINE_RELATED_ARTICLES_HEADER, new SimplePaddingRule(RichDocumentPaddingCalculator.this, RichDocumentPaddingCalculator.f5329f, RichDocumentPaddingCalculator.f5324a));
            put(HamContentType.INLINE_RELATED_ARTICLES_FOOTER, new SimplePaddingRule(RichDocumentPaddingCalculator.this, RichDocumentPaddingCalculator.f5326c, RichDocumentPaddingCalculator.f5329f));
            put(HamContentType.SHARE_BUTTON, new SimplePaddingRule(RichDocumentPaddingCalculator.this, RichDocumentPaddingCalculator.f5328e, RichDocumentPaddingCalculator.f5328e));
            put(HamContentType.VIDEO_SEEK_BAR, new SimplePaddingRule(RichDocumentPaddingCalculator.this, RichDocumentPaddingCalculator.f5325b, RichDocumentPaddingCalculator.f5326c));
        }
    }

    /* compiled from: placeholder-src */
    interface PaddingRule {
        int mo266a(HamContentType hamContentType);

        int mo267b(HamContentType hamContentType);
    }

    /* compiled from: placeholder-src */
    class AdPaddingRule implements PaddingRule {
        final /* synthetic */ RichDocumentPaddingCalculator f5315a;
        private final int f5316b;
        private final int f5317c;

        public AdPaddingRule(RichDocumentPaddingCalculator richDocumentPaddingCalculator, boolean z) {
            this.f5315a = richDocumentPaddingCalculator;
            this.f5316b = richDocumentPaddingCalculator.f5334i.m5276b(RichDocumentPaddingCalculator.f5325b) + richDocumentPaddingCalculator.f5334i.m5276b(RichDocumentPaddingCalculator.f5329f);
            if (z) {
                this.f5317c = richDocumentPaddingCalculator.f5334i.m5276b(RichDocumentPaddingCalculator.f5326c);
            } else {
                this.f5317c = richDocumentPaddingCalculator.f5334i.m5276b(RichDocumentPaddingCalculator.f5330g);
            }
        }

        public final int mo266a(HamContentType hamContentType) {
            return this.f5317c;
        }

        public final int mo267b(HamContentType hamContentType) {
            return this.f5316b;
        }
    }

    /* compiled from: placeholder-src */
    class SimplePaddingRule implements PaddingRule {
        private final int f5318a;
        final /* synthetic */ RichDocumentPaddingCalculator f5319b;
        private final int f5320c;

        public SimplePaddingRule(RichDocumentPaddingCalculator richDocumentPaddingCalculator, int i, int i2) {
            int b;
            int i3 = 0;
            this.f5319b = richDocumentPaddingCalculator;
            if (i != 0) {
                b = richDocumentPaddingCalculator.f5334i.m5276b(i);
            } else {
                b = 0;
            }
            this.f5318a = b;
            if (i2 != 0) {
                i3 = richDocumentPaddingCalculator.f5334i.m5276b(i2);
            }
            this.f5320c = i3;
        }

        public int mo266a(HamContentType hamContentType) {
            return this.f5320c;
        }

        public int mo267b(HamContentType hamContentType) {
            return this.f5318a;
        }
    }

    /* compiled from: placeholder-src */
    class ExceptionPaddingRule extends SimplePaddingRule {
        final /* synthetic */ RichDocumentPaddingCalculator f5321a;
        private final Map<HamContentType, Integer> f5322c = new HashMap();
        private final Map<HamContentType, Integer> f5323d = new HashMap();

        public ExceptionPaddingRule(RichDocumentPaddingCalculator richDocumentPaddingCalculator, int i, int i2, Map<HamContentType, Integer> map, Map<HamContentType, Integer> map2) {
            this.f5321a = richDocumentPaddingCalculator;
            super(richDocumentPaddingCalculator, i, i2);
            m5290a(map, this.f5322c);
            m5290a(map2, this.f5323d);
        }

        private void m5290a(Map<HamContentType, Integer> map, Map<HamContentType, Integer> map2) {
            if (map != null && map2 != null) {
                for (Entry entry : map.entrySet()) {
                    int b;
                    if (((Integer) entry.getValue()).intValue() != 0) {
                        b = this.f5321a.f5334i.m5276b(((Integer) entry.getValue()).intValue());
                    } else {
                        b = 0;
                    }
                    map2.put(entry.getKey(), Integer.valueOf(b));
                }
            }
        }

        public final int mo266a(HamContentType hamContentType) {
            if (this.f5323d.containsKey(hamContentType)) {
                return ((Integer) this.f5323d.get(hamContentType)).intValue();
            }
            return super.mo266a(hamContentType);
        }

        public final int mo267b(HamContentType hamContentType) {
            if (this.f5322c.containsKey(hamContentType)) {
                return ((Integer) this.f5322c.get(hamContentType)).intValue();
            }
            return super.mo267b(hamContentType);
        }
    }

    private static RichDocumentPaddingCalculator m5295b(InjectorLike injectorLike) {
        return new RichDocumentPaddingCalculator(HamDimensions.m5268a(injectorLike));
    }

    @Inject
    public RichDocumentPaddingCalculator(HamDimensions hamDimensions) {
        this.f5334i = hamDimensions;
        this.f5333h = hamDimensions.m5276b(f5327d);
    }

    public static RichDocumentPaddingCalculator m5294a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RichDocumentPaddingCalculator b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5332l) {
                RichDocumentPaddingCalculator richDocumentPaddingCalculator;
                if (a2 != null) {
                    richDocumentPaddingCalculator = (RichDocumentPaddingCalculator) a2.a(f5332l);
                } else {
                    richDocumentPaddingCalculator = f5331k;
                }
                if (richDocumentPaddingCalculator == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5295b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5332l, b3);
                        } else {
                            f5331k = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = richDocumentPaddingCalculator;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final int m5296a(HamContentType hamContentType, View view, HamContentType hamContentType2, View view2) {
        int a;
        int i = 0;
        if (this.f5335j.containsKey(hamContentType)) {
            a = ((PaddingRule) this.f5335j.get(hamContentType)).mo266a(hamContentType2);
        } else if (hamContentType == HamContentType.NONE) {
            a = 0;
        } else {
            a = this.f5333h;
        }
        if (this.f5335j.containsKey(hamContentType2)) {
            i = ((PaddingRule) this.f5335j.get(hamContentType2)).mo267b(hamContentType);
        } else if (hamContentType2 != HamContentType.NONE) {
            i = this.f5333h;
        }
        if (hamContentType2 == HamContentType.VIDEO_SEEK_BAR) {
            return m5293a(Math.min(a, i), view);
        }
        return m5293a(Math.max(a, i), view);
    }

    private static int m5293a(int i, View view) {
        int i2 = 0;
        if (view instanceof ExtraPaddingAware) {
            i2 = ((ExtraPaddingAware) view).getExtraPaddingBottom() + 0;
        }
        return i - i2;
    }

    public final int m5297a(AnnotationView annotationView, AnnotationView annotationView2) {
        View view = null;
        HamContentType from = HamContentType.from(annotationView == null ? null : annotationView.getAnnotation());
        HamContentType from2 = HamContentType.from(annotationView2 == null ? null : annotationView2.getAnnotation());
        if (from == from2 && annotationView.getAnnotation() != null && annotationView2.getAnnotation() != null && annotationView.getAnnotation().f5608a == AnnotationType.TITLE && annotationView2.getAnnotation().f5608a == AnnotationType.SUBTITLE && (annotationView instanceof TextAnnotationView) && (annotationView2 instanceof TextAnnotationView)) {
            TextAnnotationView textAnnotationView = (TextAnnotationView) annotationView;
            TextAnnotationView textAnnotationView2 = (TextAnnotationView) annotationView2;
            if (textAnnotationView.f7092a.getMeasuredWidth() == 0 || textAnnotationView2.f7092a.getMeasuredWidth() == 0) {
                textAnnotationView.f7092a.measure(0, 0);
                textAnnotationView2.f7092a.measure(0, 0);
            }
            return textAnnotationView.f7092a.f7395f + textAnnotationView2.f7092a.f7396g;
        }
        View b = annotationView != null ? annotationView.mo438b() : null;
        if (annotationView2 != null) {
            view = annotationView2.mo438b();
        }
        return m5296a(from, b, from2, view);
    }
}
