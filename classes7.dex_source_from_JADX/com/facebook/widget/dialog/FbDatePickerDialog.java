package com.facebook.widget.dialog;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.ultralight.Inject;
import java.util.Calendar;
import javax.inject.Provider;

/* compiled from: delete_video_type */
public class FbDatePickerDialog extends DatePickerDialog {
    @Inject
    public Provider<TimeFormatUtil> f15910a;
    public final OnDateSetListener f15911b;
    private OnDateTimeSetListener f15912c;
    public DatePicker f15913d;
    public int f15914e;
    public int f15915f;
    public int f15916g;
    public int f15917h;
    public int f15918i;
    private int f15919j;

    /* compiled from: delete_video_type */
    class C12181 implements OnClickListener {
        final /* synthetic */ FbDatePickerDialog f15904a;

        C12181(FbDatePickerDialog fbDatePickerDialog) {
            this.f15904a = fbDatePickerDialog;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            FbDatePickerDialog.m19868a(this.f15904a, dialogInterface, i);
            FbDatePickerDialog fbDatePickerDialog = this.f15904a;
            new FbTimePickerDialog(fbDatePickerDialog.getContext(), new C12225(fbDatePickerDialog), fbDatePickerDialog.f15917h, fbDatePickerDialog.f15918i, false, new C12236(fbDatePickerDialog)).show();
        }
    }

    /* compiled from: delete_video_type */
    class C12192 implements OnClickListener {
        final /* synthetic */ FbDatePickerDialog f15905a;

        C12192(FbDatePickerDialog fbDatePickerDialog) {
            this.f15905a = fbDatePickerDialog;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            FbDatePickerDialog.m19868a(this.f15905a, dialogInterface, i);
        }
    }

    /* compiled from: delete_video_type */
    class C12203 implements OnClickListener {
        final /* synthetic */ FbDatePickerDialog f15906a;

        C12203(FbDatePickerDialog fbDatePickerDialog) {
            this.f15906a = fbDatePickerDialog;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.f15906a.f15911b != null) {
                this.f15906a.f15911b.onDateSet(this.f15906a.f15913d, this.f15906a.f15914e, this.f15906a.f15915f, this.f15906a.f15916g);
                FbDatePickerDialog.m19868a(this.f15906a, dialogInterface, i);
            }
        }
    }

    /* compiled from: delete_video_type */
    class C12214 implements OnClickListener {
        final /* synthetic */ FbDatePickerDialog f15907a;

        C12214(FbDatePickerDialog fbDatePickerDialog) {
            this.f15907a = fbDatePickerDialog;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            FbDatePickerDialog.m19868a(this.f15907a, dialogInterface, i);
        }
    }

    /* compiled from: delete_video_type */
    public class C12225 implements OnTimeSetListener {
        final /* synthetic */ FbDatePickerDialog f15908a;

        public C12225(FbDatePickerDialog fbDatePickerDialog) {
            this.f15908a = fbDatePickerDialog;
        }

        public void onTimeSet(TimePicker timePicker, int i, int i2) {
            this.f15908a.f15917h = i;
            this.f15908a.f15918i = i2;
        }
    }

    /* compiled from: delete_video_type */
    public class C12236 {
        public final /* synthetic */ FbDatePickerDialog f15909a;

        public C12236(FbDatePickerDialog fbDatePickerDialog) {
            this.f15909a = fbDatePickerDialog;
        }
    }

    /* compiled from: delete_video_type */
    public interface OnDateTimeSetListener {
    }

    private static <T extends Dialog> void m19869a(Class<T> cls, T t) {
        m19870a((Object) t, t.getContext());
    }

    private static void m19870a(Object obj, Context context) {
        ((FbDatePickerDialog) obj).f15910a = IdBasedSingletonScopeProvider.a(FbInjector.get(context), 610);
    }

    public FbDatePickerDialog(Context context, OnDateSetListener onDateSetListener, int i, int i2, int i3) {
        this(context, 0, onDateSetListener, i, i2, i3);
    }

    public FbDatePickerDialog(Context context, int i, OnDateSetListener onDateSetListener, int i2, int i3, int i4) {
        this(context, i, onDateSetListener, null, i2, i3, i4, -1, -1);
    }

    private FbDatePickerDialog(Context context, int i, OnDateSetListener onDateSetListener, OnDateTimeSetListener onDateTimeSetListener, int i2, int i3, int i4, int i5, int i6) {
        super(context, i, null, i2, i3, i4);
        this.f15919j = -3;
        m19869a(FbDatePickerDialog.class, (Dialog) this);
        this.f15911b = onDateSetListener;
        this.f15914e = i2;
        this.f15915f = i3;
        this.f15916g = i4;
        this.f15917h = i5;
        this.f15918i = i6;
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        this.f15912c = onDateTimeSetListener;
        if (this.f15912c != null) {
            setButton(-1, context.getString(2131236209), new C12181(this));
            setButton(-2, context.getString(2131236210), new C12192(this));
        } else {
            setButton(-1, context.getString(2131230726), new C12203(this));
            setButton(-2, context.getString(2131230727), new C12214(this));
        }
        Calendar instance = Calendar.getInstance();
        instance.set(i2, i3, i4);
        setTitle(((TimeFormatUtil) this.f15910a.get()).a(TimeFormatStyle.DATE_PICKER_STYLE, instance.getTimeInMillis()));
    }

    public static void m19868a(FbDatePickerDialog fbDatePickerDialog, DialogInterface dialogInterface, int i) {
        fbDatePickerDialog.f15919j = i;
        if (dialogInterface instanceof FbDatePickerDialog) {
            View currentFocus = ((FbDatePickerDialog) dialogInterface).getCurrentFocus();
            if (currentFocus != null) {
                currentFocus.clearFocus();
            }
        }
    }

    public void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
        this.f15913d = datePicker;
        this.f15914e = i;
        this.f15915f = i2;
        this.f15916g = i3;
        Calendar instance = Calendar.getInstance();
        instance.set(i, i2, i3);
        setTitle(((TimeFormatUtil) this.f15910a.get()).a(TimeFormatStyle.DATE_PICKER_STYLE, instance.getTimeInMillis()));
        if (this.f15919j == -1) {
            if (this.f15911b != null) {
                this.f15911b.onDateSet(this.f15913d, this.f15914e, this.f15915f, this.f15916g);
            }
            this.f15919j = -3;
        }
    }
}
