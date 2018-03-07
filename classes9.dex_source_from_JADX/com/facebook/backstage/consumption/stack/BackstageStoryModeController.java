package com.facebook.backstage.consumption.stack;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.facebook.backstage.analytics.BackstageAnalyticsLogger;
import com.facebook.backstage.camera.CameraHolder;
import com.facebook.backstage.consumption.BackstageFragment;
import com.facebook.backstage.consumption.BackstageNavigatorApi;
import com.facebook.backstage.consumption.BackstagePrefetchService;
import com.facebook.backstage.consumption.ProfilesDataProvider;
import com.facebook.backstage.consumption.ScreenUtil;
import com.facebook.backstage.consumption.SimpleAnimationHelper;
import com.facebook.backstage.consumption.camera.CameraFlowLauncher;
import com.facebook.backstage.consumption.reply.AnimatingEmojiView;
import com.facebook.backstage.consumption.reply.EmojiMenuView;
import com.facebook.backstage.consumption.reply.TextReplyBuilder;
import com.facebook.backstage.consumption.stack.StoryViewAlertDialogHelper.C05441;
import com.facebook.backstage.consumption.stack.StoryViewAlertDialogHelper.C05452;
import com.facebook.backstage.consumption.swipe.BackstageSwipeController;
import com.facebook.backstage.consumption.swipe.BackstageSwipeController.GestureEventListener;
import com.facebook.backstage.consumption.swipe.BaseBackstageStoryPagerViewItem;
import com.facebook.backstage.consumption.swipe.BaseBackstageStoryPagerViewItem.CenterStateListener;
import com.facebook.backstage.data.BackstageProfile;
import com.facebook.backstage.data.BackstageProfile.BackstageStory;
import com.facebook.backstage.data.BackstageProfile.SeenByUser;
import com.facebook.backstage.data.MediaItem;
import com.facebook.backstage.data.TimezoneDate;
import com.facebook.backstage.graphql.BackstageMarkSeenMutationHelper;
import com.facebook.backstage.util.BetterGestureDetector;
import com.facebook.backstage.util.BetterGestureListener;
import com.facebook.backstage.util.LocaleTimeUtil;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.locale.Locales;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.imagepipeline.request.ImageRequest.ImageType;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pager.PagerViewItemFactory;
import com.facebook.pager.renderers.standard.StandardPagerViewRenderer;
import com.facebook.resources.ui.FbTextView;
import com.facebook.springs.SpringSystem;
import com.facebook.user.model.User;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.text.DateFormat;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: retry_after_failure */
public class BackstageStoryModeController {
    public static final String f5003a = BackstageStoryModeController.class.getSimpleName();
    public FbTextView f5004A;
    public FrameLayout f5005B;
    public GlyphView f5006C;
    public GlyphView f5007D;
    public View f5008E;
    public int f5009F;
    public int f5010G;
    public EmojiMenuView f5011H;
    public final ListeningExecutorService f5012I;
    public CameraFlowLauncher f5013J;
    public SimpleAnimationHelper f5014K;
    public final C05261 f5015b = new C05261(this);
    public final CenterStateListener<BackstageStory> f5016c = new C05272(this);
    public final BackstageNavigatorApi f5017d = BackstageNavigatorApi.m4489a();
    public final BetterGestureDetector f5018e;
    public final SecureContextHelper f5019f;
    public final AbstractFbErrorReporter f5020g;
    public final Context f5021h;
    public final BackstageSwipeController<BackstageStory, BaseBackstageStoryPagerViewItem> f5022i;
    private final ScreenUtil f5023j;
    public final FbDraweeControllerBuilder f5024k;
    private final RoundingParams f5025l = RoundingParams.e();
    public final BackstageAnalyticsLogger f5026m;
    public final BackstageMarkSeenMutationHelper f5027n;
    public final ProfilesDataProvider f5028o;
    public final Locales f5029p;
    public final TextReplyBuilder f5030q;
    public final Provider<User> f5031r;
    public final StoryViewAlertDialogHelper f5032s;
    public StandardPagerViewRenderer<BackstageStory, BaseBackstageStoryPagerViewItem> f5033t;
    public BackstageProfile f5034u;
    public boolean f5035v = false;
    public CameraHolder f5036w;
    public GenericDraweeView f5037x;
    public ViewGroup f5038y;
    public FbTextView f5039z;

    /* compiled from: retry_after_failure */
    public class C05261 {
        public final /* synthetic */ BackstageStoryModeController f4990a;

        C05261(BackstageStoryModeController backstageStoryModeController) {
            this.f4990a = backstageStoryModeController;
        }
    }

    /* compiled from: retry_after_failure */
    public class C05272 {
        final /* synthetic */ BackstageStoryModeController f4991a;

        C05272(BackstageStoryModeController backstageStoryModeController) {
            this.f4991a = backstageStoryModeController;
        }

        public final void m4830a(MediaItem mediaItem) {
            BackstageStory backstageStory = (BackstageStory) mediaItem;
            BackstageAnalyticsLogger backstageAnalyticsLogger = this.f4991a.f5026m;
            backstageAnalyticsLogger.f4269d++;
            BackstageStoryModeController backstageStoryModeController = this.f4991a;
            TimezoneDate timezoneDate = backstageStory.f4821e;
            backstageStoryModeController.f5039z.setText(DateFormat.getTimeInstance(3).format(Long.valueOf(timezoneDate.getTime() - LocaleTimeUtil.m5777a(backstageStoryModeController.f5029p, timezoneDate.mTimezoneOffset))));
            BackstageStoryModeController.m4835a(this.f4991a, backstageStory.f5105c);
        }
    }

    /* compiled from: retry_after_failure */
    class C05283 implements GestureEventListener {
        final /* synthetic */ BackstageStoryModeController f4992a;

        C05283(BackstageStoryModeController backstageStoryModeController) {
            this.f4992a = backstageStoryModeController;
        }

        public final void mo177c() {
            this.f4992a.m4840d();
        }

        public final void mo178d() {
            if (!this.f4992a.f5034u.f5115d) {
                this.f4992a.m4838a(this.f4992a.f5009F, this.f4992a.f5010G);
            }
        }
    }

    /* compiled from: retry_after_failure */
    public class C05304 implements OnClickListener {
        public final /* synthetic */ BackstageStoryModeController f4994a;

        /* compiled from: retry_after_failure */
        public class C05291 {
            public final /* synthetic */ C05304 f4993a;

            C05291(C05304 c05304) {
                this.f4993a = c05304;
            }
        }

        public C05304(BackstageStoryModeController backstageStoryModeController) {
            this.f4994a = backstageStoryModeController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -403334685);
            StoryViewAlertDialogHelper storyViewAlertDialogHelper = this.f4994a.f5032s;
            String str = ((BackstageStory) this.f4994a.f5022i.f5097f.f18378C).f5104b;
            C05291 c05291 = new C05291(this);
            AlertDialog a2 = new Builder(storyViewAlertDialogHelper.f5076a).a();
            ProgressDialog progressDialog = new ProgressDialog(storyViewAlertDialogHelper.f5076a);
            progressDialog.a(storyViewAlertDialogHelper.f5076a.getResources().getString(2131239889));
            a2.a(storyViewAlertDialogHelper.f5076a.getResources().getString(2131239948));
            a2.a(-1, storyViewAlertDialogHelper.f5076a.getResources().getString(2131239949), new C05441(storyViewAlertDialogHelper, progressDialog, str, c05291));
            a2.a(-2, storyViewAlertDialogHelper.f5076a.getResources().getString(2131237528), new C05452(storyViewAlertDialogHelper, a2, c05291));
            a2.show();
            Logger.a(2, EntryType.UI_INPUT_END, 1638801353, a);
        }
    }

    /* compiled from: retry_after_failure */
    public class C05315 implements OnClickListener {
        final /* synthetic */ BackstageStoryModeController f4995a;

        public C05315(BackstageStoryModeController backstageStoryModeController) {
            this.f4995a = backstageStoryModeController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -543096648);
            if (this.f4995a.f5022i.m4890c() != null) {
                ((BaseBackstageStoryPagerViewItem) this.f4995a.f5022i.m4890c()).mo180f();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1275505702, a);
        }
    }

    /* compiled from: retry_after_failure */
    public class C05326 implements OnClickListener {
        final /* synthetic */ BackstageStoryModeController f4996a;

        public C05326(BackstageStoryModeController backstageStoryModeController) {
            this.f4996a = backstageStoryModeController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -819270971);
            this.f4996a.m4838a((int) (this.f4996a.f5008E.getX() + ((float) (this.f4996a.f5008E.getWidth() / 2))), (int) (this.f4996a.f5008E.getY() + ((float) (this.f4996a.f5008E.getHeight() / 2))));
            Logger.a(2, EntryType.UI_INPUT_END, 1091433481, a);
        }
    }

    /* compiled from: retry_after_failure */
    public class C05337 implements OnTouchListener {
        final /* synthetic */ BackstageStoryModeController f4997a;

        public C05337(BackstageStoryModeController backstageStoryModeController) {
            this.f4997a = backstageStoryModeController;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                this.f4997a.f5009F = (int) motionEvent.getX();
                this.f4997a.f5010G = (int) motionEvent.getY();
                this.f4997a.m4840d();
            }
            if (this.f4997a.f5035v) {
                this.f4997a.f5018e.onTouchEvent(motionEvent);
            }
            return true;
        }
    }

    public static BackstageStoryModeController m4836b(InjectorLike injectorLike) {
        return new BackstageStoryModeController((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (Context) injectorLike.getInstance(Context.class), ScreenUtil.m4547a(injectorLike), SpringSystem.b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), FbDraweeControllerBuilder.b(injectorLike), BackstageAnalyticsLogger.m4259a(injectorLike), BackstageMarkSeenMutationHelper.m4965b(injectorLike), ProfilesDataProvider.m4540a(injectorLike), Locales.a(injectorLike), TextReplyBuilder.m4812a(injectorLike), (ListeningExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 3595), StoryViewAlertDialogHelper.m4873b(injectorLike));
    }

    @Inject
    public BackstageStoryModeController(FbErrorReporter fbErrorReporter, Context context, ScreenUtil screenUtil, SpringSystem springSystem, SecureContextHelper secureContextHelper, FbDraweeControllerBuilder fbDraweeControllerBuilder, BackstageAnalyticsLogger backstageAnalyticsLogger, BackstageMarkSeenMutationHelper backstageMarkSeenMutationHelper, ProfilesDataProvider profilesDataProvider, Locales locales, TextReplyBuilder textReplyBuilder, ListeningExecutorService listeningExecutorService, Provider<User> provider, StoryViewAlertDialogHelper storyViewAlertDialogHelper) {
        this.f5020g = fbErrorReporter;
        this.f5021h = context;
        this.f5029p = locales;
        this.f5019f = secureContextHelper;
        this.f5026m = backstageAnalyticsLogger;
        this.f5027n = backstageMarkSeenMutationHelper;
        this.f5028o = profilesDataProvider;
        this.f5030q = textReplyBuilder;
        this.f5012I = listeningExecutorService;
        this.f5031r = provider;
        this.f5032s = storyViewAlertDialogHelper;
        this.f5022i = new BackstageSwipeController(screenUtil, springSystem, fbErrorReporter);
        this.f5022i.m4888a(new C05283(this));
        this.f5023j = screenUtil;
        this.f5024k = fbDraweeControllerBuilder;
        this.f5018e = new BetterGestureDetector(this.f5021h, m4837h());
    }

    public final void m4839a(final BackstageProfile backstageProfile) {
        int i;
        int min;
        int i2;
        int size = backstageProfile.f5117f.size();
        if (backstageProfile.f5114c) {
            i = size - backstageProfile.f5118g;
        } else {
            i = 0;
        }
        this.f5026m.m4267a(backstageProfile.f5115d, size, i);
        Context context = this.f5021h;
        SecureContextHelper secureContextHelper = this.f5019f;
        boolean z = false;
        ArrayList arrayList = new ArrayList(10);
        if (backstageProfile.f5118g < 5) {
            min = Math.min(backstageProfile.f5117f.size(), 10);
            i2 = 0;
        } else {
            min = Math.max(backstageProfile.f5118g - 5, 0);
            i2 = min;
            min = Math.min(backstageProfile.f5118g + 5, backstageProfile.f5117f.size());
        }
        if (i2 <= min) {
            z = true;
        }
        Preconditions.checkArgument(z);
        while (i2 < min) {
            arrayList.add(Uri.parse(((BackstageStory) backstageProfile.f5117f.get(i2)).mo171f()));
            i2++;
        }
        Intent intent = new Intent(context, BackstagePrefetchService.class);
        intent.setAction("PREFTCH_MEDIA");
        intent.putParcelableArrayListExtra("MEDIA_URIS", arrayList);
        secureContextHelper.c(intent, context);
        this.f5034u = backstageProfile;
        m4834a(backstageProfile.m4898c());
        if (this.f5034u.f5115d) {
            this.f5007D.setVisibility(0);
        } else {
            this.f5007D.setVisibility(8);
        }
        if (this.f5033t == null) {
            ViewGroup viewGroup = this.f5038y;
            PagerViewItemFactory c05348 = new PagerViewItemFactory<BaseBackstageStoryPagerViewItem>(this) {
                final /* synthetic */ BackstageStoryModeController f4999b;

                public final Object mo170a() {
                    BaseBackstageStoryPagerViewItem backstageMyStoryPagerViewItem;
                    if (backstageProfile.f5115d) {
                        backstageMyStoryPagerViewItem = new BackstageMyStoryPagerViewItem(this.f4999b.f5038y.getContext(), this.f4999b.f5024k, this.f4999b.f5026m, this.f4999b.f5004A);
                    } else {
                        backstageMyStoryPagerViewItem = new BackstageStoryPagerViewItem(this.f4999b.f5038y.getContext(), this.f4999b.f5024k, this.f4999b.f5004A, this.f4999b.f5036w, this.f4999b.f5015b, this.f4999b.f5013J);
                    }
                    backstageMyStoryPagerViewItem.getController().f5084g = this.f4999b.f5016c;
                    backstageMyStoryPagerViewItem.setLayoutParams(new LayoutParams(-1, -1));
                    return backstageMyStoryPagerViewItem;
                }
            };
            if (backstageProfile.f5115d) {
                i = 1;
            } else {
                i = 3;
            }
            this.f5033t = new StandardPagerViewRenderer(viewGroup, c05348, i);
        }
        this.f5022i.m4889a(this.f5033t, (float) this.f5023j.m4551a(), (float) this.f5023j.m4552b(), backstageProfile.f5117f);
        this.f5022i.f5097f.m18386a(this.f5034u.f5118g, 10.0f);
        this.f5035v = true;
    }

    private BetterGestureListener m4837h() {
        return this.f5022i.f5092a;
    }

    private void m4834a(Uri uri) {
        ImageRequestBuilder a = ImageRequestBuilder.a(uri);
        a.f = ImageType.DEFAULT;
        this.f5037x.setController(((FbDraweeControllerBuilder) this.f5024k.c(a.m())).a(CallerContext.a(BackstageFragment.class)).s());
        ((GenericDraweeHierarchy) this.f5037x.getHierarchy()).a(this.f5025l);
    }

    public static void m4835a(BackstageStoryModeController backstageStoryModeController, ImmutableList immutableList) {
        if (backstageStoryModeController.f5034u.f5115d) {
            backstageStoryModeController.f5006C.setVisibility(8);
        }
        backstageStoryModeController.f5005B.removeAllViews();
        if (immutableList.isEmpty()) {
            backstageStoryModeController.f5005B.setVisibility(8);
            backstageStoryModeController.f5006C.setVisibility(0);
            return;
        }
        backstageStoryModeController.f5005B.setVisibility(0);
        backstageStoryModeController.f5006C.setVisibility(8);
        int size = immutableList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            SeenByUser seenByUser = (SeenByUser) immutableList.get(i);
            if (seenByUser.m4896b()) {
                AnimatingEmojiView animatingEmojiView = (AnimatingEmojiView) LayoutInflater.from(backstageStoryModeController.f5021h).inflate(2130903365, null);
                animatingEmojiView.setUser(seenByUser);
                backstageStoryModeController.f5005B.addView(animatingEmojiView);
                i3 = i2 + 1;
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        if (i2 != 0) {
            backstageStoryModeController.f5005B.getChildAt(0).setVisibility(0);
            backstageStoryModeController.f5005B.setOnClickListener(new OnClickListener(backstageStoryModeController) {
                final /* synthetic */ BackstageStoryModeController f5001b;
                private int f5002c = 0;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 699609118);
                    AnimatingEmojiView animatingEmojiView = (AnimatingEmojiView) this.f5001b.f5005B.getChildAt(this.f5002c);
                    animatingEmojiView.m4741a(this.f5001b.f5038y);
                    animatingEmojiView.setVisibility(8);
                    this.f5002c = (this.f5002c + 1) % i2;
                    animatingEmojiView = (AnimatingEmojiView) this.f5001b.f5005B.getChildAt(this.f5002c);
                    animatingEmojiView.setVisibility(0);
                    animatingEmojiView.m4742b();
                    Logger.a(2, EntryType.UI_INPUT_END, -936969394, a);
                }
            });
        }
    }

    public final void m4838a(int i, int i2) {
        if (!((BackstageStory) this.f5022i.f5097f.f18378C).f5106d) {
            this.f5011H.m4790a(i, i2);
        }
    }

    public final void m4840d() {
        if (this.f5011H.m4791b()) {
            this.f5011H.m4789a();
        }
    }
}
