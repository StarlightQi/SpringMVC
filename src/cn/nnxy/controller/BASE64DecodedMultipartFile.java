package cn.nnxy.controller;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

public class BASE64DecodedMultipartFile implements MultipartFile {

    private final byte[] imgContent;
    private final String header;

    public BASE64DecodedMultipartFile(byte[] imgContent, String header) {
        this.imgContent = imgContent;
        this.header = header.split(";")[0];
    }

    @Override
    public String getName() {
        return System.currentTimeMillis() + Math.random() + "." + header.split("/")[1];
    }

    @Override
    public String getOriginalFilename() {
        return System.currentTimeMillis() + (int) Math.random() * 10000 + "." + header.split("/")[1];
    }

    @Override
    public String getContentType() {
        return header.split(":")[1];
    }

    @Override
    public boolean isEmpty() {
        return imgContent == null || imgContent.length == 0;
    }

    @Override
    public long getSize() {
        return imgContent.length;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return imgContent;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(imgContent);
    }

    @Override
    public void transferTo(File dest) throws IOException, IllegalStateException {
        new FileOutputStream(dest).write(imgContent);
    }

    public static String saveBase64(String base64, String path) {
        try {
            String[] baseStrs = base64.split(",");

            BASE64Decoder decoder = new BASE64Decoder();
            byte[] b = new byte[0];
            b = decoder.decodeBuffer(baseStrs[1]);

            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            BASE64DecodedMultipartFile file = new BASE64DecodedMultipartFile(b, baseStrs[0]);
            return saveOneFile(file, path);
        } catch (IOException e) {
            e.printStackTrace();
            return "没有上传成功！";
        }
    }


    public static String saveOneFile(MultipartFile attach, String path) {
        String newFileName = "";
        // 文件名的后缀
        String suffix = FilenameUtils.getExtension(attach.getOriginalFilename());
        newFileName = System.currentTimeMillis() + "-" + RandomUtils.nextInt(1000000) + "." + suffix;
        // 创建文件（全路径名）
        File targetFile = new File(path, newFileName);
        // 如果文件（夹）不存在，则创建
        try {
            // 向文件中写入数据
            attach.transferTo(targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return newFileName;
    }

}