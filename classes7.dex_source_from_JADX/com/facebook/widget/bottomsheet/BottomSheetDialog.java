package com.facebook.widget.bottomsheet;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.fbui.menu.BottomSheetMenu;
import com.facebook.fbui.menu.BottomSheetMenu.MenuPresenter;
import com.facebook.fig.bottomsheet.FigBottomSheetAdapter;
import com.facebook.fig.bottomsheet.FigBottomSheetAdapter.TitleType;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.dialogs.FbDialog;
import com.facebook.widget.bottomsheet.SlideUpDialogView.Listener;
import javax.inject.Inject;

/* compiled from: delta_type */
public class BottomSheetDialog extends FbDialog implements MenuPresenter {
    public static final float[] f15844a = new float[]{0.5f, 0.75f};
    public SlideUpDialogView f15845b;
    public float f15846c;
    public float f15847d;
    @BottomSheetShowRatioType
    public int f15848e = 0;

    /* compiled from: delta_type */
    class C12091 implements Listener {
        final /* synthetic */ BottomSheetDialog f15843a;

        C12091(BottomSheetDialog bottomSheetDialog) {
            this.f15843a = bottomSheetDialog;
        }

        public final void mo1206a() {
            super.dismiss();
        }
    }

    /* compiled from: delta_type */
    public @interface BottomSheetShowRatioType {
    }

    public static BottomSheetDialog m19812b(InjectorLike injectorLike) {
        return new BottomSheetDialog((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public BottomSheetDialog(Context context) {
        super(context, 2131624659);
        getWindow().setFlags(131072, 131072);
        this.f15845b = new SlideUpDialogView(getContext());
        this.f15845b.f15892o = new C12091(this);
        setContentView(this.f15845b);
    }

    public final void m19817c() {
        getWindow().setFlags(16777216, 16777216);
    }

    private void m19810a(int i, int i2, boolean z, boolean z2, float f, float f2) {
        Resources resources = getContext().getResources();
        if (!z) {
            i2 = i;
        }
        m19809a(resources.getDimension(i2), z2, f, f2);
        this.f15845b.f15881d = this.f15846c;
        this.f15845b.f15882e = this.f15847d;
    }

    private void m19809a(float f, boolean z, float f2, float f3) {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        Point point2 = point;
        int i = point2.x > point2.y ? point2.x : point2.y;
        int i2 = point2.x > point2.y ? point2.y : point2.x;
        if (!z) {
            f2 = 0.0f;
        }
        i -= m19813e();
        i2 -= m19813e();
        float f4 = f15844a[this.f15848e];
        int floor = (int) Math.floor((double) ((((((float) i2) * f4) - f2) - f3) / f));
        this.f15846c = ((((((float) ((int) Math.floor((double) ((((((float) i) * f4) - f2) - f3) / f)))) + f4) * f) + f2) + f3) / ((float) i);
        this.f15847d = ((((((float) floor) + f4) * f) + f2) + f3) / ((float) i2);
    }

    private int m19813e() {
        int identifier = getContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getContext().getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public void dismiss() {
        this.f15845b.m19864a();
    }

    public final void m19815a(Adapter adapter) {
        this.f15845b.setAdapter(adapter);
        if (adapter instanceof BottomSheetMenu) {
            ((BottomSheetMenu) adapter).a(this);
        }
        if (adapter instanceof FigBottomSheetAdapter) {
            float f;
            boolean z = ((FigBottomSheetAdapter) adapter).f5356d;
            boolean h = ((FigBottomSheetAdapter) adapter).m5792h();
            FigBottomSheetAdapter figBottomSheetAdapter = (FigBottomSheetAdapter) adapter;
            if (figBottomSheetAdapter.f5357e == TitleType.CUSTOM) {
                f = figBottomSheetAdapter.f5360h;
            } else {
                f = figBottomSheetAdapter.f5355c.getResources().getDimension(2131430830);
            }
            m19810a(2131430829, 2131430828, z, h, f, (float) 2131430834);
        }
        if (adapter instanceof BottomSheetAdapter) {
            m19810a(2131429132, 2131429131, ((BottomSheetAdapter) adapter).f15838c, ((BottomSheetAdapter) adapter).f15839d, ((BottomSheetAdapter) adapter).c.getResources().getDimension(2131429133), 0.0f);
        }
    }

    public final void m19814a() {
        show();
    }

    public final void m19816b() {
        dismiss();
    }
}
