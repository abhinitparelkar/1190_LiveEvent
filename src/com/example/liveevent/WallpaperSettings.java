package com.example.liveevent;

import java.lang.reflect.InvocationTargetException;
import java.util.regex.Pattern;

import android.graphics.Color;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceActivity;
import android.widget.Toast;

public class WallpaperSettings extends PreferenceActivity implements OnPreferenceChangeListener {
	
	
	@Override
	protected void onCreate (Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.settings);
		Preference p = getPreferenceScreen().findPreference("listPref");
		p.setOnPreferenceChangeListener(this);
		p = getPreferenceScreen().findPreference("listPref2");
		p.setOnPreferenceChangeListener(this);
		p = getPreferenceScreen().findPreference("date");
		p.setOnPreferenceChangeListener(this);
		p = getPreferenceScreen().findPreference("time");
		p.setOnPreferenceChangeListener(this);
		p = getPreferenceScreen().findPreference("text");
		p.setOnPreferenceChangeListener(this);
		p = getPreferenceScreen().findPreference("date2");
		p.setOnPreferenceChangeListener(this);
		p = getPreferenceScreen().findPreference("time2");
		p.setOnPreferenceChangeListener(this);
		p = getPreferenceScreen().findPreference("text2");
		p.setOnPreferenceChangeListener(this);
		p = getPreferenceScreen().findPreference("date3");
		p.setOnPreferenceChangeListener(this);
		p = getPreferenceScreen().findPreference("time3");
		p.setOnPreferenceChangeListener(this);
		p = getPreferenceScreen().findPreference("text3");
		p.setOnPreferenceChangeListener(this);
		p = getPreferenceScreen().findPreference("date4");
		p.setOnPreferenceChangeListener(this);
		p = getPreferenceScreen().findPreference("time4");
		p.setOnPreferenceChangeListener(this);
		p = getPreferenceScreen().findPreference("text4");
		p.setOnPreferenceChangeListener(this);
		p = getPreferenceScreen().findPreference("date5");
		p.setOnPreferenceChangeListener(this);
		p = getPreferenceScreen().findPreference("time5");
		p.setOnPreferenceChangeListener(this);
		p = getPreferenceScreen().findPreference("text5");
		p.setOnPreferenceChangeListener(this);
		p = getPreferenceScreen().findPreference("quotes");
		p.setOnPreferenceChangeListener(this);
	}
	
	@Override
	public boolean onPreferenceChange(Preference preference, Object newValue) {

		if (preference.getKey().equalsIgnoreCase("listPref")) {
			try{
				
			ListPreference listPreference = (ListPreference) findPreference("listPref");
			String currValue = listPreference.getValue();
			 currValue = newValue.toString();
			String r = currValue.substring(1,3);
			String g = currValue.substring(3,5);
			String b = currValue.substring(5,7);
			int color = Color.rgb(Integer.parseInt(r, 16), Integer.parseInt(g, 16), Integer.parseInt(b, 16));
			return true;
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		if (preference.getKey().equalsIgnoreCase("listPref2")) {
			try{
				
			ListPreference listPreference = (ListPreference) findPreference("listPref2");
			String currValue = listPreference.getValue();
			 currValue = newValue.toString();
			String rr = currValue.substring(1,3);
			String gg = currValue.substring(3,5);
			String bb = currValue.substring(5,7);
			int color = Color.rgb(Integer.parseInt(rr, 16), Integer.parseInt(gg, 16), Integer.parseInt(bb, 16));
			return true;
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
			
		if (preference.getKey().equalsIgnoreCase("date"))
		{
			try{
				String input = newValue.toString();
				
				if(input.length() != 6) throw new Exception("Invalid length");
				if(!input.substring(3,4).equals(" ")) throw new Exception("Invalid format");
				String month = input.substring(0,3);
				int date = validateNumber(input.substring(4));				
				if(!Pattern.matches("[A-Za-z]+", month)) throw new Exception("Invalid format");		
				if (date < 0 || date >= 31) throw new Exception("Invalid format");				
				return true;
			}
			catch(Exception e){
				Toast.makeText(this, "Invalid Date Input! Plz. follow the hint",Toast.LENGTH_SHORT).show();
				return false;
			}
		}
		
		if (preference.getKey().equalsIgnoreCase("time"))
		{
			try{
				String input = newValue.toString();
				 
				if (input.length() != 5) throw new Exception ("Invalid format");
				//if (input.length() != 5) throw new Exception ("Invalid format");
				    if (!input.substring(2, 3).equals(":")) throw new Exception ("Invalid format");
				    int hour = validateNumber(input.substring(0, 2));
				    int minute = validateNumber(input.substring(3));
				    if (hour < 0 || hour >= 24) throw new Exception ("Invalid format");
				    if (minute < 0 || minute >= 60) throw new Exception ("Invalid format");
				   
				return true;
			}
			catch(Exception e){
				Toast.makeText(this, "Invalid Time Input! Plz. follow the hint",Toast.LENGTH_SHORT).show();
				return false;
			}
		}
		
		if (preference.getKey().equalsIgnoreCase("text"))
		{
			try {
				String input = newValue.toString();
				if (input.length() >18) throw new Exception ("Invalid length");
				return true;
			} catch (Exception e) {
				Toast.makeText(this, "Only 18 characters allowed.",Toast.LENGTH_SHORT).show();
				return false;
			}
		}		
		
		if (preference.getKey().equalsIgnoreCase("date2"))
		{
			try{
				String input = newValue.toString();
				
				if(input.length() != 6) throw new Exception("Invalid length");
				if(!input.substring(3,4).equals(" ")) throw new Exception("Invalid format");
				String month = input.substring(0,3);
				int date = validateNumber(input.substring(4));				
				if(!Pattern.matches("[A-Za-z]+", month)) throw new Exception("Invalid format");		
				if (date < 0 || date >= 31) throw new Exception("Invalid format");				
				return true;
			}
			catch(Exception e){
				Toast.makeText(this, "Invalid Date Input! Plz. follow the hint",Toast.LENGTH_SHORT).show();
				return false;
			}
		}
		
		if (preference.getKey().equalsIgnoreCase("time2"))
		{
			try{
				String input = newValue.toString();
				 
				if (input.length() != 5) throw new Exception ("Invalid format");
				    if (!input.substring(2, 3).equals(":")) throw new Exception ("Invalid format");
				    int hour = validateNumber(input.substring(0, 2));
				    int minute = validateNumber(input.substring(3));
				    if (hour < 0 || hour >= 24) throw new Exception ("Invalid format");
				    if (minute < 0 || minute >= 60) throw new Exception ("Invalid format");
				   
				return true;
			}
			catch(Exception e){
				Toast.makeText(this, "Invalid Time Input! Plz. follow the hint",Toast.LENGTH_SHORT).show();
				return false;
			}
		}
		
		if (preference.getKey().equalsIgnoreCase("text2"))
		{
			try {
				String input = newValue.toString();
				if (input.length()>18) throw new Exception ("Invalid length");
				return true;
			} catch (Exception e) {
				Toast.makeText(this, "Only 18 characters allowed.",Toast.LENGTH_SHORT).show();
				return false;
			}
		}
		
		if (preference.getKey().equalsIgnoreCase("date3"))
		{
			try{
				String input = newValue.toString();
				
				if(input.length() != 6) throw new Exception("Invalid length");
				if(!input.substring(3,4).equals(" ")) throw new Exception("Invalid format");
				String month = input.substring(0,3);
				int date = validateNumber(input.substring(4));				
				if(!Pattern.matches("[A-Za-z]+", month)) throw new Exception("Invalid format");		
				if (date < 0 || date >= 31) throw new Exception("Invalid format");				
				return true;
			}
			catch(Exception e){
				Toast.makeText(this, "Invalid Date Input! Plz. follow the hint",Toast.LENGTH_SHORT).show();
				return false;
			}
		}
		
		if (preference.getKey().equalsIgnoreCase("time3"))
		{
			try{
				String input = newValue.toString();
				 
				if (input.length() != 5) throw new Exception ("Invalid format");
				    if (!input.substring(2, 3).equals(":")) throw new Exception ("Invalid format");
				    int hour = validateNumber(input.substring(0, 2));
				    int minute = validateNumber(input.substring(3));
				    if (hour < 0 || hour >= 24) throw new Exception ("Invalid format");
				    if (minute < 0 || minute >= 60) throw new Exception ("Invalid format");
				   
				return true;
			}
			catch(Exception e){
				Toast.makeText(this, "Invalid Time Input! Plz. follow the hint",Toast.LENGTH_SHORT).show();
				return false;
			}
		}
		
		if (preference.getKey().equalsIgnoreCase("text3"))
		{
			try {
				String input = newValue.toString();
				if (input.length()>18) throw new Exception ("Invalid length");
				return true;
			} catch (Exception e) {
				Toast.makeText(this, "Only 18 characters allowed.",Toast.LENGTH_SHORT).show();
				return false;
			}
		}
		
		if (preference.getKey().equalsIgnoreCase("date4"))
		{
			try{
				String input = newValue.toString();
				
				if(input.length() != 6) throw new Exception("Invalid length");
				if(!input.substring(3,4).equals(" ")) throw new Exception("Invalid format");
				String month = input.substring(0,3);
				int date = validateNumber(input.substring(4));				
				if(!Pattern.matches("[A-Za-z]+", month)) throw new Exception("Invalid format");		
				if (date < 0 || date >= 31) throw new Exception("Invalid format");				
				return true;
			}
			catch(Exception e){
				Toast.makeText(this, "Invalid Date Input! Plz. follow the hint",Toast.LENGTH_SHORT).show();
				return false;
			}
		}
		
		if (preference.getKey().equalsIgnoreCase("time4"))
		{
			try{
				String input = newValue.toString();
				 
				if (input.length() != 5) throw new Exception ("Invalid format");
				    if (!input.substring(2, 3).equals(":")) throw new Exception ("Invalid format");
				    int hour = validateNumber(input.substring(0, 2));
				    int minute = validateNumber(input.substring(3));
				    if (hour < 0 || hour >= 24) throw new Exception ("Invalid format");
				    if (minute < 0 || minute >= 60) throw new Exception ("Invalid format");
				   
				return true;
			}
			catch(Exception e){
				Toast.makeText(this, "Invalid Time Input! Plz. follow the hint",Toast.LENGTH_SHORT).show();
				return false;
			}
		}
		
		if (preference.getKey().equalsIgnoreCase("text4"))
		{
			try {
				String input = newValue.toString();
				if (input.length()>18) throw new Exception ("Invalid length");
				return true;
			} catch (Exception e) {
				Toast.makeText(this, "Only 18 characters allowed.",Toast.LENGTH_SHORT).show();
				return false;
			}
		}
		
		if (preference.getKey().equalsIgnoreCase("date5"))
		{
			try{
				String input = newValue.toString();
				
				if(input.length() != 6) throw new Exception("Invalid length");
				if(!input.substring(3,4).equals(" ")) throw new Exception("Invalid format");
				String month = input.substring(0,3);
				int date = validateNumber(input.substring(4));				
				if(!Pattern.matches("[A-Za-z]+", month)) throw new Exception("Invalid format");		
				if (date < 0 || date >= 31) throw new Exception("Invalid format");				
				return true;
			}
			catch(Exception e){
				Toast.makeText(this, "Invalid Date Input! Plz. follow the hint",Toast.LENGTH_SHORT).show();
				return false;
			}
		}
		
		if (preference.getKey().equalsIgnoreCase("time5"))
		{
			try{
				String input = newValue.toString();
				 
				if (input.length() != 5) throw new Exception ("Invalid format");
				    if (!input.substring(2, 3).equals(":")) throw new Exception ("Invalid format");
				    int hour = validateNumber(input.substring(0, 2));
				    int minute = validateNumber(input.substring(3));
				    if (hour < 0 || hour >= 24) throw new Exception ("Invalid format");
				    if (minute < 0 || minute >= 60) throw new Exception ("Invalid format");
				   
				return true;
			}
			catch(Exception e){
				Toast.makeText(this, "Invalid Time Input! Plz. follow the hint",Toast.LENGTH_SHORT).show();
				return false;
			}
		}
		
		if (preference.getKey().equalsIgnoreCase("text5"))
		{
			try {
				String input = newValue.toString();
				if (input.length()>18) throw new Exception ("Invalid length");
				return true;
			} catch (Exception e) {
				Toast.makeText(this, "Only 18 characters allowed.",Toast.LENGTH_SHORT).show();
				return false;
			}
		}
		
		if (preference.getKey().equalsIgnoreCase("quotes"))
		{
			try {
				String input = newValue.toString();
				if (input.length()>30) throw new Exception ("Invalid length");
				return true;
			} catch (Exception e) {
				Toast.makeText(this, "Only 30 characters allowed.",Toast.LENGTH_SHORT).show();
				return false;
			}
		}	
		
		
		
		return true;
	}
	
	public int validateNumber(String numberString) {
	    try {
	        int number = Integer.valueOf(numberString);
	        return number;
	    } catch (NumberFormatException e) {
	        return -1;
	    }
	}
}


