package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class GetSourceCodeSumLine {
    /**
     * @param args
     */
    public static void main(String[] args) {

        // String JavaSourceCodeDir[] = {"G:\\workspace\\...\\...\\src", "G:\\workspace\\...\\...\\src"};
        String JavaSourceCodeDir[] = { "D:\\svn\\svn_tag\\TMS_TAG\\tms-web\\src\\main\\java\\com" };

        long codeCountLine = getJavaSourceCodeCountLine(JavaSourceCodeDir);

//        ArrayList<String> JavaSourceCodeDirs = new ArrayList<String>();
////        JavaSourceCodeDirs.add("G:\\workspace\\...\\...\\src");
////        JavaSourceCodeDirs.add("G:\\workspace\\...\\...\\src");
//        JavaSourceCodeDirs.add("E:\\workspace\\...\\...\\...\\src");
//
//        long codeCountLine = getJavaSourceCodeCountLine(JavaSourceCodeDirs);

        System.out.println(JavaSourceCodeDir.toString() + ":共有 "
                + codeCountLine + " 行java源代码");
    }


    public static long getJavaSourceCodeCountLine(String[] JavaSourceCodeDirs) {
        long codeCountLine = 0;
        for (String dirPath : JavaSourceCodeDirs) {
            File fl = new File(dirPath);
            if (fl.exists()) {
                codeCountLine += getJavaFileCountLine(fl);
            }
        }
        return codeCountLine;
    }

    public static long getJavaSourceCodeCountLine(ArrayList<String> JavaSourceCodeDirs) {
        long codeCountLine = 0;
        for (String dirPath : JavaSourceCodeDirs) {
            File fl = new File(dirPath);
            if (fl.exists()) {
                codeCountLine += getJavaFileCountLine(fl);
            }
        }
        return codeCountLine;
    }

    private static long getJavaFileCountLine(File fl) {
        long javaCodeCountLine = 0;

        if (fl != null && fl.exists()) {
            if (fl.isDirectory()) {
                File[] listFiles = fl.listFiles();
                for (File file : listFiles) {
                    javaCodeCountLine += getJavaFileCountLine(file);
                }
            } else if (fl.isFile() && !fl.isHidden()) {
                if (fl.getName().endsWith(".java")) {

                    FileReader fr = null;
                    BufferedReader br = null;
                    try {
                        fr = new FileReader(fl);
                        br = new BufferedReader(fr);
                        while (br.readLine() != null)
                            javaCodeCountLine++;
                        br.close();
                        fr.close();
                    } catch (Exception e) {
                    } finally {
                        if (fr != null) {
                            try {
                                fr.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            } finally {
                                fr = null;
                            }
                        }
                        if (br != null) {
                            try {
                                br.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            } finally {
                                br = null;
                            }
                        }
                    }
                }

            }
        }
        return javaCodeCountLine;
    }
}