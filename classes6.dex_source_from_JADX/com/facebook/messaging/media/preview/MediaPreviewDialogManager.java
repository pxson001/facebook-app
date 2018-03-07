package com.facebook.messaging.media.preview;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.drawable.Animatable;
import android.view.LayoutInflater;
import android.view.Window;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.ui.dialogs.DialogWindowUtils;
import com.google.common.base.Objects;
import javax.annotation.Nullable;

/* compiled from: is_fallback_datasource */
public class MediaPreviewDialogManager {
    private static final CallerContext f12086a = CallerContext.a(MediaPreviewDialogManager.class);
    public final FbDraweeControllerBuilder f12087b;
    public Dialog f12088c;
    public FbDraweeView f12089d;
    public ImageRequest f12090e;
    public int f12091f = 200;
    public CallerContext f12092g = f12086a;

    /* compiled from: is_fallback_datasource */
    public class C07801 implements OnDismissListener {
        final /* synthetic */ MediaPreviewDialogManager f12082a;

        public C07801(MediaPreviewDialogManager mediaPreviewDialogManager) {
            this.f12082a = mediaPreviewDialogManager;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            MediaPreviewDialogManager.m19027c(this.f12082a);
        }
    }

    /* compiled from: is_fallback_datasource */
    public class C07812 implements OnCancelListener {
        final /* synthetic */ MediaPreviewDialogManager f12083a;

        public C07812(MediaPreviewDialogManager mediaPreviewDialogManager) {
            this.f12083a = mediaPreviewDialogManager;
        }

        public void onCancel(DialogInterface dialogInterface) {
            MediaPreviewDialogManager.m19027c(this.f12083a);
        }
    }

    public MediaPreviewDialogManager(FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f12087b = fbDraweeControllerBuilder;
    }

    public final void m19030a(Context context, ImageRequest imageRequest) {
        if (this.f12088c == null) {
            this.f12089d = (FbDraweeView) LayoutInflater.from(context).inflate(2130905182, null);
            FbDraweeView fbDraweeView = this.f12089d;
            GenericDraweeHierarchyBuilder e = new GenericDraweeHierarchyBuilder(context.getResources()).e(ScaleType.c);
            e.f = new AutoRotateDrawable(context.getResources().getDrawable(2130841662), 1000);
            fbDraweeView.setHierarchy(e.u());
            this.f12088c = new Dialog(context);
            this.f12088c.requestWindowFeature(1);
            this.f12088c.setCanceledOnTouchOutside(false);
            this.f12088c.setOnDismissListener(new C07801(this));
            this.f12088c.setOnCancelListener(new C07812(this));
            Window window = this.f12088c.getWindow();
            window.setContentView(this.f12089d);
            window.setLayout(this.f12091f, this.f12091f);
            window.addFlags(8);
            window.setBackgroundDrawable(context.getResources().getDrawable(2130841181));
            DialogWindowUtils.a(this.f12088c);
        }
        if (!m19031b()) {
            this.f12088c.show();
        }
        if (!Objects.equal(this.f12090e, imageRequest)) {
            m19026a(imageRequest);
        }
    }

    public final void m19029a() {
        if (m19031b()) {
            this.f12088c.dismiss();
        }
    }

    public final boolean m19031b() {
        return this.f12088c != null && this.f12088c.isShowing();
    }

    private void m19026a(final ImageRequest imageRequest) {
        this.f12090e = imageRequest;
        m19028d();
        this.f12089d.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f12087b.p().a(this.f12092g).b(this.f12089d.getController())).c(imageRequest)).a(new BaseControllerListener(this) {
            final /* synthetic */ MediaPreviewDialogManager f12085b;

            public final void m19025a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
                if (animatable != null && this.f12085b.f12088c != null && Objects.equal(this.f12085b.f12090e, imageRequest)) {
                    animatable.start();
                }
            }
        })).s());
    }

    public static void m19027c(MediaPreviewDialogManager mediaPreviewDialogManager) {
        mediaPreviewDialogManager.m19028d();
        mediaPreviewDialogManager.f12088c = null;
        mediaPreviewDialogManager.f12089d = null;
        mediaPreviewDialogManager.f12090e = null;
    }

    private void m19028d() {
        if (this.f12089d != null && this.f12089d.getController() != null) {
            Animatable g = this.f12089d.getController().g();
            if (g != null) {
                g.stop();
            }
        }
    }
}
