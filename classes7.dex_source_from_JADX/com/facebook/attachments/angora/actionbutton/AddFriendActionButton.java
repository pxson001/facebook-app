package com.facebook.attachments.angora.actionbutton;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.view.View;
import com.facebook.attachments.angora.AttachmentHasButton;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentView;
import com.facebook.components.glyph.GlyphColorizerDrawableReference;
import com.facebook.components.reference.Reference;
import com.facebook.controller.mutation.gk.ControllerMutationGatekeepers;
import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.fbui.widget.text.GlyphWithTextView;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.StoryEvents.FeedUnitMutatedEvent;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.constants.FriendRequestCancelRef;
import com.facebook.friends.constants.FriendRequestHowFound;
import com.facebook.friends.controllers.FriendingExceptionHandler;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
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
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: video-creative-editing */
public class AddFriendActionButton<E extends AnyEnvironment> implements AngoraActionButton<E> {
    private static AddFriendActionButton f673n;
    private static final Object f674o = new Object();
    public final FriendingClient f675a;
    public final FriendingExceptionHandler f676b;
    public final FeedEventBus f677c;
    public final FeedStoryMutator f678d;
    public final DefaultAndroidThreadUtil f679e;
    public final ColorStateList f680f;
    public final String f681g;
    public final String f682h;
    public final int f683i;
    private final SinglePartDefinition f684j = new AddFriendActionButtonPartDefinition(this);
    private final ActionButtonComponent f685k;
    private final GlyphColorizerDrawableReference f686l;
    public final ControllerMutationGatekeepers f687m;

    /* compiled from: video-creative-editing */
    public class C00673 implements OnClickListener {
        final /* synthetic */ GraphQLStoryAttachment f664a;
        final /* synthetic */ FeedProps f665b;
        final /* synthetic */ AddFriendActionButton f666c;

        /* compiled from: video-creative-editing */
        class C00661 implements FutureCallback<GraphQLFriendshipStatus> {
            final /* synthetic */ C00673 f663a;

            C00661(C00673 c00673) {
                this.f663a = c00673;
            }

            public /* bridge */ /* synthetic */ void onSuccess(@Nullable Object obj) {
            }

            public void onFailure(Throwable th) {
                this.f663a.f666c.f676b.a(th);
                if (this.f663a.f666c.f687m.b()) {
                    this.f663a.f666c.f677c.a(new FeedUnitMutatedEvent((FeedUnit) this.f663a.f665b.a));
                }
            }
        }

        public C00673(AddFriendActionButton addFriendActionButton, GraphQLStoryAttachment graphQLStoryAttachment, FeedProps feedProps) {
            this.f666c = addFriendActionButton;
            this.f664a = graphQLStoryAttachment;
            this.f665b = feedProps;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ListenableFuture a = this.f666c.f675a.a(Long.parseLong(this.f664a.z().dp()), FriendRequestHowFound.NEWSFEED, null, null);
            if (this.f666c.f687m.b()) {
                this.f666c.f677c.a(new FeedUnitMutatedEvent(this.f666c.f678d.b(this.f665b, !GraphQLStoryAttachmentUtil.q(this.f664a))));
            }
            this.f666c.f679e.a(a, new C00661(this));
        }
    }

    /* compiled from: video-creative-editing */
    class AddFriendActionButtonPartDefinition<V extends View & AttachmentHasButton> extends BaseSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, State, E, V> {
        final /* synthetic */ AddFriendActionButton f669a;

        public AddFriendActionButtonPartDefinition(AddFriendActionButton addFriendActionButton) {
            this.f669a = addFriendActionButton;
        }

        public final Object m744a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
            final FeedProps feedProps = (FeedProps) obj;
            boolean q = GraphQLStoryAttachmentUtil.q((GraphQLStoryAttachment) feedProps.a);
            return new State(new View.OnClickListener(this) {
                final /* synthetic */ AddFriendActionButtonPartDefinition f668b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1688301995);
                    AddFriendActionButton.m748a(this.f668b.f669a, feedProps);
                    Logger.a(2, EntryType.UI_INPUT_END, -487199309, a);
                }
            }, q ? 2130839892 : 2130839877, q);
        }

        public final /* bridge */ /* synthetic */ void m745a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
            int a = Logger.a(8, EntryType.MARK_PUSH, -988532054);
            m743a((FeedProps) obj, (State) obj2, view);
            Logger.a(8, EntryType.MARK_POP, 1776071882, a);
        }

        private void m743a(FeedProps<GraphQLStoryAttachment> feedProps, State state, V v) {
            GenericActionButtonView actionButton = ((AttachmentHasButton) v).getActionButton();
            if (feedProps == null) {
                actionButton.setVisibility(8);
                return;
            }
            actionButton.setVisibility(0);
            actionButton.g = true;
            actionButton.setPadding(this.f669a.f683i, 0, this.f669a.f683i, 0);
            actionButton.setButtonBackgroundResource(2130840230);
            GlyphWithTextView glyphWithTextView = actionButton.a;
            glyphWithTextView.setContentDescription(state.f672c ? this.f669a.f682h : this.f669a.f681g);
            glyphWithTextView.setCompoundDrawablePadding(0);
            glyphWithTextView.setOnClickListener(state.f670a);
            glyphWithTextView.setImageResource(state.f671b);
            glyphWithTextView.setSelected(state.f672c);
            glyphWithTextView.setGlyphColor(this.f669a.f680f);
        }

        public final void m746b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
            if (((AttachmentHasButton) view).getActionButton() != null) {
                ((AttachmentHasButton) view).getActionButton().a();
            }
        }
    }

    /* compiled from: video-creative-editing */
    public class State {
        public final View.OnClickListener f670a;
        public final int f671b;
        public final boolean f672c;

        public State(View.OnClickListener onClickListener, int i, boolean z) {
            this.f670a = onClickListener;
            this.f671b = i;
            this.f672c = z;
        }
    }

    private static AddFriendActionButton m749b(InjectorLike injectorLike) {
        return new AddFriendActionButton(FriendingClient.b(injectorLike), FriendingExceptionHandler.b(injectorLike), FeedEventBus.a(injectorLike), FeedStoryMutator.b(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), ActionButtonComponent.a(injectorLike), GlyphColorizerDrawableReference.a(injectorLike), ControllerMutationGatekeepers.b(injectorLike));
    }

    public static AddFriendActionButton m747a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AddFriendActionButton b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f674o) {
                AddFriendActionButton addFriendActionButton;
                if (a2 != null) {
                    addFriendActionButton = (AddFriendActionButton) a2.a(f674o);
                } else {
                    addFriendActionButton = f673n;
                }
                if (addFriendActionButton == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m749b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f674o, b3);
                        } else {
                            f673n = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = addFriendActionButton;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public AddFriendActionButton(FriendingClient friendingClient, FriendingExceptionHandler friendingExceptionHandler, FeedEventBus feedEventBus, FeedStoryMutator feedStoryMutator, DefaultAndroidThreadUtil defaultAndroidThreadUtil, Resources resources, ActionButtonComponent actionButtonComponent, GlyphColorizerDrawableReference glyphColorizerDrawableReference, ControllerMutationGatekeepers controllerMutationGatekeepers) {
        this.f675a = friendingClient;
        this.f676b = friendingExceptionHandler;
        this.f677c = feedEventBus;
        this.f678d = feedStoryMutator;
        this.f679e = defaultAndroidThreadUtil;
        this.f685k = actionButtonComponent;
        this.f686l = glyphColorizerDrawableReference;
        this.f680f = resources.getColorStateList(2131364033);
        this.f681g = resources.getString(2131233500);
        this.f682h = resources.getString(2131233501);
        this.f683i = resources.getDimensionPixelSize(2131427612);
        this.f687m = controllerMutationGatekeepers;
    }

    public final <V extends View & AttachmentHasButton> SinglePartDefinition<FeedProps<GraphQLStoryAttachment>, ?, E, V> m751a() {
        return this.f684j;
    }

    public final Component m750a(ComponentContext componentContext, E e, final FeedProps<GraphQLStoryAttachment> feedProps) {
        if (feedProps == null) {
            return null;
        }
        CharSequence charSequence;
        boolean q = GraphQLStoryAttachmentUtil.q((GraphQLStoryAttachment) feedProps.a);
        Reference b = this.f686l.a(componentContext).m1294h(q ? 2130839892 : 2130839877).m1296j(2131364033).b();
        ActionButtonComponent$Builder k = this.f685k.a(componentContext).m732a(true).m740m(this.f683i).m738k(2130840230);
        if (q) {
            charSequence = this.f682h;
        } else {
            charSequence = this.f681g;
        }
        return k.m735b(charSequence).m734b(b).m730a(new View.OnClickListener(this) {
            final /* synthetic */ AddFriendActionButton f659b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1566544032);
                AddFriendActionButton.m748a(this.f659b, feedProps);
                Logger.a(2, EntryType.UI_INPUT_END, -1849612949, a);
            }
        }).d();
    }

    public final SinglePartDefinition<FeedProps<GraphQLStoryAttachment>, ?, E, ComponentView> m752b() {
        return null;
    }

    public static void m748a(AddFriendActionButton addFriendActionButton, final FeedProps feedProps) {
        final FeedProps e = AttachmentProps.e(feedProps);
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        if (e != null && graphQLStoryAttachment.z().dp() != null) {
            ListenableFuture a;
            if (GraphQLStoryAttachmentUtil.q(graphQLStoryAttachment)) {
                a = addFriendActionButton.f675a.a(Long.parseLong(graphQLStoryAttachment.z().dp()), FriendRequestCancelRef.FEED);
            } else {
                a = addFriendActionButton.f675a.b(Long.parseLong(graphQLStoryAttachment.z().dp()), FriendRequestHowFound.NEWSFEED, null, null);
            }
            ListenableFuture listenableFuture = a;
            if (addFriendActionButton.f687m.b()) {
                addFriendActionButton.f677c.a(new FeedUnitMutatedEvent(addFriendActionButton.f678d.b(e, !GraphQLStoryAttachmentUtil.q(graphQLStoryAttachment))));
            }
            addFriendActionButton.f679e.a(listenableFuture, new AbstractDisposableFutureCallback<GraphQLFriendshipStatus>(addFriendActionButton) {
                final /* synthetic */ AddFriendActionButton f662c;

                protected final void m742a(Throwable th) {
                    FriendingExceptionHandler friendingExceptionHandler = this.f662c.f676b;
                    AddFriendActionButton addFriendActionButton = this.f662c;
                    FeedProps feedProps = feedProps;
                    friendingExceptionHandler.a(th, new C00673(addFriendActionButton, (GraphQLStoryAttachment) feedProps.a, AttachmentProps.e(feedProps)));
                    if (this.f662c.f687m.b()) {
                        this.f662c.f677c.a(new FeedUnitMutatedEvent((FeedUnit) e.a));
                    }
                }
            });
        }
    }
}
