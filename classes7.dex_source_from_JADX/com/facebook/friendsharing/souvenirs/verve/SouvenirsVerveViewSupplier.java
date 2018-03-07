package com.facebook.friendsharing.souvenirs.verve;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.UriUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.friendsharing.souvenirs.protocols.FetchSouvenirsInterfaces.SouvenirsDetailsFields;
import com.facebook.friendsharing.souvenirs.protocols.FetchSouvenirsInterfaces.SouvenirsMediaElementFields;
import com.facebook.friendsharing.souvenirs.protocols.FetchSouvenirsModels.SouvenirsDetailsFieldsModel.MediaElementsModel.EdgesModel;
import com.facebook.friendsharing.souvenirs.protocols.FetchSouvenirsModels.SouvenirsMediaElementFieldsModel;
import com.facebook.friendsharing.souvenirs.protocols.FetchSouvenirsModels.SouvenirsMediaFieldsModel;
import com.facebook.friendsharing.souvenirs.protocols.SouvenirsConversionHelper;
import com.facebook.friendsharing.souvenirs.ui.SouvenirsBurstView;
import com.facebook.friendsharing.souvenirs.ui.SouvenirsImageView;
import com.facebook.friendsharing.souvenirs.util.SouvenirsElementHelper;
import com.facebook.graphql.enums.GraphQLSouvenirMediaFieldType;
import com.facebook.graphql.model.GraphQLPhoto;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.greetingcards.verve.VerveViewSupplier.RecyclerType;
import com.facebook.greetingcards.verve.model.VMSlide;
import com.facebook.greetingcards.verve.model.VMView;
import com.facebook.greetingcards.verve.render.VerveVideoContainer;
import com.facebook.greetingcards.vervecontrols.VerveViewSupplierDefault;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.mediagallery.MediaGalleryLauncherParamsFactory;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncher;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncherParams.Builder;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.video.activity.FullScreenVideoPlayerActivity;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.StreamSourceType;
import com.facebook.video.engine.VideoDataSource;
import com.facebook.video.engine.VideoDataSourceBuilder;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.engine.VideoPlayerParamsBuilder;
import com.facebook.video.player.RichVideoPlayerParams;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import java.util.HashMap;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: PushNotifId */
public class SouvenirsVerveViewSupplier extends VerveViewSupplierDefault {
    private static final CallerContext f24248a = CallerContext.a(SouvenirsVerveViewSupplier.class, "souvenirs");
    public final Provider<MediaGalleryLauncher> f24249b;
    public final SouvenirsElementHelper f24250c;
    public final SecureContextHelper f24251d;
    public ImmutableList<GraphQLPhoto> f24252e;
    private final HashMap<String, SouvenirsMediaElementFields> f24253f = Maps.c();
    public final HashMap<String, String> f24254g = Maps.c();
    private final HashMap<String, GraphQLVideo> f24255h = Maps.c();
    private final Drawable f24256i;
    @Nullable
    public final FeedProps<GraphQLStory> f24257j;
    private final OnClickListener f24258k = new C21111(this);

    /* compiled from: PushNotifId */
    class C21111 implements OnClickListener {
        final /* synthetic */ SouvenirsVerveViewSupplier f24244a;

        C21111(SouvenirsVerveViewSupplier souvenirsVerveViewSupplier) {
            this.f24244a = souvenirsVerveViewSupplier;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -874221047);
            if (this.f24244a.f24252e == null || this.f24244a.f24252e.isEmpty()) {
                Logger.a(2, EntryType.UI_INPUT_END, -63190887, a);
                return;
            }
            String d;
            String str;
            String c;
            String g;
            String ai;
            boolean p;
            ArrayNode a2;
            if (view instanceof SouvenirsBurstView) {
                SouvenirsBurstView souvenirsBurstView = (SouvenirsBurstView) view;
                if (souvenirsBurstView.f24207m != null) {
                    SouvenirsElementHelper souvenirsElementHelper = this.f24244a.f24250c;
                    SouvenirsMediaFieldsModel a3 = SouvenirsElementHelper.m26461a(souvenirsBurstView.f24207m);
                    if (a3 != null) {
                        d = a3.m26385d();
                        str = d;
                    }
                }
                d = null;
                str = d;
            } else {
                d = ((SouvenirsImageView) view).f24209c.toString();
                str = this.f24244a.f24254g.containsKey(d) ? (String) this.f24244a.f24254g.get(d) : null;
            }
            if (this.f24244a.f24257j != null) {
                c = ((GraphQLStory) this.f24244a.f24257j.a).c();
                g = ((GraphQLStory) this.f24244a.f24257j.a).g();
                ai = ((GraphQLStory) this.f24244a.f24257j.a).ai();
                p = StoryProps.p(this.f24244a.f24257j);
                a2 = TrackableFeedProps.a(this.f24244a.f24257j);
            } else {
                p = false;
                c = null;
                g = null;
                ai = null;
                a2 = null;
            }
            MediaGalleryLauncherParamsFactory mediaGalleryLauncherParamsFactory = new MediaGalleryLauncherParamsFactory();
            Builder a4 = MediaGalleryLauncherParamsFactory.m12746b(ImmutableList.copyOf(this.f24244a.f24252e)).m12720a(FullscreenGallerySource.SOUVENIRS);
            a4.f10661m = true;
            Builder a5 = a4.m12723a(str);
            a5.f10656h = g;
            a5 = a5;
            a5.f10657i = ai;
            a5 = a5;
            a5.f10659k = c;
            a5 = a5;
            if (a2 != null) {
                d = a2.toString();
            } else {
                d = null;
            }
            a5.f10658j = d;
            Builder builder = a5;
            builder.f10660l = p;
            ((MediaGalleryLauncher) this.f24244a.f24249b.get()).mo602a(view.getContext(), builder.m12726b(), null);
            LogUtils.a(-1854564989, a);
        }
    }

    /* compiled from: PushNotifId */
    public enum SouvenirsViewRecyclerTypes implements RecyclerType {
        BURST_VIEW
    }

    @Inject
    public SouvenirsVerveViewSupplier(Provider<MediaGalleryLauncher> provider, SouvenirsElementHelper souvenirsElementHelper, Resources resources, SecureContextHelper secureContextHelper, @Assisted SouvenirsDetailsFields souvenirsDetailsFields, @Nullable @Assisted FeedProps feedProps) {
        this.f24249b = provider;
        this.f24250c = souvenirsElementHelper;
        this.f24251d = secureContextHelper;
        ImmutableList a = souvenirsDetailsFields.m26305c().m26298a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            SouvenirsMediaElementFieldsModel a2 = ((EdgesModel) a.get(i)).m26292a();
            SouvenirsMediaFieldsModel a3 = SouvenirsElementHelper.m26461a(a2);
            if (a2.m26330d() == GraphQLSouvenirMediaFieldType.BURST) {
                this.f24253f.put(a2.m26328b(), a2);
            } else {
                if (a3 != null) {
                    GraphQLVideo b = SouvenirsConversionHelper.m26433b(a3);
                    if (b != null) {
                        this.f24255h.put(b.aE(), b);
                    }
                }
                if (!(a3 == null || a3.m26383b() == null || a3.m26383b().g() != 77090322)) {
                    this.f24254g.put(a3.bc_().b(), a3.m26385d());
                }
            }
        }
        this.f24257j = feedProps;
        this.f24252e = SouvenirsElementHelper.m26462a(souvenirsDetailsFields, true);
        this.f24256i = new ColorDrawable(resources.getColor(2131363642));
    }

    public final ImageView mo1608a(Context context, VMView vMView) {
        if (this.f24253f.containsKey(vMView.src)) {
            return new SouvenirsBurstView(context);
        }
        return new SouvenirsImageView(context);
    }

    public final void mo1609a(VMView vMView, VMSlide vMSlide, ImmutableMap<String, String> immutableMap, @Nullable Drawable drawable, ImageView imageView) {
        imageView.setImageDrawable(null);
        imageView.setOnClickListener(null);
        String str = vMView.src;
        if (str != null) {
            if (this.f24253f.containsKey(str) && ((SouvenirsMediaElementFieldsModel) this.f24253f.get(str)).m26330d() == GraphQLSouvenirMediaFieldType.BURST) {
                SouvenirsBurstView souvenirsBurstView = (SouvenirsBurstView) imageView;
                souvenirsBurstView.m26450a((SouvenirsMediaElementFieldsModel) this.f24253f.get(str));
                souvenirsBurstView.setOnClickListener(this.f24258k);
                return;
            }
            SouvenirsImageView souvenirsImageView = (SouvenirsImageView) imageView;
            if (!Strings.isNullOrEmpty(str)) {
                souvenirsImageView.a(Uri.parse(vMView.src), f24248a);
            }
            souvenirsImageView.setOnClickListener(null);
            GenericDraweeHierarchyBuilder e = new GenericDraweeHierarchyBuilder(imageView.getContext().getResources()).e(ScaleType.h);
            e.f = this.f24256i;
            Context context = souvenirsImageView.getContext();
            if (vMSlide.name.startsWith("Cover_0")) {
                RoundingParams roundingParams = new RoundingParams();
                roundingParams.b = true;
                e.u = roundingParams;
                souvenirsImageView.setContentDescription(context.getString(2131230842));
            } else {
                souvenirsImageView.setOnClickListener(this.f24258k);
                souvenirsImageView.setContentDescription(context.getString(2131230814));
            }
            GenericDraweeHierarchy u = e.u();
            if (vMView.b != null) {
                u.a(vMView.b);
            }
            souvenirsImageView.setHierarchy(u);
        }
    }

    public final View mo1607b(Context context, VMView vMView) {
        return new SouvenirVerveVideoView(context);
    }

    public final void mo1606a(VMView vMView, ImmutableMap<String, String> immutableMap, VerveVideoContainer verveVideoContainer) {
        boolean z = true;
        final SouvenirVerveVideoView souvenirVerveVideoView = (SouvenirVerveVideoView) verveVideoContainer;
        String str = vMView.src;
        if (!Strings.isNullOrEmpty(str) && this.f24255h.containsKey(str)) {
            final GraphQLVideo graphQLVideo = (GraphQLVideo) this.f24255h.get(str);
            ImageRequest a = ImageRequest.a(ImageUtil.a(graphQLVideo.R()));
            VideoDataSourceBuilder newBuilder = VideoDataSource.newBuilder();
            newBuilder.f = StreamSourceType.FROM_STREAM;
            newBuilder = newBuilder;
            newBuilder.a = UriUtil.a(graphQLVideo.aE());
            newBuilder = newBuilder;
            newBuilder.b = UriUtil.a(graphQLVideo.aA());
            VideoPlayerParamsBuilder a2 = VideoPlayerParams.newBuilder().a(newBuilder.i());
            a2.b = graphQLVideo.J();
            a2 = a2;
            a2.c = graphQLVideo.aD();
            a2 = a2.a(graphQLVideo.s(), graphQLVideo.G());
            if (this.f24255h.size() != 1) {
                z = false;
            }
            a2.g = z;
            VideoPlayerParams m = a2.m();
            ImmutableMap b = new ImmutableMap.Builder().b("CoverImageParamsKey", a).b("VideoAspectRatioKey", Double.valueOf((double) (vMView.h() / vMView.i()))).b();
            if (Objects.equal(m.b, souvenirVerveVideoView.f24237i)) {
                souvenirVerveVideoView.g();
                souvenirVerveVideoView.f24237i = m.b;
            }
            RichVideoPlayerParams.Builder builder = new RichVideoPlayerParams.Builder();
            builder.a = m;
            souvenirVerveVideoView.a(builder.a(b).b());
            souvenirVerveVideoView.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SouvenirsVerveViewSupplier f24247c;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -474278613);
                    souvenirVerveVideoView.b(EventTriggerType.BY_AUTOPLAY);
                    Intent a2 = FullScreenVideoPlayerActivity.a(souvenirVerveVideoView.getContext(), PlayerOrigin.VERVE);
                    FlatBufferModelHelper.a(a2, "video_graphql_object", graphQLVideo);
                    this.f24247c.f24251d.a(a2, souvenirVerveVideoView.getContext());
                    Logger.a(2, EntryType.UI_INPUT_END, -886260930, a);
                }
            });
        }
    }

    public final <T extends Enum & RecyclerType> ImmutableSet<T> mo1604a() {
        return ImmutableSet.copyOf((Enum[]) SouvenirsViewRecyclerTypes.values());
    }

    @Nullable
    public final <T extends Enum & RecyclerType> T mo1605a(VMView vMView) {
        if (this.f24253f.containsKey(vMView.src)) {
            return SouvenirsViewRecyclerTypes.BURST_VIEW;
        }
        return super.mo1605a(vMView);
    }

    public final Button mo1610c(Context context, VMView vMView) {
        return null;
    }
}
