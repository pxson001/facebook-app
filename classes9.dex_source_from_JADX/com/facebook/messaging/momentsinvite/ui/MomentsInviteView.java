package com.facebook.messaging.momentsinvite.ui;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.util.SizeUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.GenericDraweeHierarchyBuilderMethodAutoProvider;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetInterfaces.MomentsAppInvitationActionLinkFragment;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.MomentsAppInvitationActionLinkFragmentModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAModel;
import com.facebook.messaging.model.share.Share;
import com.facebook.messaging.momentsinvite.analytics.MomentsInviteLogger;
import com.facebook.messaging.momentsinvite.kenburns.KenBurnsSlideShowAnimator;
import com.facebook.messaging.momentsinvite.model.MomentsInviteXMAModel;
import com.facebook.messaging.momentsinvite.model.MomentsInviteXMAModelBuilder;
import com.facebook.messaging.momentsinvite.ui.MomentsLaunchHelper.PostbackCallback;
import com.facebook.messaging.xma.XMAViewHostEventDispatcher;
import com.facebook.messaging.xma.XMAViewHostEventListener;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Iterators;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: iso-8859-8 */
public class MomentsInviteView extends CustomLinearLayout implements MomentsInviteImageLoadingListener, XMAViewHostEventListener {
    public static final String f12351e = MomentsInviteView.class.getSimpleName();
    @Inject
    FbDraweeControllerBuilder f12352a;
    @Inject
    GenericDraweeHierarchyBuilder f12353b;
    @Inject
    MomentsInviteImageLoader f12354c;
    @Inject
    XMAViewHostEventDispatcher f12355d;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<MomentsInviteLogger> f12356f;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<MomentsLaunchHelper> f12357g;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<GatekeeperStore> f12358h;
    @Nullable
    public MomentsInviteXMAModel f12359i;
    private int f12360j;
    private View f12361k;
    private TextView f12362l;
    private TextView f12363m;
    private ImmutableList<GenericDraweeView> f12364n;
    private final TextView[] f12365o;
    private KenBurnsSlideShowAnimator f12366p;
    private final OnClickListener f12367q;

    /* compiled from: iso-8859-8 */
    class C13601 implements OnClickListener {
        final /* synthetic */ MomentsInviteView f12344a;

        C13601(MomentsInviteView momentsInviteView) {
            this.f12344a = momentsInviteView;
        }

        public void onClick(final View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1006536715);
            MomentsAppInvitationActionLinkFragmentModel e = MomentsInviteView.m12827e(this.f12344a);
            if (e == null) {
                MomentsInviteLogger momentsInviteLogger = (MomentsInviteLogger) this.f12344a.f12356f.get();
                MomentsInviteXMAModel momentsInviteXMAModel = this.f12344a.f12359i;
                HoneyClientEvent honeyClientEvent = new HoneyClientEvent("moments_invite_clicked_bad_link");
                MomentsInviteLogger.m12753a(momentsInviteXMAModel, honeyClientEvent);
                momentsInviteLogger.f12293a.a(honeyClientEvent);
                Logger.a(2, EntryType.UI_INPUT_END, 291067100, a);
                return;
            }
            ((MomentsLaunchHelper) this.f12344a.f12357g.get()).m12843a(this.f12344a.getContext(), this.f12344a.f12359i, e, true, new PostbackCallback(this) {
                final /* synthetic */ C13601 f12343b;

                public final void mo464a() {
                    view.setClickable(false);
                }

                public final void mo465b() {
                    view.setClickable(true);
                }
            });
            LogUtils.a(1454901368, a);
        }
    }

    /* compiled from: iso-8859-8 */
    class C13612 implements Predicate<MomentsAppInvitationActionLinkFragment> {
        final /* synthetic */ MomentsInviteView f12345a;

        C13612(MomentsInviteView momentsInviteView) {
            this.f12345a = momentsInviteView;
        }

        public boolean apply(Object obj) {
            MomentsAppInvitationActionLinkFragmentModel momentsAppInvitationActionLinkFragmentModel = (MomentsAppInvitationActionLinkFragmentModel) obj;
            String str = MomentsInviteView.f12351e;
            momentsAppInvitationActionLinkFragmentModel.aI_();
            momentsAppInvitationActionLinkFragmentModel.aJ_();
            momentsAppInvitationActionLinkFragmentModel.g();
            momentsAppInvitationActionLinkFragmentModel.a().toString();
            return (StringUtil.a(momentsAppInvitationActionLinkFragmentModel.g()) && StringUtil.a(momentsAppInvitationActionLinkFragmentModel.c())) ? false : true;
        }
    }

    /* compiled from: iso-8859-8 */
    class C13623 implements Predicate<MomentsAppInvitationActionLinkFragment> {
        final /* synthetic */ MomentsInviteView f12346a;

        C13623(MomentsInviteView momentsInviteView) {
            this.f12346a = momentsInviteView;
        }

        public boolean apply(Object obj) {
            MomentsAppInvitationActionLinkFragmentModel momentsAppInvitationActionLinkFragmentModel = (MomentsAppInvitationActionLinkFragmentModel) obj;
            return (StringUtil.a(momentsAppInvitationActionLinkFragmentModel.aJ_()) && StringUtil.a(momentsAppInvitationActionLinkFragmentModel.d())) ? false : true;
        }
    }

    private static <T extends View> void m12818a(Class<T> cls, T t) {
        m12819a((Object) t, t.getContext());
    }

    private static void m12819a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((MomentsInviteView) obj).m12817a(FbDraweeControllerBuilder.b(fbInjector), GenericDraweeHierarchyBuilderMethodAutoProvider.b(fbInjector), new MomentsInviteImageLoader(ImagePipelineMethodAutoProvider.a(fbInjector), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector)), XMAViewHostEventDispatcher.a(fbInjector), IdBasedLazy.a(fbInjector, 7981), IdBasedLazy.a(fbInjector, 7986), IdBasedSingletonScopeProvider.b(fbInjector, 2128));
    }

    public MomentsInviteView(Context context) {
        super(context);
        this.f12356f = UltralightRuntime.b;
        this.f12357g = UltralightRuntime.b;
        this.f12358h = UltralightRuntime.b;
        this.f12365o = new TextView[3];
        this.f12367q = new C13601(this);
        m12826d();
    }

    public void setModelFromShare(@Nullable Share share) {
        MomentsInviteXMAModel momentsInviteXMAModel;
        if (share == null) {
            momentsInviteXMAModel = null;
        } else {
            MomentsInviteXMAModelBuilder newBuilder = MomentsInviteXMAModelBuilder.newBuilder();
            newBuilder.a = share.c;
            newBuilder.b = share.e;
            ImmutableList of = ImmutableList.of(MomentsInviteDataConverter.m12799a(share.j, share.f, share.k));
            newBuilder.b(of);
            newBuilder.a(of);
            if (share.m != null) {
                newBuilder.a(share.m.a);
                newBuilder.d = share.m.c;
            }
            momentsInviteXMAModel = newBuilder.i();
        }
        setModel(momentsInviteXMAModel);
    }

    public MomentsInviteView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12356f = UltralightRuntime.b;
        this.f12357g = UltralightRuntime.b;
        this.f12358h = UltralightRuntime.b;
        this.f12365o = new TextView[3];
        this.f12367q = new C13601(this);
        m12826d();
    }

    public MomentsInviteView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12356f = UltralightRuntime.b;
        this.f12357g = UltralightRuntime.b;
        this.f12358h = UltralightRuntime.b;
        this.f12365o = new TextView[3];
        this.f12367q = new C13601(this);
        m12826d();
    }

    private void m12826d() {
        m12818a(MomentsInviteView.class, (View) this);
        setContentView(2130905766);
        setOrientation(1);
        this.f12360j = SizeUtil.a(getContext(), 320.0f);
        this.f12361k = a(2131564945);
        this.f12362l = (TextView) a(2131564948);
        this.f12363m = (TextView) a(2131564949);
        this.f12365o[0] = (TextView) a(2131564950);
        this.f12365o[1] = (TextView) a(2131564951);
        this.f12365o[2] = (TextView) a(2131564952);
        this.f12364n = ImmutableList.of((GenericDraweeView) a(2131564946), (GenericDraweeView) a(2131564947));
        int color = getResources().getColor(2131362420);
        Builder builder = ImmutableList.builder();
        int size = this.f12364n.size();
        for (int i = 0; i < size; i++) {
            MomentsInviteAnimationDelegate momentsInviteAnimationDelegate = new MomentsInviteAnimationDelegate(this.f12352a, this.f12353b, (GenericDraweeView) this.f12364n.get(i), color);
            momentsInviteAnimationDelegate.f12330f = this;
            builder.c(momentsInviteAnimationDelegate);
        }
        this.f12354c.f12337d = this;
        this.f12366p = new KenBurnsSlideShowAnimator(this.f12354c, builder.b());
        setOnClickListener(this.f12367q);
    }

    @Nullable
    public static MomentsAppInvitationActionLinkFragmentModel m12827e(MomentsInviteView momentsInviteView) {
        if (momentsInviteView.f12359i == null) {
            return null;
        }
        return (MomentsAppInvitationActionLinkFragmentModel) Iterators.a(momentsInviteView.f12359i.h.iterator(), momentsInviteView.m12832j(), null);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -907841469);
        super.onAttachedToWindow();
        m12834l();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -310138604, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1125251546);
        super.onDetachedFromWindow();
        m12835m();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1840988635, a);
    }

    public final void m12836a() {
        this.f12366p.m12790a();
    }

    public final void m12839b() {
        this.f12366p.m12793b();
    }

    public final void m12838a(boolean z) {
        if (z) {
            this.f12366p.m12793b();
        } else {
            this.f12366p.m12790a();
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int min = Math.min(this.f12360j, getMeasuredWidth());
        if (m12824c(min) || getMeasuredWidth() > min) {
            measure(MeasureSpec.makeMeasureSpec(min, 1073741824), i2);
        }
    }

    public final void mo466a(Uri uri, @Nullable Throwable th) {
        new Object[1][0] = uri;
        MomentsInviteLogger momentsInviteLogger = (MomentsInviteLogger) this.f12356f.get();
        MomentsInviteXMAModel momentsInviteXMAModel = this.f12359i;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("moments_invite_failed_to_load_image");
        MomentsInviteLogger.m12753a(momentsInviteXMAModel, honeyClientEvent);
        honeyClientEvent.a("image_uri", uri);
        honeyClientEvent.a("exception", th);
        momentsInviteLogger.f12293a.a(honeyClientEvent);
    }

    public void setModelFromXMA(@Nullable XMAModel xMAModel) {
        setModel(MomentsInviteDataConverter.m12800a(xMAModel, getResources(), (GatekeeperStoreImpl) this.f12358h.get()));
    }

    private void setModel(@Nullable MomentsInviteXMAModel momentsInviteXMAModel) {
        this.f12359i = momentsInviteXMAModel;
        m12829g();
        m12830h();
        m12831i();
        m12828f();
    }

    private void m12828f() {
        if (this.f12359i == null || this.f12359i.c.isEmpty()) {
            this.f12361k.setVisibility(8);
            return;
        }
        this.f12361k.setVisibility(0);
        m12833k();
    }

    private void m12829g() {
        if (this.f12359i == null || this.f12359i.a == null) {
            this.f12362l.setVisibility(8);
            return;
        }
        this.f12362l.setVisibility(0);
        this.f12362l.setText(this.f12359i.a);
    }

    private void m12830h() {
        if (this.f12359i == null || this.f12359i.b == null) {
            this.f12363m.setVisibility(8);
            return;
        }
        this.f12363m.setVisibility(0);
        this.f12363m.setText(this.f12359i.b);
    }

    private void m12831i() {
        int i;
        if (this.f12359i != null) {
            UnmodifiableIterator b = Iterators.b(this.f12359i.g.iterator(), m12832j());
            i = 0;
            while (b.hasNext() && i < this.f12365o.length) {
                TextView textView = this.f12365o[i];
                final MomentsAppInvitationActionLinkFragmentModel momentsAppInvitationActionLinkFragmentModel = (MomentsAppInvitationActionLinkFragmentModel) b.next();
                momentsAppInvitationActionLinkFragmentModel.aI_();
                momentsAppInvitationActionLinkFragmentModel.aJ_();
                momentsAppInvitationActionLinkFragmentModel.g();
                textView.setText(momentsAppInvitationActionLinkFragmentModel.aI_());
                textView.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ MomentsInviteView f12349b;
                    public boolean f12350c = false;

                    /* compiled from: iso-8859-8 */
                    class C13631 implements PostbackCallback {
                        final /* synthetic */ C13644 f12347a;

                        C13631(C13644 c13644) {
                            this.f12347a = c13644;
                        }

                        public final void mo464a() {
                            this.f12347a.f12350c = true;
                        }

                        public final void mo465b() {
                            this.f12347a.f12350c = false;
                        }
                    }

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, -1080177435);
                        if (this.f12350c) {
                            Logger.a(2, EntryType.UI_INPUT_END, -1690618845, a);
                            return;
                        }
                        ((MomentsLaunchHelper) this.f12349b.f12357g.get()).m12843a(this.f12349b.getContext(), this.f12349b.f12359i, momentsAppInvitationActionLinkFragmentModel, false, new C13631(this));
                        LogUtils.a(1703697942, a);
                    }
                });
                textView.setVisibility(0);
                i++;
            }
            MomentsInviteLogger momentsInviteLogger = (MomentsInviteLogger) this.f12356f.get();
            MomentsInviteXMAModel momentsInviteXMAModel = this.f12359i;
            boolean a = ((MomentsLaunchHelper) this.f12357g.get()).m12844a(getContext());
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("moments_invite_impression");
            MomentsInviteLogger.m12753a(momentsInviteXMAModel, honeyClientEvent);
            honeyClientEvent.b("share_id", momentsInviteXMAModel.f);
            honeyClientEvent.a("invite_app_installed", a);
            honeyClientEvent.a("invite_button_count", i);
            momentsInviteLogger.f12293a.a(honeyClientEvent);
        } else {
            i = 0;
        }
        while (i < this.f12365o.length) {
            this.f12365o[i].setVisibility(8);
            i++;
        }
    }

    private Predicate<MomentsAppInvitationActionLinkFragment> m12832j() {
        return ((MomentsLaunchHelper) this.f12357g.get()).m12844a(getContext()) ? new C13612(this) : new C13623(this);
    }

    private void m12817a(FbDraweeControllerBuilder fbDraweeControllerBuilder, GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder, MomentsInviteImageLoader momentsInviteImageLoader, XMAViewHostEventDispatcher xMAViewHostEventDispatcher, com.facebook.inject.Lazy<MomentsInviteLogger> lazy, com.facebook.inject.Lazy<MomentsLaunchHelper> lazy2, com.facebook.inject.Lazy<GatekeeperStore> lazy3) {
        this.f12352a = fbDraweeControllerBuilder;
        this.f12353b = genericDraweeHierarchyBuilder;
        this.f12354c = momentsInviteImageLoader;
        this.f12355d = xMAViewHostEventDispatcher;
        this.f12356f = lazy;
        this.f12357g = lazy2;
        this.f12358h = lazy3;
    }

    private boolean m12824c(int i) {
        if (this.f12359i == null || this.f12359i.c.isEmpty()) {
            return false;
        }
        LayoutParams layoutParams = (LayoutParams) this.f12361k.getLayoutParams();
        if (layoutParams.width == i && layoutParams.height == i) {
            return false;
        }
        layoutParams.width = i;
        layoutParams.height = i;
        this.f12361k.setLayoutParams(layoutParams);
        this.f12366p.m12791a(i, i);
        return true;
    }

    private void m12833k() {
        this.f12366p.m12792a(m12816a(this.f12359i));
    }

    private void m12834l() {
        this.f12366p.m12790a();
        this.f12355d.a.put(Preconditions.checkNotNull(this), Boolean.valueOf(true));
    }

    private void m12835m() {
        this.f12355d.a.remove(Preconditions.checkNotNull(this));
        this.f12366p.m12793b();
    }

    private static ImmutableList<Uri> m12816a(@Nullable MomentsInviteXMAModel momentsInviteXMAModel) {
        if (momentsInviteXMAModel == null) {
            return RegularImmutableList.a;
        }
        Builder builder = ImmutableList.builder();
        ImmutableList immutableList = momentsInviteXMAModel.c;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            m12820a((String) immutableList.get(i), builder);
        }
        return builder.b();
    }

    @Nullable
    private static void m12820a(@Nullable String str, Builder<Uri> builder) {
        if (!StringUtil.a(str)) {
            Uri parse = Uri.parse(str);
            if (parse.isAbsolute()) {
                builder.c(parse);
            }
        }
    }
}
