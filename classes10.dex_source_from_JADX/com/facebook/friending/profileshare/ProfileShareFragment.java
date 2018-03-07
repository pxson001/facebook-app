package com.facebook.friending.profileshare;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.device.ScreenUtil;
import com.facebook.fbui.draggable.Direction;
import com.facebook.fbui.draggable.widget.DismissibleFrameLayout;
import com.facebook.friending.profileshare.logging.ProfileShareAnalyticsLogger;
import com.facebook.friending.profileshare.logging.ProfileShareAnalyticsLogger.Source;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: adapter */
public class ProfileShareFragment extends FbFragment implements CanHandleBackPressed {
    @Inject
    Clock f20258a;
    private BetterLinearLayoutManager al;
    public AnimationState am = AnimationState.UNINITIALIZED;
    public boolean an;
    @Inject
    ProfileShareAdapterProvider f20259b;
    @Inject
    ProfileShareAnalyticsLogger f20260c;
    @Inject
    ProfileShareController f20261d;
    @Inject
    public ScreenUtil f20262e;
    @Inject
    SecureContextHelper f20263f;
    private ProfileShareAdapter f20264g;
    public DismissibleFrameLayout f20265h;
    public BetterRecyclerView f20266i;

    /* compiled from: adapter */
    class C28882 implements OnItemTouchListener {
        final /* synthetic */ ProfileShareFragment f20256a;

        C28882(ProfileShareFragment profileShareFragment) {
            this.f20256a = profileShareFragment;
        }

        public final boolean m20545a(MotionEvent motionEvent) {
            boolean z = true;
            if (this.f20256a.an) {
                if (motionEvent.getAction() == 1) {
                    z = false;
                }
                this.f20256a.f20265h.requestDisallowInterceptTouchEvent(z);
            }
            return false;
        }

        public final void m20546b(MotionEvent motionEvent) {
        }

        public final void m20544a(boolean z) {
        }
    }

    /* compiled from: adapter */
    class C28893 implements OnClickListener {
        final /* synthetic */ ProfileShareFragment f20257a;

        C28893(ProfileShareFragment profileShareFragment) {
            this.f20257a = profileShareFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 953251933);
            ProfileShareItem profileShareItem = (ProfileShareItem) view.getTag(2131558805);
            long a2 = this.f20257a.f20258a.a() / 1000;
            this.f20257a.f20260c.m20565a(profileShareItem.f20277a, a2);
            Intent intent = profileShareItem.f20279c;
            intent.putExtra("android.intent.extra.TEXT", this.f20257a.f20261d.m20542a(a2));
            this.f20257a.f20263f.b(intent, this.f20257a.getContext());
            Logger.a(2, EntryType.UI_INPUT_END, -303103094, a);
        }
    }

    /* compiled from: adapter */
    public enum AnimationState {
        UNINITIALIZED,
        OPENING,
        CLOSING
    }

    public static void m20548a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ProfileShareFragment) obj).m20547a((Clock) SystemClockMethodAutoProvider.a(injectorLike), (ProfileShareAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ProfileShareAdapterProvider.class), ProfileShareAnalyticsLogger.m20561a(injectorLike), ProfileShareController.m20540b(injectorLike), ScreenUtil.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    private void m20547a(Clock clock, ProfileShareAdapterProvider profileShareAdapterProvider, ProfileShareAnalyticsLogger profileShareAnalyticsLogger, ProfileShareController profileShareController, ScreenUtil screenUtil, SecureContextHelper secureContextHelper) {
        this.f20258a = clock;
        this.f20259b = profileShareAdapterProvider;
        this.f20260c = profileShareAnalyticsLogger;
        this.f20261d = profileShareController;
        this.f20262e = screenUtil;
        this.f20263f = secureContextHelper;
    }

    public final void m20551c(@Nullable Bundle bundle) {
        Class cls = ProfileShareFragment.class;
        m20548a((Object) this, getContext());
        this.f20264g = this.f20259b.m20538a(false);
    }

    public final View m20549a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1714313978);
        View inflate = layoutInflater.inflate(2130906476, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1940688549, a);
        return inflate;
    }

    public final void m20550a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.f20265h = (DismissibleFrameLayout) view;
        this.f20266i = (BetterRecyclerView) e(2131566406);
        final boolean z = bundle != null;
        this.f20265h.post(new Runnable(this) {
            final /* synthetic */ ProfileShareFragment f20255b;

            public void run() {
                ProfileShareFragment profileShareFragment = this.f20255b;
                boolean z = z;
                if (profileShareFragment.am != AnimationState.OPENING) {
                    profileShareFragment.am = AnimationState.OPENING;
                    if (!z) {
                        profileShareFragment.f20265h.scrollTo(0, (-profileShareFragment.f20265h.getHeight()) + 1);
                        profileShareFragment.f20265h.a(true);
                    }
                }
            }
        });
        this.al = new BetterLinearLayoutManager(getContext());
        this.f20266i.setLayoutManager(this.al);
        this.f20266i.setAdapter(this.f20264g);
        this.f20266i.a(new C28882(this));
        this.f20264g.f20247b = new C28893(this);
        List<ProfileShareItem> a = this.f20261d.m20543a();
        List arrayList = new ArrayList(a.size());
        for (ProfileShareItem profileShareItem : a) {
            arrayList.add(profileShareItem.f20277a);
        }
        this.f20260c.m20564a(Source.NEWS_FEED_QP, arrayList);
        this.f20264g.m20537a(a);
        int dimensionPixelSize = (jW_().getDimensionPixelSize(2131433907) * 2) + jW_().getDimensionPixelSize(2131433909);
        int d = (int) (0.6f * ((float) this.f20262e.d()));
        int aZ_ = dimensionPixelSize * this.f20264g.aZ_();
        if (aZ_ > d) {
            aZ_ = (int) ((((float) (d / dimensionPixelSize)) - 0.5f) * ((float) dimensionPixelSize));
            this.an = true;
        }
        this.f20266i.getLayoutParams().height = aZ_;
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1375685822);
        this.f20265h = null;
        this.f20266i = null;
        this.al = null;
        this.f20260c.m20563a();
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 946751216, a);
    }

    public final boolean O_() {
        if (this.am != AnimationState.CLOSING) {
            this.am = AnimationState.CLOSING;
            this.f20265h.a(Direction.DOWN, true);
        }
        return true;
    }
}
