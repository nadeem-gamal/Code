#include <avr/io.h>
#include <util/delay.h>
#include <stdlib.h>

#define MrLCDsCrib 				PORTB
#define DataDir_MrLCDsCrib 		DDRB
#define MrLCDsControl 			PORTD
#define DataDir_MrLCDsControl 	DDRD
#define LightSwitch 			PIND5
#define ReadWrite 				PIND7
#define BiPolarMood 			PIND2

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

char firstAddressForLCD[4] = {0, 64, 20, 84};

void Check_IF_MrLCD_isBusy(void);
void Peek_A_Boo(void);
void Send_A_Command(unsigned char command);
void Send_A_Character(unsigned char character);

int main(void)
{
//	DataDir_MrLCDsControl |= 1<<LightSwitch | 1<<ReadWrite | 1<<BiPolarMood;
//	_delay_ms(15);
	
	
	
//	Send_A_Command(0x01);
//	_delay_ms(2);
	
//	Send_A_Command(0x38);
//	_delay_us(50);
	
//	Send_A_Command(0b00001110);
//	_delay_us(50);
	
	
//	Send_A_Character(0x41);

	DDRD = 0xFF;
	DDRC = 0xFF;
	int i;
	Lcd8_Init();


	//Lcd8_Write_Char(0x4E);
	//Lcd8_Write_Char(0x65);
	char positionString[4];
	while(1)
	{
		for(int y = 1; y <= 4; y++)
		{
			for(int x = 1; x <= 20; x++)
			{
				itoa(x, positionString, 10);
				LCD_SET_CURSOR(12, 3);
				Lcd8_Write_String("X = ");
				Lcd8_Write_String(positionString);
				
				itoa(y, positionString, 10);
				LCD_SET_CURSOR(12, 4);
				Lcd8_Write_String("Y = ");
				Lcd8_Write_String(positionString);
				
				LCD_SET_CURSOR(x, y);
				Lcd8_Write_String("x");
				
				_delay_ms(50);
				
				LCD_SET_CURSOR(x, y);
				Lcd8_Write_String(" ");
				
				
				
				LCD_SET_CURSOR(12, 3);
				Lcd8_Write_String("      ");
				
				LCD_SET_CURSOR(12, 4);
				Lcd8_Write_String("      ");
				
			}
		}
//		for(int x = 0; x < 128; x++)
//		{
//			Lcd8_Cmd(0x80 + x);
//			Lcd8_Set_Cursor();
//			Lcd8_Write_String("x");
//			itoa(x, positionString, 10);
//			Lcd8_Set_Cursor(2, 13);
//			Lcd8_Write_String(positionString);
//			_delay_ms(50);
	//		Lcd8_Set_Cursor();
//			Lcd8_Cmd(0x80 + x);
//			Lcd8_Write_String(" ");
			
//		}
	}
}

void LCD_SET_CURSOR(uint8_t x, uint8_t y)
{
	Lcd8_Cmd(0x80 + firstAddressForLCD[y-1] + (x-1));
}

void whileLoopElectroSome()
{
	int i;
	Lcd8_Set_Cursor(1,1);
	Lcd8_Write_String("electroSome LCD Hello World");
	for(i=0;i<15;i++)
	{
		_delay_ms(50);
		Lcd8_Shift_Left();
	}
	for(i=0;i<15;i++)
	{
		_delay_ms(50);
		Lcd8_Shift_Right();
	}
	Lcd8_Clear();
	Lcd8_Write_Char('e');
	Lcd8_Write_Char('S');
	_delay_ms(200);
}
void Check_IF_MrLCD_isBusy()
{
	DataDir_MrLCDsCrib = 0;
	MrLCDsControl |= 1<<ReadWrite;
	MrLCDsControl &= ~ 1<<BiPolarMood;
	
	while(MrLCDsCrib >= 0x80)
	{
		Peek_A_Boo();
	}
	
	
	DataDir_MrLCDsCrib = 0xFF;
}

void Peek_A_Boo()
{
	DataDir_MrLCDsControl |= 1<< LightSwitch;
	asm volatile ("nop");
	asm volatile ("nop");
	MrLCDsControl &= ~ 1<<LightSwitch;
}

void Send_A_Command(unsigned char command)
{
	Check_IF_MrLCD_isBusy();
	MrLCDsCrib = command;
	MrLCDsControl &= ~ (1<<ReadWrite|1<<BiPolarMood);
	Peek_A_Boo();
	MrLCDsCrib = 0;
}

void Send_A_Character(unsigned char character)
{
	Check_IF_MrLCD_isBusy();
	MrLCDsCrib = character;
	MrLCDsControl &= ~ (1<<ReadWrite);
	MrLCDsControl |= 1<<BiPolarMood;
	Peek_A_Boo();
	MrLCDsCrib = 0;

}
