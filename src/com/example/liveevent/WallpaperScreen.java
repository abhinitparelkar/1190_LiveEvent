package com.example.liveevent;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;

import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.service.wallpaper.WallpaperService;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

// Author: Abhinit Parelkar
// Project: Functional Android Live Wall-paper(LiveEvent)
// Purpose: To provide home-screen visual fun/productive mini event app for users.

public class WallpaperScreen extends WallpaperService {
	
	@Override
	public Engine onCreateEngine() {
		return new WallpaperScreenEngine();
	}
	
	private class WallpaperScreenEngine extends Engine {
		private boolean mVisible = false;
		private int mColor = 0;
		private int bColor = 0;
		private int mAlpha = 0;
		private int mAlpha2 = 0;
		private boolean mIsCountingUp=true;
		private boolean mIsCountingUp2=true;
		
		private String mText = "";
		private String mdate = "";
		private String mtime = "";
		private String mevent = "";
		private String mdate2 = "";
		private String mtime2 = "";
		private String mevent2 = "";
		private String mdate3 = "";
		private String mtime3 = "";
		private String mevent3 = "";
		private String mdate4 = "";
		private String mtime4 = "";
		private String mevent4 = "";
		private String mdate5 = "";
		private String mtime5 = "";
		private String mevent5 = "";
		private String flag = "";
		private String flag2 = "";
		private String flag3 = "";
		private String flag4 = "";
		private String flag5 = "";
		private String indicator="<<";
		MediaPlayer mysound;
		
		
		private final Handler mHandler = new Handler();
		private final Runnable mUpdateDisplay = new Runnable() {
		@Override
		public void run() {
			draw();
		}};
	
	  
		
		private void draw() {
		   SurfaceHolder holder = getSurfaceHolder();
		   Canvas c = null;
		  
		   try {
		      c = holder.lockCanvas();
		      if (c != null) {
		    	 //android.os.Debug.waitForDebugger(); 
		    	
		    	 
		    	 /* Defining component for quote */
		    	 Paint p2 = new Paint();
		    	 p2.setTextSize(35);
		    	 p2.setAntiAlias(true);
		    	
			     
			    
		        
		        /* Defining components for date */
		        Paint p4 = new Paint();
		        p4.setTextSize(22);
		 		p4.setAntiAlias(true);
		 		String textday = "";
		 		
		 		float w5 = p4.measureText(textday, 0, textday.length());
		        int offset5 = (int) w5 / 2;
		        double x5 = c.getWidth()/13 - offset5;
		       // double x5 = c.getWidth()/10.3 - offset5;
		        double y5 = c.getHeight()/5.4;
		 		
		 		 SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm a");
		 		 //Day of Name in full form like,"Saturday", or if you need the first three characters you have to put "EEE" in the date format and your result will be "Sat".
		 		 SimpleDateFormat sdf_ = new SimpleDateFormat("EEEE"); 
		 		 SimpleDateFormat sdf__= new SimpleDateFormat("MMM");
		 		SimpleDateFormat sdf___= new SimpleDateFormat("dd");
		 		 Date date = new Date();
		 		 String d = sdf_.format(date)+", ";
		 		 String m = sdf__.format(date)+" ";
		 		 String dd = sdf___.format(date);
			    // textday = sdf_.format(date)+",";
		 		 textday = d+m+dd;
			     
		 		
			     /* Defining components for time  */
			     Paint p = new Paint();
		    	 p.setTextSize(85);
		 		 p.setAntiAlias(true);
		 		 String texthr = "";
		 		 String textmin = "";
		 		 
		 		 /* Defining component : */
			     Paint p3 = new Paint();
			     p3.setTextSize(80);
		 		 p3.setAntiAlias(true);
		 		 String text3 = ":";
		 		 float w3 = p3.measureText(text3, 0, text3.length());
		         int offset3 = (int) w3 / 2;
		         double x3 = c.getWidth()/4.7;// - offset3;
		         // int x3 = c.getWidth()/4 - offset3;
		        int y3 = c.getHeight()/7;
		 		 
		 		// Typeface type= Typeface.createFromAsset(getAssets(), "fonts/helveticaneue_ultralight.font");
		 		//Typeface type=Typeface.createFromAsset(getAssets(),"assets/helveticaneue_ultralight.font");
		 		// p.setTypeface(Typeface.MONOSPACE);
		         float w = p.measureText(texthr, 0, texthr.length());
		         int offset = (int) w / 2;
		         int x = c.getWidth()/25 - offset;
		         // int x = c.getWidth()/15 - offset;
		        int y = c.getHeight()/7;
		        
		        float w4 = p.measureText(textmin, 0, textmin.length());
		        int offset4 = (int) w4 / 2;
		        double x4 = c.getWidth()/3.8 - offset4;
		        float y4 = c.getHeight()/7;
		        
		        
		        
		        /* Date & Time Component */
		        Calendar cal= Calendar.getInstance();
		       
		     
		        long hour = cal.get(Calendar.HOUR_OF_DAY);
		        long minute = cal.get(Calendar.MINUTE);
		      //  String curTime = String.format("%02d:%02d", hour, minute);
		        String curTime = String.format("%02d", hour);
		        String curTime2 = String.format("%02d", minute);
		        
		        //text = hour+":"+minute ;
		        texthr = curTime;
		        textmin = curTime2;
		       
		        
		        /* Defining event time1 & text1 components */
		      String dateformat = m+dd;
		      String clock = curTime+":"+curTime2;
		      String text2="", mmtime="",mmevent="",mmevent2="",mmevent3="",mmevent4="",mmevent5="",ind="",mmdate="",mmdate2="",mmdate3="",mmdate4="",mmdate5="",mmtime2="",mmtime3="",mmtime4="",mmtime5="";
		      int x6=1,x10=2;
		      double x7=1,y7=1,x11=1,y11=1,x2=1,y2=1,y6=3,y10=4,x15=5,y15=6,x16=1,y16=1,x17=1,y17=1,x18=1,y18=1,x19=1,y19=1,x8=1,y8=1,x12=1,y12=1,x13=1,y13=1,x9=1,y9=1,x1=1,y1=1,x14=1,y14=1;
		     
		      mmdate = mdate;
		      mmtime = mtime;
		      mmevent = mevent;
		      ind = indicator;
		      
		     if(!mmevent.equals(""))
		     {
		       if(mmdate.equals(dateformat)){
		    	   
		    		
		        float w6 = p2.measureText(mmtime, 0, mmtime.length());
		    	 int offset6 = (int) w6 / 2;
		    	  x6 = c.getWidth()/11 - offset6;
			     y6 = c.getHeight()/2.4;
			     
			    
		    	 float w10 = p2.measureText(mmevent, 0, mmevent.length());
		    	 int offset10 = (int) w10 / 2;
		    	 x10 = c.getWidth()/2 - offset10;
			     y10 = c.getHeight()/2.4;
			     
			       if(mmtime.equals(clock)){
			    	 
			    	 flag = "1";  
			     }
			       else 
			       {
			    	   flag = "";
			       }			       
		     }
		    }
		     
		     if (flag.equals("1")){
		    	  float w15 = p2.measureText(ind, 0, ind.length());
			    	 int offset15 = (int) w15 / 2;
			    	 x15 = c.getWidth()/1.1 - offset15;
				     y15 = c.getHeight()/2.4;
				     
				   //  Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
				    //	long[] pattern = {0,200};
				    //	 v.vibrate(pattern,0);
				    	 
				    	 mysound = MediaPlayer.create(WallpaperScreen.this,R.raw.ring);
				    	 mysound.start();
		      }
		     
		     
		        /* Defining event time2 & text2 components */
		     mmdate2 = mdate2;
		      mmtime2 = mtime2;
		      mmevent2 = mevent2;
		      ind = indicator;
		      
		     if(!mmevent2.equals(""))
		     {
		       if(mmdate2.equals(dateformat)){
		    	   
			     
			     
			        float w7 = p2.measureText(mmtime2, 0, mmtime2.length());
			    	 int offset7 = (int) w7 / 2;
			    	  x7 = c.getWidth()/11 - offset7;
				      y7 = c.getHeight()/2.06;
				     
				 
			    	 float w11 = p2.measureText(mmevent2, 0, mmevent2.length());
			    	 int offset11 = (int) w11 / 2;
			    	 x11 = c.getWidth()/2 - offset11;
				     y11 = c.getHeight()/2.06;
				     
				     if(mmtime2.equals(clock)){
				    	 
				    	 flag2 = "1";  
				     }
				       else 
				       {
				    	   flag2 = "";
				       }
		       }}
		     
				     if (flag2.equals("1")){
				    	  float w16 = p2.measureText(ind, 0, ind.length());
					    	 int offset16 = (int) w16 / 2;
					    	 x16 = c.getWidth()/1.1 - offset16;
						     y16 = c.getHeight()/2.06;
						     
						   //  Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
						    //	long[] pattern = {0,200};
						    //	 v.vibrate(pattern,0);
						    	 
						    	 mysound = MediaPlayer.create(WallpaperScreen.this,R.raw.ring);
						    	 mysound.start();
				      }
		        
				     
				     /* Defining event time3 & text3 components */
				     
				     mmdate3 = mdate3;
				      mmtime3 = mtime3;
				      mmevent3 = mevent3;
				      ind = indicator;
				      
				     if(!mmevent3.equals(""))
				     {
				       if(mmdate3.equals(dateformat)){
				    
				        float w8 = p2.measureText(mmtime3, 0, mmtime3.length());
				    	 int offset8 = (int) w8 / 2;
				    	 x8 = c.getWidth()/11 - offset8;
					     y8 = c.getHeight()/1.81; 
					     
					   
				    	 float w12 = p2.measureText(mmevent3, 0, mmevent3.length());
				    	 int offset12 = (int) w12 / 2;
				    	 x12 = c.getWidth()/2 - offset12;
					    y12 = c.getHeight()/1.81;
					    
					    if(mmtime3.equals(clock)){
					    	 
					    	 flag3 = "1";  
					     }
					       else 
					       {
					    	   flag3 = "";
					       }
		    
				       }}   
				     
				     if (flag3.equals("1")){
				    	  float w17 = p2.measureText(ind, 0, ind.length());
					    	 int offset17 = (int) w17 / 2;
					    	 x17 = c.getWidth()/1.1 - offset17;
						     y17 = c.getHeight()/1.81;
						     
						   //  Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
						    //	long[] pattern = {0,200};
						    //	 v.vibrate(pattern,0);
						    	 
						    	 mysound = MediaPlayer.create(WallpaperScreen.this,R.raw.ring);
						    	 mysound.start();
				      }
		        
				     
				     /* Defining event time4 & text4 components */
				     mmdate4 = mdate4;
				      mmtime4 = mtime4;
				      mmevent4 = mevent4;
				      ind = indicator;
				      
				     if(!mmevent4.equals(""))
				     {
				       if(mmdate4.equals(dateformat)){
					     
					        float w9 = p2.measureText(mmtime4, 0, mmtime4.length());
					    	 int offset9 = (int) w9 / 2;
					    	x9 = c.getWidth()/11 - offset9;
						    y9 = c.getHeight()/1.62;
						     
						    
					    	 float w13 = p2.measureText(mmevent4, 0, mmevent4.length());
					    	 int offset13 = (int) w13 / 2;
					    	 x13 = c.getWidth()/2 - offset13;
						     y13 = c.getHeight()/1.62;
						     
						     if(mmtime4.equals(clock)){
						    	 
						    	 flag4 = "1";  
						     }
						       else 
						       {
						    	   flag4 = "";
						       }
				       }}
						     if (flag4.equals("1")){
						    	  float w18 = p2.measureText(ind, 0, ind.length());
							    	 int offset18 = (int) w18 / 2;
							    	 x18 = c.getWidth()/1.1 - offset18;
								     y18 = c.getHeight()/1.62;
								     
								   //  Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
								    //	long[] pattern = {0,200};
								    //	 v.vibrate(pattern,0);
								    	 
								    	 mysound = MediaPlayer.create(WallpaperScreen.this,R.raw.ring);
								    	 mysound.start();
						      }
						
						     /* Defining event time5 & text5 components */
						     
						     mmdate5 = mdate5;
						      mmtime5 = mtime5;
						      mmevent5 = mevent5;
						      ind = indicator;
						      
						     if(!mmevent5.equals(""))
						     {
						       if(mmdate5.equals(dateformat)){
						        
						        float w1 = p2.measureText(mmtime5, 0, mmtime5.length());
						    	 int offset1 = (int) w1 / 2;
						    	 x1 = c.getWidth()/11 - offset1;
							     y1 = c.getHeight()/1.47;
							     
							     
						    	 float w14 = p2.measureText(mmevent5, 0, mmevent5.length());
						    	 int offset14 = (int) w14 / 2;
						    	  x14 = c.getWidth()/2 - offset14;
							      y14 = c.getHeight()/1.47;
							      
							      if(mmtime5.equals(clock)){
								    	 
								    	 flag5 = "1";  
								     }
								       else 
								       {
								    	   flag5 = "";
								       }
						       }}
						     if (flag5.equals("1")){
						    	  float w19 = p2.measureText(ind, 0, ind.length());
							    	 int offset19 = (int) w19 / 2;
							    	 x19 = c.getWidth()/1.1 - offset19;
								     y19 = c.getHeight()/1.47;
								     
								   //  Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
								    //	long[] pattern = {0,200};
								    //	 v.vibrate(pattern,0);
								    	 
								    	 mysound = MediaPlayer.create(WallpaperScreen.this,R.raw.ring);
								    	 mysound.start();
						      }
						     
						     /* Defining quote component */
						     if(! mmdate.equals(dateformat) && mmdate2.equals(dateformat) && mmdate3.equals(dateformat) && mmdate4.equals(dateformat) && mmdate5.equals(dateformat)){
						    	 text2 = mText;
						    	 float w2 = p2.measureText(text2, 0, text2.length());
						    	 int offset2 = (int) w2 / 2;
						    	  x2 = c.getWidth()/2 - offset2;
							      y2 = c.getHeight()/2;
						     } 
							      else if(mmevent5.equals("") && mmevent4.equals("") && mmevent3.equals("") && mmevent2.equals("") && mmevent.equals(""))
						     {
						      text2 = mText;
					    	 float w2 = p2.measureText(text2, 0, text2.length());
					    	 int offset2 = (int) w2 / 2;
					    	  x2 = c.getWidth()/2 - offset2;
						      y2 = c.getHeight()/2;
						     }
							     
		        /* Drawing & Filling Canvas */
		         p.setColor(bColor);
		         p2.setColor(bColor);
		         p3.setColor(bColor);
		         p4.setColor(bColor);
		        
		         
		         c.drawRect(0, 0, c.getWidth(), c.getHeight(), p);
		         c.drawRect(0, 0, c.getWidth(), c.getHeight(), p2);
		         c.drawRect(0,0, c.getWidth(), c.getHeight(), p3);
		         c.drawRect(0,0, c.getWidth(), c.getHeight(), p4);
		       
		         
		         p.setColor(mColor);
		         p2.setColor(mColor);
		         p3.setColor(mColor);
		         p4.setColor(mColor);
		        
		         
		         p2.setAlpha(mAlpha);
		         p3.setAlpha(mAlpha2);
		         
		         
		         c.drawText(texthr, x, y, p);
		         c.drawText(textmin, (float) x4, y4, p);
		         c.drawText(textday, (float)x5, (float) y5, p4);
		         c.drawText(text2, (float)x2, (float)y2, p2);
		         c.drawText(text3, (float)x3, y3, p3);
		         c.drawText(mmtime, x6, (float)y6, p2);
		         c.drawText(mmtime2, (float)x7, (float)y7, p2);
		         c.drawText(mmtime3, (float)x8, (float)y8, p2);
		         c.drawText(mmtime4, (float)x9, (float)y9, p2);
		         c.drawText(mmtime5, (float)x1, (float)y1, p2);
		         c.drawText(mmevent, x10, (float)y10, p2);
		         c.drawText(mmevent2, (float)x11, (float)y11, p2);
		         c.drawText(mmevent3, (float)x12, (float)y12, p2);
		         c.drawText(mmevent4, (float)x13, (float)y13, p2);
		         c.drawText(mmevent5, (float)x14, (float)y14, p2);
		         c.drawText(ind, (float)x15, (float)y15, p2);
		         c.drawText(ind, (float)x16, (float)y16, p2);
		         c.drawText(ind, (float)x17, (float)y17, p2);
		         c.drawText(ind, (float)x18, (float)y18, p2);
		         c.drawText(ind, (float)x19, (float)y19, p2);
		         
		         /* Fade in-out Animation */
		         if (mIsCountingUp) {
		        //	 mAlpha+=10;
		        	 mAlpha+=50;
			         if (mAlpha > 255) {
			        	 mAlpha = 255;
			        	 mIsCountingUp=false;
			         }
		         } else {
		        	 mAlpha-=10;
		        	 if (mAlpha < 0) {
		        		 mAlpha = 0;
		        		 mIsCountingUp=true;
		        	 }
		         }
		         
		         /* Fade in-out Second Hand Animation */
		         if (mIsCountingUp2) {
		        //	 mAlpha+=10;
		        	 mAlpha2+=35;
			         if (mAlpha2 > 255) {
			        	 mAlpha2 = 255;
			        	 mIsCountingUp2=false;
			         }
		         } else {
		        	 mAlpha2-=35;
		        	 if (mAlpha2 < 0) {
		        		 mAlpha2 = 0;
		        		 mIsCountingUp2=true;
		        	 }
		         }
		         
		          
		      }
		   } finally {
		      if (c != null)
		         holder.unlockCanvasAndPost(c);
		   }
		   mHandler.removeCallbacks(mUpdateDisplay);
	       if (mVisible) {
	           mHandler.postDelayed(mUpdateDisplay, 100);
	       }
		}
		
		
		@Override
		public void onVisibilityChanged(boolean visible) {
			mVisible = visible;
		
			if (visible) {
				SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(WallpaperScreen.this);
				//mText = "Hello!!!"; 
				//prefs.getString("text_to_display", "This is the default.");
				String quote = prefs.getString("quotes", "Slow and steady wins the race.");
				
				String date = prefs.getString("date", "Sep 05");
				String time = prefs.getString("time", "12:00");
				String event = prefs.getString("text", "Gift Roses");
				String date2 = prefs.getString("date2", "Sep 05");
				String time2 = prefs.getString("time2", "12:00");
				String event2 = prefs.getString("text2", "Gift Roses");
				String date3 = prefs.getString("date3", "Sep 05");
				String time3 = prefs.getString("time3", "12:00");
				String event3 = prefs.getString("text3", "Gift Roses");
				String date4 = prefs.getString("date4", "Sep 05");
				String time4 = prefs.getString("time4", "12:00");
				String event4 = prefs.getString("text4", "Gift Roses");
				String date5 = prefs.getString("date5", "Sep 05");
				String time5 = prefs.getString("time5", "12:00");
				String event5 = prefs.getString("text5", "Gift Roses");
				
				mText = quote;
				mdate = date;
				mtime = time;
				mevent = event;
				mdate2 = date2;
				mtime2 = time2;
				mevent2 = event2;
				mdate3 = date3;
				mtime3 = time3;
				mevent3 = event3;
				mdate4 = date4;
				mtime4 = time4;
				mevent4 = event4;
				mdate5 = date5;
				mtime5 = time5;
				mevent5 = event5;
				
				String tmp = prefs.getString("listPref", "#ffffff");
				String r = tmp.substring(1,3);
				String g = tmp.substring(3,5);
				String b = tmp.substring(5,7);
				mColor = Color.rgb(Integer.parseInt(r, 16), Integer.parseInt(g, 16), Integer.parseInt(b, 16));
				
				String tmp2 = prefs.getString("listPref2", "#ffffff");
				String rr = tmp2.substring(1,3);
				String gg = tmp2.substring(3,5);
				String bb = tmp2.substring(5,7);
				bColor = Color.rgb(Integer.parseInt(rr, 16), Integer.parseInt(gg, 16), Integer.parseInt(bb, 16));
				
				
				draw();
			} else {
				mHandler.removeCallbacks(mUpdateDisplay);
			}
			
		}
		
		 @Override
	      public void onSurfaceChanged(SurfaceHolder holder, int format, int width, int height) {
	         draw();
	      }
		
		@Override
		public void onSurfaceDestroyed(SurfaceHolder holder) {
			super.onSurfaceDestroyed(holder);
			mVisible = false;
			mHandler.removeCallbacks(mUpdateDisplay);
		}
		
		@Override
	    public void onDestroy() {
	         super.onDestroy();
	         mVisible = false;
	         mHandler.removeCallbacks(mUpdateDisplay);
	    }
		
	}
	 
}



