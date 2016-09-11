package pl.ench.medievalcraft.log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Utils {
	private static String[] blocklog = new String[500];
	private static String[] playerlog = new String[500];
	private static String[] chestlog = new String[500];
	
	private static int b = 0;
	private static int p = 0;
	private static int c = 0;
	
	static File Dblock;
	static File Dplayer;
	static File Dchest;

	public static void chceckFiles() {
		if(!Main.getInst().getDataFolder().exists()){
			Main.getInst().getDataFolder().mkdir();
		}
		
		Dblock = new File(Main.getInst().getDataFolder(), "block");
		Dplayer = new File(Main.getInst().getDataFolder(), "player");
		Dchest = new File(Main.getInst().getDataFolder(), "chest");
		
		if(!Dblock.exists()){
			Dblock.mkdir();
		}
		
		if(!Dplayer.exists()){
			Dplayer.mkdir();
		}
		
		if(!Dchest.exists()){
			Dchest.mkdir();
		}	
	}

	public static void flush(Flush type) {
		GregorianCalendar g = new GregorianCalendar();
		String data = g.get(Calendar.YEAR) + "-" + g.get(Calendar.MONTH) + "-" + g.get(Calendar.DAY_OF_MONTH) + "(" + g.get(Calendar.HOUR_OF_DAY) + "-" + g.get(Calendar.MINUTE) + "-" + g.get(Calendar.SECOND) + ")" + ".log";
		if(type.equals(Flush.BLOCK)){
			PrintWriter out;
			try {
				File f = new File(Dblock, data);
				f.createNewFile();
				out = new PrintWriter(new FileWriter(f), true);
			} catch (IOException e) {
				Bukkit.getLogger().warning("Can not write log. Show Raktrum stack trace.");
				e.printStackTrace();
				return;
			}
			for(String s : blocklog){
				out.println(s);
			}
			blocklog = new String[500];
			b = 0;
			out.close();
		} /*else if(type.equals(Flush.PLAYER)){
			PrintWriter out;
			try {
				File f = new File(Dplayer, data);
				f.createNewFile();
				out = new PrintWriter(new FileWriter(f), true);
			} catch (IOException e) {
				Bukkit.getLogger().warning("Can not write log. Show Raktrum stack trace.");
				e.printStackTrace();
				return;
			}
			for(String s : playerlog){
				out.println(s);
			}
			playerlog = new String[500];
			p = 0;
			out.close();
		}*/ else if(type.equals(Flush.CHEST)){
			PrintWriter out;
			try {
				File f = new File(Dchest, data);
				f.createNewFile();
				out = new PrintWriter(new FileWriter(f), true);
			} catch (IOException e) {
				Bukkit.getLogger().warning("Can not write log. Show Raktrum stack trace.");
				e.printStackTrace();
				return;
			}
			for(String s : chestlog){
				out.println(s);
			}
			chestlog = new String[500];
			c = 0;
			out.close();
		} else if(type.equals(Flush.ALL)){
			PrintWriter out;
			try {
				File f = new File(Dblock, data);
				f.createNewFile();
				out = new PrintWriter(new FileWriter(f), true);
			} catch (IOException e) {
				Bukkit.getLogger().warning("Can not write log. Show Raktrum stack trace.");
				e.printStackTrace();
				return;
			}
			for(String s : blocklog){
				out.println(s);
			}
			out.close();
			
			/*PrintWriter out2;
			try {
				File f = new File(Dplayer, data);
				f.createNewFile();
				out2 = new PrintWriter(new FileWriter(f), true);
			} catch (IOException e) {
				Bukkit.getLogger().warning("Can not write log. Show Raktrum stack trace.");
				e.printStackTrace();
				return;
			}
			for(String s : playerlog){
				out2.println(s);
			}
			out2.close();*/
			
			PrintWriter out3;
			try {
				File f = new File(Dchest, data);
				f.createNewFile();
				out3 = new PrintWriter(new FileWriter(f), true);
			} catch (IOException e) {
				Bukkit.getLogger().warning("Can not write log. Show Raktrum stack trace.");
				e.printStackTrace();
				return;
			}
			for(String s : chestlog){
				out3.println(s);
			}
			out3.close();
		}
	}

	public static void addLine(String name, String string, Location location, Line type) {
		GregorianCalendar g = new GregorianCalendar();
		String data = g.get(Calendar.SECOND) + ":" + g.get(Calendar.MINUTE) + ":" + g.get(Calendar.HOUR_OF_DAY) + " " + g.get(Calendar.DAY_OF_MONTH) + "." + g.get(Calendar.MONTH) + "." + g.get(Calendar.YEAR);
		String s = "[" + data + "] " + name + " " + string + " " + Integer.toString(location.getBlockX()) + " " + Integer.toString(location.getBlockY()) + " " + Integer.toString(location.getBlockZ()) + " " + location.getWorld().getName();
		blocklog[b] = s;
		b++;
		if(b >= 499) Utils.flush(Flush.BLOCK);
	}

	public static void addLine(String name, Location from, Location to, Line type) {
		GregorianCalendar g = new GregorianCalendar();
		String data = g.get(Calendar.SECOND) + ":" + g.get(Calendar.MINUTE) + ":" + g.get(Calendar.HOUR_OF_DAY) + " " + g.get(Calendar.DAY_OF_MONTH) + "." + g.get(Calendar.MONTH) + "." + g.get(Calendar.YEAR);
		String s = "[" + data + "] " + name + " " + from.getBlockX() + " " + from.getBlockY() + " " + from.getBlockZ() + " " + from.getWorld().getName() + " " + to.getBlockX() + " " + to.getBlockY() + " " + to.getBlockZ() + " " + to.getWorld().getName();
		playerlog[p] = s;
		p++;
		if(p >= 499) Utils.flush(Flush.PLAYER);
	}

	public static void addLine(String name, Location location, Line chest) {
		GregorianCalendar g = new GregorianCalendar();
		String data = g.get(Calendar.SECOND) + ":" + g.get(Calendar.MINUTE) + ":" + g.get(Calendar.HOUR_OF_DAY) + " " + g.get(Calendar.DAY_OF_MONTH) + "." + g.get(Calendar.MONTH) + "." + g.get(Calendar.YEAR);
		String s = "[" + data + "] " + name + " " + location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ() + " " + location.getWorld();
		chestlog[c] = s;
		c++;
		if(c >= 499) Utils.flush(Flush.CHEST);
	}
}
