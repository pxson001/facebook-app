package com.facebook.platform.composer.targetprivacy;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.composer.attachments.AttachmentUtils;
import com.facebook.composer.capability.ComposerMultimediaCapability;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.platform.composer.composer.PlatformComposerControllerFragment.C05061;
import com.facebook.platform.composer.composer.PlatformComposerControllerFragment.C05072;
import com.facebook.platform.composer.composer.PlatformComposerControllerFragment.C05083;
import com.facebook.platform.composer.composer.PlatformComposerControllerFragment.C05094;
import com.facebook.platform.composer.composer.PlatformComposerFragment;
import com.facebook.platform.composer.composer.PlatformComposerFragment.AnonymousClass10;
import com.facebook.platform.composer.composer.PlatformComposerFragment.AnonymousClass12;
import com.facebook.privacy.model.SelectablePrivacyData;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: result_style_list */
public class PlatformComposerTargetPrivacySelectorFragment extends FbFragment {
    @Inject
    @LoggedInUser
    public Provider<User> f4392a;
    public PlatformComposerFriendsFragment al;
    public PlatformComposerGroupFragment am;
    public ImmutableMap<PlatformComposerTargetPrivacyItemView, FbFragment> an;
    public ImmutableMap<PlatformComposerTargetPrivacyItemView, TargetType> ao;
    public C05072 ap;
    public C05083 aq;
    public AnonymousClass12 ar;
    public AnonymousClass10 as;
    public int at;
    private ViewPager au;
    public C05061 av;
    public boolean aw;
    @Inject
    public FunnelLoggerImpl f4393b;
    @Inject
    public ComposerMultimediaCapability f4394c;
    private FbTextView f4395d;
    public C05094 f4396e;
    public PlatformComposerTargetPrivacyItemView f4397f;
    public PlatformComposerTargetPrivacyItemView f4398g;
    public PlatformComposerTargetPrivacyItemView f4399h;
    private PlatformComposerPrivacyFragment f4400i;

    /* compiled from: result_style_list */
    class C05721 implements OnClickListener {
        final /* synthetic */ PlatformComposerTargetPrivacySelectorFragment f4386a;

        C05721(PlatformComposerTargetPrivacySelectorFragment platformComposerTargetPrivacySelectorFragment) {
            this.f4386a = platformComposerTargetPrivacySelectorFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -353301906);
            this.f4386a.o().onBackPressed();
            this.f4386a.f4393b.b(FunnelRegistry.l, "target_privacy_picker_backbutton");
            Logger.a(2, EntryType.UI_INPUT_END, -109445135, a);
        }
    }

    /* compiled from: result_style_list */
    class C05732 implements OnClickListener {
        final /* synthetic */ PlatformComposerTargetPrivacySelectorFragment f4387a;

        C05732(PlatformComposerTargetPrivacySelectorFragment platformComposerTargetPrivacySelectorFragment) {
            this.f4387a = platformComposerTargetPrivacySelectorFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -108761343);
            do {
            } while (this.f4387a.m4285b());
            if (!(this.f4387a.ap == null || this.f4387a.aq == null)) {
                SelectablePrivacyData e = PlatformComposerTargetPrivacySelectorFragment.at(this.f4387a).m4272e();
                if (e != null) {
                    this.f4387a.ap.m3967a(ComposerTargetData.a);
                    this.f4387a.aq.m3968a(e);
                }
            }
            this.f4387a.f4393b.b(FunnelRegistry.l, "target_privacy_picker_donebutton");
            LogUtils.a(1983926306, a);
        }
    }

    /* compiled from: result_style_list */
    class C05754 extends SimpleOnPageChangeListener {
        final /* synthetic */ PlatformComposerTargetPrivacySelectorFragment f4389a;

        C05754(PlatformComposerTargetPrivacySelectorFragment platformComposerTargetPrivacySelectorFragment) {
            this.f4389a = platformComposerTargetPrivacySelectorFragment;
        }

        public final void e_(int i) {
            this.f4389a.at = i;
            PlatformComposerTargetPrivacySelectorFragment.ay(this.f4389a);
        }
    }

    /* compiled from: result_style_list */
    public class C05765 implements OnClickListener {
        final /* synthetic */ PlatformComposerTargetPrivacySelectorFragment f4390a;

        public C05765(PlatformComposerTargetPrivacySelectorFragment platformComposerTargetPrivacySelectorFragment) {
            this.f4390a = platformComposerTargetPrivacySelectorFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 96141746);
            if (this.f4390a.f4397f == PlatformComposerTargetPrivacySelectorFragment.ax(this.f4390a)) {
                do {
                } while (!PlatformComposerTargetPrivacySelectorFragment.at(this.f4390a).m4270b());
            }
            PlatformComposerTargetPrivacyItemView platformComposerTargetPrivacyItemView = (PlatformComposerTargetPrivacyItemView) view;
            this.f4390a.at = this.f4390a.an.keySet().asList().indexOf(platformComposerTargetPrivacyItemView);
            this.f4390a.f4393b.b(FunnelRegistry.l, StringFormatUtil.formatStrLocaleSafe(" %s clicked", PlatformComposerTargetPrivacySelectorFragment.ax(this.f4390a).getTitleText()));
            PlatformComposerTargetPrivacySelectorFragment.az(this.f4390a);
            LogUtils.a(-1494738201, a);
        }
    }

    /* compiled from: result_style_list */
    /* synthetic */ class C05776 {
        static final /* synthetic */ int[] f4391a = new int[TargetType.values().length];

        static {
            try {
                f4391a[TargetType.UNDIRECTED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4391a[TargetType.USER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4391a[TargetType.GROUP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static void m4280a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PlatformComposerTargetPrivacySelectorFragment platformComposerTargetPrivacySelectorFragment = (PlatformComposerTargetPrivacySelectorFragment) obj;
        Provider a = IdBasedProvider.a(fbInjector, 3595);
        FunnelLoggerImpl a2 = FunnelLoggerImpl.a(fbInjector);
        ComposerMultimediaCapability b = ComposerMultimediaCapability.b(fbInjector);
        platformComposerTargetPrivacySelectorFragment.f4392a = a;
        platformComposerTargetPrivacySelectorFragment.f4393b = a2;
        platformComposerTargetPrivacySelectorFragment.f4394c = b;
    }

    public final View m4284a(LayoutInflater layoutInflater, ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2118218732);
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(2130906321, viewGroup, false);
        Class cls = PlatformComposerTargetPrivacySelectorFragment.class;
        m4280a(this, getContext());
        this.f4397f = (PlatformComposerTargetPrivacyItemView) viewGroup2.findViewById(2131561876);
        this.f4398g = (PlatformComposerTargetPrivacyItemView) viewGroup2.findViewById(2131566135);
        this.f4399h = (PlatformComposerTargetPrivacyItemView) viewGroup2.findViewById(2131566136);
        ((GlyphView) viewGroup2.findViewById(2131559455)).setOnClickListener(new C05721(this));
        this.f4395d = (FbTextView) viewGroup2.findViewById(2131559325);
        this.f4395d.setOnClickListener(new C05732(this));
        this.au = (ViewPager) viewGroup2.findViewById(2131562782);
        this.au.setSaveEnabled(this.aw);
        this.au.setOffscreenPageLimit(3);
        m4281e();
        this.f4393b.b(FunnelRegistry.l, "target_privacy_picker_visible");
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 24147165, a);
        return viewGroup2;
    }

    private void ar() {
        this.ao = ImmutableMap.of(this.f4397f, TargetType.UNDIRECTED, this.f4398g, TargetType.USER, this.f4399h, TargetType.GROUP);
    }

    public final void m4282G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1620935025);
        super.G();
        if (this.aw) {
            ay(this);
        } else {
            as();
        }
        LogUtils.f(921276378, a);
    }

    private void as() {
        PlatformComposerTargetPrivacyItemView platformComposerTargetPrivacyItemView;
        TargetType targetType = this.ar.f4065a.aO.f4190e.targetType;
        switch (C05776.f4391a[targetType.ordinal()]) {
            case 1:
                this.at = 0;
                break;
            case 2:
                this.at = 1;
                break;
            case 3:
                this.at = 2;
                break;
            default:
                throw new IllegalStateException("Unexpected target type \"" + targetType + "\".");
        }
        az(this);
        ay(this);
        int i = 0;
        if (AttachmentUtils.l(this.ar.f4065a.aO.f4188c.m4153e())) {
            ImmutableList asList = this.ao.keySet().asList();
            int size = asList.size();
            for (int i2 = 0; i2 < size; i2++) {
                platformComposerTargetPrivacyItemView = (PlatformComposerTargetPrivacyItemView) asList.get(i2);
                if (!this.f4394c.a((TargetType) this.ao.get(platformComposerTargetPrivacyItemView), false)) {
                    platformComposerTargetPrivacyItemView.setVisibility(8);
                }
            }
        }
        if (PlatformComposerFragment.aJ(this.ar.f4065a)) {
            ImmutableList asList2 = this.ao.keySet().asList();
            int size2 = asList2.size();
            while (i < size2) {
                Object obj;
                platformComposerTargetPrivacyItemView = (PlatformComposerTargetPrivacyItemView) asList2.get(i);
                if (((TargetType) this.ao.get(platformComposerTargetPrivacyItemView)) == TargetType.UNDIRECTED) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    platformComposerTargetPrivacyItemView.setVisibility(8);
                }
                i++;
            }
        }
    }

    public static PlatformComposerPrivacyFragment at(PlatformComposerTargetPrivacySelectorFragment platformComposerTargetPrivacySelectorFragment) {
        if (platformComposerTargetPrivacySelectorFragment.f4400i == null) {
            platformComposerTargetPrivacySelectorFragment.f4400i = PlatformComposerPrivacyFragment.m4265n(platformComposerTargetPrivacySelectorFragment.s);
            platformComposerTargetPrivacySelectorFragment.f4400i.m4268a(platformComposerTargetPrivacySelectorFragment.as);
            platformComposerTargetPrivacySelectorFragment.f4400i.ap = platformComposerTargetPrivacySelectorFragment.f4396e;
        }
        return platformComposerTargetPrivacySelectorFragment.f4400i;
    }

    public final boolean m4285b() {
        return this.f4397f == ax(this) && !at(this).m4270b();
    }

    public final void m4283H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1592076440);
        super.H();
        this.au.setSaveEnabled(this.aw);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1527499168, a);
    }

    private void m4281e() {
        C05765 c05765 = new C05765(this);
        this.f4397f.setProfilePictureUrl(Uri.parse(((User) this.f4392a.get()).x()));
        this.f4397f.setOnClickListener(c05765);
        this.f4398g.setOnClickListener(c05765);
        this.f4399h.setOnClickListener(c05765);
        PlatformComposerTargetPrivacyItemView platformComposerTargetPrivacyItemView = this.f4397f;
        PlatformComposerPrivacyFragment at = at(this);
        PlatformComposerTargetPrivacyItemView platformComposerTargetPrivacyItemView2 = this.f4398g;
        if (this.al == null) {
            this.al = PlatformComposerFriendsFragment.m4222n(this.s);
            this.al.ar = this.av;
            this.al.al = this.f4396e;
        }
        PlatformComposerFriendsFragment platformComposerFriendsFragment = this.al;
        PlatformComposerTargetPrivacyItemView platformComposerTargetPrivacyItemView3 = this.f4399h;
        if (this.am == null) {
            this.am = PlatformComposerGroupFragment.m4233n(this.s);
            this.am.ao = this.av;
            this.am.al = this.f4396e;
        }
        this.an = ImmutableMap.of(platformComposerTargetPrivacyItemView, at, platformComposerTargetPrivacyItemView2, platformComposerFriendsFragment, platformComposerTargetPrivacyItemView3, this.am);
        ar();
        this.au.setAdapter(new FragmentPagerAdapter(this, s()) {
            final /* synthetic */ PlatformComposerTargetPrivacySelectorFragment f4388a;

            public final Fragment m4277a(int i) {
                return (Fragment) this.f4388a.an.values().asList().get(i);
            }

            public final int m4279b() {
                return this.f4388a.an.size();
            }

            public final void m4278a(ViewGroup viewGroup, int i, Object obj) {
                viewGroup.removeView((View) obj);
            }
        });
        this.au.setOnPageChangeListener(new C05754(this));
    }

    public static PlatformComposerTargetPrivacyItemView ax(PlatformComposerTargetPrivacySelectorFragment platformComposerTargetPrivacySelectorFragment) {
        if (platformComposerTargetPrivacySelectorFragment.at < 0 || platformComposerTargetPrivacySelectorFragment.at >= platformComposerTargetPrivacySelectorFragment.an.size()) {
            platformComposerTargetPrivacySelectorFragment.at = 0;
        }
        return (PlatformComposerTargetPrivacyItemView) platformComposerTargetPrivacySelectorFragment.an.keySet().asList().get(platformComposerTargetPrivacySelectorFragment.at);
    }

    public static void ay(PlatformComposerTargetPrivacySelectorFragment platformComposerTargetPrivacySelectorFragment) {
        ImmutableList asList = platformComposerTargetPrivacySelectorFragment.an.keySet().asList();
        int size = asList.size();
        for (int i = 0; i < size; i++) {
            ((PlatformComposerTargetPrivacyItemView) asList.get(i)).setIsSelected(false);
        }
        ax(platformComposerTargetPrivacySelectorFragment).setIsSelected(true);
        platformComposerTargetPrivacySelectorFragment.f4395d.setVisibility(platformComposerTargetPrivacySelectorFragment.f4397f == ax(platformComposerTargetPrivacySelectorFragment) ? 0 : 8);
    }

    public static void az(PlatformComposerTargetPrivacySelectorFragment platformComposerTargetPrivacySelectorFragment) {
        if (platformComposerTargetPrivacySelectorFragment.at != -1) {
            platformComposerTargetPrivacySelectorFragment.au.setCurrentItem(platformComposerTargetPrivacySelectorFragment.at);
        }
    }
}
