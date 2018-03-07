package com.facebook.messaging.inbox2.sharing;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mRecipientName */
public class QuickShareSearchView extends CustomLinearLayout {
    private static final CallerContext f11309d = CallerContext.a(QuickShareSearchView.class);
    @Inject
    FbDraweeControllerBuilder f11310a;
    @Inject
    GlyphColorizer f11311b;
    public UserSelectionListener f11312c;

    /* compiled from: mRecipientName */
    class C12441 implements OnClickListener {
        final /* synthetic */ QuickShareSearchView f11308a;

        C12441(QuickShareSearchView quickShareSearchView) {
            this.f11308a = quickShareSearchView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1558721105);
            if (this.f11308a.f11312c != null) {
                this.f11308a.f11312c.mo433a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -900183963, a);
        }
    }

    private static <T extends View> void m11909a(Class<T> cls, T t) {
        m11910a((Object) t, t.getContext());
    }

    private static void m11910a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((QuickShareSearchView) obj).m11908a(FbDraweeControllerBuilder.b(fbInjector), GlyphColorizer.a(fbInjector));
    }

    public QuickShareSearchView(Context context) {
        super(context);
        m11907a();
    }

    public QuickShareSearchView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m11907a();
    }

    public QuickShareSearchView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11907a();
    }

    private void m11907a() {
        m11909a(QuickShareSearchView.class, (View) this);
        setOrientation(1);
        setContentView(2130904869);
        FbDraweeView fbDraweeView = (FbDraweeView) a(2131563095);
        ((GenericDraweeHierarchy) fbDraweeView.getHierarchy()).a(this.f11311b.a(-1));
        fbDraweeView.setController(((FbDraweeControllerBuilder) this.f11310a.a(f11309d).c(ImageRequestBuilder.a(2130841432).m())).s());
        setOnClickListener(new C12441(this));
    }

    private void m11908a(FbDraweeControllerBuilder fbDraweeControllerBuilder, GlyphColorizer glyphColorizer) {
        this.f11310a = fbDraweeControllerBuilder;
        this.f11311b = glyphColorizer;
    }

    public void setListener(UserSelectionListener userSelectionListener) {
        this.f11312c = userSelectionListener;
    }
}
