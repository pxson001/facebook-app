package com.facebook.timeline.lifeevent;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.activity.ComposerFragment;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass36;
import com.facebook.composer.activity.ComposerFragment.C07625;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.composer.lifeevent.controller.ComposerLifeEventDatePickerController;
import com.facebook.composer.lifeevent.controller.ComposerLifeEventDatePickerControllerProvider;
import com.facebook.composer.lifeevent.interstitial.ComposerLifeEventIconsActivity;
import com.facebook.composer.lifeevent.model.ComposerLifeEventModel;
import com.facebook.composer.lifeevent.model.ComposerLifeEventModel.Builder;
import com.facebook.composer.lifeevent.protocol.ComposerLifeEventParam;
import com.facebook.composer.lifeevent.updaterelationship.UpdateRelationshipStatusController;
import com.facebook.composer.lifeevent.updaterelationship.UpdateRelationshipStatusController.1;
import com.facebook.composer.lifeevent.updaterelationship.UpdateRelationshipStatusControllerProvider;
import com.facebook.composer.lifeevent.view.ComposerLifeEventEditor;
import com.facebook.composer.lifeevent.view.ComposerLifeEventViewBinder;
import com.facebook.composer.lifeevent.view.ComposerLifeEventWithDatePickerView;
import com.facebook.composer.publish.helpers.PublishLifeEventHelper;
import com.facebook.composer.publish.helpers.PublishLifeEventHelperProvider;
import com.facebook.composer.ui.text.ComposerEditText;
import com.facebook.composer.ui.text.ComposerEditText.TextWithEntitiesChangedListener;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.feed.util.composer.abtest.ExperimentsForFeedUtilComposerAbtestModule;
import com.facebook.graphql.enums.GraphQLLifeEventAPIIdentifier;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.inject.Assisted;
import com.facebook.inject.IdBasedProvider;
import com.facebook.ipc.composer.intent.SerializedComposerPluginConfig;
import com.facebook.ipc.composer.model.ComposerDateInfo.ProvidesDateInfo;
import com.facebook.ipc.composer.plugin.ComposerPlugin.InstanceState;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.BooleanGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.Getter;
import com.facebook.ipc.composer.plugin.ComposerPluginSession;
import com.facebook.ipc.composer.plugin.impl.ComposerPluginDefault;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.upload.manager.UploadManager;
import com.facebook.photos.upload.operation.UploadOperationFactory;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.widget.LazyView;
import com.facebook.widget.text.watcher.BaseTextWatcher;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Ljava/lang/Integer; */
public final class LifeEventComposerPlugin extends ComposerPluginDefault {
    public static final ComposerEventOriginator f13979a = ComposerEventOriginator.a(BaseTextWatcher.class);
    private ComposerLifeEventDatePickerController f13980b;
    private final ComposerLifeEventDatePickerControllerProvider f13981c;
    private UpdateRelationshipStatusControllerProvider f13982d;
    public final PublishLifeEventHelperProvider f13983e;
    public final QeAccessor f13984f;
    public final InputMethodManager f13985g;
    public ComposerEditText f13986h;
    private LazyView<View> f13987i;

    /* compiled from: Ljava/lang/Integer; */
    class C16271 implements Getter<String> {
        final /* synthetic */ LifeEventComposerPlugin f13969a;

        C16271(LifeEventComposerPlugin lifeEventComposerPlugin) {
            this.f13969a = lifeEventComposerPlugin;
        }

        public final Object m15083a() {
            return this.f13969a.b.getResources().getString(2131234187);
        }
    }

    /* compiled from: Ljava/lang/Integer; */
    class C16282 implements BooleanGetter {
        final /* synthetic */ LifeEventComposerPlugin f13970c;

        C16282(LifeEventComposerPlugin lifeEventComposerPlugin) {
            this.f13970c = lifeEventComposerPlugin;
        }

        public final boolean m15084a() {
            if (this.f13970c.E().a.m7438n() == null || StringUtil.c(this.f13970c.E().a.m7438n().a)) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: Ljava/lang/Integer; */
    class C16293 implements BooleanGetter {
        final /* synthetic */ LifeEventComposerPlugin f13971c;

        C16293(LifeEventComposerPlugin lifeEventComposerPlugin) {
            this.f13971c = lifeEventComposerPlugin;
        }

        public final boolean m15085a() {
            if (this.f13971c.E().a.m7438n() != null) {
                GraphQLLifeEventAPIIdentifier graphQLLifeEventAPIIdentifier = this.f13971c.E().a.m7438n().b;
                if (graphQLLifeEventAPIIdentifier == GraphQLLifeEventAPIIdentifier.STARTED_JOB || graphQLLifeEventAPIIdentifier == GraphQLLifeEventAPIIdentifier.GRADUATED) {
                    return false;
                }
            }
            return true;
        }
    }

    /* compiled from: Ljava/lang/Integer; */
    class C16304 implements BooleanGetter {
        final /* synthetic */ LifeEventComposerPlugin f13972c;

        C16304(LifeEventComposerPlugin lifeEventComposerPlugin) {
            this.f13972c = lifeEventComposerPlugin;
        }

        public final boolean m15086a() {
            if (this.f13972c.E().a.m7438n() == null) {
                return true;
            }
            GraphQLLifeEventAPIIdentifier graphQLLifeEventAPIIdentifier = this.f13972c.E().a.m7438n().b;
            boolean z = (graphQLLifeEventAPIIdentifier == GraphQLLifeEventAPIIdentifier.STARTED_JOB || graphQLLifeEventAPIIdentifier == GraphQLLifeEventAPIIdentifier.GRADUATED || graphQLLifeEventAPIIdentifier == GraphQLLifeEventAPIIdentifier.MARRIED || graphQLLifeEventAPIIdentifier == GraphQLLifeEventAPIIdentifier.ENGAGED) ? false : true;
            return z;
        }
    }

    /* compiled from: Ljava/lang/Integer; */
    class C16315 implements Getter<Intent> {
        final /* synthetic */ LifeEventComposerPlugin f13973a;

        C16315(LifeEventComposerPlugin lifeEventComposerPlugin) {
            this.f13973a = lifeEventComposerPlugin;
        }

        public final Object m15087a() {
            LifeEventComposerPlugin lifeEventComposerPlugin = this.f13973a;
            PublishLifeEventHelperProvider publishLifeEventHelperProvider = lifeEventComposerPlugin.f13983e;
            ComposerDataProviderImpl composerDataProviderImpl = lifeEventComposerPlugin.E().a;
            ComposerLifeEventModel n = lifeEventComposerPlugin.E().a.m7438n();
            PublishLifeEventHelper publishLifeEventHelper = new PublishLifeEventHelper(composerDataProviderImpl, n, lifeEventComposerPlugin.E().a.m7428d(), UploadOperationFactory.b(publishLifeEventHelperProvider), UploadManager.a(publishLifeEventHelperProvider));
            publishLifeEventHelper.a = IdBasedProvider.a(publishLifeEventHelperProvider, 3595);
            PublishLifeEventHelper publishLifeEventHelper2 = publishLifeEventHelper;
            ComposerLifeEventParam a = publishLifeEventHelper2.a();
            Intent putExtra = new Intent().putExtra("publishLifeEventParams", a);
            if (publishLifeEventHelper2.a(a)) {
                putExtra.putExtra("is_uploading_media", true);
            }
            return putExtra;
        }
    }

    /* compiled from: Ljava/lang/Integer; */
    class C16326 implements Getter<String> {
        final /* synthetic */ LifeEventComposerPlugin f13974a;

        C16326(LifeEventComposerPlugin lifeEventComposerPlugin) {
            this.f13974a = lifeEventComposerPlugin;
        }

        public final Object m15088a() {
            return this.f13974a.b.getString(2131234188);
        }
    }

    /* compiled from: Ljava/lang/Integer; */
    class C16337 implements TextWithEntitiesChangedListener {
        final /* synthetic */ LifeEventComposerPlugin f13975a;

        C16337(LifeEventComposerPlugin lifeEventComposerPlugin) {
            this.f13975a = lifeEventComposerPlugin;
        }

        public final void m15090a(GraphQLTextWithEntities graphQLTextWithEntities, boolean z) {
            this.f13975a.E().b.m7468a(graphQLTextWithEntities);
        }

        public final void m15089a(GraphQLTextWithEntities graphQLTextWithEntities) {
        }
    }

    /* compiled from: Ljava/lang/Integer; */
    class C16348 extends BaseTextWatcher {
        final /* synthetic */ LifeEventComposerPlugin f13976a;

        C16348(LifeEventComposerPlugin lifeEventComposerPlugin) {
            this.f13976a = lifeEventComposerPlugin;
        }

        public void afterTextChanged(Editable editable) {
            AnonymousClass36 anonymousClass36 = this.f13976a.E().b;
            Builder l = this.f13976a.E().a.m7438n().l();
            l.a = editable.toString();
            anonymousClass36.m7467a(l.a(), LifeEventComposerPlugin.f13979a);
        }
    }

    /* compiled from: Ljava/lang/Integer; */
    class C16359 implements OnClickListener {
        final /* synthetic */ LifeEventComposerPlugin f13977a;

        C16359(LifeEventComposerPlugin lifeEventComposerPlugin) {
            this.f13977a = lifeEventComposerPlugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2074952871);
            Intent a2 = ComposerLifeEventIconsActivity.a(this.f13977a.b);
            a2.putExtra("extra_composer_life_event_model", this.f13977a.E().a.m7438n());
            C07625 c07625 = this.f13977a.E().c;
            ((SecureContextHelper) c07625.f6099a.bP.get()).a(a2, 12, c07625.f6099a);
            Logger.a(2, EntryType.UI_INPUT_END, -1851169794, a);
        }
    }

    /* compiled from: Ljava/lang/Integer; */
    public class Factory implements com.facebook.ipc.composer.plugin.ComposerPlugin.Factory {
        private final LifeEventComposerPluginProvider f13978a;

        @Inject
        public Factory(LifeEventComposerPluginProvider lifeEventComposerPluginProvider) {
            this.f13978a = lifeEventComposerPluginProvider;
        }

        public final String m15092b() {
            return "LifeEventComposerPluginConfig";
        }

        public final ComposerPluginDefault m15091a(SerializedComposerPluginConfig serializedComposerPluginConfig, ComposerPluginSession composerPluginSession, @Nullable InstanceState instanceState) {
            LifeEventComposerPluginProvider lifeEventComposerPluginProvider = this.f13978a;
            return new LifeEventComposerPlugin(composerPluginSession, (Context) lifeEventComposerPluginProvider.getInstance(Context.class), (PublishLifeEventHelperProvider) lifeEventComposerPluginProvider.getOnDemandAssistedProviderForStaticDi(PublishLifeEventHelperProvider.class), (ComposerLifeEventDatePickerControllerProvider) lifeEventComposerPluginProvider.getOnDemandAssistedProviderForStaticDi(ComposerLifeEventDatePickerControllerProvider.class), (UpdateRelationshipStatusControllerProvider) lifeEventComposerPluginProvider.getOnDemandAssistedProviderForStaticDi(UpdateRelationshipStatusControllerProvider.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(lifeEventComposerPluginProvider), InputMethodManagerMethodAutoProvider.b(lifeEventComposerPluginProvider));
        }
    }

    @Inject
    public LifeEventComposerPlugin(@Assisted ComposerPluginSession composerPluginSession, Context context, PublishLifeEventHelperProvider publishLifeEventHelperProvider, ComposerLifeEventDatePickerControllerProvider composerLifeEventDatePickerControllerProvider, UpdateRelationshipStatusControllerProvider updateRelationshipStatusControllerProvider, QeAccessor qeAccessor, InputMethodManager inputMethodManager) {
        super(context, composerPluginSession);
        this.f13983e = publishLifeEventHelperProvider;
        this.f13981c = composerLifeEventDatePickerControllerProvider;
        this.f13982d = updateRelationshipStatusControllerProvider;
        this.f13984f = qeAccessor;
        this.f13985g = inputMethodManager;
    }

    public final void m15109a(ComposerEvent composerEvent, @Nullable ComposerEventOriginator composerEventOriginator) {
        if (this.f13984f.a(ExperimentsForFeedUtilComposerAbtestModule.H, false)) {
            this.f13980b.m8098a(composerEvent, composerEventOriginator);
        }
        if (composerEvent == ComposerEvent.ON_DATASET_CHANGE) {
            if (!composerEventOriginator.a.equals(f13979a.a)) {
                aR();
            }
            if (!E().a.m7405F() && E().a.m7419V() != null) {
                CharSequence V = E().a.m7419V();
                if (this.f13986h != null) {
                    CharSequence spannableStringBuilder = new SpannableStringBuilder(this.f13986h.getUserText());
                    spannableStringBuilder.append(V);
                    int selectionStart = this.f13986h.getSelectionStart();
                    int selectionEnd = this.f13986h.getSelectionEnd();
                    this.f13986h.setText(spannableStringBuilder);
                    this.f13986h.setSelection(selectionStart, selectionEnd);
                }
            }
        }
    }

    @Nullable
    protected final BooleanGetter aM() {
        return BooleanGetter.b;
    }

    @Nullable
    protected final BooleanGetter aK() {
        return BooleanGetter.b;
    }

    private void m15094a(ComposerLifeEventModel composerLifeEventModel, TextWatcher textWatcher, OnClickListener onClickListener) {
        ComposerLifeEventViewBinder.a(this.b.getResources(), aS(), composerLifeEventModel, textWatcher, onClickListener);
    }

    @Nullable
    protected final BooleanGetter m15095I() {
        return BooleanGetter.b;
    }

    protected final BooleanGetter m15096J() {
        return BooleanGetter.b;
    }

    @Nullable
    protected final Getter<String> m15097K() {
        return new C16271(this);
    }

    @Nullable
    protected final BooleanGetter m15098L() {
        return BooleanGetter.b;
    }

    protected final BooleanGetter m15100N() {
        return BooleanGetter.a;
    }

    protected final BooleanGetter m15101O() {
        return new C16282(this);
    }

    protected final BooleanGetter m15102P() {
        return new C16293(this);
    }

    @Nullable
    protected final BooleanGetter m15103Q() {
        return BooleanGetter.b;
    }

    protected final BooleanGetter m15104R() {
        return new C16304(this);
    }

    @Nullable
    protected final Getter<Intent> m15106V() {
        return new C16315(this);
    }

    @Nullable
    protected final BooleanGetter m15105U() {
        return BooleanGetter.b;
    }

    @Nullable
    protected final BooleanGetter m15107Y() {
        return BooleanGetter.b;
    }

    @Nullable
    protected final BooleanGetter m15108Z() {
        return BooleanGetter.b;
    }

    @Nullable
    protected final BooleanGetter ac() {
        return BooleanGetter.b;
    }

    @Nullable
    protected final Getter<String> aB() {
        return new C16326(this);
    }

    @Nullable
    protected final BooleanGetter aD() {
        return BooleanGetter.b;
    }

    public final boolean m15110a(ViewStub viewStub) {
        viewStub.setLayoutResource(2130905035);
        View inflate = viewStub.inflate();
        this.f13986h = (ComposerEditText) inflate.findViewById(2131563416);
        this.f13986h.setHint((CharSequence) au().a());
        this.f13986h.setIncludeFriends(true);
        this.f13986h.a(new C16337(this));
        if (!StringUtil.a(E().a.ae().a())) {
            this.f13986h.setText(E().a.ae().a());
            int length = this.f13986h.getUserText().length();
            Selection.setSelection(this.f13986h.getText(), length, length);
        }
        boolean a = this.f13984f.a(ExperimentsForFeedUtilComposerAbtestModule.H, false);
        this.f13987i = new LazyView((ViewStub) inflate.findViewById(a ? 2131563415 : 2131563414));
        if (a) {
            m15093a(E().a);
        }
        aR();
        return true;
    }

    private void aR() {
        if (E().a.m7438n() != null) {
            m15094a(E().a.m7438n(), new C16348(this), new C16359(this));
        }
    }

    private ComposerLifeEventEditor aS() {
        return (ComposerLifeEventEditor) this.f13987i.a();
    }

    private <DataProvider extends ProvidesDateInfo> void m15093a(DataProvider dataProvider) {
        View a = this.f13987i.a();
        if (a != null && (a instanceof ComposerLifeEventWithDatePickerView)) {
            ComposerLifeEventWithDatePickerView composerLifeEventWithDatePickerView = (ComposerLifeEventWithDatePickerView) a;
            ComposerLifeEventDatePickerControllerProvider composerLifeEventDatePickerControllerProvider = this.f13981c;
            this.f13980b = new ComposerLifeEventDatePickerController(dataProvider, new Object(this) {
                public final /* synthetic */ LifeEventComposerPlugin f13963a;

                {
                    this.f13963a = r1;
                }
            }, composerLifeEventWithDatePickerView, (Context) composerLifeEventDatePickerControllerProvider.getInstance(Context.class), (TimeFormatUtil) DefaultTimeFormatUtil.a(composerLifeEventDatePickerControllerProvider));
        }
    }

    public final void m15111b() {
        if (this.f13987i != null && this.f13987i.b() && aS().hs_()) {
            aS().hr_();
        } else {
            this.f13986h.requestFocus();
        }
        this.f13986h.postDelayed(new Runnable(this) {
            final /* synthetic */ LifeEventComposerPlugin f13964a;

            {
                this.f13964a = r1;
            }

            public void run() {
                if (!this.f13964a.f13985g.showSoftInput(this.f13964a.f13986h, 0)) {
                    this.f13964a.f13985g.hideSoftInputFromWindow(this.f13964a.f13986h.getWindowToken(), 0);
                    this.f13964a.f13985g.toggleSoftInput(0, 0);
                    this.f13964a.f13985g.showSoftInput(this.f13964a.f13986h, 0);
                }
            }
        }, 100);
    }

    @Nullable
    protected final BooleanGetter aE() {
        return BooleanGetter.a;
    }

    @Nullable
    protected final BooleanGetter aF() {
        return BooleanGetter.b;
    }

    @Nullable
    protected final BooleanGetter aH() {
        return BooleanGetter.b;
    }

    @Nullable
    protected final BooleanGetter aJ() {
        return new BooleanGetter(this) {
            final /* synthetic */ LifeEventComposerPlugin f13965c;

            {
                this.f13965c = r1;
            }

            public final boolean m15081a() {
                Object obj;
                boolean z;
                LifeEventComposerPlugin lifeEventComposerPlugin = this.f13965c;
                UpdateRelationshipStatusController updateRelationshipStatusController = new UpdateRelationshipStatusController(new DialogInterface.OnClickListener(lifeEventComposerPlugin) {
                    final /* synthetic */ LifeEventComposerPlugin f13966a;

                    {
                        this.f13966a = r1;
                    }

                    public void onClick(DialogInterface dialogInterface, int i) {
                        AnonymousClass36 anonymousClass36 = this.f13966a.E().b;
                        Builder l = this.f13966a.E().a.m7438n().l();
                        l.e = true;
                        anonymousClass36.m7467a(l.a(), null);
                    }
                }, new OnDismissListener(lifeEventComposerPlugin) {
                    final /* synthetic */ LifeEventComposerPlugin f13967a;

                    {
                        this.f13967a = r1;
                    }

                    public void onDismiss(DialogInterface dialogInterface) {
                        ComposerFragment.bA(this.f13967a.E().c.f6099a);
                    }
                }, lifeEventComposerPlugin.b);
                GraphQLLifeEventAPIIdentifier graphQLLifeEventAPIIdentifier = lifeEventComposerPlugin.E().a.m7438n().b;
                if (graphQLLifeEventAPIIdentifier == GraphQLLifeEventAPIIdentifier.MARRIED || graphQLLifeEventAPIIdentifier == GraphQLLifeEventAPIIdentifier.ENGAGED) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    String str = lifeEventComposerPlugin.E().a.m7438n().g;
                    AlertDialog.Builder a = new FbAlertDialogBuilder(updateRelationshipStatusController.c).a(updateRelationshipStatusController.c.getResources().getString(2131234189)).a(true).a(updateRelationshipStatusController.c.getString(2131230735), updateRelationshipStatusController.a).b(updateRelationshipStatusController.c.getString(2131230736), new 1(updateRelationshipStatusController)).a(updateRelationshipStatusController.b);
                    if (!StringUtil.a(str)) {
                        View inflate = LayoutInflater.from(updateRelationshipStatusController.c).inflate(2130903692, null);
                        ((TextView) inflate.findViewById(2131560548)).setText(updateRelationshipStatusController.c.getResources().getString(2131234190, new Object[]{str}));
                        a.b(inflate);
                    }
                    a.a().show();
                    z = true;
                } else {
                    z = false;
                }
                return z;
            }
        };
    }

    @Nullable
    protected final BooleanGetter aL() {
        return new BooleanGetter(this) {
            final /* synthetic */ LifeEventComposerPlugin f13968c;

            {
                this.f13968c = r1;
            }

            public final boolean m15082a() {
                return this.f13968c.f13984f.a(ExperimentsForFeedUtilComposerAbtestModule.I, false);
            }
        };
    }

    @Nullable
    protected final BooleanGetter m15099M() {
        return BooleanGetter.b;
    }
}
