package com.facebook.attachments.angora.actionbutton;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.facebook.attachments.angora.AttachmentHasButton;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.SparseArrayUtil;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentView;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.enums.GraphQLCallToActionType;
import com.facebook.graphql.enums.GraphQLStoryActionLinkDestinationType;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SinglePartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetch_pinned_threads */
public class AngoraActionButtonController {
    public static final AngoraActionButton f23964a = new EmptyActionButton();
    private static AngoraActionButtonController f23965f;
    private static final Object f23966g = new Object();
    private final SparseArray<Lazy<? extends AngoraActionButton>> f23967b = new SparseArray(7);
    private final int[] f23968c;
    private final Lazy<AppOpenActionButton> f23969d;
    private final Lazy<ShareActionButton> f23970e;

    /* compiled from: fetch_pinned_threads */
    class EmptyActionButton<E extends AnyEnvironment> implements AngoraActionButton<E> {
        private final BaseSinglePartDefinition f23971a = new C09761(this);

        /* compiled from: fetch_pinned_threads */
        class C09761 extends BaseSinglePartDefinition {
            final /* synthetic */ EmptyActionButton f23972a;

            C09761(EmptyActionButton emptyActionButton) {
                this.f23972a = emptyActionButton;
            }
        }

        public final <V extends View & AttachmentHasButton> SinglePartDefinition<FeedProps<GraphQLStoryAttachment>, ?, E, V> mo3513a() {
            return this.f23971a;
        }

        public final Component mo3512a(ComponentContext componentContext, E e, FeedProps<GraphQLStoryAttachment> feedProps) {
            return null;
        }

        public final SinglePartDefinition<FeedProps<GraphQLStoryAttachment>, ?, E, ComponentView> mo3514b() {
            return null;
        }
    }

    private static AngoraActionButtonController m32350b(InjectorLike injectorLike) {
        return new AngoraActionButtonController(IdBasedLazy.m1808a(injectorLike, 322), IdBasedLazy.m1808a(injectorLike, 4881), IdBasedLazy.m1808a(injectorLike, 319), IdBasedLazy.m1808a(injectorLike, 320), IdBasedLazy.m1808a(injectorLike, 4882), IdBasedLazy.m1808a(injectorLike, 4886), IdBasedLazy.m1808a(injectorLike, 4884), IdBasedLazy.m1808a(injectorLike, 4888), IdBasedLazy.m1808a(injectorLike, 4883));
    }

    @Inject
    public AngoraActionButtonController(Lazy<ShareActionButton> lazy, Lazy<AddFriendActionButton> lazy2, Lazy<LikePageActionButton> lazy3, Lazy<LinkOpenActionButton> lazy4, Lazy<AppOpenActionButton> lazy5, Lazy<LeadGenActionButton> lazy6, Lazy<CollectionSaveActionButton> lazy7, Lazy<MessagePageActionButton> lazy8, Lazy<ClaimCouponActionButton> lazy9) {
        this.f23970e = lazy;
        this.f23967b.put(1337291567, lazy2);
        this.f23967b.put(-581184810, lazy3);
        this.f23967b.put(-508788748, lazy4);
        this.f23967b.put(1185006756, lazy6);
        this.f23967b.put(-908457779, lazy7);
        this.f23967b.put(1415852806, lazy8);
        this.f23967b.put(-314375316, lazy9);
        this.f23968c = SparseArrayUtil.m32359a(this.f23967b);
        this.f23969d = lazy5;
    }

    public static AngoraActionButtonController m32349a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AngoraActionButtonController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f23966g) {
                AngoraActionButtonController angoraActionButtonController;
                if (a2 != null) {
                    angoraActionButtonController = (AngoraActionButtonController) a2.mo818a(f23966g);
                } else {
                    angoraActionButtonController = f23965f;
                }
                if (angoraActionButtonController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32350b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f23966g, b3);
                        } else {
                            f23965f = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = angoraActionButtonController;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final AngoraActionButton m32351a(FeedProps<GraphQLStoryAttachment> feedProps) {
        if (((ShareActionButton) this.f23970e.get()).a(feedProps)) {
            return (AngoraActionButton) this.f23970e.get();
        }
        GraphQLStoryActionLink a = ActionLinkHelper.m22937a((GraphQLStoryAttachment) feedProps.f13444a, this.f23968c);
        if (a == null || a.m22901a() == null) {
            return f23964a;
        }
        if (a.m22901a().m22301g() == -508788748 && GraphQLCallToActionType.NO_BUTTON.equals(a.m22896W())) {
            return f23964a;
        }
        if (a.m22901a().m22301g() == -508788748 && (a.m22916u() == GraphQLStoryActionLinkDestinationType.APP || a.m22916u() == GraphQLStoryActionLinkDestinationType.APP_WITH_PRODUCT)) {
            return (AngoraActionButton) this.f23969d.get();
        }
        return (AngoraActionButton) ((Lazy) this.f23967b.get(a.m22901a().m22301g())).get();
    }

    public final boolean m32352b(FeedProps<GraphQLStoryAttachment> feedProps) {
        return ActionLinkHelper.m22937a((GraphQLStoryAttachment) feedProps.f13444a, this.f23968c) != null || ((ShareActionButton) this.f23970e.get()).a(feedProps);
    }
}
