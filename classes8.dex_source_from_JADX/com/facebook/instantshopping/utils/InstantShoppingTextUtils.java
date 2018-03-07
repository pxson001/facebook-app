package com.facebook.instantshopping.utils;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.widget.TextView;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.SizeUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLInstantShoppingDocumentAlignmentDescriptorType;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingTextMetricsDescriptorFragmentModel;
import com.facebook.richdocument.fonts.RichDocumentFonts;
import com.facebook.richdocument.view.widget.RichTextUtils;
import com.facebook.richdocument.view.widget.RichTextView;
import com.facebook.richdocument.view.widget.RichTextView.InnerRichTextView;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: unknown_attachment */
public class InstantShoppingTextUtils extends RichTextUtils {
    private static InstantShoppingTextUtils f1131b;
    private static final Object f1132c = new Object();
    public final Context f1133a;

    /* compiled from: unknown_attachment */
    public /* synthetic */ class C01041 {
        public static final /* synthetic */ int[] f1127a = new int[GraphQLInstantShoppingDocumentAlignmentDescriptorType.values().length];

        static {
            try {
                f1127a[GraphQLInstantShoppingDocumentAlignmentDescriptorType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1127a[GraphQLInstantShoppingDocumentAlignmentDescriptorType.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1127a[GraphQLInstantShoppingDocumentAlignmentDescriptorType.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f1127a[GraphQLInstantShoppingDocumentAlignmentDescriptorType.CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    private static InstantShoppingTextUtils m1362c(InjectorLike injectorLike) {
        return new InstantShoppingTextUtils((Context) injectorLike.getInstance(Context.class), RichDocumentFonts.m5213a(injectorLike));
    }

    @Inject
    public InstantShoppingTextUtils(Context context, RichDocumentFonts richDocumentFonts) {
        super(richDocumentFonts);
        this.f1133a = context;
    }

    public final void m1363a(@Nullable TextView textView, @Nullable GraphQLInstantShoppingDocumentAlignmentDescriptorType graphQLInstantShoppingDocumentAlignmentDescriptorType, InstantShoppingTextMetricsDescriptorFragmentModel instantShoppingTextMetricsDescriptorFragmentModel) {
        if (graphQLInstantShoppingDocumentAlignmentDescriptorType != null) {
            switch (C01041.f1127a[graphQLInstantShoppingDocumentAlignmentDescriptorType.ordinal()]) {
                case 1:
                case 2:
                    textView.setGravity(3);
                    break;
                case 3:
                    textView.setGravity(5);
                    break;
                case 4:
                    textView.setGravity(17);
                    break;
                default:
                    break;
            }
        }
        textView.setGravity(3);
        if (instantShoppingTextMetricsDescriptorFragmentModel != null) {
            RichTextUtils.m1357a(textView, instantShoppingTextMetricsDescriptorFragmentModel.iP_());
            m1360b(textView, instantShoppingTextMetricsDescriptorFragmentModel.m1216a());
            Object b = instantShoppingTextMetricsDescriptorFragmentModel.m1218b();
            if (!StringUtil.a(b)) {
                textView.setTextSize(Float.parseFloat(b));
            }
            int d = instantShoppingTextMetricsDescriptorFragmentModel.m1220d();
            if (d > 0) {
                if (d == 1) {
                    textView.setSingleLine(true);
                } else {
                    textView.setMaxLines(d);
                }
                textView.setEllipsize(TruncateAt.END);
            }
            b = instantShoppingTextMetricsDescriptorFragmentModel.m1219c();
            if (!StringUtil.a(b)) {
                ((InnerRichTextView) textView).m7625a(SizeUtil.b(this.f1133a, (float) Integer.parseInt(b)));
                ((RichTextView) textView.getParent()).requestLayout();
            }
            ((InnerRichTextView) textView).f7389d = true;
        }
    }

    public static InstantShoppingTextUtils m1361b(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InstantShoppingTextUtils c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1132c) {
                InstantShoppingTextUtils instantShoppingTextUtils;
                if (a2 != null) {
                    instantShoppingTextUtils = (InstantShoppingTextUtils) a2.a(f1132c);
                } else {
                    instantShoppingTextUtils = f1131b;
                }
                if (instantShoppingTextUtils == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        c = m1362c(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1132c, c);
                        } else {
                            f1131b = c;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    c = instantShoppingTextUtils;
                }
            }
            return c;
        } finally {
            a.c(b);
        }
    }
}
