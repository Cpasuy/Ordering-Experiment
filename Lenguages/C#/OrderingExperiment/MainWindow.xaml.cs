using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace OrderingExperiment
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    /// var readerBig;
    
    public partial class MainWindow : Window
    {
        public String readerBig;
        public String readerSmall;
        public String tratements;
        public StreamReader reader;
        public int[] arrayBig;
        public int[] arraySmall;
        public StreamWriter sw;
        public Stopwatch clock;
        public double duringtime;
        public string repetition;

        public MainWindow()
        {
            InitializeComponent();

            readerBig = @"C:\Users\Financiero\source\repos\Ordering-Experiment\data\BigSize.csv";
            readerSmall = @"C:\Users\Financiero\source\repos\Ordering-Experiment\data\SmallSize.csv";
            tratements = @"C:\Users\Financiero\source\repos\Ordering-Experiment\data\TratementsC#.csv";
            reader = null;
            arrayBig = new int[10000];
            arraySmall = new int[100];
            createArrays(readerBig, arrayBig);
            createArrays(readerSmall, arraySmall);
            sw = new StreamWriter(tratements, true);
            clock = new Stopwatch();
            duringtime = 0;
            repetition = "";
            tratementsAll();

        }
        public void createArrays(string path, int[] a)
        {
            
            string[] lines = File.ReadAllLines(path);

            for (int s=0;s<lines.Length;s++)

            {
                a[s] = int.Parse(lines[s]);
            }
            
        }
        public void tratementsAll()
        {
            for (int i = 0; i < 100; i++)
            {
                clock = new Stopwatch();
                clock.Start();
                bubbleSort(arrayBig);
                clock.Stop();
                duringtime = clock.ElapsedMilliseconds;
                repetition = repetition + duringtime + "|";

                clock = new Stopwatch();
                clock.Start();
                bubbleSort(arraySmall);
                clock.Stop();
                duringtime = clock.ElapsedMilliseconds;
                repetition = repetition + duringtime + "|";

                clock = new Stopwatch();
                clock.Start();
                insertionSort(arrayBig);
                clock.Stop();
                duringtime = clock.ElapsedMilliseconds;
                repetition = repetition + duringtime + "|";

                clock = new Stopwatch();
                clock.Start();
                insertionSort(arraySmall);
                clock.Stop();
                duringtime = clock.ElapsedMilliseconds;
                repetition = repetition + duringtime + "|";

                sw.WriteLine(repetition);
                repetition = "";
            }
            sw.Close();
        }
        public void bubbleSort(int [] arr)
        {
            int n = arr.Length;
            for (int i = 0; i < n - 1; i++)
                for (int j = 0; j < n - i - 1; j++)
                    if (arr[j] > arr[j + 1])
                    {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
        }
        public void insertionSort(int[] arr)
        {
            int n = arr.Length;
            for (int i = 1; i < n; ++i)
            {
                int key = arr[i];
                int j = i - 1;
                while (j >= 0 && arr[j] > key)
                {
                    arr[j + 1] = arr[j];
                    j = j - 1;
                }
                arr[j + 1] = key;
            }
        }

    }
}
