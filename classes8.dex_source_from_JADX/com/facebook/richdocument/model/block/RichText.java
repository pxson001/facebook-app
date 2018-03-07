package com.facebook.richdocument.model.block;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLComposedEntityType;
import com.facebook.graphql.enums.GraphQLInlineStyle;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.instantshopping.model.block.text.InstantShoppingTextBlockWrapper;
import com.facebook.richdocument.RichDocumentInfo;
import com.facebook.richdocument.model.block.Annotation.AnnotationStyle;
import com.facebook.richdocument.model.block.Annotation.AnnotationType;
import com.facebook.richdocument.model.block.entity.BaseEntity;
import com.facebook.richdocument.model.block.entity.LinkEntity;
import com.facebook.richdocument.model.block.entity.MentionEntity;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentElementStyle;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentText;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentText.EntityRanges;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentText.InlineStyleRanges;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentElementStyleModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentStyleModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentStyleModel.FallbackArticleStyleModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.InlineStyleRangesModel;
import com.facebook.richdocument.view.widget.RichTextUtils;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: pinterest */
public final class RichText {
    public static final Map<RichDocumentTextType, Integer> f5640e = new C07171();
    public final CharSequence f5641a;
    public final ImmutableList<RichDocumentElementStyle> f5642b;
    public final ImmutableList<RichDocumentElementStyle> f5643c;
    public final ImmutableList<Integer> f5644d;

    /* compiled from: pinterest */
    final class C07171 extends HashMap<RichDocumentTextType, Integer> {
        C07171() {
            put(RichDocumentTextType.KICKER, Integer.valueOf(2131625995));
            put(RichDocumentTextType.TITLE, Integer.valueOf(2131625996));
            put(RichDocumentTextType.SUBTITLE, Integer.valueOf(2131625997));
            put(RichDocumentTextType.HEADER_ONE, Integer.valueOf(2131625998));
            put(RichDocumentTextType.HEADER_TWO, Integer.valueOf(2131625999));
            put(RichDocumentTextType.BODY, Integer.valueOf(2131625994));
            put(RichDocumentTextType.PULL_QUOTE, Integer.valueOf(2131626001));
            put(RichDocumentTextType.BLOCK_QUOTE, Integer.valueOf(2131626000));
            put(RichDocumentTextType.CODE, Integer.valueOf(2131626002));
            put(RichDocumentTextType.RELATED_ARTICLES, Integer.valueOf(2131626011));
            put(RichDocumentTextType.RELATED_ARTICLES_HEADER, Integer.valueOf(2131626019));
            put(RichDocumentTextType.INLINE_RELATED_ARTICLES_HEADER, Integer.valueOf(2131626019));
            put(RichDocumentTextType.BYLINE, Integer.valueOf(2131626003));
            put(RichDocumentTextType.CREDITS, Integer.valueOf(2131626009));
            put(RichDocumentTextType.AUTHORS_CONTRIBUTORS_HEADER, Integer.valueOf(2131626018));
            put(RichDocumentTextType.COPYRIGHT, Integer.valueOf(2131626009));
        }
    }

    /* compiled from: pinterest */
    /* synthetic */ class C07182 {
        static final /* synthetic */ int[] f5631c = new int[GraphQLComposedEntityType.values().length];
        static final /* synthetic */ int[] f5632d = new int[GraphQLInlineStyle.values().length];

        static {
            try {
                f5632d[GraphQLInlineStyle.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5632d[GraphQLInlineStyle.BOLD.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f5632d[GraphQLInlineStyle.ITALIC.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f5632d[GraphQLInlineStyle.UNDERLINE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f5632d[GraphQLInlineStyle.STRIKETHROUGH.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f5632d[GraphQLInlineStyle.CODE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f5631c[GraphQLComposedEntityType.LINK.ordinal()] = 1;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f5631c[GraphQLComposedEntityType.MENTION.ordinal()] = 2;
            } catch (NoSuchFieldError e8) {
            }
            f5630b = new int[RichDocumentTextType.values().length];
            try {
                f5630b[RichDocumentTextType.KICKER.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f5630b[RichDocumentTextType.TITLE.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f5630b[RichDocumentTextType.SUBTITLE.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f5630b[RichDocumentTextType.HEADER_ONE.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f5630b[RichDocumentTextType.HEADER_TWO.ordinal()] = 5;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f5630b[RichDocumentTextType.BODY.ordinal()] = 6;
            } catch (NoSuchFieldError e14) {
            }
            try {
                f5630b[RichDocumentTextType.PULL_QUOTE.ordinal()] = 7;
            } catch (NoSuchFieldError e15) {
            }
            try {
                f5630b[RichDocumentTextType.RELATED_ARTICLES.ordinal()] = 8;
            } catch (NoSuchFieldError e16) {
            }
            try {
                f5630b[RichDocumentTextType.CAPTION_TITLE.ordinal()] = 9;
            } catch (NoSuchFieldError e17) {
            }
            try {
                f5630b[RichDocumentTextType.CAPTION_SUBTITLE.ordinal()] = 10;
            } catch (NoSuchFieldError e18) {
            }
            try {
                f5630b[RichDocumentTextType.BYLINE.ordinal()] = 11;
            } catch (NoSuchFieldError e19) {
            }
            try {
                f5630b[RichDocumentTextType.CREDITS.ordinal()] = 12;
            } catch (NoSuchFieldError e20) {
            }
            try {
                f5630b[RichDocumentTextType.COPYRIGHT.ordinal()] = 13;
            } catch (NoSuchFieldError e21) {
            }
            f5629a = new int[AnnotationType.values().length];
            try {
                f5629a[AnnotationType.TITLE.ordinal()] = 1;
            } catch (NoSuchFieldError e22) {
            }
            try {
                f5629a[AnnotationType.SUBTITLE.ordinal()] = 2;
            } catch (NoSuchFieldError e23) {
            }
            try {
                f5629a[AnnotationType.COPYRIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError e24) {
            }
        }
    }

    /* compiled from: pinterest */
    public class RichTextBuilder implements InjectableComponentWithContext {
        protected final RichDocumentStyleModel f5633a;
        @Inject
        public RichDocumentInfo f5634b;
        private final Context f5635c;
        public CharSequence f5636d;
        private List<RichDocumentElementStyle> f5637e = new ArrayList();
        private List<RichDocumentElementStyle> f5638f = new ArrayList();
        private List<Integer> f5639g = new ArrayList();

        public static void m5438a(Object obj, Context context) {
            ((RichTextBuilder) obj).f5634b = RichDocumentInfo.m5102a(FbInjector.get(context));
        }

        public RichTextBuilder(Context context) {
            this.f5635c = context;
            Class cls = RichTextBuilder.class;
            m5438a((Object) this, getContext());
            this.f5633a = this.f5634b.f5119g;
        }

        public Context getContext() {
            return this.f5635c;
        }

        public final RichTextBuilder m5442a(InstantShoppingTextBlockWrapper instantShoppingTextBlockWrapper) {
            if (instantShoppingTextBlockWrapper != null) {
                m5439a(instantShoppingTextBlockWrapper.a.mo303d(), instantShoppingTextBlockWrapper.a.mo302c(), instantShoppingTextBlockWrapper.a.mo301b(), RichDocumentTextType.from(instantShoppingTextBlockWrapper.a.mo300a()));
            }
            return this;
        }

        public final RichTextBuilder m5445a(RichDocumentText richDocumentText) {
            if (richDocumentText != null) {
                m5439a(richDocumentText.mo303d(), richDocumentText.mo302c(), richDocumentText.mo301b(), RichDocumentTextType.from(richDocumentText.mo300a()));
            }
            return this;
        }

        private void m5439a(String str, ImmutableList<? extends InlineStyleRanges> immutableList, ImmutableList<? extends EntityRanges> immutableList2, RichDocumentTextType richDocumentTextType) {
            if (!StringUtil.a(str)) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
                m5440b(spannableStringBuilder, immutableList);
                m5433a(spannableStringBuilder, (List) immutableList2);
                this.f5636d = spannableStringBuilder;
            }
            m5444a(richDocumentTextType);
        }

        public final RichTextBuilder m5443a(@Nullable Annotation annotation) {
            if (annotation != null) {
                this.f5636d = annotation.f5609b;
                AnnotationStyle annotationStyle = annotation.f5610c;
                if (this.f5633a != null) {
                    switch (annotation.f5608a) {
                        case TITLE:
                            if (annotationStyle != AnnotationStyle.REGULAR) {
                                if (annotationStyle != AnnotationStyle.MEDIUM) {
                                    if (annotationStyle != AnnotationStyle.LARGE) {
                                        if (annotationStyle == AnnotationStyle.EXTRA_LARGE) {
                                            m5436a(this.f5633a.m6354k());
                                            break;
                                        }
                                    }
                                    m5436a(this.f5633a.m6355l());
                                    break;
                                }
                                m5436a(this.f5633a.m6356m());
                                break;
                            }
                            m5436a(this.f5633a.m6357n());
                            break;
                            break;
                        case SUBTITLE:
                            if (annotationStyle != AnnotationStyle.REGULAR) {
                                if (annotationStyle != AnnotationStyle.MEDIUM) {
                                    if (annotationStyle != AnnotationStyle.LARGE) {
                                        if (annotationStyle == AnnotationStyle.EXTRA_LARGE) {
                                            m5436a(this.f5633a.m6352g());
                                            break;
                                        }
                                    }
                                    m5436a(this.f5633a.ip_());
                                    break;
                                }
                                m5436a(this.f5633a.io_());
                                break;
                            }
                            m5436a(this.f5633a.m6353j());
                            break;
                            break;
                        case COPYRIGHT:
                            m5436a(this.f5633a.iq_());
                            break;
                    }
                }
                int a = RichTextUtils.m1352a(annotation);
                if (a != 0) {
                    m5441a(a);
                }
                if (!(annotation.f5614g == null || StringUtil.a(annotation.f5614g.mo303d()))) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(annotation.f5614g.mo303d());
                    m5440b(spannableStringBuilder, annotation.f5614g.mo302c());
                    m5433a(spannableStringBuilder, annotation.f5614g.mo301b());
                    this.f5636d = spannableStringBuilder;
                }
            }
            return this;
        }

        public RichTextBuilder m5444a(RichDocumentTextType richDocumentTextType) {
            if (richDocumentTextType != null) {
                if (RichText.f5640e.containsKey(richDocumentTextType)) {
                    m5441a(((Integer) RichText.f5640e.get(richDocumentTextType)).intValue());
                }
                if (this.f5633a != null) {
                    m5434a(this, richDocumentTextType, this.f5633a.m6360q());
                    m5435a(this, richDocumentTextType, this.f5633a);
                }
            }
            return this;
        }

        private static void m5434a(RichTextBuilder richTextBuilder, RichDocumentTextType richDocumentTextType, FallbackArticleStyleModel fallbackArticleStyleModel) {
            if (fallbackArticleStyleModel != null) {
                switch (richDocumentTextType) {
                    case KICKER:
                        richTextBuilder.m5437a(fallbackArticleStyleModel.m6311p(), true);
                        return;
                    case TITLE:
                        richTextBuilder.m5437a(fallbackArticleStyleModel.m6317v(), true);
                        return;
                    case SUBTITLE:
                        richTextBuilder.m5437a(fallbackArticleStyleModel.m6316u(), true);
                        return;
                    case HEADER_ONE:
                        richTextBuilder.m5437a(fallbackArticleStyleModel.m6309n(), true);
                        return;
                    case HEADER_TWO:
                        richTextBuilder.m5437a(fallbackArticleStyleModel.m6310o(), true);
                        return;
                    case BODY:
                        richTextBuilder.m5437a(fallbackArticleStyleModel.m6300a(), true);
                        return;
                    case PULL_QUOTE:
                        richTextBuilder.m5437a(fallbackArticleStyleModel.m6314s(), true);
                        return;
                    case RELATED_ARTICLES:
                        richTextBuilder.m5437a(fallbackArticleStyleModel.m6315t(), true);
                        return;
                    case CAPTION_TITLE:
                        richTextBuilder.m5437a(fallbackArticleStyleModel.m6306k(), true);
                        return;
                    case CAPTION_SUBTITLE:
                        richTextBuilder.m5437a(fallbackArticleStyleModel.m6304g(), true);
                        return;
                    case BYLINE:
                        richTextBuilder.m5437a(fallbackArticleStyleModel.m6301b(), true);
                        return;
                    case CREDITS:
                        richTextBuilder.m5437a(fallbackArticleStyleModel.m6308m(), true);
                        return;
                    case COPYRIGHT:
                        richTextBuilder.m5437a(fallbackArticleStyleModel.m6308m(), true);
                        return;
                    default:
                        return;
                }
            }
        }

        private static void m5435a(RichTextBuilder richTextBuilder, RichDocumentTextType richDocumentTextType, RichDocumentStyleModel richDocumentStyleModel) {
            if (richDocumentStyleModel != null) {
                switch (richDocumentTextType) {
                    case KICKER:
                        richTextBuilder.m5436a(richDocumentStyleModel.m6364u());
                        return;
                    case TITLE:
                        richTextBuilder.m5436a(richDocumentStyleModel.m6344B());
                        return;
                    case SUBTITLE:
                        richTextBuilder.m5436a(richDocumentStyleModel.m6343A());
                        return;
                    case HEADER_ONE:
                        richTextBuilder.m5436a(richDocumentStyleModel.m6361r());
                        return;
                    case HEADER_TWO:
                        richTextBuilder.m5436a(richDocumentStyleModel.m6362s());
                        return;
                    case BODY:
                        richTextBuilder.m5436a(richDocumentStyleModel.m6349b());
                        return;
                    case PULL_QUOTE:
                        richTextBuilder.m5436a(richDocumentStyleModel.m6368y());
                        return;
                    case RELATED_ARTICLES:
                        richTextBuilder.m5436a(richDocumentStyleModel.m6369z());
                        return;
                    case CAPTION_TITLE:
                        richTextBuilder.m5436a(richDocumentStyleModel.m6356m());
                        return;
                    case CAPTION_SUBTITLE:
                        richTextBuilder.m5436a(richDocumentStyleModel.io_());
                        return;
                    case BYLINE:
                        richTextBuilder.m5436a(richDocumentStyleModel.m6351d());
                        return;
                    case CREDITS:
                        richTextBuilder.m5436a(richDocumentStyleModel.m6359p());
                        return;
                    case COPYRIGHT:
                        richTextBuilder.m5436a(richDocumentStyleModel.m6359p());
                        return;
                    default:
                        return;
                }
            }
        }

        private void m5436a(RichDocumentElementStyleModel richDocumentElementStyleModel) {
            m5437a(richDocumentElementStyleModel, false);
        }

        private void m5437a(RichDocumentElementStyleModel richDocumentElementStyleModel, boolean z) {
            if (richDocumentElementStyleModel == null) {
                return;
            }
            if (z) {
                this.f5638f.add(richDocumentElementStyleModel);
            } else {
                this.f5637e.add(richDocumentElementStyleModel);
            }
        }

        public final RichTextBuilder m5441a(int i) {
            this.f5639g.add(Integer.valueOf(i));
            return this;
        }

        private void m5433a(SpannableStringBuilder spannableStringBuilder, List<? extends EntityRanges> list) {
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    EntityRangesModel entityRangesModel = (EntityRangesModel) it.next();
                    int d = entityRangesModel.m6427d();
                    int min = Math.min(entityRangesModel.m6426c(), spannableStringBuilder.length() - d);
                    BaseEntity a = m5447a(entityRangesModel);
                    if (a != null) {
                        spannableStringBuilder.setSpan(a, d, min + d, 17);
                    }
                }
            }
        }

        protected BaseEntity m5447a(EntityRangesModel entityRangesModel) {
            switch (C07182.f5631c[entityRangesModel.m6425b().ordinal()]) {
                case 1:
                    return new LinkEntity(this.f5633a, entityRangesModel.m6423a(), this.f5635c);
                case 2:
                    return new MentionEntity(entityRangesModel.m6423a(), this.f5635c);
                default:
                    return null;
            }
        }

        private void m5440b(SpannableStringBuilder spannableStringBuilder, List<? extends InlineStyleRanges> list) {
            if (!list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    InlineStyleRangesModel inlineStyleRangesModel = (InlineStyleRangesModel) it.next();
                    int c = inlineStyleRangesModel.m6435c();
                    int b = inlineStyleRangesModel.m6434b();
                    Object a = m5448a(inlineStyleRangesModel.m6431a());
                    if (a != null) {
                        spannableStringBuilder.setSpan(a, c, Math.min(b + c, spannableStringBuilder.length()), 17);
                    }
                }
            }
        }

        protected Object m5448a(GraphQLInlineStyle graphQLInlineStyle) {
            switch (C07182.f5632d[graphQLInlineStyle.ordinal()]) {
                case 1:
                    return new StyleSpan(0);
                case 2:
                    return new StyleSpan(1);
                case 3:
                    return new StyleSpan(2);
                case 4:
                    return new UnderlineSpan();
                case 5:
                    return new StrikethroughSpan();
                case 6:
                    return new TypefaceSpan("monospace");
                default:
                    return null;
            }
        }

        public final RichText m5446a() {
            return new RichText(this.f5636d, ImmutableList.copyOf(this.f5637e), ImmutableList.copyOf(this.f5638f), ImmutableList.copyOf(this.f5639g));
        }
    }

    public RichText(CharSequence charSequence, ImmutableList<RichDocumentElementStyle> immutableList, ImmutableList<RichDocumentElementStyle> immutableList2, ImmutableList<Integer> immutableList3) {
        this.f5641a = charSequence;
        this.f5642b = immutableList;
        this.f5644d = immutableList3;
        this.f5643c = immutableList2;
    }

    public final boolean m5449c() {
        return (this.f5643c == null || this.f5643c.isEmpty()) ? false : true;
    }
}
