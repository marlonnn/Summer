package com.summer.utils;

import java.io.File;

import android.os.Environment;
import android.os.StatFs;


/**
 * SDcard 相关处理
 * 
 * @author LiJinlun
 * 
 */
public class FileUtils {

//    /**
//     * 获取指定文件夹  所有文件
//     * @param Path
//     * @param Extension
//     * @param IsIterative
//     * @return
//     */
//    public static List<FileEntity> GetFiles(String Path, String Extension, boolean IsIterative) // 搜索目录，扩展名(判断的文件类型的后缀名)，是否进入子文件夹
//    {
//        List<FileEntity> mlist = new ArrayList<FileEntity>();
//        if (mlist != null && mlist.size() > 0)
//            mlist.clear();
//        File[] files = new File(Path).listFiles();
//        if (files != null) {
//            for (int i = 0; i < files.length; i++) {
//                File f = files[i];
//                if (f.isFile()) {
//                    if (f.getPath().substring(f.getPath().length() - Extension.length()).equals(Extension)) // 判断扩展名
//                    {
//                        FileEntity fileEnt = new FileEntity();
//                        fileEnt.setNewName(f.getName());
//                        fileEnt.setFileSize(CommonUtil.FormetFileSize(f.length()));
//                        fileEnt.setFilePath(f.getPath());
//
//                        mlist.add(fileEnt);
//                    }
//                    if (!IsIterative)
//                        break; // 如果不进入子集目录则跳出
//                } else if (f.isDirectory() && f.getPath().indexOf("/.") == -1) // 忽略点文件（隐藏文件/文件夹）
//                    GetFiles(f.getPath(), Extension, IsIterative); // 这里就开始递归了
//            }
//
//        }
//        return mlist;
//    }

    /**
     * sdcard 是否存在
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
     * sdcard 剩余空间
     * 
     * @return
     */
    public static long getSDFreeSize() {
        // 取得SD卡文件路径
        File path = Environment.getExternalStorageDirectory();
        StatFs sf = new StatFs(path.getPath());
        // 获取单个数据块的大小(Byte)
        @SuppressWarnings("deprecation")
        long blockSize = sf.getBlockSize();
        // 空闲的数据块的数量
        @SuppressWarnings("deprecation")
        long freeBlocks = sf.getAvailableBlocks();
        // 返回SD卡空闲大小
        // return freeBlocks * blockSize; //单位Byte
        // return (freeBlocks * blockSize)/1024; //单位KB
        return (freeBlocks * blockSize) / 1024 / 1024; // 单位MB
    }

    /**
     * sdcard 总容量
     * 
     * @return
     */
    public static long getSDAllSize() {
        // 取得SD卡文件路径
        File path = Environment.getExternalStorageDirectory();
        StatFs sf = new StatFs(path.getPath());
        // 获取单个数据块的大小(Byte)
        @SuppressWarnings("deprecation")
        long blockSize = sf.getBlockSize();
        // 获取所有数据块数
        @SuppressWarnings("deprecation")
        long allBlocks = sf.getBlockCount();
        // 返回SD卡大小
        // return allBlocks * blockSize; //单位Byte
        // return (allBlocks * blockSize)/1024; //单位KB
        return (allBlocks * blockSize) / 1024 / 1024; // 单位MB
    }

    // 将SD卡文件夹里文件删除
    public static void deleteFile(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                return;
            } else if (file.isDirectory()) {
                // 如果它是一个目录
                // 声明目录下所有的文件 files[];
                File files[] = file.listFiles();
                for (int i = 0; i < files.length; i++) { // 遍历目录下所有的文件
                    deleteFile(files[i]); // 把每个文件 用这个方法进行迭代
                }
            }
            file.delete();
        }
    }

    /**
     * 删除单个文件
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
