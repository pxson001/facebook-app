package com.facebook.feedplugins.creativeediting;

import android.app.Activity;
import android.content.Context;
import android.view.View.OnClickListener;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.calltoaction.ActionLinkCallToActionPartDefinition;
import com.facebook.feedplugins.calltoaction.ActionLinkCallToActionPartDefinition.Props;
import com.facebook.feedplugins.calltoaction.ActionLinkCallToActionView;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.composer.intent.ComposerConfiguration.Builder;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.model.ComposerSourceSurface;
import com.facebook.ipc.creativecam.CreativeCamLaunchConfig;
import com.facebook.ipc.creativecam.CreativeCamLauncher;
import com.facebook.ipc.media.SupportedMediaType;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.photos.creativecam.activity.CreativeCamLauncherImpl;
import com.facebook.photos.creativeediting.abtest.ExperimentsForCreativeEditingAbtestModule;
import com.facebook.photos.creativeediting.swipeable.common.FramesAggregator;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.Toaster;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: feedback_prefetch_id */
public class FrameCallToActionPartDefinition<E extends FeedEnvironment> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, ActionLinkCallToActionView> {
    private static FrameCallToActionPartDefinition f24414g;
    private static final Object f24415h = new Object();
    private final ActionLinkCallToActionPartDefinition<E> f24416a;
    private final CreativeCamLauncher f24417b;
    public final TasksManager f24418c;
    public final FramesAggregator f24419d;
    public final Toaster f24420e;
    private final QeAccessor f24421f;

    private static FrameCallToActionPartDefinition m32719b(InjectorLike injectorLike) {
        return new FrameCallToActionPartDefinition(ActionLinkCallToActionPartDefinition.m28859a(injectorLike), CreativeCamLauncherImpl.m19535a(injectorLike), TasksManager.m14550b(injectorLike), FramesAggregator.m19559b(injectorLike), Toaster.m6454b(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        FeedEnvironment feedEnvironment = (FeedEnvironment) anyEnvironment;
        GraphQLStoryActionLink a = ActionLinkHelper.m22935a(StoryAttachmentHelper.m28042o((GraphQLStory) feedProps.f13444a));
        subParts.mo2756a(this.f24416a, Props.a(feedProps, m32716a(a), m32716a(a), null, feedEnvironment.getContext().getResources().getDrawable(2130840374)));
        return null;
    }

    public final boolean m32722a(Object obj) {
        GraphQLStoryAttachment o = StoryAttachmentHelper.m28042o((GraphQLStory) ((FeedProps) obj).f13444a);
        if (o == null) {
            return false;
        }
        GraphQLStoryActionLink a = ActionLinkHelper.m22935a(o);
        if (a == null) {
            return false;
        }
        GraphQLObjectType a2 = a.m22901a();
        return a2 != null && a2.m22301g() == 656245802 && this.f24421f.mo596a(ExperimentsForCreativeEditingAbtestModule.c, false);
    }

    public static FrameCallToActionPartDefinition m32717a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FrameCallToActionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24415h) {
                FrameCallToActionPartDefinition frameCallToActionPartDefinition;
                if (a2 != null) {
                    frameCallToActionPartDefinition = (FrameCallToActionPartDefinition) a2.mo818a(f24415h);
                } else {
                    frameCallToActionPartDefinition = f24414g;
                }
                if (frameCallToActionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32719b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24415h, b3);
                        } else {
                            f24414g = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = frameCallToActionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public FrameCallToActionPartDefinition(ActionLinkCallToActionPartDefinition actionLinkCallToActionPartDefinition, CreativeCamLauncher creativeCamLauncher, TasksManager tasksManager, FramesAggregator framesAggregator, Toaster toaster, QeAccessor qeAccessor) {
        this.f24416a = actionLinkCallToActionPartDefinition;
        this.f24417b = creativeCamLauncher;
        this.f24418c = tasksManager;
        this.f24419d = framesAggregator;
        this.f24420e = toaster;
        this.f24421f = qeAccessor;
    }

    public final ViewType<ActionLinkCallToActionView> mo2547a() {
        return ActionLinkCallToActionView.h;
    }

    private OnClickListener m32716a(GraphQLStoryActionLink graphQLStoryActionLink) {
        return new 1(this, graphQLStoryActionLink);
    }

    public static void m32718a(FrameCallToActionPartDefinition frameCallToActionPartDefinition, @Nullable Activity activity, String str, ImmutableList immutableList) {
        Builder a = ComposerConfigurationFactory.m26256a(ComposerSourceSurface.NEWSFEED, "framesCallToAction");
        String uuid = SafeUUIDGenerator.m2795a().toString();
        CreativeCamLauncher creativeCamLauncher = frameCallToActionPartDefinition.f24417b;
        CreativeCamLaunchConfig.Builder builder = new CreativeCamLaunchConfig.Builder();
        builder.b = true;
        builder = builder;
        builder.f = SupportedMediaType.PHOTO_ONLY;
        builder = builder;
        builder.h = immutableList;
        builder = builder;
        builder.i = str;
        builder = builder;
        builder.k = a.a();
        creativeCamLauncher.mo2610a(activity, 5, builder.a(), uuid, null);
    }
}
