package com.facebook.groups.feed.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.FetchGroupInformationModel;
import com.facebook.groups.feed.ui.GroupsFeedFragment.AnonymousClass15;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomFrameLayout;
import javax.inject.Inject;

/* compiled from: ThreadsInViewTooLarge */
public class GroupsInMallGiantJoinButtonView extends CustomFrameLayout {
    @Inject
    public GroupsPlutoniumHeaderActionBarControllerProvider f22186a;
    public Paint f22187b = new Paint(1);
    public GroupsPlutoniumHeaderActionBarController f22188c;
    public FbButton f22189d;

    /* compiled from: ThreadsInViewTooLarge */
    public class C32001 implements OnClickListener {
        final /* synthetic */ AnonymousClass15 f22183a;
        final /* synthetic */ FetchGroupInformationModel f22184b;
        final /* synthetic */ GroupsInMallGiantJoinButtonView f22185c;

        public C32001(GroupsInMallGiantJoinButtonView groupsInMallGiantJoinButtonView, AnonymousClass15 anonymousClass15, FetchGroupInformationModel fetchGroupInformationModel) {
            this.f22185c = groupsInMallGiantJoinButtonView;
            this.f22183a = anonymousClass15;
            this.f22184b = fetchGroupInformationModel;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1645847756);
            this.f22185c.f22188c = this.f22185c.f22186a.m23413a(this.f22183a);
            if (this.f22184b.p().equals(GraphQLGroupJoinState.REQUESTED)) {
                this.f22185c.f22188c.m23409e(this.f22184b);
                this.f22185c.f22189d.setText(2131238072);
            } else {
                this.f22185c.f22188c.m23407d(this.f22184b);
                this.f22185c.f22189d.setText(2131238073);
            }
            LogUtils.a(2086494284, a);
        }
    }

    public static void m23329a(Object obj, Context context) {
        ((GroupsInMallGiantJoinButtonView) obj).f22186a = (GroupsPlutoniumHeaderActionBarControllerProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(GroupsPlutoniumHeaderActionBarControllerProvider.class);
    }

    public GroupsInMallGiantJoinButtonView(Context context) {
        super(context);
        Class cls = GroupsInMallGiantJoinButtonView.class;
        m23329a(this, getContext());
        View.inflate(context, 2130904722, this);
        this.f22187b.setColor(getResources().getColor(2131361939));
        this.f22187b.setStrokeWidth(0.0f);
        this.f22189d = (FbButton) findViewById(2131562783);
        if (VERSION.SDK_INT < 16) {
            setBackgroundDrawable(new ColorDrawable(-1));
        } else {
            setBackground(new ColorDrawable(-1));
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() - 1;
        canvas.drawLine(0.0f, (float) height, (float) getWidth(), (float) height, this.f22187b);
    }
}
