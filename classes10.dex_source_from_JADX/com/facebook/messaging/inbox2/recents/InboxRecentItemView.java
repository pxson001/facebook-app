package com.facebook.messaging.inbox2.recents;

import android.content.Context;
import android.net.Uri;
import android.support.v7.internal.widget.ViewStubCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.FrameLayout;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.applinks.ApplinkHelper;
import com.facebook.messaging.linkhandling.LinkHandlingHelper;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.RoundedCornerOverlayDrawable;
import com.facebook.widget.ViewStubHolder;
import com.facebook.widget.ViewStubHolder.OnInflateListener;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: selfupdate_skip_showing_activity */
public class InboxRecentItemView extends CustomLinearLayout {
    @Inject
    ApplinkHelper f2898a;
    @Inject
    LinkHandlingHelper f2899b;
    private FrameLayout f2900c;
    private ViewStubHolder<InboxRecentItemMainImageView> f2901d;
    private ViewStubHolder<InboxRecentItemVideoView> f2902e;
    private InboxRecentItemFooter f2903f;
    @Nullable
    public InboxRecentItem f2904g;
    @Nullable
    public InboxRecentItemsListener f2905h;
    public final OnLongClickListener f2906i = new C04761(this);

    /* compiled from: selfupdate_skip_showing_activity */
    class C04761 implements OnLongClickListener {
        final /* synthetic */ InboxRecentItemView f2894a;

        C04761(InboxRecentItemView inboxRecentItemView) {
            this.f2894a = inboxRecentItemView;
        }

        public boolean onLongClick(View view) {
            if (this.f2894a.f2905h != null) {
                return this.f2894a.f2905h.mo92b(this.f2894a.f2904g);
            }
            return false;
        }
    }

    /* compiled from: selfupdate_skip_showing_activity */
    class C04782 implements OnInflateListener<InboxRecentItemMainImageView> {
        final /* synthetic */ InboxRecentItemView f2896a;

        /* compiled from: selfupdate_skip_showing_activity */
        class C04771 implements OnClickListener {
            final /* synthetic */ C04782 f2895a;

            C04771(C04782 c04782) {
                this.f2895a = c04782;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1774813584);
                this.f2895a.f2896a.f2904g;
                Logger.a(2, EntryType.UI_INPUT_END, 175400885, a);
            }
        }

        C04782(InboxRecentItemView inboxRecentItemView) {
            this.f2896a = inboxRecentItemView;
        }

        public final void m2859a(View view) {
            InboxRecentItemMainImageView inboxRecentItemMainImageView = (InboxRecentItemMainImageView) view;
            inboxRecentItemMainImageView.setOnClickListener(new C04771(this));
            inboxRecentItemMainImageView.setOnLongClickListener(this.f2896a.f2906i);
        }
    }

    /* compiled from: selfupdate_skip_showing_activity */
    class C04793 implements OnInflateListener<InboxRecentItemVideoView> {
        final /* synthetic */ InboxRecentItemView f2897a;

        C04793(InboxRecentItemView inboxRecentItemView) {
            this.f2897a = inboxRecentItemView;
        }

        public final void m2860a(View view) {
            ((InboxRecentItemVideoView) view).setOnLongClickListener(this.f2897a.f2906i);
        }
    }

    private static <T extends View> void m2864a(Class<T> cls, T t) {
        m2865a((Object) t, t.getContext());
    }

    private static void m2865a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((InboxRecentItemView) obj).m2863a(ApplinkHelper.b(fbInjector), LinkHandlingHelper.a(fbInjector));
    }

    public InboxRecentItemView(Context context) {
        super(context);
        m2862a();
    }

    public InboxRecentItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m2862a();
    }

    public InboxRecentItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2862a();
    }

    private void m2862a() {
        m2864a(InboxRecentItemView.class, (View) this);
        setContentView(2130904876);
        this.f2900c = (FrameLayout) a(2131563100);
        this.f2901d = ViewStubHolder.a((ViewStubCompat) a(2131563101));
        this.f2902e = ViewStubHolder.a((ViewStubCompat) a(2131563103));
        this.f2903f = (InboxRecentItemFooter) a(2131563105);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131433629);
        RoundedCornerOverlayDrawable roundedCornerOverlayDrawable = new RoundedCornerOverlayDrawable();
        roundedCornerOverlayDrawable.mutate();
        float f = (float) dimensionPixelSize;
        roundedCornerOverlayDrawable.a(f, f, f, f);
        roundedCornerOverlayDrawable.a(-1);
        this.f2900c.setForeground(roundedCornerOverlayDrawable);
        this.f2901d.c = new C04782(this);
        this.f2902e.c = new C04793(this);
    }

    public void setItem(@Nullable InboxRecentItem inboxRecentItem) {
        if (this.f2904g != inboxRecentItem) {
            this.f2904g = inboxRecentItem;
            this.f2903f.setItem(this.f2904g);
            if (inboxRecentItem instanceof RecentVideoInboxItem) {
                this.f2901d.a(false);
                this.f2902e.a(true);
                ((InboxRecentItemVideoView) this.f2902e.a()).setRecentVideoInboxItem((RecentVideoInboxItem) inboxRecentItem);
                return;
            }
            this.f2901d.a(true);
            this.f2902e.a(false);
            ((InboxRecentItemMainImageView) this.f2901d.a()).setInboxItem(this.f2904g);
        }
    }

    public void setListener(@Nullable InboxRecentItemsListener inboxRecentItemsListener) {
        this.f2905h = inboxRecentItemsListener;
    }

    public static void m2867b(InboxRecentItemView inboxRecentItemView) {
        if (inboxRecentItemView.f2904g != null) {
            if (inboxRecentItemView.f2905h != null) {
                inboxRecentItemView.f2905h.mo91a(inboxRecentItemView.f2904g, "view_link", null);
            }
            Uri mb_ = inboxRecentItemView.f2904g.mb_();
            if (!inboxRecentItemView.f2898a.a(mb_, inboxRecentItemView.getContext())) {
                inboxRecentItemView.f2899b.a(inboxRecentItemView.getContext(), mb_);
            }
        }
    }

    private void m2863a(ApplinkHelper applinkHelper, LinkHandlingHelper linkHandlingHelper) {
        this.f2898a = applinkHelper;
        this.f2899b = linkHandlingHelper;
    }
}
