using HtmlAgilityPack;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Sm3na_Downloader
{
    class Html_Helper
    {
        public static void DownloadFileFromURL(string urlToDownload, string name)
        {

            System.Net.WebClient wc = new System.Net.WebClient();

            wc.DownloadFile(urlToDownload, name);

        }

        public static List<DownloadRow> PrepareDownloadList(string URL)
        {
            List<DownloadRow> downloadList = new List<DownloadRow>();
            HtmlWeb web = new HtmlWeb();
            HtmlAgilityPack.HtmlDocument doc = web.Load(URL);

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
                            foreach (HtmlAttribute innerAttribute in node.ChildNodes[1].Attributes)
                            {
                                if (innerAttribute.Name == "alt")
                                {
                                    fileName = innerAttribute.Value;
                                    fileName = fileName.Split("mp3".ToCharArray())[0];
                                    fileName = fileName.Trim();
                                    //fileName += ".mp3";
                                    //downloadFileFromUrl(attribute.Value, fileName);
                                    DownloadRow downloadRow = new DownloadRow();
                                    downloadRow.Serial = count++;
                                    downloadRow.File_Name = fileName;
                                    downloadRow.URL = attribute.Value;
                                    downloadList.Add(downloadRow);
                                    break;
                                }
                            }
                            //Console.WriteLine("Name ");

                        }
                    }
                }
            }
            return downloadList;
        }
    }
}
