package com.facebook.saved2.ui.itemadapters;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.support.v4.app.FragmentActivity;
import com.facebook.crudolib.dbquery.loader.inprocess.NoContentResolver;
import com.facebook.inject.Assisted;
import com.facebook.saved2.model.Saved2ItemTable;
import com.facebook.saved2.model.Saved2ItemTable_Queries.BaseQueryDAO;
import com.facebook.saved2.ui.itemadapters.Saved2HeadersAdapter.Header;
import com.facebook.video.events.VideoDownloadEventBus;
import com.facebook.video.events.VideoDownloadEvents.DownloadStatusChangeEvent;
import com.facebook.video.events.VideoDownloadEvents.DownloadStatusChangeEvent.Handler;
import com.facebook.video.events.VideoDownloadStatus.DownloadStatus;
import com.facebook.widget.recyclerview.interleaved.InterleavedRecyclerViewAdapter;
import java.util.ArrayList;
import javax.annotation.Nullable;
import javax.inject.Inject;

@SuppressLint({"BadMethodUse-java.lang.System.currentTimeMillis"})
/* compiled from: initAd must be called before startAd */
public class Saved2GroupedItemsAdapterFactory {
    private final String f9627a;
    private final Saved2DownloadItemsHelper f9628b;
    private final VideoDownloadEventBus f9629c;
    public InterleavedRecyclerViewAdapter f9630d;
    private HeaderGrouper f9631e;
    private Saved2HeadersAdapter f9632f;
    private Saved2DAOItemsAdapter f9633g;

    /* compiled from: initAd must be called before startAd */
    public interface HeaderGrouper {
        @Nullable
        ArrayList<Header> mo449a(BaseQueryDAO baseQueryDAO);
    }

    /* compiled from: initAd must be called before startAd */
    class VideoDownloadEventHandler implements Handler {
        private DownloadStatus f9626a;

        public final void m9872a(DownloadStatusChangeEvent downloadStatusChangeEvent) {
            if (this.f9626a != downloadStatusChangeEvent.a.c) {
                this.f9626a = downloadStatusChangeEvent.a.c;
                NoContentResolver.a.a(Saved2ItemTable.class);
            }
        }
    }

    @Inject
    public Saved2GroupedItemsAdapterFactory(@Assisted FragmentActivity fragmentActivity, @Assisted String str, VideoDownloadEventBus videoDownloadEventBus, Saved2DownloadItemsHelper saved2DownloadItemsHelper, Saved2DAOItemsAdapterProvider saved2DAOItemsAdapterProvider) {
        this.f9627a = str;
        this.f9628b = saved2DownloadItemsHelper;
        this.f9633g = new Saved2DAOItemsAdapter(fragmentActivity, str, (Saved2DashboardItemViewHolderProvider) saved2DAOItemsAdapterProvider.getOnDemandAssistedProviderForStaticDi(Saved2DashboardItemViewHolderProvider.class));
        this.f9629c = videoDownloadEventBus;
        Object obj = -1;
        switch (str.hashCode()) {
            case -1932444596:
                if (str.equals("PLACES")) {
                    obj = null;
                    break;
                }
                break;
            case -1763348648:
                if (str.equals("VIDEOS")) {
                    obj = 1;
                    break;
                }
                break;
            case 64897:
                if (str.equals("ALL")) {
                    obj = 2;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                this.f9631e = new GeographicalHeaderGrouper();
                break;
            case 1:
            case 2:
                this.f9629c.a(DownloadStatusChangeEvent.class, new VideoDownloadEventHandler());
                this.f9631e = new DownloadChronologicalHeaderGrouper(fragmentActivity, System.currentTimeMillis(), this.f9628b);
                break;
            default:
                this.f9631e = new ChronologicalHeaderGrouper(fragmentActivity, System.currentTimeMillis());
                break;
        }
        this.f9632f = new Saved2HeadersAdapter(fragmentActivity);
        this.f9630d = new InterleavedRecyclerViewAdapter(this.f9632f, this.f9633g);
    }

    public final void m9873a(Cursor cursor, @Nullable BaseQueryDAO baseQueryDAO) {
        if (this.f9627a.equals("VIDEOS") || this.f9627a.equals("ALL")) {
            cursor = this.f9628b.m9871a(cursor, baseQueryDAO);
        }
        this.f9633g.a(cursor, baseQueryDAO);
        if (baseQueryDAO == null) {
            Saved2HeadersAdapter saved2HeadersAdapter = this.f9632f;
            saved2HeadersAdapter.f9640c = null;
            saved2HeadersAdapter.notifyDataSetChanged();
            return;
        }
        saved2HeadersAdapter = this.f9632f;
        saved2HeadersAdapter.f9640c = this.f9631e.mo449a(baseQueryDAO);
        saved2HeadersAdapter.notifyDataSetChanged();
    }
}
