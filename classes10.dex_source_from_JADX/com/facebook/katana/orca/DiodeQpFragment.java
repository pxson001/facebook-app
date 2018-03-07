package com.facebook.katana.orca;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.loader.FbLoader.Callback;
import com.facebook.common.util.FindViewUtil;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.facepile.FacepileView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.quickpromotion.asset.QuickPromotionImageFetcher;
import com.facebook.quickpromotion.data.QuickPromotionUsersLoader;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.Action;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.Creative;
import com.facebook.quickpromotion.ui.QuickPromotionFragment;
import com.facebook.sideloading.AutoQESpecForSideloadingModule;
import com.facebook.sideloading.SideloadingChecker;
import com.facebook.sideloading.SideloadingFileUtils;
import com.facebook.sideloading.SideloadingLogger;
import com.facebook.sideloading.SideloadingManager;
import com.facebook.sideloading.SideloadingManager.DownloadingButtonListener;
import com.facebook.sideloading.SideloadingPrefKeys;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.user.model.PicSquare;
import com.facebook.user.model.PicSquareUrlWithSize;
import com.facebook.user.model.User;
import com.facebook.user.tiles.UserTileView;
import com.facebook.user.tiles.UserTileViewParams;
import com.facebook.widget.listview.ScrollableListContainer;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.tiles.TileBadge;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: unknown_region_feedback */
public class DiodeQpFragment extends QuickPromotionFragment implements ScrollableListContainer {
    private static final CallerContext al = CallerContext.a(DiodeQpFragment.class, "diode_qp_module");
    @Inject
    public FbSharedPreferences f977a;
    public boolean am = false;
    private ScrollView an;
    private TextView ao;
    private TextView ap;
    private UserTileView aq;
    private FbDraweeView ar;
    public Button as;
    private ViewStub at;
    private TextView au;
    private ControllerListener av;
    @Inject
    QuickPromotionImageFetcher f978b;
    @Inject
    QuickPromotionUsersLoader f979d;
    @Inject
    SideloadingManager f980e;
    @Inject
    SideloadingChecker f981f;
    @Inject
    public SideloadingFileUtils f982g;
    @Inject
    SideloadingLogger f983h;
    @Inject
    AutoQESpecForSideloadingModule f984i;

    /* compiled from: unknown_region_feedback */
    class QPDownloadingButtonListenerImplementation implements DownloadingButtonListener {
        final /* synthetic */ DiodeQpFragment f976a;

        /* compiled from: unknown_region_feedback */
        class C01571 implements Runnable {
            final /* synthetic */ QPDownloadingButtonListenerImplementation f975a;

            C01571(QPDownloadingButtonListenerImplementation qPDownloadingButtonListenerImplementation) {
                this.f975a = qPDownloadingButtonListenerImplementation;
            }

            public void run() {
                DiodeQpFragment diodeQpFragment = this.f975a.f976a;
                diodeQpFragment.as.setText(2131236577);
                diodeQpFragment.as.setClickable(true);
                diodeQpFragment.as.getBackground().setAlpha(255);
            }
        }

        public QPDownloadingButtonListenerImplementation(DiodeQpFragment diodeQpFragment) {
            this.f976a = diodeQpFragment;
        }

        public final void mo38a() {
            FragmentActivity o = this.f976a.o();
            if (o != null) {
                o.runOnUiThread(new C01571(this));
            }
        }
    }

    public static void m1030a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((DiodeQpFragment) obj).m1028a((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), QuickPromotionImageFetcher.a(injectorLike), QuickPromotionUsersLoader.b(injectorLike), SideloadingManager.m10139a(injectorLike), SideloadingChecker.m10113b(injectorLike), SideloadingFileUtils.m10115b(injectorLike), SideloadingLogger.m10126b(injectorLike), AutoQESpecForSideloadingModule.a(injectorLike));
    }

    private void m1028a(FbSharedPreferences fbSharedPreferences, QuickPromotionImageFetcher quickPromotionImageFetcher, QuickPromotionUsersLoader quickPromotionUsersLoader, SideloadingManager sideloadingManager, SideloadingChecker sideloadingChecker, SideloadingFileUtils sideloadingFileUtils, SideloadingLogger sideloadingLogger, AutoQESpecForSideloadingModule autoQESpecForSideloadingModule) {
        this.f977a = fbSharedPreferences;
        this.f978b = quickPromotionImageFetcher;
        this.f979d = quickPromotionUsersLoader;
        this.f980e = sideloadingManager;
        this.f981f = sideloadingChecker;
        this.f982g = sideloadingFileUtils;
        this.f983h = sideloadingLogger;
        this.f984i = autoQESpecForSideloadingModule;
    }

    public final View m1032a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1315778994);
        super.a(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(2130903915, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1135665040, a);
        return inflate;
    }

    public final void m1033a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.an = (ScrollView) FindViewUtil.b(view, 2131561045);
        this.ao = (TextView) FindViewUtil.b(view, 2131561046);
        this.ap = (TextView) FindViewUtil.b(view, 2131561047);
        this.ar = (FbDraweeView) FindViewUtil.b(view, 2131561049);
        this.aq = (UserTileView) FindViewUtil.b(view, 2131561048);
        this.at = (ViewStub) FindViewUtil.b(view, 2131561051);
        this.as = (Button) FindViewUtil.b(view, 2131561050);
        this.au = (TextView) FindViewUtil.b(view, 2131561052);
        this.av = this.f978b.a();
    }

    public final void gB_() {
        this.an.fullScroll(33);
    }

    public final boolean gC_() {
        return this.an.getScrollY() == 0;
    }

    @Nullable
    public final ScrollingViewProxy m1036n() {
        return null;
    }

    public final void m1034c(Bundle bundle) {
        super.c(bundle);
        Class cls = DiodeQpFragment.class;
        m1030a((Object) this, getContext());
    }

    public final void m1035d(Bundle bundle) {
        boolean z;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -146578542);
        super.d(bundle);
        QuickPromotionDefinition quickPromotionDefinition = this.a;
        Creative c = quickPromotionDefinition.c();
        m1027a(this.ao, c.title);
        m1027a(this.ap, c.content);
        ImmutableMap b = ImmutableMap.builder().b("CIRCLE_CROP", TileBadge.NONE).b("MESSENGER_BADGE", TileBadge.MESSENGER).b();
        if (c.imageParams == null || c.imageParams.uri == null || c.templateParameters == null || !c.templateParameters.containsKey("image_overlay") || !b.containsKey(c.templateParameters.get("image_overlay"))) {
            if (this.f978b.a(this.ar, quickPromotionDefinition.c(), al, this.av)) {
                QuickPromotionImageFetcher.a(quickPromotionDefinition.c(), this.ar);
                this.ar.setVisibility(0);
            } else {
                this.ar.setVisibility(8);
            }
            this.aq.setVisibility(8);
        } else {
            TileBadge tileBadge = (TileBadge) b.get(c.templateParameters.get("image_overlay"));
            this.aq.setParams(UserTileViewParams.a(new PicSquare(new PicSquareUrlWithSize(jW_().getDimensionPixelSize(2131433317), c.imageParams.uri), null, null), tileBadge));
            this.aq.setVisibility(0);
            this.ar.setVisibility(8);
        }
        if (this.f981f.m10114a() && this.f984i.b().m10112a(false)) {
            this.f980e.f10074t = new QPDownloadingButtonListenerImplementation(this);
            final int a2 = this.f977a.a(SideloadingPrefKeys.m10162g("com.facebook.orca"), 0);
            if (this.f982g.m10119b("com.facebook.orca")) {
                this.as.setText(2131236577);
            } else if (a2 == 1) {
                aB(this);
            } else {
                this.as.setText(2131236576);
            }
            this.as.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ DiodeQpFragment f974b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1834954882);
                    if (a2 != 2) {
                        DiodeQpFragment.aB(this.f974b);
                        this.f974b.f983h.m10128a("sideloading_diode_screen_download_button_on_click", ImmutableBiMap.b("surface", "qp"));
                    } else {
                        this.f974b.f983h.m10128a("sideloading_diode_screen_install_button_on_click", ImmutableBiMap.b("surface", "qp"));
                    }
                    this.f974b.f980e.m10149a("com.facebook.orca");
                    LogUtils.a(2096164232, a);
                }
            });
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            m1029a(c.primaryAction);
        }
        m1031b(c.secondaryAction);
        if (c.socialContext != null) {
            View inflate = this.at.inflate();
            TextView textView = (TextView) FindViewUtil.b(inflate, 2131561054);
            final FacepileView facepileView = (FacepileView) FindViewUtil.b(inflate, 2131561053);
            m1027a(textView, c.socialContext.text);
            this.f979d.a(new Callback<List<String>, ImmutableList<User>, Throwable>(this) {
                final /* synthetic */ DiodeQpFragment f968b;

                public final void m1021a(Object obj, Object obj2) {
                    ImmutableList immutableList = (ImmutableList) obj2;
                    List a = Lists.a();
                    int size = immutableList.size();
                    for (int i = 0; i < size; i++) {
                        a.add(Uri.parse(((User) immutableList.get(i)).x()));
                    }
                    facepileView.setVisibility(0);
                    facepileView.setFaceUrls(a);
                }

                public final /* bridge */ /* synthetic */ void m1022b(Object obj, Object obj2) {
                }

                public final /* bridge */ /* synthetic */ void m1023c(Object obj, Object obj2) {
                }
            });
            this.f979d.a(c.socialContext.friendIds);
        }
        LogUtils.f(235091526, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -39561925);
        super.mY_();
        this.f980e.m10148a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 509665771, a);
    }

    private void m1029a(final Action action) {
        m1026a(this.as, action, new OnClickListener(this) {
            final /* synthetic */ DiodeQpFragment f970b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1504060290);
                this.f970b.as();
                this.f970b.am = action.dismissPromotion;
                Logger.a(2, EntryType.UI_INPUT_END, 862285934, a);
            }
        });
    }

    private void m1031b(final Action action) {
        m1026a(this.au, action, new OnClickListener(this) {
            final /* synthetic */ DiodeQpFragment f972b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1877925936);
                this.f972b.au();
                this.f972b.am = action.dismissPromotion;
                Logger.a(2, EntryType.UI_INPUT_END, -2009696668, a);
            }
        });
    }

    public static void aB(DiodeQpFragment diodeQpFragment) {
        diodeQpFragment.as.setText(2131236578);
        diodeQpFragment.as.setClickable(false);
        diodeQpFragment.as.getBackground().setAlpha(92);
    }

    private static void m1027a(TextView textView, String str) {
        if (TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
            return;
        }
        textView.setText(str);
        textView.setVisibility(0);
    }

    private static void m1026a(TextView textView, Action action, OnClickListener onClickListener) {
        if (action == null || TextUtils.isEmpty(action.title)) {
            textView.setVisibility(8);
            return;
        }
        textView.setText(action.title);
        textView.setOnClickListener(onClickListener);
        textView.setVisibility(0);
    }
}
