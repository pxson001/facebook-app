package com.facebook.feedplugins.base.footer.ui;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feedplugins.base.NetEgoStoryFooterButtonClickLoggingHandler;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StorySharingHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.widget.springbutton.TouchSpring;
import java.util.EnumMap;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: has_three_photos */
public class BasicFooterPartDefinition<E extends HasFeedListType & HasPersistentState, V extends View & Footer> extends BaseSinglePartDefinition<Props, State, E, V> {
    private static BasicFooterPartDefinition f21254e;
    private static final Object f21255f = new Object();
    private final Provider<TouchSpring> f21256a;
    private final CommentCacheStateUtil f21257b;
    public final BasicFooterClickHandler f21258c;
    public final Lazy<NetEgoStoryFooterButtonClickLoggingHandler> f21259d;

    private static BasicFooterPartDefinition m28976b(InjectorLike injectorLike) {
        return new BasicFooterPartDefinition(IdBasedProvider.m1811a(injectorLike, 3736), CommentCacheStateUtil.m28981b(injectorLike), BasicFooterClickHandler.m28983a(injectorLike), IdBasedLazy.m1808a(injectorLike, 6193));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        HasFeedListType hasFeedListType = (HasFeedListType) anyEnvironment;
        EnumMap a = FooterBinderUtil.m30294a((HasPersistentState) hasFeedListType, (GraphQLStory) props.a.f13444a, hasFeedListType.mo2446c());
        FooterBinderUtil.m30300a(((GraphQLStory) props.a.f13444a).m22369z(), ((GraphQLStory) props.a.f13444a).m22315A(), StorySharingHelper.m30305b((GraphQLStory) props.a.f13444a), a, this.f21256a);
        return new State(new 1(this, props.a, props.b, hasFeedListType.mo2446c()), a);
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1586318167);
        m28975a((Props) obj, (State) obj2, view);
        Logger.a(8, EntryType.MARK_POP, -1327198741, a);
    }

    public static BasicFooterPartDefinition m28974a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BasicFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f21255f) {
                BasicFooterPartDefinition basicFooterPartDefinition;
                if (a2 != null) {
                    basicFooterPartDefinition = (BasicFooterPartDefinition) a2.mo818a(f21255f);
                } else {
                    basicFooterPartDefinition = f21254e;
                }
                if (basicFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28976b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f21255f, b3);
                        } else {
                            f21254e = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = basicFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public BasicFooterPartDefinition(Provider<TouchSpring> provider, CommentCacheStateUtil commentCacheStateUtil, BasicFooterClickHandler basicFooterClickHandler, Lazy<NetEgoStoryFooterButtonClickLoggingHandler> lazy) {
        this.f21256a = provider;
        this.f21257b = commentCacheStateUtil;
        this.f21258c = basicFooterClickHandler;
        this.f21259d = lazy;
    }

    private void m28975a(Props props, State state, V v) {
        FooterBinderUtil.m30298a((Footer) v, state.b, ((GraphQLStory) props.a.f13444a).mo2890l(), state.a);
        this.f21257b.m28982a((Footer) v, (GraphQLStory) props.a.f13444a);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((Footer) view).mo3251a();
    }
}
