package com.facebook.composer.privacy.common;

import android.content.Context;
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
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
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

/* compiled from: tapped_places_map */
public class FixedPrivacyView extends CustomLinearLayout {
    @Inject
    TagExpandPrivacyHelper f2029a;
    @Inject
    GlyphColorizer f2030b;
    @Inject
    PrivacyIcons f2031c;
    private View f2032d;
    public TextView f2033e;
    public Tooltip f2034f;
    private boolean f2035g = false;
    private ImmutableList<BaseToken> f2036h;

    /* compiled from: tapped_places_map */
    class C02101 implements OnLongClickListener {
        final /* synthetic */ FixedPrivacyView f2026a;

        C02101(FixedPrivacyView fixedPrivacyView) {
            this.f2026a = fixedPrivacyView;
        }

        public boolean onLongClick(View view) {
            Layout layout = this.f2026a.f2033e.getLayout();
            if (layout == null || layout.getLineCount() <= 0 || layout.getEllipsisCount(0) <= 0) {
                return false;
            }
            Toast makeText = Toast.makeText(this.f2026a.getContext(), this.f2026a.f2033e.getText().toString(), 1);
            makeText.setGravity(48, 0, 0);
            makeText.show();
            return true;
        }
    }

    private static <T extends View> void m1978a(Class<T> cls, T t) {
        m1979a((Object) t, t.getContext());
    }

    private static void m1979a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((FixedPrivacyView) obj).m1977a(TagExpandPrivacyHelper.m1991a(injectorLike), GlyphColorizer.a(injectorLike), PrivacyIcons.a(injectorLike));
    }

    private void m1977a(TagExpandPrivacyHelper tagExpandPrivacyHelper, GlyphColorizer glyphColorizer, PrivacyIcons privacyIcons) {
        this.f2029a = tagExpandPrivacyHelper;
        this.f2030b = glyphColorizer;
        this.f2031c = privacyIcons;
    }

    public FixedPrivacyView(Context context) {
        super(context);
        m1976a();
    }

    public FixedPrivacyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m1976a();
    }

    public FixedPrivacyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1976a();
    }

    private void m1976a() {
        m1978a(FixedPrivacyView.class, (View) this);
        setContentView(2130903672);
        this.f2032d = a(2131560502);
        this.f2033e = (TextView) findViewById(2131560503);
        setOnLongClickListener(new C02101(this));
    }

    public final void m1983a(ComposerFixedPrivacyData composerFixedPrivacyData, GraphQLAlbum graphQLAlbum) {
        Preconditions.checkArgument(composerFixedPrivacyData.f1976a != null);
        this.f2032d.setVisibility(8);
        this.f2033e.setCompoundDrawablePadding(getResources().getDimensionPixelSize(2131429381));
        int a = this.f2031c.a(composerFixedPrivacyData.f1976a, Size.PILL);
        CharSequence charSequence = composerFixedPrivacyData.f1977b;
        if (graphQLAlbum != null) {
            this.f2032d.setVisibility(0);
            Drawable drawable = getResources().getDrawable(this.f2031c.a(composerFixedPrivacyData.f1976a, Size.TOKEN));
            drawable.setColorFilter(getResources().getColor(2131361974), Mode.SRC_IN);
            TextViewUtils.a(this.f2033e, drawable, null, null, null);
            this.f2033e.setVisibility(0);
            this.f2033e.setCompoundDrawablePadding(getResources().getDimensionPixelSize(2131427789));
            this.f2033e.setText(getResources().getString(2131234263, new Object[]{charSequence, graphQLAlbum.E().a()}));
        } else {
            if (composerFixedPrivacyData != null) {
                this.f2033e.setText(charSequence);
            }
            if (a != 0) {
                TextViewUtils.a(this.f2033e, m1982c(a), null, null, null);
            }
        }
        setOnClickListener(m1973a(composerFixedPrivacyData.f1978c));
    }

    private OnClickListener m1973a(final String str) {
        return new OnClickListener(this) {
            final /* synthetic */ FixedPrivacyView f2028b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 45111300);
                if (Strings.isNullOrEmpty(str)) {
                    Logger.a(2, EntryType.UI_INPUT_END, 1068499103, a);
                    return;
                }
                if (this.f2028b.f2034f == null) {
                    this.f2028b.f2034f = new Tooltip(this.f2028b.getContext());
                    this.f2028b.f2034f.t = -1;
                    this.f2028b.f2034f.c(this.f2028b);
                }
                this.f2028b.f2034f.b(str);
                this.f2028b.f2034f.d();
                LogUtils.a(1970205969, a);
            }
        };
    }

    private void m1981b() {
        this.f2033e.setText(this.f2029a.m1994a(getContext(), this.f2036h, this.f2033e.getTextSize(), this.f2033e.getMeasuredWidth(), true, false));
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1807664880);
        super.onSizeChanged(i, i2, i3, i4);
        this.f2035g = true;
        invalidate();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1233070905, a);
    }

    protected void onDraw(Canvas canvas) {
        if (this.f2035g && this.f2036h != null) {
            this.f2035g = false;
            m1981b();
        }
    }

    private Drawable m1982c(int i) {
        return this.f2030b.a(i, -7235677);
    }
}
