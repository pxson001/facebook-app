package com.facebook.messaging.groups.namingbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.facebook.resources.ui.FbEditText;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.base.Strings;
import javax.annotation.Nullable;

/* compiled from: showActionSheet */
public class GroupNamingBarView extends CustomLinearLayout {
    private final FbEditText f2487a;
    @Nullable
    public Listener f2488b;

    /* compiled from: showActionSheet */
    public interface Listener {
        void mo63a(String str);
    }

    /* compiled from: showActionSheet */
    class C04121 implements OnKeyListener {
        final /* synthetic */ GroupNamingBarView f2486a;

        C04121(GroupNamingBarView groupNamingBarView) {
            this.f2486a = groupNamingBarView;
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i != 66 || keyEvent.getAction() != 0) {
                return false;
            }
            GroupNamingBarView.m2500b(this.f2486a);
            return true;
        }
    }

    public GroupNamingBarView(Context context) {
        this(context, null, 0);
    }

    public GroupNamingBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GroupNamingBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130904681);
        this.f2487a = (FbEditText) a(2131562706);
    }

    public final void m2501a() {
        this.f2487a.setOnKeyListener(new C04121(this));
    }

    public void setListener(Listener listener) {
        this.f2488b = listener;
    }

    public static void m2500b(GroupNamingBarView groupNamingBarView) {
        String trim = groupNamingBarView.f2487a.getText().toString().trim();
        if (!Strings.isNullOrEmpty(trim) && groupNamingBarView.f2488b != null) {
            groupNamingBarView.f2488b.mo63a(trim);
        }
    }
}
