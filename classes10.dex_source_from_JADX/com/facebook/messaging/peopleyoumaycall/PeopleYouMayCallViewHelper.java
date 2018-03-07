package com.facebook.messaging.peopleyoumaycall;

import android.content.Context;
import android.content.res.Resources;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.android.WindowManagerMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: render_object_list_query_id */
public class PeopleYouMayCallViewHelper {
    private final Context f3462a;
    private final WindowManager f3463b;

    public static PeopleYouMayCallViewHelper m3347b(InjectorLike injectorLike) {
        return new PeopleYouMayCallViewHelper((Context) injectorLike.getInstance(Context.class), ResourcesMethodAutoProvider.a(injectorLike), WindowManagerMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public PeopleYouMayCallViewHelper(Context context, Resources resources, WindowManager windowManager) {
        this.f3462a = context;
        this.f3463b = windowManager;
    }

    public static PeopleYouMayCallViewHelper m3346a(InjectorLike injectorLike) {
        return m3347b(injectorLike);
    }

    public final int m3348a(int i) {
        PeopleYouMayCallItemView peopleYouMayCallItemView = new PeopleYouMayCallItemView(this.f3462a);
        peopleYouMayCallItemView.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        return i / peopleYouMayCallItemView.getMeasuredWidth();
    }
}
