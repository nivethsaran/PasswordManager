package files;
import java.io.*;
public class MainDirectory {
	public File userdata=new File("E:\\Misc\\OOPS Project\\UserData.txt");
	public void makeDir() throws IOException
{
	File dir=new File("E:\\Misc\\OOPS Project");
	if(!dir.exists())
		dir.mkdir();
}
	public void storeUserData()throws IOException {
		OutputStream store=new FileOutputStream(userdata,true);
	
	}
	public String readFileLine()
	{
		BufferedReader read;
		try {
			read=new BufferedReader(new FileReader(userdata));
			String tempLine=read.readLine();
			if(tempLine!=null)
				return tempLine;
			else
				return null;
		}
		catch(Exception E)
		{
			return null;
		}
	}
	public void addFileData(String line) throws IOException
	{
		FileWriter addData= new FileWriter(userdata,true);
		String newLine = System.getProperty("line.separator");
		byte buffer[]=line.getBytes();
		addData.write(line);
		addData.append('\n');
		addData.close();
	}
	
}
