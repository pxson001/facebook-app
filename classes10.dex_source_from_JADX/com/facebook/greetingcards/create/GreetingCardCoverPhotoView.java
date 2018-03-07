package com.facebook.greetingcards.create;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.greetingcards.model.CardPhoto;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: {group_feed_id} */
public class GreetingCardCoverPhotoView extends CustomFrameLayout implements CanDisplayCardPhoto {
    private FbDraweeView f62a;
    public WantsGalleryListener f63b;
    private View f64c;
    public Provider<FbDraweeControllerBuilder> f65d;
    public CardPhoto f66e;

    /* compiled from: {group_feed_id} */
    class C00071 implements OnClickListener {
        final /* synthetic */ GreetingCardCoverPhotoView f61a;

        C00071(GreetingCardCoverPhotoView greetingCardCoverPhotoView) {
            this.f61a = greetingCardCoverPhotoView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 717017749);
            this.f61a.f63b.mo2a();
            Logger.a(2, EntryType.UI_INPUT_END, -429681731, a);
        }
    }

    private static <T extends View> void m68a(Class<T> cls, T t) {
        m69a((Object) t, t.getContext());
    }

    private static void m69a(Object obj, Context context) {
        ((GreetingCardCoverPhotoView) obj).f65d = IdBasedProvider.a(FbInjector.get(context), 1117);
    }

    public GreetingCardCoverPhotoView(Context context) {
        super(context);
        m67a();
    }

    public GreetingCardCoverPhotoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m67a();
    }

    public GreetingCardCoverPhotoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m67a();
    }

    @Inject
    private void m70a(Provider<FbDraweeControllerBuilder> provider) {
        this.f65d = provider;
    }

    private void m67a() {
        m68a(GreetingCardCoverPhotoView.class, (View) this);
        setContentView(2130904780);
        this.f64c = c(2131562887);
        this.f62a = (FbDraweeView) c(2131562885);
        this.f62a.setAspectRatio(1.3333334f);
        this.f62a.setOnClickListener(new C00071(this));
    }

    public void setListener(WantsGalleryListener wantsGalleryListener) {
        this.f63b = wantsGalleryListener;
    }

    public final void mo1a(@Nullable CardPhoto cardPhoto) {
        if (this.f66e != cardPhoto) {
            this.f66e = cardPhoto;
            FbDraweeControllerBuilder fbDraweeControllerBuilder = (FbDraweeControllerBuilder) this.f65d.get();
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(getResources());
            if (cardPhoto.e != null) {
                genericDraweeHierarchyBuilder.p = cardPhoto.e;
                genericDraweeHierarchyBuilder.e(ScaleType.h);
            }
            this.f62a.setHierarchy(genericDraweeHierarchyBuilder.u());
            this.f62a.setController(fbDraweeControllerBuilder.b(cardPhoto.a).a(CallerContext.a(getClass(), "greeting_cards")).s());
            if (this.f66e != null) {
                this.f64c.setVisibility(8);
            }
        }
    }

    public CardPhoto getCardPhoto() {
        return this.f66e;
    }
}
