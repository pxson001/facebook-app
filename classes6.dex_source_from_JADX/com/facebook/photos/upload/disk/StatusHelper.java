package com.facebook.photos.upload.disk;

import com.facebook.device.resourcemonitor.ResourceManager;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Objects;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: graph_search_v2_pulse */
public class StatusHelper {
    public final ResourceManager f13609a;

    public static StatusHelper m21311a(InjectorLike injectorLike) {
        return new StatusHelper(ResourceManager.a(injectorLike));
    }

    @Inject
    public StatusHelper(ResourceManager resourceManager) {
        this.f13609a = resourceManager;
    }

    public final String m21313a(@Nullable String str, @Nullable String str2) {
        Writer stringWriter = new StringWriter(1024);
        m21312a(new PrintWriter(stringWriter), str, str2, false);
        return stringWriter.toString();
    }

    public static void m21312a(PrintWriter printWriter, @Nullable String str, @Nullable String str2, boolean z) {
        IOException e;
        FileReader fileReader;
        int read;
        CharSequence str3;
        Throwable th;
        FileReader fileReader2 = null;
        if (str2 != null) {
            printWriter.append(str2).append(": ");
        }
        if (str == null) {
            printWriter.append("filePath == null");
            return;
        }
        printWriter.append(str);
        File file = new File(str);
        if (file.exists()) {
            printWriter.append(", size: ").print(file.length());
            if (!file.canRead()) {
                printWriter.append(", !file.canRead");
            }
        } else {
            printWriter.append(", !file.exists");
            File parentFile = file.getParentFile();
            if (parentFile == null) {
                printWriter.append(", parentFolder == null");
            } else if (!parentFile.isDirectory()) {
                printWriter.append(", !parentFolder.isDirectory");
            } else if (parentFile.canWrite()) {
                File file2 = new File(parentFile, ", testing-sub-dir-creation");
                if (!file2.mkdir()) {
                    printWriter.append(", !subDir.mkdir");
                } else if (!file2.delete()) {
                    printWriter.append(", !subDir.delete");
                }
            } else {
                printWriter.append(", !parentFolder.canWrite");
            }
        }
        printWriter.append(", disk total: ").print(file.getTotalSpace());
        printWriter.append(" usable: ").print(file.getUsableSpace());
        printWriter.append(" free: ").print(file.getFreeSpace());
        if (z) {
            FileWriter fileWriter;
            char[] cArr;
            if (file.exists()) {
                if (!file.canWrite()) {
                    printWriter.append(", !file.canWrite");
                }
                if (!file.delete()) {
                    printWriter.append(", !file.delete");
                }
            }
            try {
                fileWriter = new FileWriter(file);
                try {
                    fileWriter.write("something to write");
                    try {
                        fileWriter.close();
                    } catch (IOException e2) {
                        printWriter.append(", fileWriter.close ex: ").append(e2.getClass().getSimpleName()).append(", ").append(e2.getMessage());
                    }
                } catch (IOException e3) {
                    e2 = e3;
                    try {
                        printWriter.append(", ").append(fileWriter != null ? "write" : "create").append(" ex: ").append(e2.getClass().getSimpleName()).append(", ").append(e2.getMessage());
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (IOException e22) {
                                printWriter.append(", fileWriter.close ex: ").append(e22.getClass().getSimpleName()).append(", ").append(e22.getMessage());
                            }
                        }
                        if (fileWriter != null) {
                            if (file.exists()) {
                                printWriter.append(", written !file.exists");
                            } else if (file.length() == 0) {
                                printWriter.append(", written file.length == 0");
                            } else {
                                try {
                                    fileReader = new FileReader(file);
                                    try {
                                        cArr = new char[19];
                                        read = fileReader.read(cArr);
                                        if (read != 18) {
                                            printWriter.append(", read ").print(read);
                                            printWriter.append(" instead of ").print(18);
                                        } else {
                                            str3 = new String(cArr, 0, read);
                                            if (Objects.equal("something to write", str3)) {
                                                printWriter.append(", write/read check success");
                                            } else {
                                                printWriter.append(", write/read failed: '").append(str3).append('\'');
                                            }
                                        }
                                        try {
                                            fileReader.close();
                                        } catch (IOException e222) {
                                            printWriter.append(", fileReader.close ex: ").append(e222.getClass().getSimpleName()).append(", ").append(e222.getMessage());
                                        }
                                    } catch (IOException e4) {
                                        e222 = e4;
                                        fileReader2 = fileReader;
                                        try {
                                            printWriter.append(", ").append(fileReader2 != null ? "open" : "read").append(" ex: ").append(e222.getClass().getSimpleName()).append(", ").append(e222.getMessage());
                                            if (fileReader2 != null) {
                                                try {
                                                    fileReader2.close();
                                                } catch (IOException e2222) {
                                                    printWriter.append(", fileReader.close ex: ").append(e2222.getClass().getSimpleName()).append(", ").append(e2222.getMessage());
                                                }
                                            }
                                            if (file.exists()) {
                                            }
                                            return;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            fileReader = fileReader2;
                                            if (fileReader != null) {
                                                try {
                                                    fileReader.close();
                                                } catch (IOException e5) {
                                                    printWriter.append(", fileReader.close ex: ").append(e5.getClass().getSimpleName()).append(", ").append(e5.getMessage());
                                                }
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        if (fileReader != null) {
                                            fileReader.close();
                                        }
                                        throw th;
                                    }
                                } catch (IOException e6) {
                                    e2222 = e6;
                                    if (fileReader2 != null) {
                                    }
                                    printWriter.append(", ").append(fileReader2 != null ? "open" : "read").append(" ex: ").append(e2222.getClass().getSimpleName()).append(", ").append(e2222.getMessage());
                                    if (fileReader2 != null) {
                                        fileReader2.close();
                                    }
                                    if (file.exists()) {
                                        return;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    fileReader = null;
                                    if (fileReader != null) {
                                        fileReader.close();
                                    }
                                    throw th;
                                }
                            }
                        }
                        if (file.exists()) {
                            return;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (IOException e52) {
                                printWriter.append(", fileWriter.close ex: ").append(e52.getClass().getSimpleName()).append(", ").append(e52.getMessage());
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e7) {
                e2222 = e7;
                fileWriter = null;
                if (fileWriter != null) {
                }
                printWriter.append(", ").append(fileWriter != null ? "write" : "create").append(" ex: ").append(e2222.getClass().getSimpleName()).append(", ").append(e2222.getMessage());
                if (fileWriter != null) {
                    fileWriter.close();
                }
                if (fileWriter != null) {
                    if (file.exists()) {
                        printWriter.append(", written !file.exists");
                    } else if (file.length() == 0) {
                        fileReader = new FileReader(file);
                        cArr = new char[19];
                        read = fileReader.read(cArr);
                        if (read != 18) {
                            str3 = new String(cArr, 0, read);
                            if (Objects.equal("something to write", str3)) {
                                printWriter.append(", write/read failed: '").append(str3).append('\'');
                            } else {
                                printWriter.append(", write/read check success");
                            }
                        } else {
                            printWriter.append(", read ").print(read);
                            printWriter.append(" instead of ").print(18);
                        }
                        fileReader.close();
                    } else {
                        printWriter.append(", written file.length == 0");
                    }
                }
                if (file.exists()) {
                }
                return;
            } catch (Throwable th6) {
                th = th6;
                fileWriter = null;
                if (fileWriter != null) {
                    fileWriter.close();
                }
                throw th;
            }
            if (fileWriter != null) {
                if (file.exists()) {
                    printWriter.append(", written !file.exists");
                } else if (file.length() == 0) {
                    printWriter.append(", written file.length == 0");
                } else {
                    fileReader = new FileReader(file);
                    cArr = new char[19];
                    read = fileReader.read(cArr);
                    if (read != 18) {
                        printWriter.append(", read ").print(read);
                        printWriter.append(" instead of ").print(18);
                    } else {
                        str3 = new String(cArr, 0, read);
                        if (Objects.equal("something to write", str3)) {
                            printWriter.append(", write/read check success");
                        } else {
                            printWriter.append(", write/read failed: '").append(str3).append('\'');
                        }
                    }
                    fileReader.close();
                }
            }
            if (file.exists() && !file.delete()) {
                printWriter.append(", file.exists && !file.delete");
            }
        }
    }
}
