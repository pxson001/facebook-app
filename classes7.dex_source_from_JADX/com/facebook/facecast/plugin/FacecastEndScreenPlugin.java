package com.facebook.facecast.plugin;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.facebook.facecastdisplay.FacecastUtil;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: borderless */
public class FacecastEndScreenPlugin extends FacecastEndScreenBasePlugin {
    private static final String f18320h = FacecastEndScreenPlugin.class.getName();
    @Inject
    public FacecastUtil f18321g;
    private final FbButton f18322i;
    private final LinearLayout f18323j;
    @Nullable
    public AlertDialog f18324k;

    /* compiled from: borderless */
    class C15531 implements OnClickListener {
        final /* synthetic */ FacecastEndScreenPlugin f18318a;

        C15531(FacecastEndScreenPlugin facecastEndScreenPlugin) {
            this.f18318a = facecastEndScreenPlugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 907891186);
            FacecastEndScreenPlugin facecastEndScreenPlugin = this.f18318a;
            if (facecastEndScreenPlugin.f18324k == null) {
                facecastEndScreenPlugin.f18324k = new Builder(facecastEndScreenPlugin.getContext()).a(true).a(2131238238).b(2131238239).a(2131238236, new C15542(facecastEndScreenPlugin)).b(2131230727, null).a();
            } else if (facecastEndScreenPlugin.f18324k.isShowing()) {
                Logger.a(2, EntryType.UI_INPUT_END, 694871229, a);
            }
            facecastEndScreenPlugin.f18324k.show();
            Logger.a(2, EntryType.UI_INPUT_END, 694871229, a);
        }
    }

    /* compiled from: borderless */
    public class C15542 implements DialogInterface.OnClickListener {
        final /* synthetic */ FacecastEndScreenPlugin f18319a;

        public C15542(FacecastEndScreenPlugin facecastEndScreenPlugin) {
            this.f18319a = facecastEndScreenPlugin;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            this.f18319a.m22034i();
            this.f18319a.mo1441h();
        }
    }

    public static void m22035a(Object obj, Context context) {
        ((FacecastEndScreenPlugin) obj).f18321g = FacecastUtil.m3107b(FbInjector.get(context));
    }

    public FacecastEndScreenPlugin(Context context) {
        this(context, null);
    }

    private FacecastEndScreenPlugin(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private FacecastEndScreenPlugin(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = FacecastEndScreenPlugin.class;
        m22035a(this, getContext());
        LayoutInflater.from(context).inflate(2130904207, (ViewGroup) findViewById(2131561645));
        this.f18322i = (FbButton) findViewById(2131561655);
        this.f18322i.setOnClickListener(new C15531(this));
        this.f18323j = (LinearLayout) findViewById(2131561654);
        if (this.f18321g.m3123x()) {
            this.f18323j.setVisibility(0);
        } else {
            this.f18323j.setVisibility(8);
        }
    }

    protected final void mo1417g() {
        super.mo1417g();
        this.f18323j.setVisibility(8);
    }
}
