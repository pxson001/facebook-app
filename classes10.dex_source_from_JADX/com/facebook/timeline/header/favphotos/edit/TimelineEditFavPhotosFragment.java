package com.facebook.timeline.header.favphotos.edit;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.build.IsWorkBuild;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.FindViewUtil;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.OnCancelListener;
import com.facebook.fbui.popover.PopoverWindow.OnDismissListener;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.fig.button.FigButton;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.calls.ProfileIntroCardPhotosSetInputData;
import com.facebook.graphql.calls.ProfileIntroCardPhotosSetInputData.PublishFeedStory;
import com.facebook.graphql.error.GraphQLException;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.request.MutationRequest;
import com.facebook.graphql.model.GraphQLPhoto;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.ipc.media.MediaItem;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.resources.ui.FbTextView;
import com.facebook.timeline.header.favphotos.FavoritePhotosUtil;
import com.facebook.timeline.header.favphotos.IntroCardFavPhotosPostToFeedNuxInterstitialController;
import com.facebook.timeline.header.favphotos.edit.FetchFavoritePhotoController.C16771;
import com.facebook.timeline.header.favphotos.edit.UploadFavoritePhotoController.C16871;
import com.facebook.timeline.header.intro.IntroCardShareToNewsfeedController;
import com.facebook.timeline.header.intro.IntroCardShareToNewsfeedController.FeedSharingSwitchNuxProvider;
import com.facebook.timeline.header.intro.IntroCardShareToNewsfeedControllerProvider;
import com.facebook.timeline.header.intro.protocol.FavPhotosQueryExecutor;
import com.facebook.timeline.logging.TimelineAnalyticsLogger;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLInterfaces.FavoritePhoto;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.FavoritePhotoModel;
import com.facebook.timeline.protocol.ProfileIntroCardMutation.ProfileIntroCardFavPhotosMutationString;
import com.facebook.timeline.protocol.ProfileIntroCardMutationModels.ProfileIntroCardFavPhotosMutationModel;
import com.facebook.timeline.protocol.TimelineCommonGraphQL;
import com.facebook.timeline.protocol.TimelineCommonGraphQL.TimelinePhotoUriQueryString;
import com.facebook.widget.mosaic.MosaicGridLayout;
import com.facebook.widget.mosaic.MosaicGridLayout.LayoutParams;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpecCache;
import com.facebook.widget.titlebar.TitleBarButtonSpecCacheProvider;
import com.facebook.work.config.String_WorkCommunityNameMethodAutoProvider;
import com.facebook.work.config.community.WorkCommunityName;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: fetch_photos_header */
public class TimelineEditFavPhotosFragment extends FbFragment implements FeedSharingSwitchNuxProvider {
    public static final CallerContext at = CallerContext.a(TimelineEditFavPhotosFragment.class, "timeline");
    @Inject
    AllCapsTransformationMethod f11800a;
    public MosaicGridLayout aA;
    private FbTitleBar aB;
    public OnClickListener aC;
    public OnCancelListener aD;
    public OnDismissListener aE;
    public int aF = -1;
    public AutoRotateDrawable aG;
    public long aH;
    public boolean aI;
    @Inject
    public Lazy<SecureContextHelper> al;
    @Inject
    @LoggedInUserId
    Provider<String> am;
    @Inject
    TitleBarButtonSpecCacheProvider an;
    @Inject
    @IsWorkBuild
    public Boolean ao;
    @Inject
    @WorkCommunityName
    public String ap;
    @Inject
    QeAccessor aq;
    @Inject
    RTLUtil ar;
    @Inject
    IntroCardShareToNewsfeedControllerProvider as;
    public IntroCardShareToNewsfeedController au;
    private TitleBarButtonSpecCache av;
    public AddFavoritePhotoIntentHandler aw;
    public ArrayList<FavoritePhoto> ax;
    public List<View> ay;
    public FigButton az;
    @Inject
    AddFavoritePhotoIntentHandlerProvider f11801b;
    @Inject
    Provider<UploadFavoritePhotoController> f11802c;
    @Inject
    Provider<FetchFavoritePhotoController> f11803d;
    @Inject
    @ForUiThread
    public Executor f11804e;
    @Inject
    public TimelineSaveFavPhotosController f11805f;
    @Inject
    public TimelineAnalyticsLogger f11806g;
    @Inject
    IntroCardFavPhotosPostToFeedNuxInterstitialController f11807h;
    @Inject
    public Lazy<UriIntentMapper> f11808i;

    /* compiled from: fetch_photos_header */
    class C16781 implements OnCancelListener {
        final /* synthetic */ TimelineEditFavPhotosFragment f11788a;

        C16781(TimelineEditFavPhotosFragment timelineEditFavPhotosFragment) {
            this.f11788a = timelineEditFavPhotosFragment;
        }

        public final boolean m11860a() {
            TimelineEditFavPhotosFragment.m11869a(this.f11788a, true);
            return false;
        }
    }

    /* compiled from: fetch_photos_header */
    class C16792 implements OnDismissListener {
        final /* synthetic */ TimelineEditFavPhotosFragment f11789a;

        C16792(TimelineEditFavPhotosFragment timelineEditFavPhotosFragment) {
            this.f11789a = timelineEditFavPhotosFragment;
        }

        public final boolean m11861a(PopoverWindow popoverWindow) {
            TimelineEditFavPhotosFragment.m11869a(this.f11789a, true);
            return false;
        }
    }

    /* compiled from: fetch_photos_header */
    class C16803 implements OnClickListener {
        final /* synthetic */ TimelineEditFavPhotosFragment f11790a;

        C16803(TimelineEditFavPhotosFragment timelineEditFavPhotosFragment) {
            this.f11790a = timelineEditFavPhotosFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1641457597);
            TimelineEditFavPhotosFragment.m11869a(this.f11790a, false);
            this.f11790a.aF = -1;
            if (view.getTag().equals("button")) {
                this.f11790a.f11806g.h(this.f11790a.aH);
            }
            if (view.getTag().equals("tile")) {
                this.f11790a.f11806g.i(this.f11790a.aH);
            }
            this.f11790a.aw.m11844a(this.f11790a, view, null, this.f11790a.aD, this.f11790a.aE);
            Logger.a(2, EntryType.UI_INPUT_END, -301270272, a);
        }
    }

    /* compiled from: fetch_photos_header */
    class C16814 implements FutureCallback<String> {
        final /* synthetic */ TimelineEditFavPhotosFragment f11791a;

        C16814(TimelineEditFavPhotosFragment timelineEditFavPhotosFragment) {
            this.f11791a = timelineEditFavPhotosFragment;
        }

        public void onSuccess(Object obj) {
            TimelineEditFavPhotosFragment.m11868a(this.f11791a, (String) obj);
        }

        public void onFailure(Throwable th) {
            if (this.f11791a.hn_()) {
                TimelineEditFavPhotosFragment.av(this.f11791a);
            }
        }
    }

    /* compiled from: fetch_photos_header */
    class C16825 implements FutureCallback<FavoritePhoto> {
        final /* synthetic */ TimelineEditFavPhotosFragment f11792a;

        C16825(TimelineEditFavPhotosFragment timelineEditFavPhotosFragment) {
            this.f11792a = timelineEditFavPhotosFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            FavoritePhotoModel favoritePhotoModel = (FavoritePhotoModel) obj;
            if (!this.f11792a.hn_()) {
                return;
            }
            if (favoritePhotoModel == null) {
                TimelineEditFavPhotosFragment.av(this.f11792a);
                return;
            }
            TimelineEditFavPhotosFragment.m11867a(this.f11792a, favoritePhotoModel);
            TimelineEditFavPhotosFragment.as(this.f11792a);
        }

        public void onFailure(Throwable th) {
            if (this.f11792a.hn_()) {
                TimelineEditFavPhotosFragment.av(this.f11792a);
            }
        }
    }

    /* compiled from: fetch_photos_header */
    class C16836 extends OnToolbarButtonListener {
        final /* synthetic */ TimelineEditFavPhotosFragment f11793a;

        C16836(TimelineEditFavPhotosFragment timelineEditFavPhotosFragment) {
            this.f11793a = timelineEditFavPhotosFragment;
        }

        public final void m11862a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            Enum enumR;
            TimelineEditFavPhotosFragment timelineEditFavPhotosFragment = this.f11793a;
            ProgressDialog a = ProgressDialog.a(timelineEditFavPhotosFragment.getContext(), null, timelineEditFavPhotosFragment.b(2131235035), true);
            timelineEditFavPhotosFragment.f11806g.m(timelineEditFavPhotosFragment.aH);
            TimelineSaveFavPhotosController timelineSaveFavPhotosController = timelineEditFavPhotosFragment.f11805f;
            List<FavoritePhotoModel> list = timelineEditFavPhotosFragment.ax;
            boolean b = timelineEditFavPhotosFragment.au.m11887b();
            ProfileIntroCardPhotosSetInputData profileIntroCardPhotosSetInputData = new ProfileIntroCardPhotosSetInputData();
            List arrayList = new ArrayList();
            for (FavoritePhotoModel b2 : list) {
                arrayList.add(b2.b().d());
            }
            profileIntroCardPhotosSetInputData.a("photo_ids", arrayList);
            if (b) {
                enumR = PublishFeedStory.TRUE;
            } else {
                enumR = PublishFeedStory.FALSE;
            }
            profileIntroCardPhotosSetInputData.a("publish_feed_story", enumR);
            GraphQlQueryString profileIntroCardFavPhotosMutationString = new ProfileIntroCardFavPhotosMutationString();
            profileIntroCardFavPhotosMutationString.a("input", profileIntroCardPhotosSetInputData);
            MutationRequest a2 = GraphQLRequest.a(profileIntroCardFavPhotosMutationString);
            timelineSaveFavPhotosController.f11812b.a(FavPhotosQueryExecutor.f11844a);
            Futures.a(timelineSaveFavPhotosController.f11811a.a(a2), new C16847(timelineEditFavPhotosFragment, a), timelineEditFavPhotosFragment.f11804e);
        }
    }

    /* compiled from: fetch_photos_header */
    public class C16847 extends AbstractDisposableFutureCallback<GraphQLResult<ProfileIntroCardFavPhotosMutationModel>> {
        final /* synthetic */ ProgressDialog f11794a;
        final /* synthetic */ TimelineEditFavPhotosFragment f11795b;

        public C16847(TimelineEditFavPhotosFragment timelineEditFavPhotosFragment, ProgressDialog progressDialog) {
            this.f11795b = timelineEditFavPhotosFragment;
            this.f11794a = progressDialog;
        }

        protected final void m11863a(Object obj) {
            FragmentActivity o = this.f11795b.o();
            if (o != null) {
                o.setResult(-1);
                TimelineEditFavPhotosFragment timelineEditFavPhotosFragment;
                if (this.f11795b.aI) {
                    timelineEditFavPhotosFragment = this.f11795b;
                    this.f11794a.dismiss();
                    Intent a = ((UriIntentMapper) timelineEditFavPhotosFragment.f11808i.get()).a(o, StringFormatUtil.a(FBLinks.aX, new Object[]{Long.valueOf(timelineEditFavPhotosFragment.aH)}));
                    if (a != null) {
                        ((SecureContextHelper) timelineEditFavPhotosFragment.al.get()).a(a, o);
                    }
                    o.finish();
                    return;
                }
                timelineEditFavPhotosFragment = this.f11795b;
                this.f11794a.dismiss();
                o.finish();
            }
        }

        protected final void m11864a(Throwable th) {
            int a;
            if (th instanceof GraphQLException) {
                a = ((GraphQLException) th).error.a();
            } else {
                a = 0;
            }
            Toast makeText = Toast.makeText(this.f11795b.getContext(), a == 1523041 ? 2131235037 : 2131235036, 1);
            this.f11794a.dismiss();
            makeText.show();
            this.f11795b.o().setResult(0);
            this.f11795b.o().finish();
        }
    }

    /* compiled from: fetch_photos_header */
    public class C16869 implements OnClickListener {
        final /* synthetic */ TimelineEditFavPhotosFragment f11799a;

        public C16869(TimelineEditFavPhotosFragment timelineEditFavPhotosFragment) {
            this.f11799a = timelineEditFavPhotosFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1602537690);
            this.f11799a.ax.remove(view.getTag());
            TimelineEditFavPhotosFragment.ax(this.f11799a);
            Logger.a(2, EntryType.UI_INPUT_END, 320086563, a);
        }
    }

    public static void m11870a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((TimelineEditFavPhotosFragment) obj).m11865a(AllCapsTransformationMethod.a(fbInjector), (AddFavoritePhotoIntentHandlerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(AddFavoritePhotoIntentHandlerProvider.class), IdBasedProvider.a(fbInjector, 11278), IdBasedSingletonScopeProvider.a(fbInjector, 11276), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), TimelineSaveFavPhotosController.m11877a(fbInjector), TimelineAnalyticsLogger.a(fbInjector), IntroCardFavPhotosPostToFeedNuxInterstitialController.m11794a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 2436), IdBasedSingletonScopeProvider.b(fbInjector, 968), IdBasedProvider.a(fbInjector, 4442), (TitleBarButtonSpecCacheProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(TitleBarButtonSpecCacheProvider.class), Boolean_IsWorkBuildMethodAutoProvider.a(fbInjector), String_WorkCommunityNameMethodAutoProvider.a(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), RTLUtil.a(fbInjector), (IntroCardShareToNewsfeedControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(IntroCardShareToNewsfeedControllerProvider.class));
    }

    private void m11865a(AllCapsTransformationMethod allCapsTransformationMethod, AddFavoritePhotoIntentHandlerProvider addFavoritePhotoIntentHandlerProvider, Provider<UploadFavoritePhotoController> provider, Provider<FetchFavoritePhotoController> provider2, Executor executor, TimelineSaveFavPhotosController timelineSaveFavPhotosController, TimelineAnalyticsLogger timelineAnalyticsLogger, IntroCardFavPhotosPostToFeedNuxInterstitialController introCardFavPhotosPostToFeedNuxInterstitialController, Lazy<UriIntentMapper> lazy, Lazy<SecureContextHelper> lazy2, Provider<String> provider3, TitleBarButtonSpecCacheProvider titleBarButtonSpecCacheProvider, Boolean bool, String str, QeAccessor qeAccessor, RTLUtil rTLUtil, IntroCardShareToNewsfeedControllerProvider introCardShareToNewsfeedControllerProvider) {
        this.f11800a = allCapsTransformationMethod;
        this.f11801b = addFavoritePhotoIntentHandlerProvider;
        this.f11802c = provider;
        this.f11803d = provider2;
        this.f11804e = executor;
        this.f11805f = timelineSaveFavPhotosController;
        this.f11806g = timelineAnalyticsLogger;
        this.f11807h = introCardFavPhotosPostToFeedNuxInterstitialController;
        this.f11808i = lazy;
        this.al = lazy2;
        this.am = provider3;
        this.an = titleBarButtonSpecCacheProvider;
        this.ao = bool;
        this.ap = str;
        this.aq = qeAccessor;
        this.ar = rTLUtil;
        this.as = introCardShareToNewsfeedControllerProvider;
    }

    public final void m11874c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = TimelineEditFavPhotosFragment.class;
        m11870a((Object) this, getContext());
        this.au = this.as.m11889a(getContext(), this.f11807h, this);
        this.aH = Long.parseLong((String) this.am.get());
        this.aI = this.s.getBoolean("should_open_new_timeline_activity_on_save_success", false);
        AddFavoritePhotoIntentHandlerProvider addFavoritePhotoIntentHandlerProvider = this.f11801b;
        Context context = getContext();
        this.aw = new AddFavoritePhotoIntentHandler(context, this.s, (QeAccessor) QeInternalImplMethodAutoProvider.a(addFavoritePhotoIntentHandlerProvider), TimelineAnalyticsLogger.a(addFavoritePhotoIntentHandlerProvider), IdBasedSingletonScopeProvider.a(addFavoritePhotoIntentHandlerProvider, 968), IdBasedSingletonScopeProvider.a(addFavoritePhotoIntentHandlerProvider, 2347), IdBasedLazy.a(addFavoritePhotoIntentHandlerProvider, 11262), IdBasedProvider.a(addFavoritePhotoIntentHandlerProvider, 4442));
        this.aD = new C16781(this);
        this.aE = new C16792(this);
        this.aC = new C16803(this);
        if (bundle == null) {
            this.ax = (ArrayList) FlatBufferModelHelper.b(this.s, "fav_photos_extra");
        } else {
            this.ax = (ArrayList) FlatBufferModelHelper.b(bundle, "saved_fav_photos");
            this.aF = bundle.getInt("index_of_photo_to_be_replaced");
        }
        if (this.ax == null) {
            this.ax = new ArrayList();
        }
        this.ay = new ArrayList();
        this.aG = new AutoRotateDrawable(jW_().getDrawable(2130844043), 1000);
    }

    public final void m11875d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 87200114);
        super.d(bundle);
        ar();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1622348771, a);
    }

    public final View m11871a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String formatStrLocaleSafe;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -735667999);
        View inflate = layoutInflater.inflate(2130907440, viewGroup, false);
        this.au.m11886a(bundle, this.s, inflate);
        this.au.m11884a();
        if (this.ao.booleanValue()) {
            ((GlyphView) FindViewUtil.b(inflate, 2131563274)).setImageResource(2130839724);
        }
        FbTextView fbTextView = (FbTextView) FindViewUtil.b(inflate, 2131563275);
        if (this.ao.booleanValue()) {
            formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(b(2131235031), this.ap);
        } else {
            formatStrLocaleSafe = b(2131235030);
        }
        fbTextView.setText(Html.fromHtml(formatStrLocaleSafe));
        this.az = (FigButton) inflate.findViewById(2131567924);
        this.az.setTransformationMethod(this.f11800a);
        this.az.setTag("button");
        this.aA = (MosaicGridLayout) inflate.findViewById(2131567925);
        this.aA.m11833a(3, 3);
        this.aA.f11738c = true;
        int dimensionPixelSize = jW_().getDimensionPixelSize(2131429957);
        int i = (dimensionPixelSize * 2) / 3;
        this.aA.m11834a(dimensionPixelSize, i, dimensionPixelSize, i);
        int dimensionPixelSize2 = jW_().getDimensionPixelSize(2131429961);
        this.aA.m11835b(dimensionPixelSize2, dimensionPixelSize2);
        ax(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1888064703, a);
        return inflate;
    }

    public final void m11872a(int i, int i2, Intent intent) {
        if (i2 != -1) {
            this.aF = -1;
            return;
        }
        List parcelableArrayList;
        switch (i) {
            case 1:
                GraphQLPhoto graphQLPhoto = (GraphQLPhoto) FlatBufferModelHelper.a(intent.getExtras(), "photo");
                if (graphQLPhoto == null) {
                    av(this);
                    return;
                } else if (graphQLPhoto.L() == null || graphQLPhoto.L().b() == null) {
                    m11868a(this, graphQLPhoto.K());
                    return;
                } else {
                    m11867a(this, FavoritePhotosUtil.m11787a(graphQLPhoto.K(), graphQLPhoto.L().b()));
                    return;
                }
            case 2:
                at();
                parcelableArrayList = intent.getExtras().getParcelableArrayList("extra_media_items");
                if (parcelableArrayList == null || parcelableArrayList.isEmpty()) {
                    av(this);
                    return;
                } else {
                    m11866a((MediaItem) parcelableArrayList.get(0));
                    return;
                }
            case 3:
                parcelableArrayList = intent.getExtras().getParcelableArrayList("extra_media_items");
                if (parcelableArrayList == null || parcelableArrayList.isEmpty()) {
                    String string = intent.getExtras().getString("suggested_media_fb_id");
                    if (string != null) {
                        String string2 = intent.getExtras().getString("suggested_media_uri");
                        if (string2 == null) {
                            m11868a(this, string);
                            return;
                        } else {
                            m11867a(this, FavoritePhotosUtil.m11787a(string, string2));
                            return;
                        }
                    }
                    return;
                }
                at();
                m11866a((MediaItem) parcelableArrayList.get(0));
                return;
            default:
                return;
        }
    }

    public final void m11876e(Bundle bundle) {
        super.e(bundle);
        FlatBufferModelHelper.a(bundle, "saved_fav_photos", this.ax);
        bundle.putInt("index_of_photo_to_be_replaced", this.aF);
        this.au.m11885a(bundle);
    }

    private void m11866a(MediaItem mediaItem) {
        UploadFavoritePhotoController uploadFavoritePhotoController = (UploadFavoritePhotoController) this.f11802c.get();
        Futures.a(uploadFavoritePhotoController.f11815a.a(new C16871(uploadFavoritePhotoController, mediaItem)), new C16814(this), this.f11804e);
    }

    public static void m11868a(TimelineEditFavPhotosFragment timelineEditFavPhotosFragment, String str) {
        FetchFavoritePhotoController fetchFavoritePhotoController = (FetchFavoritePhotoController) timelineEditFavPhotosFragment.f11803d.get();
        int a = fetchFavoritePhotoController.f11783b.m11792a();
        Futures.a(Futures.a(fetchFavoritePhotoController.f11782a.a(GraphQLRequest.a((TimelinePhotoUriQueryString) TimelineCommonGraphQL.a().a("photo_fbId", str).a("photo_width", Integer.valueOf(a)).a("photo_height", Integer.valueOf(a)))), new C16771(fetchFavoritePhotoController, str)), new C16825(timelineEditFavPhotosFragment), timelineEditFavPhotosFragment.f11804e);
    }

    private TitleBarButtonSpecCache aq() {
        if (this.av == null) {
            this.av = this.an.a(2131234971);
        }
        return this.av;
    }

    private void ar() {
        this.aB = (FbTitleBar) o().findViewById(2131558563);
        this.aB.setButtonSpecs(aq().a());
        this.aB.setOnToolbarButtonListener(new C16836(this));
    }

    public static void as(TimelineEditFavPhotosFragment timelineEditFavPhotosFragment) {
        timelineEditFavPhotosFragment.aB.setButtonSpecs(timelineEditFavPhotosFragment.aq().a());
    }

    private void at() {
        this.aB.setButtonSpecs(aq().b());
    }

    public static void m11867a(TimelineEditFavPhotosFragment timelineEditFavPhotosFragment, FavoritePhotoModel favoritePhotoModel) {
        if (timelineEditFavPhotosFragment.aF == -1) {
            timelineEditFavPhotosFragment.ax.add(favoritePhotoModel);
        } else {
            timelineEditFavPhotosFragment.ax.remove(timelineEditFavPhotosFragment.aF);
            timelineEditFavPhotosFragment.ax.add(timelineEditFavPhotosFragment.aF, favoritePhotoModel);
            timelineEditFavPhotosFragment.aF = -1;
        }
        timelineEditFavPhotosFragment.au.m11888c();
        ax(timelineEditFavPhotosFragment);
    }

    public final Tooltip mo543b() {
        Tooltip tooltip = new Tooltip(ao(), 2);
        tooltip.t = -1;
        tooltip.b(ao().getResources().getQuantityString(2131689604, this.ax.size()));
        return tooltip;
    }

    public static void av(TimelineEditFavPhotosFragment timelineEditFavPhotosFragment) {
        Toast.makeText(timelineEditFavPhotosFragment.getContext(), 2131235038, 1).show();
        as(timelineEditFavPhotosFragment);
        m11869a(timelineEditFavPhotosFragment, true);
    }

    public static void ax(TimelineEditFavPhotosFragment timelineEditFavPhotosFragment) {
        timelineEditFavPhotosFragment.ay.clear();
        for (int i = 0; i < timelineEditFavPhotosFragment.ax.size(); i++) {
            Uri uri;
            final FavoritePhotoModel favoritePhotoModel = (FavoritePhotoModel) timelineEditFavPhotosFragment.ax.get(i);
            View inflate = LayoutInflater.from(timelineEditFavPhotosFragment.getContext()).inflate(2130907447, timelineEditFavPhotosFragment.aA, false);
            FbDraweeView fbDraweeView = (FbDraweeView) inflate.findViewById(2131567927);
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(timelineEditFavPhotosFragment.jW_());
            genericDraweeHierarchyBuilder.l = timelineEditFavPhotosFragment.aG;
            genericDraweeHierarchyBuilder = genericDraweeHierarchyBuilder.g(new ColorDrawable(timelineEditFavPhotosFragment.jW_().getColor(2131362998)));
            genericDraweeHierarchyBuilder.f = new ColorDrawable(timelineEditFavPhotosFragment.jW_().getColor(2131362148));
            fbDraweeView.setHierarchy(genericDraweeHierarchyBuilder.u());
            if (favoritePhotoModel.b() == null || favoritePhotoModel.b().g() == null || favoritePhotoModel.b().g().b() == null) {
                uri = null;
            } else {
                uri = Uri.parse(favoritePhotoModel.b().g().b());
            }
            Uri uri2 = uri;
            fbDraweeView.setContentDescription(timelineEditFavPhotosFragment.b(2131235010));
            fbDraweeView.a(uri2, at);
            fbDraweeView.setOnClickListener(new OnClickListener(timelineEditFavPhotosFragment) {
                final /* synthetic */ TimelineEditFavPhotosFragment f11798c;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1627229556);
                    TimelineEditFavPhotosFragment.m11869a(this.f11798c, false);
                    this.f11798c.f11806g.j(this.f11798c.aH);
                    this.f11798c.aF = i;
                    this.f11798c.aw.m11844a(this.f11798c, view, favoritePhotoModel.b(), this.f11798c.aD, this.f11798c.aE);
                    Logger.a(2, EntryType.UI_INPUT_END, -1636822145, a);
                }
            });
            View findViewById = inflate.findViewById(2131567928);
            timelineEditFavPhotosFragment.ay.add(findViewById);
            findViewById.setContentDescription(timelineEditFavPhotosFragment.b(2131235034));
            findViewById.setTag(favoritePhotoModel);
            findViewById.setOnClickListener(new C16869(timelineEditFavPhotosFragment));
            inflate.setLayoutParams(new LayoutParams(i % 3, i / 3, 1, 1));
            timelineEditFavPhotosFragment.aA.addView(inflate);
        }
        for (int size = timelineEditFavPhotosFragment.ax.size(); size < 5; size++) {
            View inflate2 = LayoutInflater.from(timelineEditFavPhotosFragment.getContext()).inflate(2130907431, timelineEditFavPhotosFragment.aA, false);
            inflate2.setTag("tile");
            inflate2.setOnClickListener(timelineEditFavPhotosFragment.aC);
            inflate2.setLayoutParams(new LayoutParams(size % 3, size / 3, 1, 1));
            timelineEditFavPhotosFragment.aA.addView(inflate2);
        }
        boolean z = timelineEditFavPhotosFragment.ax.size() < 5;
        timelineEditFavPhotosFragment.az.setEnabled(z);
        timelineEditFavPhotosFragment.az.setOnClickListener(z ? timelineEditFavPhotosFragment.aC : null);
    }

    public static void m11869a(TimelineEditFavPhotosFragment timelineEditFavPhotosFragment, boolean z) {
        for (View enabled : timelineEditFavPhotosFragment.ay) {
            enabled.setEnabled(z);
        }
    }
}
