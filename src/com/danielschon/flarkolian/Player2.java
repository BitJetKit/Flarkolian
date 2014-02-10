package com.danielschon.flarkolian;

import android.util.Log;

public class Player2 extends Sprite
{
	
	private float speed = 0f;
	private float acceleration = 2f;
	private float decceleration = 2f;
	private float topSpeed = 30f;
	
	static SubTexture st = new SubTexture(1,7,7);
	
	public Player2(int program, Vec2 position)
	{
		super(program, st, position);
		size = new Vec2(200, 200); 
		this.translate();
	}
	
	@Override
	public void update()
	{
		if (Game.pressState)
		{
			if (Game.press.getX() > Game.widthActual/8)
			{
				speed += acceleration;
			}
			else
			{
				speed -= acceleration;
			}
			if (speed > topSpeed)
				speed = topSpeed;
			if (speed < -topSpeed)
				speed = -topSpeed;
		}
		else
		{
			if (speed > 0)
			{
				if (speed > decceleration)
					speed -= decceleration;
				else
					speed = 0;
			}
			if (speed < 0)
			{
				if (speed < -decceleration)
					speed += decceleration;
				else
					speed = 0;
			}
		}
		
		loc.x += speed;
		
		if (loc.x < 0)
		{
			if (speed < 0)
				speed = 0;
			loc.x = 0;
		}
		if (loc.x > Game.widthWindow - size.x)
		{
			if (speed > 0)
				speed = 0;
			loc.x = Game.widthWindow - size.x;
		}
		
		super.update();
	}
}