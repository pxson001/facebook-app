package com.facebook.platform.composer.privacy;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.composer.privacy.common.ComposerFixedPrivacyData;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.privacy.ui.PrivacyIcons;
import com.facebook.privacy.ui.PrivacyIcons.Size;
import com.facebook.resources.utils.TextViewUtils;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: review_character_count */
public class PlatformComposerFixedPrivacyView extends CustomLinearLayout {
    @Inject
    PlatformComposerTagExpandPrivacyHelper f4235a;
    @Inject
    GlyphColorizer f4236b;
    @Inject
    PrivacyIcons f4237c;
    private View f4238d;
    public TextView f4239e;
    public Tooltip f4240f;
    private boolean f4241g = false;
    private ImmutableList<BaseToken> f4242h;

    /* compiled from: review_character_count */
    class C05441 implements OnLongClickListener {
        final /* synthetic */ PlatformComposerFixedPrivacyView f4232a;

        C05441(PlatformComposerFixedPrivacyView platformComposerFixedPrivacyView) {
            this.f4232a = platformComposerFixedPrivacyView;
        }

        public boolean onLongClick(View view) {
            Layout layout = this.f4232a.f4239e.getLayout();
            if (layout == null || layout.getLineCount() <= 0 || layout.getEllipsisCount(0) <= 0) {
                return false;
            }
            Toast makeText = Toast.makeText(this.f4232a.getContext(), this.f4232a.f4239e.getText().toString(), 1);
            makeText.setGravity(48, 0, 0);
            makeText.show();
            return true;
        }
    }

    private static <T extends View> void m4184a(Class<T> cls, T t) {
        m4185a((Object) t, t.getContext());
    }

    private static void m4185a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PlatformComposerFixedPrivacyView) obj).m4183a(PlatformComposerTagExpandPrivacyHelper.m4201a(fbInjector), GlyphColorizer.a(fbInjector), PrivacyIcons.a(fbInjector));
    }

    public PlatformComposerFixedPrivacyView(Context context) {
        super(context);
        m4182a();
    }

    public PlatformComposerFixedPrivacyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4182a();
    }

    public PlatformComposerFixedPrivacyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4182a();
    }

    private void m4182a() {
        m4184a(PlatformComposerFixedPrivacyView.class, (View) this);
        setContentView(2130906303);
        this.f4238d = a(2131560502);
        this.f4239e = (TextView) findViewById(2131560503);
        setOnLongClickListener(new C05441(this));
    }

    private void m4183a(PlatformComposerTagExpandPrivacyHelper platformComposerTagExpandPrivacyHelper, GlyphColorizer glyphColorizer, PrivacyIcons privacyIcons) {
        this.f4235a = platformComposerTagExpandPrivacyHelper;
        this.f4236b = glyphColorizer;
        this.f4237c = privacyIcons;
    }

    public final void m4189a(ComposerFixedPrivacyData composerFixedPrivacyData, GraphQLAlbum graphQLAlbum) {
        Preconditions.checkArgument(composerFixedPrivacyData.a != null);
        this.f4238d.setVisibility(8);
        this.f4239e.setCompoundDrawablePadding(getResources().getDimensionPixelSize(2131432443));
        int a = this.f4237c.a(composerFixedPrivacyData.a, Size.PILL);
        CharSequence charSequence = composerFixedPrivacyData.b;
        if (graphQLAlbum != null) {
            String n;
            this.f4238d.setVisibility(0);
            Drawable drawable = getResources().getDrawable(this.f4237c.a(composerFixedPrivacyData.a, Size.TOKEN));
            drawable.setColorFilter(getResources().getColor(2131361974), Mode.SRC_IN);
            TextViewUtils.a(this.f4239e, drawable, null, null, null);
            this.f4239e.setVisibility(0);
            this.f4239e.setCompoundDrawablePadding(getResources().getDimensionPixelSize(2131427789));
            TextView textView = this.f4239e;
            Resources resources = getResources();
            Object[] objArr = new Object[2];
            if (graphQLAlbum != null) {
                n = graphQLAlbum.D().n();
            } else {
                n = "";
            }
            objArr[0] = n;
            if (graphQLAlbum != null) {
                n = graphQLAlbum.E().a();
            } else {
                n = "";
            }
            objArr[1] = n;
            textView.setText(resources.getString(2131234263, objArr));
        } else {
            if (charSequence != null) {
                this.f4239e.setText(charSequence);
            }
            if (a != 0) {
                TextViewUtils.a(this.f4239e, m4188c(a), null, null, null);
            }
        }
        setOnClickListener(m4179a(composerFixedPrivacyData.c));
    }

    private OnClickListener m4179a(final String str) {
        return new OnClickListener(this) {
            final /* synthetic */ PlatformComposerFixedPrivacyView f4234b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 406168410);
                if (Strings.isNullOrEmpty(str)) {
                    Logger.a(2, EntryType.UI_INPUT_END, -277501431, a);
                    return;
                }
                if (this.f4234b.f4240f == null) {
                    this.f4234b.f4240f = new Tooltip(this.f4234b.getContext());
                    this.f4234b.f4240f.t = -1;
                    this.f4234b.f4240f.c(this.f4234b);
                }
                this.f4234b.f4240f.b(str);
                this.f4234b.f4240f.d();
                LogUtils.a(1740917948, a);
            }
        };
    }

    private void m4187b() {
        this.f4239e.setText(this.f4235a.m4204a(getContext(), this.f4242h, this.f4239e.getTextSize(), this.f4239e.getMeasuredWidth(), true));
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 354615795);
        super.onSizeChanged(i, i2, i3, i4);
        this.f4241g = true;
        invalidate();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1866222035, a);
    }

    protected void onDraw(Canvas canvas) {
        if (this.f4241g && this.f4242h != null) {
            this.f4241g = false;
            m4187b();
        }
    }

    private Drawable m4188c(int i) {
        return this.f4236b.a(i, -7235677);
    }
}
