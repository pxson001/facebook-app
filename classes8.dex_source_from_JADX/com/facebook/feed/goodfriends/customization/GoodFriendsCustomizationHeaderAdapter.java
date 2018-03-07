package com.facebook.feed.goodfriends.customization;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.ContextUtils;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.goodfriends.data.FriendData;
import com.facebook.goodfriends.data.FriendStateFetcher;
import com.facebook.goodfriends.data.FriendStateFetcher.Callback;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.FbBaseAdapter;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: group_moderators */
public class GoodFriendsCustomizationHeaderAdapter extends FbBaseAdapter {
    public static final String f11905a = GoodFriendsCustomizationHeaderAdapter.class.getSimpleName();
    private final SecureContextHelper f11906b;
    private final Context f11907c;
    public final AbstractFbErrorReporter f11908d;
    private FriendStateFetcher f11909e;
    public GoodFriendsDataWrapper f11910f;
    private UriIntentMapper f11911g;
    private FbButton f11912h;
    private GoodFriendsHeaderAvatarsView f11913i;

    /* compiled from: group_moderators */
    public class C12781 implements Callback {
        final /* synthetic */ GoodFriendsCustomizationHeaderAdapter f11900a;

        public C12781(GoodFriendsCustomizationHeaderAdapter goodFriendsCustomizationHeaderAdapter) {
            this.f11900a = goodFriendsCustomizationHeaderAdapter;
        }

        public final void m13997a(ImmutableList<FriendData> immutableList, int i, ImmutableList<FriendData> immutableList2) {
            this.f11900a.f11910f = new GoodFriendsDataWrapper(immutableList, i);
            AdapterDetour.a(this.f11900a, -965347670);
        }

        public final void m13998a(Throwable th) {
            BLog.b(GoodFriendsCustomizationHeaderAdapter.f11905a, "Fail to retrieve good friends", th);
            this.f11900a.f11908d.a("FailToRetrieveGoodFriends", th.getMessage(), th);
        }
    }

    /* compiled from: group_moderators */
    class C12792 implements OnClickListener {
        final /* synthetic */ GoodFriendsCustomizationHeaderAdapter f11901a;

        C12792(GoodFriendsCustomizationHeaderAdapter goodFriendsCustomizationHeaderAdapter) {
            this.f11901a = goodFriendsCustomizationHeaderAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 821299712);
            GoodFriendsCustomizationHeaderAdapter.m13999c(this.f11901a);
            Logger.a(2, EntryType.UI_INPUT_END, 1591532699, a);
        }
    }

    /* compiled from: group_moderators */
    class C12803 implements OnClickListener {
        final /* synthetic */ GoodFriendsCustomizationHeaderAdapter f11902a;

        C12803(GoodFriendsCustomizationHeaderAdapter goodFriendsCustomizationHeaderAdapter) {
            this.f11902a = goodFriendsCustomizationHeaderAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1190226367);
            GoodFriendsCustomizationHeaderAdapter.m13999c(this.f11902a);
            Logger.a(2, EntryType.UI_INPUT_END, -344086431, a);
        }
    }

    /* compiled from: group_moderators */
    final class GoodFriendsDataWrapper {
        public final ImmutableList<FriendData> f11903a;
        public final int f11904b;

        public GoodFriendsDataWrapper(ImmutableList<FriendData> immutableList, int i) {
            this.f11903a = immutableList;
            this.f11904b = i;
        }
    }

    @Inject
    public GoodFriendsCustomizationHeaderAdapter(SecureContextHelper secureContextHelper, FriendStateFetcher friendStateFetcher, AbstractFbErrorReporter abstractFbErrorReporter, UriIntentMapper uriIntentMapper, @Assisted Context context) {
        this.f11906b = secureContextHelper;
        this.f11907c = context;
        this.f11909e = friendStateFetcher;
        this.f11908d = abstractFbErrorReporter;
        this.f11911g = uriIntentMapper;
    }

    public final View m14000a(int i, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        View inflate = LayoutInflater.from(context).inflate(2130904599, viewGroup, false);
        this.f11912h = (FbButton) inflate.findViewById(2131562558);
        Drawable drawable = context.getResources().getDrawable(2130838465);
        drawable.setColorFilter(context.getResources().getColor(2131361937), Mode.SRC_IN);
        this.f11912h.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
        this.f11912h.setOnClickListener(new C12792(this));
        this.f11913i = (GoodFriendsHeaderAvatarsView) inflate.findViewById(2131562555);
        this.f11913i.setOnClickListener(new C12803(this));
        m14001a();
        return inflate;
    }

    public static void m13999c(GoodFriendsCustomizationHeaderAdapter goodFriendsCustomizationHeaderAdapter) {
        Intent a = goodFriendsCustomizationHeaderAdapter.f11911g.a(goodFriendsCustomizationHeaderAdapter.f11907c, FBLinks.gh);
        a.putExtra("triggered_by_nux", false);
        goodFriendsCustomizationHeaderAdapter.f11906b.a(a, 101, (Activity) ContextUtils.a(goodFriendsCustomizationHeaderAdapter.f11907c, Activity.class));
    }

    public final void m14002a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        if (obj != null) {
            GoodFriendsDataWrapper goodFriendsDataWrapper = (GoodFriendsDataWrapper) obj;
            this.f11913i.m14005a(goodFriendsDataWrapper.f11903a, goodFriendsDataWrapper.f11904b);
        }
    }

    public Object getItem(int i) {
        return this.f11910f;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getCount() {
        return 1;
    }

    public final void m14001a() {
        this.f11909e.a(true, new C12781(this), 5);
    }
}
