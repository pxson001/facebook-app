package com.facebook.feedback.ui.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.RootPartSelector;
import com.facebook.feedback.ui.environment.CommentsEnvironment;
import com.facebook.feedback.ui.rows.TopLevelCommentGroupPartDefinition.Props;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ridge_has_seen_interstitial */
public class FeedbackRootGroupPartDefinition extends BaseMultiRowGroupPartDefinition<RootProps, Void, CommentsEnvironment> {
    private static FeedbackRootGroupPartDefinition f5047b;
    private static final Object f5048c = new Object();
    private final RootPartSelector<CommentsEnvironment> f5049a;

    private static FeedbackRootGroupPartDefinition m5532b(InjectorLike injectorLike) {
        return new FeedbackRootGroupPartDefinition(IdBasedLazy.a(injectorLike, 6156), IdBasedLazy.a(injectorLike, 6157), IdBasedLazy.a(injectorLike, 6160));
    }

    public final Object m5533a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        this.f5049a.a(baseMultiRowSubParts, (RootProps) obj);
        return null;
    }

    @Inject
    public FeedbackRootGroupPartDefinition(Lazy<LoadMoreCommentsPartDefinition> lazy, Lazy<OriginalPostButtonPartDefinition> lazy2, Lazy<TopLevelCommentGroupPartDefinition> lazy3) {
        this.f5049a = RootPartSelector.a().a(Props.class, lazy3).a(OriginalPostButtonPartDefinition.Props.class, lazy2).a(LoadMoreCommentsPartDefinition.Props.class, lazy);
    }

    public final boolean m5534a(Object obj) {
        return true;
    }

    public static FeedbackRootGroupPartDefinition m5531a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FeedbackRootGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5048c) {
                FeedbackRootGroupPartDefinition feedbackRootGroupPartDefinition;
                if (a2 != null) {
                    feedbackRootGroupPartDefinition = (FeedbackRootGroupPartDefinition) a2.a(f5048c);
                } else {
                    feedbackRootGroupPartDefinition = f5047b;
                }
                if (feedbackRootGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5532b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5048c, b3);
                        } else {
                            f5047b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = feedbackRootGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
