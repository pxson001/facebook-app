package com.facebook.reportaproblem.base.dialog;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.reportaproblem.base.ReportAProblemConstants;
import com.facebook.reportaproblem.base.ReportAProblemKeyboardHelper;
import com.facebook.reportaproblem.base.bugreport.BugReportCategoryInfo;
import com.facebook.reportaproblem.base.bugreport.BugReportImageCopyTask;
import com.facebook.reportaproblem.base.bugreport.BugReportImageLoaderTask;
import com.facebook.reportaproblem.base.bugreport.BugReportUploadService;
import com.facebook.reportaproblem.base.bugreport.file.BugReportFile;
import com.facebook.reportaproblem.base.ui.BugReportComposerEditText;
import com.facebook.reportaproblem.base.ui.BugReportImageThumbnail;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: setSourceType */
public class BugReportComposerScreenController extends ReportAProblemBaseScreenController {
    public BugReportComposerEditText f4575b;
    public Button f4576c;
    private LinearLayout f4577d;
    public LinearLayout f4578e;
    public View f4579f;
    private boolean f4580g = false;
    public final Map<File, Bitmap> f4581h = new LinkedHashMap();
    private final Set<BugReportImageLoaderTask> f4582i = new HashSet();
    private final Set<BugReportImageCopyTask> f4583j = new HashSet();

    /* compiled from: setSourceType */
    public class C02711 implements OnClickListener {
        final /* synthetic */ BugReportComposerScreenController f4569a;

        public C02711(BugReportComposerScreenController bugReportComposerScreenController) {
            this.f4569a = bugReportComposerScreenController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1344817086);
            ReportAProblemBaseScreenController reportAProblemBaseScreenController = this.f4569a;
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction("android.intent.action.GET_CONTENT");
            reportAProblemBaseScreenController.f4566a.a(Intent.createChooser(intent, reportAProblemBaseScreenController.f4566a.getContext().getString(2131235897)), 1);
            Logger.a(2, EntryType.UI_INPUT_END, -1949078858, a);
        }
    }

    /* compiled from: setSourceType */
    public class C02722 implements TextWatcher {
        final /* synthetic */ BugReportComposerScreenController f4570a;

        public C02722(BugReportComposerScreenController bugReportComposerScreenController) {
            this.f4570a = bugReportComposerScreenController;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            if (editable.length() > 0) {
                this.f4570a.f4576c.setTextColor(this.f4570a.f4566a.jW_().getColor(2131363150));
                this.f4570a.f4576c.setEnabled(true);
                return;
            }
            this.f4570a.f4576c.setTextColor(this.f4570a.f4566a.jW_().getColor(2131363153));
            this.f4570a.f4576c.setEnabled(false);
        }
    }

    /* compiled from: setSourceType */
    public class C02733 implements OnClickListener {
        final /* synthetic */ BugReportComposerScreenController f4571a;

        public C02733(BugReportComposerScreenController bugReportComposerScreenController) {
            this.f4571a = bugReportComposerScreenController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 627082467);
            ReportAProblemKeyboardHelper.m7036a(this.f4571a.f4566a.getContext(), this.f4571a.f4575b);
            BugReportComposerScreenController.m7068i(this.f4571a);
            ReportAProblemDialogFragment reportAProblemDialogFragment = this.f4571a.f4566a;
            reportAProblemDialogFragment.ao = false;
            Intent intent = new Intent(reportAProblemDialogFragment.o(), BugReportUploadService.class);
            intent.putExtras(reportAProblemDialogFragment.ap());
            reportAProblemDialogFragment.o().startService(intent);
            this.f4571a.f4566a.m7090a(ReportAProblemConstants.f4532f);
            Logger.a(2, EntryType.UI_INPUT_END, 1628790676, a);
        }
    }

    public final View mo305a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.f4577d = (LinearLayout) layoutInflater.inflate(2130903452, viewGroup, false);
        this.f4575b = (BugReportComposerEditText) this.f4577d.findViewById(2131560052);
        this.f4576c = (Button) this.f4577d.findViewById(2131560056);
        this.f4578e = (LinearLayout) this.f4577d.findViewById(2131560053);
        this.f4579f = this.f4577d.findViewById(2131560054);
        this.f4579f.setOnClickListener(new C02711(this));
        this.f4575b.addTextChangedListener(new C02722(this));
        BugReportCategoryInfo bugReportCategoryInfo = (BugReportCategoryInfo) this.f4566a.ap().getParcelable("param_key_category_info");
        CharSequence string = this.f4566a.ap().getString("param_key_bug_report_description");
        if (bugReportCategoryInfo != null) {
            this.f4575b.setCategoryDescription(bugReportCategoryInfo.f4541a);
        }
        if (string != null) {
            this.f4575b.setText(string);
        }
        this.f4576c.setOnClickListener(new C02733(this));
        m7069k();
        m7070l();
        return this.f4577d;
    }

    public final void mo308b() {
        m7068i(this);
        this.f4577d = null;
        this.f4575b = null;
        this.f4576c = null;
        this.f4578e = null;
        this.f4579f = null;
    }

    public final void mo309c() {
        for (BugReportImageLoaderTask cancel : this.f4582i) {
            cancel.cancel(true);
        }
        for (BugReportImageCopyTask cancel2 : this.f4583j) {
            cancel2.cancel(true);
        }
        super.mo309c();
    }

    public final void m7073a(Bitmap bitmap, File file, BugReportImageLoaderTask bugReportImageLoaderTask) {
        this.f4582i.remove(bugReportImageLoaderTask);
        this.f4581h.put(file, bitmap);
        m7067a(file, bitmap, this.f4581h.size() - 1);
    }

    public final void mo310d() {
        this.f4575b.requestFocus();
        Context context = this.f4566a.getContext();
        View view = this.f4575b;
        if (context != null) {
            Configuration configuration = context.getResources().getConfiguration();
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
            if (inputMethodManager == null) {
                return;
            }
            if (null == null) {
                inputMethodManager.showSoftInput(view, 1);
            } else if (configuration.keyboard == 1 || configuration.hardKeyboardHidden != 1) {
                inputMethodManager.showSoftInput(view, 2);
            }
        }
    }

    public final void m7074a(File file, BugReportImageCopyTask bugReportImageCopyTask) {
        this.f4583j.remove(bugReportImageCopyTask);
        if (file != null) {
            m7066a(file);
        }
    }

    public final void mo307a(int i, int i2, Intent intent) {
        if (i == 1 && i2 == -1 && intent != null && intent.getData() != null) {
            Uri data = intent.getData();
            BugReportImageCopyTask bugReportImageCopyTask = new BugReportImageCopyTask(this.f4566a.aq(), this.f4566a.getContext().getContentResolver(), this);
            this.f4583j.add(bugReportImageCopyTask);
            bugReportImageCopyTask.execute(new Uri[]{data});
        }
    }

    public static void m7068i(BugReportComposerScreenController bugReportComposerScreenController) {
        ReportAProblemDialogFragment reportAProblemDialogFragment = bugReportComposerScreenController.f4566a;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (File fromFile : bugReportComposerScreenController.f4581h.keySet()) {
            arrayList.add(new BugReportFile("screenshot-" + i, Uri.fromFile(fromFile).toString(), "image/png"));
            i++;
        }
        reportAProblemDialogFragment.ap().putParcelableArrayList("param_key_bug_report_screenshot_files", arrayList);
        bugReportComposerScreenController.f4566a.ap().putString("param_key_bug_report_description", bugReportComposerScreenController.f4575b.getWrittenDescription());
    }

    private void m7069k() {
        int i = 0;
        for (File file : this.f4581h.keySet()) {
            m7067a(file, (Bitmap) this.f4581h.get(file), i);
            i++;
        }
    }

    private void m7070l() {
        if (!this.f4580g) {
            this.f4580g = true;
            List ar = this.f4566a.ar();
            if (!ar.isEmpty()) {
                m7066a(new File(((BugReportFile) ar.get(0)).b));
            }
        }
    }

    private void m7066a(File file) {
        if (!this.f4581h.containsKey(file)) {
            BugReportImageLoaderTask bugReportImageLoaderTask = new BugReportImageLoaderTask(this, (int) this.f4566a.jW_().getDimension(2131430606));
            this.f4582i.add(bugReportImageLoaderTask);
            bugReportImageLoaderTask.execute(new File[]{file});
        }
    }

    private void m7067a(final File file, Bitmap bitmap, int i) {
        Object obj = 1;
        if ((this.f4577d != null ? 1 : null) != null) {
            final View bugReportImageThumbnail = new BugReportImageThumbnail(this.f4566a.getContext());
            bugReportImageThumbnail.f4599a.setImageBitmap(bitmap);
            bugReportImageThumbnail.f4600b.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ BugReportComposerScreenController f4574c;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1259963418);
                    this.f4574c.f4578e.removeView(bugReportImageThumbnail);
                    this.f4574c.f4581h.remove(file);
                    Object obj = this.f4574c.f4579f.getParent() == this.f4574c.f4578e ? 1 : null;
                    if (this.f4574c.f4581h.size() < 3 && obj == null) {
                        this.f4574c.f4578e.addView(this.f4574c.f4579f);
                    }
                    LogUtils.a(-210795789, a);
                }
            });
            this.f4578e.addView(bugReportImageThumbnail, i);
            if (i != 2) {
                obj = null;
            }
            if (obj != null) {
                this.f4578e.removeView(this.f4579f);
            }
        }
    }
}
