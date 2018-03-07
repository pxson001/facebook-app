package com.facebook.feed.rows.sections.inlinesurvey;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.sections.inlinesurvey.data.InlineSurveySubmitMutator;
import com.facebook.feedplugins.base.footer.ui.OneButtonFooterView;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.ResourceIdTextPartDefinition;
import com.facebook.multirow.parts.TextAppearancePartDefinition;
import com.facebook.multirow.parts.TextBackgroundPartDefinition;
import com.facebook.ui.futures.TasksManager;
import javax.inject.Inject;

@ContextScoped
/* compiled from: in_messenger_shopping_enabled */
public class InlineSurveyFooterPartDefinition extends MultiRowSinglePartDefinition<Props, Void, FeedEnvironment, OneButtonFooterView> {
    public static final String f20262a = InlineSurveyFooterPartDefinition.class.getSimpleName();
    private static InlineSurveyFooterPartDefinition f20263j;
    private static final Object f20264k = new Object();
    private final Context f20265b;
    private final ClickListenerPartDefinition f20266c;
    private final ResourceIdTextPartDefinition f20267d;
    private final TextBackgroundPartDefinition f20268e;
    private final TextAppearancePartDefinition f20269f;
    public final InlineSurveySubmitMutator f20270g;
    public final Clock f20271h;
    public final AbstractFbErrorReporter f20272i;

    private static InlineSurveyFooterPartDefinition m27938b(InjectorLike injectorLike) {
        return new InlineSurveyFooterPartDefinition((Context) injectorLike.getInstance(Context.class), ClickListenerPartDefinition.m19353a(injectorLike), ResourceIdTextPartDefinition.m27943a(injectorLike), TextBackgroundPartDefinition.m27946a(injectorLike), TextAppearancePartDefinition.m27949a(injectorLike), new InlineSurveySubmitMutator(TasksManager.m14550b(injectorLike), GraphQLQueryExecutor.m10435a(injectorLike), String_LoggedInUserIdMethodAutoProvider.m4329b(injectorLike)), SystemClockMethodAutoProvider.m1498a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        1 1;
        int i;
        Props props = (Props) obj;
        FeedEnvironment feedEnvironment = (FeedEnvironment) anyEnvironment;
        SinglePartDefinition singlePartDefinition = this.f20266c;
        if (props.b.d) {
            1 = new 1(this, props, feedEnvironment);
        } else {
            1 = null;
        }
        subParts.mo2756a(singlePartDefinition, 1);
        subParts.mo2755a(2131559974, this.f20267d, Integer.valueOf(2131235704));
        subParts.mo2755a(2131559974, this.f20268e, new ColorDrawable(this.f20265b.getResources().getColor(2131361981)));
        if (props.b.d) {
            i = 2131625554;
        } else {
            i = 2131625553;
        }
        subParts.mo2755a(2131559974, this.f20269f, Integer.valueOf(i));
        return null;
    }

    public final boolean m27941a(Object obj) {
        Props props = (Props) obj;
        return props.b.c && !props.b.e;
    }

    public static InlineSurveyFooterPartDefinition m27937a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InlineSurveyFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20264k) {
                InlineSurveyFooterPartDefinition inlineSurveyFooterPartDefinition;
                if (a2 != null) {
                    inlineSurveyFooterPartDefinition = (InlineSurveyFooterPartDefinition) a2.mo818a(f20264k);
                } else {
                    inlineSurveyFooterPartDefinition = f20263j;
                }
                if (inlineSurveyFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m27938b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20264k, b3);
                        } else {
                            f20263j = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = inlineSurveyFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public InlineSurveyFooterPartDefinition(Context context, ClickListenerPartDefinition clickListenerPartDefinition, ResourceIdTextPartDefinition resourceIdTextPartDefinition, TextBackgroundPartDefinition textBackgroundPartDefinition, TextAppearancePartDefinition textAppearancePartDefinition, InlineSurveySubmitMutator inlineSurveySubmitMutator, Clock clock, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f20265b = context;
        this.f20266c = clickListenerPartDefinition;
        this.f20267d = resourceIdTextPartDefinition;
        this.f20268e = textBackgroundPartDefinition;
        this.f20269f = textAppearancePartDefinition;
        this.f20270g = inlineSurveySubmitMutator;
        this.f20271h = clock;
        this.f20272i = abstractFbErrorReporter;
    }

    public final ViewType<OneButtonFooterView> mo2547a() {
        return OneButtonFooterView.a;
    }
}
