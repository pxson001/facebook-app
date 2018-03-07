package com.facebook.pages.common.surface.ui.header;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelUuid;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.ui.util.ViewIdUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.StringUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.crowdsourcing.logging.CrowdEndpoint;
import com.facebook.crowdsourcing.logging.CrowdEntryPoint;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLAttributionSource;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.ipc.pages.ProfilePermissions.Permission;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.minipreview.MiniPreviewCoverPhotoProcessor;
import com.facebook.pages.common.abtest.qe.PagesExperimentUtils;
import com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderView.CaspianPagesHeaderViewHandler;
import com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel.BindModel;
import com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel.BindModel.CoverPhotoViewModel;
import com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel.BindModel.CoverPhotoViewModel.CoverPhotoSubtitleState;
import com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel.BindModel.ProfilePicViewModel;
import com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel.BindModel.ProfilePicViewModel.ProfileEditIconState;
import com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel.BindModel.ProfilePicViewModel.ProfilePicContentState;
import com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel.BindModel.ProfilePicViewModel.ProfilePicState;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageGeneralDataModel.AttributionModel;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageProfileCoverPhotosDataModel.CoverPhotoModel;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.pages.fb4a.abtest.PagesFb4aAbTestGatekeepers;
import com.facebook.places.suggestions.common.CrowdsourcingSource;
import com.facebook.places.suggestions.common.SuggestProfilePicFragment;
import com.facebook.timeline.header.util.TimelineHeaderViewHelper;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: remove_link_attachment */
public class CaspianPagesHeaderViewController implements CaspianPagesHeaderViewHandler {
    public final CaspianPagesHeaderViewPerfLogging f2603a;
    private final Lazy<GatekeeperStore> f2604b;
    private Provider<MiniPreviewCoverPhotoProcessor> f2605c;
    private final Provider<Executor> f2606d;
    public final Context f2607e;
    public final Provider<UriIntentMapper> f2608f;
    public final Provider<SecureContextHelper> f2609g;
    private final PagesExperimentUtils f2610h;
    private PageHeaderData f2611i;
    public BindModel f2612j;
    private String f2613k;
    public CaspianPagesHeaderViewCallbacks f2614l;
    private FragmentManager f2615m;
    private SuggestProfilePicFragment f2616n;
    private FrameLayout f2617o;

    /* compiled from: remove_link_attachment */
    class C03481 implements FutureCallback<Drawable> {
        final /* synthetic */ CaspianPagesHeaderViewController f2596a;

        C03481(CaspianPagesHeaderViewController caspianPagesHeaderViewController) {
            this.f2596a = caspianPagesHeaderViewController;
        }

        public void onSuccess(@Nullable Object obj) {
            Drawable drawable = (Drawable) obj;
            this.f2596a.f2603a.mo71c();
            this.f2596a.f2614l.mo59a(drawable);
        }

        public void onFailure(Throwable th) {
        }
    }

    /* compiled from: remove_link_attachment */
    class C03492 implements Runnable {
        final /* synthetic */ CaspianPagesHeaderViewController f2597a;

        C03492(CaspianPagesHeaderViewController caspianPagesHeaderViewController) {
            this.f2597a = caspianPagesHeaderViewController;
        }

        public void run() {
            this.f2597a.f2607e;
        }
    }

    /* compiled from: remove_link_attachment */
    class C03503 implements OnClickListener {
        final /* synthetic */ CaspianPagesHeaderViewController f2598a;

        C03503(CaspianPagesHeaderViewController caspianPagesHeaderViewController) {
            this.f2598a = caspianPagesHeaderViewController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1525650013);
            Intent a2 = ((UriIntentMapper) this.f2598a.f2608f.get()).a(this.f2598a.f2607e, StringFormatUtil.formatStrLocaleSafe("https://m.facebook.com/%s/settings/username", Long.valueOf(this.f2598a.f2612j.f2636f)));
            if (a2 != null) {
                ((SecureContextHelper) this.f2598a.f2609g.get()).a(a2, this.f2598a.f2607e);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -198741378, a);
        }
    }

    private void m3558a(PageHeaderData pageHeaderData) {
        CoverPhotoModel u = pageHeaderData.e.u();
        String str = null;
        if (!(!pageHeaderData.e.y() || u == null || u.j() == null || u.j().n() == null)) {
            str = u.j().n();
        }
        if (str != null && !str.equals(this.f2613k)) {
            this.f2613k = str;
            Long.toString(pageHeaderData.a);
            m3563c();
        }
    }

    @Inject
    public CaspianPagesHeaderViewController(@Assisted Context context, CaspianPagesHeaderViewPerfLogging caspianPagesHeaderViewPerfLogging, Provider<MiniPreviewCoverPhotoProcessor> provider, Provider<Executor> provider2, Lazy<GatekeeperStore> lazy, Provider<UriIntentMapper> provider3, Provider<SecureContextHelper> provider4, PagesExperimentUtils pagesExperimentUtils) {
        this.f2607e = context;
        this.f2603a = caspianPagesHeaderViewPerfLogging;
        this.f2605c = provider;
        this.f2606d = provider2;
        this.f2604b = lazy;
        this.f2608f = provider3;
        this.f2609g = provider4;
        this.f2610h = pagesExperimentUtils;
    }

    public final BindModel mo62a(PageHeaderData pageHeaderData, CaspianPagesHeaderViewCallbacks caspianPagesHeaderViewCallbacks) {
        Preconditions.checkNotNull(pageHeaderData);
        this.f2614l = caspianPagesHeaderViewCallbacks;
        boolean a = pageHeaderData.a(Permission.EDIT_PROFILE);
        boolean z = !pageHeaderData.a(Permission.BASIC_ADMIN);
        this.f2611i = pageHeaderData;
        this.f2612j = new BindModel(a, z, m3568e(), pageHeaderData.c(), pageHeaderData.e.D(), pageHeaderData.a, m3566d(pageHeaderData), pageHeaderData.e.O());
        this.f2603a.mo68a(this.f2611i, this.f2612j);
        m3558a(pageHeaderData);
        m3561b(pageHeaderData);
        return this.f2612j;
    }

    public final void mo63a(ParcelUuid parcelUuid) {
        this.f2603a.mo67a(parcelUuid);
    }

    public final BaseControllerListener mo61a() {
        return this.f2603a.mo66a();
    }

    public final BaseControllerListener mo65b() {
        return this.f2603a.mo70b();
    }

    public final void mo64a(FragmentManager fragmentManager) {
        this.f2615m = fragmentManager;
    }

    private void m3563c() {
        Futures.a(((MiniPreviewCoverPhotoProcessor) this.f2605c.get()).a(this.f2613k, TimelineHeaderViewHelper.a(this.f2607e)), new C03481(this), (Executor) this.f2606d.get());
    }

    private void m3561b(PageHeaderData pageHeaderData) {
        if (this.f2615m != null && this.f2607e != null) {
            boolean e = m3570e(pageHeaderData);
            this.f2603a.mo69a(e);
            if (e) {
                HandlerDetour.b(new Handler(Looper.getMainLooper()), new C03492(this), 1000, 341358046);
                return;
            }
            if (this.f2616n != null) {
                this.f2615m.a().a(this.f2616n).c();
            }
            this.f2614l.mo60a(false, this.f2617o);
            this.f2616n = null;
            this.f2617o = null;
        }
    }

    public static void m3567d(CaspianPagesHeaderViewController caspianPagesHeaderViewController) {
        Activity activity = (Activity) ContextUtils.a(caspianPagesHeaderViewController.f2607e, Activity.class);
        if (activity != null && !caspianPagesHeaderViewController.f2615m.g() && !activity.isFinishing() && caspianPagesHeaderViewController.f2616n == null) {
            caspianPagesHeaderViewController.f2617o = new FrameLayout(caspianPagesHeaderViewController.f2607e);
            caspianPagesHeaderViewController.f2617o.setId(ViewIdUtil.a());
            caspianPagesHeaderViewController.f2616n = new SuggestProfilePicFragment();
            caspianPagesHeaderViewController.f2616n.aq = CrowdsourcingSource.FINCH_PROFILE;
            caspianPagesHeaderViewController.f2616n.ar = CrowdEntryPoint.PAGE_HEADER_ADD_PHOTO_BUTTON;
            caspianPagesHeaderViewController.f2616n.as = CrowdEndpoint.SUGGEST_PROFILE_PICTURE;
            caspianPagesHeaderViewController.f2616n.ao = caspianPagesHeaderViewController.f2612j.f2636f;
            caspianPagesHeaderViewController.f2616n.al = true;
            caspianPagesHeaderViewController.f2616n.i = true;
            caspianPagesHeaderViewController.f2615m.a().a(caspianPagesHeaderViewController.f2617o.getId(), caspianPagesHeaderViewController.f2616n).c();
            caspianPagesHeaderViewController.f2614l.mo60a(true, caspianPagesHeaderViewController.f2617o);
        }
    }

    private static String m3562c(PageHeaderData pageHeaderData) {
        StringBuilder stringBuilder = new StringBuilder();
        ImmutableList s = pageHeaderData.e.s();
        if (!(s == null || s.isEmpty())) {
            stringBuilder.append((String) s.get(0));
            for (int i = 1; i < s.size(); i++) {
                stringBuilder.append(" · ").append((String) s.get(i));
            }
        }
        return stringBuilder.toString();
    }

    private static ProfilePicViewModel m3566d(PageHeaderData pageHeaderData) {
        ProfilePicState profilePicState;
        ProfileEditIconState profileEditIconState;
        if (!pageHeaderData.c() || pageHeaderData.e.y()) {
            profilePicState = ProfilePicState.VISIBLE;
        } else {
            profilePicState = ProfilePicState.NOT_VISIBLE;
        }
        if (pageHeaderData.e.O() || !pageHeaderData.a(Permission.EDIT_PROFILE)) {
            profileEditIconState = ProfileEditIconState.NOT_VISIBLE;
        } else {
            profileEditIconState = ProfileEditIconState.VISIBLE;
        }
        Object obj = pageHeaderData.g;
        if (!(!StringUtil.a(obj) || pageHeaderData.e.M() == null || pageHeaderData.e.M().m() == null)) {
            obj = pageHeaderData.e.M().m().b();
        }
        Object obj2 = null;
        if (pageHeaderData.e.N() != null) {
            obj2 = pageHeaderData.e.N().b();
        }
        ProfilePicContentState profilePicContentState = (StringUtil.a(obj) && StringUtil.a(obj2)) ? ProfilePicContentState.NO_DATA : ProfilePicContentState.HAS_DATA;
        return new ProfilePicViewModel(profilePicState, profileEditIconState, profilePicContentState, obj, obj2);
    }

    private CoverPhotoViewModel m3568e() {
        String str;
        PointF pointF;
        String[] strArr;
        OnClickListener onClickListener;
        CoverPhotoSubtitleState coverPhotoSubtitleState;
        String c;
        boolean z = true;
        if (this.f2611i.e.y() || !this.f2611i.c()) {
            CoverPhotoModel u = this.f2611i.e.u();
            if (u == null || u.j() == null || u.j().m() == null || StringUtil.a(u.j().m().b())) {
                str = null;
            } else {
                str = u.j().m().b();
            }
            if (u == null || u.a() == null) {
                pointF = null;
            } else {
                pointF = new PointF((float) u.a().a(), (float) u.a().j());
            }
            strArr = (u == null || u.j() == null || u.j().j() == null) ? new String[]{this.f2611i.e.D()} : new String[]{this.f2611i.e.D(), u.j().j()};
        } else {
            String a;
            if (this.f2611i.e.L() != null) {
                a = this.f2611i.e.L().a();
            } else {
                a = null;
            }
            strArr = new String[]{this.f2611i.e.D()};
            pointF = null;
            str = a;
        }
        String ac = this.f2611i.e.ac();
        CoverPhotoSubtitleState coverPhotoSubtitleState2 = CoverPhotoSubtitleState.CATEGORY;
        CoverPhotoSubtitleState coverPhotoSubtitleState3;
        if (!((GatekeeperStoreImpl) this.f2604b.get()).a(PagesFb4aAbTestGatekeepers.h, false) || !this.f2611i.e.X()) {
            if (!this.f2610h.d()) {
                onClickListener = null;
                coverPhotoSubtitleState = coverPhotoSubtitleState2;
                c = m3562c(this.f2611i);
            }
            onClickListener = null;
            coverPhotoSubtitleState3 = coverPhotoSubtitleState2;
            c = null;
            coverPhotoSubtitleState = coverPhotoSubtitleState3;
        } else if (StringUtil.a(ac)) {
            if (this.f2611i.a(Permission.ADMINISTER) && ((GatekeeperStoreImpl) this.f2604b.get()).a(PagesFb4aAbTestGatekeepers.i, false)) {
                CoverPhotoSubtitleState coverPhotoSubtitleState4 = CoverPhotoSubtitleState.CREATE_USERNAME;
                onClickListener = m3571f();
                c = null;
                coverPhotoSubtitleState = coverPhotoSubtitleState4;
            }
            onClickListener = null;
            coverPhotoSubtitleState3 = coverPhotoSubtitleState2;
            c = null;
            coverPhotoSubtitleState = coverPhotoSubtitleState3;
        } else {
            c = StringFormatUtil.formatStrLocaleSafe("@%s", ac);
            coverPhotoSubtitleState = CoverPhotoSubtitleState.USERNAME;
            onClickListener = this.f2611i.a(Permission.ADMINISTER) ? m3554a(ac) : m3559b(ac);
        }
        boolean z2 = this.f2610h.c() && this.f2611i.c() && !this.f2611i.e.y();
        if (this.f2610h.c()) {
            z = false;
        }
        return new CoverPhotoViewModel(str, pointF, strArr, coverPhotoSubtitleState, c, z, z2, onClickListener);
    }

    private OnClickListener m3571f() {
        return new C03503(this);
    }

    private OnClickListener m3554a(final String str) {
        return new OnClickListener(this) {
            final /* synthetic */ CaspianPagesHeaderViewController f2600b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1969686947);
                CaspianPagesHeaderViewController caspianPagesHeaderViewController = this.f2600b;
                CaspianPagesHeaderViewController.m3556a(view, view.getResources().getString(2131234846, new Object[]{str}));
                Logger.a(2, EntryType.UI_INPUT_END, -1167282575, a);
            }
        };
    }

    private OnClickListener m3559b(final String str) {
        return new OnClickListener(this) {
            final /* synthetic */ CaspianPagesHeaderViewController f2602b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -150042404);
                CaspianPagesHeaderViewController caspianPagesHeaderViewController = this.f2602b;
                CaspianPagesHeaderViewController.m3556a(view, view.getResources().getString(2131234847, new Object[]{str}));
                Logger.a(2, EntryType.UI_INPUT_END, -250071155, a);
            }
        };
    }

    public static void m3556a(View view, String str) {
        Tooltip tooltip = new Tooltip(view.getContext(), 1);
        tooltip.b(str);
        tooltip.a(Position.BELOW);
        tooltip.t = -1;
        tooltip.a(view, ((-view.getWidth()) / 2) + 30, 0, view.getWidth(), view.getHeight());
        tooltip.d();
    }

    private static boolean m3570e(PageHeaderData pageHeaderData) {
        if (!pageHeaderData.c() || pageHeaderData.e.y() || !pageHeaderData.e.O()) {
            return false;
        }
        if (pageHeaderData.e.K() == GraphQLPlaceType.RESIDENCE) {
            return false;
        }
        if (!(pageHeaderData.e.m() == null || pageHeaderData.e.m().isEmpty())) {
            ImmutableList m = pageHeaderData.e.m();
            int size = m.size();
            for (int i = 0; i < size; i++) {
                if (((AttributionModel) m.get(i)).a() == GraphQLAttributionSource.WIKIPEDIA) {
                    return false;
                }
            }
        }
        return true;
    }
}
