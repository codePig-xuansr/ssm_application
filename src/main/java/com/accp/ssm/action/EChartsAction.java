package com.accp.ssm.action;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.ssm.biz.BxBiz;
import com.accp.ssm.pojo.Count;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

@RestController
@RequestMapping("/api/excel")
public class EChartsAction {
	@Resource
	private BxBiz biz;
	
	@GetMapping("excelByMonth/{year}/{month}/{departmentId}")
	public String exportExcelByMonth(@PathVariable Integer year,@PathVariable Integer month,@PathVariable Integer departmentId) throws Exception {
		String title=year+"年"+month+"月月度报销统计详情";
		if(year==0) {
			year=null;
		}
		if(departmentId==0) {
			departmentId=null;
		}
		List<Count> data=biz.getCountDetailsByMonth(year, month, departmentId);
		List<String[]> list = new ArrayList<String[]>();
		for (Count ex : data) {
			String[] str = new String[] { ex.getCountId().toString(), ex.getEmployeeName(),ex.getMoney().toString(), ex.getYear().toString(), ex.getMonth().toString(), ex.getDepartmentName() };
			list.add(str);
		}
		int count = this.reprotExcel(title,list);
		if(count>0) {
			return "ok";
		}else {
			return "no";
		}
	}
	
	@GetMapping("excelByYear/{year}/{departmentId}")
	public String exportExcelByYear(@PathVariable Integer year,@PathVariable Integer departmentId) {
		String title=year+"年年度报销统计详情";
		if(departmentId==0) {
			departmentId=null;
		}
		List<Count> data=biz.getCountDetailsByYear(year, departmentId);
		List<String[]> list = new ArrayList<String[]>();
		for (Count ex : data) {
			String[] str = new String[] { ex.getCountId().toString(), ex.getEmployeeName(),ex.getMoney().toString(), ex.getYear().toString(), ex.getMonth().toString(), ex.getDepartmentName() };
			list.add(str);
		}
		int count = this.reprotExcel(title,list);
		if(count>0) {
			return "ok";
		}else {
			return "no";
		}
	}
	
	public Integer reprotExcel(String title,List<String[]> pageDataList) {
		String fileName = title;
		try {
			WritableWorkbook wbook = Workbook
					.createWorkbook(new FileOutputStream("E:\\ssm_Excel\\"+fileName + ".xls")); // 建立excel文件
			WritableSheet wsheet = wbook.createSheet("导出数据", 0); // sheet名称
			WritableCellFormat cellFormatNumber = new WritableCellFormat();
			cellFormatNumber.setAlignment(Alignment.RIGHT);

			WritableFont wf = new WritableFont(WritableFont.ARIAL, 12,
					WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
					jxl.format.Colour.BLACK); // 定义格式、字体、粗体、斜体、下划线、颜色
			WritableCellFormat wcf = new WritableCellFormat(wf); // title单元格定义
			WritableCellFormat wcfc = new WritableCellFormat(); // 一般单元格定义
			WritableCellFormat wcfe = new WritableCellFormat(); // 一般单元格定义
			wcf.setAlignment(jxl.format.Alignment.CENTRE); // 设置对齐方式
			wcfc.setAlignment(jxl.format.Alignment.CENTRE); // 设置对齐方式

			wcf.setBorder(jxl.format.Border.ALL,
					jxl.format.BorderLineStyle.THIN);
			wcfc.setBorder(jxl.format.Border.ALL,
					jxl.format.BorderLineStyle.THIN);
			wcfe.setBorder(jxl.format.Border.ALL,
					jxl.format.BorderLineStyle.THIN);

			wsheet.setColumnView(0, 20);// 设置列宽
			wsheet.setColumnView(1, 10);
			wsheet.setColumnView(2, 20);

			int rowIndex = 0;
			int columnIndex = 0;
			if (null != pageDataList) {
				// rowIndex++;
				columnIndex = 0;
				wsheet.setRowView(rowIndex, 500);// 设置标题行高
				wsheet.addCell(new Label(columnIndex++, rowIndex, fileName, wcf));
				wsheet.mergeCells(0, rowIndex,  5, rowIndex);// 合并标题所占单元格
				rowIndex++;
				columnIndex = 0;
				wsheet.setRowView(rowIndex, 380);// 设置项目名行高
				wsheet.addCell(new Label(columnIndex++, rowIndex, "编号", wcf));
				wsheet.addCell(new Label(columnIndex++, rowIndex, "报销人", wcf));
				wsheet.addCell(new Label(columnIndex++, rowIndex, "报销金额", wcf));
				wsheet.addCell(new Label(columnIndex++, rowIndex, "年份", wcf));
				wsheet.addCell(new Label(columnIndex++, rowIndex, "月份", wcf));
				wsheet.addCell(new Label(columnIndex++, rowIndex, "部门", wcf));
				// 开始行循环
				for (String[] array : pageDataList) { // 循环列
					rowIndex++;
					columnIndex = 0;
					wsheet.addCell(new Label(columnIndex++, rowIndex, array[0],
							wcfe));
					wsheet.addCell(new Label(columnIndex++, rowIndex, array[1],
							wcfe));
					wsheet.addCell(new Label(columnIndex++, rowIndex, array[2],
							wcfe));
					wsheet.addCell(new Label(columnIndex++, rowIndex, array[3],
							wcfe));
					wsheet.addCell(new Label(columnIndex++, rowIndex, array[4],
							wcfe));
					wsheet.addCell(new Label(columnIndex++, rowIndex, array[5], 
							wcfe));
					
				}

				rowIndex++;
				columnIndex = 0;
			}

			wbook.write();
			if (wbook != null) {
				wbook.close();
			}
			return 1;
		} catch (Exception e) {
			return 0;
		}

	}
}
