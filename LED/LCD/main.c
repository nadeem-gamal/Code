#include <avr/io.h>
#include <util/delay.h>
#include <stdlib.h>

#define D0 eS_PORTD0
#define D1 eS_PORTD1
#define D2 eS_PORTD2
#define D3 eS_PORTD3
#define D4 eS_PORTD4
#define D5 eS_PORTD5
#define D6 eS_PORTD6
#define D7 eS_PORTD7
#define RS eS_PORTC6
#define EN eS_PORTC7

#include "lcd.h"

int main(void)
{
	DDRD = 0xFF;
	DDRC = 0xFF;
	Lcd8_Init();

	char positionString[4];
	while(1)
	{
		for(int y = 1; y <= 4; y++)
		{
			for(int x = 1; x <= 20; x++)
			{
				itoa(x, positionString, 10);
				Lcd8_Set_Cursor(12, 3);
				Lcd8_Write_String("X = ");
				Lcd8_Write_String(positionString);
				
				itoa(y, positionString, 10);
				Lcd8_Set_Cursor(12, 4);
				Lcd8_Write_String("Y = ");
				Lcd8_Write_String(positionString);
				
				Lcd8_Set_Cursor(x, y);
				Lcd8_Write_String("x");
				
				_delay_ms(50);
				
				Lcd8_Set_Cursor(x, y);
				Lcd8_Write_String(" ");				
				
				Lcd8_Set_Cursor(12, 3);
				Lcd8_Write_String("      ");
				
				Lcd8_Set_Cursor(12, 4);
				Lcd8_Write_String("      ");
				
			}
		}
	}
}

