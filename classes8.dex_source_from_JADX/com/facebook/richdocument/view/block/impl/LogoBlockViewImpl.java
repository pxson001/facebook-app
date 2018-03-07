package com.facebook.richdocument.view.block.impl;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.http.observer.ConnectionQuality;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.richdocument.ham.HamDimensions;
import com.facebook.richdocument.ham.HamViewUtils;
import com.facebook.richdocument.presenter.LogoBlockPresenter;
import com.facebook.richdocument.utils.ConnectionQualityMonitor;
import com.facebook.richdocument.view.block.LogoBlockView;
import com.facebook.richdocument.view.touch.RichDocumentTouch;
import com.facebook.richdocument.view.util.RichDocumentLayoutDirection;
import com.facebook.richdocument.view.widget.PressStateButton;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: page_logo_size */
public class LogoBlockViewImpl extends AbstractBlockView<LogoBlockPresenter> implements LogoBlockView {
    private static final CallerContext f6666h = CallerContext.a(LogoBlockViewImpl.class);
    @Inject
    FbDraweeControllerBuilder f6667a;
    @Inject
    HamViewUtils f6668b;
    @Inject
    HamDimensions f6669c;
    @Inject
    AbstractFbErrorReporter f6670d;
    @Inject
    RichDocumentLayoutDirection f6671e;
    @Inject
    ConnectionQualityMonitor f6672f;
    @Inject
    GatekeeperStoreImpl f6673g;
    public final FbDraweeView f6674i;
    public final PressStateButton f6675j;
    public final View f6676k;

    public static void m7013a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((LogoBlockViewImpl) obj).m7012a(FbDraweeControllerBuilder.b(injectorLike), HamViewUtils.m5278a(injectorLike), HamDimensions.m5268a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), RichDocumentLayoutDirection.m7366a(injectorLike), ConnectionQualityMonitor.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    public LogoBlockViewImpl(View view) {
        super(view);
        Class cls = LogoBlockViewImpl.class;
        m7013a((Object) this, getContext());
        this.f6674i = (FbDraweeView) view.findViewById(2131567040);
        this.f6675j = (PressStateButton) view.findViewById(2131567041);
        this.f6676k = view.findViewById(2131567042);
        this.f6668b.m5280a(view.findViewById(2131567039), 0, 2131558726);
        view.setPadding(this.f6669c.m5276b(2131558653), view.getPaddingTop(), this.f6669c.m5276b(2131558654), view.getPaddingBottom());
        int b = this.f6669c.m5276b(2131558723);
        RichDocumentTouch.m7189a(this.f6675j, Integer.valueOf(b), Integer.valueOf(b), Integer.valueOf(3));
        if (RichDocumentLayoutDirection.m7368c()) {
            if (this.f6671e.m7369a()) {
                iY_().setLayoutDirection(1);
            } else {
                iY_().setLayoutDirection(0);
            }
            if (this.f6671e.m7370b()) {
                this.f6675j.setTextDirection(4);
                this.f6675j.setLayoutDirection(1);
                return;
            }
            this.f6675j.setTextDirection(3);
            this.f6675j.setLayoutDirection(0);
        }
    }

    public final void mo374a(Bundle bundle) {
        super.mo374a(bundle);
        this.f6674i.setVisibility(8);
        this.f6675j.setVisibility(8);
    }

    public final void m7015a(String str, final int i) {
        if (str == null) {
            this.f6674i.setVisibility(8);
            return;
        }
        this.f6674i.setVisibility(0);
        this.f6674i.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f6667a.a(f6666h).b(Uri.parse(str)).b(this.f6674i.getController())).a(new BaseControllerListener(this) {
            final /* synthetic */ LogoBlockViewImpl f6665b;

            public final void m7010a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
                CloseableImage closeableImage = (CloseableImage) obj;
                int i = 1;
                boolean z = false;
                super.a(str, closeableImage, animatable);
                if (closeableImage != null) {
                    int round = Math.round(((float) closeableImage.f()) / ((float) i));
                    float f = this.f6665b.getContext().getResources().getDisplayMetrics().density;
                    float f2 = f / ((float) round);
                    if (this.f6665b.f6672f.a() == ConnectionQuality.POOR && f == 1.0f && this.f6665b.f6673g.a(103, false)) {
                        z = true;
                    }
                    if (z) {
                        i = 2;
                    }
                    int f3 = (int) ((((float) closeableImage.f()) * f2) * ((float) i));
                    i = (int) (((float) i) * (f2 * ((float) closeableImage.g())));
                    LayoutParams layoutParams = this.f6665b.f6674i.getLayoutParams();
                    layoutParams.width = f3;
                    layoutParams.height = i;
                    this.f6665b.f6674i.setLayoutParams(layoutParams);
                }
            }

            public final void m7011b(String str, Throwable th) {
                super.b(str, th);
                if (this.f6665b.f6670d != null) {
                    AbstractFbErrorReporter abstractFbErrorReporter = this.f6665b.f6670d;
                    String str2 = "instant_articles";
                    String str3 = "IA unable to load logo: %s";
                    Object[] objArr = new Object[1];
                    objArr[0] = th != null ? th.getMessage() : "unknown";
                    abstractFbErrorReporter.a(str2, StringFormatUtil.a(str3, objArr));
                }
            }
        })).s());
    }

    public final void m7016a(boolean z, boolean z2) {
        if (z) {
            this.f6675j.setAlpha(z2 ? 1.0f : 0.5f);
            this.f6675j.setVisibility(0);
        }
    }

    private void m7012a(FbDraweeControllerBuilder fbDraweeControllerBuilder, HamViewUtils hamViewUtils, HamDimensions hamDimensions, AbstractFbErrorReporter abstractFbErrorReporter, RichDocumentLayoutDirection richDocumentLayoutDirection, ConnectionQualityMonitor connectionQualityMonitor, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f6667a = fbDraweeControllerBuilder;
        this.f6668b = hamViewUtils;
        this.f6669c = hamDimensions;
        this.f6670d = abstractFbErrorReporter;
        this.f6671e = richDocumentLayoutDirection;
        this.f6672f = connectionQualityMonitor;
        this.f6673g = gatekeeperStoreImpl;
    }
}
