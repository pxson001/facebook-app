package com.facebook.feedplugins.links;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.view.View;
import com.facebook.browser.lite.BrowserLiteIntentServiceHelper.BrowserProcessWarmupRunnable;
import com.facebook.browser.prefetch.BrowserPrefetcher;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.common.util.TriState;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feedplugins.links.DefaultAttachmentLinkPartDefinition.Props;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLBrowserPrefetchType;
import com.facebook.graphql.model.GraphQLFeedbackContext;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.browser.prefs.BrowserPrefKey;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetch_sticky_guardrail */
public class BrowserPrefetchPartDefinition extends BaseSinglePartDefinition<Props, State, AnyEnvironment, View> {
    private static BrowserPrefetchPartDefinition f23892d;
    private static final Object f23893e = new Object();
    public final BrowserPrefetcher f23894a;
    public final GatekeeperStoreImpl f23895b;
    public final Handler f23896c = this.f23894a.f9324j;

    private static BrowserPrefetchPartDefinition m32282b(InjectorLike injectorLike) {
        return new BrowserPrefetchPartDefinition(BrowserPrefetcher.m14282a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        State state = new State();
        if (this.f23895b.m2185a(117) != TriState.NO) {
            state.b = new BrowserProcessWarmupRunnable();
        }
        m32280a(props, state);
        return state;
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1358901234);
        m32281a((Props) obj, (State) obj2, view);
        Logger.a(8, EntryType.MARK_POP, 1335958327, a);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        State state = (State) obj2;
        if (state.a != null) {
            HandlerDetour.a(this.f23896c, state.a);
        }
        if (state.b != null) {
            HandlerDetour.a(this.f23896c, state.b);
        }
    }

    @Inject
    public BrowserPrefetchPartDefinition(BrowserPrefetcher browserPrefetcher, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f23894a = browserPrefetcher;
        this.f23895b = gatekeeperStoreImpl;
    }

    public static BrowserPrefetchPartDefinition m32279a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BrowserPrefetchPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f23893e) {
                BrowserPrefetchPartDefinition browserPrefetchPartDefinition;
                if (a2 != null) {
                    browserPrefetchPartDefinition = (BrowserPrefetchPartDefinition) a2.mo818a(f23893e);
                } else {
                    browserPrefetchPartDefinition = f23892d;
                }
                if (browserPrefetchPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32282b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f23893e, b3);
                        } else {
                            f23892d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = browserPrefetchPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    private void m32281a(Props props, State state, View view) {
        if (view != null) {
            Context applicationContext = view.getContext().getApplicationContext();
            if (state.b != null) {
                state.b.a = applicationContext;
                HandlerDetour.b(this.f23896c, state.b, 2000, 1739875922);
            }
            m32283c(state);
        }
    }

    private void m32280a(Props props, State state) {
        Object obj;
        if (((GraphQLStoryAttachment) props.a.f13444a).m23987z() == null || ((GraphQLStoryAttachment) props.a.f13444a).m23987z().dB() == null) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null || !this.f23894a.m14298a() || this.f23894a.m14302c() == 1) {
            return;
        }
        if (!GraphQLStoryUtil.m9567a(AttachmentProps.m28715e(props.a)) || this.f23894a.m14304g()) {
            Uri parse = Uri.parse(props.d);
            if (parse != null && FacebookUriUtil.m20916a(parse)) {
                GraphQLStory a = AttachmentProps.m28712a(props.a);
                if (a != null) {
                    GraphQLFeedbackContext aa = a.aa();
                    if (aa != null) {
                        state.c = FacebookUriUtil.m20918b(parse);
                        if (state.c != null && this.f23894a.m14299a(state.c)) {
                            if (this.f23894a.f9323i.mo286a(BrowserPrefKey.f9370g, false)) {
                                state.d = 1;
                                state.e = 1;
                            } else {
                                state.d = (long) aa.m24206p();
                                state.e = (long) aa.m24202l();
                            }
                            if (state.d > 0 || state.e > 0) {
                                GraphQLBrowserPrefetchType graphQLBrowserPrefetchType;
                                this.f23894a.m14303d();
                                GraphQLStory a2 = AttachmentProps.m28712a(props.a);
                                if (a2 == null) {
                                    graphQLBrowserPrefetchType = GraphQLBrowserPrefetchType.HTML_ONLY;
                                } else {
                                    GraphQLFeedbackContext aa2 = a2.aa();
                                    graphQLBrowserPrefetchType = aa2 == null ? GraphQLBrowserPrefetchType.HTML_ONLY : aa2.m24201k();
                                }
                                state.a = new 1(this, state, graphQLBrowserPrefetchType);
                            }
                        }
                    }
                }
            }
        }
    }

    private void m32283c(State state) {
        if (state.a != null) {
            Object obj;
            BrowserPrefetcher browserPrefetcher = this.f23894a;
            if (browserPrefetcher.m14303d() || browserPrefetcher.m14302c() != 2) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                this.f23894a.m14300b(state.c.toString());
                long j = this.f23894a.m14303d() ? state.d : state.e;
                if (j > 0) {
                    HandlerDetour.b(this.f23896c, state.a, j, -929388414);
                }
            }
        }
    }
}
