package com.facebook.goodwill.feed.rows;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.feedplugins.base.footer.OneButtonFooterStylerPartDefinition;
import com.facebook.feedplugins.base.footer.ui.OneButtonFooterView;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackFriendListEdge;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackFriendversaryStory;
import com.facebook.graphql.model.GraphQLUser;
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
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.ResourceIdTextPartDefinition;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fb_link_url */
public class ThrowbackFriendversaryFooterPartDefinition extends MultiRowSinglePartDefinition<GraphQLGoodwillThrowbackFriendversaryStory, Void, HasPositionInformation, OneButtonFooterView> {
    private static ThrowbackFriendversaryFooterPartDefinition f13684f;
    private static final Object f13685g = new Object();
    public final SecureContextHelper f13686a;
    private final OneButtonFooterStylerPartDefinition f13687b;
    private final ResourceIdTextPartDefinition f13688c;
    private final ClickListenerPartDefinition f13689d;
    private final BackgroundPartDefinition f13690e;

    private static ThrowbackFriendversaryFooterPartDefinition m15385b(InjectorLike injectorLike) {
        return new ThrowbackFriendversaryFooterPartDefinition((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), OneButtonFooterStylerPartDefinition.a(injectorLike), ResourceIdTextPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m15387a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLGoodwillThrowbackFriendversaryStory graphQLGoodwillThrowbackFriendversaryStory = (GraphQLGoodwillThrowbackFriendversaryStory) obj;
        ImmutableList a = graphQLGoodwillThrowbackFriendversaryStory.l().a();
        Collection arrayList = new ArrayList();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            GraphQLGoodwillThrowbackFriendListEdge graphQLGoodwillThrowbackFriendListEdge = (GraphQLGoodwillThrowbackFriendListEdge) a.get(i);
            if (graphQLGoodwillThrowbackFriendListEdge.a() != null) {
                String str;
                GraphQLUser a2 = graphQLGoodwillThrowbackFriendListEdge.a();
                String P = a2.P();
                if (a2.aI() == null) {
                    str = null;
                } else {
                    str = a2.aI().b();
                }
                arrayList.add(new ThrowbackFriend(P, str, a2.ar(), m15384a(a2)));
            }
        }
        final ThrowbackFriendList throwbackFriendList = new ThrowbackFriendList(ImmutableList.copyOf(arrayList));
        subParts.a(this.f13687b, null);
        subParts.a(2131559974, this.f13688c, Integer.valueOf(2131239656));
        subParts.a(this.f13689d, new OnClickListener(this) {
            final /* synthetic */ ThrowbackFriendversaryFooterPartDefinition f13683b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1452653178);
                this.f13683b.f13686a.a(ThrowbackFriendsActivity.m15332a(view.getContext(), throwbackFriendList), view.getContext());
                Logger.a(2, EntryType.UI_INPUT_END, 1159443908, a);
            }
        });
        if ("redesign_v1".equals(graphQLGoodwillThrowbackFriendversaryStory.n())) {
            Builder c = Builder.c();
            c.d = -11.0f;
            c = c;
            c.b = -10.0f;
            c = c;
            c.c = -10.0f;
            subParts.a(this.f13690e, new StylingData(FeedProps.c(graphQLGoodwillThrowbackFriendversaryStory), c.i()));
        }
        return null;
    }

    public final boolean m15388a(Object obj) {
        return ((GraphQLGoodwillThrowbackFriendversaryStory) obj).l().a().size() > 3;
    }

    @Inject
    public ThrowbackFriendversaryFooterPartDefinition(SecureContextHelper secureContextHelper, OneButtonFooterStylerPartDefinition oneButtonFooterStylerPartDefinition, ResourceIdTextPartDefinition resourceIdTextPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, BackgroundPartDefinition backgroundPartDefinition) {
        this.f13687b = oneButtonFooterStylerPartDefinition;
        this.f13688c = resourceIdTextPartDefinition;
        this.f13686a = secureContextHelper;
        this.f13689d = clickListenerPartDefinition;
        this.f13690e = backgroundPartDefinition;
    }

    public static ThrowbackFriendversaryFooterPartDefinition m15383a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackFriendversaryFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f13685g) {
                ThrowbackFriendversaryFooterPartDefinition throwbackFriendversaryFooterPartDefinition;
                if (a2 != null) {
                    throwbackFriendversaryFooterPartDefinition = (ThrowbackFriendversaryFooterPartDefinition) a2.a(f13685g);
                } else {
                    throwbackFriendversaryFooterPartDefinition = f13684f;
                }
                if (throwbackFriendversaryFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m15385b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f13685g, b3);
                        } else {
                            f13684f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackFriendversaryFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m15386a() {
        return OneButtonFooterView.a;
    }

    private static String m15384a(GraphQLUser graphQLUser) {
        return graphQLUser.o() == null ? null : graphQLUser.o().a();
    }
}
