using System;

namespace Euler18
{
	class MainClass
	{
		public static void Main (string[] args)
		{
			// https://projecteuler.net/problem=18
			// https://projecteuler.net/problem=67
			int size = 100;//size of triangle from inputFilePath
			int[][] triangle = new int[size][];
			for (int i = 0; i < size; i++)
				triangle [i] = new int[i + 1];
			
			string inputFilePath = "test67.txt";//source file
			var fileStream = new System.IO.FileStream (inputFilePath, System.IO.FileMode.Open);
			var file = new System.IO.StreamReader(fileStream, System.Text.Encoding.UTF8);
			int lineCounter = 0;
			string lineOfText;
			while ((lineOfText = file.ReadLine()) != null) {
				var values = lineOfText.Split(' ');
				for (int j = 0; j < triangle [lineCounter].Length; j++)
					triangle [lineCounter] [j] = Int32.Parse (values [j]);
				lineCounter++;
			}
			file.Close ();
			fileStream.Close ();

			//go from the bottom of triangle to the top
			//replace value in the line with maximum sum path from the botoom of the triangle to this point
			for (int k = size-2; k >= 0; k--) {
				var currentMaxValues = MaxPathSum (triangle [k+1], triangle [k]);
				for (int r = 0; r < currentMaxValues.Length; r++)
					triangle [k] [r] = currentMaxValues [r];
			}
			Console.WriteLine ("Maximum path sum - {0}", triangle[0][0]);
		}

		public static int[] MaxPathSum(int[] lowerLine, int[] currentLine)
		{
			int[] result = new int[currentLine.Length];
			for (int i = 0; i < currentLine.Length; i++) {
				if (lowerLine [i] > lowerLine [i + 1])
					result [i] = currentLine [i] + lowerLine [i];
				else
					result [i] = currentLine [i] + lowerLine [i+1];
			}
			return result;
		}
	}
}
