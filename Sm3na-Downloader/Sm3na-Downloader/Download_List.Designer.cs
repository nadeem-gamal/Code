namespace Sm3na_Downloader
{
    partial class Download_List
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.dataGridDownloadList = new System.Windows.Forms.DataGridView();
            this.panel1 = new System.Windows.Forms.Panel();
            this.URLTxtBox = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.ReloadBtn = new System.Windows.Forms.Button();
            this.Serial = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.URL = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.File_Name = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Progress = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Download = new System.Windows.Forms.DataGridViewButtonColumn();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridDownloadList)).BeginInit();
            this.panel1.SuspendLayout();
            this.SuspendLayout();
            // 
            // dataGridDownloadList
            // 
            this.dataGridDownloadList.AllowUserToAddRows = false;
            this.dataGridDownloadList.AllowUserToDeleteRows = false;
            this.dataGridDownloadList.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridDownloadList.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.Serial,
            this.URL,
            this.File_Name,
            this.Progress,
            this.Download});
            this.dataGridDownloadList.Dock = System.Windows.Forms.DockStyle.Fill;
            this.dataGridDownloadList.Location = new System.Drawing.Point(0, 40);
            this.dataGridDownloadList.Name = "dataGridDownloadList";
            this.dataGridDownloadList.ReadOnly = true;
            this.dataGridDownloadList.Size = new System.Drawing.Size(492, 263);
            this.dataGridDownloadList.TabIndex = 0;
            this.dataGridDownloadList.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dataGridDownloadList_CellContentClick);
            // 
            // panel1
            // 
            this.panel1.Controls.Add(this.ReloadBtn);
            this.panel1.Controls.Add(this.label1);
            this.panel1.Controls.Add(this.URLTxtBox);
            this.panel1.Controls.Add(this.dataGridDownloadList);
            this.panel1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.panel1.Location = new System.Drawing.Point(0, 0);
            this.panel1.Name = "panel1";
            this.panel1.Padding = new System.Windows.Forms.Padding(0, 40, 0, 0);
            this.panel1.Size = new System.Drawing.Size(492, 303);
            this.panel1.TabIndex = 1;
            // 
            // URLTxtBox
            // 
            this.URLTxtBox.Location = new System.Drawing.Point(50, 10);
            this.URLTxtBox.Name = "URLTxtBox";
            this.URLTxtBox.Size = new System.Drawing.Size(246, 20);
            this.URLTxtBox.TabIndex = 1;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(12, 13);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(32, 13);
            this.label1.TabIndex = 2;
            this.label1.Text = "URL:";
            // 
            // ReloadBtn
            // 
            this.ReloadBtn.Location = new System.Drawing.Point(302, 8);
            this.ReloadBtn.Name = "ReloadBtn";
            this.ReloadBtn.Size = new System.Drawing.Size(75, 23);
            this.ReloadBtn.TabIndex = 3;
            this.ReloadBtn.Text = "Reload";
            this.ReloadBtn.UseVisualStyleBackColor = true;
            this.ReloadBtn.Click += new System.EventHandler(this.ReloadBtn_Click);
            // 
            // Serial
            // 
            this.Serial.DataPropertyName = "Serial";
            this.Serial.HeaderText = "Serial";
            this.Serial.Name = "Serial";
            this.Serial.ReadOnly = true;
            this.Serial.Visible = false;
            // 
            // URL
            // 
            this.URL.DataPropertyName = "URL";
            this.URL.HeaderText = "URL";
            this.URL.Name = "URL";
            this.URL.ReadOnly = true;
            this.URL.Visible = false;
            // 
            // File_Name
            // 
            this.File_Name.DataPropertyName = "File_Name";
            this.File_Name.HeaderText = "File_Name";
            this.File_Name.Name = "File_Name";
            this.File_Name.ReadOnly = true;
            // 
            // Progress
            // 
            this.Progress.DataPropertyName = "Progress";
            this.Progress.HeaderText = "Progress";
            this.Progress.Name = "Progress";
            this.Progress.ReadOnly = true;
            // 
            // Download
            // 
            this.Download.HeaderText = "Download";
            this.Download.Name = "Download";
            this.Download.ReadOnly = true;
            this.Download.Text = "Download";
            this.Download.UseColumnTextForButtonValue = true;
            // 
            // Download_List
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(492, 303);
            this.Controls.Add(this.panel1);
            this.Name = "Download_List";
            this.Text = "Download_List";
            ((System.ComponentModel.ISupportInitialize)(this.dataGridDownloadList)).EndInit();
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.DataGridView dataGridDownloadList;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Button ReloadBtn;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox URLTxtBox;
        private System.Windows.Forms.DataGridViewTextBoxColumn Serial;
        private System.Windows.Forms.DataGridViewTextBoxColumn URL;
        private System.Windows.Forms.DataGridViewTextBoxColumn File_Name;
        private System.Windows.Forms.DataGridViewTextBoxColumn Progress;
        private System.Windows.Forms.DataGridViewButtonColumn Download;
    }
}