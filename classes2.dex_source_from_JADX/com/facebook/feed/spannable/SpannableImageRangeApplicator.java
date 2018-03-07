package com.facebook.feed.spannable;

import android.content.Context;
import android.text.Spannable;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.unicode.RangeConverter;
import com.facebook.common.unicode.UTF16Range;
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
import com.facebook.text.imagerange.TextWithImageFetcher;
import com.facebook.widget.text.abtest.ExperimentsForWidgetTextAbTestModule;
import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
@Deprecated
/* compiled from: image/ */
public class SpannableImageRangeApplicator {
    private static SpannableImageRangeApplicator f20523f;
    private static final Object f20524g = new Object();
    private final Context f20525a;
    @ForUiThread
    private final ExecutorService f20526b;
    private final TextWithImageFetcher f20527c;
    public final AbstractFbErrorReporter f20528d;
    private final QeAccessor f20529e;

    private static SpannableImageRangeApplicator m28264b(InjectorLike injectorLike) {
        return new SpannableImageRangeApplicator((Context) injectorLike.getInstance(Context.class), ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.m1951a(injectorLike), TextWithImageFetcher.m28266a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public SpannableImageRangeApplicator(Context context, ExecutorService executorService, TextWithImageFetcher textWithImageFetcher, AbstractFbErrorReporter abstractFbErrorReporter, QeAccessor qeAccessor) {
        this.f20525a = context;
        this.f20526b = executorService;
        this.f20527c = textWithImageFetcher;
        this.f20528d = abstractFbErrorReporter;
        this.f20529e = qeAccessor;
    }

    public static SpannableImageRangeApplicator m28263a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SpannableImageRangeApplicator b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20524g) {
                SpannableImageRangeApplicator spannableImageRangeApplicator;
                if (a2 != null) {
                    spannableImageRangeApplicator = (SpannableImageRangeApplicator) a2.mo818a(f20524g);
                } else {
                    spannableImageRangeApplicator = f20523f;
                }
                if (spannableImageRangeApplicator == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28264b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20524g, b3);
                        } else {
                            f20523f = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = spannableImageRangeApplicator;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final void m28265a(Spannable spannable, int i, @Nullable GraphQLTextWithEntities graphQLTextWithEntities, Function<Spannable, Void> function) {
        if (graphQLTextWithEntities != null && graphQLTextWithEntities.m22619d() != null && !graphQLTextWithEntities.m22619d().isEmpty()) {
            List<GraphQLImageAtRange> d = graphQLTextWithEntities.m22619d();
            String a = graphQLTextWithEntities.mo2911a();
            List arrayList = new ArrayList();
            for (GraphQLImageAtRange graphQLImageAtRange : d) {
                if (!(graphQLImageAtRange.m23596j() == null || graphQLImageAtRange.m23596j().m32375l() == null)) {
                    UTF16Range a2 = RangeConverter.m29944a(a, graphQLImageAtRange.m23595c(), graphQLImageAtRange.m23594b());
                    arrayList.add(this.f20527c.m28268a(new UTF16Range(a2.f22086a + i, a2.f22087b), ImageUtil.m26990a(graphQLImageAtRange.m23596j().m32375l())));
                }
            }
            ListenableFuture a3 = this.f20527c.m28269a(spannable, arrayList, (float) this.f20525a.getResources().getDimensionPixelSize(this.f20529e.mo596a(ExperimentsForWidgetTextAbTestModule.f21797e, false) ? 2131427403 : 2131427404), this.f20529e.mo596a(ExperimentsForWidgetTextAbTestModule.f21793a, false) ? 2 : 1);
            if (a3 != null) {
                Futures.m2458a(a3, new 1(this, function), this.f20526b);
            }
        }
    }
}
