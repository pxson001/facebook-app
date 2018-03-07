package com.facebook.messaging.inbox2.sharing;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.ContextUtils;
import com.facebook.drawee.drawable.FadeDrawable;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbPipelineDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.drawee.view.MultiDraweeHolder;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.inbox2.sharing.SuggestedUser.ShareState;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mQueueLock */
public class QuickShareSuggestedUserView extends CustomLinearLayout {
    private static final CallerContext f11315c = CallerContext.a(QuickShareSuggestedUserView.class);
    @Inject
    FbDraweeControllerBuilder f11316a;
    @Inject
    GlyphColorizer f11317b;
    private ColorFilter f11318d;
    private final MultiDraweeHolder<GenericDraweeHierarchy> f11319e = new MultiDraweeHolder();
    private FadeDrawable f11320f;
    private SuggestedUser f11321g;
    public UserSelectionListener f11322h;
    private ImageView f11323i;
    private TextView f11324j;
    private int f11325k;

    /* compiled from: mQueueLock */
    class C12451 implements OnClickListener {
        final /* synthetic */ QuickShareSuggestedUserView f11313a;

        C12451(QuickShareSuggestedUserView quickShareSuggestedUserView) {
            this.f11313a = quickShareSuggestedUserView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 43782452);
            QuickShareSuggestedUserView.m11918d(this.f11313a);
            Logger.a(2, EntryType.UI_INPUT_END, -1399347593, a);
        }
    }

    private static <T extends View> void m11914a(Class<T> cls, T t) {
        m11915a((Object) t, t.getContext());
    }

    private static void m11915a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((QuickShareSuggestedUserView) obj).m11912a(FbDraweeControllerBuilder.b(fbInjector), GlyphColorizer.a(fbInjector));
    }

    private void m11912a(FbDraweeControllerBuilder fbDraweeControllerBuilder, GlyphColorizer glyphColorizer) {
        this.f11316a = fbDraweeControllerBuilder;
        this.f11317b = glyphColorizer;
    }

    public QuickShareSuggestedUserView(Context context) {
        super(context);
        m11916b();
    }

    public QuickShareSuggestedUserView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m11916b();
    }

    public QuickShareSuggestedUserView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11916b();
    }

    private void m11916b() {
        m11914a(QuickShareSuggestedUserView.class, (View) this);
        this.f11318d = this.f11317b.a(-1);
        this.f11325k = ContextUtils.c(getContext(), 2130773024, -1);
        setOrientation(1);
        setContentView(2130904871);
        this.f11323i = (ImageView) a(2131563096);
        this.f11324j = (TextView) a(2131563097);
        m11917c();
        setOnClickListener(new C12451(this));
    }

    public void setUser(SuggestedUser suggestedUser) {
        if (this.f11321g == suggestedUser) {
            m11919e();
            return;
        }
        this.f11321g = suggestedUser;
        setUserShareState(this.f11321g.f11354b);
        this.f11324j.setText(this.f11321g.f11353a.h());
        this.f11320f.g();
    }

    public final void m11921a() {
        this.f11321g = null;
        this.f11322h = null;
    }

    public void setListener(UserSelectionListener userSelectionListener) {
        this.f11322h = userSelectionListener;
    }

    private void m11917c() {
        Drawable[] drawableArr = new Drawable[ShareState.values().length];
        for (ShareState shareState : ShareState.values()) {
            GenericDraweeHierarchy a = m11911a(shareState);
            this.f11319e.a(DraweeHolder.a(a, getContext()));
            drawableArr[shareState.ordinal()] = a.a();
        }
        this.f11320f = new FadeDrawable(drawableArr);
        this.f11320f.c(300);
        this.f11323i.setImageDrawable(this.f11320f);
    }

    public static void m11918d(QuickShareSuggestedUserView quickShareSuggestedUserView) {
        switch (quickShareSuggestedUserView.f11321g.f11354b) {
            case PROFILE_PIC:
                quickShareSuggestedUserView.setUserShareState(ShareState.SEND_BUTTON);
                return;
            case SEND_BUTTON:
                quickShareSuggestedUserView.setUserShareState(ShareState.SEND_CONFIRMED);
                quickShareSuggestedUserView.f11322h.mo434a(quickShareSuggestedUserView.f11321g.f11353a, null);
                return;
            default:
                return;
        }
    }

    private void setUserShareState(ShareState shareState) {
        this.f11321g.f11354b = shareState;
        m11919e();
    }

    private void m11919e() {
        int ordinal = this.f11321g.f11354b.ordinal();
        this.f11319e.b(ordinal).a(m11920f());
        this.f11320f.f(ordinal);
    }

    private FbPipelineDraweeController m11920f() {
        ImageRequestBuilder a;
        switch (this.f11321g.f11354b) {
            case SEND_BUTTON:
                a = ImageRequestBuilder.a(2130841433);
                break;
            case SEND_CONFIRMED:
                a = ImageRequestBuilder.a(2130841311);
                break;
            case SEND_ERROR:
                a = ImageRequestBuilder.a(2130841354);
                break;
            default:
                a = ImageRequestBuilder.a(Uri.parse(this.f11321g.f11353a.x()));
                break;
        }
        return ((FbDraweeControllerBuilder) this.f11316a.a(f11315c).c(a.m())).s();
    }

    private GenericDraweeHierarchy m11911a(ShareState shareState) {
        Resources resources = getResources();
        GenericDraweeHierarchyBuilder a = GenericDraweeHierarchyBuilder.a(resources);
        a.u = RoundingParams.e().a(this.f11325k);
        a = a;
        GenericDraweeHierarchyBuilder e;
        switch (shareState) {
            case PROFILE_PIC:
                a.f = resources.getDrawable(2131362420);
                break;
            case SEND_BUTTON:
                e = a.e(resources.getDrawable(2131362241));
                e.q = this.f11318d;
                e.e(ScaleType.e);
                break;
            case SEND_CONFIRMED:
                e = a.e(resources.getDrawable(2131362241));
                e.q = this.f11318d;
                e.e(ScaleType.e);
                break;
            case SEND_ERROR:
                e = a.e(resources.getDrawable(2131362298));
                e.q = this.f11318d;
                e.e(ScaleType.e);
                break;
        }
        return a.u();
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1951507113);
        super.onAttachedToWindow();
        this.f11319e.a();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1873763503, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -813335801);
        super.onDetachedFromWindow();
        this.f11319e.b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1337559569, a);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.f11319e.b();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.f11319e.a();
    }
}
