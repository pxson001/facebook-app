package com.facebook.feed.goodfriends.nux;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.ContextUtils;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.goodfriends.analytics.GoodFriendsAnalyticsLogger;
import com.facebook.goodfriends.data.FriendData;
import com.facebook.goodfriends.data.FriendStateFetcher;
import com.facebook.goodfriends.data.FriendStateFetcher.Callback;
import com.facebook.inject.FbInjector;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: TX */
public class NoFriendPlaceholderFragment extends FbFragment {
    public static final String f24492e = NoFriendPlaceholderFragment.class.getSimpleName();
    @Inject
    public FriendStateFetcher f24493a;
    @Inject
    public SecureContextHelper f24494b;
    @Inject
    public UriIntentMapper f24495c;
    @Inject
    public GoodFriendsAnalyticsLogger f24496d;
    private FbButton f24497f;
    public GoodFriendsAvatarsView f24498g;
    private FbTextView f24499h;
    public ImmutableList<FriendData> f24500i = RegularImmutableList.a;

    /* compiled from: TX */
    class C29381 implements OnClickListener {
        final /* synthetic */ NoFriendPlaceholderFragment f24489a;

        C29381(NoFriendPlaceholderFragment noFriendPlaceholderFragment) {
            this.f24489a = noFriendPlaceholderFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -32314934);
            Intent a2 = this.f24489a.f24495c.a(this.f24489a.getContext(), FBLinks.gh);
            a2.putExtra("triggered_by_nux", true);
            this.f24489a.f24494b.a(a2, 101, (Activity) ContextUtils.a(this.f24489a.getContext(), Activity.class));
            Logger.a(2, EntryType.UI_INPUT_END, 724980823, a);
        }
    }

    /* compiled from: TX */
    class C29392 implements OnClickListener {
        final /* synthetic */ NoFriendPlaceholderFragment f24490a;

        C29392(NoFriendPlaceholderFragment noFriendPlaceholderFragment) {
            this.f24490a = noFriendPlaceholderFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -283069245);
            NoFriendPlaceholderFragment noFriendPlaceholderFragment = this.f24490a;
            noFriendPlaceholderFragment.f24494b.a(noFriendPlaceholderFragment.f24495c.a(this.f24490a.getContext(), FBLinks.cr.concat("/help/526170970918554/")), noFriendPlaceholderFragment.getContext());
            Logger.a(2, EntryType.UI_INPUT_END, -1498598558, a);
        }
    }

    /* compiled from: TX */
    public class C29403 implements Callback {
        final /* synthetic */ NoFriendPlaceholderFragment f24491a;

        public C29403(NoFriendPlaceholderFragment noFriendPlaceholderFragment) {
            this.f24491a = noFriendPlaceholderFragment;
        }

        public final void m26387a(ImmutableList<FriendData> immutableList, int i, ImmutableList<FriendData> immutableList2) {
            this.f24491a.f24500i = immutableList;
            this.f24491a.f24498g.setFriendsData(immutableList);
        }

        public final void m26388a(Throwable th) {
            BLog.b(NoFriendPlaceholderFragment.f24492e, "Fail to retrieve friends list", th);
        }
    }

    public static void m26390a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        NoFriendPlaceholderFragment noFriendPlaceholderFragment = (NoFriendPlaceholderFragment) obj;
        FriendStateFetcher b = FriendStateFetcher.b(fbInjector);
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector);
        UriIntentMapper uriIntentMapper = (UriIntentMapper) Fb4aUriIntentMapper.a(fbInjector);
        GoodFriendsAnalyticsLogger a = GoodFriendsAnalyticsLogger.a(fbInjector);
        noFriendPlaceholderFragment.f24493a = b;
        noFriendPlaceholderFragment.f24494b = secureContextHelper;
        noFriendPlaceholderFragment.f24495c = uriIntentMapper;
        noFriendPlaceholderFragment.f24496d = a;
    }

    public final void m26393c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = NoFriendPlaceholderFragment.class;
        m26390a(this, getContext());
        if (bundle != null && bundle.containsKey("friends")) {
            Collection parcelableArrayList = bundle.getParcelableArrayList("friends");
            if (parcelableArrayList != null) {
                this.f24500i = ImmutableList.copyOf(parcelableArrayList);
            }
        }
    }

    public final View m26392a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -829491785);
        View a2 = m26389a(layoutInflater, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 956659028, a);
        return a2;
    }

    private View m26389a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(2130904603, viewGroup, z);
        this.f24497f = (FbButton) inflate.findViewById(2131562568);
        this.f24497f.setOnClickListener(new C29381(this));
        this.f24498g = (GoodFriendsAvatarsView) inflate.findViewById(2131562567);
        if (!this.f24500i.isEmpty()) {
            this.f24498g.setFriendsData(this.f24500i);
        }
        this.f24499h = (FbTextView) inflate.findViewById(2131562569);
        this.f24499h.setOnClickListener(new C29392(this));
        this.f24496d.a("placeholder_no_friends");
        return inflate;
    }

    public final void m26391G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 153111347);
        super.G();
        this.f24493a.a(true, new C29403(this));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1645176429, a);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ViewGroup viewGroup = (ViewGroup) this.T;
        viewGroup.removeAllViewsInLayout();
        m26389a(LayoutInflater.from(getContext()), viewGroup, true);
    }

    public final void m26394e(Bundle bundle) {
        if (!this.f24500i.isEmpty()) {
            bundle.putParcelableArrayList("friends", new ArrayList(this.f24500i));
        }
        super.e(bundle);
    }
}
