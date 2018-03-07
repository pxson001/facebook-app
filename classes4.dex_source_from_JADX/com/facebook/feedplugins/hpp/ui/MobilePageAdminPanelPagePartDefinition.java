package com.facebook.feedplugins.hpp.ui;

import android.content.Context;
import android.graphics.PointF;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.Tuple;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.renderer.DefaultFeedUnitRenderer;
import com.facebook.graphql.model.GraphQLAYMTTip;
import com.facebook.graphql.model.GraphQLEntityCardContextItem;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLMobilePageAdminPanelFeedUnitItem;
import com.facebook.graphql.model.GraphQLVect2;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.ViewType;
import com.facebook.pages.common.intent_builder.DefaultPageSurfaceIntentBuilder;
import com.facebook.pages.common.intent_builder.IPageIdentityIntentBuilder;
import com.facebook.pages.identity.contextitems.PageContextItemsFallbackHandler;
import com.facebook.pages.identity.intent.impl.FbAndroidPageSurfaceIntentBuilder;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: numStories */
public class MobilePageAdminPanelPagePartDefinition extends BaseSinglePartDefinitionWithViewType<Props, State, AnyEnvironment, MobilePageAdminPanelBodyView> {
    public static final ViewType<MobilePageAdminPanelBodyView> f6616a = new C03001();
    private static MobilePageAdminPanelPagePartDefinition f6617m;
    private static final Object f6618n = new Object();
    public final DefaultFeedUnitRenderer f6619b;
    public final PageContextItemsFallbackHandler f6620c;
    public final AnalyticsLogger f6621d;
    public final NewsFeedAnalyticsEventBuilder f6622e;
    public final IFeedIntentBuilder f6623f;
    public final Provider<String> f6624g;
    public final ComposerLauncher f6625h;
    public final DefaultPageSurfaceIntentBuilder f6626i;
    public final ViewerContextManager f6627j;
    public final SecureContextHelper f6628k;
    public final UriIntentMapper f6629l;

    /* compiled from: numStories */
    final class C03001 extends ViewType<MobilePageAdminPanelBodyView> {
        C03001() {
        }

        public final View m7034a(Context context) {
            return new MobilePageAdminPanelBodyView(context);
        }
    }

    private static MobilePageAdminPanelPagePartDefinition m7027b(InjectorLike injectorLike) {
        return new MobilePageAdminPanelPagePartDefinition(DefaultFeedUnitRenderer.a(injectorLike), PageContextItemsFallbackHandler.b(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), NewsFeedAnalyticsEventBuilder.a(injectorLike), (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(injectorLike), IdBasedProvider.a(injectorLike, 4442), (ComposerLauncher) ComposerLauncherImpl.a(injectorLike), (DefaultPageSurfaceIntentBuilder) FbAndroidPageSurfaceIntentBuilder.b(injectorLike), ViewerContextManagerProvider.b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike));
    }

    public final void m7033b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        State state = (State) obj2;
        MobilePageAdminPanelBodyView mobilePageAdminPanelBodyView = (MobilePageAdminPanelBodyView) view;
        mobilePageAdminPanelBodyView.a(null, false);
        mobilePageAdminPanelBodyView.setHeaderOnClickListener(null);
        if (state.b) {
            mobilePageAdminPanelBodyView.a(null, null, null);
        }
    }

    public static MobilePageAdminPanelPagePartDefinition m7023a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MobilePageAdminPanelPagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6618n) {
                MobilePageAdminPanelPagePartDefinition mobilePageAdminPanelPagePartDefinition;
                if (a2 != null) {
                    mobilePageAdminPanelPagePartDefinition = (MobilePageAdminPanelPagePartDefinition) a2.a(f6618n);
                } else {
                    mobilePageAdminPanelPagePartDefinition = f6617m;
                }
                if (mobilePageAdminPanelPagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7027b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6618n, b3);
                        } else {
                            f6617m = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = mobilePageAdminPanelPagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public MobilePageAdminPanelPagePartDefinition(DefaultFeedUnitRenderer defaultFeedUnitRenderer, PageContextItemsFallbackHandler pageContextItemsFallbackHandler, AnalyticsLogger analyticsLogger, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, IFeedIntentBuilder iFeedIntentBuilder, Provider<String> provider, ComposerLauncher composerLauncher, IPageIdentityIntentBuilder iPageIdentityIntentBuilder, ViewerContextManager viewerContextManager, SecureContextHelper secureContextHelper, UriIntentMapper uriIntentMapper) {
        this.f6619b = defaultFeedUnitRenderer;
        this.f6620c = pageContextItemsFallbackHandler;
        this.f6621d = analyticsLogger;
        this.f6622e = newsFeedAnalyticsEventBuilder;
        this.f6623f = iFeedIntentBuilder;
        this.f6624g = provider;
        this.f6625h = composerLauncher;
        this.f6626i = iPageIdentityIntentBuilder;
        this.f6627j = viewerContextManager;
        this.f6628k = secureContextHelper;
        this.f6629l = uriIntentMapper;
    }

    public final ViewType<MobilePageAdminPanelBodyView> m7030a() {
        return f6616a;
    }

    private State m7022a(Props props) {
        int i;
        GraphQLMobilePageAdminPanelFeedUnitItem graphQLMobilePageAdminPanelFeedUnitItem = props.b;
        long j = 0;
        Uri uri = null;
        Uri uri2 = null;
        String str = null;
        boolean z = false;
        String str2 = null;
        PointF pointF = null;
        AymtData aymtData = null;
        if (!(graphQLMobilePageAdminPanelFeedUnitItem.o() == null || graphQLMobilePageAdminPanelFeedUnitItem.o().M() == null || graphQLMobilePageAdminPanelFeedUnitItem.o().M().j() == null || graphQLMobilePageAdminPanelFeedUnitItem.o().M().j().Q() == null)) {
            uri = ImageUtil.a(graphQLMobilePageAdminPanelFeedUnitItem.o().M().j().Q());
            GraphQLVect2 a = graphQLMobilePageAdminPanelFeedUnitItem.o().M().a();
            if (a != null) {
                PointF pointF2 = new PointF((float) a.a(), (float) a.b());
            }
        }
        if (!(graphQLMobilePageAdminPanelFeedUnitItem.o() == null || graphQLMobilePageAdminPanelFeedUnitItem.o().bs() == null)) {
            uri2 = ImageUtil.a(graphQLMobilePageAdminPanelFeedUnitItem.o().bs());
        }
        if (graphQLMobilePageAdminPanelFeedUnitItem.o() != null) {
            j = Long.parseLong(graphQLMobilePageAdminPanelFeedUnitItem.o().ae());
            str = graphQLMobilePageAdminPanelFeedUnitItem.o().aG();
            StringBuilder stringBuilder = new StringBuilder();
            ImmutableList F = graphQLMobilePageAdminPanelFeedUnitItem.o().F();
            if (!(F == null || F.isEmpty())) {
                stringBuilder.append((String) F.get(0));
                for (i = 1; i < F.size(); i++) {
                    stringBuilder.append(" · ").append((String) F.get(i));
                }
            }
            str2 = stringBuilder.toString();
        }
        if (graphQLMobilePageAdminPanelFeedUnitItem.m() != null) {
            ImmutableList k = graphQLMobilePageAdminPanelFeedUnitItem.m().k();
            if (!(k.isEmpty() || k.get(0) == null || ((GraphQLAYMTTip) k.get(0)).j() == null || ((GraphQLAYMTTip) k.get(0)).l() == null || (((GraphQLAYMTTip) k.get(0)).k() == null && ((GraphQLAYMTTip) k.get(0)).n() == null))) {
                z = true;
                aymtData = new AymtData(((GraphQLAYMTTip) k.get(0)).j(), ((GraphQLAYMTTip) k.get(0)).n(), ((GraphQLAYMTTip) k.get(0)).l(), ((GraphQLAYMTTip) k.get(0)).k());
            }
        }
        Builder builder = ImmutableList.builder();
        i = 0;
        while (i < graphQLMobilePageAdminPanelFeedUnitItem.n().size() && i < 3) {
            GraphQLEntityCardContextItem graphQLEntityCardContextItem = (GraphQLEntityCardContextItem) graphQLMobilePageAdminPanelFeedUnitItem.n().get(i);
            builder.c(Tuple.a(graphQLEntityCardContextItem, new 2(this, props, graphQLMobilePageAdminPanelFeedUnitItem, graphQLEntityCardContextItem)));
            i++;
        }
        ImmutableList b = builder.b();
        3 3 = new 3(this, props, graphQLMobilePageAdminPanelFeedUnitItem);
        StringBuilder stringBuilder2 = new StringBuilder();
        if (graphQLMobilePageAdminPanelFeedUnitItem.o() != null) {
            int aJ = graphQLMobilePageAdminPanelFeedUnitItem.o().aJ();
            if (aJ != 0) {
                if (aJ > 20) {
                    stringBuilder2.append(Integer.toString(20));
                    stringBuilder2.append("+");
                } else {
                    stringBuilder2.append(Integer.toString(aJ));
                }
            }
        }
        return new State(aymtData, z, j, str, str2, uri, uri2, stringBuilder2, 3, pointF, b);
    }

    private void m7024a(Props props, State state, MobilePageAdminPanelBodyView mobilePageAdminPanelBodyView) {
        GraphQLMobilePageAdminPanelFeedUnitItem graphQLMobilePageAdminPanelFeedUnitItem = props.b;
        mobilePageAdminPanelBodyView.setHeaderOnClickListener(state.i);
        mobilePageAdminPanelBodyView.c.a(state.d, state.j);
        mobilePageAdminPanelBodyView.c.setProfilePhoto(state.e);
        mobilePageAdminPanelBodyView.c.a(state.f, state.h);
        mobilePageAdminPanelBodyView.c.setBadgeCount(state.g.toString());
        mobilePageAdminPanelBodyView.a(state.k, !state.b);
        if (state.b && state.a != null) {
            boolean z;
            if (props.a.l().size() == 1) {
                z = true;
            } else {
                z = false;
            }
            mobilePageAdminPanelBodyView.a(state.a.a, state.a.c, m7021a(state.c, state.f, state.e.toString(), state.a, GraphQLHelper.a(graphQLMobilePageAdminPanelFeedUnitItem, props.a), z));
        }
    }

    private void m7026a(JsonNode jsonNode, long j, long j2, boolean z) {
        this.f6621d.a(NewsFeedAnalyticsEventBuilder.b(jsonNode, j, j2, z));
    }

    private void m7029b(JsonNode jsonNode, long j, long j2, boolean z) {
        this.f6621d.a(NewsFeedAnalyticsEventBuilder.a(jsonNode, j, j2, z));
    }

    private OnClickListener m7021a(long j, String str, String str2, AymtData aymtData, JsonNode jsonNode, boolean z) {
        return new AymtTipActionButtonOnclickListener(this, Long.parseLong((String) this.f6624g.get()), j, str, str2, z, aymtData.a, aymtData.b, aymtData.d, jsonNode);
    }
}
