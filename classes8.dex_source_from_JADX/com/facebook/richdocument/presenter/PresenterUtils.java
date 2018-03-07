package com.facebook.richdocument.presenter;

import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import com.facebook.graphql.enums.GraphQLAudioAnnotationPlayMode;
import com.facebook.graphql.enums.GraphQLDocumentElementType;
import com.facebook.graphql.enums.GraphQLDocumentMediaPresentationStyle;
import com.facebook.richdocument.model.block.Annotation.AnnotationAlignment;
import com.facebook.richdocument.model.block.AudioAnnotation;
import com.facebook.richdocument.model.data.AnnotatableBlock;
import com.facebook.richdocument.model.data.CoverMediaBlock;
import com.facebook.richdocument.model.data.MediaPresentationBlock;
import com.facebook.richdocument.model.data.OGBlock;
import com.facebook.richdocument.model.data.SlideBlock;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentStyleModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextAnnotationModel;
import com.facebook.richdocument.view.block.AudioAnnotationAware;
import com.facebook.richdocument.view.block.BlockView;
import com.facebook.richdocument.view.block.FeedbackAware;
import com.facebook.richdocument.view.block.LocationAnnotationAware;
import com.facebook.richdocument.view.block.TextAnnotationAware;
import com.facebook.richdocument.view.block.impl.MediaBlockView;
import com.facebook.richdocument.view.transition.TransitionStrategyFactory.StrategyType;
import com.facebook.richdocument.view.widget.media.plugins.MapUnderlayPlugin;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;

/* compiled from: permalink_id */
public class PresenterUtils {

    /* compiled from: permalink_id */
    /* synthetic */ class C07321 {
        static final /* synthetic */ int[] f6438a = new int[GraphQLDocumentMediaPresentationStyle.values().length];

        static {
            try {
                f6438a[GraphQLDocumentMediaPresentationStyle.ASPECT_FIT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6438a[GraphQLDocumentMediaPresentationStyle.FULL_SCREEN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6438a[GraphQLDocumentMediaPresentationStyle.ASPECT_FIT_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f6438a[GraphQLDocumentMediaPresentationStyle.NON_INTERACTIVE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static int m6821a(int i, Context context) {
        return (int) TypedValue.applyDimension(1, (float) i, context.getResources().getDisplayMetrics());
    }

    public static void m6823a(BlockView blockView, AnnotatableBlock annotatableBlock, RichDocumentStyleModel richDocumentStyleModel, Bundle bundle) {
        if (blockView instanceof TextAnnotationAware) {
            TracerDetour.a("PresenterUtils.setTextAnnotations", 10118556);
            ((TextAnnotationAware) blockView).mo392a(annotatableBlock.mo273c(), annotatableBlock.iV_(), annotatableBlock.mo274e());
            TracerDetour.a(1468559059);
        }
        if (blockView instanceof LocationAnnotationAware) {
            ((LocationAnnotationAware) blockView).mo391a(annotatableBlock.mo275f());
        }
        if (blockView instanceof AudioAnnotationAware) {
            AudioAnnotationAware audioAnnotationAware = (AudioAnnotationAware) blockView;
            String g = annotatableBlock.mo276g();
            GraphQLAudioAnnotationPlayMode h = annotatableBlock.mo277h();
            RichDocumentTextAnnotationModel i = annotatableBlock.mo278i();
            audioAnnotationAware.mo390a(new AudioAnnotation(g, h, i == null ? null : i.m6376b(), i == null ? AnnotationAlignment.LEFT : AnnotationAlignment.from(i.m6377c()), richDocumentStyleModel));
        }
        if (blockView instanceof FeedbackAware) {
            TracerDetour.a("PresenterUtils.setFeedback", 1112191813);
            ((FeedbackAware) blockView).mo389a(annotatableBlock.mo280j(), annotatableBlock.mo281k());
            TracerDetour.a(118319549);
        }
        if (blockView instanceof MediaBlockView) {
            MapUnderlayPlugin mapUnderlayPlugin = (MapUnderlayPlugin) ((MediaBlockView) blockView).m6975a(MapUnderlayPlugin.class);
            if (mapUnderlayPlugin != null) {
                mapUnderlayPlugin.f7659e = bundle;
            }
        }
    }

    public static Bundle m6822a(OGBlock oGBlock) {
        Bundle bundle = new Bundle();
        if (!(oGBlock instanceof MediaPresentationBlock)) {
            return bundle;
        }
        MediaPresentationBlock mediaPresentationBlock = (MediaPresentationBlock) oGBlock;
        if ((oGBlock instanceof CoverMediaBlock) && ((CoverMediaBlock) oGBlock).iR_()) {
            bundle.putString("isCoverMedia", Boolean.toString(true));
        }
        if (oGBlock.iT_() == GraphQLDocumentElementType.SLIDESHOW) {
            if (mediaPresentationBlock.mo293m() == GraphQLDocumentMediaPresentationStyle.FULL_SCREEN) {
                bundle.putString("strategyType", StrategyType.FULLSCREEN_SLIDESHOW.name());
            } else {
                bundle.putString("strategyType", StrategyType.ASPECT_FIT_SLIDESHOW.name());
            }
        } else if (oGBlock.iT_() == GraphQLDocumentElementType.NATIVE_AD) {
            bundle.putString("strategyType", StrategyType.NATIVE_ADS_ASPECT_FIT_ONLY.name());
        } else if (!(oGBlock instanceof SlideBlock) || !((SlideBlock) oGBlock).iS_()) {
            switch (C07321.f6438a[mediaPresentationBlock.mo293m().ordinal()]) {
                case 1:
                    bundle.putString("strategyType", StrategyType.ASPECT_FIT.name());
                    break;
                case 2:
                    bundle.putString("strategyType", StrategyType.FULLSCREEN.name());
                    break;
                case 3:
                    bundle.putString("strategyType", StrategyType.ASPECT_FIT_ONLY.name());
                    break;
                case 4:
                    bundle.putString("strategyType", StrategyType.NON_INTERACTIVE.name());
                    break;
                default:
                    break;
            }
        } else {
            SlideBlock slideBlock = (SlideBlock) oGBlock;
            if (slideBlock.mo294o() != null) {
                switch (C07321.f6438a[slideBlock.mo294o().ordinal()]) {
                    case 1:
                        bundle.putString("strategyType", StrategyType.ASPECT_FIT_SLIDE.name());
                        break;
                    case 2:
                        bundle.putString("strategyType", StrategyType.FULLSCREEN_SLIDE.name());
                        break;
                    default:
                        break;
                }
            } else if (mediaPresentationBlock.mo293m() == GraphQLDocumentMediaPresentationStyle.FULL_SCREEN) {
                bundle.putString("strategyType", StrategyType.FULLSCREEN_SLIDE.name());
            } else {
                bundle.putString("strategyType", StrategyType.ASPECT_FIT_SLIDE.name());
            }
        }
        return bundle;
    }
}
