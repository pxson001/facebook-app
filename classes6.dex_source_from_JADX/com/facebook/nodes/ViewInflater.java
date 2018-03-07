package com.facebook.nodes;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import java.lang.reflect.Field;

/* compiled from: thread_fbid */
public class ViewInflater extends LayoutInflater {
    private static final String[] f3176a = new String[]{"android.widget.", "android.webkit."};
    private static Field f3177b;
    private final Object[] f3178c;

    /* compiled from: thread_fbid */
    class NonAbstractLayoutInflater extends LayoutInflater {
        NonAbstractLayoutInflater(LayoutInflater layoutInflater, Context context) {
            super(layoutInflater, context);
        }

        public LayoutInflater cloneInContext(Context context) {
            return new NonAbstractLayoutInflater(this, context);
        }
    }

    public ViewInflater(Context context) {
        super(context);
        try {
            if (f3177b == null) {
                Field declaredField = LayoutInflater.class.getDeclaredField("mConstructorArgs");
                f3177b = declaredField;
                declaredField.setAccessible(true);
            }
            this.f3178c = (Object[]) f3177b.get(this);
        } catch (Throwable e) {
            throw new RuntimeException("Failed to initialize ViewInflater", e);
        }
    }

    public final View m4228a(String str, Context context, AttributeSet attributeSet) {
        Object obj = this.f3178c[0];
        try {
            View onCreateView;
            this.f3178c[0] = context;
            if (-1 == str.indexOf(46)) {
                onCreateView = onCreateView(str, attributeSet);
                if (VERSION.SDK_INT >= 18 && (onCreateView instanceof ViewStub)) {
                    ViewStub viewStub = (ViewStub) onCreateView;
                    if (viewStub.getLayoutInflater() == this) {
                        viewStub.setLayoutInflater(cloneInContext(m4227a()));
                    }
                }
                this.f3178c[0] = obj;
            } else {
                onCreateView = super.createView(str, null, attributeSet);
                this.f3178c[0] = obj;
            }
            return onCreateView;
        } catch (Throwable th) {
            this.f3178c[0] = obj;
        }
    }

    public LayoutInflater cloneInContext(Context context) {
        return new NonAbstractLayoutInflater(this, context);
    }

    protected View onCreateView(String str, AttributeSet attributeSet) {
        String[] strArr = f3176a;
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            try {
                View createView = createView(str, strArr[i], attributeSet);
                if (createView != null) {
                    return createView;
                }
                i++;
            } catch (ClassNotFoundException e) {
            }
        }
        return super.onCreateView(str, attributeSet);
    }

    private Context m4227a() {
        return (Context) this.f3178c[0];
    }
}
