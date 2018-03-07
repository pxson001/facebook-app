package com.facebook.friendsnearby.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.TouchDelegate;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.contentview.ContentView.ThumbnailSize;
import com.facebook.fbui.widget.contentview.ContentViewWithButton;
import com.facebook.fbui.widget.contentview.ContentViewWithButton.Theme;
import com.facebook.friendsnearby.ExperimentsForFriendsNearbyModule;
import com.facebook.friendsnearby.model.FriendsNearbyRow;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.widget.touch.TouchDelegateUtils;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: X  */
public class FriendsNearbyRowView extends ContentViewWithButton {
    private static final CallerContext f20994h = CallerContext.a(FriendsNearbyRowView.class, "friends_nearby");
    private GlyphColorizer f20995i;
    private boolean f20996j;
    private boolean f20997k;
    private FbDraweeView f20998l;
    public FriendsNearbyRow f20999m;
    public OnClickListener f21000n;

    /* compiled from: X  */
    public interface OnClickListener {
        void mo945a(FriendsNearbyRow friendsNearbyRow);

        void mo946a(FriendsNearbyRowView friendsNearbyRowView, FriendsNearbyRow friendsNearbyRow);
    }

    /* compiled from: X  */
    class C29841 implements android.view.View.OnClickListener {
        final /* synthetic */ FriendsNearbyRowView f20992a;

        C29841(FriendsNearbyRowView friendsNearbyRowView) {
            this.f20992a = friendsNearbyRowView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 66426955);
            this.f20992a.f21000n.mo945a(this.f20992a.f20999m);
            Logger.a(2, EntryType.UI_INPUT_END, 2091072957, a);
        }
    }

    /* compiled from: X  */
    class C29852 implements android.view.View.OnClickListener {
        final /* synthetic */ FriendsNearbyRowView f20993a;

        C29852(FriendsNearbyRowView friendsNearbyRowView) {
            this.f20993a = friendsNearbyRowView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -150520131);
            this.f20993a.f21000n.mo946a(this.f20993a, this.f20993a.f20999m);
            Logger.a(2, EntryType.UI_INPUT_END, 642028402, a);
        }
    }

    private static <T extends View> void m21980a(Class<T> cls, T t) {
        m21981a((Object) t, t.getContext());
    }

    private static void m21981a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((FriendsNearbyRowView) obj).m21979a(GlyphColorizer.a(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector));
    }

    public FriendsNearbyRowView(Context context) {
        super(context);
        m21984h();
    }

    public FriendsNearbyRowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m21984h();
    }

    public FriendsNearbyRowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m21984h();
    }

    @Inject
    private void m21979a(GlyphColorizer glyphColorizer, QeAccessor qeAccessor) {
        this.f20995i = glyphColorizer;
        this.f20996j = qeAccessor.a(ExperimentsForFriendsNearbyModule.f20448b, false);
        this.f20997k = qeAccessor.a(ExperimentsForFriendsNearbyModule.f20449c, false);
    }

    private void m21984h() {
        DraweeHierarchy u;
        m21980a(FriendsNearbyRowView.class, (View) this);
        setContentView(2130904535);
        if (getBackground() == null) {
            setBackgroundResource(2130839798);
        }
        setBorderColor(getResources().getColor(2131363924));
        a(0, (int) getResources().getDimension(2131427382), 0, 0);
        this.f20998l = new FbDraweeView(getContext());
        if (m21985i()) {
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(getResources());
            genericDraweeHierarchyBuilder.u = RoundingParams.e();
            u = genericDraweeHierarchyBuilder.u();
        } else {
            u = new GenericDraweeHierarchyBuilder(getResources()).u();
        }
        this.f20998l.setHierarchy(u);
        setThumbnailView(this.f20998l);
        setThumbnailSize(ThumbnailSize.LARGE);
        setOnClickListener(new C29841(this));
        this.a.setOnClickListener(new C29852(this));
    }

    public final void m21986a(FriendsNearbyRow friendsNearbyRow, OnClickListener onClickListener) {
        this.f20999m = friendsNearbyRow;
        this.f21000n = onClickListener;
        m21987g();
    }

    public final void m21987g() {
        Preconditions.checkNotNull(this.f20999m.mo916e());
        Context context = getContext();
        Resources resources = getResources();
        this.f20998l.a(this.f20999m.mo911b(), f20994h);
        boolean z = this.f20996j && this.f20999m.mo916e().startsWith("check_in");
        m21982a(z);
        setTitleText(this.f20999m.mo913c());
        FriendsNearbyRow friendsNearbyRow = this.f20999m;
        getContext();
        setMetaText(friendsNearbyRow.mo915d());
        this.a.setVisibility(this.f20999m.mo917f() ? 0 : 8);
        if (this.f20999m.mo917f()) {
            this.a.setEnabled(this.f20999m.mo918g());
            setActionButtonDrawable(this.f20999m.mo910b(resources));
            setActionButtonText(this.f20999m.mo912b(context));
            setActionButtonTheme(this.f20999m.mo919h());
            setActionButtonContentDescription(this.f20999m.mo914c(context));
            if (this.f20999m.mo919h() == Theme.NONE) {
                setActionButtonBackground(this.f20999m.mo907a(resources));
                this.a.setPadding(0, 0, 0, 0);
            }
        }
    }

    private boolean m21985i() {
        return this.f20996j || this.f20997k;
    }

    private void m21982a(boolean z) {
        if (z) {
            Resources resources = getResources();
            Drawable a = this.f20995i.a(2130839970, resources.getColor(2131363923));
            Preconditions.checkNotNull(a);
            int dimensionPixelSize = resources.getDimensionPixelSize(2131430241);
            a.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            CharSequence spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append(" ");
            spannableStringBuilder.setSpan(new ImageSpan(a, 1), 0, spannableStringBuilder.length(), 0);
            spannableStringBuilder.append(this.f20999m.mo909a(getContext()));
            setSubtitleText(spannableStringBuilder);
            setMaxLinesFromThumbnailSize(false);
            e(1, 2);
            return;
        }
        setSubtitleText(this.f20999m.mo909a(getContext()));
        nF_();
        setMaxLinesFromThumbnailSize(true);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z && this.f20999m != null) {
            View view = this.a;
            TouchDelegate a = TouchDelegateUtils.a(view, view.getParent(), 18, -1, -1, -1);
            view = (View) this.a.getParent();
            if (!this.f20999m.mo917f()) {
                a = null;
            }
            view.setTouchDelegate(a);
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f20999m != null && m21985i()) {
            Preconditions.checkNotNull(this.f20999m.mo916e());
            Drawable a = this.f20999m.mo916e().startsWith("aura") ? ContextCompat.a(getContext(), 2130840491) : ContextCompat.a(getContext(), 2130840467);
            a.setBounds(this.f20998l.getRight() - a.getIntrinsicWidth(), this.f20998l.getBottom() - a.getIntrinsicHeight(), this.f20998l.getRight(), this.f20998l.getBottom());
            a.draw(canvas);
        }
    }
}
