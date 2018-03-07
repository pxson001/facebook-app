package com.facebook.events.permalink.actionbar;

import android.net.Uri;
import android.support.v4.app.Fragment;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.config.application.Product;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.eventsevents.EventsEventBus;
import com.facebook.events.eventsevents.EventsEvents.EventStatus;
import com.facebook.events.eventsevents.EventsEvents.PostEvent;
import com.facebook.events.model.Event;
import com.facebook.events.permalink.multirow.environment.CanPostToEventWallImpl;
import com.facebook.events.permalink.pagevc.PageViewerContextForAnEvent;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.model.GraphQLEntity;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerPageData;
import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.intent.SharePreview;
import com.facebook.ipc.composer.intent.SharePreview.Builder;
import com.facebook.ipc.composer.launch.ComposerIntentLauncher;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.sounds.FBSoundUtil;
import com.facebook.sounds.fb4a.Fb4aSoundUtil;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: calling_package_name */
public class ActionItemPost {
    public Fragment f17977a;
    public final CanPostToEventWallImpl f17978b;
    public final ComposerLauncher f17979c;
    public final ComposerIntentLauncher f17980d;
    public final ComposerPublishServiceHelper f17981e;
    public final PageViewerContextForAnEvent f17982f;
    public final FBSoundUtil f17983g;
    public final TasksManager f17984h;
    public final EventsEventBus f17985i;
    public final SecureContextHelper f17986j;
    public Event f17987k;

    /* compiled from: calling_package_name */
    class C25431 implements Function<ViewerContext, Void> {
        final /* synthetic */ ActionItemPost f17972a;

        C25431(ActionItemPost actionItemPost) {
            this.f17972a = actionItemPost;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            this.f17972a.f17979c.a(null, this.f17972a.f17978b.m19012b((ViewerContext) obj, this.f17972a.f17987k), 502, this.f17972a.f17977a);
            return null;
        }
    }

    /* compiled from: calling_package_name */
    public class C25442 implements Function<ViewerContext, Void> {
        final /* synthetic */ ActionItemPost f17973a;

        public C25442(ActionItemPost actionItemPost) {
            this.f17973a = actionItemPost;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            this.f17973a.f17980d.a(this.f17973a.f17978b.m19010a((ViewerContext) obj, this.f17973a.f17977a.getContext(), this.f17973a.f17987k), 502, this.f17973a.f17977a);
            return null;
        }
    }

    /* compiled from: calling_package_name */
    class C25453 implements Function<ViewerContext, Void> {
        final /* synthetic */ ActionItemPost f17974a;

        C25453(ActionItemPost actionItemPost) {
            this.f17974a = actionItemPost;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            String str;
            ViewerContext viewerContext = (ViewerContext) obj;
            ComposerLauncher composerLauncher = this.f17974a.f17979c;
            CanPostToEventWallImpl canPostToEventWallImpl = this.f17974a.f17978b;
            Event event = this.f17974a.f17987k;
            GraphQLEntity a = GraphQLHelper.a(event.a, 67338874);
            Uri uri = event.Y;
            Builder builder = new Builder();
            builder.a = event.b;
            builder = builder;
            if (uri == null) {
                str = null;
            } else {
                str = uri.toString();
            }
            builder.d = str;
            SharePreview a2 = builder.a();
            ComposerSourceType composerSourceType = ComposerSourceType.EVENT;
            ComposerShareParams.Builder a3 = ComposerShareParams.Builder.a(a);
            a3.d = a2;
            ComposerConfiguration.Builder isFireAndForget = ComposerConfigurationFactory.c(composerSourceType, a3.b()).setIsFireAndForget(true);
            if (canPostToEventWallImpl.f18727d == Product.PAA) {
                Preconditions.checkNotNull(viewerContext);
                ComposerConfiguration.Builder disableFriendTagging = isFireAndForget.setDisableFriendTagging(true);
                ComposerTargetData.Builder builder2 = new ComposerTargetData.Builder(Long.parseLong(viewerContext.mUserId), TargetType.PAGE);
                builder2.c = viewerContext.mUsername;
                builder2 = builder2;
                builder2.d = event.w;
                builder2 = builder2;
                builder2.f = true;
                disableFriendTagging.setInitialTargetData(builder2.a()).setInitialPageData(ComposerPageData.newBuilder().setPostAsPageViewerContext(viewerContext).a());
            }
            composerLauncher.a(null, isFireAndForget.a(), 503, this.f17974a.f17977a);
            return null;
        }
    }

    /* compiled from: calling_package_name */
    public class C25464 extends AbstractDisposableFutureCallback<OperationResult> {
        final /* synthetic */ int f17975a;
        final /* synthetic */ ActionItemPost f17976b;

        public C25464(ActionItemPost actionItemPost, int i) {
            this.f17976b = actionItemPost;
            this.f17975a = i;
        }

        protected final void m18370a(Object obj) {
            OperationResult operationResult = (OperationResult) obj;
            if (this.f17975a != 502) {
                return;
            }
            if (operationResult.b) {
                this.f17976b.f17983g.b("post_main");
                this.f17976b.f17985i.a(new PostEvent(EventStatus.SUCCESS));
                return;
            }
            this.f17976b.f17985i.a(new PostEvent(EventStatus.FAILURE));
        }

        protected final void m18371a(Throwable th) {
            if (this.f17975a == 502) {
                this.f17976b.f17985i.a(new PostEvent(EventStatus.FAILURE));
            }
        }
    }

    public static ActionItemPost m18372a(InjectorLike injectorLike) {
        return new ActionItemPost(CanPostToEventWallImpl.m19009b(injectorLike), (ComposerLauncher) ComposerLauncherImpl.a(injectorLike), ComposerIntentLauncher.b(injectorLike), ComposerPublishServiceHelper.b(injectorLike), PageViewerContextForAnEvent.m19058a(injectorLike), (FBSoundUtil) Fb4aSoundUtil.a(injectorLike), TasksManager.b(injectorLike), EventsEventBus.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    @Inject
    public ActionItemPost(CanPostToEventWallImpl canPostToEventWallImpl, ComposerLauncher composerLauncher, ComposerIntentLauncher composerIntentLauncher, ComposerPublishServiceHelper composerPublishServiceHelper, PageViewerContextForAnEvent pageViewerContextForAnEvent, FBSoundUtil fBSoundUtil, TasksManager tasksManager, EventsEventBus eventsEventBus, SecureContextHelper secureContextHelper) {
        this.f17978b = canPostToEventWallImpl;
        this.f17979c = composerLauncher;
        this.f17980d = composerIntentLauncher;
        this.f17981e = composerPublishServiceHelper;
        this.f17982f = pageViewerContextForAnEvent;
        this.f17983g = fBSoundUtil;
        this.f17984h = tasksManager;
        this.f17985i = eventsEventBus;
        this.f17986j = secureContextHelper;
    }

    public final void m18373a() {
        if (this.f17987k != null && this.f17977a != null) {
            this.f17982f.m19060a(this.f17987k, new C25431(this));
        }
    }

    public final void m18374d() {
        if (this.f17977a != null) {
            this.f17979c.a(1756, this.f17977a);
        }
    }

    public final void m18375e() {
        if (this.f17987k != null && this.f17977a != null) {
            this.f17982f.m19060a(this.f17987k, new C25453(this));
        }
    }
}
