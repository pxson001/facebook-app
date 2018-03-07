package com.facebook.feedplugins.richmedia;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasScrollListenerSupport;
import com.facebook.feed.environment.HasScrollListenerSupport.SimpleScrollListener;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feedplugins.richmedia.abtest.ExperimentsForRichMediaAbTestModule;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

@ContextScoped
/* compiled from: button_negative */
public class RichMediaLightningBoltAnimationPartDefinition<E extends HasPersistentState & HasScrollListenerSupport, V extends View & AttachmentHasLightningBoltAnimation> extends BaseSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, ScrollListener, E, V> {
    private static RichMediaLightningBoltAnimationPartDefinition f9205d;
    private static final Object f9206e = new Object();
    private final ScheduledExecutorService f9207a;
    private final QeAccessor f9208b;
    private final AnalyticsLogger f9209c;

    /* compiled from: button_negative */
    public class ScrollListener implements SimpleScrollListener {
        public View f9192a;
        public RichMediaStoryPersistentState f9193b;
        public ScheduledFuture f9194c;
        private final Rect f9195d = new Rect(0, 0, 0, 0);
        public final Runnable f9196e;
        public final Runnable f9197f;
        public final ScheduledExecutorService f9198g;
        public final int f9199h;
        public final int f9200i;
        private final float f9201j;
        public final String f9202k;
        public final AnalyticsLogger f9203l;
        public FeedProps<GraphQLStory> f9204m;

        /* compiled from: button_negative */
        class C11111 implements Runnable {
            final /* synthetic */ ScrollListener f9190a;

            C11111(ScrollListener scrollListener) {
                this.f9190a = scrollListener;
            }

            public void run() {
                ((AttachmentHasLightningBoltAnimation) this.f9190a.f9192a).mo250a(this.f9190a.f9199h, this.f9190a.f9202k);
                this.f9190a.f9203l.d(new HoneyClientEvent("rich_media_lightning_bolt_animation_start").a("tracking", TrackableFeedProps.a(this.f9190a.f9204m)));
                this.f9190a.f9198g.schedule(this.f9190a.f9197f, (long) (this.f9190a.f9199h / 2), TimeUnit.MILLISECONDS);
                this.f9190a.f9193b.f9213c = false;
            }
        }

        /* compiled from: button_negative */
        class C11122 implements Runnable {
            final /* synthetic */ ScrollListener f9191a;

            C11122(ScrollListener scrollListener) {
                this.f9191a = scrollListener;
            }

            public void run() {
                if (ScrollListener.m9857b(this.f9191a, this.f9191a.f9192a)) {
                    this.f9191a.f9203l.d(new HoneyClientEvent("rich_media_lightning_bolt_animation_half_done").a("tracking", TrackableFeedProps.a(this.f9191a.f9204m)));
                }
            }
        }

        public ScrollListener(ScheduledExecutorService scheduledExecutorService, int i, int i2, float f, String str, AnalyticsLogger analyticsLogger, FeedProps<GraphQLStory> feedProps) {
            this.f9198g = scheduledExecutorService;
            this.f9199h = i;
            this.f9200i = i2;
            this.f9201j = f;
            this.f9202k = str;
            this.f9203l = analyticsLogger;
            this.f9204m = feedProps;
            this.f9196e = new C11111(this);
            this.f9197f = new C11122(this);
        }

        public final void m9858a() {
            if (m9857b(this, this.f9192a) && this.f9194c == null && this.f9193b.f9213c) {
                this.f9194c = this.f9198g.schedule(this.f9196e, (long) this.f9200i, TimeUnit.MILLISECONDS);
            } else if (!m9857b(this, this.f9192a) && this.f9194c != null) {
                m9859b();
            }
        }

        public final void m9859b() {
            if (!(this.f9194c == null || this.f9194c.isDone())) {
                this.f9194c.cancel(false);
                ((AttachmentHasLightningBoltAnimation) this.f9192a).mo251b();
            }
            this.f9194c = null;
        }

        public static boolean m9857b(ScrollListener scrollListener, View view) {
            if (view == null || view.getParent() == null || view.getWindowToken() == null || view.getWidth() == 0 || view.getHeight() == 0 || !view.isShown() || !view.getGlobalVisibleRect(scrollListener.f9195d)) {
                return false;
            }
            if (((float) (scrollListener.f9195d.width() * scrollListener.f9195d.height())) / ((float) (view.getWidth() * view.getHeight())) >= scrollListener.f9201j) {
                return true;
            }
            return false;
        }
    }

    private static RichMediaLightningBoltAnimationPartDefinition m9862b(InjectorLike injectorLike) {
        return new RichMediaLightningBoltAnimationPartDefinition((ScheduledExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    public final Object m9863a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        if (AttachmentProps.c(feedProps) == null) {
            return null;
        }
        return new ScrollListener(this.f9207a, this.f9208b.a(ExperimentsForRichMediaAbTestModule.f9252a, 1000), this.f9208b.a(ExperimentsForRichMediaAbTestModule.f9257f, 1000), this.f9208b.a(ExperimentsForRichMediaAbTestModule.f9256e, 0.8f), this.f9208b.a(ExperimentsForRichMediaAbTestModule.f9255d, "https://lookaside.facebook.com/assets/126637881080823/"), this.f9209c, AttachmentProps.e(feedProps));
    }

    public final void m9865b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ScrollListener scrollListener = (ScrollListener) obj2;
        HasPersistentState hasPersistentState = (HasPersistentState) anyEnvironment;
        if (AttachmentProps.c((FeedProps) obj) != null) {
            scrollListener.m9859b();
            ((HasScrollListenerSupport) hasPersistentState).b(scrollListener);
            scrollListener.f9192a = null;
            ((AttachmentHasLightningBoltAnimation) view).mo251b();
        }
    }

    @Inject
    public RichMediaLightningBoltAnimationPartDefinition(ScheduledExecutorService scheduledExecutorService, QeAccessor qeAccessor, AnalyticsLogger analyticsLogger) {
        this.f9207a = scheduledExecutorService;
        this.f9208b = qeAccessor;
        this.f9209c = analyticsLogger;
    }

    public static RichMediaLightningBoltAnimationPartDefinition m9860a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RichMediaLightningBoltAnimationPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9206e) {
                RichMediaLightningBoltAnimationPartDefinition richMediaLightningBoltAnimationPartDefinition;
                if (a2 != null) {
                    richMediaLightningBoltAnimationPartDefinition = (RichMediaLightningBoltAnimationPartDefinition) a2.a(f9206e);
                } else {
                    richMediaLightningBoltAnimationPartDefinition = f9205d;
                }
                if (richMediaLightningBoltAnimationPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9862b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9206e, b3);
                        } else {
                            f9205d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = richMediaLightningBoltAnimationPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private static void m9861a(FeedProps<GraphQLStoryAttachment> feedProps, ScrollListener scrollListener, E e, V v) {
        GraphQLStory c = AttachmentProps.c(feedProps);
        if (c != null) {
            RichMediaStoryPersistentState richMediaStoryPersistentState = (RichMediaStoryPersistentState) e.a(new RichMediaStoryKey(c), c);
            if (richMediaStoryPersistentState.f9213c) {
                scrollListener.f9192a = v;
                scrollListener.f9193b = richMediaStoryPersistentState;
                ((HasScrollListenerSupport) e).a(scrollListener);
                return;
            }
            ((AttachmentHasLightningBoltAnimation) v).mo251b();
        }
    }
}
