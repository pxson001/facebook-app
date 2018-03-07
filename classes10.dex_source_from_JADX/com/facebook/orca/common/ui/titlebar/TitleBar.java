package com.facebook.orca.common.ui.titlebar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.R;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.util.SizeUtil;
import com.facebook.config.application.FbAppType;
import com.facebook.config.application.IntendedAudience;
import com.facebook.config.application.Product;
import com.facebook.config.server.ServerConfig;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.push.mqtt.external.PushStateEvent;
import com.facebook.push.mqtt.service.ChannelConnectivityTracker;
import com.facebook.push.mqtt.service.ConnectionState;
import com.facebook.resources.utils.ResourceUtils;
import com.facebook.rtc.fbwebrtc.VoipStatusHandler;
import com.facebook.widget.CustomViewGroup;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnBackPressedListener;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.List;
import javax.inject.Provider;

/* compiled from: p2p_group_send_initiate */
public class TitleBar extends CustomViewGroup implements FbTitleBar {
    private final Provider<ServerConfig> f5280a;
    private final FbAppType f5281b;
    private final AnalyticsLogger f5282c;
    public final VoipStatusHandler f5283d;
    private final BaseFbBroadcastManager f5284e;
    private final TitleBarBackButton f5285f;
    private final View f5286g;
    private final ViewGroup f5287h;
    private final TitleBarDefaultTextTitle f5288i;
    private final LinearLayout f5289j;
    private final TextView f5290k;
    private String f5291l;
    private boolean f5292m;
    private SelfRegistrableReceiverImpl f5293n;
    private List<TitleBarButtonSpec> f5294o;
    private OnToolbarButtonListener f5295p;
    private Paint f5296q;
    private OnBackPressedListener f5297r;

    /* compiled from: p2p_group_send_initiate */
    class C07401 implements OnClickListener {
        final /* synthetic */ TitleBar f5271a;

        C07401(TitleBar titleBar) {
            this.f5271a = titleBar;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2118955472);
            this.f5271a.f5283d.c();
            Logger.a(2, EntryType.UI_INPUT_END, 581620659, a);
        }
    }

    /* compiled from: p2p_group_send_initiate */
    class C07412 implements OnClickListener {
        final /* synthetic */ TitleBar f5272a;

        C07412(TitleBar titleBar) {
            this.f5272a = titleBar;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1545884711);
            this.f5272a.m4702c();
            Logger.a(2, EntryType.UI_INPUT_END, 1910240029, a);
        }
    }

    /* compiled from: p2p_group_send_initiate */
    class C07423 implements ActionReceiver {
        final /* synthetic */ TitleBar f5273a;

        C07423(TitleBar titleBar) {
            this.f5273a = titleBar;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 29005488);
            TitleBar.m4706e(this.f5273a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -575646463, a);
        }
    }

    /* compiled from: p2p_group_send_initiate */
    class C07434 implements ActionReceiver {
        final /* synthetic */ TitleBar f5274a;

        C07434(TitleBar titleBar) {
            this.f5274a = titleBar;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1435628684);
            TitleBar.m4707f(this.f5274a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -590877199, a);
        }
    }

    /* compiled from: p2p_group_send_initiate */
    class C07445 implements ActionReceiver {
        final /* synthetic */ TitleBar f5275a;

        C07445(TitleBar titleBar) {
            this.f5275a = titleBar;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1493778757);
            this.f5275a.m4698a(PushStateEvent.fromValue(intent.getIntExtra("event", PushStateEvent.UNKNOWN.toValue())));
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -254145742, a);
        }
    }

    /* compiled from: p2p_group_send_initiate */
    /* synthetic */ class C07467 {
        static final /* synthetic */ int[] f5278a = new int[ConnectionState.values().length];
        static final /* synthetic */ int[] f5279b = new int[PushStateEvent.values().length];

        static {
            try {
                f5279b[PushStateEvent.CHANNEL_DISCONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5279b[PushStateEvent.CHANNEL_CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f5279b[PushStateEvent.CHANNEL_CONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f5278a[ConnectionState.CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f5278a[ConnectionState.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f5278a[ConnectionState.DISCONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public TitleBar(Context context) {
        this(context, null);
    }

    public TitleBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TitleBar(Context context, AttributeSet attributeSet, int i) {
        PushStateEvent pushStateEvent;
        super(context, attributeSet, i);
        this.f5294o = RegularImmutableList.a;
        FbInjector fbInjector = FbInjector.get(getContext());
        this.f5280a = IdBasedSingletonScopeProvider.a(fbInjector, 2409);
        this.f5281b = (FbAppType) fbInjector.getInstance(FbAppType.class);
        this.f5282c = AnalyticsLoggerMethodAutoProvider.a(fbInjector);
        this.f5283d = VoipStatusHandler.a(fbInjector);
        this.f5284e = (BaseFbBroadcastManager) LocalFbBroadcastManager.a(fbInjector);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TitleBar);
        this.f5291l = Strings.nullToEmpty(ResourceUtils.a(context, obtainStyledAttributes, 0));
        this.f5292m = obtainStyledAttributes.getBoolean(1, true);
        obtainStyledAttributes.recycle();
        setContentView(2130905895);
        this.f5285f = (TitleBarBackButton) getView(2131565237);
        this.f5286g = getView(2131560490);
        this.f5288i = (TitleBarDefaultTextTitle) getView(2131565239);
        this.f5287h = (ViewGroup) getView(2131565238);
        this.f5289j = (LinearLayout) getView(2131565240);
        this.f5290k = (TextView) getView(2131565236);
        this.f5288i.setText(this.f5291l);
        this.f5290k.setOnClickListener(new C07401(this));
        if (this.f5281b.i == IntendedAudience.DEVELOPMENT) {
            setWillNotDraw(false);
        }
        if (!this.f5292m) {
            this.f5285f.setVisibility(8);
        }
        this.f5285f.setOnClickListener(new C07412(this));
        m4704d();
        this.f5296q = new Paint();
        this.f5296q.setStyle(Style.FILL_AND_STROKE);
        this.f5296q.setAntiAlias(true);
        PushStateEvent pushStateEvent2 = PushStateEvent.UNKNOWN;
        switch (C07467.f5278a[ChannelConnectivityTracker.a(fbInjector).b().ordinal()]) {
            case 1:
                pushStateEvent = PushStateEvent.CHANNEL_CONNECTED;
                break;
            case 2:
                pushStateEvent = PushStateEvent.CHANNEL_CONNECTING;
                break;
            case 3:
                pushStateEvent = PushStateEvent.CHANNEL_DISCONNECTED;
                break;
            default:
                pushStateEvent = pushStateEvent2;
                break;
        }
        m4698a(pushStateEvent);
    }

    private void m4700b() {
        if (this.f5293n == null) {
            C07423 c07423 = new C07423(this);
            this.f5293n = this.f5284e.a().a("com.facebook.orca.login.AuthStateMachineMonitor.LOGIN_COMPLETE", c07423).a("com.facebook.orca.login.AuthStateMachineMonitor.LOGOUT_COMPLETE", c07423).a("com.facebook.push.mqtt.ACTION_CHANNEL_STATE_CHANGED", new C07445(this)).a("com.facebook.rtc.fbwebrtc.CALL_STATUS_AND_DURATION_UPDATE", new C07434(this)).a();
        }
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 65550693);
        super.onAttachedToWindow();
        m4700b();
        this.f5293n.b();
        m4706e(this);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1584802709, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 944201854);
        super.onDetachedFromWindow();
        if (this.f5293n != null) {
            this.f5293n.c();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -924503941, a);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f5281b.i == IntendedAudience.DEVELOPMENT && this.f5281b.j != Product.PAA) {
            int a = SizeUtil.a(getContext(), 10.0f);
            canvas.drawCircle((float) (canvas.getWidth() - a), (float) a, (float) (a / 2), this.f5296q);
        }
    }

    public String getTitle() {
        return this.f5291l;
    }

    public void setTitle(String str) {
        this.f5291l = str;
        this.f5288i.setText(str);
    }

    public void setTitle(int i) {
        this.f5291l = getResources().getString(i);
        this.f5288i.setText(this.f5291l);
    }

    public void setHasBackButton(boolean z) {
        this.f5292m = z;
        this.f5285f.setVisibility(z ? 0 : 8);
    }

    public final boolean m4709a() {
        return false;
    }

    public void setCustomTitleView(View view) {
        if (this.f5287h.getChildCount() > 1) {
            this.f5287h.removeViewAt(1);
        }
        if (view != null) {
            this.f5287h.addView(view);
            view.setVisibility(0);
            this.f5288i.setVisibility(8);
            return;
        }
        this.f5288i.setVisibility(0);
    }

    public final View f_(int i) {
        View inflate = LayoutInflater.from(getContext()).inflate(i, this.f5287h, false);
        setCustomTitleView(inflate);
        return inflate;
    }

    public void setButtonSpecs(List<TitleBarButtonSpec> list) {
        this.f5294o = ImmutableList.copyOf(list);
        m4704d();
    }

    public void setOnBackPressedListener(OnBackPressedListener onBackPressedListener) {
        this.f5297r = onBackPressedListener;
    }

    public void setShowDividers(boolean z) {
    }

    private void m4702c() {
        m4699a("titlebar_back_button");
        if (this.f5297r != null) {
            this.f5297r.a();
            return;
        }
        Context context = getContext();
        if (context instanceof Activity) {
            ((Activity) context).onBackPressed();
        }
    }

    private void m4704d() {
        for (int childCount = this.f5289j.getChildCount(); childCount < this.f5294o.size(); childCount++) {
            TitleBarButton titleBarButton = new TitleBarButton(getContext());
            titleBarButton.setLayoutParams(new LayoutParams(-2, -2));
            this.f5289j.addView(titleBarButton);
            titleBarButton.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ TitleBar f5277b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -270583458);
                    this.f5277b.m4697a((TitleBarButton) view, childCount);
                    Logger.a(2, EntryType.UI_INPUT_END, -288290255, a);
                }
            });
            if (childCount == 0) {
                titleBarButton.setId(2131558450);
            }
        }
        for (int i = 0; i < this.f5294o.size(); i++) {
            int i2;
            TitleBarButton titleBarButton2 = (TitleBarButton) this.f5289j.getChildAt(i);
            TitleBarButtonSpec titleBarButtonSpec = (TitleBarButtonSpec) this.f5294o.get(i);
            if (titleBarButtonSpec.h != -1) {
                titleBarButton2.setIconResId(titleBarButtonSpec.h);
            } else {
                titleBarButton2.setImageDrawable(titleBarButtonSpec.d);
            }
            titleBarButton2.setText(titleBarButtonSpec.i);
            titleBarButton2.setImageButtonContentDescription(titleBarButtonSpec.k);
            titleBarButton2.setButtonWidth(titleBarButtonSpec.j);
            if (titleBarButtonSpec.f) {
                i2 = 4;
            } else {
                i2 = 0;
            }
            titleBarButton2.setVisibility(i2);
            titleBarButton2.setSelected(titleBarButtonSpec.s);
            titleBarButton2.setEnabled(titleBarButtonSpec.t);
        }
        for (int size = this.f5294o.size(); size < this.f5289j.getChildCount(); size++) {
            titleBarButton2 = (TitleBarButton) this.f5289j.getChildAt(size);
            titleBarButton2.setVisibility(8);
            titleBarButton2.setShowProgress(false);
        }
        m4706e(this);
        m4707f(this);
    }

    private void m4699a(String str) {
        if (str != null) {
            Context context = getContext();
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("click");
            honeyClientEvent.e = str;
            honeyClientEvent = honeyClientEvent;
            honeyClientEvent.d = "button";
            honeyClientEvent = honeyClientEvent;
            if (context instanceof AnalyticsActivity) {
                honeyClientEvent.c = ((AnalyticsActivity) context).am_().toString();
            }
            this.f5282c.a(honeyClientEvent);
        }
    }

    private void m4697a(TitleBarButton titleBarButton, int i) {
        if (i < this.f5294o.size()) {
            TitleBarButtonSpec titleBarButtonSpec = (TitleBarButtonSpec) this.f5294o.get(i);
            if (titleBarButtonSpec.e) {
                boolean z;
                if (titleBarButtonSpec.s) {
                    z = false;
                } else {
                    z = true;
                }
                titleBarButton.setSelected(z);
                titleBarButtonSpec.s = z;
            }
            if (this.f5295p != null) {
                m4699a(titleBarButtonSpec.g);
                this.f5295p.a(titleBarButton, titleBarButtonSpec);
            }
        }
    }

    public void setOnToolbarButtonListener(OnToolbarButtonListener onToolbarButtonListener) {
        this.f5295p = onToolbarButtonListener;
    }

    public void setHasFbLogo(boolean z) {
    }

    public final void m4708a(OnClickListener onClickListener) {
    }

    public void setTitlebarAsModal(OnClickListener onClickListener) {
    }

    public static void m4706e(TitleBar titleBar) {
        int i;
        ServerConfig serverConfig = (ServerConfig) titleBar.f5280a.get();
        if (!BuildConstants.i || serverConfig.a() == serverConfig.b()) {
            i = 0;
        } else {
            i = 1;
        }
        if (i != 0) {
            titleBar.f5286g.setBackgroundDrawable(new ColorDrawable(Color.rgb(0, 255, 0)));
        } else {
            titleBar.f5286g.setBackgroundResource(2130843655);
        }
    }

    private void m4698a(PushStateEvent pushStateEvent) {
        switch (C07467.f5279b[pushStateEvent.ordinal()]) {
            case 1:
                this.f5296q.setColor(-65536);
                break;
            case 2:
                this.f5296q.setColor(-256);
                break;
            case 3:
                this.f5296q.setColor(-1);
                break;
        }
        invalidate();
    }

    public static void m4707f(TitleBar titleBar) {
        if (titleBar.f5283d.a()) {
            titleBar.f5290k.setVisibility(0);
            titleBar.f5290k.setText(titleBar.f5283d.b());
            return;
        }
        titleBar.f5290k.setVisibility(8);
    }
}
