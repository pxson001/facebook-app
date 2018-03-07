package com.facebook.feedplugins.base;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.analytics.StoryRenderContext;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.ui.FeedStoryMessageFlyoutClickWithPositionListener;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.ui.clickwithpositionlistener.ClickWithPositionListenerBinder;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: hy_AM */
public class TextLinkPartDefinition extends BaseSinglePartDefinition<FeedProps<GraphQLStory>, ClickWithPositionListenerBinder, AnyEnvironment, View> {
    private static TextLinkPartDefinition f20654c;
    private static final Object f20655d = new Object();
    private final Provider<Boolean> f20656a;
    private final Provider<FeedStoryMessageFlyoutClickWithPositionListener> f20657b;

    private static TextLinkPartDefinition m28403b(InjectorLike injectorLike) {
        return new TextLinkPartDefinition(IdBasedProvider.m1811a(injectorLike, 4008), IdBasedProvider.m1811a(injectorLike, 1733));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        if (!((Boolean) this.f20656a.get()).booleanValue()) {
            return null;
        }
        FeedStoryMessageFlyoutClickWithPositionListener feedStoryMessageFlyoutClickWithPositionListener = (FeedStoryMessageFlyoutClickWithPositionListener) this.f20657b.get();
        feedStoryMessageFlyoutClickWithPositionListener.m29433a(feedProps, StoryRenderContext.NEWSFEED);
        return new ClickWithPositionListenerBinder(feedStoryMessageFlyoutClickWithPositionListener);
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 211367786);
        ClickWithPositionListenerBinder clickWithPositionListenerBinder = (ClickWithPositionListenerBinder) obj2;
        if (clickWithPositionListenerBinder != null) {
            clickWithPositionListenerBinder.m29439a(view);
        }
        Logger.a(8, EntryType.MARK_POP, -1514034475, a);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        if (((ClickWithPositionListenerBinder) obj2) != null) {
            ClickWithPositionListenerBinder.m29438b(view);
        }
    }

    @Inject
    public TextLinkPartDefinition(Provider<Boolean> provider, Provider<FeedStoryMessageFlyoutClickWithPositionListener> provider2) {
        this.f20656a = provider;
        this.f20657b = provider2;
    }

    public static TextLinkPartDefinition m28402a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TextLinkPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20655d) {
                TextLinkPartDefinition textLinkPartDefinition;
                if (a2 != null) {
                    textLinkPartDefinition = (TextLinkPartDefinition) a2.mo818a(f20655d);
                } else {
                    textLinkPartDefinition = f20654c;
                }
                if (textLinkPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28403b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20655d, b3);
                        } else {
                            f20654c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = textLinkPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
