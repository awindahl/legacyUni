/* mipslabwork.c

   This file written 2015 by F Lundevall

   This file should be changed by YOU! So add something here: Assignment solved by Alexander Windahl

   This file modified 2015-12-24 by Ture Teknolog 

   Latest update 2015-08-28 by F Lundevall

   For copyright and licensing, see file COPYING */

#include <stdint.h>   /* Declarations of uint_32 and the like */
#include <pic32mx.h>  /* Declarations of system-specific addresses etc */
#include "mipslab.h"  /* Declatations for these labs */

int mytime = 0x5957;
int ticks = 0;

char textstring[] = "text, more text, and even more text!";

/* Interrupt Service Routine */
void user_isr( void )
{
  return;
}

/* Lab-specific initialization goes here */
void labinit( void )
{
  volatile int* TRaddr = (volatile int*) 0xbf886100;
  int i = *TRaddr & ~0xff;  // sets bits 7-0 to outputs (0)
  //TRISD &= 0xfffffffa;      // sets bits 4-0 to 0 
  TRISD |= 0xfe0;           // sets bits 11-5 to inputs (1)
  //  TRISD |= (0xf<<5);

  return;

}

/* This function is called repetitively from the main program */
void labwork( void )
{
  delay( 1000 );

  int btn = getbtns();
  int sw = getsw();
  if (btn){
    if(btn ==0b001|| btn == 0b011|| btn == 0b101|| btn == 0b111){
        mytime = ((mytime & 0xff0f) | (sw<<4));
    }
    if(btn == 0b010 || btn ==0b011 || btn ==0b110 || btn ==0b111){
        mytime = ((mytime & 0xf0ff) | (sw<<8));
    }
    if(btn == 0b100|| btn ==0b110|| btn ==0b101||btn==0b111){
        mytime = ((mytime & 0x0fff) | (sw<<12));
    }
  }

  time2string( textstring, mytime );
  display_string( 3, textstring );
  display_update();
  while(1){
    tick( &mytime );
    ticks++;
    volatile int* LEDlight = (volatile int*) 0xbf886110;
    *LEDlight = ticks;
    break;
  }
  display_image(96, icon);
}
