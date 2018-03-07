package com.facebook.feed.spannable;

import android.content.Context;
import android.text.Spannable;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.unicode.RangeConverter;
import com.facebook.common.unicode.UTF16Range;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import com.facebook.graphql.model.GraphQLImageAtRange;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.text.imagerange.FrescoTextWithImageFetcher;
import com.facebook.text.imagerange.FrescoTextWithImageFetcher.DraweeSpanSpec;
import com.facebook.widget.text.abtest.ExperimentsForWidgetTextAbTestModule;
import com.google.common.collect.ImmutableList;
import java.util.Iterator;
import java.util.TreeSet;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Typing_Indicator_Cell_Shown_Without_Text */
public class FrescoSpannableImageRangeApplicator {
    private static final CallerContext f21671a = CallerContext.a(FrescoSpannableImageRangeApplicator.class);
    private static FrescoSpannableImageRangeApplicator f21672e;
    private static final Object f21673f = new Object();
    private final Context f21674b;
    private final FrescoTextWithImageFetcher f21675c;
    private final QeAccessor f21676d;

    private static FrescoSpannableImageRangeApplicator m24252b(InjectorLike injectorLike) {
        return new FrescoSpannableImageRangeApplicator((Context) injectorLike.getInstance(Context.class), FrescoTextWithImageFetcher.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FrescoSpannableImageRangeApplicator(Context context, FrescoTextWithImageFetcher frescoTextWithImageFetcher, QeAccessor qeAccessor) {
        this.f21674b = context;
        this.f21675c = frescoTextWithImageFetcher;
        this.f21676d = qeAccessor;
    }

    public static FrescoSpannableImageRangeApplicator m24251a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FrescoSpannableImageRangeApplicator b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f21673f) {
                FrescoSpannableImageRangeApplicator frescoSpannableImageRangeApplicator;
                if (a2 != null) {
                    frescoSpannableImageRangeApplicator = (FrescoSpannableImageRangeApplicator) a2.a(f21673f);
                } else {
                    frescoSpannableImageRangeApplicator = f21672e;
                }
                if (frescoSpannableImageRangeApplicator == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24252b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f21673f, b3);
                        } else {
                            f21672e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = frescoSpannableImageRangeApplicator;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Nullable
    public final DraweeSpanStringBuilder m24253a(Spannable spannable, int i, @Nullable GraphQLTextWithEntities graphQLTextWithEntities) {
        if (graphQLTextWithEntities == null || graphQLTextWithEntities.d() == null || graphQLTextWithEntities.d().isEmpty()) {
            return null;
        }
        ImmutableList<GraphQLImageAtRange> d = graphQLTextWithEntities.d();
        String a = graphQLTextWithEntities.a();
        int dimensionPixelSize = this.f21674b.getResources().getDimensionPixelSize(this.f21676d.a(ExperimentsForWidgetTextAbTestModule.e, false) ? 2131427403 : 2131427404);
        TreeSet treeSet = new TreeSet(FrescoTextWithImageFetcher.a);
        DraweeSpanStringBuilder draweeSpanStringBuilder = new DraweeSpanStringBuilder(spannable);
        for (GraphQLImageAtRange graphQLImageAtRange : d) {
            if (!(graphQLImageAtRange.j() == null || graphQLImageAtRange.j().l() == null)) {
                UTF16Range a2 = RangeConverter.a(a, graphQLImageAtRange.c(), graphQLImageAtRange.b());
                treeSet.add(new DraweeSpanSpec(ImageUtil.a(graphQLImageAtRange.j().l()), new UTF16Range(a2.a + i, a2.b)));
            }
        }
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            DraweeSpanSpec draweeSpanSpec = (DraweeSpanSpec) it.next();
            draweeSpanStringBuilder = this.f21675c.a(draweeSpanStringBuilder, draweeSpanSpec.a, -1, dimensionPixelSize, draweeSpanSpec.b, 1, f21671a);
        }
        return draweeSpanStringBuilder;
    }
}
