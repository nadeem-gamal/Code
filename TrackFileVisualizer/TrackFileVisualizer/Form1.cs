using GMap.NET;
using GMap.NET.WindowsForms;
using GMap.NET.WindowsForms.Markers;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace TrackFileVisualizer
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            gMapControl1.MapProvider = GMap.NET.MapProviders.GoogleMapProvider.Instance;

            StreamReader reader = new StreamReader(@"D:\dragonFile.txt");
            string line = null;
            List<PointLatLng> points = new List<PointLatLng>();
            while (!reader.EndOfStream)
            {
                line = reader.ReadLine();
                string[] positionStr = line.Split(',');
                points.Add(new PointLatLng(double.Parse(positionStr[0]), double.Parse(positionStr[1])));
            }
            GMapOverlay overlay = new GMapOverlay("route");
            gMapControl1.Overlays.Add(overlay);
            GMapRoute route = new GMapRoute(points, "");
            overlay.Routes.Add(route);

            GMarkerGoogle start = new GMarkerGoogle(points[0], GMarkerGoogleType.green_big_go);
            GMarkerGoogle stop = new GMarkerGoogle(points[points.Count - 1], GMarkerGoogleType.red_big_stop);
            overlay.Markers.Add(start);
            overlay.Markers.Add(stop);
        }
    }
}
