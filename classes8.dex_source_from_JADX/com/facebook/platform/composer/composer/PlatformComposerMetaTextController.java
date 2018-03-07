package com.facebook.platform.composer.composer;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.facebook.composer.metatext.MetaTextSpan;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.platform.opengraph.model.OpenGraphActionRobotext;
import com.facebook.platform.opengraph.model.OpenGraphActionRobotext.Span;
import com.facebook.platform.opengraph.server.GetRobotextPreviewMethod.Params;
import com.facebook.share.model.ComposerAppAttribution;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: rich_document_layout_inflation */
public class PlatformComposerMetaTextController {
    public final Context f4122a;
    private final DefaultBlueServiceOperationFactory f4123b;

    /* compiled from: rich_document_layout_inflation */
    class C05341 implements Function<OperationResult, SpannableStringBuilder> {
        final /* synthetic */ PlatformComposerMetaTextController f4121a;

        C05341(PlatformComposerMetaTextController platformComposerMetaTextController) {
            this.f4121a = platformComposerMetaTextController;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            OperationResult operationResult = (OperationResult) obj;
            if (operationResult == null) {
                return null;
            }
            OpenGraphActionRobotext openGraphActionRobotext = (OpenGraphActionRobotext) operationResult.h();
            PlatformComposerMetaTextController platformComposerMetaTextController = this.f4121a;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            int color = platformComposerMetaTextController.f4122a.getResources().getColor(2131361916);
            if (openGraphActionRobotext != null) {
                String str = openGraphActionRobotext.a;
                List<Span> list = openGraphActionRobotext.b;
                if (str != null) {
                    int length = str.length();
                    spannableStringBuilder.append(str);
                    spannableStringBuilder.setSpan(new MetaTextSpan(platformComposerMetaTextController.f4122a.getResources().getColor(2131363638)), 0, length, 33);
                    for (Span span : list) {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), span.mOffset, span.b(), 33);
                    }
                }
            }
            return spannableStringBuilder;
        }
    }

    public static PlatformComposerMetaTextController m4088a(InjectorLike injectorLike) {
        return new PlatformComposerMetaTextController((Context) injectorLike.getInstance(Context.class), DefaultBlueServiceOperationFactory.b(injectorLike));
    }

    @Inject
    public PlatformComposerMetaTextController(Context context, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory) {
        this.f4122a = context;
        this.f4123b = defaultBlueServiceOperationFactory;
    }

    public final ListenableFuture<SpannableStringBuilder> m4089a(String str, String str2, ComposerAppAttribution composerAppAttribution) {
        if (str == null || str2 == null || composerAppAttribution == null) {
            throw new IllegalArgumentException("Failed to generate preview for user due to invalid input");
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("og_action", new Params(str, str2, composerAppAttribution.a(), composerAppAttribution.c()));
        return Futures.a(BlueServiceOperationFactoryDetour.a(this.f4123b, "platform_get_robotext_preview", bundle, 1610368252).a(), new C05341(this));
    }
}
