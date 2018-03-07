package com.facebook.leadgen.util;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.leadgen.LeadGenLinkHandlerProvider;
import com.facebook.leadgen.LeadGenLogger;
import com.facebook.widget.FbScrollView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: photo_fbId */
public class LeadGenUIUtil {
    private static LeadGenUIUtil f6581d;
    private static final Object f6582e = new Object();
    @Inject
    public LeadGenLogger f6583a;
    public LeadGenLinkHandlerProvider f6584b;
    public Context f6585c;

    /* compiled from: photo_fbId */
    public class C05981 extends ClickableSpan {
        final /* synthetic */ FeedProps f6567a;
        final /* synthetic */ GraphQLStoryActionLink f6568b;
        final /* synthetic */ LeadGenUIUtil f6569c;

        public C05981(LeadGenUIUtil leadGenUIUtil, FeedProps feedProps, GraphQLStoryActionLink graphQLStoryActionLink) {
            this.f6569c = leadGenUIUtil;
            this.f6567a = feedProps;
            this.f6568b = graphQLStoryActionLink;
        }

        public void onClick(View view) {
            this.f6569c.f6583a.m8140a("cta_lead_gen_visit_privacy_page_click");
            this.f6569c.f6584b.m8133a(this.f6567a).m8132b(view, this.f6568b.C(), false);
        }
    }

    /* compiled from: photo_fbId */
    final class C05992 implements Runnable {
        final /* synthetic */ FbScrollView f6570a;
        final /* synthetic */ TextView f6571b;

        C05992(FbScrollView fbScrollView, TextView textView) {
            this.f6570a = fbScrollView;
            this.f6571b = textView;
        }

        public final void run() {
            this.f6570a.smoothScrollTo(0, this.f6571b.getTop());
        }
    }

    /* compiled from: photo_fbId */
    public class C06003 extends ClickableSpan {
        final /* synthetic */ FeedProps f6572a;
        final /* synthetic */ String f6573b;
        final /* synthetic */ LeadGenUIUtil f6574c;

        public C06003(LeadGenUIUtil leadGenUIUtil, FeedProps feedProps, String str) {
            this.f6574c = leadGenUIUtil;
            this.f6572a = feedProps;
            this.f6573b = str;
        }

        public void onClick(View view) {
            this.f6574c.f6583a.m8140a("cta_lead_gen_visit_privacy_page_click");
            this.f6574c.f6584b.m8133a(this.f6572a).m8131a(view, this.f6573b, false);
        }
    }

    /* compiled from: photo_fbId */
    public class C06014 extends ClickableSpan {
        final /* synthetic */ FeedProps f6575a;
        final /* synthetic */ GraphQLStoryActionLink f6576b;
        final /* synthetic */ LeadGenUIUtil f6577c;

        public C06014(LeadGenUIUtil leadGenUIUtil, FeedProps feedProps, GraphQLStoryActionLink graphQLStoryActionLink) {
            this.f6577c = leadGenUIUtil;
            this.f6575a = feedProps;
            this.f6576b = graphQLStoryActionLink;
        }

        public void onClick(View view) {
            this.f6577c.f6583a.m8140a("cta_lead_gen_visit_privacy_page_click");
            this.f6577c.f6584b.m8133a(this.f6575a).m8132b(view, this.f6576b.C(), false);
        }
    }

    /* compiled from: photo_fbId */
    public class C06025 extends ClickableSpan {
        final /* synthetic */ FeedProps f6578a;
        final /* synthetic */ GraphQLStoryActionLink f6579b;
        final /* synthetic */ LeadGenUIUtil f6580c;

        public C06025(LeadGenUIUtil leadGenUIUtil, FeedProps feedProps, GraphQLStoryActionLink graphQLStoryActionLink) {
            this.f6580c = leadGenUIUtil;
            this.f6578a = feedProps;
            this.f6579b = graphQLStoryActionLink;
        }

        public void onClick(View view) {
            this.f6580c.f6583a.m8140a("cta_lead_gen_visit_privacy_page_click");
            this.f6580c.f6584b.m8133a(this.f6578a).m8132b(view, this.f6579b.M().o(), false);
        }
    }

    private static LeadGenUIUtil m8507b(InjectorLike injectorLike) {
        LeadGenUIUtil leadGenUIUtil = new LeadGenUIUtil((LeadGenLinkHandlerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LeadGenLinkHandlerProvider.class), (Context) injectorLike.getInstance(Context.class));
        leadGenUIUtil.f6583a = LeadGenLogger.m8134a(injectorLike);
        return leadGenUIUtil;
    }

    @Inject
    public LeadGenUIUtil(LeadGenLinkHandlerProvider leadGenLinkHandlerProvider, Context context) {
        this.f6584b = leadGenLinkHandlerProvider;
        this.f6585c = context;
    }

    public static LeadGenUIUtil m8504a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LeadGenUIUtil b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6582e) {
                LeadGenUIUtil leadGenUIUtil;
                if (a2 != null) {
                    leadGenUIUtil = (LeadGenUIUtil) a2.a(f6582e);
                } else {
                    leadGenUIUtil = f6581d;
                }
                if (leadGenUIUtil == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m8507b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6582e, b3);
                        } else {
                            f6581d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = leadGenUIUtil;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public static void m8505a(TextView textView) {
        textView.setVisibility(8);
    }

    public static void m8506a(TextView textView, String str) {
        textView.setText(str);
        textView.setVisibility(0);
        FbScrollView fbScrollView = (FbScrollView) textView.getParent().getParent().getParent().getParent();
        fbScrollView.post(new C05992(fbScrollView, textView));
    }
}
