package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.CommonEventsBuilder;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.DraweeView;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.rows.sections.attachments.ui.ImageShareAttachmentView;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.links.AttachmentLinkInspector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Optional;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: [createActor] Empty imageUrl */
public class AnimatedImagePartDefinition extends BaseSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, State, AnyEnvironment, ImageShareAttachmentView> {
    public static final CallerContext f20508a = CallerContext.a(AnimatedImagePartDefinition.class, "newsfeed_image_share_view", "animated_image", "native_newsfeed");
    private static AnimatedImagePartDefinition f20509g;
    private static final Object f20510h = new Object();
    public final FbDraweeControllerBuilder f20511b;
    public final AnalyticsLogger f20512c;
    public final Clock f20513d;
    private final CommonEventsBuilder f20514e;
    private final AttachmentLinkInspector f20515f;

    /* compiled from: [createActor] Empty imageUrl */
    public enum ClickBehavior {
        LOAD_ON_CLICK,
        PAUSE_ON_CLICK,
        RESUME_ON_CLICK
    }

    /* compiled from: [createActor] Empty imageUrl */
    public class State {
        public final DraweeController f20500a;
        public OnClickListener f20501b;
        public final float f20502c;
        public final HoneyClientEvent f20503d;
        public long f20504e;
        public final ClickBehavior f20505f;
        public ClickBehavior f20506g;
        public ImageShareAttachmentView f20507h;

        public State(DraweeController draweeController, float f, HoneyClientEvent honeyClientEvent, ClickBehavior clickBehavior) {
            this.f20500a = draweeController;
            this.f20502c = f;
            this.f20503d = honeyClientEvent;
            this.f20505f = clickBehavior;
        }
    }

    private static AnimatedImagePartDefinition m23577b(InjectorLike injectorLike) {
        return new AnimatedImagePartDefinition(FbDraweeControllerBuilder.b(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), CommonEventsBuilder.b(injectorLike), AttachmentLinkInspector.a(injectorLike));
    }

    public final Object m23578a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        GraphQLImage a = ImageShareUtil.m23646a(graphQLStoryAttachment);
        GraphQLImage b = ImageShareUtil.m23647b(graphQLStoryAttachment);
        final State state = new State(ImageShareUtil.m23645a(this.f20511b, a), ImageShareUtil.m23644a(a), m23576b(AttachmentProps.e(feedProps)), ClickBehavior.LOAD_ON_CLICK);
        final DraweeController s = ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f20511b.p().a(f20508a).b(ImageUtil.a(b)).d(ImageRequest.a(ImageUtil.a(a)))).a(new BaseControllerListener(this) {
            final /* synthetic */ AnimatedImagePartDefinition f20498b;

            public final void m23572a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
                state.f20507h.setPlayButtonState(com.facebook.gif.AnimatedImagePlayButtonView.State.DONE_LOADING);
                if (animatable != null) {
                    animatable.start();
                }
            }

            public final void m23573b(String str, Throwable th) {
                state.f20506g = ClickBehavior.LOAD_ON_CLICK;
                if (state.f20507h != null) {
                    state.f20507h.setImageController(state.f20500a);
                    state.f20507h.setPlayButtonState(com.facebook.gif.AnimatedImagePlayButtonView.State.READY_TO_PLAY);
                }
            }
        })).s();
        state.f20501b = new OnClickListener(this) {
            final /* synthetic */ AnimatedImagePartDefinition f20496d;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 339190191);
                ImageShareAttachmentView imageShareAttachmentView = (ImageShareAttachmentView) ((DraweeView) view).getParent().getParent();
                Optional fromNullable = Optional.fromNullable(imageShareAttachmentView.f21062a.getController().g());
                switch (state.f20506g) {
                    case LOAD_ON_CLICK:
                        imageShareAttachmentView.setPlayButtonState(com.facebook.gif.AnimatedImagePlayButtonView.State.LOADING);
                        imageShareAttachmentView.setImageController(s);
                        AnimatedImagePartDefinition.m23575a(this.f20496d, state, feedProps);
                        state.f20506g = ClickBehavior.PAUSE_ON_CLICK;
                        break;
                    case PAUSE_ON_CLICK:
                        if (fromNullable.isPresent()) {
                            imageShareAttachmentView.setPlayButtonState(com.facebook.gif.AnimatedImagePlayButtonView.State.READY_TO_PLAY);
                            ((Animatable) fromNullable.get()).stop();
                            state.f20506g = ClickBehavior.RESUME_ON_CLICK;
                            break;
                        }
                        break;
                    case RESUME_ON_CLICK:
                        if (fromNullable.isPresent()) {
                            imageShareAttachmentView.setPlayButtonState(com.facebook.gif.AnimatedImagePlayButtonView.State.HIDDEN);
                            ((Animatable) fromNullable.get()).start();
                            state.f20506g = ClickBehavior.PAUSE_ON_CLICK;
                            AnimatedImagePartDefinition.m23575a(this.f20496d, state, feedProps);
                            break;
                        }
                        break;
                }
                LogUtils.a(1757466746, a);
            }
        };
        return state;
    }

    public final /* bridge */ /* synthetic */ void m23579a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1296080690);
        State state = (State) obj2;
        ImageShareAttachmentView imageShareAttachmentView = (ImageShareAttachmentView) view;
        state.f20506g = state.f20505f;
        state.f20507h = imageShareAttachmentView;
        state.f20507h.setAspectRatio(state.f20502c);
        state.f20507h.setImageController(state.f20500a);
        if (state.f20506g == ClickBehavior.LOAD_ON_CLICK) {
            state.f20507h.setPlayButtonState(com.facebook.gif.AnimatedImagePlayButtonView.State.READY_TO_PLAY);
        } else {
            state.f20507h.setPlayButtonState(com.facebook.gif.AnimatedImagePlayButtonView.State.LOADING);
        }
        state.f20507h.setOnImageClickListener(state.f20501b);
        state.f20504e = this.f20513d.a();
        Logger.a(8, EntryType.MARK_POP, -1066111958, a);
    }

    public final void m23580b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        State state = (State) obj2;
        state.f20507h.setOnImageClickListener(null);
        state.f20507h.setPlayButtonState(com.facebook.gif.AnimatedImagePlayButtonView.State.HIDDEN);
        state.f20507h = null;
        if (state.f20503d != null) {
            state.f20503d.a("was_tapped", state.f20506g != ClickBehavior.LOAD_ON_CLICK);
            state.f20503d.a("time_spent", this.f20513d.a() - state.f20504e);
            this.f20512c.c(state.f20503d);
        }
    }

    public static AnimatedImagePartDefinition m23574a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AnimatedImagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20510h) {
                AnimatedImagePartDefinition animatedImagePartDefinition;
                if (a2 != null) {
                    animatedImagePartDefinition = (AnimatedImagePartDefinition) a2.a(f20510h);
                } else {
                    animatedImagePartDefinition = f20509g;
                }
                if (animatedImagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23577b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20510h, b3);
                        } else {
                            f20509g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = animatedImagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private static HoneyClientEvent m23576b(FeedProps<GraphQLStory> feedProps) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        HoneyClientEvent b = new HoneyClientEvent("animated_image_session").a("tracking", TrackableFeedProps.a(feedProps)).b("story_graphql_id", graphQLStory.c()).b("story_legacy_api_post_id", Strings.nullToEmpty(graphQLStory.ai()));
        b.c = "native_newsfeed";
        return b;
    }

    @Inject
    public AnimatedImagePartDefinition(FbDraweeControllerBuilder fbDraweeControllerBuilder, AnalyticsLogger analyticsLogger, Clock clock, CommonEventsBuilder commonEventsBuilder, AttachmentLinkInspector attachmentLinkInspector) {
        this.f20511b = fbDraweeControllerBuilder;
        this.f20512c = analyticsLogger;
        this.f20513d = clock;
        this.f20514e = commonEventsBuilder;
        this.f20515f = attachmentLinkInspector;
    }

    public static void m23575a(AnimatedImagePartDefinition animatedImagePartDefinition, State state, FeedProps feedProps) {
        HoneyClientEvent honeyClientEvent;
        FeedProps feedProps2 = feedProps.b;
        JsonNode b = feedProps2 != null ? TrackableFeedProps.b(feedProps2) : null;
        String a = animatedImagePartDefinition.f20515f.a(feedProps);
        String str = "native_newsfeed";
        if (b == null || b.e() == 0 || a == null) {
            honeyClientEvent = null;
        } else {
            honeyClientEvent = new HoneyClientEvent("inline_play_gif");
            honeyClientEvent.d = "url";
            honeyClientEvent = honeyClientEvent;
            honeyClientEvent.e = a;
            honeyClientEvent = honeyClientEvent.a("tracking", b);
            honeyClientEvent.c = str;
            honeyClientEvent = honeyClientEvent;
        }
        HoneyClientEvent honeyClientEvent2 = honeyClientEvent;
        if (honeyClientEvent2 != null) {
            if (!TrackingNodes.a(honeyClientEvent2)) {
                TrackingNodes.a(honeyClientEvent2, state.f20507h);
            }
            animatedImagePartDefinition.f20512c.c(honeyClientEvent2);
        }
    }
}
