package com.facebook.feedplugins.prompts;

import android.content.Context;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feedplugins.prompts.graphql.ProductionPromptShareMutationsModels;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: SLIDE_IN_BOTTOM */
public class SocialPromptFeedActionHandler {
    public static final String f23766a = SocialPromptFeedActionHandler.class.getSimpleName();
    private static SocialPromptFeedActionHandler f23767i;
    private static final Object f23768j = new Object();
    public final SecureContextHelper f23769b;
    public final UriIntentMapper f23770c;
    public final Provider<String> f23771d;
    public final TasksManager f23772e;
    public final GraphQLQueryExecutor f23773f;
    public final Toaster f23774g;
    public final AbstractFbErrorReporter f23775h;

    /* compiled from: SLIDE_IN_BOTTOM */
    public class C20511 extends AbstractDisposableFutureCallback<GraphQLResult<ProductionPromptShareMutationsModels>> {
        final /* synthetic */ PromptFriendSelectorFragment f23764a;
        final /* synthetic */ SocialPromptFeedActionHandler f23765b;

        public C20511(SocialPromptFeedActionHandler socialPromptFeedActionHandler, PromptFriendSelectorFragment promptFriendSelectorFragment) {
            this.f23765b = socialPromptFeedActionHandler;
            this.f23764a = promptFriendSelectorFragment;
        }

        protected final void m25919a(Object obj) {
            this.f23765b.f23774g.a(new ToastBuilder(this.f23764a.getContext().getResources().getString(2131239239)));
            this.f23764a.aI();
        }

        protected final void m25920a(Throwable th) {
            this.f23765b.f23774g.a(new ToastBuilder(this.f23764a.getContext().getResources().getString(2131230761)));
            this.f23765b.f23775h.a(SocialPromptFeedActionHandler.f23766a, "Social Prompt invite friends GraphQL mutation failed");
        }
    }

    private static SocialPromptFeedActionHandler m25922b(InjectorLike injectorLike) {
        return new SocialPromptFeedActionHandler((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike), Toaster.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 4442));
    }

    @Inject
    public SocialPromptFeedActionHandler(SecureContextHelper secureContextHelper, UriIntentMapper uriIntentMapper, GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, Toaster toaster, FbErrorReporter fbErrorReporter, Provider<String> provider) {
        this.f23769b = secureContextHelper;
        this.f23770c = uriIntentMapper;
        this.f23773f = graphQLQueryExecutor;
        this.f23772e = tasksManager;
        this.f23774g = toaster;
        this.f23775h = fbErrorReporter;
        this.f23771d = provider;
    }

    public static SocialPromptFeedActionHandler m25921a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SocialPromptFeedActionHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23768j) {
                SocialPromptFeedActionHandler socialPromptFeedActionHandler;
                if (a2 != null) {
                    socialPromptFeedActionHandler = (SocialPromptFeedActionHandler) a2.a(f23768j);
                } else {
                    socialPromptFeedActionHandler = f23767i;
                }
                if (socialPromptFeedActionHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25922b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23768j, b3);
                        } else {
                            f23767i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = socialPromptFeedActionHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
