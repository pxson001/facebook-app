package com.facebook.groups.docsandfiles.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.dateformatter.EventsDashboardTimeFormatUtil;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.fbuploader.fbcommon.FbUploaderSingletonWrapper;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.groups.docsandfiles.controller.GroupsDocsAndFilesUploadController;
import com.facebook.groups.docsandfiles.controller.GroupsDocsAndFilesUploadController.UploadingFileItem;
import com.facebook.groups.docsandfiles.fragment.GroupDocsAndFilesFragment.C30527;
import com.facebook.groups.docsandfiles.intent.GroupDocsAndFilesPermalinkIntentFactory;
import com.facebook.groups.docsandfiles.protocol.GroupDocsAndFilesModels.GroupDocsAndFilesQueryModel.GroupDocsAndFilesModel.NodesModel;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.bottomsheet.BottomSheetAdapter;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import java.util.Date;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: Upload failed. */
public class GroupDocOrFileListViewItem extends ImageBlockLayout {
    public NodesModel f21393A;
    public BottomSheetDialog f21394B;
    public int f21395C = this.f21397h.getDimensionPixelSize(2131434264);
    private int f21396D;
    public Resources f21397h;
    private EventsDashboardTimeFormatUtil f21398i;
    public SecureContextHelper f21399j;
    private GroupDocsAndFilesPermalinkIntentFactory f21400k;
    public Provider<BottomSheetDialog> f21401l;
    public Lazy<GatekeeperStore> f21402m;
    public TextView f21403n;
    public TextView f21404o;
    public TextView f21405p;
    private String f21406q;
    public FileState f21407r;
    public int f21408s;
    public ImageButton f21409t;
    public GroupDocsAndFilesFragment f21410u;
    private ProgressBar f21411v;
    private ImageView f21412w;
    public OnClickListener f21413x;
    public OnClickListener f21414y;
    public OnClickListener f21415z;

    /* compiled from: Upload failed. */
    public class C30391 implements OnClickListener {
        final /* synthetic */ GroupDocOrFileListViewItem f21384a;

        public C30391(GroupDocOrFileListViewItem groupDocOrFileListViewItem) {
            this.f21384a = groupDocOrFileListViewItem;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -454786330);
            GroupDocOrFileListViewItem groupDocOrFileListViewItem = this.f21384a;
            groupDocOrFileListViewItem.f21394B = (BottomSheetDialog) groupDocOrFileListViewItem.f21401l.get();
            BottomSheetAdapter bottomSheetAdapter = new BottomSheetAdapter(groupDocOrFileListViewItem.f21394B.getContext());
            if (groupDocOrFileListViewItem.f21393A.m22480j() != null) {
                MenuItemImpl e = bottomSheetAdapter.e(2131242081);
                e.setIcon(2130839694);
                e.setOnMenuItemClickListener(new C30446(groupDocOrFileListViewItem));
            }
            MenuItemImpl e2 = bottomSheetAdapter.e(2131242084);
            e2.setIcon(2130840005);
            e2.setOnMenuItemClickListener(new C30435(groupDocOrFileListViewItem));
            groupDocOrFileListViewItem.f21394B.a(bottomSheetAdapter);
            groupDocOrFileListViewItem.f21394B.show();
            Logger.a(2, EntryType.UI_INPUT_END, 1476505040, a);
        }
    }

    /* compiled from: Upload failed. */
    public class C30402 implements OnClickListener {
        final /* synthetic */ GroupDocOrFileListViewItem f21385a;

        public C30402(GroupDocOrFileListViewItem groupDocOrFileListViewItem) {
            this.f21385a = groupDocOrFileListViewItem;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -380315902);
            GroupDocOrFileListViewItem.m22347l(this.f21385a);
            Logger.a(2, EntryType.UI_INPUT_END, 840830327, a);
        }
    }

    /* compiled from: Upload failed. */
    class C30413 implements OnClickListener {
        final /* synthetic */ GroupDocOrFileListViewItem f21386a;

        C30413(GroupDocOrFileListViewItem groupDocOrFileListViewItem) {
            this.f21386a = groupDocOrFileListViewItem;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -159703167);
            if (this.f21386a.f21410u != null) {
                GroupDocsAndFilesFragment groupDocsAndFilesFragment = this.f21386a.f21410u;
                String k = this.f21386a.f21393A.m22481k();
                groupDocsAndFilesFragment.as.m22341b(k);
                groupDocsAndFilesFragment.ap.m22314a(k, FileState.UPLOADING_IS_IN_PROGRESS);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 318313060, a);
        }
    }

    /* compiled from: Upload failed. */
    class C30424 implements OnClickListener {
        final /* synthetic */ GroupDocOrFileListViewItem f21387a;

        C30424(GroupDocOrFileListViewItem groupDocOrFileListViewItem) {
            this.f21387a = groupDocOrFileListViewItem;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 688291201);
            if (this.f21387a.f21410u != null) {
                GroupDocsAndFilesFragment groupDocsAndFilesFragment;
                String l;
                switch (this.f21387a.f21407r) {
                    case DOWNLOADING_IS_IN_PROGRESS:
                        groupDocsAndFilesFragment = this.f21387a.f21410u;
                        l = this.f21387a.f21393A.m22482l();
                        groupDocsAndFilesFragment.ap.m22312a(this.f21387a.f21408s, FileState.NORMAL);
                        if (groupDocsAndFilesFragment.ar != null) {
                            groupDocsAndFilesFragment.ar.f21349h.c("DOWNLOAD_GROUP_FILES_" + l);
                        }
                        break;
                    default:
                        Object obj;
                        groupDocsAndFilesFragment = this.f21387a.f21410u;
                        l = this.f21387a.f21393A.m22481k();
                        GroupsDocsAndFilesUploadController groupsDocsAndFilesUploadController = groupDocsAndFilesFragment.as;
                        UploadingFileItem uploadingFileItem = (UploadingFileItem) groupsDocsAndFilesUploadController.f21382l.get(l);
                        if (!(uploadingFileItem == null || (uploadingFileItem.f21368d == null && uploadingFileItem.f21366b == null))) {
                            if (uploadingFileItem.f21368d != null) {
                                ((FbUploaderSingletonWrapper) groupsDocsAndFilesUploadController.f21374d.get()).a.a(uploadingFileItem.f21368d);
                            }
                            groupsDocsAndFilesUploadController.f21382l.remove(l);
                        }
                        groupDocsAndFilesFragment.ap.m22315a(l, true);
                        if (groupDocsAndFilesFragment.aB) {
                            Object obj2;
                            if (groupDocsAndFilesFragment.as.f21382l.isEmpty()) {
                                obj2 = null;
                            } else {
                                obj2 = 1;
                            }
                            if (obj2 == null) {
                                obj = 1;
                                if (obj != null) {
                                    GroupDocsAndFilesFragment.m22366a(groupDocsAndFilesFragment, true);
                                    break;
                                }
                            }
                        }
                        obj = null;
                        if (obj != null) {
                            GroupDocsAndFilesFragment.m22366a(groupDocsAndFilesFragment, true);
                        }
                        break;
                }
            }
            LogUtils.a(1678183131, a);
        }
    }

    /* compiled from: Upload failed. */
    public class C30435 implements OnMenuItemClickListener {
        final /* synthetic */ GroupDocOrFileListViewItem f21388a;

        public C30435(GroupDocOrFileListViewItem groupDocOrFileListViewItem) {
            this.f21388a = groupDocOrFileListViewItem;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            GroupDocOrFileListViewItem.m22347l(this.f21388a);
            return true;
        }
    }

    /* compiled from: Upload failed. */
    public class C30446 implements OnMenuItemClickListener {
        final /* synthetic */ GroupDocOrFileListViewItem f21389a;

        public C30446(GroupDocOrFileListViewItem groupDocOrFileListViewItem) {
            this.f21389a = groupDocOrFileListViewItem;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            boolean z;
            GroupDocOrFileListViewItem groupDocOrFileListViewItem = this.f21389a;
            if (((GatekeeperStoreImpl) groupDocOrFileListViewItem.f21402m.get()).a(872, false) || groupDocOrFileListViewItem.f21393A.m22480j().contains("dropbox")) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(this.f21389a.f21393A.m22480j()));
                this.f21389a.f21399j.b(intent, this.f21389a.getContext());
            } else if (this.f21389a.f21410u != null) {
                GroupDocsAndFilesFragment groupDocsAndFilesFragment = this.f21389a.f21410u;
                groupDocsAndFilesFragment.az.a(GroupDocsAndFilesFragment.an, new C30527(groupDocsAndFilesFragment, this.f21389a.f21393A.m22482l(), this.f21389a.f21393A.m22480j(), this.f21389a.f21408s));
            }
            return true;
        }
    }

    /* compiled from: Upload failed. */
    public class FileModel {
        public final NodesModel f21391a;
        public FileState f21392b;

        public FileModel(NodesModel nodesModel, FileState fileState) {
            this.f21391a = nodesModel;
            this.f21392b = fileState;
        }
    }

    /* compiled from: Upload failed. */
    public enum FileState {
        UPLOADING_FAILED_SHOW_RETRY,
        UPLOADING_IS_IN_PROGRESS,
        DOWNLOADING_IS_IN_PROGRESS,
        NORMAL
    }

    @Inject
    public GroupDocOrFileListViewItem(@Assisted Context context, @Assisted GroupsDocOrFileRowListener groupsDocOrFileRowListener, Resources resources, EventsDashboardTimeFormatUtil eventsDashboardTimeFormatUtil, SecureContextHelper secureContextHelper, GroupDocsAndFilesPermalinkIntentFactory groupDocsAndFilesPermalinkIntentFactory, Provider<BottomSheetDialog> provider, Lazy<GatekeeperStore> lazy) {
        super(context);
        this.f21410u = groupsDocOrFileRowListener;
        this.f21397h = resources;
        this.f21398i = eventsDashboardTimeFormatUtil;
        this.f21399j = secureContextHelper;
        this.f21400k = groupDocsAndFilesPermalinkIntentFactory;
        this.f21401l = provider;
        this.f21402m = lazy;
        setContentView(2130904658);
        setBackgroundColor(this.f21397h.getColor(2131363931));
        setPadding(this.f21395C, 0, 0, 0);
        setThumbnailPadding(this.f21395C);
        setThumbnailGravity(17);
        this.f21403n = (TextView) findViewById(2131562679);
        this.f21404o = (TextView) findViewById(2131562680);
        this.f21405p = (TextView) findViewById(2131562681);
        this.f21409t = (ImageButton) this.a;
        this.f21414y = new C30391(this);
        this.f21415z = new C30402(this);
    }

    public final void m22348a(FileModel fileModel, String str, int i) {
        this.f21406q = str;
        this.f21408s = i;
        NodesModel nodesModel = fileModel.f21391a;
        this.f21407r = fileModel.f21392b;
        this.f21393A = nodesModel;
        this.f21403n.setText(nodesModel.m22482l());
        this.f21404o.setText(nodesModel.m22484n().m22474j());
        switch (this.f21407r) {
            case UPLOADING_IS_IN_PROGRESS:
            case UPLOADING_FAILED_SHOW_RETRY:
                setAlpha(0.5f);
                break;
            default:
                setAlpha(1.0f);
                break;
        }
        switch (this.f21407r) {
            case UPLOADING_IS_IN_PROGRESS:
                this.f21405p.setText(this.f21397h.getString(2131242078));
                setAlpha(0.5f);
                m22344i();
                return;
            case UPLOADING_FAILED_SHOW_RETRY:
                this.f21405p.setText(this.f21397h.getString(2131242080));
                setAlpha(0.5f);
                m22345j();
                return;
            case DOWNLOADING_IS_IN_PROGRESS:
                this.f21405p.setText(this.f21397h.getString(2131242079));
                setAlpha(1.0f);
                m22344i();
                return;
            default:
                setAlpha(1.0f);
                m22346k();
                return;
        }
    }

    private void m22343a(boolean z) {
        if (z && this.f21412w == null) {
            this.f21412w = new ImageView(getContext());
            this.f21412w.setImageDrawable(this.f21397h.getDrawable(2130840077));
            this.f21412w.setContentDescription(this.f21397h.getString(2131242088));
            this.f21396D = this.f21397h.getDimensionPixelSize(2131434261);
            this.f21412w.setOnClickListener(new C30413(this));
        } else if (!z && this.f21411v == null) {
            this.f21411v = new ProgressBar(getContext());
            this.f21396D = this.f21397h.getDimensionPixelSize(2131434261);
        }
        if (this.f21413x == null) {
            this.f21413x = new C30424(this);
        }
        this.f21409t.setImageDrawable(this.f21397h.getDrawable(2130839815));
        this.f21409t.setOnClickListener(this.f21413x);
        this.f21409t.setContentDescription(this.f21397h.getString(2131242089));
        setClickable(false);
    }

    private void m22344i() {
        m22343a(false);
        setThumbnailView(this.f21411v);
        d(this.f21396D, this.f21396D);
        setThumbnailGravity(17);
        setOnClickListener(null);
    }

    private void m22345j() {
        m22343a(true);
        setThumbnailView(this.f21412w);
        d(this.f21396D, this.f21396D);
        setThumbnailGravity(17);
        setOnClickListener(null);
    }

    private void m22346k() {
        this.f21405p.setText(this.f21398i.a(false, new Date(this.f21393A.m22477a() * 1000), null));
        this.f21409t.setImageDrawable(this.f21397h.getDrawable(2130843592));
        this.f21409t.setContentDescription(this.f21397h.getString(2131242085));
        this.f21409t.setOnClickListener(this.f21414y);
        if (this.f != null) {
            removeView(this.f);
        }
        setThumbnailDrawable(this.f21397h.getDrawable(2130840005));
        setOnClickListener(this.f21415z);
        setClickable(true);
    }

    public static void m22347l(GroupDocOrFileListViewItem groupDocOrFileListViewItem) {
        SecureContextHelper secureContextHelper = groupDocOrFileListViewItem.f21399j;
        GroupDocsAndFilesPermalinkIntentFactory a = groupDocOrFileListViewItem.f21400k.mo953a();
        groupDocOrFileListViewItem.f21393A.m22481k();
        secureContextHelper.a(a.mo955b().mo954a(groupDocOrFileListViewItem.f21393A.m22483m().m22463j()).mo956c(), groupDocOrFileListViewItem.getContext());
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -73636479);
        super.onDetachedFromWindow();
        if (this.f21394B != null && this.f21394B.isShowing()) {
            this.f21394B.dismiss();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -986246584, a);
    }
}
