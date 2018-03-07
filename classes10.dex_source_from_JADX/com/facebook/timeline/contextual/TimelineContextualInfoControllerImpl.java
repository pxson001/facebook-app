package com.facebook.timeline.contextual;

import android.content.Context;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.inject.Assisted;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.profile.api.RelationshipType;
import com.facebook.timeline.datafetcher.TimelineDataFetcher;
import com.facebook.timeline.event.HeaderDataEvents.AdapterDataChangedEvent;
import com.facebook.timeline.event.TimelineHeaderEventBus;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.logging.TimelineAnalyticsLogger;
import com.facebook.timeline.protocol.FetchTimelineContextItemsGraphQLModels.TimelineContextItemsModel;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineContextItemsPageInfoModel;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineContextItemsPageInfoModel.Builder;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineContextListItemFieldsModel;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineContextListItemFieldsModel.NodeModel;
import com.facebook.timeline.services.ProfileContextItemNavigationHandler;
import com.facebook.timeline.services.data.ProfileContextItemNavigationData;
import com.facebook.ultralight.Inject;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: group_photos */
public class TimelineContextualInfoControllerImpl implements TimelineContextualInfoController {
    private final Provider<ProfileContextItemNavigationHandler> f10330a;
    public final Provider<TimelineHeaderEventBus> f10331b;
    private final Context f10332c;
    private final TimelineAnalyticsLogger f10333d;
    private final TimelineDataFetcher f10334e;
    private final TimelineContext f10335f;
    public final TimelineContextualInfoData f10336g;
    private final TimelineHeaderUserData f10337h;

    /* compiled from: group_photos */
    class C15211 extends AbstractDisposableFutureCallback<TimelineContextItemsModel> {
        final /* synthetic */ TimelineContextualInfoControllerImpl f10329a;

        C15211(TimelineContextualInfoControllerImpl timelineContextualInfoControllerImpl) {
            this.f10329a = timelineContextualInfoControllerImpl;
        }

        protected final void m10463a(Object obj) {
            TimelineContextItemsModel timelineContextItemsModel = (TimelineContextItemsModel) obj;
            this.f10329a.f10336g.h();
            ImmutableList a = timelineContextItemsModel.a();
            Builder builder = new Builder();
            builder.a = false;
            builder = builder;
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.c(1);
            flatBufferBuilder.a(0, builder.a);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            this.f10329a.f10336g.m10468a(new TimelineContextItemsData(a, new TimelineContextItemsPageInfoModel(new MutableFlatBuffer(wrap, null, null, true, null))), 2);
            ((TimelineHeaderEventBus) this.f10329a.f10331b.get()).a(new AdapterDataChangedEvent());
        }

        protected final void m10464a(Throwable th) {
            this.f10329a.f10336g.h();
        }
    }

    @Inject
    public TimelineContextualInfoControllerImpl(@Assisted Context context, @Assisted TimelineAnalyticsLogger timelineAnalyticsLogger, @Assisted TimelineContext timelineContext, @Assisted TimelineContextualInfoData timelineContextualInfoData, @Assisted TimelineDataFetcher timelineDataFetcher, @Assisted TimelineHeaderUserData timelineHeaderUserData, Provider<ProfileContextItemNavigationHandler> provider, Provider<TimelineHeaderEventBus> provider2) {
        this.f10332c = context;
        this.f10333d = timelineAnalyticsLogger;
        this.f10335f = timelineContext;
        this.f10336g = timelineContextualInfoData;
        this.f10334e = timelineDataFetcher;
        this.f10337h = timelineHeaderUserData;
        this.f10330a = provider;
        this.f10331b = provider2;
    }

    public final void mo504a(@Nullable TimelineContextListItemFieldsModel timelineContextListItemFieldsModel, boolean z) {
        String str = null;
        if (timelineContextListItemFieldsModel != null) {
            int i;
            String str2;
            RelationshipType relationshipType = RelationshipType.getRelationshipType(this.f10335f.i(), this.f10337h.B(), this.f10337h.C());
            this.f10333d.a(this.f10335f.b, relationshipType, timelineContextListItemFieldsModel);
            if (z) {
                this.f10333d.b(this.f10335f.b, relationshipType, timelineContextListItemFieldsModel);
            }
            NodeModel c = timelineContextListItemFieldsModel.c();
            ProfileContextItemNavigationHandler profileContextItemNavigationHandler = (ProfileContextItemNavigationHandler) this.f10330a.get();
            Context context = this.f10332c;
            ProfileContextItemNavigationData.Builder builder = new ProfileContextItemNavigationData.Builder();
            if (c == null || c.b() == null) {
                i = 0;
            } else {
                i = c.b().g();
            }
            builder.a = i;
            builder = builder;
            if (c == null || c.d() == null) {
                str2 = null;
            } else {
                str2 = c.d();
            }
            builder.b = str2;
            builder = builder;
            if (c == null || c.dt_() == null) {
                str2 = null;
            } else {
                str2 = c.dt_().b();
            }
            builder.c = str2;
            ProfileContextItemNavigationData.Builder builder2 = builder;
            if (!(c == null || c.c() == null)) {
                str = c.c().b();
            }
            builder2.d = str;
            builder2 = builder2;
            builder2.e = FullscreenGallerySource.TIMELINE_CONTEXT_ITEM;
            builder2 = builder2;
            builder2.f = timelineContextListItemFieldsModel.d();
            builder2 = builder2;
            builder2.g = this.f10337h.E();
            builder2 = builder2;
            builder2.h = this.f10337h.N();
            builder2 = builder2;
            builder2.i = this.f10337h.L();
            builder2 = builder2;
            builder2.j = this.f10337h.U();
            builder2 = builder2;
            builder2.k = "timeline_context_item";
            builder2 = builder2;
            builder2.l = timelineContextListItemFieldsModel.ds_();
            builder2 = builder2;
            builder2.m = this.f10337h.B().toString();
            builder2 = builder2;
            builder2.n = this.f10337h.C().toString();
            builder2 = builder2;
            builder2.o = this.f10337h.y();
            profileContextItemNavigationHandler.a(context, builder2.a());
        }
    }

    public final void mo503a() {
        if (this.f10334e != null) {
            this.f10334e.m10555a().m10615a(new C15211(this));
            this.f10336g.g();
            ((TimelineHeaderEventBus) this.f10331b.get()).a(new AdapterDataChangedEvent());
        }
    }
}
