package com.facebook.photos.creativeediting.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.tempfile.TempFileManager;
import com.facebook.common.ui.keyboard.SoftInputDetector;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.creativeediting.utilities.TextPaintUtilities;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import java.io.File;
import java.io.FileOutputStream;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: live_videos_watching_events */
public class KeyboardAwareEditText extends EditText {
    private static final String f9976e = KeyboardAwareEditText.class.getSimpleName();
    @Inject
    public TempFileManager f9977a;
    @Inject
    public SoftInputDetector f9978b;
    @Inject
    public QeAccessor f9979c;
    @Inject
    public AbstractFbErrorReporter f9980d;
    private final TextWatcher f9981f = new C08331(this);
    public KeyboardEventCallBack f9982g;
    public InputMethodManager f9983h;

    /* compiled from: live_videos_watching_events */
    class C08331 implements TextWatcher {
        final /* synthetic */ KeyboardAwareEditText f9971a;
        private int f9972b = this.f9971a.getLineCount();

        C08331(KeyboardAwareEditText keyboardAwareEditText) {
            this.f9971a = keyboardAwareEditText;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f9972b = this.f9971a.getLineCount();
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            float f = this.f9971a.getResources().getDisplayMetrics().scaledDensity;
            f = this.f9971a.getTextSize();
            if (this.f9971a.getLineCount() < this.f9972b && f < ((float) this.f9971a.getResources().getDimensionPixelSize(2131429540)) && this.f9971a.getTop() > 0) {
                this.f9971a.setTextSize(0, f / 0.9f);
            }
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    /* compiled from: live_videos_watching_events */
    class C08342 implements Runnable {
        final /* synthetic */ KeyboardAwareEditText f9973a;

        C08342(KeyboardAwareEditText keyboardAwareEditText) {
            this.f9973a = keyboardAwareEditText;
        }

        public void run() {
            this.f9973a.m11930a();
        }
    }

    /* compiled from: live_videos_watching_events */
    class C08353 implements Runnable {
        final /* synthetic */ KeyboardAwareEditText f9974a;

        C08353(KeyboardAwareEditText keyboardAwareEditText) {
            this.f9974a = keyboardAwareEditText;
        }

        public void run() {
            if (!this.f9974a.f9983h.showSoftInput(this.f9974a, 0)) {
                this.f9974a.m11932b();
                this.f9974a.f9983h.toggleSoftInput(0, 0);
                this.f9974a.f9983h.showSoftInput(this.f9974a, 0);
            }
            this.f9974a.f9982g.mo594a(this.f9974a.f9978b.e);
        }
    }

    /* compiled from: live_videos_watching_events */
    class C08364 implements OnEditorActionListener {
        final /* synthetic */ KeyboardAwareEditText f9975a;

        C08364(KeyboardAwareEditText keyboardAwareEditText) {
            this.f9975a = keyboardAwareEditText;
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 6) {
                return false;
            }
            this.f9975a.m11932b();
            return true;
        }
    }

    /* compiled from: live_videos_watching_events */
    public interface KeyboardEventCallBack {
        void mo593a();

        void mo594a(int i);
    }

    private static <T extends View> void m11926a(Class<T> cls, T t) {
        m11927a((Object) t, t.getContext());
    }

    private static void m11927a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        KeyboardAwareEditText keyboardAwareEditText = (KeyboardAwareEditText) obj;
        TempFileManager a = TempFileManager.a(fbInjector);
        SoftInputDetector a2 = SoftInputDetector.a(fbInjector);
        QeAccessor qeAccessor = (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector);
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        keyboardAwareEditText.f9977a = a;
        keyboardAwareEditText.f9978b = a2;
        keyboardAwareEditText.f9979c = qeAccessor;
        keyboardAwareEditText.f9980d = abstractFbErrorReporter;
    }

    public KeyboardAwareEditText(Context context) {
        super(context);
        m11929e();
    }

    public KeyboardAwareEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11929e();
    }

    public KeyboardAwareEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11929e();
    }

    private void m11929e() {
        m11926a(KeyboardAwareEditText.class, (View) this);
        this.f9983h = (InputMethodManager) getContext().getSystemService("input_method");
        setOnEditorActionListener(getOnEditorActionListener());
        addTextChangedListener(this.f9981f);
    }

    public final void m11930a() {
        if (getLineCount() * getLineHeight() >= getMeasuredHeight()) {
            setTextSize(0, getTextSize() * 0.9f);
            requestLayout();
        }
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 1 || !this.f9978b.f) {
            return super.dispatchKeyEvent(keyEvent);
        }
        m11932b();
        if (getParent() != null) {
            ((View) getParent()).requestFocus();
        }
        return true;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        post(new C08342(this));
        super.onLayout(z, i, i2, i3, i4);
    }

    public void onMeasure(int i, int i2) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 457631453);
        this.f9978b.a(this, i2);
        super.onMeasure(i, i2);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1140669140, a);
    }

    protected void setCallBack(KeyboardEventCallBack keyboardEventCallBack) {
        this.f9982g = keyboardEventCallBack;
    }

    public final void m11932b() {
        clearFocus();
        setEnabled(false);
        setFocusable(false);
        setFocusableInTouchMode(false);
        this.f9983h.hideSoftInputFromWindow(getWindowToken(), 0);
        this.f9982g.mo593a();
    }

    public final boolean m11933c() {
        return this.f9978b.f;
    }

    @Nullable
    protected final void m11931a(File file) {
        Throwable th;
        setDrawingCacheEnabled(true);
        FileOutputStream fileOutputStream;
        try {
            TextPaint textPaint = new TextPaint(3);
            textPaint.setColor(getCurrentTextColor());
            textPaint.setTextSize((float) ((int) (getTextSize() * 2.0f)));
            int measuredHeight = getMeasuredHeight() * 2;
            int measuredWidth = getMeasuredWidth() * 2;
            if (getLayout() instanceof DynamicLayout) {
                measuredWidth = TextPaintUtilities.a(textPaint, (DynamicLayout) getLayout());
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(getLayout() != null ? "Layout class: " + getLayout().getClass().getSimpleName() : "Layout class: null");
                stringBuilder.append(getText() != null ? ", text class: " + getText().getClass().getSimpleName() : ", text class: null");
                this.f9980d.b(f9976e, stringBuilder.toString());
            }
            StaticLayout staticLayout = new StaticLayout(getText().toString(), textPaint, measuredWidth, Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
            Bitmap createBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            fileOutputStream = new FileOutputStream(file);
            try {
                staticLayout.draw(canvas);
                createBitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.close();
            } catch (Throwable th2) {
                th = th2;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }

    public final void m11934d() {
        setEnabled(true);
        setFocusable(true);
        setFocusableInTouchMode(true);
        bringToFront();
        requestFocus();
        post(new C08353(this));
    }

    private OnEditorActionListener getOnEditorActionListener() {
        return new C08364(this);
    }
}
