package com.facebook.attachments.angora.actionbutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.attachments.angora.AttachmentHasButton;
import com.facebook.attachments.angora.actionbutton.ActionButtonComponent.Builder;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.ui.animation.LikeIconPopAnimationHelper;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentView;
import com.facebook.components.glyph.GlyphColorizerDrawableReference;
import com.facebook.fbui.widget.text.GlyphWithTextView;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
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
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ufiservices.event.UfiEvents.PageLikeClickedEvent;
import javax.inject.Inject;

@ContextScoped
/* compiled from: notOnMessengerFriends */
public class LikePageActionButton<E extends AnyEnvironment> implements AngoraActionButton<E> {
    public static final String f6980a = LikePageActionButton.class.getSimpleName();
    private static LikePageActionButton f6981m;
    private static final Object f6982n = new Object();
    public final FeedEventBus f6983b;
    public final int f6984c = 2130840277;
    public final ColorStateList f6985d;
    public final String f6986e;
    public final String f6987f;
    public final AbstractFbErrorReporter f6988g;
    public final int f6989h;
    public final GatekeeperStoreImpl f6990i;
    private final SinglePartDefinition f6991j;
    private final ActionButtonComponent f6992k;
    private final GlyphColorizerDrawableReference f6993l;

    /* compiled from: notOnMessengerFriends */
    class LikePageActionButtonPartDefinition<V extends View & AttachmentHasButton> extends BaseSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, State, E, V> {
        final /* synthetic */ LikePageActionButton f6994a;

        public LikePageActionButtonPartDefinition(LikePageActionButton likePageActionButton) {
            this.f6994a = likePageActionButton;
        }

        public final Object m7284a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
            FeedProps feedProps = (FeedProps) obj;
            GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
            if (ActionLinkHelper.a(graphQLStoryAttachment).ab() == null) {
                return new State(null, false);
            }
            return new State(LikePageActionButton.m7277a(this.f6994a, feedProps), ActionLinkHelper.a(graphQLStoryAttachment).ab().O());
        }

        public final /* bridge */ /* synthetic */ void m7285a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
            int a = Logger.a(8, EntryType.MARK_PUSH, -1086393769);
            m7283a((FeedProps) obj, (State) obj2, view);
            Logger.a(8, EntryType.MARK_POP, -114747855, a);
        }

        private void m7283a(FeedProps<GraphQLStoryAttachment> feedProps, State state, V v) {
            GenericActionButtonView actionButton = ((AttachmentHasButton) v).getActionButton();
            if (ActionLinkHelper.a((GraphQLStoryAttachment) feedProps.a).ab() == null) {
                actionButton.setVisibility(8);
                this.f6994a.f6988g.a(LikePageActionButton.f6980a, "Attachment does not contain an action link with a page! Story ID is " + AttachmentProps.c(feedProps).c());
                return;
            }
            actionButton.setVisibility(0);
            actionButton.f13763g = true;
            actionButton.setButtonBackgroundResource(2130840230);
            actionButton.setPadding(this.f6994a.f6989h, 0, this.f6994a.f6989h, 0);
            GlyphWithTextView glyphWithTextView = ((AttachmentHasButton) v).getActionButton().f13757a;
            glyphWithTextView.setContentDescription(state.f6998b ? this.f6994a.f6987f : this.f6994a.f6986e);
            glyphWithTextView.setCompoundDrawablePadding(0);
            glyphWithTextView.setOnClickListener(state.f6997a);
            glyphWithTextView.setImageResource(this.f6994a.f6984c);
            glyphWithTextView.setSelected(state.f6998b);
            glyphWithTextView.setGlyphColor(this.f6994a.f6985d);
        }

        public final void m7286b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
            if (((AttachmentHasButton) view).getActionButton() != null) {
                ((AttachmentHasButton) view).getActionButton().m14490a();
            }
        }
    }

    /* compiled from: notOnMessengerFriends */
    public class State {
        public final OnClickListener f6997a;
        public final boolean f6998b;

        public State(OnClickListener onClickListener, boolean z) {
            this.f6997a = onClickListener;
            this.f6998b = z;
        }
    }

    private static LikePageActionButton m7279b(InjectorLike injectorLike) {
        return new LikePageActionButton(FeedEventBus.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), ActionButtonComponent.m7576a(injectorLike), GlyphColorizerDrawableReference.a(injectorLike));
    }

    public static LikePageActionButton m7278a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LikePageActionButton b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6982n) {
                LikePageActionButton likePageActionButton;
                if (a2 != null) {
                    likePageActionButton = (LikePageActionButton) a2.a(f6982n);
                } else {
                    likePageActionButton = f6981m;
                }
                if (likePageActionButton == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7279b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6982n, b3);
                        } else {
                            f6981m = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = likePageActionButton;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public LikePageActionButton(FeedEventBus feedEventBus, Resources resources, AbstractFbErrorReporter abstractFbErrorReporter, GatekeeperStoreImpl gatekeeperStoreImpl, ActionButtonComponent actionButtonComponent, GlyphColorizerDrawableReference glyphColorizerDrawableReference) {
        this.f6983b = feedEventBus;
        this.f6985d = resources.getColorStateList(2131364107);
        this.f6986e = resources.getString(2131233426);
        this.f6987f = resources.getString(2131233427);
        this.f6988g = abstractFbErrorReporter;
        this.f6989h = resources.getDimensionPixelSize(2131427613);
        this.f6990i = gatekeeperStoreImpl;
        this.f6992k = actionButtonComponent;
        this.f6993l = glyphColorizerDrawableReference;
        this.f6991j = new LikePageActionButtonPartDefinition(this);
    }

    public final Component m7280a(ComponentContext componentContext, E e, FeedProps<GraphQLStoryAttachment> feedProps) {
        GraphQLStoryActionLink a = ActionLinkHelper.a((GraphQLStoryAttachment) feedProps.a);
        if (a.ab() == null) {
            return null;
        }
        CharSequence charSequence;
        boolean O = a.ab().O();
        Builder m = this.f6992k.m7579a(componentContext).b(this.f6993l.a(componentContext).j(O ? 2131361917 : 2131361938).h(this.f6984c).b()).a(true).k(2130840230).a(m7277a(this, feedProps)).m(this.f6989h);
        if (O) {
            charSequence = this.f6986e;
        } else {
            charSequence = this.f6987f;
        }
        return m.b(charSequence).d();
    }

    public final <V extends View & AttachmentHasButton> SinglePartDefinition<FeedProps<GraphQLStoryAttachment>, ?, E, V> m7281a() {
        return this.f6991j;
    }

    public final SinglePartDefinition<FeedProps<GraphQLStoryAttachment>, ?, E, ComponentView> m7282b() {
        return null;
    }

    public static OnClickListener m7277a(LikePageActionButton likePageActionButton, final FeedProps feedProps) {
        return new OnClickListener(likePageActionButton) {
            final /* synthetic */ LikePageActionButton f6996b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1009840944);
                FeedProps e = AttachmentProps.e(feedProps);
                if (e == null) {
                    Logger.a(2, EntryType.UI_INPUT_END, -1922227451, a);
                    return;
                }
                boolean z;
                FeedProps feedProps;
                GraphQLStory graphQLStory;
                String str;
                String j;
                GraphQLStory graphQLStory2 = (GraphQLStory) e.a;
                GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
                boolean u = graphQLStory2.u();
                FeedProps b = StoryProps.b(e);
                if (b != null) {
                    graphQLStory2 = (GraphQLStory) b.a;
                    u = u || graphQLStory2.u();
                    GraphQLStory graphQLStory3 = graphQLStory2;
                    z = u;
                    feedProps = b;
                    graphQLStory = graphQLStory3;
                } else {
                    graphQLStory = graphQLStory2;
                    z = u;
                    feedProps = e;
                }
                if (!ActionLinkHelper.a(graphQLStoryAttachment).ab().O()) {
                    view.setSelected(true);
                    LikeIconPopAnimationHelper.a(view);
                }
                if (this.f6996b.f6990i.a(830, false)) {
                    str = z ? "sponsored_story" : "feed_story";
                } else {
                    str = null;
                }
                FeedEventBus feedEventBus = this.f6996b.f6983b;
                String ae = ActionLinkHelper.a(graphQLStoryAttachment).ab().ae();
                if (graphQLStory.l() != null) {
                    j = graphQLStory.l().j();
                } else {
                    j = null;
                }
                feedEventBus.a(new PageLikeClickedEvent(feedProps, ae, j, str, "unknown"));
                LogUtils.a(1444441505, a);
            }
        };
    }
}
