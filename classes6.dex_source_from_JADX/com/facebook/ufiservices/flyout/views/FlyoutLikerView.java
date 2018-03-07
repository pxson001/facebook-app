package com.facebook.ufiservices.flyout.views;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.content.event.FbEventBus;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.friends.ui.FriendingButton;
import com.facebook.friends.ui.SmartButtonLite;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ufiservices.ui.ProfileListFriendingButtonBinder;
import com.facebook.ufiservices.ui.ProfileListFriendingController;
import com.facebook.ufiservices.ui.SimpleFriendingButtonBinder;
import com.facebook.ufiservices.ui.SmartFriendingButtonBinder;
import com.facebook.widget.CustomRelativeLayout;

/* compiled from: customLocation */
public class FlyoutLikerView extends CustomRelativeLayout {
    public static final CallerContext f18190a = CallerContext.a(FlyoutLikerView.class, "story_feedback_flyout");
    public View f18191b;
    public FbDraweeView f18192c;
    public TextView f18193d;
    public TextView f18194e;
    public ImageView f18195f;
    public Product f18196g;
    public FriendingEventBus f18197h;
    public ProfileListFriendingController f18198i;
    public boolean f18199j = true;
    public AbstractFbErrorReporter f18200k;

    public static void m26724a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        FlyoutLikerView flyoutLikerView = (FlyoutLikerView) obj;
        Product b = ProductMethodAutoProvider.b(fbInjector);
        FriendingEventBus a = FriendingEventBus.m16746a(fbInjector);
        ProfileListFriendingController b2 = ProfileListFriendingController.m26792b(fbInjector);
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        flyoutLikerView.f18196g = b;
        flyoutLikerView.f18197h = a;
        flyoutLikerView.f18198i = b2;
        flyoutLikerView.f18200k = abstractFbErrorReporter;
    }

    public FlyoutLikerView(Context context) {
        SmartFriendingButtonBinder smartFriendingButtonBinder;
        SmartButtonLite smartButtonLite;
        super(context);
        Class cls = FlyoutLikerView.class;
        m26724a(this, getContext());
        setContentView(2130904390);
        this.f18191b = a(2131562093);
        this.f18192c = (FbDraweeView) a(2131560426);
        this.f18193d = (TextView) a(2131562094);
        this.f18194e = (TextView) a(2131562098);
        this.f18195f = (ImageView) a(2131562097);
        ProfileListFriendingController profileListFriendingController = this.f18198i;
        if (Product.FB4A.equals(this.f18196g)) {
            smartFriendingButtonBinder = new SmartFriendingButtonBinder();
        } else {
            smartFriendingButtonBinder = new SimpleFriendingButtonBinder();
        }
        ProfileListFriendingButtonBinder profileListFriendingButtonBinder = smartFriendingButtonBinder;
        ViewGroup viewGroup = (ViewGroup) a(2131562096);
        if (Product.FB4A.equals(this.f18196g)) {
            View.inflate(getContext(), 2130904389, viewGroup);
            smartButtonLite = (SmartButtonLite) a(2131562095);
        } else {
            View.inflate(getContext(), 2130904387, viewGroup);
            FriendingButton friendingButton = (FriendingButton) a(2131562095);
        }
        profileListFriendingController.m26794a(profileListFriendingButtonBinder, (View) smartButtonLite, this.f18194e);
        a(this.f18198i.m26793a());
        setPadding(getContext().getResources().getDimensionPixelSize(2131428715), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    private TextView[] getAllTextViews() {
        return new TextView[]{this.f18193d, this.f18194e};
    }

    protected FbEventBus getEventBus() {
        return this.f18197h;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 340765888);
        super.onAttachedToWindow();
        this.f18198i.m26796a(false);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 149351605, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1972711614);
        this.f18198i.m26796a(true);
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -441296248, a);
    }
}
