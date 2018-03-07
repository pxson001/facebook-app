package com.facebook.trace;

import android.content.Context;
import android.preference.DialogPreference;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: segments */
public class DebugTracePreference extends DialogPreference {
    private PerfDebugTracer f5069a;
    private Context f5070b;
    private View f5071c;

    public static DebugTracePreference m7831a(InjectorLike injectorLike) {
        return new DebugTracePreference((Context) injectorLike.getInstance(Context.class), PerfDebugTracer.a(injectorLike));
    }

    @Inject
    public DebugTracePreference(Context context, PerfDebugTracer perfDebugTracer) {
        super(context, null);
        this.f5069a = perfDebugTracer;
        this.f5070b = context;
        setTitle("Performance Metric Tracing");
        setSummary("Enter a perf metric name, max trace size, and a max trace time to method level trace a performance metric");
        setPersistent(false);
        setDialogLayoutResource(2130907530);
    }

    protected void onBindDialogView(View view) {
        super.onBindDialogView(view);
        this.f5071c = view;
    }

    protected void onDialogClosed(boolean z) {
        if (z) {
            EditText editText = (EditText) this.f5071c.findViewById(2131568082);
            if (editText.getText().toString().equals("")) {
                m7832a();
                return;
            }
            int parseInt;
            int i;
            EditText editText2 = (EditText) this.f5071c.findViewById(2131568083);
            EditText editText3 = (EditText) this.f5071c.findViewById(2131568084);
            EditText editText4 = (EditText) this.f5071c.findViewById(2131568085);
            RadioButton radioButton = (RadioButton) this.f5071c.findViewById(2131568088);
            if (((RadioButton) this.f5071c.findViewById(2131568087)).isChecked()) {
                try {
                    parseInt = Integer.parseInt(editText4.getText().toString());
                } catch (NumberFormatException e) {
                    m7832a();
                    return;
                }
            }
            parseInt = 0;
            if (radioButton.isChecked()) {
                i = 1;
            } else {
                i = 0;
            }
            try {
                this.f5069a.a(editText.getText().toString(), 0, "temp", Integer.parseInt(editText2.getText().toString()) * 1048576, ((long) Integer.parseInt(editText3.getText().toString())) * 1000, parseInt, i);
            } catch (NumberFormatException e2) {
                m7832a();
            }
        }
    }

    private void m7832a() {
        Toast.makeText(this.f5070b, "Trace config failed. Enter values for all params", 1).show();
    }
}
