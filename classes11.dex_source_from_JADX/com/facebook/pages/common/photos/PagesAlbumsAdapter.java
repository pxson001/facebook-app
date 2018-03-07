package com.facebook.pages.common.photos;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.graphql.model.GraphQLAlbumsConnection;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.photos.PagesAlbumsListFragment.C02386;
import com.facebook.pages.common.photos.PagesAlbumsListFragment.C02397;
import com.facebook.photos.albumcreator.AlbumCreatorIntentBuilder;
import com.facebook.photos.albumcreator.AlbumCreatorSourceType;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Preconditions;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: settings_phone_acquisition */
public class PagesAlbumsAdapter extends Adapter<PagesAlbumsAdapterBaseViewHolder> {
    public static final CallerContext f1701a = CallerContext.a(PagesAlbumsAdapter.class, "pages_public_view");
    private DefaultTimeFormatUtil f1702b;
    private Context f1703c;
    private List<GraphQLAlbum> f1704d;
    private boolean f1705e = false;
    private C02397 f1706f;
    private C02386 f1707g;
    private LayoutInflater f1708h;

    /* compiled from: settings_phone_acquisition */
    public class PagesAlbumsAdapterBaseViewHolder extends ViewHolder {
        public FbDraweeView f1693o;
        public TextView f1694p;
        public TextView f1695q;
        public TextView f1696r;

        public PagesAlbumsAdapterBaseViewHolder(View view) {
            super(view);
            this.f1693o = (FbDraweeView) FindViewUtil.b(view, 2131565367);
            this.f1694p = (TextView) FindViewUtil.b(view, 2131565368);
            this.f1695q = (TextView) FindViewUtil.b(view, 2131565369);
            this.f1696r = (TextView) FindViewUtil.b(view, 2131565370);
        }
    }

    /* compiled from: settings_phone_acquisition */
    public class AlbumViewHolder extends PagesAlbumsAdapterBaseViewHolder implements OnClickListener {
        protected int f1697l = -1;
        @Nullable
        protected String f1698m = null;
        @Nullable
        protected C02397 f1699n = null;

        public AlbumViewHolder(View view) {
            super(view);
        }

        public AlbumViewHolder(View view, C02397 c02397) {
            super(view);
            Preconditions.checkNotNull(c02397);
            this.f1699n = c02397;
            view.setOnClickListener(this);
        }

        public final void m2512a(GraphQLAlbum graphQLAlbum, int i, Context context, DefaultTimeFormatUtil defaultTimeFormatUtil) {
            String str;
            int a;
            this.f1697l = i;
            String u = !StringUtil.a(graphQLAlbum.u()) ? graphQLAlbum.u() : null;
            if (graphQLAlbum.j() == null || graphQLAlbum.j().af() == null || StringUtil.a(graphQLAlbum.j().af().b())) {
                str = null;
            } else {
                str = graphQLAlbum.j().af().b();
            }
            CharSequence a2 = (graphQLAlbum.E() == null || StringUtil.a(graphQLAlbum.E().a())) ? "" : graphQLAlbum.E().a();
            if (graphQLAlbum.C() != null) {
                a = graphQLAlbum.C().a();
            } else {
                a = 0;
            }
            long z = graphQLAlbum.z();
            CharSequence a3 = (graphQLAlbum.y() == null || StringUtil.a(graphQLAlbum.y().a())) ? "" : graphQLAlbum.y().a();
            if (u != null) {
                this.f1698m = u;
                this.a.setClickable(true);
            } else {
                this.f1698m = null;
                this.a.setClickable(false);
            }
            if (str != null) {
                this.f1693o.a(Uri.parse(str), PagesAlbumsAdapter.f1701a);
            } else {
                this.f1693o.setImageResource(2130839460);
            }
            this.f1694p.setText(a2);
            this.f1695q.setText(m2510a(a, context) + " · " + m2511a(z, defaultTimeFormatUtil));
            this.f1696r.setText(a3);
        }

        private static String m2510a(int i, Context context) {
            if (i == 0) {
                return context.getResources().getString(2131234347);
            }
            if (i > 0) {
                return context.getResources().getQuantityString(2131689584, i, new Object[]{Integer.valueOf(i)});
            }
            throw new IllegalArgumentException("Invalid album size " + i);
        }

        private static String m2511a(long j, DefaultTimeFormatUtil defaultTimeFormatUtil) {
            if (j == 0) {
                return "";
            }
            return defaultTimeFormatUtil.a(TimeFormatStyle.STREAM_RELATIVE_STYLE, 1000 * j);
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2088543647);
            if (this.f1699n != null) {
                this.f1699n.m2533a(this.f1698m, this.f1694p.getText().toString(), this.f1697l);
                LogUtils.a(-281302520, a);
                return;
            }
            NullPointerException nullPointerException = new NullPointerException("Set AlbumViewHolder with null onClickAlbumListener as View.OnClickListener");
            LogUtils.a(-789728121, a);
            throw nullPointerException;
        }
    }

    /* compiled from: settings_phone_acquisition */
    public class CreateAlbumViewHolder extends PagesAlbumsAdapterBaseViewHolder implements OnClickListener {
        protected C02386 f1700l;

        public CreateAlbumViewHolder(View view, C02386 c02386) {
            super(view);
            Preconditions.checkNotNull(c02386);
            this.f1700l = c02386;
            view.setOnClickListener(this);
            Context context = view.getContext();
            this.f1693o.setScaleType(ScaleType.CENTER_INSIDE);
            this.f1693o.setImageResource(2130837631);
            this.f1694p.setText(context.getResources().getString(2131234349));
            this.f1695q.setText("");
            this.f1696r.setText("");
        }

        public void onClick(View view) {
            Intent intent;
            int a = Logger.a(2, EntryType.UI_INPUT_START, 421315210);
            C02386 c02386 = this.f1700l;
            ((PagesAnalytics) c02386.f1718a.ap.get()).j(Long.parseLong(c02386.f1718a.aB), "redesign_albums_list");
            PagesAlbumsListFragment pagesAlbumsListFragment = c02386.f1718a;
            ComposerTargetData composerTargetData = c02386.f1718a.aE;
            ViewerContext at = PagesAlbumsListFragment.at(pagesAlbumsListFragment);
            if (at == null || !at.mIsPageContext || composerTargetData == null || !composerTargetData.a()) {
                ((AbstractFbErrorReporter) pagesAlbumsListFragment.al.get()).b("getCreateAlbumIntent", "not page context");
                intent = null;
            } else {
                intent = ((AlbumCreatorIntentBuilder) pagesAlbumsListFragment.f1731i.get()).a(AlbumCreatorSourceType.ALBUMSTAB, at, composerTargetData);
            }
            Intent intent2 = intent;
            if (intent2 != null) {
                ((SecureContextHelper) c02386.f1718a.an.get()).a(intent2, c02386.f1718a.getContext());
            }
            Logger.a(2, EntryType.UI_INPUT_END, -752312578, a);
        }
    }

    /* compiled from: settings_phone_acquisition */
    public enum ViewType {
        CREATE_ALBUM,
        ALBUM
    }

    public final void m2517a(ViewHolder viewHolder, int i) {
        PagesAlbumsAdapterBaseViewHolder pagesAlbumsAdapterBaseViewHolder = (PagesAlbumsAdapterBaseViewHolder) viewHolder;
        int itemViewType = getItemViewType(i);
        if (itemViewType == ViewType.ALBUM.ordinal()) {
            int e = m2514e(i);
            ((AlbumViewHolder) pagesAlbumsAdapterBaseViewHolder).m2512a((GraphQLAlbum) this.f1704d.get(e), e, this.f1703c, this.f1702b);
        } else if (itemViewType != ViewType.CREATE_ALBUM.ordinal()) {
            throw new IllegalArgumentException("Invalid view Holder " + pagesAlbumsAdapterBaseViewHolder);
        }
    }

    @Inject
    public PagesAlbumsAdapter(DefaultTimeFormatUtil defaultTimeFormatUtil, @Assisted Context context, @Assisted List<GraphQLAlbum> list, @Assisted boolean z, @Nullable @Assisted OnClickAlbumListener onClickAlbumListener, @Nullable @Assisted OnClickCreateAlbumListener onClickCreateAlbumListener) {
        boolean z2 = false;
        Preconditions.checkNotNull(list);
        if (!(z && onClickCreateAlbumListener == null)) {
            z2 = true;
        }
        Preconditions.checkArgument(z2, "canViewerAddAlbum without providing onClickCreateAlbumListener");
        this.f1702b = defaultTimeFormatUtil;
        this.f1703c = context;
        this.f1704d = list;
        this.f1705e = z;
        this.f1706f = onClickAlbumListener;
        this.f1707g = onClickCreateAlbumListener;
        this.f1708h = LayoutInflater.from(this.f1703c);
    }

    public final void m2518a(GraphQLAlbumsConnection graphQLAlbumsConnection) {
        if (graphQLAlbumsConnection.a() != null && !graphQLAlbumsConnection.a().isEmpty()) {
            this.f1704d.addAll(graphQLAlbumsConnection.a());
        }
    }

    public final void m2519d() {
        this.f1704d.clear();
    }

    public final int aZ_() {
        return this.f1704d.size() + m2513e();
    }

    public int getItemViewType(int i) {
        if (i == 0 && m2515f()) {
            return ViewType.CREATE_ALBUM.ordinal();
        }
        return ViewType.ALBUM.ordinal();
    }

    public final ViewHolder m2516a(ViewGroup viewGroup, int i) {
        View inflate = this.f1708h.inflate(2130905967, viewGroup, false);
        switch (ViewType.values()[i]) {
            case ALBUM:
                if (this.f1706f != null) {
                    return new AlbumViewHolder(inflate, this.f1706f);
                }
                return new AlbumViewHolder(inflate);
            case CREATE_ALBUM:
                return new CreateAlbumViewHolder(inflate, this.f1707g);
            default:
                throw new IllegalArgumentException("Invalid viewType " + i);
        }
    }

    private int m2514e(int i) {
        return i - m2513e();
    }

    private int m2513e() {
        return m2515f() ? 1 : 0;
    }

    private boolean m2515f() {
        return this.f1705e && this.f1707g != null;
    }
}
