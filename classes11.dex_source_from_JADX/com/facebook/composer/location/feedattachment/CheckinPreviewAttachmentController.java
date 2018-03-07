package com.facebook.composer.location.feedattachment;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.facebook.android.maps.StaticMapView.StaticMapOptions;
import com.facebook.checkin.abtest.ExperimentsForCheckinAbTestModule;
import com.facebook.checkin.rows.BaseCheckinStoryPartDefinition;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.composer.activity.ComposerFragment;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass34;
import com.facebook.composer.activity.ComposerMutatorImpl;
import com.facebook.composer.activity.TransactionImpl;
import com.facebook.composer.analytics.ComposerAnalyticsLogger;
import com.facebook.composer.analytics.ComposerAnalyticsLogger.Events;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.composer.feedattachment.ComposerFeedAttachmentController;
import com.facebook.composer.location.feedattachment.FetchCheckinComposerPreview.FetchCheckinComposerPreviewString;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.fbui.widget.text.ImageWithTextView;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.RowKey;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLLocation;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStory.Builder;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerMutator;
import com.facebook.ipc.composer.dataaccessor.ComposerTransaction;
import com.facebook.ipc.composer.model.ComposerContentType;
import com.facebook.ipc.composer.model.ComposerContentType.ProvidesContentType;
import com.facebook.ipc.composer.model.ComposerLocationInfo;
import com.facebook.ipc.composer.model.ComposerLocationInfo.ProvidesLocationInfo;
import com.facebook.ipc.composer.model.ComposerLocationInfo.SetsLocationInfo;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.maps.FbStaticMapView;
import com.facebook.maps.rows.MapPartDefinition;
import com.facebook.maps.rows.MapPartDefinition.Props;
import com.facebook.maps.rows.MapSizeHelper;
import com.facebook.maps.rows.StaticMapOptionsHelper;
import com.facebook.multirow.api.Environments;
import com.facebook.multirow.api.renderers.SimpleRenderer;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel.LocationModel;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.google.common.base.Absent;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.lang.ref.WeakReference;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: from_network */
public class CheckinPreviewAttachmentController<DataProvider extends ProvidesContentType & ProvidesLocationInfo, Transaction extends ComposerTransaction & SetsLocationInfo<Transaction>> implements ComposerFeedAttachmentController {
    private static final String f6707a = CheckinPreviewAttachmentController.class.getSimpleName();
    private static final ComposerEventOriginator f6708b = ComposerEventOriginator.a(CheckinPreviewAttachmentController.class);
    public static final ImmutableList<GraphQLStoryAttachmentStyle> f6709c = ImmutableList.of(GraphQLStoryAttachmentStyle.FALLBACK);
    private final WeakReference<DataProvider> f6710d;
    private final WeakReference<ComposerMutator<Transaction>> f6711e;
    public final AnonymousClass34 f6712f;
    private final AbstractFbErrorReporter f6713g;
    private final ComposerAnalyticsLogger f6714h;
    private final QeAccessor f6715i;
    private final GraphQLQueryExecutor f6716j;
    private final GraphQLImageHelper f6717k;
    private final Resources f6718l;
    private final MapPartDefinition f6719m;
    private final BaseCheckinStoryPartDefinition f6720n;
    private final GlyphColorizer f6721o;
    private final MapSizeHelper f6722p;
    private boolean f6723q;
    private boolean f6724r;

    /* compiled from: from_network */
    class C08511 implements OnClickListener {
        final /* synthetic */ CheckinPreviewAttachmentController f6705a;

        C08511(CheckinPreviewAttachmentController checkinPreviewAttachmentController) {
            this.f6705a = checkinPreviewAttachmentController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -673529901);
            AnonymousClass34 anonymousClass34 = this.f6705a.f6712f;
            anonymousClass34.f6065a.bJ.a(Events.CHECKIN_PREVIEW_ADD_PHOTO_CLICKED);
            ComposerFragment.bZ(anonymousClass34.f6065a);
            Logger.a(2, EntryType.UI_INPUT_END, -1356000340, a);
        }
    }

    /* compiled from: from_network */
    class C08522 implements Function<GraphQLResult<GraphQLPlace>, GraphQLStoryAttachment> {
        final /* synthetic */ CheckinPreviewAttachmentController f6706a;

        C08522(CheckinPreviewAttachmentController checkinPreviewAttachmentController) {
            this.f6706a = checkinPreviewAttachmentController;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null) {
                return null;
            }
            Builder builder = new Builder();
            builder.B = (GraphQLPlace) graphQLResult.e;
            GraphQLStory a = builder.a();
            GraphQLNode.Builder builder2 = new GraphQLNode.Builder();
            builder2.iS = a;
            GraphQLNode a2 = builder2.a();
            GraphQLStoryAttachment.Builder builder3 = new GraphQLStoryAttachment.Builder();
            builder3.q = CheckinPreviewAttachmentController.f6709c;
            builder3 = builder3;
            builder3.t = a2;
            return builder3.a();
        }
    }

    /* compiled from: from_network */
    class CheckinPreviewEnvironment implements HasPrefetcher, HasRowKey {
        public final RowKey m8120m() {
            return null;
        }

        public final void m8118a(RowKey rowKey) {
        }

        public final void m8121n() {
        }

        public final boolean m8122o() {
            return false;
        }

        public final void m8119a(ImageRequest imageRequest, CallerContext callerContext) {
        }
    }

    @Inject
    public CheckinPreviewAttachmentController(@Assisted DataProvider dataProvider, @Assisted ComposerMutator<Transaction> composerMutator, @Assisted Callback callback, FbErrorReporter fbErrorReporter, ComposerAnalyticsLogger composerAnalyticsLogger, QeAccessor qeAccessor, MapPartDefinition mapPartDefinition, GraphQLQueryExecutor graphQLQueryExecutor, GraphQLImageHelper graphQLImageHelper, Resources resources, BaseCheckinStoryPartDefinition baseCheckinStoryPartDefinition, GlyphColorizer glyphColorizer, MapSizeHelper mapSizeHelper) {
        this.f6710d = new WeakReference(Preconditions.checkNotNull(dataProvider));
        this.f6711e = new WeakReference(Preconditions.checkNotNull(composerMutator));
        this.f6712f = callback;
        this.f6713g = fbErrorReporter;
        this.f6714h = composerAnalyticsLogger;
        this.f6715i = qeAccessor;
        this.f6719m = mapPartDefinition;
        this.f6716j = graphQLQueryExecutor;
        this.f6717k = graphQLImageHelper;
        this.f6718l = resources;
        this.f6720n = baseCheckinStoryPartDefinition;
        this.f6721o = glyphColorizer;
        this.f6722p = mapSizeHelper;
    }

    public final View mo192a(GraphQLStoryAttachment graphQLStoryAttachment, ViewGroup viewGroup) {
        LocationModel cg_ = ((ProvidesLocationInfo) ((ProvidesContentType) this.f6710d.get())).g().a().cg_();
        if (!this.f6723q) {
            this.f6723q = true;
            this.f6714h.a(Events.CHECKIN_PREVIEW_SEEN);
        }
        GraphQLLocation.Builder builder = new GraphQLLocation.Builder();
        builder.d = cg_.a();
        builder = builder;
        builder.e = cg_.b();
        StaticMapOptions a = StaticMapOptionsHelper.a(null, "checkin_story_preview", builder.a());
        SimpleRenderer simpleRenderer = new SimpleRenderer(this.f6719m, Environments.a);
        int a2 = this.f6722p.a(null);
        int a3 = this.f6722p.a();
        if (this.f6715i.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForCheckinAbTestModule.c, false)) {
            a3 = MapSizeHelper.a(a2, 1.9f);
        }
        simpleRenderer.a(new Props(a, true, a2, a3));
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2130903564, viewGroup, false);
        simpleRenderer.a((FbStaticMapView) inflate.findViewById(2131560312));
        simpleRenderer = new SimpleRenderer(this.f6720n, new CheckinPreviewEnvironment());
        simpleRenderer.a(new BaseCheckinStoryPartDefinition.Props(graphQLStoryAttachment.z().hO(), graphQLStoryAttachment.z().hO().Y(), false));
        simpleRenderer.a((ImageBlockLayout) inflate.findViewById(2131562015));
        if (this.f6715i.a(ExperimentsForCheckinAbTestModule.g, false)) {
            m8123a(inflate);
        }
        return inflate;
    }

    private void m8123a(View view) {
        ImageWithTextView imageWithTextView;
        if (this.f6715i.a(ExperimentsForCheckinAbTestModule.i, false)) {
            imageWithTextView = (ImageWithTextView) ((ViewStub) view.findViewById(2131560314)).inflate();
            imageWithTextView.setImageDrawable(this.f6721o.a(2130839751, -1));
        } else {
            imageWithTextView = (ImageWithTextView) ((ViewStub) view.findViewById(2131560313)).inflate();
        }
        imageWithTextView.setOnClickListener(new C08511(this));
    }

    public final ListenableFuture<GraphQLStoryAttachment> mo195d() {
        CheckinPlaceModel a = ((ProvidesLocationInfo) ((ProvidesContentType) Preconditions.checkNotNull(this.f6710d.get()))).g().a();
        GraphQlQueryString fetchCheckinComposerPreviewString = new FetchCheckinComposerPreviewString();
        fetchCheckinComposerPreviewString.a("page_id", a.cf_()).a("profile_image_size", GraphQLImageHelper.a(this.f6718l.getDimensionPixelSize(2131429240)));
        return Futures.a(this.f6716j.a(GraphQLRequest.a(fetchCheckinComposerPreviewString)), new C08522(this), MoreExecutors.a());
    }

    public final List<GraphQLStoryAttachmentStyle> mo194c() {
        return f6709c;
    }

    public final Optional<GraphQLStoryAttachment> mo193a(Throwable th) {
        this.f6713g.a(f6707a, th);
        return Absent.INSTANCE;
    }

    public final boolean mo196e() {
        return ((ProvidesContentType) Preconditions.checkNotNull(this.f6710d.get())).c() == ComposerContentType.CHECKIN;
    }

    public final boolean mo197f() {
        return false;
    }

    public final View mo191a(Context context, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(2130905288, viewGroup, false);
    }

    public final String mo198g() {
        return String.valueOf(((ProvidesLocationInfo) ((ProvidesContentType) Preconditions.checkNotNull(this.f6710d.get()))).g().j());
    }

    public final void mo199h() {
        TransactionImpl a = ((ComposerMutatorImpl) Preconditions.checkNotNull(this.f6711e.get())).m7626a(f6708b);
        ComposerLocationInfo.Builder a2 = ComposerLocationInfo.a(((ProvidesLocationInfo) ((ProvidesContentType) Preconditions.checkNotNull(this.f6710d.get()))).g());
        a2.b = true;
        ((TransactionImpl) a.m7685a(a2.b())).m7689a();
        if (!this.f6724r) {
            this.f6724r = true;
            this.f6714h.a(Events.CHECKIN_PREVIEW_DISMISSED);
        }
    }

    public final void mo200i() {
    }

    public final View mo201j() {
        return null;
    }

    public final boolean mo202k() {
        return false;
    }
}
