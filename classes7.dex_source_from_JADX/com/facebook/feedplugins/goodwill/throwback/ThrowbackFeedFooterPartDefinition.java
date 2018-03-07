package com.facebook.feedplugins.goodwill.throwback;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.base.footer.OneButtonFooterStylerPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StorySharingHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Stop failed. */
public class ThrowbackFeedFooterPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, HasPositionInformation, ThrowbackFooterShareButtonView> {
    private static ThrowbackFeedFooterPartDefinition f23136d;
    private static final Object f23137e = new Object();
    private final OneButtonFooterStylerPartDefinition f23138a;
    private final ClickListenerPartDefinition f23139b;
    private final ThrowbackShareComposerLauncherProvider f23140c;

    private static ThrowbackFeedFooterPartDefinition m25563b(InjectorLike injectorLike) {
        return new ThrowbackFeedFooterPartDefinition(OneButtonFooterStylerPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), (ThrowbackShareComposerLauncherProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ThrowbackShareComposerLauncherProvider.class));
    }

    public final Object m25565a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ThrowbackShareComposerLauncher a = this.f23140c.m25570a((FeedProps) obj, ComposerSourceType.ON_THIS_DAY_FEED, "goodwill_throwback_permalink_ufi");
        subParts.a(this.f23138a, null);
        subParts.a(this.f23139b, a);
        return null;
    }

    public final /* bridge */ /* synthetic */ void m25566a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1675889075);
        ThrowbackFooterShareButtonView throwbackFooterShareButtonView = (ThrowbackFooterShareButtonView) view;
        throwbackFooterShareButtonView.f23143c.setVisibility(null != null ? 0 : 8);
        throwbackFooterShareButtonView.f23144d.setVisibility(1 != 0 ? 0 : 8);
        Logger.a(8, EntryType.MARK_POP, -416949727, a);
    }

    public final boolean m25567a(Object obj) {
        return StorySharingHelper.b((GraphQLStory) ((FeedProps) obj).a);
    }

    @Inject
    public ThrowbackFeedFooterPartDefinition(OneButtonFooterStylerPartDefinition oneButtonFooterStylerPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, ThrowbackShareComposerLauncherProvider throwbackShareComposerLauncherProvider) {
        this.f23138a = oneButtonFooterStylerPartDefinition;
        this.f23139b = clickListenerPartDefinition;
        this.f23140c = throwbackShareComposerLauncherProvider;
    }

    public final ViewType m25564a() {
        return ThrowbackFooterShareButtonView.f23141a;
    }

    public static ThrowbackFeedFooterPartDefinition m25562a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackFeedFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23137e) {
                ThrowbackFeedFooterPartDefinition throwbackFeedFooterPartDefinition;
                if (a2 != null) {
                    throwbackFeedFooterPartDefinition = (ThrowbackFeedFooterPartDefinition) a2.a(f23137e);
                } else {
                    throwbackFeedFooterPartDefinition = f23136d;
                }
                if (throwbackFeedFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25563b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23137e, b3);
                        } else {
                            f23136d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackFeedFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
