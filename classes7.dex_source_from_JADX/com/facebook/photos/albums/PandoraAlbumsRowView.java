package com.facebook.photos.albums;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import com.facebook.auth.module.ViewerContextMethodAutoProvider;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.photos.albumcreator.AlbumCreatorIntentBuilder;
import com.facebook.photos.albumcreator.AlbumCreatorSourceType;
import com.facebook.photos.albums.events.AlbumsEventBus;
import com.facebook.photos.albums.events.AlbumsEvents.AlbumSelectedEvent;
import com.facebook.photos.albums.events.AlbumsEvents.VideoAlbumSelectedEvent;
import com.facebook.photos.albums.util.PandoraAlbumItemCountUtil;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomFrameLayout;
import javax.inject.Inject;

/* compiled from: main_info */
public class PandoraAlbumsRowView extends CustomFrameLayout implements OnTouchListener {
    private VideoAlbumPosition f9365A;
    public double f9366a = -1.0d;
    public FbTextView f9367b;
    public FbTextView f9368c;
    protected GraphQLAlbum f9369d;
    protected GraphQLAlbum f9370e;
    protected AlbumsEventBus f9371f;
    public PandoraAlbumLinesHeaderView f9372g;
    public PandoraAlbumLinesHeaderView f9373h;
    public PandoraAlbumUploadButtonView f9374i;
    protected String f9375j;
    public double f9376k = -1.0d;
    public double f9377l = -1.0d;
    public double f9378m = -1.0d;
    public int f9379n = 0;
    public AlbumsRowView f9380o;
    public FbTextView f9381p;
    public FbTextView f9382q;
    private int f9383r = -1;
    public Lazy<SecureContextHelper> f9384s;
    public Lazy<AlbumCreatorIntentBuilder> f9385t;
    public Lazy<PagesAnalytics> f9386u;
    public ViewerContext f9387v;
    private RTLUtil f9388w;
    private boolean f9389x;
    public String f9390y;
    public boolean f9391z = false;

    /* compiled from: main_info */
    public class C07621 implements OnClickListener {
        final /* synthetic */ PandoraAlbumsRowView f9364a;

        public C07621(PandoraAlbumsRowView pandoraAlbumsRowView) {
            this.f9364a = pandoraAlbumsRowView;
        }

        public void onClick(View view) {
            ViewerContext viewerContext;
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1133261570);
            if (this.f9364a.f9391z) {
                ((PagesAnalytics) this.f9364a.f9386u.get()).m10957j(Long.parseLong(this.f9364a.f9390y), "pandora_albums_grid");
            }
            AlbumCreatorIntentBuilder albumCreatorIntentBuilder = (AlbumCreatorIntentBuilder) this.f9364a.f9385t.get();
            AlbumCreatorSourceType albumCreatorSourceType = AlbumCreatorSourceType.ALBUMSTAB;
            if (this.f9364a.f9387v.mIsPageContext) {
                viewerContext = this.f9364a.f9387v;
            } else {
                viewerContext = null;
            }
            ((SecureContextHelper) this.f9364a.f9384s.get()).a(albumCreatorIntentBuilder.m11325a(albumCreatorSourceType, viewerContext), this.f9364a.getContext());
            LogUtils.a(396785980, a);
        }
    }

    /* compiled from: main_info */
    public enum VideoAlbumPosition {
        NONE,
        LEFT,
        RIGHT
    }

    public static void m11361a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PandoraAlbumsRowView) obj).m11360a(AlbumsEventBus.m11400a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 968), IdBasedLazy.a(fbInjector, 9243), IdBasedSingletonScopeProvider.b(fbInjector, 8930), ViewerContextMethodAutoProvider.b(fbInjector), RTLUtil.a(fbInjector));
    }

    public PandoraAlbumsRowView(Context context) {
        super(context);
        setContentView(2130906136);
        Class cls = PandoraAlbumsRowView.class;
        m11361a((Object) this, getContext());
        this.f9376k = (double) getResources().getDisplayMetrics().widthPixels;
        this.f9377l = (double) getResources().getDimensionPixelSize(2131429444);
        this.f9378m = (double) getResources().getDimensionPixelSize(2131429445);
        this.f9366a = (this.f9376k - ((double) (getResources().getDimensionPixelSize(2131429451) * 3))) / 2.0d;
        if (VERSION.SDK_INT < 11) {
            this.f9379n = getResources().getDimensionPixelSize(2131429449);
        }
        setOnTouchListener(this);
        this.f9372g = (PandoraAlbumLinesHeaderView) findViewById(2131565772);
        this.f9373h = (PandoraAlbumLinesHeaderView) findViewById(2131565773);
        ViewCompat.b((LinearLayout) findViewById(2131565774), getResources().getDimensionPixelSize(2131429451), (((int) this.f9366a) + getResources().getDimensionPixelSize(2131429454)) + this.f9379n, 0, getResources().getDimensionPixelSize(2131429455) + this.f9379n);
        this.f9368c = (FbTextView) findViewById(2131565776);
        this.f9368c.setMaxWidth((int) (this.f9366a - (this.f9378m * 2.0d)));
        this.f9367b = (FbTextView) findViewById(2131565775);
        this.f9367b.setMaxWidth((int) (this.f9366a - (this.f9378m * 2.0d)));
        ViewCompat.b((LinearLayout) findViewById(2131565777), ((int) this.f9366a) + (getResources().getDimensionPixelSize(2131429451) * 2), (((int) this.f9366a) + getResources().getDimensionPixelSize(2131429454)) + this.f9379n, 0, getResources().getDimensionPixelSize(2131429455) + this.f9379n);
        this.f9382q = (FbTextView) findViewById(2131565779);
        this.f9382q.setMaxWidth((int) (this.f9366a - (this.f9378m * 2.0d)));
        this.f9381p = (FbTextView) findViewById(2131565778);
        this.f9381p.setMaxWidth((int) (this.f9366a - (this.f9378m * 2.0d)));
        this.f9380o = (AlbumsRowView) findViewById(2131565780);
        this.f9374i = (PandoraAlbumUploadButtonView) findViewById(2131565771);
        ViewCompat.b(this.f9374i, getResources().getDimensionPixelSize(2131429451), 0, 0, 0);
        this.f9374i.setOnClickListener(new C07621(this));
        this.f9380o.bringToFront();
        this.f9374i.bringToFront();
        this.f9372g.bringToFront();
        this.f9367b.bringToFront();
        this.f9368c.bringToFront();
        this.f9373h.bringToFront();
        this.f9381p.bringToFront();
        this.f9382q.bringToFront();
    }

    @Inject
    private void m11360a(AlbumsEventBus albumsEventBus, Lazy<SecureContextHelper> lazy, Lazy<AlbumCreatorIntentBuilder> lazy2, Lazy<PagesAnalytics> lazy3, ViewerContext viewerContext, RTLUtil rTLUtil) {
        this.f9371f = albumsEventBus;
        this.f9384s = lazy;
        this.f9385t = lazy2;
        this.f9386u = lazy3;
        this.f9387v = viewerContext;
        this.f9375j = viewerContext.mUserId;
        this.f9388w = rTLUtil;
    }

    public final void m11363a(int i, String str, boolean z, GraphQLAlbum graphQLAlbum, GraphQLAlbum graphQLAlbum2, boolean z2, VideoAlbumPosition videoAlbumPosition) {
        this.f9383r = i;
        this.f9369d = graphQLAlbum;
        this.f9370e = graphQLAlbum2;
        this.f9389x = z2;
        this.f9390y = str;
        this.f9391z = z;
        this.f9365A = videoAlbumPosition;
        this.f9380o.m11349a();
        this.f9380o.invalidate();
        this.f9380o.m11350a(graphQLAlbum, graphQLAlbum2, this.f9389x, getResources().getDimensionPixelSize(2131429451), getResources().getDimensionPixelSize(2131429452) + this.f9379n);
        if (this.f9365A == VideoAlbumPosition.LEFT || !(graphQLAlbum == null || graphQLAlbum.E() == null || graphQLAlbum.E().a() == null)) {
            if (this.f9365A == VideoAlbumPosition.LEFT) {
                this.f9374i.setVisibility(8);
                this.f9367b.setVisibility(0);
                this.f9372g.setVisibility(0);
                this.f9367b.setText(2131234348);
            } else {
                this.f9374i.setVisibility(8);
                this.f9367b.setVisibility(0);
                this.f9372g.setVisibility(0);
                this.f9367b.setText(graphQLAlbum.E().a());
                if (graphQLAlbum.w() != null) {
                    this.f9368c.setVisibility(0);
                    this.f9368c.setText(PandoraAlbumItemCountUtil.m11419a(graphQLAlbum, getContext()));
                }
            }
            this.f9368c.setVisibility(8);
        } else {
            this.f9367b.setText("");
            this.f9368c.setText("");
            this.f9367b.setVisibility(8);
            this.f9368c.setVisibility(8);
            this.f9372g.setVisibility(8);
            this.f9374i.setVisibility(0);
            this.f9374i.bringToFront();
        }
        if (this.f9365A == VideoAlbumPosition.RIGHT || !(graphQLAlbum2 == null || graphQLAlbum2.E() == null || graphQLAlbum2.E().a() == null)) {
            if (this.f9365A == VideoAlbumPosition.RIGHT) {
                this.f9381p.setVisibility(0);
                this.f9373h.setVisibility(0);
                this.f9381p.setText(2131234348);
            } else {
                this.f9381p.setVisibility(0);
                this.f9373h.setVisibility(0);
                this.f9381p.setText(graphQLAlbum2.E().a());
                if (graphQLAlbum2.w() != null) {
                    this.f9382q.setVisibility(0);
                    this.f9382q.setText(PandoraAlbumItemCountUtil.m11419a(graphQLAlbum2, getContext()));
                }
            }
            this.f9382q.setVisibility(8);
        } else {
            this.f9381p.setText("");
            this.f9382q.setText("");
            this.f9381p.setVisibility(8);
            this.f9382q.setVisibility(8);
            this.f9373h.setVisibility(8);
        }
        if (this.f9375j.contentEquals(str)) {
            this.f9368c.setTextColor(getResources().getColor(2131362902));
            this.f9382q.setTextColor(getResources().getColor(2131362902));
            return;
        }
        this.f9367b.setVisibility(8);
        this.f9381p.setVisibility(8);
        this.f9368c.setText(this.f9367b.getText());
        this.f9382q.setText(this.f9381p.getText());
        this.f9368c.setVisibility(0);
        this.f9382q.setVisibility(0);
        this.f9368c.setTextColor(getResources().getColor(2131362903));
        this.f9382q.setTextColor(getResources().getColor(2131362903));
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 && motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
            return false;
        }
        if (motionEvent.getAction() == 3) {
            return true;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        int rawX = (int) (motionEvent.getRawX() - ((float) iArr[0]));
        boolean a = this.f9388w.a();
        if (motionEvent.getAction() == 1) {
            if ((((double) rawX) >= this.f9366a || a) && (((double) rawX) < this.f9366a || !a)) {
                m11358a(this.f9370e, this.f9365A);
            } else {
                m11362b(this.f9369d, this.f9365A);
            }
        }
        return true;
    }

    private void m11358a(GraphQLAlbum graphQLAlbum, VideoAlbumPosition videoAlbumPosition) {
        m11359a(graphQLAlbum, videoAlbumPosition == VideoAlbumPosition.RIGHT);
    }

    private void m11362b(GraphQLAlbum graphQLAlbum, VideoAlbumPosition videoAlbumPosition) {
        m11359a(graphQLAlbum, videoAlbumPosition == VideoAlbumPosition.LEFT);
    }

    private void m11359a(GraphQLAlbum graphQLAlbum, boolean z) {
        if (graphQLAlbum != null && this.f9371f != null) {
            if (z) {
                this.f9371f.a(new VideoAlbumSelectedEvent());
            } else {
                this.f9371f.a(new AlbumSelectedEvent(graphQLAlbum, graphQLAlbum.u()));
            }
            if (this.f9391z) {
                String a;
                int i;
                PagesAnalytics pagesAnalytics = (PagesAnalytics) this.f9386u.get();
                long parseLong = Long.parseLong(this.f9390y);
                String u = graphQLAlbum.u();
                if (graphQLAlbum.E() != null) {
                    a = graphQLAlbum.E().a();
                } else {
                    a = null;
                }
                if (graphQLAlbum == this.f9369d) {
                    i = this.f9383r;
                } else {
                    i = this.f9383r + 1;
                }
                pagesAnalytics.m10930a(parseLong, u, a, i, "pandora_albums_grid", z);
            }
        }
    }
}
