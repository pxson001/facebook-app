package com.facebook.greetingcards.create;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.callercontexttagger.AnalyticsTagger;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.greetingcards.create.MomentPhotosContainer.C00221;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: {campaign_id} */
public class MomentPhotoView extends CustomFrameLayout {
    public static final CallerContext f119a = CallerContext.a(MomentPhotoView.class);
    public AnalyticsTagger f120b;
    public FbDraweeView f121c = ((FbDraweeView) c(2131563902));
    public ImageView f122d = ((ImageView) c(2131563903));
    public C00221 f123e;

    /* compiled from: {campaign_id} */
    public class C00201 implements OnClickListener {
        final /* synthetic */ MomentPhotoView f117a;

        public C00201(MomentPhotoView momentPhotoView) {
            this.f117a = momentPhotoView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2130129574);
            if (this.f117a.f123e != null) {
                this.f117a.f123e.m131a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 845969208, a);
        }
    }

    /* compiled from: {campaign_id} */
    public class C00212 implements OnClickListener {
        final /* synthetic */ MomentPhotoView f118a;

        public C00212(MomentPhotoView momentPhotoView) {
            this.f118a = momentPhotoView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -285390309);
            if (this.f118a.f123e != null) {
                this.f118a.f123e.m132b();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1255753948, a);
        }
    }

    public static void m130a(Object obj, Context context) {
        ((MomentPhotoView) obj).f120b = AnalyticsTagger.a(FbInjector.get(context));
    }

    public MomentPhotoView(Context context) {
        super(context);
        Class cls = MomentPhotoView.class;
        m130a(this, getContext());
        this.f120b.a(this, "greeting_cards", getClass());
        setContentView(2130905293);
        this.f121c.setOnClickListener(new C00201(this));
        this.f122d.setOnClickListener(new C00212(this));
    }
}
