package com.facebook.platform.composer.footer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: rich_document_block_type */
public class PlatformComposerFooterView extends LinearLayout {
    private GlyphView f4147a;
    private GlyphView f4148b;
    private GlyphView f4149c;
    private GlyphView f4150d;
    private GlyphView f4151e;
    private GlyphView f4152f;
    private View f4153g;
    private View f4154h;
    private int f4155i;
    private ImmutableList<GlyphView> f4156j;

    /* compiled from: rich_document_block_type */
    class C05401 implements OnMenuItemClickListener {
        final /* synthetic */ PlatformComposerFooterView f4143a;

        C05401(PlatformComposerFooterView platformComposerFooterView) {
            this.f4143a = platformComposerFooterView;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            this.f4143a.findViewById(menuItem.getItemId()).callOnClick();
            return true;
        }
    }

    /* compiled from: rich_document_block_type */
    public enum ButtonType {
        PHOTO,
        ALBUM,
        MINUTIAE,
        PEOPLE_TAGGING,
        PLACE_TAGGING,
        POST,
        BIG_POST
    }

    public PlatformComposerFooterView(Context context) {
        super(context);
        m4108b();
    }

    public PlatformComposerFooterView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m4108b();
    }

    private void m4108b() {
        this.f4155i = Integer.MAX_VALUE;
    }

    protected void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 637624229);
        super.onFinishInflate();
        this.f4147a = (GlyphView) findViewById(2131563423);
        this.f4148b = (GlyphView) findViewById(2131566101);
        this.f4149c = (GlyphView) findViewById(2131558584);
        this.f4150d = (GlyphView) findViewById(2131566102);
        this.f4151e = (GlyphView) findViewById(2131566103);
        this.f4152f = (GlyphView) findViewById(2131566104);
        this.f4153g = findViewById(2131566105);
        this.f4154h = findViewById(2131566106);
        this.f4156j = ImmutableList.of(this.f4147a, this.f4148b, this.f4149c, this.f4150d, this.f4151e);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -719878185, a);
    }

    public final void m4110a() {
        this.f4149c.setVisibility(0);
        this.f4150d.setVisibility(0);
        this.f4151e.setVisibility(0);
        int size = this.f4156j.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            if (((GlyphView) this.f4156j.get(i)).getVisibility() == 0) {
                i3 = i2 + 1;
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        if (i2 <= this.f4155i) {
            this.f4152f.setVisibility(8);
            return;
        }
        List arrayList = new ArrayList();
        int size2 = this.f4156j.size();
        i = 0;
        i2 = 0;
        while (i < size2) {
            GlyphView glyphView = (GlyphView) this.f4156j.get(i);
            if (glyphView.getVisibility() == 0 && i2 == this.f4155i - 1) {
                arrayList.add(glyphView);
                glyphView.setVisibility(8);
                i3 = i2;
            } else {
                i3 = i2 + 1;
            }
            i++;
            i2 = i3;
        }
        this.f4152f.setVisibility(0);
        final PopupMenu popupMenu = new PopupMenu(getContext(), this.f4152f);
        popupMenu.getMenu().clear();
        for (i2 = 0; i2 < arrayList.size(); i2++) {
            popupMenu.getMenu().add(0, ((GlyphView) arrayList.get(i2)).getId(), i2, ((GlyphView) arrayList.get(i2)).getContentDescription());
        }
        popupMenu.setOnMenuItemClickListener(new C05401(this));
        this.f4152f.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PlatformComposerFooterView f4145b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1635235623);
                popupMenu.show();
                Logger.a(2, EntryType.UI_INPUT_END, 912843789, a);
            }
        });
    }

    public void setMaxVisibleButtonAllowed(int i) {
        if (i <= 0) {
            i = 0;
        }
        this.f4155i = i;
    }

    public final void m4112a(ButtonType buttonType, boolean z) {
        GlyphView b = m4107b(buttonType);
        if (b != null) {
            b.setActivated(z);
        }
    }

    public final void m4113b(ButtonType buttonType, boolean z) {
        View a = m4109a(buttonType);
        if (a != null) {
            a.setEnabled(z);
        }
    }

    public final void m4111a(ButtonType buttonType, OnClickListener onClickListener) {
        View a = m4109a(buttonType);
        if (a != null) {
            a.setOnClickListener(onClickListener);
        }
    }

    public final void m4114c(ButtonType buttonType, boolean z) {
        View a = m4109a(buttonType);
        if (a != null) {
            a.setVisibility(z ? 0 : 8);
        }
    }

    public final View m4109a(ButtonType buttonType) {
        switch (buttonType) {
            case PHOTO:
                return this.f4147a;
            case ALBUM:
                return this.f4148b;
            case MINUTIAE:
                return this.f4149c;
            case PEOPLE_TAGGING:
                return this.f4150d;
            case PLACE_TAGGING:
                return this.f4151e;
            case POST:
                return this.f4153g;
            case BIG_POST:
                return this.f4154h;
            default:
                return null;
        }
    }

    private GlyphView m4107b(ButtonType buttonType) {
        View a = m4109a(buttonType);
        return a instanceof GlyphView ? (GlyphView) a : null;
    }
}
