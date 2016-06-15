package com.summer.utils;

import java.io.File;

import android.os.Environment;
import android.os.StatFs;


/**
 * SDcard ��ش���
 * 
 * @author LiJinlun
 * 
 */
public class FileUtils {

//    /**
//     * ��ȡָ���ļ���  �����ļ�
//     * @param Path
//     * @param Extension
//     * @param IsIterative
//     * @return
//     */
//    public static List<FileEntity> GetFiles(String Path, String Extension, boolean IsIterative) // ����Ŀ¼����չ��(�жϵ��ļ����͵ĺ�׺��)���Ƿ�������ļ���
//    {
//        List<FileEntity> mlist = new ArrayList<FileEntity>();
//        if (mlist != null && mlist.size() > 0)
//            mlist.clear();
//        File[] files = new File(Path).listFiles();
//        if (files != null) {
//            for (int i = 0; i < files.length; i++) {
//                File f = files[i];
//                if (f.isFile()) {
//                    if (f.getPath().substring(f.getPath().length() - Extension.length()).equals(Extension)) // �ж���չ��
//                    {
//                        FileEntity fileEnt = new FileEntity();
//                        fileEnt.setNewName(f.getName());
//                        fileEnt.setFileSize(CommonUtil.FormetFileSize(f.length()));
//                        fileEnt.setFilePath(f.getPath());
//
//                        mlist.add(fileEnt);
//                    }
//                    if (!IsIterative)
//                        break; // ����������Ӽ�Ŀ¼������
//                } else if (f.isDirectory() && f.getPath().indexOf("/.") == -1) // ���Ե��ļ��������ļ�/�ļ��У�
//                    GetFiles(f.getPath(), Extension, IsIterative); // ����Ϳ�ʼ�ݹ���
//            }
//
//        }
//        return mlist;
//    }

    /**
     * sdcard �Ƿ����
     * 
     * @return
     */
    public static boolean ExistSDCard() {
        if (android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)) {
            return true;
        } else
            return false;
    }

    /**
     * sdcard ʣ��ռ�
     * 
     * @return
     */
    public static long getSDFreeSize() {
        // ȡ��SD���ļ�·��
        File path = Environment.getExternalStorageDirectory();
        StatFs sf = new StatFs(path.getPath());
        // ��ȡ�������ݿ�Ĵ�С(Byte)
        @SuppressWarnings("deprecation")
        long blockSize = sf.getBlockSize();
        // ���е����ݿ������
        @SuppressWarnings("deprecation")
        long freeBlocks = sf.getAvailableBlocks();
        // ����SD�����д�С
        // return freeBlocks * blockSize; //��λByte
        // return (freeBlocks * blockSize)/1024; //��λKB
        return (freeBlocks * blockSize) / 1024 / 1024; // ��λMB
    }

    /**
     * sdcard ������
     * 
     * @return
     */
    public static long getSDAllSize() {
        // ȡ��SD���ļ�·��
        File path = Environment.getExternalStorageDirectory();
        StatFs sf = new StatFs(path.getPath());
        // ��ȡ�������ݿ�Ĵ�С(Byte)
        @SuppressWarnings("deprecation")
        long blockSize = sf.getBlockSize();
        // ��ȡ�������ݿ���
        @SuppressWarnings("deprecation")
        long allBlocks = sf.getBlockCount();
        // ����SD����С
        // return allBlocks * blockSize; //��λByte
        // return (allBlocks * blockSize)/1024; //��λKB
        return (allBlocks * blockSize) / 1024 / 1024; // ��λMB
    }

    // ��SD���ļ������ļ�ɾ��
    public static void deleteFile(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                return;
            } else if (file.isDirectory()) {
                // �������һ��Ŀ¼
                // ����Ŀ¼�����е��ļ� files[];
                File files[] = file.listFiles();
                for (int i = 0; i < files.length; i++) { // ����Ŀ¼�����е��ļ�
                    deleteFile(files[i]); // ��ÿ���ļ� ������������е���
                }
            }
            file.delete();
        }
    }

    /**
     * ɾ�������ļ�
     * 
     * @param file
     */
    public static void deleteSingleFile(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
            }
        }
    }
}
