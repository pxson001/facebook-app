package com.facebook.fbui.dialog;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import com.facebook.fbui.dialog.AlertController.CheckedItemAdapter;

/* compiled from: e */
public class AlertController$AlertParams {
    public int f13427A;
    public int f13428B;
    public int f13429C;
    public boolean f13430D = false;
    public boolean[] f13431E;
    public boolean f13432F;
    public boolean f13433G;
    public int f13434H = -1;
    public OnMultiChoiceClickListener f13435I;
    public Cursor f13436J;
    public String f13437K;
    public String f13438L;
    public boolean f13439M;
    public OnItemSelectedListener f13440N;
    public boolean f13441O = true;
    public boolean f13442P = true;
    public final Context f13443a;
    public final LayoutInflater f13444b;
    public int f13445c = 0;
    public Drawable f13446d;
    public int f13447e = 0;
    public CharSequence f13448f;
    public View f13449g;
    public CharSequence f13450h;
    public Drawable f13451i;
    public CharSequence f13452j;
    public CharSequence f13453k;
    public OnClickListener f13454l;
    public CharSequence f13455m;
    public OnClickListener f13456n;
    public CharSequence f13457o;
    public OnClickListener f13458p;
    public boolean f13459q;
    public OnCancelListener f13460r;
    public OnDismissListener f13461s;
    public OnKeyListener f13462t;
    public CharSequence[] f13463u;
    public ListAdapter f13464v;
    public OnClickListener f13465w;
    public View f13466x;
    public View f13467y;
    public int f13468z;

    public AlertController$AlertParams(Context context) {
        this.f13443a = context;
        this.f13459q = true;
        this.f13444b = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public final void m14364a(AlertController alertController) {
        if (this.f13449g != null) {
            alertController.y = this.f13449g;
        } else {
            if (this.f13448f != null) {
                alertController.a(this.f13448f);
            }
            if (this.f13447e > 0) {
                int i = this.f13447e;
                TypedValue typedValue = new TypedValue();
                alertController.a.getTheme().resolveAttribute(i, typedValue, true);
                int i2 = typedValue.resourceId;
            }
        }
        if (this.f13450h != null) {
            alertController.b(this.f13450h);
        }
        if (this.f13451i != null) {
            alertController.A = this.f13451i;
            if (alertController.z != null) {
                alertController.z.setImageDrawable(alertController.A);
            }
        }
        if (this.f13452j != null) {
            alertController.C = this.f13452j;
            if (alertController.B != null) {
                alertController.B.setText(alertController.C);
            }
        }
        if (this.f13467y != null) {
            alertController.D = this.f13467y;
        }
        if (this.f13453k != null) {
            alertController.a(-1, this.f13453k, this.f13454l, null);
        }
        if (this.f13455m != null) {
            alertController.a(-2, this.f13455m, this.f13456n, null);
        }
        if (this.f13457o != null) {
            alertController.a(-3, this.f13457o, this.f13458p, null);
        }
        if (!(this.f13463u == null && this.f13436J == null && this.f13464v == null)) {
            m14363b(alertController);
        }
        if (this.f13466x != null) {
            if (this.f13430D) {
                alertController.a(this.f13466x, this.f13468z, this.f13427A, this.f13428B, this.f13429C);
            } else {
                alertController.c(this.f13466x);
            }
        }
        alertController.L = this.f13442P;
    }

    private void m14363b(AlertController alertController) {
        ListAdapter 1;
        ListView listView = (ListView) this.f13444b.inflate(alertController.H, null);
        if (this.f13432F) {
            1 = this.f13436J == null ? new 1(this, this.f13443a, alertController.I, 2131561855, this.f13463u, listView) : new 2(this, this.f13443a, this.f13436J, false, listView, alertController);
        } else {
            int i = this.f13433G ? alertController.J : alertController.K;
            1 = this.f13436J == null ? this.f13464v != null ? this.f13464v : new CheckedItemAdapter(this.f13443a, i, 2131561855, this.f13463u) : new SimpleCursorAdapter(this.f13443a, i, this.f13436J, new String[]{this.f13437K}, new int[]{2131561855});
        }
        alertController.E = 1;
        alertController.F = this.f13434H;
        if (this.f13465w != null) {
            listView.setOnItemClickListener(new 3(this, alertController));
        } else if (this.f13435I != null) {
            listView.setOnItemClickListener(new 4(this, listView, alertController));
        }
        if (this.f13440N != null) {
            listView.setOnItemSelectedListener(this.f13440N);
        }
        if (this.f13433G) {
            listView.setChoiceMode(1);
        } else if (this.f13432F) {
            listView.setChoiceMode(2);
        }
        alertController.f = listView;
    }
}
