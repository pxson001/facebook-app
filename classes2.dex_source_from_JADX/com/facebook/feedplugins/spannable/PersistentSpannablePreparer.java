package com.facebook.feedplugins.spannable;

import android.content.Context;
import android.text.Spannable;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.spannable.FrescoSpannableImageRangeApplicator;
import com.facebook.feed.spannable.PersistentSpannable;
import com.facebook.feed.spannable.SpannableImageRangeApplicator;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.google.common.base.Function;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: image/* */
public class PersistentSpannablePreparer {
    private static PersistentSpannablePreparer f20519c;
    private static final Object f20520d = new Object();
    public final SpannableImageRangeApplicator f20521a;
    public final Lazy<FrescoSpannableImageRangeApplicator> f20522b;

    private static PersistentSpannablePreparer m28259b(InjectorLike injectorLike) {
        return new PersistentSpannablePreparer(SpannableImageRangeApplicator.m28263a(injectorLike), IdBasedLazy.m1808a(injectorLike, 6059));
    }

    @Inject
    public PersistentSpannablePreparer(SpannableImageRangeApplicator spannableImageRangeApplicator, Lazy<FrescoSpannableImageRangeApplicator> lazy) {
        this.f20521a = spannableImageRangeApplicator;
        this.f20522b = lazy;
    }

    public final <E extends HasPersistentState & HasInvalidate> void m28260a(PersistentSpannableInput persistentSpannableInput, E e) {
        m28261b(persistentSpannableInput, e);
    }

    public final <E extends HasPersistentState & HasInvalidate> void m28261b(final PersistentSpannableInput persistentSpannableInput, final E e) {
        PersistentSpannable persistentSpannable = (PersistentSpannable) e.mo2425a(persistentSpannableInput.mo3193a(), persistentSpannableInput.mo3195c());
        if (!persistentSpannable.f21834b) {
            e.mo2439a(persistentSpannableInput.mo3193a(), new PersistentSpannable(persistentSpannable.f21833a, true));
            Spannable spannable = persistentSpannable.f21833a;
            this.f20521a.m28265a(spannable, persistentSpannableInput.mo3192a(spannable), persistentSpannableInput.mo3194b(), new Function<Spannable, Void>(this) {
                final /* synthetic */ PersistentSpannablePreparer f21838c;

                public Object apply(@Nullable Object obj) {
                    e.mo2439a(persistentSpannableInput.mo3193a(), new PersistentSpannable((Spannable) obj, true));
                    ((HasInvalidate) e).mo2438a(persistentSpannableInput.mo3195c());
                    return null;
                }
            });
        }
    }

    public static PersistentSpannablePreparer m28258a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PersistentSpannablePreparer b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20520d) {
                PersistentSpannablePreparer persistentSpannablePreparer;
                if (a2 != null) {
                    persistentSpannablePreparer = (PersistentSpannablePreparer) a2.mo818a(f20520d);
                } else {
                    persistentSpannablePreparer = f20519c;
                }
                if (persistentSpannablePreparer == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28259b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20520d, b3);
                        } else {
                            f20519c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = persistentSpannablePreparer;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final <E extends HasPersistentState & HasInvalidate> void m28262c(PersistentSpannableInput persistentSpannableInput, E e) {
        PersistentSpannable persistentSpannable = (PersistentSpannable) e.mo2425a(persistentSpannableInput.mo3193a(), persistentSpannableInput.mo3195c());
        if (!persistentSpannable.f21834b) {
            Spannable spannable = persistentSpannable.f21833a;
            DraweeSpanStringBuilder a = ((FrescoSpannableImageRangeApplicator) this.f20522b.get()).a(spannable, persistentSpannableInput.mo3192a(spannable), persistentSpannableInput.mo3194b());
            if (a != null) {
                a.c = new 2(this, e, persistentSpannableInput);
            }
            spannable = a;
            if (spannable == null) {
                e.mo2439a(persistentSpannableInput.mo3193a(), new PersistentSpannable(persistentSpannable.f21833a, true));
            } else {
                e.mo2439a(persistentSpannableInput.mo3193a(), new PersistentSpannable(spannable, true, spannable));
            }
        }
    }
}
