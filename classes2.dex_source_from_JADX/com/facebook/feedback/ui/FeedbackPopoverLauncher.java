package com.facebook.feedback.ui;

import android.content.Context;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feedback.abtest.ExperimentsForFeedbackTestModule;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.ufiperf.perf.UfiPerfUtil;
import com.facebook.ufiservices.flyout.FeedbackParams;
import com.facebook.ufiservices.flyout.PopoverParams;
import com.facebook.ufiservices.flyout.PopoverParams.Builder;
import com.facebook.ufiservices.flyout.UFIPopoverLauncher;
import com.facebook.widget.popover.PopoverAnimationState;
import javax.inject.Inject;

@ContextScoped
/* compiled from: is_user_active */
public class FeedbackPopoverLauncher {
    private static final String f18807a = FeedbackPopoverLauncher.class.getName();
    private static FeedbackPopoverLauncher f18808k;
    private static final Object f18809l = new Object();
    private final AbstractFbErrorReporter f18810b;
    private final PopoverAnimationState f18811c;
    private final UfiPerfUtil f18812d;
    private final SecureContextHelper f18813e;
    private final IFeedIntentBuilder f18814f;
    private final QuickPerformanceLogger f18815g;
    private final ViewerContextManager f18816h;
    private final QeAccessor f18817i;
    private final UFIPopoverLauncher f18818j;

    private static FeedbackPopoverLauncher m26454b(InjectorLike injectorLike) {
        return new FeedbackPopoverLauncher(FbErrorReporterImpl.m2317a(injectorLike), PopoverAnimationState.m26458a(injectorLike), UfiPerfUtil.m26467a(injectorLike), DefaultSecureContextHelper.m4636a(injectorLike), DefaultFeedIntentBuilder.m26214a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.m2859a(injectorLike), ViewerContextManagerProvider.m2496b(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), UFIPopoverLauncher.m26514b(injectorLike));
    }

    @Inject
    public FeedbackPopoverLauncher(AbstractFbErrorReporter abstractFbErrorReporter, PopoverAnimationState popoverAnimationState, UfiPerfUtil ufiPerfUtil, SecureContextHelper secureContextHelper, IFeedIntentBuilder iFeedIntentBuilder, QuickPerformanceLogger quickPerformanceLogger, ViewerContextManager viewerContextManager, QeAccessor qeAccessor, UFIPopoverLauncher uFIPopoverLauncher) {
        this.f18810b = abstractFbErrorReporter;
        this.f18811c = popoverAnimationState;
        this.f18812d = ufiPerfUtil;
        this.f18813e = secureContextHelper;
        this.f18814f = iFeedIntentBuilder;
        this.f18815g = quickPerformanceLogger;
        this.f18816h = viewerContextManager;
        this.f18817i = qeAccessor;
        this.f18818j = uFIPopoverLauncher;
    }

    public static FeedbackPopoverLauncher m26450a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FeedbackPopoverLauncher b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18809l) {
                FeedbackPopoverLauncher feedbackPopoverLauncher;
                if (a2 != null) {
                    feedbackPopoverLauncher = (FeedbackPopoverLauncher) a2.mo818a(f18809l);
                } else {
                    feedbackPopoverLauncher = f18808k;
                }
                if (feedbackPopoverLauncher == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m26454b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18809l, b3);
                        } else {
                            f18808k = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = feedbackPopoverLauncher;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final void m26455a(Context context, FeedbackParams feedbackParams) {
        m26451a(context, feedbackParams, new Builder().a(), true, -1);
    }

    public final void m26457a(Context context, FeedbackParams feedbackParams, boolean z, int i) {
        m26451a(context, feedbackParams, new Builder().a(), z, i);
    }

    public final void m26456a(Context context, FeedbackParams feedbackParams, PopoverParams popoverParams) {
        m26451a(context, feedbackParams, popoverParams, true, -1);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m26451a(android.content.Context r10, com.facebook.ufiservices.flyout.FeedbackParams r11, com.facebook.ufiservices.flyout.PopoverParams r12, boolean r13, int r14) {
        /*
        r9 = this;
        r1 = 1;
        if (r11 == 0) goto L_0x0013;
    L_0x0003:
        r4 = r11.a;
        if (r4 != 0) goto L_0x000f;
    L_0x0007:
        r4 = r11.d;
        if (r4 != 0) goto L_0x000f;
    L_0x000b:
        r4 = r11.e;
        if (r4 == 0) goto L_0x0186;
    L_0x000f:
        r4 = 1;
    L_0x0010:
        r0 = r4;
        if (r0 != 0) goto L_0x001c;
    L_0x0013:
        r0 = r9.f18810b;
        r2 = f18807a;
        r3 = "Feedback id or legacy api post id must be set";
        r0.m2350b(r2, r3);
    L_0x001c:
        r0 = r9.f18811c;
        r0 = r0.m26460a();
        if (r0 == 0) goto L_0x0025;
    L_0x0024:
        return;
    L_0x0025:
        r4 = r11.j;
        r0 = r4;
        if (r0 == 0) goto L_0x0030;
    L_0x002a:
        r0 = r9.m26452a();
        if (r0 == 0) goto L_0x00aa;
    L_0x0030:
        r0 = r9.f18812d;
        r8 = 3735560; // 0x390008 float:5.234634E-39 double:1.845612E-317;
        r7 = 0;
        r0.f18826e = r7;
        r0.f18827f = r7;
        r4 = r0.f18822a;
        r5 = 3735553; // 0x390001 float:5.234625E-39 double:1.8456084E-317;
        r6 = "NNF_FlyoutLoadDBCache";
        r4.mo392d(r5, r6);
        r4 = r0.f18822a;
        r5 = 3735554; // 0x390002 float:5.234626E-39 double:1.845609E-317;
        r6 = "NNF_FlyoutLoadDBCacheAndRender";
        r4.mo392d(r5, r6);
        r4 = r0.f18822a;
        r5 = 3735555; // 0x390003 float:5.234627E-39 double:1.8456094E-317;
        r6 = "NNF_FlyoutLoadNetwork";
        r4.mo392d(r5, r6);
        r4 = r0.f18822a;
        r5 = 3735556; // 0x390004 float:5.234629E-39 double:1.84561E-317;
        r6 = "NNF_FlyoutLoadNetworkAndRender";
        r4.mo392d(r5, r6);
        r4 = r0.f18822a;
        r5 = 3735557; // 0x390005 float:5.23463E-39 double:1.8456104E-317;
        r6 = "NNF_FlyoutLoadNetworkNoCache";
        r4.mo392d(r5, r6);
        r4 = r0.f18822a;
        r5 = 3735558; // 0x390006 float:5.234632E-39 double:1.845611E-317;
        r6 = "NNF_FlyoutLoadNetworkNoCacheAndRender";
        r4.mo392d(r5, r6);
        r4 = r0.f18822a;
        r5 = 3735559; // 0x390007 float:5.234633E-39 double:1.8456114E-317;
        r6 = "NNF_FlyoutLoadCompleteFlow";
        r4.mo392d(r5, r6);
        r4 = r0.f18823b;
        r4.mo471c(r8);
        if (r14 < 0) goto L_0x0092;
    L_0x0087:
        r4 = r0.f18823b;
        r5 = "story_index";
        r6 = java.lang.String.valueOf(r14);
        r4.mo467b(r8, r5, r6);
    L_0x0092:
        r0.f18825d = r7;
        r0.f18824c = r7;
        r4 = r0.f18822a;
        r5 = 3735561; // 0x390009 float:5.234636E-39 double:1.8456124E-317;
        r6 = "NNF_FlyoutLoadOnCreateTime";
        r4.mo392d(r5, r6);
        r4 = r0.f18822a;
        r5 = 3735562; // 0x39000a float:5.234637E-39 double:1.845613E-317;
        r6 = "NNF_FlyoutLoadFragmentCreateTime";
        r4.mo392d(r5, r6);
    L_0x00aa:
        r0 = r9.m26452a();
        r2 = r9.m26453a(r11);
        if (r2 == 0) goto L_0x00c7;
    L_0x00b4:
        r4 = r11.a;
        r0 = r4;
        r0 = com.facebook.graphql.model.GraphQLHelper.m22525s(r0);
        if (r0 != 0) goto L_0x00fc;
    L_0x00bd:
        r0 = r9.f18810b;
        r2 = f18807a;
        r3 = "Reactors list init needs valid reactors count map";
        r0.m2340a(r2, r3);
        r0 = r1;
    L_0x00c7:
        r4 = r11.j;
        r2 = r4;
        if (r2 == 0) goto L_0x0145;
    L_0x00cc:
        if (r0 != 0) goto L_0x0145;
    L_0x00ce:
        r0 = new com.facebook.ufiservices.flyout.ProfileListParams$Builder;
        r0.<init>();
        r2 = r11.g();
        r0.a = r2;
        r0 = r0;
        r2 = com.facebook.ipc.feed.ProfileListParamType.LIKERS_FOR_FEEDBACK_ID;
        r0.d = r2;
        r0 = r0;
        r0.f = r1;
        r0 = r0;
        r0.e = r1;
        r0 = r0;
        r1 = r0.a();
        r0 = new com.facebook.ufiservices.flyout.UFIProfileListFragment;
        r0.<init>();
        r1 = r1.k();
        r0.m271g(r1);
    L_0x00f5:
        r1 = r9.f18818j;
        r1.m26516a(r0, r10, r12, r13);
        goto L_0x0024;
    L_0x00fc:
        r0 = r9.f18814f;
        r4 = r11.a;
        r2 = r4;
        r3 = "native_newsfeed";
        r0 = r0.mo3006a(r2, r3);
        r2 = "fragment_title";
        r3 = 2131233292; // 0x7f080a0c float:1.8082717E38 double:1.052969153E-314;
        r3 = r10.getString(r3);
        r0.putExtra(r2, r3);
        r2 = r9.f18816h;
        r2 = r2.mo215b();
        if (r2 == 0) goto L_0x0131;
    L_0x011b:
        r2 = r9.f18816h;
        r2 = r2.mo215b();
        r4 = r2.mIsPageContext;
        r2 = r4;
        if (r2 == 0) goto L_0x0131;
    L_0x0126:
        r2 = "com.facebook.orca.auth.OVERRIDDEN_VIEWER_CONTEXT";
        r3 = r9.f18816h;
        r3 = r3.mo215b();
        r0.putExtra(r2, r3);
    L_0x0131:
        r2 = "open_fragment_as_modal";
        r0.putExtra(r2, r1);
        r1 = r9.f18815g;
        r2 = 8519681; // 0x820001 float:1.1938616E-38 double:4.2092817E-317;
        r1.mo462b(r2);
        r1 = r9.f18813e;
        r1.mo662a(r0, r10);
        goto L_0x0024;
    L_0x0145:
        r0 = r9.f18817i;
        r1 = com.facebook.feedback.abtest.ExperimentsForFeedbackTestModule.f6824b;
        r2 = 0;
        r0 = r0.mo596a(r1, r2);
        if (r0 == 0) goto L_0x0179;
    L_0x0150:
        r0 = r9.f18812d;
        r0.m26495s();
        r0 = new com.facebook.feedback.ui.BgInflatableFeedbackFragment;
        r0.<init>();
        r1 = r11.v();
        r0.m271g(r1);
    L_0x0161:
        r4 = r11.g;
        r1 = r4;
        if (r1 == 0) goto L_0x016e;
    L_0x0166:
        r4 = r11.g;
        r1 = r4;
        r4 = r1.f22391c;
        r1 = r4;
        if (r1 != 0) goto L_0x00f5;
    L_0x016e:
        r1 = r9.f18810b;
        r2 = f18807a;
        r3 = "feedback logging params or feedback source is null";
        r1.m2340a(r2, r3);
        goto L_0x00f5;
    L_0x0179:
        r0 = new com.facebook.feedback.ui.DefaultFeedbackFragment;
        r0.<init>();
        r1 = r11.v();
        r0.m271g(r1);
        goto L_0x0161;
    L_0x0186:
        r4 = 0;
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.ui.FeedbackPopoverLauncher.a(android.content.Context, com.facebook.ufiservices.flyout.FeedbackParams, com.facebook.ufiservices.flyout.PopoverParams, boolean, int):void");
    }

    private boolean m26453a(FeedbackParams feedbackParams) {
        if (!feedbackParams.j || m26452a() || feedbackParams.r) {
            return false;
        }
        GraphQLFeedback graphQLFeedback = feedbackParams.a;
        if (graphQLFeedback == null || graphQLFeedback.m23211E() == null || graphQLFeedback.m23211E().m22671a() <= 0) {
            return false;
        }
        return true;
    }

    private boolean m26452a() {
        return this.f18817i.mo596a(ExperimentsForFeedbackTestModule.f6837o, false);
    }
}
