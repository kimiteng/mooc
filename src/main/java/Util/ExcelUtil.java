/**
 * @author: haiqing.teng
 * @since: 2021/5/11 15:26
 */
package Util;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class ExcelUtil {
    private static FormulaEvaluator evaluator;
    public static List<Map<String, Object>> getParameter(String fileName) throws IOException {
        File file = new File(PathUtil.getParamFilePath() + File.separator + fileName);
        InputStream ips = new FileInputStream(file);
        HSSFWorkbook wb = new HSSFWorkbook(ips);
        HSSFSheet sheet = wb.getSheetAt(0);
        List<String> keyList = new ArrayList<>();
        List<Map<String,Object>> params = new ArrayList<>();
        for (int i =0;i<sheet.getPhysicalNumberOfRows();i++) {
            Map<String,Object> rowMap = new HashMap<>();
            HSSFRow row = sheet.getRow(i);
            for (int j=0;j<row.getPhysicalNumberOfCells();j++) {
                HSSFCell cell = row.getCell(j);
                if(i==0){
                    keyList.add(getCellValueByCell(cell));
                }else{
                    rowMap.put(keyList.get(j),getCellValueByCell(cell));
                }
            }
            if(rowMap.size()>0){
                params.add(rowMap);
            }

        }
        return params;
    }
    private static String getCellValueByCell(Cell cell) {
        //判断是否为null或空串
        if (cell==null || cell.toString().trim().equals("")) {
            return "";
        }
        String cellValue = "";
        int cellType=cell.getCellType();
        if(cellType== Cell.CELL_TYPE_FORMULA){ //表达式类型
            cellType=evaluator.evaluate(cell).getCellType();
        }

        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING: //字符串类型
                cellValue= cell.getStringCellValue().trim();
                cellValue= StringUtils.isEmpty(cellValue) ? "" : cellValue;
                break;
            case Cell.CELL_TYPE_BOOLEAN:  //布尔类型
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_NUMERIC: //数值类型
                cellValue = new DecimalFormat("#.######").format(cell.getNumericCellValue());
                break;
            default: //其它类型，取空串吧
                cellValue = "";
                break;
        }
        return cellValue;
    }



}
