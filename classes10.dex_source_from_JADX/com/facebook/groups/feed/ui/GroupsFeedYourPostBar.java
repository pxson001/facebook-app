package com.facebook.groups.feed.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.dracula.api.DraculaReturnValue;
import com.facebook.dracula.runtime.base.DraculaRuntime;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.FetchGroupInformationModel;
import com.facebook.groups.staticadapter.StaticAdapter.Bindable;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomFrameLayout;
import javax.inject.Inject;

/* compiled from: Time between Device Status analytics events */
public class GroupsFeedYourPostBar extends CustomFrameLayout implements Bindable<FetchGroupInformationModel> {
    @Inject
    public GroupsFeedIntentBuilder f22167a;
    @Inject
    public SecureContextHelper f22168b;
    public FetchGroupInformationModel f22169c;
    public FbTextView f22170d;

    /* compiled from: Time between Device Status analytics events */
    public class C31961 implements OnClickListener {
        final /* synthetic */ GroupsFeedYourPostBar f22166a;

        public C31961(GroupsFeedYourPostBar groupsFeedYourPostBar) {
            this.f22166a = groupsFeedYourPostBar;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -487380144);
            this.f22166a.f22168b.a(this.f22166a.f22167a.m23298b(this.f22166a.f22169c), this.f22166a.getContext());
            Logger.a(2, EntryType.UI_INPUT_END, -526609307, a);
        }
    }

    public static void m23305a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        GroupsFeedYourPostBar groupsFeedYourPostBar = (GroupsFeedYourPostBar) obj;
        GroupsFeedIntentBuilder a = GroupsFeedIntentBuilder.m23295a(injectorLike);
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike);
        groupsFeedYourPostBar.f22167a = a;
        groupsFeedYourPostBar.f22168b = secureContextHelper;
    }

    public final void mo758a(Object obj) {
        MutableFlatBuffer mutableFlatBuffer;
        int i;
        int i2;
        Integer valueOf;
        this.f22169c = (FetchGroupInformationModel) obj;
        int i3 = 1;
        if (this.f22169c != null) {
            DraculaReturnValue b = this.f22169c.b();
            mutableFlatBuffer = b.a;
            i = b.b;
            i2 = b.c;
            if (DraculaRuntime.a(mutableFlatBuffer, i, null, 0)) {
                i2 = 0;
            } else {
                i2 = 1;
            }
        } else {
            i2 = 0;
        }
        if (i2 != 0) {
            b = this.f22169c.b();
            mutableFlatBuffer = b.a;
            i = b.b;
            i2 = b.c;
            if (DraculaRuntime.a(mutableFlatBuffer, mutableFlatBuffer.g(i, 6), null, 0)) {
                i3 = 0;
            }
        } else {
            i3 = 0;
        }
        if (i3 != 0) {
            b = this.f22169c.b();
            MutableFlatBuffer mutableFlatBuffer2 = b.a;
            int i4 = b.b;
            i2 = b.c;
            valueOf = Integer.valueOf(mutableFlatBuffer2.j(mutableFlatBuffer2.g(i4, 6), 0));
        } else {
            valueOf = null;
        }
        i2 = valueOf.intValue();
        if (i2 > 0) {
            this.f22170d.setText(String.valueOf(i2));
            this.f22170d.setVisibility(0);
            return;
        }
        this.f22170d.setVisibility(8);
    }

    public GroupsFeedYourPostBar(Context context) {
        this(context, null);
    }

    private GroupsFeedYourPostBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2131626078);
        Class cls = GroupsFeedYourPostBar.class;
        m23305a(this, getContext());
        View.inflate(context, 2130904719, this);
        this.f22170d = (FbTextView) c(2131562778);
        ((FbButton) c(2131562777)).setOnClickListener(new C31961(this));
    }
}
