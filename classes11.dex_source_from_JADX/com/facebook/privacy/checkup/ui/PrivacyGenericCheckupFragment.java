package com.facebook.privacy.checkup.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerShareParams.Builder;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.privacy.checkup.manager.IDBackedPrivacyCheckupManager;
import com.facebook.privacy.checkup.manager.IDBackedPrivacyCheckupManager.OnDataFetchedListener;
import com.facebook.privacy.checkup.manager.PrivacyCheckupStepData.PrivacyCheckupItemRow;
import com.facebook.privacy.checkup.service.PrivacyCheckupAnalyticsLogger;
import com.facebook.privacy.checkup.ui.PrivacyCheckupStepAdapter.PrivacyCheckupActionCallbackInterface;
import com.facebook.privacy.model.SelectablePrivacyData;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionFieldsWithExplanation;
import com.facebook.resources.ui.FbButton;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: SUGGEST_EDIT */
public class PrivacyGenericCheckupFragment extends FbFragment {
    private static final CallerContext f11236b = CallerContext.a(PrivacyGenericCheckupFragment.class);
    public int f11237a;
    public PrivacyCheckupStepAdapter al;
    public final PrivacyCheckupActionCallbackInterface am = new C13521(this);
    public final OnScrollListener an = new C13542(this);
    public ListView f11238c;
    public IDBackedPrivacyCheckupManager f11239d;
    private FbDraweeControllerBuilder f11240e;
    private ComposerLauncher f11241f;
    private Lazy<ComposerPublishServiceHelper> f11242g;
    public PrivacyCheckupAnalyticsLogger f11243h;
    public PrivacyCheckupStepAdapterProvider f11244i;

    /* compiled from: SUGGEST_EDIT */
    class C13521 implements PrivacyCheckupActionCallbackInterface {
        final /* synthetic */ PrivacyGenericCheckupFragment f11232a;

        C13521(PrivacyGenericCheckupFragment privacyGenericCheckupFragment) {
            this.f11232a = privacyGenericCheckupFragment;
        }

        public final void mo297a(String str, PrivacyOptionFieldsWithExplanation privacyOptionFieldsWithExplanation) {
            IDBackedPrivacyCheckupManager iDBackedPrivacyCheckupManager = this.f11232a.f11239d;
            int i = this.f11232a.f11237a;
            iDBackedPrivacyCheckupManager.f10871h.put(str, privacyOptionFieldsWithExplanation);
            PrivacyCheckupItemRow privacyCheckupItemRow = (PrivacyCheckupItemRow) iDBackedPrivacyCheckupManager.m11321a(i).f10966b.get(str);
            PrivacyOptionFieldsWithExplanation b = privacyCheckupItemRow.f10961f.b();
            if (iDBackedPrivacyCheckupManager.f10873k.get(str) == null) {
                iDBackedPrivacyCheckupManager.f10873k.put(str, b);
            }
            privacyCheckupItemRow.f10961f.b(privacyOptionFieldsWithExplanation);
            AdapterDetour.a(this.f11232a.al, -121834512);
        }

        public final void mo298a(String str, boolean z) {
            AdapterDetour.a(this.f11232a.al, -481550951);
        }

        public final boolean mo299a() {
            return true;
        }

        public final void mo300b() {
        }

        public final SelectablePrivacyData mo301c() {
            return null;
        }
    }

    /* compiled from: SUGGEST_EDIT */
    class C13542 implements OnScrollListener {
        final /* synthetic */ PrivacyGenericCheckupFragment f11234a;

        /* compiled from: SUGGEST_EDIT */
        class C13531 implements OnDataFetchedListener {
            final /* synthetic */ C13542 f11233a;

            C13531(C13542 c13542) {
                this.f11233a = c13542;
            }

            public final void mo302a() {
                AdapterDetour.a(this.f11233a.f11234a.al, 26825829);
            }

            public final void mo303b() {
            }
        }

        C13542(PrivacyGenericCheckupFragment privacyGenericCheckupFragment) {
            this.f11234a = privacyGenericCheckupFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if ((i + i2) + 8 > i3 && this.f11234a.f11239d.m11321a(this.f11234a.f11237a).f10975k) {
                this.f11234a.f11239d.m11323a(new C13531(this), this.f11234a.f11239d.f10872i, this.f11234a.f11239d.m11321a(this.f11234a.f11237a).f10974j);
            }
        }
    }

    /* compiled from: SUGGEST_EDIT */
    public class C13553 implements OnClickListener {
        final /* synthetic */ PrivacyGenericCheckupFragment f11235a;

        public C13553(PrivacyGenericCheckupFragment privacyGenericCheckupFragment) {
            this.f11235a = privacyGenericCheckupFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -637863425);
            PrivacyGenericCheckupFragment.m11631a(this.f11235a, "https://www.facebook.com/privacy/review/" + this.f11235a.f11239d.f10872i + "/");
            this.f11235a.f11243h.m11468a(this.f11235a.f11239d.f10872i, "share_timeline", null, null, null, null, null);
            Logger.a(2, EntryType.UI_INPUT_END, -2018544510, a);
        }
    }

    public static void m11632a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PrivacyGenericCheckupFragment) obj).m11630a((PrivacyCheckupStepAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PrivacyCheckupStepAdapterProvider.class), IDBackedPrivacyCheckupManager.m11319a(injectorLike), FbDraweeControllerBuilder.b(injectorLike), (ComposerLauncher) ComposerLauncherImpl.a(injectorLike), IdBasedLazy.a(injectorLike, 5272), PrivacyCheckupAnalyticsLogger.m11461b(injectorLike));
    }

    @Inject
    private void m11630a(PrivacyCheckupStepAdapterProvider privacyCheckupStepAdapterProvider, IDBackedPrivacyCheckupManager iDBackedPrivacyCheckupManager, FbDraweeControllerBuilder fbDraweeControllerBuilder, ComposerLauncher composerLauncher, Lazy<ComposerPublishServiceHelper> lazy, PrivacyCheckupAnalyticsLogger privacyCheckupAnalyticsLogger) {
        this.f11244i = privacyCheckupStepAdapterProvider;
        this.f11239d = iDBackedPrivacyCheckupManager;
        this.f11240e = fbDraweeControllerBuilder;
        this.f11241f = composerLauncher;
        this.f11242g = lazy;
        this.f11243h = privacyCheckupAnalyticsLogger;
    }

    public final void m11637c(@Nullable Bundle bundle) {
        int i;
        super.c(bundle);
        Class cls = PrivacyGenericCheckupFragment.class;
        m11632a((Object) this, getContext());
        if (this.s != null) {
            i = this.s.getInt("stepIndex");
        } else {
            i = 0;
        }
        this.f11237a = i;
    }

    public final View m11634a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2058229950);
        View inflate = layoutInflater.inflate(2130906387, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -813573473, a);
        return inflate;
    }

    public final void m11636a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.f11238c = (ListView) view.findViewById(2131566246);
        m11633e();
        az();
        aA();
        this.al = this.f11244i.m11576a(this.am, this.f11239d.m11321a(this.f11237a));
        this.f11238c.setAdapter(this.al);
        this.f11238c.setOnScrollListener(this.an);
    }

    private void m11633e() {
        View inflate = LayoutInflater.from(getContext()).inflate(2130906396, this.f11238c, false);
        TextView textView = (TextView) inflate.findViewById(2131559441);
        if (this.f11237a == this.f11239d.m11327c() - 1) {
            textView.setTextSize(20.0f);
        }
        textView.setText(this.f11239d.m11321a(this.f11237a).f10970f);
        textView = (TextView) inflate.findViewById(2131566248);
        CharSequence charSequence = this.f11239d.m11321a(this.f11237a).f10971g;
        if (!(IDBackedPrivacyCheckupManager.f10862j || ay() == null)) {
            charSequence = ay();
        }
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setText(charSequence);
            textView.setVisibility(0);
        }
        String str = this.f11239d.m11321a(this.f11237a).f10969e;
        if (str != null) {
            FbDraweeView fbDraweeView = (FbDraweeView) inflate.findViewById(2131562571);
            Uri parse = Uri.parse(str);
            fbDraweeView.setController(((FbDraweeControllerBuilder) this.f11240e.c(ImageRequest.a(parse))).a(f11236b).s());
            fbDraweeView.setImageURI(parse);
        }
        this.f11238c.addHeaderView(inflate);
    }

    private CharSequence at() {
        return this.f11239d.m11321a(this.f11237a).f10972h;
    }

    private String aw() {
        return this.f11239d.m11321a(this.f11237a).f10978n;
    }

    private String ax() {
        return this.f11239d.m11321a(this.f11237a).f10979o;
    }

    private String ay() {
        return this.f11239d.m11321a(this.f11237a).f10981q;
    }

    private void az() {
        if (at() != null && at().length() != 0) {
            View inflate = LayoutInflater.from(getContext()).inflate(2130906395, this.f11238c, false);
            ((TextView) inflate.findViewById(2131566245)).setText(at());
            this.f11238c.addFooterView(inflate);
        }
    }

    private void aA() {
        View inflate = LayoutInflater.from(getContext()).inflate(2130906385, this.f11238c, false);
        if (!(aw() == null || aw().isEmpty())) {
            TextView textView = (TextView) inflate.findViewById(2131566243);
            textView.setText(aw());
            textView.setVisibility(0);
            textView = (TextView) inflate.findViewById(2131566244);
            if (!(ax() == null || ax().isEmpty())) {
                textView.setText(ax());
                textView.setVisibility(0);
            }
        }
        this.f11238c.addFooterView(inflate);
        FbButton fbButton = (FbButton) e(2131558956);
        if (!(this.f11239d.m11321a(this.f11237a).f10980p == null || this.f11239d.m11321a(this.f11237a).f10980p.isEmpty())) {
            fbButton.setText(2131242326);
            fbButton.setVisibility(0);
        }
        fbButton.setOnClickListener(new C13553(this));
    }

    public static void m11631a(PrivacyGenericCheckupFragment privacyGenericCheckupFragment, String str) {
        privacyGenericCheckupFragment.f11241f.a(null, ComposerConfigurationFactory.a(ComposerSourceType.STORY_CALL_TO_ACTION, Builder.a(str).b()).setIsEditTagEnabled(false).setDisableFriendTagging(true).setDisableMentions(true).a(), 1756, privacyGenericCheckupFragment);
    }

    public final void m11635a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (i == 1756 && i2 == -1) {
            ((ComposerPublishServiceHelper) this.f11242g.get()).c(intent);
        }
    }
}
