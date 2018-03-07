package com.facebook.friendsharing.meme.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.util.FindViewUtil;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerShareParams.Builder;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.productionprompts.logging.PromptAnalytics;
import com.facebook.widget.recyclerview.BetterGridLayoutManager;
import com.facebook.widget.recyclerview.GridSpacingItemDecoration;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: SAMSUNG-SGH-I747 */
public class MemePickerFragment extends FbFragment {
    public static final String f23932a = MemePickerFragment.class.getSimpleName();
    @Nullable
    private String al;
    @Inject
    public MemePickerScrollAdapterProvider f23933b;
    @Inject
    public ComposerLauncher f23934c;
    @Inject
    public MemePickerAnalyticsLogger f23935d;
    private RecyclerView f23936e;
    public String f23937f;
    private ComposerConfiguration f23938g;
    private ImmutableList<String> f23939h;
    public PromptAnalytics f23940i;

    public static void m26065a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        MemePickerFragment memePickerFragment = (MemePickerFragment) obj;
        MemePickerScrollAdapterProvider memePickerScrollAdapterProvider = (MemePickerScrollAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(MemePickerScrollAdapterProvider.class);
        ComposerLauncher composerLauncher = (ComposerLauncher) ComposerLauncherImpl.a(fbInjector);
        MemePickerAnalyticsLogger b = MemePickerAnalyticsLogger.b(fbInjector);
        memePickerFragment.f23933b = memePickerScrollAdapterProvider;
        memePickerFragment.f23934c = composerLauncher;
        memePickerFragment.f23935d = b;
    }

    public final void m26071c(Bundle bundle) {
        super.c(bundle);
        Class cls = MemePickerFragment.class;
        m26065a((Object) this, getContext());
    }

    public final View m26067a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 863874114);
        View inflate = layoutInflater.inflate(2130905209, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 199386241, a);
        return inflate;
    }

    public final void m26069a(View view, Bundle bundle) {
        this.f23936e = (RecyclerView) FindViewUtil.b(view, 2131563796);
        this.f23937f = this.s.getString("extra_meme_picker_session_id");
        this.f23938g = (ComposerConfiguration) this.s.getParcelable("extra_meme_picker_composer_config");
        this.f23939h = ImmutableList.copyOf(this.s.getStringArrayList("extra_meme_urls"));
        this.f23940i = (PromptAnalytics) this.s.getParcelable("extra_prompt_analytics");
        this.al = this.s.getString("extra_selected_meme");
        if (this.al != null) {
            m26070a(this.al);
        } else {
            m26066e();
        }
    }

    public final void m26068a(int i, int i2, Intent intent) {
        if (i == 1) {
            ao().setResult(i2, intent);
            ao().finish();
        }
    }

    private void m26066e() {
        this.f23936e.setLayoutManager(new BetterGridLayoutManager(getContext(), 2));
        RecyclerView recyclerView = this.f23936e;
        MemePickerScrollAdapterProvider memePickerScrollAdapterProvider = this.f23933b;
        recyclerView.setAdapter(new MemePickerScrollAdapter(getContext(), this.f23939h, this, Integer.valueOf(2), FbDraweeControllerBuilder.b(memePickerScrollAdapterProvider)));
        this.f23936e.a(new GridSpacingItemDecoration(jW_().getDimensionPixelSize(2131432479)));
    }

    public final void m26070a(String str) {
        this.f23934c.a(this.f23937f, ComposerConfiguration.a(this.f23938g).setInitialShareParams(Builder.a(str).b()).a(), 1, this);
        this.f23935d.a.a(MemePickerAnalyticsLogger.b("launch_composer", this.f23937f).b("meme_url", str));
    }
}
