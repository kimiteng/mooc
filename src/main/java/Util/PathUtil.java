/**
 * @author: haiqing.teng
 * @since: 2021/5/7 11:33
 */
package Util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class PathUtil {
    private static int startIndex = 0;
    private static Logger logger = LogManager.getLogger();
    private static String paramFilePath = getProjectPath()+File.separator+"src"+ File.separator+"main"+File.separator+"resources"+File.separator+"TestFile";

    /**
     *获取项目路径
     * @return
     */
    public static String getProjectPath(){
        String classPath = PathUtil.class.getResource("/").getPath();
        logger.info(classPath.substring(startIndex,classPath.indexOf("/target")));
        return classPath.substring(startIndex,classPath.indexOf("/target"));
    }

    public static int getStartIndex() {
        return startIndex;
    }

    public static void setStartIndex(int startIndex) {
        PathUtil.startIndex = startIndex;
    }

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger logger) {
        PathUtil.logger = logger;
    }

    public static String getParamFilePath() {
        return paramFilePath;
    }

    public static void setParamFilePath(String paramFilePath) {
        PathUtil.paramFilePath = paramFilePath;
    }

    public static void main(String[] args) {
        System.out.println(getProjectPath());
    }
}
