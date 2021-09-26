import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
	static int[] arrayBig;
    public static int[] arraySmall;
    public final static String READERBIG = "C:/Users/Financiero/source/repos/Ordering-Experiment/data/BigSize.csv";
    public final static String READERSMALL = "C:/Users/Financiero/source/repos/Ordering-Experiment/data/SmallSize.csv";
    public final static String TRATEMENTS = "C:/Users/Financiero/source/repos/Ordering-Experiment/data/TratementsJava.csv";
	public static void main(String[] args) throws IOException {
		arrayBig = new int[10000];
        arraySmall = new int[100];
        importData(READERBIG,arrayBig);
        importData(READERSMALL,arraySmall);
        tratementsAll();
        
	}
	public static void importData(String name, int[] array) throws IOException   {
		File f=new File(name);
		int cont=0;
		BufferedReader br =new BufferedReader(new FileReader(f));
		String line=br.readLine();
		while(line!=null) {
			if(cont>=0){
			array[cont]	=Integer.parseInt(line);
			}
			line=br.readLine();
			cont++;
		}
		br.close();
	}
	public static void tratementsAll() throws FileNotFoundException
    {
		File f=new File(TRATEMENTS);
		PrintWriter pw =new PrintWriter(f);
		String line=" ";
        for (int i = 0; i < 100; i++)
        {
        	line= " ";
        	long startTime = System.currentTimeMillis();;
            bubbleSort(arrayBig);
            long endTime   = System.currentTimeMillis();;
        	long totalTime = endTime - startTime;
            line = line + totalTime + "|";

            long startTime2 = System.currentTimeMillis();;
            bubbleSort(arraySmall);
            long endTime2   = System.currentTimeMillis();;
            long totalTime2 = endTime2 - startTime2;
            line = line + totalTime2 + "|";

            long startTime3 = System.currentTimeMillis();;
            insertionSort(arrayBig);
            long endTime3   = System.currentTimeMillis();;
            long totalTime3 = endTime3 - startTime3;
            line = line + totalTime3 + "|";

            long startTime4 = System.currentTimeMillis();;
            insertionSort(arraySmall);
            long endTime4   = System.currentTimeMillis();;
            long totalTime4 = endTime4 - startTime4;
            line = line + totalTime4 + "|";

            pw.write(line + "\n");
            
        }
        pw.close();
    }
	public static void bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }
	public static void insertionSort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

}
