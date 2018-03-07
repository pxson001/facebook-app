package com.facebook.friendsharing.souvenirs.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.DataSourceToFutureAdapter;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.drawable.FadeDrawable;
import com.facebook.friendsharing.souvenirs.protocols.FetchSouvenirsModels.SouvenirsMediaElementFieldsModel;
import com.facebook.friendsharing.souvenirs.protocols.FetchSouvenirsModels.SouvenirsMediaElementFieldsModel.SouvenirMediaModel.EdgesModel;
import com.facebook.graphql.enums.GraphQLSouvenirMediaFieldType;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: RECOVERY_FROM_UNCAUGHT_EXCEPTION */
public class SouvenirsBurstView extends ImageView {
    public static final CallerContext f24195a = CallerContext.a(SouvenirsBurstView.class, "souvenirs");
    public ImagePipeline f24196b;
    public TasksManager f24197c;
    public FadeDrawable f24198d;
    public int f24199e = 0;
    public int f24200f = 0;
    public int f24201g;
    public int f24202h;
    public String f24203i;
    public final Paint f24204j = new Paint();
    public final Paint f24205k = new Paint();
    private final Rect f24206l = new Rect();
    public SouvenirsMediaElementFieldsModel f24207m;
    public List<CloseableReference<CloseableImage>> f24208n;

    /* compiled from: RECOVERY_FROM_UNCAUGHT_EXCEPTION */
    class C21062 extends AbstractDisposableFutureCallback<List<CloseableReference<CloseableImage>>> {
        final /* synthetic */ SouvenirsBurstView f24194a;

        C21062(SouvenirsBurstView souvenirsBurstView) {
            this.f24194a = souvenirsBurstView;
        }

        protected final void m26444a(Object obj) {
            List list = (List) obj;
            if (list != null && !list.isEmpty()) {
                Drawable[] drawableArr;
                this.f24194a.f24208n = list;
                Drawable[] drawableArr2 = new BitmapDrawable[list.size()];
                this.f24194a.f24200f = list.size();
                this.f24194a.f24203i = String.valueOf(this.f24194a.f24200f);
                int i = 0;
                while (i < list.size()) {
                    if (!(list.get(i) == null || ((CloseableReference) list.get(i)).a() == null)) {
                        drawableArr2[i] = new BitmapDrawable(this.f24194a.getResources(), ((CloseableBitmap) ((CloseableReference) list.get(i)).a()).a());
                        drawableArr2[i].setGravity(17);
                    }
                    i++;
                }
                SouvenirsBurstView souvenirsBurstView = this.f24194a;
                if (drawableArr2.length <= 0 || drawableArr2[drawableArr2.length - 1] != null) {
                    drawableArr = drawableArr2;
                } else {
                    int i2 = 0;
                    while (i2 < drawableArr2.length && drawableArr2[i2] != null) {
                        i2++;
                    }
                    BitmapDrawable[] bitmapDrawableArr = (BitmapDrawable[]) Arrays.copyOf(drawableArr2, i2);
                }
                souvenirsBurstView.f24198d = new FadeDrawable(drawableArr);
                this.f24194a.f24198d.c(500);
                this.f24194a.setImageDrawable(this.f24194a.f24198d);
            }
        }

        protected final void m26445a(Throwable th) {
        }
    }

    public static void m26446a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        SouvenirsBurstView souvenirsBurstView = (SouvenirsBurstView) obj;
        ImagePipeline a = ImagePipelineMethodAutoProvider.a(fbInjector);
        TasksManager b = TasksManager.b(fbInjector);
        souvenirsBurstView.f24196b = a;
        souvenirsBurstView.f24197c = b;
    }

    public SouvenirsBurstView(Context context) {
        super(context);
        Class cls = SouvenirsBurstView.class;
        m26446a(this, getContext());
        Resources resources = getResources();
        this.f24202h = resources.getDimensionPixelSize(2131432489);
        this.f24201g = resources.getDimensionPixelSize(2131432490);
        this.f24204j.setColor(resources.getColor(2131363643));
        this.f24204j.setAntiAlias(true);
        this.f24205k.setColor(-1);
        this.f24205k.setTextSize((float) resources.getDimensionPixelSize(2131432491));
        this.f24205k.setAntiAlias(true);
        this.f24205k.setTextAlign(Align.CENTER);
    }

    public final void m26449a() {
        if (this.f24198d != null) {
            if (this.f24199e >= this.f24200f) {
                this.f24199e = 0;
            }
            FadeDrawable fadeDrawable = this.f24198d;
            int i = this.f24199e;
            this.f24199e = i + 1;
            fadeDrawable.g(i);
        }
    }

    public final void m26450a(SouvenirsMediaElementFieldsModel souvenirsMediaElementFieldsModel) {
        if (souvenirsMediaElementFieldsModel != null && souvenirsMediaElementFieldsModel.m26330d() == GraphQLSouvenirMediaFieldType.BURST) {
            this.f24207m = souvenirsMediaElementFieldsModel;
            setImageDrawable(null);
            this.f24199e = 0;
            this.f24200f = 0;
            Iterable a = Lists.a();
            ImmutableList a2 = souvenirsMediaElementFieldsModel.m26329c().m26322a();
            int size = a2.size();
            for (int i = 0; i < size; i++) {
                EdgesModel edgesModel = (EdgesModel) a2.get(i);
                if (edgesModel.m26317a() != null) {
                    DefaultImageFields bc_ = edgesModel.m26317a().bc_();
                    if (!(bc_ == null || bc_.b() == null)) {
                        ImageRequestBuilder a3 = ImageRequestBuilder.a(Uri.parse(bc_.b()));
                        a3.d = new ResizeOptions(400, 400);
                        a3 = a3;
                        a3.c = true;
                        a.add(DataSourceToFutureAdapter.a(this.f24196b.c(a3.m(), f24195a)));
                    }
                }
            }
            final ListenableFuture b = Futures.b(a);
            this.f24197c.a("fetching_media_for_" + souvenirsMediaElementFieldsModel.m26328b(), new Callable<ListenableFuture<List<CloseableReference<CloseableImage>>>>(this) {
                final /* synthetic */ SouvenirsBurstView f24193b;

                public Object call() {
                    return b;
                }
            }, new C21062(this));
        }
    }

    public void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1869241138);
        super.onAttachedToWindow();
        m26447e();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 797683486, a);
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        m26447e();
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        m26448f();
    }

    public void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1606170358);
        super.onDetachedFromWindow();
        m26448f();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1097051184, a);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f24198d != null) {
            int width = (canvas.getWidth() - this.f24201g) - this.f24202h;
            int height = (canvas.getHeight() - this.f24201g) - this.f24202h;
            canvas.drawCircle((float) width, (float) height, (float) this.f24201g, this.f24204j);
            this.f24205k.getTextBounds(this.f24203i, 0, this.f24203i.length(), this.f24206l);
            canvas.drawText(this.f24203i, (float) width, ((float) height) - this.f24206l.exactCenterY(), this.f24205k);
        }
    }

    private void m26447e() {
        if (this.f24207m != null) {
            m26450a(this.f24207m);
        }
    }

    private void m26448f() {
        if (this.f24208n != null) {
            for (CloseableReference c : this.f24208n) {
                CloseableReference.c(c);
            }
        }
        setImageDrawable(null);
    }
}
