package com.facebook.composer.feedattachment.minutiae;

import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLInterfaces.EventAttachment;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.EventAttachmentModel.EventCoverPhotoModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.EventAttachmentModel.EventCoverPhotoModel.PhotoModel;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.Executor_SameThreadExecutorMethodAutoProvider;
import com.facebook.common.util.UriUtil;
import com.facebook.composer.feedattachment.graphql.ComposerAttachmentModelConversionHelper;
import com.facebook.composer.feedattachment.graphql.FetchEventComposerPreview.FetchEventComposerPreviewString;
import com.facebook.composer.feedattachment.graphql.FetchEventComposerPreviewModels.EventStoryAttachmentModel;
import com.facebook.composer.feedattachment.graphql.FetchEventComposerPreviewModels.FetchEventComposerPreviewModel;
import com.facebook.composer.feedattachment.minutiae.MinutiaeAttachmentController.SubController;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbPipelineDraweeController;
import com.facebook.events.common.EventsDateUtil;
import com.facebook.events.widget.eventcard.EventAttachmentUtil;
import com.facebook.events.widget.eventcard.EventsCardView;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLFocusedPhoto;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLPhoto;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachment.Builder;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.GraphQLVect2;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.story.GraphQLStoryHelper;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Date;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: getgames_activity_start */
public class EventComposerAttachmentController implements SubController {
    public static final CallerContext f6518a = CallerContext.a(EventComposerAttachmentController.class);
    private final GraphQLQueryExecutor f6519b;
    private final GraphQLStoryHelper f6520c;
    private final Executor f6521d;
    public final Provider<FbDraweeControllerBuilder> f6522e;

    /* compiled from: getgames_activity_start */
    class C08281 implements Function<GraphQLResult<FetchEventComposerPreviewModel>, GraphQLStoryAttachment> {
        final /* synthetic */ EventComposerAttachmentController f6517a;

        C08281(EventComposerAttachmentController eventComposerAttachmentController) {
            this.f6517a = eventComposerAttachmentController;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null) {
                return null;
            }
            GraphQLStoryAttachment graphQLStoryAttachment;
            EventStoryAttachmentModel a = ((FetchEventComposerPreviewModel) graphQLResult.e).m7959a();
            if (a == null) {
                graphQLStoryAttachment = null;
            } else {
                GraphQLNode graphQLNode;
                Builder builder = new Builder();
                builder.q = a.m7953a();
                EventAttachment b = a.m7954b();
                if (b == null) {
                    graphQLNode = null;
                } else {
                    GraphQLFocusedPhoto graphQLFocusedPhoto;
                    GraphQLNode.Builder builder2 = new GraphQLNode.Builder();
                    builder2.kQ = new GraphQLObjectType(67338874);
                    builder2.aE = b.b();
                    builder2.bu = b.c();
                    builder2.ch = b.d();
                    EventCoverPhotoModel bv_ = b.bv_();
                    if (bv_ == null) {
                        graphQLFocusedPhoto = null;
                    } else {
                        GraphQLPhoto graphQLPhoto;
                        GraphQLFocusedPhoto.Builder builder3 = new GraphQLFocusedPhoto.Builder();
                        PhotoModel a2 = bv_.a();
                        if (a2 == null) {
                            graphQLPhoto = null;
                        } else {
                            GraphQLImage graphQLImage;
                            GraphQLTextWithEntities graphQLTextWithEntities;
                            GraphQLPhoto.Builder builder4 = new GraphQLPhoto.Builder();
                            builder4.F = a2.b();
                            DefaultImageFields c = a2.c();
                            if (c == null) {
                                graphQLImage = null;
                            } else {
                                GraphQLImage.Builder builder5 = new GraphQLImage.Builder();
                                builder5.d = c.a();
                                builder5.g = c.b();
                                builder5.h = c.c();
                                graphQLImage = builder5.a();
                            }
                            builder4.G = graphQLImage;
                            DefaultTextWithEntitiesFields d = a2.d();
                            if (d == null) {
                                graphQLTextWithEntities = null;
                            } else {
                                GraphQLTextWithEntities.Builder builder6 = new GraphQLTextWithEntities.Builder();
                                builder6.i = d.a();
                                graphQLTextWithEntities = builder6.a();
                            }
                            builder4.as = graphQLTextWithEntities;
                            builder4.aW = a2.bw_();
                            graphQLPhoto = builder4.a();
                        }
                        builder3.e = graphQLPhoto;
                        graphQLFocusedPhoto = builder3.a();
                    }
                    builder2.cr = graphQLFocusedPhoto;
                    builder2.cx = ComposerAttachmentModelConversionHelper.m7946a(b.g());
                    builder2.dK = b.bt_();
                    builder2.eb = b.bu_();
                    builder2.fw = b.j();
                    builder2.iO = b.k();
                    builder2.jy = b.l();
                    builder2.kf = b.m();
                    builder2.a(b.n());
                    boolean o = b.o();
                    builder2.kx = o;
                    if (builder2.a != null && builder2.a.d) {
                        builder2.a.a(builder2.b, 529, o);
                    }
                    builder2.a(b.p());
                    graphQLNode = builder2.a();
                }
                builder.t = graphQLNode;
                graphQLStoryAttachment = builder.a();
            }
            return graphQLStoryAttachment;
        }
    }

    public static EventComposerAttachmentController m7969b(InjectorLike injectorLike) {
        return new EventComposerAttachmentController(GraphQLQueryExecutor.a(injectorLike), GraphQLStoryHelper.a(injectorLike), Executor_SameThreadExecutorMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 1117));
    }

    public final ListenableFuture<GraphQLStoryAttachment> mo204a(MinutiaeObject minutiaeObject) {
        GraphQlQueryString fetchEventComposerPreviewString = new FetchEventComposerPreviewString();
        fetchEventComposerPreviewString.a("angora_attachment_cover_image_size", this.f6520c.r()).a("event_id", minutiaeObject.object.k().d());
        return Futures.a(this.f6519b.a(GraphQLRequest.a(fetchEventComposerPreviewString)), new C08281(this), this.f6521d);
    }

    @Inject
    public EventComposerAttachmentController(GraphQLQueryExecutor graphQLQueryExecutor, GraphQLStoryHelper graphQLStoryHelper, Executor executor, Provider<FbDraweeControllerBuilder> provider) {
        this.f6519b = graphQLQueryExecutor;
        this.f6520c = graphQLStoryHelper;
        this.f6522e = provider;
        this.f6521d = executor;
    }

    public final View mo203a(GraphQLStoryAttachment graphQLStoryAttachment, ViewGroup viewGroup) {
        GraphQLNode z = graphQLStoryAttachment.z();
        Preconditions.checkNotNull(z);
        Date c = EventsDateUtil.c(z.hK());
        GraphQLPlace cl = z.cl();
        CharSequence a = EventAttachmentUtil.a(cl);
        CharSequence b = EventAttachmentUtil.b(cl);
        CharSequence a2 = EventAttachmentUtil.a(z);
        EventsCardView eventsCardView = new EventsCardView(viewGroup.getContext());
        m7968a(z, eventsCardView);
        eventsCardView.i = true;
        eventsCardView.setTitleText(z.eP());
        eventsCardView.setCalendarFormatStartDate(c);
        eventsCardView.a(a, b);
        eventsCardView.setSocialContextText(a2);
        eventsCardView.d();
        eventsCardView.setBackgroundResource(2130840254);
        eventsCardView.f();
        return eventsCardView;
    }

    private void m7968a(GraphQLNode graphQLNode, EventsCardView eventsCardView) {
        GraphQLFocusedPhoto cf = graphQLNode.cf();
        if (cf != null) {
            FbPipelineDraweeController s;
            GraphQLPhoto j = cf.j();
            if (j == null || j.L() == null) {
                s = ((FbDraweeControllerBuilder) this.f6522e.get()).a(f6518a).s();
            } else {
                s = ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f6522e.get()).a(f6518a).a(j.L().b()).d(ImageRequest.a(UriUtil.a(j.L().b())))).s();
            }
            eventsCardView.setCoverPhotoController(s);
            if (cf.a() != null) {
                GraphQLVect2 a = cf.a();
                eventsCardView.setCoverPhotoFocusPoint(new PointF((float) a.a(), (float) a.b()));
            }
        }
    }
}
