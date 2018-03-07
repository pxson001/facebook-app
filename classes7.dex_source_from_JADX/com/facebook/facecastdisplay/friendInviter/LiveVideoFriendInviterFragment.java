package com.facebook.facecastdisplay.friendInviter;

import android.content.Context;
import android.os.Bundle;
import com.facebook.contacts.iterator.ContactCursorsQuery.SortKey;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.user.model.User;
import com.facebook.widget.friendselector.CaspianTypeaheadAdapterWithStickyHeader;
import com.facebook.widget.friendselector.GenericFriendsSelectorFragment;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: attachmentProps */
public class LiveVideoFriendInviterFragment extends GenericFriendsSelectorFragment {
    public static String au = "recent_invitee_section";
    public static String av = "suggested_section";
    @Inject
    public LiveVideoInviteHelper aw;
    @Inject
    public LiveVideoInviteFriendCache ax;
    @Nullable
    public LiveVideoFriendInviterDialog ay;
    @Nullable
    public String az;

    /* compiled from: attachmentProps */
    class C16571 implements Callable<ImmutableMap<String, ImmutableList<User>>> {
        final /* synthetic */ LiveVideoFriendInviterFragment f19044a;

        C16571(LiveVideoFriendInviterFragment liveVideoFriendInviterFragment) {
            this.f19044a = liveVideoFriendInviterFragment;
        }

        public Object call() {
            Builder builder = ImmutableMap.builder();
            ImmutableList az = this.f19044a.az();
            ImmutableList immutableList = this.f19044a.ax.f19057j;
            if (immutableList.isEmpty()) {
                builder.b(LiveVideoFriendInviterFragment.av, az);
                return builder.b();
            }
            ImmutableList.Builder builder2 = new ImmutableList.Builder();
            ImmutableList.Builder builder3 = new ImmutableList.Builder();
            int size = az.size();
            for (int i = 0; i < size; i++) {
                User user = (User) az.get(i);
                if (immutableList.contains(user.a)) {
                    builder2.c(user);
                } else {
                    builder3.c(user);
                }
            }
            builder.b(LiveVideoFriendInviterFragment.au, builder2.b());
            builder.b(LiveVideoFriendInviterFragment.av, builder3.b());
            return builder.b();
        }
    }

    public static void m22617a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        LiveVideoFriendInviterFragment liveVideoFriendInviterFragment = (LiveVideoFriendInviterFragment) obj;
        LiveVideoInviteHelper b = LiveVideoInviteHelper.m22630b(injectorLike);
        LiveVideoInviteFriendCache a = LiveVideoInviteFriendCache.m22625a(injectorLike);
        liveVideoFriendInviterFragment.aw = b;
        liveVideoFriendInviterFragment.ax = a;
    }

    public final void mo321c(Bundle bundle) {
        super.mo321c(bundle);
        Class cls = LiveVideoFriendInviterFragment.class;
        m22617a(this, getContext());
        this.ax.m22627a(this.az);
        if (this.al instanceof CaspianTypeaheadAdapterWithStickyHeader) {
            ((CaspianTypeaheadAdapterWithStickyHeader) this.al).f16039i = true;
        }
    }

    protected final SortKey aA() {
        return SortKey.COMMUNICATION_RANK;
    }

    protected final boolean aB() {
        return true;
    }

    protected final void aH() {
        ImmutableList ax = ax();
        this.aw.m22631a(this.az, ax);
        LiveVideoInviteFriendCache liveVideoInviteFriendCache = this.ax;
        if (liveVideoInviteFriendCache.f19054g != null) {
            liveVideoInviteFriendCache.f19049b.addAll(ax);
        }
        if (this.ay != null) {
            this.ay.a();
        }
    }

    protected final boolean mo1446a(String str) {
        return !this.ax.f19049b.contains(str);
    }

    protected final ImmutableList<String> aD() {
        return ImmutableList.of(au, av);
    }

    protected final ListenableFuture<ImmutableMap<String, ImmutableList<User>>> ay() {
        return this.f5790c.a(new C16571(this));
    }

    protected final int mo320b(String str) {
        if (au.equals(str)) {
            return 2131232725;
        }
        if (av.equals(str)) {
            return 2131232726;
        }
        return 0;
    }
}
