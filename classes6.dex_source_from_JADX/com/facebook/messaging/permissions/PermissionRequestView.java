package com.facebook.messaging.permissions;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.R;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.utils.ResourceUtils;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;

/* compiled from: is_edit_tag_enabled */
public class PermissionRequestView extends CustomLinearLayout {
    @Inject
    public RuntimePermissionsUtil f12097a;
    private TextView f12098b;

    /* compiled from: is_edit_tag_enabled */
    class C07831 implements OnClickListener {
        final /* synthetic */ PermissionRequestView f12096a;

        C07831(PermissionRequestView permissionRequestView) {
            this.f12096a = permissionRequestView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1040750979);
            this.f12096a.f12097a.b();
            Logger.a(2, EntryType.UI_INPUT_END, -607358650, a);
        }
    }

    private static <T extends View> void m19035a(Class<T> cls, T t) {
        m19036a((Object) t, t.getContext());
    }

    private static void m19036a(Object obj, Context context) {
        ((PermissionRequestView) obj).f12097a = RuntimePermissionsUtil.b(FbInjector.get(context));
    }

    public PermissionRequestView(Context context) {
        this(context, null, 0);
    }

    public PermissionRequestView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PermissionRequestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19033a(attributeSet);
    }

    private void m19033a(AttributeSet attributeSet) {
        m19035a(PermissionRequestView.class, (View) this);
        setContentView(2130906177);
        this.f12098b = (TextView) a(2131565844);
        ((TextView) a(2131565845)).setOnClickListener(new C07831(this));
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.PermissionRequestView);
        this.f12098b.setText(ResourceUtils.a(getContext(), obtainStyledAttributes, 1));
        obtainStyledAttributes.recycle();
    }

    private void m19034a(RuntimePermissionsUtil runtimePermissionsUtil) {
        this.f12097a = runtimePermissionsUtil;
    }

    public void setDescription(int i) {
        this.f12098b.setText(i);
    }
}
