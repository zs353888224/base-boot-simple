package cn.wscq.spring.domain.util;

import java.io.*;

/**
 * @author shuai
 * @version 1.0
 * @description 为一些csv文件加上utf8标示，确保windows环境下打开没有乱码
 * @date 2017/12/11 17:23
 */
public class FileUtil {

    public static void writeFile(String filePath, String content) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void addUTF8BomMark(String srcFile, String targetFile) throws Exception {
        File target = new File(targetFile);
        FileOutputStream fos = new FileOutputStream(target, true);
        final byte[] bom = new byte[]{(byte) 0xEF, (byte) 0xBB, (byte) 0xBF};
        fos.write(bom);
        OutputStreamWriter sw = new OutputStreamWriter(fos, "UTF-8");
        BufferedWriter bw = new BufferedWriter(sw);

        File src = new File(srcFile);
        BufferedReader reader = new BufferedReader(new FileReader(src));
        String tempString;
        while ((tempString = reader.readLine()) != null) {
            bw.write(tempString);
            bw.write("\r\n");
        }
        reader.close();
        bw.close();
        fos.close();
    }
}
