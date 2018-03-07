package com.facebook.goodwill.feed.rows;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.timeline.intent.ModelBundle;
import com.facebook.widget.listview.BetterListView;

/* compiled from: feed_awesomizer */
public class ThrowbackFriendsFragment extends FbFragment {
    public ThrowbackFriendsAdapter f13589a;
    private BetterListView f13590b;
    public ThrowbackFriendList f13591c;
    public FbUriIntentHandler f13592d;
    public GlyphColorizer f13593e;

    /* compiled from: feed_awesomizer */
    class C14431 implements OnItemClickListener {
        final /* synthetic */ ThrowbackFriendsFragment f13588a;

        C14431(ThrowbackFriendsFragment throwbackFriendsFragment) {
            this.f13588a = throwbackFriendsFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ThrowbackFriendsFragment throwbackFriendsFragment = this.f13588a;
            ThrowbackFriend throwbackFriend = (ThrowbackFriend) throwbackFriendsFragment.f13591c.f13579a.get(i);
            String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.aX, throwbackFriend.f13575a);
            Bundle bundle = new Bundle();
            ModelBundle.a(bundle, String.valueOf(throwbackFriend.f13575a), throwbackFriend.f13576b, throwbackFriend.f13577c, null, null);
            throwbackFriendsFragment.f13592d.a(throwbackFriendsFragment.getContext(), formatStrLocaleSafe, bundle);
        }
    }

    public static void m15335a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ThrowbackFriendsFragment throwbackFriendsFragment = (ThrowbackFriendsFragment) obj;
        FbUriIntentHandler a = FbUriIntentHandler.a(fbInjector);
        GlyphColorizer a2 = GlyphColorizer.a(fbInjector);
        throwbackFriendsFragment.f13592d = a;
        throwbackFriendsFragment.f13593e = a2;
    }

    public final void m15338c(Bundle bundle) {
        Class cls = ThrowbackFriendsFragment.class;
        m15335a((Object) this, getContext());
        super.c(bundle);
    }

    public final View m15336a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1866814302);
        View inflate = layoutInflater.inflate(2130907407, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1561722256, a);
        return inflate;
    }

    public final void m15339e(Bundle bundle) {
        super.e(bundle);
        bundle.putParcelable("friend_list", this.f13591c);
    }

    public final void m15337a(View view, Bundle bundle) {
        super.a(view, bundle);
        if (bundle != null && bundle.containsKey("friend_list")) {
            this.f13591c = (ThrowbackFriendList) bundle.getParcelable("friend_list");
        }
        this.f13590b = (BetterListView) e(2131567873);
        this.f13590b.setOnItemClickListener(new C14431(this));
        BetterListView betterListView = this.f13590b;
        if (this.f13589a == null) {
            this.f13589a = new ThrowbackFriendsAdapter(this.f13591c, this.f13592d, this.f13593e);
        }
        betterListView.setAdapter(this.f13589a);
    }
}
