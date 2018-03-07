package com.facebook.pages.common.reaction.components;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.pages.common.services.PagesServiceCarousel;
import com.facebook.pages.common.services.PagesServiceCarousel.PagesServiceCarouselItemClickListener;
import com.facebook.pages.common.services.PagesServiceUtils;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQLInterfaces.PageServiceItem;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQLModels.PageServiceItemModel;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: selling_unseen */
public class PagesFeaturedServiceItemsUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, PagesServiceCarousel> {
    public static final ViewType f2060a = new C02671();
    private static PagesFeaturedServiceItemsUnitComponentPartDefinition f2061c;
    private static final Object f2062d = new Object();
    private final ReactionIntentFactory f2063b;

    /* compiled from: selling_unseen */
    final class C02671 extends ViewType {
        C02671() {
        }

        public final View m3087a(Context context) {
            return new PagesServiceCarousel(context);
        }
    }

    /* compiled from: selling_unseen */
    public class State {
        public final List<PageServiceItem> f2058a;
        public final PagesServiceCarouselItemClickListener f2059b;

        public State(List<PageServiceItem> list, PagesServiceCarouselItemClickListener pagesServiceCarouselItemClickListener) {
            this.f2058a = list;
            this.f2059b = pagesServiceCarouselItemClickListener;
        }
    }

    private static PagesFeaturedServiceItemsUnitComponentPartDefinition m3093b(InjectorLike injectorLike) {
        return new PagesFeaturedServiceItemsUnitComponentPartDefinition(ReactionIntentFactory.a(injectorLike));
    }

    public final Object m3095a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        final CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.b;
        final String b = reactionUnitComponentFields.bI().b();
        return new State(ImmutableList.copyOf(reactionUnitComponentFields.cx()), new PagesServiceCarouselItemClickListener(this) {
            final /* synthetic */ PagesFeaturedServiceItemsUnitComponentPartDefinition f2057d;

            public final void mo44a(PageServiceItemModel pageServiceItemModel) {
                this.f2057d.m3092a(reactionUnitComponentNode.c, reactionUnitComponentNode.d, canLaunchReactionIntent, b, pageServiceItemModel.d());
            }
        });
    }

    public final /* bridge */ /* synthetic */ void m3096a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -940743551);
        State state = (State) obj2;
        ((PagesServiceCarousel) view).m3292a(state.f2058a, state.f2059b);
        Logger.a(8, EntryType.MARK_POP, -765919183, a);
    }

    public final boolean m3097a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).b;
        if (!(reactionUnitComponentFields.cx().isEmpty() || reactionUnitComponentFields.bI() == null || StringUtil.a(reactionUnitComponentFields.bI().b()))) {
            Object obj2;
            for (PageServiceItemModel a : ImmutableList.copyOf(reactionUnitComponentFields.cx())) {
                if (PagesServiceUtils.m3305a(a) != null) {
                    obj2 = 1;
                    break;
                }
            }
            obj2 = null;
            if (obj2 != null) {
                return true;
            }
        }
        return false;
    }

    public final void m3098b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        PagesServiceCarousel pagesServiceCarousel = (PagesServiceCarousel) view;
        if (pagesServiceCarousel.f2325b != null) {
            pagesServiceCarousel.f2325b.m3297a(null);
            pagesServiceCarousel.f2325b.f2338b = null;
        }
    }

    public final ViewType m3094a() {
        return f2060a;
    }

    public static PagesFeaturedServiceItemsUnitComponentPartDefinition m3090a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PagesFeaturedServiceItemsUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2062d) {
                PagesFeaturedServiceItemsUnitComponentPartDefinition pagesFeaturedServiceItemsUnitComponentPartDefinition;
                if (a2 != null) {
                    pagesFeaturedServiceItemsUnitComponentPartDefinition = (PagesFeaturedServiceItemsUnitComponentPartDefinition) a2.a(f2062d);
                } else {
                    pagesFeaturedServiceItemsUnitComponentPartDefinition = f2061c;
                }
                if (pagesFeaturedServiceItemsUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m3093b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2062d, b3);
                        } else {
                            f2061c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pagesFeaturedServiceItemsUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PagesFeaturedServiceItemsUnitComponentPartDefinition(ReactionIntentFactory reactionIntentFactory) {
        this.f2063b = reactionIntentFactory;
    }

    private void m3092a(String str, String str2, E e, String str3, String str4) {
        e.a(str, str2, this.f2063b.l(((HasContext) e).getContext(), str3, str4));
    }
}
