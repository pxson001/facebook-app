package com.facebook.redspace.ui.friendslist;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.contentview.ContentViewWithButton;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.redspace.abtest.ExperimentsForRedSpaceExperimentsModule;
import com.facebook.redspace.abtest.RedSpaceFriendsLayout;
import com.facebook.redspace.abtest.RedSpaceStrings;
import com.facebook.redspace.data.RedSpaceFriendsSection;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;

/* compiled from: Payment Required */
public class RedSpaceFriendsTitleView extends ContentViewWithButton {
    private RedSpaceFriendsSection f12491h;
    private boolean f12492i;
    public OnEditModeSwitchListener f12493j;
    public boolean f12494k;
    @Inject
    private GlyphColorizer f12495l;
    @Inject
    private Resources f12496m;
    @Inject
    private RedSpaceStrings f12497n;
    @Inject
    private QeAccessor f12498o;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<AllCapsTransformationMethod> f12499p = UltralightRuntime.b;

    /* compiled from: Payment Required */
    public interface OnEditModeSwitchListener {
        void mo341a();

        void mo342b();
    }

    /* compiled from: Payment Required */
    class C14771 implements OnClickListener {
        final /* synthetic */ RedSpaceFriendsTitleView f12490a;

        C14771(RedSpaceFriendsTitleView redSpaceFriendsTitleView) {
            this.f12490a = redSpaceFriendsTitleView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -165864649);
            if (this.f12490a.f12493j != null) {
                if (this.f12490a.f12494k) {
                    this.f12490a.f12493j.mo342b();
                } else {
                    this.f12490a.f12493j.mo341a();
                }
            }
            LogUtils.a(-1434385840, a);
        }
    }

    private static <T extends View> void m12898a(Class<T> cls, T t) {
        m12899a((Object) t, t.getContext());
    }

    private static void m12899a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((RedSpaceFriendsTitleView) obj).m12897a(GlyphColorizer.a(fbInjector), ResourcesMethodAutoProvider.a(fbInjector), RedSpaceStrings.a(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), IdBasedLazy.a(fbInjector, 1281));
    }

    public RedSpaceFriendsTitleView(Context context) {
        super(context);
        m12902g();
    }

    public RedSpaceFriendsTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12902g();
    }

    public RedSpaceFriendsTitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12902g();
    }

    private void m12902g() {
        m12898a(RedSpaceFriendsTitleView.class, (View) this);
    }

    protected void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -514829144);
        super.onFinishInflate();
        setActionButtonOnClickListener(new C14771(this));
        int dimensionPixelSize = this.f12496m.getDimensionPixelSize(2131430542);
        this.a.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        this.a.getLayoutParams().height = -1;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1986478939, a);
    }

    private void m12897a(GlyphColorizer glyphColorizer, Resources resources, RedSpaceStrings redSpaceStrings, QeAccessor qeAccessor, com.facebook.inject.Lazy<AllCapsTransformationMethod> lazy) {
        this.f12495l = glyphColorizer;
        this.f12496m = resources;
        this.f12497n = redSpaceStrings;
        this.f12498o = qeAccessor;
        this.f12499p = lazy;
    }

    public final void m12905a(RedSpaceFriendsSection redSpaceFriendsSection, boolean z, boolean z2) {
        if (this.f12491h != redSpaceFriendsSection || this.f12492i != z || this.f12494k != z2) {
            int i;
            int i2;
            CharSequence m;
            this.f12491h = redSpaceFriendsSection;
            this.f12492i = z;
            this.f12494k = z2;
            if (redSpaceFriendsSection.isTop()) {
                i = 2130839919;
                i2 = 2131361918;
                m = this.f12497n.m();
            } else {
                i = 2130839800;
                i2 = 2131361917;
                m = z ? this.f12497n.o() : this.f12497n.n();
            }
            Drawable f = m12901f(i, i2);
            i = (int) this.f12496m.getDimension(2131430556);
            f.setBounds(0, 0, i, i);
            setThumbnailDrawable(f);
            d(i, i);
            setTitleText(m);
            setContentDescription(m);
            m12903h();
        }
    }

    private void m12903h() {
        Object obj;
        QeAccessor qeAccessor = this.f12498o;
        if (RedSpaceFriendsLayout.getLayout(qeAccessor) == RedSpaceFriendsLayout.LIST) {
            Object obj2;
            short s = ExperimentsForRedSpaceExperimentsModule.a;
            if (qeAccessor.a(ExperimentsForRedSpaceExperimentsModule.e, false) && qeAccessor.a(s, false)) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 != null) {
                obj = 1;
                if (obj == null && this.f12491h == RedSpaceFriendsSection.TOP) {
                    setShowActionButton(true);
                    setActionButtonText(((AllCapsTransformationMethod) this.f12499p.get()).getTransformation(this.f12496m.getString(this.f12494k ? 2131230733 : 2131230734), this.a));
                    return;
                }
                setShowActionButton(false);
            }
        }
        obj = null;
        if (obj == null) {
        }
        setShowActionButton(false);
    }

    public void setShowActionButton(boolean z) {
        super.setShowActionButton(z);
        m12904i();
    }

    private void m12904i() {
        int i;
        boolean a = RTLUtil.a(getContext());
        int paddingRight = a ? getPaddingRight() : getPaddingLeft();
        if (f()) {
            i = 0;
        } else {
            i = paddingRight;
        }
        if (!a) {
            int i2 = i;
            i = paddingRight;
            paddingRight = i2;
        }
        setPadding(i, getPaddingTop(), paddingRight, getPaddingBottom());
    }

    private Drawable m12901f(int i, int i2) {
        Drawable a = this.f12495l.a(i, -1);
        new ShapeDrawable(new OvalShape()).getPaint().setColor(this.f12496m.getColor(i2));
        Drawable layerDrawable = new LayerDrawable(new Drawable[]{r3, a});
        int intrinsicWidth = (int) (((float) a.getIntrinsicWidth()) * 0.2f);
        layerDrawable.setLayerInset(1, intrinsicWidth, intrinsicWidth, intrinsicWidth, intrinsicWidth);
        return layerDrawable;
    }

    public void setEditModeListener(OnEditModeSwitchListener onEditModeSwitchListener) {
        this.f12493j = onEditModeSwitchListener;
    }
}
