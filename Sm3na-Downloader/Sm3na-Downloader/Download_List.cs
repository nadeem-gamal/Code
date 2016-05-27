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
    public partial class Download_List : Form
    {
        public Download_List()
        {
            InitializeComponent();
        }

        private void ReloadBtn_Click(object sender, EventArgs e)
        {
            List<DownloadRow> downloadList = Html_Helper.PrepareDownloadList(URLTxtBox.Text);

            dataGridDownloadList.DataSource = downloadList;
        }

        private void dataGridDownloadList_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            if (dataGridDownloadList.Columns[e.ColumnIndex].Name == "Download") {
                int serial = int.Parse(dataGridDownloadList.Rows[e.RowIndex].Cells["Serial"].Value.ToString());
                string url = dataGridDownloadList.Rows[e.RowIndex].Cells["URL"].Value.ToString();
                string name = dataGridDownloadList.Rows[e.RowIndex].Cells["File_Name"].Value.ToString() + ".mp3";

                (dataGridDownloadList.Rows[e.RowIndex].Cells["Download"] as DataGridViewButtonCell).Dispose();// = false;
            }
        }
    }
}
