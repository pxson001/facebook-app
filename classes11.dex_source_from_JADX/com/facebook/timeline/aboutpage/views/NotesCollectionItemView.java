package com.facebook.timeline.aboutpage.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.graphql.enums.GraphQLTimelineAppSectionType;
import com.facebook.inject.FbInjector;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.notes.gk.NotesGatekeepers;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.AppCollectionItemModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.CollectionsAppSectionRequestableFieldModel;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;

/* compiled from: Ljava/net/InetAddress; */
public class NotesCollectionItemView extends CustomLinearLayout implements ICollectionItemView {
    @Inject
    IFeedIntentBuilder f13885a;
    @Inject
    NotesGatekeepers f13886b;

    private static <T extends View> void m15018a(Class<T> cls, T t) {
        m15019a((Object) t, t.getContext());
    }

    private static void m15019a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((NotesCollectionItemView) obj).m15017a((IFeedIntentBuilder) DefaultFeedIntentBuilder.a(fbInjector), NotesGatekeepers.b(fbInjector));
    }

    public NotesCollectionItemView(Context context) {
        super(context);
        m15015a();
    }

    public NotesCollectionItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m15015a();
    }

    private void m15015a() {
        m15018a(NotesCollectionItemView.class, (View) this);
    }

    public final void mo424a(final AppCollectionItemModel appCollectionItemModel) {
        CharSequence charSequence;
        m15016a(2131560377, appCollectionItemModel.m14299l() == null ? null : appCollectionItemModel.m14299l().m14277a());
        m15016a(2131560378, appCollectionItemModel.m14297j() == null ? null : appCollectionItemModel.m14297j().a());
        if (appCollectionItemModel.nH_() == null) {
            charSequence = null;
        } else {
            charSequence = appCollectionItemModel.nH_().m14375j();
        }
        m15016a(2131560379, charSequence);
        if (appCollectionItemModel.nH_() == null || appCollectionItemModel.nH_().m14374g() == null) {
            setOnClickListener(null);
            setBackgroundColor(getResources().getColor(2131361864));
            return;
        }
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ NotesCollectionItemView f13884b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1193803840);
                this.f13884b.f13885a.a(this.f13884b.getContext(), StringFormatUtil.formatStrLocaleSafe(this.f13884b.f13886b.a() ? FBLinks.aV : FBLinks.aU, appCollectionItemModel.nH_().m14374g()));
                LogUtils.a(1400858104, a);
            }
        });
        setBackgroundResource(2130843621);
    }

    public final void mo425a(CollectionsAppSectionRequestableFieldModel collectionsAppSectionRequestableFieldModel, ProfileViewerContext profileViewerContext, GraphQLTimelineAppSectionType graphQLTimelineAppSectionType) {
    }

    private void m15016a(int i, CharSequence charSequence) {
        TextView textView = (TextView) a(i);
        if (textView == null) {
            return;
        }
        if (charSequence != null) {
            textView.setVisibility(0);
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
    }

    private void m15017a(IFeedIntentBuilder iFeedIntentBuilder, NotesGatekeepers notesGatekeepers) {
        this.f13885a = iFeedIntentBuilder;
        this.f13886b = notesGatekeepers;
    }
}
