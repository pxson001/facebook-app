package com.facebook.stickers.store;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.stickers.client.StickerDownloadManager;
import com.facebook.stickers.model.StickerInterface;
import com.facebook.stickers.model.StickerPack;
import com.facebook.stickers.service.DefaultStickerPackSetProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomViewGroup;
import com.google.common.base.Absent;
import com.google.common.base.Objects;
import com.google.common.base.Optional;

/* compiled from: e22cbab8bb29240b16720b39a58c4fe3 */
public class StickerStoreListItemView extends CustomViewGroup implements ActionReceiver {
    private static final CallerContext f16983a = CallerContext.a(StickerStoreListItemView.class, "sticker_store");
    public final FbDraweeView f16984b;
    private final ProgressBar f16985c;
    public final TextView f16986d;
    private final TextView f16987e;
    public final TextView f16988f;
    public final ImageView f16989g;
    public final View f16990h;
    public final ImageView f16991i;
    private final Context f16992j;
    public BaseFbBroadcastManager f16993k;
    private SelfRegistrableReceiverImpl f16994l;
    public DefaultStickerPackSetProvider f16995m;
    public StickerDownloadManager f16996n;
    public final int f16997o;
    private final int f16998p;
    private final int f16999q;
    public String f17000r;
    public StickerPack f17001s;
    private boolean f17002t;
    private String f17003u;
    private boolean f17004v;
    public boolean f17005w;
    private Optional<StickerInterface> f17006x = Absent.INSTANCE;

    public static void m24711a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        StickerStoreListItemView stickerStoreListItemView = (StickerStoreListItemView) obj;
        BaseFbBroadcastManager baseFbBroadcastManager = (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike);
        DefaultStickerPackSetProvider a = DefaultStickerPackSetProvider.a(injectorLike);
        StickerDownloadManager a2 = StickerDownloadManager.m23933a(injectorLike);
        stickerStoreListItemView.f16993k = baseFbBroadcastManager;
        stickerStoreListItemView.f16995m = a;
        stickerStoreListItemView.f16996n = a2;
    }

    public StickerStoreListItemView(Context context) {
        super(context);
        setContentView(2130905864);
        Class cls = StickerStoreListItemView.class;
        m24711a(this, getContext());
        this.f17005w = true;
        this.f16984b = (FbDraweeView) getView(2131562910);
        this.f16985c = (ProgressBar) getView(2131559418);
        this.f16986d = (TextView) getView(2131560124);
        this.f16987e = (TextView) getView(2131565135);
        this.f16988f = (TextView) getView(2131560464);
        this.f16989g = (ImageView) getView(2131565161);
        this.f16990h = getView(2131565159);
        this.f16991i = (ImageView) getView(2131562655);
        this.f16992j = ContextUtils.a(getContext(), 2130773101, 2131625136);
        this.f16994l = this.f16993k.a().a("com.facebook.orca.stickers.DOWNLOAD_PROGRESS", this).a("com.facebook.orca.stickers.DOWNLOAD_SUCCESS", this).a("com.facebook.orca.stickers.DOWNLOAD_FAILURE", this).a();
        this.f16997o = ContextUtils.b(this.f16992j, 2130773102, 2130842319);
        this.f16998p = ContextUtils.b(this.f16992j, 2130773103, 2130842322);
        this.f16999q = ContextUtils.b(this.f16992j, 2130773104, 2130842326);
    }

    public final void m24715a(StickerPack stickerPack, boolean z, String str, boolean z2, StickerInterface stickerInterface) {
        this.f17000r = stickerPack.f4955a;
        this.f17001s = stickerPack;
        this.f17002t = z;
        this.f17003u = str;
        this.f17004v = z2;
        this.f17005w = true;
        this.f17006x = Optional.of(stickerInterface);
        m24714a();
    }

    public void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 518947258);
        super.onAttachedToWindow();
        this.f16994l.b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1102517329, a);
    }

    public void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1466304401);
        this.f16994l.c();
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1672553451, a);
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 893523416);
        StickerPack stickerPack = (StickerPack) intent.getParcelableExtra("stickerPack");
        if (this.f17004v || stickerPack == null || !Objects.equal(this.f17000r, stickerPack.f4955a)) {
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1763619220, a);
            return;
        }
        m24713g();
        if ("com.facebook.orca.stickers.DOWNLOAD_PROGRESS".equals(intent.getAction())) {
            this.f16985c.setProgress(intent.getIntExtra("progress", 0));
        }
        LogUtils.e(1460378941, a);
    }

    public final void m24714a() {
        this.f16984b.a(this.f17001s.f4959e, f16983a);
        this.f16986d.setText(this.f17001s.f4956b);
        this.f16987e.setText(this.f17001s.f4957c);
        this.f16991i.setVisibility(this.f17004v ? 0 : 8);
        if (this.f17001s.m7725a((StickerInterface) this.f17006x.get())) {
            m24712e();
            return;
        }
        Resources resources = getResources();
        this.f16988f.setText(resources.getString(2131232439));
        TypedValue typedValue = new TypedValue();
        resources.getValue(2131428040, typedValue, false);
        this.f16984b.setAlpha(typedValue.getFloat());
        this.f16989g.setColorFilter(resources.getColor(2131361939));
        this.f16989g.setEnabled(false);
        this.f16986d.setTextColor(resources.getColor(2131361937));
    }

    private void m24712e() {
        int i = 0;
        Resources resources = getResources();
        TypedValue typedValue = new TypedValue();
        resources.getValue(2131428041, typedValue, false);
        this.f16984b.setAlpha(typedValue.getFloat());
        this.f16989g.clearColorFilter();
        this.f16989g.setEnabled(true);
        this.f16986d.setTextColor(-16777216);
        this.f16988f.setText(this.f17003u != null ? this.f17003u : resources.getText(2131231293));
        if (this.f17004v) {
            boolean z;
            this.f16985c.setVisibility(8);
            int i2 = 0;
            this.f16989g.setImageResource(this.f16997o);
            if (this.f16995m.a.contains(this.f17000r)) {
                z = false;
            } else {
                z = true;
            }
            this.f16989g.setContentDescription(StringLocaleUtil.a("%s %s", new Object[]{getResources().getString(2131231294), this.f17001s.f4956b}));
            ImageView imageView = this.f16989g;
            if (!z) {
                i2 = 8;
            }
            imageView.setVisibility(i2);
            this.f16989g.setEnabled(true);
            return;
        }
        int i3;
        boolean c = this.f16996n.m23937c(this.f17001s);
        ProgressBar progressBar = this.f16985c;
        if (c) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        progressBar.setVisibility(i3);
        ProgressBar progressBar2 = this.f16985c;
        if (c) {
            i = this.f16996n.m23938d(this.f17001s);
        }
        progressBar2.setProgress(i);
        m24713g();
    }

    private void m24713g() {
        CharSequence a;
        boolean z = true;
        boolean c = this.f16996n.m23937c(this.f17001s);
        if (this.f16996n.m23937c(this.f17001s)) {
            this.f16989g.setImageResource(this.f16998p);
            a = StringLocaleUtil.a("%s %s", new Object[]{getResources().getString(2131231296), this.f17001s.f4956b});
        } else if (this.f17002t) {
            this.f16989g.setImageResource(this.f16999q);
            a = StringLocaleUtil.a("%s %s", new Object[]{getResources().getString(2131231297), this.f17001s.f4956b});
        } else {
            this.f16989g.setImageResource(this.f16998p);
            a = StringLocaleUtil.a("%s %s", new Object[]{getResources().getString(2131231295), this.f17001s.f4956b});
        }
        ImageView imageView = this.f16989g;
        if (c) {
            z = false;
        }
        imageView.setEnabled(z);
        this.f16989g.setVisibility(0);
        this.f16989g.setContentDescription(a);
    }
}
