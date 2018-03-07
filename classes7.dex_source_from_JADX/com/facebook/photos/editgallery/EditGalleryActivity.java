package com.facebook.photos.editgallery;

import android.content.Context;
import android.content.Intent;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.view.ViewStub;
import android.widget.ProgressBar;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.bitmaps.BitmapUtils;
import com.facebook.bitmaps.Dimension;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.SizeUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.ipc.editgallery.EditGalleryIpcBundle;
import com.facebook.ipc.editgallery.EditGalleryIpcBundle.Builder;
import com.facebook.ipc.editgallery.EditGalleryLaunchConfiguration;
import com.facebook.ipc.editgallery.EntryPoint;
import com.facebook.photos.creativeediting.analytics.CreativeEditingUsageLogger;
import com.facebook.photos.creativeediting.analytics.CreativeEditingUsageLoggerProvider;
import com.facebook.photos.creativeediting.model.CreativeEditingData;
import com.facebook.photos.creativeediting.utilities.MediaRotationHelper;
import com.facebook.photos.editgallery.EditGalleryFragmentManager.EditGalleryCallback;
import com.facebook.photos.editgallery.EditGalleryFragmentManager.UsageParams;
import com.facebook.photos.editgallery.utils.FetchImageUtils;
import com.facebook.timeline.tempprofilepic.model.ExpirationState;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: legacy_activity_api_id */
public final class EditGalleryActivity extends FbFragmentActivity {
    public static final RectF f10243p = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
    public String f10244A;
    public EntryPoint f10245B;
    public String f10246C;
    public final EditGalleryCallback f10247q = new C08631(this);
    public EditGalleryFragmentManager f10248r;
    public Uri f10249s;
    private BitmapUtils f10250t;
    public MediaRotationHelper f10251u;
    public Lazy<FbErrorReporter> f10252v;
    private FetchImageUtils f10253w;
    public CreativeEditingData f10254x;
    private CreativeEditingUsageLoggerProvider f10255y;
    public CreativeEditingUsageLogger f10256z;

    /* compiled from: legacy_activity_api_id */
    class C08631 implements EditGalleryCallback {
        final /* synthetic */ EditGalleryActivity f10240a;

        C08631(EditGalleryActivity editGalleryActivity) {
            this.f10240a = editGalleryActivity;
        }

        public final void mo221a(CreativeEditingData creativeEditingData) {
            Preconditions.checkNotNull(creativeEditingData);
            this.f10240a.f10254x = creativeEditingData;
        }

        public final int mo220a(int i) {
            this.f10240a.f10251u.a(this.f10240a.f10249s, i);
            return 0;
        }

        public final void mo222a(UsageParams usageParams, ExpirationState expirationState, boolean z) {
            if (z) {
                Uri uri;
                int a;
                RectF rectF;
                if (this.f10240a.f10254x == null) {
                    uri = this.f10240a.f10249s;
                    a = this.f10240a.f10251u.a(this.f10240a.f10249s);
                    rectF = EditGalleryActivity.f10243p;
                } else {
                    Uri o = this.f10240a.f10254x.o() == null ? this.f10240a.f10249s : this.f10240a.f10254x.o();
                    if (this.f10240a.f10254x.o() == null) {
                        a = this.f10240a.f10251u.a(this.f10240a.f10249s);
                    } else {
                        a = this.f10240a.f10251u.a(this.f10240a.f10254x.o());
                    }
                    uri = o;
                    rectF = this.f10240a.f10254x.c();
                }
                Builder builder = new Builder();
                builder.a = uri;
                Builder builder2 = builder;
                builder2.b = a;
                Builder builder3 = builder2;
                builder3.c = this.f10240a.f10246C;
                builder3 = builder3;
                builder3.d = this.f10240a.f10254x;
                builder3 = builder3;
                builder3.e = this.f10240a.f10244A;
                builder3 = builder3;
                builder3.f = rectF;
                EditGalleryIpcBundle a2 = builder3.a();
                Intent intent = new Intent();
                intent.putExtra(EditGalleryIpcBundle.a, a2);
                intent.putExtra("extra_profile_pic_expiration", expirationState.d);
                this.f10240a.setResult(-1, intent);
            } else {
                this.f10240a.setResult(0);
            }
            this.f10240a.f10256z.m11492a(this.f10240a.f10244A, EditGalleryUsageLoggingUtils.m12203a(this.f10240a.f10254x, this.f10240a.f10245B, usageParams, z, this.f10240a.f10251u.a(this.f10240a.f10249s)));
            this.f10240a.finish();
        }
    }

    private static <T extends Context> void m12118a(Class<T> cls, T t) {
        m12119a((Object) t, (Context) t);
    }

    public static void m12119a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((EditGalleryActivity) obj).m12117a(BitmapUtils.a(fbInjector), MediaRotationHelper.b(fbInjector), FetchImageUtils.m12376b(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 494), (CreativeEditingUsageLoggerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(CreativeEditingUsageLoggerProvider.class));
    }

    @Inject
    private void m12117a(BitmapUtils bitmapUtils, MediaRotationHelper mediaRotationHelper, FetchImageUtils fetchImageUtils, Lazy<FbErrorReporter> lazy, CreativeEditingUsageLoggerProvider creativeEditingUsageLoggerProvider) {
        this.f10250t = bitmapUtils;
        this.f10251u = mediaRotationHelper;
        this.f10253w = fetchImageUtils;
        this.f10252v = lazy;
        this.f10255y = creativeEditingUsageLoggerProvider;
    }

    protected final void m12131a(@Nullable Bundle bundle) {
        super.a(bundle);
        setContentView(2130903935);
    }

    public final void m12132b(Bundle bundle) {
        super.b(bundle);
        Class cls = EditGalleryActivity.class;
        m12119a((Object) this, (Context) this);
        this.f10248r = new EditGalleryFragmentManager(kO_());
        Bundle extras = getIntent().getExtras();
        final EditGalleryLaunchConfiguration editGalleryLaunchConfiguration = (EditGalleryLaunchConfiguration) extras.getParcelable("extra_edit_gallery_launch_settings");
        this.f10249s = editGalleryLaunchConfiguration.a;
        this.f10254x = editGalleryLaunchConfiguration.j;
        this.f10244A = editGalleryLaunchConfiguration.b;
        this.f10246C = editGalleryLaunchConfiguration.g;
        this.f10245B = EntryPoint.valueOf(extras.getString("extra_edit_gallery_entry_point_name"));
        this.f10256z = this.f10255y.m11493a(this.f10246C);
        if (bundle != null) {
            this.f10248r.m12202a(this.f10247q);
        } else if (Strings.isNullOrEmpty(this.f10249s.getHost())) {
            float a = m12113a(this, this.f10249s);
            int a2 = SizeUtil.a(this, getResources().getDimension(2131431919));
            this.f10248r.m12201a(this.f10249s, a2, (int) (((float) a2) / a), editGalleryLaunchConfiguration, this.f10247q, null, null);
        } else {
            ((ViewStub) findViewById(2131561101)).inflate();
            this.f10253w.m12378a(this, this.f10249s, new AbstractDisposableFutureCallback<Uri>(this) {
                final /* synthetic */ EditGalleryActivity f10242b;

                protected final void m12111a(Object obj) {
                    Uri uri = (Uri) obj;
                    Preconditions.checkNotNull(uri);
                    ((ProgressBar) this.f10242b.findViewById(2131561127)).setVisibility(8);
                    this.f10242b.f10249s = uri;
                    int a = SizeUtil.a(this.f10242b, this.f10242b.getResources().getDimension(2131431919));
                    this.f10242b.f10248r.m12201a(this.f10242b.f10249s, a, (int) (((float) a) / EditGalleryActivity.m12113a(this.f10242b, this.f10242b.f10249s)), editGalleryLaunchConfiguration, this.f10242b.f10247q, null, null);
                }

                protected final void m12112a(Throwable th) {
                    ((AbstractFbErrorReporter) this.f10242b.f10252v.get()).b(getClass().getSimpleName(), "Failed to save photo to file", th);
                    this.f10242b.finish();
                }
            });
        }
    }

    public static float m12113a(EditGalleryActivity editGalleryActivity, Uri uri) {
        Preconditions.checkNotNull(uri);
        int a = editGalleryActivity.f10251u.a(uri);
        Dimension a2 = BitmapUtils.a(uri.getPath());
        if (a2 == null || a2.a == 0) {
            return 1.0f;
        }
        float f = ((float) a2.b) / ((float) a2.a);
        if (a % 180 != 0) {
            return 1.0f / f;
        }
        return f;
    }
}
