package com.facebook.goodwill.composer.photofragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ScrollView;
import android.widget.Toast;
import com.facebook.camera.ipc.CameraIntentBuilder;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.text.ImageWithTextView;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.goodwill.composer.GoodwillComposerActivity.ComposerFlowCallback;
import com.facebook.goodwill.composer.GoodwillComposerEvent;
import com.facebook.goodwill.composer.GoodwillComposerEvent.GoodwillPhoto;
import com.facebook.goodwill.composer.GoodwillComposerFragment;
import com.facebook.goodwill.composer.GoodwillComposerFragmentCallback$NavigationResult;
import com.facebook.goodwill.composer.ui.GoodwillComposerTitleBar;
import com.facebook.graphql.model.GraphQLPhoto;
import com.facebook.graphql.model.conversion.GraphQLPhotoConversionHelper;
import com.facebook.inject.FbInjector;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.simplepicker.SimplePickerIntent;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Action;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Builder;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.media.MediaItemFactory;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.mediareorderview.ImagesReorderView;
import com.facebook.widget.mediareorderview.ImagesReorderView.EventCallback;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

/* compiled from: {" */
public class PhotoFromFbOrCameraFragment extends GoodwillComposerFragment implements EventCallback {
    public SecureContextHelper f131a;
    private ImageWithTextView al;
    public GoodwillComposerEvent am;
    public IFeedIntentBuilder f132b;
    public ViewStub f133c;
    public ImagesReorderView f134d;
    public ViewGroup f135e;
    public ScrollView f136f;
    public InterceptingRelativeLayout f137g;
    public GlyphColorizer f138h;
    private ImageWithTextView f139i;

    /* compiled from: {" */
    class C00151 implements OnClickListener {
        final /* synthetic */ PhotoFromFbOrCameraFragment f126a;

        C00151(PhotoFromFbOrCameraFragment photoFromFbOrCameraFragment) {
            this.f126a = photoFromFbOrCameraFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -358457223);
            if (this.f126a.m157e()) {
                PhotoFromFbOrCameraFragment photoFromFbOrCameraFragment = this.f126a;
                photoFromFbOrCameraFragment.f131a.a(SimplePickerIntent.a(photoFromFbOrCameraFragment.o(), new Builder(SimplePickerSource.GOODWILL_COMPOSER).h().i().k().a(Action.NONE)), 1, photoFromFbOrCameraFragment);
            } else {
                this.f126a.aq();
            }
            LogUtils.a(919168780, a);
        }
    }

    /* compiled from: {" */
    class C00162 implements OnClickListener {
        final /* synthetic */ PhotoFromFbOrCameraFragment f127a;

        C00162(PhotoFromFbOrCameraFragment photoFromFbOrCameraFragment) {
            this.f127a = photoFromFbOrCameraFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1149854913);
            if (this.f127a.m157e()) {
                PhotoFromFbOrCameraFragment photoFromFbOrCameraFragment = this.f127a;
                Intent b = photoFromFbOrCameraFragment.f132b.b(photoFromFbOrCameraFragment.o(), StringFormatUtil.formatStrLocaleSafe(FBLinks.dT, photoFromFbOrCameraFragment.am.f71a));
                b.putExtra("extra_photo_title_text", photoFromFbOrCameraFragment.jW_().getString(2131239219));
                photoFromFbOrCameraFragment.f131a.a(b, 9913, photoFromFbOrCameraFragment);
            } else {
                this.f127a.aq();
            }
            LogUtils.a(824678154, a);
        }
    }

    /* compiled from: {" */
    class C00173 implements OnClickListener {
        final /* synthetic */ PhotoFromFbOrCameraFragment f128a;

        C00173(PhotoFromFbOrCameraFragment photoFromFbOrCameraFragment) {
            this.f128a = photoFromFbOrCameraFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 559573748);
            this.f128a.f81a.m61a(GoodwillComposerFragmentCallback$NavigationResult.NAVIGATION_BACK);
            Logger.a(2, EntryType.UI_INPUT_END, 1851650662, a);
        }
    }

    /* compiled from: {" */
    class C00184 implements OnClickListener {
        final /* synthetic */ PhotoFromFbOrCameraFragment f129a;

        C00184(PhotoFromFbOrCameraFragment photoFromFbOrCameraFragment) {
            this.f129a = photoFromFbOrCameraFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1103526634);
            this.f129a.f81a.m61a(GoodwillComposerFragmentCallback$NavigationResult.NAVIGATION_NEXT);
            Logger.a(2, EntryType.UI_INPUT_END, 1041346874, a);
        }
    }

    /* compiled from: {" */
    class C00195 implements Runnable {
        final /* synthetic */ PhotoFromFbOrCameraFragment f130a;

        C00195(PhotoFromFbOrCameraFragment photoFromFbOrCameraFragment) {
            this.f130a = photoFromFbOrCameraFragment;
        }

        public void run() {
            if (this.f130a.f136f != null) {
                this.f130a.f136f.fullScroll(130);
            }
        }
    }

    public static void m147a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PhotoFromFbOrCameraFragment photoFromFbOrCameraFragment = (PhotoFromFbOrCameraFragment) obj;
        CameraIntentBuilder.b(fbInjector);
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector);
        MediaItemFactory.b(fbInjector);
        IFeedIntentBuilder iFeedIntentBuilder = (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(fbInjector);
        DefaultBlueServiceOperationFactory.b(fbInjector);
        GlyphColorizer a = GlyphColorizer.a(fbInjector);
        photoFromFbOrCameraFragment.f131a = secureContextHelper;
        photoFromFbOrCameraFragment.f132b = iFeedIntentBuilder;
        photoFromFbOrCameraFragment.f138h = a;
    }

    public final void m156c(Bundle bundle) {
        super.c(bundle);
        Class cls = PhotoFromFbOrCameraFragment.class;
        m147a((Object) this, getContext());
    }

    public final View m148a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1455414709);
        View inflate = layoutInflater.inflate(2130903253, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -737798092, a);
        return inflate;
    }

    final boolean m157e() {
        return this.am.m96g().size() < 10;
    }

    final void aq() {
        Toast.makeText(getContext(), jW_().getString(2131239223), 0).show();
    }

    public final void m152a(View view, Bundle bundle) {
        super.a(view, bundle);
        int color = jW_().getColor(2131361920);
        this.al = (ImageWithTextView) view.findViewById(2131559595);
        this.al.setOnClickListener(new C00151(this));
        this.al.setImageDrawable(this.f138h.a(2130840019, color));
        this.f139i = (ImageWithTextView) view.findViewById(2131559596);
        this.f139i.setOnClickListener(new C00162(this));
        this.f139i.setImageDrawable(this.f138h.a(2130840016, color));
        GoodwillComposerTitleBar goodwillComposerTitleBar = (GoodwillComposerTitleBar) view.findViewById(2131559592);
        goodwillComposerTitleBar.setTitle(2131239216);
        goodwillComposerTitleBar.m158a(new C00173(this), new C00184(this));
        this.f133c = (ViewStub) view.findViewById(2131559591);
        this.f135e = (ViewGroup) view.findViewById(2131559590);
        this.f136f = (ScrollView) view.findViewById(2131559589);
        this.f137g = (InterceptingRelativeLayout) view.findViewById(2131559588);
        ImmutableList g = this.am.m96g();
        int size = g.size();
        for (color = 0; color < size; color++) {
            m146a((GoodwillPhoto) g.get(color), false);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        for (int i = 0; i < this.f135e.getChildCount(); i++) {
            GoodwillPhotoView goodwillPhotoView = (GoodwillPhotoView) this.f135e.getChildAt(i);
            goodwillPhotoView.setPhoto(goodwillPhotoView.f119e);
        }
    }

    public final void m151a(int i, int i2, Intent intent) {
        if (i2 != -1) {
            return;
        }
        GoodwillPhoto goodwillPhoto;
        if ((i & 65535) == 1) {
            goodwillPhoto = new GoodwillPhoto((MediaItem) intent.getParcelableArrayListExtra("extra_media_items").get(0));
            this.am.m91a(goodwillPhoto);
            m146a(goodwillPhoto, true);
        } else if ((i & 65535) == 9913) {
            GraphQLPhoto graphQLPhoto = (GraphQLPhoto) FlatBufferModelHelper.a(intent, "photo");
            if (graphQLPhoto != null && graphQLPhoto.L() != null && graphQLPhoto.L().b() != null) {
                goodwillPhoto = new GoodwillPhoto(GraphQLPhotoConversionHelper.a(graphQLPhoto));
                this.am.m91a(goodwillPhoto);
                m146a(goodwillPhoto, true);
            }
        }
    }

    private void m146a(GoodwillPhoto goodwillPhoto, boolean z) {
        if (this.f135e != null) {
            GoodwillPhotoView goodwillPhotoView = new GoodwillPhotoView(o());
            goodwillPhotoView.setPhoto(goodwillPhoto);
            goodwillPhotoView.f118d = this;
            this.f135e.addView(goodwillPhotoView);
            if (z) {
                this.f136f.post(new C00195(this));
            }
        }
    }

    public final void m154a(GoodwillPhotoView goodwillPhotoView) {
        int indexOf = this.am.m96g().indexOf(goodwillPhotoView.f119e);
        this.am.m92b(goodwillPhotoView.f119e);
        this.f135e.removeView(goodwillPhotoView);
        if (indexOf < this.f135e.getChildCount()) {
            Animation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 0, (float) goodwillPhotoView.getHeight(), 1, 0.0f);
            translateAnimation.setDuration((long) o().getResources().getInteger(2131492946));
            for (int i = indexOf; i < this.f135e.getChildCount(); i++) {
                this.f135e.getChildAt(i).startAnimation(translateAnimation);
            }
        }
    }

    public final void m155a(GoodwillPhotoView goodwillPhotoView, Point point) {
        if (this.f135e.getChildCount() > 1) {
            int indexOfChild = this.f135e.indexOfChild(goodwillPhotoView);
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            Uri uri = null;
            for (int i = 0; i < this.f135e.getChildCount(); i++) {
                GoodwillPhotoView goodwillPhotoView2 = (GoodwillPhotoView) this.f135e.getChildAt(i);
                Rect photoRect = goodwillPhotoView2.getPhotoRect();
                arrayList.add(new Pair(goodwillPhotoView2.f121g, photoRect));
                arrayList2.add(Float.valueOf(((float) photoRect.width()) / ((float) photoRect.height())));
                if (i == indexOfChild) {
                    uri = goodwillPhotoView2.f121g;
                }
            }
            if (this.f134d == null) {
                this.f134d = (ImagesReorderView) this.f133c.inflate();
            } else {
                this.f134d.setVisibility(0);
            }
            this.f137g.f125a = this.f134d;
            this.f134d.m11588a(arrayList, arrayList2, uri, indexOfChild, (View) this.f135e.getParent(), this, point);
        }
    }

    public final void mo6a(int i, int i2) {
        this.f137g.f125a = null;
        this.f135e.requestFocus();
        List arrayList = new ArrayList();
        for (int i3 = 0; i3 < this.f135e.getChildCount(); i3++) {
            arrayList.add(((GoodwillPhotoView) this.f135e.getChildAt(i3)).getPhotoRect());
        }
        this.f134d.m11587a(arrayList);
        if (i != i2) {
            GoodwillPhotoView goodwillPhotoView = (GoodwillPhotoView) this.f135e.getChildAt(i2);
            this.f135e.removeViewAt(i2);
            this.f135e.addView(goodwillPhotoView, i);
            this.am.m92b(goodwillPhotoView.f119e);
            GoodwillComposerEvent goodwillComposerEvent = this.am;
            goodwillComposerEvent.f77g.add(i, goodwillPhotoView.f119e);
        }
        this.f135e.requestLayout();
    }

    public final void mo5a() {
        for (int i = 0; i < this.f135e.getChildCount(); i++) {
            ((GoodwillPhotoView) this.f135e.getChildAt(i)).f116b.setVisibility(0);
        }
        this.f134d.setVisibility(8);
        this.f135e.requestLayout();
    }

    public final void mo7a(GoodwillComposerEvent goodwillComposerEvent, ComposerFlowCallback composerFlowCallback) {
        this.am = goodwillComposerEvent;
        super.mo7a(goodwillComposerEvent, composerFlowCallback);
    }
}
