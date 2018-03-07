package com.facebook.offers.fragment;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.fbui.popover.PopoverMenuWindow;
import com.facebook.fbui.popover.PopoverMenuWindow.OnMenuItemClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.offers.fragment.OfferRenderingUtils.C17562;
import com.facebook.offers.fragment.OffersWalletFragment.C17664;
import com.facebook.offers.fragment.OffersWalletFragment.C17664.C17651;
import com.facebook.offers.fragment.OffersWalletFragment.C17705;
import com.facebook.offers.graphql.OfferQueriesInterfaces.OfferClaimData;
import com.facebook.offers.model.OfferOrCoupon;
import com.facebook.offers.views.OfferExpirationTimerView;
import com.facebook.resources.ui.FbButton;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.widget.listview.AdapterCompatibleWithListView;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.BetterRecyclerView.OnItemClickListener;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: cursor_token */
public class OffersWalletAdapter extends Adapter<ViewHolder> implements AdapterCompatibleWithListView<ViewHolder> {
    public static final CallerContext f16273a = CallerContext.a(OffersWalletAdapter.class);
    public List<OfferOrCoupon> f16274b = Collections.EMPTY_LIST;
    public final Activity f16275c;
    private final UriIntentMapper f16276d;
    private final SecureContextHelper f16277e;
    public final OfferRenderingUtils f16278f;
    @Nullable
    public C17664 f16279g;
    @Nullable
    public C17705 f16280h;

    /* compiled from: cursor_token */
    public class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder implements OnClickListener, OnItemClickListener {
        public final /* synthetic */ OffersWalletAdapter f16260l;
        public FbButton f16261m;
        public FbDraweeView f16262n;
        public FbDraweeView f16263o;
        public TextView f16264p;
        public TextView f16265q;
        public TextView f16266r;
        public OfferExpirationTimerView f16267s;
        public FbButton f16268t;
        public BetterRecyclerView f16269u;
        public OfferDetailHeaderCarouselAdapter f16270v;
        public RichVideoPlayer f16271w;
        public OfferOrCoupon f16272x;

        /* compiled from: cursor_token */
        public class C17581 implements OnMenuItemClickListener {
            final /* synthetic */ ViewHolder f16259a;

            public C17581(ViewHolder viewHolder) {
                this.f16259a = viewHolder;
            }

            public final boolean m19025a(MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == 2131568652) {
                    this.f16259a.f16260l.f16278f.m19018a(this.f16259a.f16260l.f16275c, this.f16259a.f16272x, "wallet");
                } else if (itemId == 2131568651) {
                    if (this.f16259a.f16260l.f16279g != null) {
                        C17664 c17664 = this.f16259a.f16260l.f16279g;
                        OfferClaimData offerClaimData = this.f16259a.f16272x.f16522a;
                        c17664.f16292a.au = true;
                        ListenableFuture a = c17664.f16292a.f16307a.m18993a(offerClaimData.mo1003g(), offerClaimData, c17664.f16292a.aq, !offerClaimData.mo1007v(), (String) c17664.f16292a.f16312f.get());
                        c17664.f16292a.m19040a(true);
                        Futures.a(a, new C17651(c17664, offerClaimData));
                    }
                } else if (itemId == 2131568653 && this.f16259a.f16260l.f16280h != null) {
                    this.f16259a.f16260l.f16280h.m19033a(this.f16259a.f16272x.f16522a);
                }
                return true;
            }
        }

        public ViewHolder(OffersWalletAdapter offersWalletAdapter, View view) {
            this.f16260l = offersWalletAdapter;
            super(view);
            this.f16261m = (FbButton) view.findViewById(2131564370);
            this.f16262n = (FbDraweeView) view.findViewById(2131564372);
            this.f16263o = (FbDraweeView) view.findViewById(2131564368);
            this.f16264p = (TextView) view.findViewById(2131564369);
            this.f16265q = (TextView) view.findViewById(2131564375);
            this.f16266r = (TextView) view.findViewById(2131564376);
            this.f16267s = (OfferExpirationTimerView) view.findViewById(2131564371);
            this.f16268t = (FbButton) view.findViewById(2131564378);
            this.f16269u = (BetterRecyclerView) view.findViewById(2131564373);
            this.f16270v = new OfferDetailHeaderCarouselAdapter(view.getContext(), false);
            this.f16269u.setAdapter(this.f16270v);
            this.f16271w = (RichVideoPlayer) view.findViewById(2131564374);
            this.f16271w.a(offersWalletAdapter.f16278f.m19023b(view.getContext()));
            this.f16269u.setLayoutManager(new BetterLinearLayoutManager(view.getContext(), 0, false));
            this.f16269u.setOnItemClickListener(this);
            this.f16262n.setOnClickListener(this);
            this.f16265q.setOnClickListener(this);
            this.f16266r.setOnClickListener(this);
            this.f16267s.setOnClickListener(this);
            this.f16261m.setOnClickListener(this);
        }

        public final void m19026a(BetterRecyclerView betterRecyclerView, View view, int i, long j) {
            onClick(view);
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1443785128);
            if (view == this.f16261m) {
                boolean z;
                PopoverMenuWindow popoverMenuWindow = new PopoverMenuWindow(view.getContext());
                popoverMenuWindow.b(2131820569);
                MenuItemImpl menuItemImpl = (MenuItemImpl) popoverMenuWindow.c().getItem(0);
                menuItemImpl.setChecked(this.f16272x.m19464n());
                menuItemImpl.setTitle(this.f16272x.m19464n() ? 2131236815 : 2131236814);
                menuItemImpl = (MenuItemImpl) popoverMenuWindow.c().getItem(2);
                if (this.f16272x.m19465o()) {
                    z = false;
                } else {
                    z = true;
                }
                menuItemImpl.setChecked(z);
                menuItemImpl.setTitle(this.f16272x.m19465o() ? 2131236816 : 2131236817);
                popoverMenuWindow.p = new C17581(this);
                popoverMenuWindow.c(view);
                popoverMenuWindow.d();
            } else {
                this.f16260l.f16278f.m19017a(this.f16260l.f16275c, this.f16272x);
            }
            LogUtils.a(1497209259, a);
        }
    }

    public final void m19028a(android.support.v7.widget.RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        OfferOrCoupon offerOrCoupon = (OfferOrCoupon) this.f16274b.get(i);
        viewHolder2.f16272x = offerOrCoupon;
        if (viewHolder2.f16272x.m19455d() > 0) {
            viewHolder2.f16271w.setVisibility(0);
            viewHolder2.f16271w.a(viewHolder2.f16272x.m19452a(0, true));
            viewHolder2.f16271w.a(EventTriggerType.BY_USER);
            viewHolder2.f16271w.a(true, EventTriggerType.BY_AUTOPLAY);
            viewHolder2.f16269u.setVisibility(8);
            viewHolder2.f16262n.setVisibility(8);
        } else if (viewHolder2.f16272x.m19454c() > 1) {
            viewHolder2.f16270v.f16192d = viewHolder2.f16272x.m19453b();
            viewHolder2.f16269u.setVisibility(0);
            viewHolder2.f16262n.setVisibility(8);
            viewHolder2.f16271w.setVisibility(8);
        } else if (viewHolder2.f16272x.m19451a() != null) {
            viewHolder2.f16262n.a(Uri.parse(viewHolder2.f16272x.m19451a().m19151a()), f16273a);
            viewHolder2.f16262n.setVisibility(0);
            viewHolder2.f16269u.setVisibility(8);
            viewHolder2.f16271w.setVisibility(8);
        } else {
            viewHolder2.f16262n.a(null, f16273a);
            viewHolder2.f16262n.setVisibility(0);
            viewHolder2.f16269u.setVisibility(8);
            viewHolder2.f16271w.setVisibility(8);
        }
        viewHolder2.f16263o.a(Uri.parse(viewHolder2.f16272x.m19456e().jR_().m19151a()), f16273a);
        viewHolder2.f16264p.setText(viewHolder2.f16272x.m19456e().m19245d());
        viewHolder2.f16265q.setText(viewHolder2.f16272x.m19457f());
        viewHolder2.f16266r.setText(viewHolder2.f16272x.m19458g());
        viewHolder2.f16267s.setExpiresOn(viewHolder2.f16272x.m19459h());
        OfferRenderingUtils offerRenderingUtils = viewHolder2.f16260l.f16278f;
        OfferExpirationTimerView offerExpirationTimerView = viewHolder2.f16267s;
        long h = (1000 * viewHolder2.f16272x.m19459h()) - offerRenderingUtils.f16249a.a();
        if (h >= 86400000 || h <= 0) {
            offerExpirationTimerView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            offerExpirationTimerView.setCompoundDrawablePadding(0);
        } else {
            offerExpirationTimerView.setCompoundDrawablesWithIntrinsicBounds(offerRenderingUtils.f16252d.a(2130839801, -5066062), null, null, null);
            offerExpirationTimerView.setCompoundDrawablePadding(5);
        }
        if (viewHolder2.f16260l.f16278f.m19022a(viewHolder2.f16272x)) {
            viewHolder2.f16268t.setText(2131236831);
            viewHolder2.f16268t.setTextColor(viewHolder2.f16260l.f16275c.getResources().getColor(2131362107));
        } else if (offerOrCoupon.m19464n()) {
            viewHolder2.f16268t.setText(2131236810);
            viewHolder2.f16268t.setTextColor(viewHolder2.f16260l.f16275c.getResources().getColor(2131362107));
        } else {
            viewHolder2.f16268t.setText(2131236810);
            viewHolder2.f16268t.setTextColor(viewHolder2.f16260l.f16275c.getResources().getColor(2131361917));
        }
        offerRenderingUtils = viewHolder2.f16260l.f16278f;
        FbButton fbButton = viewHolder2.f16268t;
        fbButton.setOnClickListener(new C17562(offerRenderingUtils, fbButton.getContext(), viewHolder2.f16272x, "wallet"));
        viewHolder2.f16260l.f16278f.m19020a(viewHolder2.f16264p, viewHolder2.f16272x);
        viewHolder2.f16260l.f16278f.m19020a(viewHolder2.f16263o, viewHolder2.f16272x);
        if (offerOrCoupon.m19471v()) {
            viewHolder2.f16261m.setVisibility(4);
        } else {
            viewHolder2.f16261m.setVisibility(0);
        }
    }

    @Inject
    public OffersWalletAdapter(Activity activity, UriIntentMapper uriIntentMapper, SecureContextHelper secureContextHelper, OfferRenderingUtils offerRenderingUtils) {
        this.f16275c = activity;
        this.f16276d = uriIntentMapper;
        this.f16277e = secureContextHelper;
        this.f16278f = offerRenderingUtils;
        a(true);
    }

    public final android.support.v7.widget.RecyclerView.ViewHolder m19027a(ViewGroup viewGroup, int i) {
        return new ViewHolder(this, LayoutInflater.from(viewGroup.getContext()).inflate(2130905532, viewGroup, false));
    }

    public final int aZ_() {
        return this.f16274b.size();
    }

    public final long H_(int i) {
        return Long.parseLong(((OfferOrCoupon) this.f16274b.get(i)).m19462k());
    }

    public final int iy_() {
        return 1;
    }

    public Object getItem(int i) {
        return this.f16274b.get(i);
    }
}
