package com.facebook.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.R;
import com.google.common.base.Preconditions;

/* compiled from: com.google.android.gms.maps.internal.IOnMapClickListener */
public class ControlledView extends View {
    public final ViewController f19779a;

    public ControlledView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ControlledView);
        String string = obtainStyledAttributes.getString(0);
        Preconditions.checkNotNull(string, "You must provide a controller class name in the 'controller' attribute of a ControlledView");
        obtainStyledAttributes.recycle();
        try {
            this.f19779a = (ViewController) Class.forName(string).getConstructor(new Class[]{ControlledView.class}).newInstance(new Object[]{this});
        } catch (Throwable e) {
            throw new RuntimeException("Could not find controller class", e);
        } catch (Throwable e2) {
            throw new RuntimeException("Could not find controller constructor", e2);
        } catch (Throwable e22) {
            throw new RuntimeException("Could not instantiate controller", e22);
        } catch (Throwable e222) {
            throw new RuntimeException("Could not instantiate controller", e222);
        } catch (Throwable e2222) {
            throw new RuntimeException("Could not instantiate controller", e2222);
        }
    }

    public <T extends ViewController> T getController() {
        return this.f19779a;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f19779a.mo895a();
    }
}
