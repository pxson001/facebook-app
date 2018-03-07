package com.facebook.photos.creativeediting.ui;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.FindViewUtil;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.doodle.ColourIndicator;
import com.facebook.messaging.doodle.ColourPicker;
import com.facebook.messaging.doodle.ColourPicker.OnColourPickerInteractionListener;
import com.facebook.photos.creativeediting.model.TextParams;
import com.facebook.photos.creativeediting.ui.KeyboardAwareEditText.KeyboardEventCallBack;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomFrameLayout;
import java.io.File;
import javax.annotation.Nullable;

/* compiled from: live_photo_view */
public class PhotoTextEditorEntryLayout extends CustomFrameLayout {
    @Nullable
    public TextParams f10025a;
    public KeyboardAwareEditText f10026b;
    public ColourIndicator f10027c;
    public ColourPicker f10028d;
    public ImageView f10029e;
    public FbDraweeView f10030f;
    public View f10031g;
    public CustomFrameLayout f10032h;
    public boolean f10033i;

    /* compiled from: live_photo_view */
    public class C08461 implements OnClickListener {
        final /* synthetic */ PhotoTextEditorEntryLayout f10022a;

        public C08461(PhotoTextEditorEntryLayout photoTextEditorEntryLayout) {
            this.f10022a = photoTextEditorEntryLayout;
        }

        public void onClick(View view) {
            Logger.a(2, EntryType.UI_INPUT_END, -516258459, Logger.a(2, EntryType.UI_INPUT_START, -662643841));
        }
    }

    /* compiled from: live_photo_view */
    public class C08472 implements OnClickListener {
        final /* synthetic */ PhotoTextEditorEntryLayout f10023a;

        public C08472(PhotoTextEditorEntryLayout photoTextEditorEntryLayout) {
            this.f10023a = photoTextEditorEntryLayout;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2067506587);
            if (this.f10023a.f10026b.m11933c()) {
                this.f10023a.f10026b.m11932b();
            } else {
                this.f10023a.f10026b.m11934d();
            }
            LogUtils.a(1010135870, a);
        }
    }

    /* compiled from: live_photo_view */
    public class C08483 implements OnColourPickerInteractionListener {
        final /* synthetic */ PhotoTextEditorEntryLayout f10024a;

        public C08483(PhotoTextEditorEntryLayout photoTextEditorEntryLayout) {
            this.f10024a = photoTextEditorEntryLayout;
        }

        public final void mo545a(int i, float f, float f2, float f3) {
            this.f10024a.f10027c.m9447a(i, f, f2, f3);
            this.f10024a.f10026b.setTextColor(i);
        }

        public final void mo544a(int i) {
            this.f10024a.f10027c.setColour(i);
            this.f10024a.f10027c.m9446a();
            this.f10024a.f10026b.setTextColor(i);
            this.f10024a.f10033i = true;
        }
    }

    public PhotoTextEditorEntryLayout(Context context) {
        super(context);
        View inflate = LayoutInflater.from(getContext()).inflate(2130906217, this);
        this.f10032h = (CustomFrameLayout) FindViewUtil.b(inflate, 2131565885);
        this.f10026b = (KeyboardAwareEditText) FindViewUtil.b(inflate, 2131559443);
        this.f10027c = (ColourIndicator) FindViewUtil.b(inflate, 2131565938);
        this.f10028d = (ColourPicker) FindViewUtil.b(inflate, 2131565939);
        this.f10029e = (ImageView) FindViewUtil.b(inflate, 2131563751);
        this.f10030f = (FbDraweeView) FindViewUtil.b(inflate, 2131561116);
        this.f10031g = FindViewUtil.b(inflate, 2131565937);
        setOnClickListener(new C08461(this));
        this.f10031g.setOnClickListener(new C08472(this));
    }

    public void setCallBack(KeyboardEventCallBack keyboardEventCallBack) {
        this.f10026b.f9982g = keyboardEventCallBack;
    }

    public final void m11961a(FbDraweeControllerBuilder fbDraweeControllerBuilder, Uri uri, int i, int i2, @Nullable Postprocessor postprocessor) {
        ImageRequestBuilder a = ImageRequestBuilder.a(uri);
        a.d = new ResizeOptions(i, i2);
        a = a;
        a.j = postprocessor;
        this.f10030f.setController(((FbDraweeControllerBuilder) fbDraweeControllerBuilder.c(a.m())).a(CallerContext.a(PhotoTextEditorEntryLayout.class)).s());
    }

    public String getText() {
        return this.f10026b.getText().toString();
    }

    public final void m11962a(File file) {
        this.f10026b.m11930a();
        this.f10026b.m11931a(file);
    }

    public final void m11960a() {
        this.f10025a = null;
        this.f10033i = false;
        this.f10026b.setText("");
        this.f10026b.setTextColor(-1);
        this.f10026b.setTextSize(0, (float) getResources().getDimensionPixelSize(2131429540));
        this.f10026b.setVisibility(8);
        this.f10027c.setVisibility(8);
        this.f10027c.setEnabled(false);
        this.f10028d.setVisibility(8);
        this.f10028d.setEnabled(false);
        this.f10029e.setVisibility(8);
        this.f10030f.setVisibility(8);
        this.f10031g.setVisibility(8);
        setVisibility(8);
    }

    public final void m11963e() {
        this.f10026b.clearComposingText();
    }

    public int getTextWidth() {
        return this.f10026b.getMeasuredWidth();
    }

    public int getTextHeight() {
        return this.f10026b.getMeasuredHeight();
    }

    public int getTextColor() {
        return this.f10026b.getCurrentTextColor();
    }

    @Nullable
    public String getTextId() {
        return this.f10025a != null ? this.f10025a.g() : null;
    }

    public final boolean m11964g() {
        return this.f10033i;
    }

    public void setTextParams(@Nullable TextParams textParams) {
        this.f10025a = textParams;
        if (this.f10025a != null) {
            this.f10026b.setTextColor(this.f10025a.m());
            Object l = this.f10025a.l();
            this.f10026b.setText(l);
            this.f10026b.setSelection(l.length());
        }
    }
}
