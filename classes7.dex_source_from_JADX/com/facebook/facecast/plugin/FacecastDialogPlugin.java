package com.facebook.facecast.plugin;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.annotation.Nullable;

/* compiled from: brand */
public class FacecastDialogPlugin extends FacecastBasePlugin {
    public final FbTextView f18233c = ((FbTextView) a(2131561630));
    public final FbTextView f18234d = ((FbTextView) a(2131561631));
    public final FbButton f18235e = ((FbButton) a(2131561632));
    public final FbButton f18236f = ((FbButton) a(2131561633));

    /* compiled from: brand */
    class C15381 implements OnClickListener {
        final /* synthetic */ FacecastDialogPlugin f18244a;

        C15381(FacecastDialogPlugin facecastDialogPlugin) {
            this.f18244a = facecastDialogPlugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1206104866);
            if (view == this.f18244a.f18235e) {
                this.f18244a.mo1414g();
            } else if (view == this.f18244a.f18236f) {
                this.f18244a.mo1415h();
            }
            LogUtils.a(-745577614, a);
        }
    }

    @SuppressLint({"ConstructorMayLeakThis"})
    public FacecastDialogPlugin(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130904201);
        OnClickListener c15381 = new C15381(this);
        this.f18235e.setOnClickListener(c15381);
        this.f18236f.setOnClickListener(c15381);
    }

    protected void mo1414g() {
    }

    protected void mo1415h() {
    }

    public final boolean mo1409a() {
        mo1414g();
        return true;
    }
}
