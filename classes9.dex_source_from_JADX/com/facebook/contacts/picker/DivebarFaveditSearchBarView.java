package com.facebook.contacts.picker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: post_photo_button */
public class DivebarFaveditSearchBarView extends ContactPickerSearchBarView {
    public ButtonListener f6450a;
    private Button f6451b;
    private Button f6452c;

    /* compiled from: post_photo_button */
    class C06611 implements OnClickListener {
        final /* synthetic */ DivebarFaveditSearchBarView f6448a;

        C06611(DivebarFaveditSearchBarView divebarFaveditSearchBarView) {
            this.f6448a = divebarFaveditSearchBarView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 709251148);
            if (this.f6448a.f6450a != null) {
                this.f6448a.f6450a.m6811a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 872788570, a);
        }
    }

    /* compiled from: post_photo_button */
    class C06622 implements OnClickListener {
        final /* synthetic */ DivebarFaveditSearchBarView f6449a;

        C06622(DivebarFaveditSearchBarView divebarFaveditSearchBarView) {
            this.f6449a = divebarFaveditSearchBarView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1717397006);
            if (this.f6449a.f6450a != null) {
                this.f6449a.f6450a.m6812b();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 709184396, a);
        }
    }

    /* compiled from: post_photo_button */
    public interface ButtonListener {
        void m6811a();

        void m6812b();
    }

    public DivebarFaveditSearchBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6814i();
    }

    public void setButtonListener(ButtonListener buttonListener) {
        this.f6450a = buttonListener;
    }

    public final void m6816g() {
        this.f6451b.setVisibility(0);
        this.f6452c.setVisibility(8);
    }

    public final void m6817h() {
        this.f6451b.setVisibility(8);
        this.f6452c.setVisibility(0);
    }

    private void m6814i() {
        this.f6451b = (Button) a(2131564837);
        this.f6452c = (Button) a(2131564838);
        this.f6451b.setOnClickListener(new C06611(this));
        this.f6452c.setOnClickListener(new C06622(this));
    }

    protected final void mo259b() {
        setContentView(2130905684);
    }
}
