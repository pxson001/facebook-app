package com.facebook.bugreporter;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: stickers */
public class BugReportingXConfig extends XConfig {
    public static final XConfigSetting f1681A = new XConfigSetting(f1686F, "send_rtc_engine_log_async");
    public static final XConfigSetting f1682B = new XConfigSetting(f1686F, "send_search_events_async");
    public static final XConfigSetting f1683C = new XConfigSetting(f1686F, "send_xconfigs_async");
    public static final XConfigSetting f1684D = new XConfigSetting(f1686F, "timeout_attachment_futures");
    public static final XConfigSetting f1685E = new XConfigSetting(f1686F, "attachment_future_timeout_time_s");
    private static final XConfigName f1686F = new XConfigName("bug_reporting");
    private static final ImmutableSet<XConfigSetting> f1687G = ImmutableSet.of(f1688c, f1689d, f1690e, f1691f, f1692g, f1693h, new XConfigSetting[]{f1694i, f1695j, f1696k, f1697l, f1698m, f1699n, f1700o, f1701p, f1702q, f1703r, f1704s, f1705t, f1706u, f1707v, f1708w, f1709x, f1710y, f1711z, f1681A, f1682B, f1683C, f1684D, f1685E});
    public static final XConfigSetting f1688c = new XConfigSetting(f1686F, "async_attachments_retry_count");
    public static final XConfigSetting f1689d = new XConfigSetting(f1686F, "bug_report_retry_count");
    public static final XConfigSetting f1690e = new XConfigSetting(f1686F, "send_bug_report_operation_async");
    public static final XConfigSetting f1691f = new XConfigSetting(f1686F, "send_debug_log_files_async");
    public static final XConfigSetting f1692g = new XConfigSetting(f1686F, "send_dump_sys_async");
    public static final XConfigSetting f1693h = new XConfigSetting(f1686F, "send_debug_info_async");
    public static final XConfigSetting f1694i = new XConfigSetting(f1686F, "send_fb_liger_reporting_async");
    public static final XConfigSetting f1695j = new XConfigSetting(f1686F, "send_gatekeepers_async");
    public static final XConfigSetting f1696k = new XConfigSetting(f1686F, "send_instant_article_activity_async");
    public static final XConfigSetting f1697l = new XConfigSetting(f1686F, "send_messages_async");
    public static final XConfigSetting f1698m = new XConfigSetting(f1686F, "send_quick_experiments_async");
    public static final XConfigSetting f1699n = new XConfigSetting(f1686F, "send_anr_traces_async");
    public static final XConfigSetting f1700o = new XConfigSetting(f1686F, "send_stack_trace_dump_async");
    public static final XConfigSetting f1701p = new XConfigSetting(f1686F, "send_view_hierarchy_async");
    public static final XConfigSetting f1702q = new XConfigSetting(f1686F, "send_screenshots_async");
    public static final XConfigSetting f1703r = new XConfigSetting(f1686F, "send_contacts_async");
    public static final XConfigSetting f1704s = new XConfigSetting(f1686F, "send_network_stats_async");
    public static final XConfigSetting f1705t = new XConfigSetting(f1686F, "send_recent_navigation_async");
    public static final XConfigSetting f1706u = new XConfigSetting(f1686F, "send_recent_db_messages_async");
    public static final XConfigSetting f1707v = new XConfigSetting(f1686F, "send_message_failed_async");
    public static final XConfigSetting f1708w = new XConfigSetting(f1686F, "send_omnistore_files_async");
    public static final XConfigSetting f1709x = new XConfigSetting(f1686F, "send_serialized_story_async");
    public static final XConfigSetting f1710y = new XConfigSetting(f1686F, "send_post_failure_data_async");
    public static final XConfigSetting f1711z = new XConfigSetting(f1686F, "send_recent_messages_async");

    @Inject
    public BugReportingXConfig() {
        super(f1686F, f1687G);
    }
}
