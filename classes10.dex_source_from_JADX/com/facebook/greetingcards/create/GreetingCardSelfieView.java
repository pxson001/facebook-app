package com.facebook.greetingcards.create;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.DraweeView;
import com.facebook.greetingcards.model.CardPhoto;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: {extra_ads_experience_id} */
public class GreetingCardSelfieView extends CustomLinearLayout implements CanDisplayCardPhoto {
    public Provider<FbDraweeControllerBuilder> f93a;
    private DraweeView f94b;
    public WantsGalleryListener f95c;
    public CardPhoto f96d;

    /* compiled from: {extra_ads_experience_id} */
    class C00161 implements OnClickListener {
        final /* synthetic */ GreetingCardSelfieView f92a;

        C00161(GreetingCardSelfieView greetingCardSelfieView) {
            this.f92a = greetingCardSelfieView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -45393571);
            this.f92a.f95c.mo2a();
            Logger.a(2, EntryType.UI_INPUT_END, 1728030278, a);
        }
    }

    private static <T extends View> void m109a(Class<T> cls, T t) {
        m110a((Object) t, t.getContext());
    }

    private static void m110a(Object obj, Context context) {
        ((GreetingCardSelfieView) obj).f93a = IdBasedProvider.a(FbInjector.get(context), 1117);
    }

    public GreetingCardSelfieView(Context context) {
        super(context);
        m108a();
    }

    public GreetingCardSelfieView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m108a();
    }

    public GreetingCardSelfieView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m108a();
    }

    @Inject
    private void m111a(Provider<FbDraweeControllerBuilder> provider) {
        this.f93a = provider;
    }

    private void m108a() {
        m109a(GreetingCardSelfieView.class, (View) this);
        setContentView(2130904784);
        this.f94b = (DraweeView) a(2131562899);
        setOnClickListener(new C00161(this));
    }

    public void setListener(WantsGalleryListener wantsGalleryListener) {
        this.f95c = wantsGalleryListener;
    }

    public final void mo1a(@Nullable CardPhoto cardPhoto) {
        if (this.f96d != cardPhoto) {
            this.f96d = cardPhoto;
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(getResources());
            genericDraweeHierarchyBuilder.u = RoundingParams.e();
            genericDraweeHierarchyBuilder = genericDraweeHierarchyBuilder;
            if (cardPhoto.e != null) {
                genericDraweeHierarchyBuilder.p = cardPhoto.e;
                genericDraweeHierarchyBuilder.e(ScaleType.h);
            }
            this.f94b.setHierarchy(genericDraweeHierarchyBuilder.u());
            this.f94b.setController(((FbDraweeControllerBuilder) this.f93a.get()).b(cardPhoto.a).a(CallerContext.a(getClass(), "greeting_cards")).s());
        }
    }

    public CardPhoto getCardPhoto() {
        return this.f96d;
    }
}
