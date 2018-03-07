package com.facebook.composer.stickerpost;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.composer.activity.ComposerFragment;
import com.facebook.composer.activity.ComposerFragment.20;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.intent.ComposerStickerData;
import com.facebook.ipc.composer.intent.ComposerStickerData.Builder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.stickers.model.Sticker;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: configureCodec */
public class ComposerStickerController {
    private static final CallerContext f16947a = CallerContext.a(ComposerStickerController.class);
    public final String f16948b;
    public final FragmentManager f16949c;
    private final FbDraweeControllerBuilder f16950d;
    private FbDraweeView f16951e;
    public ComposerStickerPickerFragment f16952f;
    private 20 f16953g;

    /* compiled from: configureCodec */
    class C13581 implements OnClickListener {
        final /* synthetic */ ComposerStickerController f16945a;

        C13581(ComposerStickerController composerStickerController) {
            this.f16945a = composerStickerController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -576102530);
            ComposerStickerController composerStickerController = this.f16945a;
            if (composerStickerController.f16952f == null) {
                String str = composerStickerController.f16948b;
                ComposerStickerPickerFragment composerStickerPickerFragment = new ComposerStickerPickerFragment();
                Bundle bundle = new Bundle();
                bundle.putString("sessionId", str);
                composerStickerPickerFragment.g(bundle);
                composerStickerController.f16952f = composerStickerPickerFragment;
                composerStickerController.f16952f.aw = composerStickerController;
            }
            composerStickerController.f16949c.a().a(composerStickerController.f16952f, "STICKER_PICKER_FRAGMENT_TAG").b();
            Logger.a(2, EntryType.UI_INPUT_END, 1687231214, a);
        }
    }

    /* compiled from: configureCodec */
    class C13592 extends BaseControllerListener {
        final /* synthetic */ ComposerStickerController f16946a;

        C13592(ComposerStickerController composerStickerController) {
            this.f16946a = composerStickerController;
        }

        public final void m20906a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    }

    @Inject
    public ComposerStickerController(@Assisted String str, @Assisted FragmentManager fragmentManager, @Assisted 20 20, FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f16948b = str;
        this.f16949c = fragmentManager;
        this.f16953g = 20;
        this.f16950d = fbDraweeControllerBuilder;
    }

    public final void m20909a(Sticker sticker) {
        m20907a(Builder.a(sticker).a());
        20 20 = this.f16953g;
        Preconditions.checkNotNull(sticker);
        20.a.aU.b(ComposerFragment.cn).a(Builder.a(sticker).a()).a();
    }

    public final void m20908a(ComposerStickerData composerStickerData, ViewStub viewStub) {
        if (composerStickerData != null) {
            this.f16951e = (FbDraweeView) viewStub.inflate();
            this.f16951e.setOnClickListener(new C13581(this));
            this.f16951e.setVisibility(0);
            m20907a(composerStickerData);
        }
    }

    private void m20907a(ComposerStickerData composerStickerData) {
        FbDraweeControllerBuilder fbDraweeControllerBuilder = (FbDraweeControllerBuilder) this.f16950d.a(f16947a).b(this.f16951e.getController());
        Preconditions.checkNotNull(composerStickerData);
        String str = composerStickerData.staticWebUri;
        if (composerStickerData.animatedDiskUri != null) {
            str = composerStickerData.animatedDiskUri;
        } else if (composerStickerData.animatedWebUri != null) {
            str = composerStickerData.animatedWebUri;
        } else if (composerStickerData.staticDiskUri != null) {
            str = composerStickerData.staticDiskUri;
        }
        this.f16951e.setController(((FbDraweeControllerBuilder) fbDraweeControllerBuilder.b(Uri.parse(str)).a(new C13592(this))).s());
    }
}
