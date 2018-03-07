package com.facebook.photos.creativeediting.swipeable.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.net.Uri;
import android.text.Html;
import android.text.TextPaint;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.DataSourceToFutureAdapter;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.time.SystemClock;
import com.facebook.common.util.StringUtil;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import com.facebook.debug.log.BLog;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.imagepipeline.module.PlatformBitmapFactoryMethodAutoProvider;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.creativeediting.model.FrameGraphQLInterfaces.Frame;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FrameModel;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FrameModel.StickerAssetsModel.NodesModel;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FrameModel.TextAssetsModel;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ultralight.Inject;
import com.facebook.widget.text.CustomFontHelper;
import com.facebook.widget.text.CustomFontHelper.FontFamily;
import com.facebook.widget.text.CustomFontHelper.FontWeight;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Singleton;

@Singleton
/* compiled from: mIconDrawable is null! resId= */
public class FrameAssetsLoader {
    private static final String f9733a = FrameAssetsLoader.class.getSimpleName();
    private static final CallerContext f9734b = CallerContext.a(FrameAssetsLoader.class, "creative_editing_in_composer");
    private static final HashSet<String> f9735c = new HashSet();
    private static volatile FrameAssetsLoader f9736k;
    @Inject
    private ImagePipeline f9737d;
    @Inject
    @ForUiThread
    private ExecutorService f9738e;
    @DefaultExecutorService
    @Inject
    private ExecutorService f9739f;
    @Inject
    private DefaultAndroidThreadUtil f9740g;
    @Inject
    private Context f9741h;
    @Inject
    private PlatformBitmapFactory f9742i;
    @Inject
    private AbstractFbErrorReporter f9743j;

    /* compiled from: mIconDrawable is null! resId= */
    public interface Listener {
        void mo509a(FrameModel frameModel);
    }

    public static com.facebook.photos.creativeediting.swipeable.common.FrameAssetsLoader m11662a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f9736k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.creativeediting.swipeable.common.FrameAssetsLoader.class;
        monitor-enter(r1);
        r0 = f9736k;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m11668b(r0);	 Catch:{ all -> 0x0035 }
        f9736k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9736k;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.creativeediting.swipeable.common.FrameAssetsLoader.a(com.facebook.inject.InjectorLike):com.facebook.photos.creativeediting.swipeable.common.FrameAssetsLoader");
    }

    private static FrameAssetsLoader m11668b(InjectorLike injectorLike) {
        FrameAssetsLoader frameAssetsLoader = new FrameAssetsLoader();
        frameAssetsLoader.m11664a(ImagePipelineMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), (Context) injectorLike.getInstance(Context.class), PlatformBitmapFactoryMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
        return frameAssetsLoader;
    }

    private void m11664a(ImagePipeline imagePipeline, ExecutorService executorService, ExecutorService executorService2, DefaultAndroidThreadUtil defaultAndroidThreadUtil, Context context, PlatformBitmapFactory platformBitmapFactory, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f9737d = imagePipeline;
        this.f9738e = executorService;
        this.f9739f = executorService2;
        this.f9740g = defaultAndroidThreadUtil;
        this.f9741h = context;
        this.f9742i = platformBitmapFactory;
        this.f9743j = abstractFbErrorReporter;
    }

    public final void m11672a(final ImmutableList<Frame> immutableList, final Listener listener) {
        ExecutorDetour.a(this.f9739f, new Runnable(this) {
            final /* synthetic */ FrameAssetsLoader f9724c;

            public void run() {
                this.f9724c.m11673b(immutableList, listener);
            }
        }, -1714186194);
    }

    public static void m11665a(FrameAssetsLoader frameAssetsLoader, final FrameModel frameModel, Uri uri, @Nullable List list, final Listener listener) {
        list.add(uri);
        if (list.size() == frameModel.bE_().a().size() && listener != null) {
            frameAssetsLoader.f9740g.b(new Runnable(frameAssetsLoader) {
                final /* synthetic */ FrameAssetsLoader f9727c;

                public void run() {
                    listener.mo509a(frameModel);
                }
            });
        }
    }

    public final ImmutableList<Frame> m11673b(ImmutableList<Frame> immutableList, @Nullable Listener listener) {
        this.f9740g.b();
        m11666a((ImmutableList) immutableList);
        Builder builder = new Builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            final FrameModel frameModel = (FrameModel) immutableList.get(i);
            m11669b(frameModel);
            final List arrayList = new ArrayList();
            Object obj = 1;
            ImmutableList a = frameModel.bE_().a();
            int size2 = a.size();
            int i2 = 0;
            while (i2 < size2) {
                boolean z;
                Object obj2;
                final Uri parse = Uri.parse(((NodesModel) a.get(i2)).d().c().b());
                if (this.f9737d.b(parse)) {
                    z = true;
                } else {
                    try {
                        z = ((Boolean) FutureDetour.a(DataSourceToFutureAdapter.a(this.f9737d.c(parse)), -828337193)).booleanValue();
                    } catch (ExecutionException e) {
                        z = false;
                    } catch (InterruptedException e2) {
                        z = false;
                    }
                }
                if (z) {
                    m11665a(this, frameModel, parse, arrayList, listener);
                    obj2 = obj;
                } else {
                    final Listener listener2 = listener;
                    this.f9737d.f(ImageRequest.a(parse), f9734b).a(new DataSubscriber<Void>(this) {
                        final /* synthetic */ FrameAssetsLoader f9732e;

                        public final void m11657a(DataSource<Void> dataSource) {
                            if (dataSource.b()) {
                                FrameAssetsLoader.m11665a(this.f9732e, frameModel, parse, arrayList, listener2);
                                dataSource.g();
                            }
                        }

                        public final void m11658b(DataSource<Void> dataSource) {
                            dataSource.g();
                        }

                        public final void m11659c(DataSource<Void> dataSource) {
                            dataSource.g();
                        }

                        public final void m11660d(DataSource<Void> dataSource) {
                        }
                    }, this.f9738e);
                    obj2 = null;
                }
                i2++;
                obj = obj2;
            }
            if (obj != null) {
                builder.c(frameModel);
            }
        }
        return builder.b();
    }

    public final void m11671a(FrameModel frameModel) {
        ImmutableList a = frameModel.bE_().a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            this.f9737d.f(ImageRequest.a(Uri.parse(((NodesModel) a.get(i)).d().c().b())), f9734b);
        }
    }

    public final File m11670a(TextAssetsModel.NodesModel nodesModel, String str) {
        return new File(m11663a(), nodesModel.d().replaceAll(" ", "").replaceAll(",", "").replaceAll("\\.", "") + "_" + nodesModel.c() + "_" + str + ".png");
    }

    private File m11663a() {
        File file = new File(this.f9741h.getExternalFilesDir(null).getPath() + "/Frames_Text");
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    private synchronized void m11669b(FrameModel frameModel) {
        if (!(frameModel.g() == null || frameModel.g().a() == null)) {
            ImmutableList a = frameModel.g().a();
            int size = a.size();
            int i = 0;
            while (i < size) {
                TextAssetsModel.NodesModel nodesModel = (TextAssetsModel.NodesModel) a.get(i);
                File a2 = m11670a(nodesModel, frameModel.c());
                if (a2.exists() || f9735c.contains(a2.getPath())) {
                    a2.setLastModified(SystemClock.b().a());
                } else {
                    try {
                        f9735c.add(a2.getPath());
                        m11667a(a2, nodesModel.d(), nodesModel.c(), frameModel.c());
                    } catch (Throwable e) {
                        BLog.b(f9733a, "i/o exception while generating frame asset", e);
                        i++;
                    } finally {
                        File file = a2;
                        file = a2;
                        file = a2;
                        i = f9735c;
                        a = a2.getPath();
                        i.remove(a);
                        i++;
                    }
                }
                i++;
            }
        }
    }

    private void m11667a(File file, String str, String str2, String str3) {
        OutputStream fileOutputStream;
        Throwable th;
        FileOutputStream fileOutputStream2;
        CloseableReference closeableReference = null;
        boolean z = true;
        this.f9740g.b();
        try {
            String obj = Html.fromHtml(str).toString();
            if (StringUtil.a(obj)) {
                this.f9743j.a(SoftError.b(f9733a, "Unexpected failure: Frame " + str3 + " has an empty text asset!"));
                return;
            }
            int parseColor;
            Typeface a = CustomFontHelper.a(this.f9741h, FontFamily.ROBOTO, FontWeight.MEDIUM, null);
            if (!str2.contains("#")) {
                str2 = "#" + str2;
            }
            try {
                parseColor = Color.parseColor(str2);
            } catch (IllegalArgumentException e) {
                parseColor = -1;
            }
            Paint textPaint = new TextPaint(3);
            textPaint.setColor(parseColor);
            textPaint.setTextSize(250.0f);
            textPaint.setTypeface(a);
            textPaint.setShadowLayer(20.0f, 10.0f, 10.0f, -16777216);
            int measureText = (int) textPaint.measureText(obj);
            int descent = ((int) textPaint.descent()) + ((int) textPaint.getTextSize());
            Preconditions.checkArgument(measureText > 0);
            if (descent <= 0) {
                z = false;
            }
            Preconditions.checkArgument(z);
            CloseableReference a2 = this.f9742i.a(measureText, descent, Config.ARGB_8888);
            try {
                ((Bitmap) a2.a()).setHasAlpha(true);
                Canvas canvas = new Canvas((Bitmap) a2.a());
                canvas.drawText(obj, 0.0f, ((float) canvas.getHeight()) - textPaint.descent(), textPaint);
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th2) {
                th = th2;
                CloseableReference closeableReference2 = a2;
                fileOutputStream2 = null;
                closeableReference = closeableReference2;
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                if (closeableReference != null) {
                    closeableReference.close();
                }
                throw th;
            }
            try {
                ((Bitmap) a2.a()).compress(CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.close();
                if (a2 != null) {
                    a2.close();
                }
            } catch (Throwable th3) {
                th = th3;
                closeableReference = a2;
                OutputStream outputStream = fileOutputStream;
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                if (closeableReference != null) {
                    closeableReference.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream2 = null;
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            if (closeableReference != null) {
                closeableReference.close();
            }
            throw th;
        }
    }

    private void m11666a(ImmutableList<Frame> immutableList) {
        File a = m11663a();
        if (a != null && a.listFiles() != null && a.listFiles().length != 0) {
            HashSet hashSet = new HashSet();
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                FrameModel frameModel = (FrameModel) immutableList.get(i);
                if (!(frameModel.g() == null || frameModel.g().a() == null)) {
                    ImmutableList a2 = frameModel.g().a();
                    int size2 = a2.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        hashSet.add(m11670a((TextAssetsModel.NodesModel) a2.get(i2), frameModel.c()));
                    }
                    for (File file : a.listFiles()) {
                        if (!hashSet.contains(file) && file.getName().contains(frameModel.c())) {
                            file.delete();
                        } else if (!hashSet.contains(file) && file.lastModified() < SystemClock.b().a() - 1209600000) {
                            file.delete();
                        }
                    }
                }
            }
        }
    }
}
