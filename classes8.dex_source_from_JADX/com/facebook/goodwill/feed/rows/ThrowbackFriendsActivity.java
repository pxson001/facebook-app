package com.facebook.goodwill.feed.rows;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarUtil;

/* compiled from: feed_awesomizer_home_close */
public class ThrowbackFriendsActivity extends FbFragmentActivity {
    private ThrowbackFriendList f13581p;

    /* compiled from: feed_awesomizer_home_close */
    class C14411 implements OnClickListener {
        final /* synthetic */ ThrowbackFriendsActivity f13580a;

        C14411(ThrowbackFriendsActivity throwbackFriendsActivity) {
            this.f13580a = throwbackFriendsActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 492213584);
            this.f13580a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, 442367088, a);
        }
    }

    public static Intent m15332a(Context context, ThrowbackFriendList throwbackFriendList) {
        Intent intent = new Intent(context, ThrowbackFriendsActivity.class);
        intent.putExtra("friend_list", throwbackFriendList);
        return intent;
    }

    public final void m15334b(Bundle bundle) {
        super.b(bundle);
        this.f13581p = (ThrowbackFriendList) getIntent().getParcelableExtra("friend_list");
        setContentView(2130907406);
        ThrowbackFriendsFragment throwbackFriendsFragment = new ThrowbackFriendsFragment();
        throwbackFriendsFragment.f13591c = this.f13581p;
        kO_().a().b(2131558429, throwbackFriendsFragment).b();
        m15333i();
    }

    private void m15333i() {
        FbTitleBarUtil.b(this);
        FbTitleBar fbTitleBar = (FbTitleBar) findViewById(2131558563);
        int size = this.f13581p.f13579a.size();
        if (size >= 50) {
            fbTitleBar.setTitle(2131239657);
        } else {
            fbTitleBar.setTitle(getResources().getQuantityString(2131689745, size, new Object[]{Integer.valueOf(size)}));
        }
        fbTitleBar.a(new C14411(this));
    }
}
