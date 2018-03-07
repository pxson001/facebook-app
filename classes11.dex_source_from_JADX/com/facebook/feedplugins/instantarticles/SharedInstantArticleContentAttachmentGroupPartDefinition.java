package com.facebook.feedplugins.instantarticles;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.qe.api.QeAccessor;
import com.facebook.richdocument.abtest.ExperimentsForRichDocumentAbtestModule;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import javax.inject.Provider;

@ContextScoped
/* compiled from: contain */
public class SharedInstantArticleContentAttachmentGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStoryAttachment>, Void, FeedEnvironment> {
    private static SharedInstantArticleContentAttachmentGroupPartDefinition f7991f;
    private static final Object f7992g = new Object();
    @Inject
    public volatile Provider<GatekeeperStore> f7993a = UltralightRuntime.a;
    @Inject
    public volatile Provider<QeAccessor> f7994b = UltralightRuntime.a;
    private final InstantArticleAttachmentLabelPartDefinition<FeedEnvironment, ?> f7995c;
    private final InstantArticlePhotoAttachmentPartDefinition<FeedEnvironment, ?> f7996d;
    private final InstantArticlesVideoAttachmentPartDefinition<FeedEnvironment> f7997e;

    private static SharedInstantArticleContentAttachmentGroupPartDefinition m9067b(InjectorLike injectorLike) {
        SharedInstantArticleContentAttachmentGroupPartDefinition sharedInstantArticleContentAttachmentGroupPartDefinition = new SharedInstantArticleContentAttachmentGroupPartDefinition(InstantArticleAttachmentLabelPartDefinition.m9044a(injectorLike), InstantArticlePhotoAttachmentPartDefinition.m9052a(injectorLike), InstantArticlesVideoAttachmentPartDefinition.m9061a(injectorLike));
        Provider a = IdBasedSingletonScopeProvider.a(injectorLike, 2128);
        Provider a2 = IdBasedSingletonScopeProvider.a(injectorLike, 3219);
        sharedInstantArticleContentAttachmentGroupPartDefinition.f7993a = a;
        sharedInstantArticleContentAttachmentGroupPartDefinition.f7994b = a2;
        return sharedInstantArticleContentAttachmentGroupPartDefinition;
    }

    public final Object m9068a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f7996d, feedProps).a(this.f7997e, feedProps);
        baseMultiRowSubParts.a(this.f7995c, feedProps);
        return null;
    }

    public final boolean m9069a(Object obj) {
        GatekeeperStoreImpl gatekeeperStoreImpl = (GatekeeperStoreImpl) this.f7993a.get();
        return (gatekeeperStoreImpl.a(99, false) ? true : ((QeAccessor) this.f7994b.get()).a(ExperimentsForRichDocumentAbtestModule.f, false)) || gatekeeperStoreImpl.a(110, false);
    }

    @Inject
    private SharedInstantArticleContentAttachmentGroupPartDefinition(InstantArticleAttachmentLabelPartDefinition instantArticleAttachmentLabelPartDefinition, InstantArticlePhotoAttachmentPartDefinition instantArticlePhotoAttachmentPartDefinition, InstantArticlesVideoAttachmentPartDefinition instantArticlesVideoAttachmentPartDefinition) {
        this.f7995c = instantArticleAttachmentLabelPartDefinition;
        this.f7996d = instantArticlePhotoAttachmentPartDefinition;
        this.f7997e = instantArticlesVideoAttachmentPartDefinition;
    }

    public static SharedInstantArticleContentAttachmentGroupPartDefinition m9066a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SharedInstantArticleContentAttachmentGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7992g) {
                SharedInstantArticleContentAttachmentGroupPartDefinition sharedInstantArticleContentAttachmentGroupPartDefinition;
                if (a2 != null) {
                    sharedInstantArticleContentAttachmentGroupPartDefinition = (SharedInstantArticleContentAttachmentGroupPartDefinition) a2.a(f7992g);
                } else {
                    sharedInstantArticleContentAttachmentGroupPartDefinition = f7991f;
                }
                if (sharedInstantArticleContentAttachmentGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9067b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7992g, b3);
                        } else {
                            f7991f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = sharedInstantArticleContentAttachmentGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
