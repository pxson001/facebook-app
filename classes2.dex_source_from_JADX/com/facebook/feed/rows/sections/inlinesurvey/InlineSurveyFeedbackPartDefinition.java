package com.facebook.feed.rows.sections.inlinesurvey;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.ViewType;

@ContextScoped
/* compiled from: in_app_browser_profiling */
public class InlineSurveyFeedbackPartDefinition extends MultiRowSinglePartDefinition<Props, Void, FeedEnvironment, InlineSurveyFeedbackView> {
    public static final ViewType f20282a = new C08211();
    private static InlineSurveyFeedbackPartDefinition f20283b;
    private static final Object f20284c = new Object();

    /* compiled from: in_app_browser_profiling */
    final class C08211 extends ViewType {
        C08211() {
        }

        public final View mo1995a(Context context) {
            return new InlineSurveyFeedbackView(context);
        }
    }

    private static InlineSurveyFeedbackPartDefinition m27954b() {
        return new InlineSurveyFeedbackPartDefinition();
    }

    public final boolean m27956a(Object obj) {
        return ((Props) obj).b.e;
    }

    public static InlineSurveyFeedbackPartDefinition m27953a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InlineSurveyFeedbackPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20284c) {
                InlineSurveyFeedbackPartDefinition inlineSurveyFeedbackPartDefinition;
                if (a2 != null) {
                    inlineSurveyFeedbackPartDefinition = (InlineSurveyFeedbackPartDefinition) a2.mo818a(f20284c);
                } else {
                    inlineSurveyFeedbackPartDefinition = f20283b;
                }
                if (inlineSurveyFeedbackPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.m1474e();
                        b3 = m27954b();
                        if (a2 != null) {
                            a2.mo822a(f20284c, b3);
                        } else {
                            f20283b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = inlineSurveyFeedbackPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final ViewType<InlineSurveyFeedbackView> mo2547a() {
        return f20282a;
    }
}
