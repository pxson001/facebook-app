package com.facebook.adinterfaces.ui.selector;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.composer.ui.titlebar.ComposerBaseTitleBar;
import com.facebook.composer.ui.titlebar.ComposerTitleBar;
import com.facebook.composer.ui.titlebar.ComposerTitleBar.StateBuilder;
import com.facebook.composer.ui.titlebar.HarrisonPlusIconType;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.widget.titlebar.FbTitleBar.OnBackPressedListener;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;

/* compiled from: Unknown host  */
public class TargetingSelectorActivity extends FbFragmentActivity {
    private BaseTargetingSelectorFragment<?> f23234p;

    /* compiled from: Unknown host  */
    class C27461 implements OnBackPressedListener {
        final /* synthetic */ TargetingSelectorActivity f23231a;

        C27461(TargetingSelectorActivity targetingSelectorActivity) {
            this.f23231a = targetingSelectorActivity;
        }

        public final void m25218a() {
            this.f23231a.onBackPressed();
        }
    }

    /* compiled from: Unknown host  */
    class C27472 extends OnToolbarButtonListener {
        final /* synthetic */ TargetingSelectorActivity f23232a;

        C27472(TargetingSelectorActivity targetingSelectorActivity) {
            this.f23232a = targetingSelectorActivity;
        }

        public final void m25219a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            TargetingSelectorActivity.m25221i(this.f23232a);
        }
    }

    public final void m25222b(Bundle bundle) {
        super.b(bundle);
        TargetingSelectorArgument targetingSelectorArgument = (TargetingSelectorArgument) getIntent().getParcelableExtra("selectorArgument");
        setContentView(2130905135);
        ComposerBaseTitleBar composerBaseTitleBar = (ComposerBaseTitleBar) a(2131560528);
        composerBaseTitleBar.setOnBackPressedListener(new C27461(this));
        Builder a = TitleBarButtonSpec.a();
        a.g = getString(2131234002);
        a = a;
        a.h = -2;
        TitleBarButtonSpec a2 = a.a();
        StateBuilder stateBuilder = new StateBuilder();
        stateBuilder.b = a2;
        StateBuilder stateBuilder2 = stateBuilder;
        stateBuilder2.a = getString(targetingSelectorArgument.f23236b);
        stateBuilder2 = stateBuilder2;
        stateBuilder2.c = new C27472(this);
        stateBuilder2 = stateBuilder2;
        stateBuilder2.d = HarrisonPlusIconType.c();
        ComposerTitleBar composerTitleBar = new ComposerTitleBar(composerBaseTitleBar, stateBuilder2.a());
        switch (targetingSelectorArgument.f23235a) {
            case INTEREST:
                this.f23234p = (InterestTargetingSelectorFragment) kO_().a(2131563619);
                break;
            default:
                this.f23234p = (LocationTargetingFragment) kO_().a(2131563619);
                break;
        }
        if (this.f23234p == null) {
            this.f23234p = TargetingSelectorFragmentFactory.m25225a(targetingSelectorArgument.f23235a);
            this.f23234p.g(getIntent().getExtras());
            kO_().a().b(2131563619, this.f23234p).b();
        }
    }

    public void onBackPressed() {
        if (this.f23234p != null) {
            BaseTargetingSelectorFragment.ax(this.f23234p);
        }
        super.onBackPressed();
    }

    public static void m25221i(TargetingSelectorActivity targetingSelectorActivity) {
        if (targetingSelectorActivity.f23234p != null) {
            BaseTargetingSelectorFragment baseTargetingSelectorFragment = targetingSelectorActivity.f23234p;
            Intent intent = new Intent();
            FlatBufferModelHelper.a(intent, "selectedTokens", baseTargetingSelectorFragment.as());
            baseTargetingSelectorFragment.ao().setResult(-1, intent);
            baseTargetingSelectorFragment.ao().finish();
            BaseTargetingSelectorFragment.ax(baseTargetingSelectorFragment);
        }
        super.onBackPressed();
    }
}
