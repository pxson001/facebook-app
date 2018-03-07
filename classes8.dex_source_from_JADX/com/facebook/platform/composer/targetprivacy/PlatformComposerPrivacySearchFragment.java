package com.facebook.platform.composer.targetprivacy;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.platform.composer.composer.PlatformComposerControllerFragment.C05072;
import com.facebook.platform.composer.composer.PlatformComposerControllerFragment.C05083;
import com.facebook.platform.composer.composer.PlatformComposerFragment.AnonymousClass10;
import com.facebook.privacy.model.SelectablePrivacyData;
import com.facebook.resources.ui.FbTextView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: results_count */
public class PlatformComposerPrivacySearchFragment extends FbFragment {
    @Inject
    public FunnelLoggerImpl f4375a;
    private PlatformComposerPrivacyFragment f4376b;
    public AnonymousClass10 f4377c;
    public C05083 f4378d;
    public C05072 f4379e;

    /* compiled from: results_count */
    class C05691 implements OnClickListener {
        final /* synthetic */ PlatformComposerPrivacySearchFragment f4373a;

        C05691(PlatformComposerPrivacySearchFragment platformComposerPrivacySearchFragment) {
            this.f4373a = platformComposerPrivacySearchFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1510532577);
            this.f4373a.o().onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, 1255502080, a);
        }
    }

    /* compiled from: results_count */
    class C05702 implements OnClickListener {
        final /* synthetic */ PlatformComposerPrivacySearchFragment f4374a;

        C05702(PlatformComposerPrivacySearchFragment platformComposerPrivacySearchFragment) {
            this.f4374a = platformComposerPrivacySearchFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -959763045);
            this.f4374a.f4375a.b(FunnelRegistry.l, "target_privacy_picker_donebutton");
            if (!(this.f4374a.f4379e == null || this.f4374a.f4378d == null)) {
                PlatformComposerPrivacySearchFragment.m4274b(this.f4374a).m4270b();
                SelectablePrivacyData e = PlatformComposerPrivacySearchFragment.m4274b(this.f4374a).m4272e();
                if (e != null) {
                    this.f4374a.f4379e.m3967a(ComposerTargetData.a);
                    this.f4374a.f4378d.m3968a(e);
                }
            }
            Logger.a(2, EntryType.UI_INPUT_END, 441844554, a);
        }
    }

    public static void m4273a(Object obj, Context context) {
        ((PlatformComposerPrivacySearchFragment) obj).f4375a = FunnelLoggerImpl.a(FbInjector.get(context));
    }

    public final void m4276c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = PlatformComposerPrivacySearchFragment.class;
        m4273a(this, getContext());
    }

    public final View m4275a(LayoutInflater layoutInflater, ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1942162492);
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(2130906311, viewGroup, false);
        ((FbTextView) viewGroup2.findViewById(2131559636)).setText(jW_().getString(2131238396));
        viewGroup2.findViewById(2131559455).setOnClickListener(new C05691(this));
        ((FbTextView) viewGroup2.findViewById(2131559325)).setOnClickListener(new C05702(this));
        FragmentTransaction a2 = this.D.a();
        a2.a(2131566121, m4274b(this));
        a2.b();
        this.f4375a.b(FunnelRegistry.l, "target_privacy_picker_privacy_search");
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1082249932, a);
        return viewGroup2;
    }

    public static PlatformComposerPrivacyFragment m4274b(PlatformComposerPrivacySearchFragment platformComposerPrivacySearchFragment) {
        if (platformComposerPrivacySearchFragment.f4376b == null) {
            platformComposerPrivacySearchFragment.f4376b = PlatformComposerPrivacyFragment.m4265n(platformComposerPrivacySearchFragment.s);
            platformComposerPrivacySearchFragment.f4376b.m4268a(platformComposerPrivacySearchFragment.f4377c);
            platformComposerPrivacySearchFragment.f4376b.ax = true;
        }
        return platformComposerPrivacySearchFragment.f4376b;
    }
}
