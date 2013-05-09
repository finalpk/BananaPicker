package com.finalpk;

import java.awt.Color;
import java.awt.Font;
import java.awt.RenderingHints;

import org.powerbot.game.api.util.Timer;
import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.Tile;

public class Settings {

	public static Tile plantage = new Tile(2916, 3155, 0);
	public static Tile lodestone = new Tile(3011, 3215, 0);
	public static Tile deposit = new Tile(3047, 3236, 0);
	public static Tile seamen = new Tile(3027, 3219, 0);
	public static Tile boat = new Tile(2956, 3143, 1);
	public static Tile bank = new Tile(2444, 3083, 0);
	public static Tile castle = new Tile(2441, 3088, 0);

	public static Area MusaPoint = new Area(new Tile[] {
			new Tile(2886, 3178, 0), new Tile(2891, 3181, 0),
			new Tile(2896, 3181, 0), new Tile(2901, 3182, 0),
			new Tile(2906, 3183, 0), new Tile(2911, 3183, 0),
			new Tile(2916, 3183, 0), new Tile(2921, 3183, 0),
			new Tile(2926, 3181, 0), new Tile(2931, 3179, 0),
			new Tile(2936, 3177, 0), new Tile(2940, 3173, 0),
			new Tile(2945, 3172, 0), new Tile(2950, 3170, 0),
			new Tile(2954, 3167, 0), new Tile(2957, 3163, 0),
			new Tile(2959, 3158, 0), new Tile(2962, 3154, 0),
			new Tile(2964, 3149, 0), new Tile(2964, 3144, 0),
			new Tile(2961, 3140, 0), new Tile(2957, 3137, 0),
			new Tile(2952, 3134, 0), new Tile(2947, 3133, 0),
			new Tile(2942, 3132, 0), new Tile(2937, 3132, 0),
			new Tile(2932, 3132, 0), new Tile(2927, 3131, 0),
			new Tile(2922, 3130, 0), new Tile(2917, 3130, 0),
			new Tile(2912, 3129, 0), new Tile(2907, 3129, 0),
			new Tile(2902, 3128, 0), new Tile(2897, 3129, 0),
			new Tile(2892, 3130, 0), new Tile(2887, 3132, 0),
			new Tile(2883, 3135, 0), new Tile(2880, 3139, 0),
			new Tile(2877, 3143, 0), new Tile(2874, 3147, 0),
			new Tile(2872, 3152, 0), new Tile(2871, 3157, 0),
			new Tile(2871, 3162, 0), new Tile(2873, 3167, 0),
			new Tile(2876, 3171, 0), new Tile(2880, 3174, 0),
			new Tile(2884, 3177, 0), new Tile(2889, 3179, 0) });

	public static int[] trees = { 2073, 2074, 2075, 2076, 2077 };
	public static int seaman = 377;
	public static int banana = 1963;
	public static int baskets = 5376;
	public static int basketsfull = 5416;
	public static int ring = 2558;
	public boolean portsarim = true;
	public static int gangplank = 2082;

	public static String status = "Starting";
	public static int picked = 0;
	public static long time;
	public static int price = 0;
	public static int current = 0;
	public static Timer timer = new Timer(0);
	public static boolean basket = false;
	public static boolean duellring = false;
	public static boolean newring = false;

	public static RenderingHints antialiasing = new RenderingHints(
			RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	public static Color color1 = new Color(51, 51, 51);
	public static Color color2 = new Color(255, 255, 255);
	public static Color color3 = new Color(255, 30, 50);

	public static Font font1 = new Font("Bookman Old Style", 1, 16);
	public static Font font2 = new Font("Bookman Old Style", 0, 10);
	
}
