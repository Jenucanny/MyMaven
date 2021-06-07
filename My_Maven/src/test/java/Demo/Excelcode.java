package Demo;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelcode {
	public XSSFSheet s;
	public Excelcode() throws IOException
	{
	FileInputStream f=new FileInputStream("C:\\Users\\Hi\\Desktop\\Manual Testing\\tescasegmail.xlsx");
	XSSFWorkbook w= new XSSFWorkbook(f);
	s=w.getSheet("Sheet1");

	}

	public String readdata(int i,int j)
	{
	Row r=s.getRow(i);
	Cell c=r.getCell(j);
	int celltype=c.getCellType();

	switch(celltype)
	{
	case Cell.CELL_TYPE_NUMERIC:
	{
	double d=c.getNumericCellValue();
	return String.valueOf(d);
	}
	case Cell.CELL_TYPE_STRING:
	{
	return c.getStringCellValue();
	}
	}
	return null;

	}

	public int rowsize()
	{
	int rowno=s.getLastRowNum()+1;
	return rowno;
	}
	
	
}
