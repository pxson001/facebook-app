package com.facebook.feedplugins.links;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.facebook.attachments.angora.AngoraAttachmentView;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feedplugins.attachments.linkshare.follow.FollowAuthorUtil;
import com.facebook.feedplugins.attachments.linkshare.follow.FollowShareAttachmentKey;
import com.facebook.feedplugins.attachments.linkshare.follow.FollowShareAttachmentPersistentState;
import com.facebook.feedplugins.attachments.linkshare.offlinesave.OfflineAttachmentSaveFooterKey;
import com.facebook.feedplugins.attachments.linkshare.offlinesave.OfflineAttachmentSaveFooterPersistentState;
import com.facebook.fig.attachment.FIGAttachmentView;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.instantshopping.fetcher.InstantShoppingDocumentFetcher.PrefetchMonitor;
import com.facebook.instantshopping.links.InstantShoppingLinkHandler;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetch_type */
public class DefaultAttachmentLinkPartDefinition<E extends HasInvalidate & HasPersistentState> extends BaseSinglePartDefinition<Props, State, E, View> {
    private static DefaultAttachmentLinkPartDefinition f23846e;
    private static final Object f23847f = new Object();
    private final InstantShoppingLinkHandler f23848a;
    private final ArticlePrefetchingPartDefinition f23849b;
    private final BrowserPrefetchPartDefinition f23850c;
    public final DefaultAttachmentLinkClickHandler f23851d;

    private static DefaultAttachmentLinkPartDefinition m32239b(InjectorLike injectorLike) {
        return new DefaultAttachmentLinkPartDefinition(InstantShoppingLinkHandler.m32244b(injectorLike), ArticlePrefetchingPartDefinition.m32246a(injectorLike), BrowserPrefetchPartDefinition.m32279a(injectorLike), DefaultAttachmentLinkClickHandler.m32288a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        HasInvalidate hasInvalidate = (HasInvalidate) anyEnvironment;
        subParts.mo2756a(this.f23849b, props.a.f13444a);
        subParts.mo2756a(this.f23850c, props);
        boolean a = FollowAuthorUtil.a((GraphQLStoryAttachment) props.a.f13444a);
        return new State(new 1(this, props, a ? (FollowShareAttachmentPersistentState) ((HasPersistentState) hasInvalidate).mo2424a(new FollowShareAttachmentKey(props.a)) : null, (OfflineAttachmentSaveFooterPersistentState) ((HasPersistentState) hasInvalidate).mo2425a(new OfflineAttachmentSaveFooterKey(props.a), AttachmentProps.m28714c(props.a)), a, hasInvalidate));
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1642484119);
        m32237a((Props) obj, (State) obj2, view);
        Logger.a(8, EntryType.MARK_POP, 1553175331, a);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        View b = m32238b((Props) obj, view);
        if (b != null) {
            b.setOnClickListener(null);
        }
        InstantShoppingLinkHandler instantShoppingLinkHandler = this.f23848a;
        if (instantShoppingLinkHandler.f23853b != null) {
            PrefetchMonitor prefetchMonitor = instantShoppingLinkHandler.f23853b;
            if (prefetchMonitor.b != null) {
                prefetchMonitor.b.mo2782g();
            }
            if (prefetchMonitor.d != null) {
                prefetchMonitor.a.e.m32267c(prefetchMonitor.d.m());
            }
            instantShoppingLinkHandler.f23853b = null;
        }
    }

    public static DefaultAttachmentLinkPartDefinition m32236a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DefaultAttachmentLinkPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f23847f) {
                DefaultAttachmentLinkPartDefinition defaultAttachmentLinkPartDefinition;
                if (a2 != null) {
                    defaultAttachmentLinkPartDefinition = (DefaultAttachmentLinkPartDefinition) a2.mo818a(f23847f);
                } else {
                    defaultAttachmentLinkPartDefinition = f23846e;
                }
                if (defaultAttachmentLinkPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32239b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f23847f, b3);
                        } else {
                            f23846e = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = defaultAttachmentLinkPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public DefaultAttachmentLinkPartDefinition(InstantShoppingLinkHandler instantShoppingLinkHandler, ArticlePrefetchingPartDefinition articlePrefetchingPartDefinition, BrowserPrefetchPartDefinition browserPrefetchPartDefinition, DefaultAttachmentLinkClickHandler defaultAttachmentLinkClickHandler) {
        this.f23848a = instantShoppingLinkHandler;
        this.f23849b = articlePrefetchingPartDefinition;
        this.f23850c = browserPrefetchPartDefinition;
        this.f23851d = defaultAttachmentLinkClickHandler;
    }

    private void m32237a(Props props, State state, View view) {
        if (view != null) {
            View b = m32238b(props, view);
            if (b != null) {
                b.setOnClickListener(state.a);
            }
            this.f23848a.m32245a(view.getContext(), props.d);
            if (props.d != null && FacebookUriUtil.m20916a(Uri.parse(props.d))) {
                if (view instanceof FIGAttachmentView) {
                    ((FIGAttachmentView) view).n = true;
                } else if (view instanceof AngoraAttachmentView) {
                    ((AngoraAttachmentView) view).h = true;
                }
            }
        }
    }

    private static View m32238b(Props props, View view) {
        return props.c.mo3509a(view);
    }
}
