package com.facebook.video.followvideos;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.graphql.calls.VideoChannelFollowInputData.Surface;
import com.facebook.graphql.calls.VideoChannelSubscribeInputData;
import com.facebook.graphql.calls.VideoChannelUnfollowInputData;
import com.facebook.graphql.calls.VideoChannelUnsubscribeInputData;
import com.facebook.inject.FbInjector;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.video.channelfeed.protocol.VideoChannelMutationsHelper;
import com.facebook.video.followvideos.FollowVideosNotificationUpsellDialogBuilder.NotificationDialog;
import com.facebook.video.followvideos.qe.ExperimentsForFollowVideosQeModule;
import com.facebook.video.followvideos.qe.FollowVideosButtonTextHelper;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: dlxu */
public class VideoHomeFollowVideosButton extends CustomLinearLayout {
    @Inject
    QeAccessor f15682a;
    @Inject
    VideoChannelMutationsHelper f15683b;
    private boolean f15684c;
    private boolean f15685d;
    private String f15686e;
    private String f15687f;
    public SubscribeStateChangedListener f15688g;
    private C12034 f15689h;
    @Nullable
    private VideoHomeToggleButton f15690i;
    private final Context f15691j;
    private final VideoHomeToggleButton f15692k;
    private long f15693l;

    /* compiled from: dlxu */
    class C12012 implements com.facebook.video.followvideos.VideoHomeToggleButton.SubscribeStateChangedListener {
        final /* synthetic */ VideoHomeFollowVideosButton f15675a;

        C12012(VideoHomeFollowVideosButton videoHomeFollowVideosButton) {
            this.f15675a = videoHomeFollowVideosButton;
        }

        public final void mo1205a(boolean z) {
            this.f15675a.m19628a(z);
        }
    }

    /* compiled from: dlxu */
    public interface SubscribeStateChangedListener {
        void m19622a(boolean z);
    }

    private static <T extends View> void m19626a(Class<T> cls, T t) {
        m19627a((Object) t, t.getContext());
    }

    private static void m19627a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((VideoHomeFollowVideosButton) obj).m19623a((QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), VideoChannelMutationsHelper.a(fbInjector));
    }

    private void m19623a(QeAccessor qeAccessor, VideoChannelMutationsHelper videoChannelMutationsHelper) {
        this.f15682a = qeAccessor;
        this.f15683b = videoChannelMutationsHelper;
    }

    public VideoHomeFollowVideosButton(Context context) {
        this(context, null);
    }

    public VideoHomeFollowVideosButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoHomeFollowVideosButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15690i = null;
        m19626a(VideoHomeFollowVideosButton.class, (View) this);
        setContentView(2130907677);
        this.f15692k = (VideoHomeToggleButton) a(2131568336);
        this.f15691j = context;
    }

    public void setFollowStateChangedListener(SubscribeStateChangedListener subscribeStateChangedListener) {
        this.f15688g = subscribeStateChangedListener;
    }

    public final void m19635a(boolean z, final String str, final Surface surface, final VideoChannelUnfollowInputData.Surface surface2) {
        m19630b();
        this.f15687f = str;
        m19629a(z, FollowVideosButtonTextHelper.m19645b(this.f15682a, getContext()), FollowVideosButtonTextHelper.m19644a(this.f15682a, getContext()), new com.facebook.video.followvideos.VideoHomeToggleButton.SubscribeStateChangedListener(this) {
            final /* synthetic */ VideoHomeFollowVideosButton f15674d;

            public final void mo1205a(boolean z) {
                if (z) {
                    this.f15674d.f15683b.a(str, surface);
                } else {
                    this.f15674d.f15683b.a(str, surface2);
                }
                this.f15674d.m19628a(z);
            }
        });
    }

    public final void m19637a(boolean z, String str, String str2, SubscribeStateChangedListener subscribeStateChangedListener) {
        m19630b();
        this.f15688g = subscribeStateChangedListener;
        m19629a(z, str, str2, new C12012(this));
    }

    private void m19629a(boolean z, String str, String str2, com.facebook.video.followvideos.VideoHomeToggleButton.SubscribeStateChangedListener subscribeStateChangedListener) {
        this.f15685d = z;
        this.f15692k.m19643a(z, str, str2, subscribeStateChangedListener);
    }

    private void m19630b() {
        this.f15684c = false;
        this.f15686e = null;
        this.f15687f = null;
        this.f15688g = null;
        this.f15689h = null;
        if (this.f15690i != null) {
            this.f15690i.setVisibility(8);
            this.f15690i = null;
        }
    }

    public final void m19634a(boolean z, final VideoChannelSubscribeInputData.Surface surface, final VideoChannelUnsubscribeInputData.Surface surface2) {
        this.f15684c = z;
        com.facebook.video.followvideos.VideoHomeToggleButton.SubscribeStateChangedListener c12023 = new com.facebook.video.followvideos.VideoHomeToggleButton.SubscribeStateChangedListener(this) {
            final /* synthetic */ VideoHomeFollowVideosButton f15678c;

            public final void mo1205a(boolean z) {
                VideoHomeFollowVideosButton.m19631b(this.f15678c, z, surface, surface2);
            }
        };
        String a = this.f15682a.a(ExperimentsForFollowVideosQeModule.f15706f, this.f15691j.getResources().getString(2131235667));
        String a2 = this.f15682a.a(ExperimentsForFollowVideosQeModule.f15705e, this.f15691j.getResources().getString(2131235668));
        this.f15690i = (VideoHomeToggleButton) a(2131568337);
        this.f15690i.m19643a(z, a, a2, c12023);
        if (this.f15685d) {
            this.f15690i.setVisibility(0);
        }
    }

    public final void m19636a(boolean z, String str, final VideoChannelSubscribeInputData.Surface surface, final VideoChannelUnsubscribeInputData.Surface surface2) {
        if (!TextUtils.isEmpty(str)) {
            this.f15684c = z;
            this.f15686e = str;
            this.f15693l = this.f15682a.a(ExperimentsForFollowVideosQeModule.f15707g, 5000);
            this.f15689h = new Object(this) {
                final /* synthetic */ VideoHomeFollowVideosButton f15681c;

                public final void m19621a(boolean z) {
                    VideoHomeFollowVideosButton.m19631b(this.f15681c, z, surface, surface2);
                }
            };
        }
    }

    public static void m19631b(VideoHomeFollowVideosButton videoHomeFollowVideosButton, boolean z, VideoChannelSubscribeInputData.Surface surface, VideoChannelUnsubscribeInputData.Surface surface2) {
        videoHomeFollowVideosButton.f15684c = z;
        if (z) {
            videoHomeFollowVideosButton.f15683b.a(videoHomeFollowVideosButton.f15687f, surface);
        } else {
            videoHomeFollowVideosButton.f15683b.a(videoHomeFollowVideosButton.f15687f, surface2);
        }
    }

    private void m19628a(boolean z) {
        this.f15685d = z;
        if (this.f15690i != null) {
            if (this.f15685d) {
                this.f15690i.setVisibility(0);
            } else {
                this.f15684c = false;
                this.f15690i.m19642a(false);
                this.f15690i.setVisibility(8);
            }
        }
        if (!(!this.f15685d || this.f15684c || this.f15689h == null)) {
            m19632c();
        }
        if (this.f15688g != null) {
            this.f15688g.m19622a(this.f15685d);
        }
    }

    private void m19632c() {
        FollowVideosNotificationUpsellDialogBuilder followVideosNotificationUpsellDialogBuilder = new FollowVideosNotificationUpsellDialogBuilder();
        followVideosNotificationUpsellDialogBuilder.f15667a = getContext();
        followVideosNotificationUpsellDialogBuilder = followVideosNotificationUpsellDialogBuilder;
        followVideosNotificationUpsellDialogBuilder.f15668b = this.f15686e;
        followVideosNotificationUpsellDialogBuilder = followVideosNotificationUpsellDialogBuilder;
        followVideosNotificationUpsellDialogBuilder.f15669c = this.f15693l;
        followVideosNotificationUpsellDialogBuilder = followVideosNotificationUpsellDialogBuilder;
        followVideosNotificationUpsellDialogBuilder.f15670d = this.f15689h;
        followVideosNotificationUpsellDialogBuilder = followVideosNotificationUpsellDialogBuilder;
        Preconditions.checkNotNull(followVideosNotificationUpsellDialogBuilder.f15667a);
        Preconditions.checkNotNull(followVideosNotificationUpsellDialogBuilder.f15668b);
        new NotificationDialog(followVideosNotificationUpsellDialogBuilder, followVideosNotificationUpsellDialogBuilder.f15667a).show();
    }

    public final void m19633a() {
        this.f15692k.m19641a();
    }
}
