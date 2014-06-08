package com.example.breakout;

import java.util.Random;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Item {
	protected Random rnd = new Random();
	protected int rand = rnd.nextInt(2); 
	protected int ix = 400;
	protected int iy = 0;
	protected boolean vanish = false;
	
	public void draw(Canvas c, Paint p) {
		p.setColor(Color.MAGENTA);
		if(vanish) p.setColor(Color.WHITE);
		c.drawRect(ix,iy, ix + 80, iy + 20, p);
		iy += 5;
	}
	public int getX(){return ix;};
	public int getY(){return iy;};
	public void vanishch(){
		vanish = true;
	}
}
