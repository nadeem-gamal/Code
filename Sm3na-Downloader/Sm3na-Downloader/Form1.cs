using HtmlAgilityPack;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Sm3na_Downloader
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        int x = 0;

        private void button1_Click(object sender, EventArgs e)
        {
            //listView1.Items.Add("Test " + x++);
            //readURL();

            //downloadFileFromUrl();
            url = textBox1.Text;
            parsingHTMLPage();
            MessageBox.Show("Download - complete");
        }

        //private string downloadFileUrl = @"http://ms4.sm3na.com/342/Sm3na_com_44159.mp3";
        string url = @"http://www.sm3na.com/audios/d305d79c2e/page2";
        private void readURL()
        {


            System.Net.WebClient wc = new System.Net.WebClient();
            byte[] raw = wc.DownloadData(url);

            string webData = System.Text.Encoding.UTF8.GetString(raw);
        }

        private void downloadFileFromUrl(string urlToDownload, string name)
        {

            System.Net.WebClient wc = new System.Net.WebClient();

            wc.DownloadFile(urlToDownload, name);

        }

        private void parsingHTMLPage()
        {

            HtmlWeb web = new HtmlWeb();
            HtmlAgilityPack.HtmlDocument doc = web.Load(url);

            //string metascore = doc.DocumentNode.SelectNodes("//*[@id=\"main\"]/div[3]/div/div[2]/div[1]/div[1]/div/div/div[2]/a/span[1]")[0].InnerText;
            //string userscore = doc.DocumentNode.SelectNodes("//*[@id=\"main\"]/div[3]/div/div[2]/div[1]/div[2]/div[1]/div/div[2]/a/span[1]")[0].InnerText;
            //string summary = doc.DocumentNode.SelectNodes("//*[@id=\"main\"]/div[3]/div/div[2]/div[2]/div[1]/ul/li/span[2]/span/span[1]")[0].InnerText;
            HtmlNodeCollection nodes = doc.DocumentNode.SelectNodes("//a[@href]");
            int count = 1;
            foreach (HtmlNode node in nodes)
            {
                //Console.WriteLine("NODE: " + node.InnerText);
                foreach (HtmlAttribute attribute in node.Attributes)
                {
                    if (attribute.Name == "href")
                    {
                        if (attribute.Value.Contains(".mp3"))
                        {
                           // Console.WriteLine("Attribute: " + attribute.Value);
                           // downloadFileFromUrl(attribute.Value, count++ + ".mp3");
                            string fileName = "";
                            foreach (HtmlAttribute innerAttribute in node.ChildNodes[1].Attributes) { 
                                if(innerAttribute.Name == "alt"){
                                    fileName = innerAttribute.Value;
                                    fileName = fileName.Split("mp3".ToCharArray())[0];
                                    fileName = fileName.Trim();
                                    fileName += ".mp3";
                                    downloadFileFromUrl(attribute.Value, fileName);
                                    break;
                                }
                            }
                            //Console.WriteLine("Name ");
                            
                        }
                    }
                }
            }


        }
    }
}
