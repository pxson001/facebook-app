package com.facebook.growth.friendfinder;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.ipc.katana.findfriends.CIFlow;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import java.util.Arrays;

/* compiled from: paths */
public class FriendFinderHostingActivity extends FbFragmentActivity implements HasTitleBar {
    private FbTitleBar f7224p;

    /* compiled from: paths */
    class C07791 implements OnClickListener {
        final /* synthetic */ FriendFinderHostingActivity f7223a;

        C07791(FriendFinderHostingActivity friendFinderHostingActivity) {
            this.f7223a = friendFinderHostingActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -91713342);
            this.f7223a.finish();
            Logger.a(2, EntryType.UI_INPUT_END, 1305667472, a);
        }
    }

    protected final void m7499b(Bundle bundle) {
        super.b(bundle);
        overridePendingTransition(2130968649, 2130968714);
        setContentView(2130904469);
        FbTitleBarUtil.b(this);
        this.f7224p = (FbTitleBar) findViewById(2131558563);
        this.f7224p.a(new C07791(this));
        CIFlow cIFlow = (CIFlow) getIntent().getSerializableExtra("ci_flow");
        FragmentManager kO_ = kO_();
        if (kO_.a(2131562241) == null) {
            kO_.a().a(2131562241, FriendFinderAddFriendsFragment.m7447a(cIFlow)).b();
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(2130968711, 2130968695);
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(2130968711, 2130968695);
    }

    public final void m7498b(int i) {
        setResult(i);
        finish();
    }

    public final void a_(String str) {
        this.f7224p.setTitle(str);
    }

    public final void y_(int i) {
        this.f7224p.setTitle(i);
    }

    public void setCustomTitle(View view) {
    }

    public final View lh_() {
        return null;
    }

    public final void m7497a(TitleBarButtonSpec titleBarButtonSpec) {
        this.f7224p.setButtonSpecs(Arrays.asList(new TitleBarButtonSpec[]{titleBarButtonSpec}));
    }

    public final void m7500b(TitleBarButtonSpec titleBarButtonSpec) {
    }

    public final void m7496a(OnToolbarButtonListener onToolbarButtonListener) {
        this.f7224p.setOnToolbarButtonListener(onToolbarButtonListener);
    }

    public final void kg_() {
    }

    public final void m7501c(boolean z) {
    }
}
