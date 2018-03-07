package com.facebook.richdocument.view.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.method.TransformationMethod;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLCapitalizationStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.richdocument.fonts.RichDocumentFonts;
import com.facebook.richdocument.model.block.Annotation;
import com.facebook.richdocument.model.block.Annotation.AnnotationStyle;
import com.facebook.richdocument.model.block.RichText;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentElementStyleModel;
import com.facebook.richdocument.utils.UIUtils;
import com.google.common.collect.ImmutableList;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: unknown view stub attribute =  */
public class RichTextUtils {
    private static RichTextUtils f1128b;
    private static final Object f1129c = new Object();
    private final RichDocumentFonts f1130a;

    /* compiled from: unknown view stub attribute =  */
    public class CapsTransformationMethod implements TransformationMethod {
        private final GraphQLCapitalizationStyle f7367a;
        private final Locale f7368b;

        public CapsTransformationMethod(Context context, GraphQLCapitalizationStyle graphQLCapitalizationStyle) {
            this.f7367a = graphQLCapitalizationStyle;
            this.f7368b = context.getResources().getConfiguration().locale;
        }

        public CharSequence getTransformation(CharSequence charSequence, View view) {
            if (this.f7367a == GraphQLCapitalizationStyle.ALL_CAPS) {
                return charSequence == null ? null : charSequence.toString().toUpperCase(this.f7368b);
            } else {
                if (this.f7367a == GraphQLCapitalizationStyle.ALL_LOWER_CASE) {
                    return charSequence == null ? null : charSequence.toString().toLowerCase(this.f7368b);
                } else {
                    return charSequence;
                }
            }
        }

        public void onFocusChanged(View view, CharSequence charSequence, boolean z, int i, Rect rect) {
        }
    }

    private static RichTextUtils m1358b(InjectorLike injectorLike) {
        return new RichTextUtils(RichDocumentFonts.m5213a(injectorLike));
    }

    @Inject
    public RichTextUtils(RichDocumentFonts richDocumentFonts) {
        this.f1130a = richDocumentFonts;
    }

    public final void m1359a(@Nullable TextView textView, RichText richText) {
        int i = 0;
        if (textView != null) {
            Object obj;
            ImmutableList immutableList;
            int size;
            int i2;
            RichDocumentElementStyleModel richDocumentElementStyleModel;
            textView.setText(richText.f5641a);
            if (LinkHighlightMovementMethod.f7227a == null) {
                LinkHighlightMovementMethod.f7227a = new LinkHighlightMovementMethod();
            }
            textView.setMovementMethod(LinkHighlightMovementMethod.f7227a);
            if (richText.f5644d == null || richText.f5644d.isEmpty()) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                immutableList = richText.f5644d;
                size = immutableList.size();
                for (i2 = 0; i2 < size; i2++) {
                    Integer num = (Integer) immutableList.get(i2);
                    if (num != null) {
                        textView.setTextAppearance(textView.getContext(), num.intValue());
                    }
                }
            }
            if (richText.m5449c()) {
                immutableList = richText.f5643c;
                size = immutableList.size();
                for (i2 = 0; i2 < size; i2++) {
                    richDocumentElementStyleModel = (RichDocumentElementStyleModel) immutableList.get(i2);
                    m1356a(textView, richDocumentElementStyleModel, richDocumentElementStyleModel.m5925c());
                }
            }
            Map map = this.f1130a.f5279a;
            Map map2 = this.f1130a.f5280b;
            if (map == null || map.isEmpty()) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            if (richText.f5642b == null || richText.f5642b.isEmpty()) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                ImmutableList immutableList2 = richText.f5642b;
                int size2 = immutableList2.size();
                while (i < size2) {
                    richDocumentElementStyleModel = (RichDocumentElementStyleModel) immutableList2.get(i);
                    if (!richText.m5449c() || r1 != 0 || m1354a(map2, richDocumentElementStyleModel.m5925c()) != null) {
                        m1356a(textView, richDocumentElementStyleModel, richDocumentElementStyleModel.m5925c());
                    }
                    i++;
                }
            }
        }
    }

    public static RichTextUtils m1355a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RichTextUtils b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1129c) {
                RichTextUtils richTextUtils;
                if (a2 != null) {
                    richTextUtils = (RichTextUtils) a2.a(f1129c);
                } else {
                    richTextUtils = f1128b;
                }
                if (richTextUtils == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m1358b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1129c, b3);
                        } else {
                            f1128b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = richTextUtils;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private void m1356a(TextView textView, RichDocumentElementStyleModel richDocumentElementStyleModel, String str) {
        m1357a(textView, richDocumentElementStyleModel.m5924b());
        GraphQLCapitalizationStyle a = richDocumentElementStyleModel.m5922a();
        if (a != null) {
            textView.setTransformationMethod(new CapsTransformationMethod(textView.getContext(), a));
        }
        m1360b(textView, str);
        UIUtils.m6864a(textView, m1353a(richDocumentElementStyleModel.m5926d()));
    }

    protected static void m1357a(TextView textView, String str) {
        try {
            textView.setTextColor(m1353a(str));
        } catch (IllegalArgumentException e) {
        }
    }

    protected final void m1360b(TextView textView, String str) {
        Typeface a = m1354a(this.f1130a.f5279a, str);
        if (a == null) {
            a = m1354a(this.f1130a.f5280b, str);
        }
        if (a == null) {
            textView.setTypeface(Typeface.DEFAULT);
        } else {
            textView.setTypeface(a);
        }
    }

    private static Typeface m1354a(Map<String, Typeface> map, String str) {
        if (map == null || str == null) {
            return null;
        }
        return (Typeface) map.get(str);
    }

    public static int m1353a(String str) {
        if (StringUtil.c(str)) {
            return 0;
        }
        if (!str.startsWith("#")) {
            str = "#" + str;
        }
        return Color.parseColor(str);
    }

    public static int m1352a(@Nullable Annotation annotation) {
        if (annotation == null) {
            return 0;
        }
        AnnotationStyle annotationStyle = annotation.f5610c;
        if (annotationStyle == AnnotationStyle.MINI_LABEL) {
            return 2131626003;
        }
        if (annotationStyle == AnnotationStyle.REGULAR) {
            return 2131626005;
        }
        if (annotationStyle == AnnotationStyle.MEDIUM) {
            return 2131626006;
        }
        if (annotationStyle == AnnotationStyle.LARGE) {
            return 2131626007;
        }
        if (annotationStyle == AnnotationStyle.EXTRA_LARGE) {
            return 2131626008;
        }
        switch (annotation.f5608a) {
            case TITLE:
                return 2131626007;
            case SUBTITLE:
            case COPYRIGHT:
            case AUDIO:
                return 2131626005;
            default:
                return 0;
        }
    }
}
