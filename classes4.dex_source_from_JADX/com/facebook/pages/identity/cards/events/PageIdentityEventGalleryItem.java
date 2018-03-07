package com.facebook.pages.identity.cards.events;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.events.common.EventsDateUtil;
import com.facebook.events.mutators.PrivateEventsRsvpMutator;
import com.facebook.events.mutators.PublicEventsRsvpMutator;
import com.facebook.events.socialcontext.EventSocialContextFormatter;
import com.facebook.events.widget.eventcard.EventActionButtonStateSelector;
import com.facebook.events.widget.eventcard.EventActionButtonStateSelectorProvider;
import com.facebook.events.widget.eventcard.EventAttachmentUtil;
import com.facebook.events.widget.eventcard.EventsCardView;
import com.facebook.graphql.model.GraphQLEvent;
import com.facebook.graphql.model.GraphQLFocusedPhoto;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.constants.PagesAsyncTaskType;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.RecyclableView;
import javax.inject.Inject;

/* compiled from: notification can't be null */
public class PageIdentityEventGalleryItem extends EventsCardView implements RecyclableView {
    private static final CallerContext f6886a = CallerContext.a(PageIdentityEventGalleryItem.class, "pages_identity");
    public TasksManager<PagesAsyncTaskType> f6887b;
    public Toaster f6888c;
    public PagesAnalytics f6889d;
    public PrivateEventsRsvpMutator f6890e;
    public PublicEventsRsvpMutator f6891f;
    private EventActionButtonStateSelector f6892g;
    private FbDraweeControllerBuilder f6893h;
    private EventSocialContextFormatter f6894i;
    private Resources f6895j;
    private int f6896k;
    public GraphQLEvent f6897l;
    public long f6898m;
    public boolean f6899n = false;

    public static void m7218a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PageIdentityEventGalleryItem) obj).m7217a(TasksManager.b(fbInjector), Toaster.b(fbInjector), PagesAnalytics.a(fbInjector), (EventActionButtonStateSelectorProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(EventActionButtonStateSelectorProvider.class), PrivateEventsRsvpMutator.b(fbInjector), PublicEventsRsvpMutator.b(fbInjector), FbDraweeControllerBuilder.b(fbInjector), ResourcesMethodAutoProvider.a(fbInjector), EventSocialContextFormatter.b(fbInjector));
    }

    public PageIdentityEventGalleryItem(Context context) {
        super(context);
        Class cls = PageIdentityEventGalleryItem.class;
        m7218a((Object) this, getContext());
    }

    @Inject
    private void m7217a(TasksManager tasksManager, Toaster toaster, PagesAnalytics pagesAnalytics, EventActionButtonStateSelectorProvider eventActionButtonStateSelectorProvider, PrivateEventsRsvpMutator privateEventsRsvpMutator, PublicEventsRsvpMutator publicEventsRsvpMutator, FbDraweeControllerBuilder fbDraweeControllerBuilder, Resources resources, EventSocialContextFormatter eventSocialContextFormatter) {
        this.f6887b = tasksManager;
        this.f6888c = toaster;
        this.f6889d = pagesAnalytics;
        this.f6890e = privateEventsRsvpMutator;
        this.f6891f = publicEventsRsvpMutator;
        this.f6892g = eventActionButtonStateSelectorProvider.m6427a(new PageEvenEventsRsvpActionListener(this));
        this.f6893h = fbDraweeControllerBuilder;
        this.f6895j = resources;
        this.f6894i = eventSocialContextFormatter;
    }

    public final void m7219a(GraphQLEvent graphQLEvent, long j) {
        this.f6897l = graphQLEvent;
        this.f6898m = j;
        m6444a(new ColorDrawable(this.f6895j.getColor(2131361864)));
        setTitleText(graphQLEvent.aE());
        setCalendarFormatStartDate(EventsDateUtil.m6501c(graphQLEvent.bi()));
        GraphQLPlace W = graphQLEvent.W();
        m6446a(EventAttachmentUtil.m6503a(W), EventAttachmentUtil.m6504b(W));
        setSocialContextText(this.f6894i.a(graphQLEvent));
        this.f5988g.m6495a(this.f6892g.m6525a(graphQLEvent.A(), graphQLEvent.bt(), graphQLEvent.bA()));
        setUpCoverPhoto(this.f6897l.C());
    }

    private void setUpCoverPhoto(GraphQLFocusedPhoto graphQLFocusedPhoto) {
        Object obj;
        if (graphQLFocusedPhoto == null || graphQLFocusedPhoto.j() == null || graphQLFocusedPhoto.j().L() == null || StringUtil.a(graphQLFocusedPhoto.j().L().b()) || graphQLFocusedPhoto.a() == null) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            setCoverPhotoController(this.f6893h.a(f6886a).a(graphQLFocusedPhoto.j().L().b()).s());
            return;
        }
        setCoverPhotoController(null);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -2026993509);
        super.onAttachedToWindow();
        this.f6899n = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -2063822639, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 481344045);
        super.onDetachedFromWindow();
        this.f6899n = false;
        if (this.f6887b != null) {
            this.f6887b.c(PagesAsyncTaskType.JOIN_EVENT);
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1660174085, a);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f6896k != configuration.orientation) {
            this.f6896k = configuration.orientation;
            if (this.f6897l.C() != null) {
                setUpCoverPhoto(this.f6897l.C());
            }
        }
    }

    public final boolean mo569a() {
        return this.f6899n;
    }
}
