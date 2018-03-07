package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.widget.Checkable;
import com.facebook.common.ui.util.ViewIdUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: VC */
public class EditableRadioGroup extends LinearLayoutCompat {
    public int f23141a;
    public CheckedStateTracker f23142b;
    public boolean f23143c;
    public OnCheckedChangeRadioGroupListener f23144d;
    private PassThroughHierarchyChangeListener f23145e;

    /* compiled from: VC */
    public interface OnCheckedChangeRadioGroupListener {
        void mo1006a(EditableRadioGroup editableRadioGroup, int i);
    }

    /* compiled from: VC */
    public class CheckedStateTracker {
        final /* synthetic */ EditableRadioGroup f23138a;

        public CheckedStateTracker(EditableRadioGroup editableRadioGroup) {
            this.f23138a = editableRadioGroup;
        }

        public final void m25117a(View view) {
            if (!this.f23138a.f23143c) {
                this.f23138a.f23143c = true;
                if (this.f23138a.f23141a != -1) {
                    this.f23138a.m25120a(this.f23138a.f23141a, false);
                }
                this.f23138a.f23143c = false;
                EditableRadioGroup.setCheckedId(this.f23138a, view.getId());
            }
        }
    }

    /* compiled from: VC */
    public class PassThroughHierarchyChangeListener implements OnHierarchyChangeListener {
        final /* synthetic */ EditableRadioGroup f23139a;
        public OnHierarchyChangeListener f23140b;

        public PassThroughHierarchyChangeListener(EditableRadioGroup editableRadioGroup) {
            this.f23139a = editableRadioGroup;
        }

        public void onChildViewAdded(View view, View view2) {
            if (view == this.f23139a && (view2 instanceof HasOnCheckedChangeWidgetListener)) {
                m25119a(view2);
                ((HasOnCheckedChangeWidgetListener) view2).setOnCheckedChangeWidgetListener(this.f23139a.f23142b);
            }
            if (this.f23140b != null) {
                this.f23140b.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            if (view == this.f23139a && (view2 instanceof HasOnCheckedChangeWidgetListener)) {
                ((HasOnCheckedChangeWidgetListener) view2).setOnCheckedChangeWidgetListener(null);
            }
            if (this.f23140b != null) {
                this.f23140b.onChildViewRemoved(view, view2);
            }
        }

        private static void m25119a(View view) {
            if (view.getId() == -1) {
                view.setId(ViewIdUtil.a());
            }
        }
    }

    public EditableRadioGroup(Context context) {
        this(context, null);
    }

    public EditableRadioGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23141a = -1;
        this.f23143c = false;
        m25126b();
    }

    private void m25126b() {
        this.f23142b = new CheckedStateTracker(this);
        this.f23145e = new PassThroughHierarchyChangeListener(this);
        super.setOnHierarchyChangeListener(this.f23145e);
    }

    public void setOnHierarchyChangeListener(OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f23145e.f23140b = onHierarchyChangeListener;
    }

    protected void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1534069699);
        super.onFinishInflate();
        if (this.f23141a != -1) {
            this.f23143c = true;
            m25120a(this.f23141a, true);
            this.f23143c = false;
            setCheckedId(this, this.f23141a);
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 737256708, a);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if ((view instanceof Checkable) && ((Checkable) view).isChecked()) {
            this.f23143c = true;
            if (this.f23141a != -1) {
                m25120a(this.f23141a, false);
            }
            this.f23143c = false;
            setCheckedId(this, view.getId());
        }
    }

    public final void m25129a(int i) {
        if (i == -1 || i != this.f23141a) {
            if (this.f23141a != -1) {
                m25120a(this.f23141a, false);
            }
            if (i != -1) {
                m25120a(i, true);
            }
            setCheckedId(this, i);
        }
    }

    public static void setCheckedId(EditableRadioGroup editableRadioGroup, int i) {
        editableRadioGroup.f23141a = i;
        if (editableRadioGroup.f23144d != null) {
            editableRadioGroup.f23144d.mo1006a(editableRadioGroup, editableRadioGroup.f23141a);
        }
    }

    private void m25120a(int i, boolean z) {
        View findViewById = findViewById(i);
        if (findViewById != null && (findViewById instanceof Checkable)) {
            ((Checkable) findViewById).setChecked(z);
        }
    }

    public int getCheckedRadioButtonId() {
        return this.f23141a;
    }

    public final void m25128a() {
        m25129a(-1);
    }

    public void setOnCheckedChangeRadioGroupListener(OnCheckedChangeRadioGroupListener onCheckedChangeRadioGroupListener) {
        this.f23144d = onCheckedChangeRadioGroupListener;
    }
}
