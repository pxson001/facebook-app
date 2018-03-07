package com.facebook.widget.friendselector;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.apptab.ui.chrome.FinishHandler;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.build.IsWorkBuild;
import com.facebook.common.fragmentfactory.FragmentFactoryMap;
import com.facebook.common.fragmentfactory.FragmentFactoryMapImpl;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: default_feedback_scroll_perf */
public class CaspianFriendSelectorActivity extends FbFragmentActivity implements FinishHandler {
    @Inject
    FragmentFactoryMap f16019p;
    @Inject
    @IsWorkBuild
    Boolean f16020q;
    private FragmentManager f16021r;
    public GenericFriendsSelectorFragment f16022s;
    private Boolean f16023t = Boolean.valueOf(false);

    /* compiled from: default_feedback_scroll_perf */
    class C12431 implements OnClickListener {
        final /* synthetic */ CaspianFriendSelectorActivity f16018a;

        C12431(CaspianFriendSelectorActivity caspianFriendSelectorActivity) {
            this.f16018a = caspianFriendSelectorActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1760253493);
            this.f16018a.f16022s.aJ();
            Logger.a(2, EntryType.UI_INPUT_END, 1205674559, a);
        }
    }

    private static <T extends Context> void m19996a(Class<T> cls, T t) {
        m19997a((Object) t, (Context) t);
    }

    public static void m19997a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((CaspianFriendSelectorActivity) obj).m19995a((FragmentFactoryMap) FragmentFactoryMapImpl.a(fbInjector), Boolean_IsWorkBuildMethodAutoProvider.a(fbInjector));
    }

    private void m19995a(FragmentFactoryMap fragmentFactoryMap, Boolean bool) {
        this.f16019p = fragmentFactoryMap;
        this.f16020q = bool;
    }

    protected final void m20002b(@Nullable Bundle bundle) {
        super.b(bundle);
        Class cls = CaspianFriendSelectorActivity.class;
        m19997a((Object) this, (Context) this);
        this.f16021r = kO_();
        overridePendingTransition(2130968739, 2130968614);
        setContentView(2130904492);
        m19999j();
        m19998i();
    }

    private void m19998i() {
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("target_fragment", -1);
        if (intExtra != -1) {
            this.f16023t = Boolean.valueOf(intent.getBooleanExtra("non_modal_display", false));
            if (this.f16023t.booleanValue()) {
                overridePendingTransition(2130968750, 2130968614);
                m20000k();
            }
            Fragment a = this.f16019p.a(intExtra).a(intent);
            if (a == null || !(a instanceof GenericFriendsSelectorFragment)) {
                finish();
                return;
            }
            this.f16022s = (GenericFriendsSelectorFragment) a;
            Bundle bundle = this.f16022s.s;
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("is_show_caspian_style", true);
            a.g(bundle);
            this.f16021r.a().b(2131558429, a).b();
            this.f16021r.b();
        }
    }

    private void m19999j() {
        TextView textView = (TextView) a(2131558927);
        int intExtra = getIntent().getIntExtra("title", 0);
        if (intExtra == 0) {
            intExtra = this.f16020q.booleanValue() ? 2131232659 : 2131232657;
        }
        textView.setText(getResources().getString(intExtra));
        a(2131560414).setOnClickListener(new C12431(this));
    }

    private void m20000k() {
        ((GlyphView) a(2131560414)).setImageResource(2130838002);
    }

    public void onBackPressed() {
        this.f16022s.aJ();
    }

    public final void m20001b() {
        finish();
    }

    public void finish() {
        super.finish();
        if (this.f16023t.booleanValue()) {
            overridePendingTransition(2130968725, 2130968766);
        } else {
            overridePendingTransition(2130968724, 2130968740);
        }
    }

    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(2130968750, 2130968614);
    }
}
