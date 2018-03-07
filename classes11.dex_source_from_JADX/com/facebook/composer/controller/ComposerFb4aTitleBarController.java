package com.facebook.composer.controller;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.activity.ComposerFragment;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass65;
import com.facebook.composer.analytics.ComposerAnalyticsLogger.Events;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventHandler;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.composer.targetselection.ComposerTargetSelectorController;
import com.facebook.composer.ui.titlebar.FbTitleViewWithTriangle;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesCanSubmit;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsPostCompositionOverlayShowing;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsPostCompositionViewSupported;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;
import com.facebook.ipc.composer.model.ComposerFacecastInfo.ProvidesFacecastInfo;
import com.facebook.ipc.composer.model.PublishMode.ProvidesPublishMode;
import com.facebook.ipc.composer.model.RedSpaceValue;
import com.facebook.ipc.composer.model.RedSpaceValue.ProvidesRedSpaceValue;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginPublishButtonTextGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginTitleGetter;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: initialFetch */
public class ComposerFb4aTitleBarController<DataProvider extends ProvidesTargetData & ProvidesPluginPublishButtonTextGetter & ProvidesPluginTitleGetter & ProvidesConfiguration & ProvidesCanSubmit & ProvidesIsPostCompositionOverlayShowing & ProvidesIsPostCompositionViewSupported & ProvidesFacecastInfo & ProvidesPublishMode & ProvidesRedSpaceValue> implements ComposerEventHandler {
    public final OnClickListener f6242a = new C07761(this);
    public final WeakReference<DataProvider> f6243b;
    public final ComposerTargetSelectorController f6244c;
    public final WeakReference<Delegate> f6245d;
    public final WeakReference<FbTitleBar> f6246e;
    private final WeakReference<View> f6247f;
    public final List<TitleBarButtonSpec> f6248g = new ArrayList(1);
    public final Context f6249h;
    public final ComposerTitleGenerator f6250i;
    public final ComposerPublishButtonGenerator f6251j;
    public FigPopoverMenuWindow f6252k;
    public WeakReference<FbTitleViewWithTriangle> f6253l;

    /* compiled from: initialFetch */
    class C07761 implements OnClickListener {
        final /* synthetic */ ComposerFb4aTitleBarController f6238a;

        C07761(ComposerFb4aTitleBarController composerFb4aTitleBarController) {
            this.f6238a = composerFb4aTitleBarController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -163199069);
            if (this.f6238a.f6252k == null) {
                this.f6238a.f6252k = new FigPopoverMenuWindow(this.f6238a.f6249h);
                this.f6238a.f6252k.a(true);
            }
            this.f6238a.f6252k.c(view);
            PopoverMenu c = this.f6238a.f6252k.c();
            this.f6238a.f6244c.m8279a(this.f6238a.f6252k.c());
            if (c.size() == 1) {
                c.performIdentifierAction(c.getItem(0).getItemId(), 0);
            } else {
                this.f6238a.f6252k.d();
            }
            LogUtils.a(858045533, a);
        }
    }

    /* compiled from: initialFetch */
    class C07772 implements OnClickListener {
        final /* synthetic */ ComposerFb4aTitleBarController f6239a;

        C07772(ComposerFb4aTitleBarController composerFb4aTitleBarController) {
            this.f6239a = composerFb4aTitleBarController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1124078037);
            ((AnonymousClass65) Preconditions.checkNotNull(this.f6239a.f6245d.get())).f6105a.o().onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, -195928511, a);
        }
    }

    /* compiled from: initialFetch */
    class C07783 extends OnToolbarButtonListener {
        final /* synthetic */ ComposerFb4aTitleBarController f6240a;

        C07783(ComposerFb4aTitleBarController composerFb4aTitleBarController) {
            this.f6240a = composerFb4aTitleBarController;
        }

        public final void m7711a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            if (ComposerFb4aTitleBarController.m7714c(this.f6240a)) {
                AnonymousClass65 anonymousClass65 = (AnonymousClass65) this.f6240a.f6245d.get();
                anonymousClass65.f6105a.bJ.a(Events.COMPOSER_POST_COMPOSITION_CLICK, anonymousClass65.f6105a.aS.ab());
                ComposerFragment.m7545a(anonymousClass65.f6105a, true);
                return;
            }
            ComposerFragment.bu(((AnonymousClass65) this.f6240a.f6245d.get()).f6105a);
        }
    }

    /* compiled from: initialFetch */
    /* synthetic */ class C07794 {
        static final /* synthetic */ int[] f6241a = new int[ComposerEvent.values().length];

        static {
            try {
                f6241a[ComposerEvent.ON_DATASET_CHANGE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6241a[ComposerEvent.ON_STATUS_TEXT_CHANGED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    @Inject
    public ComposerFb4aTitleBarController(@Assisted ViewStub viewStub, @Assisted DataProvider dataProvider, @Assisted ComposerMenuCreator composerMenuCreator, @Assisted Delegate delegate, Context context, ComposerTitleGenerator composerTitleGenerator, ComposerPublishButtonGeneratorProvider composerPublishButtonGeneratorProvider) {
        this.f6249h = context;
        this.f6243b = new WeakReference(Preconditions.checkNotNull(dataProvider));
        this.f6244c = (ComposerTargetSelectorController) Preconditions.checkNotNull(composerMenuCreator);
        this.f6245d = new WeakReference(Preconditions.checkNotNull(delegate));
        this.f6250i = composerTitleGenerator;
        this.f6251j = composerPublishButtonGeneratorProvider.m7726a(dataProvider);
        viewStub.setLayoutResource(2130903667);
        View inflate = viewStub.inflate();
        this.f6247f = new WeakReference(inflate);
        FbTitleBar fbTitleBar = (FbTitleBar) inflate;
        this.f6246e = new WeakReference(fbTitleBar);
        fbTitleBar.a(new C07772(this));
        fbTitleBar.setOnToolbarButtonListener(new C07783(this));
        this.f6253l = new WeakReference((FbTitleViewWithTriangle) fbTitleBar.f_(2130903668));
        m7712a();
    }

    public final void m7716a(ComposerEvent composerEvent, @Nullable ComposerEventOriginator composerEventOriginator) {
        switch (C07794.f6241a[composerEvent.ordinal()]) {
            case 1:
            case 2:
                m7712a();
                return;
            default:
                return;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m7712a() {
        /*
        r7 = this;
        r4 = 0;
        r0 = r7.f6243b;
        r0 = r0.get();
        r0 = com.google.common.base.Preconditions.checkNotNull(r0);
        r5 = r0;
        r5 = (com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData) r5;
        r0 = r7.f6253l;
        r0 = r0.get();
        r0 = com.google.common.base.Preconditions.checkNotNull(r0);
        r6 = r0;
        r6 = (com.facebook.composer.ui.titlebar.FbTitleViewWithTriangle) r6;
        r0 = r7.f6250i;
        r1 = r5;
        r1 = (com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginTitleGetter) r1;
        r1 = r1.aw();
        r2 = r5;
        r2 = (com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration) r2;
        r2 = r2.o();
        r3 = r5.s();
        r5 = (com.facebook.ipc.composer.model.RedSpaceValue.ProvidesRedSpaceValue) r5;
        r5 = r5.k();
        r0 = r0.m7753a(r1, r2, r3, r4, r5);
        r6.setText(r0);
        r0 = r7.f6244c;
        r0 = r0.m8280a();
        if (r0 == 0) goto L_0x00bf;
    L_0x0044:
        r0 = 1;
        r6.setShouldShowTriangle(r0);
        r0 = r7.f6242a;
        r6.setOnClickListener(r0);
    L_0x004d:
        r0 = r7.f6243b;
        r0 = r0.get();
        r0 = com.google.common.base.Preconditions.checkNotNull(r0);
        r0 = (com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData) r0;
        r1 = m7714c(r7);
        if (r1 == 0) goto L_0x00c7;
    L_0x005f:
        r1 = r7.f6249h;
        r1 = r1.getResources();
        r2 = 2131234758; // 0x7f080fc6 float:1.808569E38 double:1.052969877E-314;
        r1 = r1.getString(r2);
    L_0x006c:
        r2 = com.facebook.widget.titlebar.TitleBarButtonSpec.a();
        r2.g = r1;
        r1 = r2;
        r2 = 1;
        r1.q = r2;
        r1 = r1;
        r2 = -2;
        r1.h = r2;
        r1 = r1;
        r0 = (com.facebook.composer.activity.ComposerDataProviderImpl) r0;
        r3 = r0.f6037u;
        r3 = r3.m7746a();
        r0 = r3;
        r1.d = r0;
        r0 = r1;
        r0 = r0.a();
        r1 = r7.f6248g;
        r1 = r1.isEmpty();
        if (r1 != 0) goto L_0x00a0;
    L_0x0093:
        r1 = r7.f6248g;
        r2 = 0;
        r1 = r1.get(r2);
        r1 = r0.equals(r1);
        if (r1 != 0) goto L_0x00bb;
    L_0x00a0:
        r1 = r7.f6248g;
        r1.clear();
        r1 = r7.f6248g;
        r1.add(r0);
        r0 = r7.f6246e;
        r0 = r0.get();
        r0 = com.google.common.base.Preconditions.checkNotNull(r0);
        r0 = (com.facebook.widget.titlebar.FbTitleBar) r0;
        r1 = r7.f6248g;
        r0.setButtonSpecs(r1);
    L_0x00bb:
        r7.m7715e();
        return;
    L_0x00bf:
        r6.setShouldShowTriangle(r4);
        r0 = 0;
        r6.setOnClickListener(r0);
        goto L_0x004d;
    L_0x00c7:
        r1 = r7.f6251j;
        r5 = 0;
        r3 = r1.f6284a;
        r3 = r3.get();
        r3 = com.google.common.base.Preconditions.checkNotNull(r3);
        r3 = (com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration) r3;
        r6 = com.facebook.composer.controller.ComposerPublishButtonGenerator.C07831.f6283a;
        r4 = r3;
        r4 = (com.facebook.ipc.composer.model.PublishMode.ProvidesPublishMode) r4;
        r4 = r4.j();
        r4 = r4.ordinal();
        r4 = r6[r4];
        switch(r4) {
            case 1: goto L_0x00fb;
            case 2: goto L_0x0176;
            case 3: goto L_0x0181;
            default: goto L_0x00e8;
        };
    L_0x00e8:
        r3 = r1.f6286c;
        r3 = r3.get();
        r3 = (com.facebook.common.errorreporting.AbstractFbErrorReporter) r3;
        r4 = "composer_get_titlebar_button_spec";
        r6 = "Publish Mode not set.";
        r3.a(r4, r6);
        r3 = r5;
    L_0x00f8:
        r1 = r3;
        goto L_0x006c;
    L_0x00fb:
        r4 = r3;
        r4 = (com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginPublishButtonTextGetter) r4;
        r4 = r4.as();
        if (r4 == 0) goto L_0x0111;
    L_0x0104:
        r3 = (com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginPublishButtonTextGetter) r3;
        r3 = r3.as();
        r3 = r3.a();
        r3 = (java.lang.String) r3;
        goto L_0x00f8;
    L_0x0111:
        r4 = r3.o();
        r4 = r4.isEdit();
        if (r4 == 0) goto L_0x0125;
    L_0x011b:
        r3 = r1.f6285b;
        r4 = 2131234526; // 0x7f080ede float:1.808522E38 double:1.0529697625E-314;
        r3 = r3.getString(r4);
        goto L_0x00f8;
    L_0x0125:
        r4 = r3;
        r4 = (com.facebook.composer.activity.ComposerDataProviderImpl) r4;
        r4 = r4.m7429e();
        r4 = r4.facecastCameraIndex;
        r6 = -1;
        if (r4 == r6) goto L_0x013b;
    L_0x0131:
        r3 = r1.f6285b;
        r4 = 2131234520; // 0x7f080ed8 float:1.8085208E38 double:1.0529697596E-314;
        r3 = r3.getString(r4);
        goto L_0x00f8;
    L_0x013b:
        r4 = r3;
        r4 = (com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData) r4;
        r4 = r4.s();
        r4 = r4.a();
        if (r4 == 0) goto L_0x0152;
    L_0x0148:
        r3 = r1.f6285b;
        r4 = 2131234521; // 0x7f080ed9 float:1.808521E38 double:1.05296976E-314;
        r3 = r3.getString(r4);
        goto L_0x00f8;
    L_0x0152:
        r3 = r3.o();
        r3 = r3.getComposerType();
        r4 = com.facebook.ipc.composer.model.ComposerType.SHARE;
        if (r3 != r4) goto L_0x016c;
    L_0x015e:
        r3 = r1.f6287d;
        r4 = com.facebook.composer.abtest.ExperimentsForComposerAbTestModule.T;
        r3 = r3.a(r4, r5);
        r4 = android.text.TextUtils.isEmpty(r3);
        if (r4 == 0) goto L_0x00f8;
    L_0x016c:
        r3 = r1.f6285b;
        r4 = 2131234519; // 0x7f080ed7 float:1.8085206E38 double:1.052969759E-314;
        r3 = r3.getString(r4);
        goto L_0x00f8;
    L_0x0176:
        r3 = r1.f6285b;
        r4 = 2131234626; // 0x7f080f42 float:1.8085423E38 double:1.052969812E-314;
        r3 = r3.getString(r4);
        goto L_0x00f8;
    L_0x0181:
        r3 = r1.f6285b;
        r4 = 2131234632; // 0x7f080f48 float:1.8085435E38 double:1.052969815E-314;
        r3 = r3.getString(r4);
        goto L_0x00f8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.composer.controller.ComposerFb4aTitleBarController.a():void");
    }

    public static boolean m7714c(ComposerFb4aTitleBarController composerFb4aTitleBarController) {
        Preconditions.checkNotNull(composerFb4aTitleBarController.f6243b.get());
        return ((ComposerDataProviderImpl) ((ProvidesTargetData) composerFb4aTitleBarController.f6243b.get())).m7412N() && !((ComposerDataProviderImpl) ((ProvidesTargetData) composerFb4aTitleBarController.f6243b.get())).f6035s.m7481a().f6756n;
    }

    private void m7715e() {
        ProvidesTargetData providesTargetData = (ProvidesTargetData) Preconditions.checkNotNull(this.f6243b.get());
        View view = (View) this.f6247f.get();
        if (view != null) {
            Drawable drawable = (Drawable) view.getTag(2131558585);
            if (((ProvidesRedSpaceValue) providesTargetData).k() == RedSpaceValue.POST_TO_REDSPACE) {
                if (drawable == null) {
                    view.setTag(2131558585, view.getBackground());
                }
                m7713a(new ColorDrawable(this.f6249h.getResources().getColor(2131361917)));
            } else if (drawable != null) {
                m7713a(drawable);
            }
        }
    }

    private void m7713a(Drawable drawable) {
        View view = (View) this.f6247f.get();
        if (view != null) {
            if (VERSION.SDK_INT < 16) {
                view.setBackgroundDrawable(drawable);
            } else {
                view.setBackground(drawable);
            }
        }
    }
}
