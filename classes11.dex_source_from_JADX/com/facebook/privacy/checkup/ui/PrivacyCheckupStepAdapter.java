package com.facebook.privacy.checkup.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.ui.util.ViewReplacementUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.graphql.enums.GraphQLPrivacyCheckupActionType;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.privacy.checkup.manager.PrivacyCheckupStepData;
import com.facebook.privacy.checkup.manager.PrivacyCheckupStepData.PrivacyCheckupHeaderRow;
import com.facebook.privacy.checkup.manager.PrivacyCheckupStepData.PrivacyCheckupInfoRow;
import com.facebook.privacy.checkup.manager.PrivacyCheckupStepData.PrivacyCheckupItemRow;
import com.facebook.privacy.checkup.manager.PrivacyCheckupStepData.PrivacyCheckupRowType;
import com.facebook.privacy.checkup.service.PrivacyCheckupAnalyticsLogger;
import com.facebook.privacy.checkup.service.PrivacyCheckupAnalyticsLogger.Event;
import com.facebook.privacy.model.SelectablePrivacyData;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionFieldsWithExplanation;
import com.facebook.privacy.spinner.AudienceSpinner;
import com.facebook.privacy.spinner.AudienceSpinner.PrivacyChangeListener;
import com.facebook.privacy.ui.PrivacyOptionView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.widget.listview.FbBaseAdapter;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.google.common.base.Preconditions;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: SetResultAndroid */
public class PrivacyCheckupStepAdapter extends FbBaseAdapter {
    public static final CallerContext f11105c = CallerContext.a(PrivacyCheckupStepAdapter.class);
    protected final PrivacyCheckupActionCallbackInterface f11106a;
    public final PrivacyCheckupStepData f11107b;
    public final LayoutInflater f11108d;
    public final Resources f11109e;
    public final Context f11110f;
    public final PrivacyCheckupAnalyticsLogger f11111g;
    private final Animation f11112h;
    public View f11113i;
    public Set<String> f11114j;
    private final PrivacyChangeListener f11115k = new C13351(this);

    /* compiled from: SetResultAndroid */
    public interface PrivacyCheckupActionCallbackInterface {
        void mo297a(String str, PrivacyOptionFieldsWithExplanation privacyOptionFieldsWithExplanation);

        void mo298a(String str, boolean z);

        boolean mo299a();

        void mo300b();

        SelectablePrivacyData mo301c();
    }

    /* compiled from: SetResultAndroid */
    class C13351 implements PrivacyChangeListener {
        final /* synthetic */ PrivacyCheckupStepAdapter f11177a;

        C13351(PrivacyCheckupStepAdapter privacyCheckupStepAdapter) {
            this.f11177a = privacyCheckupStepAdapter;
        }

        public final void m11575a(PrivacyOptionFieldsWithExplanation privacyOptionFieldsWithExplanation, @Nullable String str) {
            if (this.f11177a.f11106a != null) {
                this.f11177a.f11106a.mo297a(str, privacyOptionFieldsWithExplanation);
            }
        }
    }

    /* compiled from: SetResultAndroid */
    public class C13373 implements OnClickListener {
        final /* synthetic */ String f11181a;
        final /* synthetic */ boolean f11182b;
        final /* synthetic */ View f11183c;
        final /* synthetic */ PrivacyCheckupStepAdapter f11184d;

        public C13373(PrivacyCheckupStepAdapter privacyCheckupStepAdapter, String str, boolean z, View view) {
            this.f11184d = privacyCheckupStepAdapter;
            this.f11181a = str;
            this.f11182b = z;
            this.f11183c = view;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f11184d.f11106a.mo300b();
            PrivacyCheckupStepAdapter.m11500a(this.f11184d, this.f11181a, this.f11182b, this.f11183c);
        }
    }

    /* compiled from: SetResultAndroid */
    class DeleteButtonListener implements View.OnClickListener {
        final /* synthetic */ PrivacyCheckupStepAdapter f11187a;
        private View f11188b;
        private String f11189c;
        private String f11190d;
        private String f11191e;

        /* compiled from: SetResultAndroid */
        class C13391 implements OnClickListener {
            final /* synthetic */ DeleteButtonListener f11186a;

            C13391(DeleteButtonListener deleteButtonListener) {
                this.f11186a = deleteButtonListener;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }

        DeleteButtonListener(PrivacyCheckupStepAdapter privacyCheckupStepAdapter, View view, String str, String str2, String str3) {
            this.f11187a = privacyCheckupStepAdapter;
            this.f11188b = view;
            this.f11189c = str;
            this.f11190d = str2;
            this.f11191e = str3;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -693529981);
            PrivacyCheckupStepAdapter privacyCheckupStepAdapter = this.f11187a;
            ViewGroup viewGroup = (ViewGroup) this.f11188b;
            String str = this.f11189c;
            String str2 = this.f11190d;
            if (privacyCheckupStepAdapter.f11113i == null) {
                privacyCheckupStepAdapter.f11113i = privacyCheckupStepAdapter.f11108d.inflate(2130906378, viewGroup, false);
            } else if (privacyCheckupStepAdapter.f11113i.getParent() != null) {
                ((ViewGroup) privacyCheckupStepAdapter.f11113i.getParent()).removeView(privacyCheckupStepAdapter.f11113i);
            }
            FbDraweeView fbDraweeView = (FbDraweeView) privacyCheckupStepAdapter.f11113i.findViewById(2131559621);
            fbDraweeView.a(Uri.parse(str2), PrivacyCheckupStepAdapter.f11105c);
            fbDraweeView.setContentDescription(privacyCheckupStepAdapter.f11109e.getString(2131242296, new Object[]{str}));
            ((TextView) privacyCheckupStepAdapter.f11113i.findViewById(2131566229)).setText(privacyCheckupStepAdapter.f11109e.getString(2131242297, new Object[]{str}));
            ((TextView) privacyCheckupStepAdapter.f11113i.findViewById(2131566230)).setText(privacyCheckupStepAdapter.f11109e.getString(2131242298, new Object[]{str}));
            Builder a2 = new FbAlertDialogBuilder(this.f11187a.f11110f).b(this.f11187a.f11113i).c(2131242299, new DeleteDialogChoiceOnClickListener(this.f11187a, this.f11191e, this.f11188b, false)).a(new DeleteDialogDismissListener(this.f11187a, this.f11191e));
            if (this.f11187a.f11107b.f10968d.contains(GraphQLPrivacyCheckupActionType.DELETE_APP_AND_POSTS)) {
                a2.b(2131242300, new DeleteDialogChoiceOnClickListener(this.f11187a, this.f11191e, this.f11188b, true));
            } else {
                a2.b(2131230727, new C13391(this));
            }
            a2.b();
            this.f11187a.f11111g.m11462a(Event.PRIVACY_CHECKUP_APP_STEP_DELETE_DIALOG_EXPOSED);
            LogUtils.a(2110497115, a);
        }
    }

    /* compiled from: SetResultAndroid */
    class DeleteDialogChoiceOnClickListener implements OnClickListener {
        final /* synthetic */ PrivacyCheckupStepAdapter f11192a;
        private String f11193b;
        private View f11194c;
        private boolean f11195d;

        public DeleteDialogChoiceOnClickListener(PrivacyCheckupStepAdapter privacyCheckupStepAdapter, String str, View view, boolean z) {
            this.f11192a = privacyCheckupStepAdapter;
            this.f11193b = str;
            this.f11194c = view;
            this.f11195d = z;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.f11192a.f11106a.mo299a()) {
                PrivacyCheckupStepAdapter.m11500a(this.f11192a, this.f11193b, this.f11195d, this.f11194c);
                return;
            }
            PrivacyCheckupStepAdapter privacyCheckupStepAdapter = this.f11192a;
            String str = this.f11193b;
            boolean z = this.f11195d;
            View view = this.f11194c;
            View inflate = privacyCheckupStepAdapter.f11108d.inflate(2130906378, null, false);
            inflate.findViewById(2131559621).setVisibility(8);
            ((TextView) inflate.findViewById(2131566229)).setText(2131242308);
            ((TextView) inflate.findViewById(2131566230)).setText(2131242309);
            new FbAlertDialogBuilder(privacyCheckupStepAdapter.f11110f).b(inflate).a(2131230728, new C13373(privacyCheckupStepAdapter, str, z, view)).a(false).b();
        }
    }

    /* compiled from: SetResultAndroid */
    class DeleteDialogDismissListener implements OnDismissListener {
        final /* synthetic */ PrivacyCheckupStepAdapter f11196a;
        private String f11197b;

        public DeleteDialogDismissListener(PrivacyCheckupStepAdapter privacyCheckupStepAdapter, String str) {
            this.f11196a = privacyCheckupStepAdapter;
            this.f11197b = str;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            if (!this.f11196a.f11114j.contains(this.f11197b)) {
                this.f11196a.f11111g.m11462a(Event.PRIVACY_CHECKUP_APP_STEP_DELETE_DIALOG_CANCEL);
            }
        }
    }

    /* compiled from: SetResultAndroid */
    public enum ViewType {
        CHECKUP_LIST_SECTION_HEADER_TYPE,
        CHECKUP_LIST_SECTION_ITEM_TYPE,
        LOADING_INDICATOR
    }

    @Inject
    public PrivacyCheckupStepAdapter(LayoutInflater layoutInflater, Resources resources, Context context, PrivacyCheckupAnalyticsLogger privacyCheckupAnalyticsLogger, @Assisted PrivacyCheckupActionCallbackInterface privacyCheckupActionCallbackInterface, @Assisted PrivacyCheckupStepData privacyCheckupStepData) {
        this.f11108d = layoutInflater;
        this.f11109e = resources;
        this.f11110f = context;
        this.f11111g = privacyCheckupAnalyticsLogger;
        this.f11106a = privacyCheckupActionCallbackInterface;
        this.f11107b = privacyCheckupStepData;
        this.f11112h = AnimationUtils.loadAnimation(context, 2130968608);
        this.f11114j = new HashSet();
    }

    public final View m11502a(int i, ViewGroup viewGroup) {
        switch (m11496a(i)) {
            case CHECKUP_LIST_SECTION_HEADER_TYPE:
                return this.f11108d.inflate(2130906381, viewGroup, false);
            case CHECKUP_LIST_SECTION_ITEM_TYPE:
                return this.f11108d.inflate(2130906377, viewGroup, false);
            case LOADING_INDICATOR:
                return new LoadingIndicatorView(this.f11110f);
            default:
                return null;
        }
    }

    public final void m11503a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        PrivacyCheckupRowType privacyCheckupRowType = (PrivacyCheckupRowType) obj;
        switch (m11496a(i2)) {
            case CHECKUP_LIST_SECTION_HEADER_TYPE:
                m11498a(view, privacyCheckupRowType);
                return;
            case CHECKUP_LIST_SECTION_ITEM_TYPE:
                mo293a(view, (PrivacyCheckupItemRow) privacyCheckupRowType);
                return;
            case LOADING_INDICATOR:
                m11497a(view);
                return;
            default:
                return;
        }
    }

    private static void m11498a(View view, PrivacyCheckupRowType privacyCheckupRowType) {
        TextView textView = (TextView) ((ViewGroup) view).findViewById(2131559439);
        if (privacyCheckupRowType instanceof PrivacyCheckupHeaderRow) {
            textView.setText(((PrivacyCheckupHeaderRow) privacyCheckupRowType).f10945a);
        } else if (privacyCheckupRowType instanceof PrivacyCheckupInfoRow) {
            textView.setText(((PrivacyCheckupInfoRow) privacyCheckupRowType).f10946a);
        } else {
            Preconditions.checkArgument(false, "Section header of type: %s unrecognized!", new Object[]{privacyCheckupRowType.getClass().getSimpleName()});
        }
    }

    protected void mo293a(View view, PrivacyCheckupItemRow privacyCheckupItemRow) {
        m11505b(view, privacyCheckupItemRow);
        AudienceSpinner audienceSpinner = (AudienceSpinner) view.findViewById(2131566225);
        PrivacyOptionView privacyOptionView = (PrivacyOptionView) view.findViewById(2131566226);
        if (privacyCheckupItemRow.f10964i) {
            privacyOptionView.setVisibility(8);
            audienceSpinner.setVisibility(8);
        } else if (privacyCheckupItemRow.f10961f == null || !this.f11107b.f10968d.contains(GraphQLPrivacyCheckupActionType.CHANGE_PRIVACY)) {
            privacyOptionView.a(privacyCheckupItemRow.f10962g, privacyCheckupItemRow.f10963h);
            privacyOptionView.setVisibility(0);
            privacyOptionView.setOnClickListener(null);
            audienceSpinner.setVisibility(8);
        } else {
            audienceSpinner.a(privacyCheckupItemRow.f10961f, privacyCheckupItemRow.f10956a);
            audienceSpinner.setPrivacyChangeListener(this.f11115k);
            audienceSpinner.setVisibility(0);
            privacyOptionView.setVisibility(8);
        }
        m11501c(view, privacyCheckupItemRow);
    }

    protected final void m11505b(View view, PrivacyCheckupItemRow privacyCheckupItemRow) {
        TextView textView = (TextView) view.findViewById(2131561318);
        if (privacyCheckupItemRow.f10964i) {
            textView.setVisibility(8);
        } else {
            textView.setText(privacyCheckupItemRow.f10958c);
            textView.setVisibility(0);
        }
        textView = (TextView) view.findViewById(2131566224);
        if (privacyCheckupItemRow.f10964i) {
            textView.setVisibility(0);
            textView.setText(2131242307);
        } else if (TextUtils.isEmpty(privacyCheckupItemRow.f10959d)) {
            textView.setVisibility(8);
            textView.setText(null);
        } else {
            textView.setVisibility(0);
            textView.setText(privacyCheckupItemRow.f10959d);
        }
        m11499a(view, privacyCheckupItemRow.f10960e, privacyCheckupItemRow.f10958c);
    }

    private void m11501c(View view, PrivacyCheckupItemRow privacyCheckupItemRow) {
        Object obj;
        View findViewById = view.findViewById(2131566228);
        if (privacyCheckupItemRow.f10964i || !(this.f11107b.f10968d.contains(GraphQLPrivacyCheckupActionType.DELETE_APP_ONLY) || this.f11107b.f10968d.contains(GraphQLPrivacyCheckupActionType.DELETE_APP_AND_POSTS))) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            GlyphView glyphView;
            if (findViewById == null) {
                glyphView = (GlyphView) ((ViewStub) view.findViewById(2131566227)).inflate();
            } else {
                glyphView = (GlyphView) findViewById;
            }
            glyphView.setVisibility(0);
            glyphView.setOnClickListener(new DeleteButtonListener(this, view, privacyCheckupItemRow.f10958c, privacyCheckupItemRow.f10960e, privacyCheckupItemRow.f10956a));
        } else if (findViewById != null) {
            findViewById.setVisibility(8);
            findViewById.setOnClickListener(null);
        }
    }

    private void m11499a(View view, String str, String str2) {
        View findViewById = view.findViewById(2131566223);
        if (!TextUtils.isEmpty(str)) {
            FbDraweeView fbDraweeView;
            if (findViewById == null) {
                fbDraweeView = new FbDraweeView(view.getContext());
                fbDraweeView.setId(2131566223);
                ViewReplacementUtil.a((ViewGroup) view, 2131566222, fbDraweeView);
            } else {
                fbDraweeView = (FbDraweeView) findViewById;
            }
            fbDraweeView.a(Uri.parse(str), f11105c);
            fbDraweeView.setContentDescription(this.f11109e.getString(2131242296, new Object[]{str2}));
            fbDraweeView.setVisibility(0);
        } else if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    private void m11497a(View view) {
        LoadingIndicatorView loadingIndicatorView = (LoadingIndicatorView) view;
        if (this.f11107b.f10975k) {
            loadingIndicatorView.a();
        } else {
            loadingIndicatorView.b();
        }
    }

    public static void m11500a(PrivacyCheckupStepAdapter privacyCheckupStepAdapter, final String str, final boolean z, View view) {
        privacyCheckupStepAdapter.f11112h.setAnimationListener(new AnimationListener(privacyCheckupStepAdapter) {
            final /* synthetic */ PrivacyCheckupStepAdapter f11180c;

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                this.f11180c.f11106a.mo298a(str, z);
            }

            public void onAnimationRepeat(Animation animation) {
            }
        });
        privacyCheckupStepAdapter.f11111g.m11462a(z ? Event.PRIVACY_CHECKUP_APP_STEP_DELETE_DIALOG_DELETE_POSTS : Event.PRIVACY_CHECKUP_APP_STEP_DELETE_DIALOG_DELETE_APP_ONLY);
        privacyCheckupStepAdapter.f11114j.add(str);
        view.startAnimation(privacyCheckupStepAdapter.f11112h);
    }

    public Object getItem(int i) {
        if (i >= this.f11107b.f10965a.size()) {
            return null;
        }
        return this.f11107b.f10965a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getCount() {
        return this.f11107b.f10965a.size() + 1;
    }

    public int getItemViewType(int i) {
        PrivacyCheckupRowType privacyCheckupRowType = (PrivacyCheckupRowType) getItem(i);
        if (privacyCheckupRowType == null) {
            return ViewType.LOADING_INDICATOR.ordinal();
        }
        if ((privacyCheckupRowType instanceof PrivacyCheckupHeaderRow) || (privacyCheckupRowType instanceof PrivacyCheckupInfoRow)) {
            return ViewType.CHECKUP_LIST_SECTION_HEADER_TYPE.ordinal();
        }
        if (privacyCheckupRowType instanceof PrivacyCheckupItemRow) {
            return ViewType.CHECKUP_LIST_SECTION_ITEM_TYPE.ordinal();
        }
        Preconditions.checkArgument(false, "Got a PrivacyCheckupRowType that did not map to a view type: %s", new Object[]{privacyCheckupRowType.getClass().getSimpleName()});
        return 0;
    }

    public int getViewTypeCount() {
        return ViewType.values().length;
    }

    private static ViewType m11496a(int i) {
        return ViewType.values()[i];
    }
}
