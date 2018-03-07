package com.facebook.widget.dialog;

import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.TimePicker;
import com.facebook.widget.dialog.FbDatePickerDialog.C12236;

/* compiled from: delete_video_key */
public class FbTimePickerDialog extends TimePickerDialog {
    public final OnTimeSetListener f15924a;
    public final C12236 f15925b;
    public TimePicker f15926c;
    public int f15927d;
    public int f15928e;

    /* compiled from: delete_video_key */
    class C12241 implements OnClickListener {
        final /* synthetic */ FbTimePickerDialog f15920a;

        C12241(FbTimePickerDialog fbTimePickerDialog) {
            this.f15920a = fbTimePickerDialog;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.f15920a.f15924a != null) {
                this.f15920a.f15924a.onTimeSet(this.f15920a.f15926c, this.f15920a.f15927d, this.f15920a.f15928e);
            }
        }
    }

    /* compiled from: delete_video_key */
    class C12252 implements OnClickListener {
        final /* synthetic */ FbTimePickerDialog f15921a;

        C12252(FbTimePickerDialog fbTimePickerDialog) {
            this.f15921a = fbTimePickerDialog;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.f15921a.f15925b != null) {
                C12236 c12236 = this.f15921a.f15925b;
                int i2 = this.f15921a.f15927d;
                int i3 = this.f15921a.f15928e;
                c12236.f15909a.f15917h = i2;
                c12236.f15909a.f15918i = i3;
                c12236.f15909a.show();
            }
        }
    }

    /* compiled from: delete_video_key */
    class C12263 implements OnClickListener {
        final /* synthetic */ FbTimePickerDialog f15922a;

        C12263(FbTimePickerDialog fbTimePickerDialog) {
            this.f15922a = fbTimePickerDialog;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.f15922a.f15924a != null) {
                this.f15922a.f15924a.onTimeSet(this.f15922a.f15926c, this.f15922a.f15927d, this.f15922a.f15928e);
            }
        }
    }

    /* compiled from: delete_video_key */
    class C12274 implements OnClickListener {
        final /* synthetic */ FbTimePickerDialog f15923a;

        C12274(FbTimePickerDialog fbTimePickerDialog) {
            this.f15923a = fbTimePickerDialog;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public FbTimePickerDialog(Context context, OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        this(context, onTimeSetListener, i, i2, z, null);
    }

    public FbTimePickerDialog(Context context, OnTimeSetListener onTimeSetListener, int i, int i2, boolean z, C12236 c12236) {
        super(context, null, i, i2, z);
        this.f15927d = i;
        this.f15928e = i2;
        this.f15924a = onTimeSetListener;
        this.f15925b = c12236;
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        if (c12236 != null) {
            setButton(-1, context.getString(2131236211), new C12241(this));
            setButton(-2, context.getString(2131236212), new C12252(this));
            return;
        }
        setButton(-1, context.getString(2131230726), new C12263(this));
        setButton(-2, context.getString(2131230727), new C12274(this));
    }

    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
        this.f15926c = timePicker;
        this.f15927d = i;
        this.f15928e = i2;
    }
}
