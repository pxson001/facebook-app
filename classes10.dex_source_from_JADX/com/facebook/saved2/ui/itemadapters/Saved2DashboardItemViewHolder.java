package com.facebook.saved2.ui.itemadapters;

import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.facebook.analytics.CurationMechanism;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.crudolib.dao.DAOItem;
import com.facebook.crudolib.dao.view.OnDAOItemClickListener;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.saved2.analytics.Saved2StartPerfLogger;
import com.facebook.saved2.model.Saved2ItemTable_Queries.BaseQueryDAO;
import com.facebook.saved2.model.Saved2ItemTable_Queries.BaseQueryProvider;
import com.facebook.saved2.ui.contextmenu.Saved2ContextMenuFactory;
import com.facebook.saved2.ui.itemadapters.Saved2DashboardItemView.OnAfterDrawListener;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.video.downloadmanager.DownloadManager;
import com.facebook.video.events.VideoDownloadEventBus;
import com.facebook.video.events.VideoDownloadEvents.DownloadStatusChangeEvent;
import com.facebook.video.events.VideoDownloadStatus;
import com.facebook.video.events.VideoDownloadStatus.DownloadStatus;
import javax.inject.Inject;

/* compiled from: index_of_photo_to_be_replaced */
public class Saved2DashboardItemViewHolder extends ViewHolder {
    private final Saved2DashboardItemView f9606l;
    private final Saved2ItemClickListener f9607m;
    private final Saved2ActionButtonClickListener f9608n;
    public final PopoverTrackingState f9609o;
    private final Drawable f9610p;
    public final Saved2StartPerfLogger f9611q;
    public String f9612r = null;
    private String f9613s;
    private long f9614t;
    public VideoDownloadStatus f9615u;
    public final Handler f9616v = new Handler(Looper.getMainLooper());
    private DownloadManager f9617w;
    private final VideoDownloadEventBus f9618x;
    private final VideoDownloadEventHandler f9619y;

    /* compiled from: index_of_photo_to_be_replaced */
    class C14321 implements OnAfterDrawListener {
        final /* synthetic */ Saved2DashboardItemViewHolder f9596a;

        C14321(Saved2DashboardItemViewHolder saved2DashboardItemViewHolder) {
            this.f9596a = saved2DashboardItemViewHolder;
        }

        public final void mo450a() {
            this.f9596a.f9611q.m9531f();
        }
    }

    /* compiled from: index_of_photo_to_be_replaced */
    class Saved2ActionButtonClickListener extends OnDAOItemClickListener<BaseQueryDAO> {
        final /* synthetic */ Saved2DashboardItemViewHolder f9598a;
        private final FragmentActivity f9599b;
        private final Lazy<Saved2ContextMenuFactory> f9600c;

        /* compiled from: index_of_photo_to_be_replaced */
        public class C14331 {
            final /* synthetic */ Saved2ActionButtonClickListener f9597a;

            C14331(Saved2ActionButtonClickListener saved2ActionButtonClickListener) {
                this.f9597a = saved2ActionButtonClickListener;
            }

            public final DAOItem m9851a(Cursor cursor) {
                cursor.moveToFirst();
                BaseQueryProvider baseQueryProvider = new BaseQueryProvider(0, 0);
                return BaseQueryProvider.b(cursor);
            }
        }

        public final void m9853a(View view, DAOItem dAOItem) {
            BaseQueryDAO baseQueryDAO = (BaseQueryDAO) dAOItem;
            this.f9598a.f9609o.f9589a = ((Saved2ContextMenuFactory) this.f9600c.get()).m9801a(this.f9599b, view, m9852a(baseQueryDAO), CurationMechanism.MORE_BUTTON);
        }

        public Saved2ActionButtonClickListener(Saved2DashboardItemViewHolder saved2DashboardItemViewHolder, FragmentActivity fragmentActivity, Lazy<Saved2ContextMenuFactory> lazy) {
            this.f9598a = saved2DashboardItemViewHolder;
            this.f9599b = fragmentActivity;
            this.f9600c = lazy;
        }

        private BaseQueryDAO m9852a(BaseQueryDAO baseQueryDAO) {
            return (BaseQueryDAO) baseQueryDAO.a(new C14331(this));
        }
    }

    /* compiled from: index_of_photo_to_be_replaced */
    class Saved2ItemClickListener extends OnDAOItemClickListener<BaseQueryDAO> {
        private final Lazy<Saved2ItemClickHandler> f9601a;
        private final String f9602b;

        public final void m9854a(View view, DAOItem dAOItem) {
            ((Saved2ItemClickHandler) this.f9601a.get()).m9881a(view.getContext(), this.f9602b, (BaseQueryDAO) dAOItem);
        }

        public Saved2ItemClickListener(Lazy<Saved2ItemClickHandler> lazy, String str) {
            this.f9601a = lazy;
            this.f9602b = str;
        }
    }

    /* compiled from: index_of_photo_to_be_replaced */
    class VideoDownloadEventHandler implements DownloadStatusChangeEvent.Handler {
        final /* synthetic */ Saved2DashboardItemViewHolder f9605a;

        public VideoDownloadEventHandler(Saved2DashboardItemViewHolder saved2DashboardItemViewHolder) {
            this.f9605a = saved2DashboardItemViewHolder;
        }

        public final void m9855a(final DownloadStatusChangeEvent downloadStatusChangeEvent) {
            HandlerDetour.a(this.f9605a.f9616v, new Runnable(this) {
                final /* synthetic */ VideoDownloadEventHandler f9604b;

                public void run() {
                    if (this.f9604b.f9605a.f9612r != null && this.f9604b.f9605a.f9612r.equals(downloadStatusChangeEvent.b)) {
                        this.f9604b.f9605a.f9615u = downloadStatusChangeEvent.a;
                        Saved2DashboardItemViewHolder.m9864y(this.f9604b.f9605a);
                    }
                }
            }, 92638588);
        }
    }

    @Inject
    public Saved2DashboardItemViewHolder(@Assisted FragmentActivity fragmentActivity, @Assisted View view, @Assisted String str, @Assisted PopoverTrackingState popoverTrackingState, Lazy<Saved2ItemClickHandler> lazy, Lazy<Saved2ContextMenuFactory> lazy2, Saved2StartPerfLogger saved2StartPerfLogger, DownloadManager downloadManager, VideoDownloadEventBus videoDownloadEventBus) {
        super(view);
        this.f9606l = (Saved2DashboardItemView) view.findViewById(2131567202);
        this.f9606l.setThumbnailSize(view.getResources().getDimensionPixelSize(2131434028));
        this.f9607m = new Saved2ItemClickListener(lazy, str);
        this.f9608n = new Saved2ActionButtonClickListener(this, fragmentActivity, lazy2);
        this.f9609o = popoverTrackingState;
        this.f9610p = fragmentActivity.getResources().getDrawable(2130840339);
        int dimensionPixelSize = fragmentActivity.getResources().getDimensionPixelSize(2131432255);
        this.f9606l.c(dimensionPixelSize, dimensionPixelSize);
        this.f9611q = saved2StartPerfLogger;
        this.f9617w = downloadManager;
        this.f9618x = videoDownloadEventBus;
        this.f9619y = new VideoDownloadEventHandler(this);
    }

    private static String m9858a(long j) {
        if (j < 1000000) {
            return StringFormatUtil.formatStrLocaleSafe("%.1f KB", Double.valueOf(((double) j) / 1000.0d));
        }
        return StringFormatUtil.formatStrLocaleSafe("%.1f MB", Double.valueOf((((double) j) / 1000.0d) / 1000.0d));
    }

    private String m9859a(VideoDownloadStatus videoDownloadStatus) {
        long j = 0;
        if (videoDownloadStatus != null) {
            j = (videoDownloadStatus.b * 100) / this.f9614t;
        }
        return this.f9606l.getContext().getResources().getString(2131241576, new Object[]{Long.valueOf(j), m9858a(this.f9614t)});
    }

    public static void m9864y(Saved2DashboardItemViewHolder saved2DashboardItemViewHolder) {
        if (saved2DashboardItemViewHolder.f9615u == null) {
            return;
        }
        if (saved2DashboardItemViewHolder.f9615u.c == DownloadStatus.DOWNLOAD_COMPLETED) {
            saved2DashboardItemViewHolder.f9606l.setSubtitleText(saved2DashboardItemViewHolder.f9606l.getContext().getResources().getString(2131241577, new Object[]{saved2DashboardItemViewHolder.f9613s, m9858a(saved2DashboardItemViewHolder.f9614t)}));
        } else if (saved2DashboardItemViewHolder.f9615u.c != DownloadStatus.DOWNLOAD_NOT_REQUESTED) {
            saved2DashboardItemViewHolder.f9606l.setSubtitleText(saved2DashboardItemViewHolder.m9859a(saved2DashboardItemViewHolder.f9615u));
        }
    }

    public final void m9866w() {
        this.f9618x.a(DownloadStatusChangeEvent.class, this.f9619y);
    }

    public final void m9867x() {
        this.f9618x.b(DownloadStatusChangeEvent.class, this.f9619y);
    }

    public final void m9865a(BaseQueryDAO baseQueryDAO) {
        Saved2DashboardItemView saved2DashboardItemView;
        Uri parse;
        Drawable drawable = null;
        this.f9606l.setTitleText(baseQueryDAO.j());
        if (baseQueryDAO.t()) {
            this.f9612r = baseQueryDAO.w();
            this.f9614t = baseQueryDAO.Q();
            m9864y(this);
        } else {
            this.f9612r = null;
        }
        this.f9613s = baseQueryDAO.l();
        this.f9615u = this.f9617w.d(this.f9612r);
        if (this.f9615u.c == DownloadStatus.DOWNLOAD_NOT_REQUESTED) {
            this.f9606l.setSubtitleText(baseQueryDAO.k());
            this.f9606l.setMetaText(baseQueryDAO.l());
            saved2DashboardItemView = this.f9606l;
            Context context = this.f9606l.getContext();
            Object[] objArr = new Object[3];
            objArr[0] = baseQueryDAO.j() != null ? baseQueryDAO.j() : "";
            objArr[1] = baseQueryDAO.k() != null ? baseQueryDAO.k() : "";
            objArr[2] = baseQueryDAO.l() != null ? baseQueryDAO.l() : "";
            saved2DashboardItemView.setContentDescription(context.getString(2131241574, objArr));
        } else {
            this.f9606l.setMetaText("");
        }
        saved2DashboardItemView = this.f9606l;
        if (baseQueryDAO.h()) {
            parse = Uri.parse(baseQueryDAO.i());
        } else {
            parse = null;
        }
        saved2DashboardItemView.setThumbnailUri(parse);
        int b = baseQueryDAO.b();
        this.f9606l.setOnClickListener(this.f9607m.a(baseQueryDAO, b));
        this.f9606l.setActionButtonOnClickListener(this.f9608n.a(baseQueryDAO, b));
        if (this.f9609o.f9589a != null) {
            this.f9609o.f9589a.l();
            this.f9609o.f9589a = null;
        }
        Saved2DashboardItemView saved2DashboardItemView2 = this.f9606l;
        if (baseQueryDAO.t()) {
            drawable = this.f9610p;
        }
        saved2DashboardItemView2.setOverlayDrawable(drawable);
        this.f9606l.f9595h = new C14321(this);
    }
}
