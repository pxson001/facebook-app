package com.facebook.drawee.fbpipeline;

import android.content.res.Resources;
import android.net.Uri;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.dialtone.DialtoneController;
import com.facebook.dialtone.DialtoneController.FeatureType;
import com.facebook.dialtone.DialtoneController.PlaceholderState;
import com.facebook.dialtone.UpgradeButtonDrawable;
import com.facebook.dialtone.common.DialtoneStateChangedListener;
import com.facebook.drawee.callercontext.FbDraweeCallerContext;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.imagepipeline.animated.factory.AnimatedDrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.inject.Assisted;
import com.facebook.qe.api.QeAccessor;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: privacy_option_invalid_json_null */
public class DegradableDraweeController extends FbPipelineDraweeController implements DialtoneStateChangedListener {
    Supplier<DataSource<CloseableReference<CloseableImage>>> f4208a;
    private final DialtoneController f4209b;
    private boolean f4210c;
    private Uri f4211d;
    public boolean f4212e;
    private PlaceholderState f4213f;

    @Inject
    public DegradableDraweeController(Resources resources, DeferredReleaser deferredReleaser, Executor executor, AnimatedDrawableFactory animatedDrawableFactory, DialtoneController dialtoneController, AnalyticsLogger analyticsLogger, @Assisted Supplier<DataSource<CloseableReference<CloseableImage>>> supplier, @Assisted Supplier<DataSource<CloseableReference<CloseableImage>>> supplier2, @Assisted Uri uri, @Assisted String str, @Assisted FbDraweeCallerContext fbDraweeCallerContext, QeAccessor qeAccessor) {
        super(resources, deferredReleaser, animatedDrawableFactory, analyticsLogger, executor, supplier, str, fbDraweeCallerContext, qeAccessor);
        this.f4209b = dialtoneController;
        m4722a(uri, (Supplier) supplier2);
    }

    protected final void m4728a(Supplier<DataSource<CloseableReference<CloseableImage>>> supplier, Supplier<DataSource<CloseableReference<CloseableImage>>> supplier2, Uri uri, String str, FbDraweeCallerContext fbDraweeCallerContext) {
        super.a(supplier, str, fbDraweeCallerContext);
        m4722a(uri, (Supplier) supplier2);
    }

    private void m4722a(Uri uri, Supplier<DataSource<CloseableReference<CloseableImage>>> supplier) {
        this.f4211d = uri;
        this.f4210c = false;
        this.f4212e = false;
        this.f4208a = supplier;
        m4723b(0, FeatureType.PHOTO);
    }

    private void m4723b(int i, FeatureType featureType) {
        if (!m4726t()) {
            Object obj;
            String r = m4724r();
            if (r.equals("cover_photo") || r.equals("entity_cards")) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                this.f4212e = true;
                this.f4213f = new PlaceholderState(m4724r(), i, featureType);
                a(new UpgradeButtonDrawable(this.f4209b, this.f4213f));
            }
        }
    }

    private String m4724r() {
        String b = q().b.b();
        return b.equals("unknown") ? q().b.c() : b;
    }

    private boolean m4725s() {
        return this.f4209b.j() && !m4726t();
    }

    private boolean m4726t() {
        return this.f4209b.a(this.f4211d, q().b) || this.f4209b.a(m4724r(), q().b);
    }

    public final void m4730e() {
        this.f4210c = true;
        if (m4725s()) {
            this.f4209b.a(this);
        } else if (this.f4209b.b() && m4726t() && this.f4212e) {
            this.f4212e = false;
            a(null);
        }
        super.e();
    }

    public final void m4731f() {
        this.f4210c = false;
        this.f4209b.b(this);
        super.f();
    }

    protected final DataSource<CloseableReference<CloseableImage>> m4733n() {
        return m4725s() ? (DataSource) this.f4208a.a() : super.n();
    }

    public final boolean m4729c() {
        if (!m4725s()) {
            return super.c();
        }
        return this.f4209b.a(this, this.f4211d, !this.f4209b.b(m4724r()));
    }

    protected final boolean m4732l() {
        if (this.f4213f != null && this.f4213f.c == FeatureType.LINK) {
            return false;
        }
        if (m4725s() || super.l()) {
            return true;
        }
        return false;
    }

    public final void iw_() {
    }

    public final void b_(boolean z) {
        b();
        if (this.f4210c) {
            m();
            this.f4212e = false;
            a(null);
        }
    }

    public final void m4727a(int i, FeatureType featureType) {
        m4723b(i, featureType);
    }
}
